package cn.damai.seat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.listener.OnSeatRemoveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;
import tb.g72;
import tb.h72;
import tb.s72;

/* compiled from: Taobao */
public class SeatHorizontalListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ItemSeatV2> b;
    private h72 c;
    private OnSeatRemoveListener d;

    /* compiled from: Taobao */
    public class SeatVh extends BaseViewHolder<ItemSeatV2> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private ItemSeatV2 a;
        private TextView b;
        private View c;
        private ViewGroup d;

        public SeatVh(View view) {
            super(view);
            this.d = (ViewGroup) view.findViewById(R$id.seat_group_container);
            this.b = (TextView) view.findViewById(R$id.seat_floor_name);
            View findViewById = view.findViewById(R$id.remove_seat);
            this.c = findViewById;
            findViewById.setOnClickListener(this);
        }

        /* renamed from: c */
        public void a(ItemSeatV2 itemSeatV2, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1023659525")) {
                ipChange.ipc$dispatch("-1023659525", new Object[]{this, itemSeatV2, Integer.valueOf(i)});
                return;
            }
            this.a = itemSeatV2;
            this.d.removeAllViews();
            List<SeatNew> list = itemSeatV2.seatList;
            if (!f92.d(list)) {
                for (SeatNew seatNew : list) {
                    View inflate = LayoutInflater.from(SeatHorizontalListAdapter.this.a).inflate(R$layout.item_select_seat_inner, this.d, false);
                    ImageView imageView = (ImageView) inflate.findViewById(R$id.seat_icon);
                    TextView textView = (TextView) inflate.findViewById(R$id.seat_paihao);
                    if (SeatHorizontalListAdapter.this.c != null) {
                        imageView.setImageBitmap(SeatHorizontalListAdapter.this.c.a(seatNew.seatColor, 0.0f, itemSeatV2.isPackageSeat ? (byte) 12 : 10, false));
                    }
                    textView.setText(g72.q(seatNew));
                    this.d.addView(inflate);
                }
            }
            g72.F(this.b, this.a.formatFloorName);
        }

        public void onClick(View view) {
            ItemSeatV2 itemSeatV2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1653030344")) {
                ipChange.ipc$dispatch("1653030344", new Object[]{this, view});
            } else if (!s72.c() && SeatHorizontalListAdapter.this.d != null && (itemSeatV2 = this.a) != null && itemSeatV2.firstSeat() != null) {
                SeatHorizontalListAdapter.this.d.onSeatRemove(this.a.firstSeat());
            }
        }
    }

    public SeatHorizontalListAdapter(Context context, OnSeatRemoveListener onSeatRemoveListener) {
        this.a = context;
        this.d = onSeatRemoveListener;
    }

    /* renamed from: d */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697705714")) {
            ipChange.ipc$dispatch("-697705714", new Object[]{this, baseViewHolder, Integer.valueOf(i)});
            return;
        }
        baseViewHolder.a(this.b.get(i), i);
    }

    @NonNull
    /* renamed from: e */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1337995096")) {
            return new SeatVh(LayoutInflater.from(this.a).inflate(R$layout.item_select_seat_v2, viewGroup, false));
        }
        return (BaseViewHolder) ipChange.ipc$dispatch("-1337995096", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void f(h72 h72) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477255769")) {
            ipChange.ipc$dispatch("1477255769", new Object[]{this, h72});
            return;
        }
        this.c = h72;
    }

    public void g(List<ItemSeatV2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735841278")) {
            ipChange.ipc$dispatch("735841278", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875272477")) {
            return ((Integer) ipChange.ipc$dispatch("-1875272477", new Object[]{this})).intValue();
        }
        List<ItemSeatV2> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
