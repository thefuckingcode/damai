package com.alibaba.aliweex.adapter.adapter;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.DrawableStrategy;
import com.taobao.weex.adapter.IDrawableLoader;
import tb.tp1;
import tb.ug2;
import tb.vp1;

/* compiled from: Taobao */
public class PhenixBasedDrawableLoader implements IDrawableLoader {

    /* compiled from: Taobao */
    private static class a implements IPhenixListener<ug2> {
        private IDrawableLoader.DrawableTarget a;

        a(IDrawableLoader.DrawableTarget drawableTarget) {
            this.a = drawableTarget;
        }

        /* renamed from: a */
        public boolean onHappen(ug2 ug2) {
            BitmapDrawable f = ug2.f();
            if (f != null && !ug2.i()) {
                f.setGravity(119);
                IDrawableLoader.DrawableTarget drawableTarget = this.a;
                if (drawableTarget instanceof IDrawableLoader.StaticTarget) {
                    ((IDrawableLoader.StaticTarget) drawableTarget).setDrawable(f, true);
                }
            }
            return true;
        }
    }

    @Override // com.taobao.weex.adapter.IDrawableLoader
    public void setDrawable(final String str, final IDrawableLoader.DrawableTarget drawableTarget, final DrawableStrategy drawableStrategy) {
        try {
            WXSDKManager.v().N(new Runnable() {
                /* class com.alibaba.aliweex.adapter.adapter.PhenixBasedDrawableLoader.AnonymousClass1 */

                public void run() {
                    if (drawableTarget != null) {
                        if (TextUtils.isEmpty(str)) {
                            IDrawableLoader.DrawableTarget drawableTarget = drawableTarget;
                            if (drawableTarget instanceof IDrawableLoader.StaticTarget) {
                                ((IDrawableLoader.StaticTarget) drawableTarget).setDrawable(null, false);
                                return;
                            }
                        }
                        vp1 s = tp1.o().s(str);
                        DrawableStrategy drawableStrategy = drawableStrategy;
                        s.B(null, drawableStrategy.width, drawableStrategy.height).F(true).Q(new a(drawableTarget)).n();
                    }
                }
            }, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
