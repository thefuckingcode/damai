package tb;

import android.view.View;
import com.alibaba.gaiax.render.node.GXNodeTreeUpdate;
import com.alibaba.gaiax.render.view.GXIRootView;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class gq0 {
    public final void a(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        wq0.v(false);
        new GXNodeTreeUpdate(wq0).a();
    }

    public final void b(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        wq0.v(false);
        new GXNodeTreeUpdate(wq0).b();
    }

    public final void c(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        up0 g = wq0.g();
        if (g != null) {
            new hr0(wq0, g).a();
            new GXNodeTreeUpdate(wq0).c();
            return;
        }
        throw new IllegalArgumentException(k21.r("RootNode is null(bindViewDataOnlyViewTree) gxTemplateContext = ", wq0));
    }

    @NotNull
    public final up0 d(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        up0 a = zp0.INSTANCE.a(wq0);
        wq0.z(a);
        return a;
    }

    @NotNull
    public final up0 e(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        up0 a = zp0.INSTANCE.a(wq0);
        wq0.z(a);
        return a;
    }

    @NotNull
    public final View f(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        up0 g = wq0.g();
        if (g != null) {
            View a = new fr0(wq0, g).a();
            ((GXIRootView) a).setTemplateContext(wq0);
            wq0.A(a);
            View h = wq0.h();
            if (h != null) {
                return h;
            }
            throw new IllegalArgumentException(k21.r("Create template view exception, gxTemplateContext = ", wq0));
        }
        throw new IllegalArgumentException(k21.r("Create template view exception, root node null, ", wq0));
    }
}
