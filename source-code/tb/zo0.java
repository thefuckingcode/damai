package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class zo0 {
    @Nullable
    private static Pattern a;

    @Nullable
    public static final Object c(@NotNull JSON json, @NotNull String str) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        try {
            String obj = StringsKt__StringsKt.T0(str).toString();
            o41 o41 = o41.INSTANCE;
            String[] f = o41.f(obj);
            boolean z = false;
            if (!(f.length == 0)) {
                String str2 = f[0];
                String str3 = f.length >= 2 ? f[1] : null;
                int a2 = o41.a(str2);
                if (str3 != null) {
                    if (str3.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        if (a2 == -1) {
                            Object obj2 = ((JSONObject) json).get(str2);
                            if (obj2 instanceof JSON) {
                                return c((JSON) obj2, str3);
                            }
                        } else {
                            Object c = o41.c(json, str2, a2);
                            if (c instanceof JSON) {
                                return c((JSON) c, str3);
                            }
                        }
                    }
                }
                if (a2 != -1 || !(json instanceof JSONObject)) {
                    String b = o41.b(str2);
                    if (json instanceof JSONObject) {
                        if (((JSONObject) json).containsKey(b)) {
                            JSONArray jSONArray = ((JSONObject) json).getJSONArray(b);
                            if (jSONArray.size() > a2) {
                                return jSONArray.get(a2);
                            }
                        }
                    } else if ((json instanceof JSONArray) && ((JSONArray) json).size() > a2) {
                        return ((JSONArray) json).get(a2);
                    }
                } else if (((JSONObject) json).containsKey(str2)) {
                    return ((JSONObject) json).get(str2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final boolean d(@NotNull JSON json, @NotNull String str) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        return o.w("true", i(json, str), true);
    }

    public static final int e(@NotNull JSON json, @NotNull String str) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        String i = i(json, str);
        try {
            if (i.length() > 0) {
                return Integer.parseInt(i);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static final JSONArray f(JSON json, String str) {
        if (str != null) {
            try {
                String obj = StringsKt__StringsKt.T0(str).toString();
                o41 o41 = o41.INSTANCE;
                String[] f = o41.f(obj);
                boolean z = false;
                if (!(f.length == 0)) {
                    String str2 = f[0];
                    String str3 = null;
                    if (f.length >= 2) {
                        str3 = f[1];
                    }
                    int a2 = o41.a(str2);
                    if (str3 != null) {
                        if (str3.length() > 0) {
                            z = true;
                        }
                        if (z) {
                            if (a2 == -1) {
                                Object obj2 = ((JSONObject) json).get(str2);
                                if (obj2 instanceof JSON) {
                                    return f((JSON) obj2, str3);
                                }
                            } else {
                                Object c = o41.c(json, str2, a2);
                                if (c instanceof JSON) {
                                    return f((JSON) c, str3);
                                }
                            }
                        }
                    }
                    if (a2 != -1 || !(json instanceof JSONObject)) {
                        String b = o41.b(str2);
                        if (json instanceof JSONObject) {
                            if (((JSONObject) json).containsKey(b)) {
                                JSONArray jSONArray = ((JSONObject) json).getJSONArray(b);
                                if (jSONArray.size() > a2) {
                                    JSONArray jSONArray2 = jSONArray.getJSONArray(a2);
                                    k21.h(jSONArray2, "jsonArray.getJSONArray(arrayIndex)");
                                    return jSONArray2;
                                }
                            }
                        } else if ((json instanceof JSONArray) && ((JSONArray) json).size() > a2) {
                            JSONArray jSONArray3 = ((JSONArray) json).getJSONArray(a2);
                            k21.h(jSONArray3, "this.getJSONArray(arrayIndex)");
                            return jSONArray3;
                        }
                    } else if (((JSONObject) json).containsKey(str2)) {
                        JSONArray jSONArray4 = ((JSONObject) json).getJSONArray(str2);
                        k21.h(jSONArray4, "this.getJSONArray(firstKey)");
                        return jSONArray4;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new JSONArray();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    public static final JSONArray g(@NotNull JSON json, @NotNull String str) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        return f(json, str);
    }

    public static final long h(@NotNull JSON json, @NotNull String str) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        String i = i(json, str);
        try {
            if (i.length() > 0) {
                return Long.parseLong(i);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @NotNull
    public static final String i(@NotNull JSON json, @NotNull String str) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        String j = j(json, str);
        return j == null ? "" : j;
    }

    @Nullable
    public static final String j(@NotNull JSON json, @NotNull String str) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        try {
            String obj = StringsKt__StringsKt.T0(str).toString();
            o41 o41 = o41.INSTANCE;
            String[] f = o41.f(obj);
            boolean z = false;
            if (!(f.length == 0)) {
                String str2 = f[0];
                String str3 = f.length >= 2 ? f[1] : null;
                int a2 = o41.a(str2);
                if (str3 != null) {
                    if (str3.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        if (a2 == -1) {
                            Object obj2 = ((JSONObject) json).get(str2);
                            if (obj2 instanceof JSON) {
                                return j((JSON) obj2, str3);
                            }
                        } else {
                            Object c = o41.c(json, str2, a2);
                            if (c instanceof JSON) {
                                return j((JSON) c, str3);
                            }
                        }
                    }
                }
                if (a2 != -1 || !(json instanceof JSONObject)) {
                    String b = o41.b(str2);
                    if (json instanceof JSONObject) {
                        if (((JSONObject) json).containsKey(b)) {
                            JSONArray jSONArray = ((JSONObject) json).getJSONArray(b);
                            if (jSONArray.size() > a2) {
                                return jSONArray.getString(a2);
                            }
                        }
                    } else if ((json instanceof JSONArray) && ((JSONArray) json).size() > a2) {
                        return ((JSONArray) json).getString(a2);
                    }
                } else if (((JSONObject) json).containsKey(str2)) {
                    return ((JSONObject) json).getString(str2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @NotNull
    public static final JSONObject k(@NotNull String str) {
        k21.i(str, "<this>");
        try {
            JSONObject parseObject = JSON.parseObject(str);
            k21.h(parseObject, "{\n    JSONObject.parseObject(this)\n}");
            return parseObject;
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static final void l(@NotNull JSON json, @NotNull String str, @NotNull Object obj) {
        k21.i(json, "<this>");
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        k21.i(obj, "value");
        try {
            o41 o41 = o41.INSTANCE;
            String[] f = o41.f(str);
            boolean z = false;
            if (!(f.length == 0)) {
                String str2 = f[0];
                String str3 = null;
                if (f.length >= 2) {
                    str3 = f[1];
                }
                int a2 = o41.a(str2);
                if (str3 != null) {
                    if (str3.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        if (a2 != -1) {
                            Object c = o41.c(json, str2, a2);
                            if (c instanceof JSON) {
                                l((JSON) c, str3, obj);
                                return;
                            }
                            return;
                        } else if (json instanceof JSONObject) {
                            Object obj2 = ((JSONObject) json).get(str2);
                            if (obj2 instanceof JSON) {
                                l((JSON) obj2, str3, obj);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (a2 != -1 || !(json instanceof JSONObject)) {
                    String b = o41.b(str2);
                    if (json instanceof JSONObject) {
                        if (((JSONObject) json).containsKey(b)) {
                            ((JSONObject) json).getJSONArray(b).add(a2, obj);
                        }
                    } else if (json instanceof JSONArray) {
                        ((JSONArray) json).add(a2, obj);
                    }
                } else {
                    ((Map) json).put(str2, obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
