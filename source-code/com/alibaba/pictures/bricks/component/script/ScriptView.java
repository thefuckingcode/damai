package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.SearchScriptBean;
import com.alibaba.pictures.bricks.component.script.ScriptContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.HighlightTextView;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.l52;

/* compiled from: Taobao */
public final class ScriptView extends AbsView<GenericItem<ItemValue>, ScriptModel, ScriptPresenter> implements ScriptContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private View divline;
    @NotNull
    private final View itemView;
    @NotNull
    private RoundRadiusImageView posterImg;
    @NotNull
    private final DMCategroyTagView posterTag;
    @NotNull
    private TextView scriptDescTv;
    @NotNull
    private TextView scriptScoreTv;
    @NotNull
    private ViewGroup scriptScoreView;
    @NotNull
    private HighlightTextView titleTv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.script_poster);
        k21.h(findViewById, "itemView.findViewById(R.id.script_poster)");
        this.posterImg = (RoundRadiusImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.script_tag);
        k21.h(findViewById2, "itemView.findViewById(R.id.script_tag)");
        this.posterTag = (DMCategroyTagView) findViewById2;
        View findViewById3 = view.findViewById(R$id.script_name);
        k21.h(findViewById3, "itemView.findViewById(R.id.script_name)");
        this.titleTv = (HighlightTextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.script_score);
        k21.h(findViewById4, "itemView.findViewById(R.id.script_score)");
        this.scriptScoreView = (ViewGroup) findViewById4;
        View findViewById5 = view.findViewById(R$id.tv_script_score);
        k21.h(findViewById5, "itemView.findViewById(R.id.tv_script_score)");
        this.scriptScoreTv = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R$id.script_desc);
        k21.h(findViewById6, "itemView.findViewById(R.id.script_desc)");
        this.scriptDescTv = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R$id.ll_search_bottom_div);
        k21.h(findViewById7, "itemView.findViewById(R.id.ll_search_bottom_div)");
        this.divline = findViewById7;
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m142bindData$lambda0(ScriptView scriptView, SearchScriptBean searchScriptBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671411478")) {
            ipChange.ipc$dispatch("-1671411478", new Object[]{scriptView, searchScriptBean, view});
            return;
        }
        k21.i(scriptView, "this$0");
        ScriptPresenter scriptPresenter = (ScriptPresenter) scriptView.getPresenter();
        if (scriptPresenter != null) {
            scriptPresenter.onItemClick(searchScriptBean, 0);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.script.ScriptContract.View
    public void bindData(@Nullable SearchScriptBean searchScriptBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-119146097")) {
            ipChange.ipc$dispatch("-119146097", new Object[]{this, searchScriptBean});
        } else if (searchScriptBean != null) {
            ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
            String url = searchScriptBean.getUrl();
            RoundRadiusImageView roundRadiusImageView = this.posterImg;
            int i = R$drawable.bricks_uikit_default_image_bg_gradient;
            proxy.loadinto(url, roundRadiusImageView, i, i);
            this.posterTag.setTagName(ErrControlViewInfo.TYPE_SCRIPT);
            this.posterTag.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_DEFAULT);
            this.titleTv.setText(searchScriptBean.getName(), searchScriptBean.getHighlightWord());
            String itemScore = searchScriptBean.getItemScore();
            if (!(itemScore == null || itemScore.length() == 0)) {
                z = false;
            }
            if (z) {
                this.scriptScoreView.setVisibility(8);
            } else {
                this.scriptScoreView.setVisibility(0);
                this.scriptScoreTv.setText(searchScriptBean.getItemScore());
            }
            this.scriptDescTv.setText(searchScriptBean.buildDesc());
            this.itemView.setOnClickListener(new l52(this, searchScriptBean));
            ScriptPresenter scriptPresenter = (ScriptPresenter) getPresenter();
            if (scriptPresenter != null) {
                scriptPresenter.onItemExpose(this.itemView, searchScriptBean, 0);
            }
        }
    }

    @NotNull
    public final View getDivline() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2142004338")) {
            return this.divline;
        }
        return (View) ipChange.ipc$dispatch("-2142004338", new Object[]{this});
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1092895907")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1092895907", new Object[]{this});
    }

    public final void setDivline(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858936186")) {
            ipChange.ipc$dispatch("1858936186", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.divline = view;
    }
}
