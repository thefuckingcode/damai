package tb;

import android.text.TextUtils;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.a;
import com.taobao.weex.adapter.IWXConfigAdapter;

/* compiled from: Taobao */
public class dx2 implements IWXConfigAdapter {
    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public boolean checkMode(String str) {
        IConfigAdapter c = a.l().c();
        if (c == null) {
            return false;
        }
        return c.checkMode(str);
    }

    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public String getConfig(String str, String str2, String str3) {
        IConfigAdapter c = a.l().c();
        if (c == null) {
            return str3;
        }
        if (kx2.WXAPM_CONFIG_GROUP.equalsIgnoreCase(str) && "use_runtime_api".equalsIgnoreCase(str2)) {
            return kx2.j().o(str, str2, str3);
        }
        String config = c.getConfig(str, str2, str3);
        return (!TextUtils.isEmpty(config) || !kx2.WXAPM_CONFIG_GROUP.equalsIgnoreCase(str) || !"ws_white_list".equalsIgnoreCase(str2)) ? config : "g.alicdn.com/tbsearch-segments/placeholder_bar/0.0.1/nx_placeholder_bar_segment.js;";
    }

    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public String getConfigWhenInit(String str, String str2, String str3) {
        return kx2.j().o(str, str2, str3);
    }
}
