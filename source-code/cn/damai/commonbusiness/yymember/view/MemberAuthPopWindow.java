package cn.damai.commonbusiness.yymember.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.yymember.bean.AuthOnekeybindInfo;
import cn.damai.commonbusiness.yymember.bean.MemberAuthBean;
import cn.damai.commonbusiness.yymember.request.YYMemberAuthRequest;
import cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g03;
import tb.hc1;
import tb.ic1;
import tb.k21;
import tb.v;
import tb.yz2;

/* compiled from: Taobao */
public final class MemberAuthPopWindow extends PopupWindow {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity activity;
    @NotNull
    private final String authPPDmOnline = "https://pages.taopiaopiao.com/wh/fragment/taopiaopiao/default/mdmas?wh_biz=tm&wh_ttid=pc";
    @NotNull
    private final String authPPDmPre = "https://pre-wormhole.tmall.com/wh/fragment/taopiaopiao/default/mdmas";
    private long damaiShowEndTime;
    private long damaiShowStartTime;
    private MemberDamaiAuthView dmAuth;
    @Nullable
    private ICustomDialogEventListener eventListener;
    @NotNull
    private a handler = new a();
    private Context mContext;
    @NotNull
    private String pageSource = "AuthPopWindow";
    @NotNull
    private MemberDamaiAuthView.IMemberPopEventListener popEventListener = new c(this);
    private View popView;
    private MemberDamaiAuthView ppAuth;
    private long tppShowEndTime;
    private long tppShowStartTime;
    private View viewParent;

    /* compiled from: Taobao */
    public interface ICustomDialogEventListener {
        void dialogItemEvent(@Nullable String str);
    }

    /* compiled from: Taobao */
    public final class a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public void dispatchMessage(@NotNull Message message) {
            String str;
            MemberAuthBean memberAuthBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-301249068")) {
                ipChange.ipc$dispatch("-301249068", new Object[]{this, message});
                return;
            }
            k21.i(message, "msg");
            super.dispatchMessage(message);
            Activity activity = MemberAuthPopWindow.this.activity;
            MemberDamaiAuthView memberDamaiAuthView = null;
            if (activity == null) {
                k21.A("activity");
                activity = null;
            }
            DamaiBaseActivity damaiBaseActivity = activity instanceof DamaiBaseActivity ? (DamaiBaseActivity) activity : null;
            if (damaiBaseActivity != null) {
                damaiBaseActivity.stopProgressDialog();
            }
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj != null) {
                    k21.g(obj, "null cannot be cast to non-null type kotlin.String");
                    str = (String) obj;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    ToastUtil.i("麦麦开小差了，请稍后重试哦");
                    MemberAuthPopWindow.this.dismiss();
                    yz2.a("", "-7103", "会员授权请求cdn失败-返回null");
                    return;
                }
                try {
                    memberAuthBean = (MemberAuthBean) JSON.parseObject(str, MemberAuthBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    memberAuthBean = null;
                }
                if ((memberAuthBean != null ? memberAuthBean.quickAuthModal : null) != null) {
                    MemberAuthBean.QuickAuthModel quickAuthModel = memberAuthBean.quickAuthModal;
                    if (!(quickAuthModel.dmToTpp == null || quickAuthModel.tppToDm == null)) {
                        MemberDamaiAuthView memberDamaiAuthView2 = MemberAuthPopWindow.this.dmAuth;
                        if (memberDamaiAuthView2 == null) {
                            k21.A("dmAuth");
                            memberDamaiAuthView2 = null;
                        }
                        memberDamaiAuthView2.setVisibility(0);
                        MemberAuthPopWindow.this.damaiShowStartTime = System.currentTimeMillis();
                        MemberAuthBean.AuthProtocol authProtocol = memberAuthBean.quickAuthModal.dmToTpp;
                        authProtocol.type = MemberDamaiAuthView.DM_AUTH;
                        authProtocol.pageSource = MemberAuthPopWindow.this.pageSource;
                        MemberAuthBean.AuthProtocol authProtocol2 = memberAuthBean.quickAuthModal.tppToDm;
                        authProtocol2.type = MemberDamaiAuthView.PP_AUTH;
                        authProtocol2.pageSource = MemberAuthPopWindow.this.pageSource;
                        MemberDamaiAuthView memberDamaiAuthView3 = MemberAuthPopWindow.this.dmAuth;
                        if (memberDamaiAuthView3 == null) {
                            k21.A("dmAuth");
                            memberDamaiAuthView3 = null;
                        }
                        MemberAuthBean.AuthProtocol authProtocol3 = memberAuthBean.quickAuthModal.dmToTpp;
                        k21.h(authProtocol3, "response.quickAuthModal.dmToTpp");
                        memberDamaiAuthView3.updateData(authProtocol3);
                        MemberDamaiAuthView memberDamaiAuthView4 = MemberAuthPopWindow.this.ppAuth;
                        if (memberDamaiAuthView4 == null) {
                            k21.A("ppAuth");
                        } else {
                            memberDamaiAuthView = memberDamaiAuthView4;
                        }
                        MemberAuthBean.AuthProtocol authProtocol4 = memberAuthBean.quickAuthModal.tppToDm;
                        k21.h(authProtocol4, "response.quickAuthModal.tppToDm");
                        memberDamaiAuthView.updateData(authProtocol4);
                        return;
                    }
                }
                ToastUtil.i("麦麦开小差了，请稍后重试哦");
                MemberAuthPopWindow.this.dismiss();
                yz2.a(str, "-7103", "会员授权请求cdn失败-json解析失败");
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MemberAuthPopWindow a;

        b(MemberAuthPopWindow memberAuthPopWindow) {
            this.a = memberAuthPopWindow;
        }

        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "72133308")) {
                ipChange.ipc$dispatch("72133308", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            this.a.callSuperDismiss();
        }

        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "927124280")) {
                ipChange.ipc$dispatch("927124280", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        }

        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-904167659")) {
                ipChange.ipc$dispatch("-904167659", new Object[]{this, animation});
                return;
            }
            k21.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        }
    }

    /* compiled from: Taobao */
    public static final class c implements MemberDamaiAuthView.IMemberPopEventListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MemberAuthPopWindow a;

        c(MemberAuthPopWindow memberAuthPopWindow) {
            this.a = memberAuthPopWindow;
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView.IMemberPopEventListener
        public void dmAgree() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "814206917")) {
                ipChange.ipc$dispatch("814206917", new Object[]{this});
                return;
            }
            this.a.damaiShowEndTime = System.currentTimeMillis();
            MemberDamaiAuthView memberDamaiAuthView = this.a.dmAuth;
            MemberDamaiAuthView memberDamaiAuthView2 = null;
            if (memberDamaiAuthView == null) {
                k21.A("dmAuth");
                memberDamaiAuthView = null;
            }
            memberDamaiAuthView.setVisibility(8);
            this.a.tppShowStartTime = System.currentTimeMillis();
            MemberDamaiAuthView memberDamaiAuthView3 = this.a.ppAuth;
            if (memberDamaiAuthView3 == null) {
                k21.A("ppAuth");
            } else {
                memberDamaiAuthView2 = memberDamaiAuthView3;
            }
            memberDamaiAuthView2.setVisibility(0);
            cn.damai.common.user.c.e().x(g03.Companion.a().h(this.a.pageSource, MemberDamaiAuthView.DM_AUTH_UT_MODULE, "agree"));
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView.IMemberPopEventListener
        public void popDismiss() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1277906473")) {
                ipChange.ipc$dispatch("1277906473", new Object[]{this});
                return;
            }
            this.a.dismiss();
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView.IMemberPopEventListener
        public void tppAgree() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1457289622")) {
                ipChange.ipc$dispatch("-1457289622", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(g03.Companion.a().h(this.a.pageSource, MemberDamaiAuthView.PP_AUTH_UT_MODULE, "confirm"));
            this.a.oneKeyAuthRequest();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberAuthPopWindow(@NotNull Context context, @NotNull View view, @NotNull Activity activity2) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(view, "viewParent");
        k21.i(activity2, "activity");
        init(context, view, activity2);
        initData();
        View view2 = this.popView;
        if (view2 == null) {
            k21.A("popView");
            view2 = null;
        }
        view2.setOnClickListener(new hc1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m18_init_$lambda0(MemberAuthPopWindow memberAuthPopWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624286912")) {
            ipChange.ipc$dispatch("624286912", new Object[]{memberAuthPopWindow, view});
            return;
        }
        k21.i(memberAuthPopWindow, "this$0");
        memberAuthPopWindow.dismiss();
    }

    private final void init(Context context, View view, Activity activity2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1122470710")) {
            ipChange.ipc$dispatch("-1122470710", new Object[]{this, context, view, activity2});
            return;
        }
        this.mContext = context;
        this.activity = activity2;
        this.viewParent = view;
        View view2 = null;
        View inflate = LayoutInflater.from(context).inflate(R$layout.commonbusiness_member_auth_pop_layout, (ViewGroup) null);
        k21.h(inflate, "from(context)\n          …er_auth_pop_layout, null)");
        this.popView = inflate;
        View findViewById = inflate.findViewById(R$id.member_damai_auth);
        k21.h(findViewById, "customView.findViewById(R.id.member_damai_auth)");
        this.dmAuth = (MemberDamaiAuthView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.member_taopiaopiao_auth);
        k21.h(findViewById2, "customView.findViewById(….member_taopiaopiao_auth)");
        this.ppAuth = (MemberDamaiAuthView) findViewById2;
        MemberDamaiAuthView memberDamaiAuthView = this.dmAuth;
        if (memberDamaiAuthView == null) {
            k21.A("dmAuth");
            memberDamaiAuthView = null;
        }
        memberDamaiAuthView.setPopEventListener(this.popEventListener);
        MemberDamaiAuthView memberDamaiAuthView2 = this.ppAuth;
        if (memberDamaiAuthView2 == null) {
            k21.A("ppAuth");
            memberDamaiAuthView2 = null;
        }
        memberDamaiAuthView2.setPopEventListener(this.popEventListener);
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99000000")));
        View view3 = this.popView;
        if (view3 == null) {
            k21.A("popView");
        } else {
            view2 = view3;
        }
        setContentView(view2);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setWidth(-1);
        setHeight(-1);
    }

    private final void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1098811420")) {
            ipChange.ipc$dispatch("-1098811420", new Object[]{this});
            return;
        }
        Activity activity2 = this.activity;
        DamaiBaseActivity damaiBaseActivity = null;
        if (activity2 == null) {
            k21.A("activity");
            activity2 = null;
        }
        if (activity2 instanceof DamaiBaseActivity) {
            damaiBaseActivity = (DamaiBaseActivity) activity2;
        }
        if (damaiBaseActivity != null) {
            damaiBaseActivity.startProgressDialog();
        }
        new Thread(new ic1(new cn.damai.tetris.page.a(), AppConfig.g() == AppConfig.EnvMode.prepare ? this.authPPDmPre : this.authPPDmOnline, this)).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-2  reason: not valid java name */
    public static final void m19initData$lambda2(cn.damai.tetris.page.a aVar, String str, MemberAuthPopWindow memberAuthPopWindow) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289105580")) {
            ipChange.ipc$dispatch("-1289105580", new Object[]{aVar, str, memberAuthPopWindow});
            return;
        }
        k21.i(aVar, "$cdnRequestUtil");
        k21.i(str, "$url");
        k21.i(memberAuthPopWindow, "this$0");
        Message message = new Message();
        message.what = 1;
        message.obj = aVar.b(str);
        memberAuthPopWindow.handler.sendMessage(message);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void oneKeyAuthRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598465186")) {
            ipChange.ipc$dispatch("-1598465186", new Object[]{this});
            return;
        }
        YYMemberAuthRequest yYMemberAuthRequest = new YYMemberAuthRequest();
        Activity activity2 = this.activity;
        DamaiBaseActivity damaiBaseActivity = null;
        if (activity2 == null) {
            k21.A("activity");
            activity2 = null;
        }
        if (activity2 instanceof DamaiBaseActivity) {
            damaiBaseActivity = (DamaiBaseActivity) activity2;
        }
        if (damaiBaseActivity != null) {
            damaiBaseActivity.startProgressDialog();
        }
        yYMemberAuthRequest.request(new MemberAuthPopWindow$oneKeyAuthRequest$2(this, AuthOnekeybindInfo.class));
    }

    public final void callSuperDismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462619439")) {
            ipChange.ipc$dispatch("-1462619439", new Object[]{this});
            return;
        }
        super.dismiss();
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861615102")) {
            ipChange.ipc$dispatch("-861615102", new Object[]{this});
            return;
        }
        MemberDamaiAuthView memberDamaiAuthView = this.ppAuth;
        View view = null;
        if (memberDamaiAuthView == null) {
            k21.A("ppAuth");
            memberDamaiAuthView = null;
        }
        if (memberDamaiAuthView.getVisibility() == 0) {
            this.tppShowEndTime = System.currentTimeMillis();
            g03.a aVar = g03.Companion;
            aVar.a().g(this.pageSource, this.damaiShowStartTime, this.damaiShowEndTime, MemberDamaiAuthView.DM_AUTH_UT_MODULE, "agree");
            aVar.a().g(this.pageSource, this.tppShowStartTime, this.tppShowEndTime, MemberDamaiAuthView.PP_AUTH_UT_MODULE, "confirm");
        } else {
            this.damaiShowEndTime = System.currentTimeMillis();
            g03.Companion.a().g(this.pageSource, this.damaiShowStartTime, this.damaiShowEndTime, MemberDamaiAuthView.DM_AUTH_UT_MODULE, "agree");
        }
        ICustomDialogEventListener iCustomDialogEventListener = this.eventListener;
        if (iCustomDialogEventListener != null) {
            iCustomDialogEventListener.dialogItemEvent("dismiss");
        }
        if (Build.VERSION.SDK_INT == 16) {
            callSuperDismiss();
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            k21.A("mContext");
            context = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R$anim.push_top_out_500);
        loadAnimation.setAnimationListener(new b(this));
        View view2 = this.popView;
        if (view2 == null) {
            k21.A("popView");
        } else {
            view = view2;
        }
        view.startAnimation(loadAnimation);
    }

    public final void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042648593")) {
            ipChange.ipc$dispatch("1042648593", new Object[]{this});
            return;
        }
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void setEventListener(@Nullable ICustomDialogEventListener iCustomDialogEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1964405650")) {
            ipChange.ipc$dispatch("1964405650", new Object[]{this, iCustomDialogEventListener});
            return;
        }
        this.eventListener = iCustomDialogEventListener;
    }

    public final void setPageSource(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410525258")) {
            ipChange.ipc$dispatch("410525258", new Object[]{this, str});
            return;
        }
        k21.i(str, "pageSourceName");
        this.pageSource = str;
    }

    public final void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881197727")) {
            ipChange.ipc$dispatch("-1881197727", new Object[]{this});
            return;
        }
        View view = this.viewParent;
        View view2 = null;
        if (view == null) {
            k21.A("viewParent");
            view = null;
        }
        showAtLocation(view, 80, 0, 0);
        Context context = this.mContext;
        if (context == null) {
            k21.A("mContext");
            context = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R$anim.push_bottom_out_500);
        View view3 = this.popView;
        if (view3 == null) {
            k21.A("popView");
        } else {
            view2 = view3;
        }
        view2.startAnimation(loadAnimation);
    }
}
