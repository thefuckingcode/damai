package tb;

import com.alibaba.pictures.cornerstone.protocol.IJSONParser;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class f31 extends ua<IJSONParser> implements IJSONParser {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final f31 INSTANCE;

    static {
        f31 f31 = new f31();
        INSTANCE = f31;
        ua.f(f31, new e31(), null, 2, null);
    }

    private f31() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> ArrayList<T> parseArrayList(@Nullable String str, @NotNull Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546461678")) {
            return (ArrayList) ipChange.ipc$dispatch("546461678", new Object[]{this, str, cls});
        }
        k21.i(cls, "clz");
        return ((IJSONParser) a()).parseArrayList(str, cls);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Boolean[] parseBooleanArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "133471137")) {
            return ((IJSONParser) a()).parseBooleanArray(str);
        }
        return (Boolean[]) ipChange.ipc$dispatch("133471137", new Object[]{this, str});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Integer[] parseIntArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1120862876")) {
            return ((IJSONParser) a()).parseIntArray(str);
        }
        return (Integer[]) ipChange.ipc$dispatch("-1120862876", new Object[]{this, str});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> T parseJson(@Nullable String str, @NotNull Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1721914635")) {
            return (T) ipChange.ipc$dispatch("1721914635", new Object[]{this, str, cls});
        }
        k21.i(cls, "cls");
        return (T) ((IJSONParser) a()).parseJson(str, (Class) cls);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Object parseJsonObject(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1081871963")) {
            return ((IJSONParser) a()).parseJsonObject(str);
        }
        return ipChange.ipc$dispatch("1081871963", new Object[]{this, str});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Long[] parseLongArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-566174873")) {
            return ((IJSONParser) a()).parseLongArray(str);
        }
        return (Long[]) ipChange.ipc$dispatch("-566174873", new Object[]{this, str});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public String[] parseStringArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-945927097")) {
            return ((IJSONParser) a()).parseStringArray(str);
        }
        return (String[]) ipChange.ipc$dispatch("-945927097", new Object[]{this, str});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public String toJsonString(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1435585269")) {
            return ((IJSONParser) a()).toJsonString(obj);
        }
        return (String) ipChange.ipc$dispatch("1435585269", new Object[]{this, obj});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> T parseJson(@Nullable String str, @NotNull Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149074835")) {
            return (T) ipChange.ipc$dispatch("-149074835", new Object[]{this, str, type});
        }
        k21.i(type, "type");
        return (T) ((IJSONParser) a()).parseJson(str, type);
    }
}
