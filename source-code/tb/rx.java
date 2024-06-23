package tb;

import android.util.Log;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.eventchain.DXAtomicEventNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* compiled from: Taobao */
public class rx {
    private tx a = null;
    private o00 b;
    private a c;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a {
        private Map<String, ay> a;
        private Stack<ay> b = new Stack<>();
        private o00 c;

        public a(rx rxVar, o00 o00) {
            this.c = o00;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0136, code lost:
            r16.a.put(r9, r11);
            r6 = r6 + 1;
         */
        public boolean b(int i, ys ysVar, DXRuntimeContext dXRuntimeContext) {
            ay ayVar;
            if (i == 0) {
                return true;
            }
            ysVar.b();
            short h = ysVar.h();
            if (h < 0) {
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_COUNT_ERROR, "count < 0"));
                return false;
            }
            this.a = new HashMap(h);
            int i2 = 0;
            boolean z = true;
            while (i2 < h) {
                short h2 = ysVar.h();
                String str = new String(ysVar.a(), ysVar.c(), (int) h2);
                ysVar.j(h2);
                ysVar.h();
                this.b.clear();
                byte d = ysVar.d();
                ay ayVar2 = null;
                char c2 = 0;
                while (true) {
                    if (d == 0) {
                        if (ayVar2 != null) {
                            this.b.push(ayVar2);
                        }
                        byte d2 = ysVar.d();
                        if (d2 == 1) {
                            ayVar = new sy();
                        } else if (d2 == 3) {
                            ayVar = new bt();
                        } else if (d2 == 5) {
                            ayVar = new ts();
                        } else if (d2 == 4) {
                            ayVar = new j00();
                        } else if (d2 == 2) {
                            ayVar = new i10();
                        } else if (d2 == 6) {
                            ayVar = new ux();
                        } else if (d2 != 7) {
                            return false;
                        } else {
                            ayVar = new f00();
                        }
                        long g = ysVar.g();
                        ayVar.b = g;
                        String string = this.c.getString(g);
                        ayVar.d = string;
                        if (string != null || d2 == 6 || d2 == 1 || d2 == 7) {
                            ayVar2 = ayVar;
                        } else {
                            List<e.a> list = dXRuntimeContext.getDxError().c;
                            list.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_EVENT_CHAIN_BINARY_FILE_EXPR_LOADER_COMMON_ERROR, "exprNode.name == null && type != DXExprNode.Event && type != DXExprNode.Method exprid" + ayVar.b));
                            return false;
                        }
                    } else if (d != 1) {
                        Log.e("EventChainLoader_TMTEST", "load expr invalidate tag type:" + ((int) d));
                        List<e.a> list2 = dXRuntimeContext.getDxError().c;
                        list2.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_COMMON_ERROR, "load expr invalidate tag type:" + ((int) d)));
                        z = false;
                        c2 = 2;
                    } else if (this.b.size() > 0) {
                        ay pop = this.b.pop();
                        pop.a(ayVar2);
                        ayVar2 = pop;
                    } else {
                        c2 = 1;
                    }
                    if (c2 != 0) {
                        break;
                    }
                    d = ysVar.d();
                }
            }
            if (!z) {
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", 70008));
            }
            return z;
        }
    }

    public rx() {
        o00 o00 = new o00();
        this.b = o00;
        this.c = new a(this, o00);
    }

    private DXAtomicEventNode b(int i2, String str, ys ysVar, DXRuntimeContext dXRuntimeContext) {
        try {
            short h2 = ysVar.h();
            String str2 = new String(ysVar.a(), ysVar.c(), (int) h2);
            ysVar.j(h2);
            DXAtomicEventNode dXAtomicEventNode = new DXAtomicEventNode(str2, Long.valueOf(ysVar.g()));
            short h3 = ysVar.h();
            if (h3 != 0) {
                dXAtomicEventNode.w(new String(ysVar.a(), ysVar.c(), (int) h3));
                ysVar.j(h3);
            }
            short h4 = ysVar.h();
            if (h4 != 0) {
                dXAtomicEventNode.u(new String(ysVar.a(), ysVar.c(), (int) h4));
                ysVar.j(h4);
            }
            int f2 = ysVar.f();
            if (f2 != 0) {
                dXAtomicEventNode.v(new String(ysVar.a(), ysVar.c(), f2));
                ysVar.j(f2);
            }
            return dXAtomicEventNode;
        } catch (Exception e2) {
            if (DinamicXEngine.x()) {
                e2.printStackTrace();
            }
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_ATOMICEVENT, vx.a(e2)));
            return null;
        }
    }

    private mx c(int i2, ys ysVar, DXRuntimeContext dXRuntimeContext) {
        try {
            short h2 = ysVar.h();
            String str = new String(ysVar.a(), ysVar.c(), (int) h2);
            ysVar.j(h2);
            short h3 = ysVar.h();
            mx mxVar = new mx(str, h3);
            for (int i3 = 0; i3 < h3; i3++) {
                ysVar.d();
                DXAtomicEventNode b2 = b(ysVar.h(), str, ysVar, dXRuntimeContext);
                if (b2 == null) {
                    List<e.a> list = dXRuntimeContext.getDxError().c;
                    list.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_ATOMICEVENT, "eventChainName" + str));
                    return null;
                }
                mxVar.a(b2.n(), b2);
                ysVar.d();
            }
            return mxVar;
        } catch (Exception e2) {
            if (DinamicXEngine.x()) {
                e2.printStackTrace();
            }
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_EVENTCHIAN, vx.a(e2)));
            return null;
        }
    }

    public tx a(ys ysVar, DXRuntimeContext dXRuntimeContext) {
        mx c2;
        long nanoTime = System.nanoTime();
        if (this.e == 0 || ysVar == null || !ysVar.i(this.d)) {
            return null;
        }
        byte d2 = ysVar.d();
        if (d2 < 0) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_COUNT_ERROR));
            return null;
        }
        this.a = new tx();
        for (int i2 = 0; i2 < d2; i2++) {
            if (ysVar.d() != 0 || (c2 = c(ysVar.f(), ysVar, dXRuntimeContext)) == null) {
                return null;
            }
            this.a.e(c2.d(), c2);
            if (ysVar.d() != 1) {
                return null;
            }
        }
        this.a.d(this.c.a);
        Log.e("TIME:", "eventchain_createEventChain** " + (System.nanoTime() - nanoTime));
        return this.a;
    }

    public boolean d(ys ysVar, DXRuntimeContext dXRuntimeContext) {
        long nanoTime = System.nanoTime();
        if (ysVar == null || !ysVar.i(this.d)) {
            return false;
        }
        if (!ysVar.j(this.e)) {
            Log.e("EventChainLoader_TMTEST", "event chain seekBy error:" + this.e);
            return false;
        }
        ysVar.c();
        if (ysVar.c() != this.f) {
            List<e.a> list = dXRuntimeContext.getDxError().c;
            list.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_STRING_LOADER_POSITION_ERROR, "event chain string pos error:" + this.f + "  read pos:" + ysVar.c()));
        } else if (!this.b.a(this.g, ysVar, dXRuntimeContext)) {
            wz.b("event chain string loadFromBuffer error!");
        }
        if (ysVar.c() != this.h) {
            List<e.a> list2 = dXRuntimeContext.getDxError().c;
            list2.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_EXPR_LOADER_POSITION_ERROR, "event chain expr pos error:" + this.h + "  read pos:" + ysVar.c()));
        } else if (!this.c.b(this.i, ysVar, dXRuntimeContext)) {
            wz.b("event chain expr loadFromBuffer error!");
        }
        Log.e("TIME:", "eventchain_loadFromBuffer** " + (System.nanoTime() - nanoTime));
        return true;
    }

    public void e(int i2) {
        this.e = i2;
    }

    public void f(int i2) {
        this.d = i2;
    }

    public void g(int i2) {
        this.i = i2;
    }

    public void h(int i2) {
        this.h = i2;
    }

    public void i(int i2) {
        this.g = i2;
    }

    public void j(int i2) {
        this.f = i2;
    }
}
