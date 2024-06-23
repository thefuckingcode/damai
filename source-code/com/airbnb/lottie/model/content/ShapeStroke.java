package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.m;
import java.util.List;
import tb.h5;
import tb.i5;
import tb.k5;

/* compiled from: Taobao */
public class ShapeStroke implements ContentModel {
    private final String a;
    @Nullable
    private final i5 b;
    private final List<i5> c;
    private final h5 d;
    private final k5 e;
    private final i5 f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;
    private final boolean j;

    /* compiled from: Taobao */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = a.a[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* compiled from: Taobao */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = a.b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            int[] iArr = new int[LineJoinType.values().length];
            b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            a = iArr2;
            iArr2[LineCapType.BUTT.ordinal()] = 1;
            a[LineCapType.ROUND.ordinal()] = 2;
            a[LineCapType.UNKNOWN.ordinal()] = 3;
        }
    }

    public ShapeStroke(String str, @Nullable i5 i5Var, List<i5> list, h5 h5Var, k5 k5Var, i5 i5Var2, LineCapType lineCapType, LineJoinType lineJoinType, float f2, boolean z) {
        this.a = str;
        this.b = i5Var;
        this.c = list;
        this.d = h5Var;
        this.e = k5Var;
        this.f = i5Var2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f2;
        this.j = z;
    }

    public LineCapType a() {
        return this.g;
    }

    public h5 b() {
        return this.d;
    }

    public i5 c() {
        return this.b;
    }

    public LineJoinType d() {
        return this.h;
    }

    public List<i5> e() {
        return this.c;
    }

    public float f() {
        return this.i;
    }

    public String g() {
        return this.a;
    }

    public k5 h() {
        return this.e;
    }

    public i5 i() {
        return this.f;
    }

    public boolean j() {
        return this.j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        return new m(lottieDrawable, aVar, this);
    }
}
