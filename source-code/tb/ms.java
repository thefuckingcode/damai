package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.f;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;
import java.util.Stack;

/* compiled from: Taobao */
public class ms {
    public static final int EVENTCHAIN_MINOR_VERSION = 7;
    public static final int MAJOR_VERSION = 3;
    public static final int MINOR_VERSION_0 = 0;
    public static final int MINOR_VERSION_1 = 1;
    public static final int MINOR_VERSION_8 = 8;
    public static final int MINOR_VERSION_9 = 9;
    public static final int STATE_continue = 0;
    public static final int STATE_failed = 2;
    public static final int STATE_successful = 1;
    public static final short TYPE_ADAPTIVE_UNIT = 32;
    public static final short TYPE_COLOR = 16;
    public static final short TYPE_DOUBLE = 4;
    public static final short TYPE_ENUM = 512;
    public static final short TYPE_INT = 1;
    public static final short TYPE_LIST = 128;
    public static final short TYPE_LONG = 2;
    public static final short TYPE_MAP = 256;
    public static final short TYPE_NATIVE_UNIT = 64;
    public static final short TYPE_OBJECT = 1024;
    public static final short TYPE_STRING = 8;
    private int a;
    private o00 b = new o00();
    private o00 c;
    private e10 d;
    private xx e;
    private kx f;
    private ws g;
    private rx h;
    private cy i;
    private e00 j;
    private Stack<DXWidgetNode> k = new Stack<>();
    private int l = 1000;

    public ms() {
        o00 o00 = new o00();
        this.c = o00;
        this.e = new xx(o00);
        this.d = new e10();
        this.f = new kx(this.c);
        this.h = new rx();
        this.i = new cy();
        this.j = new e00();
        this.g = new ws();
        new n00();
    }

    private tx a(ys ysVar, DXRuntimeContext dXRuntimeContext, Context context) {
        if (ysVar == null) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EMPTY));
            return null;
        }
        try {
            return this.h.a(ysVar, dXRuntimeContext);
        } catch (Exception e2) {
            if (DinamicXEngine.x()) {
                e2.printStackTrace();
            }
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_CREATE_EVENT_CHAIN_ERROR, vx.a(e2)));
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:192:0x0472 A[LOOP:0: B:5:0x001c->B:192:0x0472, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0431 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02f9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0121  */
    private DXWidgetNode b(ys ysVar, DXRuntimeContext dXRuntimeContext, Context context) {
        char c2;
        DXWidgetNode dXWidgetNode;
        DXWidgetNode dXWidgetNode2;
        byte d2;
        int i2;
        long j2;
        long j3;
        byte b2;
        long j4;
        char c3;
        byte b3;
        long j5;
        DXWidgetNode dXWidgetNode3;
        JSONArray jSONArray;
        JSONObject jSONObject;
        Exception e2;
        Context context2 = context;
        DXWidgetNode dXWidgetNode4 = null;
        if (ysVar == null) {
            return null;
        }
        try {
            this.k.clear();
            this.l = 1000;
            byte d3 = ysVar.d();
            char c4 = 0;
            DXWidgetNode dXWidgetNode5 = null;
            char c5 = 0;
            while (true) {
                short s = 2;
                short s2 = 1;
                if (d3 == 0) {
                    long g2 = ysVar.g();
                    if (dXRuntimeContext.getWidgetNodeMap() == null) {
                        return dXWidgetNode4;
                    }
                    IDXBuilderWidgetNode iDXBuilderWidgetNode = dXRuntimeContext.getWidgetNodeMap().get(g2);
                    if (iDXBuilderWidgetNode != null) {
                        try {
                            dXWidgetNode2 = iDXBuilderWidgetNode.build(context2);
                            try {
                                int i3 = this.l;
                                this.l = i3 + 1;
                                dXWidgetNode2.setAutoId(i3);
                                try {
                                    dXWidgetNode2.setDXRuntimeContext(dXRuntimeContext);
                                    c4 = 1;
                                } catch (Exception e3) {
                                    e2 = e3;
                                    if (DinamicXEngine.x()) {
                                    }
                                    if (dXWidgetNode5 != null) {
                                    }
                                    if (c4 == 0) {
                                    }
                                    d2 = ysVar.d();
                                    i2 = 0;
                                    while (true) {
                                        String str = " value ";
                                        if (i2 >= d2) {
                                        }
                                        i2++;
                                        dXWidgetNode2 = dXWidgetNode3;
                                        g2 = j5;
                                        d2 = b3;
                                        c5 = c3;
                                        s = 2;
                                        s2 = 1;
                                    }
                                    if (c5 == 0) {
                                    }
                                }
                            } catch (Exception e4) {
                                e2 = e4;
                                if (DinamicXEngine.x()) {
                                }
                                if (dXWidgetNode5 != null) {
                                }
                                if (c4 == 0) {
                                }
                                d2 = ysVar.d();
                                i2 = 0;
                                while (true) {
                                    String str2 = " value ";
                                    if (i2 >= d2) {
                                    }
                                    i2++;
                                    dXWidgetNode2 = dXWidgetNode3;
                                    g2 = j5;
                                    d2 = b3;
                                    c5 = c3;
                                    s = 2;
                                    s2 = 1;
                                }
                                if (c5 == 0) {
                                }
                            }
                        } catch (Exception e5) {
                            e2 = e5;
                            dXWidgetNode2 = dXWidgetNode4;
                            if (DinamicXEngine.x()) {
                                e2.printStackTrace();
                            }
                            if (dXWidgetNode5 != null) {
                            }
                            if (c4 == 0) {
                            }
                            d2 = ysVar.d();
                            i2 = 0;
                            while (true) {
                                String str22 = " value ";
                                if (i2 >= d2) {
                                }
                                i2++;
                                dXWidgetNode2 = dXWidgetNode3;
                                g2 = j5;
                                d2 = b3;
                                c5 = c3;
                                s = 2;
                                s2 = 1;
                            }
                            if (c5 == 0) {
                            }
                        }
                    } else {
                        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_WIDGET_NOT_FOUND, "创建原型树找不到注册的widgetNode nodeId" + g2));
                        dXWidgetNode2 = dXWidgetNode4;
                        c4 = 0;
                    }
                    if (dXWidgetNode5 != null) {
                        this.k.push(dXWidgetNode5);
                    }
                    if (c4 == 0) {
                        if (this.k.size() == 0) {
                            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_CREATE_WT_CREATE_ROOT_ERROR, "创建原型树root节点失败 !getNodeResult nodeStack.size() nodeId" + g2));
                            return dXWidgetNode4;
                        }
                        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_ERROR, "创建节点失败 !getNodeResult nodeId" + g2));
                    }
                    d2 = ysVar.d();
                    i2 = 0;
                    while (true) {
                        String str222 = " value ";
                        if (i2 >= d2) {
                            short h2 = ysVar.h();
                            if (h2 == s2) {
                                b3 = d2;
                                c3 = c5;
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g3 = ysVar.g();
                                int f2 = ysVar.f();
                                if (dXWidgetNode3 != null) {
                                    dXWidgetNode3.setIntAttribute(g3, f2);
                                }
                            } else if (h2 == s) {
                                b3 = d2;
                                c3 = c5;
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g4 = ysVar.g();
                                long g5 = ysVar.g();
                                if (dXWidgetNode3 != null) {
                                    dXWidgetNode3.setLongAttribute(g4, g5);
                                }
                            } else if (h2 == 4) {
                                b3 = d2;
                                c3 = c5;
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g6 = ysVar.g();
                                double e6 = ysVar.e();
                                if (dXWidgetNode3 != null) {
                                    dXWidgetNode3.setDoubleAttribute(g6, e6);
                                }
                            } else if (h2 == 8) {
                                b3 = d2;
                                c3 = c5;
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g7 = ysVar.g();
                                long g8 = ysVar.g();
                                if (dXWidgetNode3 != null) {
                                    String string = this.c.getString(g8);
                                    if (TextUtils.isEmpty(string)) {
                                        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_STRING_ERROR, "nodeId" + j5 + str222 + g8));
                                        return null;
                                    }
                                    dXWidgetNode3.setStringAttribute(g7, string);
                                } else {
                                    continue;
                                }
                            } else if (h2 == 16) {
                                b3 = d2;
                                c3 = c5;
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g9 = ysVar.g();
                                int f3 = ysVar.f();
                                if (dXWidgetNode3 != null) {
                                    dXWidgetNode3.setIntAttribute(g9, f3);
                                }
                            } else if (h2 == 32) {
                                b3 = d2;
                                c3 = c5;
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g10 = ysVar.g();
                                int b4 = d00.b(context2, (float) ysVar.e());
                                if (dXWidgetNode3 != null) {
                                    dXWidgetNode3.setIntAttribute(g10, b4);
                                }
                            } else if (h2 == 64) {
                                b3 = d2;
                                c3 = c5;
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g11 = ysVar.g();
                                int c6 = d00.c(context2, (float) ysVar.e());
                                if (dXWidgetNode3 != null) {
                                    dXWidgetNode3.setIntAttribute(g11, c6);
                                }
                            } else if (h2 != 128) {
                                if (h2 == 256) {
                                    long g12 = ysVar.g();
                                    long g13 = ysVar.g();
                                    try {
                                        jSONObject = JSON.parseObject(this.c.getString(g13));
                                    } catch (Exception e7) {
                                        if (DinamicXEngine.x()) {
                                            e7.printStackTrace();
                                        }
                                        jSONObject = null;
                                    }
                                    if (jSONObject == null) {
                                        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", 70020, "nodeId" + g2 + " key " + g12 + str222 + g13));
                                        return null;
                                    }
                                    j5 = g2;
                                    if (dXWidgetNode2 != null) {
                                        dXWidgetNode2.setMapAttribute(g12, jSONObject);
                                    }
                                    c3 = c5;
                                    b3 = d2;
                                } else if (h2 != 512) {
                                    b3 = d2;
                                    c3 = c5;
                                    j5 = g2;
                                } else {
                                    long g14 = ysVar.g();
                                    int f4 = ysVar.f();
                                    if (dXWidgetNode2 != null) {
                                        dXWidgetNode2.setIntAttribute(g14, f4);
                                    }
                                    b3 = d2;
                                    dXWidgetNode3 = dXWidgetNode2;
                                    j5 = g2;
                                    c3 = c5;
                                }
                                dXWidgetNode3 = dXWidgetNode2;
                            } else {
                                j5 = g2;
                                dXWidgetNode3 = dXWidgetNode2;
                                long g15 = ysVar.g();
                                c3 = c5;
                                b3 = d2;
                                try {
                                    jSONArray = JSON.parseArray(this.c.getString(ysVar.g()));
                                } catch (Exception e8) {
                                    if (DinamicXEngine.x()) {
                                        e8.printStackTrace();
                                    }
                                    jSONArray = null;
                                }
                                if (jSONArray == null) {
                                    dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_LIST_ERROR, "nodeId" + j5));
                                    return null;
                                } else if (dXWidgetNode3 != null) {
                                    dXWidgetNode3.setListAttribute(g15, jSONArray);
                                }
                            }
                            i2++;
                            dXWidgetNode2 = dXWidgetNode3;
                            g2 = j5;
                            d2 = b3;
                            c5 = c3;
                            s = 2;
                            s2 = 1;
                        } else {
                            long j6 = g2;
                            byte d4 = ysVar.d();
                            if (d4 > 0 && dXWidgetNode2 != null && dXWidgetNode2.getDataParsersExprNode() == null) {
                                dXWidgetNode2.newDataParsersExprNode(d4);
                                dXWidgetNode2.setStatFlag(1);
                            }
                            int i4 = 0;
                            while (i4 < d4) {
                                short h3 = ysVar.h();
                                if (this.a >= 1) {
                                    j3 = ysVar.g();
                                    j2 = j6;
                                } else {
                                    j2 = j6;
                                    j3 = 0;
                                }
                                long g16 = ysVar.g();
                                if (j3 == 0) {
                                    j3 = g16;
                                }
                                long g17 = ysVar.g();
                                if (dXWidgetNode2 != null) {
                                    b2 = d4;
                                    ay a2 = this.e.a(g17);
                                    if (a2 == null) {
                                        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", 70022, "nodeId" + j2 + " 创建原型树expr失败 value" + g17));
                                        return null;
                                    }
                                    j4 = j2;
                                    a2.d(h3);
                                    dXWidgetNode2.getDataParsersExprNode().put(g16, a2);
                                    if (!((h3 & TYPE_ENUM) != 512 || this.f.a() == null || this.f.a().get(j3) == null)) {
                                        if (dXWidgetNode2.getEnumMap() == null) {
                                            dXWidgetNode2.newEnumMap();
                                        }
                                        dXWidgetNode2.getEnumMap().put(g16, this.f.a().get(j3));
                                    }
                                } else {
                                    b2 = d4;
                                    j4 = j2;
                                }
                                i4++;
                                d4 = b2;
                                str222 = str222;
                                j6 = j4;
                            }
                            byte d5 = ysVar.d();
                            if (d5 > 0 && dXWidgetNode2 != null && dXWidgetNode2.getEventHandlersExprNode() == null) {
                                dXWidgetNode2.newEventHandlersExprNode(d5);
                            }
                            for (int i5 = 0; i5 < d5; i5++) {
                                long g18 = ysVar.g();
                                long g19 = ysVar.g();
                                if (dXWidgetNode2 != null) {
                                    ay a3 = this.e.a(g19);
                                    if (a3 == null) {
                                        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", 70023, "nodeId" + j6 + " 创建原型树event失败  key " + g18 + str222 + g19));
                                        return null;
                                    }
                                    dXWidgetNode2.getEventHandlersExprNode().put(g18, a3);
                                }
                            }
                            dXWidgetNode5 = dXWidgetNode2;
                            c5 = c5;
                        }
                    }
                } else if (d3 != 1) {
                    String[] strArr = new String[1];
                    strArr[c4] = "invalidate tag type:" + ((int) d3);
                    ry.g("BinaryLoader_TMTEST", strArr);
                    c5 = 2;
                } else if (this.k.size() > 0) {
                    DXWidgetNode pop = this.k.pop();
                    pop.addChild(dXWidgetNode5);
                    dXWidgetNode5 = pop;
                } else {
                    c5 = 1;
                }
                if (c5 == 0) {
                    DXWidgetNode dXWidgetNode6 = 1 == c5 ? dXWidgetNode5 : null;
                    if (ysVar.c() != this.d.a()) {
                        c2 = 2;
                        c5 = 2;
                    } else {
                        c2 = 2;
                    }
                    if (c5 == c2) {
                        dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_CREATE_WT_READ_ERROR));
                        dXWidgetNode = null;
                    } else {
                        dXWidgetNode = dXWidgetNode6;
                    }
                    if (!(dXWidgetNode == null || dXWidgetNode.getDXRuntimeContext() == null)) {
                        dXWidgetNode.getDXRuntimeContext().setWidgetNode(dXWidgetNode);
                        dXWidgetNode.setLastAutoId(this.l);
                    }
                    return dXWidgetNode;
                }
                d3 = ysVar.d();
                context2 = context;
                dXWidgetNode4 = null;
                c4 = 0;
            }
        } catch (Exception e9) {
            vx.b(e9);
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", 70021, vx.a(e9)));
            return null;
        }
    }

    private ys d(byte[] bArr, DXRuntimeContext dXRuntimeContext, boolean z, Context context) {
        ys ysVar = new ys();
        String str = new String(bArr, 0, 5);
        if (!"ALIDX".equals(str)) {
            Log.e("BinaryLoader_TMTEST", "loadFromBuffer failed tag is invalidate:" + str);
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_TAG_ERROR));
            return null;
        }
        ysVar.k(bArr);
        ysVar.j(5);
        if (ysVar.d() != 3) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_MAJOR_VERSION_ERROR));
            return null;
        }
        this.a = ysVar.h();
        short h2 = ysVar.h();
        String str2 = new String(ysVar.a(), ysVar.c(), (int) h2);
        ysVar.j(h2);
        ysVar.l(ysVar.h());
        int f2 = ysVar.f();
        int f3 = ysVar.f();
        int f4 = ysVar.f();
        int f5 = ysVar.f();
        int f6 = ysVar.f();
        int f7 = ysVar.f();
        int f8 = ysVar.f();
        int f9 = ysVar.f();
        int f10 = ysVar.f();
        int f11 = ysVar.f();
        if (this.a >= 7) {
            this.h.f(ysVar.f());
            this.h.e(ysVar.f());
            this.h.j(ysVar.f());
            this.h.i(ysVar.f());
            this.h.h(ysVar.f());
            this.h.g(ysVar.f());
        }
        if (this.a >= 8) {
            this.i.d(ysVar.f());
            this.i.c(ysVar.f());
            if (z) {
                this.g.d(ysVar.f());
                this.g.c(ysVar.f());
            }
        }
        if (this.a >= 8 && z) {
            this.g.b(ysVar, dXRuntimeContext, context);
        }
        if (ysVar.i(f2)) {
            this.d.b(str2, f3, ysVar);
            if (ysVar.c() != f4) {
                List<e.a> list = dXRuntimeContext.getDxError().c;
                list.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_STRING_LOADER_POSITION_ERROR, "string pos error:" + f4 + "  read pos:" + ysVar.c()));
            } else if (!this.b.a(f5, ysVar, dXRuntimeContext)) {
                wz.b("string loadFromBuffer error!");
            }
            if (ysVar.c() != f6) {
                List<e.a> list2 = dXRuntimeContext.getDxError().c;
                list2.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_POSITION_ERROR, "var string pos error:" + f4 + "  read pos:" + ysVar.c()));
            } else if (!this.c.a(f7, ysVar, dXRuntimeContext)) {
                wz.b("var string loadFromBuffer error!");
            }
            if (ysVar.c() != f8) {
                List<e.a> list3 = dXRuntimeContext.getDxError().c;
                list3.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_POSITION_ERROR, "expr pos error:" + f8 + "  read pos:" + ysVar.c()));
            } else if (!this.e.c(f9, ysVar, dXRuntimeContext)) {
                wz.b("expr loadFromBuffer error!");
            }
            if (ysVar.c() != f10) {
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_POSITION_ERROR, "enum pos error:" + f8 + "  read pos:" + ysVar.c()));
            } else if (!this.f.b(f11, ysVar, dXRuntimeContext)) {
                wz.b("enum loadFromBuffer error!");
            }
        } else {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_UI_LOADER_POSITION_ERROR));
        }
        try {
            if (this.a >= 7 && !this.h.d(ysVar, dXRuntimeContext)) {
                wz.b("event chain loadFromBuffer error!");
            }
        } catch (Exception e2) {
            vx.b(e2);
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_EVENTCHIAN, vx.a(e2)));
        }
        try {
            if (this.a >= 8 && !this.i.b(ysVar, dXRuntimeContext)) {
                wz.b("Expr Script loadFromBuffer error!");
            }
        } catch (Throwable th) {
            vx.b(th);
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_CREATE_LOAD_DX_EXPR_SCRIPT, vx.a(th)));
        }
        ysVar.i(f2);
        return ysVar;
    }

    private void e(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2) {
        if (dXWidgetNode2 != null) {
            if (dXWidgetNode2 instanceof DXTemplateWidgetNode) {
                DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) dXWidgetNode2;
                if (dXTemplateWidgetNode.get__StorageType() == 2) {
                    String str = dXTemplateWidgetNode.getName() + JSMethod.NOT_SET + dXTemplateWidgetNode.getVersion();
                    DXWidgetNode a2 = this.g.a(str);
                    if (a2 != null) {
                        ry.a("取到childTemplate:" + str);
                        dXTemplateWidgetNode.addChild(a2, false);
                    }
                    dXWidgetNode = a2;
                } else if (dXTemplateWidgetNode.get__StorageType() != 1) {
                    dXTemplateWidgetNode.isRemote();
                } else if (dXTemplateWidgetNode.getChildrenCount() != 1) {
                    ry.g(ry.TAG, "内联的子模版有问题，其getChildrenCount() != 1");
                } else {
                    DXWidgetNode childAt = dXTemplateWidgetNode.getChildAt(0);
                    childAt.setDxEventChains(dXWidgetNode.getDxEventChains());
                    childAt.setAnimation(dXWidgetNode.getAnimation());
                    childAt.setDxExprBytes(dXWidgetNode.getDxExprBytes());
                    dXWidgetNode = childAt;
                }
            }
            if ((dXWidgetNode2 instanceof f) || dXWidgetNode2.getChildrenCount() > 0) {
                for (int i2 = 0; i2 < dXWidgetNode2.getChildrenCount(); i2++) {
                    e(dXWidgetNode, dXWidgetNode2.getChildAt(i2));
                }
            }
        }
    }

    public DXWidgetNode c(byte[] bArr, DXRuntimeContext dXRuntimeContext, Context context, boolean z) {
        if (bArr == null) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_BINARY_FILE_EMPTY));
            return null;
        }
        ys d2 = d(bArr, dXRuntimeContext, z, context);
        DXWidgetNode b2 = b(d2, dXRuntimeContext, context);
        if (b2 == null) {
            wz.b("DXBinaryLoader loadFromBuffer null!");
        }
        if (this.a >= 7) {
            tx a2 = a(d2, dXRuntimeContext, context);
            if (!(b2 == null || a2 == null)) {
                b2.setDxEventChains(a2);
            }
        }
        if (this.a >= 8 && b2 != null) {
            b2.setDxExprBytes(this.i.a());
            if (!(this.i.a() == null || this.i.a().length <= 0 || dXRuntimeContext.getEngineContext().c() == null)) {
                dXRuntimeContext.getEngineContext().c().b(dXRuntimeContext.getDxTemplateItem().getIdentifier(), this.i.a(), 0);
            }
            this.j.a(dXRuntimeContext, z);
        }
        if (this.a >= 8 && z && b2 != null) {
            e(b2, b2);
        }
        if (this.a >= 9) {
            b2.setCodeMap(this.e.b());
        }
        return b2;
    }
}
