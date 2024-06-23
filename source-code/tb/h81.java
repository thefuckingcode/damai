package tb;

import com.alibaba.pictures.cornerstone.protocol.IKVData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class h81 extends ua<IKVData> implements IKVData {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final h81 INSTANCE = new h81();
    @NotNull
    private static String d = "cs_local_kv_data";

    private h81() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean containsKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "471218154")) {
            return g().containsKey(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("471218154", new Object[]{this, str})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public IKVData g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-682755129")) {
            return (IKVData) ipChange.ipc$dispatch("-682755129", new Object[]{this});
        }
        if (b() == null) {
            ua.f(this, new g81(d), null, 2, null);
        }
        return (IKVData) super.a();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean getBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1453964498")) {
            return g().getBoolean(str, z);
        }
        return ((Boolean) ipChange.ipc$dispatch("1453964498", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable Class<T> cls, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1141739204")) {
            return (T) g().getConfigObj(str, cls, str2);
        }
        return (T) ipChange.ipc$dispatch("1141739204", new Object[]{this, str, cls, str2});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public float getFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "340103454")) {
            return g().getFloat(str, f);
        }
        return ((Float) ipChange.ipc$dispatch("340103454", new Object[]{this, str, Float.valueOf(f)})).floatValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public int getInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1425156599")) {
            return g().getInt(str, i);
        }
        return ((Integer) ipChange.ipc$dispatch("1425156599", new Object[]{this, str, Integer.valueOf(i)})).intValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public long getLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "803247556")) {
            return g().getLong(str, j);
        }
        return ((Long) ipChange.ipc$dispatch("803247556", new Object[]{this, str, Long.valueOf(j)})).longValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1749895927")) {
            return g().getString(str, str2);
        }
        return (String) ipChange.ipc$dispatch("1749895927", new Object[]{this, str, str2});
    }

    public final void h(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1543711589")) {
            ipChange.ipc$dispatch("-1543711589", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        d = str;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean isExpected(@Nullable String str, @NotNull String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175114280")) {
            return ((Boolean) ipChange.ipc$dispatch("-175114280", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
        }
        k21.i(str2, "expectedValue");
        return g().isExpected(str, str2, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860730805")) {
            ipChange.ipc$dispatch("1860730805", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        g().putBoolean(str, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putConfigObj(@Nullable String str, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715382350")) {
            ipChange.ipc$dispatch("1715382350", new Object[]{this, str, obj});
            return;
        }
        g().putConfigObj(str, obj);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353326123")) {
            ipChange.ipc$dispatch("-1353326123", new Object[]{this, str, Float.valueOf(f)});
            return;
        }
        g().putFloat(str, f);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1633450091")) {
            ipChange.ipc$dispatch("1633450091", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        g().putInt(str, i);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329589175")) {
            ipChange.ipc$dispatch("-1329589175", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        g().putLong(str, j);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1764243024")) {
            ipChange.ipc$dispatch("-1764243024", new Object[]{this, str, str2});
            return;
        }
        g().putString(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void removeKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736844043")) {
            ipChange.ipc$dispatch("736844043", new Object[]{this, str});
            return;
        }
        g().removeKey(str);
    }
}
