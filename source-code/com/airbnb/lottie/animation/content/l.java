package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import java.util.List;
import tb.m92;
import tb.p92;

/* compiled from: Taobao */
public class l implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final Path a = new Path();
    private final String b;
    private final boolean c;
    private final LottieDrawable d;
    private final BaseKeyframeAnimation<?, Path> e;
    private boolean f;
    private b g = new b();

    public l(LottieDrawable lottieDrawable, a aVar, p92 p92) {
        this.b = p92.a();
        this.c = p92.c();
        this.d = lottieDrawable;
        BaseKeyframeAnimation<m92, Path> createAnimation = p92.b().createAnimation();
        this.e = createAnimation;
        aVar.c(createAnimation);
        createAnimation.a(this);
    }

    private void a() {
        this.f = false;
        this.d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.f) {
            return this.a;
        }
        this.a.reset();
        if (this.c) {
            this.f = true;
            return this.a;
        }
        this.a.set(this.e.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.g.b(this.a);
        this.f = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof n) {
                n nVar = (n) content;
                if (nVar.e() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(nVar);
                    nVar.a(this);
                }
            }
        }
    }
}
