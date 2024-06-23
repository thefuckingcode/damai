package com.taobao.weex.ui.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.BaseFrameLayout;
import com.taobao.weex.ui.view.WXCircleIndicator;
import com.taobao.weex.ui.view.WXCirclePageAdapter;
import com.taobao.weex.ui.view.WXCircleViewPager;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: Taobao */
public class WXSliderNeighbor extends WXSlider {
    public static final String CURRENT_ITEM_SCALE = "currentItemScale";
    private static final float DEFAULT_CURRENT_ITEM_SCALE = 0.9f;
    private static final float DEFAULT_NEIGHBOR_ALPHA = 0.6f;
    private static final float DEFAULT_NEIGHBOR_SCALE = 0.8f;
    private static final int DEFAULT_NEIGHBOR_SPACE = 25;
    public static final String NEIGHBOR_ALPHA = "neighborAlpha";
    public static final String NEIGHBOR_SCALE = "neighborScale";
    public static final String NEIGHBOR_SPACE = "neighborSpace";
    private ZoomTransformer mCachedTransformer;
    private float mCurrentItemScale = 0.9f;
    private float mNeighborAlpha = 0.6f;
    private float mNeighborScale = 0.8f;
    private float mNeighborSpace = 25.0f;

    /* compiled from: Taobao */
    public static class Creator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXSliderNeighbor(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ZoomTransformer implements ViewPager.PageTransformer {
        ZoomTransformer() {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f) {
            View childAt;
            int pagePosition = WXSliderNeighbor.this.mAdapter.getPagePosition(view);
            int currentItem = WXSliderNeighbor.this.mViewPager.getCurrentItem();
            int realCount = WXSliderNeighbor.this.mAdapter.getRealCount();
            boolean z = (currentItem == 0 || currentItem == realCount + -1 || Math.abs(pagePosition - currentItem) <= 1) ? false : true;
            if (currentItem == 0 && pagePosition < realCount - 1 && pagePosition > 1) {
                z = true;
            }
            int i = realCount - 1;
            if (currentItem == i && pagePosition < realCount - 2 && pagePosition > 0) {
                z = true;
            }
            if (!z && (childAt = ((ViewGroup) view).getChildAt(0)) != null) {
                if (f <= ((float) ((-realCount) + 1))) {
                    f += (float) realCount;
                }
                if (f >= ((float) i)) {
                    f -= (float) realCount;
                }
                if (f >= -1.0f && f <= 1.0f) {
                    float abs = Math.abs(Math.abs(f) - 1.0f);
                    float f2 = WXSliderNeighbor.this.mNeighborScale + ((WXSliderNeighbor.this.mCurrentItemScale - WXSliderNeighbor.this.mNeighborScale) * abs);
                    float f3 = ((1.0f - WXSliderNeighbor.this.mNeighborAlpha) * abs) + WXSliderNeighbor.this.mNeighborAlpha;
                    float calculateTranslation = WXSliderNeighbor.this.calculateTranslation(view);
                    int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                    if (i2 > 0) {
                        float f4 = -(f * calculateTranslation);
                        childAt.setTranslationX(f4);
                        view.setTranslationX(f4);
                    } else if (i2 == 0) {
                        view.setTranslationX(0.0f);
                        childAt.setTranslationX(0.0f);
                        WXSliderNeighbor wXSliderNeighbor = WXSliderNeighbor.this;
                        wXSliderNeighbor.updateAdapterScaleAndAlpha(wXSliderNeighbor.mNeighborAlpha, WXSliderNeighbor.this.mNeighborScale);
                    } else if (realCount != 2 || Math.abs(f) != 1.0f) {
                        float f5 = (-f) * calculateTranslation;
                        childAt.setTranslationX(f5);
                        view.setTranslationX(f5);
                    } else {
                        return;
                    }
                    childAt.setScaleX(f2);
                    childAt.setScaleY(f2);
                    childAt.setAlpha(f3);
                }
            }
        }
    }

    public WXSliderNeighbor(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float calculateTranslation(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return 0.0f;
        }
        View childAt = ((ViewGroup) view).getChildAt(0);
        return ((((float) view.getMeasuredWidth()) - (((float) childAt.getMeasuredWidth()) * this.mNeighborScale)) / 4.0f) + ((((((float) view.getMeasuredWidth()) - (((float) childAt.getMeasuredWidth()) * this.mCurrentItemScale)) / 2.0f) - WXViewUtils.getRealPxByWidth(this.mNeighborSpace, getInstance().getInstanceViewPortWidth())) / 2.0f);
    }

    private void moveLeft(View view, float f, float f2, float f3) {
        updateScaleAndAlpha(((ViewGroup) view).getChildAt(0), f2, f3);
        view.setTranslationX(f);
        ((ViewGroup) view).getChildAt(0).setTranslationX(f);
    }

    private void moveRight(View view, float f, float f2, float f3) {
        moveLeft(view, -f, f2, f3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateAdapterScaleAndAlpha(final float f, final float f2) {
        List<View> views = this.mAdapter.getViews();
        int currentItem = this.mViewPager.getCurrentItem();
        if (views.size() > 0) {
            final View view = views.get(currentItem);
            updateScaleAndAlpha(((ViewGroup) view).getChildAt(0), 1.0f, this.mCurrentItemScale);
            if (views.size() >= 2) {
                view.postDelayed(WXThread.secure(new Runnable() {
                    /* class com.taobao.weex.ui.component.WXSliderNeighbor.AnonymousClass2 */

                    public void run() {
                        WXSliderNeighbor.this.updateNeighbor(view, f, f2);
                    }
                }), 17);
                int size = currentItem == 0 ? views.size() - 1 : currentItem - 1;
                int i = currentItem == views.size() + -1 ? 0 : currentItem + 1;
                for (int i2 = 0; i2 < this.mAdapter.getRealCount(); i2++) {
                    if (!(i2 == size || i2 == currentItem || i2 == i)) {
                        ((ViewGroup) views.get(i2)).getChildAt(0).setAlpha(0.0f);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateNeighbor(View view, float f, float f2) {
        List<View> views = this.mAdapter.getViews();
        int currentItem = this.mViewPager.getCurrentItem();
        float calculateTranslation = calculateTranslation(view);
        View view2 = views.get(currentItem == 0 ? views.size() - 1 : currentItem - 1);
        View view3 = views.get(currentItem == views.size() - 1 ? 0 : currentItem + 1);
        if (views.size() != 2) {
            moveLeft(view2, calculateTranslation, f, f2);
            moveRight(view3, calculateTranslation, f, f2);
        } else if (currentItem == 0) {
            moveRight(view3, calculateTranslation, f, f2);
        } else if (currentItem == 1) {
            moveLeft(view2, calculateTranslation, f, f2);
        }
    }

    private void updateScaleAndAlpha(View view, float f, float f2) {
        if (view != null) {
            if (f >= 0.0f && view.getAlpha() != f) {
                view.setAlpha(f);
            }
            if (f2 >= 0.0f && view.getScaleX() != f2) {
                view.setScaleX(f2);
                view.setScaleY(f2);
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXVContainer
    public void addSubView(View view, final int i) {
        if (view != null && this.mAdapter != null && !(view instanceof WXCircleIndicator)) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            frameLayout.addView(view);
            super.addSubView(frameLayout, i);
            updateAdapterScaleAndAlpha(this.mNeighborAlpha, this.mNeighborScale);
            this.mViewPager.postDelayed(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.ui.component.WXSliderNeighbor.AnonymousClass1 */

                public void run() {
                    WXSliderNeighbor wXSliderNeighbor;
                    try {
                        if (WXSliderNeighbor.this.mViewPager.getRealCount() > 0 && i > 2) {
                            WXSliderNeighbor.this.mViewPager.beginFakeDrag();
                            WXSliderNeighbor.this.mViewPager.fakeDragBy(1.0f);
                        }
                        try {
                            wXSliderNeighbor = WXSliderNeighbor.this;
                        } catch (Exception unused) {
                            return;
                        }
                    } catch (IndexOutOfBoundsException unused2) {
                        wXSliderNeighbor = WXSliderNeighbor.this;
                    } catch (Throwable th) {
                        try {
                            WXSliderNeighbor.this.mViewPager.endFakeDrag();
                        } catch (Exception unused3) {
                        }
                        throw th;
                    }
                    wXSliderNeighbor.mViewPager.endFakeDrag();
                }
            }), 50);
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void bindData(WXComponent wXComponent) {
        super.bindData(wXComponent);
    }

    /* access modifiers changed from: package-private */
    public ZoomTransformer createTransformer() {
        if (this.mCachedTransformer == null) {
            this.mCachedTransformer = new ZoomTransformer();
        }
        return this.mCachedTransformer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    @WXComponentProp(name = CURRENT_ITEM_SCALE)
    public void setCurrentItemScale(String str) {
        float f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
            }
            if (this.mCurrentItemScale == f) {
                this.mCurrentItemScale = f;
                updateAdapterScaleAndAlpha(-1.0f, -1.0f);
                return;
            }
            return;
        }
        f = 0.9f;
        if (this.mCurrentItemScale == f) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    @WXComponentProp(name = NEIGHBOR_ALPHA)
    public void setNeighborAlpha(String str) {
        float f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
            }
            if (this.mNeighborAlpha == f) {
                this.mNeighborAlpha = f;
                updateAdapterScaleAndAlpha(f, -1.0f);
                return;
            }
            return;
        }
        f = 0.6f;
        if (this.mNeighborAlpha == f) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    @WXComponentProp(name = NEIGHBOR_SCALE)
    public void setNeighborScale(String str) {
        float f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
            }
            if (this.mNeighborScale == f) {
                this.mNeighborScale = f;
                updateAdapterScaleAndAlpha(-1.0f, f);
                return;
            }
            return;
        }
        f = 0.8f;
        if (this.mNeighborScale == f) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
    @WXComponentProp(name = NEIGHBOR_SPACE)
    public void setNeighborSpace(String str) {
        float f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
            }
            if (this.mNeighborSpace == f) {
                this.mNeighborSpace = f;
                return;
            }
            return;
        }
        f = 25.0f;
        if (this.mNeighborSpace == f) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1763701364:
                if (str.equals(NEIGHBOR_ALPHA)) {
                    c = 0;
                    break;
                }
                break;
            case -1747360392:
                if (str.equals(NEIGHBOR_SCALE)) {
                    c = 1;
                    break;
                }
                break;
            case -1746973388:
                if (str.equals(NEIGHBOR_SPACE)) {
                    c = 2;
                    break;
                }
                break;
            case -1013904258:
                if (str.equals(CURRENT_ITEM_SCALE)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                String string = WXUtils.getString(obj, null);
                if (string != null) {
                    setNeighborAlpha(string);
                }
                return true;
            case 1:
                String string2 = WXUtils.getString(obj, null);
                if (string2 != null) {
                    setNeighborScale(string2);
                }
                return true;
            case 2:
                String string3 = WXUtils.getString(obj, null);
                if (string3 != null) {
                    setNeighborSpace(string3);
                }
                return true;
            case 3:
                String string4 = WXUtils.getString(obj, null);
                if (string4 != null) {
                    setCurrentItemScale(string4);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXComponent
    public BaseFrameLayout initComponentHostView(@NonNull Context context) {
        BaseFrameLayout baseFrameLayout = new BaseFrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        WXCircleViewPager wXCircleViewPager = new WXCircleViewPager(getContext());
        this.mViewPager = wXCircleViewPager;
        wXCircleViewPager.setLayoutParams(layoutParams);
        WXCirclePageAdapter wXCirclePageAdapter = new WXCirclePageAdapter();
        this.mAdapter = wXCirclePageAdapter;
        this.mViewPager.setAdapter(wXCirclePageAdapter);
        baseFrameLayout.addView(this.mViewPager);
        this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
        this.mViewPager.setOverScrollMode(2);
        registerActivityStateListener();
        this.mViewPager.setPageTransformer(false, createTransformer());
        return baseFrameLayout;
    }
}
