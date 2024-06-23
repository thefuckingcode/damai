package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$layout;
import tb.n42;

/* compiled from: Taobao */
public class SearchEndViewHolder extends RecyclerView.ViewHolder {
    public SearchEndViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_end, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, n42.a(context, 21.0f)));
    }
}
