package tb;

import com.alibaba.pictures.cornerstone.protocol.IKVData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class i81 extends ua<IKVData> implements IKVData {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final i81 INSTANCE;

    static {
        i81 i81 = new i81();
        INSTANCE = i81;
        ua.f(i81, new g81("cs_local_orange_kv_data"), null, 2, null);
    }

    private i81() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean containsKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1326990792")) {
            return ((IKVData) a()).containsKey(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1326990792", new Object[]{this, str})).booleanValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean getBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-344244448")) {
            return ((IKVData) a()).getBoolean(str, z);
        }
        return ((Boolean) ipChange.ipc$dispatch("-344244448", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable Class<T> cls, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2055856438")) {
            return (T) ((IKVData) a()).getConfigObj(str, cls, str2);
        }
        return (T) ipChange.ipc$dispatch("2055856438", new Object[]{this, str, cls, str2});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public float getFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1802547476")) {
            return ((IKVData) a()).getFloat(str, f);
        }
        return ((Float) ipChange.ipc$dispatch("-1802547476", new Object[]{this, str, Float.valueOf(f)})).floatValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public int getInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1351418693")) {
            return ((IKVData) a()).getInt(str, i);
        }
        return ((Integer) ipChange.ipc$dispatch("1351418693", new Object[]{this, str, Integer.valueOf(i)})).intValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public long getLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1482627530")) {
            return ((IKVData) a()).getLong(str, j);
        }
        return ((Long) ipChange.ipc$dispatch("-1482627530", new Object[]{this, str, Long.valueOf(j)})).longValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "853658217")) {
            return ((IKVData) a()).getString(str, str2);
        }
        return (String) ipChange.ipc$dispatch("853658217", new Object[]{this, str, str2});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean isExpected(@Nullable String str, @NotNull String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018590042")) {
            return ((Boolean) ipChange.ipc$dispatch("-2018590042", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
        }
        k21.i(str2, "expectedValue");
        return ((IKVData) a()).isExpected(str, str2, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62521859")) {
            ipChange.ipc$dispatch("62521859", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        ((IKVData) a()).putBoolean(str, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putConfigObj(@Nullable String str, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402208576")) {
            ipChange.ipc$dispatch("402208576", new Object[]{this, str, obj});
            return;
        }
        ((IKVData) a()).putConfigObj(str, obj);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798990243")) {
            ipChange.ipc$dispatch("798990243", new Object[]{this, str, Float.valueOf(f)});
            return;
        }
        ((IKVData) a()).putFloat(str, f);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559712185")) {
            ipChange.ipc$dispatch("1559712185", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        ((IKVData) a()).putInt(str, i);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "679503035")) {
            ipChange.ipc$dispatch("679503035", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        ((IKVData) a()).putLong(str, j);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076293630")) {
            ipChange.ipc$dispatch("1076293630", new Object[]{this, str, str2});
            return;
        }
        ((IKVData) a()).putString(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void removeKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1405806887")) {
            ipChange.ipc$dispatch("-1405806887", new Object[]{this, str});
            return;
        }
        ((IKVData) a()).removeKey(str);
    }
}
