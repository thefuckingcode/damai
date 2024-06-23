package org.conscrypt.ct;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SignedCertificateTimestamp {
    private final byte[] extensions;
    private final byte[] logId;
    private final Origin origin;
    private final DigitallySigned signature;
    private final long timestamp;
    private final Version version;

    public enum Origin {
        EMBEDDED,
        TLS_EXTENSION,
        OCSP_RESPONSE
    }

    public enum SignatureType {
        CERTIFICATE_TIMESTAMP,
        TREE_HASH
    }

    public enum Version {
        V1
    }

    public SignedCertificateTimestamp(Version version2, byte[] bArr, long j, byte[] bArr2, DigitallySigned digitallySigned, Origin origin2) {
        this.version = version2;
        this.logId = bArr;
        this.timestamp = j;
        this.extensions = bArr2;
        this.signature = digitallySigned;
        this.origin = origin2;
    }

    public Version getVersion() {
        return this.version;
    }

    public byte[] getLogID() {
        return this.logId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public byte[] getExtensions() {
        return this.extensions;
    }

    public DigitallySigned getSignature() {
        return this.signature;
    }

    public Origin getOrigin() {
        return this.origin;
    }

    public static SignedCertificateTimestamp decode(InputStream inputStream, Origin origin2) throws SerializationException {
        int readNumber = Serialization.readNumber(inputStream, 1);
        if (readNumber == Version.V1.ordinal()) {
            return new SignedCertificateTimestamp(Version.V1, Serialization.readFixedBytes(inputStream, 32), Serialization.readLong(inputStream, 8), Serialization.readVariableBytes(inputStream, 2), DigitallySigned.decode(inputStream), origin2);
        }
        throw new SerializationException("Unsupported SCT version " + readNumber);
    }

    public static SignedCertificateTimestamp decode(byte[] bArr, Origin origin2) throws SerializationException {
        return decode(new ByteArrayInputStream(bArr), origin2);
    }

    public void encodeTBS(OutputStream outputStream, CertificateEntry certificateEntry) throws SerializationException {
        Serialization.writeNumber(outputStream, (long) this.version.ordinal(), 1);
        Serialization.writeNumber(outputStream, (long) SignatureType.CERTIFICATE_TIMESTAMP.ordinal(), 1);
        Serialization.writeNumber(outputStream, this.timestamp, 8);
        certificateEntry.encode(outputStream);
        Serialization.writeVariableBytes(outputStream, this.extensions, 2);
    }

    public byte[] encodeTBS(CertificateEntry certificateEntry) throws SerializationException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encodeTBS(byteArrayOutputStream, certificateEntry);
        return byteArrayOutputStream.toByteArray();
    }
}
