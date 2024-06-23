package tb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.ultron.R$layout;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
public class u90 extends h1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final IViewHolderCreator CREATOR = new a();

    /* compiled from: Taobao */
    public static final class a implements IViewHolderCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator
        public h1 create(wv2 wv2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-748883092")) {
                return new u90(wv2);
            }
            return (h1) ipChange.ipc$dispatch("-748883092", new Object[]{this, wv2});
        }
    }

    public u90(wv2 wv2) {
        super(wv2);
    }

    /* access modifiers changed from: protected */
    @Override // tb.h1
    public void d(@NonNull IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428417859")) {
            ipChange.ipc$dispatch("428417859", new Object[]{this, iDMComponent});
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.h1
    public View e(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "980085624")) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.ultron_line_layout, viewGroup, false);
        }
        return (View) ipChange.ipc$dispatch("980085624", new Object[]{this, viewGroup});
    }
}
