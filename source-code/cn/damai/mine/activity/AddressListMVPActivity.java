package cn.damai.mine.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.address.ui.AddAddressActivity;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.adapter.AddressListAdapter;
import cn.damai.mine.bean.DefaultAddressBean;
import cn.damai.mine.contract.AddressListContract;
import cn.damai.mine.presenter.AddressListPresenter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.OnRefreshListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.d20;
import tb.ge1;
import tb.gr;
import tb.ne2;
import tb.v50;
import tb.xf2;
import tb.yd1;

/* compiled from: Taobao */
public class AddressListMVPActivity extends DamaiBaseActivity<AddressListPresenter, AddressListContract.Model> implements AddressListContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private String addressId;
    private String isAbleAdd = "false";
    private AddressBean mAddress;
    private AddressListAdapter mAddressListAdapter;
    private DamaiRootRecyclerView mAddressRecyclerView;
    private AddressBean mDeletedAddress;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayout mLvInvalidPromptLayout;
    private long mPosition;
    private RelativeLayout mRvInvalidPrompt;
    private TextView mTitleTV;
    private DMIconFontTextView mTvPromptClose;
    private TextView mTvPromptContent;
    private DMIconFontTextView mTvTitleBack;
    private String msg;
    private TextView tv_add_main;
    private String type = "";

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-729630914")) {
                ipChange.ipc$dispatch("-729630914", new Object[]{this, view});
                return;
            }
            AddressListMVPActivity.this.onBackPressed();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1381659455")) {
                ipChange.ipc$dispatch("1381659455", new Object[]{this, view});
                return;
            }
            d20.h0(true);
            AddressListMVPActivity.this.mRvInvalidPrompt.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class c implements OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.uikit.irecycler.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-288670497")) {
                ipChange.ipc$dispatch("-288670497", new Object[]{this});
                return;
            }
            AddressListMVPActivity.this.retrieveAddressList();
        }
    }

    /* compiled from: Taobao */
    public class d implements AddressListAdapter.OnAddressItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ long a;

            a(long j) {
                this.a = j;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-801551199")) {
                    ipChange.ipc$dispatch("-801551199", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                if (i == 0) {
                    AddressListMVPActivity.this.startProgressDialog();
                    ((AddressListPresenter) AddressListMVPActivity.this.mPresenter).deleteAddress(String.valueOf(this.a));
                }
            }
        }

        d() {
        }

        @Override // cn.damai.mine.adapter.AddressListAdapter.OnAddressItemClickListener
        public void onItemClick(int i, AddressBean addressBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "988073093")) {
                ipChange.ipc$dispatch("988073093", new Object[]{this, Integer.valueOf(i), addressBean});
            } else if (addressBean == null) {
            } else {
                if (TextUtils.isEmpty(AddressListMVPActivity.this.type) || !AddressListMVPActivity.this.type.equals("choose")) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(AddAddressActivity.KEY_OPERATION_ADDRESS, 2);
                    bundle.putParcelable(AddAddressActivity.KEY_MODIFIED_ADDRESS_DATA, addressBean);
                    DMNav.from(AddressListMVPActivity.this).withExtras(bundle).forResult(101).toUri(gr.b());
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("pkid", Long.parseLong(addressBean.getAddressId()));
                AddressListMVPActivity.this.setResult(-1, intent);
                AddressListMVPActivity.this.finish();
            }
        }

        @Override // cn.damai.mine.adapter.AddressListAdapter.OnAddressItemClickListener
        public void onItemLongClick(int i, AddressBean addressBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "238900201")) {
                ipChange.ipc$dispatch("238900201", new Object[]{this, Integer.valueOf(i), addressBean});
            } else if (i > -1) {
                String[] strArr = {new String(AddressListMVPActivity.this.getResources().getString(R$string.damai_addresslist_del))};
                if (addressBean != null) {
                    AddressListMVPActivity.this.mDeletedAddress = addressBean;
                    new AlertDialog.Builder(AddressListMVPActivity.this.mContext).setTitle(AddressListMVPActivity.this.getResources().getString(R$string.damai_addresslist_operation)).setItems(strArr, new a(Long.parseLong(AddressListMVPActivity.this.mDeletedAddress.getAddressId()))).show();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-874404030")) {
                ipChange.ipc$dispatch("-874404030", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(AddressListMVPActivity.this.isAbleAdd) && AddressListMVPActivity.this.isAbleAdd.equals("true")) {
                Bundle bundle = new Bundle();
                bundle.putInt(AddAddressActivity.KEY_OPERATION_ADDRESS, 1);
                DMNav.from(AddressListMVPActivity.this).withExtras(bundle).forResult(101).toUri(gr.b());
                cn.damai.common.user.c.e().x(yd1.x().n());
            } else if (!TextUtils.isEmpty(AddressListMVPActivity.this.msg)) {
                ToastUtil.i(AddressListMVPActivity.this.msg);
            }
        }
    }

    private void deleteAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442337313")) {
            ipChange.ipc$dispatch("1442337313", new Object[]{this});
        } else if (this.mDeletedAddress != null) {
            retrieveAddressList();
        }
    }

    private View getBottomDivider() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2050088138")) {
            return (View) ipChange.ipc$dispatch("2050088138", new Object[]{this});
        }
        View view = new View(this);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, v50.a(this, 30.0f)));
        view.setBackgroundColor(getResources().getColor(R$color.color_F5F5F5));
        return view;
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460831328")) {
            ipChange.ipc$dispatch("-460831328", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.type = extras.getString("type");
            this.addressId = extras.getString("addressid");
        }
    }

    private void initInvalidPromptView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685933766")) {
            ipChange.ipc$dispatch("-685933766", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R$layout.address_list_invalid_prompt_layout, (ViewGroup) this.mAddressRecyclerView.getHeaderContainer(), false);
        this.mLvInvalidPromptLayout = linearLayout;
        this.mRvInvalidPrompt = (RelativeLayout) linearLayout.findViewById(R$id.mine_address_invalid_prompt_rv);
        this.mTvPromptContent = (TextView) this.mLvInvalidPromptLayout.findViewById(R$id.mine_address_invalid_prompt_content_tv);
        this.mTvPromptClose = (DMIconFontTextView) this.mLvInvalidPromptLayout.findViewById(R$id.mine_address_invalid_close_prompt_tv);
        this.mRvInvalidPrompt.setVisibility(8);
        this.mTvPromptClose.setOnClickListener(new b());
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324306146")) {
            ipChange.ipc$dispatch("324306146", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTvTitleBack = (DMIconFontTextView) findViewById(R$id.mine_title_left_icon_font_tv);
        TextView textView = (TextView) findViewById(R$id.mine_title_tv);
        this.mTitleTV = textView;
        textView.setText("设置");
        this.mTvTitleBack.setOnClickListener(new a());
        if (!xf2.j(this.type)) {
            this.mTitleTV.setText("收货地址");
        } else {
            this.mTitleTV.setText(getResources().getString(R$string.damai_address_select_receiving_address));
        }
    }

    private void initUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2013283364")) {
            ipChange.ipc$dispatch("-2013283364", new Object[]{this});
            return;
        }
        this.mAddressRecyclerView = (DamaiRootRecyclerView) findViewById(R$id.mine_address_list_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mAddressRecyclerView.setLayoutManager(linearLayoutManager);
        this.mAddressRecyclerView.setRefreshEnabled(false);
        this.mAddressRecyclerView.setIsAutoToDefault(false);
        this.mAddressRecyclerView.setLoadMoreEnabled(false);
        this.mAddressRecyclerView.getLoadMoreFooterView().setVisibility(8);
        AddressListAdapter addressListAdapter = new AddressListAdapter(this);
        this.mAddressListAdapter = addressListAdapter;
        addressListAdapter.f(this.type);
        this.mAddressListAdapter.c(this.addressId);
        this.mAddressRecyclerView.setAdapter(this.mAddressListAdapter);
        initInvalidPromptView();
        this.mAddressRecyclerView.addHeaderView(this.mLvInvalidPromptLayout);
        this.mAddressRecyclerView.addFooterView(getBottomDivider());
        this.tv_add_main = (TextView) findViewById(R$id.tv_add_main);
    }

    private void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79469673")) {
            ipChange.ipc$dispatch("79469673", new Object[]{this});
            return;
        }
        this.mAddressRecyclerView.setOnRefreshListener(new c());
        this.mAddressListAdapter.e(new d());
        this.tv_add_main.setOnClickListener(new e());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void retrieveAddressList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1815375412")) {
            ipChange.ipc$dispatch("1815375412", new Object[]{this});
            return;
        }
        ((AddressListPresenter) this.mPresenter).getAddressList();
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794996350")) {
            ipChange.ipc$dispatch("-1794996350", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void updateInvalidAddressPrompt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833582176")) {
            ipChange.ipc$dispatch("1833582176", new Object[]{this, str});
            return;
        }
        boolean e2 = d20.e();
        if (TextUtils.isEmpty(str) || e2) {
            this.mRvInvalidPrompt.setVisibility(8);
            return;
        }
        this.mRvInvalidPrompt.setVisibility(0);
        this.mTvPromptContent.setText(str);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493087128")) {
            ipChange.ipc$dispatch("-493087128", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.mine.contract.AddressListContract.View
    public void deleteAddressFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872782520")) {
            ipChange.ipc$dispatch("872782520", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        if (!TextUtils.isEmpty(str2)) {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.mine.contract.AddressListContract.View
    public void deleteAddressSuccess(DefaultAddressBean defaultAddressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959540506")) {
            ipChange.ipc$dispatch("1959540506", new Object[]{this, defaultAddressBean});
            return;
        }
        stopProgressDialog();
        if (defaultAddressBean == null || TextUtils.isEmpty(defaultAddressBean.getSuccess()) || !defaultAddressBean.getSuccess().equals("true")) {
            Resources resources = getResources();
            int i = R$string.damai_addresslist_del_failure_toast;
            ToastUtil.i(resources.getString(i));
            ge1.b("-1000", getResources().getString(i));
            return;
        }
        ToastUtil.i(getResources().getString(R$string.damai_addresslist_del_success_toast));
        deleteAddress();
    }

    @Override // cn.damai.mine.contract.AddressListContract.View
    public void getAddressListError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785056910")) {
            ipChange.ipc$dispatch("-785056910", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        if (!TextUtils.isEmpty(str2)) {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "386792066")) {
            return R$layout.address_list_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("386792066", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1538620729")) {
            ipChange.ipc$dispatch("1538620729", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823463442")) {
            ipChange.ipc$dispatch("1823463442", new Object[]{this});
            return;
        }
        ((AddressListPresenter) this.mPresenter).setVM(this, (AddressListContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167777461")) {
            ipChange.ipc$dispatch("-167777461", new Object[]{this});
            return;
        }
        initExtraData();
        initTitle();
        initUI();
        setImmersionStyle();
        registerListener();
        retrieveAddressList();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580994446")) {
            ipChange.ipc$dispatch("-1580994446", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        if (i2 == -1) {
            retrieveAddressList();
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651279601")) {
            ipChange.ipc$dispatch("-651279601", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(yd1.x().o());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1513795992")) {
            ipChange.ipc$dispatch("-1513795992", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690826579")) {
            ipChange.ipc$dispatch("-690826579", new Object[]{this});
        }
    }

    public void requestDefaultUserAddressData(long j, AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028991745")) {
            ipChange.ipc$dispatch("1028991745", new Object[]{this, Long.valueOf(j), addressBean});
            return;
        }
        this.mPosition = j;
        this.mAddress = addressBean;
        startProgressDialog();
        ((AddressListPresenter) this.mPresenter).setDefaultAddress(String.valueOf(j));
    }

    @Override // cn.damai.mine.contract.AddressListContract.View
    public void returnAddressList(AddressListBean addressListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1235282128")) {
            ipChange.ipc$dispatch("1235282128", new Object[]{this, addressListBean});
            return;
        }
        this.mAddressRecyclerView.setRefreshing(false);
        if (addressListBean != null) {
            updateInvalidAddressPrompt(addressListBean.getDistrictMsg());
            setDataOsTrue(addressListBean);
        }
    }

    public void setDataOsTrue(AddressListBean addressListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091181996")) {
            ipChange.ipc$dispatch("-1091181996", new Object[]{this, addressListBean});
        } else if (addressListBean != null) {
            this.isAbleAdd = addressListBean.getAbleAdd();
            this.msg = addressListBean.getMsg();
            AddressListAdapter addressListAdapter = this.mAddressListAdapter;
            if (addressListAdapter != null) {
                addressListAdapter.setData(addressListBean.getList());
                this.mAddressListAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.mine.contract.AddressListContract.View
    public void setDefaultAddressFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2079227892")) {
            ipChange.ipc$dispatch("-2079227892", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        if (!TextUtils.isEmpty(str2)) {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.mine.contract.AddressListContract.View
    public void setDefaultAddressSuccess(DefaultAddressBean defaultAddressBean) {
        List<AddressBean> data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727877742")) {
            ipChange.ipc$dispatch("1727877742", new Object[]{this, defaultAddressBean});
            return;
        }
        stopProgressDialog();
        if (defaultAddressBean != null && !TextUtils.isEmpty(defaultAddressBean.getSuccess()) && defaultAddressBean.getSuccess().equals("true") && (data = this.mAddressListAdapter.getData()) != null) {
            this.mAddressListAdapter.d(this.mPosition);
            data.remove(this.mAddress);
            data.add(0, this.mAddress);
            this.mAddressListAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412322678")) {
            return (String) ipChange.ipc$dispatch("1412322678", new Object[]{this});
        } else if (xf2.j(this.type)) {
            return "我的收货地址";
        } else {
            return getResources().getString(R$string.damai_address_select_receiving_address);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596340565")) {
            ipChange.ipc$dispatch("596340565", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243985199")) {
            ipChange.ipc$dispatch("-1243985199", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031922933")) {
            ipChange.ipc$dispatch("1031922933", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506421424")) {
            ipChange.ipc$dispatch("1506421424", new Object[]{this});
        }
    }
}
