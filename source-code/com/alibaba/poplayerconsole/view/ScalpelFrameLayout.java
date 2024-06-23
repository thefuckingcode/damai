package com.alibaba.poplayerconsole.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

/* compiled from: Taobao */
public class ScalpelFrameLayout extends FrameLayout {
    private static final int CHILD_COUNT_ESTIMATION = 50;
    private static final int CHROME_COLOR = -7829368;
    private static final int CHROME_SHADOW_COLOR = -16777216;
    private static final boolean DEBUG = false;
    private static final int ROTATION_DEFAULT_X = -10;
    private static final int ROTATION_DEFAULT_Y = 15;
    private static final int ROTATION_MAX = 60;
    private static final int ROTATION_MIN = -60;
    private static final int SPACING_DEFAULT = 25;
    private static final int SPACING_MAX = 100;
    private static final int SPACING_MIN = 10;
    private static final int TEXT_OFFSET_DP = 2;
    private static final int TEXT_SIZE_DP = 10;
    private static final int TRACKING_HORIZONTALLY = -1;
    private static final int TRACKING_UNKNOWN = 0;
    private static final int TRACKING_VERTICALLY = 1;
    private static final float ZOOM_DEFAULT = 0.6f;
    private static final float ZOOM_MAX = 2.0f;
    private static final float ZOOM_MIN = 0.33f;
    private final Camera camera;
    private int chromeColor;
    private int chromeShadowColor;
    private final float density;
    private boolean drawIds;
    private boolean drawViews;
    private boolean enabled;
    private final SparseArray<String> idNames;
    private float lastOneX;
    private float lastOneY;
    private float lastTwoX;
    private float lastTwoY;
    private final c<b> layeredViewPool;
    private final Deque<b> layeredViewQueue;
    private final int[] location;
    private final Matrix matrix;
    private int multiTouchTracking;
    private int pointerOne;
    private int pointerTwo;
    private final Resources res;
    private float rotationX;
    private float rotationY;
    private final float slop;
    private float spacing;
    private final float textOffset;
    private final float textSize;
    private final Paint viewBorderPaint;
    private final Rect viewBoundsRect;
    private final BitSet visibilities;
    private float zoom;

    /* compiled from: Taobao */
    class a extends c<b> {
        a(ScalpelFrameLayout scalpelFrameLayout, int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public b a() {
            return new b(null);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        View a;
        int b;

        private b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a = null;
            this.b = -1;
        }

        /* access modifiers changed from: package-private */
        public void b(View view, int i) {
            this.a = view;
            this.b = i;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    private static abstract class c<T> {
        private final Deque<T> a;

        c(int i) {
            this.a = new ArrayDeque(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.a.addLast(a());
            }
        }

        /* access modifiers changed from: protected */
        public abstract T a();

        /* access modifiers changed from: package-private */
        public T b() {
            return this.a.isEmpty() ? a() : this.a.removeLast();
        }

        /* access modifiers changed from: package-private */
        public void c(T t) {
            this.a.addLast(t);
        }
    }

    public ScalpelFrameLayout(Context context) {
        this(context, null);
    }

    private static void log(String str, Object... objArr) {
        Log.d("Scalpel", String.format(str, objArr));
    }

    private String nameForId(int i) {
        String str = this.idNames.get(i);
        if (str == null) {
            try {
                str = this.res.getResourceEntryName(i);
            } catch (Resources.NotFoundException unused) {
                str = String.format("0x%8x", Integer.valueOf(i));
            }
            this.idNames.put(i, str);
        }
        return str;
    }

    public void draw(Canvas canvas) {
        int id;
        if (!this.enabled) {
            super.draw(canvas);
            return;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        float f = (float) iArr[0];
        float f2 = (float) iArr[1];
        int save = canvas.save();
        float width = ((float) getWidth()) / ZOOM_MAX;
        float height = ((float) getHeight()) / ZOOM_MAX;
        this.camera.save();
        this.camera.rotate(this.rotationX, this.rotationY, 0.0f);
        this.camera.getMatrix(this.matrix);
        this.camera.restore();
        this.matrix.preTranslate(-width, -height);
        this.matrix.postTranslate(width, height);
        canvas.concat(this.matrix);
        float f3 = this.zoom;
        canvas.scale(f3, f3, width, height);
        if (this.layeredViewQueue.isEmpty()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                b b2 = this.layeredViewPool.b();
                b2.b(getChildAt(i), 0);
                this.layeredViewQueue.add(b2);
            }
            while (!this.layeredViewQueue.isEmpty()) {
                b removeFirst = this.layeredViewQueue.removeFirst();
                View view = removeFirst.a;
                int i2 = removeFirst.b;
                removeFirst.a();
                this.layeredViewPool.c(removeFirst);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    this.visibilities.clear();
                    int childCount2 = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount2; i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (childAt.getVisibility() == 0) {
                            this.visibilities.set(i3);
                            childAt.setVisibility(4);
                        }
                    }
                }
                int save2 = canvas.save();
                float f4 = (float) i2;
                float f5 = this.spacing;
                float f6 = this.density;
                canvas.translate(f4 * f5 * f6 * (this.rotationY / 60.0f), -(f4 * f5 * f6 * (this.rotationX / 60.0f)));
                view.getLocationInWindow(this.location);
                int[] iArr2 = this.location;
                canvas.translate(((float) iArr2[0]) - f, ((float) iArr2[1]) - f2);
                this.viewBoundsRect.set(0, 0, view.getWidth(), view.getHeight());
                canvas.drawRect(this.viewBoundsRect, this.viewBorderPaint);
                if (this.drawViews) {
                    view.draw(canvas);
                }
                if (this.drawIds && (id = view.getId()) != -1) {
                    canvas.drawText(nameForId(id), this.textOffset, this.textSize, this.viewBorderPaint);
                }
                canvas.restoreToCount(save2);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) view;
                    int childCount3 = viewGroup2.getChildCount();
                    for (int i4 = 0; i4 < childCount3; i4++) {
                        if (this.visibilities.get(i4)) {
                            View childAt2 = viewGroup2.getChildAt(i4);
                            childAt2.setVisibility(0);
                            b b3 = this.layeredViewPool.b();
                            b3.b(childAt2, i2 + 1);
                            this.layeredViewQueue.add(b3);
                        }
                    }
                }
            }
            canvas.restoreToCount(save);
            return;
        }
        throw new AssertionError("View queue is not empty.");
    }

    public int getChromeColor() {
        return this.chromeColor;
    }

    public int getChromeShadowColor() {
        return this.chromeShadowColor;
    }

    public boolean isDrawingIds() {
        return this.drawIds;
    }

    public boolean isDrawingViews() {
        return this.drawViews;
    }

    public boolean isLayerInteractionEnabled() {
        return this.enabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.enabled || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != 6) goto L_0x01cb;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!this.enabled) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                        }
                    }
                } else if (this.pointerTwo == -1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        if (this.pointerOne == motionEvent.getPointerId(i2)) {
                            float x = motionEvent.getX(i2);
                            float y = motionEvent.getY(i2);
                            this.rotationY = Math.min(Math.max(this.rotationY + (((x - this.lastOneX) / ((float) getWidth())) * 90.0f), -60.0f), 60.0f);
                            this.rotationX = Math.min(Math.max(this.rotationX + (((-(y - this.lastOneY)) / ((float) getHeight())) * 90.0f), -60.0f), 60.0f);
                            this.lastOneX = x;
                            this.lastOneY = y;
                            invalidate();
                        }
                        i2++;
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.pointerOne);
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.pointerTwo);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float x3 = motionEvent.getX(findPointerIndex2);
                    float y3 = motionEvent.getY(findPointerIndex2);
                    float f = x2 - this.lastOneX;
                    float f2 = y2 - this.lastOneY;
                    float f3 = x3 - this.lastTwoX;
                    float f4 = y3 - this.lastTwoY;
                    if (this.multiTouchTracking == 0) {
                        float abs = Math.abs(f) + Math.abs(f3);
                        float abs2 = Math.abs(f2) + Math.abs(f4);
                        float f5 = this.slop;
                        if (abs > f5 * ZOOM_MAX || abs2 > f5 * ZOOM_MAX) {
                            if (abs > abs2) {
                                this.multiTouchTracking = -1;
                            } else {
                                this.multiTouchTracking = 1;
                            }
                        }
                    }
                    int i3 = this.multiTouchTracking;
                    if (i3 == 1) {
                        if (y2 >= y3) {
                            this.zoom += (f2 / ((float) getHeight())) - (f4 / ((float) getHeight()));
                        } else {
                            this.zoom += (f4 / ((float) getHeight())) - (f2 / ((float) getHeight()));
                        }
                        this.zoom = Math.min(Math.max(this.zoom, (float) ZOOM_MIN), (float) ZOOM_MAX);
                        invalidate();
                    } else if (i3 == -1) {
                        if (x2 >= x3) {
                            this.spacing += ((f / ((float) getWidth())) * 100.0f) - ((f3 / ((float) getWidth())) * 100.0f);
                        } else {
                            this.spacing += ((f3 / ((float) getWidth())) * 100.0f) - ((f / ((float) getWidth())) * 100.0f);
                        }
                        this.spacing = Math.min(Math.max(this.spacing, 10.0f), 100.0f);
                        invalidate();
                    }
                    if (this.multiTouchTracking != 0) {
                        this.lastOneX = x2;
                        this.lastOneY = y2;
                        this.lastTwoX = x3;
                        this.lastTwoY = y3;
                    }
                }
                return true;
            }
            if (actionMasked != 6) {
                i = 0;
            } else {
                i = motionEvent.getActionIndex();
            }
            int pointerId = motionEvent.getPointerId(i);
            if (this.pointerOne == pointerId) {
                this.pointerOne = this.pointerTwo;
                this.lastOneX = this.lastTwoX;
                this.lastOneY = this.lastTwoY;
                this.pointerTwo = -1;
                this.multiTouchTracking = 0;
            } else if (this.pointerTwo == pointerId) {
                this.pointerTwo = -1;
                this.multiTouchTracking = 0;
            }
            return true;
        }
        if (actionMasked != 0) {
            i2 = motionEvent.getActionIndex();
        }
        if (this.pointerOne == -1) {
            this.pointerOne = motionEvent.getPointerId(i2);
            this.lastOneX = motionEvent.getX(i2);
            this.lastOneY = motionEvent.getY(i2);
        } else if (this.pointerTwo == -1) {
            this.pointerTwo = motionEvent.getPointerId(i2);
            this.lastTwoX = motionEvent.getX(i2);
            this.lastTwoY = motionEvent.getY(i2);
        }
        return true;
    }

    public void setChromeColor(int i) {
        if (this.chromeColor != i) {
            this.viewBorderPaint.setColor(i);
            this.chromeColor = i;
            invalidate();
        }
    }

    public void setChromeShadowColor(int i) {
        if (this.chromeShadowColor != i) {
            this.viewBorderPaint.setShadowLayer(1.0f, -1.0f, 1.0f, i);
            this.chromeShadowColor = i;
            invalidate();
        }
    }

    public void setDrawIds(boolean z) {
        if (this.drawIds != z) {
            this.drawIds = z;
            invalidate();
        }
    }

    public void setDrawViews(boolean z) {
        if (this.drawViews != z) {
            this.drawViews = z;
            invalidate();
        }
    }

    public void setLayerInteractionEnabled(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            setWillNotDraw(!z);
            invalidate();
        }
    }

    public ScalpelFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalpelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewBoundsRect = new Rect();
        Paint paint = new Paint(1);
        this.viewBorderPaint = paint;
        this.camera = new Camera();
        this.matrix = new Matrix();
        this.location = new int[2];
        this.visibilities = new BitSet(50);
        this.idNames = new SparseArray<>();
        this.layeredViewQueue = new ArrayDeque();
        this.layeredViewPool = new a(this, 50);
        this.drawViews = true;
        this.pointerOne = -1;
        this.pointerTwo = -1;
        this.multiTouchTracking = 0;
        this.rotationY = 15.0f;
        this.rotationX = -10.0f;
        this.zoom = 0.6f;
        this.spacing = 25.0f;
        this.res = context.getResources();
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        this.slop = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = 10.0f * f;
        this.textSize = f2;
        this.textOffset = f * ZOOM_MAX;
        setChromeColor(CHROME_COLOR);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(f2);
        setChromeShadowColor(-16777216);
        if (Build.VERSION.SDK_INT >= 16) {
            paint.setTypeface(Typeface.create("sans-serif-condensed", 0));
        }
    }
}
