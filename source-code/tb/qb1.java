package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject;

/* compiled from: Taobao */
public class qb1 implements IDXFunctionObject {
    private ey a(ey[] eyVarArr) throws DXExprFunctionError {
        ey eyVar = eyVarArr[0];
        if (eyVar == null || !eyVar.A()) {
            throw new DXExprFunctionError("args[0] not number");
        } else if (eyVar.x()) {
            return ey.J(Math.abs(eyVar.m()));
        } else {
            return ey.H(Math.abs(eyVar.k()));
        }
    }

    private ey b(ey[] eyVarArr) throws DXExprFunctionError {
        ey eyVar = eyVarArr[0];
        if (eyVar != null && eyVar.A()) {
            return ey.J((long) ((int) Math.ceil(eyVar.b())));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    private ey c(ey[] eyVarArr) throws DXExprFunctionError {
        ey eyVar = eyVarArr[0];
        if (eyVar != null && eyVar.A()) {
            return ey.H(Math.exp(eyVar.b()));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    private ey d(ey[] eyVarArr) throws DXExprFunctionError {
        ey eyVar = eyVarArr[0];
        if (eyVar != null && eyVar.A()) {
            return ey.J((long) ((int) Math.floor(eyVar.b())));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    private ey e(int i, ey[] eyVarArr) throws DXExprFunctionError {
        ey eyVar = null;
        for (int i2 = 0; i2 < i; i2++) {
            ey eyVar2 = eyVarArr[i2];
            if (eyVar2 == null || !eyVar2.A()) {
                throw new DXExprFunctionError("args[" + i2 + "] not number");
            }
            if (eyVar == null || eyVar.b() < eyVar2.b()) {
                eyVar = eyVar2;
            }
        }
        return eyVar;
    }

    private ey f(int i, ey[] eyVarArr) throws DXExprFunctionError {
        ey eyVar = null;
        for (int i2 = 0; i2 < i; i2++) {
            ey eyVar2 = eyVarArr[i2];
            if (eyVar2 == null || !eyVar2.A()) {
                throw new DXExprFunctionError("args[" + i2 + "] not number");
            }
            if (eyVar == null || eyVar.b() > eyVar2.b()) {
                eyVar = eyVar2;
            }
        }
        return eyVar;
    }

    private ey g(ey[] eyVarArr) throws DXExprFunctionError {
        ey eyVar = eyVarArr[0];
        if (eyVar != null && eyVar.A()) {
            return ey.J(Math.round(eyVar.b()));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, String str, iy iyVar) throws DXExprFunctionError {
        if (i == 0) {
            throw new DXExprFunctionError("argc == 0");
        } else if (eyVarArr == null || eyVarArr.length != i) {
            throw new DXExprFunctionError("args == null || args.length != argc");
        } else if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 96370:
                    if (str.equals("abs")) {
                        c = 0;
                        break;
                    }
                    break;
                case 100893:
                    if (str.equals("exp")) {
                        c = 1;
                        break;
                    }
                    break;
                case 107876:
                    if (str.equals("max")) {
                        c = 2;
                        break;
                    }
                    break;
                case 108114:
                    if (str.equals("min")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3049733:
                    if (str.equals("ceil")) {
                        c = 4;
                        break;
                    }
                    break;
                case 97526796:
                    if (str.equals("floor")) {
                        c = 5;
                        break;
                    }
                    break;
                case 108704142:
                    if (str.equals("round")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return a(eyVarArr);
                case 1:
                    return c(eyVarArr);
                case 2:
                    return e(i, eyVarArr);
                case 3:
                    return f(i, eyVarArr);
                case 4:
                    return b(eyVarArr);
                case 5:
                    return d(eyVarArr);
                case 6:
                    return g(eyVarArr);
                default:
                    throw new DXExprFunctionError("can not find function on Math:" + str);
            }
        } else {
            throw new DXExprFunctionError("function is null");
        }
    }
}
