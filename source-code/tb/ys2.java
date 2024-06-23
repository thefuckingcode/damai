package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.ta.utdid2.device.UTDevice;
import com.uploader.export.UploaderGlobal;
import java.util.HashMap;

/* compiled from: Taobao */
public class ys2 extends xs2 {
    private final Context context;
    private volatile int environment;
    private volatile String utdid;

    public ys2(Context context2, int i) {
        super(i);
        this.environment = 0;
        if (context2 == null) {
            this.context = UploaderGlobal.f();
        } else {
            this.context = context2;
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public byte[] decrypt(Context context2, String str, byte[] bArr) {
        try {
            return SecurityGuardManager.getInstance(context2).getStaticDataEncryptComp().staticBinarySafeDecryptNoB64(16, str, bArr, getCurrentElement().e);
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

    @Override // tb.xs2, com.uploader.export.IUploaderEnvironment
    public int getEnvironment() {
        return this.environment;
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
            return SecurityGuardManager.getInstance(this.context).getSecureSignatureComp().signRequest(securityGuardParamContext, getCurrentElement().e);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ys2(Context context2) {
        this(context2, 0);
    }
}
