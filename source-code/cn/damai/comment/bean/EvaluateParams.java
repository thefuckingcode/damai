package cn.damai.comment.bean;

import android.os.Bundle;
import cn.damai.commonbusiness.scriptmurder.venuedetail.VenueDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.lk1;
import tb.p21;

/* compiled from: Taobao */
public class EvaluateParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String OPEN_QUERY_STORE_INFO = "OPEN_QUERY_STORE_INFO";
    public static final String STORE_ID = "storeId";
    public final int fromWhere;
    public final String ipId;
    public final long itemId;
    public final boolean openQueryStoreInfo;
    public final String scriptId;
    public final String storeId;
    public final String tourId;
    public final String venueId;

    public EvaluateParams(int i, long j, String str, String str2, String str3, String str4, String str5, boolean z) {
        this.fromWhere = i;
        this.itemId = j;
        this.ipId = str;
        this.tourId = str2;
        this.storeId = str3;
        this.scriptId = str4;
        this.venueId = str5;
        this.openQueryStoreInfo = z;
    }

    public static EvaluateParams formBundle(Bundle bundle) {
        long intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875697152")) {
            return (EvaluateParams) ipChange.ipc$dispatch("1875697152", new Object[]{bundle});
        }
        int i = bundle.getInt("fromWhere", 0);
        String string = bundle.getString(p21.ISSUE_PARAM_IPID);
        String string2 = bundle.getString("tourId");
        String string3 = bundle.getString(VenueDetailFragment.VENUE_ID);
        String string4 = bundle.getString("storeId");
        String string5 = bundle.getString("scriptId");
        long j = 0;
        if (bundle.containsKey("projectId")) {
            intValue = lk1.k(bundle.getString("projectId"), 0);
        } else {
            Object obj = bundle.get("itemId");
            if (obj instanceof String) {
                intValue = lk1.k((String) obj, 0);
            } else if (obj instanceof Long) {
                intValue = ((Long) obj).longValue();
            } else {
                if (obj instanceof Integer) {
                    intValue = (long) ((Integer) obj).intValue();
                }
                return new EvaluateParams(i, j, string, string2, string4, string5, string3, bundle.getBoolean(OPEN_QUERY_STORE_INFO, false));
            }
        }
        j = intValue;
        return new EvaluateParams(i, j, string, string2, string4, string5, string3, bundle.getBoolean(OPEN_QUERY_STORE_INFO, false));
    }
}
