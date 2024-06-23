package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.lw2;
import tb.sl2;
import tb.xf2;

/* compiled from: Taobao */
public class TickletFaceToBindTicketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<UserTicketTable> b;
    private OnToBindFaceClickListener c;
    private String d;

    /* compiled from: Taobao */
    public interface OnToBindFaceClickListener {
        void onToBindFace(String str, String str2);
    }

    /* compiled from: Taobao */
    public static class TicketFaceUnBindViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public TextView a;
        public LinearLayout b;
        public TextView c;
        public TextView d;

        public TicketFaceUnBindViewHolder(View view) {
            super(view);
            init();
        }

        private void init() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-481701214")) {
                ipChange.ipc$dispatch("-481701214", new Object[]{this});
                return;
            }
            this.a = (TextView) this.itemView.findViewById(R$id.ticklet_to_bind_face_tv);
            this.b = (LinearLayout) this.itemView.findViewById(R$id.ticklet_to_bind_face_ticket_seat_lv);
            this.c = (TextView) this.itemView.findViewById(R$id.ticklet_to_bind_face_ticket_num_tv);
            this.d = (TextView) this.itemView.findViewById(R$id.ticklet_to_bind_face_ticket_cert_name_id_tv);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserTicketTable a;
        final /* synthetic */ int b;

        a(UserTicketTable userTicketTable, int i) {
            this.a = userTicketTable;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "337103666")) {
                ipChange.ipc$dispatch("337103666", new Object[]{this, view});
            } else if (this.a != null) {
                c e = c.e();
                sl2 j = sl2.j();
                String str = TickletFaceToBindTicketAdapter.this.d;
                UserTicketTable userTicketTable = this.a;
                e.x(j.A(str, userTicketTable.performId, userTicketTable.voucherUniqueKey, this.b));
                TickletFaceToBindTicketAdapter.this.e(this.a);
            }
        }
    }

    public TickletFaceToBindTicketAdapter(Context context, List<UserTicketTable> list) {
        this.a = context;
        this.b = list;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938642779")) {
            ipChange.ipc$dispatch("938642779", new Object[]{this, userTicketTable});
        }
    }

    public void c(OnToBindFaceClickListener onToBindFaceClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189832422")) {
            ipChange.ipc$dispatch("-1189832422", new Object[]{this, onToBindFaceClickListener});
            return;
        }
        this.c = onToBindFaceClickListener;
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558439444")) {
            ipChange.ipc$dispatch("-1558439444", new Object[]{this, str});
            return;
        }
        this.d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583468319")) {
            return ((Integer) ipChange.ipc$dispatch("-1583468319", new Object[]{this})).intValue();
        }
        List<UserTicketTable> list = this.b;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721826680")) {
            ipChange.ipc$dispatch("721826680", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        TicketFaceUnBindViewHolder ticketFaceUnBindViewHolder = (TicketFaceUnBindViewHolder) viewHolder;
        UserTicketTable userTicketTable = this.b.get(i);
        if (userTicketTable != null) {
            lw2.z(this.a, userTicketTable.getVoucherState(), 14, userTicketTable.seatInfo, ticketFaceUnBindViewHolder.b, 3);
            String str = userTicketTable.voucherCertName;
            String str2 = userTicketTable.voucherCertNo;
            String str3 = userTicketTable.productSystemVoucherIdWithPre;
            if (!xf2.j(str3)) {
                ticketFaceUnBindViewHolder.c.setVisibility(0);
                ticketFaceUnBindViewHolder.c.setText(str3);
            } else {
                ticketFaceUnBindViewHolder.c.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append("   ");
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                ticketFaceUnBindViewHolder.d.setVisibility(0);
                ticketFaceUnBindViewHolder.d.setText(sb2);
            } else {
                ticketFaceUnBindViewHolder.d.setVisibility(8);
            }
            ticketFaceUnBindViewHolder.a.setOnClickListener(new a(userTicketTable, i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-496099458")) {
            return new TicketFaceUnBindViewHolder(LayoutInflater.from(this.a).inflate(R$layout.ticklet_face_to_bind_ticket_item_layout, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-496099458", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
