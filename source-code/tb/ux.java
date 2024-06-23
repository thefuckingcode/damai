package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IDXEventHandler;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.util.List;

/* compiled from: Taobao */
public class ux extends ay {
    @Override // tb.ay
    public Object b(@Nullable lx lxVar, DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getWidgetNode() != null) {
                    IDXEventHandler eventHandlerWithId = dXRuntimeContext.getEventHandlerWithId(this.b);
                    if (eventHandlerWithId == null) {
                        if (lxVar != null && !lxVar.c()) {
                            e eVar = new e(dXRuntimeContext.getBizType());
                            if (dXRuntimeContext.getDxTemplateItem() != null) {
                                eVar.b = dXRuntimeContext.getDxTemplateItem();
                            }
                            e.a aVar = new e.a("ASTNode", "ASTNode_EventHandler", e.DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND);
                            aVar.e = "找不到用户注册的eventHandle  hashcode 为: " + this.b;
                            eVar.c.add(aVar);
                            DXAppMonitor.n(eVar);
                        }
                        return null;
                    }
                    List<ay> list = this.a;
                    int size = list != null ? list.size() : 0;
                    Object[] objArr = new Object[size];
                    for (int i = 0; i < size; i++) {
                        objArr[i] = this.a.get(i).b(lxVar, dXRuntimeContext);
                    }
                    if (lxVar == null || !lxVar.c()) {
                        eventHandlerWithId.handleEvent(lxVar, objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
                    } else {
                        eventHandlerWithId.prepareBindEventWithArgs(objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
                    }
                    if (dXRuntimeContext.isOpenNewFastReturnLogic()) {
                        return new Object();
                    }
                }
            } catch (Exception e) {
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
                e eVar2 = new e(dXRuntimeContext.getBizType());
                e.a aVar2 = new e.a("ASTNode", "ASTNode_EventHandler", e.DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION);
                eVar2.b = dXRuntimeContext.getDxTemplateItem();
                if (lxVar != null) {
                    aVar2.e = "eventId: " + lxVar.b() + " isPrepareBind: " + lxVar.c() + "  stack： " + vx.a(e);
                }
                eVar2.c.add(aVar2);
                DXAppMonitor.n(eVar2);
            }
        }
        return null;
    }
}
