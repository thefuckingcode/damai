package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class f {
    private SVG a;
    private float b;
    private Picture c;
    private Map<String, SVG.a0> d;
    private List<g> e;
    private List<CSSParser.k> f;

    /* compiled from: Taobao */
    public static class a extends g {
    }

    /* compiled from: Taobao */
    public static class b extends g {
    }

    /* compiled from: Taobao */
    public static class c extends g {
        private Path c;

        public Path e() {
            return this.c;
        }

        public void f(Path path) {
            this.c = path;
        }
    }

    /* compiled from: Taobao */
    public static class d extends g {
        private float[] c;

        public float[] e() {
            return this.c;
        }

        public void f(float[] fArr) {
            this.c = fArr;
        }
    }

    /* compiled from: Taobao */
    public static class e extends d {
    }

    /* renamed from: com.caverock.androidsvg.f$f  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0150f extends g {
    }

    /* compiled from: Taobao */
    public static class g {
        private String a;
        private RectF b;

        public RectF a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }

        public void c(RectF rectF) {
            this.b = rectF;
        }

        public void d(String str) {
            this.a = str;
        }
    }

    public f(SVG svg) {
        SVG.w l;
        List<SVG.c0> children;
        this.a = svg;
        if (svg != null && svg.l() != null && (children = (l = this.a.l()).getChildren()) != null && !children.isEmpty()) {
            this.d = new HashMap((int) (((float) children.size()) / 0.75f));
            t(l);
            this.c = f();
            d();
            this.f = new ArrayList();
            List<CSSParser.k> k = k();
            if (k != null && !k.isEmpty()) {
                this.f.addAll(k);
            }
        }
    }

    private g b(SVG.d dVar) {
        if (dVar.h == null) {
            return null;
        }
        a aVar = new a();
        RectF rectF = new RectF();
        SVG.b bVar = dVar.h;
        float f2 = bVar.a;
        float f3 = bVar.b;
        rectF.set(f2, f3, bVar.c + f2, bVar.d + f3);
        p(rectF, dVar.n);
        aVar.d(dVar.c);
        aVar.c(rectF);
        return aVar;
    }

    private g c(SVG.g gVar) {
        if (gVar.h == null) {
            return null;
        }
        b bVar = new b();
        RectF rectF = new RectF();
        SVG.b bVar2 = gVar.h;
        float f2 = bVar2.a;
        float f3 = bVar2.b;
        rectF.set(f2, f3, bVar2.c + f2, bVar2.d + f3);
        p(rectF, gVar.n);
        bVar.d(gVar.c);
        bVar.c(rectF);
        return bVar;
    }

    private void d() {
        Map<String, SVG.a0> map;
        if (!(this.a == null || (map = this.d) == null || map.isEmpty())) {
            List<g> list = this.e;
            if (list == null) {
                this.e = new ArrayList();
            } else {
                list.clear();
            }
            for (Map.Entry<String, SVG.a0> entry : this.d.entrySet()) {
                SVG.a0 value = entry.getValue();
                if (value instanceof SVG.t) {
                    this.e.add(i((SVG.t) value));
                }
                if (value instanceof SVG.d) {
                    this.e.add(b((SVG.d) value));
                }
                if (value instanceof SVG.g) {
                    this.e.add(c((SVG.g) value));
                }
                if (value instanceof SVG.o) {
                    this.e.add(e((SVG.o) value));
                }
                if (value instanceof SVG.s) {
                    this.e.add(h((SVG.s) value));
                }
                if (value instanceof SVG.r) {
                    this.e.add(g((SVG.r) value));
                }
            }
        }
    }

    private g e(SVG.o oVar) {
        if (oVar.h == null) {
            return null;
        }
        c cVar = new c();
        RectF rectF = new RectF();
        SVG.b bVar = oVar.h;
        float f2 = bVar.a;
        float f3 = bVar.b;
        rectF.set(f2, f3, bVar.c + f2, bVar.d + f3);
        p(rectF, oVar.n);
        cVar.d(oVar.c);
        cVar.c(rectF);
        cVar.f(new e.d(oVar.o).a());
        return cVar;
    }

    private Picture f() {
        return this.a.o(new d());
    }

    private g g(SVG.r rVar) {
        if (rVar.h == null) {
            return null;
        }
        d dVar = new d();
        RectF rectF = new RectF();
        SVG.b bVar = rVar.h;
        float f2 = bVar.a;
        float f3 = bVar.b;
        rectF.set(f2, f3, bVar.c + f2, bVar.d + f3);
        dVar.c(p(rectF, rVar.n));
        dVar.f(q(rVar.o, rVar.n));
        dVar.d(rVar.c);
        return dVar;
    }

    private g h(SVG.s sVar) {
        if (sVar.h == null) {
            return null;
        }
        e eVar = new e();
        RectF rectF = new RectF();
        SVG.b bVar = sVar.h;
        float f2 = bVar.a;
        float f3 = bVar.b;
        rectF.set(f2, f3, bVar.c + f2, bVar.d + f3);
        eVar.c(p(rectF, sVar.n));
        eVar.f(q(sVar.o, sVar.n));
        eVar.d(sVar.c);
        return eVar;
    }

    private g i(SVG.t tVar) {
        if (tVar.h == null) {
            return null;
        }
        C0150f fVar = new C0150f();
        RectF rectF = new RectF();
        SVG.b bVar = tVar.h;
        float f2 = bVar.a;
        float f3 = bVar.b;
        rectF.set(f2, f3, bVar.c + f2, bVar.d + f3);
        p(rectF, tVar.n);
        fVar.d(tVar.c);
        fVar.c(rectF);
        return fVar;
    }

    private void j() {
        SVG svg = this.a;
        if (svg != null) {
            svg.b();
        }
    }

    private List<CSSParser.k> k() {
        SVG svg = this.a;
        if (svg != null) {
            return svg.d();
        }
        return null;
    }

    private RectF p(RectF rectF, @Nullable Matrix matrix) {
        if (matrix != null) {
            try {
                matrix.mapRect(rectF);
                return rectF;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return rectF;
    }

    private float[] q(float[] fArr, @Nullable Matrix matrix) {
        if (!(matrix == null || fArr == null)) {
            try {
                if (fArr.length > 0) {
                    float[] fArr2 = new float[fArr.length];
                    for (int i = 0; i < fArr.length; i++) {
                        fArr2[i] = fArr[i];
                    }
                    matrix.mapPoints(fArr2);
                    return fArr2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return fArr;
    }

    private void t(SVG.SvgContainer svgContainer) {
        if (svgContainer != null) {
            SVG.a0 a0Var = (SVG.a0) svgContainer;
            if (!TextUtils.isEmpty(a0Var.c)) {
                this.d.put(a0Var.c, a0Var);
            }
            List<SVG.c0> children = svgContainer.getChildren();
            if (!(children == null || children.isEmpty())) {
                for (int i = 0; i < children.size(); i++) {
                    SVG.c0 c0Var = children.get(i);
                    if (c0Var instanceof SVG.a0) {
                        SVG.a0 a0Var2 = (SVG.a0) c0Var;
                        if (!TextUtils.isEmpty(a0Var2.c)) {
                            this.d.put(a0Var2.c, a0Var2);
                        }
                        if (c0Var instanceof SVG.SvgContainer) {
                            t((SVG.SvgContainer) c0Var);
                        }
                    }
                }
            }
        }
    }

    public void a(List<CSSParser.k> list) {
        if (list != null) {
            CSSParser.m mVar = new CSSParser.m();
            for (CSSParser.k kVar : list) {
                mVar.a(kVar);
            }
            SVG svg = this.a;
            if (svg != null) {
                svg.a(mVar);
            }
        }
    }

    public List<g> l() {
        return this.e;
    }

    public Picture m() {
        return this.c;
    }

    public Set<String> n() {
        Map<String, SVG.a0> map = this.d;
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    public float o() {
        return this.b;
    }

    public Picture r(d dVar) {
        SVG svg = this.a;
        if (svg != null) {
            return svg.o(dVar);
        }
        return null;
    }

    public void s() {
        j();
        a(this.f);
    }

    public void u(float f2) {
        this.b = f2;
    }
}
