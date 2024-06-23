package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.g;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
import tb.i5;
import tb.j5;
import tb.k5;
import tb.m5;

/* compiled from: Taobao */
public class a implements ContentModel {
    private final String a;
    private final GradientType b;
    private final j5 c;
    private final k5 d;
    private final m5 e;
    private final m5 f;
    private final i5 g;
    private final ShapeStroke.LineCapType h;
    private final ShapeStroke.LineJoinType i;
    private final float j;
    private final List<i5> k;
    @Nullable
    private final i5 l;
    private final boolean m;

    public a(String str, GradientType gradientType, j5 j5Var, k5 k5Var, m5 m5Var, m5 m5Var2, i5 i5Var, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<i5> list, @Nullable i5 i5Var2, boolean z) {
        this.a = str;
        this.b = gradientType;
        this.c = j5Var;
        this.d = k5Var;
        this.e = m5Var;
        this.f = m5Var2;
        this.g = i5Var;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f2;
        this.k = list;
        this.l = i5Var2;
        this.m = z;
    }

    public ShapeStroke.LineCapType a() {
        return this.h;
    }

    @Nullable
    public i5 b() {
        return this.l;
    }

    public m5 c() {
        return this.f;
    }

    public j5 d() {
        return this.c;
    }

    public GradientType e() {
        return this.b;
    }

    public ShapeStroke.LineJoinType f() {
        return this.i;
    }

    public List<i5> g() {
        return this.k;
    }

    public float h() {
        return this.j;
    }

    public String i() {
        return this.a;
    }

    public k5 j() {
        return this.d;
    }

    public m5 k() {
        return this.e;
    }

    public i5 l() {
        return this.g;
    }

    public boolean m() {
        return this.m;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        return new g(lottieDrawable, aVar, this);
    }
}
