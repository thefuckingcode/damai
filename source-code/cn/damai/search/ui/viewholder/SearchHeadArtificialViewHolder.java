package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.helper.SearchHelper;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m42;
import tb.xs0;

/* compiled from: Taobao */
public class SearchHeadArtificialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private int c = m42.a(xs0.a(), 115.0f);
    private ArtificialProxy d;
    private Context e;
    private ImageView f;
    private int g;
    private OnItemBindListener<ArtificialProxy> h;

    public SearchHeadArtificialViewHolder(Context context, ViewGroup viewGroup, OnItemBindListener<ArtificialProxy> onItemBindListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_view_artificial, viewGroup, false));
        this.e = context;
        this.f = (ImageView) this.itemView.findViewById(R$id.artificial_img_1);
        this.b = (TextView) this.itemView.findViewById(R$id.artificial_text);
        this.a = this.itemView.findViewById(R$id.artificial_video_tag);
        this.h = onItemBindListener;
    }

    public void a(ArtificialProxy artificialProxy, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "2131354981")) {
            ipChange.ipc$dispatch("2131354981", new Object[]{this, artificialProxy, Integer.valueOf(i)});
        } else if (artificialProxy != null) {
            this.d = artificialProxy;
            this.g = i;
            String imgUrl = artificialProxy.getImgUrl();
            this.b.setText(artificialProxy.getTitle());
            View view = this.a;
            if (!artificialProxy.isShowVideoTag()) {
                i2 = 8;
            }
            view.setVisibility(i2);
            ImageView imageView = this.f;
            int i3 = this.c;
            SearchHelper.s(imageView, imgUrl, i3, i3);
            this.itemView.setOnClickListener(this);
            OnItemBindListener<ArtificialProxy> onItemBindListener = this.h;
            if (onItemBindListener != null) {
                onItemBindListener.exposeItem(this.itemView, this.d, this.g);
            }
        }
    }

    public void onClick(View view) {
        ArtificialProxy artificialProxy;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645397896")) {
            ipChange.ipc$dispatch("1645397896", new Object[]{this, view});
            return;
        }
        OnItemBindListener<ArtificialProxy> onItemBindListener = this.h;
        if (onItemBindListener != null && (artificialProxy = this.d) != null && this.e != null) {
            onItemBindListener.onItemClick(artificialProxy, this.g);
        }
    }
}
