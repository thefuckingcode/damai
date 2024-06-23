package tb;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

/* compiled from: Taobao */
public final /* synthetic */ class zc1 implements BasicMessageChannel.Reply {
    public final /* synthetic */ Messages.FlutterRouterApi.Reply a;

    public /* synthetic */ zc1(Messages.FlutterRouterApi.Reply reply) {
        this.a = reply;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public final void reply(Object obj) {
        this.a.reply(null);
    }
}
