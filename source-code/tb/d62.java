package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.search.bean.IRankWordBean;
import cn.damai.search.bean.InputInfoProvider;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class d62 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_NAME = "search";
    private static d62 b = new d62();

    private d62() {
    }

    public static a.b f(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "763456872")) {
            return new a.b().a(d20.d()).e(str).i("search");
        }
        return (a.b) ipChange.ipc$dispatch("763456872", new Object[]{str});
    }

    public static void g(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837207600")) {
            ipChange.ipc$dispatch("837207600", new Object[]{view, str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("searchhistory", str);
        c e = c.e();
        e.G(view, "item_" + i, "searchhistory", "search", f);
    }

    public static void h(View view, IRankWordBean iRankWordBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "253508781")) {
            ipChange.ipc$dispatch("253508781", new Object[]{view, iRankWordBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        a03.h(f, "reason", iRankWordBean.getTag4Ut());
        a03.h(f, "wordtype", iRankWordBean.getType());
        a03.h(f, "trend", iRankWordBean.getTrend4Ut());
        a03.h(f, "hotword", iRankWordBean.getRankWord());
        c e = c.e();
        e.G(view, "hotword_" + i, "hotsearch_list", "search", f);
    }

    public static void i(View view, int i, String str, InputInfoProvider inputInfoProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437571245")) {
            ipChange.ipc$dispatch("-1437571245", new Object[]{view, Integer.valueOf(i), str, inputInfoProvider});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("contentlabel", str);
        if (inputInfoProvider != null) {
            f.put("keyword", inputInfoProvider.getInput());
            f.put("type", inputInfoProvider.getType4Ut());
        }
        c e = c.e();
        e.G(view, "tab_" + i, "top", "search", f);
    }

    public static Map<String, String> j(Map<String, String> map, NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128371895")) {
            return (Map) ipChange.ipc$dispatch("-2128371895", new Object[]{map, noteBean});
        }
        HashMap hashMap = new HashMap();
        if (!f92.f(map)) {
            hashMap.putAll(map);
        }
        hashMap.put("content_id", noteBean.id);
        hashMap.put("content_type", "0");
        a03.h(hashMap, "publiser_id", noteBean.getPublishUserId());
        return hashMap;
    }

    public static Map<String, String> k(Map<String, String> map, ProjectItemBean projectItemBean, int i) {
        MarketTagBean gotTopTag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592253836")) {
            return (Map) ipChange.ipc$dispatch("-592253836", new Object[]{map, projectItemBean, Integer.valueOf(i)});
        }
        HashMap<String, String> d = a03.d();
        f92.i(d, map);
        if (!(projectItemBean == null || (gotTopTag = projectItemBean.gotTopTag(true)) == null || TextUtils.isEmpty(gotTopTag.type))) {
            d.put("discount_type", gotTopTag.type);
        }
        d.put("item_id", projectItemBean.id);
        d.put("contentlabel", projectItemBean.name);
        return d;
    }

    public static void l(InputInfoProvider inputInfoProvider, String str, int i, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "154179718")) {
            ipChange.ipc$dispatch("154179718", new Object[]{inputInfoProvider, str, Integer.valueOf(i), map});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("keyword", inputInfoProvider.getInput());
        f.put("contentlabel", str);
        f.put("type", inputInfoProvider.getType4Ut());
        if (!f92.f(map)) {
            f.putAll(map);
        }
        d62 d62 = b;
        c.e().x(d62.e("search", "top", "item_" + i, f, Boolean.TRUE));
    }

    public static void m(InputInfoProvider inputInfoProvider, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-441488208")) {
            ipChange.ipc$dispatch("-441488208", new Object[]{inputInfoProvider, map});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("keyword", inputInfoProvider.getInput());
        f.put("titlelabel", inputInfoProvider.getInput());
        if (map != null) {
            f.putAll(map);
        }
        c.e().x(b.e("search", "suggestion", "item_0", f, Boolean.TRUE));
    }

    public static void n(ProjectItemBean projectItemBean, InputInfoProvider inputInfoProvider, int i, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259208060")) {
            ipChange.ipc$dispatch("1259208060", new Object[]{projectItemBean, inputInfoProvider, Integer.valueOf(i), map});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("keyword", inputInfoProvider.getInput());
        f.put("type", inputInfoProvider.getType4Ut());
        f.put("item_id", projectItemBean.id);
        if (!f92.f(map)) {
            f.putAll(map);
        }
        d62 d62 = b;
        c.e().x(d62.e("search", "list", "item_" + i, f, Boolean.TRUE));
    }

    public static void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-876750964")) {
            ipChange.ipc$dispatch("-876750964", new Object[0]);
            return;
        }
        c.e().x(b.e("search", "clearhistory", Constants.TAG_CLEAR_STRING, a03.f(), Boolean.FALSE));
    }

    public static void p(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208558516")) {
            ipChange.ipc$dispatch("1208558516", new Object[]{str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("searchhistory", str);
        d62 d62 = b;
        c.e().x(d62.e("search", "searchhistory", "item_" + i, f, Boolean.FALSE));
    }

    public static void q(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797879778")) {
            ipChange.ipc$dispatch("-797879778", new Object[]{str});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", str);
        c.e().x(b.e("search", "cleartext", Constants.TAG_CLEAR_STRING, f, Boolean.FALSE));
    }

    public static void r(IRankWordBean iRankWordBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672979337")) {
            ipChange.ipc$dispatch("1672979337", new Object[]{iRankWordBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("hotword", iRankWordBean.getRankWord());
        a03.h(f, "reason", iRankWordBean.getTag4Ut());
        f.put("wordtype", iRankWordBean.getType());
        f.put("trend", iRankWordBean.getTrend4Ut());
        d62 d62 = b;
        c.e().x(d62.e("search", "hotsearch_list", "hotword_" + i, f, Boolean.TRUE));
    }

    public static void s(InputInfoProvider inputInfoProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528617774")) {
            ipChange.ipc$dispatch("-1528617774", new Object[]{inputInfoProvider});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("keyword", inputInfoProvider.getInput());
        f.put("type", inputInfoProvider.getType4Ut());
        c.e().x(b.e("search", "top", "searchbtn", f, Boolean.FALSE));
    }

    public static void t(InputInfoProvider inputInfoProvider, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667056351")) {
            ipChange.ipc$dispatch("1667056351", new Object[]{inputInfoProvider, str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("keyword", inputInfoProvider.getInput());
        f.put("titlelabel", str);
        d62 d62 = b;
        c.e().x(d62.e("search", "suggestion", "item_" + i, f, Boolean.FALSE));
    }
}
