package tb;

import android.view.View;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class x9 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View a;

    @Nullable
    public final View a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "95040873")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("95040873", new Object[]{this});
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1532952058")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1532952058", new Object[]{this})).intValue();
    }

    public void c(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160259236")) {
            ipChange.ipc$dispatch("160259236", new Object[]{this, view});
            return;
        }
        k21.i(view, "view");
    }

    public final void d(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "975096831")) {
            ipChange.ipc$dispatch("975096831", new Object[]{this, view});
            return;
        }
        this.a = view;
    }

    public void e(@NotNull PermissionModel permissionModel, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292395912")) {
            ipChange.ipc$dispatch("292395912", new Object[]{this, permissionModel, Boolean.valueOf(z)});
            return;
        }
        k21.i(permissionModel, "permission");
    }
}
