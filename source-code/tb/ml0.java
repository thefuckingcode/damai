package tb;

import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.b;

/* compiled from: Taobao */
public final /* synthetic */ class ml0 implements Messages.FlutterRouterApi.Reply {
    public final /* synthetic */ Messages.FlutterRouterApi.Reply a;

    public /* synthetic */ ml0(Messages.FlutterRouterApi.Reply reply) {
        this.a = reply;
    }

    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
    public final void reply(Object obj) {
        b.x(this.a, (Void) obj);
    }
}
