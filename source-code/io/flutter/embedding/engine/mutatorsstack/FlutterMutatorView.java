package io.flutter.embedding.engine.mutatorsstack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.util.ViewUtils;

/* compiled from: Taobao */
public class FlutterMutatorView extends FrameLayout {
    @Nullable
    @VisibleForTesting
    ViewTreeObserver.OnGlobalFocusChangeListener activeFocusListener;
    private final AndroidTouchProcessor androidTouchProcessor;
    private int left;
    private FlutterMutatorsStack mutatorsStack;
    private int prevLeft;
    private int prevTop;
    private float screenDensity;
    private int top;

    public FlutterMutatorView(@NonNull Context context, float f, @Nullable AndroidTouchProcessor androidTouchProcessor2) {
        super(context, null);
        this.screenDensity = f;
        this.androidTouchProcessor = androidTouchProcessor2;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.mutatorsStack.getFinalMatrix());
        float f = this.screenDensity;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate((float) (-this.left), (float) (-this.top));
        return matrix;
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.mutatorsStack.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset((float) (-this.left), (float) (-this.top));
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.androidTouchProcessor == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i = this.left;
            this.prevLeft = i;
            int i2 = this.top;
            this.prevTop = i2;
            matrix.postTranslate((float) i, (float) i2);
        } else if (action != 2) {
            matrix.postTranslate((float) this.left, (float) this.top);
        } else {
            matrix.postTranslate((float) this.prevLeft, (float) this.prevTop);
            this.prevLeft = this.left;
            this.prevTop = this.top;
        }
        return this.androidTouchProcessor.onTouchEvent(motionEvent, matrix);
    }

    public void readyToDisplay(@NonNull FlutterMutatorsStack flutterMutatorsStack, int i, int i2, int i3, int i4) {
        this.mutatorsStack = flutterMutatorsStack;
        this.left = i;
        this.top = i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void setOnDescendantFocusChangeListener(@NonNull final View.OnFocusChangeListener onFocusChangeListener) {
        unsetOnDescendantFocusChangeListener();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.activeFocusListener == null) {
            AnonymousClass1 r1 = new ViewTreeObserver.OnGlobalFocusChangeListener() {
                /* class io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView.AnonymousClass1 */

                public void onGlobalFocusChanged(View view, View view2) {
                    View.OnFocusChangeListener onFocusChangeListener = onFocusChangeListener;
                    View view3 = this;
                    onFocusChangeListener.onFocusChange(view3, ViewUtils.childHasFocus(view3));
                }
            };
            this.activeFocusListener = r1;
            viewTreeObserver.addOnGlobalFocusChangeListener(r1);
        }
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (onGlobalFocusChangeListener = this.activeFocusListener) != null) {
            this.activeFocusListener = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }

    public FlutterMutatorView(@NonNull Context context) {
        this(context, 1.0f, null);
    }
}
