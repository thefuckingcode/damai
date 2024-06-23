package io.flutter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;

/* compiled from: Taobao */
public final class FlutterInjector {
    private static boolean accessed;
    private static FlutterInjector instance;
    private DeferredComponentManager deferredComponentManager;
    private FlutterJNI.Factory flutterJniFactory;
    private FlutterLoader flutterLoader;

    /* compiled from: Taobao */
    public static final class Builder {
        private DeferredComponentManager deferredComponentManager;
        private FlutterJNI.Factory flutterJniFactory;
        private FlutterLoader flutterLoader;

        private void fillDefaults() {
            if (this.flutterJniFactory == null) {
                this.flutterJniFactory = new FlutterJNI.Factory();
            }
            if (this.flutterLoader == null) {
                this.flutterLoader = new FlutterLoader(this.flutterJniFactory.provideFlutterJNI());
            }
        }

        public FlutterInjector build() {
            fillDefaults();
            return new FlutterInjector(this.flutterLoader, this.deferredComponentManager, this.flutterJniFactory);
        }

        public Builder setDeferredComponentManager(@Nullable DeferredComponentManager deferredComponentManager2) {
            this.deferredComponentManager = deferredComponentManager2;
            return this;
        }

        public Builder setFlutterJNIFactory(@NonNull FlutterJNI.Factory factory) {
            this.flutterJniFactory = factory;
            return this;
        }

        public Builder setFlutterLoader(@NonNull FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
            return this;
        }
    }

    public static FlutterInjector instance() {
        accessed = true;
        if (instance == null) {
            instance = new Builder().build();
        }
        return instance;
    }

    @VisibleForTesting
    public static void reset() {
        accessed = false;
        instance = null;
    }

    @VisibleForTesting
    public static void setInstance(@NonNull FlutterInjector flutterInjector) {
        if (!accessed) {
            instance = flutterInjector;
            return;
        }
        throw new IllegalStateException("Cannot change the FlutterInjector instance once it's been read. If you're trying to dependency inject, be sure to do so at the beginning of the program");
    }

    @Nullable
    public DeferredComponentManager deferredComponentManager() {
        return this.deferredComponentManager;
    }

    @NonNull
    public FlutterLoader flutterLoader() {
        return this.flutterLoader;
    }

    @NonNull
    public FlutterJNI.Factory getFlutterJNIFactory() {
        return this.flutterJniFactory;
    }

    private FlutterInjector(@NonNull FlutterLoader flutterLoader2, @Nullable DeferredComponentManager deferredComponentManager2, @NonNull FlutterJNI.Factory factory) {
        this.flutterLoader = flutterLoader2;
        this.deferredComponentManager = deferredComponentManager2;
        this.flutterJniFactory = factory;
    }
}
