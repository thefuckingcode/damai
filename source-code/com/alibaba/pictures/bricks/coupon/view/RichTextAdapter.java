package com.alibaba.pictures.bricks.coupon.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.ImageTicket;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.n12;
import tb.o12;
import tb.p12;
import tb.u50;

/* compiled from: Taobao */
public final class RichTextAdapter extends RecyclerView.Adapter<RichTextViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private List<HtmlParserManager.b> a;
    @NotNull
    private Context b;
    @NotNull
    private ArrayList<HashMap<String, String>> c = new ArrayList<>();

    public RichTextAdapter(@NotNull List<HtmlParserManager.b> list, @NotNull Context context) {
        k21.i(list, "convertedItemList");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = list;
        this.b = context;
    }

    /* access modifiers changed from: private */
    public static final void f(RichTextViewHolder richTextViewHolder, int i, RichTextAdapter richTextAdapter, Ref$ObjectRef ref$ObjectRef, SuccessEvent successEvent) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500517228")) {
            ipChange.ipc$dispatch("1500517228", new Object[]{richTextViewHolder, Integer.valueOf(i), richTextAdapter, ref$ObjectRef, successEvent});
            return;
        }
        k21.i(richTextViewHolder, "$holder");
        k21.i(richTextAdapter, "this$0");
        k21.i(ref$ObjectRef, "$item");
        if (successEvent == null || (drawable = successEvent.drawable) == null) {
            richTextViewHolder.a().setImageResource(R$drawable.bricks_uikit_default_image_bg_grey);
            return;
        }
        richTextAdapter.k(richTextViewHolder.a(), i, (int) ((((float) (successEvent.drawable.getIntrinsicHeight() * i)) * 1.0f) / ((float) drawable.getIntrinsicWidth())));
        richTextViewHolder.a().setImageDrawable(successEvent.drawable);
        richTextViewHolder.a().setOnClickListener(new n12(richTextViewHolder, ref$ObjectRef, richTextAdapter));
    }

    /* access modifiers changed from: private */
    public static final void g(RichTextViewHolder richTextViewHolder, Ref$ObjectRef ref$ObjectRef, RichTextAdapter richTextAdapter, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1237863150")) {
            ipChange.ipc$dispatch("1237863150", new Object[]{richTextViewHolder, ref$ObjectRef, richTextAdapter, view});
            return;
        }
        k21.i(richTextViewHolder, "$holder");
        k21.i(ref$ObjectRef, "$item");
        k21.i(richTextAdapter, "this$0");
        Context context = richTextViewHolder.itemView.getContext();
        if (!TextUtils.isEmpty(ref$ObjectRef.element.d())) {
            Bundle bundle = new Bundle();
            bundle.putString("url", ref$ObjectRef.element.d());
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl("damai://webview");
            action.setExtra(bundle);
            NavProviderProxy.getProxy().toUri(context, action);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("pic_info_map", richTextAdapter.c);
        bundle2.putInt("position", ref$ObjectRef.element.e());
        Action action2 = new Action();
        action2.setActionType(1);
        action2.setActionUrl("damai://videobrowse");
        action2.setExtra(bundle2);
        NavProviderProxy.getProxy().toUri(context, action2);
    }

    /* access modifiers changed from: private */
    public static final void h(RichTextAdapter richTextAdapter, int i, RichTextViewHolder richTextViewHolder, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274665792")) {
            ipChange.ipc$dispatch("1274665792", new Object[]{richTextAdapter, Integer.valueOf(i), richTextViewHolder, failEvent});
            return;
        }
        k21.i(richTextAdapter, "this$0");
        k21.i(richTextViewHolder, "$holder");
        richTextAdapter.j(i, richTextViewHolder);
    }

    private final void j(int i, RichTextViewHolder richTextViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308048160")) {
            ipChange.ipc$dispatch("308048160", new Object[]{this, Integer.valueOf(i), richTextViewHolder});
            return;
        }
        int i2 = i / 2;
        k(richTextViewHolder.a(), i2, (int) ((((float) i2) * 6.0f) / ((float) 19)));
        richTextViewHolder.a().setImageDrawable(this.b.getResources().getDrawable(R$drawable.bricks_default_image_bg_gradient));
    }

    private final void k(ImageView imageView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161977545")) {
            ipChange.ipc$dispatch("-1161977545", new Object[]{this, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        imageView.setLayoutParams(imageView.getLayoutParams());
    }

    @NotNull
    public final HtmlParserManager.b d(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1220803712")) {
            return this.a.get(i);
        }
        return (HtmlParserManager.b) ipChange.ipc$dispatch("-1220803712", new Object[]{this, Integer.valueOf(i)});
    }

    /* renamed from: e */
    public void onBindViewHolder(@NotNull RichTextViewHolder richTextViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636867714")) {
            ipChange.ipc$dispatch("636867714", new Object[]{this, richTextViewHolder, Integer.valueOf(i)});
            return;
        }
        k21.i(richTextViewHolder, "holder");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        T t = (T) d(i);
        ref$ObjectRef.element = t;
        if (t.f() == 1) {
            richTextViewHolder.b().setText(ref$ObjectRef.element.a());
            return;
        }
        int b2 = DisplayMetrics.getwidthPixels(this.b.getResources().getDisplayMetrics()) - (u50.INSTANCE.b(this.b, 12) * 2);
        Object tag = richTextViewHolder.a().getTag();
        if (tag != null) {
            k21.h(tag, "getTag()");
            ((ImageTicket) tag).cancel();
        }
        j(b2, richTextViewHolder);
        richTextViewHolder.a().setTag(ImageLoaderProviderProxy.getProxy().load(String.valueOf(ref$ObjectRef.element.a()), R$drawable.bricks_default_image_bg_gradient, new p12(richTextViewHolder, b2, this, ref$ObjectRef), new o12(this, b2, richTextViewHolder)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "338127787")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("338127787", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-671049518")) {
            return d(i).f();
        }
        return ((Integer) ipChange.ipc$dispatch("-671049518", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @NotNull
    /* renamed from: i */
    public RichTextViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710624844")) {
            return (RichTextViewHolder) ipChange.ipc$dispatch("-1710624844", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        k21.i(viewGroup, "parent");
        if (i == 1) {
            TextView textView = new TextView(viewGroup.getContext());
            u50 u50 = u50.INSTANCE;
            textView.setLineSpacing((float) u50.a(this.b, 9.0f), 1.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = u50.a(this.b, 9.0f);
            textView.setLayoutParams(layoutParams);
            return new RichTextViewHolder(textView);
        }
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new RichTextViewHolder(imageView);
    }

    public final void l(@NotNull ArrayList<HashMap<String, String>> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348191616")) {
            ipChange.ipc$dispatch("-1348191616", new Object[]{this, arrayList});
            return;
        }
        k21.i(arrayList, "<set-?>");
        this.c = arrayList;
    }

    public final void m(@NotNull List<HtmlParserManager.b> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808602436")) {
            ipChange.ipc$dispatch("-808602436", new Object[]{this, list});
            return;
        }
        k21.i(list, "convertedItemList");
        this.a = list;
        notifyDataSetChanged();
    }
}
