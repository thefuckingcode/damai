package tb;

import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class sl2 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CUSTOM_ACCS_TICKLET = "accsinfo";
    public static final String CUSTOM_TICKLET_3DTOUCH = "3dtouch";
    public static final String CUSTOM_TICKLET_LIST_STATUS = "ticketwalletinfo_status";
    public static final String TICKLET_DEFINE_SOUNENIR_TICKET = "souvenir_ticket_define";
    public static final String TICKLET_DETAIL_PAGE = "ticketwalletinfo";
    public static final String TICKLET_EXPLAIN = "ticket_explain";
    public static final String TICKLET_FACE_SETTING = "face_recognition_config";
    public static final String TICKLET_FORGET_CARD = "forget_credentials";
    public static final String TICKLET_HISTORY_LIST_PAGE = "history";
    public static final String TICKLET_LIST_PAGE = "ticketwalletlist";
    public static final String TICKLET_MYCOMMENT_LIST_PAGE = "evaluate_my";
    public static final String TICKLET_SCROT4TICKETINFO = "scrot4ticketinfo";
    public static final String TICKLET_SOUNENIR_TICKET = "souvenir_ticket";
    public static final String TICKLET_SOUVENIR = "paperticket_exchange";
    public static final String TICKLET_TRANSFER_CONDIRM_PAGE = "transferconfim";
    public static final String TICKLET_TRANSFER_MANAGER_PAGE = "transfermanager";
    public static final String TICKLET_TRANSFER_TABLE_PAGE = "transfertable";
    public static final String TICKLET_VENUEMAP = "ticket_venuemap";
    public static final String TICKLET_VOUCHER = "ticket_voucher";
    private static sl2 b;

    public static sl2 j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1621556443")) {
            return (sl2) ipChange.ipc$dispatch("-1621556443", new Object[0]);
        }
        if (b == null) {
            b = new sl2();
        }
        return b;
    }

    public a.b A(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351724815")) {
            return (a.b) ipChange.ipc$dispatch("1351724815", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        hashMap.put("ticket_id", str3);
        hashMap.put("usercode", d20.E());
        return e(TICKLET_FACE_SETTING, "binding", "go_binding_[" + i + jl1.ARRAY_END_STR, hashMap, Boolean.FALSE);
    }

    public a.b B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820048967")) {
            return (a.b) ipChange.ipc$dispatch("-1820048967", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        return e(TICKLET_FACE_SETTING, "top", "face_recognition_info", hashMap, Boolean.FALSE);
    }

    public a.b C(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466325859")) {
            return (a.b) ipChange.ipc$dispatch("1466325859", new Object[]{this, str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        hashMap.put("ticket_id", str3);
        hashMap.put("usercode", d20.E());
        hashMap.put("titlelabel", str4);
        return e(TICKLET_FACE_SETTING, "binding", "re_binding", hashMap, Boolean.FALSE);
    }

    public a.b D(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-408776813")) {
            return (a.b) ipChange.ipc$dispatch("-408776813", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        hashMap.put("ticket_id", str3);
        hashMap.put("usercode", d20.E());
        return e(TICKLET_FACE_SETTING, "untying", "face_untying", hashMap, Boolean.FALSE);
    }

    public a.b E(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861358273")) {
            return (a.b) ipChange.ipc$dispatch("861358273", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        hashMap.put("ticket_id", str3);
        hashMap.put("usercode", d20.E());
        return e(TICKLET_FACE_SETTING, "untying", "confirm_untying", hashMap, Boolean.FALSE);
    }

    public a.b F(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43178639")) {
            return (a.b) ipChange.ipc$dispatch("43178639", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        hashMap.put("ticket_id", str3);
        hashMap.put("usercode", d20.E());
        return e(TICKLET_FACE_SETTING, "untying", "think", hashMap, Boolean.FALSE);
    }

    public a.b G(int i, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718687337")) {
            return (a.b) ipChange.ipc$dispatch("1718687337", new Object[]{this, Integer.valueOf(i), map});
        }
        return e(TICKLET_LIST_PAGE, "list", "item_" + String.valueOf(i), map, Boolean.TRUE);
    }

    public a.b H() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "259670487")) {
            return e(TICKLET_LIST_PAGE, "list", "loginbutton", new HashMap(), Boolean.FALSE);
        }
        return (a.b) ipChange.ipc$dispatch("259670487", new Object[]{this});
    }

    public a.b I(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640591213")) {
            return (a.b) ipChange.ipc$dispatch("1640591213", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("collection_type", str);
        return e(TICKLET_DETAIL_PAGE, "nft", "play_" + i, hashMap, Boolean.TRUE);
    }

    public a.b J(String str, String str2, int i, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383333420")) {
            return (a.b) ipChange.ipc$dispatch("-1383333420", new Object[]{this, str, str2, Integer.valueOf(i), str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("screening_id", str);
        hashMap.put("ticket_status", str3);
        return e(TICKLET_DETAIL_PAGE, "nft", "obtain_" + i, hashMap, Boolean.FALSE);
    }

    public void K(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504263604")) {
            ipChange.ipc$dispatch("504263604", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        c e = c.e();
        e.G(view, "obtain_" + i, "nft", TICKLET_DETAIL_PAGE, hashMap);
    }

    public a.b L(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1843408148")) {
            return (a.b) ipChange.ipc$dispatch("-1843408148", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        hashMap.put("ticket_id", str3);
        hashMap.put("usercode", d20.E());
        return e(TICKLET_FACE_SETTING, "untying", "voucher_display", hashMap, Boolean.TRUE);
    }

    public a.b M(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942056026")) {
            return (a.b) ipChange.ipc$dispatch("-1942056026", new Object[]{this, str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("screening_id", str);
        return e(str3, "screenshot", str4, hashMap, Boolean.TRUE);
    }

    public a.b N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782176184")) {
            return (a.b) ipChange.ipc$dispatch("-782176184", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        return e(TICKLET_LIST_PAGE, "top", "verification", hashMap, Boolean.FALSE);
    }

    public a.b O(String str, String str2, String str3, String str4, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202465014")) {
            return (a.b) ipChange.ipc$dispatch("-1202465014", new Object[]{this, str, str2, str3, str4, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screening_id", str3);
        hashMap.put("tel", str4);
        return e(TICKLET_TRANSFER_MANAGER_PAGE, str, str2, hashMap, Boolean.valueOf(z));
    }

    public a.b P(String str, String str2, String str3, String str4, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703737319")) {
            return (a.b) ipChange.ipc$dispatch("703737319", new Object[]{this, str, str2, str3, str4, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screening_id", str3);
        hashMap.put("titlelabel", str4);
        hashMap.put("usercode", d20.E());
        return e(TICKLET_TRANSFER_MANAGER_PAGE, str, str2, hashMap, Boolean.valueOf(z));
    }

    public a.b Q() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "287634522")) {
            return e(TICKLET_LIST_PAGE, "top", "transferother_msg", new HashMap(), Boolean.TRUE);
        }
        return (a.b) ipChange.ipc$dispatch("287634522", new Object[]{this});
    }

    public a.b R() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762091342")) {
            return (a.b) ipChange.ipc$dispatch("-762091342", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d());
        return e(TICKLET_LIST_PAGE, "top", NotificationCompat.CATEGORY_REMINDER, hashMap, Boolean.FALSE);
    }

    public Map<String, String> S(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265667578")) {
            return (Map) ipChange.ipc$dispatch("265667578", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("titlelabel", str);
        return hashMap;
    }

    public void f(View view, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010961016")) {
            ipChange.ipc$dispatch("-1010961016", new Object[]{this, view, Integer.valueOf(i), str, str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("orderid", str2);
        hashMap.put("screening_id", str);
        c e = c.e();
        e.G(view, str3, "center_" + i, TICKLET_DETAIL_PAGE, hashMap);
    }

    public void g(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906278884")) {
            ipChange.ipc$dispatch("-906278884", new Object[]{this, str, str2, str3, str4});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("performid", str);
            hashMap.put(Constants.TOTAL_NUM, str2);
            hashMap.put("localNum", str3);
            hashMap.put("from", str4);
            hashMap.put("usercode", d20.E());
            c.e().A(hashMap, "local_data", "ticket_local");
        } catch (Exception unused) {
        }
    }

    public Map<String, String> h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542906375")) {
            return (Map) ipChange.ipc$dispatch("1542906375", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        return hashMap;
    }

    public Map<String, String> i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524497827")) {
            return (Map) ipChange.ipc$dispatch("1524497827", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        return hashMap;
    }

    public a.b k(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-733153414")) {
            return new a.b().i(str);
        }
        return (a.b) ipChange.ipc$dispatch("-733153414", new Object[]{this, str});
    }

    public a.b l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240118373")) {
            return (a.b) ipChange.ipc$dispatch("240118373", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        return new a.b().j(hashMap).i(str);
    }

    public a.b m(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097229326")) {
            return (a.b) ipChange.ipc$dispatch("-2097229326", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("perform_id", str);
        hashMap.put("usercode", String.valueOf(d20.E()));
        return e(TICKLET_SOUNENIR_TICKET, "center", "style_item_" + i, hashMap, Boolean.FALSE);
    }

    public a.b n(String str, String str2, String str3, String str4, String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240290486")) {
            return (a.b) ipChange.ipc$dispatch("1240290486", new Object[]{this, str, str2, str3, str4, str5, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str3);
        hashMap.put("screening_id", str2);
        return e(str, str4, str5, hashMap, Boolean.valueOf(z));
    }

    public a.b o(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "911315328")) {
            return (a.b) ipChange.ipc$dispatch("911315328", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("perform_id", str2);
        hashMap.put("usercode", String.valueOf(d20.E()));
        return e(str, str3, "close", hashMap, Boolean.TRUE);
    }

    public Map<String, String> p(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071861197")) {
            return (Map) ipChange.ipc$dispatch("2071861197", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("status", str);
        }
        hashMap.put("usercode", str2);
        return hashMap;
    }

    public Map<String, String> q(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913325639")) {
            return (Map) ipChange.ipc$dispatch("1913325639", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("ticket_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("type", str2);
        }
        return hashMap;
    }

    public Map<String, String> r(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731794780")) {
            return (Map) ipChange.ipc$dispatch("1731794780", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("perform_id", str);
        hashMap.put("usercode", String.valueOf(d20.E()));
        return hashMap;
    }

    public Map<String, String> s(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763493350")) {
            return (Map) ipChange.ipc$dispatch("763493350", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screening_id", str2);
        hashMap.put("item_id", str);
        return hashMap;
    }

    public Map<String, String> t(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "956260684")) {
            return (Map) ipChange.ipc$dispatch("956260684", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screening_id", str2);
        hashMap.put("orderid", str);
        return hashMap;
    }

    public a.b u(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76593402")) {
            return (a.b) ipChange.ipc$dispatch("76593402", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        return e(TICKLET_LIST_PAGE, "list", "evaluate_list_" + String.valueOf(i), hashMap, Boolean.TRUE);
    }

    public a.b v(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570478701")) {
            return (a.b) ipChange.ipc$dispatch("1570478701", new Object[]{this, Integer.valueOf(i), str});
        }
        new HashMap();
        Map<String, String> S = S(str);
        return e(TICKLET_MYCOMMENT_LIST_PAGE, "top", "tab_" + String.valueOf(i), S, Boolean.FALSE);
    }

    public a.b w(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939322240")) {
            return (a.b) ipChange.ipc$dispatch("-939322240", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("screening_id", str2);
        return e(TICKLET_LIST_PAGE, "list", "evaluate_submit_" + String.valueOf(i), hashMap, Boolean.TRUE);
    }

    public a.b x(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301424714")) {
            return (a.b) ipChange.ipc$dispatch("-1301424714", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("screening_id", str);
        hashMap.put("titlelabel", str3);
        return e(TICKLET_DETAIL_PAGE, "center", "button_" + i, hashMap, Boolean.FALSE);
    }

    public void y(View view, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654089010")) {
            ipChange.ipc$dispatch("654089010", new Object[]{this, view, Integer.valueOf(i), str, str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("screening_id", str);
        hashMap.put("titlelabel", str3);
        c e = c.e();
        e.G(view, "button_" + i, "center", TICKLET_DETAIL_PAGE, hashMap);
    }

    public a.b z(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-26861988")) {
            return e(str, str2, str3, map, bool);
        }
        return (a.b) ipChange.ipc$dispatch("-26861988", new Object[]{this, str, str2, str3, map, bool});
    }
}
