package cn.damai.ultron.secondpage.chooseaddress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.address.manager.AddressListener;
import cn.damai.commonbusiness.address.manager.AddressManager;
import cn.damai.commonbusiness.address.ui.AddAddressActivity;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.ultron.R$anim;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.secondpage.chooseaddress.DmLoginReceiver;
import cn.damai.ultron.utils.DmUltronChooseListenerImpl;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.d20;
import tb.ma0;
import tb.n42;
import tb.na0;
import tb.oa0;
import tb.w90;
import tb.xf2;

/* compiled from: Taobao */
public class DmChoseAddressListActivity extends SimpleBaseActivity implements DmLoginReceiver.OnLoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView cancelIcon;
    private String currentAddressId;
    private DmChoseAddressAdapter dmAddressAdapter;
    private DmLoginReceiver dmLoginReceiver;
    DmUltronChooseListenerImpl<AddressBean> itemClickListener = new b();
    private LinearLayout ll_add;
    View mAnimView;
    private boolean modifyAddress = false;
    private RecyclerView recyclerView;
    private RelativeLayout rl_bottom;
    private LinearLayout rl_empty_view;
    private int type;
    private View v_outside;

    /* compiled from: Taobao */
    public class a implements AddressListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.address.manager.AddressListener
        public void onAddressListFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-40441737")) {
                ipChange.ipc$dispatch("-40441737", new Object[]{this, str, str2});
                return;
            }
            DmChoseAddressListActivity.this.recyclerView.setVisibility(8);
            DmChoseAddressListActivity.this.rl_empty_view.setVisibility(0);
            oa0.f().a(DmChoseAddressListActivity.this, str, str2);
        }

        @Override // cn.damai.commonbusiness.address.manager.AddressListener
        public void onAddressListSuccess(AddressListBean addressListBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "142588078")) {
                ipChange.ipc$dispatch("142588078", new Object[]{this, addressListBean});
                return;
            }
            if (addressListBean != null) {
                if ("true".equals(addressListBean.getAbleAdd())) {
                    DmChoseAddressListActivity.this.ll_add.setVisibility(0);
                    DmChoseAddressListActivity.this.ll_add.setOnClickListener(DmChoseAddressListActivity.this);
                    DmChoseAddressListActivity.this.ll_add.setEnabled(true);
                    DmChoseAddressListActivity.this.dmAddressAdapter.i(true);
                } else {
                    DmChoseAddressListActivity.this.ll_add.setVisibility(8);
                    DmChoseAddressListActivity.this.ll_add.setEnabled(false);
                    DmChoseAddressListActivity.this.dmAddressAdapter.i(false);
                }
                DmChoseAddressListActivity.this.dmAddressAdapter.k(DmChoseAddressListActivity.this.currentAddressId);
                DmChoseAddressListActivity.this.dmAddressAdapter.j(addressListBean.getList());
                DmChoseAddressListActivity.this.dmAddressAdapter.notifyDataSetChanged();
            }
            if (DmChoseAddressListActivity.this.dmAddressAdapter == null || xf2.e(DmChoseAddressListActivity.this.dmAddressAdapter.f()) <= 0) {
                DmChoseAddressListActivity.this.recyclerView.setVisibility(8);
                DmChoseAddressListActivity.this.rl_empty_view.setVisibility(0);
                return;
            }
            DmChoseAddressListActivity.this.recyclerView.setVisibility(0);
            DmChoseAddressListActivity.this.rl_empty_view.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class b implements DmUltronChooseListenerImpl<AddressBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void chooseItemListener(AddressBean addressBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1400820353")) {
                ipChange.ipc$dispatch("-1400820353", new Object[]{this, addressBean});
            } else if (addressBean == null) {
                ToastUtil.i("没有选择收货地址");
            } else {
                DmChoseAddressListActivity.this.finishPage(addressBean);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-335685886")) {
                ipChange.ipc$dispatch("-335685886", new Object[]{this, animation});
                return;
            }
            DmChoseAddressListActivity.this.finish();
            DmChoseAddressListActivity.this.overridePendingTransition(0, 0);
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2047996210")) {
                ipChange.ipc$dispatch("2047996210", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1976389157")) {
                ipChange.ipc$dispatch("-1976389157", new Object[]{this, animation});
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finishPage(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-682972211")) {
            ipChange.ipc$dispatch("-682972211", new Object[]{this, addressBean});
        } else if (addressBean != null) {
            cn.damai.common.user.c.e().x(ma0.u().E(String.valueOf(w90.b(this))));
            Intent intent = new Intent();
            intent.putExtra("added_address", addressBean);
            intent.putExtra("addressId", addressBean.getAddressId());
            setResult(-1, intent);
            finishActivity();
        }
    }

    private void getAddressData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688325087")) {
            ipChange.ipc$dispatch("-688325087", new Object[]{this});
            return;
        }
        AddressManager.b().a(d20.q(), new a());
    }

    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732534873")) {
            ipChange.ipc$dispatch("-732534873", new Object[]{this});
        } else if (this.mAnimView == null) {
            finish();
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.activity_item_animexit);
            this.mAnimView.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new c());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1691208313")) {
            return R$layout.dm_chose_address_list;
        }
        return ((Integer) ipChange.ipc$dispatch("1691208313", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143657292")) {
            ipChange.ipc$dispatch("-143657292", new Object[]{this});
            return;
        }
        hideBaseLayout();
        Intent intent = getIntent();
        if (intent != null) {
            this.type = intent.getIntExtra("type", 0);
            this.currentAddressId = intent.getStringExtra("dm_bundle_address_id");
        }
        this.v_outside = findViewById(R$id.v_outside);
        this.cancelIcon = (DMIconFontTextView) findViewById(R$id.text_ok);
        this.rl_bottom = (RelativeLayout) findViewById(R$id.rl_bottom);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.rl_top);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = (int) (((double) DisplayMetrics.getheightPixels(n42.b(this))) * 0.75d);
        linearLayout.setLayoutParams(layoutParams);
        this.ll_add = (LinearLayout) findViewById(R$id.ll_add);
        this.rl_empty_view = (LinearLayout) findViewById(R$id.rl_empty_view);
        ((TextView) findViewById(R$id.tv_empty_content)).setText("还没有收货地址，赶快新增一个？");
        this.recyclerView = (RecyclerView) findViewById(R$id.recyclerview);
        this.v_outside.setOnClickListener(this);
        this.cancelIcon.setOnClickListener(this);
        findViewById(R$id.rl_title).setOnClickListener(null);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DmChoseAddressAdapter dmChoseAddressAdapter = new DmChoseAddressAdapter(this, this.type, this.itemClickListener);
        this.dmAddressAdapter = dmChoseAddressAdapter;
        this.recyclerView.setAdapter(dmChoseAddressAdapter);
        this.rl_bottom.startAnimation(AnimationUtils.loadAnimation(this, R$anim.activity_item_animshow));
        setAnimationView(this.rl_bottom);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967319141")) {
            ipChange.ipc$dispatch("-967319141", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 37) {
            setResult(-1, intent);
            finishActivity();
        } else if (i == 40) {
            this.modifyAddress = true;
            getAddressData();
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1594565989")) {
            ipChange.ipc$dispatch("1594565989", new Object[]{this});
        } else if (!this.modifyAddress) {
            finishActivity();
        } else if (this.currentAddressId == null) {
            finishActivity();
        } else {
            AddressBean addressBean = null;
            DmChoseAddressAdapter dmChoseAddressAdapter = this.dmAddressAdapter;
            if (dmChoseAddressAdapter != null) {
                List<AddressBean> f = dmChoseAddressAdapter.f();
                int e = xf2.e(f);
                while (true) {
                    if (i >= e) {
                        break;
                    } else if (this.currentAddressId.equals(f.get(i).getAddressId())) {
                        addressBean = f.get(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (addressBean == null) {
                finishActivity();
            } else {
                finishPage(addressBean);
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "242637722")) {
            ipChange.ipc$dispatch("242637722", new Object[]{this, view});
        } else if (view.getId() == R$id.ll_add) {
            cn.damai.common.user.c.e().x(ma0.u().f(String.valueOf(w90.b(this))));
            Bundle bundle = new Bundle();
            bundle.putInt(AddAddressActivity.KEY_OPERATION_ADDRESS, 1);
            DMNav.from(this).withExtras(bundle).forResult(37).toUri(NavUri.b("addaddress"));
        } else if (view.getId() == R$id.v_outside || view.getId() == R$id.text_ok) {
            onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145406714")) {
            ipChange.ipc$dispatch("-145406714", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(ma0.u().m(this));
        initView();
        getAddressData();
        this.dmLoginReceiver = na0.d(this, this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180865478")) {
            ipChange.ipc$dispatch("1180865478", new Object[]{this});
            return;
        }
        super.onDestroy();
        DmLoginReceiver dmLoginReceiver2 = this.dmLoginReceiver;
        if (dmLoginReceiver2 != null) {
            unregisterReceiver(dmLoginReceiver2);
        }
    }

    @Override // cn.damai.ultron.secondpage.chooseaddress.DmLoginReceiver.OnLoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914363321")) {
            ipChange.ipc$dispatch("914363321", new Object[]{this});
        }
    }

    @Override // cn.damai.ultron.secondpage.chooseaddress.DmLoginReceiver.OnLoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617142064")) {
            ipChange.ipc$dispatch("1617142064", new Object[]{this});
            return;
        }
        getAddressData();
    }

    public void setAnimationView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168877904")) {
            ipChange.ipc$dispatch("168877904", new Object[]{this, view});
            return;
        }
        this.mAnimView = view;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1162570029")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1162570029", new Object[]{this});
    }
}
