package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cn.damai.discover.content.ut.LiveUTer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class ym2<T> implements View.OnClickListener, LiveUTer {
    private static transient /* synthetic */ IpChange $ipChange;
    public Context a;
    public View b;
    private w71 c;

    public ym2(Context context) {
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(a(), (ViewGroup) null);
        b();
        c(false);
    }

    public abstract int a();

    public abstract void b();

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1323529869")) {
            ipChange.ipc$dispatch("1323529869", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.b;
        if (view != null) {
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    @Override // cn.damai.discover.content.ut.LiveUTer
    @NonNull
    public w71 getLiveUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1249207224")) {
            return (w71) ipChange.ipc$dispatch("-1249207224", new Object[]{this});
        }
        w71 w71 = this.c;
        return w71 == null ? new w71() : w71;
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615419704")) {
            ipChange.ipc$dispatch("-1615419704", new Object[]{this, view});
        }
    }

    @Override // cn.damai.discover.content.ut.LiveUTer
    public void setLiveUt(w71 w71) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16824118")) {
            ipChange.ipc$dispatch("-16824118", new Object[]{this, w71});
            return;
        }
        this.c = w71;
    }
}
