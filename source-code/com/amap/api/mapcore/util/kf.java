package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;

/* compiled from: Taobao */
public final class kf {
    private static kf b;
    long a = 0;
    private kj c = null;
    private long d = 0;
    private long e = 0;

    private kf() {
    }

    public static synchronized kf a() {
        kf kfVar;
        synchronized (kf.class) {
            if (b == null) {
                b = new kf();
            }
            kfVar = b;
        }
        return kfVar;
    }

    public final kj a(kj kjVar) {
        int i;
        if (kc.b() - this.a > 30000) {
            this.c = kjVar;
            this.a = kc.b();
            return this.c;
        }
        this.a = kc.b();
        if (!kn.a(this.c) || !kn.a(kjVar)) {
            this.d = kc.b();
            this.c = kjVar;
            return kjVar;
        } else if (kjVar.getTime() == this.c.getTime() && kjVar.getAccuracy() < 300.0f) {
            return kjVar;
        } else {
            if (kjVar.getProvider().equalsIgnoreCase(GeocodeSearch.GPS)) {
                this.d = kc.b();
                this.c = kjVar;
                return kjVar;
            } else if (kjVar.c() != this.c.c()) {
                this.d = kc.b();
                this.c = kjVar;
                return kjVar;
            } else if (kjVar.getBuildingId().equals(this.c.getBuildingId()) || TextUtils.isEmpty(kjVar.getBuildingId())) {
                float a2 = kc.a(new double[]{kjVar.getLatitude(), kjVar.getLongitude(), this.c.getLatitude(), this.c.getLongitude()});
                float accuracy = this.c.getAccuracy();
                float accuracy2 = kjVar.getAccuracy();
                float f = accuracy2 - accuracy;
                long b2 = kc.b();
                long j = b2 - this.d;
                if ((accuracy < 101.0f && accuracy2 > 299.0f) || (accuracy > 299.0f && accuracy2 > 299.0f)) {
                    long j2 = this.e;
                    if (j2 == 0) {
                        this.e = b2;
                    } else if (b2 - j2 > 30000) {
                        this.d = b2;
                        this.c = kjVar;
                        this.e = 0;
                        return kjVar;
                    }
                    return this.c;
                } else if (accuracy2 >= 101.0f || i <= 0) {
                    if (accuracy2 <= 299.0f) {
                        this.e = 0;
                    }
                    if (a2 >= 10.0f || ((double) a2) <= 0.1d || accuracy2 <= 5.0f) {
                        if (f < 300.0f) {
                            this.d = kc.b();
                            this.c = kjVar;
                            return kjVar;
                        } else if (j < 30000) {
                            return this.c;
                        } else {
                            this.d = kc.b();
                            this.c = kjVar;
                            return kjVar;
                        }
                    } else if (f >= -300.0f) {
                        return this.c;
                    } else {
                        if (accuracy / accuracy2 < 2.0f) {
                            return this.c;
                        }
                        this.d = b2;
                        this.c = kjVar;
                        return kjVar;
                    }
                } else {
                    this.d = b2;
                    this.c = kjVar;
                    this.e = 0;
                    return kjVar;
                }
            } else {
                this.d = kc.b();
                this.c = kjVar;
                return kjVar;
            }
        }
    }
}
