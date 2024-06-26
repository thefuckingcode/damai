package com.youku.middlewareservice.provider.location;

/* compiled from: Taobao */
public interface AppLocationProvider {

    /* compiled from: Taobao */
    public interface OnLocationChangedListener {

        /* compiled from: Taobao */
        public static class Location {
            public String address;
            public String cityCode;
            public double latitude;
            public double longitude;
            public String title;
        }

        void onLocationChanged(Location location);
    }

    void startLocate(OnLocationChangedListener onLocationChangedListener);
}
