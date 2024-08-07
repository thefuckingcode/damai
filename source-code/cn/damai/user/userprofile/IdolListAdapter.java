package cn.damai.user.userprofile;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.userprofile.bean.IdolData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cq;

/* compiled from: Taobao */
public class IdolListAdapter extends RecyclerView.Adapter<b> {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity a;
    List<IdolData> b = new ArrayList();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IdolData a;

        a(IdolData idolData) {
            this.a = idolData;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-526265126")) {
                ipChange.ipc$dispatch("-526265126", new Object[]{this, view});
                return;
            }
            IdolListAdapter.this.a.setResult(-1);
            Intent intent = new Intent();
            intent.putExtra("circleId", this.a.circleId);
            intent.putExtra("name", this.a.circleName);
            IdolListAdapter.this.a.setResult(-1, intent);
            IdolListAdapter.this.a.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends RecyclerView.ViewHolder {
        ImageView a;
        TextView b;

        public b(IdolListAdapter idolListAdapter, View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.idol_img);
            this.b = (TextView) view.findViewById(R$id.idol_name);
        }
    }

    public IdolListAdapter(Activity activity) {
        this.a = activity;
    }

    public void a(List<IdolData> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504603052")) {
            ipChange.ipc$dispatch("-504603052", new Object[]{this, list});
            return;
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void onBindViewHolder(b bVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259162194")) {
            ipChange.ipc$dispatch("-259162194", new Object[]{this, bVar, Integer.valueOf(i)});
            return;
        }
        IdolData idolData = this.b.get(i);
        DMImageCreator c = cn.damai.common.image.a.b().c(idolData.targetImg);
        int i2 = R$drawable.uikit_user_default_icon;
        c.i(i2).k(new cq()).c(i2).g(bVar.a);
        bVar.b.setText(idolData.circleName);
        bVar.itemView.setOnClickListener(new a(idolData));
    }

    /* renamed from: c */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "222929672")) {
            return new b(this, LayoutInflater.from(this.a).inflate(R$layout.idol_select_list_item, viewGroup, false));
        }
        return (b) ipChange.ipc$dispatch("222929672", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954581129")) {
            return ((Integer) ipChange.ipc$dispatch("1954581129", new Object[]{this})).intValue();
        }
        List<IdolData> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
