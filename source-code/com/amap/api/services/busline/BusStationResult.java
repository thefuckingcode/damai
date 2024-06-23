package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class BusStationResult {
    private int a;
    private ArrayList<BusStationItem> b = new ArrayList<>();
    private BusStationQuery c;
    private List<String> d = new ArrayList();
    private List<SuggestionCity> e = new ArrayList();

    private BusStationResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.c = busStationQuery;
        this.a = a(i);
        this.e = list;
        this.d = list2;
        this.b = arrayList;
    }

    private int a(int i) {
        int pageSize = this.c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i, list, list2, arrayList);
    }

    public final List<BusStationItem> getBusStations() {
        return this.b;
    }

    public final int getPageCount() {
        return this.a;
    }

    public final BusStationQuery getQuery() {
        return this.c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.d;
    }
}
