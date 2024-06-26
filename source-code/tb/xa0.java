package tb;

import android.content.Context;
import com.alibaba.pictures.dolores.business.IDoloresEncryptor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.dynamicdataencrypt.IDynamicDataEncryptComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class xa0 implements IDoloresEncryptor {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final xa0 INSTANCE = new xa0();

    private xa0() {
    }

    private final String a(Context context, String str) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1219788618")) {
            return (String) ipChange.ipc$dispatch("1219788618", new Object[]{this, context, str});
        }
        if (context == null || str == null) {
            return str;
        }
        SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
        if (instance == null || (dynamicDataEncryptComp = instance.getDynamicDataEncryptComp()) == null) {
            return null;
        }
        return dynamicDataEncryptComp.dynamicDecrypt(str);
    }

    private final String b(Context context, String str) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003091934")) {
            return (String) ipChange.ipc$dispatch("-2003091934", new Object[]{this, context, str});
        }
        if (context == null || str == null) {
            return str;
        }
        SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
        if (instance == null || (dynamicDataEncryptComp = instance.getDynamicDataEncryptComp()) == null) {
            return null;
        }
        return dynamicDataEncryptComp.dynamicEncrypt(str);
    }

    @Override // com.alibaba.pictures.dolores.business.IDoloresEncryptor
    @Nullable
    public String decrypt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "459855190")) {
            return a(ua0.Companion.g().i(), str);
        }
        return (String) ipChange.ipc$dispatch("459855190", new Object[]{this, str});
    }

    @Override // com.alibaba.pictures.dolores.business.IDoloresEncryptor
    @Nullable
    public String encrypt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1873195986")) {
            return b(ua0.Companion.g().i(), str);
        }
        return (String) ipChange.ipc$dispatch("-1873195986", new Object[]{this, str});
    }
}
