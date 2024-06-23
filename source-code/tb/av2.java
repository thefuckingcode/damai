package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class av2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PROJECT_DETAIL_VENUE_ERROR_CODE = "-3103";
    public static final String PROJECT_DETAIL_VENUE_ERROR_MSG = "场馆信息加载异常";
    public static final String PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_CODE = "-3102";
    public static final String PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_MSG = "项目详情-场馆POI检索结果与传入经纬度距离超过2公里";
    public static final String PROJECT_VENUE_POI_SEARCH_ERROR_CODE = "-3101";
    public static final String PROJECT_VENUE_POI_SEARCH_ERROR_MSG = "项目详情-场馆POI检索异常";

    public static void a(long j, String str, String str2, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247140216")) {
            ipChange.ipc$dispatch("247140216", new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(wk.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        String str3 = "mtop.damai.wireless.venue.info";
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", retCode:");
        sb.append(str);
        sb.append(", retMsg:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", projectId:");
        sb.append(j2);
        sb.append(", venueId:");
        sb.append(j);
        sb.append("}");
        yz2.a(sb.toString(), PROJECT_DETAIL_VENUE_ERROR_CODE, PROJECT_DETAIL_VENUE_ERROR_MSG);
    }

    public static void b(String str, long j, String str2, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296437283")) {
            ipChange.ipc$dispatch("296437283", new Object[]{str, Long.valueOf(j), str2, Long.valueOf(j2)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(wk.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        sb.append(vl2.TICKLET_VENUE_POI_SEARCH_API_NAME);
        sb.append(", distance(m):");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", keyword:");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(", projectId:");
        sb.append(j2);
        sb.append(", venueId:");
        sb.append(j);
        sb.append("}");
        yz2.a(sb.toString(), PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_CODE, PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_MSG);
    }

    public static void c(String str, long j, String str2, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208142754")) {
            ipChange.ipc$dispatch("1208142754", new Object[]{str, Long.valueOf(j), str2, Long.valueOf(j2)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(wk.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        sb.append(vl2.TICKLET_VENUE_POI_SEARCH_API_NAME);
        sb.append(", retCode:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", keyword:");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(", projectId:");
        sb.append(j2);
        sb.append(", venueId:");
        sb.append(j);
        sb.append("}");
        yz2.a(sb.toString(), PROJECT_VENUE_POI_SEARCH_ERROR_CODE, PROJECT_VENUE_POI_SEARCH_ERROR_MSG);
    }
}
