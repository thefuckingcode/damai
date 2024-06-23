package tb;

import com.alibaba.pictures.cornerstone.protocol.ILogger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class e91 extends ua<ILogger> implements ILogger {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final e91 INSTANCE;

    static {
        e91 e91 = new e91();
        INSTANCE = e91;
        ua.f(e91, new w91(), null, 2, null);
    }

    private e91() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void d(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1831934128")) {
            ipChange.ipc$dispatch("1831934128", new Object[]{this, str});
            return;
        }
        ((ILogger) a()).d(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206122161")) {
            ipChange.ipc$dispatch("-206122161", new Object[]{this, str});
            return;
        }
        ((ILogger) a()).e(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void w(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763570301")) {
            ipChange.ipc$dispatch("1763570301", new Object[]{this, str});
            return;
        }
        ((ILogger) a()).w(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void d(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006406022")) {
            ipChange.ipc$dispatch("-1006406022", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "tag");
        ((ILogger) a()).d(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void e(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455173977")) {
            ipChange.ipc$dispatch("455173977", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "tag");
        ((ILogger) a()).e(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void w(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993810183")) {
            ipChange.ipc$dispatch("993810183", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "tag");
        ((ILogger) a()).w(str, str2);
    }
}
