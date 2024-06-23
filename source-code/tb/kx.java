package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class kx {
    private DXLongSparseArray<Map<String, Integer>> a;
    private o00 b;

    public kx(o00 o00) {
        this.b = o00;
    }

    public DXLongSparseArray<Map<String, Integer>> a() {
        return this.a;
    }

    public boolean b(int i, ys ysVar, DXRuntimeContext dXRuntimeContext) {
        if (i == 0) {
            return true;
        }
        int c = ysVar.c();
        short h = ysVar.h();
        if (h < 0) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_COUNT_ERROR, "totalSize < 0"));
            return false;
        }
        this.a = new DXLongSparseArray<>(h);
        for (int i2 = 0; i2 < h; i2++) {
            long g = ysVar.g();
            byte d = ysVar.d();
            if (d <= 0) {
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_ERROR, "count <= 0"));
                return false;
            }
            HashMap hashMap = new HashMap(d);
            int i3 = 0;
            while (i3 < d) {
                hashMap.put(this.b.getString(ysVar.g()), Integer.valueOf(ysVar.f()));
                i3++;
                c = c;
            }
            this.a.put(g, hashMap);
        }
        if (ysVar.c() - c == i) {
            return true;
        }
        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_ERROR, "reader.getPos() - startPos != length"));
        return false;
    }
}
