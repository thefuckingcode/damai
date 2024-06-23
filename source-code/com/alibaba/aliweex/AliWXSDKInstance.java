package com.alibaba.aliweex;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXEmbed;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.ox2;

/* compiled from: Taobao */
public class AliWXSDKInstance extends WXSDKInstance implements WXEmbed.EmbedManager {
    private Map<String, WXEmbed> a = new HashMap();
    private ox2 b;
    protected String c;
    private Map<String, Object> d;

    public AliWXSDKInstance(Context context, String str) {
        super(context);
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public ox2 b() {
        return this.b;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(ox2 ox2) {
    }

    @Override // com.taobao.weex.ui.component.WXEmbed.EmbedManager
    public WXEmbed getEmbed(String str) {
        return this.a.get(str);
    }

    @Keep
    public Object getExtra(String str, Object obj) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || obj == null || (map = this.d) == null) {
            return null;
        }
        return map.get(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.WXSDKInstance
    public WXSDKInstance newNestedInstance() {
        AliWXSDKInstance aliWXSDKInstance = new AliWXSDKInstance(getContext(), this.c);
        aliWXSDKInstance.d(this.b);
        return aliWXSDKInstance;
    }

    @Override // com.taobao.weex.WXSDKInstance, com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
    }

    @Override // com.taobao.weex.ui.component.WXEmbed.EmbedManager
    public void putEmbed(String str, WXEmbed wXEmbed) {
        this.a.put(str, wXEmbed);
    }

    @Keep
    public void putExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.d == null) {
                this.d = new ConcurrentHashMap();
            }
            this.d.put(str, obj);
        }
    }
}
