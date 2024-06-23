package com.amap.api.services.interfaces;

import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;

/* compiled from: Taobao */
public interface IBusStationSearch {
    BusStationQuery getQuery();

    BusStationResult searchBusStation() throws AMapException;

    void searchBusStationAsyn();

    void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener);

    void setQuery(BusStationQuery busStationQuery);
}
