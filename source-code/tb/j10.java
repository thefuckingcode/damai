package tb;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.videoc.IDXVideoControlCenter;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.impl.DXVideoController;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import tb.sx1;

/* compiled from: Taobao */
public class j10 implements IDXVideoControlCenter {
    private final DXVideoControlConfig<xv2> a;
    private final Map<RecyclerView, Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>>> b = new WeakHashMap();

    public j10(@NonNull DXVideoControlConfig<xv2> dXVideoControlConfig) {
        this.a = dXVideoControlConfig;
    }

    private IExposureEngine<?, ?> a(@NonNull RecyclerView recyclerView) {
        Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>> pair = this.b.get(recyclerView);
        if (pair == null) {
            return null;
        }
        return (IExposureEngine) pair.first;
    }

    private IDXVideoController<?, ?> b(@NonNull RecyclerView recyclerView) {
        Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>> pair = this.b.get(recyclerView);
        if (pair == null) {
            return null;
        }
        return (IDXVideoController) pair.second;
    }

    private void c(RecyclerView recyclerView, DXVideoControlConfig<xv2> dXVideoControlConfig) {
        m10 m10 = new m10(dXVideoControlConfig.o());
        Comparator<xv2> p = dXVideoControlConfig.p();
        if (p == null) {
            p = new n10();
        }
        boolean z = true;
        if (dXVideoControlConfig.n() != 1) {
            z = false;
        }
        DXVideoController dXVideoController = new DXVideoController(recyclerView, new q10(m10, p, z, dXVideoControlConfig.t()), new p10(dXVideoControlConfig.l()));
        sx1.b bVar = new sx1.b(recyclerView, new vz(dXVideoController, dXVideoControlConfig.s(), dXVideoControlConfig.r(), dXVideoControlConfig.u()));
        for (String str : dXVideoController.scenes()) {
            bVar.d(new l10(dXVideoController, dXVideoControlConfig.q(), dXVideoControlConfig.u()), dXVideoControlConfig.m(), str);
        }
        this.b.put(recyclerView, new Pair<>(bVar.a(), dXVideoController));
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView) {
        clearVideoQueue(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void destroy() {
        for (Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>> pair : this.b.values()) {
            ((IExposureEngine) pair.first).stop();
        }
        this.b.clear();
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView) {
        makeVideoControl(recyclerView, this.a);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView) {
        start(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView) {
        startAtOnce(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView) {
        stop(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView) {
        stop(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView) {
        triggerPlayControl(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public int triggerPlayControlAtOnce(@NonNull RecyclerView recyclerView, @NonNull String str) {
        IExposureEngine<?, ?> a2 = a(recyclerView);
        IDXVideoController<?, ?> b2 = b(recyclerView);
        if (a2 == null || b2 == null) {
            return -1;
        }
        a2.triggerExposeAtOnce(str);
        return b2.getVideos(str).size();
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IDXVideoController<?, ?> b2 = b(recyclerView);
        if (b2 != null) {
            if (str == null) {
                b2.clearVideos();
            } else {
                b2.clearVideos(str);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<xv2> dXVideoControlConfig) {
        makeVideoControl(recyclerView, dXVideoControlConfig, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a2 = a(recyclerView);
        if (a2 != null) {
            a2.start(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a2 = a(recyclerView);
        if (a2 != null) {
            if (str == null) {
                a2.runZone();
            } else {
                a2.runZone(str);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a2 = a(recyclerView);
        if (a2 != null) {
            a2.stop(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a2 = a(recyclerView);
        if (a2 != null) {
            if (str == null) {
                a2.stopZone();
            } else {
                a2.stopZone(str);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a2 = a(recyclerView);
        if (a2 != null) {
            if (str == null) {
                a2.triggerExpose();
            } else {
                a2.triggerExpose(str);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<xv2> dXVideoControlConfig, @Nullable String str) {
        if (!this.b.containsKey(recyclerView)) {
            if (str != null) {
                if (dXVideoControlConfig == this.a) {
                    dXVideoControlConfig = DXVideoControlConfig.j();
                }
                dXVideoControlConfig.v(str);
            }
            c(recyclerView, dXVideoControlConfig);
        }
    }
}
