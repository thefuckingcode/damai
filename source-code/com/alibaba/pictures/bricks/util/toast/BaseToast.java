package com.alibaba.pictures.bricks.util.toast;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public class BaseToast extends Toast {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private View mMessageView;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final TextView b(ViewGroup viewGroup) {
            TextView b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1196149110")) {
                return (TextView) ipChange.ipc$dispatch("-1196149110", new Object[]{this, viewGroup});
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof TextView) {
                    return (TextView) childAt;
                }
                if ((childAt instanceof ViewGroup) && (b = b((ViewGroup) childAt)) != null) {
                    return b;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final View c(View view) {
            TextView b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1844697560")) {
                return (View) ipChange.ipc$dispatch("-1844697560", new Object[]{this, view});
            }
            if (view instanceof TextView) {
                return view;
            }
            if (!(view.findViewById(16908299) instanceof TextView)) {
                return (!(view instanceof ViewGroup) || (b = b((ViewGroup) view)) == null) ? view : b;
            }
            View findViewById = view.findViewById(16908299);
            k21.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) findViewById;
        }
    }

    public BaseToast(@Nullable Application application) {
        super(application);
    }

    @Override // android.widget.Toast
    public void setText(@NotNull CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445419877")) {
            ipChange.ipc$dispatch("1445419877", new Object[]{this, charSequence});
            return;
        }
        k21.i(charSequence, "s");
        if ((this.mMessageView instanceof TextView) && !TextUtils.isEmpty(charSequence)) {
            View view = this.mMessageView;
            k21.g(view, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) view).setText(charSequence);
        }
    }

    public void setView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038867735")) {
            ipChange.ipc$dispatch("-2038867735", new Object[]{this, view});
            return;
        }
        k21.i(view, "view");
        super.setView(view);
        this.mMessageView = Companion.c(view);
    }
}
