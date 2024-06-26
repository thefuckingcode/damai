package tb;

import android.util.Log;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.template.loader.binary.IDXStringSupport;

/* compiled from: Taobao */
public class o00 implements IDXStringSupport {
    private DXLongSparseArray<String> a;

    public boolean a(int i, ys ysVar, DXRuntimeContext dXRuntimeContext) {
        if (i == 0) {
            return true;
        }
        int b = ysVar.b();
        short h = ysVar.h();
        if (h < 0) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_COUNT_ERROR));
            return false;
        }
        this.a = new DXLongSparseArray<>(h);
        for (int i2 = 0; i2 < h; i2++) {
            long g = ysVar.g();
            short h2 = ysVar.h();
            if (ysVar.c() + h2 <= b) {
                this.a.put(g, new String(ysVar.a(), ysVar.c(), (int) h2));
                ysVar.j(h2);
            } else {
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_ERROR));
                Log.e("StringLoader_TMTEST", "read string over");
                return false;
            }
        }
        return true;
    }

    @Override // com.taobao.android.dinamicx.template.loader.binary.IDXStringSupport
    public String getString(long j) {
        DXLongSparseArray<String> dXLongSparseArray = this.a;
        if (dXLongSparseArray != null && dXLongSparseArray.get(j) != null) {
            return this.a.get(j);
        }
        if (!DinamicXEngine.x()) {
            return null;
        }
        Log.e("StringLoader_TMTEST", "getString null:" + j);
        return null;
    }
}
