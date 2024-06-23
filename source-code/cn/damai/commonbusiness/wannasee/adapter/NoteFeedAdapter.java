package cn.damai.commonbusiness.wannasee.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolderUserCenter;
import cn.damai.commonbusiness.wannasee.bean.EmptyBean;
import cn.damai.commonbusiness.wannasee.bean.FeedBean;
import cn.damai.commonbusiness.wannasee.viewholder.UserEmptyFeedViewHolder;
import cn.damai.commonbusiness.wannasee.viewholder.UserPublishViewHolder;
import cn.damai.user.userhome.bean.MinepublishCheckBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.q3;

/* compiled from: Taobao */
public class NoteFeedAdapter extends RecyclerView.Adapter<BaseViewHolder> implements IPublishView {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Activity a;
    public final q3 b;
    private final List<FeedBean> c = new ArrayList();
    private FeedBean d;

    public NoteFeedAdapter(Activity activity, q3 q3Var) {
        this.a = activity;
        this.b = q3Var;
    }

    /* renamed from: a */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727152486")) {
            ipChange.ipc$dispatch("-727152486", new Object[]{this, baseViewHolder, Integer.valueOf(i)});
            return;
        }
        baseViewHolder.a(this.c.get(i).bean, i);
    }

    @NonNull
    /* renamed from: b */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942435996")) {
            return (BaseViewHolder) ipChange.ipc$dispatch("1942435996", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 2) {
            return new BigNoteViewHolderUserCenter(this.a, viewGroup, this.b.b);
        } else {
            if (i == 1) {
                return new UserPublishViewHolder(this.a, viewGroup, this.b.a);
            }
            return new UserEmptyFeedViewHolder(this.a, viewGroup);
        }
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749164898")) {
            ipChange.ipc$dispatch("1749164898", new Object[]{this, str});
            return;
        }
        this.c.clear();
        FeedBean feedBean = this.d;
        if (feedBean != null) {
            this.c.add(feedBean);
        }
        this.c.add(new FeedBean(3, new EmptyBean(str)));
        notifyDataSetChanged();
    }

    public void d(List<FeedBean> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150779170")) {
            ipChange.ipc$dispatch("150779170", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.c.clear();
            FeedBean feedBean = this.d;
            if (feedBean != null) {
                this.c.add(feedBean);
            }
        }
        if (!f92.d(list)) {
            this.c.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2112531927")) {
            return this.c.size();
        }
        return ((Integer) ipChange.ipc$dispatch("2112531927", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1287578878")) {
            return this.c.get(i).viewType;
        }
        return ((Integer) ipChange.ipc$dispatch("1287578878", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // cn.damai.commonbusiness.wannasee.adapter.IPublishView
    @SuppressLint({"NotifyDataSetChanged"})
    public void showPublishItemView(@Nullable MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1211599238")) {
            ipChange.ipc$dispatch("1211599238", new Object[]{this, minepublishCheckBean});
        } else if (minepublishCheckBean != null) {
            FeedBean feedBean = this.d;
            if (feedBean == null || !minepublishCheckBean.equals(feedBean.bean)) {
                FeedBean feedBean2 = this.d;
                if (feedBean2 != null) {
                    this.c.remove(feedBean2);
                }
                FeedBean feedBean3 = new FeedBean(1, minepublishCheckBean);
                this.d = feedBean3;
                this.c.add(0, feedBean3);
                notifyDataSetChanged();
            }
        } else {
            FeedBean feedBean4 = this.d;
            if (feedBean4 != null) {
                this.c.remove(feedBean4);
                notifyDataSetChanged();
                this.d = null;
            }
        }
    }
}
