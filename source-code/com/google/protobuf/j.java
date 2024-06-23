package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.taobao.weex.annotation.JSMethod;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;
import tb.gl1;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class j {
    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(JSMethod.NOT_SET);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (((Float) obj).floatValue() == 0.0f) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj == ((MessageLite) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum) || ((Enum) obj).ordinal() != 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    static final void c(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                c(sb, i, str, obj2);
            }
            return;
        }
        sb.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.c((String) obj));
            sb.append(jl1.QUOTE);
        } else if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.a((ByteString) obj));
            sb.append(jl1.QUOTE);
        } else if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            d((GeneratedMessageLite) obj, sb, i + 2);
            sb.append(StringUtils.LF);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append("}");
        } else {
            sb.append(": ");
            sb.append(obj.toString());
        }
    }

    private static void d(MessageLite messageLite, StringBuilder sb, int i) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith(gl1.TYPE_OPEN_URL_METHOD_GET)) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst(gl1.TYPE_OPEN_URL_METHOD_GET, "");
            boolean z = true;
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList")) {
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get(gl1.TYPE_OPEN_URL_METHOD_GET + replaceFirst);
                if (method2 != null) {
                    c(sb, i, a(str2), GeneratedMessageLite.o(method2, messageLite, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    if (hashMap.containsKey(gl1.TYPE_OPEN_URL_METHOD_GET + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str3 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method3 = (Method) hashMap.get(gl1.TYPE_OPEN_URL_METHOD_GET + replaceFirst);
                Method method4 = (Method) hashMap.get("has" + replaceFirst);
                if (method3 != null) {
                    Object o = GeneratedMessageLite.o(method3, messageLite, new Object[0]);
                    if (method4 != null) {
                        z = ((Boolean) GeneratedMessageLite.o(method4, messageLite, new Object[0])).booleanValue();
                    } else if (b(o)) {
                        z = false;
                    }
                    if (z) {
                        c(sb, i, a(str3), o);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.c) {
            Iterator<Map.Entry<GeneratedMessageLite.d, Object>> j = ((GeneratedMessageLite.c) messageLite).d.j();
            while (j.hasNext()) {
                Map.Entry<GeneratedMessageLite.d, Object> next = j.next();
                c(sb, i, jl1.ARRAY_START_STR + next.getKey().getNumber() + jl1.ARRAY_END_STR, next.getValue());
            }
        }
        m mVar = ((GeneratedMessageLite) messageLite).b;
        if (mVar != null) {
            mVar.d(sb, i);
        }
    }

    static String e(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(messageLite, sb, 0);
        return sb.toString();
    }
}
