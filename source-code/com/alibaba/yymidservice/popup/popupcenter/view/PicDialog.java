package com.alibaba.yymidservice.popup.popupcenter.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.iq1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\n"}, d2 = {"Lcom/alibaba/yymidservice/popup/popupcenter/view/PicDialog;", "Landroid/app/Dialog;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "", "themeResId", "(Landroid/content/Context;I)V", "OnDialogShowTimeListener", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PicDialog extends Dialog {
    @Nullable
    private OnDialogShowTimeListener a;
    private long b;
    private long c;
    @Nullable
    private Activity d;
    private boolean e;
    @NotNull
    private final iq1.b f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/yymidservice/popup/popupcenter/view/PicDialog$OnDialogShowTimeListener;", "", "", "mills", "Ltb/ur2;", "exposureTime", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    public static final class a extends iq1.b {
        final /* synthetic */ PicDialog a;

        a(PicDialog picDialog) {
            this.a = picDialog;
        }

        @Override // tb.iq1.b
        public boolean a(@NotNull Activity activity) {
            k21.i(activity, "activity");
            return this.a.d != null && this.a.d == activity;
        }

        @Override // tb.iq1.b
        public void b(@NotNull Activity activity) {
            k21.i(activity, "activity");
            if (this.a.e) {
                this.a.i(System.currentTimeMillis());
                this.a.d();
            }
        }

        @Override // tb.iq1.b
        public void c(@NotNull Activity activity) {
            k21.i(activity, "activity");
            if (this.a.e) {
                this.a.j(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PicDialog(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        a aVar = new a(this);
        this.f = aVar;
        if (getContext() instanceof Activity) {
            this.d = (Activity) getContext();
            iq1.Companion.a().c(aVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void d() {
        OnDialogShowTimeListener onDialogShowTimeListener = this.a;
        if (onDialogShowTimeListener != null) {
            onDialogShowTimeListener.exposureTime(e() - f());
        }
    }

    private final void g() {
        iq1.Companion.a().e(this.f);
    }

    public void dismiss() {
        this.e = false;
        this.c = System.currentTimeMillis();
        super.dismiss();
        d();
        g();
    }

    public final long e() {
        return this.c;
    }

    public final long f() {
        return this.b;
    }

    public final void h(@Nullable OnDialogShowTimeListener onDialogShowTimeListener) {
        this.a = onDialogShowTimeListener;
    }

    public void hide() {
        this.e = false;
        super.hide();
        d();
    }

    public final void i(long j) {
        this.c = j;
    }

    public final void j(long j) {
        this.b = j;
    }

    public void show() {
        this.e = true;
        this.b = System.currentTimeMillis();
        super.show();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PicDialog(@NotNull Context context, int i) {
        super(context, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        a aVar = new a(this);
        this.f = aVar;
        if (getContext() instanceof Activity) {
            this.d = (Activity) getContext();
            iq1.Companion.a().c(aVar);
        }
    }
}
