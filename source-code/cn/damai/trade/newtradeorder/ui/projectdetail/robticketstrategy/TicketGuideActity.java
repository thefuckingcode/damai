package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.network.NetworkType;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuideNoticeListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTicketGuideBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTicketGuideDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.bean.UpdateResultBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.request.UpdateVersionRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.utils.NetworkChangedBroadcastReceiver;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mtopsdk.mtop.util.ErrorConstant;
import tb.el2;
import tb.g70;
import tb.gl1;
import tb.hu1;
import tb.js2;
import tb.ln2;
import tb.n42;
import tb.ne2;
import tb.xf2;
import tb.xh1;

/* compiled from: Taobao */
public class TicketGuideActity extends SimpleBaseActivity implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int DEFAULT_LINE = 2;
    private final int DEFAULT_LINE_TWO = 1;
    private int alpha;
    private String calendarRemindTitle;
    private TicketGuideAdapter mAdapter;
    private boolean mAppBarLayoutHeight = false;
    private List<ProjectTicketGuideDataHolder> mGuideDataHolders = new ArrayList();
    private DMIconFontTextView mIconBack;
    private ImageView mIvHeadImageBg;
    private NetworkChangedBroadcastReceiver mNetworkChangedBroadcastReceiver;
    private long mProjectId;
    private ProjectTicketGuideBean mProjectTicketGuideBean;
    private RecyclerView mRecyclerView;
    c mTimeCount;
    private View mTitleLineView;
    private TextView mTvTitle;
    private boolean mVisEmail;
    private long sellStartTime;
    private int stateHeight = 0;

    /* compiled from: Taobao */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ LinearLayout b;

        a(int i, LinearLayout linearLayout) {
            this.a = i;
            this.b = linearLayout;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "6317100")) {
                ipChange.ipc$dispatch("6317100", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            int height = appBarLayout.getHeight();
            TicketGuideActity.this.mAppBarLayoutHeight = false;
            if (!TicketGuideActity.this.mAppBarLayoutHeight) {
                TicketGuideActity.this.mAppBarLayoutHeight = true;
                int i2 = this.a;
                if (height > i2) {
                    height -= i2;
                }
            }
            TicketGuideActity.this.alpha = (Math.abs(i) * 255) / height;
            if (TicketGuideActity.this.alpha > 126) {
                this.b.setBackgroundColor(ContextCompat.getColor(TicketGuideActity.this, R$color.white));
                DMIconFontTextView dMIconFontTextView = TicketGuideActity.this.mIconBack;
                TicketGuideActity ticketGuideActity = TicketGuideActity.this;
                int i3 = R$color.black;
                dMIconFontTextView.setTextColor(ContextCompat.getColor(ticketGuideActity, i3));
                TicketGuideActity.this.mTvTitle.setTextColor(ContextCompat.getColor(TicketGuideActity.this, i3));
                TicketGuideActity.this.mTitleLineView.setVisibility(0);
                TicketGuideActity.this.mTvTitle.setVisibility(0);
                return;
            }
            this.b.setBackgroundColor(ContextCompat.getColor(TicketGuideActity.this, R$color.transparent));
            TicketGuideActity.this.mIconBack.setTextColor(ContextCompat.getColor(TicketGuideActity.this, R$color.white));
            TicketGuideActity.this.mTitleLineView.setVisibility(8);
            TicketGuideActity.this.mTvTitle.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class b implements NetworkChangedBroadcastReceiver.OnNetworkChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.utils.NetworkChangedBroadcastReceiver.OnNetworkChangedListener
        public void onNetworkChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477065516")) {
                ipChange.ipc$dispatch("-1477065516", new Object[]{this});
                return;
            }
            TicketGuideActity.this.checkNetworkType();
            if (TicketGuideActity.this.mAdapter != null) {
                TicketGuideActity.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: Taobao */
    public class c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        public c(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "496233525")) {
                ipChange.ipc$dispatch("496233525", new Object[]{this});
            }
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1239705721")) {
                ipChange.ipc$dispatch("1239705721", new Object[]{this, Long.valueOf(j)});
            } else if (j / 1000 <= 600 && !el2.b().g() && TicketGuideActity.this.mAdapter != null) {
                TicketGuideActity.this.mAdapter.notifyDataSetChanged();
                TicketGuideActity.this.stopTimer();
            }
        }
    }

    private void checkAppHasNewVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1544813608")) {
            ipChange.ipc$dispatch("1544813608", new Object[]{this});
            return;
        }
        UpdateVersionRequest updateVersionRequest = new UpdateVersionRequest(false);
        updateVersionRequest.brand = Build.getMANUFACTURER();
        updateVersionRequest.model = g70.b();
        updateVersionRequest.identifier = AppConfig.j();
        updateVersionRequest.appVersion = getVersion();
        updateVersionRequest.apiLevel = (long) Build.VERSION.SDK_INT;
        updateVersionRequest.isYunos = isYunOS();
        ArrayList arrayList = new ArrayList();
        arrayList.add(js2.MAIN);
        updateVersionRequest.updateTypes = arrayList;
        updateVersionRequest.request(new DMMtopRequestListener<UpdateResultBean>(UpdateResultBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.TicketGuideActity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1796855121")) {
                    ipChange.ipc$dispatch("-1796855121", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(UpdateResultBean updateResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2033571266")) {
                    ipChange.ipc$dispatch("-2033571266", new Object[]{this, updateResultBean});
                } else if (!TicketGuideActity.this.isActivityFinsihed() && updateResultBean != null) {
                    hu1.d(updateResultBean.hasUpdate);
                    if (TicketGuideActity.this.mAdapter != null) {
                        TicketGuideActity.this.mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkNetworkType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122368105")) {
            ipChange.ipc$dispatch("1122368105", new Object[]{this});
            return;
        }
        hu1.e(hasFineNetWork(xh1.b(this)));
    }

    private ProjectTickGuidePreBean getPreparationBean(ProjectTickGuidePreBean projectTickGuidePreBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241003490")) {
            return (ProjectTickGuidePreBean) ipChange.ipc$dispatch("-1241003490", new Object[]{this, projectTickGuidePreBean});
        }
        if (projectTickGuidePreBean != null) {
            projectTickGuidePreBean.projectId = String.valueOf(this.mProjectId);
            Objects.requireNonNull(el2.b());
            if ("ReminderModule".equals(projectTickGuidePreBean.name)) {
                projectTickGuidePreBean.sellStartTime = this.sellStartTime;
                projectTickGuidePreBean.calendarRemindTitle = this.calendarRemindTitle;
            } else {
                Objects.requireNonNull(el2.b());
                if ("PreFillModule".equals(projectTickGuidePreBean.name)) {
                    projectTickGuidePreBean.visEmail = this.mVisEmail;
                }
            }
        }
        return projectTickGuidePreBean;
    }

    private String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751241625")) {
            return (String) ipChange.ipc$dispatch("751241625", new Object[]{this});
        }
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "6.0.0";
        }
    }

    private boolean hasFineNetWork(NetworkType networkType) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1114357898")) {
            return (networkType == null || networkType == NetworkType.NETWORK_NO || networkType == NetworkType.NETWORK_UNKNOWN || networkType == NetworkType.NETWORK_2G || networkType == NetworkType.NETWORK_3G) ? false : true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1114357898", new Object[]{this, networkType})).booleanValue();
    }

    private void initAppBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197873369")) {
            ipChange.ipc$dispatch("-1197873369", new Object[]{this});
            return;
        }
        int a2 = this.stateHeight + n42.a(this, 44.0f);
        ((CollapsingToolbarLayout) findViewById(R$id.toolbar_layout)).setMinimumHeight(a2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.iv_ticket_rob_bar);
        this.mIconBack = (DMIconFontTextView) linearLayout.findViewById(R$id.ticket_rob_title_back_tv);
        this.mTvTitle = (TextView) linearLayout.findViewById(R$id.ticket_rob_title_tv);
        View findViewById = linearLayout.findViewById(R$id.title_line);
        this.mTitleLineView = findViewById;
        findViewById.setVisibility(8);
        this.mIconBack.setOnClickListener(this);
        ((AppBarLayout) findViewById(R$id.appbar_layout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(a2, linearLayout));
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428412497")) {
            ipChange.ipc$dispatch("-1428412497", new Object[]{this});
            return;
        }
        checkAppHasNewVersion();
        checkNetworkType();
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050144329")) {
            ipChange.ipc$dispatch("-2050144329", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        this.mProjectId = intent.getLongExtra("projectId", 0);
        this.calendarRemindTitle = intent.getStringExtra("calendarRemindTitle");
        this.sellStartTime = intent.getLongExtra("sellStartTime", 0);
        this.mVisEmail = intent.getBooleanExtra("email", false);
        Parcelable parcelableExtra = intent.getParcelableExtra("ticketGuide");
        if (parcelableExtra != null) {
            this.mProjectTicketGuideBean = (ProjectTicketGuideBean) parcelableExtra;
        }
    }

    private void initStateBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642292375")) {
            ipChange.ipc$dispatch("1642292375", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                this.stateHeight = findViewById.getLayoutParams().height;
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        initAppBar();
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922092381")) {
            ipChange.ipc$dispatch("-1922092381", new Object[]{this});
            return;
        }
        initStateBar();
        this.mIvHeadImageBg = (ImageView) findViewById(R$id.iv_ticket_rob);
        this.mRecyclerView = (RecyclerView) findViewById(R$id.irc);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.mContext, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.TicketGuideActity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1700329949")) {
                    return ((Integer) ipChange.ipc$dispatch("-1700329949", new Object[]{this, Integer.valueOf(i)})).intValue();
                } else if (xf2.e(TicketGuideActity.this.mGuideDataHolders) <= i) {
                    return 2;
                } else {
                    TicketGuideActity ticketGuideActity = TicketGuideActity.this;
                    return ticketGuideActity.getLineCount((ProjectTicketGuideDataHolder) ticketGuideActity.mGuideDataHolders.get(i));
                }
            }
        });
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        TicketGuideAdapter ticketGuideAdapter = new TicketGuideAdapter(this, this.mGuideDataHolders);
        this.mAdapter = ticketGuideAdapter;
        this.mRecyclerView.setAdapter(ticketGuideAdapter);
    }

    private boolean isYunOS() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259215623")) {
            return ((Boolean) ipChange.ipc$dispatch("-259215623", new Object[]{this})).booleanValue();
        }
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        if ((str2 == null || !str2.toLowerCase().contains("lemur")) && (str == null || str.trim().length() <= 0)) {
            return false;
        }
        return true;
    }

    private void loadGuideData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493646303")) {
            ipChange.ipc$dispatch("-493646303", new Object[]{this});
            return;
        }
        this.mGuideDataHolders.clear();
        ProjectTicketGuideBean projectTicketGuideBean = this.mProjectTicketGuideBean;
        if (projectTicketGuideBean != null) {
            loadGuildePoster(projectTicketGuideBean.headerImageUrl);
            ProjectTickGuidePreListBean projectTickGuidePreListBean = this.mProjectTicketGuideBean.tpgPreparation;
            if (projectTickGuidePreListBean != null) {
                ProjectTicketGuideDataHolder projectTicketGuideDataHolder = new ProjectTicketGuideDataHolder(0);
                projectTicketGuideDataHolder.mTicketGuideTitle = projectTickGuidePreListBean.title;
                this.mGuideDataHolders.add(projectTicketGuideDataHolder);
                int e = xf2.e(projectTickGuidePreListBean.tpgPreparationList);
                for (int i = 0; i < e; i++) {
                    ProjectTicketGuideDataHolder projectTicketGuideDataHolder2 = new ProjectTicketGuideDataHolder(getItemViewType(projectTickGuidePreListBean.tpgPreparationList.get(i)));
                    projectTicketGuideDataHolder2.tickGuidePreBean = getPreparationBean(projectTickGuidePreListBean.tpgPreparationList.get(i));
                    this.mGuideDataHolders.add(projectTicketGuideDataHolder2);
                }
            }
            ProjectTickGuideNoticeListBean projectTickGuideNoticeListBean = this.mProjectTicketGuideBean.tpgNotice;
            if (projectTickGuideNoticeListBean != null) {
                ProjectTicketGuideDataHolder projectTicketGuideDataHolder3 = new ProjectTicketGuideDataHolder(0);
                projectTicketGuideDataHolder3.mTicketGuideTitle = projectTickGuideNoticeListBean.title;
                this.mGuideDataHolders.add(projectTicketGuideDataHolder3);
                int e2 = xf2.e(projectTickGuideNoticeListBean.noticeModules);
                int i2 = 0;
                while (i2 < e2) {
                    ProjectTicketGuideDataHolder projectTicketGuideDataHolder4 = new ProjectTicketGuideDataHolder(3);
                    projectTicketGuideDataHolder4.noticeBean = projectTickGuideNoticeListBean.noticeModules.get(i2);
                    projectTicketGuideDataHolder4.hideTopLine = i2 == 0;
                    projectTicketGuideDataHolder4.hideBottomLine = i2 == e2 + -1;
                    projectTicketGuideDataHolder4.projectId = String.valueOf(this.mProjectId);
                    this.mGuideDataHolders.add(projectTicketGuideDataHolder4);
                    i2++;
                }
            }
            if (!TextUtils.isEmpty(this.mProjectTicketGuideBean.tpgBottomText)) {
                ProjectTicketGuideDataHolder projectTicketGuideDataHolder5 = new ProjectTicketGuideDataHolder(4);
                projectTicketGuideDataHolder5.mTicketGuideTitle = this.mProjectTicketGuideBean.tpgBottomText;
                this.mGuideDataHolders.add(projectTicketGuideDataHolder5);
            }
            TicketGuideAdapter ticketGuideAdapter = this.mAdapter;
            if (ticketGuideAdapter != null) {
                ticketGuideAdapter.notifyDataSetChanged();
            }
        }
    }

    private void loadGuildePoster(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-60503378")) {
            ipChange.ipc$dispatch("-60503378", new Object[]{this, str});
        } else if (str != null) {
            DMImageCreator f = cn.damai.common.image.a.b().f(str, -1, -1);
            int i = R$drawable.bg_border_corner_f5;
            f.i(i).c(i).g(this.mIvHeadImageBg);
        }
    }

    private void registerNetworkStateChangeListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627449887")) {
            ipChange.ipc$dispatch("1627449887", new Object[]{this});
            return;
        }
        if (this.mNetworkChangedBroadcastReceiver == null) {
            this.mNetworkChangedBroadcastReceiver = new NetworkChangedBroadcastReceiver(new b());
        }
        registerReceiver(this.mNetworkChangedBroadcastReceiver, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45542562")) {
            ipChange.ipc$dispatch("-45542562", new Object[]{this});
            return;
        }
        c cVar = this.mTimeCount;
        if (cVar != null) {
            cVar.cancel();
            this.mTimeCount = null;
        }
    }

    private void unregisterNetworkStateChangeListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42077658")) {
            ipChange.ipc$dispatch("-42077658", new Object[]{this});
            return;
        }
        NetworkChangedBroadcastReceiver networkChangedBroadcastReceiver = this.mNetworkChangedBroadcastReceiver;
        if (networkChangedBroadcastReceiver != null) {
            unregisterReceiver(networkChangedBroadcastReceiver);
        }
    }

    public int getItemViewType(ProjectTickGuidePreBean projectTickGuidePreBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595022310")) {
            return ((Integer) ipChange.ipc$dispatch("1595022310", new Object[]{this, projectTickGuidePreBean})).intValue();
        } else if (projectTickGuidePreBean != null) {
            return el2.b().e(projectTickGuidePreBean.name);
        } else {
            return 1;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1158321753")) {
            return R$layout.activity_ticket_guide;
        }
        return ((Integer) ipChange.ipc$dispatch("1158321753", new Object[]{this})).intValue();
    }

    public int getLineCount(ProjectTicketGuideDataHolder projectTicketGuideDataHolder) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1478291605")) {
            return (projectTicketGuideDataHolder != null && projectTicketGuideDataHolder.mType == 1) ? 1 : 2;
        }
        return ((Integer) ipChange.ipc$dispatch("-1478291605", new Object[]{this, projectTicketGuideDataHolder})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877587668")) {
            ipChange.ipc$dispatch("1877587668", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtraData();
        initViews();
        loadGuideData();
        initData();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961303482")) {
            ipChange.ipc$dispatch("961303482", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.ticket_rob_title_back_tv) {
            onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658395366")) {
            ipChange.ipc$dispatch("658395366", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        registerNetworkStateChangeListener();
        LoginManager.k().c(this);
        setDamaiUTKeyBuilder(ln2.r().b1(String.valueOf(this.mProjectId)));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585050202")) {
            ipChange.ipc$dispatch("-585050202", new Object[]{this});
            return;
        }
        super.onDestroy();
        unregisterNetworkStateChangeListener();
        LoginManager.k().C(this);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697447363")) {
            ipChange.ipc$dispatch("-1697447363", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381476761")) {
            ipChange.ipc$dispatch("381476761", new Object[]{this});
            return;
        }
        ToastUtil.i(ErrorConstant.ERRMSG_ANDROID_SYS_LOGIN_FAIL);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "592759120")) {
            ipChange.ipc$dispatch("592759120", new Object[]{this});
            return;
        }
        ToastUtil.i("已登录");
        TicketGuideAdapter ticketGuideAdapter = this.mAdapter;
        if (ticketGuideAdapter != null) {
            ticketGuideAdapter.notifyDataSetChanged();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1467575840")) {
            ipChange.ipc$dispatch("-1467575840", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746552739")) {
            ipChange.ipc$dispatch("-1746552739", new Object[]{this});
            return;
        }
        super.onResume();
        startRemindTimer();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088784984")) {
            ipChange.ipc$dispatch("-1088784984", new Object[]{this});
            return;
        }
        super.onStop();
        stopTimer();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1446646515")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1446646515", new Object[]{this});
    }

    public void startRemindTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074664587")) {
            ipChange.ipc$dispatch("2074664587", new Object[]{this});
            return;
        }
        if (this.mTimeCount != null) {
            stopTimer();
        }
        if (el2.b().g()) {
            c cVar = new c(el2.b().f() * 1000, 1000);
            this.mTimeCount = cVar;
            cVar.start();
        }
    }
}
