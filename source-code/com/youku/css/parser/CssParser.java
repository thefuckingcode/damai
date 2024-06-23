package com.youku.css.parser;

import android.text.TextUtils;
import android.util.Log;
import com.youku.css.binder.CssBinder;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Css;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class CssParser {
    private static final Pattern patternBgColor = Pattern.compile(regBgColor);
    private static final Pattern patternColor = Pattern.compile(regColor);
    private static final String regBgColor = "(Bg)$";
    private static final String regColor = "^(scene)+|(Text)*(Color)$";

    public static synchronized CssBinder parseCss(Map map) {
        synchronized (CssParser.class) {
            if (map == null) {
                return null;
            }
            String str = "";
            long j = 0L;
            if (map.containsKey("tag")) {
                str = (String) map.get("tag");
            }
            if (map.containsKey("updateTime")) {
                if (map.get("updateTime") instanceof Long) {
                    j = (Long) map.get("updateTime");
                } else if (map.get("updateTime") instanceof String) {
                    j = Long.valueOf(Long.parseLong((String) map.get("updateTime")));
                }
            }
            try {
                return new CssBinder(str, parseCss(map, new ConcurrentHashMap()), j);
            } catch (Exception unused) {
                return new CssBinder(str, new HashMap(1), j);
            }
        }
    }

    private static synchronized void putCssMap(Map<String, Css> map, Map.Entry<String, Object> entry, String str, String str2) {
        synchronized (CssParser.class) {
            Css css = null;
            if (map != null) {
                try {
                    if (map.containsKey(str)) {
                        css = map.get(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (css == null) {
                css = new Css();
            }
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 94842723) {
                if (hashCode == 1287124693) {
                    if (str2.equals("backgroundColor")) {
                        c = 0;
                    }
                }
            } else if (str2.equals("color")) {
                c = 1;
            }
            if (c == 0) {
                css.backgroundColor = (String) entry.getValue();
            } else if (c == 1) {
                css.color = (String) entry.getValue();
            }
            Log.d("css", str);
            map.put(str, css);
        }
    }

    public static synchronized Map<String, Css> parseCss(Map map, Map<String, Css> map2) {
        synchronized (CssParser.class) {
            if (map != null) {
                if (!map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        Object value = entry.getValue();
                        if (value != null) {
                            if (!(value instanceof String) || !TextUtils.isEmpty((String) value)) {
                                String str = (String) entry.getKey();
                                Pattern pattern = patternColor;
                                String[] split = pattern.split(str);
                                if (pattern.matcher(str).find() && split.length == 2) {
                                    String str2 = split[1];
                                    Pattern pattern2 = patternBgColor;
                                    if (pattern2.matcher(str2).find()) {
                                        String[] split2 = pattern2.split(str2);
                                        if (split2.length > 0) {
                                            if (map2 == null) {
                                                map2 = new ConcurrentHashMap<>(32);
                                            }
                                            putCssMap(map2, entry, split2[0], "backgroundColor");
                                        } else {
                                            if (map2 == null) {
                                                map2 = new ConcurrentHashMap<>(32);
                                            }
                                            putCssMap(map2, entry, CssConst.CssScenes.VIEW, "backgroundColor");
                                        }
                                    } else {
                                        if (map2 == null) {
                                            map2 = new ConcurrentHashMap<>(32);
                                        }
                                        putCssMap(map2, entry, str2, "color");
                                    }
                                }
                            }
                        }
                    }
                    return map2;
                }
            }
            return null;
        }
    }
}
