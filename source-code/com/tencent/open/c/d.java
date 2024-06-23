package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.open.web.security.a;

/* compiled from: Taobao */
public class d extends b {
    public static boolean a;
    private KeyEvent b;
    private a c;

    public d(Context context) {
        super(context);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + a);
        if (!a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 67) {
            a.b = true;
            return super.dispatchKeyEvent(keyEvent);
        } else if (keyEvent.getUnicodeChar() == 0) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.dispatchKeyEvent(keyEvent);
            }
            KeyEvent keyEvent2 = new KeyEvent(0, 17);
            this.b = keyEvent2;
            return super.dispatchKeyEvent(keyEvent2);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection != null) {
            a = true;
            a aVar = new a(super.onCreateInputConnection(editorInfo), false);
            this.c = aVar;
            return aVar;
        }
        a = false;
        return onCreateInputConnection;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + a);
        if (!a) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyCode == 66) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyCode == 67) {
            a.b = true;
            return super.onKeyDown(i, keyEvent);
        } else if (keyEvent.getUnicodeChar() == 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.onKeyDown(i, keyEvent);
            }
            KeyEvent keyEvent2 = new KeyEvent(0, 17);
            this.b = keyEvent2;
            return super.onKeyDown(keyEvent2.getKeyCode(), this.b);
        }
    }
}
