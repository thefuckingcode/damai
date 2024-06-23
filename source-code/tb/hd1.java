package tb;

import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.d;
import io.flutter.plugin.common.BasicMessageChannel;

/* compiled from: Taobao */
public final /* synthetic */ class hd1 implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.NativeRouterApi a;

    public /* synthetic */ hd1(Messages.NativeRouterApi nativeRouterApi) {
        this.a = nativeRouterApi;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        d.i(this.a, obj, reply);
    }
}
