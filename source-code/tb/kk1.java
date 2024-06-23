package tb;

import java.math.BigDecimal;

/* compiled from: Taobao */
public class kk1 {
    public static boolean a(Object obj) {
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        if (str.indexOf(46) == -1 && str.indexOf(101) == -1 && str.indexOf(69) == -1) {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        return str != null && !str.equals("false") && !str.equalsIgnoreCase("0") && !str.isEmpty();
    }

    public static BigDecimal c(Object obj) {
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj == null) {
            throw new IllegalArgumentException("BigDecimal coercion exception. arg is null");
        } else if (obj instanceof String) {
            String str = (String) obj;
            if ("".equals(str.trim())) {
                return BigDecimal.valueOf(0L);
            }
            return new BigDecimal(str);
        } else if (obj instanceof Number) {
            return new BigDecimal(obj.toString());
        } else {
            if (obj instanceof Character) {
                return new BigDecimal((int) ((Character) obj).charValue());
            }
            return null;
        }
    }

    public static double d(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                String str = (String) obj;
                if ("".equals(str.trim())) {
                    return 0.0d;
                }
                return Double.parseDouble(str);
            } else if (obj instanceof Character) {
                return (double) ((Character) obj).charValue();
            } else {
                if (obj instanceof Number) {
                    return d(obj);
                }
                if (obj instanceof Boolean) {
                    throw new IllegalArgumentException("Boolean->Double coercion exception");
                }
            }
        }
        return 0.0d;
    }

    public static int e(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                if ("".equals(obj)) {
                    return 0;
                }
                return Integer.parseInt((String) obj);
            } else if (obj instanceof Character) {
                return ((Character) obj).charValue();
            } else {
                if (obj instanceof Boolean) {
                    throw new IllegalArgumentException("Boolean->Integer coercion exception");
                } else if (obj instanceof Number) {
                    return ((Number) obj).intValue();
                }
            }
        }
        return 0;
    }

    public static long f(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof String) {
            if ("".equals(obj)) {
                return 0;
            }
            return Long.parseLong((String) obj);
        } else if (obj instanceof Character) {
            return (long) ((Character) obj).charValue();
        } else {
            if (!(obj instanceof Boolean) && (obj instanceof Number)) {
                return ((Number) obj).longValue();
            }
            return 0;
        }
    }
}
