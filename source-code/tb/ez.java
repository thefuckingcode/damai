package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.android.dinamicx.template.loader.ILoader;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ez {
    private ms a = new ms();
    private Map<String, ILoader> b = new HashMap();

    private DXWidgetNode b(DXTemplateItem dXTemplateItem, String str, Map<String, String> map, DXRuntimeContext dXRuntimeContext, Context context) {
        List<e.a> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] e = hy.c().e(str, dXRuntimeContext);
        if (e == null || e.length == 0) {
            if (!(dXRuntimeContext == null || dXRuntimeContext.getDxError() == null || (list = dXRuntimeContext.getDxError().c) == null)) {
                e.a aVar = new e.a("Template", "Template_Read", e.DX_TEMPLATE_LOAD_ERROR);
                if (e == null) {
                    aVar.e = "DXPackageManager load  bytes == null";
                } else {
                    aVar.e = "DXPackageManager load  bytes.len == 0";
                }
                list.add(aVar);
            }
            u00.f().n(dXRuntimeContext.getBizType(), dXTemplateItem);
            return null;
        }
        DXWidgetNode c = this.a.c(e, dXRuntimeContext, context, true);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (this.b.containsKey(entry.getKey())) {
                    this.b.get(entry.getKey()).load(dXTemplateItem, hy.c(), entry.getValue());
                }
            }
        }
        return c;
    }

    public DXWidgetNode a(DXTemplateItem dXTemplateItem, DXRuntimeContext dXRuntimeContext, Context context) {
        DXTemplatePackageInfo dXTemplatePackageInfo = dXTemplateItem.packageInfo;
        return b(dXTemplateItem, dXTemplatePackageInfo.mainFilePath, dXTemplatePackageInfo.subFilePathDict, dXRuntimeContext, context);
    }
}
