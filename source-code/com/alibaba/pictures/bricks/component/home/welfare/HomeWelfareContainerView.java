package com.alibaba.pictures.bricks.component.home.welfare;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerContract;
import com.alibaba.pictures.ut.ClickCat;
import com.alibaba.pictures.ut.DogCat;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalView;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.lx0;
import tb.mx0;
import tb.nx0;
import tb.ox0;
import tb.px0;
import tb.u50;

/* compiled from: Taobao */
public final class HomeWelfareContainerView extends GenericHorizontalView implements HomeWelfareContainerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ImageView bgLayout;
    @NotNull
    private final View itemView;
    private final TextView welfareDesc;
    private final View welfareDescIcon;
    private final LinearLayout welfareDescParent;
    private final ImageView welfareTitle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeWelfareContainerView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.bgLayout = (ImageView) view.findViewById(R$id.bricks_welfare_layout);
        this.welfareTitle = (ImageView) view.findViewById(R$id.bricks_welfare_title);
        this.welfareDesc = (TextView) view.findViewById(R$id.welfare_desc);
        this.welfareDescParent = (LinearLayout) view.findViewById(R$id.welfare_desc_parent);
        this.welfareDescIcon = view.findViewById(R$id.welfare_desc_right_icon);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-5$lambda-4$lambda-2$lambda-1  reason: not valid java name */
    public static final void m132bindView$lambda10$lambda5$lambda4$lambda2$lambda1(JSONObject jSONObject, String str, HomeWelfareContainerView homeWelfareContainerView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334600465")) {
            ipChange.ipc$dispatch("-1334600465", new Object[]{jSONObject, str, homeWelfareContainerView, view});
            return;
        }
        k21.i(jSONObject, "$this_actionNode");
        k21.i(str, "$this_url");
        k21.i(homeWelfareContainerView, "this$0");
        JSONObject jSONObject2 = jSONObject.getJSONObject("trackInfo");
        if (jSONObject2 != null) {
            ClickCat d = DogCat.INSTANCE.d();
            IContract.Presenter presenter = homeWelfareContainerView.getPresenter();
            k21.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerPresent");
            d.n(((GenericItem) ((HomeWelfareContainerPresent) presenter).getItem()).getPageContext().getPageName()).r(jSONObject2.getString("spmc"), jSONObject2.getString("spmd")).j();
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(str);
        NavProviderProxy.getProxy().toUri(homeWelfareContainerView.itemView.getContext(), action);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-6  reason: not valid java name */
    public static final void m133bindView$lambda10$lambda6(HomeWelfareContainerView homeWelfareContainerView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956171395")) {
            ipChange.ipc$dispatch("-1956171395", new Object[]{homeWelfareContainerView, successEvent});
            return;
        }
        k21.i(homeWelfareContainerView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeWelfareContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_welfare_bg);
        } else {
            homeWelfareContainerView.bgLayout.setBackground(drawable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-7  reason: not valid java name */
    public static final void m134bindView$lambda10$lambda7(HomeWelfareContainerView homeWelfareContainerView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748546335")) {
            ipChange.ipc$dispatch("1748546335", new Object[]{homeWelfareContainerView, failEvent});
            return;
        }
        k21.i(homeWelfareContainerView, "this$0");
        homeWelfareContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_welfare_bg);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-8  reason: not valid java name */
    public static final void m135bindView$lambda10$lambda8(HomeWelfareContainerView homeWelfareContainerView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094337793")) {
            ipChange.ipc$dispatch("-1094337793", new Object[]{homeWelfareContainerView, successEvent});
            return;
        }
        k21.i(homeWelfareContainerView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeWelfareContainerView.welfareTitle.setImageResource(R$drawable.bricks_welfare_title);
            return;
        }
        homeWelfareContainerView.welfareTitle.setImageDrawable(drawable);
        ViewGroup.LayoutParams layoutParams = homeWelfareContainerView.welfareTitle.getLayoutParams();
        if (layoutParams != null) {
            int width = successEvent.bitmap.getWidth();
            u50 u50 = u50.INSTANCE;
            Context context = homeWelfareContainerView.itemView.getContext();
            k21.h(context, "itemView.context");
            layoutParams.width = (width * u50.b(context, 14)) / successEvent.bitmap.getHeight();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-9  reason: not valid java name */
    public static final void m136bindView$lambda10$lambda9(HomeWelfareContainerView homeWelfareContainerView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655911133")) {
            ipChange.ipc$dispatch("655911133", new Object[]{homeWelfareContainerView, failEvent});
            return;
        }
        k21.i(homeWelfareContainerView, "this$0");
        homeWelfareContainerView.welfareTitle.setImageResource(R$drawable.bricks_welfare_title);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c7  */
    @Override // com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerContract.View
    public void bindView(@Nullable JSONObject jSONObject) {
        boolean z;
        Object obj;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1901637951")) {
            ipChange.ipc$dispatch("1901637951", new Object[]{this, jSONObject});
            return;
        }
        int i = 8;
        if (jSONObject != null) {
            JSONArray jSONArray = jSONObject.getJSONArray(OneArchConstants.LayoutKey.KEY_WORDS);
            if (!(jSONArray == null || (obj = jSONArray.get(0)) == null)) {
                k21.h(obj, "get(0)");
                JSONObject jSONObject2 = ((JSONObject) obj).getJSONObject("action");
                if (jSONObject2 != null) {
                    k21.h(jSONObject2, "getJSONObject(\"action\")");
                    String string = jSONObject2.getString("actionUrl");
                    if (string != null) {
                        k21.h(string, "getString(\"actionUrl\")");
                        this.itemView.setOnClickListener(new lx0(jSONObject2, string, this));
                        z = true;
                    } else {
                        z = false;
                    }
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("trackInfo");
                    if (jSONObject3 != null) {
                        k21.h(jSONObject3, "getJSONObject(\"trackInfo\")");
                        DogCat.INSTANCE.h(this.itemView).w(jSONObject3.getString("spmc"), jSONObject3.getString("spmd")).k();
                    }
                    ImageLoaderProviderProxy.getProxy().load(jSONObject.getString("bgPic"), new ox0(this), new nx0(this));
                    ImageLoaderProviderProxy.getProxy().load(jSONObject.getString("titlePic"), new px0(this), new mx0(this));
                    String string2 = jSONObject.getString("subTitle");
                    if (string2 != null && !(o.y(string2))) {
                        z2 = false;
                    }
                    if (!z2) {
                        this.welfareDescParent.setVisibility(8);
                        return;
                    }
                    View view = this.welfareDescIcon;
                    if (view != null) {
                        if (z) {
                            i = 0;
                        }
                        view.setVisibility(i);
                    }
                    this.welfareDescParent.setVisibility(0);
                    this.welfareDesc.setText(jSONObject.getString("subTitle"));
                    return;
                }
            }
            z = false;
            ImageLoaderProviderProxy.getProxy().load(jSONObject.getString("bgPic"), new ox0(this), new nx0(this));
            ImageLoaderProviderProxy.getProxy().load(jSONObject.getString("titlePic"), new px0(this), new mx0(this));
            String string22 = jSONObject.getString("subTitle");
            z2 = false;
            if (!z2) {
            }
        } else {
            this.bgLayout.setBackgroundResource(R$drawable.bricks_welfare_bg);
            this.welfareDescParent.setVisibility(8);
            this.welfareTitle.setVisibility(8);
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-806492661")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("-806492661", new Object[]{this});
    }
}
