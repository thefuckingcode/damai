package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.l;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.DocumentData;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;
import tb.h5;
import tb.i5;
import tb.o92;
import tb.pa1;
import tb.r5;
import tb.um0;
import tb.xt2;
import tb.zm0;

/* compiled from: Taobao */
public class g extends a {
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();
    private final Paint C = new a(this, 1);
    private final Paint D = new b(this, 1);
    private final Map<zm0, List<com.airbnb.lottie.animation.content.c>> E = new HashMap();
    private final LongSparseArray<String> F = new LongSparseArray<>();
    private final l G;
    private final LottieDrawable H;
    private final com.airbnb.lottie.a I;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> J;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> K;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> L;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> M;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> N;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> O;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> P;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> Q;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> R;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> S;
    private final StringBuilder z = new StringBuilder(2);

    /* compiled from: Taobao */
    class a extends Paint {
        a(g gVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: Taobao */
    class b extends Paint {
        b(g gVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            a = iArr;
            iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            try {
                a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    g(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        i5 i5Var;
        i5 i5Var2;
        h5 h5Var;
        h5 h5Var2;
        this.H = lottieDrawable;
        this.I = layer.a();
        l a2 = layer.q().createAnimation();
        this.G = a2;
        a2.a(this);
        c(a2);
        r5 r = layer.r();
        if (!(r == null || (h5Var2 = r.a) == null)) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation = h5Var2.createAnimation();
            this.J = createAnimation;
            createAnimation.a(this);
            c(this.J);
        }
        if (!(r == null || (h5Var = r.b) == null)) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = h5Var.createAnimation();
            this.L = createAnimation2;
            createAnimation2.a(this);
            c(this.L);
        }
        if (!(r == null || (i5Var2 = r.c) == null)) {
            BaseKeyframeAnimation<Float, Float> createAnimation3 = i5Var2.createAnimation();
            this.N = createAnimation3;
            createAnimation3.a(this);
            c(this.N);
        }
        if (r != null && (i5Var = r.d) != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = i5Var.createAnimation();
            this.P = createAnimation4;
            createAnimation4.a(this);
            c(this.P);
        }
    }

    private void E(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = c.a[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else if (i == 3) {
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    private String F(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!R(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = (long) codePointAt;
        if (this.F.containsKey(j)) {
            return this.F.get(j);
        }
        this.z.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.z.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.z.toString();
        this.F.put(j, sb);
        return sb;
    }

    private void G(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private void H(zm0 zm0, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<com.airbnb.lottie.animation.content.c> O2 = O(zm0);
        for (int i = 0; i < O2.size(); i++) {
            Path path = O2.get(i).getPath();
            path.computeBounds(this.A, false);
            this.B.set(matrix);
            this.B.preTranslate(0.0f, (-documentData.g) * xt2.e());
            this.B.preScale(f, f);
            path.transform(this.B);
            if (documentData.k) {
                K(path, this.C, canvas);
                K(path, this.D, canvas);
            } else {
                K(path, this.D, canvas);
                K(path, this.C, canvas);
            }
        }
    }

    private void I(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.k) {
            G(str, this.C, canvas);
            G(str, this.D, canvas);
            return;
        }
        G(str, this.D, canvas);
        G(str, this.C, canvas);
    }

    private void J(String str, DocumentData documentData, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String F2 = F(str, i);
            i += F2.length();
            I(F2, documentData, canvas);
            canvas.translate(this.C.measureText(F2) + f, 0.0f);
        }
    }

    private void K(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void L(String str, DocumentData documentData, Matrix matrix, um0 um0, Canvas canvas, float f, float f2) {
        float floatValue;
        for (int i = 0; i < str.length(); i++) {
            zm0 zm0 = this.I.c().get(zm0.c(str.charAt(i), um0.a(), um0.c()));
            if (zm0 != null) {
                H(zm0, matrix, f2, documentData, canvas);
                float b2 = ((float) zm0.b()) * f2 * xt2.e() * f;
                float f3 = ((float) documentData.e) / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.Q;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.h().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.P;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.h().floatValue();
                    }
                    canvas.translate(b2 + (f3 * f), 0.0f);
                }
                f3 += floatValue;
                canvas.translate(b2 + (f3 * f), 0.0f);
            }
        }
    }

    private void M(DocumentData documentData, Matrix matrix, um0 um0, Canvas canvas) {
        float f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.S;
        if (baseKeyframeAnimation != null) {
            f = baseKeyframeAnimation.h().floatValue();
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.R;
            if (baseKeyframeAnimation2 != null) {
                f = baseKeyframeAnimation2.h().floatValue();
            } else {
                f = documentData.c;
            }
        }
        float f2 = f / 100.0f;
        float g = xt2.g(matrix);
        String str = documentData.a;
        float e = documentData.f * xt2.e();
        List<String> Q2 = Q(str);
        int size = Q2.size();
        for (int i = 0; i < size; i++) {
            String str2 = Q2.get(i);
            float P2 = P(str2, um0, f2, g);
            canvas.save();
            E(documentData.d, canvas, P2);
            canvas.translate(0.0f, (((float) i) * e) - ((((float) (size - 1)) * e) / 2.0f));
            L(str2, documentData, matrix, um0, canvas, g, f2);
            canvas.restore();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a4 A[LOOP:0: B:18:0x00a2->B:19:0x00a4, LOOP_END] */
    private void N(DocumentData documentData, um0 um0, Matrix matrix, Canvas canvas) {
        float f;
        int size;
        int i;
        float floatValue;
        xt2.g(matrix);
        Typeface typeface = this.H.getTypeface(um0.a(), um0.c());
        if (typeface != null) {
            String str = documentData.a;
            this.H.getTextDelegate();
            this.C.setTypeface(typeface);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.S;
            if (baseKeyframeAnimation != null) {
                f = baseKeyframeAnimation.h().floatValue();
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.R;
                if (baseKeyframeAnimation2 != null) {
                    f = baseKeyframeAnimation2.h().floatValue();
                } else {
                    f = documentData.c;
                }
            }
            this.C.setTextSize(xt2.e() * f);
            this.D.setTypeface(this.C.getTypeface());
            this.D.setTextSize(this.C.getTextSize());
            float e = documentData.f * xt2.e();
            float f2 = ((float) documentData.e) / 10.0f;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.Q;
            if (baseKeyframeAnimation3 != null) {
                floatValue = baseKeyframeAnimation3.h().floatValue();
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.P;
                if (baseKeyframeAnimation4 != null) {
                    floatValue = baseKeyframeAnimation4.h().floatValue();
                }
                float e2 = ((f2 * xt2.e()) * f) / 100.0f;
                List<String> Q2 = Q(str);
                size = Q2.size();
                for (i = 0; i < size; i++) {
                    String str2 = Q2.get(i);
                    float measureText = this.D.measureText(str2) + (((float) (str2.length() - 1)) * e2);
                    canvas.save();
                    E(documentData.d, canvas, measureText);
                    canvas.translate(0.0f, (((float) i) * e) - ((((float) (size - 1)) * e) / 2.0f));
                    J(str2, documentData, canvas, e2);
                    canvas.restore();
                }
            }
            f2 += floatValue;
            float e22 = ((f2 * xt2.e()) * f) / 100.0f;
            List<String> Q22 = Q(str);
            size = Q22.size();
            while (i < size) {
            }
        }
    }

    private List<com.airbnb.lottie.animation.content.c> O(zm0 zm0) {
        if (this.E.containsKey(zm0)) {
            return this.E.get(zm0);
        }
        List<o92> a2 = zm0.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.animation.content.c(this.H, this, a2.get(i)));
        }
        this.E.put(zm0, arrayList);
        return arrayList;
    }

    private float P(String str, um0 um0, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            zm0 zm0 = this.I.c().get(zm0.c(str.charAt(i), um0.a(), um0.c()));
            if (zm0 != null) {
                f3 = (float) (((double) f3) + (zm0.b() * ((double) f) * ((double) xt2.e()) * ((double) f2)));
            }
        }
        return f3;
    }

    private List<String> Q(String str) {
        return Arrays.asList(str.replaceAll(SocketClient.NETASCII_EOL, StringUtils.CR).replaceAll(StringUtils.LF, StringUtils.CR).split(StringUtils.CR));
    }

    private boolean R(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        super.addValueCallback(t, pa1);
        if (t == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.K;
            if (baseKeyframeAnimation != null) {
                w(baseKeyframeAnimation);
            }
            if (pa1 == null) {
                this.K = null;
                return;
            }
            n nVar = new n(pa1);
            this.K = nVar;
            nVar.a(this);
            c(this.K);
        } else if (t == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.M;
            if (baseKeyframeAnimation2 != null) {
                w(baseKeyframeAnimation2);
            }
            if (pa1 == null) {
                this.M = null;
                return;
            }
            n nVar2 = new n(pa1);
            this.M = nVar2;
            nVar2.a(this);
            c(this.M);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.O;
            if (baseKeyframeAnimation3 != null) {
                w(baseKeyframeAnimation3);
            }
            if (pa1 == null) {
                this.O = null;
                return;
            }
            n nVar3 = new n(pa1);
            this.O = nVar3;
            nVar3.a(this);
            c(this.O);
        } else if (t == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.Q;
            if (baseKeyframeAnimation4 != null) {
                w(baseKeyframeAnimation4);
            }
            if (pa1 == null) {
                this.Q = null;
                return;
            }
            n nVar4 = new n(pa1);
            this.Q = nVar4;
            nVar4.a(this);
            c(this.Q);
        } else if (t == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.S;
            if (baseKeyframeAnimation5 != null) {
                w(baseKeyframeAnimation5);
            }
            if (pa1 == null) {
                this.S = null;
                return;
            }
            n nVar5 = new n(pa1);
            this.S = nVar5;
            nVar5.a(this);
            c(this.S);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z2) {
        super.getBounds(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, (float) Rect.width(this.I.b()), (float) Rect.height(this.I.b()));
    }

    /* access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.layer.a
    public void n(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.H.useTextGlyphs()) {
            canvas.concat(matrix);
        }
        DocumentData documentData = (DocumentData) this.G.h();
        um0 um0 = this.I.g().get(documentData.b);
        if (um0 == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.K;
        if (baseKeyframeAnimation != null) {
            this.C.setColor(baseKeyframeAnimation.h().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.J;
            if (baseKeyframeAnimation2 != null) {
                this.C.setColor(baseKeyframeAnimation2.h().intValue());
            } else {
                this.C.setColor(documentData.h);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.M;
        if (baseKeyframeAnimation3 != null) {
            this.D.setColor(baseKeyframeAnimation3.h().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.L;
            if (baseKeyframeAnimation4 != null) {
                this.D.setColor(baseKeyframeAnimation4.h().intValue());
            } else {
                this.D.setColor(documentData.i);
            }
        }
        int intValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.C.setAlpha(intValue);
        this.D.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.O;
        if (baseKeyframeAnimation5 != null) {
            this.D.setStrokeWidth(baseKeyframeAnimation5.h().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.N;
            if (baseKeyframeAnimation6 != null) {
                this.D.setStrokeWidth(baseKeyframeAnimation6.h().floatValue());
            } else {
                this.D.setStrokeWidth(documentData.j * xt2.e() * xt2.g(matrix));
            }
        }
        if (this.H.useTextGlyphs()) {
            M(documentData, matrix, um0, canvas);
        } else {
            N(documentData, um0, matrix, canvas);
        }
        canvas.restore();
    }
}
