package tb;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
public abstract class h1 {
    protected wv2 a;
    protected View b;

    public h1(wv2 wv2) {
        this.a = wv2;
    }

    public final void a(IDMComponent iDMComponent) {
        d(iDMComponent);
    }

    public final View b(@Nullable ViewGroup viewGroup) {
        View e = e(viewGroup);
        this.b = e;
        return e;
    }

    public final View c() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public abstract void d(@NonNull IDMComponent iDMComponent);

    /* access modifiers changed from: protected */
    public abstract View e(@Nullable ViewGroup viewGroup);
}
