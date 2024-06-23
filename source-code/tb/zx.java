package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.IDXEventHandler;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.script.IDXJSEngine;
import com.taobao.android.dinamicx.template.DXJSCacheManager;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.HashMap;

/* compiled from: Taobao */
public class zx implements DXBuiltinProvider, DXExprDxMethodProxy, DXJSMethodProxy {
    public static final int CALL_DATA_PARSER = 1;
    public static final int CALL_EVENT = 0;
    private HashMap<String, IDXFunction> a;
    private IDXJSEngine b;

    public zx(HashMap<String, IDXFunction> hashMap, IDXJSEngine iDXJSEngine) {
        this.a = hashMap;
        this.b = iDXJSEngine;
    }

    private DXRuntimeContext a(DXWidgetNode dXWidgetNode) {
        DXWidgetNode queryRootWidgetNode;
        if (dXWidgetNode == null || (queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode()) == null) {
            return null;
        }
        if (!(queryRootWidgetNode instanceof DXTemplateWidgetNode) || ((DXTemplateWidgetNode) queryRootWidgetNode).get__StorageType() != 1) {
            return queryRootWidgetNode.getDXRuntimeContext();
        }
        return a(queryRootWidgetNode.getParentWidget());
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy
    public ey call(DXRuntimeContext dXRuntimeContext, lx lxVar, long j, int i, int i2, ey[] eyVarArr) {
        Object obj;
        Object[] objArr;
        int i3 = 0;
        Object[] objArr2 = null;
        if (i == 0) {
            IDXEventHandler eventHandlerWithId = dXRuntimeContext.getEventHandlerWithId(j);
            if (eventHandlerWithId == null) {
                DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", e.DXSCRIPT_EVENT_NOTFOUND_2, "事件: " + j + "找不到");
                return null;
            }
            if (i2 < 0 || eyVarArr == null || eyVarArr.length != i2) {
                objArr = null;
            } else {
                objArr = new Object[i2];
                while (i3 < i2) {
                    objArr[i3] = eyVarArr[i3].s();
                    i3++;
                }
            }
            if (lxVar == null || !lxVar.c()) {
                eventHandlerWithId.handleEvent(lxVar, objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
            } else {
                eventHandlerWithId.prepareBindEventWithArgs(objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
            }
            return null;
        } else if (i == 1) {
            IDXDataParser iDXDataParser = dXRuntimeContext.getParserMap().get(j);
            if (iDXDataParser == null) {
                DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", e.DXSCRIPT_DATAPARSER_NOTFOUND_2, "表达式: " + j + "找不到");
                return null;
            }
            if (i2 >= 0) {
                objArr2 = new Object[i2];
                while (i3 < i2) {
                    objArr2[i3] = eyVarArr[i3].s();
                    i3++;
                }
            }
            if (iDXDataParser instanceof bv) {
                obj = ((bv) iDXDataParser).e(lxVar, objArr2, dXRuntimeContext);
            } else {
                obj = iDXDataParser.evalWithArgs(objArr2, dXRuntimeContext);
            }
            return ey.d(obj);
        } else {
            DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", e.DXSCRIPT_CALLBACK_ERROR, "调用为不认识的type：  " + i);
            return null;
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider
    public ey getFunction(DXRuntimeContext dXRuntimeContext, String str) {
        HashMap<String, IDXFunction> hashMap;
        IDXFunction iDXFunction;
        if (TextUtils.isEmpty(str) || (hashMap = this.a) == null || hashMap.size() == 0 || (iDXFunction = this.a.get(str)) == null) {
            return null;
        }
        return ey.I(iDXFunction);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy
    public boolean isValid() {
        return this.b != null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy
    public void call(DXRuntimeContext dXRuntimeContext, lx lxVar, String str, String str2, int i, ey[] eyVarArr) {
        DXJSCacheManager.DXLoadJSBytesTask dXLoadJSBytesTask;
        if (this.b == null) {
            ry.g(ry.TAG, "call js 失败 idxjsEngine == null");
        } else if (lxVar != null && lxVar.c()) {
        } else {
            if (dXRuntimeContext == null) {
                ry.g(ry.TAG, "call js 失败 runtimeContext == null");
            } else if (dXRuntimeContext.getWidgetNode() == null) {
                ry.g(ry.TAG, "call js 失败 runtimeContext widgetNode == null");
            } else {
                DXRuntimeContext a2 = a(dXRuntimeContext.getWidgetNode());
                if (a2 == null) {
                    ry.g(ry.TAG, "call js 失败 rootRuntimeContext == null");
                    return;
                }
                if (a2.getInstanceId() <= 0) {
                    if (dXRuntimeContext.getDxTemplateItem() == null) {
                        ry.g(ry.TAG, "call js 失败 runtimeContext.getDxTemplateItem() == null");
                        return;
                    }
                    byte[] b2 = DXJSCacheManager.c().b(dXRuntimeContext.getDxTemplateItem().getIdentifier());
                    if (b2 == null) {
                        if (dXRuntimeContext.getWidgetNode().isChildWidgetNode()) {
                            dXLoadJSBytesTask = new DXJSCacheManager.DXLoadJSBytesTask(dXRuntimeContext, false);
                        } else {
                            dXLoadJSBytesTask = new DXJSCacheManager.DXLoadJSBytesTask(dXRuntimeContext, true);
                        }
                        dXLoadJSBytesTask.run();
                        ry.s("主线程加载 " + dXRuntimeContext.getDxTemplateItem().getIdentifier() + " 的js文件");
                        byte[] jsBytes = dXLoadJSBytesTask.getJsBytes();
                        if (jsBytes != null) {
                            DXJSCacheManager.c().e(dXRuntimeContext.getDxTemplateItem().getIdentifier(), dXLoadJSBytesTask.getJsBytes());
                        }
                        b2 = jsBytes;
                    }
                    a2.setInstanceId(this.b.decode(dXRuntimeContext, b2));
                }
                ry.a("开始调用js的函数  module: " + str + "  method:  " + str2);
                this.b.run(a2.getInstanceId(), dXRuntimeContext, str, str2, i, eyVarArr);
            }
        }
    }
}
