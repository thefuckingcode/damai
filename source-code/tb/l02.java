package tb;

import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
public class l02 extends z1 {
    @Override // com.taobao.android.dinamic.parser.Parser
    public XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, ew2 ew2) {
        return DTemplateManager.q(str).h(dinamicTemplate);
    }
}
