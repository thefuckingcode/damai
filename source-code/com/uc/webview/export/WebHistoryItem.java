package com.uc.webview.export;

import android.graphics.Bitmap;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: Taobao */
public class WebHistoryItem {
    public android.webkit.WebHistoryItem mItem = null;

    public Bitmap getFavicon() {
        return this.mItem.getFavicon();
    }

    public String getOriginalUrl() {
        return this.mItem.getOriginalUrl();
    }

    public String getTitle() {
        return this.mItem.getTitle();
    }

    public String getUrl() {
        return this.mItem.getUrl();
    }

    /* access modifiers changed from: protected */
    public synchronized WebHistoryItem clone() {
        return null;
    }
}
