package tb;

import android.taobao.windvane.connect.HttpRequest;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.event.Subject;
import java.math.BigDecimal;

/* compiled from: Taobao */
public class ey {
    public static final int TYPE_ARRAY = 6;
    public static final int TYPE_BOOL = 4;
    public static final int TYPE_BUILTIN_OBJECT = 8;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_FUNCTION = 9;
    public static final int TYPE_INT = 2;
    public static final int TYPE_INVALID = -1;
    public static final int TYPE_JAVA_OBJECT = 10;
    public static final int TYPE_NULL = 1;
    public static final int TYPE_OBJECT = 7;
    public static final int TYPE_STRING = 5;
    public static final int TYPE_UNDEFINED = 0;
    private final int a;
    private final long b;
    private final double c;
    private final Object d;

    private ey(int i, long j, double d2, Object obj) {
        this.a = i;
        this.b = j;
        this.c = d2;
        this.d = obj;
    }

    public static ey E(JSONArray jSONArray) {
        return new ey(6, 0, 0.0d, jSONArray);
    }

    public static ey F(boolean z) {
        return new ey(4, z ? 1 : 0, 0.0d, null);
    }

    public static ey G(fy fyVar) {
        return new ey(8, 0, 0.0d, fyVar);
    }

    public static ey H(double d2) {
        return new ey(3, 0, d2, null);
    }

    public static ey I(IDXFunction iDXFunction) {
        return new ey(9, 0, 0.0d, iDXFunction);
    }

    public static ey J(long j) {
        return new ey(2, j, 0.0d, null);
    }

    public static ey K(Object obj) {
        if (obj != null) {
            return new ey(10, 0, 0.0d, obj);
        }
        throw new IllegalStateException("对象不可以是 null");
    }

    public static ey L() {
        return new ey(1, 0, 0.0d, null);
    }

    public static ey M(JSONObject jSONObject) {
        return new ey(7, 0, 0.0d, jSONObject);
    }

    public static ey N(String str) {
        if (str != null) {
            return new ey(5, 0, 0.0d, str);
        }
        throw new IllegalStateException("string can't be null");
    }

    public static ey O() {
        return new ey(0, 0, 0.0d, null);
    }

    public static Object P(ey eyVar) {
        int q = eyVar.q();
        if (q != -1) {
            switch (q) {
                case 2:
                    return Long.valueOf(eyVar.m());
                case 3:
                    return Double.valueOf(eyVar.k());
                case 4:
                    return Boolean.valueOf(eyVar.i());
                case 5:
                    return eyVar.p();
                case 6:
                    return eyVar.h();
                case 7:
                    return eyVar.o();
                case 8:
                    return eyVar.j();
                case 9:
                    return eyVar.l();
                case 10:
                    return eyVar.n();
                default:
                    return null;
            }
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    private String a(Object obj) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int size = jSONArray.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(a(jSONArray.get(i)));
                if (i < size - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } else if (obj instanceof JSONObject) {
            return "[object Object]";
        } else {
            return obj != null ? obj.toString() : "";
        }
    }

    public static ey d(Object obj) {
        if (obj == null) {
            return O();
        }
        if (obj instanceof JSONObject) {
            return M((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return E((JSONArray) obj);
        }
        if (obj instanceof String) {
            return N((String) obj);
        }
        if (obj instanceof Boolean) {
            return F(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Integer) {
            return J((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Float) {
            return H((double) ((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return J(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return H(((Double) obj).doubleValue());
        }
        if (obj instanceof BigDecimal) {
            return H(((BigDecimal) obj).doubleValue());
        }
        return K(obj);
    }

    public boolean A() {
        int i = this.a;
        return i == 2 || i == 3 || i == 1 || i == 0;
    }

    public boolean B() {
        return this.a == 7;
    }

    public boolean C(ey eyVar) {
        return this.d == eyVar.d;
    }

    public boolean D() {
        return this.a == 5;
    }

    public String Q() {
        switch (this.a) {
            case -1:
                throw new IllegalArgumentException("Invalid type");
            case 0:
                return Constants.Name.UNDEFINED;
            case 1:
            case 6:
            case 7:
            case 8:
                return "object";
            case 2:
            case 3:
                return "number";
            case 4:
                return TypedValues.Custom.S_BOOLEAN;
            case 5:
                return "string";
            case 9:
                return Subject.FUNCTION;
            default:
                throw new IllegalArgumentException("Invalid type" + this.a);
        }
    }

    public double b() {
        int i = this.a;
        if (i == 0) {
            return Double.NaN;
        }
        if (i == 1) {
            return 0.0d;
        }
        if (i == 2) {
            return (double) this.b;
        }
        if (i == 3) {
            return this.c;
        }
        throw new IllegalArgumentException("cannot cast to number, type: " + this.a);
    }

    public boolean c() {
        switch (this.a) {
            case 0:
            case 1:
                return false;
            case 2:
            case 4:
                if (this.b != 0) {
                    return true;
                }
                return false;
            case 3:
                if (this.c != 0.0d) {
                    return true;
                }
                return false;
            case 5:
                if (((String) this.d).length() == 0 || ((String) this.d).equalsIgnoreCase("false")) {
                    return false;
                }
                return true;
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                throw new IllegalStateException("invalid type");
        }
    }

    public double e() {
        int i = this.a;
        if (i == 0) {
            return Double.NaN;
        }
        if (i == 1) {
            return 0.0d;
        }
        if (i == 2) {
            return (double) this.b;
        }
        if (i == 3) {
            return this.c;
        }
        if (i == 5) {
            return Double.parseDouble((String) this.d);
        }
        throw new IllegalStateException("can't conver to float:" + this);
    }

    public long f() {
        int i = this.a;
        if (i == 0 || i == 1) {
            return 0;
        }
        if (i == 2) {
            return this.b;
        }
        if (i == 3) {
            return (long) this.c;
        }
        if (i == 5) {
            return Long.parseLong((String) this.d);
        }
        throw new IllegalStateException("can't conver to int:" + this);
    }

    public String g() {
        switch (this.a) {
            case -1:
                throw new IllegalArgumentException("Invalid type");
            case 0:
                return Constants.Name.UNDEFINED;
            case 1:
                return "null";
            case 2:
                return String.valueOf(this.b);
            case 3:
                return String.valueOf(this.c);
            case 4:
                return String.valueOf(this.b != 0);
            case 5:
                return (String) this.d;
            case 6:
                return "[object Array]";
            case 7:
            case 8:
                return "[object Object]";
            case 9:
                return "[function]";
            case 10:
                return "[java object]";
            default:
                throw new IllegalArgumentException("Invalid type convert to string" + this.a);
        }
    }

    public JSONArray h() {
        if (t()) {
            return (JSONArray) this.d;
        }
        throw new IllegalStateException("getArray from a type:" + this.a);
    }

    public boolean i() {
        if (this.a == 4) {
            return this.b != 0;
        }
        throw new IllegalStateException("can't getBool :" + this);
    }

    public fy j() {
        if (u()) {
            return (fy) this.d;
        }
        throw new IllegalStateException("getBuiltInObject from a type:" + this.a);
    }

    public double k() {
        if (this.a == 3) {
            return this.c;
        }
        throw new IllegalStateException("getInt from: " + this);
    }

    public IDXFunction l() {
        if (w()) {
            return (IDXFunction) this.d;
        }
        throw new IllegalStateException("getFunction from a type:" + this.a);
    }

    public long m() {
        if (this.a == 2) {
            return this.b;
        }
        throw new IllegalStateException("getInt from: " + this);
    }

    public Object n() {
        if (this.a == 10) {
            return this.d;
        }
        throw new IllegalStateException("getText illegal type: " + this.a);
    }

    public JSONObject o() {
        if (B()) {
            return (JSONObject) this.d;
        }
        throw new IllegalStateException("getObject from a type:" + this.a);
    }

    public String p() {
        if (this.a == 5) {
            return (String) this.d;
        }
        throw new IllegalStateException("getText illegal type: " + this.a);
    }

    public int q() {
        return this.a;
    }

    public String r() {
        switch (this.a) {
            case -1:
                return HttpRequest.DEFAULT_HTTPS_ERROR_INVALID;
            case 0:
                return "UNDEFINED";
            case 1:
                return "NULL";
            case 2:
                return "INT";
            case 3:
                return "FLOAT";
            case 4:
                return "BOOL";
            case 5:
                return "STRING";
            case 6:
                return "ARRAY";
            case 7:
                return "OBJECT";
            case 8:
                return "BUILTIN_OBJECT";
            case 9:
                return "FUNCTION";
            default:
                throw new IllegalArgumentException("Invalid type" + this.a);
        }
    }

    public Object s() {
        int q = q();
        if (q != -1) {
            switch (q) {
                case 2:
                    return Long.valueOf(m());
                case 3:
                    return Double.valueOf(k());
                case 4:
                    return Boolean.valueOf(i());
                case 5:
                    return p();
                case 6:
                    return h();
                case 7:
                    return o();
                case 8:
                    return j();
                case 9:
                    return l();
                case 10:
                    return n();
                default:
                    return null;
            }
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    public boolean t() {
        return this.a == 6;
    }

    public String toString() {
        switch (this.a) {
            case -1:
            case 0:
            case 1:
                return "";
            case 2:
                return String.valueOf(this.b);
            case 3:
                return String.valueOf(this.c);
            case 4:
                return String.valueOf(this.b != 0);
            case 5:
                return String.valueOf(this.d);
            case 6:
                return a(this.d);
            case 7:
            case 8:
                return "[object Object]";
            case 9:
                return "function " + ((IDXFunction) this.d).getDxFunctionName() + "() { [native code] }";
            case 10:
                StringBuilder sb = new StringBuilder();
                sb.append("[java Object]");
                Object obj = this.d;
                sb.append(obj != null ? obj.getClass().getSimpleName() : "null");
                return sb.toString();
            default:
                throw new IllegalArgumentException("Invalid type" + this.a);
        }
    }

    public boolean u() {
        return this.a == 8;
    }

    public boolean v() {
        return this.a == 3;
    }

    public boolean w() {
        return this.a == 9;
    }

    public boolean x() {
        return this.a == 2;
    }

    public boolean y() {
        return this.a == 10;
    }

    public boolean z() {
        int i = this.a;
        return i == 0 || i == 1;
    }
}
