package tb;

import com.alibaba.android.ultron.vfw.template.ITemplateProvider;
import com.alibaba.android.ultron.vfw.template.TemplateDownloadListener;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class uj2 {
    private HashMap<String, ITemplateProvider> a = new HashMap<>();

    public uj2(wv2 wv2) {
        c(v00.DB_NAME, new n80(wv2));
    }

    public void a(String str, List<mc0> list, TemplateDownloadListener templateDownloadListener) {
        ITemplateProvider iTemplateProvider = this.a.get(str);
        if (iTemplateProvider != null) {
            iTemplateProvider.downloadTemplates(list, templateDownloadListener);
        }
    }

    public ITemplateProvider b(String str) {
        return this.a.get(str);
    }

    public void c(String str, ITemplateProvider iTemplateProvider) {
        this.a.put(str, iTemplateProvider);
    }
}
