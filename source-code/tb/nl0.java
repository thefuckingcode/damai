package tb;

import android.content.Intent;
import com.idlefish.flutterboost.b;
import io.flutter.plugin.common.PluginRegistry;

/* compiled from: Taobao */
public final /* synthetic */ class nl0 implements PluginRegistry.ActivityResultListener {
    public final /* synthetic */ b a;

    public /* synthetic */ nl0(b bVar) {
        this.a = bVar;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return this.a.p(i, i2, intent);
    }
}
