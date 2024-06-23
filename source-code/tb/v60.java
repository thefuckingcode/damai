package tb;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.coupon.view.DetailInfoViewHolder;
import java.util.List;

/* compiled from: Taobao */
public final /* synthetic */ class v60 implements View.OnClickListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ List b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ DetailInfoViewHolder d;

    public /* synthetic */ v60(RecyclerView recyclerView, List list, TextView textView, DetailInfoViewHolder detailInfoViewHolder) {
        this.a = recyclerView;
        this.b = list;
        this.c = textView;
        this.d = detailInfoViewHolder;
    }

    public final void onClick(View view) {
        DetailInfoViewHolder.c.b(this.a, this.b, this.c, this.d, view);
    }
}
