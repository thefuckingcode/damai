package cn.damai.commonbusiness.wannasee.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.wannasee.WantSeeRecommendRequest;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.eb0;
import tb.iy2;
import tb.k21;
import tb.m40;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeeRecommendView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Event = new a(null);
    public static final int TYPE_FOLLOW_CLICK = 3;
    public static final int TYPE_FOLLOW_SUCCESS = 4;
    public static final int TYPE_ITEM_CLICK = 2;
    public static final int TYPE_ITEM_EXPOSURE = 5;
    public static final int TYPE_REFRESH_CLICK = 1;
    private final LinearLayout container;
    private final TextView descTv;
    @Nullable
    private Function4<? super Integer, Object, ? super Integer, ? super View, ur2> onEventListener;
    @Nullable
    private Function1<? super RecommendProjects, ur2> onRefreshSuccess;
    private final DMIconFontTextView refreshTv;
    private final TextView titleTv;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WantSeeRecommendView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m17bindData$lambda0(WantSeeRecommendView wantSeeRecommendView, RecommendProjects recommendProjects, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709814381")) {
            ipChange.ipc$dispatch("-1709814381", new Object[]{wantSeeRecommendView, recommendProjects, view});
            return;
        }
        k21.i(wantSeeRecommendView, "this$0");
        Function4<? super Integer, Object, ? super Integer, ? super View, ur2> function4 = wantSeeRecommendView.onEventListener;
        if (function4 != null) {
            function4.invoke(1, recommendProjects, Integer.valueOf(recommendProjects.index), wantSeeRecommendView.refreshTv);
        }
        Integer valueOf = Integer.valueOf(recommendProjects.recommendType);
        int i = recommendProjects.pageNo + 1;
        recommendProjects.pageNo = i;
        wantSeeRecommendView.doRefresh(valueOf, i);
    }

    private final void bindRecommend(RecommendProjects recommendProjects) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130749672")) {
            ipChange.ipc$dispatch("2130749672", new Object[]{this, recommendProjects});
            return;
        }
        int childCount = this.container.getChildCount();
        List<ProjectItemBean> list = recommendProjects.details;
        int size = list != null ? list.size() : 0;
        int i = 0;
        while (i < childCount) {
            WantSeeRecommendItemView wantSeeRecommendItemView = null;
            ProjectItemBean projectItemBean = (size <= 0 || i >= size || list == null) ? null : list.get(i);
            View childAt = this.container.getChildAt(i);
            if (childAt instanceof WantSeeRecommendItemView) {
                wantSeeRecommendItemView = (WantSeeRecommendItemView) childAt;
            }
            if (wantSeeRecommendItemView != null) {
                if (projectItemBean != null) {
                    wantSeeRecommendItemView.setVisibility(0);
                    wantSeeRecommendItemView.bindData(projectItemBean, i);
                } else {
                    wantSeeRecommendItemView.setVisibility(4);
                }
                wantSeeRecommendItemView.setOnEventListener(new WantSeeRecommendView$bindRecommend$1$1(this, recommendProjects));
            }
            i++;
        }
    }

    private final void doRefresh(Integer num, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-185288685")) {
            ipChange.ipc$dispatch("-185288685", new Object[]{this, num, Integer.valueOf(i)});
            return;
        }
        showLoading();
        WantSeeRecommendRequest wantSeeRecommendRequest = new WantSeeRecommendRequest();
        if (num != null) {
            i2 = num.intValue();
        }
        wantSeeRecommendRequest.setRecommendType(i2);
        wantSeeRecommendRequest.setPageNo(i);
        eb0.a(wantSeeRecommendRequest).doOnKTSuccess(new WantSeeRecommendView$doRefresh$2(this)).doOnKTFail(new WantSeeRecommendView$doRefresh$3(this));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void hideLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225358749")) {
            ipChange.ipc$dispatch("225358749", new Object[]{this});
            return;
        }
        Context context = getContext();
        DamaiBaseActivity damaiBaseActivity = context instanceof DamaiBaseActivity ? (DamaiBaseActivity) context : null;
        if (damaiBaseActivity != null && !damaiBaseActivity.isFinishing()) {
            damaiBaseActivity.hideLoading();
        }
    }

    private final void showLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1607859304")) {
            ipChange.ipc$dispatch("-1607859304", new Object[]{this});
            return;
        }
        Context context = getContext();
        DamaiBaseActivity damaiBaseActivity = context instanceof DamaiBaseActivity ? (DamaiBaseActivity) context : null;
        if (damaiBaseActivity != null && !damaiBaseActivity.isFinishing()) {
            damaiBaseActivity.showLoading("");
        }
    }

    public final void bindData(@Nullable RecommendProjects recommendProjects) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139510476")) {
            ipChange.ipc$dispatch("-2139510476", new Object[]{this, recommendProjects});
        } else if (recommendProjects == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.titleTv.setText(recommendProjects.recommendTitle);
            this.descTv.setText(recommendProjects.recommendDesc);
            if (recommendProjects.recommendType == 3) {
                this.refreshTv.setVisibility(8);
                TextView textView = this.titleTv;
                Resources resources = getResources();
                int i = R$color.color_4D4D56;
                textView.setTextColor(resources.getColor(i));
                this.descTv.setTextColor(getResources().getColor(i));
                this.titleTv.setTextSize(1, 12.0f);
                this.descTv.setTextSize(1, 12.0f);
            } else {
                this.refreshTv.setVisibility(0);
                DMIconFontTextView dMIconFontTextView = this.refreshTv;
                dMIconFontTextView.setText("换一换 " + getResources().getString(R$string.iconfont_huanyihuan));
                this.refreshTv.setOnClickListener(new iy2(this, recommendProjects));
                this.titleTv.setTextColor(getResources().getColor(R$color.color_2E333E));
                this.descTv.setTextColor(getResources().getColor(R$color.color_4D4D56));
                this.titleTv.setTextSize(1, 13.0f);
                this.descTv.setTextSize(1, 12.0f);
            }
            bindRecommend(recommendProjects);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: kotlin.jvm.functions.Function4<? super java.lang.Integer, java.lang.Object, ? super java.lang.Integer, ? super android.view.View, tb.ur2>, kotlin.jvm.functions.Function4<java.lang.Integer, java.lang.Object, java.lang.Integer, android.view.View, tb.ur2> */
    @Nullable
    public final Function4<Integer, Object, Integer, View, ur2> getOnEventListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-736200577")) {
            return this.onEventListener;
        }
        return (Function4) ipChange.ipc$dispatch("-736200577", new Object[]{this});
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super cn.damai.commonbusiness.wannasee.bean.RecommendProjects, tb.ur2>, kotlin.jvm.functions.Function1<cn.damai.commonbusiness.wannasee.bean.RecommendProjects, tb.ur2> */
    @Nullable
    public final Function1<RecommendProjects, ur2> getOnRefreshSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1086304930")) {
            return this.onRefreshSuccess;
        }
        return (Function1) ipChange.ipc$dispatch("1086304930", new Object[]{this});
    }

    public final void setOnEventListener(@Nullable Function4<? super Integer, Object, ? super Integer, ? super View, ur2> function4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64740329")) {
            ipChange.ipc$dispatch("64740329", new Object[]{this, function4});
            return;
        }
        this.onEventListener = function4;
    }

    public final void setOnRefreshSuccess(@Nullable Function1<? super RecommendProjects, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974507596")) {
            ipChange.ipc$dispatch("-974507596", new Object[]{this, function1});
            return;
        }
        this.onRefreshSuccess = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R$layout.common_business_want_see_recommend_layout, (ViewGroup) this, true);
        this.titleTv = (TextView) findViewById(R$id.recommend_title);
        this.descTv = (TextView) findViewById(R$id.recommend_desc);
        this.refreshTv = (DMIconFontTextView) findViewById(R$id.recommend_refresh);
        this.container = (LinearLayout) findViewById(R$id.recommend_list_container);
    }
}
