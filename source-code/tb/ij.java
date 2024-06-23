package tb;

import com.alibaba.pictures.cornerstone.protocol.ICloudConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ij implements ICloudConfig, OConfigListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a = "Orange.";
    private Map<String, String[]> b = new HashMap();

    /* compiled from: Taobao */
    public static final class a implements OConfigListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ICloudConfig.OnGroupUpdateListener a;

        a(ICloudConfig.OnGroupUpdateListener onGroupUpdateListener) {
            this.a = onGroupUpdateListener;
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(@Nullable String str, @Nullable Map<String, String> map) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1180356548")) {
                ipChange.ipc$dispatch("1180356548", new Object[]{this, str, map});
                return;
            }
            if (!(str == null || str.length() == 0)) {
                if (map != null && !map.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    this.a.onUpdate(str, map);
                }
            }
        }
    }

    private final String a(String str, String str2) {
        String[] strArr;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1503858196")) {
            return (String) ipChange.ipc$dispatch("-1503858196", new Object[]{this, str, str2});
        }
        if (str2 == null || str2.length() == 0) {
            z = true;
        }
        if (z || (strArr = this.b.get(str)) == null || !e.r(strArr, str2)) {
            return null;
        }
        e91 e91 = e91.INSTANCE;
        e91.d("CloudConfigImpl", "getCacheableValueByKey:groupName=" + str + ",key=" + str2 + ",cacheable=true");
        i81 i81 = i81.INSTANCE;
        return i81.getString(this.a + str2, null);
    }

    private final void b(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-36706301")) {
            ipChange.ipc$dispatch("-36706301", new Object[]{this, str});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            String[] strArr = this.b.get(str);
            Map<String, String> allConfig = getAllConfig(str);
            if (s6.INSTANCE.debugable()) {
                e91.INSTANCE.d("CloudConfigImpl", "updateCacheKeysValue:groupName=" + str + ",allConfig==" + f31.INSTANCE.toJsonString(allConfig) + "||cacheableKeys==null");
            }
            if (!(allConfig == null || allConfig.isEmpty())) {
                if (strArr != null) {
                    if (!(strArr.length == 0)) {
                        z = false;
                    }
                }
                if (!z) {
                    for (String str2 : strArr) {
                        String str3 = allConfig.get(str2);
                        if (str3 == null) {
                            i81.INSTANCE.removeKey(this.a + str2);
                        } else {
                            i81.INSTANCE.putString(this.a + str2, str3);
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void forceCheckUpdate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829564201")) {
            ipChange.ipc$dispatch("-829564201", new Object[]{this});
            return;
        }
        OrangeConfig.getInstance().forceCheckUpdate();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public Map<String, String> getAllConfig(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1247120785")) {
            return (Map) ipChange.ipc$dispatch("-1247120785", new Object[]{this, str});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            return null;
        }
        return OrangeConfig.getInstance().getConfigs(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable String str2, @Nullable Class<T> cls, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1297988611")) {
            return (T) ipChange.ipc$dispatch("-1297988611", new Object[]{this, str, str2, cls, str3});
        }
        String string = getString(str, str2, str3);
        if (!(string == null || string.length() == 0)) {
            z = false;
        }
        if (!z && cls != null) {
            try {
                return (T) f31.INSTANCE.parseJson(string, (Class) cls);
            } catch (Exception e) {
                e91 e91 = e91.INSTANCE;
                e91.e("CloudConfigImpl", "getConfigObj():" + e);
            }
        }
        return null;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public String getCustomConfig(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1066533992")) {
            return (String) ipChange.ipc$dispatch("1066533992", new Object[]{this, str, str2});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            return str2;
        }
        return OrangeConfig.getInstance().getCustomConfig(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public float getFloat(@Nullable String str, @Nullable String str2, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953101125")) {
            return ((Float) ipChange.ipc$dispatch("1953101125", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue();
        }
        String string = getString(str, str2, null);
        if (string == null) {
            return f;
        }
        try {
            return Float.parseFloat(string);
        } catch (Exception e) {
            e91 e91 = e91.INSTANCE;
            e91.e("CloudConfigImpl", "getFloat():" + e);
            return f;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public int getInt(@Nullable String str, @Nullable String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821246050")) {
            return ((Integer) ipChange.ipc$dispatch("-821246050", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
        }
        String string = getString(str, str2, null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            e91 e91 = e91.INSTANCE;
            e91.e("CloudConfigImpl", "getInt()," + e);
            return i;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "365173980")) {
            return (String) ipChange.ipc$dispatch("365173980", new Object[]{this, str, str2, str3});
        }
        if (str == null || str.length() == 0) {
            return str3;
        }
        if (!(str2 == null || str2.length() == 0)) {
            z = false;
        }
        if (z) {
            return str3;
        }
        String config = OrangeConfig.getInstance().getConfig(str, str2, null);
        e91 e91 = e91.INSTANCE;
        e91.d("CloudConfigImpl", "getString:groupName=" + str + ":key=" + str2 + ",cloudValue=" + config);
        if (config == null) {
            config = a(str, str2);
            e91.d("CloudConfigImpl", "key=" + str2 + ",miss cloud value,cacheValue=" + config);
        }
        return config != null ? config : str3;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public boolean isExpected(@Nullable String str, @Nullable String str2, @NotNull String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1562093313")) {
            return ((Boolean) ipChange.ipc$dispatch("-1562093313", new Object[]{this, str, str2, str3, Boolean.valueOf(z)})).booleanValue();
        }
        k21.i(str3, "expectedValue");
        String string = getString(str, str2, null);
        return string != null ? k21.d(string, str3) : z;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void markCacheableKeys(@Nullable String str, @Nullable String[] strArr) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1271724811")) {
            ipChange.ipc$dispatch("1271724811", new Object[]{this, str, strArr});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    z = false;
                }
            }
            if (!z) {
                this.b.put(str, strArr);
            }
        }
    }

    @Override // com.taobao.orange.OConfigListener
    public void onConfigUpdate(@Nullable String str, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1001324888")) {
            ipChange.ipc$dispatch("-1001324888", new Object[]{this, str, map});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            if (map != null && !map.isEmpty()) {
                z = false;
            }
            if (!z) {
                e91 e91 = e91.INSTANCE;
                e91.d("CloudConfigImpl", "onUpdate:groupName=" + str);
                b(str);
            }
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void registerGroupConfigUpdateListener(@Nullable String str, @Nullable ICloudConfig.OnGroupUpdateListener onGroupUpdateListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553689647")) {
            ipChange.ipc$dispatch("553689647", new Object[]{this, str, onGroupUpdateListener, Boolean.valueOf(z)});
        } else if (str != null && onGroupUpdateListener != null) {
            OrangeConfig.getInstance().registerListener(new String[]{str}, new a(onGroupUpdateListener), z);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void startCheckAndUpdateCacheableKV() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "715326448")) {
            ipChange.ipc$dispatch("715326448", new Object[]{this});
            return;
        }
        try {
            Map<String, String[]> map = this.b;
            if (map != null) {
                if (!map.isEmpty()) {
                    z = false;
                }
            }
            if (!z) {
                Object[] array = this.b.keySet().toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    for (String str : strArr) {
                        b(str);
                    }
                    OrangeConfig.getInstance().registerListener(strArr, this, false);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } catch (Exception e) {
            e91.INSTANCE.e("CloudConfigImpl", "startCheckAndUpdateCacheableKV:" + e);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void stopCheckAndUpdateCacheableKV() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-746343360")) {
            ipChange.ipc$dispatch("-746343360", new Object[]{this});
            return;
        }
        Map<String, String[]> map = this.b;
        if (map != null && !map.isEmpty()) {
            z = false;
        }
        if (!z) {
            Object[] array = this.b.keySet().toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            OrangeConfig.getInstance().unregisterListener((String[]) array, this);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void unRegisterGroupConfigUpdateListener(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912744331")) {
            ipChange.ipc$dispatch("-1912744331", new Object[]{this, str});
        } else if (str != null) {
            OrangeConfig.getInstance().unregisterListener(new String[]{str});
        }
    }
}
