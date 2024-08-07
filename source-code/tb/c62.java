package tb;

import android.text.TextUtils;
import android.view.View;
import androidx.media.MediaBrowserServiceCompat;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;

/* compiled from: Taobao */
public class c62 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CODE_SEARCH_CDN_DOWNGRADE_ALARM = "-1302";
    public static final String MSG_SEARCH_CDN_DOWNGRADE_ALARM = "搜索cdn降级";
    public static final String SEARCH_ITEM_ASSOCIATE = "item_associate";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final c62 a = new c62();
    }

    public static final c62 C() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "786161921") ? (c62) ipChange.ipc$dispatch("786161921", new Object[0]) : a.a;
    }

    public static void f(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688436111")) {
            ipChange.ipc$dispatch("-688436111", new Object[]{str, str2, str3});
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("search");
            sb.append(":jsondata={apiName: ");
            sb.append("mtop.damai.mec.aristotle.get");
            sb.append(", retCode: ");
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            sb.append(str);
            sb.append(", retMsg: ");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(", keyword: ");
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            sb.append(str3);
            sb.append(", cityId: ");
            sb.append(d20.c());
            sb.append("}");
            yz2.a(sb.toString(), CODE_SEARCH_CDN_DOWNGRADE_ALARM, MSG_SEARCH_CDN_DOWNGRADE_ALARM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void A(View view, int i, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431365826")) {
            ipChange.ipc$dispatch("-431365826", new Object[]{this, view, Integer.valueOf(i), str, str2, str3, str4});
            return;
        }
        HashMap hashMap = new HashMap();
        a03.h(hashMap, "titlelabel", str);
        a03.h(hashMap, "aaid", str2);
        a03.h(hashMap, za.PRE_CONTENT_ID, str3);
        a03.h(hashMap, za.PRE_CONTENT_TYPE, str4);
        c e = c.e();
        e.G(view, "item_" + i, "content", "search", hashMap);
    }

    public a.b B(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600323602")) {
            return (a.b) ipChange.ipc$dispatch("-1600323602", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        a03.h(hashMap, "titlelabel", str);
        a03.h(hashMap, "aaid", str2);
        return e("search", "content", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b D(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-965795959")) {
            return new a.b().a(d20.d()).e(str).i("related_search");
        }
        return (a.b) ipChange.ipc$dispatch("-965795959", new Object[]{this, str});
    }

    public a.b E() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1712210992")) {
            return new a.b().i(SEARCH_ITEM_ASSOCIATE);
        }
        return (a.b) ipChange.ipc$dispatch("1712210992", new Object[]{this});
    }

    public a.b F(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "744560602")) {
            return new a.b().a(d20.d()).e(str).i("search");
        }
        return (a.b) ipChange.ipc$dispatch("744560602", new Object[]{this, str});
    }

    public a.b G(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911990485")) {
            return (a.b) ipChange.ipc$dispatch("-1911990485", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        int i = !z ? 1 : 0;
        HashMap hashMap = new HashMap();
        a03.h(hashMap, "titlelabel", str);
        a03.h(hashMap, "contentlabel", z ? ErrControlViewInfo.TYPE_PROJECT : "现场");
        a03.h(hashMap, "aaid", str2);
        return e("search", "top", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b H(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1810842748")) {
            return (a.b) ipChange.ipc$dispatch("1810842748", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("biz_id", str);
        hashMap.put("usercode", d20.E());
        return e("search", "business_account", "card", hashMap, Boolean.TRUE);
    }

    public void I(e62 e62) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186673071")) {
            ipChange.ipc$dispatch("-1186673071", new Object[]{this, e62});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contentlabel", JSON.toJSONString(e62));
        c.e().A(hashMap, "keyword", "search");
    }

    public void J(View view, String str, String str2, String str3, String str4, String str5, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600710021")) {
            ipChange.ipc$dispatch("1600710021", new Object[]{this, view, str, str2, str3, str4, str5, Integer.valueOf(i)});
        } else if (view != null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("item_id", str);
                hashMap.put("alg", str4);
            } else {
                hashMap.put(za.PRE_CONTENT_ID, str5);
                hashMap.put(za.PRE_CONTENT_TYPE, "note");
            }
            hashMap.put("keyword", str2);
            hashMap.put("contentLabel", str3);
            c e = c.e();
            e.G(view, "item_" + i, "Recommend", "search", hashMap);
        }
    }

    public a.b K(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711970132")) {
            return (a.b) ipChange.ipc$dispatch("-1711970132", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", str);
        hashMap.put("titlelabel", str2);
        hashMap.put("type", String.valueOf(i));
        return e("search", "top", "searchbtn", hashMap, Boolean.FALSE);
    }

    public a.b L(String str, String str2, String str3, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430374754")) {
            return (a.b) ipChange.ipc$dispatch("1430374754", new Object[]{this, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        hashMap.put("item_id", str2);
        hashMap.put("keyword", str3);
        hashMap.put("contentlabel", "");
        hashMap.put("type", String.valueOf(i));
        return e("search", "list", "tour_item_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b M(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395165721")) {
            return (a.b) ipChange.ipc$dispatch("1395165721", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        return e("search", "list", "more", hashMap, Boolean.FALSE);
    }

    public a.b g(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038337307")) {
            return (a.b) ipChange.ipc$dispatch("-1038337307", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str2);
        hashMap.put("keyword", str);
        return e(SEARCH_ITEM_ASSOCIATE, "searchbar", "search", hashMap, Boolean.FALSE);
    }

    public a.b h(String str, boolean z, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044239858")) {
            return (a.b) ipChange.ipc$dispatch("-2044239858", new Object[]{this, str, Boolean.valueOf(z), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        hashMap.put("usercode", d20.E());
        hashMap.put("status", z ? "1" : "0");
        hashMap.put("biz_id", str2);
        hashMap.put("biz_type", str3);
        hashMap.put("keyword", str4);
        hashMap.put("type", String.valueOf(i));
        return e("search", "business_account", "flow", hashMap, Boolean.FALSE);
    }

    public a.b i(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865831800")) {
            return (a.b) ipChange.ipc$dispatch("1865831800", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        hashMap.put("usercode", d20.E());
        hashMap.put("biz_id", str2);
        hashMap.put("biz_type", str3);
        hashMap.put("keyword", str4);
        hashMap.put("type", String.valueOf(i));
        return e("search", "business_account", "card", hashMap, Boolean.TRUE);
    }

    public a.b j(String str, Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1237850773")) {
            return (a.b) ipChange.ipc$dispatch("1237850773", new Object[]{this, str, l});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("itemId", str);
        if (l != null) {
            hashMap.put("style", "1");
            hashMap.put("storeId", String.valueOf(l));
        } else {
            hashMap.put("style", "0");
        }
        return e(SEARCH_ITEM_ASSOCIATE, "be_evaluated", "upload", hashMap, Boolean.TRUE);
    }

    public a.b k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179625180")) {
            return (a.b) ipChange.ipc$dispatch("179625180", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("itemId", str);
        return e(SEARCH_ITEM_ASSOCIATE, MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, "upload", hashMap, Boolean.TRUE);
    }

    public a.b l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614272132")) {
            return (a.b) ipChange.ipc$dispatch("-614272132", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("itemId", str);
        return e(SEARCH_ITEM_ASSOCIATE, "topic", "upload", hashMap, Boolean.TRUE);
    }

    public a.b m(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "81057858")) {
            return (a.b) ipChange.ipc$dispatch("81057858", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put("status", z ? "1" : "0");
        return e("search", "business_card", "follow_btn", hashMap, Boolean.FALSE);
    }

    public a.b n(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511625910")) {
            return (a.b) ipChange.ipc$dispatch("-511625910", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        hashMap.put("usercode", d20.E());
        hashMap.put("biz_id", str2);
        hashMap.put("biz_type", str3);
        return e("search", "business_card", "card", hashMap, Boolean.TRUE);
    }

    public a.b o(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1140206958")) {
            return (a.b) ipChange.ipc$dispatch("-1140206958", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        hashMap.put("usercode", d20.E());
        hashMap.put("biz_id", str3);
        hashMap.put("biz_type", str4);
        hashMap.put("item_id", str2);
        return e("search", "business_card", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b p() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1517790958")) {
            return c("search", "clearhistory", Constants.TAG_CLEAR_STRING, Boolean.FALSE);
        }
        return (a.b) ipChange.ipc$dispatch("1517790958", new Object[]{this});
    }

    public a.b q(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293096231")) {
            return (a.b) ipChange.ipc$dispatch("-293096231", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        return e("search", "cleartext", Constants.TAG_CLEAR_STRING, hashMap, Boolean.FALSE);
    }

    public a.b r(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402064477")) {
            return (a.b) ipChange.ipc$dispatch("402064477", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        return e("search", "searchhistory", "item_" + str2, hashMap, Boolean.FALSE);
    }

    public a.b s(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138801219")) {
            return (a.b) ipChange.ipc$dispatch("-2138801219", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("alg", str2);
        hashMap.put("reason", str3);
        hashMap.put("wordtype", str4);
        return e("search", "hotword", "item_" + i, hashMap, Boolean.FALSE);
    }

    public a.b t(String str, String str2, String str3, int i, String str4, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9964736")) {
            return (a.b) ipChange.ipc$dispatch("9964736", new Object[]{this, str, str2, str3, Integer.valueOf(i), str4, Integer.valueOf(i2)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        hashMap.put("item_id", str2);
        hashMap.put("keyword", str3);
        hashMap.put("type", String.valueOf(i));
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("alg", str4);
        return e("search", "list", "item_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b u(String str, String str2, String str3, int i, int i2, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843623737")) {
            return (a.b) ipChange.ipc$dispatch("1843623737", new Object[]{this, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aaid", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        } else {
            hashMap.put("item_id", str3);
        }
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("alg", str4);
        hashMap.put("type", String.valueOf(i));
        return e("search", "keywordother", "item_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b v(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794363065")) {
            return (a.b) ipChange.ipc$dispatch("794363065", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("keyword", str2);
        hashMap.put("contentlabel", str3);
        hashMap.put("type", String.valueOf(i));
        return e("search", "top", "item_" + str4, hashMap, Boolean.TRUE);
    }

    public a.b w(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605071504")) {
            return (a.b) ipChange.ipc$dispatch("-605071504", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", str);
        hashMap.put("titlelabel", str2);
        hashMap.put("alg", str3);
        return e("search", "suggestion", "item_" + i, hashMap, Boolean.FALSE);
    }

    public a.b x(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "694949461")) {
            return (a.b) ipChange.ipc$dispatch("694949461", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", str);
        hashMap.put("titlelabel", str2);
        hashMap.put("alg", str3);
        return e("search", "suggestion", "item_" + i, hashMap, Boolean.TRUE);
    }

    @Deprecated
    public a.b y(String str, String str2, String str3, int i, String str4, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198918370")) {
            return (a.b) ipChange.ipc$dispatch("-198918370", new Object[]{this, str, str2, str3, Integer.valueOf(i), str4, Integer.valueOf(i2)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", str3);
        hashMap.put("titlelabel", str);
        hashMap.put("contentlabel", str2);
        hashMap.put("type", String.valueOf(i));
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("alg", str4);
        return e("search", "suggestionitem", "items_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b z(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581638252")) {
            return (a.b) ipChange.ipc$dispatch("-581638252", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", str);
        return e("search", "bottom", "gotop", hashMap, Boolean.FALSE);
    }
}
