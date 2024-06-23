package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public final class ax implements ICloudSearch {
    private Context a;
    private CloudSearch.OnCloudSearchListener b;
    private CloudSearch.Query c;
    private int d;
    private HashMap<Integer, CloudResult> e;
    private Handler f;

    public ax(Context context) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.f = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.ax.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 700;
                        t.d dVar = new t.d();
                        dVar.b = ax.this.b;
                        obtainMessage.obj = dVar;
                        dVar.a = ax.this.a((ax) query);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ax.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    ax.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.ax.AnonymousClass2 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 701;
                        t.c cVar = new t.c();
                        cVar.b = ax.this.b;
                        obtainMessage.obj = cVar;
                        cVar.a = ax.this.a((ax) str, str2);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ax.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    ax.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }

    private boolean b(int i) {
        return i <= this.d && i > 0;
    }

    private static boolean b(CloudSearch.Query query) {
        if (query == null || i.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CloudResult a(CloudSearch.Query query) throws AMapException {
        AMapException th;
        CloudResult cloudResult = null;
        try {
            if (b(query)) {
                if (!query.queryEquals(this.c)) {
                    this.d = 0;
                    this.c = query.clone();
                    HashMap<Integer, CloudResult> hashMap = this.e;
                    if (hashMap != null) {
                        hashMap.clear();
                    }
                }
                if (this.d == 0) {
                    CloudResult cloudResult2 = (CloudResult) new g(this.a, query).b();
                    try {
                        a(cloudResult2, query);
                        return cloudResult2;
                    } catch (Throwable th2) {
                        th = th2;
                        cloudResult = cloudResult2;
                    }
                } else {
                    cloudResult = a(query.getPageNum());
                    if (cloudResult == null) {
                        CloudResult cloudResult3 = (CloudResult) new g(this.a, query).b();
                        this.e.put(Integer.valueOf(query.getPageNum()), cloudResult3);
                        return cloudResult3;
                    }
                    return cloudResult;
                }
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (Throwable th3) {
            th = th3;
            i.a(th, "CloudSearch", "searchCloud");
            if (!(th instanceof AMapException)) {
                th.printStackTrace();
                return cloudResult;
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CloudItemDetail a(String str, String str2) throws AMapException {
        if (str == null || str.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else if (str2 == null || str2.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else {
            try {
                return (CloudItemDetail) new f(this.a, new ab(str, str2)).b();
            } catch (Throwable th) {
                i.a(th, "CloudSearch", "searchCloudDetail");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return null;
                }
                throw th;
            }
        }
    }

    private void a(CloudResult cloudResult, CloudSearch.Query query) {
        HashMap<Integer, CloudResult> hashMap = new HashMap<>();
        this.e = hashMap;
        if (this.d > 0) {
            hashMap.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    private CloudResult a(int i) {
        if (b(i)) {
            return this.e.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }
}
