package com.amap.api.maps;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.mapcore.util.t;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import tb.v;

@TargetApi(20)
/* compiled from: Taobao */
public class WearMapView extends ViewGroup implements BaseMapView {
    private static int f;
    private static int g;
    private final String a = WearMapView.class.getSimpleName();
    private IMapFragmentDelegate b;
    private AMap c;
    private View d;
    private SwipeDismissView e;
    private int h = 0;

    /* compiled from: Taobao */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotifySwipe();
    }

    public WearMapView(Context context) {
        super(context);
        getMapFragmentDelegate().setContext(context);
        a(context);
        b(context);
    }

    private void a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            if (defaultDisplay != null) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
            }
            f = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            g = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        }
    }

    private void b(Context context) {
        this.e = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f), g);
        this.e.setBackgroundColor(Color.argb(0, 0, 0, 0));
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        addView(this.e, layoutParams);
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.c == null) {
                this.c = new AMap(map);
            }
            return this.c;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public IMapFragmentDelegate getMapFragmentDelegate() {
        IMapFragmentDelegate iMapFragmentDelegate = this.b;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
            this.b = new t(1);
        }
        return this.b;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z) {
        try {
            getMapFragmentDelegate().loadWorldVectorMap(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onCreate(Bundle bundle) {
        try {
            this.d = getMapFragmentDelegate().onCreateView(null, null, bundle);
            addView(this.d, 0, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onDismiss() {
        removeAllViews();
    }

    public void onEnterAmbient(Bundle bundle) {
        onResume();
    }

    public void onExitAmbient() {
        onPause();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt == this.d) {
                childAt.layout(0, 0, getWidth(), getHeight());
            } else {
                SwipeDismissView swipeDismissView = this.e;
                if (childAt == swipeDismissView) {
                    a(swipeDismissView);
                    this.e.layout(0, 0, this.e.getMeasuredWidth(), i3);
                }
            }
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof SwipeDismissView) {
                SwipeDismissView swipeDismissView = (SwipeDismissView) childAt;
                childAt.measure(swipeDismissView.getLayoutParams().width, swipeDismissView.getLayoutParams().height);
            } else {
                childAt.measure(i, i2);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayerType(int i, Paint paint) {
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.e;
        if (swipeDismissView != null) {
            swipeDismissView.setCallback(onDismissCallback);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        getMapFragmentDelegate().setVisibility(i);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.h);
        a(context);
        b(context);
    }

    private void a(View view) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i3 = layoutParams.width;
        if (i3 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i4 = layoutParams.height;
        if (i4 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else {
            i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i, i2);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.h);
        a(context);
        b(context);
    }

    public WearMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
        a(context);
        b(context);
    }
}
