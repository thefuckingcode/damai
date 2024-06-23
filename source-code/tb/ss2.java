package tb;

import com.alibaba.pictures.uploader.UploadStatus;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ss2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String a;
    @Nullable
    private String b;
    @Nullable
    private UploadStatus c;
    private int d;
    @Nullable
    private ITaskResult e;
    @Nullable
    private ej2 f;

    @Nullable
    public final String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-596547403")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("-596547403", new Object[]{this});
    }

    @Nullable
    public final String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1820910345")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("1820910345", new Object[]{this});
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1032553646")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("1032553646", new Object[]{this})).intValue();
    }

    @Nullable
    public final ITaskResult d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1690477337")) {
            return this.e;
        }
        return (ITaskResult) ipChange.ipc$dispatch("1690477337", new Object[]{this});
    }

    public final void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1365613409")) {
            ipChange.ipc$dispatch("1365613409", new Object[]{this, str});
            return;
        }
        this.b = str;
    }

    public final void f(@Nullable ej2 ej2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629306272")) {
            ipChange.ipc$dispatch("-1629306272", new Object[]{this, ej2});
            return;
        }
        this.f = ej2;
    }

    public final void g(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716499941")) {
            ipChange.ipc$dispatch("1716499941", new Object[]{this, Long.valueOf(j)});
        }
    }

    public final void h(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002607731")) {
            ipChange.ipc$dispatch("-1002607731", new Object[]{this, str});
            return;
        }
        this.a = str;
    }

    public final void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439792972")) {
            ipChange.ipc$dispatch("-1439792972", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
    }

    public final void j(@Nullable ITaskResult iTaskResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100942401")) {
            ipChange.ipc$dispatch("-1100942401", new Object[]{this, iTaskResult});
            return;
        }
        this.e = iTaskResult;
    }

    public final void k(@Nullable UploadStatus uploadStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549063202")) {
            ipChange.ipc$dispatch("-1549063202", new Object[]{this, uploadStatus});
            return;
        }
        this.c = uploadStatus;
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591979456")) {
            return (String) ipChange.ipc$dispatch("-1591979456", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(this.c));
        stringBuffer.append(":");
        UploadStatus uploadStatus = this.c;
        if (uploadStatus != null) {
            int i = rs2.$EnumSwitchMapping$0[uploadStatus.ordinal()];
            if (i == 1) {
                stringBuffer.append(this.d);
                stringBuffer.append("%");
            } else if (i == 2) {
                ej2 ej2 = this.f;
                stringBuffer.append(ej2 != null ? ej2.a : null);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        k21.h(stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }
}
