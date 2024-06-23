package com.taobao.monitor.procedure;

import com.taobao.monitor.network.a;
import com.taobao.monitor.procedure.d;
import tb.us1;
import tb.xs1;

/* compiled from: Taobao */
public class e implements IProcedureFactory {
    /* access modifiers changed from: protected */
    public ProcedureImpl a(String str, d dVar) {
        IProcedure a = dVar.a();
        if (a == IProcedure.DEFAULT) {
            a = us1.PROCEDURE_MANAGER.getCurrentProcedure();
        }
        ProcedureImpl procedureImpl = new ProcedureImpl(str, a, dVar.b(), dVar.c());
        if (dVar.e()) {
            procedureImpl.d(new a());
        }
        if (dVar.d()) {
            procedureImpl.d(new xs1());
        }
        return procedureImpl;
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str) {
        return createProcedure(str, new d.b().k(false).g(true).i(true).h(us1.PROCEDURE_MANAGER.getCurrentProcedure()).f());
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str, d dVar) {
        if (dVar == null) {
            dVar = new d.b().k(false).g(true).i(true).h(us1.PROCEDURE_MANAGER.getCurrentProcedure()).f();
        }
        return new ProcedureProxy(a(str, dVar));
    }
}
