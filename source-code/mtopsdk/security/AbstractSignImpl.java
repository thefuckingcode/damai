package mtopsdk.security;

import androidx.annotation.NonNull;
import java.util.HashMap;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;

/* compiled from: Taobao */
public abstract class AbstractSignImpl implements ISign {
    EnvModeEnum envMode = null;
    MtopConfig mtopConfig = null;

    /* access modifiers changed from: package-private */
    /* renamed from: mtopsdk.security.AbstractSignImpl$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum = iArr;
            iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.PREPARE.ordinal()] = 2;
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST.ordinal()] = 3;
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getAuthCode() {
        MtopConfig mtopConfig2 = this.mtopConfig;
        return mtopConfig2 != null ? mtopConfig2.authCode : "";
    }

    @Override // mtopsdk.security.ISign
    public String getAvmpSign(String str, String str2, int i) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getEnv() {
        EnvModeEnum envModeEnum = this.envMode;
        if (envModeEnum == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i == 3 || i == 4) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public String getInstanceId() {
        MtopConfig mtopConfig2 = this.mtopConfig;
        return mtopConfig2 != null ? mtopConfig2.instanceId : "";
    }

    @Override // mtopsdk.security.ISign
    public String getMiniWua(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getSign(HashMap<String, String> hashMap, String str) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public HashMap<String, String> getUnifiedSign(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2, boolean z) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getWua(HashMap<String, String> hashMap, String str) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public void init(@NonNull MtopConfig mtopConfig2) {
        this.mtopConfig = mtopConfig2;
        if (mtopConfig2 != null) {
            this.envMode = mtopConfig2.envMode;
        }
    }
}
