package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceDataList;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceDetailInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceExpressInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoicesDetail;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.ZLOrderInvoiceDetailRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.OrderInvoiceDetailAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class OrderInvoiceDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private OrderInvoiceDetailAdapter mAdapter;
    private List<InvoiceDataList> mInvoiceDataList;
    private String mOrderId;
    private IRecyclerView mRecyclerView;
    private View mRootView;

    private void getIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880258475")) {
            ipChange.ipc$dispatch("-880258475", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        String stringExtra = intent.getStringExtra("orderId");
        this.mOrderId = stringExtra;
        if (xf2.j(stringExtra)) {
            finish();
        }
    }

    private void requestInvoiceData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1617489711")) {
            ipChange.ipc$dispatch("-1617489711", new Object[]{this});
            return;
        }
        onLoadStart();
        requestInvoiceDetail(this.mOrderId);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059448991")) {
            ipChange.ipc$dispatch("-1059448991", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        onBackPressed();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-613449239")) {
            return R$layout.activity_order_invoice_detail;
        }
        return ((Integer) ipChange.ipc$dispatch("-613449239", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595911346")) {
            ipChange.ipc$dispatch("595911346", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        requestInvoiceData();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322505404")) {
            ipChange.ipc$dispatch("-322505404", new Object[]{this});
            return;
        }
        this.mRootView = findViewById(R$id.ll_root);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList arrayList = new ArrayList();
        this.mInvoiceDataList = arrayList;
        OrderInvoiceDetailAdapter orderInvoiceDetailAdapter = new OrderInvoiceDetailAdapter(this, arrayList);
        this.mAdapter = orderInvoiceDetailAdapter;
        this.mRecyclerView.setAdapter(orderInvoiceDetailAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getRefreshHeaderView().setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007018890")) {
            ipChange.ipc$dispatch("-1007018890", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getIntentData();
        requestInvoiceData();
    }

    public void onNetError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539817437")) {
            ipChange.ipc$dispatch("-1539817437", new Object[]{this, str, str2});
            return;
        }
        if (xf2.j(str2)) {
            str2 = "网络异常，请稍后重试";
        }
        onResponseError(str2, str, OrderDetailConstantsApi.API_ZL_ORDER_INVOICE_DETAIL, this.mRootView, true);
    }

    public void requestInvoiceDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1220396180")) {
            ipChange.ipc$dispatch("1220396180", new Object[]{this, str});
            return;
        }
        ZLOrderInvoiceDetailRequest zLOrderInvoiceDetailRequest = new ZLOrderInvoiceDetailRequest();
        zLOrderInvoiceDetailRequest.orderId = str;
        zLOrderInvoiceDetailRequest.request(new DMMtopResultRequestListener<InvoicesDetail>(InvoicesDetail.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderInvoiceDetailActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-422200035")) {
                    ipChange.ipc$dispatch("-422200035", new Object[]{this, str, str2});
                    return;
                }
                OrderInvoiceDetailActivity.this.onLoadFinish();
                OrderInvoiceDetailActivity.this.onNetError(str, str2);
            }

            public void onSuccess(InvoicesDetail invoicesDetail) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1882123")) {
                    ipChange.ipc$dispatch("1882123", new Object[]{this, invoicesDetail});
                    return;
                }
                OrderInvoiceDetailActivity.this.onLoadFinish();
                OrderInvoiceDetailActivity.this.returnInvoiceInfo(invoicesDetail);
            }
        });
    }

    public void returnInvoiceInfo(InvoicesDetail invoicesDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "933618437")) {
            ipChange.ipc$dispatch("933618437", new Object[]{this, invoicesDetail});
        } else if (invoicesDetail == null) {
            onNetError("SUCCESS", "");
        } else {
            InvoiceDetailInfo invoiceDetailInfo = invoicesDetail.invo;
            if (!invoicesDetail.os || invoiceDetailInfo == null) {
                onNetError("SUCCESS", "");
                return;
            }
            this.mInvoiceDataList.clear();
            InvoiceDataList invoiceDataList = new InvoiceDataList();
            invoiceDataList.type = 0;
            invoiceDataList.invoiceDetail = invoiceDetailInfo;
            this.mInvoiceDataList.add(invoiceDataList);
            if (invoiceDetailInfo.transInfo != null) {
                InvoiceDataList invoiceDataList2 = new InvoiceDataList();
                invoiceDataList2.type = 1;
                invoiceDataList2.invoicesTrans = invoiceDetailInfo.transInfo;
                this.mInvoiceDataList.add(invoiceDataList2);
                List<InvoiceExpressInfo> list = invoiceDetailInfo.transInfo.express;
                int e = xf2.e(list);
                int i = 0;
                while (i < e) {
                    InvoiceDataList invoiceDataList3 = new InvoiceDataList();
                    invoiceDataList3.type = 2;
                    invoiceDataList3.expressInfo = list.get(i);
                    invoiceDataList3.expressFirst = i == 0;
                    invoiceDataList3.expressEnd = i == e + -1;
                    this.mInvoiceDataList.add(invoiceDataList3);
                    i++;
                }
            }
            OrderInvoiceDetailAdapter orderInvoiceDetailAdapter = this.mAdapter;
            if (orderInvoiceDetailAdapter != null) {
                orderInvoiceDetailAdapter.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "924802205")) {
            return "大麦订单";
        }
        return (String) ipChange.ipc$dispatch("924802205", new Object[]{this});
    }
}
