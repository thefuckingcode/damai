package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* compiled from: Taobao */
public final class h23 implements ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return s03.c(bArr, str);
        } catch (Exception e) {
            t43.c(Constants.TAG, "aes decrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return s03.d(bArr, str);
        } catch (Exception e) {
            t43.c(Constants.TAG, "aes encrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
