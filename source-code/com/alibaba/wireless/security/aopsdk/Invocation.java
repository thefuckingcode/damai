package com.alibaba.wireless.security.aopsdk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.wireless.security.aopsdk.e.b;
import com.taobao.aranger.constant.Constants;
import tb.o70;

public class Invocation {
    public static final boolean f = true;
    private String a = null;
    public long aopStartTime = System.nanoTime();
    public Object[] args;
    private b b;
    public long basicIncTimeCost;
    private boolean c = false;
    private Object d;
    private Throwable e;
    public Object extraInfo = null;
    public InvocationConfig invocationConfig;
    public long invokeTimeCost;
    public final String methodInfo;
    public boolean shouldReport;
    public long stackTimeCost;
    public Object thiz;

    public Invocation(String str, Object obj, Object... objArr) {
        this.methodInfo = str;
        this.thiz = obj;
        this.args = objArr;
    }

    private static String a(char c2) {
        switch (c2) {
            case 'B':
                return "byte";
            case 'C':
                return "char";
            case 'D':
                return "double";
            case 'F':
                return TypedValues.Custom.S_FLOAT;
            case 'I':
                return "int";
            case 'J':
                return "long";
            case 'S':
                return "short";
            case 'V':
                return Constants.VOID;
            case 'Z':
                return TypedValues.Custom.S_BOOLEAN;
            default:
                return "";
        }
    }

    private static String a(String str) {
        char charAt;
        String[] split = str.split("\\^");
        if (split.length < 3) {
            return str;
        }
        String str2 = split[2];
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 1;
        int i2 = 0;
        boolean z = false;
        while (i < str2.length() && (charAt = str2.charAt(i)) != ')') {
            if (charAt == '[') {
                i2++;
            } else if (charAt == 'L' && !z) {
                z = true;
            } else if (charAt == ';') {
                sb.append(sb2.toString());
                for (int i3 = 0; i3 < i2; i3++) {
                    sb.append("[]");
                }
                sb.append(',');
                sb2 = new StringBuilder();
                i2 = 0;
                z = false;
            } else if (z) {
                if (charAt == '/') {
                    charAt = '.';
                }
                sb2.append(charAt);
            } else {
                sb.append(a(charAt));
                for (int i4 = 0; i4 < i2; i4++) {
                    sb.append("[]");
                }
                sb.append(',');
                i2 = 0;
            }
            i++;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String str3 = split[0];
        if (str3.contains("/") && str3.length() >= 2) {
            str3 = str3.substring(1, str3.length() - 1).replace("/", ".");
        }
        return str3 + '.' + split[1] + '(' + sb.toString() + ')';
    }

    public String getAnnotationInfo() {
        return this.a;
    }

    public byte getArgB(int i) {
        return ((Byte) this.args[i]).byteValue();
    }

    public char getArgC(int i) {
        return ((Character) this.args[i]).charValue();
    }

    public double getArgD(int i) {
        return ((Double) this.args[i]).doubleValue();
    }

    public float getArgF(int i) {
        return ((Float) this.args[i]).floatValue();
    }

    public int getArgI(int i) {
        return ((Integer) this.args[i]).intValue();
    }

    public long getArgJ(int i) {
        return ((Long) this.args[i]).longValue();
    }

    public Object getArgL(int i) {
        return this.args[i];
    }

    public short getArgS(int i) {
        return ((Short) this.args[i]).shortValue();
    }

    public boolean getArgZ(int i) {
        return ((Boolean) this.args[i]).booleanValue();
    }

    public Object[] getArgs() {
        return this.args;
    }

    public b getHashableArgs() {
        if (this.b == null) {
            this.b = new b(this.args);
        }
        return this.b;
    }

    public String getProxyName() {
        if (this.a != null) {
            return o70.DINAMIC_PREFIX_AT + this.a + ":" + this.methodInfo;
        }
        return this.methodInfo;
    }

    public Object getResult() {
        return this.d;
    }

    public Throwable getThrowable() {
        return this.e;
    }

    public boolean hasThrowable() {
        return this.e != null;
    }

    public void setArgs(Object[] objArr) {
        this.args = objArr;
    }

    public void setResult(Object obj) {
        this.d = obj;
    }

    public void setShouldBlock(boolean z) {
        this.c = z;
    }

    public void setThrowable(Throwable th) {
        this.e = th;
    }

    public boolean shouldBlock() {
        return this.c;
    }

    public Invocation(safe.section.around.Invocation invocation) {
        this.methodInfo = a(invocation.methodinfo);
        this.args = invocation.args;
        this.thiz = invocation.thiz;
        this.a = invocation.annotationInfo;
    }
}
