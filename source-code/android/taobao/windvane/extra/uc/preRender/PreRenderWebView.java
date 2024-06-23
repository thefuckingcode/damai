package android.taobao.windvane.extra.uc.preRender;

import android.content.Context;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.webview.IPreRenderWebView;
import android.text.TextUtils;
import android.util.AttributeSet;
import tb.ws1;

/* compiled from: Taobao */
public class PreRenderWebView extends WVUCWebView implements IPreRenderWebView {
    private long expireTime = 0;
    public boolean isPreLoad = false;
    private boolean preRenderSuccess = false;
    private String realUrl = null;

    public PreRenderWebView(Context context) {
        super(context);
    }

    private String getAttachData() {
        if (TextUtils.isEmpty(this.realUrl)) {
            return "{}";
        }
        return "{ \"url\": \"" + this.realUrl + "\" }";
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public long getExpireTime() {
        return this.expireTime;
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public boolean isPreLoad() {
        return this.isPreLoad;
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public boolean isPreRenderSuccess() {
        return this.preRenderSuccess;
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.extra.uc.WVUCWebView, com.uc.webview.export.WebView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isPreLoad) {
            fireEvent(BasePreInitManager.ATTACH_EVENT, getAttachData());
            if (getUCExtension() != null) {
                post(new Runnable() {
                    /* class android.taobao.windvane.extra.uc.preRender.PreRenderWebView.AnonymousClass1 */

                    public void run() {
                        if (PreRenderWebView.this.getUCExtension() != null) {
                            PreRenderWebView.this.getUCExtension().setIsPreRender(false);
                        }
                    }
                });
            }
            try {
                ws1.b.getProcedure(this).addProperty("H5_URL", getUrl());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.isPreLoad = false;
        }
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public void preRenderInit(String str) {
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public void setPreRenderSuccess(boolean z) {
        this.preRenderSuccess = z;
    }

    /* access modifiers changed from: package-private */
    public void setRealUrl(String str) {
        this.realUrl = str;
    }

    public PreRenderWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreRenderWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
