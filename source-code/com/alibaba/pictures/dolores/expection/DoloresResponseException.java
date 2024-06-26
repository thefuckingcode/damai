package com.alibaba.pictures.dolores.expection;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/alibaba/pictures/dolores/expection/DoloresResponseException;", "Lcom/alibaba/pictures/dolores/expection/DoloresException;", "", "returnCode", "Ljava/lang/String;", "getReturnCode", "()Ljava/lang/String;", "setReturnCode", "(Ljava/lang/String;)V", "returnMessage", "getReturnMessage", "setReturnMessage", "", "bizReturnCode", "I", "getBizReturnCode", "()I", "setBizReturnCode", "(I)V", "bizReturnMessage", "getBizReturnMessage", "setBizReturnMessage", "", "tag", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "message", "<init>", "Companion", "a", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DoloresResponseException extends DoloresException {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private int bizReturnCode = -1;
    @Nullable
    private String bizReturnMessage;
    @Nullable
    private String returnCode = "-1";
    @Nullable
    private String returnMessage;
    @Nullable
    private Object tag;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public DoloresResponseException(@Nullable String str) {
        super(str);
    }

    public final int getBizReturnCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1315430936")) {
            return this.bizReturnCode;
        }
        return ((Integer) ipChange.ipc$dispatch("-1315430936", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getBizReturnMessage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1402344287")) {
            return this.bizReturnMessage;
        }
        return (String) ipChange.ipc$dispatch("1402344287", new Object[]{this});
    }

    @Nullable
    public final String getReturnCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "22948280")) {
            return this.returnCode;
        }
        return (String) ipChange.ipc$dispatch("22948280", new Object[]{this});
    }

    @Nullable
    public final String getReturnMessage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1186327086")) {
            return this.returnMessage;
        }
        return (String) ipChange.ipc$dispatch("-1186327086", new Object[]{this});
    }

    @Nullable
    public final Object getTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-395950137")) {
            return this.tag;
        }
        return ipChange.ipc$dispatch("-395950137", new Object[]{this});
    }

    public final void setBizReturnCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1560420386")) {
            ipChange.ipc$dispatch("1560420386", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.bizReturnCode = i;
    }

    public final void setBizReturnMessage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648794785")) {
            ipChange.ipc$dispatch("-648794785", new Object[]{this, str});
            return;
        }
        this.bizReturnMessage = str;
    }

    public final void setReturnCode(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1398486746")) {
            ipChange.ipc$dispatch("-1398486746", new Object[]{this, str});
            return;
        }
        this.returnCode = str;
    }

    public final void setReturnMessage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9902308")) {
            ipChange.ipc$dispatch("9902308", new Object[]{this, str});
            return;
        }
        this.returnMessage = str;
    }

    public final void setTag(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861772557")) {
            ipChange.ipc$dispatch("-1861772557", new Object[]{this, obj});
            return;
        }
        this.tag = obj;
    }
}
