package com.alibaba.pictures.share.common.ui.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.r92;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\nH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/GridViewAdapter;", "Landroid/widget/BaseAdapter;", "Ljava/util/ArrayList;", "Ltb/r92;", "list", "Ltb/ur2;", "initChannelItems", "Landroid/database/DataSetObserver;", "observer", "unregisterDataSetObserver", "", "getCount", "position", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "channelList", "Ljava/util/ArrayList;", "getChannelList", "()Ljava/util/ArrayList;", "setChannelList", "(Ljava/util/ArrayList;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "a", "share_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GridViewAdapter extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private ArrayList<r92> channelList = new ArrayList<>();
    @NotNull
    private final Context context;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private ImageView a;
        @Nullable
        private TextView b;

        @Nullable
        public final ImageView a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "88109417")) {
                return this.a;
            }
            return (ImageView) ipChange.ipc$dispatch("88109417", new Object[]{this});
        }

        @Nullable
        public final TextView b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1129701847")) {
                return this.b;
            }
            return (TextView) ipChange.ipc$dispatch("-1129701847", new Object[]{this});
        }

        public final void c(@Nullable ImageView imageView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1867875979")) {
                ipChange.ipc$dispatch("-1867875979", new Object[]{this, imageView});
                return;
            }
            this.a = imageView;
        }

        public final void d(@Nullable TextView textView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1349821499")) {
                ipChange.ipc$dispatch("1349821499", new Object[]{this, textView});
                return;
            }
            this.b = textView;
        }
    }

    public GridViewAdapter(@NotNull Context context2) {
        k21.i(context2, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context2;
    }

    @NotNull
    public final ArrayList<r92> getChannelList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1760362200")) {
            return this.channelList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1760362200", new Object[]{this});
    }

    @NotNull
    public final Context getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-453980136")) {
            return this.context;
        }
        return (Context) ipChange.ipc$dispatch("-453980136", new Object[]{this});
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "355967027")) {
            return this.channelList.size();
        }
        return ((Integer) ipChange.ipc$dispatch("355967027", new Object[]{this})).intValue();
    }

    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1272109162")) {
            return (long) i;
        }
        return ((Long) ipChange.ipc$dispatch("1272109162", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    @Nullable
    public View getView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114625446")) {
            return (View) ipChange.ipc$dispatch("1114625446", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        a aVar = new a();
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R$layout.share_channel_item, (ViewGroup) null);
            aVar.c((ImageView) view.findViewById(R$id.share_channel_icon));
            aVar.d((TextView) view.findViewById(R$id.share_channel_name));
            view.setTag(aVar);
        } else {
            Object tag = view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.alibaba.pictures.share.common.ui.adapter.GridViewAdapter.ShareChannelItem");
            aVar = (a) tag;
        }
        ImageView a2 = aVar.a();
        if (a2 != null) {
            a2.setImageResource(getItem(i).a());
        }
        TextView b = aVar.b();
        if (b != null) {
            b.setText(getItem(i).c());
        }
        return view;
    }

    public final void initChannelItems(@NotNull ArrayList<r92> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1608136638")) {
            ipChange.ipc$dispatch("1608136638", new Object[]{this, arrayList});
            return;
        }
        k21.i(arrayList, "list");
        this.channelList = arrayList;
    }

    public final void setChannelList(@NotNull ArrayList<r92> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71794064")) {
            ipChange.ipc$dispatch("71794064", new Object[]{this, arrayList});
            return;
        }
        k21.i(arrayList, "<set-?>");
        this.channelList = arrayList;
    }

    public void unregisterDataSetObserver(@Nullable DataSetObserver dataSetObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1288326860")) {
            ipChange.ipc$dispatch("-1288326860", new Object[]{this, dataSetObserver});
        } else if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @NotNull
    public r92 getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1167228854")) {
            return (r92) ipChange.ipc$dispatch("-1167228854", new Object[]{this, Integer.valueOf(i)});
        }
        r92 r92 = this.channelList.get(i);
        k21.h(r92, "channelList.get(position)");
        return r92;
    }
}
