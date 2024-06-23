package cn.damai.message.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.message.bean.MessageItem;
import cn.damai.message.ui.fragment.MessageCommentFragment;
import cn.damai.message.viewholder.MessageCommentViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class MessageCommentAdapter extends RecyclerView.Adapter<MessageCommentViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MessageItem> a = new ArrayList();
    private MessageCommentFragment b;

    public MessageCommentAdapter(MessageCommentFragment messageCommentFragment) {
        this.b = messageCommentFragment;
        LayoutInflater.from(messageCommentFragment.getActivity());
    }

    public void a(List<MessageItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137228780")) {
            ipChange.ipc$dispatch("-2137228780", new Object[]{this, list});
            return;
        }
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898440531")) {
            ipChange.ipc$dispatch("-1898440531", new Object[]{this});
            return;
        }
        this.a.clear();
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public void onBindViewHolder(MessageCommentViewHolder messageCommentViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1966759593")) {
            ipChange.ipc$dispatch("1966759593", new Object[]{this, messageCommentViewHolder, Integer.valueOf(i)});
            return;
        }
        messageCommentViewHolder.b(this.a.get(i), i);
    }

    /* renamed from: d */
    public MessageCommentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-267272723")) {
            return new MessageCommentViewHolder(this.b, null);
        }
        return (MessageCommentViewHolder) ipChange.ipc$dispatch("-267272723", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-355711287")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-355711287", new Object[]{this})).intValue();
    }

    public void setData(List<MessageItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-433222349")) {
            ipChange.ipc$dispatch("-433222349", new Object[]{this, list});
            return;
        }
        this.a.addAll(list);
        notifyDataSetChanged();
    }
}
