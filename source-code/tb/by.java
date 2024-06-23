package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IExprRecorderProtocol;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;

/* compiled from: Taobao */
public class by implements IExprRecorderProtocol {
    private static volatile IExprRecorderProtocol a;
    private static volatile IExprRecorderProtocol b;
    private static boolean c;

    public static IExprRecorderProtocol a() {
        if (!c && DinamicXEngine.x() && b == null) {
            synchronized (by.class) {
                if (b == null) {
                    try {
                        b = (IExprRecorderProtocol) Class.forName("com.taobao.android.dinamicx.devtools.modules.DXDevToolsExprRecorder").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        c = true;
                        throw th;
                    }
                    c = true;
                }
            }
        }
        return b == null ? b() : b;
    }

    public static IExprRecorderProtocol b() {
        if (a == null) {
            synchronized (by.class) {
                if (a == null) {
                    a = new by();
                }
            }
        }
        return a;
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doAfterEvaluateMethodWithResult(ay ayVar, Object obj, DXRuntimeContext dXRuntimeContext) {
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doAfterExecuteASTWithEventAndContext(ay ayVar, Object obj, DXRuntimeContext dXRuntimeContext) {
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(ay ayVar, IDXDataParser iDXDataParser, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doBeforeExecuteASTWithEventAndContext(ay ayVar, Object obj, DXRuntimeContext dXRuntimeContext) {
    }
}
