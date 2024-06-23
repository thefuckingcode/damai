package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import tb.xt2;

/* compiled from: Taobao */
public class b {
    private List<n> a = new ArrayList();

    /* access modifiers changed from: package-private */
    public void a(n nVar) {
        this.a.add(nVar);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            xt2.b(path, this.a.get(size));
        }
    }
}
