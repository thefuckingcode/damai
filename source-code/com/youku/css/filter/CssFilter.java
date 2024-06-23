package com.youku.css.filter;

import android.text.TextUtils;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Border;
import com.youku.css.dto.Css;
import com.youku.css.dto.Gradient;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class CssFilter {
    public static final int FILTER_TYPE_FOLLOW_ONE_KEY = 2;
    public static final int FILTER_TYPE_FOLLOW_ONE_KEY_ALPHA = 3;
    public static final int FILTER_TYPE_NONE = 0;
    public static final int FILTER_TYPE_ONLY_SET_ONE_KEY = 1;

    public static String filterColor(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() == 2) {
            if (str2.length() == 9) {
                return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + str2.substring(3, 9);
            } else if (str2.length() == 7) {
                return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + str2.substring(1, 7);
            }
        }
        return str2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0238, code lost:
        if (r1.equals("color") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r1.equals("color") == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012a, code lost:
        if (r1.equals("color") == false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0179, code lost:
        if (r1.equals("color") == false) goto L_0x0161;
     */
    public static Css filterCss(Css css, int i, String... strArr) {
        String str;
        if (i == 0 || strArr == null || strArr.length <= 0) {
            return css;
        }
        char c = 0;
        String str2 = strArr[0];
        if (TextUtils.isEmpty(str2)) {
            return css;
        }
        Css css2 = new Css();
        if (i != 1) {
            css2 = css.clone();
        }
        if (strArr.length != 1) {
            String str3 = strArr[strArr.length - 1];
            if (Pattern.compile("^[-\\+]?[\\d]*$").matcher(str3).matches()) {
                String hexString = Integer.toHexString((Integer.parseInt(str3) * 255) / 100);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str = hexString;
                i = 3;
            } else {
                str = "";
            }
            if (strArr.length != 2) {
                if (strArr.length == 3) {
                    String str4 = strArr[1];
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case 94842723:
                            break;
                        case 320716577:
                            if (str2.equals(CssConst.CssAttrs.BORDER_COLOR)) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1287124693:
                            if (str2.equals("backgroundColor")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            css2.color = filterColor(str, getValueFromCssKey(css, str4));
                            break;
                        case 1:
                            if (css2.border == null) {
                                css2.border = new Border();
                            }
                            css2.border.color = filterColor(str, getValueFromCssKey(css, str4));
                            break;
                        case 2:
                            css2.backgroundColor = filterColor(str, getValueFromCssKey(css, str4));
                            break;
                    }
                }
            } else if (i == 3) {
                str2.hashCode();
                switch (str2.hashCode()) {
                    case 94842723:
                        break;
                    case 320716577:
                        if (str2.equals(CssConst.CssAttrs.BORDER_COLOR)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1287124693:
                        if (str2.equals("backgroundColor")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        if (TextUtils.isEmpty(css.color)) {
                            if (!TextUtils.isEmpty(css.backgroundColor)) {
                                css2.color = filterColor(str, css.backgroundColor);
                                break;
                            }
                        } else {
                            css2.color = filterColor(str, css.color);
                            break;
                        }
                        break;
                    case 1:
                        Border border = css.border;
                        if (border != null && !TextUtils.isEmpty(border.color)) {
                            Border border2 = css.border;
                            css2.border = border2;
                            border2.color = filterColor(str, border2.color);
                            break;
                        } else {
                            css2.border = new Border();
                            if (TextUtils.isEmpty(css.color)) {
                                if (!TextUtils.isEmpty(css.backgroundColor)) {
                                    css2.border.color = filterColor(str, css.backgroundColor);
                                    break;
                                }
                            } else {
                                css2.border.color = filterColor(str, css.color);
                                break;
                            }
                        }
                        break;
                    case 2:
                        if (TextUtils.isEmpty(css.backgroundColor)) {
                            if (!TextUtils.isEmpty(css.color)) {
                                css2.backgroundColor = filterColor(str, css.color);
                                break;
                            }
                        } else {
                            css2.backgroundColor = filterColor(str, css.backgroundColor);
                            break;
                        }
                        break;
                }
            } else {
                String str5 = strArr[1];
                str2.hashCode();
                switch (str2.hashCode()) {
                    case 94842723:
                        break;
                    case 320716577:
                        if (str2.equals(CssConst.CssAttrs.BORDER_COLOR)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1287124693:
                        if (str2.equals("backgroundColor")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        css2.color = getValueFromCssKey(css, str5);
                        break;
                    case 1:
                        if (css2.border == null) {
                            css2.border = new Border();
                        }
                        css2.border.color = getValueFromCssKey(css, str5);
                        break;
                    case 2:
                        css2.backgroundColor = getValueFromCssKey(css, str5);
                        break;
                }
            }
        } else {
            str2.hashCode();
            switch (str2.hashCode()) {
                case 94842723:
                    break;
                case 320716577:
                    if (str2.equals(CssConst.CssAttrs.BORDER_COLOR)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (str2.equals("backgroundColor")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (TextUtils.isEmpty(css.color)) {
                        if (!TextUtils.isEmpty(css.backgroundColor)) {
                            css2.color = css.backgroundColor;
                            break;
                        }
                    } else {
                        css2.color = css.color;
                        break;
                    }
                    break;
                case 1:
                    Border border3 = css.border;
                    if (border3 != null && !TextUtils.isEmpty(border3.color)) {
                        css2.border = css.border;
                        break;
                    } else {
                        css2.border = new Border();
                        if (TextUtils.isEmpty(css.color)) {
                            if (!TextUtils.isEmpty(css.backgroundColor)) {
                                css2.border.color = css.backgroundColor;
                                break;
                            }
                        } else {
                            css2.border.color = css.color;
                            break;
                        }
                    }
                    break;
                case 2:
                    if (TextUtils.isEmpty(css.backgroundColor)) {
                        if (!TextUtils.isEmpty(css.color)) {
                            css2.backgroundColor = css.color;
                            break;
                        }
                    } else {
                        css2.backgroundColor = css.backgroundColor;
                        break;
                    }
                    break;
            }
        }
        return css2;
    }

    private static String getValueFromCssKey(Css css, String str) {
        if (css == null) {
            return "";
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1072949178:
                if (str.equals(CssConst.CssAttrs.END_COLOR)) {
                    c = 0;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 1;
                    break;
                }
                break;
            case 320716577:
                if (str.equals(CssConst.CssAttrs.BORDER_COLOR)) {
                    c = 2;
                    break;
                }
                break;
            case 1206759839:
                if (str.equals(CssConst.CssAttrs.START_COLOR)) {
                    c = 3;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Gradient gradient = css.gradient;
                if (gradient != null) {
                    return gradient.endColor;
                }
                break;
            case 1:
                return css.color;
            case 2:
                Border border = css.border;
                if (border != null) {
                    return border.color;
                }
                break;
            case 3:
                Gradient gradient2 = css.gradient;
                if (gradient2 != null) {
                    return gradient2.startColor;
                }
                break;
            case 4:
                return css.backgroundColor;
        }
        return "";
    }
}
