package com.alibaba.pictures.share.common.ui.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class DialogHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private AlertDialog a;
    @NotNull
    private final Activity b;

    public DialogHelper(@NotNull Activity activity) {
        k21.i(activity, "activity");
        this.b = activity;
    }

    public final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119565433")) {
            ipChange.ipc$dispatch("119565433", new Object[]{this});
            return;
        }
        this.b.runOnUiThread(new DialogHelper$dismissProgressDialog$1(this));
    }

    @NotNull
    public final Activity d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-809070699")) {
            return this.b;
        }
        return (Activity) ipChange.ipc$dispatch("-809070699", new Object[]{this});
    }

    public final void e(@Nullable CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210437412")) {
            ipChange.ipc$dispatch("1210437412", new Object[]{this, charSequence});
            return;
        }
        f(charSequence, false, null, true);
    }

    public final void f(@Nullable CharSequence charSequence, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962879947")) {
            ipChange.ipc$dispatch("1962879947", new Object[]{this, charSequence, Boolean.valueOf(z), onCancelListener, Boolean.valueOf(z2)});
            return;
        }
        g(charSequence, z, onCancelListener, z2, null);
    }

    public final void g(@Nullable CharSequence charSequence, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener, boolean z2, @Nullable DialogInterface.OnKeyListener onKeyListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358146133")) {
            ipChange.ipc$dispatch("-1358146133", new Object[]{this, charSequence, Boolean.valueOf(z), onCancelListener, Boolean.valueOf(z2), onKeyListener});
            return;
        }
        c();
        this.b.runOnUiThread(new DialogHelper$showProgressDialog$2(this, charSequence, z2, z, onCancelListener, onKeyListener));
    }
}
