package cn.damai.commonbusiness.servicenotice;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.n42;
import tb.x3;

/* compiled from: Taobao */
public class ProjectSupportServiceViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private LinearLayout c;
    private TextView d;
    private FrameLayout e;
    private RoundImageView f;
    private View g;
    private int h = 0;
    public Context i;
    private ArrayList<IdCardTypes> j;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-355185920")) {
                ipChange.ipc$dispatch("-355185920", new Object[]{this, view});
            } else if (ProjectSupportServiceViewHolder.this.j != null) {
                ProjectSupportServiceViewHolder projectSupportServiceViewHolder = ProjectSupportServiceViewHolder.this;
                x3.a(projectSupportServiceViewHolder.i, 4121, GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL, projectSupportServiceViewHolder.j);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1723373389")) {
                ipChange.ipc$dispatch("-1723373389", new Object[]{this, dVar});
                return;
            }
            ProjectSupportServiceViewHolder.this.e.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-583481336")) {
                ipChange.ipc$dispatch("-583481336", new Object[]{this, eVar});
            } else if (eVar != null && eVar.a != null) {
                ProjectSupportServiceViewHolder.this.f.setImageDrawable(eVar.a);
                ProjectSupportServiceViewHolder.this.f.getLayoutParams().height = (int) (((float) eVar.a.getIntrinsicHeight()) * ((((float) ProjectSupportServiceViewHolder.this.h) * 1.0f) / ((float) eVar.a.getIntrinsicWidth())));
                ProjectSupportServiceViewHolder.this.e.setVisibility(0);
            }
        }
    }

    public ProjectSupportServiceViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.layout_service_notice_item, viewGroup, false));
        this.i = context;
        g();
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712659594")) {
            ipChange.ipc$dispatch("1712659594", new Object[]{this});
            return;
        }
        this.a = (TextView) this.itemView.findViewById(R$id.project_service_item_tag_name_tv);
        this.b = (TextView) this.itemView.findViewById(R$id.project_service_item_tag_desc_tv);
        this.c = (LinearLayout) this.itemView.findViewById(R$id.project_service_item_tag_action);
        this.d = (TextView) this.itemView.findViewById(R$id.project_support_service_item_action_desc);
        this.e = (FrameLayout) this.itemView.findViewById(R$id.project_service_item_tag_ll);
        this.f = (RoundImageView) this.itemView.findViewById(R$id.project_service_item_tag_img);
        this.g = this.itemView.findViewById(R$id.line);
        this.h = DisplayMetrics.getwidthPixels(n42.b(this.i)) - n42.a(this.i, 42.0f);
    }

    private void h(String str) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "555260587")) {
            ipChange.ipc$dispatch("555260587", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && "1".equals(str)) {
            if (this.c.getVisibility() == 8) {
                this.c.setVisibility(0);
            }
            this.d.setText(this.i.getResources().getString(R$string.add_contacts_title_text));
            LinearLayout linearLayout = this.c;
            if (this.j == null) {
                i2 = 8;
            }
            linearLayout.setVisibility(i2);
            this.c.setOnClickListener(new a());
        } else if (this.c.getVisibility() == 0) {
            this.c.setVisibility(8);
        }
    }

    private void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3628728")) {
            ipChange.ipc$dispatch("3628728", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
        } else {
            DMImageCreator c2 = cn.damai.common.image.a.b().c(str);
            int i2 = R$drawable.uikit_default_image_bg_grey;
            c2.i(i2).c(i2).k(new DMRoundedCornersBitmapProcessor(6, 0)).n(new c()).e(new b()).f();
        }
    }

    private void j(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354827332")) {
            ipChange.ipc$dispatch("-354827332", new Object[]{this, str, str2, Boolean.valueOf(z)});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.a.setText(str);
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setVisibility(0);
            this.b.setText(str2);
        } else {
            this.b.setVisibility(8);
        }
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public void e(ServiceNote serviceNote, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133949544")) {
            ipChange.ipc$dispatch("1133949544", new Object[]{this, serviceNote, Boolean.valueOf(z)});
        } else if (serviceNote != null) {
            j(serviceNote.getTagName(), serviceNote.getTagDesc(), z);
            h(serviceNote.getTagType());
            i(serviceNote.imgUrl);
        }
    }

    public void f(TicketNote ticketNote, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516534261")) {
            ipChange.ipc$dispatch("516534261", new Object[]{this, ticketNote, Boolean.valueOf(z)});
        } else if (ticketNote != null) {
            j(ticketNote.title, ticketNote.getContent(), z);
            i(ticketNote.getImgUrl());
        }
    }

    public void k(ArrayList<IdCardTypes> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071883631")) {
            ipChange.ipc$dispatch("1071883631", new Object[]{this, arrayList});
            return;
        }
        this.j = arrayList;
    }
}
