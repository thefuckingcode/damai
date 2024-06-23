package cn.damai.ultron.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.live.LiveActivity;
import cn.damai.ultron.R$color;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.net.UltronPresenter;
import cn.damai.ultron.utils.DmBuildRequestCallBackImp;
import cn.damai.ultron.utils.DmUltronChooseListenerImpl;
import cn.damai.ultron.utils.DmUltronRequestErrorUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import tb.br;
import tb.ga0;
import tb.ha0;
import tb.ia0;
import tb.ma0;
import tb.ne2;
import tb.r90;
import tb.ub2;
import tb.w90;

/* compiled from: Taobao */
public class DmOrderActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DmBuildRequestCallBackImp callBackImp = new a();
    DmUltronChooseListenerImpl<String> closeTicketDetailListener = new c();
    public r90 dmErrorViewHolder;
    DmUltronPromotionFragment fragment;
    private br mDMMessage;
    private ga0 mDmTicketDetailView;
    InputMethodManager mInputMethodManager;
    private UltronPresenter mPresenter;
    private LinearLayout mTicketPopView;
    private View statusBar;

    /* compiled from: Taobao */
    public class a implements DmBuildRequestCallBackImp {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.ultron.utils.DmBuildRequestCallBackImp
        public void onError(String str, String str2, int i, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1361711008")) {
                ipChange.ipc$dispatch("-1361711008", new Object[]{this, str, str2, Integer.valueOf(i), str3});
                return;
            }
            if (i == 420) {
                str2 = "前方拥挤，亲稍等再试试";
            }
            DmUltronRequestErrorUtils.d().f(DmUltronRequestErrorUtils.BizType.BUILD).g(DmUltronRequestErrorUtils.DefaultError.ERROR_LAYOUT).h(DmUltronRequestErrorUtils.NetError.NO_NETWORK).a(DmOrderActivity.this, str, str2, str3);
        }

        @Override // cn.damai.ultron.utils.DmBuildRequestCallBackImp
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1879437026")) {
                ipChange.ipc$dispatch("-1879437026", new Object[]{this});
                return;
            }
            r90 r90 = DmOrderActivity.this.dmErrorViewHolder;
            if (r90 != null) {
                r90.d();
            }
            DmOrderActivity.this.updateTicketDetailData();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "217297850")) {
                ipChange.ipc$dispatch("217297850", new Object[]{this, view});
                return;
            }
            DmOrderActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class c implements DmUltronChooseListenerImpl<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void chooseItemListener(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-94626762")) {
                ipChange.ipc$dispatch("-94626762", new Object[]{this, str});
                return;
            }
            DmOrderActivity.this.mPresenter.getTradeEventHandler().h(DmOrderActivity.this.mPresenter.getTradeEventHandler().d().l(ia0.closePopUpEvent));
        }
    }

    private void InitUltronPresenter(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228549815")) {
            ipChange.ipc$dispatch("-228549815", new Object[]{this, bundle});
            return;
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        UltronPresenter ultronPresenter = new UltronPresenter(this, this.callBackImp);
        this.mPresenter = ultronPresenter;
        ultronPresenter.onCreate(bundle);
        this.mPresenter.initView(null, recyclerView, (LinearLayout) findViewById(R$id.bottom_layout));
        this.mPresenter.buildPage();
        br brVar = new br();
        this.mDMMessage = brVar;
        this.mPresenter.listenerNotify(brVar);
    }

    private void InputMethodHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587318466")) {
            ipChange.ipc$dispatch("587318466", new Object[]{this});
            return;
        }
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        }
        this.mInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    private void initBackEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-485419572")) {
            ipChange.ipc$dispatch("-485419572", new Object[]{this});
            return;
        }
        findViewById(R$id.tv_goback).setOnClickListener(new b());
    }

    private void initErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "718842034")) {
            ipChange.ipc$dispatch("718842034", new Object[]{this});
            return;
        }
        r90 r90 = new r90();
        this.dmErrorViewHolder = r90;
        r90.e((LinearLayout) findViewById(R$id.error_layout), this);
    }

    private void initStateBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281797623")) {
            ipChange.ipc$dispatch("-281797623", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar);
        this.statusBar = findViewById;
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                this.statusBar.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            ne2.e(this);
            return;
        }
        ne2.f(this, false, R$color.black);
        View view = this.statusBar;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void initTicketDetailView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417296119")) {
            ipChange.ipc$dispatch("-417296119", new Object[]{this});
            return;
        }
        this.mTicketPopView = (LinearLayout) findViewById(R$id.ll_popup);
        ga0 ga0 = new ga0();
        this.mDmTicketDetailView = ga0;
        ga0.d(this.mTicketPopView, this);
        this.mDmTicketDetailView.i(this.closeTicketDetailListener);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1813239641")) {
            return R$layout.activity_ultron;
        }
        return ((Integer) ipChange.ipc$dispatch("-1813239641", new Object[]{this})).intValue();
    }

    public UltronPresenter getPresenter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-530769864")) {
            return this.mPresenter;
        }
        return (UltronPresenter) ipChange.ipc$dispatch("-530769864", new Object[]{this});
    }

    public void hideProFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271890540")) {
            ipChange.ipc$dispatch("-1271890540", new Object[]{this});
        } else if (this.fragment == null) {
            findViewById(R$id.ll_promotion).setVisibility(8);
        } else {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            findViewById(R$id.ll_promotion).setVisibility(8);
            beginTransaction.remove(this.fragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IDMComponent a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1670987181")) {
            ipChange.ipc$dispatch("1670987181", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 36) {
            if (intent != null && (a2 = ha0.a(this.mPresenter)) != null) {
                this.mPresenter.getDataManager().respondToLinkage(a2);
            }
        } else if (i == 41) {
            if (i2 == -1) {
                this.mPresenter.getTradeEventHandler().h(this.mPresenter.getTradeEventHandler().d().l(ia0.switchDeliveryWayEvent).m("data", intent));
            }
        } else if (i == 48) {
            if (i2 == -1) {
                this.mPresenter.getTradeEventHandler().h(this.mPresenter.getTradeEventHandler().d().l(ia0.switchDataTypeEvent).m("pageType", ia0.PAGE_PHONE_CODE).m("data", intent));
            }
        } else if (i == 37) {
            if (intent != null) {
                this.mPresenter.getTradeEventHandler().h(this.mPresenter.getTradeEventHandler().d().l(ia0.switchDataTypeEvent).m("pageType", ia0.PAGE_ADDRESS_LIST).m("data", intent));
            }
        } else if (i == 49) {
            onSelectPromoBack(intent);
        } else if (i == 39) {
            this.mPresenter.getTradeEventHandler().h(this.mPresenter.getTradeEventHandler().d().l(ia0.switchDataTypeEvent).m("pageType", ia0.PAGE_READ_PHONE).m("data", intent));
        } else if (i == 38) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "142444340")) {
            ipChange.ipc$dispatch("142444340", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        hideBaseLayout();
        initStateBar();
        long j = 0;
        try {
            Intent intent = getIntent();
            if (intent != null) {
                j = intent.getLongExtra(LiveActivity.OPTION_DAMAI_ITEM_ID, 0);
                z = intent.getBooleanExtra("is_seat", false);
            }
            w90.g(this.mContext, j);
            w90.f(this.mContext, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDamaiUTKeyBuilder(ma0.u().r(j, z));
        cn.damai.common.user.c.e().K(this);
        InitUltronPresenter(bundle);
        initBackEvent();
        initErrorView();
        initTicketDetailView();
        ub2.c(j);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084480372")) {
            ipChange.ipc$dispatch("2084480372", new Object[]{this});
            return;
        }
        UltronPresenter ultronPresenter = this.mPresenter;
        if (ultronPresenter != null) {
            ultronPresenter.onDestroy();
        }
        br brVar = this.mDMMessage;
        if (brVar != null) {
            brVar.a();
        }
        InputMethodHide();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365934536")) {
            ipChange.ipc$dispatch("-365934536", new Object[]{this});
            return;
        }
        super.onPause();
        UltronPresenter ultronPresenter = this.mPresenter;
        if (ultronPresenter != null) {
            ultronPresenter.onPause();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1106249521")) {
            ipChange.ipc$dispatch("-1106249521", new Object[]{this});
            return;
        }
        super.onResume();
        UltronPresenter ultronPresenter = this.mPresenter;
        if (ultronPresenter != null) {
            ultronPresenter.onResume();
        }
    }

    public void onSelectPromoBack(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796267825")) {
            ipChange.ipc$dispatch("1796267825", new Object[]{this, intent});
        } else if (intent != null) {
            this.mPresenter.getTradeEventHandler().h(this.mPresenter.getTradeEventHandler().d().l(ia0.switchDataTypeEvent).m("pageType", ia0.PAGE_PROMOTION_LIST).m("data", intent));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413259110")) {
            ipChange.ipc$dispatch("-413259110", new Object[]{this});
            return;
        }
        super.onStop();
        InputMethodHide();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1582980827")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1582980827", new Object[]{this});
    }

    public void showProFragment(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464689563")) {
            ipChange.ipc$dispatch("-1464689563", new Object[]{this, bundle});
            return;
        }
        this.fragment = new DmUltronPromotionFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.ll_promotion;
        findViewById(i).setVisibility(0);
        this.fragment.setArguments(bundle);
        beginTransaction.replace(i, this.fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    public void updateTicketDetailData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886019573")) {
            ipChange.ipc$dispatch("-1886019573", new Object[]{this});
            return;
        }
        this.mDmTicketDetailView.l(ha0.i(this.mPresenter));
    }

    public void updateTicketDetailVis(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430604447")) {
            ipChange.ipc$dispatch("1430604447", new Object[]{this, Boolean.valueOf(z)});
        } else if (!z) {
            this.mDmTicketDetailView.j();
        } else {
            this.mDmTicketDetailView.c();
        }
    }
}
