package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import tb.jl1;

/* compiled from: Taobao */
public class gu {
    private static gu a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Object> f440a = new ConcurrentHashMap();
    private Map<String, Object> b = new ConcurrentHashMap();

    private gu() {
        m530a();
    }

    public static synchronized gu a() {
        gu guVar;
        synchronized (gu.class) {
            if (a == null) {
                a = new gu();
            }
            guVar = a;
        }
        return guVar;
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.L);
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append(jl1.L);
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    private ClassLoader[] m528a() {
        ClassLoader[] classLoaderArr = {gu.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m529a(String str, String str2) {
        return this.f440a.get(a(str, str2));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f6 A[SYNTHETIC, Splitter:B:42:0x00f6] */
    /* renamed from: a  reason: collision with other method in class */
    public void m530a() {
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        try {
            for (ClassLoader classLoader : m528a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        InputStream openStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(openStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("iqProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText2 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText3 = newPullParser.nextText();
                                    String a2 = a(nextText, nextText2);
                                    if (!this.b.containsKey(a2)) {
                                        try {
                                            Class<?> cls = Class.forName(nextText3);
                                            if (gs.class.isAssignableFrom(cls)) {
                                                map2 = this.b;
                                                obj2 = cls.newInstance();
                                            } else if (gl.class.isAssignableFrom(cls)) {
                                                map2 = this.b;
                                                obj2 = cls;
                                            }
                                            map2.put(a2, obj2 == 1 ? 1 : 0);
                                        } catch (ClassNotFoundException e) {
                                            e = e;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                            if (eventType == 1) {
                                            }
                                        }
                                    }
                                } else if (newPullParser.getName().equals("extensionProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText4 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText5 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText6 = newPullParser.nextText();
                                    String a3 = a(nextText4, nextText5);
                                    if (!this.f440a.containsKey(a3)) {
                                        try {
                                            Class<?> cls2 = Class.forName(nextText6);
                                            if (gt.class.isAssignableFrom(cls2)) {
                                                map = this.f440a;
                                                obj = cls2.newInstance();
                                            } else if (go.class.isAssignableFrom(cls2)) {
                                                map = this.f440a;
                                                obj = cls2;
                                            }
                                            map.put(a3, obj == 1 ? 1 : 0);
                                        } catch (ClassNotFoundException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                            if (eventType == 1) {
                                            }
                                        }
                                    }
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType == 1);
                    } finally {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void a(String str, String str2, Object obj) {
        if ((obj instanceof gt) || (obj instanceof Class)) {
            this.f440a.put(a(str, str2), obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }
}
