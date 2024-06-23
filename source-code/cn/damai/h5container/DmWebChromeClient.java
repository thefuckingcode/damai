package cn.damai.h5container;

import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.fragment.app.Fragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;
import tb.aj2;

/* compiled from: Taobao */
public class DmWebChromeClient extends aj2 {
    private static transient /* synthetic */ IpChange $ipChange;
    Fragment fragment;

    public DmWebChromeClient(Fragment fragment2) {
        super(fragment2.getActivity());
        this.fragment = fragment2;
    }

    private void setUploadMessage(ValueCallback<Uri> valueCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2096449583")) {
            ipChange.ipc$dispatch("-2096449583", new Object[]{this, valueCallback});
            return;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 instanceof WebViewFragment) {
            ((WebViewFragment) fragment2).mUploadMessage = valueCallback;
        } else if (fragment2 instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment2).setMUploadMessage(valueCallback);
        }
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615263935")) {
            ipChange.ipc$dispatch("-615263935", new Object[]{this, webView, str});
            return;
        }
        super.onReceivedTitle(webView, str);
        if (str != null) {
            str.trim().equals("");
        }
    }

    @Override // tb.aj2, android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-553895275")) {
            return ((Boolean) ipChange.ipc$dispatch("-553895275", new Object[]{this, webView, valueCallback, fileChooserParams})).booleanValue();
        }
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        String str = "";
        for (int i = 0; i < acceptTypes.length; i++) {
            if (!(acceptTypes[i] == null || acceptTypes[i].length() == 0)) {
                str = str + acceptTypes[i] + ";";
            }
        }
        if (str.length() == 0) {
            str = "*/*";
        }
        openFileChooser(new ValueCallback<Uri>() {
            /* class cn.damai.h5container.DmWebChromeClient.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onReceiveValue(Uri uri) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-717184584")) {
                    ipChange.ipc$dispatch("-717184584", new Object[]{this, uri});
                } else {
                    valueCallback.onReceiveValue(uri != null ? new Uri[]{uri} : null);
                }
            }
        }, str);
        return true;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948024022")) {
            ipChange.ipc$dispatch("948024022", new Object[]{this, valueCallback, str});
            return;
        }
        setUploadMessage(valueCallback);
        WebViewUtil.showPhotoDialog(this.fragment.getActivity(), valueCallback);
    }

    @Override // tb.aj2, android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1771369484")) {
            ipChange.ipc$dispatch("1771369484", new Object[]{this, valueCallback});
            return;
        }
        setUploadMessage(null);
        openFileChooser(valueCallback, "");
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634472736")) {
            ipChange.ipc$dispatch("1634472736", new Object[]{this, valueCallback, str, str2});
            return;
        }
        setUploadMessage(null);
        openFileChooser(valueCallback, str);
    }
}
