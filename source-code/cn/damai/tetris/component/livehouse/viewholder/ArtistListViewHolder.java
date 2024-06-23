package cn.damai.tetris.component.livehouse.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.livehouse.bean.ArtistItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cq;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class ArtistListViewHolder extends BaseViewHolderV2<ArtistItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView c = ((ImageView) this.itemView.findViewById(R$id.actor_image_bg));
    private ImageView d = ((ImageView) this.itemView.findViewById(R$id.actor_image));
    private OnItemClickListener<ArtistItemBean> e;
    private RelativeLayout f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private Context j;

    public ArtistListViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<ArtistItemBean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.livehouse_actor_item_layout, viewGroup, false));
        this.j = context;
        this.e = onItemClickListener;
        this.f = (RelativeLayout) this.itemView.findViewById(R$id.actor_layout);
        this.g = (TextView) this.itemView.findViewById(R$id.actor_text);
        this.h = (ImageView) this.itemView.findViewById(R$id.artist_tag_image);
        this.i = (TextView) this.itemView.findViewById(R$id.artist_tag_text);
        this.f.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void c(ArtistItemBean artistItemBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961546034")) {
            ipChange.ipc$dispatch("-1961546034", new Object[]{this, artistItemBean, Integer.valueOf(i2)});
            return;
        }
        if (artistItemBean != null) {
            int i3 = artistItemBean.artistVo.flag;
            if (i3 == -1 && i2 == 0) {
                this.c.setVisibility(0);
                this.g.setTextColor(this.j.getResources().getColor(R$color.color_FF2869));
            } else if (i3 == 1) {
                this.c.setVisibility(0);
                this.g.setTextColor(this.j.getResources().getColor(R$color.color_FF2869));
            } else {
                this.c.setVisibility(4);
                this.g.setTextColor(this.j.getResources().getColor(R$color.color_333333));
            }
            DMImageCreator f2 = a.b().h(xs0.a()).f(artistItemBean.artistVo.headPic, n42.a(xs0.a(), 40.0f), n42.a(xs0.a(), 40.0f));
            int i4 = R$drawable.artist_grey_bg;
            f2.i(i4).c(i4).k(new cq()).g(this.d);
        }
        this.g.setText(artistItemBean.artistVo.name);
        if (!TextUtils.isEmpty(artistItemBean.artistVo.tag)) {
            this.h.setVisibility(0);
            this.i.setText(artistItemBean.artistVo.tag);
            return;
        }
        this.h.setVisibility(4);
    }

    public void onClick(View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406186022")) {
            ipChange.ipc$dispatch("-1406186022", new Object[]{this, view});
            return;
        }
        OnItemClickListener<ArtistItemBean> onItemClickListener = this.e;
        if (onItemClickListener != null && (t = this.a) != null) {
            onItemClickListener.onItemClick(t, this.b);
        }
    }
}
