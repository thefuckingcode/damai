package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.HashMap;
import java.util.Map;
import tb.yx;

/* compiled from: Taobao */
public class f00 extends ay {
    @Override // tb.ay
    public Object b(@Nullable lx lxVar, DXRuntimeContext dXRuntimeContext) {
        Throwable th;
        if (lxVar != null) {
            try {
                if (lxVar.c()) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                vx.b(th);
                DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", e.DXSCRIPT_SCRIPT_NODE_ERROR, vx.a(th));
                return null;
            }
        }
        yx c = dXRuntimeContext.getEngineContext() == null ? null : dXRuntimeContext.getEngineContext().c();
        if (c == null) {
            return null;
        }
        String identifier = dXRuntimeContext.getDxTemplateItem() == null ? null : dXRuntimeContext.getDxTemplateItem().getIdentifier();
        if (!c.a(identifier)) {
            DXWidgetNode widgetNode = dXRuntimeContext.getWidgetNode();
            if (widgetNode == null) {
                ry.h(identifier + " 执行表达式失败: thisNode == null");
                return null;
            }
            DXWidgetNode queryRootWidgetNode = widgetNode.queryRootWidgetNode();
            if (queryRootWidgetNode == null) {
                ry.h(identifier + " 执行表达式失败: rootNode == null)");
                return null;
            }
            byte[] dxExprBytes = queryRootWidgetNode.getDxExprBytes();
            if (dxExprBytes == null) {
                return null;
            }
            c.b(identifier, dxExprBytes, 0);
        }
        HashMap hashMap = new HashMap();
        if (!(lxVar == null || lxVar.a() == null)) {
            hashMap.putAll(lxVar.a());
        }
        Map<String, ey> env = dXRuntimeContext.getEnv();
        if (env != null) {
            hashMap.putAll(env);
        }
        try {
            yx.a f = c.f(dXRuntimeContext, lxVar, identifier, (int) this.b, dXRuntimeContext.getData(), null, null, hashMap, dXRuntimeContext.getEngineContext().d(), dXRuntimeContext.getEngineContext().d(), dXRuntimeContext.getEngineContext().d());
            if (f.a) {
                return ey.P(f.c);
            }
            ry.h(identifier + " 模板中执行表达式失败: " + f.b);
            return null;
        } catch (Throwable th3) {
            th = th3;
            vx.b(th);
            DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", e.DXSCRIPT_SCRIPT_NODE_ERROR, vx.a(th));
            return null;
        }
    }
}
