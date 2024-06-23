package tb;

import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: Taobao */
public final /* synthetic */ class af0 implements EventListener.Factory {
    public final /* synthetic */ EventListener a;

    public /* synthetic */ af0(EventListener eventListener) {
        this.a = eventListener;
    }

    @Override // okhttp3.EventListener.Factory
    public final EventListener create(Call call) {
        return EventListener.a(this.a, call);
    }
}
