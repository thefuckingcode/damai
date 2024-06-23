package tb;

import android.text.TextUtils;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.taobao.weex.adapter.IWXJsFileLoaderAdapter;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
public class lx2 implements IWXJsFileLoaderAdapter {
    @Override // com.taobao.weex.adapter.IWXJsFileLoaderAdapter
    public String loadJsFramework() {
        return null;
    }

    @Override // com.taobao.weex.adapter.IWXJsFileLoaderAdapter
    public String loadJsFrameworkForSandBox() {
        String b = vx2.b("weex", AliWXSDKEngine.a);
        if (TextUtils.isEmpty(b)) {
            WXLogUtils.e("TBWXSDKEngine", "TBWXSDKEngine: WV obtain  FRAMEWORK_JS failed");
        }
        return b;
    }

    @Override // com.taobao.weex.adapter.IWXJsFileLoaderAdapter
    public String loadRaxApi() {
        String b = vx2.b("weex", AliWXSDKEngine.b);
        if (TextUtils.isEmpty(b)) {
            WXLogUtils.e("TBWXSDKEngine", "TBWXSDKEngine: WV obtain rax_api failed");
        }
        return b;
    }
}
