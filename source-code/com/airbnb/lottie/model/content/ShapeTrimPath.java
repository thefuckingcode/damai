package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.n;
import com.airbnb.lottie.model.layer.a;
import tb.i5;

/* compiled from: Taobao */
public class ShapeTrimPath implements ContentModel {
    private final String a;
    private final Type b;
    private final i5 c;
    private final i5 d;
    private final i5 e;
    private final boolean f;

    /* compiled from: Taobao */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, i5 i5Var, i5 i5Var2, i5 i5Var3, boolean z) {
        this.a = str;
        this.b = type;
        this.c = i5Var;
        this.d = i5Var2;
        this.e = i5Var3;
        this.f = z;
    }

    public i5 a() {
        return this.d;
    }

    public String b() {
        return this.a;
    }

    public i5 c() {
        return this.e;
    }

    public i5 d() {
        return this.c;
    }

    public Type e() {
        return this.b;
    }

    public boolean f() {
        return this.f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new n(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
