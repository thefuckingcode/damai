package tb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.discover.bean.IFeedProjectBean;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class dx0 implements OnItemBindListener<IFeedProjectBean<WaterFlowRecommendItem>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Context a;
    private String b;
    private int c;

    public dx0(Context context) {
        this.a = context;
    }

    /* renamed from: a */
    public void exposeItem(View view, IFeedProjectBean<WaterFlowRecommendItem> iFeedProjectBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1697038107")) {
            ipChange.ipc$dispatch("1697038107", new Object[]{this, view, iFeedProjectBean, Integer.valueOf(i)});
            return;
        }
        WaterFlowRecommendItem raw = iFeedProjectBean.getRaw();
        if (raw != null) {
            String str = null;
            MarketTagBean gotTopTag = raw.gotTopTag(true);
            if (gotTopTag != null) {
                str = gotTopTag.type;
            }
            gw0 i2 = gw0.i();
            String str2 = this.b;
            String str3 = raw.projectId;
            i2.l(str2, view, str3, raw.alg, raw.scm, raw.cardType, str3, this.c, str);
        }
    }

    /* renamed from: b */
    public void onItemClick(IFeedProjectBean<WaterFlowRecommendItem> iFeedProjectBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618482576")) {
            ipChange.ipc$dispatch("1618482576", new Object[]{this, iFeedProjectBean, Integer.valueOf(i)});
            return;
        }
        WaterFlowRecommendItem raw = iFeedProjectBean.getRaw();
        if (raw != null && this.a != null) {
            String str = null;
            MarketTagBean gotTopTag = raw.gotTopTag(true);
            if (gotTopTag != null) {
                str = gotTopTag.type;
            }
            gw0 i2 = gw0.i();
            String str2 = this.b;
            String str3 = raw.projectId;
            i2.n(str2, str3, raw.alg, raw.scm, raw.cardType, str3, this.c, str);
            if (xf2.j(raw.schema)) {
                Bundle bundle = new Bundle();
                bundle.putString("from_page", "homepage");
                bundle.putString("projectImage", raw.projectPic);
                bundle.putString("id", raw.projectId);
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(gr.b));
                return;
            }
            DMNav.from(this.a).toUri(raw.schema);
        }
    }

    public void c(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362210690")) {
            ipChange.ipc$dispatch("-362210690", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        this.b = str;
        this.c = i;
    }
}
