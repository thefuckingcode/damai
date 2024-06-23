package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.videoc.IDXVideoControlCenter;

/* compiled from: Taobao */
public class k10 implements IDXVideoControlCenter {
    private IDXVideoControlCenter a;
    private DXVideoControlConfig<xv2> b;

    public k10(@NonNull DXVideoControlConfig<xv2> dXVideoControlConfig) {
        this.b = dXVideoControlConfig;
    }

    public void a() {
        if (this.a == null) {
            DXVideoControlConfig<xv2> dXVideoControlConfig = this.b;
            if (dXVideoControlConfig == null) {
                dXVideoControlConfig = DXVideoControlConfig.j();
            }
            this.a = new j10(dXVideoControlConfig);
        }
    }

    public boolean b() {
        return this.a != null && at.C0();
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView) {
        if (this.a != null && at.C0()) {
            this.a.clearVideoQueue(recyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void destroy() {
        if (this.a != null && at.C0()) {
            this.a.destroy();
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView) {
        if (this.a != null && at.C0()) {
            this.a.makeVideoControl(recyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView) {
        if (this.a != null && at.C0()) {
            this.a.start(recyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a != null && at.C0()) {
            this.a.startAtOnce(recyclerView, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView) {
        if (this.a != null && at.C0()) {
            this.a.stop(recyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView) {
        if (this.a != null && at.C0()) {
            this.a.stopAtOnce(recyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView) {
        if (this.a != null && at.C0()) {
            this.a.triggerPlayControl(recyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public int triggerPlayControlAtOnce(@NonNull RecyclerView recyclerView, @NonNull String str) {
        if (this.a == null || !at.C0()) {
            return -1;
        }
        return this.a.triggerPlayControlAtOnce(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a != null && at.C0()) {
            this.a.clearVideoQueue(recyclerView, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<xv2> dXVideoControlConfig) {
        if (this.a != null && at.C0()) {
            this.a.makeVideoControl(recyclerView, dXVideoControlConfig);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a != null && at.C0()) {
            this.a.start(recyclerView, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView) {
        if (this.a != null && at.C0()) {
            this.a.startAtOnce(recyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a != null && at.C0()) {
            this.a.stop(recyclerView, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a != null && at.C0()) {
            this.a.stopAtOnce(recyclerView, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a != null && at.C0()) {
            this.a.triggerPlayControl(recyclerView, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<xv2> dXVideoControlConfig, @NonNull String str) {
        if (this.a != null && at.C0()) {
            this.a.makeVideoControl(recyclerView, dXVideoControlConfig, str);
        }
    }
}
