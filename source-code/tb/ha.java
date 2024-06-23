package tb;

import cn.damai.message.observer.Action;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.msg.Message;

/* compiled from: Taobao */
public final /* synthetic */ class ha implements Action {
    public final /* synthetic */ BasePresenter a;

    public /* synthetic */ ha(BasePresenter basePresenter) {
        this.a = basePresenter;
    }

    @Override // cn.damai.message.observer.Action
    public final void call(Object obj) {
        this.a.lambda$new$3((Message) obj);
    }
}
