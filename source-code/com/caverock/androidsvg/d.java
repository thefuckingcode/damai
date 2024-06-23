package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

/* compiled from: Taobao */
public class d {
    CSSParser.m a = null;
    PreserveAspectRatio b = null;
    String c = null;
    SVG.b d = null;
    String e = null;
    SVG.b f = null;

    public d() {
    }

    public d a(String str) {
        this.a = new CSSParser(CSSParser.Source.RenderOptions).d(str);
        return this;
    }

    public boolean b() {
        CSSParser.m mVar = this.a;
        return mVar != null && mVar.f() > 0;
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public d h(float f2, float f3, float f4, float f5) {
        this.f = new SVG.b(f2, f3, f4, f5);
        return this;
    }

    public d(d dVar) {
        if (dVar != null) {
            this.a = dVar.a;
            this.b = dVar.b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
        }
    }
}
