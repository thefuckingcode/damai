package android.taobao.windvane.embed;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.view.View;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public abstract class BaseEmbedView extends WVApiPlugin implements IEmbedView, IEmbedViewContainer.OnParamChangedListener, IEmbedViewContainer.OnStateChangedListener, IEmbedViewContainer.OnVisibilityChangedListener {
    Context context;
    public String id = "";
    public EmbedViewConfig params = null;
    public View view = null;
    public IWVWebView webView;

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract View generateView(Context context2);

    @Override // com.uc.webview.export.extension.IEmbedView
    public Bitmap getSnapShot() {
        return null;
    }

    @Override // com.uc.webview.export.extension.IEmbedView
    public View getView() {
        View view2 = this.view;
        if (view2 != null) {
            return view2;
        }
        Context context2 = this.context;
        if (context2 == null) {
            return null;
        }
        View generateView = generateView(context2);
        this.view = generateView;
        return generateView;
    }

    /* access modifiers changed from: protected */
    public abstract String getViewType();

    public boolean init(String str, String str2, IWVWebView iWVWebView, EmbedViewConfig embedViewConfig) {
        String str3;
        if (!str2.equals(getViewType()) || iWVWebView == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str3 = "WVEmbedView";
        } else {
            str3 = "WVEmbedView_" + str;
        }
        iWVWebView.addJsObject(str3, this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bridgeId", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        iWVWebView.evaluateJavascript(String.format("javascript:window.WindVane&&window.WindVane.fireEvent('WVEmbed.Ready',%s);", jSONObject.toString()));
        this.context = iWVWebView.getContext();
        if (iWVWebView.getContext() instanceof MutableContextWrapper) {
            this.context = ((MutableContextWrapper) iWVWebView.getContext()).getBaseContext();
        }
        if (!(this.context instanceof Activity)) {
            this.context = null;
        }
        this.webView = iWVWebView;
        this.params = embedViewConfig;
        this.id = str;
        return true;
    }

    @Override // com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onAttachedToWebView() {
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        this.view = null;
        this.context = null;
    }

    @Override // com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDetachedFromWebView() {
    }

    @Override // com.uc.webview.export.extension.IEmbedViewContainer.OnParamChangedListener
    public void onParamChanged(String[] strArr, String[] strArr2) {
    }

    @Override // com.uc.webview.export.extension.IEmbedViewContainer.OnVisibilityChangedListener
    public void onVisibilityChanged(int i) {
    }
}
