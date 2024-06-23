package cn.damai.message.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.message.bean.MessageGroupItem;
import cn.damai.message.viewholder.MessageModelViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class MessageListAdapter extends RecyclerView.Adapter<MessageModelViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MessageGroupItem> a;
    private Context b;

    public MessageListAdapter(Context context, List<MessageGroupItem> list) {
        this.b = context;
        this.a = list;
    }

    /* renamed from: a */
    public void onBindViewHolder(MessageModelViewHolder messageModelViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141790744")) {
            ipChange.ipc$dispatch("2141790744", new Object[]{this, messageModelViewHolder, Integer.valueOf(i)});
            return;
        }
        MessageGroupItem messageGroupItem = this.a.get(i);
        if (messageGroupItem != null) {
            messageModelViewHolder.b(messageGroupItem, i);
        }
    }

    /* renamed from: b */
    public MessageModelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-355259810")) {
            return new MessageModelViewHolder(this.b, viewGroup);
        }
        return (MessageModelViewHolder) ipChange.ipc$dispatch("-355259810", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2054630780")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-2054630780", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1513155371")) {
            return (int) this.a.get(i).getGroupId();
        }
        return ((Integer) ipChange.ipc$dispatch("1513155371", new Object[]{this, Integer.valueOf(i)})).intValue();
    }
}
