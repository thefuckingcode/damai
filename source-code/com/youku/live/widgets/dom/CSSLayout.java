package com.youku.live.widgets.dom;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.model.template.WidgetAttributesModel;
import com.youku.live.widgets.protocol.Orientation;
import tb.v;

/* compiled from: Taobao */
public class CSSLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float baseDensity = 0.0f;
    public boolean isNotifyConfigChanged = true;
    private boolean mIsLandscape = false;
    private int mStatusBar = 0;
    protected boolean mSupportAscendingDispatchTouchEvent = false;

    public CSSLayout(@NonNull Context context) {
        super(context);
    }

    private float getDensity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133730052")) {
            return ((Float) ipChange.ipc$dispatch("133730052", new Object[]{this})).floatValue();
        }
        if (this.baseDensity <= 0.0f) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService(v.ATTACH_MODE_WINDOW);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null) {
                Display.getMetrics(windowManager.getDefaultDisplay(), displayMetrics);
                this.baseDensity = displayMetrics.density;
            }
        }
        return this.baseDensity;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081975214")) {
            ipChange.ipc$dispatch("2081975214", new Object[]{this, view, Integer.valueOf(i), layoutParams});
            return;
        }
        if (!(layoutParams instanceof LayoutParams)) {
            if (layoutParams != null) {
                layoutParams = new LayoutParams(layoutParams.width, layoutParams.height);
            } else {
                layoutParams = new LayoutParams(-1, -1);
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void enableNotifyConfigChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361698730")) {
            ipChange.ipc$dispatch("-1361698730", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isNotifyConfigChanged = z;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        Boolean bool;
        Boolean bool2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558729657")) {
            ipChange.ipc$dispatch("-1558729657", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        if (this.isNotifyConfigChanged) {
            int childCount = getChildCount();
            int i = configuration.orientation;
            if (i == 1) {
                this.mIsLandscape = false;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    WidgetAttributesModel.OrientationModel orientationModel = ((LayoutParams) childAt.getLayoutParams()).portraitModel;
                    if (!(orientationModel == null || (bool2 = orientationModel.visible) == null)) {
                        if (bool2.booleanValue()) {
                            if (childAt.getVisibility() != 0) {
                                childAt.setVisibility(0);
                            }
                        } else if (childAt.getVisibility() == 0) {
                            childAt.setVisibility(4);
                        }
                    }
                }
            } else if (i == 2) {
                this.mIsLandscape = true;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = getChildAt(i3);
                    WidgetAttributesModel.OrientationModel orientationModel2 = ((LayoutParams) childAt2.getLayoutParams()).landscapeModel;
                    if (!(orientationModel2 == null || (bool = orientationModel2.visible) == null)) {
                        if (bool.booleanValue()) {
                            if (childAt2.getVisibility() != 0) {
                                childAt2.setVisibility(0);
                            }
                        } else if (childAt2.getVisibility() == 0) {
                            childAt2.setVisibility(4);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        WidgetAttributesModel.RectModel rectModel;
        WidgetAttributesModel.RectModel rectModel2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148578057")) {
            ipChange.ipc$dispatch("-148578057", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        int i11 = i3 - i;
        int i12 = i4 - i2;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            if (!(layoutParams2 instanceof LayoutParams)) {
                layoutParams = new LayoutParams(layoutParams2.width, layoutParams2.height);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                WidgetAttributesModel.OrientationModel orientationModel = layoutParams.portraitModel;
                if (orientationModel != null) {
                    if (!orientationModel.useDp() || getDensity() <= 0.0f) {
                        rectModel2 = layoutParams.portraitModel.compute(i11, i12, layoutParams.aspectRatio);
                    } else {
                        rectModel2 = layoutParams.portraitModel.compute(i11, i12, getDensity());
                    }
                    i7 = rectModel2.l;
                    i9 = rectModel2.t;
                    i8 = rectModel2.w;
                    i10 = rectModel2.h;
                }
                i6 = measuredHeight;
                i7 = 0;
                i5 = 0;
                childAt.layout(i7, i5, measuredWidth + i7, i6 + i5);
            } else {
                WidgetAttributesModel.OrientationModel orientationModel2 = layoutParams.landscapeModel;
                if (orientationModel2 != null) {
                    if (!orientationModel2.useDp() || getDensity() <= 0.0f) {
                        rectModel = layoutParams.landscapeModel.compute(i11, i12, layoutParams.aspectRatio);
                    } else {
                        rectModel = layoutParams.landscapeModel.compute(i11, i12, getDensity());
                    }
                    i7 = rectModel.l;
                    i9 = rectModel.t;
                    i8 = rectModel.w;
                    i10 = rectModel.h;
                }
                i6 = measuredHeight;
                i7 = 0;
                i5 = 0;
                childAt.layout(i7, i5, measuredWidth + i7, i6 + i5);
            }
            i6 = i10;
            measuredWidth = i8;
            i5 = i9;
            childAt.layout(i7, i5, measuredWidth + i7, i6 + i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        WidgetAttributesModel.RectModel rectModel;
        WidgetAttributesModel.RectModel rectModel2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "270130181")) {
            ipChange.ipc$dispatch("270130181", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        LayoutParams layoutParams = null;
        setMeasuredDimension(size, size2);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (marginLayoutParams instanceof LayoutParams) {
                layoutParams = (LayoutParams) marginLayoutParams;
            }
            if (layoutParams != null && layoutParams.useCSSLayout) {
                if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                    WidgetAttributesModel.OrientationModel orientationModel = layoutParams.portraitModel;
                    if (orientationModel != null) {
                        if (!orientationModel.useDp() || getDensity() <= 0.0f) {
                            rectModel2 = layoutParams.portraitModel.compute(size, size2, layoutParams.aspectRatio);
                        } else {
                            rectModel2 = layoutParams.portraitModel.compute(size, size2, getDensity());
                        }
                        i5 = rectModel2.w;
                        i6 = rectModel2.h;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    }
                } else {
                    WidgetAttributesModel.OrientationModel orientationModel2 = layoutParams.landscapeModel;
                    if (orientationModel2 != null) {
                        if (!orientationModel2.useDp() || getDensity() <= 0.0f) {
                            rectModel = layoutParams.landscapeModel.compute(size, size2, layoutParams.aspectRatio);
                        } else {
                            rectModel = layoutParams.landscapeModel.compute(size, size2, getDensity());
                        }
                        i5 = rectModel.w;
                        i6 = rectModel.h;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    }
                }
                i6 = 0;
                i5 = 0;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            } else if (layoutParams != null) {
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i8 == -1) {
                    i3 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin), 1073741824);
                } else {
                    i3 = FrameLayout.getChildMeasureSpec(i, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i8);
                }
                int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i9 == -1) {
                    i4 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin), 1073741824);
                } else {
                    i4 = FrameLayout.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, i9);
                }
                childAt.measure(i3, i4);
            }
        }
    }

    public void supportAscendingDispatchTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-192571156")) {
            ipChange.ipc$dispatch("-192571156", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mSupportAscendingDispatchTouchEvent = z;
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        private static transient /* synthetic */ IpChange $ipChange;
        public float aspectRatio;
        public float baseDp;
        public WidgetAttributesModel.RectModel landscapeCache;
        public WidgetAttributesModel.OrientationModel landscapeModel;
        public WidgetAttributesModel.RectModel portraitCache;
        public WidgetAttributesModel.OrientationModel portraitModel;
        public boolean useCSSLayout = false;

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setOrientationModel(WidgetAttributesModel.OrientationModel orientationModel, WidgetAttributesModel.OrientationModel orientationModel2, float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1197430351")) {
                ipChange.ipc$dispatch("-1197430351", new Object[]{this, orientationModel, orientationModel2, Float.valueOf(f)});
                return;
            }
            this.portraitModel = orientationModel;
            this.landscapeModel = orientationModel2;
            this.aspectRatio = f;
            this.useCSSLayout = true;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(api = 19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public CSSLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSSLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
