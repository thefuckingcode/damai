package com.alibaba.pictures.share.common.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.r92;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0007\bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter$ShareMenuHolder;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "OnShareMenuItemClickListener", "ShareMenuHolder", "share_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ShareMenuAdapter extends RecyclerView.Adapter<ShareMenuHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<r92> a = new ArrayList<>();
    private OnShareMenuItemClickListener b;
    @NotNull
    private final Context c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter$OnShareMenuItemClickListener;", "", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ltb/ur2;", "onMenuItemClick", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface OnShareMenuItemClickListener {
        void onMenuItemClick(int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter$ShareMenuHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter;Landroid/view/View;)V", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public final class ShareMenuHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private ImageView a;
        @Nullable
        private TextView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShareMenuHolder(@NotNull ShareMenuAdapter shareMenuAdapter, View view) {
            super(view);
            k21.i(view, "itemView");
            this.a = (ImageView) view.findViewById(R$id.share_channel_icon);
            this.b = (TextView) view.findViewById(R$id.share_channel_name);
        }

        @Nullable
        public final ImageView a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "468086537")) {
                return this.a;
            }
            return (ImageView) ipChange.ipc$dispatch("468086537", new Object[]{this});
        }

        @Nullable
        public final TextView getTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2081393638")) {
                return this.b;
            }
            return (TextView) ipChange.ipc$dispatch("2081393638", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public static final class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShareMenuAdapter a;
        final /* synthetic */ int b;

        a(ShareMenuAdapter shareMenuAdapter, int i) {
            this.a = shareMenuAdapter;
            this.b = i;
        }

        public final void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1107429683")) {
                ipChange.ipc$dispatch("1107429683", new Object[]{this, view});
                return;
            }
            OnShareMenuItemClickListener onShareMenuItemClickListener = this.a.b;
            if (onShareMenuItemClickListener != null) {
                onShareMenuItemClickListener.onMenuItemClick(((r92) this.a.a.get(this.b)).b());
            }
        }
    }

    public ShareMenuAdapter(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.c = context;
    }

    public final void c(@NotNull r92 r92) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863960791")) {
            ipChange.ipc$dispatch("863960791", new Object[]{this, r92});
            return;
        }
        k21.i(r92, "channelUIData");
        this.a.add(r92);
        notifyItemInserted(this.a.indexOf(r92));
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352772901")) {
            ipChange.ipc$dispatch("-352772901", new Object[]{this});
            return;
        }
        this.a.clear();
    }

    /* renamed from: e */
    public void onBindViewHolder(@NotNull ShareMenuHolder shareMenuHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281257222")) {
            ipChange.ipc$dispatch("-281257222", new Object[]{this, shareMenuHolder, Integer.valueOf(i)});
            return;
        }
        k21.i(shareMenuHolder, "holder");
        ImageView a2 = shareMenuHolder.a();
        if (a2 != null) {
            a2.setImageResource(this.a.get(i).a());
        }
        TextView title = shareMenuHolder.getTitle();
        if (title != null) {
            title.setText(this.a.get(i).c());
        }
        shareMenuHolder.itemView.setOnClickListener(new a(this, i));
    }

    @NotNull
    /* renamed from: f */
    public ShareMenuHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829853052")) {
            return (ShareMenuHolder) ipChange.ipc$dispatch("829853052", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        k21.i(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.c).inflate(R$layout.share_channel_recycler_item, viewGroup, false);
        k21.h(inflate, "view");
        return new ShareMenuHolder(this, inflate);
    }

    public final void g(@NotNull OnShareMenuItemClickListener onShareMenuItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-84790697")) {
            ipChange.ipc$dispatch("-84790697", new Object[]{this, onShareMenuItemClickListener});
            return;
        }
        k21.i(onShareMenuItemClickListener, "listener");
        this.b = onShareMenuItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "96805915")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("96805915", new Object[]{this})).intValue();
    }
}
