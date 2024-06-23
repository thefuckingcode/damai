package cn.damai.ticklet.ui.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TickletFaceBindResult;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.net.TickletFaceBindRequest;
import cn.damai.ticklet.ui.adapter.TickletFaceToBindTicketAdapter;
import cn.damai.ticklet.view.TickletFaceBindResultView;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.g91;
import tb.sl2;
import tb.v50;
import tb.vl2;

/* compiled from: Taobao */
public class TickletFaceBindFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = TickletFaceBindFragment.class.getSimpleName();
    private LinearLayout llCompleteButton;
    private LinearLayout mErrorPageView;
    private IRecyclerView mFaceBindRecyclerView;
    private String mFaceId;
    private List<UserTicketTable> mFaceUnbindTicketList;
    private TickletFaceToBindTicketAdapter mFaceUnbindTicketsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayout mLvFaceBindHeader;
    private View.OnClickListener mOnCompleteClickListener;
    private OnFaceBindListener mOnFaceBindListener;
    private View.OnClickListener mOnRebindFaceClickListener;
    private TickletFaceToBindTicketAdapter.OnToBindFaceClickListener mOnToBindFaceClickListener;
    private String mPerformId;
    private String mTicketId;
    private TextView mTvFaceBindStatus;
    private TextView mTvFaceUnbindTicketsTitle;
    private TextView mTvRebindComplete;
    private TickletFaceBindResultView mViewFaceBindResultMsg;
    private String projectId;

    /* compiled from: Taobao */
    public interface OnFaceBindListener {
        void onFaceBind(boolean z);

        void onFaceBindComplete();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-704036277")) {
                ipChange.ipc$dispatch("-704036277", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(sl2.j().C(TickletFaceBindFragment.this.projectId, TickletFaceBindFragment.this.mPerformId, TickletFaceBindFragment.this.mTicketId, TickletFaceBindFragment.this.mTvFaceBindStatus.getText().toString()));
            TickletFaceBindFragment.this.executeFaceBindRequest();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1407254092")) {
                ipChange.ipc$dispatch("1407254092", new Object[]{this, view});
            } else if (TickletFaceBindFragment.this.mOnFaceBindListener != null) {
                TickletFaceBindFragment.this.mOnFaceBindListener.onFaceBindComplete();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements TickletFaceToBindTicketAdapter.OnToBindFaceClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.ticklet.ui.adapter.TickletFaceToBindTicketAdapter.OnToBindFaceClickListener
        public void onToBindFace(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1282346468")) {
                ipChange.ipc$dispatch("-1282346468", new Object[]{this, str, str2});
                return;
            }
            TickletFaceBindFragment.this.mFaceBindRecyclerView.setVisibility(8);
            TickletFaceBindFragment.this.llCompleteButton.setVisibility(8);
            TickletFaceBindFragment.this.mErrorPageView.setVisibility(8);
            TickletFaceBindFragment.this.mFaceId = str;
            TickletFaceBindFragment.this.mTicketId = str2;
            TickletFaceBindFragment.this.executeFaceBindRequest();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void bindPerformDetailErrorXFlushMonitor(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806379638")) {
            ipChange.ipc$dispatch("-1806379638", new Object[]{this, str, str2, str3, str4});
            return;
        }
        vl2.d(vl2.f(vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_BIND, "mtop.damai.wireless.ticklet2.perform.detail.get", str, str2, "faceId:" + str3 + ", voucherUniqueKey:" + str4), vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_CODE, str, vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void executeFaceBindRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207427085")) {
            ipChange.ipc$dispatch("1207427085", new Object[]{this});
            return;
        }
        startProgressDialog();
        TickletFaceBindRequest tickletFaceBindRequest = new TickletFaceBindRequest();
        tickletFaceBindRequest.faceId = this.mFaceId;
        tickletFaceBindRequest.ticketId = this.mTicketId;
        tickletFaceBindRequest.request(new DMMtopRequestListener<TickletFaceBindResult>(TickletFaceBindResult.class) {
            /* class cn.damai.ticklet.ui.fragment.TickletFaceBindFragment.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "187701940")) {
                    ipChange.ipc$dispatch("187701940", new Object[]{this, str, str2});
                    return;
                }
                TickletFaceBindFragment.this.stopProgressDialog();
                g91.b(TickletFaceBindFragment.TAG, "TickletFaceBindRequest, onFail().");
                TickletFaceBindFragment.this.showFaceBindErrorPage(str, str2);
                TickletFaceBindFragment tickletFaceBindFragment = TickletFaceBindFragment.this;
                tickletFaceBindFragment.bindPerformDetailErrorXFlushMonitor(str, str2, tickletFaceBindFragment.mFaceId, TickletFaceBindFragment.this.mTicketId);
            }

            public void onSuccess(TickletFaceBindResult tickletFaceBindResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1970592982")) {
                    ipChange.ipc$dispatch("1970592982", new Object[]{this, tickletFaceBindResult});
                    return;
                }
                TickletFaceBindFragment.this.stopProgressDialog();
                g91.b(TickletFaceBindFragment.TAG, "TickletFaceBindRequest, onSuccess().");
                TickletFaceBindFragment.this.showFaceBindResultPage();
                TickletFaceBindFragment.this.processFaceBindResult(tickletFaceBindResult);
            }
        });
    }

    private Drawable getStatusIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559182803")) {
            return (Drawable) ipChange.ipc$dispatch("1559182803", new Object[]{this, Integer.valueOf(i)});
        }
        try {
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return null;
            }
            int a2 = v50.a(getActivity(), 30.0f);
            drawable.setBounds(0, 0, a2, a2);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private void initErrorPageView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787708625")) {
            ipChange.ipc$dispatch("787708625", new Object[]{this});
            return;
        }
        this.mErrorPageView = (LinearLayout) this.rootView.findViewById(R$id.ticklet_face_bind_error_page);
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421940306")) {
            ipChange.ipc$dispatch("-1421940306", new Object[]{this});
            return;
        }
        this.mOnRebindFaceClickListener = new a();
        this.mOnCompleteClickListener = new b();
        this.mOnToBindFaceClickListener = new c();
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107810713")) {
            ipChange.ipc$dispatch("1107810713", new Object[]{this});
            return;
        }
        this.mFaceBindRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.ticklet_face_bind_recyclerview);
        this.mFaceUnbindTicketList = new ArrayList();
        TickletFaceToBindTicketAdapter tickletFaceToBindTicketAdapter = new TickletFaceToBindTicketAdapter(getActivity(), this.mFaceUnbindTicketList);
        this.mFaceUnbindTicketsAdapter = tickletFaceToBindTicketAdapter;
        this.mFaceBindRecyclerView.setAdapter(tickletFaceToBindTicketAdapter);
        this.mFaceUnbindTicketsAdapter.d(this.projectId);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.mFaceBindRecyclerView.setLayoutManager(this.mLinearLayoutManager);
        this.mFaceBindRecyclerView.setRefreshEnabled(false);
        this.mFaceBindRecyclerView.setIsAutoToDefault(false);
        this.mFaceBindRecyclerView.setLoadMoreEnabled(false);
    }

    private void initRecyclerViewHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29637428")) {
            ipChange.ipc$dispatch("-29637428", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R$layout.ticklet_face_bind_head_layout, (ViewGroup) this.mFaceBindRecyclerView, false);
        this.mLvFaceBindHeader = linearLayout;
        this.mTvFaceBindStatus = (TextView) linearLayout.findViewById(R$id.ticklet_face_bind_state_tv);
        this.mViewFaceBindResultMsg = (TickletFaceBindResultView) this.mLvFaceBindHeader.findViewById(R$id.ticklet_face_bind_result_msg_cv);
        TextView textView = (TextView) this.mLvFaceBindHeader.findViewById(R$id.face_unbind_ticket_title_tv);
        this.mTvFaceUnbindTicketsTitle = textView;
        textView.setVisibility(8);
        this.mFaceBindRecyclerView.addHeaderView(this.mLvFaceBindHeader);
        this.mLvFaceBindHeader.setVisibility(8);
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972346593")) {
            ipChange.ipc$dispatch("-972346593", new Object[]{this});
            return;
        }
        this.llCompleteButton = (LinearLayout) this.rootView.findViewById(R$id.ll_face_complete);
        this.mTvRebindComplete = (TextView) this.rootView.findViewById(R$id.rebind_complete_tv);
        this.llCompleteButton.setVisibility(8);
        initRecyclerView();
        initRecyclerViewHeader();
        initErrorPageView();
    }

    public static Fragment newInstance(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919079778")) {
            return (Fragment) ipChange.ipc$dispatch("919079778", new Object[]{bundle});
        }
        TickletFaceBindFragment tickletFaceBindFragment = new TickletFaceBindFragment();
        if (bundle != null) {
            tickletFaceBindFragment.setArguments(bundle);
        }
        return tickletFaceBindFragment;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processFaceBindResult(TickletFaceBindResult tickletFaceBindResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626705768")) {
            ipChange.ipc$dispatch("626705768", new Object[]{this, tickletFaceBindResult});
        } else if (tickletFaceBindResult != null) {
            String str = tickletFaceBindResult.opResult;
            String str2 = TAG;
            g91.b(str2, "face bind result, opResult = " + str);
            if ("1".equals(str)) {
                showFaceBindSuccess(tickletFaceBindResult);
                resetRebindCompleteBtn(true, getResources().getString(R$string.ticklet_face_bind_complete), this.mOnCompleteClickListener);
                updateFaceBindResult(true);
            } else if ("0".equals(str)) {
                showFaceBindFailure(tickletFaceBindResult);
                resetRebindCompleteBtn(false, getResources().getString(R$string.ticklet_face_rebind), this.mOnRebindFaceClickListener);
                bindPerformDetailErrorXFlushMonitor(vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_BIND_FAIL, tickletFaceBindResult.subFailNote, this.mFaceId, this.mTicketId);
                updateFaceBindResult(false);
            } else if ("-1".equals(str)) {
                showFaceBindFailure(tickletFaceBindResult);
                resetRebindCompleteBtn(false, "", null);
                updateFaceBindResult(false);
            }
        } else {
            renderErrorXFlushMonitor(vl2.TICKLET_PERFORM_DETAIL_RENDER_BIND_FAIL_MSG, this.mTicketId);
        }
    }

    private void renderErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542239877")) {
            ipChange.ipc$dispatch("542239877", new Object[]{this, str, str2});
            return;
        }
        vl2.d(vl2.f(vl2.TICKLET_PERFORM_DETAIL_RENDER_BIND_FAIL_MSG, "", "", str, "voucherUniqueKey:" + str2), vl2.TICKLET_PERFORM_DETAIL_RENDER_ERROR_CODE, "", "票夹场次详情渲染失败");
    }

    private void resetRebindCompleteBtn(boolean z, String str, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632802724")) {
            ipChange.ipc$dispatch("1632802724", new Object[]{this, Boolean.valueOf(z), str, onClickListener});
        } else if (TextUtils.isEmpty(str) || onClickListener == null) {
            this.llCompleteButton.setVisibility(8);
            this.mTvRebindComplete.setText("");
            this.mTvRebindComplete.setOnClickListener(null);
        } else {
            this.llCompleteButton.setVisibility(0);
            this.mTvRebindComplete.setText(str);
            this.mTvRebindComplete.setOnClickListener(onClickListener);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.llCompleteButton.getLayoutParams();
            this.mTvRebindComplete.setBackgroundResource(R$drawable.ticklet_face_rebind_complete_btn_bg);
            this.mTvRebindComplete.setTextColor(getResources().getColor(R$color.white));
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            ((LinearLayout.LayoutParams) this.mTvRebindComplete.getLayoutParams()).rightMargin = 0;
        }
    }

    private void setBindStatus(int i, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187358846")) {
            ipChange.ipc$dispatch("-187358846", new Object[]{this, Integer.valueOf(i), str, Integer.valueOf(i2)});
            return;
        }
        Drawable statusIcon = getStatusIcon(i);
        if (statusIcon != null) {
            this.mTvFaceBindStatus.setCompoundDrawables(statusIcon, null, null, null);
            this.mTvFaceBindStatus.setCompoundDrawablePadding(v50.a(getActivity(), 5.0f));
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTvFaceBindStatus.setVisibility(0);
            this.mTvFaceBindStatus.setTextColor(i2);
            this.mTvFaceBindStatus.setText(str);
            return;
        }
        this.mTvFaceBindStatus.setVisibility(8);
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1754612043")) {
            ipChange.ipc$dispatch("1754612043", new Object[]{this});
            return;
        }
        this.mFaceUnbindTicketsAdapter.c(this.mOnToBindFaceClickListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showFaceBindErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494447727")) {
            ipChange.ipc$dispatch("-1494447727", new Object[]{this, str, str2});
            return;
        }
        this.mFaceBindRecyclerView.setVisibility(8);
        this.llCompleteButton.setVisibility(8);
        this.mErrorPageView.setVisibility(0);
        onResponseError(str2, str, "mtop.damai.wireless.ticklet.face.binding", this.mErrorPageView, true);
    }

    private void showFaceBindFailure(TickletFaceBindResult tickletFaceBindResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402661035")) {
            ipChange.ipc$dispatch("-1402661035", new Object[]{this, tickletFaceBindResult});
            return;
        }
        String str = tickletFaceBindResult.opResultMsg;
        String str2 = tickletFaceBindResult.opResultNote;
        String str3 = tickletFaceBindResult.subFailNote;
        setBindStatus(R$drawable.ticklet_face_bind_failure_icon, str, getResources().getColor(R$color.color_111111));
        this.mViewFaceBindResultMsg.setFailureMessage(str2, str3);
        this.mTvFaceUnbindTicketsTitle.setVisibility(8);
        this.mLvFaceBindHeader.setVisibility(0);
        this.mFaceUnbindTicketList.clear();
        this.mFaceUnbindTicketsAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showFaceBindResultPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907528726")) {
            ipChange.ipc$dispatch("-1907528726", new Object[]{this});
            return;
        }
        this.mErrorPageView.setVisibility(8);
        this.mFaceBindRecyclerView.setVisibility(0);
    }

    private void showFaceBindSuccess(TickletFaceBindResult tickletFaceBindResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1772884018")) {
            ipChange.ipc$dispatch("-1772884018", new Object[]{this, tickletFaceBindResult});
            return;
        }
        setBindStatus(R$drawable.ticklet_face_bind_success_icon, tickletFaceBindResult.opResultMsg, getResources().getColor(R$color.color_ff2d79));
        this.mViewFaceBindResultMsg.setBindSuccessMessage(getResources().getString(R$string.ticklet_face_bind_note, TextUtils.isEmpty(tickletFaceBindResult.faceCertName) ? "" : tickletFaceBindResult.faceCertName), tickletFaceBindResult.fullSeatInfo, tickletFaceBindResult.faceCertNo);
        this.mLvFaceBindHeader.setVisibility(0);
        List<UserTicketTable> list = tickletFaceBindResult.ticketInfoList;
        if (list == null || list.size() <= 0) {
            this.mTvFaceUnbindTicketsTitle.setVisibility(8);
        } else {
            this.mTvFaceUnbindTicketsTitle.setVisibility(0);
        }
        this.mFaceUnbindTicketList.clear();
        this.mFaceUnbindTicketList.addAll(list);
        this.mFaceUnbindTicketsAdapter.notifyDataSetChanged();
    }

    private void updateFaceBindResult(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-689376313")) {
            ipChange.ipc$dispatch("-689376313", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        OnFaceBindListener onFaceBindListener = this.mOnFaceBindListener;
        if (onFaceBindListener != null) {
            onFaceBindListener.onFaceBind(z);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1840958974")) {
            return R$layout.ticklet_fragment_face_bind;
        }
        return ((Integer) ipChange.ipc$dispatch("-1840958974", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681538490")) {
            ipChange.ipc$dispatch("-1681538490", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        executeFaceBindRequest();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782775461")) {
            ipChange.ipc$dispatch("782775461", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938393304")) {
            ipChange.ipc$dispatch("938393304", new Object[]{this});
            return;
        }
        initViews();
        initListeners();
        setupListeners();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554596335")) {
            ipChange.ipc$dispatch("-554596335", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        executeFaceBindRequest();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1434168795")) {
            ipChange.ipc$dispatch("1434168795", new Object[]{this, activity});
            return;
        }
        super.onAttach(activity);
        try {
            this.mOnFaceBindListener = (OnFaceBindListener) activity;
        } catch (ClassCastException unused) {
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942545086")) {
            ipChange.ipc$dispatch("1942545086", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012114018")) {
            ipChange.ipc$dispatch("1012114018", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.projectId = arguments.getString("projectId");
            this.mPerformId = arguments.getString(TicketDetailExtFragment.PERFORM_ID);
            this.mTicketId = arguments.getString("voucherUniqueKey");
            this.mFaceId = arguments.getString("faceId");
        }
    }
}
