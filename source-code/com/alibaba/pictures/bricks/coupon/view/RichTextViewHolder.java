package com.alibaba.pictures.bricks.coupon.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class RichTextViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public TextView a;
    public ImageView b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichTextViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        if (view instanceof TextView) {
            d((TextView) view);
        } else if (view instanceof ImageView) {
            c((ImageView) view);
        }
    }

    @NotNull
    public final ImageView a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133444108")) {
            return (ImageView) ipChange.ipc$dispatch("-1133444108", new Object[]{this});
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            return imageView;
        }
        k21.A(IRequestConst.IM);
        return null;
    }

    @NotNull
    public final TextView b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246356622")) {
            return (TextView) ipChange.ipc$dispatch("-1246356622", new Object[]{this});
        }
        TextView textView = this.a;
        if (textView != null) {
            return textView;
        }
        k21.A("tv");
        return null;
    }

    public final void c(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705873226")) {
            ipChange.ipc$dispatch("705873226", new Object[]{this, imageView});
            return;
        }
        k21.i(imageView, "<set-?>");
        this.b = imageView;
    }

    public final void d(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1931730158")) {
            ipChange.ipc$dispatch("-1931730158", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.a = textView;
    }
}
