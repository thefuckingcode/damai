package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class FlutterEngineGroup {
    @VisibleForTesting
    final List<FlutterEngine> activeEngines;

    public FlutterEngineGroup(@NonNull Context context) {
        this(context, null);
    }

    public FlutterEngine createAndRunDefaultEngine(@NonNull Context context) {
        return createAndRunEngine(context, null);
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint) {
        final FlutterEngine flutterEngine;
        if (dartEntrypoint == null) {
            dartEntrypoint = DartExecutor.DartEntrypoint.createDefault();
        }
        if (this.activeEngines.size() == 0) {
            flutterEngine = createEngine(context);
            flutterEngine.getDartExecutor().executeDartEntrypoint(dartEntrypoint);
        } else {
            flutterEngine = this.activeEngines.get(0).spawn(context, dartEntrypoint);
        }
        this.activeEngines.add(flutterEngine);
        flutterEngine.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener() {
            /* class io.flutter.embedding.engine.FlutterEngineGroup.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onEngineWillDestroy() {
                FlutterEngineGroup.this.activeEngines.remove(flutterEngine);
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
            }
        });
        return flutterEngine;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public FlutterEngine createEngine(Context context) {
        return new FlutterEngine(context);
    }

    public FlutterEngineGroup(@NonNull Context context, @Nullable String[] strArr) {
        this.activeEngines = new ArrayList();
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        if (!flutterLoader.initialized()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context, strArr);
        }
    }
}
