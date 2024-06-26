package cn.damai.user.ipdrama;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.message.observer.Action;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.tetris.core.msg.Message;
import cn.damai.uikit.view.SimpleTitleLayout;
import cn.damai.user.bean.ShareBean;
import cn.damai.user.ipdrama.IpDramaFragment;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cr;
import tb.p21;
import tb.xs0;

/* compiled from: Taobao */
public class IpDramaActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRAND_STATE_CHANGED = "brand_state_changed";
    private static final String IP_DRAMA_WANT_SEE_TIPS_CLICK = "ip_drama_want_see_tips_click";
    private static final String IP_DRAMA_WANT_SEE_TIPS_SHOW = "ip_drama_want_see_tips_show";
    private final String TAG = "IpDramaActivity";
    Action action;
    IpDramaFragment fragment;
    private ViewGroup mRootView;
    private ShareBean mShareBean;
    private SimpleTitleLayout mStlLayout;
    private WantSeeTips wantSeeTips;
    Action wantSeeTipsClickAction;
    Action wantSeeTipsShowAction;

    /* compiled from: Taobao */
    public class a implements IpDramaFragment.OnAlphaChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.user.ipdrama.IpDramaFragment.OnAlphaChangeListener
        public void onAlphaChaged(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736898176")) {
                ipChange.ipc$dispatch("-1736898176", new Object[]{this, Float.valueOf(f)});
                return;
            }
            IpDramaActivity.this.mStlLayout.setAlpha(f);
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<Bundle> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void call(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-417437200")) {
                ipChange.ipc$dispatch("-417437200", new Object[]{this, bundle});
            } else if (IpDramaActivity.this.fragment != null) {
                IpDramaActivity.this.fragment.sendMsg(new Message(10241, bundle));
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1923680849")) {
                ipChange.ipc$dispatch("-1923680849", new Object[]{this, str});
            } else if (IpDramaActivity.this.wantSeeTips != null) {
                WantSeeTips.a.d dVar = WantSeeTips.a.d.INSTANCE;
                dVar.l(str);
                IpDramaActivity.this.wantSeeTips.setPageSource(dVar);
                IpDramaActivity.this.wantSeeTips.showAnim();
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1230579152")) {
                ipChange.ipc$dispatch("-1230579152", new Object[]{this, str});
            } else if (IpDramaActivity.this.fragment != null) {
                IpDramaActivity.this.fragment.sendMsg(new Message(10245, str));
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-419694557")) {
                ipChange.ipc$dispatch("-419694557", new Object[]{this});
                return;
            }
            IpDramaActivity.this.finish();
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1072608925")) {
                ipChange.ipc$dispatch("1072608925", new Object[]{this});
                return;
            }
            IpDramaActivity.this.dispatchShareClick();
        }
    }

    /* compiled from: Taobao */
    public class f implements ShareBean.OnShareListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.user.bean.ShareBean.OnShareListener
        public void openShareView(Bundle bundle, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "83619476")) {
                ipChange.ipc$dispatch("83619476", new Object[]{this, bundle, str});
            } else if (!IpDramaActivity.this.isFinishing()) {
                ShareManager E = ShareManager.E();
                IpDramaActivity ipDramaActivity = IpDramaActivity.this;
                E.T(ipDramaActivity, bundle, ipDramaActivity.mRootView);
                E.e0(ShareManager.E().F(IpDramaActivity.this.mContext, 1, str, 1));
                E.l0();
            }
        }

        @Override // cn.damai.user.bean.ShareBean.OnShareListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "483896335")) {
                ipChange.ipc$dispatch("483896335", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                IpDramaActivity.this.startProgressDialog();
            } else {
                IpDramaActivity.this.stopProgressDialog();
            }
        }

        @Override // cn.damai.user.bean.ShareBean.OnShareListener
        public void toast(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1665908857")) {
                ipChange.ipc$dispatch("-1665908857", new Object[]{this, str});
                return;
            }
            ToastUtil.a().j(xs0.a(), str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchShareClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219570415")) {
            ipChange.ipc$dispatch("-1219570415", new Object[]{this});
        } else if (this.mShareBean != null && !isFinishing()) {
            ShareBean.doIpDramaShare(this.mShareBean, new f());
        }
    }

    private void setUpTitleLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121769521")) {
            ipChange.ipc$dispatch("-2121769521", new Object[]{this});
            return;
        }
        this.mStlLayout.setAlpha(0.0f);
        this.mStlLayout.enableImmersiveMode(this);
        this.mStlLayout.enableDivider(false);
        this.mStlLayout.showShareBtn(true);
        this.mStlLayout.setTitleGravity(3);
        this.mStlLayout.setListener(new e());
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1526483570")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1526483570", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169922533")) {
            ipChange.ipc$dispatch("-1169922533", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_layout_ipdrama);
        cn.damai.common.user.c.e().K(this);
        this.mStlLayout = (SimpleTitleLayout) findViewById(R$id.simple_title_layout);
        this.mRootView = (ViewGroup) findViewById(R$id.ip_drama_root);
        this.wantSeeTips = (WantSeeTips) findViewById(R$id.want_see_tips_ip_drama);
        setUpTitleLayout();
        hideBaseLayout();
        String str = null;
        if (getIntent() != null) {
            str = getIntent().getStringExtra("id");
            if (TextUtils.isEmpty(str)) {
                str = getIntent().getStringExtra(RepertoireDetailFragment.REPERTOIREID);
            }
            if (TextUtils.isEmpty(str)) {
                str = getIntent().getStringExtra(p21.ISSUE_PARAM_IPID);
            }
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("IpDramaActivity", " ipdrama id is null");
            finish();
        }
        IpDramaFragment newInstance = IpDramaFragment.newInstance(str);
        this.fragment = newInstance;
        newInstance.setOnAlphaChangeListener(new a());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.fragment_container, this.fragment);
        beginTransaction.commitAllowingStateLoss();
        this.action = new b();
        cr.c().e("brand_state_changed", this.action);
        this.wantSeeTipsShowAction = new c();
        cr.c().e(IP_DRAMA_WANT_SEE_TIPS_SHOW, this.wantSeeTipsShowAction);
        this.wantSeeTipsClickAction = new d();
        cr.c().e(IP_DRAMA_WANT_SEE_TIPS_CLICK, this.wantSeeTipsClickAction);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600981531")) {
            ipChange.ipc$dispatch("600981531", new Object[]{this});
            return;
        }
        cr.c().a("brand_state_changed", this.action);
        cr.c().a(IP_DRAMA_WANT_SEE_TIPS_SHOW, this.wantSeeTipsShowAction);
        cr.c().a(IP_DRAMA_WANT_SEE_TIPS_CLICK, this.wantSeeTipsClickAction);
        super.onDestroy();
    }

    public void setShareBean(@Nullable ShareBean shareBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053364989")) {
            ipChange.ipc$dispatch("2053364989", new Object[]{this, shareBean});
            return;
        }
        this.mShareBean = shareBean;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1313459074")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1313459074", new Object[]{this});
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531640104")) {
            ipChange.ipc$dispatch("531640104", new Object[]{this, str});
            return;
        }
        SimpleTitleLayout simpleTitleLayout = this.mStlLayout;
        if (simpleTitleLayout != null) {
            simpleTitleLayout.setTitle(str);
        }
    }
}
