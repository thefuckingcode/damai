package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.taobao.windvane.util.DPUtil;
import android.taobao.windvane.util.ScreenUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IAttachBottom;
import android.util.AttributeSet;

/* compiled from: Taobao */
public class WVPTRUCWebView extends WVUCWebView {
    private IAttachBottom attachBottom;
    private int bottomLevel = DPUtil.dip2px(50.0f);
    private int bottomLevelDP = 50;
    private boolean isBottom = false;
    private boolean isBottomLevelUp = false;
    private int screenHeight = ScreenUtil.getScreenHeight();

    public WVPTRUCWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView
    public void OnScrollChanged(int i, int i2, int i3, int i4) {
        super.OnScrollChanged(i, i2, i3, i4);
        if (this.screenHeight + i2 > getContentHeight() - this.bottomLevel) {
            if (i2 < i4) {
                this.isBottomLevelUp = true;
            }
            if (!this.isBottom) {
                TaoLog.e("scroll", "attach bottom level");
                this.isBottom = true;
                if (this.attachBottom != null) {
                    TaoLog.e("scroll", "attach bottom callback");
                    this.attachBottom.onAttachBottom();
                }
            } else if (this.isBottomLevelUp && i2 + this.screenHeight == getContentHeight()) {
                TaoLog.e("scroll", "attach bottom level");
                if (this.attachBottom != null) {
                    TaoLog.e("scroll", "attach bottom callback");
                    this.attachBottom.onAttachBottom();
                }
            }
        } else {
            this.isBottomLevelUp = false;
            this.isBottom = false;
        }
    }

    public void setAttachBottomListener(IAttachBottom iAttachBottom) {
        this.attachBottom = iAttachBottom;
    }

    public void setBottomLevelDP(int i) {
        this.bottomLevelDP = i;
    }

    public WVPTRUCWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WVPTRUCWebView(Context context) {
        super(context);
    }

    public WVPTRUCWebView(Context context, boolean z) {
        super(context, z);
    }
}
