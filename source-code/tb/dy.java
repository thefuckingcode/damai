package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy;
import com.taobao.android.dinamicx.expression.parser.a;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/* compiled from: Taobao */
public class dy {
    private static bu g = new bu();
    private static sw h = new sw();
    private static ew i = new ew();
    private static yu j = new yu();
    private static dw k = new dw();
    private static nv l = new nv();
    private static dv m = new dv();
    private static gw n = new gw();
    private static ov o = new ov();
    private boolean a = false;
    private boolean b = true;
    private wx c = new wx();
    private final ArrayList<ey> d = new ArrayList<>();
    private final Stack<ey> e = new Stack<>();
    private boolean f = false;

    private ey b(ey eyVar, ey eyVar2) {
        if (eyVar.A() && eyVar2.A()) {
            return j(eyVar.b() + eyVar2.b());
        }
        if (eyVar.v()) {
            eyVar = j(eyVar.b());
        }
        if (eyVar2.v()) {
            eyVar2 = j(eyVar2.b());
        }
        return ey.N(eyVar.toString() + eyVar2.toString());
    }

    private ey c(ey eyVar, ey eyVar2, lx lxVar, DXRuntimeContext dXRuntimeContext, a aVar) {
        ey[] eyVarArr = {eyVar, eyVar2};
        iy iyVar = new iy();
        iyVar.b(lxVar);
        try {
            return aVar.call(dXRuntimeContext, null, 2, eyVarArr, iyVar);
        } catch (Throwable th) {
            ey.L();
            throw new IllegalArgumentException("FunctionError: " + th.getMessage(), th);
        }
    }

    private ey d(ey eyVar, ey eyVar2) {
        if (eyVar.A() || eyVar2.A()) {
            return j(eyVar.b() / eyVar2.b());
        }
        throw new IllegalStateException("Can't do " + eyVar + " / " + eyVar2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f3  */
    private ey e(DXRuntimeContext dXRuntimeContext, ey eyVar, ey eyVar2, boolean z) {
        switch (eyVar.q()) {
            case 0:
            case 1:
                return ey.L();
            case 2:
            case 3:
            case 4:
            case 9:
                return ey.O();
            case 5:
                if (eyVar2.D()) {
                    if ("length".equals(eyVar2.p())) {
                        return ey.J((long) eyVar.p().length());
                    }
                    if ("substring".equals(eyVar2.p())) {
                        return yx.c("substring");
                    }
                    if (!eyVar2.D()) {
                        if ("length".equals(eyVar2.p())) {
                            return ey.J((long) eyVar.h().size());
                        }
                        if ("slice".equals(eyVar2.p())) {
                            return yx.c("slice");
                        }
                        if (z) {
                            return h(eyVar.h(), (int) eyVar2.f());
                        }
                        return ey.O();
                    } else if (!eyVar2.x()) {
                        return ey.O();
                    } else {
                        if (z) {
                            JSONArray h2 = eyVar.h();
                            if (h2 == null) {
                                throw new IllegalStateException("get property on array is not allowed for null");
                            } else if (eyVar2.m() < 0 || eyVar2.m() >= ((long) h2.size())) {
                                return ey.O();
                            } else {
                                return h(eyVar.h(), (int) eyVar2.m());
                            }
                        } else {
                            throw new IllegalStateException("get property on array is not allowed of number: " + eyVar2.g());
                        }
                    }
                } else if (!eyVar2.x() || !z) {
                    throw new IllegalStateException("get property on string is not allowed of key: " + eyVar2.g());
                } else if (eyVar2.m() < 0 || eyVar2.m() >= ((long) eyVar.p().length())) {
                    return ey.O();
                } else {
                    return ey.N(String.valueOf(eyVar.p().charAt((int) eyVar2.m())));
                }
            case 6:
                if (!eyVar2.D()) {
                }
                break;
            case 7:
                if (z) {
                    return i(eyVar.o(), eyVar2.toString());
                }
                if (eyVar2.D()) {
                    return i(eyVar.o(), eyVar2.p());
                }
                throw new IllegalStateException("get property object is not allowed of type: " + eyVar2.r());
            case 8:
                if (!eyVar2.D()) {
                    return ey.O();
                }
                return eyVar.j().a(eyVar2.p());
            case 10:
                if (dXRuntimeContext.supportDataProxy() && eyVar2.D() && eyVar.y()) {
                    dXRuntimeContext.getDataProxy();
                    eyVar.n();
                    eyVar2.p();
                    throw null;
                }
                throw new IllegalStateException("Unsupported type: " + eyVar.q());
            default:
                throw new IllegalStateException("Unsupported type: " + eyVar.q());
        }
    }

    private ey f(ey eyVar, ey eyVar2) {
        if (eyVar.A() || eyVar2.A()) {
            return j(eyVar.b() * eyVar2.b());
        }
        throw new IllegalStateException("Can't do " + eyVar + " * " + eyVar2);
    }

    private ey g(ey eyVar, ey eyVar2) {
        if (eyVar.A() || eyVar2.A()) {
            return j(eyVar.e() - eyVar2.e());
        }
        throw new IllegalStateException("Can't do " + eyVar + " - " + eyVar2);
    }

    private ey h(JSONArray jSONArray, int i2) {
        Object obj = jSONArray.get(i2);
        if (obj == null) {
            return ey.O();
        }
        return ey.d(obj);
    }

    private ey i(JSONObject jSONObject, String str) {
        Object obj = jSONObject.get(str);
        if (obj == null) {
            return ey.O();
        }
        return ey.d(obj);
    }

    private ey j(double d2) {
        long round = Math.round(d2);
        if (((double) round) == d2) {
            return ey.J(round);
        }
        return ey.H(d2);
    }

    private boolean k(DXRuntimeContext dXRuntimeContext) {
        return dXRuntimeContext.getEngineContext().h();
    }

    private ey l(int i2) {
        ey eyVar = this.d.get(i2);
        if (eyVar == null) {
            eyVar = this.c.c(i2);
            this.d.set(i2, eyVar);
        }
        if (eyVar != null) {
            return eyVar;
        }
        throw new IllegalArgumentException("Invalid const: " + i2);
    }

    private boolean p(ey eyVar, ey eyVar2) {
        if (eyVar2.q() == eyVar.q()) {
            switch (eyVar2.q()) {
                case 0:
                case 1:
                    return true;
                case 2:
                    if (eyVar2.m() == eyVar.m()) {
                        return true;
                    }
                    break;
                case 3:
                    if (Double.compare(eyVar2.k(), eyVar.k()) == 0) {
                        return true;
                    }
                    break;
                case 4:
                    if (eyVar2.i() == eyVar.i()) {
                        return true;
                    }
                    break;
                case 5:
                    return eyVar2.p().equals(eyVar.p());
                case 6:
                case 7:
                case 8:
                case 9:
                    return eyVar2.C(eyVar);
                default:
                    throw new IllegalArgumentException("invalid type");
            }
        }
        return false;
    }

    public void a(byte[] bArr, int i2) {
        this.f = true;
        this.c.g(bArr, i2);
        int d2 = this.c.d();
        this.d.clear();
        this.d.ensureCapacity(d2);
        for (int i3 = 0; i3 < d2; i3++) {
            this.d.add(null);
        }
    }

    public ey m(DXRuntimeContext dXRuntimeContext, lx lxVar, int i2, Map<String, ey> map, DXJSMethodProxy dXJSMethodProxy, DXExprDxMethodProxy dXExprDxMethodProxy, DXBuiltinProvider dXBuiltinProvider) {
        if (this.f) {
            try {
                n(dXRuntimeContext, lxVar, this.c.b(), this.c.f(i2), this.c.e(i2), map, dXJSMethodProxy, dXExprDxMethodProxy, dXBuiltinProvider);
                if (this.e.size() == 0) {
                    throw new IllegalStateException("expression has no return value");
                } else if (this.e.size() <= 1) {
                    return this.e.pop();
                } else {
                    throw new IllegalStateException("invalid stack size. vm error");
                }
            } catch (Throwable th) {
                this.e.clear();
                throw th;
            }
        } else {
            throw new IllegalStateException("run before decode");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x010d */
    /* JADX DEBUG: Multi-variable search result rejected for r2v152, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v156, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v167, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0716, code lost:
        if (r21.e.pop().c() != false) goto L_0x0757;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x0755, code lost:
        if (r21.e.pop().c() == false) goto L_0x0757;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0757, code lost:
        r3 = (r1 - r17) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x075d, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x075e, code lost:
        r15 = r3;
        r8 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0254, code lost:
        if (r21.b != false) goto L_0x0256;
     */
    public void n(DXRuntimeContext dXRuntimeContext, lx lxVar, byte[] bArr, int i2, int i3, Map<String, ey> map, DXJSMethodProxy dXJSMethodProxy, DXExprDxMethodProxy dXExprDxMethodProxy, DXBuiltinProvider dXBuiltinProvider) {
        String str;
        int i4;
        byte[] bArr2;
        byte[] bArr3;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        ey eyVar5;
        int i5;
        ey eyVar6;
        double d2;
        ey eyVar7;
        ey eyVar8;
        ey eyVar9;
        double d3;
        ey eyVar10;
        int i6;
        String str2;
        Throwable th;
        byte[] bArr4 = bArr;
        int i7 = i3;
        char c2 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i2 + i8;
            byte b2 = bArr4[i10];
            int a2 = ok1.a(bArr4, i10);
            int c3 = ok1.c(a2);
            String b3 = ok1.b(a2);
            if (i8 + c3 + 1 <= i7) {
                if (this.a) {
                    Object[] objArr = new Object[4];
                    objArr[c2] = Integer.valueOf(i8);
                    objArr[1] = Integer.valueOf(i9);
                    objArr[2] = Integer.valueOf(c3);
                    objArr[3] = b3;
                    str = String.format("PC: %3d[c:%-3d]<sz:%-3d> %-25s", objArr);
                } else {
                    str = "";
                }
                double d4 = 0.0d;
                switch (b2) {
                    case 0:
                        i4 = i8;
                        bArr2 = bArr4;
                        if (!this.b) {
                            break;
                        } else {
                            throw new IllegalStateException("OP Invalid in pc:" + i4);
                        }
                    case 1:
                        i4 = i8;
                        bArr2 = bArr4;
                        int b4 = xd.b(bArr2, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" const_id: %3d", Integer.valueOf(b4)));
                        }
                        if (this.b) {
                            String p = l(b4).p();
                            ey eyVar11 = map.get(p);
                            if (eyVar11 != null) {
                                this.e.push(eyVar11);
                                break;
                            } else {
                                ey function = dXBuiltinProvider.getFunction(dXRuntimeContext, p);
                                if (function != null) {
                                    this.e.push(function);
                                    break;
                                } else {
                                    ey c4 = yx.c(p);
                                    if (c4 != null) {
                                        this.e.push(c4);
                                        break;
                                    } else {
                                        throw new IllegalArgumentException("找不到对应变量或者表达式函数 " + p);
                                    }
                                }
                            }
                        }
                    case 2:
                        i4 = i8;
                        bArr2 = bArr4;
                        int b5 = xd.b(bArr2, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" const_id: %3d", Integer.valueOf(b5)));
                        }
                        if (this.b) {
                            this.e.push(l(b5));
                        }
                        break;
                    case 3:
                        i4 = i8;
                        bArr2 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.pop();
                        }
                        break;
                    case 4:
                        i4 = i8;
                        bArr2 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(this.e.peek());
                        }
                        break;
                    case 5:
                        i4 = i8;
                        int a3 = xd.a(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + " argc: " + a3);
                        }
                        if (this.b) {
                            ey[] eyVarArr = new ey[a3];
                            for (int i11 = 0; i11 < a3; i11++) {
                                eyVarArr[(a3 - i11) - 1] = this.e.pop();
                            }
                            ey pop = this.e.pop();
                            ey pop2 = this.e.pop();
                            if (pop.w()) {
                                try {
                                    iy iyVar = new iy();
                                    iyVar.b(lxVar);
                                    bArr2 = bArr4;
                                    this.e.push(pop.l().call(dXRuntimeContext, pop2, a3, eyVarArr, iyVar));
                                } catch (DXExprFunctionError e2) {
                                    throw new IllegalArgumentException("FunctionError: " + e2.getMessage(), e2);
                                }
                            } else {
                                throw new IllegalArgumentException("call on none function value: " + pop);
                            }
                        } else {
                            bArr2 = bArr4;
                        }
                        break;
                    case 6:
                        i4 = i8;
                        int a4 = xd.a(bArr4, i10 + 1);
                        int b6 = xd.b(bArr4, i10 + 2);
                        int b7 = xd.b(bArr4, i10 + 4);
                        ey l2 = l(b6);
                        ey l3 = l(b7);
                        if (this.a) {
                            ry.a(str + " module_id: " + b6 + " const_id: " + b7 + ", argc: " + a4);
                        }
                        if (!this.b) {
                            bArr2 = bArr4;
                            break;
                        } else if (dXJSMethodProxy != null && dXJSMethodProxy.isValid()) {
                            ey[] eyVarArr2 = new ey[a4];
                            for (int i12 = 0; i12 < a4; i12++) {
                                eyVarArr2[(a4 - i12) - 1] = this.e.pop();
                            }
                            dXJSMethodProxy.call(dXRuntimeContext, lxVar, l2.p(), l3.p(), a4, eyVarArr2);
                            this.e.push(ey.L());
                            bArr2 = bArr4;
                            break;
                        } else {
                            throw new IllegalArgumentException("can not find js instance!");
                        }
                        break;
                    case 7:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(e(dXRuntimeContext, this.e.pop(), this.e.pop(), true));
                        }
                        bArr2 = bArr3;
                        break;
                    case 8:
                        i4 = i8;
                        bArr3 = bArr4;
                        int b8 = xd.b(bArr3, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" const_id: %d", Integer.valueOf(b8)));
                        }
                        if (this.b) {
                            this.e.push(e(dXRuntimeContext, this.e.pop(), l(b8), false));
                        }
                        bArr2 = bArr3;
                        break;
                    case 9:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop3 = this.e.pop();
                            ey pop4 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                eyVar = b(pop4, pop3);
                            } else {
                                eyVar = c(pop4, pop3, lxVar, dXRuntimeContext, g);
                            }
                            this.e.push(eyVar);
                        }
                        bArr2 = bArr3;
                        break;
                    case 10:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop5 = this.e.pop();
                            ey pop6 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                eyVar2 = g(pop6, pop5);
                            } else {
                                eyVar2 = c(pop6, pop5, lxVar, dXRuntimeContext, h);
                            }
                            this.e.push(eyVar2);
                        }
                        bArr2 = bArr3;
                        break;
                    case 11:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop7 = this.e.pop();
                            ey pop8 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                eyVar3 = f(pop8, pop7);
                            } else {
                                eyVar3 = c(pop8, pop7, lxVar, dXRuntimeContext, i);
                            }
                            this.e.push(eyVar3);
                        }
                        bArr2 = bArr3;
                        break;
                    case 12:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop9 = this.e.pop();
                            ey pop10 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                eyVar4 = d(pop10, pop9);
                            } else {
                                eyVar4 = c(pop10, pop9, lxVar, dXRuntimeContext, j);
                            }
                            this.e.push(eyVar4);
                        }
                        bArr2 = bArr3;
                        break;
                    case 13:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop11 = this.e.pop();
                            ey pop12 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                eyVar5 = d(pop12, pop11);
                            } else {
                                eyVar5 = c(pop12, pop11, lxVar, dXRuntimeContext, k);
                            }
                            this.e.push(eyVar5);
                        }
                        bArr2 = bArr3;
                        break;
                    case 14:
                        i4 = i8;
                        bArr3 = bArr4;
                        i5 = xd.c(bArr3, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" pc_inc: %3d", Integer.valueOf(i5)));
                        }
                        if (this.b) {
                            break;
                        }
                        bArr2 = bArr3;
                        break;
                    case 15:
                        i4 = i8;
                        bArr3 = bArr4;
                        i5 = xd.c(bArr3, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" pc_inc: %3d", Integer.valueOf(i5)));
                        }
                        if (this.b) {
                            break;
                        }
                        bArr2 = bArr3;
                        break;
                    case 16:
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 17:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop13 = this.e.pop();
                            ey pop14 = this.e.pop();
                            if (!k(dXRuntimeContext)) {
                                eyVar6 = c(pop14, pop13, lxVar, dXRuntimeContext, l);
                            } else if (pop14.A() && pop13.A()) {
                                eyVar6 = ey.F(pop14.b() > pop13.b());
                            } else if (pop14.D() && pop13.D()) {
                                eyVar6 = ey.F(pop14.p().compareTo(pop13.p()) > 0);
                            } else if (pop14.A() || pop13.A()) {
                                try {
                                    d2 = pop14.e();
                                } catch (Exception unused) {
                                    d2 = 0.0d;
                                }
                                try {
                                    d4 = pop13.e();
                                } catch (Exception unused2) {
                                }
                                eyVar6 = ey.F(d2 > d4);
                            } else {
                                throw new IllegalStateException("Can't do " + pop14 + " > " + pop13);
                            }
                            this.e.push(eyVar6);
                        }
                        bArr2 = bArr3;
                        break;
                    case 18:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop15 = this.e.pop();
                            ey pop16 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                eyVar7 = ey.F(!p(pop15, pop16));
                            } else {
                                eyVar7 = c(pop16, pop15, lxVar, dXRuntimeContext, n);
                            }
                            this.e.push(eyVar7);
                        }
                        bArr2 = bArr3;
                        break;
                    case 19:
                        i4 = i8;
                        bArr3 = bArr4;
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop17 = this.e.pop();
                            ey pop18 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                eyVar8 = ey.F(p(pop17, pop18));
                            } else {
                                eyVar8 = c(pop18, pop17, lxVar, dXRuntimeContext, m);
                            }
                            this.e.push(eyVar8);
                        }
                        bArr2 = bArr3;
                        break;
                    case 20:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop19 = this.e.pop();
                            ey pop20 = this.e.pop();
                            if (k(dXRuntimeContext)) {
                                if (pop20.A() && pop19.A()) {
                                    eyVar9 = ey.F(pop20.b() >= pop19.b());
                                } else if (pop20.D() && pop19.D()) {
                                    eyVar9 = ey.F(pop20.p().compareTo(pop19.p()) >= 0);
                                } else if (pop20.A() || pop19.A()) {
                                    try {
                                        d3 = pop20.e();
                                    } catch (Exception unused3) {
                                        d3 = 0.0d;
                                    }
                                    try {
                                        d4 = pop19.e();
                                    } catch (Exception unused4) {
                                    }
                                    eyVar9 = ey.F(d3 >= d4);
                                } else {
                                    throw new IllegalStateException("Can't do " + pop20 + " >= " + pop19);
                                }
                                i4 = i8;
                                bArr3 = bArr4;
                            } else {
                                i4 = i8;
                                bArr3 = bArr4;
                                eyVar9 = c(pop20, pop19, lxVar, dXRuntimeContext, o);
                            }
                            this.e.push(eyVar9);
                            bArr2 = bArr3;
                            break;
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 21:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(ey.F(this.e.pop().c() && this.e.pop().c()));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 22:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(ey.F(this.e.pop().c() || this.e.pop().c()));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 23:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(ey.F(!this.e.pop().c()));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 24:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(ey.F(true));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 25:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(ey.F(false));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 26:
                        int a5 = xd.a(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" value: %d", Integer.valueOf(a5)));
                        }
                        if (this.b) {
                            this.e.push(ey.J((long) a5));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 27:
                        int b9 = xd.b(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" value: %d", Integer.valueOf(b9)));
                        }
                        if (this.b) {
                            this.e.push(ey.J((long) b9));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 28:
                        int d5 = xd.d(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" value: %d", Integer.valueOf(d5)));
                        }
                        if (this.b) {
                            this.e.push(ey.J((long) d5));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 29:
                        long f2 = xd.f(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" value: %d", Long.valueOf(f2)));
                        }
                        if (this.b) {
                            this.e.push(ey.J(f2));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 30:
                        double e3 = xd.e(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" value: %f", Double.valueOf(e3)));
                        }
                        if (this.b) {
                            this.e.push(ey.H(e3));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 31:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(ey.L());
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 32:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            this.e.push(ey.O());
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 33:
                    case 34:
                    case 35:
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 36:
                    default:
                        throw new IllegalStateException("Unsupported code: " + a2);
                    case 37:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            ey pop21 = this.e.pop();
                            if (pop21.x()) {
                                eyVar10 = ey.J(-pop21.m());
                            } else if (pop21.v()) {
                                eyVar10 = ey.H(-pop21.k());
                            } else {
                                throw new IllegalStateException("Can't do -" + pop21);
                            }
                            this.e.push(eyVar10);
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 38:
                        i6 = xd.c(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" pc_inc: %3d", Integer.valueOf(i6)));
                        }
                        break;
                    case 39:
                        if (this.a) {
                            ry.a(str);
                        }
                        if (this.b) {
                            Stack<ey> stack = this.e;
                            stack.push(ey.N(stack.pop().Q()));
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 40:
                        int a6 = xd.a(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + " argc: " + a6);
                        }
                        if (this.b) {
                            ey[] eyVarArr3 = new ey[a6];
                            for (int i13 = 0; i13 < a6; i13++) {
                                eyVarArr3[(a6 - i13) - 1] = this.e.pop();
                            }
                            ey pop22 = this.e.pop();
                            if (!pop22.x()) {
                                throw new IllegalArgumentException("invalid call to dx event: " + pop22);
                            } else if (dXExprDxMethodProxy != null) {
                                try {
                                    ey call = dXExprDxMethodProxy.call(dXRuntimeContext, lxVar, pop22.m(), 0, a6, eyVarArr3);
                                    if (call == null) {
                                        call = ey.O();
                                    }
                                    this.e.push(call);
                                } catch (Throwable th2) {
                                    throw new IllegalArgumentException("Call DxEventError: " + th2.getMessage(), th2);
                                }
                            } else {
                                this.e.push(ey.O());
                            }
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 41:
                        int a7 = xd.a(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + " argc: " + a7);
                        }
                        if (this.b) {
                            ey[] eyVarArr4 = new ey[a7];
                            for (int i14 = 0; i14 < a7; i14++) {
                                eyVarArr4[(a7 - i14) - 1] = this.e.pop();
                            }
                            ey pop23 = this.e.pop();
                            if (!pop23.x()) {
                                throw new IllegalArgumentException("invalid call to dx event: " + pop23);
                            } else if (dXExprDxMethodProxy != null) {
                                try {
                                    long m2 = pop23.m();
                                    pop23 = "Call DxEventError: ";
                                    ey call2 = dXExprDxMethodProxy.call(dXRuntimeContext, lxVar, m2, 1, a7, eyVarArr4);
                                    if (call2 == null) {
                                        call2 = ey.O();
                                    }
                                    this.e.push(call2);
                                } catch (Throwable th3) {
                                    th = th3;
                                    str2 = pop23;
                                    throw new IllegalArgumentException(str2 + th.getMessage(), th);
                                }
                            } else {
                                this.e.push(ey.O());
                            }
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                    case 42:
                        i6 = xd.c(bArr4, i10 + 1);
                        if (this.a) {
                            ry.a(str + String.format(" pc_inc: %d", Integer.valueOf(i6)));
                        }
                        if (this.b) {
                            ey pop24 = this.e.pop();
                            if (pop24.z()) {
                                this.e.push(ey.O());
                                i8 = (i6 - c3) - 1;
                            } else {
                                this.e.push(pop24);
                            }
                        }
                        i4 = i8;
                        bArr2 = bArr4;
                        break;
                }
                i9++;
                i7 = i3;
                i8 = i4 + c3 + 1;
                bArr4 = bArr2;
                c2 = 0;
            } else {
                throw new IllegalStateException("Exceed End of code");
            }
        }
    }

    public void o(yx yxVar) {
    }

    public String toString() {
        return "DXExprVM{mConst=" + this.d + ", mVarStack=" + this.e + '}';
    }
}
