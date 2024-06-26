package cn.damai.wantsee;

import android.text.TextUtils;
import cn.damai.abtest.ABTestOrangeModel;
import cn.damai.common.util.CompliantUtUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.d20;
import tb.g91;
import tb.m02;
import tb.s41;

/* compiled from: Taobao */
public class StartConfig implements CompliantUtUtils.CompliantUtDelegate, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ABTestOrangeModel abTestOrangeModel;
    public String enableNewShowCalendar;
    public GeoDeBackList geoBackList;
    public NewHomeSwitch homeSwitch;
    public PopupSwitch popupSwitch;
    public String privacyDoubleListInitSwitch;
    public m02 resetAttendees;
    public SearchCDNSwitch searchCdnSwitch;
    public WantSeeOrangeConfig wantSeeOrangeConfig;

    public static StartConfig getConfigFromSp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "521154991")) {
            return (StartConfig) ipChange.ipc$dispatch("521154991", new Object[0]);
        }
        try {
            String b = d20.b();
            g91.c("OrangeFixWVCamera", "app_start_config = " + b);
            if (!TextUtils.isEmpty(b)) {
                return (StartConfig) s41.a(b, StartConfig.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> getPopupSceneTypes() {
        PopupSwitch popupSwitch2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934519159")) {
            return (ArrayList) ipChange.ipc$dispatch("-1934519159", new Object[0]);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        StartConfig configFromSp = getConfigFromSp();
        return (configFromSp == null || (popupSwitch2 = configFromSp.popupSwitch) == null) ? arrayList : popupSwitch2.sceneTypes;
    }

    public static boolean isOpenNewShowCalendar() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982100843")) {
            return ((Boolean) ipChange.ipc$dispatch("-1982100843", new Object[0])).booleanValue();
        }
        StartConfig configFromSp = getConfigFromSp();
        if (configFromSp == null || (str = configFromSp.enableNewShowCalendar) == null) {
            return true;
        }
        return "true".equals(str);
    }

    public static boolean isOpenSearchCdnDowngrade() {
        SearchCDNSwitch searchCDNSwitch;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283365746")) {
            return ((Boolean) ipChange.ipc$dispatch("283365746", new Object[0])).booleanValue();
        }
        StartConfig configFromSp = getConfigFromSp();
        if (configFromSp == null || (searchCDNSwitch = configFromSp.searchCdnSwitch) == null) {
            return true;
        }
        return searchCDNSwitch.isSearchCdnDownGradeOpen;
    }

    public static boolean isOrangeOpenPrivacyDoubleListInit() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649411863")) {
            return ((Boolean) ipChange.ipc$dispatch("649411863", new Object[0])).booleanValue();
        }
        StartConfig configFromSp = getConfigFromSp();
        if (configFromSp == null || (str = configFromSp.privacyDoubleListInitSwitch) == null) {
            return true;
        }
        return "true".equals(str);
    }

    public static boolean isPopupOpenAble() {
        PopupSwitch popupSwitch2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326898646")) {
            return ((Boolean) ipChange.ipc$dispatch("326898646", new Object[0])).booleanValue();
        }
        StartConfig configFromSp = getConfigFromSp();
        if (configFromSp == null || (popupSwitch2 = configFromSp.popupSwitch) == null) {
            return true;
        }
        return popupSwitch2.isHomePopupOpen;
    }

    public static boolean isResetAttendeesOpen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938923352")) {
            return ((Boolean) ipChange.ipc$dispatch("938923352", new Object[0])).booleanValue();
        }
        getConfigFromSp();
        return true;
    }

    public static boolean isShowHomeDependOnOrange() {
        NewHomeSwitch newHomeSwitch;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691286007")) {
            return ((Boolean) ipChange.ipc$dispatch("691286007", new Object[0])).booleanValue();
        }
        StartConfig configFromSp = getConfigFromSp();
        if (configFromSp == null || (newHomeSwitch = configFromSp.homeSwitch) == null) {
            return false;
        }
        return newHomeSwitch.isHomePageDependOnOrange;
    }

    public static boolean isUseNewHomePreload() {
        NewHomeSwitch newHomeSwitch;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658377077")) {
            return ((Boolean) ipChange.ipc$dispatch("658377077", new Object[0])).booleanValue();
        }
        StartConfig configFromSp = getConfigFromSp();
        if (configFromSp == null || (newHomeSwitch = configFromSp.homeSwitch) == null) {
            return true;
        }
        return newHomeSwitch.isUseNewHomePreload;
    }

    public static boolean isUseOldHomeCMSFragment() {
        NewHomeSwitch newHomeSwitch;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "612320524")) {
            return ((Boolean) ipChange.ipc$dispatch("612320524", new Object[0])).booleanValue();
        }
        StartConfig configFromSp = getConfigFromSp();
        if (configFromSp == null || (newHomeSwitch = configFromSp.homeSwitch) == null) {
            return false;
        }
        return newHomeSwitch.isUseOldHomeCMSFragment;
    }

    @Override // cn.damai.common.util.CompliantUtUtils.CompliantUtDelegate
    public boolean isOpenPrivacyDoubleListInit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1377158775")) {
            return isOrangeOpenPrivacyDoubleListInit();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1377158775", new Object[]{this})).booleanValue();
    }
}
