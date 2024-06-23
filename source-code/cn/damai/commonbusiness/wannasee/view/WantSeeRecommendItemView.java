package cn.damai.commonbusiness.wannasee.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gy2;
import tb.hy2;
import tb.k21;
import tb.m40;
import tb.tb2;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeeRecommendItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Function4<? super Integer, Object, ? super Integer, ? super View, ur2> onEventListener;
    private final DMPosterView posterView;
    private final TextView titleTv;
    private final TextView wantSeeTv;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendItemView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WantSeeRecommendItemView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m15bindData$lambda0(WantSeeRecommendItemView wantSeeRecommendItemView, ProjectItemBean projectItemBean, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890854288")) {
            ipChange.ipc$dispatch("1890854288", new Object[]{wantSeeRecommendItemView, projectItemBean, Integer.valueOf(i), view});
            return;
        }
        k21.i(wantSeeRecommendItemView, "this$0");
        k21.i(projectItemBean, "$projectMo");
        Context context = wantSeeRecommendItemView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing()) {
            Function4<? super Integer, Object, ? super Integer, ? super View, ur2> function4 = wantSeeRecommendItemView.onEventListener;
            if (function4 != null) {
                function4.invoke(2, projectItemBean, Integer.valueOf(i), wantSeeRecommendItemView);
            }
            tb2.b(wantSeeRecommendItemView.getContext(), projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
        }
    }

    private final void requestWantSee(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321924821")) {
            ipChange.ipc$dispatch("-321924821", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        this.wantSeeTv.setEnabled(false);
        FollowRequest followRequest = new FollowRequest();
        followRequest.targetId = projectItemBean.id;
        followRequest.operateType = projectItemBean.wantSeeStatus == 1 ? "0" : "1";
        followRequest.targetType = "7";
        followRequest.request(new WantSeeRecommendItemView$requestWantSee$2(this, projectItemBean, i, FollowDataBean.class));
    }

    /* access modifiers changed from: private */
    public final void setWantSeeStatus(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751993718")) {
            ipChange.ipc$dispatch("-751993718", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        if (projectItemBean.wantSeeStatus == 0) {
            this.wantSeeTv.setText("想看");
            this.wantSeeTv.setTextColor(getResources().getColor(R$color.white));
            this.wantSeeTv.setBackground(getResources().getDrawable(R$drawable.want_see_background_already));
        } else {
            this.wantSeeTv.setText("已想看");
            this.wantSeeTv.setTextColor(getResources().getColor(R$color.color_5F6672));
            this.wantSeeTv.setBackground(getResources().getDrawable(R$drawable.want_see_background));
        }
        this.wantSeeTv.setOnClickListener(new hy2(projectItemBean, this, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: setWantSeeStatus$lambda-1  reason: not valid java name */
    public static final void m16setWantSeeStatus$lambda1(ProjectItemBean projectItemBean, WantSeeRecommendItemView wantSeeRecommendItemView, int i, View view) {
        Function4<? super Integer, Object, ? super Integer, ? super View, ur2> function4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222287387")) {
            ipChange.ipc$dispatch("222287387", new Object[]{projectItemBean, wantSeeRecommendItemView, Integer.valueOf(i), view});
            return;
        }
        k21.i(projectItemBean, "$projectMo");
        k21.i(wantSeeRecommendItemView, "this$0");
        if (projectItemBean.wantSeeStatus == 0 && (function4 = wantSeeRecommendItemView.onEventListener) != null) {
            function4.invoke(3, projectItemBean, Integer.valueOf(i), wantSeeRecommendItemView.wantSeeTv);
        }
        wantSeeRecommendItemView.requestWantSee(projectItemBean, i);
    }

    public final void bindData(@NotNull ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965810270")) {
            ipChange.ipc$dispatch("965810270", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        k21.i(projectItemBean, "projectMo");
        this.posterView.setImageUrl(projectItemBean.verticalPic);
        this.posterView.setScoreStar(projectItemBean.itemScore, true);
        this.posterView.setCategoryTagName(projectItemBean.getCategoryNameCompat());
        this.titleTv.setText(projectItemBean.name);
        setWantSeeStatus(projectItemBean, i);
        setOnClickListener(new gy2(this, projectItemBean, i));
        Function4<? super Integer, Object, ? super Integer, ? super View, ur2> function4 = this.onEventListener;
        if (function4 != null) {
            function4.invoke(5, projectItemBean, Integer.valueOf(i), this);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: kotlin.jvm.functions.Function4<? super java.lang.Integer, java.lang.Object, ? super java.lang.Integer, ? super android.view.View, tb.ur2>, kotlin.jvm.functions.Function4<java.lang.Integer, java.lang.Object, java.lang.Integer, android.view.View, tb.ur2> */
    @Nullable
    public final Function4<Integer, Object, Integer, View, ur2> getOnEventListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1721477140")) {
            return this.onEventListener;
        }
        return (Function4) ipChange.ipc$dispatch("-1721477140", new Object[]{this});
    }

    public final void setOnEventListener(@Nullable Function4<? super Integer, Object, ? super Integer, ? super View, ur2> function4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414062052")) {
            ipChange.ipc$dispatch("-414062052", new Object[]{this, function4});
            return;
        }
        this.onEventListener = function4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R$layout.common_business_want_see_recommend_item_layout, (ViewGroup) this, true);
        this.posterView = (DMPosterView) findViewById(R$id.want_see_poster);
        this.titleTv = (TextView) findViewById(R$id.want_see_recommend_title);
        this.wantSeeTv = (TextView) findViewById(R$id.want_see_btn);
    }
}
