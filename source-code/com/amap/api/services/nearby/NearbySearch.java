package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.s.bc;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;

/* compiled from: Taobao */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;
    private static NearbySearch a;
    private INearbySearch b;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.services.nearby.NearbySearch$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[NearbySearchFunctionType.values().length];
            a = iArr;
            iArr[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
        }
    }

    /* compiled from: Taobao */
    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i);

        void onNearbyInfoUploaded(int i);

        void onUserInfoCleared(int i);
    }

    /* compiled from: Taobao */
    public static class NearbyQuery {
        private LatLonPoint a;
        private NearbySearchFunctionType b = NearbySearchFunctionType.DISTANCE_SEARCH;
        private int c = 1000;
        private int d = 1800;
        private int e = 1;

        public LatLonPoint getCenterPoint() {
            return this.a;
        }

        public int getCoordType() {
            return this.e;
        }

        public int getRadius() {
            return this.c;
        }

        public int getTimeRange() {
            return this.d;
        }

        public int getType() {
            int i = AnonymousClass1.a[this.b.ordinal()];
            return (i == 1 || i != 2) ? 0 : 1;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.a = latLonPoint;
        }

        public void setCoordType(int i) {
            if (i == 0 || i == 1) {
                this.e = i;
            } else {
                this.e = 1;
            }
        }

        public void setRadius(int i) {
            if (i > 10000) {
                i = 10000;
            }
            this.c = i;
        }

        public void setTimeRange(int i) {
            if (i < 5) {
                i = 5;
            } else if (i > 86400) {
                i = 86400;
            }
            this.d = i;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.b == null) {
            try {
                this.b = new bc(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    private void a() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.b = null;
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            NearbySearch nearbySearch = a;
            if (nearbySearch != null) {
                try {
                    nearbySearch.a();
                } catch (Throwable th) {
                    i.a(th, "NearbySearch", "destryoy");
                }
            }
            a = null;
        }
    }

    public static synchronized NearbySearch getInstance(Context context) throws AMapException {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (a == null) {
                try {
                    a = new NearbySearch(context);
                } catch (AMapException e) {
                    throw e;
                }
            }
            nearbySearch = a;
        }
        return nearbySearch;
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
