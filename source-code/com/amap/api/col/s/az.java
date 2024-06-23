package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* compiled from: Taobao */
public final class az implements IDistrictSearch {
    private static HashMap<Integer, DistrictResult> f;
    private Context a;
    private DistrictSearchQuery b;
    private DistrictSearch.OnDistrictSearchListener c;
    private DistrictSearchQuery d;
    private int e;
    private Handler g;

    public az(Context context) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.g = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        DistrictResult districtResult;
        try {
            DistrictResult districtResult2 = new DistrictResult();
            r.a(this.a);
            if (!a()) {
                this.b = new DistrictSearchQuery();
            }
            districtResult2.setQuery(this.b.clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.clone();
                HashMap<Integer, DistrictResult> hashMap = f;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.e == 0) {
                districtResult = (DistrictResult) new k(this.a, this.b.clone()).b();
                if (districtResult == null) {
                    return districtResult;
                }
                this.e = districtResult.getPageCount();
                a(districtResult);
            } else {
                districtResult = a(this.b.getPageNum());
                if (districtResult == null) {
                    districtResult = (DistrictResult) new k(this.a, this.b.clone()).b();
                    DistrictSearchQuery districtSearchQuery = this.b;
                    if (districtSearchQuery != null) {
                        if (districtResult != null) {
                            int i = this.e;
                            if (i > 0 && i > districtSearchQuery.getPageNum()) {
                                f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
                            }
                        }
                    }
                }
            }
            return districtResult;
        } catch (AMapException e2) {
            i.a(e2, "DistrictSearch", "searchDistrict");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.az.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(az.this.b);
                    try {
                        DistrictResult searchDistrict = az.this.searchDistrict();
                        if (searchDistrict != null) {
                            searchDistrict.setAMapException(new AMapException());
                        }
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = az.this.c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", searchDistrict);
                        obtainMessage.setData(bundle);
                        if (az.this.g != null) {
                            az.this.g.sendMessage(obtainMessage);
                        }
                    } catch (AMapException e) {
                        districtResult.setAMapException(e);
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = az.this.c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle2);
                        if (az.this.g != null) {
                            az.this.g.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = az.this.c;
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle3);
                        if (az.this.g != null) {
                            az.this.g.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }

    private void a(DistrictResult districtResult) {
        int i;
        f = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.b;
        if (districtSearchQuery != null && districtResult != null && (i = this.e) > 0 && i > districtSearchQuery.getPageNum()) {
            f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
        }
    }

    private boolean b(int i) {
        return i < this.e && i >= 0;
    }

    private boolean a() {
        return this.b != null;
    }

    private DistrictResult a(int i) throws AMapException {
        if (b(i)) {
            return f.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
