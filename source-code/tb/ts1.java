package tb;

import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.IProcedureFactory;
import com.taobao.monitor.procedure.d;

/* compiled from: Taobao */
public class ts1 implements IProcedureFactory {
    public static ts1 b = new ts1();
    private IProcedureFactory a;

    private ts1() {
    }

    public ts1 a(IProcedureFactory iProcedureFactory) {
        this.a = iProcedureFactory;
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str) {
        IProcedureFactory iProcedureFactory = this.a;
        if (iProcedureFactory == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureFactory.createProcedure(str);
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str, d dVar) {
        IProcedureFactory iProcedureFactory = this.a;
        if (iProcedureFactory == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureFactory.createProcedure(str, dVar);
    }
}
