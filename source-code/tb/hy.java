package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/* compiled from: Taobao */
public class hy {
    private static File b;
    private final LruCache<String, byte[]> a = new LruCache<>(50);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final hy a = new hy();
        private static hy b = null;
    }

    public static hy c() {
        return (!DinamicXEngine.x() || a.b == null) ? a.a : a.b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void h(hy hyVar) {
        if (a.b == null) {
            hy unused = a.b = hyVar;
        }
    }

    private void i(String str, long j) {
        DXAppMonitor.s(2, "DinamicX_File", "Template", str, null, DXAppMonitor.g((float) j), (double) j, true);
    }

    public String a() {
        return v00.ASSET_DIR;
    }

    public String b() {
        File file = b;
        if (file == null) {
            return "";
        }
        return file.getAbsolutePath();
    }

    public void d(@NonNull Context context) {
        if (context == null) {
            wz.d("DinamicX_File", "DXFileManager", "context is null");
        }
        File file = b;
        if (file == null || !file.exists()) {
            File file2 = new File(context.getFilesDir(), v00.DEFAULT_ROOT_DIR);
            b = file2;
            if (!file2.exists() && !b.mkdirs()) {
                b.mkdirs();
            }
        }
    }

    public byte[] e(String str, DXRuntimeContext dXRuntimeContext) {
        List<e.a> list;
        byte[] bArr;
        long nanoTime = System.nanoTime();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.a) {
                bArr = this.a.get(str);
                if ((bArr == null || bArr.length == 0) && (bArr = b.c(str)) != null && bArr.length > 0) {
                    this.a.put(str, bArr);
                }
                i("Template_Read", System.nanoTime() - nanoTime);
            }
            return bArr;
        } catch (IOException e) {
            if (dXRuntimeContext == null || dXRuntimeContext.getDxError() == null || (list = dXRuntimeContext.getDxError().c) == null) {
                return null;
            }
            e.a aVar = new e.a("Template", "Template_Read", e.DX_TEMPLATE_IO_READ_ERROR);
            if (e instanceof FileNotFoundException) {
                aVar.e = "fileNotFound " + str;
            } else {
                aVar.e = vx.a(e);
            }
            list.add(aVar);
            return null;
        }
    }

    public void f(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            synchronized (this.a) {
                if (this.a.get(str) == null) {
                    this.a.put(str, bArr);
                }
            }
        }
    }

    public boolean g(String str, byte[] bArr) {
        long nanoTime = System.nanoTime();
        boolean h = b.h(str, bArr);
        if (h) {
            i("Template_Write", System.nanoTime() - nanoTime);
        }
        return h;
    }
}
