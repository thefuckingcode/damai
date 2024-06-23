package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class ak extends b<RoutePOISearchQuery, RoutePOISearchResult> {

    /* renamed from: com.amap.api.col.s.ak$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[RoutePOISearch.RoutePOISearchType.values().length];
            a = iArr;
            iArr[RoutePOISearch.RoutePOISearchType.TypeGasStation.ordinal()] = 1;
            a[RoutePOISearch.RoutePOISearchType.TypeMaintenanceStation.ordinal()] = 2;
            a[RoutePOISearch.RoutePOISearchType.TypeATM.ordinal()] = 3;
            a[RoutePOISearch.RoutePOISearchType.TypeToilet.ordinal()] = 4;
            a[RoutePOISearch.RoutePOISearchType.TypeFillingStation.ordinal()] = 5;
            try {
                a[RoutePOISearch.RoutePOISearchType.TypeServiceArea.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ak(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public RoutePOISearchResult a(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = q.i(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, ((a) this).b);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(((a) this).e));
        stringBuffer.append("&range=");
        StringBuilder sb = new StringBuilder();
        sb.append(((a) this).b.getRange());
        stringBuffer.append(sb.toString());
        String str = "";
        try {
            switch (AnonymousClass1.a[((a) this).b.getSearchType().ordinal()]) {
                case 1:
                    str = "010100";
                    break;
                case 2:
                    str = "030000";
                    break;
                case 3:
                    str = "160300";
                    break;
                case 4:
                    str = "200300";
                    break;
                case 5:
                    str = "010300";
                    break;
                case 6:
                    str = "180300";
                    break;
            }
        } catch (Exception unused) {
        }
        if (((a) this).b.getPolylines() == null || ((a) this).b.getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((a) this).b.getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((a) this).b.getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((a) this).b.getMode());
            stringBuffer.append(sb2.toString());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(i.a(((a) this).b.getPolylines()));
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/place/route?";
    }
}
