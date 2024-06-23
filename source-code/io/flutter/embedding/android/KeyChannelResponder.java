package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import tb.w51;

/* compiled from: Taobao */
public class KeyChannelResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyChannelResponder";
    private int combiningCharacter;
    @NonNull
    private final KeyEventChannel keyEventChannel;

    public KeyChannelResponder(@NonNull KeyEventChannel keyEventChannel2) {
        this.keyEventChannel = keyEventChannel2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleEvent$0(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback, boolean z) {
        onKeyEventHandledCallback.onKeyEventHandled(Boolean.valueOf(z));
    }

    /* access modifiers changed from: package-private */
    public Character applyCombiningCharacterToBaseCharacter(int i) {
        char c = (char) i;
        if ((Integer.MIN_VALUE & i) != 0) {
            int i2 = i & Integer.MAX_VALUE;
            int i3 = this.combiningCharacter;
            if (i3 != 0) {
                this.combiningCharacter = KeyCharacterMap.getDeadChar(i3, i2);
            } else {
                this.combiningCharacter = i2;
            }
        } else {
            int i4 = this.combiningCharacter;
            if (i4 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                if (deadChar > 0) {
                    c = (char) deadChar;
                }
                this.combiningCharacter = 0;
            }
        }
        return Character.valueOf(c);
    }

    @Override // io.flutter.embedding.android.KeyboardManager.Responder
    public void handleEvent(@NonNull KeyEvent keyEvent, @NonNull KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        int action = keyEvent.getAction();
        boolean z = true;
        if (action == 0 || action == 1) {
            KeyEventChannel.FlutterKeyEvent flutterKeyEvent = new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar()));
            if (action == 0) {
                z = false;
            }
            this.keyEventChannel.sendFlutterKeyEvent(flutterKeyEvent, z, new w51(onKeyEventHandledCallback));
            return;
        }
        onKeyEventHandledCallback.onKeyEventHandled(Boolean.FALSE);
    }
}
