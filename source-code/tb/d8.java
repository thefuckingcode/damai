package tb;

import android.content.res.XmlResourceParser;
import android.util.Log;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
public class d8 extends z1 {
    private Constructor<?> a;

    public d8() {
        b();
    }

    private void b() {
        try {
            Constructor<?> constructor = Class.forName("android.content.res.XmlBlock").getConstructor(byte[].class);
            this.a = constructor;
            constructor.setAccessible(true);
        } catch (Exception e) {
            Log.e("Home.AssetParser", "Fail to get XmlBlock", e);
        }
    }

    @Override // com.taobao.android.dinamic.parser.Parser
    public XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, ew2 ew2) {
        if (!(this.a == null || dinamicTemplate == null)) {
            byte[] a2 = a(DTemplateManager.q(str).n(dinamicTemplate), ew2);
            if (a2 == null || a2.length == 0) {
                ew2.b().a(r70.ERROR_CODE_TEMPLATE_FILE_EMPTY, "assert error");
            } else {
                Log.d("Home.AssetParser", "File parser is applied: " + dinamicTemplate.name);
                try {
                    Object b = bz1.b(this.a.newInstance(a2), "newParser", new Object[0]);
                    if (b instanceof XmlResourceParser) {
                        return (XmlResourceParser) b;
                    }
                } catch (Exception e) {
                    ew2.b().a(r70.ERROR_CODE_BYTE_TO_PARSER_ERROR, e.getMessage());
                }
                return null;
            }
        }
        return null;
    }
}
