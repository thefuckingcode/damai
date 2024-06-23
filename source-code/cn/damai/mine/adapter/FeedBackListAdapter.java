package cn.damai.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.bean.FeedBack;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class FeedBackListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<FeedBack> a;
    private View.OnClickListener b;
    private LayoutInflater c;

    /* compiled from: Taobao */
    public class FeedBackViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_desc));
        private View b = this.itemView.findViewById(R$id.line);

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a(FeedBackListAdapter feedBackListAdapter) {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "840044162")) {
                    ipChange.ipc$dispatch("840044162", new Object[]{this, view});
                } else if (FeedBackListAdapter.this.b != null) {
                    FeedBackListAdapter.this.b.onClick(view);
                }
            }
        }

        public FeedBackViewHolder(LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.feed_back_list_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.itemView.setOnClickListener(new a(FeedBackListAdapter.this));
        }

        public void a(FeedBack feedBack, boolean z) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1305716590")) {
                ipChange.ipc$dispatch("-1305716590", new Object[]{this, feedBack, Boolean.valueOf(z)});
            } else if (feedBack != null) {
                this.itemView.setTag(feedBack);
                this.a.setText(feedBack.title);
                View view = this.b;
                if (z) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        }
    }

    public FeedBackListAdapter(Context context, List<FeedBack> list, View.OnClickListener onClickListener) {
        this.a = list;
        this.b = onClickListener;
        this.c = LayoutInflater.from(context);
    }

    public List<FeedBack> b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2065520958")) {
            return this.a;
        }
        return (List) ipChange.ipc$dispatch("2065520958", new Object[]{this});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-711035819")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-711035819", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "788019076")) {
            ipChange.ipc$dispatch("788019076", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        FeedBack feedBack = this.a.get(i);
        if (feedBack != null) {
            FeedBackViewHolder feedBackViewHolder = (FeedBackViewHolder) viewHolder;
            if (i == getItemCount() - 1) {
                z = true;
            }
            feedBackViewHolder.a(feedBack, z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1312325874")) {
            return new FeedBackViewHolder(this.c);
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1312325874", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
