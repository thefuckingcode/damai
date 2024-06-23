package tb;

import io.flutter.embedding.android.KeyChannelResponder;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

/* compiled from: Taobao */
public final /* synthetic */ class w51 implements KeyEventChannel.EventResponseHandler {
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback a;

    public /* synthetic */ w51(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.a = onKeyEventHandledCallback;
    }

    @Override // io.flutter.embedding.engine.systemchannels.KeyEventChannel.EventResponseHandler
    public final void onFrameworkResponse(boolean z) {
        KeyChannelResponder.lambda$handleEvent$0(this.a, z);
    }
}
