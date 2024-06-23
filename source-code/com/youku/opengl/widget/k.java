package com.youku.opengl.widget;

import com.youku.media.b;
import com.youku.opengl.filter.f;
import java.nio.FloatBuffer;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public class k extends f {
    private b d;
    private n e;

    private String b(int i, int i2) {
        return "No." + i + AltriaXLaunchTime.SPACE + i2;
    }

    private String d(int i) {
        return "No." + i;
    }

    private String e(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        return sb.toString();
    }

    @Override // com.youku.opengl.filter.b, com.youku.opengl.filter.f
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        b bVar = this.d;
        int i2 = -1;
        int c = bVar != null ? bVar.c() : -1;
        n nVar = this.e;
        if (nVar != null) {
            i2 = nVar.k();
        }
        a((i2 < 0 || c < 0) ? i2 >= 0 ? d(i2) : c >= 0 ? e(c) : "no pts" : b(i2, c));
        super.a(i, floatBuffer, floatBuffer2);
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a(n nVar) {
        this.e = nVar;
    }
}
