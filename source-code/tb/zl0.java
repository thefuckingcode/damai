package tb;

import com.idlefish.flutterboost.containers.FlutterViewContainer;
import java.util.function.Consumer;

/* compiled from: Taobao */
public final /* synthetic */ class zl0 implements Consumer {
    public final /* synthetic */ StringBuilder a;

    public /* synthetic */ zl0(StringBuilder sb) {
        this.a = sb;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        am0.j(this.a, (FlutterViewContainer) obj);
    }
}
