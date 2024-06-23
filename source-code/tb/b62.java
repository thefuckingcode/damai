package tb;

import android.text.Editable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class b62 extends fk2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a = false;

    public abstract void a(Editable editable);

    public void afterTextChanged(Editable editable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341967062")) {
            ipChange.ipc$dispatch("341967062", new Object[]{this, editable});
        } else if (this.a) {
            this.a = false;
        } else {
            a(editable);
        }
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614938430")) {
            ipChange.ipc$dispatch("-614938430", new Object[]{this});
            return;
        }
        this.a = true;
    }
}
