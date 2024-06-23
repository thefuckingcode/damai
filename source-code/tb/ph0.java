package tb;

import android.content.res.XmlResourceParser;
import android.util.Log;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
public class ph0 extends z1 {
    private Constructor<?> a;

    public ph0() {
        b();
    }

    private void b() {
        try {
            Constructor<?> constructor = Class.forName("android.content.res.XmlBlock").getConstructor(byte[].class);
            this.a = constructor;
            constructor.setAccessible(true);
        } catch (Exception e) {
            Log.e("Home.FileParser", "Fail to get XmlBlock", e);
        }
    }

    @Override // com.taobao.android.dinamic.parser.Parser
    public XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, ew2 ew2) {
        if (this.a == null || dinamicTemplate == null) {
            ew2.b().a(r70.ERROR_CODE_XML_BLOCK_CONSTRUCTOR_REFLECT_ERROR, r70.ERROR_CODE_XML_BLOCK_CONSTRUCTOR_REFLECT_ERROR);
            return null;
        }
        DTemplateManager q = DTemplateManager.q(str);
        if (!q.g().d(q.j(dinamicTemplate))) {
            ew2.b().a(r70.ERROR_CODE_TEMPLATE_FILE_LOST, "downloaded file lost");
            return null;
        }
        try {
            byte[] o = q.o(dinamicTemplate);
            if (o != null) {
                if (o.length != 0) {
                    byte[] a2 = a(o, ew2);
                    try {
                        Object b = bz1.b(this.a.newInstance(a2), "newParser", new Object[0]);
                        if (b instanceof XmlResourceParser) {
                            return (XmlResourceParser) b;
                        }
                        ew2.b().a(r70.ERROR_CODE_XML_RES_PARSER_ERROR, r70.ERROR_CODE_XML_RES_PARSER_ERROR);
                        return null;
                    } catch (Exception e) {
                        ew2.b().a(r70.ERROR_CODE_BYTE_TO_PARSER_ERROR, e.getMessage());
                        return null;
                    }
                }
            }
            ew2.b().a(r70.ERROR_CODE_TEMPLATE_FILE_EMPTY, "downloaded file empty");
            return null;
        } catch (Exception e2) {
            ew2.b().a(r70.ERROR_CODE_BYTE_READ_ERROR, e2.getMessage());
            return null;
        }
    }
}
