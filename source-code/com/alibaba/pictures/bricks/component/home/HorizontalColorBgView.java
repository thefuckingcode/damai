package com.alibaba.pictures.bricks.component.home;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.HorizontalColorBgContract;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.sx0;
import tb.tx0;
import tb.ux0;
import tb.vx0;

/* compiled from: Taobao */
public final class HorizontalColorBgView extends GenericHorizontalView implements HorizontalColorBgContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RoundRadiusImageView bgImg;
    @NotNull
    private final View itemView;
    @NotNull
    private final TextView subTitle;
    @NotNull
    private final View subTitleImg;
    @NotNull
    private final ImageView titlePic;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalColorBgView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.bricks_horizontal_layout_title);
        k21.h(findViewById, "itemView.findViewById(R.…_horizontal_layout_title)");
        this.titlePic = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.bricks_horizontal_layout_more);
        k21.h(findViewById2, "itemView.findViewById(R.…s_horizontal_layout_more)");
        this.subTitle = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.bricks_horizontal_layout_moreimg);
        k21.h(findViewById3, "itemView.findViewById(R.…orizontal_layout_moreimg)");
        this.subTitleImg = findViewById3;
        View findViewById4 = view.findViewById(R$id.bricks_horizontal_layout_bg);
        k21.h(findViewById4, "itemView.findViewById(R.…cks_horizontal_layout_bg)");
        this.bgImg = (RoundRadiusImageView) findViewById4;
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-3$lambda-1  reason: not valid java name */
    public static final void m105bindView$lambda3$lambda1(Object obj, HorizontalColorBgView horizontalColorBgView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498426360")) {
            ipChange.ipc$dispatch("1498426360", new Object[]{obj, horizontalColorBgView, successEvent});
            return;
        }
        k21.i(obj, "$this_apply");
        k21.i(horizontalColorBgView, "this$0");
        if ((successEvent != null ? successEvent.drawable : null) != null) {
            Log.d("debugtitle", ' ' + obj + " === success: ");
            horizontalColorBgView.titlePic.setVisibility(0);
            horizontalColorBgView.titlePic.setImageDrawable(successEvent.drawable);
            return;
        }
        horizontalColorBgView.titlePic.setImageDrawable(horizontalColorBgView.itemView.getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        horizontalColorBgView.titlePic.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-3$lambda-2  reason: not valid java name */
    public static final void m106bindView$lambda3$lambda2(HorizontalColorBgView horizontalColorBgView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786839938")) {
            ipChange.ipc$dispatch("786839938", new Object[]{horizontalColorBgView, failEvent});
            return;
        }
        k21.i(horizontalColorBgView, "this$0");
        horizontalColorBgView.titlePic.setImageDrawable(horizontalColorBgView.itemView.getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        horizontalColorBgView.titlePic.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-7$lambda-5  reason: not valid java name */
    public static final void m107bindView$lambda7$lambda5(Object obj, HorizontalColorBgView horizontalColorBgView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726993032")) {
            ipChange.ipc$dispatch("-726993032", new Object[]{obj, horizontalColorBgView, successEvent});
            return;
        }
        k21.i(obj, "$this_apply");
        k21.i(horizontalColorBgView, "this$0");
        if ((successEvent != null ? successEvent.bitmap : null) != null) {
            Log.d("debugtitle", ' ' + obj + " === success: ");
            horizontalColorBgView.titlePic.setVisibility(0);
            horizontalColorBgView.bgImg.setImageBitmap(successEvent.bitmap);
            return;
        }
        horizontalColorBgView.bgImg.setImageBitmap(null);
        horizontalColorBgView.bgImg.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-7$lambda-6  reason: not valid java name */
    public static final void m108bindView$lambda7$lambda6(HorizontalColorBgView horizontalColorBgView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680313342")) {
            ipChange.ipc$dispatch("-680313342", new Object[]{horizontalColorBgView, failEvent});
            return;
        }
        k21.i(horizontalColorBgView, "this$0");
        horizontalColorBgView.bgImg.setImageBitmap(null);
        horizontalColorBgView.bgImg.setVisibility(8);
    }

    @Override // com.alibaba.pictures.bricks.component.home.HorizontalColorBgContract.View
    public void bindView(@Nullable JSONObject jSONObject) {
        Object obj;
        Object obj2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500830894")) {
            ipChange.ipc$dispatch("1500830894", new Object[]{this, jSONObject});
            return;
        }
        this.titlePic.setVisibility(8);
        if ((jSONObject != null ? jSONObject.get("title") : null) == null) {
            this.titlePic.setImageDrawable(this.itemView.getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
            this.titlePic.setVisibility(0);
        }
        if (!(jSONObject == null || (obj2 = jSONObject.get("title")) == null)) {
            ImageLoaderProviderProxy.getProxy().load((String) obj2, new vx0(obj2, this), new sx0(this));
        }
        if (!(jSONObject == null || (obj = jSONObject.get("backgroundPic")) == null)) {
            ImageLoaderProviderProxy.getProxy().load((String) obj, new ux0(obj, this), new tx0(this));
        }
        this.subTitle.setVisibility(8);
        this.subTitleImg.setVisibility(8);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1708425210")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1708425210", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract.View, com.alient.onearch.adapter.component.horizontal.GenericHorizontalView
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278672176")) {
            ipChange.ipc$dispatch("-278672176", new Object[]{this, recycledViewPool, map});
            return;
        }
        super.initRecyclerSettings(recycledViewPool, map);
    }
}
