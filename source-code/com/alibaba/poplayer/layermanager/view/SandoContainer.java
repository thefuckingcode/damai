package com.alibaba.poplayer.layermanager.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.R$layout;
import tb.cr1;
import tb.eu2;

/* compiled from: Taobao */
public class SandoContainer extends FrameLayout {
    private boolean isBeginPreDrawListener = false;
    private AugmentedLayer mAugmentedLayer;
    private MirrorLayer mMirrorLayer;
    private PopLayerViewContainer mPopLayerContainer;
    private final ViewTreeObserver.OnPreDrawListener mPreDrawLsn = new a();

    /* compiled from: Taobao */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            try {
                SandoContainer.this.mMirrorLayer.updateMirrorViewsIfNeed();
                SandoContainer.this.mAugmentedLayer.updateAugmentedViews();
                if (SandoContainer.this.mMirrorLayer.size() == 0 && SandoContainer.this.mAugmentedLayer.getChildCount() == 0) {
                    SandoContainer.this.stopPreDrawListenerIfNeed();
                    cr1.b("SandoContainer.stop preDraw listener:mirror and track count = 0;", new Object[0]);
                }
            } catch (Throwable unused) {
            }
            return true;
        }
    }

    public SandoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
    }

    private void initialize(Context context) {
        View.inflate(context, R$layout.pop_layer_sando_layer, this);
        MirrorLayer mirrorLayer = (MirrorLayer) findViewById(R$id.mirror);
        this.mMirrorLayer = mirrorLayer;
        mirrorLayer.setSandoContainer(this);
        AugmentedLayer augmentedLayer = (AugmentedLayer) findViewById(R$id.augmented);
        this.mAugmentedLayer = augmentedLayer;
        augmentedLayer.setSandoContainer(this);
    }

    public AugmentedLayer getAugmentedLayer() {
        return this.mAugmentedLayer;
    }

    public MirrorLayer getMirrorLayer() {
        return this.mMirrorLayer;
    }

    /* access modifiers changed from: package-private */
    public PopLayerViewContainer getPopLayerContainer() {
        return this.mPopLayerContainer;
    }

    /* access modifiers changed from: package-private */
    public void setPopLayerContainer(PopLayerViewContainer popLayerViewContainer) {
        this.mPopLayerContainer = popLayerViewContainer;
    }

    /* access modifiers changed from: package-private */
    public void startPreDrawListenerIfNeed() {
        if (!this.isBeginPreDrawListener) {
            this.mPopLayerContainer.showSandoContainer(true);
            ViewTreeObserver viewTreeObserver = eu2.e((Activity) getContext()).getViewTreeObserver();
            viewTreeObserver.removeOnPreDrawListener(this.mPreDrawLsn);
            viewTreeObserver.addOnPreDrawListener(this.mPreDrawLsn);
            cr1.b("SandoContainer.start preDraw listener.", new Object[0]);
            this.isBeginPreDrawListener = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void stopPreDrawListenerIfNeed() {
        if (this.isBeginPreDrawListener) {
            this.mPopLayerContainer.showSandoContainer(false);
            eu2.e((Activity) getContext()).getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawLsn);
            cr1.b("SandoContainer.stop preDraw listener.", new Object[0]);
            this.isBeginPreDrawListener = false;
        }
    }

    public SandoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public SandoContainer(Context context) {
        super(context);
        initialize(context);
    }
}
