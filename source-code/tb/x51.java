package tb;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;

/* compiled from: Taobao */
public final /* synthetic */ class x51 implements BasicMessageChannel.Reply {
    public final /* synthetic */ KeyEventChannel.EventResponseHandler a;

    public /* synthetic */ x51(KeyEventChannel.EventResponseHandler eventResponseHandler) {
        this.a = eventResponseHandler;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public final void reply(Object obj) {
        KeyEventChannel.lambda$createReplyHandler$0(this.a, obj);
    }
}
