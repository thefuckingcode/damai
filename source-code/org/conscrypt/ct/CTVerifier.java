package org.conscrypt.ct;

import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.conscrypt.NativeCrypto;
import org.conscrypt.OpenSSLX509Certificate;
import org.conscrypt.ct.SignedCertificateTimestamp;
import org.conscrypt.ct.VerifiedSCT;

public class CTVerifier {
    private final CTLogStore store;

    public CTVerifier(CTLogStore cTLogStore) {
        this.store = cTLogStore;
    }

    public CTVerificationResult verifySignedCertificateTimestamps(List<X509Certificate> list, byte[] bArr, byte[] bArr2) throws CertificateEncodingException {
        OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[list.size()];
        int i = 0;
        for (X509Certificate x509Certificate : list) {
            openSSLX509CertificateArr[i] = OpenSSLX509Certificate.fromCertificate(x509Certificate);
            i++;
        }
        return verifySignedCertificateTimestamps(openSSLX509CertificateArr, bArr, bArr2);
    }

    public CTVerificationResult verifySignedCertificateTimestamps(OpenSSLX509Certificate[] openSSLX509CertificateArr, byte[] bArr, byte[] bArr2) throws CertificateEncodingException {
        if (openSSLX509CertificateArr.length != 0) {
            OpenSSLX509Certificate openSSLX509Certificate = openSSLX509CertificateArr[0];
            CTVerificationResult cTVerificationResult = new CTVerificationResult();
            verifyExternalSCTs(getSCTsFromTLSExtension(bArr), openSSLX509Certificate, cTVerificationResult);
            verifyExternalSCTs(getSCTsFromOCSPResponse(bArr2, openSSLX509CertificateArr), openSSLX509Certificate, cTVerificationResult);
            verifyEmbeddedSCTs(getSCTsFromX509Extension(openSSLX509CertificateArr[0]), openSSLX509CertificateArr, cTVerificationResult);
            return cTVerificationResult;
        }
        throw new IllegalArgumentException("Chain of certificates mustn't be empty.");
    }

    private void verifyEmbeddedSCTs(List<SignedCertificateTimestamp> list, OpenSSLX509Certificate[] openSSLX509CertificateArr, CTVerificationResult cTVerificationResult) {
        if (!list.isEmpty()) {
            CertificateEntry certificateEntry = null;
            if (openSSLX509CertificateArr.length >= 2) {
                try {
                    certificateEntry = CertificateEntry.createForPrecertificate(openSSLX509CertificateArr[0], openSSLX509CertificateArr[1]);
                } catch (CertificateException unused) {
                }
            }
            if (certificateEntry == null) {
                markSCTsAsInvalid(list, cTVerificationResult);
                return;
            }
            for (SignedCertificateTimestamp signedCertificateTimestamp : list) {
                cTVerificationResult.add(new VerifiedSCT(signedCertificateTimestamp, verifySingleSCT(signedCertificateTimestamp, certificateEntry)));
            }
        }
    }

    private void verifyExternalSCTs(List<SignedCertificateTimestamp> list, OpenSSLX509Certificate openSSLX509Certificate, CTVerificationResult cTVerificationResult) {
        if (!list.isEmpty()) {
            try {
                CertificateEntry createForX509Certificate = CertificateEntry.createForX509Certificate(openSSLX509Certificate);
                for (SignedCertificateTimestamp signedCertificateTimestamp : list) {
                    cTVerificationResult.add(new VerifiedSCT(signedCertificateTimestamp, verifySingleSCT(signedCertificateTimestamp, createForX509Certificate)));
                }
            } catch (CertificateException unused) {
                markSCTsAsInvalid(list, cTVerificationResult);
            }
        }
    }

    private VerifiedSCT.Status verifySingleSCT(SignedCertificateTimestamp signedCertificateTimestamp, CertificateEntry certificateEntry) {
        CTLogInfo knownLog = this.store.getKnownLog(signedCertificateTimestamp.getLogID());
        if (knownLog == null) {
            return VerifiedSCT.Status.UNKNOWN_LOG;
        }
        return knownLog.verifySingleSCT(signedCertificateTimestamp, certificateEntry);
    }

    private void markSCTsAsInvalid(List<SignedCertificateTimestamp> list, CTVerificationResult cTVerificationResult) {
        for (SignedCertificateTimestamp signedCertificateTimestamp : list) {
            cTVerificationResult.add(new VerifiedSCT(signedCertificateTimestamp, VerifiedSCT.Status.INVALID_SCT));
        }
    }

    private List<SignedCertificateTimestamp> getSCTsFromSCTList(byte[] bArr, SignedCertificateTimestamp.Origin origin) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        try {
            byte[][] readList = Serialization.readList(bArr, 2, 2);
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr2 : readList) {
                try {
                    arrayList.add(SignedCertificateTimestamp.decode(bArr2, origin));
                } catch (SerializationException unused) {
                }
            }
            return arrayList;
        } catch (SerializationException unused2) {
            return Collections.emptyList();
        }
    }

    private List<SignedCertificateTimestamp> getSCTsFromTLSExtension(byte[] bArr) {
        return getSCTsFromSCTList(bArr, SignedCertificateTimestamp.Origin.TLS_EXTENSION);
    }

    private List<SignedCertificateTimestamp> getSCTsFromOCSPResponse(byte[] bArr, OpenSSLX509Certificate[] openSSLX509CertificateArr) {
        if (bArr == null || openSSLX509CertificateArr.length < 2) {
            return Collections.emptyList();
        }
        byte[] bArr2 = NativeCrypto.get_ocsp_single_extension(bArr, CTConstants.OCSP_SCT_LIST_OID, openSSLX509CertificateArr[0].getContext(), openSSLX509CertificateArr[0], openSSLX509CertificateArr[1].getContext(), openSSLX509CertificateArr[1]);
        if (bArr2 == null) {
            return Collections.emptyList();
        }
        try {
            return getSCTsFromSCTList(Serialization.readDEROctetString(Serialization.readDEROctetString(bArr2)), SignedCertificateTimestamp.Origin.OCSP_RESPONSE);
        } catch (SerializationException unused) {
            return Collections.emptyList();
        }
    }

    private List<SignedCertificateTimestamp> getSCTsFromX509Extension(OpenSSLX509Certificate openSSLX509Certificate) {
        byte[] extensionValue = openSSLX509Certificate.getExtensionValue(CTConstants.X509_SCT_LIST_OID);
        if (extensionValue == null) {
            return Collections.emptyList();
        }
        try {
            return getSCTsFromSCTList(Serialization.readDEROctetString(Serialization.readDEROctetString(extensionValue)), SignedCertificateTimestamp.Origin.EMBEDDED);
        } catch (SerializationException unused) {
            return Collections.emptyList();
        }
    }
}
