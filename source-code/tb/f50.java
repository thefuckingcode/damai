package tb;

import com.alibaba.android.ultron.trade.event.rollback.RollbackHandler;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
public class f50 implements RollbackHandler {
    private IDMComponent a;
    private IPresenter b;

    public f50(IDMComponent iDMComponent, IPresenter iPresenter) {
        this.a = iDMComponent;
        this.b = iPresenter;
        if (iDMComponent != null) {
            iDMComponent.record();
        }
    }

    @Override // com.alibaba.android.ultron.trade.event.rollback.RollbackHandler
    public void rollback() {
        IDMComponent iDMComponent = this.a;
        if (iDMComponent != null) {
            iDMComponent.rollBack();
        }
        IPresenter iPresenter = this.b;
        if (iPresenter != null) {
            iPresenter.getViewManager().refreshCurrentContainer();
        }
    }
}
