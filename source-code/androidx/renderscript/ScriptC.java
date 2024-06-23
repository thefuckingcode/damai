package androidx.renderscript;

import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class ScriptC extends Script {
    private static final String TAG = "ScriptC";

    protected ScriptC(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    private static synchronized long internalCreate(RenderScript renderScript, Resources resources, int i) {
        long nScriptCCreate;
        synchronized (ScriptC.class) {
            InputStream openRawResource = resources.openRawResource(i);
            try {
                byte[] bArr = new byte[1024];
                int i2 = 0;
                while (true) {
                    int length = bArr.length - i2;
                    if (length == 0) {
                        int length2 = bArr.length * 2;
                        byte[] bArr2 = new byte[length2];
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        length = length2 - i2;
                        bArr = bArr2;
                    }
                    int read = openRawResource.read(bArr, i2, length);
                    if (read <= 0) {
                        try {
                            nScriptCCreate = renderScript.nScriptCCreate(resources.getResourceEntryName(i), renderScript.getApplicationContext().getCacheDir().toString(), bArr, i2);
                        } catch (IOException unused) {
                            throw new Resources.NotFoundException();
                        }
                    } else {
                        i2 += read;
                    }
                }
            } finally {
                openRawResource.close();
            }
        }
        return nScriptCCreate;
    }

    private static synchronized long internalStringCreate(RenderScript renderScript, String str, byte[] bArr) {
        long nScriptCCreate;
        synchronized (ScriptC.class) {
            nScriptCCreate = renderScript.nScriptCCreate(str, renderScript.getApplicationContext().getCacheDir().toString(), bArr, bArr.length);
        }
        return nScriptCCreate;
    }

    protected ScriptC(RenderScript renderScript, Resources resources, int i) {
        super(0, renderScript);
        long internalCreate = internalCreate(renderScript, resources, i);
        if (internalCreate != 0) {
            setID(internalCreate);
            return;
        }
        throw new RSRuntimeException("Loading of ScriptC script failed.");
    }

    protected ScriptC(RenderScript renderScript, String str, byte[] bArr, byte[] bArr2) {
        super(0, renderScript);
        long j;
        if (RenderScript.sPointerSize == 4) {
            j = internalStringCreate(renderScript, str, bArr);
        } else {
            j = internalStringCreate(renderScript, str, bArr2);
        }
        if (j != 0) {
            setID(j);
            return;
        }
        throw new RSRuntimeException("Loading of ScriptC script failed.");
    }
}
