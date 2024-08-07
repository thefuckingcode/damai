package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.servicenotice.OnCompleteListener;
import cn.damai.commonbusiness.servicenotice.ProjectTicketNoticeAdapter;
import cn.damai.commonbusiness.servicenotice.TicketNoteList;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.NoticeMatter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.AnchorIndicatorView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.a5;
import tb.ut1;
import tb.xf2;

/* compiled from: Taobao */
public class ProjectNoticeMatterFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private int displayPage;
    private AnchorIndicatorView mAnchorIndicator;
    private NoticeMatter mNoticeMatter;
    private View.OnClickListener mOnCompleteClickListener;
    private OnCompleteListener mOnCompleteListener;
    private long mProjectId;
    private ProjectTicketNoticeAdapter mProjectNoticeMatterAdapter;
    private DMIconFontTextView tvComplete;
    private ViewPager viewPager;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "950876082")) {
                ipChange.ipc$dispatch("950876082", new Object[]{this, view});
            } else if (ProjectNoticeMatterFragment.this.mOnCompleteListener != null) {
                ProjectNoticeMatterFragment.this.mOnCompleteListener.onComplete(1);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements AnchorIndicatorView.OnAnchorItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.AnchorIndicatorView.OnAnchorItemClickListener
        public void onAnchorItemClick(int i, a5 a5Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-840181363")) {
                ipChange.ipc$dispatch("-840181363", new Object[]{this, Integer.valueOf(i), a5Var});
                return;
            }
            ProjectNoticeMatterFragment.this.viewPager.setCurrentItem(i);
        }
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-591172692")) {
            ipChange.ipc$dispatch("-591172692", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mProjectId = arguments.getLong("projectId");
            this.displayPage = arguments.getInt("displayPage", -1);
            Parcelable parcelable = arguments.getParcelable("notice_matter");
            if (parcelable != null) {
                this.mNoticeMatter = (NoticeMatter) parcelable;
            }
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511593689")) {
            ipChange.ipc$dispatch("-511593689", new Object[]{this});
            return;
        }
        this.mOnCompleteClickListener = new a();
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345479448")) {
            ipChange.ipc$dispatch("345479448", new Object[]{this});
            return;
        }
        AnchorIndicatorView anchorIndicatorView = (AnchorIndicatorView) this.rootView.findViewById(R$id.project_item_notice);
        this.mAnchorIndicator = anchorIndicatorView;
        anchorIndicatorView.setAnchorFontColor(getResources().getColor(R$color.color_000000), getResources().getColor(R$color.color_9C9CA5));
        this.tvComplete = (DMIconFontTextView) this.rootView.findViewById(R$id.project_notice_matter_complete_btn_tv);
        this.viewPager = (ViewPager) this.rootView.findViewById(R$id.project_notice_matter_view_pager);
        ProjectTicketNoticeAdapter projectTicketNoticeAdapter = new ProjectTicketNoticeAdapter(getActivity(), this.mNoticeMatter.getNoticeList());
        this.mProjectNoticeMatterAdapter = projectTicketNoticeAdapter;
        this.viewPager.setAdapter(projectTicketNoticeAdapter);
        this.viewPager.setCurrentItem(this.displayPage);
    }

    public static ProjectNoticeMatterFragment newInstance(long j, int i, NoticeMatter noticeMatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2096350378")) {
            return (ProjectNoticeMatterFragment) ipChange.ipc$dispatch("2096350378", new Object[]{Long.valueOf(j), Integer.valueOf(i), noticeMatter});
        }
        ProjectNoticeMatterFragment projectNoticeMatterFragment = new ProjectNoticeMatterFragment();
        if (noticeMatter != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("notice_matter", noticeMatter);
            bundle.putLong("projectId", j);
            bundle.putInt("displayPage", i);
            projectNoticeMatterFragment.setArguments(bundle);
        }
        return projectNoticeMatterFragment;
    }

    private void setExtraData() {
        List<TicketNoteList> noticeList;
        int e;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1278731676")) {
            ipChange.ipc$dispatch("1278731676", new Object[]{this});
            return;
        }
        NoticeMatter noticeMatter = this.mNoticeMatter;
        if (noticeMatter == null || (e = xf2.e((noticeList = noticeMatter.getNoticeList()))) <= 0) {
            return;
        }
        if (e == 1) {
            TicketNoteList ticketNoteList = noticeList.get(0);
            String noteTitle = ticketNoteList != null ? ticketNoteList.getNoteTitle() : "购票须知";
            a5 a5Var = new a5();
            a5Var.e(noteTitle);
            a5Var.f(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a5Var);
            this.mAnchorIndicator.setAnchorList(arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        TicketNoteList ticketNoteList2 = noticeList.get(0);
        if ((ticketNoteList2 != null) && (xf2.e(ticketNoteList2.getTicketNoteList()) > 0)) {
            a5 a5Var2 = new a5();
            a5Var2.e(ticketNoteList2.getNoteTitle());
            a5Var2.f(0);
            arrayList2.add(a5Var2);
        }
        TicketNoteList ticketNoteList3 = noticeList.get(1);
        boolean z2 = ticketNoteList3 != null;
        if (xf2.e(ticketNoteList3.getTicketNoteList()) > 0) {
            z = true;
        }
        if (z2 && z) {
            a5 a5Var3 = new a5();
            a5Var3.e(ticketNoteList3.getNoteTitle());
            a5Var3.f(1);
            arrayList2.add(a5Var3);
        }
        this.mAnchorIndicator.setAnchorList(arrayList2);
        int i = this.displayPage;
        if (i != -1) {
            this.viewPager.setCurrentItem(i);
            this.mAnchorIndicator.setSelectAnchor(this.displayPage);
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89413902")) {
            ipChange.ipc$dispatch("-89413902", new Object[]{this});
            return;
        }
        this.mAnchorIndicator.setOnAnchorItemClickListener(new b());
        this.tvComplete.setOnClickListener(this.mOnCompleteClickListener);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectNoticeMatterFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "828896542")) {
                    ipChange.ipc$dispatch("828896542", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1551663037")) {
                    ipChange.ipc$dispatch("1551663037", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1860436457")) {
                    ipChange.ipc$dispatch("1860436457", new Object[]{this, Integer.valueOf(i)});
                } else if (ProjectNoticeMatterFragment.this.mAnchorIndicator != null) {
                    ProjectNoticeMatterFragment.this.mAnchorIndicator.setSelectAnchor(i);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-291203333")) {
            return R$layout.project_item_pop_notice_matter_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-291203333", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672963501")) {
            ipChange.ipc$dispatch("1672963501", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693122078")) {
            ipChange.ipc$dispatch("1693122078", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1651495489")) {
            ipChange.ipc$dispatch("-1651495489", new Object[]{this});
            return;
        }
        initExtraData();
        initViews();
        initListeners();
        setupListeners();
        setExtraData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341386872")) {
            ipChange.ipc$dispatch("341386872", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        int i = this.displayPage;
        if (i == 0) {
            setDamaiUTKeyBuilder(ut1.b(this.mProjectId));
        } else if (i == 1) {
            setDamaiUTKeyBuilder(ut1.c(this.mProjectId));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-373411944")) {
            ipChange.ipc$dispatch("-373411944", new Object[]{this, context});
            return;
        }
        super.onAttach(context);
        try {
            if (getParentFragment() != null) {
                this.mOnCompleteListener = (OnCompleteListener) getParentFragment();
            } else {
                this.mOnCompleteListener = (OnCompleteListener) context;
            }
        } catch (ClassCastException unused) {
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571931163")) {
            ipChange.ipc$dispatch("-571931163", new Object[]{this, view});
        }
    }
}
