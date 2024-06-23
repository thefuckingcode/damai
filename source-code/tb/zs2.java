package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.ta.utdid2.device.UTDevice;
import com.uploader.export.IUploaderEnvironment;
import java.util.HashMap;

@Deprecated
/* compiled from: Taobao */
public class zs2 implements IUploaderEnvironment {
    private volatile String authCode;
    private final Context context;
    private volatile String dailyAppKey = "4272";
    private volatile int environment = 0;
    private final int instanceType;
    private volatile String onlineAppKey = "21646297";
    private volatile String prepareAppKey = "21646297";
    private volatile String utdid;

    public zs2(Context context2) {
        this.context = context2;
        this.instanceType = 0;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public byte[] decrypt(Context context2, String str, byte[] bArr) {
        try {
            return SecurityGuardManager.getInstance(context2).getStaticDataEncryptComp().staticBinarySafeDecryptNoB64(16, str, bArr, this.authCode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public boolean enableFlowControl() {
        return false;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getAppKey() {
        int environment2 = getEnvironment();
        if (environment2 == 0) {
            return this.onlineAppKey;
        }
        if (environment2 == 1) {
            return this.prepareAppKey;
        }
        if (environment2 != 2) {
            return this.onlineAppKey;
        }
        return this.dailyAppKey;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getAppVersion() {
        try {
            String str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
            if (TextUtils.isEmpty(str)) {
                return "0";
            }
            return str;
        } catch (Throwable unused) {
            return "0";
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getDomain() {
        return null;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public int getEnvironment() {
        return this.environment;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public int getInstanceType() {
        return 0;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public byte[] getSslTicket(Context context2, String str) {
        try {
            return SecurityGuardManager.getInstance(context2).getDynamicDataStoreComp().getByteArray(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getUserId() {
        return null;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getUtdid() {
        if (this.utdid != null) {
            return this.utdid;
        }
        try {
            this.utdid = UTDevice.getUtdid(this.context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.utdid;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public int putSslTicket(Context context2, String str, byte[] bArr) {
        try {
            return SecurityGuardManager.getInstance(context2).getDynamicDataStoreComp().putByteArray(str, bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setAppKey(String str, String str2, String str3) {
        this.onlineAppKey = str;
        this.prepareAppKey = str2;
        this.dailyAppKey = str3;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setEnvironment(int i) {
        this.environment = i;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String signature(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("INPUT", str);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = getAppKey();
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 3;
        try {
            return SecurityGuardManager.getInstance(this.context).getSecureSignatureComp().signRequest(securityGuardParamContext, this.authCode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
