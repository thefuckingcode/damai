package cn.damai.ticklet.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketPerformanceNoticeResult;
import cn.damai.ticklet.net.TickletPerformanceNoticeRequest;
import cn.damai.ticklet.ui.adapter.TickletPerformanceNoticeAdapter;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.gl2;
import tb.lw2;
import tb.ne2;
import tb.sl2;
import tb.vl2;

/* compiled from: Taobao */
public class TicketPerformanceNoticeActivity extends TickletBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletPerformanceNoticeAdapter adapter;
    private LinearLayout errorPageView;
    private int mCurrentPageIndex = 0;
    private IRecyclerView mRecyclerView;
    private View mViewStatusBarSpace;
    private ArrayList<TicketPerformanceNoticeResult.TicketNoticeData> noticeDataList = new ArrayList<>();
    private String performId;
    private String productSystemId;
    private String title;
    private TextView tvRule;
    private TextView tvTitle;
    private DMIconFontTextView tvTitleBack;

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2099728158")) {
            ipChange.ipc$dispatch("2099728158", new Object[]{this});
            return;
        }
        this.adapter = new TickletPerformanceNoticeAdapter(this, this.noticeDataList);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.adapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    private void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993204281")) {
            ipChange.ipc$dispatch("993204281", new Object[]{this});
            return;
        }
        finish();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportPerformNoticeXFlushError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1108290356")) {
            ipChange.ipc$dispatch("-1108290356", new Object[]{this, str, str2});
            return;
        }
        vl2.d(vl2.f(vl2.TICKLET_PERFORM_NOTE_INTERFACE_API, "mtop.damai.wireless.ticklet2.extension.notice.query", str, str2, ""), vl2.TICKLET_PERFORM_NOTE_INTERFACE_ERROR_CODE, str, vl2.TICKLET_PERFORM_NOTE_INTERFACE_ERROR_MSG);
    }

    private void requestDetailData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818009891")) {
            ipChange.ipc$dispatch("1818009891", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (!z) {
            startProgressDialog();
        }
        TickletPerformanceNoticeRequest tickletPerformanceNoticeRequest = new TickletPerformanceNoticeRequest();
        tickletPerformanceNoticeRequest.performId = this.performId;
        tickletPerformanceNoticeRequest.productSystemId = this.productSystemId;
        tickletPerformanceNoticeRequest.request(new DMMtopRequestListener<TicketPerformanceNoticeResult>(TicketPerformanceNoticeResult.class) {
            /* class cn.damai.ticklet.ui.activity.TicketPerformanceNoticeActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1346187917")) {
                    ipChange.ipc$dispatch("-1346187917", new Object[]{this, str, str2});
                    return;
                }
                TicketPerformanceNoticeActivity.this.stopProgressDialog();
                TicketPerformanceNoticeActivity.this.reportPerformNoticeXFlushError(str, str2);
                TicketPerformanceNoticeActivity.this.errorView(str, str2);
            }

            public void onSuccess(TicketPerformanceNoticeResult ticketPerformanceNoticeResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1991644113")) {
                    ipChange.ipc$dispatch("1991644113", new Object[]{this, ticketPerformanceNoticeResult});
                    return;
                }
                TicketPerformanceNoticeActivity.this.stopProgressDialog();
                if (ticketPerformanceNoticeResult != null) {
                    TicketPerformanceNoticeActivity.this.returnNoticeDetailData(ticketPerformanceNoticeResult.getPairInfoList());
                } else {
                    TicketPerformanceNoticeActivity.this.showEmptyPage();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void returnNoticeDetailData(ArrayList<TicketPerformanceNoticeResult.TicketNoticeData> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1839929634")) {
            ipChange.ipc$dispatch("-1839929634", new Object[]{this, arrayList});
            return;
        }
        stopProgressDialog();
        this.errorPageView.setVisibility(8);
        if (!(arrayList == null || arrayList.size() == 0)) {
            this.mRecyclerView.setVisibility(0);
            if (this.mCurrentPageIndex == 0) {
                this.noticeDataList.clear();
                this.noticeDataList.addAll(arrayList);
                this.adapter.notifyDataSetChanged();
            } else {
                this.noticeDataList.addAll(arrayList);
                this.adapter.notifyDataSetChanged();
            }
            this.mCurrentPageIndex++;
        } else if (this.mCurrentPageIndex == 0) {
            this.noticeDataList.clear();
            showEmptyPage();
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2103608083")) {
            ipChange.ipc$dispatch("2103608083", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                this.mViewStatusBarSpace.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2129022148")) {
            ipChange.ipc$dispatch("-2129022148", new Object[]{this});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        onResponseError(3, getString(R$string.ticklet_venue_error), "", "", this.errorPageView, true);
    }

    private void showErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374430901")) {
            ipChange.ipc$dispatch("1374430901", new Object[]{this, str, str2});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        onResponseError(str2, str, "mtop.damai.wireless.ticklet2.extension.notice.query", this.errorPageView, true);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433789623")) {
            ipChange.ipc$dispatch("1433789623", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void errorView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719309886")) {
            ipChange.ipc$dispatch("-719309886", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        showErrorPage(str, str2);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1471297235")) {
            return R$layout.ticklet_perforance_require_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1471297235", new Object[]{this})).intValue();
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798542600")) {
            ipChange.ipc$dispatch("798542600", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.errorPageView.setVisibility(8);
        requestDetailData(false);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244873370")) {
            ipChange.ipc$dispatch("244873370", new Object[]{this});
            return;
        }
        this.mViewStatusBarSpace = findViewById(R$id.ticklet_title_bar_space_view);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.tvRule = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.tvTitle = (TextView) findViewById(R$id.ticklet_title_text);
        setImmersionStyle();
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.ticklet_notice_list);
        this.errorPageView = (LinearLayout) findViewById(R$id.errorPageView);
        initIRecyclerView();
        this.tvRule.setOnClickListener(this);
        this.tvTitleBack.setOnClickListener(this);
        this.tvRule.setVisibility(8);
        if (TextUtils.isEmpty(this.title)) {
            this.tvTitle.setText("温馨提示");
        } else {
            this.tvTitle.setText(this.title);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307865088")) {
            ipChange.ipc$dispatch("1307865088", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        } else if (view.getId() == R$id.ticklet_rule_text_url) {
            lw2.f().n(this, gl2.DAMAI_TRANSFER_RULE_URL);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483096736")) {
            ipChange.ipc$dispatch("-1483096736", new Object[]{this, bundle});
            return;
        }
        if (getIntent() != null) {
            this.title = getIntent().getStringExtra("title");
            this.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = getIntent().getStringExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
        }
        super.onCreate(bundle);
        hideBaseLayout();
        requestDetailData(false);
        setDamaiUTKeyBuilder(sl2.j().k(sl2.TICKLET_EXPLAIN));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340414112")) {
            ipChange.ipc$dispatch("340414112", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393470730")) {
            return ((Boolean) ipChange.ipc$dispatch("-393470730", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041093175")) {
            ipChange.ipc$dispatch("2041093175", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393678590")) {
            ipChange.ipc$dispatch("393678590", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361857636")) {
            ipChange.ipc$dispatch("1361857636", new Object[]{this});
            return;
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2128203769")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-2128203769", new Object[]{this});
    }
}
