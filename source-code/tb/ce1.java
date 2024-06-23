package tb;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.mine.activity.CustomersActivity;
import cn.damai.mine.bean.UserCenterDynamicMenu;
import cn.damai.mine.userinfo.help.MineUserCenterBadeListener;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.ali.user.mobile.rpc.ApiConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class ce1 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private MineUserCenterBadeListener c;
    private LinearLayout d;
    private LinearLayout e;
    private RelativeLayout f;
    private TextView g;
    private FrameLayout h;
    private RelativeLayout i;
    private TextView j;
    private FrameLayout k;
    private FlowLayout l;
    private View m;
    private TextView n;
    private DMIconFontTextView o;
    private UserCenterDynamicMenu p;
    private boolean q = true;
    private View.OnClickListener r = new a();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1461630806")) {
                ipChange.ipc$dispatch("-1461630806", new Object[]{this, view});
            } else if (ce1.this.a != null && !ce1.this.a.isFinishing() && (view.getTag() instanceof UserCenterDynamicMenu.DynamicMenuItem)) {
                UserCenterDynamicMenu.DynamicMenuItem dynamicMenuItem = (UserCenterDynamicMenu.DynamicMenuItem) view.getTag();
                ce1.this.o(dynamicMenuItem);
                if (dynamicMenuItem == null) {
                    return;
                }
                if (!ce1.this.n(dynamicMenuItem.getTitle())) {
                    String targetUrl = dynamicMenuItem.getTargetUrl();
                    if (!TextUtils.isEmpty(targetUrl)) {
                        DMNav.from(ce1.this.a).toUri(targetUrl);
                    }
                } else if (LoginManager.k().q()) {
                    AliMeUtil.k(ce1.this.a, AliMeUtil.FROM_MINE);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("from", 1);
                    DMNav.from(ce1.this.a).withExtras(bundle).toUri(gr.f());
                }
            }
        }
    }

    public ce1(Activity activity, View view) {
        this.a = activity;
        this.b = view.findViewById(R$id.ll_mine_service_container);
        k();
        j();
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883431112")) {
            ipChange.ipc$dispatch("883431112", new Object[]{this});
            return;
        }
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.b.findViewById(R$id.ll_mine_common_orderlist).setOnClickListener(this);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369912503")) {
            ipChange.ipc$dispatch("369912503", new Object[]{this});
            return;
        }
        this.d = (LinearLayout) this.b.findViewById(R$id.ll_mine_common_purchase);
        this.e = (LinearLayout) this.b.findViewById(R$id.ll_mine_user_center_address);
        this.f = (RelativeLayout) this.b.findViewById(R$id.ll_mine_evaluate);
        this.g = (TextView) this.b.findViewById(R$id.tv_mine_evaluated_count);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R$id.fl_mine_evaluated_badge);
        this.h = frameLayout;
        frameLayout.setVisibility(8);
        this.i = (RelativeLayout) this.b.findViewById(R$id.ll_mine_coupon);
        this.j = (TextView) this.b.findViewById(R$id.tv_mine_coupon_count);
        FrameLayout frameLayout2 = (FrameLayout) this.b.findViewById(R$id.fl_mine_coupon_badge);
        this.k = frameLayout2;
        frameLayout2.setVisibility(8);
        FlowLayout flowLayout = (FlowLayout) this.b.findViewById(R$id.fl_dynamic_menu_layout_container);
        this.l = flowLayout;
        flowLayout.setVisibility(8);
        this.m = this.b.findViewById(R$id.ll_extend_state);
        this.n = (TextView) this.b.findViewById(R$id.tv_extend_state);
        this.o = (DMIconFontTextView) this.b.findViewById(R$id.tv_extend_arrow);
        this.m.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean n(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-907710418")) {
            return !TextUtils.isEmpty(str) && str.contains("客服");
        }
        return ((Boolean) ipChange.ipc$dispatch("-907710418", new Object[]{this, str})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(UserCenterDynamicMenu.DynamicMenuItem dynamicMenuItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776485660")) {
            ipChange.ipc$dispatch("-776485660", new Object[]{this, dynamicMenuItem});
        } else if (dynamicMenuItem != null && this.p != null) {
            String targetUrl = dynamicMenuItem.getTargetUrl();
            try {
                Uri parse = Uri.parse(targetUrl);
                if (parse != null) {
                    String queryParameter = parse.getQueryParameter("scm");
                    List<UserCenterDynamicMenu.DynamicMenuItem> itemList = this.p.getItemList();
                    if (xf2.e(itemList) > 0) {
                        c.e().x(yd1.x().q(queryParameter, targetUrl, itemList.indexOf(dynamicMenuItem) + 4));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void p(String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262692096")) {
            ipChange.ipc$dispatch("-262692096", new Object[]{this, str, Integer.valueOf(i2)});
            return;
        }
        c.e().x(yd1.x().q("", str, i2));
    }

    private void r(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800400488")) {
            ipChange.ipc$dispatch("-800400488", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            wd1.a = wd1.c;
        } else {
            wd1.a = wd1.d;
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183823314")) {
            ipChange.ipc$dispatch("-1183823314", new Object[]{this});
        } else if (this.a != null) {
            String simpleName = CustomersActivity.class.getSimpleName();
            if (!LoginManager.k().q()) {
                Bundle bundle = new Bundle();
                bundle.putInt("from", 1);
                bundle.putString("activity_name", simpleName);
                DMNav.from(this.a).withExtras(bundle).toUri(gr.f());
                return;
            }
            DMNav.from(this.a).toUri(NavUri.b(gr.R));
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-589296428")) {
            ipChange.ipc$dispatch("-589296428", new Object[]{this});
        } else if (this.a != null) {
            if (!zd1.d()) {
                zd1.c(this.a);
            } else if ("1".equals(OrangeConfigCenter.c().b(ol1.b, "myCouponDowngrade", "0"))) {
                DMNav.from(this.a).toUri(gr.d());
            } else {
                DMNav.from(this.a).toUri("damai://V1/Flutter?flutter_path=dm_coupon_list&bizType=0");
            }
        }
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889938426")) {
            ipChange.ipc$dispatch("-889938426", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            zd1.c(this.a);
        } else if (this.a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("from_where", "damai");
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(gr.f));
        }
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401589864")) {
            ipChange.ipc$dispatch("-401589864", new Object[]{this});
        } else if (this.a != null) {
            Bundle bundle = new Bundle();
            if (zd1.d()) {
                bundle.putLong(ApiConstants.ApiField.MEMBER_ID, xf2.n(d20.E()));
                bundle.putString("type", "morenpeisong");
                DMNav.from(this.a).withExtras(bundle).toUri(gr.g());
                return;
            }
            bundle.putInt("from", 1);
            DMNav.from(this.a).withExtras(bundle).toUri(gr.f());
        }
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588772999")) {
            ipChange.ipc$dispatch("-1588772999", new Object[]{this});
        } else if (this.a != null) {
            if (zd1.d()) {
                DMNav.from(this.a).toUri(gr.l());
            } else {
                zd1.c(this.a);
            }
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677393238")) {
            ipChange.ipc$dispatch("1677393238", new Object[]{this});
            return;
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997817527")) {
            return ((Boolean) ipChange.ipc$dispatch("997817527", new Object[]{this})).booleanValue();
        }
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            return frameLayout.isShown();
        }
        return false;
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222285976")) {
            return ((Boolean) ipChange.ipc$dispatch("222285976", new Object[]{this})).booleanValue();
        }
        FrameLayout frameLayout = this.h;
        if (frameLayout != null) {
            return frameLayout.isShown();
        }
        return false;
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614664995")) {
            ipChange.ipc$dispatch("-614664995", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (R$id.ll_mine_common_orderlist == id) {
            p("damai://" + gr.f, 0);
            f();
        } else if (R$id.ll_mine_common_purchase == id) {
            p("damai://" + gr.R, 1);
            d();
        } else if (R$id.ll_mine_user_center_address == id) {
            p("damai://" + gr.g(), 2);
            g();
        } else if (R$id.ll_mine_evaluate == id) {
            MineUserCenterBadeListener mineUserCenterBadeListener = this.c;
            if (mineUserCenterBadeListener != null) {
                mineUserCenterBadeListener.markBadgeData("DM_USER_MY_EVALUATE");
            }
            p("damai://" + gr.l(), 3);
            h();
        } else if (R$id.ll_mine_coupon == id) {
            MineUserCenterBadeListener mineUserCenterBadeListener2 = this.c;
            if (mineUserCenterBadeListener2 != null) {
                mineUserCenterBadeListener2.markBadgeData("DM_USER_MY_COUPON");
            }
            p("damai://" + gr.d(), 4);
            e();
        } else if (R$id.ll_extend_state == id) {
            boolean z = !this.q;
            this.q = z;
            r(z);
            t();
            c.e().x(yd1.x().r());
        }
    }

    public void q(MineUserCenterBadeListener mineUserCenterBadeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212594103")) {
            ipChange.ipc$dispatch("1212594103", new Object[]{this, mineUserCenterBadeListener});
            return;
        }
        this.c = mineUserCenterBadeListener;
    }

    public void s(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925081219")) {
            ipChange.ipc$dispatch("925081219", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 <= 0) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
    }

    public void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "275313456")) {
            ipChange.ipc$dispatch("275313456", new Object[]{this});
        } else if (this.q) {
            this.l.setVisibility(8);
            this.n.setText("展开");
            Activity activity = this.a;
            if (activity != null) {
                this.o.setText(activity.getString(R$string.iconfont_xiangxiajiantou_));
            }
        } else {
            this.l.setVisibility(0);
            this.n.setText("收起");
            Activity activity2 = this.a;
            if (activity2 != null) {
                this.o.setText(activity2.getString(R$string.iconfont_xiangshangjiantou_));
            }
        }
    }

    public void u(UserCenterDynamicMenu userCenterDynamicMenu) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584348883")) {
            ipChange.ipc$dispatch("-584348883", new Object[]{this, userCenterDynamicMenu});
            return;
        }
        this.p = userCenterDynamicMenu;
        if (userCenterDynamicMenu == null || xf2.e(userCenterDynamicMenu.getItemList()) == 0 || this.a == null) {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            return;
        }
        if (wd1.a == wd1.c) {
            this.q = true;
        } else if (wd1.a == wd1.d) {
            this.q = false;
        } else {
            if (zd1.d()) {
                this.q = true;
            } else {
                this.q = false;
            }
            r(this.q);
        }
        this.l.removeAllViews();
        DisplayMetrics c2 = n42.c(this.a);
        List<UserCenterDynamicMenu.DynamicMenuItem> itemList = userCenterDynamicMenu.getItemList();
        int size = itemList.size();
        for (int i2 = 0; i2 < size; i2++) {
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(this.a, R$layout.layout_user_center_dynamic_menu, null);
            relativeLayout.setMinimumWidth(((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(c2) - v50.a(this.a, 50.0f)) - 1) / 5);
            UserCenterDynamicMenu.DynamicMenuItem dynamicMenuItem = itemList.get(i2);
            ((TextView) relativeLayout.findViewById(R$id.tv_title)).setText(dynamicMenuItem.getTitle());
            ImageView imageView = (ImageView) relativeLayout.findViewById(R$id.iv_icon);
            if (!TextUtils.isEmpty(dynamicMenuItem.getIconUrl())) {
                DMImageCreator c3 = cn.damai.common.image.a.b().c(dynamicMenuItem.getIconUrl());
                int i3 = R$drawable.user_center_dynamic_menu_bg;
                c3.i(i3).c(i3).g(imageView);
            } else {
                imageView.setImageResource(R$drawable.user_center_dynamic_menu_bg);
            }
            View findViewById = relativeLayout.findViewById(R$id.bubble_layout);
            TextView textView = (TextView) relativeLayout.findViewById(R$id.tv_dynamic_menu_item_tag);
            if (!TextUtils.isEmpty(dynamicMenuItem.getBubbleText())) {
                findViewById.setVisibility(0);
                textView.setText(dynamicMenuItem.getBubbleText());
            } else {
                findViewById.setVisibility(8);
            }
            relativeLayout.setTag(dynamicMenuItem);
            relativeLayout.setOnClickListener(this.r);
            this.l.addView(relativeLayout);
        }
        this.m.setVisibility(0);
        t();
    }

    public void v(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2077173688")) {
            ipChange.ipc$dispatch("2077173688", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        String a2 = zd1.a(i2);
        String a3 = zd1.a(i3);
        if (i2 <= 0 || TextUtils.isEmpty(a2)) {
            this.g.setVisibility(8);
            this.f.setTag("0");
        } else {
            this.g.setVisibility(0);
            this.g.setText(a2);
            this.f.setTag(String.valueOf(i2));
        }
        if (i3 <= 0 || TextUtils.isEmpty(a3)) {
            this.j.setVisibility(8);
            this.i.setTag("0");
            return;
        }
        this.j.setVisibility(0);
        this.j.setText(a3);
        this.i.setTag(String.valueOf(i3));
    }

    public void w(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454211952")) {
            ipChange.ipc$dispatch("454211952", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 <= 0) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
        }
    }
}
