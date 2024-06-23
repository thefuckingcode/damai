package cn.damai.mine.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.activity.AddressListMVPActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public class AddressListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<AddressBean> a = new ArrayList();
    private AddressListMVPActivity b;
    private long c = -1;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h;
    private OnAddressItemClickListener i;

    /* compiled from: Taobao */
    public interface OnAddressItemClickListener {
        void onItemClick(int i, AddressBean addressBean);

        void onItemLongClick(int i, AddressBean addressBean);
    }

    /* compiled from: Taobao */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public DMIconFontTextView e;
        public DMIconFontTextView f;
        public TextView g;
        public LinearLayout h;

        public ViewHolder(View view) {
            super(view);
            a(view);
        }

        private void a(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1182404454")) {
                ipChange.ipc$dispatch("-1182404454", new Object[]{this, view});
                return;
            }
            this.a = (TextView) view.findViewById(R$id.tv_name);
            this.b = (TextView) view.findViewById(R$id.tv_phone);
            this.c = (TextView) view.findViewById(R$id.mine_address_item_invalid_indicator_tv);
            this.d = (TextView) view.findViewById(R$id.mine_address_item_detail_address_tv);
            this.f = (DMIconFontTextView) view.findViewById(R$id.mine_address_item_default_indicator_tv);
            this.h = (LinearLayout) view.findViewById(R$id.mine_address_item_set_default_ll);
            this.g = (TextView) view.findViewById(R$id.mine_address_item_default_text_tv);
            this.e = (DMIconFontTextView) view.findViewById(R$id.mine_address_item_right_indicator_tv);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AddressBean a;

        a(AddressBean addressBean) {
            this.a = addressBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "827575665")) {
                ipChange.ipc$dispatch("827575665", new Object[]{this, view});
            } else if (AddressListAdapter.this.b != null && !TextUtils.isEmpty(this.a.getAddressId())) {
                AddressListAdapter.this.b.requestDefaultUserAddressData(Long.parseLong(this.a.getAddressId()), this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ AddressBean b;

        b(int i, AddressBean addressBean) {
            this.a = i;
            this.b = addressBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1356101262")) {
                ipChange.ipc$dispatch("-1356101262", new Object[]{this, view});
            } else if (AddressListAdapter.this.i != null) {
                AddressListAdapter.this.i.onItemClick(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ AddressBean b;

        c(int i, AddressBean addressBean) {
            this.a = i;
            this.b = addressBean;
        }

        public boolean onLongClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "913781339")) {
                return ((Boolean) ipChange.ipc$dispatch("913781339", new Object[]{this, view})).booleanValue();
            }
            if (AddressListAdapter.this.i != null) {
                AddressListAdapter.this.i.onItemLongClick(this.a, this.b);
            }
            return true;
        }
    }

    public AddressListAdapter(AddressListMVPActivity addressListMVPActivity) {
        this.b = addressListMVPActivity;
        this.f = addressListMVPActivity.getResources().getColor(R$color.color_AAAAAA);
        this.g = this.b.getResources().getColor(R$color.color_111111);
        this.h = this.b.getResources().getColor(R$color.color_222222);
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848006864")) {
            ipChange.ipc$dispatch("-848006864", new Object[]{this, str});
            return;
        }
        this.e = str;
    }

    public void d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159707199")) {
            ipChange.ipc$dispatch("-1159707199", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.c = j;
    }

    public void e(OnAddressItemClickListener onAddressItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147551354")) {
            ipChange.ipc$dispatch("-147551354", new Object[]{this, onAddressItemClickListener});
            return;
        }
        this.i = onAddressItemClickListener;
    }

    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442980101")) {
            ipChange.ipc$dispatch("442980101", new Object[]{this, str});
            return;
        }
        this.d = str;
    }

    public List<AddressBean> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1061531472")) {
            return this.a;
        }
        return (List) ipChange.ipc$dispatch("1061531472", new Object[]{this});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305252128")) {
            return ((Integer) ipChange.ipc$dispatch("1305252128", new Object[]{this})).intValue();
        }
        List<AddressBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1363378012")) {
            return (long) i2;
        }
        return ((Long) ipChange.ipc$dispatch("-1363378012", new Object[]{this, Integer.valueOf(i2)})).longValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900732377")) {
            ipChange.ipc$dispatch("1900732377", new Object[]{this, viewHolder, Integer.valueOf(i2)});
            return;
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        AddressBean addressBean = this.a.get(i2);
        viewHolder2.a.setText(addressBean.getConsigneeName());
        viewHolder2.b.setText(addressBean.getMobile());
        String province = addressBean.getProvince();
        String city = addressBean.getCity();
        String county = addressBean.getCounty();
        String street = addressBean.getStreet();
        if (TextUtils.isEmpty(county) || TextUtils.isEmpty(addressBean.getCountyCode()) || addressBean.getCityCode().equals("-1")) {
            TextView textView = viewHolder2.d;
            textView.setText(province + AltriaXLaunchTime.SPACE + city + AltriaXLaunchTime.SPACE + addressBean.getAddressDetail());
        } else if (county.equals(city)) {
            TextView textView2 = viewHolder2.d;
            textView2.setText(province + AltriaXLaunchTime.SPACE + city + AltriaXLaunchTime.SPACE + addressBean.getAddressDetail());
        } else if (TextUtils.isEmpty(street) || street.equals("暂不选择")) {
            TextView textView3 = viewHolder2.d;
            textView3.setText(province + AltriaXLaunchTime.SPACE + city + AltriaXLaunchTime.SPACE + county + AltriaXLaunchTime.SPACE + addressBean.getAddressDetail());
        } else {
            TextView textView4 = viewHolder2.d;
            textView4.setText(province + AltriaXLaunchTime.SPACE + city + AltriaXLaunchTime.SPACE + county + AltriaXLaunchTime.SPACE + street + AltriaXLaunchTime.SPACE + addressBean.getAddressDetail());
        }
        viewHolder2.f.setVisibility(0);
        viewHolder2.h.setOnClickListener(new a(addressBean));
        if (!TextUtils.isEmpty(addressBean.getIsDefault()) && addressBean.getIsDefault().equals("1") && this.c == -1) {
            this.c = Long.parseLong(addressBean.getAddressId());
        }
        if (this.c == Long.parseLong(addressBean.getAddressId())) {
            viewHolder2.f.setSelected(true);
            viewHolder2.f.setText(R$string.iconfont_danxuanxuanzhong24);
        } else {
            viewHolder2.f.setSelected(false);
            viewHolder2.f.setText(R$string.iconfont_danxuanweixuanzhong24);
        }
        if (!TextUtils.isEmpty(this.d) && "choose".equals(this.d)) {
            if ((!TextUtils.isEmpty(this.e) || i2 != 0) && ((TextUtils.isEmpty(this.e) || !this.e.equals(addressBean.getAddressId())) && (!"0".equals(this.e) || i2 != 0))) {
                viewHolder2.e.setSelected(false);
                viewHolder2.e.setText(R$string.iconfont_danxuanweixuanzhong24);
            } else {
                viewHolder2.e.setSelected(true);
                viewHolder2.e.setText(R$string.iconfont_danxuanxuanzhong24);
            }
            viewHolder2.h.setVisibility(8);
        } else if (TextUtils.isEmpty(this.d) || !"morenpeisong".equals(this.d)) {
            viewHolder2.h.setVisibility(8);
            viewHolder2.e.setVisibility(0);
            viewHolder2.e.setTextColor(this.b.getResources().getColor(R$color.color_DDDDDD));
        } else {
            viewHolder2.e.setVisibility(0);
            viewHolder2.e.setTextColor(this.b.getResources().getColor(R$color.color_DDDDDD));
            viewHolder2.h.setVisibility(0);
        }
        if (!"true".equals(addressBean.getMatch())) {
            viewHolder2.c.setVisibility(0);
            viewHolder2.a.setTextColor(this.f);
            viewHolder2.b.setTextColor(this.f);
            viewHolder2.d.setTextColor(this.f);
            viewHolder2.g.setTextColor(this.f);
        } else {
            viewHolder2.c.setVisibility(8);
            viewHolder2.a.setTextColor(this.g);
            viewHolder2.b.setTextColor(this.h);
            viewHolder2.d.setTextColor(this.g);
            viewHolder2.g.setTextColor(this.g);
        }
        viewHolder2.itemView.setOnClickListener(new b(i2, addressBean));
        viewHolder2.itemView.setOnLongClickListener(new c(i2, addressBean));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "668693053")) {
            return new ViewHolder(LayoutInflater.from(this.b).inflate(R$layout.address_item, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("668693053", new Object[]{this, viewGroup, Integer.valueOf(i2)});
    }

    public void setData(List<AddressBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705363844")) {
            ipChange.ipc$dispatch("-1705363844", new Object[]{this, list});
            return;
        }
        this.a = list;
    }
}
