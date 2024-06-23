package cn.damai.ticklet.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.PriorityTask;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.message.observer.Action;
import cn.damai.ticklet.bean.CalenderBean;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.QueryPerformListResultEntryData;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TicketVerifyEntryData;
import cn.damai.ticklet.manager.DataHelper;
import cn.damai.ticklet.net.TickletHistoryListRequest;
import cn.damai.ticklet.net.TickletListRequest;
import cn.damai.ticklet.net.TickletVerifyRequest;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.activity.TicketDetailAcceptTransferActivity;
import cn.damai.ticklet.ui.adapter.TickletListAdapter;
import cn.damai.ticklet.utils.UTTimeUtils;
import cn.damai.ticklet.utils.Utils;
import cn.damai.ticklet.view.TickletPerformBannerLoginView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.b30;
import tb.d20;
import tb.dr;
import tb.fl2;
import tb.fp1;
import tb.fs1;
import tb.g91;
import tb.gl2;
import tb.hl2;
import tb.hp1;
import tb.jp1;
import tb.lp1;
import tb.lw2;
import tb.ne2;
import tb.ns1;
import tb.ol1;
import tb.p41;
import tb.rr;
import tb.sl2;
import tb.v50;
import tb.vl2;

/* compiled from: Taobao */
public class TickletListFragment extends DamaiBaseMvpFragment implements ILoginListener, TickletPerformBannerLoginView.TickletBannerLoginCallBack, OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int LOCAL_DATA = 1;
    private static final String TAG = "member_activity";
    private TickletPerformBannerLoginView bannerLoginView;
    private int barStatusBarHeight = 0;
    ArrayList<CalenderBean> cacheCalendarLists = new ArrayList<>();
    private String currentPageUserCode = "";
    private int distance;
    private LinearLayout errorPageView;
    private int hasMore = -1;
    int hgtTip = 1;
    private int historyHasMore = -1;
    private IRecyclerView irc;
    private boolean isErrorRefresh = false;
    private boolean isHasCalendarPermission = false;
    private boolean isHttpRequestFinish = true;
    private boolean isMoreThanZero = false;
    private boolean isPulling = false;
    private boolean isRefreshing = false;
    private Activity mActivity;
    private Handler mHandler = new d();
    private int mHistoryPagingKey = 1;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayout mLvTitleView;
    private LinearLayout mLvTransferLayout;
    private int mPagingKey = 1;
    private TickletListAdapter mTickletListAdapter;
    private TextView mTvTransferMessage;
    private List<PerformTable> mUnUsedLocalPerformTables = new ArrayList();
    private List<PerformTable> mUnUsedNetWorkPerformTables = new ArrayList();
    private LinearLayout mllSeeTip;
    private LinearLayout mllVerifyTicket;
    private int movedDistance = 0;
    private int page = 1;
    private TextView ticklet_perform_list_footer;
    private int transferNum;
    private UTTimeUtils utTimeUtils;

    /* compiled from: Taobao */
    public class a implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PerformTable a;

        a(PerformTable performTable) {
            this.a = performTable;
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1238398336")) {
                ipChange.ipc$dispatch("-1238398336", new Object[]{this});
            } else if (TickletListFragment.this.getActivity() != null && !TickletListFragment.this.getActivity().isFinishing()) {
                TickletListFragment.this.getContext();
            }
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-252627142")) {
                ipChange.ipc$dispatch("-252627142", new Object[]{this});
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", this.a.performId);
            hashMap.put("contentlabel", this.a.getProjectName());
            hashMap.put("begintime", this.a.getStartTimeByLong() + "");
            cn.damai.common.user.c.e().A(hashMap, "calendar_delete", sl2.TICKLET_LIST_PAGE);
        }
    }

    /* compiled from: Taobao */
    public class b implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CalenderBean a;
        final /* synthetic */ PerformTable b;

        b(CalenderBean calenderBean, PerformTable performTable) {
            this.a = calenderBean;
            this.b = performTable;
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "979359617")) {
                ipChange.ipc$dispatch("979359617", new Object[]{this});
            } else if (TickletListFragment.this.getActivity() != null && !TickletListFragment.this.getActivity().isFinishing() && TickletListFragment.this.getContext() != null) {
                TickletListFragment.this.cacheCalendarLists.add(this.a);
                HashMap hashMap = new HashMap();
                hashMap.put("titlelabel", this.b.performId);
                hashMap.put("contentlabel", this.b.getProjectName());
                hashMap.put("begintime", this.b.getStartTimeByLong() + "");
                cn.damai.common.user.c.e().A(hashMap, "calendar_add", sl2.TICKLET_LIST_PAGE);
            }
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-507363687")) {
                ipChange.ipc$dispatch("-507363687", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2006656298")) {
                    ipChange.ipc$dispatch("2006656298", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                jp1.f(TickletListFragment.this.getActivity());
            }
        }

        /* compiled from: Taobao */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b(c cVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1318729975")) {
                    ipChange.ipc$dispatch("-1318729975", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        c() {
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "258174881")) {
                ipChange.ipc$dispatch("258174881", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "799212694")) {
                ipChange.ipc$dispatch("799212694", new Object[]{this});
                return;
            }
            Utils.c();
            TickletListFragment tickletListFragment = TickletListFragment.this;
            tickletListFragment.addCalendarEvent(tickletListFragment.mUnUsedNetWorkPerformTables);
            TickletListFragment.this.mllSeeTip.setVisibility(8);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-467915689")) {
                ipChange.ipc$dispatch("-467915689", new Object[]{this, strArr});
                return;
            }
            fp1.a(TickletListFragment.this.getActivity(), "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new a(), new b(this));
        }
    }

    /* compiled from: Taobao */
    public class d extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void handleMessage(Message message) {
            Object obj;
            QueryPerformListResultEntryData queryPerformListResultEntryData;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1280863040")) {
                ipChange.ipc$dispatch("1280863040", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            if (message.what == 1 && (obj = message.obj) != null && (obj instanceof QueryPerformListResultEntryData) && (queryPerformListResultEntryData = (QueryPerformListResultEntryData) obj) != null && queryPerformListResultEntryData.getUserPerformVOList() != null && queryPerformListResultEntryData.getUserPerformVOList().size() > 0) {
                DMProgressDialog dMProgressDialog = TickletListFragment.this.progressDialog;
                if (dMProgressDialog != null && dMProgressDialog.isShowing()) {
                    TickletListFragment.this.stopProgressDialog();
                }
                TickletListFragment.this.refreshUI((QueryPerformListResultEntryData) message.obj, true);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements PullToRefreshHeaderView.PullToRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView.PullToRefreshListener
        public void onComplete() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1174333560")) {
                ipChange.ipc$dispatch("-1174333560", new Object[]{this});
                return;
            }
            TickletListFragment.this.irc.setInterceptOnTouchEvent(false);
            TickletListFragment.this.isPulling = false;
            g91.b(TickletListFragment.TAG, "scroll: onComplete");
            if (TickletListFragment.this.movedDistance > 0) {
                TickletListFragment.this.movedDistance = 0;
            }
        }

        @Override // cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView.PullToRefreshListener
        public void onMove(boolean z, boolean z2, int i, boolean z3) {
            IpChange ipChange = $ipChange;
            boolean z4 = true;
            if (AndroidInstantRuntime.support(ipChange, "692297377")) {
                ipChange.ipc$dispatch("692297377", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Boolean.valueOf(z3)});
                return;
            }
            TickletListFragment.this.mLvTransferLayout.setVisibility(8);
            if (i > 0) {
                TickletListFragment.this.isMoreThanZero = true;
                TickletListFragment.this.isPulling = true;
            }
            if (TickletListFragment.this.isMoreThanZero && i == 0) {
                TickletListFragment.this.isPulling = false;
                TickletListFragment.this.isMoreThanZero = false;
            }
            g91.b(TickletListFragment.TAG, "scroll: onMove" + i);
            TickletListFragment.this.movedDistance = i;
            IRecyclerView iRecyclerView = TickletListFragment.this.irc;
            if (!z3 || !z2) {
                z4 = false;
            }
            iRecyclerView.setInterceptOnTouchEvent(z4);
        }
    }

    /* compiled from: Taobao */
    public class f implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1408749632")) {
                ipChange.ipc$dispatch("1408749632", new Object[]{this, obj});
                return;
            }
            TickletListFragment.this.onRefresh();
        }
    }

    static /* synthetic */ int access$712(TickletListFragment tickletListFragment, int i) {
        int i2 = tickletListFragment.distance + i;
        tickletListFragment.distance = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e A[Catch:{ Exception -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    private void addCalendar(List<PerformTable> list) {
        int i;
        int i2;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359004107")) {
            ipChange.ipc$dispatch("1359004107", new Object[]{this, list});
        } else if (getActivity() != null && !getActivity().isFinishing() && getContext() != null) {
            String c2 = cn.damai.commonbusiness.util.b.b().c(getContext(), cn.damai.commonbusiness.util.b.CALENDAR_CACHE_FILE_NAME);
            if (!TextUtils.isEmpty(c2)) {
                this.cacheCalendarLists.clear();
                ArrayList<CalenderBean> a2 = p41.a(c2, CalenderBean.class);
                this.cacheCalendarLists = a2;
                if (!(a2 == null || a2.size() == 0)) {
                    i = this.cacheCalendarLists.size();
                    for (i2 = 0; i2 < list.size(); i2++) {
                        try {
                            PerformTable performTable = list.get(i2);
                            if (!(performTable == null || performTable.startTimeByLong == 0)) {
                                if (i > 0) {
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= i) {
                                            break;
                                        }
                                        CalenderBean calenderBean = this.cacheCalendarLists.get(i3);
                                        if (performTable.getStartTimeByLong() != calenderBean.beginTime || ((!TextUtils.isEmpty(calenderBean.projectName) || !TextUtils.isEmpty(performTable.getProjectName())) && (TextUtils.isEmpty(performTable.getProjectName()) || !performTable.getProjectName().equals(calenderBean.projectName)))) {
                                            i3++;
                                        }
                                    }
                                    if (gl2.PERFORM_CANCEL.equals(performTable.getPerformStatus())) {
                                        CalendarsResolver.i().k(new a(performTable));
                                        CalendarsResolver.i().h(getContext(), performTable.getProjectName(), performTable.getStartTimeByLong());
                                    }
                                    z = true;
                                    if (!z && !CalendarsResolver.i().j(getContext(), performTable.getProjectName(), performTable.startTimeByLong) && !gl2.PERFORM_CANCEL.equals(performTable.getPerformStatus())) {
                                        String str = "";
                                        if (!"1".equals(performTable.getIsLongtermProject())) {
                                            str = getResources().getString(R$string.ticklet_perform_add_calender_date, b30.h(Long.valueOf(performTable.getStartTimeByLong()), "yyyy-MM-dd HH:mm"), b30.h(Long.valueOf(performTable.getEndTime()), "yyyy-MM-dd HH:mm"));
                                        }
                                        CalenderBean calenderBean2 = new CalenderBean();
                                        calenderBean2.projectName = performTable.getProjectName();
                                        calenderBean2.beginTime = performTable.startTimeByLong;
                                        CalendarsResolver.i().k(new b(calenderBean2, performTable));
                                        if (performTable.getUserVenueVO() == null) {
                                            CalendarsResolver l = CalendarsResolver.i().l(1440);
                                            Context context = getContext();
                                            String projectName = performTable.getProjectName();
                                            String venueDetailAddress = performTable.getVenueDetailAddress();
                                            l.d(context, projectName, venueDetailAddress, performTable.getVenueName() + " " + str, performTable.startTimeByLong);
                                        } else {
                                            CalendarsResolver.i().l(1440).b(getContext(), performTable.getProjectName(), str, performTable.startTimeByLong);
                                        }
                                    }
                                }
                                z = false;
                                String str2 = "";
                                if (!"1".equals(performTable.getIsLongtermProject())) {
                                }
                                CalenderBean calenderBean22 = new CalenderBean();
                                calenderBean22.projectName = performTable.getProjectName();
                                calenderBean22.beginTime = performTable.startTimeByLong;
                                CalendarsResolver.i().k(new b(calenderBean22, performTable));
                                if (performTable.getUserVenueVO() == null) {
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (i >= this.cacheCalendarLists.size()) {
                        cn.damai.commonbusiness.util.b.b().d(getContext(), cn.damai.commonbusiness.util.b.CALENDAR_CACHE_FILE_NAME, p41.b(this.cacheCalendarLists));
                        return;
                    }
                    return;
                }
            }
            i = 0;
            while (i2 < list.size()) {
            }
            if (i >= this.cacheCalendarLists.size()) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addCalendarEvent(final List<PerformTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86456679")) {
            ipChange.ipc$dispatch("86456679", new Object[]{this, list});
            return;
        }
        boolean i = hp1.i(lp1.CALENDAR);
        this.isHasCalendarPermission = i;
        if (i) {
            ns1.a(new PriorityTask("PERFORM_LIST_CALENDAR_UPDATE_DATA", this) {
                /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass10 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.util.PriorityTask
                public void doTask() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-930497420")) {
                        ipChange.ipc$dispatch("-930497420", new Object[]{this});
                        return;
                    }
                    TickletListFragment.this.addCalendar(list);
                }
            });
        }
    }

    private void alarm(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511370458")) {
            ipChange.ipc$dispatch("-511370458", new Object[]{this, str, str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.i());
        dr.INSTANCE.a().a(str3).c(str).d(str2).e(hashMap).g("票列表页面").j(sl2.TICKLET_LIST_PAGE).f(false).b();
    }

    private void errorRefreshAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "615306696")) {
            ipChange.ipc$dispatch("615306696", new Object[]{this});
        } else if (this.isErrorRefresh) {
            this.errorPageView.setVisibility(8);
            this.isErrorRefresh = false;
        }
    }

    private void fetchHistoryListData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003703825")) {
            ipChange.ipc$dispatch("-2003703825", new Object[]{this});
        } else if (LoginManager.k().q()) {
            this.isHttpRequestFinish = false;
            if (islistEmpty()) {
                startProgressDialog();
            }
            TickletHistoryListRequest tickletHistoryListRequest = new TickletHistoryListRequest();
            tickletHistoryListRequest.pageNo = this.mHistoryPagingKey;
            tickletHistoryListRequest.pageSize = "5";
            tickletHistoryListRequest.request(new DMMtopRequestListener<QueryPerformListResultEntryData>(QueryPerformListResultEntryData.class) {
                /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass8 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "959394588")) {
                        ipChange.ipc$dispatch("959394588", new Object[]{this, str, str2});
                        return;
                    }
                    TickletListFragment.this.stopProgressDialog();
                    TickletListFragment.this.isHttpRequestFinish = true;
                    if (!TextUtils.isEmpty(str2)) {
                        ToastUtil.i(str2);
                    }
                    TickletListFragment.this.isShowHttpErrorView(str2, str, "mtop.damai.wireless.ticklet2.performs.history.get");
                    TickletListFragment.this.historyPerformListErrorXFlushMonitor(str, str2);
                }

                public void onSuccess(QueryPerformListResultEntryData queryPerformListResultEntryData) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-154677845")) {
                        ipChange.ipc$dispatch("-154677845", new Object[]{this, queryPerformListResultEntryData});
                        return;
                    }
                    TickletListFragment.this.stopProgressDialog();
                    TickletListFragment.this.refreshHistoryUI(queryPerformListResultEntryData);
                    vl2.b(vl2.TICKLET_PERFORM_LIST_POINT, "mtop.damai.wireless.ticklet2.performs.history.get");
                }
            });
        }
    }

    private void fetchTickletLisServertData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898448696")) {
            ipChange.ipc$dispatch("-1898448696", new Object[]{this});
        } else if (LoginManager.k().q()) {
            this.currentPageUserCode = fs1.c();
            final long currentTimeMillis = System.currentTimeMillis();
            this.isHttpRequestFinish = false;
            this.irc.setRefreshEnabled(true);
            TickletListRequest tickletListRequest = new TickletListRequest();
            tickletListRequest.pageNo = this.mPagingKey;
            tickletListRequest.pageSize = "5";
            tickletListRequest.request(new DMMtopRequestListener<QueryPerformListResultEntryData>(QueryPerformListResultEntryData.class) {
                /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass7 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "967153947")) {
                        ipChange.ipc$dispatch("967153947", new Object[]{this, str, str2});
                        return;
                    }
                    TickletListFragment.this.isHttpRequestFinish = true;
                    TickletListFragment.this.transferNum = 0;
                    TickletListFragment.this.stopProgressDialog();
                    if (!TextUtils.isEmpty(str2)) {
                        ToastUtil.i(str2);
                    }
                    TickletListFragment.this.isShowHttpErrorView(str2, str, "mtop.damai.wireless.ticklet2.performs.get");
                    TickletListFragment.this.performListErrorXFlushMonitor(str, str2);
                }

                public void onSuccess(QueryPerformListResultEntryData queryPerformListResultEntryData) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "328997482")) {
                        ipChange.ipc$dispatch("328997482", new Object[]{this, queryPerformListResultEntryData});
                        return;
                    }
                    TickletListFragment.this.stopProgressDialog();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (queryPerformListResultEntryData != null) {
                        if (queryPerformListResultEntryData.getServerTimestamp() != null) {
                            b30.d(queryPerformListResultEntryData.getServerTimestamp().longValue());
                        }
                        queryPerformListResultEntryData.setLoadTime(currentTimeMillis - currentTimeMillis);
                    }
                    TickletListFragment.this.refreshUI(queryPerformListResultEntryData, false);
                    vl2.b(vl2.TICKLET_PERFORM_LIST_POINT, "mtop.damai.wireless.ticklet2.performs.get");
                }
            });
        } else {
            refreshLoginUI();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fetchTickletListData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797588251")) {
            ipChange.ipc$dispatch("-1797588251", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            cn.damai.common.user.c.e().A(sl2.j().p("-1", d20.E()), sl2.CUSTOM_TICKLET_LIST_STATUS, sl2.TICKLET_LIST_PAGE);
            refreshLoginUI();
        } else if (hl2.a().booleanValue()) {
            if (islistEmpty()) {
                startProgressDialog();
            }
            fetchTickletListLocalData();
            fetchTickletLisServertData();
        } else {
            if (islistEmpty()) {
                startProgressDialog();
            }
            fetchTickletLisServertData();
        }
    }

    private void fetchTickletListLocalData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195932538")) {
            ipChange.ipc$dispatch("-195932538", new Object[]{this});
        } else if (LoginManager.k().q()) {
            ns1.a(new PriorityTask("PERFORM_LIST_DB_GET_DATA", this) {
                /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass6 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.util.PriorityTask
                public void doTask() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1331400429")) {
                        ipChange.ipc$dispatch("-1331400429", new Object[]{this});
                        return;
                    }
                    QueryPerformListResultEntryData list = DataHelper.getInstance().getList(TickletListFragment.this.page);
                    if (TickletListFragment.this.mHandler != null && TickletListFragment.this.mHandler.obtainMessage() != null) {
                        Message obtainMessage = TickletListFragment.this.mHandler.obtainMessage();
                        obtainMessage.what = 1;
                        obtainMessage.obj = list;
                        TickletListFragment.this.mHandler.sendMessage(obtainMessage);
                    }
                }
            });
        } else {
            refreshLoginUI();
        }
    }

    private void fetchTickletListMoreData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593532208")) {
            ipChange.ipc$dispatch("-1593532208", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            refreshLoginUI();
        } else if (this.hasMore != 0) {
            if (hl2.a().booleanValue()) {
                fetchTickletListLocalData();
            }
            if (this.isHttpRequestFinish && this.hasMore == 1) {
                fetchTickletLisServertData();
            }
        } else if (this.historyHasMore != 0 && this.isHttpRequestFinish) {
            loadHistoryRequest(false);
        }
    }

    private void handleEmptyPage(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731490823")) {
            ipChange.ipc$dispatch("-731490823", new Object[]{this, Boolean.valueOf(z), str});
        } else if (!islistEmpty()) {
            this.irc.setVisibility(0);
            this.errorPageView.setVisibility(8);
            this.irc.getFooterContainer().setVisibility(0);
            if (!TextUtils.isEmpty(str)) {
                this.ticklet_perform_list_footer.setText(str);
            }
            this.isHttpRequestFinish = true;
        } else if (!z) {
            if (islistEmpty()) {
                refreshLoginUI();
            }
            this.isHttpRequestFinish = true;
        }
    }

    private void handleFromTouch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041577812")) {
            ipChange.ipc$dispatch("-2041577812", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        Handler handler = new Handler();
        if (arguments != null) {
            String string = arguments.getString("from");
            if (TextUtils.isEmpty(string) || !string.equals("from_3dtouch")) {
                fetchTickletListData();
            } else {
                handler.postDelayed(new Runnable() {
                    /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1597189376")) {
                            ipChange.ipc$dispatch("-1597189376", new Object[]{this});
                            return;
                        }
                        TickletListFragment.this.fetchTickletListData();
                        cn.damai.common.user.c.e().A(sl2.j().h(d20.E()), sl2.CUSTOM_TICKLET_3DTOUCH, sl2.TICKLET_LIST_PAGE);
                    }
                }, 100);
            }
        } else {
            fetchTickletListData();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void historyPerformListErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218314828")) {
            ipChange.ipc$dispatch("-218314828", new Object[]{this, str, str2});
            return;
        }
        vl2.a(vl2.TICKLET_PERFORM_LIST_POINT, vl2.f(vl2.TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG_HISTORY_PERFORMS, "mtop.damai.wireless.ticklet2.performs.history.get", str, str2, ""), vl2.TICKLET_PERFORM_LIST_NETWORK_ERROR_CODE, vl2.TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG);
    }

    private void initErrorPageView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821241619")) {
            ipChange.ipc$dispatch("-821241619", new Object[]{this});
            return;
        }
        this.errorPageView = (LinearLayout) this.rootView.findViewById(R$id.errorPageView);
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1398967484")) {
            ipChange.ipc$dispatch("1398967484", new Object[]{this});
            return;
        }
        this.irc = (IRecyclerView) this.rootView.findViewById(R$id.ticklet_irecyclerview);
        TickletListAdapter tickletListAdapter = new TickletListAdapter(getContext());
        this.mTickletListAdapter = tickletListAdapter;
        tickletListAdapter.l(this);
        this.irc.setAdapter(this.mTickletListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.irc.setLayoutManager(this.mLinearLayoutManager);
        this.irc.setRefreshEnabled(true);
        this.irc.setIsAutoToDefault(false);
        this.irc.setOnRefreshListener(this);
        this.irc.setOnLoadMoreListener(this);
        this.irc.setLoadMoreEnabled(true);
        this.irc.setHasFixedSize(true);
        PullToRefreshHeaderView instance = PullToRefreshHeaderView.getInstance(this.mActivity);
        this.irc.setRefreshHeaderView(instance);
        instance.setPullToRefreshListener(new e());
        this.irc.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1840820542")) {
                    ipChange.ipc$dispatch("1840820542", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
                g91.b(TickletListFragment.TAG, "scroll: onScrollStateChanged = " + i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "963528993")) {
                    ipChange.ipc$dispatch("963528993", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                g91.b(TickletListFragment.TAG, "scroll:  dy: " + i2);
                if (!TickletListFragment.this.isPulling) {
                    TickletListFragment.access$712(TickletListFragment.this, i2);
                    g91.b(TickletListFragment.TAG, "scroll:  distance: " + TickletListFragment.this.distance);
                    int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                    g91.b(TickletListFragment.TAG, "scroll: firstCompletelyVisibleItemPosition: " + findFirstCompletelyVisibleItemPosition);
                    if (findFirstCompletelyVisibleItemPosition == 0) {
                        g91.b(TickletListFragment.TAG, "scroll: firstCompletelyVisibleItemPosition 滑动到顶部");
                        TickletListFragment.this.distance = 0;
                    }
                    if (TickletListFragment.this.transferNum > 0) {
                        int i3 = TickletListFragment.this.distance;
                        TickletListFragment tickletListFragment = TickletListFragment.this;
                        if (i3 < tickletListFragment.hgtTip) {
                            tickletListFragment.mLvTransferLayout.setVisibility(8);
                            TickletListFragment.this.bannerLoginView.getJaiTransferView().setVisibility(0);
                            return;
                        }
                        tickletListFragment.mLvTransferLayout.setVisibility(0);
                        TickletListFragment.this.bannerLoginView.getJaiTransferView().setVisibility(4);
                    }
                }
            }
        });
    }

    private void initNoLoginLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906464841")) {
            ipChange.ipc$dispatch("-906464841", new Object[]{this});
            return;
        }
        LinearLayout headerContainer = this.irc.getHeaderContainer();
        TickletPerformBannerLoginView tickletPerformBannerLoginView = new TickletPerformBannerLoginView(getContext(), getActivity(), (String) null);
        this.bannerLoginView = tickletPerformBannerLoginView;
        tickletPerformBannerLoginView.isShowBannerLoginView(false);
        this.bannerLoginView.setBannerLoginCallback(this);
        this.bannerLoginView.setPadding(0, v50.a(getContext(), 12.0f), 0, 0);
        this.irc.addHeaderView(this.bannerLoginView);
        View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.tickletperform_loadmore_footer, (ViewGroup) headerContainer, false);
        this.ticklet_perform_list_footer = (TextView) inflate.findViewById(R$id.ticklet_perform_list_footer);
        this.irc.addFooterView(inflate);
        this.irc.getFooterContainer().setVisibility(8);
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185984980")) {
            ipChange.ipc$dispatch("-1185984980", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R$id.ticklet_list_title);
        this.mLvTitleView = linearLayout;
        View findViewById = linearLayout.findViewById(R$id.title_status_bar_space_view);
        LinearLayout linearLayout2 = (LinearLayout) this.mLvTitleView.findViewById(R$id.ticklet_list_ll_verify_icon);
        this.mllVerifyTicket = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.mLvTitleView.findViewById(R$id.ticklet_list_ll_see_tip);
        this.mllSeeTip = linearLayout3;
        linearLayout3.setOnClickListener(this);
        setImmersionStyle(findViewById);
    }

    private void initTransferViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321375674")) {
            ipChange.ipc$dispatch("-321375674", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R$id.ticklet_transfer_message_layout);
        this.mLvTransferLayout = linearLayout;
        this.mTvTransferMessage = (TextView) linearLayout.findViewById(R$id.ticklet_transfer_message_content_tv);
        this.mLvTransferLayout.setOnClickListener(this);
        this.mLvTransferLayout.setVisibility(8);
        rr.b(this.mLvTransferLayout, Color.parseColor("#00ffffff"), v50.a(getContext(), 9.0f), Color.parseColor("#266a7a99"), v50.a(getContext(), 9.0f), 0, v50.a(getContext(), 6.0f));
    }

    private boolean isHaveTicklet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584442767")) {
            return ((Boolean) ipChange.ipc$dispatch("-1584442767", new Object[]{this})).booleanValue();
        }
        List<PerformTable> list = this.mUnUsedNetWorkPerformTables;
        if (list != null && list.size() > 0) {
            return true;
        }
        List<PerformTable> list2 = this.mUnUsedLocalPerformTables;
        return list2 != null && list2.size() > 0;
    }

    private String isHistoryMsg() {
        List<PerformTable> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794994394")) {
            return (String) ipChange.ipc$dispatch("-1794994394", new Object[]{this});
        }
        String i = lw2.f().i(getContext(), this.mBaseActivity, R$string.ticklet_perform_data_load_finish);
        return (this.mHistoryPagingKey != 1 || (list = this.mUnUsedNetWorkPerformTables) == null || list.size() <= 0) ? i : "还没有历史票哦~";
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void isShowHttpErrorView(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371931129")) {
            ipChange.ipc$dispatch("1371931129", new Object[]{this, str, str2, str3});
            return;
        }
        this.isErrorRefresh = false;
        g91.b(TAG, "setRefreshing isShowHttpErrorView");
        setRefeshAninEnd();
        if (islistEmpty()) {
            this.irc.setVisibility(8);
            this.errorPageView.setVisibility(0);
            onResponseError(str, str2, str3, this.errorPageView, true);
            alarm(str2, str, str3);
        }
    }

    private boolean islistEmpty() {
        List<PerformTable> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419850936")) {
            return ((Boolean) ipChange.ipc$dispatch("1419850936", new Object[]{this})).booleanValue();
        }
        List<PerformTable> list2 = this.mUnUsedLocalPerformTables;
        return (list2 == null || list2.size() <= 0) && ((list = this.mUnUsedNetWorkPerformTables) == null || list.size() <= 0);
    }

    private void loadHistoryRequest(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350564316")) {
            ipChange.ipc$dispatch("-350564316", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.hasMore == 0 && !z) {
            fetchHistoryListData();
        }
    }

    public static TickletListFragment newInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299785317")) {
            return (TickletListFragment) ipChange.ipc$dispatch("-299785317", new Object[]{str});
        }
        TickletListFragment tickletListFragment = new TickletListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", str);
        tickletListFragment.setArguments(bundle);
        return tickletListFragment;
    }

    private void notEmptyListUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771866587")) {
            ipChange.ipc$dispatch("-1771866587", new Object[]{this});
            return;
        }
        TickletPerformBannerLoginView tickletPerformBannerLoginView = this.bannerLoginView;
        if (tickletPerformBannerLoginView != null) {
            tickletPerformBannerLoginView.notEmptyListUI();
        }
    }

    private void onListenerCommentPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75806727")) {
            ipChange.ipc$dispatch("-75806727", new Object[]{this});
            return;
        }
        this.mDMMessage.b("comment_publish_success", new f());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void performListErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-531474168")) {
            ipChange.ipc$dispatch("-531474168", new Object[]{this, str, str2});
            return;
        }
        vl2.a(vl2.TICKLET_PERFORM_LIST_POINT, vl2.f(vl2.TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG_PERFORM, "mtop.damai.wireless.ticklet2.performs.get", str, str2, ""), vl2.TICKLET_PERFORM_LIST_NETWORK_ERROR_CODE, vl2.TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshHistoryUI(QueryPerformListResultEntryData queryPerformListResultEntryData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1108019784")) {
            ipChange.ipc$dispatch("1108019784", new Object[]{this, queryPerformListResultEntryData});
            return;
        }
        g91.b(TAG, "setRefreshing refreshHistoryUI");
        setRefeshAninEnd();
        this.irc.setVisibility(0);
        errorRefreshAction();
        if (queryPerformListResultEntryData != null) {
            this.historyHasMore = Integer.parseInt(queryPerformListResultEntryData.getHasMore());
            List<PerformTable> userPerformVOList = queryPerformListResultEntryData.getUserPerformVOList();
            if (userPerformVOList == null || userPerformVOList.size() <= 0) {
                handleEmptyPage(false, isHistoryMsg());
                return;
            }
            if (this.mHistoryPagingKey == 1) {
                PerformTable performTable = new PerformTable();
                performTable.sepType = 1;
                this.mUnUsedNetWorkPerformTables.add(performTable);
            }
            int i = this.mHistoryPagingKey + 1;
            this.mHistoryPagingKey = i;
            this.mHistoryPagingKey = i;
            this.mUnUsedNetWorkPerformTables.addAll(lw2.f().b(userPerformVOList));
            this.mTickletListAdapter.setData(this.mUnUsedNetWorkPerformTables);
            notEmptyListUI();
            this.irc.getFooterContainer().setVisibility(0);
            if (this.historyHasMore == 0) {
                this.ticklet_perform_list_footer.setText(lw2.f().i(getContext(), this.mBaseActivity, R$string.ticklet_perform_data_load_finish));
            } else {
                this.ticklet_perform_list_footer.setText(lw2.f().i(getContext(), this.mBaseActivity, R$string.ticklet_perform_data_load_more));
            }
            this.isHttpRequestFinish = true;
            g91.b(TAG, "网络结束历史数据：共" + this.mHistoryPagingKey + "页,共" + this.mUnUsedNetWorkPerformTables.size() + "条");
            return;
        }
        handleEmptyPage(false, isHistoryMsg());
    }

    private void refreshLoginUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452080497")) {
            ipChange.ipc$dispatch("-452080497", new Object[]{this});
            return;
        }
        this.irc.setVisibility(0);
        this.errorPageView.setVisibility(8);
        resetPageState();
        if (LoginManager.k().q()) {
            this.bannerLoginView.update(TickletPerformBannerLoginView.LIST_DATA_EMPTY);
            this.irc.setRefreshEnabled(true);
            this.irc.getFooterContainer().setVisibility(8);
            return;
        }
        this.irc.setRefreshEnabled(false);
        this.irc.getFooterContainer().setVisibility(8);
        this.bannerLoginView.update(TickletPerformBannerLoginView.LIST_NO_LOGIN);
        this.mLvTransferLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshUI(QueryPerformListResultEntryData queryPerformListResultEntryData, boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133230798")) {
            ipChange.ipc$dispatch("-133230798", new Object[]{this, queryPerformListResultEntryData, Boolean.valueOf(z)});
            return;
        }
        g91.b(TAG, "setRefreshing refreshUI");
        setRefeshAninEnd();
        if (queryPerformListResultEntryData != null) {
            if (!z) {
                int i2 = this.mPagingKey + 1;
                this.mPagingKey = i2;
                this.mPagingKey = i2;
                this.hasMore = Integer.parseInt(queryPerformListResultEntryData.getHasMore());
                showTransfer(queryPerformListResultEntryData.getTransferRecvNum());
                showHeadTip(queryPerformListResultEntryData.globalHeadTips, z);
            }
            List<PerformTable> userPerformVOList = queryPerformListResultEntryData.getUserPerformVOList();
            if (userPerformVOList == null || userPerformVOList.size() <= 0) {
                loadHistoryRequest(z);
            } else {
                this.utTimeUtils.l();
                this.irc.setVisibility(0);
                errorRefreshAction();
                notEmptyListUI();
                if (z) {
                    this.utTimeUtils.m(queryPerformListResultEntryData.getLoadTime());
                    this.irc.getFooterContainer().setVisibility(8);
                    this.mUnUsedLocalPerformTables.addAll(lw2.f().b(userPerformVOList));
                    this.mTickletListAdapter.setData(this.mUnUsedLocalPerformTables);
                    this.utTimeUtils.p(this.mActivity.getWindow().getDecorView());
                    g91.b(TAG, "本地数据：第" + this.page + "页,本页" + userPerformVOList.size() + "条数据。页面显示" + this.mUnUsedLocalPerformTables.size() + "条");
                    this.page = this.page + 1;
                } else {
                    this.utTimeUtils.q(queryPerformListResultEntryData.getLoadTime());
                    boolean a2 = Utils.a();
                    if (!hp1.i(lp1.CALENDAR) || !a2) {
                        this.mllSeeTip.setVisibility(0);
                        HashMap hashMap = new HashMap();
                        hashMap.put("usercode", d20.E());
                        hashMap.put("city", d20.d());
                        cn.damai.common.user.c.e().G(this.mllSeeTip, NotificationCompat.CATEGORY_REMINDER, "top", sl2.TICKLET_LIST_PAGE, hashMap);
                    } else {
                        this.mllSeeTip.setVisibility(8);
                        addCalendarEvent(userPerformVOList);
                    }
                    this.irc.getFooterContainer().setVisibility(0);
                    this.ticklet_perform_list_footer.setText(lw2.f().i(getContext(), this.mBaseActivity, R$string.ticklet_perform_data_load_more));
                    this.mUnUsedNetWorkPerformTables.addAll(lw2.f().b(userPerformVOList));
                    if (this.mUnUsedNetWorkPerformTables.size() >= this.mUnUsedLocalPerformTables.size() || (i = this.hasMore) == 0) {
                        this.mTickletListAdapter.setData(this.mUnUsedNetWorkPerformTables);
                        this.isHttpRequestFinish = true;
                        this.utTimeUtils.p(this.mActivity.getWindow().getDecorView());
                        g91.b(TAG, "网络结束数据：共" + this.mPagingKey + "页,共" + this.mUnUsedNetWorkPerformTables.size() + "条");
                    } else if (i == 1) {
                        fetchTickletLisServertData();
                        g91.b(TAG, "网络轮询：第" + this.mPagingKey + "页," + this.mUnUsedNetWorkPerformTables.size() + "条");
                    }
                    loadHistoryRequest(z);
                    saveOrUpdatePerforms(userPerformVOList);
                }
            }
        } else {
            handleEmptyPage(z, "");
        }
        if (z) {
            return;
        }
        if (isHaveTicklet()) {
            cn.damai.common.user.c.e().A(sl2.j().p("1", d20.E()), sl2.CUSTOM_TICKLET_LIST_STATUS, sl2.TICKLET_LIST_PAGE);
        } else {
            cn.damai.common.user.c.e().A(sl2.j().p("0", d20.E()), sl2.CUSTOM_TICKLET_LIST_STATUS, sl2.TICKLET_LIST_PAGE);
        }
    }

    private void requestCalendarPermission() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "27981597")) {
            ipChange.ipc$dispatch("27981597", new Object[]{this});
            return;
        }
        new Permission(getContext(), new PermissionModel(lp1.CALENDAR, "日历权限使用说明", Integer.valueOf(R$drawable.pemission_calendar_icon), "观演提醒服务需要获取您的日历权限，以便开演前自动提醒您准时观演。您同意授权日历权限开启该服务后，票夹里未观演场次（含日后新增场次）将会收到观演提醒。")).a(new c()).b();
    }

    private void resetPageState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469496674")) {
            ipChange.ipc$dispatch("-469496674", new Object[]{this});
            return;
        }
        this.mTickletListAdapter.clear();
        this.mUnUsedLocalPerformTables.clear();
        this.mUnUsedNetWorkPerformTables.clear();
        this.errorPageView.setVisibility(8);
        this.mPagingKey = 1;
        this.hasMore = -1;
        this.historyHasMore = -1;
        this.mHistoryPagingKey = 1;
        this.page = 1;
        this.transferNum = 0;
        this.ticklet_perform_list_footer.setText("");
    }

    private void rollNotOver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-18967313")) {
            ipChange.ipc$dispatch("-18967313", new Object[]{this});
            return;
        }
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass14 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1471105993")) {
                    ipChange.ipc$dispatch("-1471105993", new Object[]{this});
                    return;
                }
                g91.b(TickletListFragment.TAG, "setRefreshing rollNotOver");
                TickletListFragment.this.isRefreshing = true;
                TickletListFragment.this.setRefeshAninEnd();
            }
        }, 2000);
    }

    private void saveOrUpdatePerforms(final List<PerformTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404253497")) {
            ipChange.ipc$dispatch("-404253497", new Object[]{this, list});
            return;
        }
        ns1.a(new PriorityTask("PERFORM_LIST_DB_UPDATE_DATA", this) {
            /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.util.PriorityTask
            public void doTask() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2083357846")) {
                    ipChange.ipc$dispatch("2083357846", new Object[]{this});
                    return;
                }
                DataHelper.getInstance().saveOrUpdatePerformTables(list, gl2.c);
            }
        });
    }

    private void setImmersionStyle(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1230098303")) {
            ipChange.ipc$dispatch("-1230098303", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (view != null) {
                view.getLayoutParams().height = ne2.a(getActivity());
                view.setVisibility(0);
                this.barStatusBarHeight = view.getLayoutParams().height;
            }
            ne2.f(getActivity(), true, R$color.black);
            ne2.d(true, getActivity());
        } else {
            ne2.f(getActivity(), false, R$color.black);
            if (view != null) {
                view.setVisibility(8);
                this.barStatusBarHeight = 0;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRefeshAninEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1982802705")) {
            ipChange.ipc$dispatch("1982802705", new Object[]{this});
            return;
        }
        g91.b(TAG, "setRefeshAninEnd");
        if (this.isRefreshing) {
            g91.b(TAG, "setRefreshing false");
            this.isRefreshing = false;
            this.irc.setRefreshing(false);
        }
    }

    private void setTransferLayoutExposure(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "820762469")) {
            ipChange.ipc$dispatch("820762469", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        cn.damai.common.user.c.e().G(this.bannerLoginView.getJaiTransferView(), "transferother_msg", "top", sl2.TICKLET_LIST_PAGE, hashMap);
    }

    private void showHeadTip(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737362895")) {
            ipChange.ipc$dispatch("737362895", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        TickletPerformBannerLoginView tickletPerformBannerLoginView = this.bannerLoginView;
        if (tickletPerformBannerLoginView != null) {
            tickletPerformBannerLoginView.setHeadTips(str, z);
        }
    }

    private void showTransfer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691877299")) {
            ipChange.ipc$dispatch("691877299", new Object[]{this, str});
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            this.transferNum = parseInt;
            if (parseInt <= 0 || getContext() == null || getActivity() == null || getActivity().isFinishing()) {
                this.mLvTransferLayout.setVisibility(8);
                this.bannerLoginView.getJaiTransferView().setVisibility(8);
                return;
            }
            String string = getContext().getResources().getString(R$string.ticklet_perform_transfer_num, String.valueOf(this.transferNum));
            this.mLvTransferLayout.setVisibility(8);
            this.mTvTransferMessage.setText(string);
            this.bannerLoginView.getJaiTransferView().setVisibility(0);
            this.bannerLoginView.getJaiTransferMessageView().setText(string);
            setTransferLayoutExposure(string);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showVerifyTicketEntry(boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1664167883")) {
            ipChange.ipc$dispatch("1664167883", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (OrangeConfigCenter.c().a(ol1.a, "nfc_open", 1) == 0) {
            z2 = false;
        }
        if (!z || !z2) {
            this.mllVerifyTicket.setVisibility(8);
        } else {
            this.mllVerifyTicket.setVisibility(0);
        }
    }

    private void verifyTicketEntryRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1651412655")) {
            ipChange.ipc$dispatch("1651412655", new Object[]{this});
            return;
        }
        new TickletVerifyRequest().request(new DMMtopRequestListener<TicketVerifyEntryData>(TicketVerifyEntryData.class) {
            /* class cn.damai.ticklet.ui.fragment.TickletListFragment.AnonymousClass15 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1631653888")) {
                    ipChange.ipc$dispatch("-1631653888", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(TicketVerifyEntryData ticketVerifyEntryData) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1644804416")) {
                    ipChange.ipc$dispatch("-1644804416", new Object[]{this, ticketVerifyEntryData});
                    return;
                }
                TickletListFragment.this.showVerifyTicketEntry(ticketVerifyEntryData.isHasEntrance);
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "845058078")) {
            return R$layout.ticklet_tickletlist_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("845058078", new Object[]{this})).intValue();
    }

    public void gotoDetailPage(String str, int i, Map<String, String> map, String str2, String str3) {
        TicketDeatilResult deatilList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "713472398")) {
            ipChange.ipc$dispatch("713472398", new Object[]{this, str, Integer.valueOf(i), map, str2, str3});
            return;
        }
        Intent intent = new Intent(getContext(), TicketDeatilActivity.class);
        Bundle bundle = new Bundle();
        if ("history".equals(str)) {
            bundle.putBoolean("history", true);
        } else if (LoginManager.k().q() && hl2.a().booleanValue() && (deatilList = DataHelper.getInstance().getDeatilList(1, str2, str3)) != null && deatilList.getUserPerformVO() != null) {
            bundle.putSerializable("ticketDeatilResult", deatilList);
        }
        cn.damai.common.user.c.e().x(sl2.j().G(i, map));
        bundle.putString(TicketDetailExtFragment.PERFORM_ID, str2);
        bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str3);
        bundle.putString("from", TicketDeatilActivity.FROM_LIST);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // cn.damai.ticklet.view.TickletPerformBannerLoginView.TickletBannerLoginCallBack
    public void gotoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695630259")) {
            ipChange.ipc$dispatch("1695630259", new Object[]{this});
            return;
        }
        cn.damai.common.user.c.e().x(sl2.j().H());
        LoginManager.k().y(this, new Intent(), 2000);
    }

    @Override // cn.damai.ticklet.view.TickletPerformBannerLoginView.TickletBannerLoginCallBack
    public void gotoTransferAccept() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520905563")) {
            ipChange.ipc$dispatch("1520905563", new Object[]{this});
            return;
        }
        cn.damai.common.user.c.e().x(sl2.j().Q());
        Intent intent = new Intent(this.mActivity, TicketDetailAcceptTransferActivity.class);
        intent.putExtra("from", TicketDeatilActivity.FROM_LIST);
        this.mActivity.startActivity(intent);
    }

    @Override // cn.damai.ticklet.view.TickletPerformBannerLoginView.TickletBannerLoginCallBack
    public void gotoVerifyTicket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382105015")) {
            ipChange.ipc$dispatch("-382105015", new Object[]{this});
            return;
        }
        cn.damai.common.user.c.e().x(sl2.j().N());
        this.utTimeUtils.k();
        DMNav.from(this.mActivity).toUri("damai://V1/Flutter?flutter_path=dm_ticket_nfc");
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1067908438")) {
            ipChange.ipc$dispatch("-1067908438", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.isErrorRefresh = true;
        onRefresh();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669529407")) {
            ipChange.ipc$dispatch("-1669529407", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958803652")) {
            ipChange.ipc$dispatch("-958803652", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        initTitleView();
        initIRecyclerView();
        initTransferViews();
        initNoLoginLayout();
        initErrorPageView();
        this.utTimeUtils.n();
        handleFromTouch();
        onListenerCommentPublishSuccess();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889426398")) {
            ipChange.ipc$dispatch("-1889426398", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.ticklet_list_ll_verify_icon) {
            gotoVerifyTicket();
        } else if (id == R$id.ticklet_list_ll_see_tip) {
            requestCalendarPermission();
            cn.damai.common.user.c.e().x(sl2.j().R());
        } else if (id == R$id.ticklet_transfer_message_layout) {
            gotoTransferAccept();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814884994")) {
            ipChange.ipc$dispatch("-1814884994", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.utTimeUtils = new UTTimeUtils(UTTimeUtils.o);
        setDamaiUTKeyBuilder(sl2.j().k(sl2.TICKLET_LIST_PAGE));
        LoginManager.k().c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681132094")) {
            ipChange.ipc$dispatch("1681132094", new Object[]{this});
            return;
        }
        super.onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.mHandler = null;
        }
        LoginManager.k().C(this);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374821925")) {
            ipChange.ipc$dispatch("-374821925", new Object[]{this, view});
            return;
        }
        fetchTickletListMoreData();
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693840085")) {
            ipChange.ipc$dispatch("693840085", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634244145")) {
            ipChange.ipc$dispatch("634244145", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708225976")) {
            ipChange.ipc$dispatch("1708225976", new Object[]{this});
            return;
        }
        if (TextUtils.isEmpty(this.currentPageUserCode) || ((!TextUtils.isEmpty(this.currentPageUserCode) && !this.currentPageUserCode.equals(d20.i())) || (!TextUtils.isEmpty(d20.i()) && !d20.i().equals(fs1.c())))) {
            fl2.a();
        }
        this.bannerLoginView.isShowBannerLoginView(false);
        onRefresh();
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8999864")) {
            ipChange.ipc$dispatch("-8999864", new Object[]{this});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863559294")) {
            ipChange.ipc$dispatch("-1863559294", new Object[]{this});
            return;
        }
        super.onPause();
        TickletPerformBannerLoginView tickletPerformBannerLoginView = this.bannerLoginView;
        if (tickletPerformBannerLoginView != null) {
            tickletPerformBannerLoginView.getmBannerStop();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-100786243")) {
            ipChange.ipc$dispatch("-100786243", new Object[]{this});
        } else if (this.isHttpRequestFinish) {
            this.utTimeUtils.k();
            this.isRefreshing = true;
            resetPageState();
            fetchTickletListData();
        } else {
            rollNotOver();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287976763")) {
            ipChange.ipc$dispatch("-287976763", new Object[]{this});
            return;
        }
        super.onResume();
        if (!LoginManager.k().q()) {
            refreshLoginUI();
        }
        verifyTicketEntryRequest();
    }

    @Override // cn.damai.ticklet.view.TickletPerformBannerLoginView.TickletBannerLoginCallBack
    public void setNoticeHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910472949")) {
            ipChange.ipc$dispatch("-1910472949", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.hgtTip = i;
    }
}
