package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.a;

/* compiled from: Taobao */
public class qb extends a implements PlatformManager.ScrollListener {
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;

    public qb(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
    }

    private boolean l(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i <= 0 || i2 <= 0) {
            return i < 0 && i2 < 0;
        }
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        PlatformManager.IScrollFactory f = this.h.f();
        if (f == null) {
            return false;
        }
        f.addScrollListenerWith(str, this);
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.a, com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        PlatformManager.IScrollFactory f = this.h.f();
        if (f == null) {
            return false;
        }
        f.removeScrollListenerWith(str, this);
        return super.onDisable(str, str2);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.ScrollListener
    public void onScrollEnd(float f, float f2) {
        super.i("scrollEnd", (double) f, (double) f2, 0.0d, 0.0d, 0.0d, 0.0d, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.ScrollListener
    public void onScrollStart() {
        super.i("scrollStart", 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.ScrollListener
    public void onScrolled(float f, float f2) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = (int) (f - ((float) this.n));
        int i6 = (int) (f2 - ((float) this.o));
        this.n = (int) f;
        this.o = (int) f2;
        if (i5 != 0 || i6 != 0) {
            boolean z2 = true;
            if (!l(i6, this.t)) {
                this.r = this.o;
                z = true;
            } else {
                z = false;
            }
            if (!l(i5, this.s)) {
                this.q = this.n;
            } else {
                z2 = z;
            }
            int i7 = this.n;
            int i8 = i7 - this.q;
            int i9 = this.o;
            int i10 = i9 - this.r;
            this.s = i5;
            this.t = i6;
            if (z2) {
                i4 = i6;
                i3 = i5;
                i2 = i10;
                i = i8;
                super.i("turn", (double) i7, (double) i9, (double) i5, (double) i6, (double) i8, (double) i10, new Object[0]);
            } else {
                i2 = i10;
                i4 = i6;
                i = i8;
                i3 = i5;
            }
            super.j(this.n, this.o, i3, i4, i, i2);
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }
}
