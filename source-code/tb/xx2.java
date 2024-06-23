package tb;

import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.app.widget.WantSeeGuideDialog;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.homepage.util.window.WantSeeActionBean;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.wantsee.GuideUtHelper;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class xx2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static final class a implements GuideUtHelper {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ sq2 a;
        final /* synthetic */ xx2 b;
        final /* synthetic */ String c;
        final /* synthetic */ Map<String, JSONObject> d;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX WARN: Multi-variable type inference failed */
        a(sq2 sq2, xx2 xx2, String str, Map<String, ? extends JSONObject> map) {
            this.a = sq2;
            this.b = xx2;
            this.c = str;
            this.d = map;
        }

        @Override // cn.damai.wantsee.GuideUtHelper
        public void cancelUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "244077597")) {
                ipChange.ipc$dispatch("244077597", new Object[]{this});
                return;
            }
            this.a.closeUt(this.b.b(this.c), this.d);
        }

        @Override // cn.damai.wantsee.GuideUtHelper
        public void confirmUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1466346571")) {
                ipChange.ipc$dispatch("-1466346571", new Object[]{this});
                return;
            }
            this.a.confirmUt(this.b.b(this.c), this.d);
        }

        @Override // cn.damai.wantsee.GuideUtHelper
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-971699372")) {
                ipChange.ipc$dispatch("-971699372", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.a.exposureUt(j, this.b.b(this.c), this.d);
        }
    }

    /* compiled from: Taobao */
    public static final class b implements WantSeeGuideDialog.WantGuidePageSource {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeActionBean a;

        b(WantSeeActionBean wantSeeActionBean) {
            this.a = wantSeeActionBean;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String getButtonName() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "372219360")) {
                return (String) ipChange.ipc$dispatch("372219360", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean == null) {
                return "";
            }
            String str = wantSeeActionBean.buttonName;
            k21.h(str, "it.buttonName");
            return str;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String getSubTitle() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "758955899")) {
                return (String) ipChange.ipc$dispatch("758955899", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean == null) {
                return "";
            }
            String str = wantSeeActionBean.subTitleOpenNotify;
            k21.h(str, "it.subTitleOpenNotify");
            return str;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String getTitle() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-561826453")) {
                return (String) ipChange.ipc$dispatch("-561826453", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean == null) {
                return "";
            }
            String str = wantSeeActionBean.title;
            k21.h(str, "it.title");
            return str;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String lottieUrl() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2008453411")) {
                return (String) ipChange.ipc$dispatch("-2008453411", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean == null) {
                return "";
            }
            String str = wantSeeActionBean.lottie;
            k21.h(str, "it.lottie");
            return str;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String schema() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1606227050")) {
                return (String) ipChange.ipc$dispatch("1606227050", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean == null) {
                return "";
            }
            String str = wantSeeActionBean.jumpUrl;
            k21.h(str, "it.jumpUrl");
            return str;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final HashMap<String, String> b(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "36635627")) {
            return (HashMap) ipChange.ipc$dispatch("36635627", new Object[]{this, str});
        }
        HashMap<String, String> f = a03.f();
        if (str != null && !(o.y(str))) {
            z = false;
        }
        if (!z) {
            k21.h(f, "map");
            f.put("item_id", str);
        }
        return f;
    }

    public final boolean c(@NotNull BaseActivity<?, ?> baseActivity, @NotNull String str, @NotNull WantSeeTips wantSeeTips, @NotNull WantSeePosterTips wantSeePosterTips) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153885446")) {
            return ((Boolean) ipChange.ipc$dispatch("-153885446", new Object[]{this, baseActivity, str, wantSeeTips, wantSeePosterTips})).booleanValue();
        }
        k21.i(baseActivity, "activity");
        k21.i(str, "id");
        k21.i(wantSeeTips, "wantSeeTips");
        k21.i(wantSeePosterTips, "wantSeeProjectTips");
        ArrayList<PopupDetailBean> k = kr1.Companion.a().k(baseActivity);
        sq2 sq2 = new sq2(baseActivity);
        if (k != null && k.size() > 0) {
            Iterator<PopupDetailBean> it = k.iterator();
            Map map = null;
            PopupDetailBean popupDetailBean = null;
            PopupDetailBean popupDetailBean2 = null;
            while (it.hasNext()) {
                PopupDetailBean next = it.next();
                if (k21.d("wantSeeFirst", next.eventType)) {
                    popupDetailBean = next;
                } else if (k21.d("wantSeeNonFirst", next.eventType)) {
                    popupDetailBean2 = next;
                }
                if (popupDetailBean != null && popupDetailBean2 != null) {
                    break;
                }
            }
            if (!(popupDetailBean == null || popupDetailBean2 == null)) {
                PopupDetailBean.PopupItem popupItem = popupDetailBean.item;
                WantSeeActionBean wantSeeActionBean = (WantSeeActionBean) s41.d(popupItem != null ? popupItem.value : null, WantSeeActionBean.class);
                PopupDetailBean.PopupItem popupItem2 = popupDetailBean2.item;
                WantSeeActionBean wantSeeActionBean2 = (WantSeeActionBean) s41.d(popupItem2 != null ? popupItem2.value : null, WantSeeActionBean.class);
                PopupDetailBean.PopupItem popupItem3 = popupDetailBean.item;
                Object obj = (popupItem3 == null || (jSONObject = popupItem3.value) == null) ? null : jSONObject.get("action");
                if (obj instanceof Map) {
                    map = (Map) obj;
                }
                if (!cy2.INSTANCE.d(baseActivity, new a(sq2, this, str, map), new b(wantSeeActionBean)) && wantSeePosterTips.getVisibility() == 8) {
                    if (wantSeeActionBean2 != null) {
                        WantSeeTips.a.b bVar = WantSeeTips.a.b.INSTANCE;
                        bVar.p(wantSeeActionBean2.title);
                        bVar.o(PermissionsHelper.a(AppInfoProviderProxy.getAppContext()) ? wantSeeActionBean2.subTitleOpenNotify : wantSeeActionBean2.subTitleUnOpenNotify);
                        bVar.m(wantSeeActionBean2.lottie);
                        bVar.n(wantSeeActionBean2.jumpUrl);
                    }
                    wantSeeTips.setPageSource(WantSeeTips.a.b.INSTANCE);
                    wantSeeTips.showAnim();
                }
                return true;
            }
        }
        return false;
    }
}
