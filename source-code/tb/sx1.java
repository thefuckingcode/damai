package tb;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZone;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner;
import com.taobao.android.dinamicx.videoc.expose.core.a;
import com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class sx1<ExposeKey, ExposeData> extends com.taobao.android.dinamicx.videoc.expose.core.a<ExposeKey, ExposeData> {
    private final RecyclerView b;
    private sx1<ExposeKey, ExposeData>.c c;
    private final Set<String> d = new HashSet();

    /* compiled from: Taobao */
    public static class b<ExposeKey, ExposeData> extends a.AbstractC0207a<ExposeKey, ExposeData, AbstractExposure.a<ExposeData>> {
        private final RecyclerView e;

        public b(@NonNull RecyclerView recyclerView, @NonNull RecyclerViewZone.OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback) {
            this(recyclerView, onRecyclerViewExposeCallback, new q40());
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.android.dinamicx.videoc.expose.core.a.AbstractC0207a
        @NonNull
        public IExposureEngine<ExposeKey, ExposeData> b(@NonNull IExposureZoneRunner<ExposeKey, ExposeData> iExposureZoneRunner, @NonNull Collection<IExposureZone<ExposeKey, ExposeData>> collection) {
            return new sx1(this.e, iExposureZoneRunner);
        }

        public b(@NonNull RecyclerView recyclerView, @NonNull RecyclerViewZone.OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback, @Nullable IExposureCenter<ExposeKey, ExposeData, AbstractExposure.a<ExposeData>> iExposureCenter) {
            super(new RecyclerViewZone.a(recyclerView).c(onRecyclerViewExposeCallback), iExposureCenter);
            this.e = recyclerView;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c implements View.OnAttachStateChangeListener {
        private c() {
        }

        public void onViewAttachedToWindow(View view) {
            for (String str : sx1.this.d) {
                ((com.taobao.android.dinamicx.videoc.expose.core.a) sx1.this).a.runZone(str);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            ((com.taobao.android.dinamicx.videoc.expose.core.a) sx1.this).a.stopZone();
        }
    }

    public sx1(RecyclerView recyclerView, IExposureZoneRunner<ExposeKey, ExposeData> iExposureZoneRunner) {
        super(iExposureZoneRunner);
        this.b = recyclerView;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void start() {
        start(null);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void stop() {
        stop(null);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void start(@Nullable String str) {
        if (str == null) {
            for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.zones()) {
                this.d.add(iExposureZone.key());
            }
        } else {
            this.d.add(str);
        }
        if (this.c == null) {
            sx1<ExposeKey, ExposeData>.c cVar = new c();
            this.c = cVar;
            this.b.addOnAttachStateChangeListener(cVar);
        } else if (str == null) {
            this.a.runZone();
        } else {
            this.a.runZone(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.a, com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void stop(@Nullable String str) {
        super.stop(str);
        if (str == null) {
            this.d.clear();
        } else {
            this.d.remove(str);
        }
        if (this.c != null && this.d.isEmpty()) {
            this.b.removeOnAttachStateChangeListener(this.c);
        }
    }
}
