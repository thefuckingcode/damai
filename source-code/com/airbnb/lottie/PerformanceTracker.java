package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tb.zb1;

/* compiled from: Taobao */
public class PerformanceTracker {
    private boolean a = false;
    private final Set<FrameListener> b = new ArraySet();
    private final Map<String, zb1> c = new HashMap();

    /* compiled from: Taobao */
    public interface FrameListener {
        void onFrameRendered(float f);
    }

    /* compiled from: Taobao */
    class a implements Comparator<Pair<String, Float>> {
        a(PerformanceTracker performanceTracker) {
        }

        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    public PerformanceTracker() {
        new a(this);
    }

    public void a(String str, float f) {
        if (this.a) {
            zb1 zb1 = this.c.get(str);
            if (zb1 == null) {
                zb1 = new zb1();
                this.c.put(str, zb1);
            }
            zb1.a(f);
            if (str.equals("__container")) {
                for (FrameListener frameListener : this.b) {
                    frameListener.onFrameRendered(f);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        this.a = z;
    }
}
