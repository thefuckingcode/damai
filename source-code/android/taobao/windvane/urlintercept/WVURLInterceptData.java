package android.taobao.windvane.urlintercept;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class WVURLInterceptData {

    /* compiled from: Taobao */
    public static class RuleData {
        public Map<String, Integer> indexp = new HashMap();
        public Map<String, String> namep = new HashMap();
        public boolean needdecode = true;
        public String pattern;
        public int rutype;
        public int target;
    }

    /* compiled from: Taobao */
    public static class URLInfo {
        public int code;
        public String feature;
        public Map<String, String> params = new HashMap();
        public String rule;
        public String url;
    }
}
