package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import android.widget.TextView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.FavouriteBean;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMDigitTextView;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.pictures.bricks.view.ScoreStarViewV2;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class FavouriteViewHolder extends BaseViewHolder<FavouriteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final TextView content;
    @NotNull
    private final DMLabelView label;
    @NotNull
    private final LiveRoomView live;
    @NotNull
    private final TextView name;
    @NotNull
    private final RoundImageView poster;
    @NotNull
    private final ScoreStarViewV2 scoreIcon;
    @NotNull
    private final View scoreLayout;
    @NotNull
    private final DMDigitTextView scoreText;
    @NotNull
    private final DMCategroyTagView tag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavouriteViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "view");
        View findViewById = view.findViewById(R$id.favourite_poster);
        k21.h(findViewById, "view.findViewById(R.id.favourite_poster)");
        this.poster = (RoundImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.content);
        k21.h(findViewById2, "view.findViewById(R.id.content)");
        this.content = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.name);
        k21.h(findViewById3, "view.findViewById(R.id.name)");
        this.name = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.favourite_tag);
        k21.h(findViewById4, "view.findViewById(R.id.favourite_tag)");
        this.tag = (DMCategroyTagView) findViewById4;
        View findViewById5 = view.findViewById(R$id.favourite_live);
        k21.h(findViewById5, "view.findViewById(R.id.favourite_live)");
        this.live = (LiveRoomView) findViewById5;
        View findViewById6 = view.findViewById(R$id.favourite_score_layout);
        k21.h(findViewById6, "view.findViewById(R.id.favourite_score_layout)");
        this.scoreLayout = findViewById6;
        View findViewById7 = view.findViewById(R$id.favourite_score_text);
        k21.h(findViewById7, "view.findViewById(R.id.favourite_score_text)");
        this.scoreText = (DMDigitTextView) findViewById7;
        View findViewById8 = view.findViewById(R$id.favourite_score_icon);
        k21.h(findViewById8, "view.findViewById(R.id.favourite_score_icon)");
        this.scoreIcon = (ScoreStarViewV2) findViewById8;
        View findViewById9 = view.findViewById(R$id.favourite_label);
        k21.h(findViewById9, "view.findViewById(R.id.favourite_label)");
        this.label = (DMLabelView) findViewById9;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "308122020")) {
            ipChange.ipc$dispatch("308122020", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
        ImageLoaderProviderProxy.getProxy().loadinto(((FavouriteBean) getValue()).coverUrl, this.poster);
        String str = ((FavouriteBean) getValue()).name;
        if (str == null || str.length() == 0) {
            this.name.setVisibility(8);
        } else {
            this.name.setVisibility(0);
            this.name.setText(((FavouriteBean) getValue()).name);
        }
        this.content.setText(((FavouriteBean) getValue()).displayContent);
        String str2 = ((FavouriteBean) getValue()).liveStatus;
        if (str2 == null || str2.length() == 0) {
            String str3 = ((FavouriteBean) getValue()).categoryName;
            if ((str3 == null || str3.length() == 0) || ((FavouriteBean) getValue()).tagType.equals("1") || ((FavouriteBean) getValue()).tagType.equals("2") || ((FavouriteBean) getValue()).tagType.equals("5")) {
                this.tag.setVisibility(8);
            } else {
                this.live.setVisibility(8);
                this.tag.setVisibility(0);
                this.tag.setTagName(((FavouriteBean) getValue()).categoryName);
            }
        } else {
            this.tag.setVisibility(8);
            this.live.setVisibility(0);
            this.live.setLiveType(((FavouriteBean) getValue()).getLiveType());
        }
        String str4 = ((FavouriteBean) getValue()).itemScore;
        if (str4 == null || str4.length() == 0) {
            this.scoreLayout.setVisibility(8);
            String str5 = ((FavouriteBean) getValue()).tagType;
            if (!(str5 == null || str5.length() == 0)) {
                z = false;
            }
            if (z || (!((FavouriteBean) getValue()).tagType.equals("1") && !((FavouriteBean) getValue()).tagType.equals("2") && !((FavouriteBean) getValue()).tagType.equals("5"))) {
                this.label.setVisibility(8);
                return;
            }
            this.label.setVisibility(0);
            if (k21.d("1", ((FavouriteBean) getValue()).tagType)) {
                this.label.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
            } else if (k21.d("2", ((FavouriteBean) getValue()).tagType)) {
                this.label.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
            } else if (k21.d("5", ((FavouriteBean) getValue()).tagType)) {
                this.label.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
            }
        } else {
            this.label.setVisibility(8);
            this.scoreLayout.setVisibility(0);
            this.scoreText.setText(((FavouriteBean) getValue()).itemScore);
            try {
                ScoreStarViewV2 scoreStarViewV2 = this.scoreIcon;
                String str6 = ((FavouriteBean) getValue()).itemScore;
                k21.h(str6, "value.itemScore");
                scoreStarViewV2.updateView(Double.parseDouble(str6));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
