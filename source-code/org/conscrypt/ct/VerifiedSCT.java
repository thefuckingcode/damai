package org.conscrypt.ct;

public final class VerifiedSCT {
    public final SignedCertificateTimestamp sct;
    public final Status status;

    public enum Status {
        VALID,
        INVALID_SIGNATURE,
        UNKNOWN_LOG,
        INVALID_SCT
    }

    public VerifiedSCT(SignedCertificateTimestamp signedCertificateTimestamp, Status status2) {
        this.sct = signedCertificateTimestamp;
        this.status = status2;
    }
}
