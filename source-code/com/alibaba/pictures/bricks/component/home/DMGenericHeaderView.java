package com.alibaba.pictures.bricks.component.home;

import android.text.TextPaint;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alient.onearch.adapter.component.header.GenericHeaderView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.nq;
import tb.oq;

/* compiled from: Taobao */
public final class DMGenericHeaderView extends GenericHeaderView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DMGenericHeaderView(@NotNull View view) {
        super(view);
        k21.i(view, "view");
    }

    /* access modifiers changed from: private */
    /* renamed from: renderTitle$lambda-0  reason: not valid java name */
    public static final void m100renderTitle$lambda0(ImageView imageView, DMGenericHeaderView dMGenericHeaderView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404669290")) {
            ipChange.ipc$dispatch("404669290", new Object[]{imageView, dMGenericHeaderView, successEvent});
            return;
        }
        k21.i(dMGenericHeaderView, "this$0");
        if ((successEvent != null ? successEvent.drawable : null) != null) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (imageView != null) {
                imageView.setImageDrawable(successEvent.drawable);
                return;
            }
            return;
        }
        if (imageView != null) {
            imageView.setImageDrawable(dMGenericHeaderView.getView().getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: renderTitle$lambda-1  reason: not valid java name */
    public static final void m101renderTitle$lambda1(ImageView imageView, DMGenericHeaderView dMGenericHeaderView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43015412")) {
            ipChange.ipc$dispatch("43015412", new Object[]{imageView, dMGenericHeaderView, failEvent});
            return;
        }
        k21.i(dMGenericHeaderView, "this$0");
        if (imageView != null) {
            imageView.setImageDrawable(dMGenericHeaderView.getView().getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View, com.alient.onearch.adapter.component.header.GenericHeaderView
    public void renderTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275783177")) {
            ipChange.ipc$dispatch("-275783177", new Object[]{this, str});
            return;
        }
        TextView textView = (TextView) getView().findViewById(R$id.title);
        ImageView imageView = (ImageView) getView().findViewById(R$id.title_image);
        if (Patterns.WEB_URL.matcher(str).matches()) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageLoaderProviderProxy.getProxy().load(str, new oq(imageView, this), new nq(imageView, this));
            return;
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextPaint textPaint = null;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView != null) {
            textPaint = textView.getPaint();
        }
        if (textPaint != null) {
            textPaint.setFakeBoldText(true);
        }
        if (textView != null) {
            textView.setText(str);
        }
    }
}
