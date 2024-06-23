package io.flutter.embedding.android;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.editing.TextInputPlugin;
import java.util.HashSet;

/* compiled from: Taobao */
public class KeyboardManager {
    private static final String TAG = "KeyboardManager";
    @NonNull
    private final HashSet<KeyEvent> redispatchedEvents = new HashSet<>();
    @NonNull
    protected final Responder[] responders;
    @NonNull
    private final TextInputPlugin textInputPlugin;
    private final View view;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class PerEventCallbackBuilder {
        boolean isEventHandled = false;
        @NonNull
        final KeyEvent keyEvent;
        int unrepliedCount;

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public class Callback implements Responder.OnKeyEventHandledCallback {
            boolean isCalled;

            private Callback() {
                this.isCalled = false;
            }

            @Override // io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback
            public void onKeyEventHandled(Boolean bool) {
                if (!this.isCalled) {
                    this.isCalled = true;
                    PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                    perEventCallbackBuilder.unrepliedCount--;
                    perEventCallbackBuilder.isEventHandled = bool.booleanValue() | perEventCallbackBuilder.isEventHandled;
                    PerEventCallbackBuilder perEventCallbackBuilder2 = PerEventCallbackBuilder.this;
                    if (perEventCallbackBuilder2.unrepliedCount == 0 && !perEventCallbackBuilder2.isEventHandled) {
                        KeyboardManager.this.onUnhandled(perEventCallbackBuilder2.keyEvent);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
        }

        PerEventCallbackBuilder(@NonNull KeyEvent keyEvent2) {
            this.unrepliedCount = KeyboardManager.this.responders.length;
            this.keyEvent = keyEvent2;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Responder {

        /* compiled from: Taobao */
        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(Boolean bool);
        }

        void handleEvent(@NonNull KeyEvent keyEvent, @NonNull OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public KeyboardManager(View view2, @NonNull TextInputPlugin textInputPlugin2, Responder[] responderArr) {
        this.view = view2;
        this.textInputPlugin = textInputPlugin2;
        this.responders = responderArr;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onUnhandled(@NonNull KeyEvent keyEvent) {
        if (!this.textInputPlugin.handleKeyEvent(keyEvent) && this.view != null) {
            this.redispatchedEvents.add(keyEvent);
            this.view.getRootView().dispatchKeyEvent(keyEvent);
            if (this.redispatchedEvents.remove(keyEvent)) {
                Log.w(TAG, "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }

    public void destroy() {
        int size = this.redispatchedEvents.size();
        if (size > 0) {
            Log.w(TAG, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    public boolean handleEvent(@NonNull KeyEvent keyEvent) {
        if (this.redispatchedEvents.remove(keyEvent)) {
            return false;
        }
        if (this.responders.length > 0) {
            PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
            for (Responder responder : this.responders) {
                responder.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
            }
            return true;
        }
        onUnhandled(keyEvent);
        return true;
    }
}
