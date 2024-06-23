package cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponCreditsBean;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.presenter.VIPCreditExchangePresenter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.adapter.VIPCreditExchangeAdapter;
import com.alibaba.pictures.bricks.view.BricksThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g90;
import tb.k21;
import tb.m40;
import tb.qu2;
import tb.ru2;
import tb.su2;
import tb.ta;
import tb.ur2;

/* compiled from: Taobao */
public final class VIPCreditExchangePopFragment extends DamaiBaseMvpFragment<VIPCreditExchangePresenter, VIPCreditExchangeContract.Model> implements VIPCreditExchangeContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private VIPCreditExchangeAdapter adapter;
    @Nullable
    private View closeBtn;
    @Nullable
    private View.OnClickListener closeListener;
    @Nullable
    private TextView creditExchangeExtView;
    @Nullable
    private TextView creditExchangeTv;
    @Nullable
    private View creditExchangeView;
    @Nullable
    private TextView creditStockView;
    @Nullable
    private TextView creditTotalView;
    @Nullable
    private TextView creditView;
    @Nullable
    private ProjectMemberPrompt data;
    @Nullable
    private IExchangeResult exchangeListener;
    @Nullable
    private RecyclerView recycleView;
    @Nullable
    private TextView titleTv;

    /* compiled from: Taobao */
    public interface IExchangeResult {
        void exchangeResult(boolean z);
    }

    /* compiled from: Taobao */
    public static final class ItemDecoration extends RecyclerView.ItemDecoration {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1793244360")) {
                ipChange.ipc$dispatch("-1793244360", new Object[]{this, rect, view, recyclerView, state});
                return;
            }
            k21.i(rect, "outRect");
            k21.i(view, "view");
            k21.i(recyclerView, "parent");
            k21.i(state, "state");
            super.getItemOffsets(rect, view, recyclerView, state);
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            k21.f(layoutManager);
            if (childLayoutPosition == layoutManager.getItemCount() - 1) {
                rect.set(0, 0, 0, g90.a(9.0f));
            }
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final VIPCreditExchangePopFragment a(@NotNull ProjectMemberPrompt projectMemberPrompt, @Nullable IExchangeResult iExchangeResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "416058164")) {
                return (VIPCreditExchangePopFragment) ipChange.ipc$dispatch("416058164", new Object[]{this, projectMemberPrompt, iExchangeResult});
            }
            k21.i(projectMemberPrompt, "data");
            VIPCreditExchangePopFragment vIPCreditExchangePopFragment = new VIPCreditExchangePopFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", projectMemberPrompt);
            vIPCreditExchangePopFragment.setArguments(bundle);
            vIPCreditExchangePopFragment.setExchangeListener(iExchangeResult);
            return vIPCreditExchangePopFragment;
        }
    }

    private final String formatStock(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221866068")) {
            return (String) ipChange.ipc$dispatch("-221866068", new Object[]{this, l});
        } else if (l == null) {
            return null;
        } else {
            if (l.longValue() < 10000) {
                return "剩余" + l + (char) 20221;
            }
            try {
                return "剩余" + new DecimalFormat("0.0") + "万份";
            } catch (Exception unused) {
                return "剩余" + l + (char) 20221;
            }
        }
    }

    private final void setupView() {
        String buttonStatus;
        String str;
        String str2;
        String userScore;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1025161038")) {
            ipChange.ipc$dispatch("-1025161038", new Object[]{this});
            return;
        }
        TextView textView = this.titleTv;
        String str3 = null;
        if (textView != null) {
            ProjectMemberPrompt projectMemberPrompt = this.data;
            textView.setText(projectMemberPrompt != null ? projectMemberPrompt.getLayerTitle() : null);
        }
        View view = this.closeBtn;
        if (view != null) {
            view.setOnClickListener(this.closeListener);
        }
        TextView textView2 = this.creditView;
        if (textView2 != null) {
            ProjectMemberPrompt projectMemberPrompt2 = this.data;
            textView2.setText(projectMemberPrompt2 != null ? projectMemberPrompt2.getScore() : null);
        }
        TextView textView3 = this.creditStockView;
        if (textView3 != null) {
            ProjectMemberPrompt projectMemberPrompt3 = this.data;
            textView3.setText(formatStock(projectMemberPrompt3 != null ? projectMemberPrompt3.getPoolRemainingCount() : null));
        }
        TextView textView4 = this.creditStockView;
        if (textView4 != null) {
            CharSequence text = textView4 != null ? textView4.getText() : null;
            textView4.setVisibility(text == null || text.length() == 0 ? 8 : 0);
        }
        TextView textView5 = this.creditTotalView;
        if (textView5 != null) {
            ProjectMemberPrompt projectMemberPrompt4 = this.data;
            if (projectMemberPrompt4 == null || (userScore = projectMemberPrompt4.getUserScore()) == null) {
                str2 = null;
            } else {
                str2 = "你有" + userScore + "积分";
            }
            textView5.setText(str2);
        }
        TextView textView6 = this.creditExchangeTv;
        if (textView6 != null) {
            ProjectMemberPrompt projectMemberPrompt5 = this.data;
            if (projectMemberPrompt5 == null || (str = projectMemberPrompt5.getLayerButtonText()) == null) {
                str = "暂不可兑";
            }
            textView6.setText(str);
        }
        ProjectMemberPrompt projectMemberPrompt6 = this.data;
        if (k21.d(projectMemberPrompt6 != null ? projectMemberPrompt6.getButtonStatus() : null, "10")) {
            TextView textView7 = this.creditExchangeExtView;
            if (textView7 != null) {
                ProjectMemberPrompt projectMemberPrompt7 = this.data;
                textView7.setText(projectMemberPrompt7 != null ? projectMemberPrompt7.getExchangeStartTime() : null);
            }
            TextView textView8 = this.creditExchangeExtView;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
        } else {
            TextView textView9 = this.creditExchangeExtView;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        ProjectMemberPrompt projectMemberPrompt8 = this.data;
        if (projectMemberPrompt8 != null) {
            str3 = projectMemberPrompt8.getButtonStatus();
        }
        if (k21.d(str3, "6")) {
            View view2 = this.creditExchangeView;
            if (view2 != null) {
                view2.setBackgroundResource(R$drawable.vip_credit_exchange_bottom_bg);
            }
            TextView textView10 = this.creditExchangeTv;
            if (textView10 != null) {
                textView10.setTextColor(Color.parseColor("#582331"));
            }
        } else {
            View view3 = this.creditExchangeView;
            if (view3 != null) {
                view3.setBackgroundResource(R$drawable.vip_credit_exchange_bottom_bg_unable);
            }
            TextView textView11 = this.creditExchangeTv;
            if (textView11 != null) {
                textView11.setTextColor(Color.parseColor("#7F582331"));
            }
            TextView textView12 = this.creditExchangeExtView;
            if (textView12 != null) {
                textView12.setTextColor(Color.parseColor("#7F582331"));
            }
        }
        c e = c.e();
        View view4 = this.creditExchangeView;
        HashMap hashMap = new HashMap();
        ProjectMemberPrompt projectMemberPrompt9 = this.data;
        String str4 = "1";
        hashMap.put("preemption_stage", projectMemberPrompt9 != null && projectMemberPrompt9.isPromptBeforeSale() ? str4 : "2");
        ProjectMemberPrompt projectMemberPrompt10 = this.data;
        if (!(projectMemberPrompt10 == null || (buttonStatus = projectMemberPrompt10.getButtonStatus()) == null)) {
            String str5 = (String) hashMap.put("preemption_btn_status", buttonStatus);
        }
        ProjectMemberPrompt projectMemberPrompt11 = this.data;
        if (projectMemberPrompt11 == null || !projectMemberPrompt11.isSpecialBuy()) {
            z = false;
        }
        if (!z) {
            str4 = "0";
        }
        hashMap.put("is_exclusivepurchase", str4);
        ur2 ur2 = ur2.INSTANCE;
        e.G(view4, "exchangebtn", "preemption_layer", ta.PROJECT_PAGE, hashMap);
        View view5 = this.creditExchangeView;
        if (view5 != null) {
            view5.setOnClickListener(new su2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-10  reason: not valid java name */
    public static final void m89setupView$lambda10(VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        Context context;
        String buttonStatus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469249491")) {
            ipChange.ipc$dispatch("1469249491", new Object[]{vIPCreditExchangePopFragment, view});
            return;
        }
        k21.i(vIPCreditExchangePopFragment, "this$0");
        c e = c.e();
        a.b g = new a.b().i(ta.PROJECT_PAGE).f("preemption_layer").l("exchangebtn").g(false);
        HashMap hashMap = new HashMap();
        ProjectMemberPrompt projectMemberPrompt = vIPCreditExchangePopFragment.data;
        String str = "1";
        hashMap.put("is_exclusivepurchase", projectMemberPrompt != null && projectMemberPrompt.isSpecialBuy() ? str : "0");
        ProjectMemberPrompt projectMemberPrompt2 = vIPCreditExchangePopFragment.data;
        if (!(projectMemberPrompt2 != null && projectMemberPrompt2.isPromptBeforeSale())) {
            str = "2";
        }
        hashMap.put("preemption_stage", str);
        ProjectMemberPrompt projectMemberPrompt3 = vIPCreditExchangePopFragment.data;
        if (!(projectMemberPrompt3 == null || (buttonStatus = projectMemberPrompt3.getButtonStatus()) == null)) {
            hashMap.put("preemption_btn_status", buttonStatus);
        }
        ur2 ur2 = ur2.INSTANCE;
        e.x(g.j(hashMap));
        ProjectMemberPrompt projectMemberPrompt4 = vIPCreditExchangePopFragment.data;
        if (k21.d(projectMemberPrompt4 != null ? projectMemberPrompt4.getButtonStatus() : null, "6") && (context = vIPCreditExchangePopFragment.getContext()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("本次兑换将消耗");
            int length = sb.length();
            ProjectMemberPrompt projectMemberPrompt5 = vIPCreditExchangePopFragment.data;
            sb.append(projectMemberPrompt5 != null ? projectMemberPrompt5.getScore() : null);
            int length2 = sb.length();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("积分（当前有");
            ProjectMemberPrompt projectMemberPrompt6 = vIPCreditExchangePopFragment.data;
            sb2.append(projectMemberPrompt6 != null ? projectMemberPrompt6.getUserScore() : null);
            sb2.append("积分）");
            sb.append(sb2.toString());
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F38066")), length, length2, 18);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("使用规则\n");
            ProjectMemberPrompt projectMemberPrompt7 = vIPCreditExchangePopFragment.data;
            sb3.append(projectMemberPrompt7 != null ? projectMemberPrompt7.getExchangeRule() : null);
            SpannableString spannableString2 = new SpannableString(sb3.toString());
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, 4, 18);
            spannableString2.setSpan(new AbsoluteSizeSpan(16, true), 0, 4, 18);
            BricksThemeDialog bricksThemeDialog = new BricksThemeDialog(context);
            bricksThemeDialog.n(R$drawable.score_icon).q(GridBean.TYPE_PIC_URL, 83).p(GridBean.TYPE_PIC_URL, 55).o(R$drawable.score_bg).m("确认兑换此特权吗").l(spannableString).j(spannableString2).k(GravityCompat.START).f(R$drawable.sku_promotion_profit_bg).i("确认兑换", ContextCompat.getColor(context, R$color.color_582331), new ru2(vIPCreditExchangePopFragment)).e(R$drawable.bg_vip_exchange_dialog_cancel).g("取消", Color.parseColor("#F38066"), new qu2(bricksThemeDialog)).h(true, null).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-10$lambda-9$lambda-7  reason: not valid java name */
    public static final void m90setupView$lambda10$lambda9$lambda7(VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360149455")) {
            ipChange.ipc$dispatch("-1360149455", new Object[]{vIPCreditExchangePopFragment, view});
            return;
        }
        k21.i(vIPCreditExchangePopFragment, "this$0");
        vIPCreditExchangePopFragment.showLoading("");
        VIPCreditExchangePresenter vIPCreditExchangePresenter = (VIPCreditExchangePresenter) vIPCreditExchangePopFragment.mPresenter;
        ProjectMemberPrompt projectMemberPrompt = vIPCreditExchangePopFragment.data;
        String str = null;
        String exchange4Dm = projectMemberPrompt != null ? projectMemberPrompt.getExchange4Dm() : null;
        ProjectMemberPrompt projectMemberPrompt2 = vIPCreditExchangePopFragment.data;
        String spreadId = projectMemberPrompt2 != null ? projectMemberPrompt2.getSpreadId() : null;
        ProjectMemberPrompt projectMemberPrompt3 = vIPCreditExchangePopFragment.data;
        if (projectMemberPrompt3 != null) {
            str = projectMemberPrompt3.getAsac();
        }
        vIPCreditExchangePresenter.requestExchange(exchange4Dm, spreadId, "204", str);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-10$lambda-9$lambda-8  reason: not valid java name */
    public static final void m91setupView$lambda10$lambda9$lambda8(BricksThemeDialog bricksThemeDialog, DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847507163")) {
            ipChange.ipc$dispatch("-847507163", new Object[]{bricksThemeDialog, dialogInterface, Integer.valueOf(i)});
            return;
        }
        k21.i(bricksThemeDialog, "$dialog");
        bricksThemeDialog.dismiss();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract.View
    public void exchangeFail(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1747650281")) {
            ipChange.ipc$dispatch("1747650281", new Object[]{this, str, str2});
        } else if (getActivity() != null && !requireActivity().isFinishing()) {
            stopLoading();
            ToastUtil.b("啊哦，兑换失败了~", 1);
            View.OnClickListener onClickListener = this.closeListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.closeBtn);
            }
            IExchangeResult iExchangeResult = this.exchangeListener;
            if (iExchangeResult != null) {
                iExchangeResult.exchangeResult(false);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract.View
    public void exchangeSuccess(@NotNull CouponCreditsBean couponCreditsBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736834136")) {
            ipChange.ipc$dispatch("-1736834136", new Object[]{this, couponCreditsBean});
            return;
        }
        k21.i(couponCreditsBean, "data");
        if (getActivity() != null && !requireActivity().isFinishing()) {
            stopLoading();
            ToastUtil.b("已兑换成功，去购票享优惠吧~", 1);
            View.OnClickListener onClickListener = this.closeListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.closeBtn);
            }
            IExchangeResult iExchangeResult = this.exchangeListener;
            if (iExchangeResult != null) {
                iExchangeResult.exchangeResult(true);
            }
        }
    }

    @Nullable
    public final View.OnClickListener getCloseListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-872214551")) {
            return this.closeListener;
        }
        return (View.OnClickListener) ipChange.ipc$dispatch("-872214551", new Object[]{this});
    }

    @Nullable
    public final IExchangeResult getExchangeListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1154535384")) {
            return this.exchangeListener;
        }
        return (IExchangeResult) ipChange.ipc$dispatch("1154535384", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1177262745")) {
            return R$layout.fragment_vip_creadit_exchange_pop_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1177262745", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738008753")) {
            ipChange.ipc$dispatch("-1738008753", new Object[]{this, Integer.valueOf(i)});
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.VIPCreditExchangePopFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967802692")) {
            ipChange.ipc$dispatch("-967802692", new Object[]{this});
            return;
        }
        ((VIPCreditExchangePresenter) this.mPresenter).mView = this;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688848993")) {
            ipChange.ipc$dispatch("688848993", new Object[]{this});
            return;
        }
        this.titleTv = (TextView) this.rootView.findViewById(R$id.layer_title);
        this.closeBtn = this.rootView.findViewById(R$id.layer_close);
        this.creditView = (TextView) this.rootView.findViewById(R$id.tv_integral_number);
        this.creditStockView = (TextView) this.rootView.findViewById(R$id.tv_stock);
        this.creditTotalView = (TextView) this.rootView.findViewById(R$id.tv_use_integral);
        this.creditExchangeTv = (TextView) this.rootView.findViewById(R$id.btn_exchange);
        this.creditExchangeView = this.rootView.findViewById(R$id.cl_exchange);
        this.creditExchangeExtView = (TextView) this.rootView.findViewById(R$id.btn_exchange_ext);
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R$id.recyclerview);
        this.recycleView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        VIPCreditExchangeAdapter vIPCreditExchangeAdapter = new VIPCreditExchangeAdapter();
        this.adapter = vIPCreditExchangeAdapter;
        RecyclerView recyclerView2 = this.recycleView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(vIPCreditExchangeAdapter);
        }
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new ItemDecoration());
        }
        setupView();
        VIPCreditExchangeAdapter vIPCreditExchangeAdapter2 = this.adapter;
        if (vIPCreditExchangeAdapter2 != null) {
            vIPCreditExchangeAdapter2.a(this.data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1154978330")) {
            ipChange.ipc$dispatch("1154978330", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277987320")) {
            ipChange.ipc$dispatch("-277987320", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343671289")) {
            ipChange.ipc$dispatch("-1343671289", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076345799")) {
            ipChange.ipc$dispatch("-2076345799", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        ProjectMemberPrompt projectMemberPrompt = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("data") : null;
        if (serializable instanceof ProjectMemberPrompt) {
            projectMemberPrompt = (ProjectMemberPrompt) serializable;
        }
        this.data = projectMemberPrompt;
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666121109")) {
            ipChange.ipc$dispatch("-1666121109", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
    }

    public final void setCloseListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1161552685")) {
            ipChange.ipc$dispatch("1161552685", new Object[]{this, onClickListener});
            return;
        }
        this.closeListener = onClickListener;
    }

    public final void setExchangeListener(@Nullable IExchangeResult iExchangeResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742234460")) {
            ipChange.ipc$dispatch("-742234460", new Object[]{this, iExchangeResult});
            return;
        }
        this.exchangeListener = iExchangeResult;
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100041727")) {
            ipChange.ipc$dispatch("2100041727", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254481147")) {
            ipChange.ipc$dispatch("1254481147", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637874079")) {
            ipChange.ipc$dispatch("1637874079", new Object[]{this, str});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.mBaseActivity;
        if (damaiBaseActivity != null) {
            String[] strArr = new String[1];
            if (str == null) {
                str = "";
            }
            strArr[0] = str;
            damaiBaseActivity.showLoading(strArr);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "569439706")) {
            ipChange.ipc$dispatch("569439706", new Object[]{this});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.mBaseActivity;
        if (damaiBaseActivity != null) {
            damaiBaseActivity.hideLoading();
        }
    }
}
