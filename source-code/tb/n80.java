package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.ultron.vfw.template.ITemplateProvider;
import com.alibaba.android.ultron.vfw.template.TemplateDownloadListener;
import com.taobao.android.dinamicx.n;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class n80 implements ITemplateProvider {
    private Map<String, DXTemplateItem> a = new HashMap();
    private n b;

    public n80(wv2 wv2) {
        this.b = wv2.n().d();
    }

    @Nullable
    public DXTemplateItem a(@NonNull String str) {
        return this.a.get(str);
    }

    @Override // com.alibaba.android.ultron.vfw.template.ITemplateProvider
    public boolean checkTemplate(IDMComponent iDMComponent) {
        return true;
    }

    @Override // com.alibaba.android.ultron.vfw.template.ITemplateProvider
    public void downloadTemplates(List<mc0> list, TemplateDownloadListener templateDownloadListener) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (mc0 mc0 : list) {
                DXTemplateItem a2 = sj2.a(mc0);
                if (a2.version > 0) {
                    DXTemplateItem e = this.b.e(a2);
                    if (e == null) {
                        arrayList.add(a2);
                    } else {
                        if (a2.version != e.version) {
                            arrayList.add(a2);
                        }
                        if (!this.a.containsKey(e.name)) {
                            this.a.put(e.name, e);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.b.d(arrayList);
            }
        }
    }
}
