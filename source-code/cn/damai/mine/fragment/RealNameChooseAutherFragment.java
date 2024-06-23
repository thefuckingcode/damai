package cn.damai.mine.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.activity.RealNameAuthActivity;
import cn.damai.mine.adapter.RealNameChooseAutherAdapter;
import cn.damai.mine.bean.RealNameCustomerBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.yd1;

/* compiled from: Taobao */
public class RealNameChooseAutherFragment extends DamaiBaseMvpFragment implements RealNameChooseAutherAdapter.OnCustomerItemClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RealNameCustomerBean> customerBeans;
    private RealNameChooseAutherAdapter mAutherAdapter;
    private RecyclerView mChooseAutherIrc;
    private RealNameCustomerBean mSelectedCustomer;

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1052450863")) {
            return R$layout.realname_choose_auther;
        }
        return ((Integer) ipChange.ipc$dispatch("1052450863", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388699143")) {
            ipChange.ipc$dispatch("-388699143", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088877742")) {
            ipChange.ipc$dispatch("-2088877742", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817921013")) {
            ipChange.ipc$dispatch("-1817921013", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("data")) {
            this.customerBeans = arguments.getParcelableArrayList("data");
            this.mSelectedCustomer = (RealNameCustomerBean) arguments.getParcelable("selectedCustomer");
        }
        this.mChooseAutherIrc = (RecyclerView) this.rootView.findViewById(R$id.chooseauther_irc);
        this.mChooseAutherIrc.setLayoutManager(new LinearLayoutManager(getContext()));
        RealNameChooseAutherAdapter realNameChooseAutherAdapter = new RealNameChooseAutherAdapter(getContext(), this.customerBeans);
        this.mAutherAdapter = realNameChooseAutherAdapter;
        realNameChooseAutherAdapter.c(this);
        this.mAutherAdapter.d(this.mSelectedCustomer);
        this.mChooseAutherIrc.setAdapter(this.mAutherAdapter);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "856135473")) {
            ipChange.ipc$dispatch("856135473", new Object[]{this, view});
        }
    }

    @Override // cn.damai.mine.adapter.RealNameChooseAutherAdapter.OnCustomerItemClickListener
    public void onItemClick(RealNameCustomerBean realNameCustomerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47850600")) {
            ipChange.ipc$dispatch("-47850600", new Object[]{this, realNameCustomerBean});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof RealNameAuthActivity)) {
            RealNameAuthActivity realNameAuthActivity = (RealNameAuthActivity) activity;
            realNameAuthActivity.dismissChooseAuthFragment();
            c.e().x(yd1.x().X());
            realNameAuthActivity.refreshUI(realNameCustomerBean, true);
        }
    }
}
