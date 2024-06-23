package com.alibaba.poplayer.layermanager.view.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public class c implements Window.Callback {
    public static final String TAG = c.class.getSimpleName();
    Window.Callback a;
    a b;

    public c(a aVar, Window.Callback callback) {
        this.b = aVar;
        this.a = callback;
    }

    @SuppressLint({"NewApi"})
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.dispatchKeyEvent(keyEvent);
    }

    @SuppressLint({"NewApi"})
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Log.d(TAG, "dispatchKeyShortcutEvent ");
        return this.a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) (-this.b.b()));
        if (this.a != null && this.b.a(obtain)) {
            return true;
        }
        return this.a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        Log.d(TAG, "onActionModeFinished");
        this.a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        Log.d(TAG, "onActionModeStarted");
        this.a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow");
        this.a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.a.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return this.a.onCreatePanelView(i);
    }

    public void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow");
        this.a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.a.onMenuItemSelected(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.a.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        Log.d(TAG, "onPanelClosed");
        this.a.onPanelClosed(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.a.onPreparePanel(i, view, menu);
    }

    public boolean onSearchRequested() {
        Log.d(TAG, "onSearchRequested");
        return this.a.onSearchRequested();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.b.g();
        } else {
            this.b.c();
        }
        String str = TAG;
        Log.d(str, "onWindowFocusChanged :" + z);
        this.a.onWindowFocusChanged(z);
    }

    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Log.d(TAG, "onWindowStartingActionMode");
        return this.a.onWindowStartingActionMode(callback);
    }

    @TargetApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.a.onSearchRequested(searchEvent);
    }

    @Nullable
    @TargetApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        Log.d(TAG, "onWindowStartingActionMode");
        return this.a.onWindowStartingActionMode(callback, i);
    }
}
