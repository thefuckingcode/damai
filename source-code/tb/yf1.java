package tb;

import com.alibaba.android.ultron.trade.event.rollback.RollbackHandler;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;

/* compiled from: Taobao */
public class yf1 implements RollbackHandler {
    List<IDMComponent> a;

    public yf1(List<IDMComponent> list) {
        this.a = list;
    }

    private void b(List<IDMComponent> list) {
        if (list != null) {
            for (IDMComponent iDMComponent : list) {
                if (iDMComponent != null) {
                    iDMComponent.rollBack();
                }
            }
        }
    }

    public void a() {
        List<IDMComponent> list = this.a;
        if (list != null) {
            for (IDMComponent iDMComponent : list) {
                if (iDMComponent != null) {
                    iDMComponent.record();
                }
            }
        }
    }

    @Override // com.alibaba.android.ultron.trade.event.rollback.RollbackHandler
    public void rollback() {
        b(this.a);
    }
}
