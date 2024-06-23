package tb;

import android.text.TextUtils;
import java.io.File;

/* compiled from: Taobao */
public class n11 extends dj2 {
    public String path;
    public String workDir;

    public String getPatchPath() {
        if (this.context == null) {
            return null;
        }
        if (TextUtils.isEmpty(this.workDir)) {
            this.workDir = new File(this.context.getExternalCacheDir(), js2.HOTPATCH).getAbsolutePath();
        }
        return this.workDir;
    }
}
