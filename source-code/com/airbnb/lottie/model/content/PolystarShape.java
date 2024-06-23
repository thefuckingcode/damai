package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.i;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.a;
import tb.i5;

/* compiled from: Taobao */
public class PolystarShape implements ContentModel {
    private final String a;
    private final Type b;
    private final i5 c;
    private final AnimatableValue<PointF, PointF> d;
    private final i5 e;
    private final i5 f;
    private final i5 g;
    private final i5 h;
    private final i5 i;
    private final boolean j;

    /* compiled from: Taobao */
    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values = values();
            for (Type type : values) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, i5 i5Var, AnimatableValue<PointF, PointF> animatableValue, i5 i5Var2, i5 i5Var3, i5 i5Var4, i5 i5Var5, i5 i5Var6, boolean z) {
        this.a = str;
        this.b = type;
        this.c = i5Var;
        this.d = animatableValue;
        this.e = i5Var2;
        this.f = i5Var3;
        this.g = i5Var4;
        this.h = i5Var5;
        this.i = i5Var6;
        this.j = z;
    }

    public i5 a() {
        return this.f;
    }

    public i5 b() {
        return this.h;
    }

    public String c() {
        return this.a;
    }

    public i5 d() {
        return this.g;
    }

    public i5 e() {
        return this.i;
    }

    public i5 f() {
        return this.c;
    }

    public AnimatableValue<PointF, PointF> g() {
        return this.d;
    }

    public i5 h() {
        return this.e;
    }

    public Type i() {
        return this.b;
    }

    public boolean j() {
        return this.j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new i(lottieDrawable, aVar, this);
    }
}
