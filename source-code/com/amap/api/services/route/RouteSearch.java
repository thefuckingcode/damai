package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.bf;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
    public static final int DRIVEING_PLAN_DEFAULT = 1;
    public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
    public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
    public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
    public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final String DRIVING_EXCLUDE_FERRY = "ferry";
    public static final String DRIVING_EXCLUDE_MOTORWAY = "motorway";
    public static final String DRIVING_EXCLUDE_TOLL = "toll";
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_NORMAL_CAR = 0;
    public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
    public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int TRUCK_AVOID_CONGESTION = 1;
    public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int TRUCK_CHOICE_HIGHWAY = 8;
    public static final int TRUCK_NO_HIGHWAY = 2;
    public static final int TRUCK_SAVE_MONEY = 3;
    public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final int TRUCK_SIZE_HEAVY = 4;
    public static final int TRUCK_SIZE_LIGHT = 2;
    public static final int TRUCK_SIZE_MEDIUM = 3;
    public static final int TRUCK_SIZE_MINI = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;
    private IRouteSearch a;

    /* compiled from: Taobao */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.BusRouteQuery.AnonymousClass1 */

            private static BusRouteQuery a(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery[] newArray(int i) {
                return a(i);
            }

            private static BusRouteQuery[] a(int i) {
                return new BusRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b;
        private String c;
        private String d;
        private int e;
        private String f = "base";

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.a = fromAndTo;
            this.b = i;
            this.c = str;
            this.e = i2;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            String str = this.c;
            if (str == null) {
                if (busRouteQuery.c != null) {
                    return false;
                }
            } else if (!str.equals(busRouteQuery.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null) {
                if (busRouteQuery.d != null) {
                    return false;
                }
            } else if (!str2.equals(busRouteQuery.d)) {
                return false;
            }
            String str3 = this.f;
            if (str3 == null) {
                if (busRouteQuery.f != null) {
                    return false;
                }
            } else if (!str3.equals(busRouteQuery.f)) {
                return false;
            }
            FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (busRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(busRouteQuery.a)) {
                return false;
            }
            return this.b == busRouteQuery.b && this.e == busRouteQuery.e;
        }

        public String getCity() {
            return this.c;
        }

        public String getCityd() {
            return this.d;
        }

        public String getExtensions() {
            return this.f;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int getNightFlag() {
            return this.e;
        }

        public int hashCode() {
            String str = this.c;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.b) * 31) + this.e) * 31;
            String str2 = this.d;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public void setCityd(String str) {
            this.d = str;
        }

        public void setExtensions(String str) {
            this.f = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeInt(this.e);
            parcel.writeString(this.d);
            parcel.writeString(this.f);
        }

        @Override // java.lang.Object
        public BusRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.a, this.b, this.c, this.e);
            busRouteQuery.setCityd(this.d);
            busRouteQuery.setExtensions(this.f);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.e = parcel.readInt();
            this.d = parcel.readString();
            this.f = parcel.readString();
        }

        public BusRouteQuery() {
        }
    }

    /* compiled from: Taobao */
    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new Parcelable.Creator<DrivePlanQuery>() {
            /* class com.amap.api.services.route.RouteSearch.DrivePlanQuery.AnonymousClass1 */

            private static DrivePlanQuery a(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery[] newArray(int i) {
                return a(i);
            }

            private static DrivePlanQuery[] a(int i) {
                return new DrivePlanQuery[i];
            }
        };
        private FromAndTo a;
        private String b;
        private int c = 1;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private int g = 48;

        public DrivePlanQuery(FromAndTo fromAndTo, int i, int i2, int i3) {
            this.a = fromAndTo;
            this.e = i;
            this.f = i2;
            this.g = i3;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DrivePlanQuery drivePlanQuery = (DrivePlanQuery) obj;
            FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (drivePlanQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(drivePlanQuery.a)) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (drivePlanQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(drivePlanQuery.b)) {
                return false;
            }
            return this.c == drivePlanQuery.c && this.d == drivePlanQuery.d && this.e == drivePlanQuery.e && this.f == drivePlanQuery.f && this.g == drivePlanQuery.g;
        }

        public int getCarType() {
            return this.d;
        }

        public int getCount() {
            return this.g;
        }

        public String getDestParentPoiID() {
            return this.b;
        }

        public int getFirstTime() {
            return this.e;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getInterval() {
            return this.f;
        }

        public int getMode() {
            return this.c;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.a;
            int i = 0;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return ((((((((((hashCode + i) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }

        public void setCarType(int i) {
            this.d = i;
        }

        public void setDestParentPoiID(String str) {
            this.b = str;
        }

        public void setMode(int i) {
            this.c = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeString(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        @Override // java.lang.Object
        public DrivePlanQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.a, this.e, this.f, this.g);
            drivePlanQuery.setDestParentPoiID(this.b);
            drivePlanQuery.setMode(this.c);
            drivePlanQuery.setCarType(this.d);
            return drivePlanQuery;
        }

        public DrivePlanQuery() {
        }

        protected DrivePlanQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readString();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }
    }

    /* compiled from: Taobao */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.DriveRouteQuery.AnonymousClass1 */

            private static DriveRouteQuery a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i) {
                return a(i);
            }

            private static DriveRouteQuery[] a(int i) {
                return new DriveRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b;
        private List<LatLonPoint> c;
        private List<List<LatLonPoint>> d;
        private String e;
        private boolean f = true;
        private int g = 0;
        private String h = null;
        private String i = "base";

        public DriveRouteQuery(FromAndTo fromAndTo, int i2, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.a = fromAndTo;
            this.b = i2;
            this.c = list;
            this.d = list2;
            this.e = str;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            String str = this.e;
            if (str == null) {
                if (driveRouteQuery.e != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.e)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.d;
            if (list == null) {
                if (driveRouteQuery.d != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.d)) {
                return false;
            }
            FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (driveRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.a)) {
                return false;
            }
            if (this.b != driveRouteQuery.b) {
                return false;
            }
            List<LatLonPoint> list2 = this.c;
            if (list2 == null) {
                if (driveRouteQuery.c != null) {
                    return false;
                }
            } else if (!(list2.equals(driveRouteQuery.c) && this.f == driveRouteQuery.isUseFerry() && this.g == driveRouteQuery.g)) {
                return false;
            }
            String str2 = this.i;
            if (str2 == null) {
                if (driveRouteQuery.i != null) {
                    return false;
                }
            } else if (!str2.equals(driveRouteQuery.i)) {
                return false;
            }
            return true;
        }

        public String getAvoidRoad() {
            return this.e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                List<LatLonPoint> list2 = this.d.get(i2);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    LatLonPoint latLonPoint = list2.get(i3);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i3 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i2 < this.d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.g;
        }

        public String getExclude() {
            return this.h;
        }

        public String getExtensions() {
            return this.i;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                LatLonPoint latLonPoint = this.c.get(i2);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i2 < this.c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !i.a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !i.a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !i.a(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.e;
            int i2 = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.b) * 31;
            List<LatLonPoint> list2 = this.c;
            if (list2 != null) {
                i2 = list2.hashCode();
            }
            return ((hashCode3 + i2) * 31) + this.g;
        }

        public boolean isUseFerry() {
            return this.f;
        }

        public void setCarType(int i2) {
            this.g = i2;
        }

        public void setExclude(String str) {
            this.h = str;
        }

        public void setExtensions(String str) {
            this.i = str;
        }

        public void setUseFerry(boolean z) {
            this.f = z;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.a, i2);
            parcel.writeInt(this.b);
            parcel.writeTypedList(this.c);
            List<List<LatLonPoint>> list = this.d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                for (List<LatLonPoint> list2 : this.d) {
                    parcel.writeTypedList(list2);
                }
            }
            parcel.writeString(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
        }

        @Override // java.lang.Object
        public DriveRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.a, this.b, this.c, this.d, this.e);
            driveRouteQuery.setUseFerry(this.f);
            driveRouteQuery.setCarType(this.g);
            driveRouteQuery.setExclude(this.h);
            driveRouteQuery.setExtensions(this.i);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            boolean z = true;
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.d = null;
            } else {
                this.d = new ArrayList();
            }
            for (int i2 = 0; i2 < readInt; i2++) {
                this.d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.e = parcel.readString();
            this.f = parcel.readInt() != 1 ? false : z;
            this.g = parcel.readInt();
            this.h = parcel.readString();
            this.i = parcel.readString();
        }

        public DriveRouteQuery() {
        }
    }

    /* compiled from: Taobao */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() {
            /* class com.amap.api.services.route.RouteSearch.FromAndTo.AnonymousClass1 */

            private static FromAndTo a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i) {
                return a(i);
            }

            private static FromAndTo[] a(int i) {
                return new FromAndTo[i];
            }
        };
        private LatLonPoint a;
        private LatLonPoint b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FromAndTo fromAndTo = (FromAndTo) obj;
            String str = this.d;
            if (str == null) {
                if (fromAndTo.d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.a;
            if (latLonPoint == null) {
                if (fromAndTo.a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.a)) {
                return false;
            }
            String str2 = this.c;
            if (str2 == null) {
                if (fromAndTo.c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.b;
            if (latLonPoint2 == null) {
                if (fromAndTo.b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.b)) {
                return false;
            }
            String str3 = this.e;
            if (str3 == null) {
                if (fromAndTo.e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.e)) {
                return false;
            }
            String str4 = this.f;
            if (str4 == null) {
                if (fromAndTo.f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f)) {
                return false;
            }
            return true;
        }

        public String getDestinationPoiID() {
            return this.d;
        }

        public String getDestinationType() {
            return this.f;
        }

        public LatLonPoint getFrom() {
            return this.a;
        }

        public String getOriginType() {
            return this.e;
        }

        public String getPlateNumber() {
            return this.h;
        }

        public String getPlateProvince() {
            return this.g;
        }

        public String getStartPoiID() {
            return this.c;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public int hashCode() {
            String str = this.d;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode5 + i;
        }

        public void setDestinationPoiID(String str) {
            this.d = str;
        }

        public void setDestinationType(String str) {
            this.f = str;
        }

        public void setOriginType(String str) {
            this.e = str;
        }

        public void setPlateNumber(String str) {
            this.h = str;
        }

        public void setPlateProvince(String str) {
            this.g = str;
        }

        public void setStartPoiID(String str) {
            this.c = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }

        @Override // java.lang.Object
        public FromAndTo clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.a, this.b);
            fromAndTo.setStartPoiID(this.c);
            fromAndTo.setDestinationPoiID(this.d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* compiled from: Taobao */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i);
    }

    /* compiled from: Taobao */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    /* compiled from: Taobao */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i);
    }

    /* compiled from: Taobao */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.RideRouteQuery.AnonymousClass1 */

            private static RideRouteQuery a(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery[] newArray(int i) {
                return a(i);
            }

            private static RideRouteQuery[] a(int i) {
                return new RideRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b;
        private String c = "base";

        public RideRouteQuery(FromAndTo fromAndTo, int i) {
            this.a = fromAndTo;
            this.b = i;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RideRouteQuery rideRouteQuery = (RideRouteQuery) obj;
            FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (rideRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.a)) {
                return false;
            }
            return this.b == rideRouteQuery.b;
        }

        public String getExtensions() {
            return this.c;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.b;
        }

        public void setExtensions(String str) {
            this.c = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
        }

        @Override // java.lang.Object
        public RideRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                i.a(e, "RouteSearch", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.a);
            rideRouteQuery.setExtensions(this.c);
            return rideRouteQuery;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.a = fromAndTo;
        }

        public RideRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
        }

        public RideRouteQuery() {
        }
    }

    /* compiled from: Taobao */
    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new Parcelable.Creator<TruckRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.TruckRouteQuery.AnonymousClass1 */

            private static TruckRouteQuery a(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery[] newArray(int i) {
                return a(i);
            }

            private static TruckRouteQuery[] a(int i) {
                return new TruckRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b = 2;
        private int c;
        private List<LatLonPoint> d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private String j = "base";

        public TruckRouteQuery(FromAndTo fromAndTo, int i2, List<LatLonPoint> list, int i3) {
            this.a = fromAndTo;
            this.c = i2;
            this.d = list;
            this.b = i3;
        }

        public int describeContents() {
            return 0;
        }

        public String getExtensions() {
            return this.j;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                LatLonPoint latLonPoint = this.d.get(i2);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i2 < this.d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.i;
        }

        public float getTruckHeight() {
            return this.e;
        }

        public float getTruckLoad() {
            return this.g;
        }

        public int getTruckSize() {
            return this.b;
        }

        public float getTruckWeight() {
            return this.h;
        }

        public float getTruckWidth() {
            return this.f;
        }

        public boolean hasPassPoint() {
            return !i.a(getPassedPointStr());
        }

        public void setExtensions(String str) {
            this.j = str;
        }

        public void setMode(int i2) {
            this.c = i2;
        }

        public void setTruckAxis(float f2) {
            this.i = f2;
        }

        public void setTruckHeight(float f2) {
            this.e = f2;
        }

        public void setTruckLoad(float f2) {
            this.g = f2;
        }

        public void setTruckSize(int i2) {
            this.b = i2;
        }

        public void setTruckWeight(float f2) {
            this.h = f2;
        }

        public void setTruckWidth(float f2) {
            this.f = f2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.a, i2);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeTypedList(this.d);
            parcel.writeFloat(this.e);
            parcel.writeFloat(this.f);
            parcel.writeFloat(this.g);
            parcel.writeFloat(this.h);
            parcel.writeFloat(this.i);
            parcel.writeString(this.j);
        }

        @Override // java.lang.Object
        public TruckRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "TruckRouteQueryclone");
            }
            TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.a, this.c, this.d, this.b);
            truckRouteQuery.setExtensions(this.j);
            return truckRouteQuery;
        }

        protected TruckRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.e = parcel.readFloat();
            this.f = parcel.readFloat();
            this.g = parcel.readFloat();
            this.h = parcel.readFloat();
            this.i = parcel.readFloat();
            this.j = parcel.readString();
        }
    }

    /* compiled from: Taobao */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.WalkRouteQuery.AnonymousClass1 */

            private static WalkRouteQuery a(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery[] newArray(int i) {
                return a(i);
            }

            private static WalkRouteQuery[] a(int i) {
                return new WalkRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b;
        private String c = "base";

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.a = fromAndTo;
            this.b = i;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (walkRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.a)) {
                return false;
            }
            String str = this.c;
            if (str == null) {
                if (walkRouteQuery.c != null) {
                    return false;
                }
            } else if (!str.equals(walkRouteQuery.c)) {
                return false;
            }
            return this.b == walkRouteQuery.b;
        }

        public String getExtensions() {
            return this.c;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.b;
        }

        public void setExtensions(String str) {
            this.c = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
        }

        @Override // java.lang.Object
        public WalkRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                i.a(e, "RouteSearch", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.a);
            walkRouteQuery.setExtensions(this.c);
            return walkRouteQuery;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.a = fromAndTo;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
        }

        public WalkRouteQuery() {
        }
    }

    public RouteSearch(Context context) throws AMapException {
        if (this.a == null) {
            try {
                this.a = new bf(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
