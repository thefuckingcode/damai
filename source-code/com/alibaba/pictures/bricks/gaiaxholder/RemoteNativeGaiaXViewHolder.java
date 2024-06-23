package com.alibaba.pictures.bricks.gaiaxholder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.coupon.order.bean.GxTemplate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.data.Constants;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.k21;
import tb.pr0;
import tb.qz1;

/* compiled from: Taobao */
public final class RemoteNativeGaiaXViewHolder extends RecyclerView.ViewHolder implements GaiaX.IHostMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Activity a;
    @Nullable
    private final GaiaXUtParamsGenerator b;
    @Nullable
    private pr0 c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteNativeGaiaXViewHolder(@NotNull Activity activity, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        super(new FrameLayout(activity));
        k21.i(activity, "activity");
        this.a = activity;
        this.b = gaiaXUtParamsGenerator;
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.itemView.setOnClickListener(new qz1(this));
    }

    /* access modifiers changed from: private */
    public static final void b(RemoteNativeGaiaXViewHolder remoteNativeGaiaXViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541834368")) {
            ipChange.ipc$dispatch("541834368", new Object[]{remoteNativeGaiaXViewHolder, view});
            return;
        }
        k21.i(remoteNativeGaiaXViewHolder, "this$0");
        pr0 pr0 = remoteNativeGaiaXViewHolder.c;
        if (pr0 != null) {
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            pr0.d(view);
        }
    }

    public final void c(@NotNull GxTemplate gxTemplate, @Nullable JSONObject jSONObject, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624581628")) {
            ipChange.ipc$dispatch("-1624581628", new Object[]{this, gxTemplate, jSONObject, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        k21.i(gxTemplate, Constants.TEMPLATE);
        d(gxTemplate.getBizId(), gxTemplate.getTemplateId(), gxTemplate.getTemplateVersion(), jSONObject, f, i);
    }

    public final void d(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable JSONObject jSONObject, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475606481")) {
            ipChange.ipc$dispatch("475606481", new Object[]{this, str, str2, str3, jSONObject, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        if (jSONObject != null) {
            GaiaX.Params build = new GaiaX.Params.Builder().templateBiz(str).templateId(str2).templateVersion(str3).container(this.itemView).mode(LoadType.SYNC_NORMAL).data(jSONObject).width(f).build();
            build.setMessage(this);
            View view = this.itemView;
            k21.h(view, "itemView");
            pr0 pr0 = new pr0(view, this.a, str, str2, str3, jSONObject, i, this.b);
            build.setEventDelegate(pr0);
            build.setTrackDelegate3(pr0);
            build.setStatusDelegate(pr0);
            this.c = pr0;
            pr0.c(pr0.b());
            GaiaX.Companion.getInstance().bindView(build);
        }
    }

    @Override // com.youku.gaiax.GaiaX.IHostMessage
    public boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-916261410")) {
            return ((Boolean) ipChange.ipc$dispatch("-916261410", new Object[]{this, str, jSONObject})).booleanValue();
        }
        k21.i(str, "type");
        k21.i(jSONObject, "data");
        return false;
    }
}
