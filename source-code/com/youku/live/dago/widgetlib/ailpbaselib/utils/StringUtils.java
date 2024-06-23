package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class StringUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    private StringUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081003364")) {
            return ((Boolean) ipChange.ipc$dispatch("-2081003364", new Object[]{charSequence, charSequence2})).booleanValue();
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1127517222")) {
            return ((Boolean) ipChange.ipc$dispatch("1127517222", new Object[]{str, str2})).booleanValue();
        } else if (str == null) {
            return str2 == null;
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "346824256")) {
            return charSequence == null || charSequence.length() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("346824256", new Object[]{charSequence})).booleanValue();
    }

    public static boolean isSpace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "867747661")) {
            return ((Boolean) ipChange.ipc$dispatch("867747661", new Object[]{str})).booleanValue();
        } else if (str == null) {
            return true;
        } else {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isTrimEmpty(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-33818840")) {
            return str == null || str.trim().length() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-33818840", new Object[]{str})).booleanValue();
    }

    public static int length(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718068320")) {
            return ((Integer) ipChange.ipc$dispatch("1718068320", new Object[]{charSequence})).intValue();
        } else if (charSequence == null) {
            return 0;
        } else {
            return charSequence.length();
        }
    }

    public static String lowerFirstLetter(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111295036")) {
            return (String) ipChange.ipc$dispatch("1111295036", new Object[]{str});
        } else if (isEmpty(str) || !Character.isUpperCase(str.charAt(0))) {
            return str;
        } else {
            return String.valueOf((char) (str.charAt(0) + ' ')) + str.substring(1);
        }
    }

    public static String null2Length0(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-367125882")) {
            return str == null ? "" : str;
        }
        return (String) ipChange.ipc$dispatch("-367125882", new Object[]{str});
    }

    public static String reverse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112550109")) {
            return (String) ipChange.ipc$dispatch("112550109", new Object[]{str});
        }
        int length = length(str);
        if (length <= 1) {
            return str;
        }
        int i = length >> 1;
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < i; i2++) {
            char c = charArray[i2];
            int i3 = (length - i2) - 1;
            charArray[i2] = charArray[i3];
            charArray[i3] = c;
        }
        return new String(charArray);
    }

    public static String toDBC(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361221723")) {
            return (String) ipChange.ipc$dispatch("-361221723", new Object[]{str});
        } else if (isEmpty(str)) {
            return str;
        } else {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                if (charArray[i] == 12288) {
                    charArray[i] = ' ';
                } else if (65281 > charArray[i] || charArray[i] > 65374) {
                    charArray[i] = charArray[i];
                } else {
                    charArray[i] = (char) (charArray[i] - 65248);
                }
            }
            return new String(charArray);
        }
    }

    public static String toSBC(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "668645044")) {
            return (String) ipChange.ipc$dispatch("668645044", new Object[]{str});
        } else if (isEmpty(str)) {
            return str;
        } else {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                if (charArray[i] == ' ') {
                    charArray[i] = 12288;
                } else if ('!' > charArray[i] || charArray[i] > '~') {
                    charArray[i] = charArray[i];
                } else {
                    charArray[i] = (char) (charArray[i] + 65248);
                }
            }
            return new String(charArray);
        }
    }

    public static String upperFirstLetter(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2038624443")) {
            return (String) ipChange.ipc$dispatch("2038624443", new Object[]{str});
        } else if (isEmpty(str) || !Character.isLowerCase(str.charAt(0))) {
            return str;
        } else {
            return String.valueOf((char) (str.charAt(0) - ' ')) + str.substring(1);
        }
    }
}
