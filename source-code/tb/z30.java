package tb;

import android.util.Xml;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
public class z30 {
    private static transient /* synthetic */ IpChange $ipChange;
    private kb a;

    z30(kb kbVar) {
        this.a = kbVar;
    }

    public static z30 b(kb kbVar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1975264688")) {
            return new z30(kbVar);
        }
        return (z30) ipChange.ipc$dispatch("-1975264688", new Object[]{kbVar});
    }

    public y30 a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693420720")) {
            return (y30) ipChange.ipc$dispatch("1693420720", new Object[]{this, inputStream});
        }
        y30 y30 = new y30();
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("kantai".equalsIgnoreCase(name)) {
                        a40 a40 = new a40(this.a);
                        String attributeValue = newPullParser.getAttributeValue(0);
                        a40.j(attributeValue);
                        String attributeValue2 = newPullParser.getAttributeValue(1);
                        a40.u.clear();
                        a40.u.addAll(r71.a(attributeValue2, ","));
                        String attributeValue3 = newPullParser.getAttributeValue(2);
                        a40.v.clear();
                        a40.v.addAll(r71.a(attributeValue3, ","));
                        String attributeValue4 = newPullParser.getAttributeValue(3);
                        a40.w.clear();
                        a40.w.addAll(r71.a(attributeValue4, ","));
                        String attributeValue5 = newPullParser.getAttributeValue(4);
                        a40.x.clear();
                        a40.x.addAll(r71.a(attributeValue5, ","));
                        String attributeValue6 = newPullParser.getAttributeValue(5);
                        a40.y.clear();
                        a40.y.addAll(r71.a(attributeValue6, ","));
                        String attributeValue7 = newPullParser.getAttributeValue(6);
                        a40.z.clear();
                        a40.z.addAll(r71.a(attributeValue7, ","));
                        String attributeValue8 = newPullParser.getAttributeValue(7);
                        a40.A.clear();
                        a40.A.addAll(r71.a(attributeValue8, ","));
                        String attributeValue9 = newPullParser.getAttributeValue(8);
                        a40.B.clear();
                        a40.B.addAll(r71.a(attributeValue9, ","));
                        String attributeValue10 = newPullParser.getAttributeValue(9);
                        a40.C.clear();
                        a40.C.addAll(r71.a(attributeValue10, ","));
                        String attributeValue11 = newPullParser.getAttributeValue(10);
                        a40.D.clear();
                        a40.D.addAll(r71.a(attributeValue11, ","));
                        String attributeValue12 = newPullParser.getAttributeValue(11);
                        a40.E.clear();
                        a40.E.addAll(r71.a(attributeValue12, ","));
                        a40.i(newPullParser.getAttributeValue(12));
                        y30.a.put(attributeValue, a40);
                    } else if ("head".equalsIgnoreCase(name)) {
                        String attributeValue13 = newPullParser.getAttributeValue(0);
                        String attributeValue14 = newPullParser.getAttributeValue(1);
                        if (!kb.c().equalsIgnoreCase(attributeValue13)) {
                            nn.a("binrary", ".bin is not Quantum Binary!");
                        } else if (!kb.f().equalsIgnoreCase(attributeValue14)) {
                            nn.a("binrary", ".bin version is not support!");
                        }
                    } else if ("dict".equalsIgnoreCase(name)) {
                        LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap<>();
                        String attributeValue15 = newPullParser.getAttributeValue(0);
                        String attributeValue16 = newPullParser.getAttributeValue(1);
                        String attributeValue17 = newPullParser.getAttributeValue(2);
                        linkedHashMap.put("floorDict", r71.b(attributeValue15, ","));
                        linkedHashMap.put("rowDict", r71.b(attributeValue16, ","));
                        linkedHashMap.put("chairDict", r71.b(attributeValue17, ","));
                        e40 d = e40.d();
                        d.c(linkedHashMap);
                        y30.b = d;
                    }
                } else if (eventType == 3) {
                    String name2 = newPullParser.getName();
                    if (!"kantai".equalsIgnoreCase(name2) && !"head".equalsIgnoreCase(name2)) {
                        "dict".equalsIgnoreCase(name2);
                    }
                }
            }
        } catch (Throwable th) {
            nn.b("binary", "DecodeParser error:" + th.toString());
            th.printStackTrace();
        }
        return y30;
    }
}
