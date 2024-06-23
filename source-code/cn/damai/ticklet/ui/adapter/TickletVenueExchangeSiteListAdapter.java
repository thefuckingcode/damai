package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.ExchangeSiteInfo;
import cn.damai.ticklet.inteface.TickletVenueSiteCallback;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.jl1;
import tb.lw2;
import tb.q92;

/* compiled from: Taobao */
public class TickletVenueExchangeSiteListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<ExchangeSiteInfo> a;
    private int b = -1;
    private Context c;
    private TickletVenueSiteCallback d;

    /* compiled from: Taobao */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout a;
        private TextView b;
        private TextView c;
        private DMIconFontTextView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private TextView h;
        private DMIconFontTextView i;
        private View j;

        public ViewHolder(TickletVenueExchangeSiteListAdapter tickletVenueExchangeSiteListAdapter, View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1312696446")) {
                ipChange.ipc$dispatch("-1312696446", new Object[]{this, view});
            } else if (TickletVenueExchangeSiteListAdapter.this.d != null) {
                TickletVenueExchangeSiteListAdapter.this.d.showMapMarkByItem(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ExchangeSiteInfo a;

        b(ExchangeSiteInfo exchangeSiteInfo) {
            this.a = exchangeSiteInfo;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "798593923")) {
                ipChange.ipc$dispatch("798593923", new Object[]{this, view});
            } else if (TickletVenueExchangeSiteListAdapter.this.d != null) {
                TickletVenueSiteCallback tickletVenueSiteCallback = TickletVenueExchangeSiteListAdapter.this.d;
                ExchangeSiteInfo exchangeSiteInfo = this.a;
                tickletVenueSiteCallback.callNavi(exchangeSiteInfo.lat, exchangeSiteInfo.lng, exchangeSiteInfo.siteName);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ExchangeSiteInfo a;

        c(ExchangeSiteInfo exchangeSiteInfo) {
            this.a = exchangeSiteInfo;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1385083004")) {
                ipChange.ipc$dispatch("-1385083004", new Object[]{this, view});
            } else if (TickletVenueExchangeSiteListAdapter.this.c != null) {
                q92.b(TickletVenueExchangeSiteListAdapter.this.c, this.a.siteName, "已复制至剪切板");
            }
        }
    }

    public TickletVenueExchangeSiteListAdapter(Context context, ArrayList<ExchangeSiteInfo> arrayList) {
        this.c = context;
        this.a = arrayList;
    }

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634927560")) {
            ipChange.ipc$dispatch("-1634927560", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b = i;
    }

    /* renamed from: d */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1678574581")) {
            ipChange.ipc$dispatch("-1678574581", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ExchangeSiteInfo exchangeSiteInfo = this.a.get(i);
        if (exchangeSiteInfo != null) {
            viewHolder.itemView.setTag(Integer.valueOf(i));
            viewHolder.itemView.setOnClickListener(new a(i));
            int i2 = this.b;
            if (i2 < 0 || i != i2) {
                viewHolder.a.setBackgroundColor(this.c.getResources().getColor(R$color.white));
            } else {
                viewHolder.a.setBackgroundColor(this.c.getResources().getColor(R$color.ticklet_color_ff2d79_5));
            }
            lw2.E(viewHolder.c, exchangeSiteInfo.detailLocation);
            lw2.D(viewHolder.d, viewHolder.c.getVisibility() == 0);
            lw2.E(viewHolder.e, exchangeSiteInfo.distanceDesc);
            TextView textView = viewHolder.b;
            lw2.E(textView, String.valueOf(i + 1) + "、" + exchangeSiteInfo.siteName);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(exchangeSiteInfo.businessHoursNote)) {
                sb.append(exchangeSiteInfo.businessHoursNote);
            }
            if (!TextUtils.isEmpty(exchangeSiteInfo.remark)) {
                sb.append("  (" + exchangeSiteInfo.remark + jl1.BRACKET_END_STR);
            }
            lw2.E(viewHolder.h, sb.toString());
            lw2.D(viewHolder.i, viewHolder.h.getVisibility() == 0);
            if (TextUtils.isEmpty(exchangeSiteInfo.lat) || TextUtils.isEmpty(exchangeSiteInfo.lng)) {
                viewHolder.f.setVisibility(8);
                viewHolder.g.setVisibility(0);
            } else {
                viewHolder.f.setVisibility(0);
                viewHolder.g.setVisibility(8);
            }
            if (i < getItemCount() - 1) {
                viewHolder.j.setVisibility(0);
            } else {
                viewHolder.j.setVisibility(8);
            }
            viewHolder.f.setOnClickListener(new b(exchangeSiteInfo));
            viewHolder.g.setOnClickListener(new c(exchangeSiteInfo));
        }
    }

    /* renamed from: e */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617967051")) {
            return (ViewHolder) ipChange.ipc$dispatch("1617967051", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.c).inflate(R$layout.ticklet_venue_site_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.a = (LinearLayout) inflate.findViewById(R$id.ticklet_venue_exchange_site_item_layout);
        viewHolder.b = (TextView) inflate.findViewById(R$id.ticklet_venue_exchange_site_name);
        viewHolder.c = (TextView) inflate.findViewById(R$id.ticklet_venue_exchange_site_address);
        viewHolder.d = (DMIconFontTextView) inflate.findViewById(R$id.ticklet_venue_address_icon);
        viewHolder.e = (TextView) inflate.findViewById(R$id.ticklet_venue_exchange_site_distance);
        viewHolder.f = (TextView) inflate.findViewById(R$id.ticklet_venue_exchange_site_navi);
        viewHolder.h = (TextView) inflate.findViewById(R$id.ticklet_venue_exchange_hour_remark);
        viewHolder.i = (DMIconFontTextView) inflate.findViewById(R$id.ticklet_ticklet_venue_time_icon);
        viewHolder.j = inflate.findViewById(R$id.ticklet_venue_item_bottom_line);
        viewHolder.g = (TextView) inflate.findViewById(R$id.ticklet_venue_exchange_copy);
        return viewHolder;
    }

    public void f(TickletVenueSiteCallback tickletVenueSiteCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692381473")) {
            ipChange.ipc$dispatch("692381473", new Object[]{this, tickletVenueSiteCallback});
            return;
        }
        this.d = tickletVenueSiteCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1091231025")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("1091231025", new Object[]{this})).intValue();
    }
}
