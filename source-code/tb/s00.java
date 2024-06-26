package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: Taobao */
public class s00 {
    private volatile com.taobao.android.dinamicx.template.db.b a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final s00 a = new s00();
    }

    public static s00 b() {
        return b.a;
    }

    private boolean f() {
        if (this.a == null) {
            c(DinamicXEngine.i(), v00.DB_NAME);
        }
        if (this.a != null) {
            return true;
        }
        g("DB_Open", e.DX_DB_NULL, "dXDataBaseHelper == null");
        return false;
    }

    private void g(String str, int i, String str2) {
        e eVar = new e("DinamicX_db");
        e.a aVar = new e.a("DB", str, i);
        aVar.e = str2;
        ArrayList arrayList = new ArrayList();
        eVar.c = arrayList;
        arrayList.add(aVar);
        DXAppMonitor.n(eVar);
    }

    private void h(String str, String str2, DXTemplateItem dXTemplateItem, long j) {
        DXAppMonitor.s(2, str2, "DB", str, dXTemplateItem, DXAppMonitor.g((float) j), (double) j, true);
    }

    public void a(String str, DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        if (f()) {
            this.a.e(str, dXTemplateItem);
        }
        h("DB_Delete", str, dXTemplateItem, System.nanoTime() - nanoTime);
    }

    public synchronized void c(Context context, String str) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (this.a == null) {
                    this.a = new com.taobao.android.dinamicx.template.db.b(context, str);
                }
            }
        }
    }

    public void d(String str, DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        if (f()) {
            this.a.h(str, dXTemplateItem);
        }
        h("DB_Store", str, dXTemplateItem, System.nanoTime() - nanoTime);
    }

    public LinkedList<DXTemplateItem> e(String str, DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        if (f()) {
            return this.a.g(str, dXTemplateItem);
        }
        h("DB_Query", str, dXTemplateItem, System.nanoTime() - nanoTime);
        return null;
    }

    private s00() {
    }
}
