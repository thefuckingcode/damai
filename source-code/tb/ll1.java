package tb;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageExtra;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.Option;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class ll1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HashMap<String, kl1<vz0>> a = new HashMap<>();
    private final HashMap<String, kl1<f72>> b = new HashMap<>();

    @Nullable
    public List<kl1<?>> a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698058829")) {
            return (List) ipChange.ipc$dispatch("-1698058829", new Object[]{this});
        }
        Collection<kl1<vz0>> values = this.a.values();
        if (!f92.d(values)) {
            return new ArrayList(values);
        }
        return null;
    }

    @Nullable
    public List<kl1<?>> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595407707")) {
            return (List) ipChange.ipc$dispatch("-595407707", new Object[]{this});
        }
        Collection<kl1<f72>> values = this.b.values();
        if (!f92.d(values)) {
            return new ArrayList(values);
        }
        return null;
    }

    public void c(kl1<vz0> kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676308804")) {
            ipChange.ipc$dispatch("-676308804", new Object[]{this, kl1});
        } else if (kl1 != null) {
            this.a.put(kl1.b(), kl1);
        }
    }

    public void d(Option<ImageExtra>[] optionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295885505")) {
            ipChange.ipc$dispatch("-295885505", new Object[]{this, optionArr});
        } else if (optionArr != null && optionArr.length > 0) {
            for (Option<ImageExtra> option : optionArr) {
                c(option);
            }
        }
    }

    public void e(kl1<f72> kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706316004")) {
            ipChange.ipc$dispatch("-1706316004", new Object[]{this, kl1});
        } else if (kl1 != null) {
            this.b.put(kl1.b(), kl1);
        }
    }
}
