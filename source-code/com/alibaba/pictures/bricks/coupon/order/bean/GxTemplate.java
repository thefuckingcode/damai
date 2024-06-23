package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.k21;

/* compiled from: Taobao */
public final class GxTemplate implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String bizId;
    @NotNull
    private final String templateId;
    @Nullable
    private String templateVersion;

    public GxTemplate(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        this.bizId = str;
        this.templateId = str2;
        this.templateVersion = str3;
    }

    @NotNull
    public final String getBizId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "983933855")) {
            return this.bizId;
        }
        return (String) ipChange.ipc$dispatch("983933855", new Object[]{this});
    }

    @NotNull
    public final String getTemplateId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "638535930")) {
            return this.templateId;
        }
        return (String) ipChange.ipc$dispatch("638535930", new Object[]{this});
    }

    @Nullable
    public final String getTemplateVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2105993615")) {
            return this.templateVersion;
        }
        return (String) ipChange.ipc$dispatch("2105993615", new Object[]{this});
    }

    public final void setTemplateVersion(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143105991")) {
            ipChange.ipc$dispatch("1143105991", new Object[]{this, str});
            return;
        }
        this.templateVersion = str;
    }
}
