package cn.damai.commonbusiness.photoselect.imageselected.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.i42;
import tb.jl1;
import tb.sm0;

/* compiled from: Taobao */
public class FolderAdapter extends RecyclerView.Adapter<b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<sm0> a;
    private LayoutInflater b;
    private OnFolderSelectListener c;

    /* compiled from: Taobao */
    public interface OnFolderSelectListener {
        int OnFolderSelect(sm0 sm0);

        void OnFolderSelect(int i);
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
            if (AndroidInstantRuntime.support(ipChange, "1688051929")) {
                ipChange.ipc$dispatch("1688051929", new Object[]{this, view});
                return;
            }
            FolderAdapter.this.notifyDataSetChanged();
            if (FolderAdapter.this.c != null) {
                FolderAdapter.this.c.OnFolderSelect(this.a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends RecyclerView.ViewHolder {
        DMPosterView a;
        TextView b;
        TextView c;
        TextView d;

        public b(View view) {
            super(view);
            this.a = (DMPosterView) view.findViewById(R$id.iv_image);
            this.b = (TextView) view.findViewById(R$id.tv_select_num);
            this.c = (TextView) view.findViewById(R$id.tv_folder_name);
            this.d = (TextView) view.findViewById(R$id.tv_folder_size);
        }
    }

    public FolderAdapter(Context context, ArrayList<sm0> arrayList) {
        this.a = arrayList;
        this.b = LayoutInflater.from(context);
    }

    /* renamed from: b */
    public void onBindViewHolder(b bVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930929821")) {
            ipChange.ipc$dispatch("1930929821", new Object[]{this, bVar, Integer.valueOf(i)});
            return;
        }
        sm0 sm0 = this.a.get(i);
        ArrayList<Image> b2 = sm0.b();
        bVar.c.setText(sm0.c());
        if (b2 == null || b2.isEmpty()) {
            bVar.d.setText("(0)");
        } else {
            TextView textView = bVar.d;
            textView.setText(jl1.BRACKET_START_STR + b2.size() + jl1.BRACKET_END_STR);
            bVar.a.setPlaceholder(R$drawable.uikit_default_image_bg_trans_white);
            bVar.a.setImageUrl(i42.q(b2.get(0).getPath()));
        }
        OnFolderSelectListener onFolderSelectListener = this.c;
        if (onFolderSelectListener != null) {
            int OnFolderSelect = onFolderSelectListener.OnFolderSelect(sm0);
            if (OnFolderSelect > 0) {
                if (bVar.b.getVisibility() == 8) {
                    bVar.b.setVisibility(0);
                }
                bVar.b.setText(String.valueOf(OnFolderSelect));
            } else if (bVar.b.getVisibility() == 0) {
                bVar.b.setVisibility(8);
            }
        } else if (bVar.b.getVisibility() == 0) {
            bVar.b.setVisibility(8);
        }
        bVar.itemView.setOnClickListener(new a(i));
    }

    /* renamed from: c */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1122169351")) {
            return new b(this.b.inflate(R$layout.adapter_folder, viewGroup, false));
        }
        return (b) ipChange.ipc$dispatch("-1122169351", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void d(OnFolderSelectListener onFolderSelectListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598327388")) {
            ipChange.ipc$dispatch("598327388", new Object[]{this, onFolderSelectListener});
            return;
        }
        this.c = onFolderSelectListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "230306952")) {
            return ((Integer) ipChange.ipc$dispatch("230306952", new Object[]{this})).intValue();
        }
        ArrayList<sm0> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
