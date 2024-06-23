package cn.damai.issue.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.evaluate.ui.EvaluateSuccessActivity;
import cn.damai.issue.net.EvaluteSuccessRenderResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gr;
import tb.h03;
import tb.ik;
import tb.jq;
import tb.k21;
import tb.kq;
import tb.lq;
import tb.p21;
import tb.ur2;

/* compiled from: Taobao */
public final class DMEvaluateSuccessHeadView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View layoutCoins;
    @NotNull
    private final View layoutShare;
    @Nullable
    private final Context mContext;
    @NotNull
    private final TextView tvCoins;
    @NotNull
    private final TextView tvGotoDetail;
    @NotNull
    private final TextView tvHotPlaytitle;
    @NotNull
    private final TextView tvShareSubtitle;
    @NotNull
    private final TextView tvShareTitle;
    @NotNull
    private final TextView tvSubTitle;
    @NotNull
    private final TextView tvTip;

    public DMEvaluateSuccessHeadView(@Nullable Context context) {
        super(context);
        this.mContext = context;
        setGravity(16);
        setOrientation(1);
        setBackgroundResource(R$drawable.uikit_dialog_customer_bg);
        View inflate = LayoutInflater.from(context).inflate(R$layout.evaluate_success_head_layout, this);
        View findViewById = inflate.findViewById(R$id.tv_comment_tip);
        k21.h(findViewById, "parent.findViewById(R.id.tv_comment_tip)");
        this.tvTip = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.tv_subTitle);
        k21.h(findViewById2, "parent.findViewById(R.id.tv_subTitle)");
        this.tvSubTitle = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R$id.tv_goto_detail);
        k21.h(findViewById3, "parent.findViewById(R.id.tv_goto_detail)");
        this.tvGotoDetail = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R$id.layout_coin);
        k21.h(findViewById4, "parent.findViewById(R.id.layout_coin)");
        this.layoutCoins = findViewById4;
        View findViewById5 = inflate.findViewById(R$id.tv_coins);
        k21.h(findViewById5, "parent.findViewById(R.id.tv_coins)");
        this.tvCoins = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R$id.layout_share);
        k21.h(findViewById6, "parent.findViewById(R.id.layout_share)");
        this.layoutShare = findViewById6;
        View findViewById7 = inflate.findViewById(R$id.tv_share_title);
        k21.h(findViewById7, "parent.findViewById(R.id.tv_share_title)");
        this.tvShareTitle = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R$id.tv_share_subtitle);
        k21.h(findViewById8, "parent.findViewById(R.id.tv_share_subtitle)");
        this.tvShareSubtitle = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R$id.tv_hot_play_title);
        k21.h(findViewById9, "parent.findViewById(R.id.tv_hot_play_title)");
        this.tvHotPlaytitle = (TextView) findViewById9;
    }

    private final SpannableStringBuilder getCoinMessage(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799037027")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("799037027", new Object[]{this, str, Boolean.valueOf(z)});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "评价获得");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FDA277")), length, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) "会员积分，");
        spannableStringBuilder.append((CharSequence) (z ? "可兑专享福利哦" : "升级会员可兑哦"));
        return spannableStringBuilder;
    }

    private final CharSequence getTipMessage(String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "832379666")) {
            return (CharSequence) ipChange.ipc$dispatch("832379666", new Object[]{this, str});
        }
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (z) {
            return "恭喜您发布成功";
        }
        if (k21.d(str, "1")) {
            return "哇！这是你发布的第1条评价";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "恭喜发布的第");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9200")), length, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(30, true), length, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) "条内容");
        return spannableStringBuilder;
    }

    private final void loadBackground(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694636614")) {
            ipChange.ipc$dispatch("1694636614", new Object[]{this, view, str});
            return;
        }
        a.b().c(str).n(new lq(view)).f();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadBackground$lambda-9  reason: not valid java name */
    public static final void m51loadBackground$lambda9(View view, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "682521672")) {
            ipChange.ipc$dispatch("682521672", new Object[]{view, eVar});
            return;
        }
        k21.i(view, "$this_loadBackground");
        view.setBackground(eVar != null ? eVar.a : null);
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-0  reason: not valid java name */
    public static final void m52setData$lambda0(String str, DMEvaluateSuccessHeadView dMEvaluateSuccessHeadView, String str2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667916198")) {
            ipChange.ipc$dispatch("1667916198", new Object[]{str, dMEvaluateSuccessHeadView, str2, view});
            return;
        }
        k21.i(str, "$commentId");
        k21.i(dMEvaluateSuccessHeadView, "this$0");
        k21.i(str2, "$itemType");
        Bundle bundle = new Bundle();
        bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, str);
        DMNav.from(dMEvaluateSuccessHeadView.mContext).withExtras(bundle).toUri(NavUri.b(gr.X));
        c.e().x(ik.I().K(str2, str));
        Context context = dMEvaluateSuccessHeadView.mContext;
        EvaluateSuccessActivity evaluateSuccessActivity = context instanceof EvaluateSuccessActivity ? (EvaluateSuccessActivity) context : null;
        if (evaluateSuccessActivity != null) {
            evaluateSuccessActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-3$lambda-2  reason: not valid java name */
    public static final void m53setData$lambda3$lambda2(DMEvaluateSuccessHeadView dMEvaluateSuccessHeadView, String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618383369")) {
            ipChange.ipc$dispatch("618383369", new Object[]{dMEvaluateSuccessHeadView, str, view});
            return;
        }
        k21.i(dMEvaluateSuccessHeadView, "this$0");
        DMNav.from(dMEvaluateSuccessHeadView.mContext).toUri(h03.j());
        c.e().x(ik.I().L(str));
        Context context = dMEvaluateSuccessHeadView.mContext;
        EvaluateSuccessActivity evaluateSuccessActivity = context instanceof EvaluateSuccessActivity ? (EvaluateSuccessActivity) context : null;
        if (evaluateSuccessActivity != null) {
            evaluateSuccessActivity.finish();
        }
    }

    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108044091")) {
            ipChange.ipc$dispatch("2108044091", new Object[]{this, view});
            return;
        }
        k21.i(view, "v");
    }

    public final void setData(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable EvaluteSuccessRenderResponse evaluteSuccessRenderResponse, int i) {
        ur2 ur2;
        EvaluteSuccessRenderResponse.EvaSuccessActivityInfo evaSuccessActivityInfo;
        DMShareMessage.YYMemberIntegrate yYMemberIntegrate;
        DMShareMessage.YYMemberIntegrate yYMemberIntegrate2;
        EvaluteSuccessRenderResponse.CommentSuccessInfo commentSuccessInfo;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "842947559")) {
            ipChange.ipc$dispatch("842947559", new Object[]{this, str, str2, str3, evaluteSuccessRenderResponse, Integer.valueOf(i)});
            return;
        }
        k21.i(str, "itemType");
        k21.i(str2, p21.ISSUE_PARAM_COMMENT_ID);
        ur2 ur22 = null;
        this.tvTip.setText(getTipMessage((evaluteSuccessRenderResponse == null || (commentSuccessInfo = evaluteSuccessRenderResponse.commentInfo) == null) ? null : commentSuccessInfo.userCommentTotal));
        TextView textView = this.tvSubTitle;
        Context context = getContext();
        int i2 = R$string.evaluate_success_subtitle;
        Object[] objArr = new Object[1];
        objArr[0] = k21.d(str, "1") ? "店铺" : "剧本";
        textView.setText(context.getString(i2, objArr));
        this.tvGotoDetail.setOnClickListener(new kq(str2, this, str));
        String str4 = (evaluteSuccessRenderResponse == null || (yYMemberIntegrate2 = evaluteSuccessRenderResponse.vipScore) == null) ? null : yYMemberIntegrate2.oriScore;
        if (!(str4 == null || str4.length() == 0)) {
            z = false;
        }
        if (z) {
            str4 = null;
        }
        if (str4 != null) {
            this.layoutCoins.setVisibility(0);
            loadBackground(this.layoutCoins, "https://androiddownload.damai.cn/pic/damai_profit_gradient_bg.png");
            this.tvCoins.setText(getCoinMessage(str4, h03.d((evaluteSuccessRenderResponse == null || (yYMemberIntegrate = evaluteSuccessRenderResponse.vipScore) == null) ? null : yYMemberIntegrate.memberFlag)));
            this.layoutCoins.setOnClickListener(new jq(this, str3));
            ur2 = ur2.INSTANCE;
        } else {
            ur2 = null;
        }
        if (ur2 == null) {
            this.layoutCoins.setVisibility(8);
        }
        if (!(evaluteSuccessRenderResponse == null || (evaSuccessActivityInfo = evaluteSuccessRenderResponse.activityInfo) == null)) {
            this.layoutShare.setVisibility(0);
            loadBackground(this.layoutShare, "https://androiddownload.damai.cn/pic/damai_profit_member_bg.png");
            this.tvShareTitle.setText(evaSuccessActivityInfo.activityName);
            this.tvShareSubtitle.setText(evaSuccessActivityInfo.activityDes);
            ur22 = ur2.INSTANCE;
        }
        if (ur22 == null) {
            this.layoutShare.setVisibility(8);
        }
        if (i > 0) {
            this.tvHotPlaytitle.setVisibility(0);
        } else {
            this.tvHotPlaytitle.setVisibility(8);
        }
    }
}
