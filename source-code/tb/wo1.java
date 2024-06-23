package tb;

import android.annotation.SuppressLint;
import com.android.alibaba.ip.common.PatchInfo;
import com.android.alibaba.ip.common.PatchResult;
import com.android.alibaba.ip.server.InstantPatcher;
import com.taobao.update.instantpatch.InstantPatchUpdater;
import com.taobao.update.instantpatch.flow.PatchChecker;
import com.taobao.update.instantpatch.model.InstantUpdateInfo;
import java.io.IOException;

/* compiled from: Taobao */
public class wo1 {
    private n11 a;

    public wo1(n11 n11) {
        this.a = n11;
    }

    @SuppressLint({"NewApi"})
    public void install(InstantUpdateInfo instantUpdateInfo) {
        PatchResult patchResult = new PatchResult();
        PatchInfo createPatchInfo = InstantPatchUpdater.instance().createPatchInfo(instantUpdateInfo);
        try {
            InstantPatcher.create(this.a.context).setiPatchVerifier(new PatchChecker());
            patchResult = InstantPatcher.create(this.a.context).handlePatches(this.a.path, createPatchInfo);
        } catch (IOException e) {
            e.printStackTrace();
            patchResult.resCode = 3;
        }
        switch (patchResult.resCode) {
            case 0:
                this.a.success = true;
                return;
            case 1:
                this.a.success = true;
                return;
            case 2:
                n11 n11 = this.a;
                n11.success = false;
                n11.errorCode = 2;
                n11.errorMsg = "patch verify failed";
                return;
            case 3:
                n11 n112 = this.a;
                n112.success = false;
                n112.errorCode = 3;
                n112.errorMsg = patchResult.msg;
                return;
            case 4:
                n11 n113 = this.a;
                n113.success = false;
                n113.errorCode = 4;
                n113.errorMsg = "patch has no dex";
                return;
            case 5:
                n11 n114 = this.a;
                n114.success = false;
                n114.errorCode = 5;
                n114.errorMsg = "patch is mismatch";
                return;
            case 6:
                n11 n115 = this.a;
                n115.success = false;
                n115.errorCode = 6;
                n115.errorMsg = patchResult.msg;
                return;
            default:
                return;
        }
    }
}
