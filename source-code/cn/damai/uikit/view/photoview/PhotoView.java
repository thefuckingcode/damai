package cn.damai.uikit.view.photoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PhotoView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private PhotoViewAttacher attacher;
    private ImageView.ScaleType pendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893539350")) {
            ipChange.ipc$dispatch("-893539350", new Object[]{this});
            return;
        }
        this.attacher = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.pendingScaleType = null;
        }
    }

    public PhotoViewAttacher getAttacher() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "898455082")) {
            return this.attacher;
        }
        return (PhotoViewAttacher) ipChange.ipc$dispatch("898455082", new Object[]{this});
    }

    public void getDisplayMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1960948209")) {
            ipChange.ipc$dispatch("-1960948209", new Object[]{this, matrix});
            return;
        }
        this.attacher.D(matrix);
    }

    public RectF getDisplayRect() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "678856701")) {
            return this.attacher.E();
        }
        return (RectF) ipChange.ipc$dispatch("678856701", new Object[]{this});
    }

    public Matrix getImageMatrix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2001304128")) {
            return this.attacher.H();
        }
        return (Matrix) ipChange.ipc$dispatch("-2001304128", new Object[]{this});
    }

    public float getMaximumScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-763716288")) {
            return this.attacher.K();
        }
        return ((Float) ipChange.ipc$dispatch("-763716288", new Object[]{this})).floatValue();
    }

    public float getMediumScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1084653227")) {
            return this.attacher.L();
        }
        return ((Float) ipChange.ipc$dispatch("1084653227", new Object[]{this})).floatValue();
    }

    public float getMinimumScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1874155218")) {
            return this.attacher.M();
        }
        return ((Float) ipChange.ipc$dispatch("-1874155218", new Object[]{this})).floatValue();
    }

    public float getScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1734400086")) {
            return this.attacher.N();
        }
        return ((Float) ipChange.ipc$dispatch("1734400086", new Object[]{this})).floatValue();
    }

    public ImageView.ScaleType getScaleType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-611667036")) {
            return this.attacher.O();
        }
        return (ImageView.ScaleType) ipChange.ipc$dispatch("-611667036", new Object[]{this});
    }

    public void getSuppMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264518021")) {
            ipChange.ipc$dispatch("264518021", new Object[]{this, matrix});
            return;
        }
        this.attacher.P(matrix);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1235734864")) {
            return this.attacher.R();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1235734864", new Object[]{this})).booleanValue();
    }

    public boolean isZoomable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2125511911")) {
            return this.attacher.S();
        }
        return ((Boolean) ipChange.ipc$dispatch("2125511911", new Object[]{this})).booleanValue();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039696529")) {
            ipChange.ipc$dispatch("1039696529", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.attacher.U(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1372373369")) {
            return this.attacher.V(matrix);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1372373369", new Object[]{this, matrix})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154739789")) {
            return ((Boolean) ipChange.ipc$dispatch("-154739789", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).booleanValue();
        }
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.attacher.t0();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837140455")) {
            ipChange.ipc$dispatch("837140455", new Object[]{this, drawable});
            return;
        }
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.t0();
        }
    }

    public void setImageResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577078416")) {
            ipChange.ipc$dispatch("577078416", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.t0();
        }
    }

    public void setImageURI(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371015158")) {
            ipChange.ipc$dispatch("-1371015158", new Object[]{this, uri});
            return;
        }
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.t0();
        }
    }

    public void setMaximumScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "550898044")) {
            ipChange.ipc$dispatch("550898044", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.attacher.X(f);
    }

    public void setMediumScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184572377")) {
            ipChange.ipc$dispatch("184572377", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.attacher.Y(f);
    }

    public void setMinimumScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "487029582")) {
            ipChange.ipc$dispatch("487029582", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.attacher.Z(f);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1954297478")) {
            ipChange.ipc$dispatch("-1954297478", new Object[]{this, onClickListener});
            return;
        }
        this.attacher.a0(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899502460")) {
            ipChange.ipc$dispatch("899502460", new Object[]{this, onDoubleTapListener});
            return;
        }
        this.attacher.b0(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753627654")) {
            ipChange.ipc$dispatch("-753627654", new Object[]{this, onLongClickListener});
            return;
        }
        this.attacher.c0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "295566889")) {
            ipChange.ipc$dispatch("295566889", new Object[]{this, onMatrixChangedListener});
            return;
        }
        this.attacher.d0(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446057823")) {
            ipChange.ipc$dispatch("1446057823", new Object[]{this, onOutsidePhotoTapListener});
            return;
        }
        this.attacher.e0(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113479365")) {
            ipChange.ipc$dispatch("-2113479365", new Object[]{this, onPhotoTapListener});
            return;
        }
        this.attacher.f0(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "277716741")) {
            ipChange.ipc$dispatch("277716741", new Object[]{this, onScaleChangedListener});
            return;
        }
        this.attacher.g0(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1204150753")) {
            ipChange.ipc$dispatch("-1204150753", new Object[]{this, onSingleFlingListener});
            return;
        }
        this.attacher.h0(onSingleFlingListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686320235")) {
            ipChange.ipc$dispatch("686320235", new Object[]{this, onViewDragListener});
            return;
        }
        this.attacher.i0(onViewDragListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-201525921")) {
            ipChange.ipc$dispatch("-201525921", new Object[]{this, onViewTapListener});
            return;
        }
        this.attacher.j0(onViewTapListener);
    }

    public void setRotationBy(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075524825")) {
            ipChange.ipc$dispatch("-1075524825", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.attacher.k0(f);
    }

    public void setRotationTo(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569435317")) {
            ipChange.ipc$dispatch("-569435317", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.attacher.l0(f);
    }

    public void setScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-519152498")) {
            ipChange.ipc$dispatch("-519152498", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.attacher.m0(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296284899")) {
            ipChange.ipc$dispatch("-296284899", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        this.attacher.p0(f, f2, f3);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576797006")) {
            ipChange.ipc$dispatch("-576797006", new Object[]{this, scaleType});
            return;
        }
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher == null) {
            this.pendingScaleType = scaleType;
        } else {
            photoViewAttacher.q0(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1488568939")) {
            return this.attacher.V(matrix);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1488568939", new Object[]{this, matrix})).booleanValue();
    }

    public void setZoomTransitionDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674273585")) {
            ipChange.ipc$dispatch("1674273585", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.attacher.r0(i);
    }

    public void setZoomable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942143693")) {
            ipChange.ipc$dispatch("-942143693", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.attacher.s0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086187526")) {
            ipChange.ipc$dispatch("1086187526", new Object[]{this, Float.valueOf(f), Boolean.valueOf(z)});
            return;
        }
        this.attacher.o0(f, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131558278")) {
            ipChange.ipc$dispatch("131558278", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)});
            return;
        }
        this.attacher.n0(f, f2, f3, z);
    }

    @TargetApi(21)
    public PhotoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
