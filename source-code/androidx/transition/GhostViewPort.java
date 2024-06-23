package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class GhostViewPort extends ViewGroup implements GhostView {
    @Nullable
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
        /* class androidx.transition.GhostViewPort.AnonymousClass1 */

        public boolean onPreDraw() {
            View view;
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.mStartParent;
            if (viewGroup == null || (view = ghostViewPort.mStartView) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this.mStartParent);
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.mStartParent = null;
            ghostViewPort2.mStartView = null;
            return true;
        }
    };
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    GhostViewPort(View view) {
        super(view.getContext());
        this.mView = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    static GhostViewPort addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        GhostViewHolder ghostViewHolder;
        if (view.getParent() instanceof ViewGroup) {
            GhostViewHolder holder = GhostViewHolder.getHolder(viewGroup);
            GhostViewPort ghostView = getGhostView(view);
            int i = 0;
            if (!(ghostView == null || (ghostViewHolder = (GhostViewHolder) ghostView.getParent()) == holder)) {
                i = ghostView.mReferences;
                ghostViewHolder.removeView(ghostView);
                ghostView = null;
            }
            if (ghostView == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    calculateMatrix(view, viewGroup, matrix);
                }
                ghostView = new GhostViewPort(view);
                ghostView.setMatrix(matrix);
                if (holder == null) {
                    holder = new GhostViewHolder(viewGroup);
                } else {
                    holder.popToOverlayTop();
                }
                copySize(viewGroup, holder);
                copySize(viewGroup, ghostView);
                holder.addGhostView(ghostView);
                ghostView.mReferences = i;
            } else if (matrix != null) {
                ghostView.setMatrix(matrix);
            }
            ghostView.mReferences++;
            return ghostView;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void calculateMatrix(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ViewUtils.transformMatrixToGlobal(viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
    }

    static void copySize(View view, View view2) {
        ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static GhostViewPort getGhostView(View view) {
        return (GhostViewPort) view.getTag(R.id.ghost_view);
    }

    static void removeGhost(View view) {
        GhostViewPort ghostView = getGhostView(view);
        if (ghostView != null) {
            int i = ghostView.mReferences - 1;
            ghostView.mReferences = i;
            if (i <= 0) {
                ((GhostViewHolder) ghostView.getParent()).removeView(ghostView);
            }
        }
    }

    static void setGhostView(@NonNull View view, @Nullable GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, ghostViewPort);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() != null) {
            ((View) this.mView.getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        setGhostView(this.mView, null);
        if (this.mView.getParent() != null) {
            ((View) this.mView.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        CanvasUtils.enableZ(canvas, true);
        canvas.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        drawChild(canvas, this.mView, getDrawingTime());
        CanvasUtils.enableZ(canvas, false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.mStartParent = viewGroup;
        this.mStartView = view;
    }

    /* access modifiers changed from: package-private */
    public void setMatrix(@NonNull Matrix matrix) {
        this.mMatrix = matrix;
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getGhostView(this.mView) == this) {
            ViewUtils.setTransitionVisibility(this.mView, i == 0 ? 4 : 0);
        }
    }
}
