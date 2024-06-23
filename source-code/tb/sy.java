package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class sy extends ay {

    /* compiled from: Taobao */
    public static class a {
        public boolean a;
        public int b = 0;
    }

    @Override // tb.ay
    public Object b(@Nullable lx lxVar, DXRuntimeContext dXRuntimeContext) {
        boolean z;
        is isVar;
        Object obj;
        Object obj2 = null;
        try {
            IDXDataParser iDXDataParser = this.b != 0 ? dXRuntimeContext.getParserMap().get(this.b) : null;
            if (iDXDataParser == null) {
                e.a aVar = new e.a("ASTNode", "ASTNode_METHOD_NODE", 100001);
                aVar.e = "exprId:" + this.b;
                dXRuntimeContext.getDxError().c.add(aVar);
                return null;
            }
            if (iDXDataParser instanceof is) {
                isVar = (is) iDXDataParser;
                z = true;
            } else {
                isVar = null;
                z = false;
            }
            List<ay> list = this.a;
            int size = list != null ? list.size() : 0;
            a aVar2 = new a();
            Object[] objArr = new Object[size];
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                objArr[i] = this.a.get(i).b(lxVar, dXRuntimeContext);
                if (z) {
                    by.a().doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(this, isVar, Arrays.copyOfRange(objArr, 0, i + 1), dXRuntimeContext);
                    obj2 = isVar.a(objArr, dXRuntimeContext, aVar2, i);
                    by.a().doAfterEvaluateMethodWithResult(this, obj2, dXRuntimeContext);
                    if (aVar2.a) {
                        break;
                    }
                    int i2 = aVar2.b;
                    if (i2 > 0) {
                        i += i2;
                        aVar2.b = 0;
                    }
                }
                i++;
            }
            if (z) {
                return obj2;
            }
            by.a().doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(this, isVar, objArr, dXRuntimeContext);
            if (iDXDataParser instanceof bv) {
                obj = ((bv) iDXDataParser).e(lxVar, objArr, dXRuntimeContext);
            } else {
                obj = iDXDataParser.evalWithArgs(objArr, dXRuntimeContext);
            }
            by.a().doAfterEvaluateMethodWithResult(this, obj, dXRuntimeContext);
            return obj;
        } catch (Throwable th) {
            e.a aVar3 = new e.a("ASTNode", "ASTNode_METHOD_NODE", e.DX_ERROR_CODE_METHOD_NODE_EXECUTE_EXCEPTION);
            aVar3.e = vx.a(th);
            dXRuntimeContext.getDxError().c.add(aVar3);
            vx.b(th);
            return null;
        }
    }
}
