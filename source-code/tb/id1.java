package tb;

import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.d;
import io.flutter.plugin.common.BasicMessageChannel;

/* compiled from: Taobao */
public final /* synthetic */ class id1 implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.NativeRouterApi a;

    public /* synthetic */ id1(Messages.NativeRouterApi nativeRouterApi) {
        this.a = nativeRouterApi;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        d.k(this.a, obj, reply);
    }
}
