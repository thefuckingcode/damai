package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;

    public BaseViewHolder(View view) {
        super(view);
    }

    public static View b(Context context, ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-361060687")) {
            return LayoutInflater.from(context).inflate(i, viewGroup, false);
        }
        return (View) ipChange.ipc$dispatch("-361060687", new Object[]{context, viewGroup, Integer.valueOf(i)});
    }

    public abstract void a(T t, int i);
}
