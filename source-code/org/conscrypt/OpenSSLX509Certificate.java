package org.conscrypt;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import javax.crypto.BadPaddingException;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.OpenSSLX509CertificateFactory;

public final class OpenSSLX509Certificate extends X509Certificate {
    private static final long serialVersionUID = 1992239142393372128L;
    private final transient long mContext;
    private transient Integer mHashCode;
    private final Date notAfter;
    private final Date notBefore;

    OpenSSLX509Certificate(long j) throws OpenSSLX509CertificateFactory.ParsingException {
        this.mContext = j;
        this.notBefore = toDate(NativeCrypto.X509_get_notBefore(j, this));
        this.notAfter = toDate(NativeCrypto.X509_get_notAfter(j, this));
    }

    private OpenSSLX509Certificate(long j, Date date, Date date2) {
        this.mContext = j;
        this.notBefore = date;
        this.notAfter = date2;
    }

    private static Date toDate(long j) throws OpenSSLX509CertificateFactory.ParsingException {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.set(14, 0);
        NativeCrypto.ASN1_TIME_to_Calendar(j, instance);
        return instance.getTime();
    }

    public static OpenSSLX509Certificate fromX509DerInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            long d2i_X509_bio = NativeCrypto.d2i_X509_bio(openSSLBIOInputStream.getBioContext());
            if (d2i_X509_bio == 0) {
                openSSLBIOInputStream.release();
                return null;
            }
            OpenSSLX509Certificate openSSLX509Certificate = new OpenSSLX509Certificate(d2i_X509_bio);
            openSSLBIOInputStream.release();
            return openSSLX509Certificate;
        } catch (Exception e) {
            throw new OpenSSLX509CertificateFactory.ParsingException(e);
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static OpenSSLX509Certificate fromX509Der(byte[] bArr) throws CertificateEncodingException {
        try {
            return new OpenSSLX509Certificate(NativeCrypto.d2i_X509(bArr));
        } catch (OpenSSLX509CertificateFactory.ParsingException e) {
            throw new CertificateEncodingException(e);
        }
    }

    public static List<OpenSSLX509Certificate> fromPkcs7DerInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            long[] d2i_PKCS7_bio = NativeCrypto.d2i_PKCS7_bio(openSSLBIOInputStream.getBioContext(), 1);
            openSSLBIOInputStream.release();
            if (d2i_PKCS7_bio == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(d2i_PKCS7_bio.length);
            for (int i = 0; i < d2i_PKCS7_bio.length; i++) {
                if (d2i_PKCS7_bio[i] != 0) {
                    arrayList.add(new OpenSSLX509Certificate(d2i_PKCS7_bio[i]));
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new OpenSSLX509CertificateFactory.ParsingException(e);
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static OpenSSLX509Certificate fromX509PemInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            long PEM_read_bio_X509 = NativeCrypto.PEM_read_bio_X509(openSSLBIOInputStream.getBioContext());
            if (PEM_read_bio_X509 == 0) {
                openSSLBIOInputStream.release();
                return null;
            }
            OpenSSLX509Certificate openSSLX509Certificate = new OpenSSLX509Certificate(PEM_read_bio_X509);
            openSSLBIOInputStream.release();
            return openSSLX509Certificate;
        } catch (Exception e) {
            throw new OpenSSLX509CertificateFactory.ParsingException(e);
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static List<OpenSSLX509Certificate> fromPkcs7PemInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            long[] PEM_read_bio_PKCS7 = NativeCrypto.PEM_read_bio_PKCS7(openSSLBIOInputStream.getBioContext(), 1);
            openSSLBIOInputStream.release();
            ArrayList arrayList = new ArrayList(PEM_read_bio_PKCS7.length);
            for (int i = 0; i < PEM_read_bio_PKCS7.length; i++) {
                if (PEM_read_bio_PKCS7[i] != 0) {
                    arrayList.add(new OpenSSLX509Certificate(PEM_read_bio_PKCS7[i]));
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new OpenSSLX509CertificateFactory.ParsingException(e);
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static OpenSSLX509Certificate fromCertificate(Certificate certificate) throws CertificateEncodingException {
        if (certificate instanceof OpenSSLX509Certificate) {
            return (OpenSSLX509Certificate) certificate;
        }
        if (certificate instanceof X509Certificate) {
            return fromX509Der(certificate.getEncoded());
        }
        throw new CertificateEncodingException("Only X.509 certificates are supported");
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        String[] strArr = NativeCrypto.get_X509_ext_oids(this.mContext, this, 1);
        if (strArr.length == 0 && NativeCrypto.get_X509_ext_oids(this.mContext, this, 0).length == 0) {
            return null;
        }
        return new HashSet(Arrays.asList(strArr));
    }

    public byte[] getExtensionValue(String str) {
        return NativeCrypto.X509_get_ext_oid(this.mContext, this, str);
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        String[] strArr = NativeCrypto.get_X509_ext_oids(this.mContext, this, 0);
        if (strArr.length == 0 && NativeCrypto.get_X509_ext_oids(this.mContext, this, 1).length == 0) {
            return null;
        }
        return new HashSet(Arrays.asList(strArr));
    }

    public boolean hasUnsupportedCriticalExtension() {
        return (NativeCrypto.get_X509_ex_flags(this.mContext, this) & 512) != 0;
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (getNotBefore().compareTo(date) > 0) {
            throw new CertificateNotYetValidException("Certificate not valid until " + getNotBefore().toString() + " (compared to " + date.toString() + ")");
        } else if (getNotAfter().compareTo(date) < 0) {
            throw new CertificateExpiredException("Certificate expired at " + getNotAfter().toString() + " (compared to " + date.toString() + ")");
        }
    }

    public int getVersion() {
        return ((int) NativeCrypto.X509_get_version(this.mContext, this)) + 1;
    }

    public BigInteger getSerialNumber() {
        return new BigInteger(NativeCrypto.X509_get_serialNumber(this.mContext, this));
    }

    public Principal getIssuerDN() {
        return getIssuerX500Principal();
    }

    public Principal getSubjectDN() {
        return getSubjectX500Principal();
    }

    public Date getNotBefore() {
        return (Date) this.notBefore.clone();
    }

    public Date getNotAfter() {
        return (Date) this.notAfter.clone();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        return NativeCrypto.get_X509_cert_info_enc(this.mContext, this);
    }

    public byte[] getSignature() {
        return NativeCrypto.get_X509_signature(this.mContext, this);
    }

    public String getSigAlgName() {
        String sigAlgOID = getSigAlgOID();
        String oidToAlgorithmName = OidData.oidToAlgorithmName(sigAlgOID);
        if (oidToAlgorithmName != null) {
            return oidToAlgorithmName;
        }
        String oidToAlgorithmName2 = Platform.oidToAlgorithmName(sigAlgOID);
        return oidToAlgorithmName2 != null ? oidToAlgorithmName2 : sigAlgOID;
    }

    public String getSigAlgOID() {
        return NativeCrypto.get_X509_sig_alg_oid(this.mContext, this);
    }

    public byte[] getSigAlgParams() {
        return NativeCrypto.get_X509_sig_alg_parameter(this.mContext, this);
    }

    public boolean[] getIssuerUniqueID() {
        return NativeCrypto.get_X509_issuerUID(this.mContext, this);
    }

    public boolean[] getSubjectUniqueID() {
        return NativeCrypto.get_X509_subjectUID(this.mContext, this);
    }

    public boolean[] getKeyUsage() {
        boolean[] zArr = NativeCrypto.get_X509_ex_kusage(this.mContext, this);
        if (zArr == null) {
            return null;
        }
        if (zArr.length >= 9) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[9];
        System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
        return zArr2;
    }

    public int getBasicConstraints() {
        if ((NativeCrypto.get_X509_ex_flags(this.mContext, this) & 16) == 0) {
            return -1;
        }
        int i = NativeCrypto.get_X509_ex_pathlen(this.mContext, this);
        if (i == -1) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return NativeCrypto.i2d_X509(this.mContext, this);
    }

    private void verifyOpenSSL(OpenSSLKey openSSLKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        try {
            NativeCrypto.X509_verify(this.mContext, this, openSSLKey.getNativeRef());
        } catch (RuntimeException e) {
            throw new CertificateException(e);
        } catch (BadPaddingException unused) {
            throw new SignatureException();
        }
    }

    private void verifyInternal(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        if (str == null) {
            signature = Signature.getInstance(getSigAlgName());
        } else {
            signature = Signature.getInstance(getSigAlgName(), str);
        }
        signature.initVerify(publicKey);
        signature.update(getTBSCertificate());
        if (!signature.verify(getSignature())) {
            throw new SignatureException("signature did not verify");
        }
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (publicKey instanceof OpenSSLKeyHolder) {
            verifyOpenSSL(((OpenSSLKeyHolder) publicKey).getOpenSSLKey());
        } else {
            verifyInternal(publicKey, null);
        }
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        verifyInternal(publicKey, str);
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public void verify(PublicKey publicKey, Provider provider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature;
        if (!(publicKey instanceof OpenSSLKeyHolder) || !(provider instanceof OpenSSLProvider)) {
            if (provider == null) {
                signature = Signature.getInstance(getSigAlgName());
            } else {
                signature = Signature.getInstance(getSigAlgName(), provider);
            }
            signature.initVerify(publicKey);
            signature.update(getTBSCertificate());
            if (!signature.verify(getSignature())) {
                throw new SignatureException("signature did not verify");
            }
            return;
        }
        verifyOpenSSL(((OpenSSLKeyHolder) publicKey).getOpenSSLKey());
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long create_BIO_OutputStream = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        try {
            NativeCrypto.X509_print_ex(create_BIO_OutputStream, this.mContext, this, 0, 0);
            return byteArrayOutputStream.toString();
        } finally {
            NativeCrypto.BIO_free_all(create_BIO_OutputStream);
        }
    }

    public PublicKey getPublicKey() {
        try {
            return new OpenSSLKey(NativeCrypto.X509_get_pubkey(this.mContext, this)).getPublicKey();
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            String str = NativeCrypto.get_X509_pubkey_oid(this.mContext, this);
            byte[] i2d_X509_PUBKEY = NativeCrypto.i2d_X509_PUBKEY(this.mContext, this);
            try {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(i2d_X509_PUBKEY));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException unused2) {
                return new X509PublicKey(str, i2d_X509_PUBKEY);
            }
        }
    }

    public X500Principal getIssuerX500Principal() {
        return new X500Principal(NativeCrypto.X509_get_issuer_name(this.mContext, this));
    }

    public X500Principal getSubjectX500Principal() {
        return new X500Principal(NativeCrypto.X509_get_subject_name(this.mContext, this));
    }

    @Override // java.security.cert.X509Certificate
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        String[] strArr = NativeCrypto.get_X509_ex_xkusage(this.mContext, this);
        if (strArr == null) {
            return null;
        }
        return Arrays.asList(strArr);
    }

    private static Collection<List<?>> alternativeNameArrayToList(Object[][] objArr) {
        if (objArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object[] objArr2 : objArr) {
            arrayList.add(Collections.unmodifiableList(Arrays.asList(objArr2)));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    @Override // java.security.cert.X509Certificate
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        return alternativeNameArrayToList(NativeCrypto.get_X509_GENERAL_NAME_stack(this.mContext, this, 1));
    }

    @Override // java.security.cert.X509Certificate
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        return alternativeNameArrayToList(NativeCrypto.get_X509_GENERAL_NAME_stack(this.mContext, this, 2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OpenSSLX509Certificate)) {
            return super.equals(obj);
        }
        OpenSSLX509Certificate openSSLX509Certificate = (OpenSSLX509Certificate) obj;
        return NativeCrypto.X509_cmp(this.mContext, this, openSSLX509Certificate.mContext, openSSLX509Certificate) == 0;
    }

    public int hashCode() {
        Integer num = this.mHashCode;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(super.hashCode());
        this.mHashCode = valueOf;
        return valueOf.intValue();
    }

    public long getContext() {
        return this.mContext;
    }

    public OpenSSLX509Certificate withDeletedExtension(String str) {
        OpenSSLX509Certificate openSSLX509Certificate = new OpenSSLX509Certificate(NativeCrypto.X509_dup(this.mContext, this), this.notBefore, this.notAfter);
        NativeCrypto.X509_delete_ext(openSSLX509Certificate.getContext(), openSSLX509Certificate, str);
        return openSSLX509Certificate;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            long j = this.mContext;
            if (j != 0) {
                NativeCrypto.X509_free(j, this);
            }
        } finally {
            super.finalize();
        }
    }
}
