package tb;

import android.util.Log;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import java.util.List;
import java.util.Stack;

/* compiled from: Taobao */
public class xx {
    private DXLongSparseArray<ay> a;
    private Stack<ay> b = new Stack<>();
    private o00 c;

    public xx(o00 o00) {
        this.c = o00;
    }

    public ay a(long j) {
        DXLongSparseArray<ay> dXLongSparseArray = this.a;
        if (dXLongSparseArray != null) {
            return dXLongSparseArray.get(j);
        }
        return null;
    }

    public DXLongSparseArray<ay> b() {
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012b, code lost:
        r17.a.put(r8, r11);
        r6 = r6 + 1;
        r2 = r16;
     */
    public boolean c(int i, ys ysVar, DXRuntimeContext dXRuntimeContext) {
        short s;
        ay f00;
        byte b2 = 1;
        if (i == 0) {
            return true;
        }
        ysVar.b();
        short h = ysVar.h();
        if (h < 0) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_COUNT_ERROR, "count < 0"));
            return false;
        }
        this.a = new DXLongSparseArray<>(h);
        int i2 = 0;
        boolean z = true;
        while (i2 < h) {
            long g = ysVar.g();
            ysVar.h();
            this.b.clear();
            byte d = ysVar.d();
            ay ayVar = null;
            char c2 = 0;
            while (true) {
                if (d == 0) {
                    if (ayVar != null) {
                        this.b.push(ayVar);
                    }
                    byte d2 = ysVar.d();
                    if (d2 == b2) {
                        f00 = new sy();
                    } else if (d2 == 3) {
                        f00 = new bt();
                    } else if (d2 == 5) {
                        f00 = new ts();
                    } else if (d2 == 4) {
                        f00 = new j00();
                    } else if (d2 == 2) {
                        f00 = new i10();
                    } else if (d2 == 6) {
                        f00 = new ux();
                    } else if (d2 != 7) {
                        return false;
                    } else {
                        f00 = new f00();
                    }
                    s = h;
                    long g2 = ysVar.g();
                    f00.b = g2;
                    String string = this.c.getString(g2);
                    f00.d = string;
                    if (string != null || d2 == 6) {
                        b2 = 1;
                    } else {
                        b2 = 1;
                        if (!(d2 == 1 || d2 == 7)) {
                            List<e.a> list = dXRuntimeContext.getDxError().c;
                            list.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_COMMON_ERROR, "exprNode.name == null && type != DXExprNode.Event && type != DXExprNode.Method exprid" + f00.b));
                            return false;
                        }
                    }
                    ayVar = f00;
                } else if (d != b2) {
                    Log.e("CodeManager_TMTEST", "load expr invalidate tag type:" + ((int) d));
                    List<e.a> list2 = dXRuntimeContext.getDxError().c;
                    list2.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_COMMON_ERROR, "load expr invalidate tag type:" + ((int) d)));
                    s = h;
                    z = false;
                    c2 = 2;
                } else if (this.b.size() > 0) {
                    ay pop = this.b.pop();
                    pop.a(ayVar);
                    s = h;
                    ayVar = pop;
                } else {
                    s = h;
                    c2 = 1;
                }
                if (c2 != 0) {
                    break;
                }
                d = ysVar.d();
                h = s;
            }
        }
        if (!z) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", 70008));
        }
        return z;
    }
}
