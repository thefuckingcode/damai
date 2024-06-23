package tb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.alibaba.pictures.bricks.component.instructions.ProjectSupportServiceAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ir1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    public static final void e(PopupWindow popupWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107436596")) {
            ipChange.ipc$dispatch("1107436596", new Object[]{popupWindow, view});
        } else if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void f(PopupWindow popupWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054340107")) {
            ipChange.ipc$dispatch("-2054340107", new Object[]{popupWindow, view});
        } else if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void g(PopupWindow popupWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921149514")) {
            ipChange.ipc$dispatch("-921149514", new Object[]{popupWindow, view});
        } else if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void d(@NotNull View view, @NotNull List<TicketNote> list, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001715375")) {
            ipChange.ipc$dispatch("-1001715375", new Object[]{this, view, list, str});
            return;
        }
        k21.i(view, AdvanceSetting.NETWORK_TYPE);
        k21.i(list, "instructions");
        k21.i(str, "title");
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.bricks_layout_service_notice_rl, (ViewGroup) null);
        k21.h(inflate, "from(it.context)\n       …_service_notice_rl, null)");
        qr1 qr1 = new qr1(inflate, -1);
        Context context = view.getContext();
        k21.g(context, "null cannot be cast to non-null type android.app.Activity");
        qr1 g = qr1.g((Activity) context);
        ((TextView) inflate.findViewById(R$id.layer_title)).setText(str);
        int i = R$id.rl_bottom;
        View findViewById = inflate.findViewById(i);
        k21.h(findViewById, "container.findViewById(R.id.rl_bottom)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        k21.g(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        u50 u50 = u50.INSTANCE;
        Context context2 = view.getContext();
        k21.h(context2, "it.context");
        layoutParams2.height = (int) u50.g(context2);
        linearLayout.setLayoutParams(layoutParams2);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.project_support_service_irc);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProjectSupportServiceAdapter(view.getContext(), list));
        PopupWindow b = g.b();
        int e = g.e();
        ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
        k21.g(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.height = e;
        inflate.findViewById(i).setLayoutParams(layoutParams4);
        inflate.setOnClickListener(new fr1(b));
        inflate.findViewById(R$id.v_outside).setOnClickListener(new gr1(b));
        inflate.findViewById(R$id.layer_close).setOnClickListener(new hr1(b));
    }
}
