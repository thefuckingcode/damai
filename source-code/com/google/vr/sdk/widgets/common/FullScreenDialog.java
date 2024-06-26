package com.google.vr.sdk.widgets.common;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.vr.cardboard.FullscreenMode;

/* compiled from: Taobao */
public class FullScreenDialog extends Dialog {
    private static final String TAG = FullScreenDialog.class.getSimpleName();
    private final ViewGroup dialogContent;
    private FullscreenMode fullscreenMode;
    private final View innerWidgetView;
    private ViewGroup innerWidgetViewParent;
    private VrWidgetRenderer renderer;

    public FullScreenDialog(Context context, View view, VrWidgetRenderer vrWidgetRenderer) {
        super(context, 16973834);
        this.innerWidgetView = view;
        this.renderer = vrWidgetRenderer;
        FrameLayout frameLayout = new FrameLayout(context);
        this.dialogContent = frameLayout;
        setContentView(frameLayout);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.renderer.onViewDetach();
        ViewGroup viewGroup = (ViewGroup) this.innerWidgetView.getParent();
        this.innerWidgetViewParent = viewGroup;
        viewGroup.removeView(this.innerWidgetView);
        this.dialogContent.addView(this.innerWidgetView, -1, -1);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.renderer.onViewDetach();
        this.dialogContent.removeView(this.innerWidgetView);
        this.innerWidgetViewParent.addView(this.innerWidgetView);
        super.onStop();
    }

    public void show() {
        super.show();
        FullscreenMode fullscreenMode2 = new FullscreenMode(getWindow());
        this.fullscreenMode = fullscreenMode2;
        fullscreenMode2.b();
    }
}
