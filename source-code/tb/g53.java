package tb;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.loc.eo;
import com.loc.i1;
import com.loc.m1;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
public final class g53 {
    eo a = null;
    long b = 0;
    long c = 0;
    private boolean d = true;
    int e = 0;
    long f = 0;
    AMapLocation g = null;
    long h = 0;

    private eo e(eo eoVar) {
        int i;
        if (m1.r(eoVar)) {
            if (!this.d || !i1.f(eoVar.getTime())) {
                i = this.e;
            } else if (eoVar.getLocationType() == 5 || eoVar.getLocationType() == 6) {
                i = 4;
            }
            eoVar.setLocationType(i);
        }
        return eoVar;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (!m1.q(aMapLocation)) {
            return aMapLocation;
        }
        long B = m1.B() - this.h;
        this.h = m1.B();
        if (B > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
            return aMapLocation;
        }
        AMapLocation aMapLocation2 = this.g;
        if (aMapLocation2 == null) {
            this.g = aMapLocation;
            return aMapLocation;
        } else if (1 != aMapLocation2.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.g.getProvider())) {
            this.g = aMapLocation;
            return aMapLocation;
        } else if (this.g.getAltitude() == aMapLocation.getAltitude() && this.g.getLongitude() == aMapLocation.getLongitude()) {
            this.g = aMapLocation;
            return aMapLocation;
        } else {
            long abs = Math.abs(aMapLocation.getTime() - this.g.getTime());
            if (30000 < abs) {
                this.g = aMapLocation;
                return aMapLocation;
            } else if (m1.c(aMapLocation, this.g) > (((this.g.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.g.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                return this.g;
            } else {
                this.g = aMapLocation;
                return aMapLocation;
            }
        }
    }

    public final eo b(eo eoVar) {
        if (m1.B() - this.f > 30000) {
            this.a = eoVar;
            this.f = m1.B();
            return this.a;
        }
        this.f = m1.B();
        if (!m1.r(this.a) || !m1.r(eoVar)) {
            this.b = m1.B();
            this.a = eoVar;
            return eoVar;
        } else if (eoVar.getTime() == this.a.getTime() && eoVar.getAccuracy() < 300.0f) {
            return eoVar;
        } else {
            if (GeocodeSearch.GPS.equals(eoVar.getProvider())) {
                this.b = m1.B();
                this.a = eoVar;
                return eoVar;
            } else if (eoVar.c() != this.a.c()) {
                this.b = m1.B();
                this.a = eoVar;
                return eoVar;
            } else if (eoVar.getBuildingId() == null || eoVar.getBuildingId().equals(this.a.getBuildingId()) || TextUtils.isEmpty(eoVar.getBuildingId())) {
                this.e = eoVar.getLocationType();
                float c2 = m1.c(eoVar, this.a);
                float accuracy = this.a.getAccuracy();
                float accuracy2 = eoVar.getAccuracy();
                float f2 = accuracy2 - accuracy;
                long B = m1.B();
                long j = B - this.b;
                boolean z = true;
                boolean z2 = accuracy <= 100.0f && accuracy2 > 299.0f;
                int i = (accuracy > 299.0f ? 1 : (accuracy == 299.0f ? 0 : -1));
                if (i <= 0 || accuracy2 <= 299.0f) {
                    z = false;
                }
                if (z2 || z) {
                    long j2 = this.c;
                    if (j2 == 0) {
                        this.c = B;
                    } else if (B - j2 > 30000) {
                        this.b = B;
                        this.a = eoVar;
                        this.c = 0;
                        return eoVar;
                    }
                    eo e2 = e(this.a);
                    this.a = e2;
                    return e2;
                } else if (accuracy2 >= 100.0f || i <= 0) {
                    if (accuracy2 <= 299.0f) {
                        this.c = 0;
                    }
                    if (c2 >= 10.0f || ((double) c2) <= 0.1d || accuracy2 <= 5.0f) {
                        if (f2 < 300.0f) {
                            this.b = m1.B();
                            this.a = eoVar;
                            return eoVar;
                        } else if (j >= 30000) {
                            this.b = m1.B();
                            this.a = eoVar;
                            return eoVar;
                        } else {
                            eo e3 = e(this.a);
                            this.a = e3;
                            return e3;
                        }
                    } else if (f2 >= -300.0f) {
                        eo e4 = e(this.a);
                        this.a = e4;
                        return e4;
                    } else if (accuracy / accuracy2 >= 2.0f) {
                        this.b = B;
                        this.a = eoVar;
                        return eoVar;
                    } else {
                        eo e5 = e(this.a);
                        this.a = e5;
                        return e5;
                    }
                } else {
                    this.b = B;
                    this.a = eoVar;
                    this.c = 0;
                    return eoVar;
                }
            } else {
                this.b = m1.B();
                this.a = eoVar;
                return eoVar;
            }
        }
    }

    public final void c() {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.g = null;
        this.h = 0;
    }

    public final void d(boolean z) {
        this.d = z;
    }
}
