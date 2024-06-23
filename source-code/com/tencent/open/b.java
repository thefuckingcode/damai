package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.taobao.aranger.constant.Constants;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class b {
    protected HashMap<String, C0238b> a = new HashMap<>();

    /* renamed from: com.tencent.open.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0238b {
        public void call(String str, List<String> list, a aVar) {
            String str2;
            Method method;
            Object obj;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                str2 = null;
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i++;
            }
            if (method != null) {
                try {
                    int size = list.size();
                    if (size == 0) {
                        obj = method.invoke(this, new Object[0]);
                    } else if (size == 1) {
                        obj = method.invoke(this, list.get(0));
                    } else if (size == 2) {
                        obj = method.invoke(this, list.get(0), list.get(1));
                    } else if (size == 3) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2));
                    } else if (size == 4) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3));
                    } else if (size != 5) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                    } else {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                    }
                    Class<?> returnType = method.getReturnType();
                    SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + obj + " | ReturnType: " + returnType.getName());
                    if (!Constants.VOID.equals(returnType.getName())) {
                        if (returnType != Void.class) {
                            if (aVar != null && customCallback()) {
                                if (obj != null) {
                                    str2 = obj.toString();
                                }
                                aVar.a(str2);
                                return;
                            }
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.a((Object) null);
                    }
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            } else if (aVar != null) {
                aVar.a();
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(C0238b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, a aVar) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C0238b bVar = this.a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, aVar);
            return;
        }
        SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (aVar != null) {
            aVar.a();
        }
    }

    /* compiled from: Taobao */
    public static class a {
        protected WeakReference<WebView> a;
        protected long b;
        protected String c;

        public a(WebView webView, long j, String str) {
            this.a = new WeakReference<>(webView);
            this.b = j;
            this.c = str;
        }

        public void a(Object obj) {
            String str;
            WebView webView = this.a.get();
            if (webView != null) {
                if (obj instanceof String) {
                    String replace = ((String) obj).replace("\\", "\\\\").replace("'", "\\'");
                    str = "'" + ((Object) replace) + "'";
                } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                    str = obj.toString();
                } else {
                    str = obj instanceof Boolean ? obj.toString() : "'undefined'";
                }
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + str + "});");
            }
        }

        public void a() {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
            }
        }

        public void a(String str) {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        a aVar = new a(webView, 4, str);
        webView.getUrl();
        a((String) arrayList.get(2), (String) arrayList.get(3), subList, aVar);
        return true;
    }
}
