package org.conscrypt;

import java.math.BigInteger;
import java.security.spec.ECPoint;
import org.conscrypt.NativeRef;

/* access modifiers changed from: package-private */
public final class OpenSSLECPointContext {
    private final OpenSSLECGroupContext group;
    private final NativeRef.EC_POINT pointCtx;

    OpenSSLECPointContext(OpenSSLECGroupContext openSSLECGroupContext, NativeRef.EC_POINT ec_point) {
        this.group = openSSLECGroupContext;
        this.pointCtx = ec_point;
    }

    public boolean equals(Object obj) {
        throw new IllegalArgumentException("OpenSSLECPointContext.equals is not defined.");
    }

    /* access modifiers changed from: package-private */
    public ECPoint getECPoint() {
        byte[][] EC_POINT_get_affine_coordinates = NativeCrypto.EC_POINT_get_affine_coordinates(this.group.getNativeRef(), this.pointCtx);
        return new ECPoint(new BigInteger(EC_POINT_get_affine_coordinates[0]), new BigInteger(EC_POINT_get_affine_coordinates[1]));
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public NativeRef.EC_POINT getNativeRef() {
        return this.pointCtx;
    }

    static OpenSSLECPointContext getInstance(OpenSSLECGroupContext openSSLECGroupContext, ECPoint eCPoint) {
        OpenSSLECPointContext openSSLECPointContext = new OpenSSLECPointContext(openSSLECGroupContext, new NativeRef.EC_POINT(NativeCrypto.EC_POINT_new(openSSLECGroupContext.getNativeRef())));
        NativeCrypto.EC_POINT_set_affine_coordinates(openSSLECGroupContext.getNativeRef(), openSSLECPointContext.getNativeRef(), eCPoint.getAffineX().toByteArray(), eCPoint.getAffineY().toByteArray());
        return openSSLECPointContext;
    }
}
