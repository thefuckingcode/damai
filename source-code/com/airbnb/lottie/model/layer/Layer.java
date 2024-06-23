package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.a;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import tb.b61;
import tb.i5;
import tb.q5;
import tb.r5;
import tb.s5;

/* compiled from: Taobao */
public class Layer {
    private final List<ContentModel> a;
    private final a b;
    private final String c;
    private final long d;
    private final LayerType e;
    private final long f;
    @Nullable
    private final String g;
    private final List<Mask> h;
    private final s5 i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    @Nullable
    private final q5 q;
    @Nullable
    private final r5 r;
    @Nullable
    private final i5 s;
    private final List<b61<Float>> t;
    private final MatteType u;
    private final boolean v;

    /* compiled from: Taobao */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: Taobao */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, a aVar, String str, long j2, LayerType layerType, long j3, @Nullable String str2, List<Mask> list2, s5 s5Var, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable q5 q5Var, @Nullable r5 r5Var, List<b61<Float>> list3, MatteType matteType, @Nullable i5 i5Var, boolean z) {
        this.a = list;
        this.b = aVar;
        this.c = str;
        this.d = j2;
        this.e = layerType;
        this.f = j3;
        this.g = str2;
        this.h = list2;
        this.i = s5Var;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = q5Var;
        this.r = r5Var;
        this.t = list3;
        this.u = matteType;
        this.s = i5Var;
        this.v = z;
    }

    /* access modifiers changed from: package-private */
    public a a() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public List<b61<Float>> c() {
        return this.t;
    }

    public LayerType d() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public List<Mask> e() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public MatteType f() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public long h() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String k() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public List<ContentModel> l() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public float p() {
        return this.n / this.b.e();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public q5 q() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public r5 r() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public i5 s() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    /* access modifiers changed from: package-private */
    public s5 u() {
        return this.i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append(StringUtils.LF);
        Layer s2 = this.b.s(h());
        if (s2 != null) {
            sb.append("\t\tParents: ");
            sb.append(s2.g());
            Layer s3 = this.b.s(s2.h());
            while (s3 != null) {
                sb.append("->");
                sb.append(s3.g());
                s3 = this.b.s(s3.h());
            }
            sb.append(str);
            sb.append(StringUtils.LF);
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append(StringUtils.LF);
        }
        if (!(o() == 0 || n() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel contentModel : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }
}
