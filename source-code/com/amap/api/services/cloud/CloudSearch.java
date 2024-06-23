package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.s.aa;
import com.amap.api.col.s.ax;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class CloudSearch {
    private ICloudSearch a;

    /* compiled from: Taobao */
    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i);

        void onCloudSearched(CloudResult cloudResult, int i);
    }

    /* compiled from: Taobao */
    public static class Query implements Cloneable {
        private String a;
        private int b = 1;
        private int c = 20;
        private String d;
        private SearchBound e;
        private Sortingrules f;
        private ArrayList<aa> g = new ArrayList<>();
        private List<String> h = new ArrayList();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (i.a(str) || searchBound == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            this.d = str;
            this.a = str2;
            this.e = searchBound;
        }

        private ArrayList<aa> a() {
            if (this.g == null) {
                return null;
            }
            ArrayList<aa> arrayList = new ArrayList<>();
            arrayList.addAll(this.g);
            return arrayList;
        }

        private ArrayList<String> b() {
            if (this.h == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.h);
            return arrayList;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.g.add(new aa(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str != null && str2 != null) {
                List<String> list = this.h;
                list.add(str + str2);
            }
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                return queryEquals(query) && query.b == this.b;
            }
        }

        public SearchBound getBound() {
            return this.e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    aa aaVar = this.g.get(i);
                    stringBuffer.append(aaVar.a());
                    stringBuffer.append(jl1.GE);
                    stringBuffer.append(aaVar.b());
                    stringBuffer.append(jl1.AND);
                    stringBuffer.append(aaVar.a());
                    stringBuffer.append(jl1.LE);
                    stringBuffer.append(aaVar.c());
                    if (i != size - 1) {
                        stringBuffer.append(jl1.AND);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.h.size();
                for (int i = 0; i < size; i++) {
                    stringBuffer.append(this.h.get(i));
                    if (i != size - 1) {
                        stringBuffer.append(jl1.AND);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.b;
        }

        public int getPageSize() {
            return this.c;
        }

        public String getQueryString() {
            return this.a;
        }

        public Sortingrules getSortingrules() {
            return this.f;
        }

        public String getTableID() {
            return this.d;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            ArrayList<aa> arrayList = this.g;
            int i6 = 0;
            if (arrayList == null) {
                i = 0;
            } else {
                i = arrayList.hashCode();
            }
            int i7 = (i + 31) * 31;
            List<String> list = this.h;
            if (list == null) {
                i2 = 0;
            } else {
                i2 = list.hashCode();
            }
            int i8 = (i7 + i2) * 31;
            SearchBound searchBound = this.e;
            if (searchBound == null) {
                i3 = 0;
            } else {
                i3 = searchBound.hashCode();
            }
            int i9 = (((((i8 + i3) * 31) + this.b) * 31) + this.c) * 31;
            String str = this.a;
            if (str == null) {
                i4 = 0;
            } else {
                i4 = str.hashCode();
            }
            int i10 = (i9 + i4) * 31;
            Sortingrules sortingrules = this.f;
            if (sortingrules == null) {
                i5 = 0;
            } else {
                i5 = sortingrules.hashCode();
            }
            int i11 = (i10 + i5) * 31;
            String str2 = this.d;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            return i11 + i6;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return CloudSearch.b(query.a, this.a) && CloudSearch.b(query.getTableID(), getTableID()) && CloudSearch.b(query.getFilterString(), getFilterString()) && CloudSearch.b(query.getFilterNumString(), getFilterNumString()) && query.c == this.c && a(query.getBound(), getBound()) && a(query.getSortingrules(), getSortingrules());
        }

        public void setBound(SearchBound searchBound) {
            this.e = searchBound;
        }

        public void setPageNum(int i) {
            this.b = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.c = 20;
            } else if (i > 100) {
                this.c = 100;
            } else {
                this.c = i;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f = sortingrules;
        }

        public void setTableID(String str) {
            this.d = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
        @Override // java.lang.Object
        public Query clone() {
            Query query;
            AMapException e2;
            try {
                super.clone();
            } catch (CloneNotSupportedException e3) {
                e3.printStackTrace();
            }
            try {
                query = new Query(this.d, this.a, this.e);
                try {
                    query.setPageNum(this.b);
                    query.setPageSize(this.c);
                    query.setSortingrules(getSortingrules());
                    query.g = a();
                    query.h = b();
                } catch (AMapException e4) {
                    e2 = e4;
                }
            } catch (AMapException e5) {
                query = null;
                e2 = e5;
                e2.printStackTrace();
                if (query != null) {
                }
            }
            return query != null ? new Query() : query;
        }

        private static boolean a(SearchBound searchBound, SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        private static boolean a(Sortingrules sortingrules, Sortingrules sortingrules2) {
            if (sortingrules == null && sortingrules2 == null) {
                return true;
            }
            if (sortingrules == null || sortingrules2 == null) {
                return false;
            }
            return sortingrules.equals(sortingrules2);
        }

        private Query() {
        }
    }

    /* compiled from: Taobao */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";
        private LatLonPoint a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private List<LatLonPoint> f;
        private String g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
            if (latLonPoint == null || latLonPoint2 == null || latLonPoint.getLatitude() >= this.b.getLatitude() || this.a.getLongitude() >= this.b.getLongitude()) {
                return false;
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    if (!searchBound.d.equals(this.d) || searchBound.c != this.c) {
                        return false;
                    }
                    return true;
                } else if (getShape().equals("Polygon")) {
                    return a(searchBound.f, this.f);
                } else {
                    if (getShape().equals(LOCAL_SHAPE)) {
                        return searchBound.g.equals(this.g);
                    }
                    if (!searchBound.a.equals(this.a) || !searchBound.b.equals(this.b)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.d;
        }

        public String getCity() {
            return this.g;
        }

        public LatLonPoint getLowerLeft() {
            return this.a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f;
        }

        public int getRange() {
            return this.c;
        }

        public String getShape() {
            return this.e;
        }

        public LatLonPoint getUpperRight() {
            return this.b;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            LatLonPoint latLonPoint = this.d;
            int i5 = 0;
            if (latLonPoint == null) {
                i = 0;
            } else {
                i = latLonPoint.hashCode();
            }
            int i6 = (i + 31) * 31;
            LatLonPoint latLonPoint2 = this.a;
            if (latLonPoint2 == null) {
                i2 = 0;
            } else {
                i2 = latLonPoint2.hashCode();
            }
            int i7 = (i6 + i2) * 31;
            LatLonPoint latLonPoint3 = this.b;
            if (latLonPoint3 == null) {
                i3 = 0;
            } else {
                i3 = latLonPoint3.hashCode();
            }
            int i8 = (i7 + i3) * 31;
            List<LatLonPoint> list = this.f;
            if (list == null) {
                i4 = 0;
            } else {
                i4 = list.hashCode();
            }
            int i9 = (((i8 + i4) * 31) + this.c) * 31;
            String str = this.e;
            int hashCode = (i9 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.g;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return hashCode + i5;
        }

        @Override // java.lang.Object
        public SearchBound clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.d, this.c);
            }
            if (getShape().equals("Polygon")) {
                return new SearchBound(a());
            }
            if (getShape().equals(LOCAL_SHAPE)) {
                return new SearchBound(this.g);
            }
            return new SearchBound(this.a, this.b);
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.e = "Rectangle";
            if (!a(latLonPoint, latLonPoint2)) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
        }

        private static boolean a(List<LatLonPoint> list, List<LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!list.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }

        private List<LatLonPoint> a() {
            if (this.f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint latLonPoint : this.f) {
                arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.e = "Polygon";
            this.f = list;
        }

        public SearchBound(String str) {
            this.e = LOCAL_SHAPE;
            this.g = str;
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.a == null) {
            try {
                this.a = new ax(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    /* compiled from: Taobao */
    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;
        private int a = 0;
        private String b;
        private boolean c = true;

        public Sortingrules(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sortingrules sortingrules = (Sortingrules) obj;
            if (this.c != sortingrules.c) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (sortingrules.b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.b)) {
                return false;
            }
            return this.a == sortingrules.a;
        }

        public int hashCode() {
            int i = ((this.c ? 1231 : 1237) + 31) * 31;
            String str = this.b;
            return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.a;
        }

        public String toString() {
            if (i.a(this.b)) {
                int i = this.a;
                if (i == 0) {
                    return "_weight:desc";
                }
                return i == 1 ? "_distance:asc" : "";
            } else if (this.c) {
                return this.b + ":asc";
            } else {
                return this.b + ":desc";
            }
        }

        public Sortingrules(int i) {
            this.a = i;
        }
    }
}
