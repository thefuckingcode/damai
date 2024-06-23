package cn.damai.search.v2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.SearchSuggest;
import cn.damai.search.ui.viewholder.SearchWordViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class SuggestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<SearchDataHolder> a = new ArrayList();
    private Context b;
    private OnSuggestListener c;

    /* compiled from: Taobao */
    public interface OnSuggestListener {
        void onSuggestClick(View view, SearchSuggest searchSuggest, int i);

        void onSuggestExpose(View view, SearchSuggest searchSuggest, int i);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SearchWordViewHolder a;
        final /* synthetic */ SearchSuggest b;
        final /* synthetic */ int c;

        a(SearchWordViewHolder searchWordViewHolder, SearchSuggest searchSuggest, int i) {
            this.a = searchWordViewHolder;
            this.b = searchSuggest;
            this.c = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-74625811")) {
                ipChange.ipc$dispatch("-74625811", new Object[]{this, view});
            } else if (SuggestAdapter.this.c != null) {
                SuggestAdapter.this.c.onSuggestClick(this.a.itemView, this.b, this.c);
            }
        }
    }

    public SuggestAdapter(Context context) {
        this.b = context;
    }

    public void b(OnSuggestListener onSuggestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284629653")) {
            ipChange.ipc$dispatch("284629653", new Object[]{this, onSuggestListener});
            return;
        }
        this.c = onSuggestListener;
    }

    public void c(List<SearchDataHolder> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695179895")) {
            ipChange.ipc$dispatch("1695179895", new Object[]{this, list});
            return;
        }
        this.a.clear();
        if (!f92.d(list)) {
            this.a.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2123139228")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("2123139228", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "532403523")) {
            return this.a.get(i).mType;
        }
        return ((Integer) ipChange.ipc$dispatch("532403523", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875178787")) {
            ipChange.ipc$dispatch("-1875178787", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        SearchWordViewHolder searchWordViewHolder = (SearchWordViewHolder) viewHolder;
        SearchSuggest searchSuggest = this.a.get(i).mSuggestWord;
        searchWordViewHolder.a(searchSuggest);
        searchWordViewHolder.itemView.setOnClickListener(new a(searchWordViewHolder, searchSuggest, i));
        OnSuggestListener onSuggestListener = this.c;
        if (onSuggestListener != null) {
            onSuggestListener.onSuggestExpose(searchWordViewHolder.itemView, searchSuggest, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061614521")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1061614521", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i != 8) {
            return null;
        } else {
            Context context = this.b;
            return new SearchWordViewHolder(context, LayoutInflater.from(context));
        }
    }
}
