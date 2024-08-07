package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.b;
import com.alibaba.pictures.ut.ClickCat;
import com.alibaba.pictures.ut.DogCat;
import com.alibaba.pictures.ut.ExposureDog;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.oneservice.nav.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class gw0 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_PAGE = "home";
    private static gw0 d;
    int b = 0;
    List<RichTitle> c;

    public static String g(Map<String, Action> map) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857038462")) {
            return (String) ipChange.ipc$dispatch("-1857038462", new Object[]{map});
        }
        if (map == null || (action = map.get("item")) == null || action.getTrackInfo() == null) {
            return "feed_recommend";
        }
        return action.getTrackInfo().getSpmc();
    }

    private String h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "177942232")) {
            return "item_";
        }
        return (String) ipChange.ipc$dispatch("177942232", new Object[]{this});
    }

    public static gw0 i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-913663571")) {
            return (gw0) ipChange.ipc$dispatch("-913663571", new Object[0]);
        }
        if (d == null) {
            d = new gw0();
        }
        return d;
    }

    private String j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414436482")) {
            return (String) ipChange.ipc$dispatch("414436482", new Object[]{this});
        }
        List<RichTitle> list = this.c;
        return (list == null || this.b >= list.size() || this.c.get(this.b) == null || TextUtils.isEmpty(this.c.get(this.b).getText())) ? "为你推荐" : this.c.get(this.b).getText();
    }

    public void f(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798334057")) {
            ipChange.ipc$dispatch("1798334057", new Object[]{this, str, str2, str3, str4, str5, str6, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> d2 = a03.d();
        a03.h(d2, "city", d20.d() + "市");
        a03.h(d2, "titlelabel", j());
        if (!TextUtils.isEmpty(str2)) {
            d2.put("item_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            d2.put("alg", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            d2.put("scm", str4);
        }
        a03.h(d2, "card_type", str5);
        if (!TextUtils.isEmpty(str6)) {
            d2.put("card_id", str6);
        }
        if (!TextUtils.isEmpty(d20.E())) {
            d2.put("usercode", d20.E());
        }
        DogCat.INSTANCE.d().r(str, "vote_cancel").o(d2).m(false).j();
    }

    public void k(String str, View view, String str2, String str3, String str4, String str5, String str6, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133426450")) {
            ipChange.ipc$dispatch("133426450", new Object[]{this, str, view, str2, str3, str4, str5, str6, Integer.valueOf(i)});
            return;
        }
        l(str, view, str2, str3, str4, str5, str6, i, "");
    }

    public void l(String str, View view, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965560740")) {
            ipChange.ipc$dispatch("-965560740", new Object[]{this, str, view, str2, str3, str4, str5, str6, Integer.valueOf(i), str7});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city", d20.d() + "市");
            hashMap.put("titlelabel", j());
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("item_id", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("alg", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("scm", str4);
            }
            hashMap.put("card_type", str5);
            if (!TextUtils.isEmpty(str6)) {
                hashMap.put("card_id", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                hashMap.put("discount_type", str7);
            }
            ExposureDog h = DogCat.INSTANCE.h(view);
            h.w(str, h() + i).r(hashMap).k();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654249095")) {
            ipChange.ipc$dispatch("1654249095", new Object[]{this, str, str2, str3, str4, str5, str6, Integer.valueOf(i)});
            return;
        }
        n(str, str2, str3, str4, str5, str6, i, "");
    }

    public void n(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280373615")) {
            ipChange.ipc$dispatch("-1280373615", new Object[]{this, str, str2, str3, str4, str5, str6, Integer.valueOf(i), str7});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", d20.d() + "市");
        hashMap.put("titlelabel", j());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("alg", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("scm", str4);
        }
        hashMap.put("card_type", str5);
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("card_id", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("discount_type", str7);
        }
        if (!TextUtils.isEmpty(d20.E())) {
            hashMap.put("usercode", d20.E());
        }
        ClickCat d2 = DogCat.INSTANCE.d();
        d2.r(str, h() + i).o(hashMap).m(true).j();
    }

    public void o(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062512044")) {
            ipChange.ipc$dispatch("-1062512044", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b = i;
    }

    public void p(List<RichTitle> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583349310")) {
            ipChange.ipc$dispatch("1583349310", new Object[]{this, list});
            return;
        }
        this.c = list;
    }
}
