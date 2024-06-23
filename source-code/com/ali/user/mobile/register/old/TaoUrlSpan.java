package com.ali.user.mobile.register.old;

import android.content.Context;
import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.webview.WebViewActivity;

/* compiled from: Taobao */
public class TaoUrlSpan extends URLSpan {
    public TaoUrlSpan(String str) {
        super(str);
    }

    public void onClick(View view) {
        if (view != null && view.getContext() != null) {
            Context context = view.getContext();
            Intent intent = new Intent();
            intent.setClass(context, WebViewActivity.class);
            intent.putExtra(WebConstant.WEBURL, getURL());
            context.startActivity(intent);
        }
    }
}
