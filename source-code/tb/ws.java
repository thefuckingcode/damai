package tb;

import android.content.Context;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ws {
    private int a;
    private int b;
    private int c = 1;
    private int d = 2;
    private Map<String, DXWidgetNode> e = new HashMap();

    public DXWidgetNode a(String str) {
        if (str == null) {
            return null;
        }
        return this.e.get(str);
    }

    public Map<String, DXWidgetNode> b(ys ysVar, DXRuntimeContext dXRuntimeContext, Context context) {
        int i = this.a;
        if (i <= 0 || this.b <= 0) {
            return null;
        }
        if (!ysVar.i(i)) {
            ry.g(null, "DXChildTemplateLoader 解析子模版区失败 !codeReader.seek(childTemplateStartPos)");
        }
        int f = ysVar.f();
        if (f <= 0) {
            return null;
        }
        DXTemplateItem dxTemplateItem = dXRuntimeContext.getDxTemplateItem();
        for (int i2 = 0; i2 < f; i2++) {
            if (ysVar.d() != this.c) {
                ry.g(null, "DXChildTemplateLoader 解析子模版区失败 startTag != START_TAG)");
                return null;
            }
            short h = ysVar.h();
            String str = new String(ysVar.a(), ysVar.c(), (int) h);
            ysVar.j(h);
            short h2 = ysVar.h();
            int f2 = ysVar.f();
            byte[] bArr = new byte[f2];
            System.arraycopy(ysVar.a(), ysVar.c(), bArr, 0, f2);
            ysVar.j(f2);
            if (ysVar.d() != this.d) {
                ry.g(null, "DXChildTemplateLoader 解析子模版区失败 endTag != END_TAG)");
                return null;
            }
            ms msVar = new ms();
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            dXTemplateItem.name = str;
            dXTemplateItem.version = (long) h2;
            DXTemplatePackageInfo dXTemplatePackageInfo = new DXTemplatePackageInfo();
            DXTemplatePackageInfo dXTemplatePackageInfo2 = dxTemplateItem.packageInfo;
            dXTemplatePackageInfo.mainFilePath = dXTemplatePackageInfo2.mainFilePath;
            dXTemplatePackageInfo.subFilePathDict = dXTemplatePackageInfo2.subFilePathDict;
            dXTemplateItem.packageInfo = dXTemplatePackageInfo;
            DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(null);
            cloneWithWidgetNode.setDxTemplateItem(dXTemplateItem);
            DXWidgetNode c2 = msVar.c(bArr, cloneWithWidgetNode, context, false);
            Map<String, DXWidgetNode> map = this.e;
            map.put(str + JSMethod.NOT_SET + ((int) h2), c2);
        }
        return this.e;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.a = i;
    }
}
