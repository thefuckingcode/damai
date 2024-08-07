package tb;

import android.content.SharedPreferences;
import cn.damai.category.categorygirl.ui.GirlShowAllActivity;
import com.alibaba.pictures.cornerstone.protocol.IKVData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class g81 implements IKVData {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String a;

    public g81(@NotNull String str) {
        k21.i(str, GirlShowAllActivity.KEY_GROUPNAME);
        this.a = str;
    }

    private final boolean a(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1085955673")) {
            return str == null || str.length() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1085955673", new Object[]{this, str})).booleanValue();
    }

    private final SharedPreferences b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-192612020")) {
            return (SharedPreferences) ipChange.ipc$dispatch("-192612020", new Object[]{this});
        }
        SharedPreferences sharedPreferences = pn.INSTANCE.a().getSharedPreferences(this.a, 0);
        k21.h(sharedPreferences, "Cornerstone.application.…me, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean containsKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452544900")) {
            return ((Boolean) ipChange.ipc$dispatch("-452544900", new Object[]{this, str})).booleanValue();
        } else if (a(str)) {
            return false;
        } else {
            return b().contains(str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean getBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530201444")) {
            return ((Boolean) ipChange.ipc$dispatch("530201444", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue();
        } else if (a(str)) {
            return z;
        } else {
            return b().getBoolean(str, z);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable Class<T> cls, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658976398")) {
            return (T) ipChange.ipc$dispatch("-1658976398", new Object[]{this, str, cls, str2});
        }
        String string = getString(str, str2);
        if (cls == null) {
            return null;
        }
        return (T) f31.INSTANCE.parseJson(string, (Class) cls);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public float getFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107856432")) {
            return ((Float) ipChange.ipc$dispatch("1107856432", new Object[]{this, str, Float.valueOf(f)})).floatValue();
        } else if (a(str)) {
            return f;
        } else {
            return b().getFloat(str, f);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public int getInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620969591")) {
            return ((Integer) ipChange.ipc$dispatch("-620969591", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        } else if (a(str)) {
            return i;
        } else {
            return b().getInt(str, i);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public long getLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1797845106")) {
            return ((Long) ipChange.ipc$dispatch("1797845106", new Object[]{this, str, Long.valueOf(j)})).longValue();
        } else if (a(str)) {
            return j;
        } else {
            return b().getLong(str, j);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66951515")) {
            return (String) ipChange.ipc$dispatch("-66951515", new Object[]{this, str, str2});
        } else if (a(str)) {
            return str2;
        } else {
            return b().getString(str, str2);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean isExpected(@Nullable String str, @NotNull String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983334934")) {
            return ((Boolean) ipChange.ipc$dispatch("-1983334934", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
        }
        k21.i(str2, "expectedValue");
        String string = getString(str, null);
        return string != null ? k21.d(string, str2) : z;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "936967751")) {
            ipChange.ipc$dispatch("936967751", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (!a(str)) {
            b().edit().putBoolean(str, z).apply();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putConfigObj(@Nullable String str, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1495116924")) {
            ipChange.ipc$dispatch("1495116924", new Object[]{this, str, obj});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (!z) {
            putString(str, obj != null ? f31.INSTANCE.toJsonString(obj) : "");
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585573145")) {
            ipChange.ipc$dispatch("-585573145", new Object[]{this, str, Float.valueOf(f)});
        } else if (!a(str)) {
            b().edit().putFloat(str, f).apply();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412676099")) {
            ipChange.ipc$dispatch("-412676099", new Object[]{this, str, Integer.valueOf(i)});
        } else if (!a(str)) {
            b().edit().putInt(str, i).apply();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334991625")) {
            ipChange.ipc$dispatch("-334991625", new Object[]{this, str, Long.valueOf(j)});
        } else if (!a(str)) {
            b().edit().putLong(str, j).apply();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468509762")) {
            ipChange.ipc$dispatch("468509762", new Object[]{this, str, str2});
        } else if (!a(str)) {
            b().edit().putString(str, str2).apply();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void removeKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504597021")) {
            ipChange.ipc$dispatch("1504597021", new Object[]{this, str});
        } else if (!a(str)) {
            b().edit().remove(str).apply();
        }
    }
}
