package com.alibaba.motu.tbrest.rest;

import android.content.Context;
import com.alibaba.motu.tbrest.utils.LogUtil;
import com.alibaba.motu.tbrest.utils.MD5Utils;
import com.alibaba.motu.tbrest.utils.StringUtils;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class RestUrlWrapper {
    public static final String FIELD_APPKEY = "appkey";
    public static final String FIELD_APPVERSION = "app_version";
    public static final String FIELD_CHANNEL = "channel";
    public static final String FIELD_PLATFORM = "platform";
    public static final String FIELD_SDK_VERSION = "sdk_version";
    public static final String FIELD_T = "t";
    public static final String FIELD_UTDID = "utdid";
    public static final String FIELD_V = "v";
    static boolean enableSecuritySDK;
    static Context mContext;

    private static String _getEncoded(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    private static String _wrapUrl(String str, String str2, String str3, String str4, Context context, String str5, String str6, String str7, String str8, String str9, String str10) throws Exception {
        String str11;
        String str12;
        String str13;
        Exception e;
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (!enableSecuritySDK || mContext == null) {
            str12 = "";
            str11 = str12;
        } else {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(str6);
                sb.append(str7);
                sb.append(str8);
                sb.append(RestConstants.G_SDK_VERSION);
                sb.append(str10);
                sb.append(valueOf);
                sb.append(LiveFullInfo.VER);
                sb.append("");
                if (str3 == null) {
                    str3 = "";
                }
                sb.append(str3);
                if (str4 == null) {
                    str4 = "";
                }
                sb.append(str4);
                str12 = new RestSecuritySDKRequestAuthentication(mContext, str5).getSign(MD5Utils.getMd5Hex(sb.toString().getBytes()));
                try {
                    if (StringUtils.isNotBlank(RestConstants.G_SDK_VERSION)) {
                        str11 = "1";
                    }
                } catch (Exception e2) {
                    e = e2;
                    LogUtil.w("security sdk signed", e);
                    str11 = "";
                    if (!StringUtils.isEmpty(str2)) {
                    }
                    return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s", str, str13, _getEncoded(str5), _getEncoded(str7), _getEncoded(str6), _getEncoded(LiveFullInfo.VER), _getEncoded(str12), _getEncoded(str10), RestConstants.G_SDK_VERSION, str8, valueOf, "", str11);
                }
            } catch (Exception e3) {
                e = e3;
                str12 = "";
                LogUtil.w("security sdk signed", e);
                str11 = "";
                if (!StringUtils.isEmpty(str2)) {
                }
                return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s", str, str13, _getEncoded(str5), _getEncoded(str7), _getEncoded(str6), _getEncoded(LiveFullInfo.VER), _getEncoded(str12), _getEncoded(str10), RestConstants.G_SDK_VERSION, str8, valueOf, "", str11);
            }
            str11 = "";
        }
        if (!StringUtils.isEmpty(str2)) {
            str13 = str2 + "&";
        } else {
            str13 = "";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s", str, str13, _getEncoded(str5), _getEncoded(str7), _getEncoded(str6), _getEncoded(LiveFullInfo.VER), _getEncoded(str12), _getEncoded(str10), RestConstants.G_SDK_VERSION, str8, valueOf, "", str11);
    }

    public static void enableSecuritySDK() {
        enableSecuritySDK = true;
    }

    public static String getSignedTransferUrl(String str, Map<String, Object> map, Map<String, Object> map2, Context context, String str2, String str3, String str4, String str5, String str6, String str7) throws Exception {
        String str8 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            String[] sortResourcesList = RestKeyArraySorter.getInstance().sortResourcesList(strArr, true);
            for (String str9 : sortResourcesList) {
                str8 = str8 + str9 + MD5Utils.getMd5Hex((byte[]) map2.get(str9));
            }
        }
        try {
            return _wrapUrl(str, null, null, str8, context, str2, str3, str4, str5, str6, str7);
        } catch (Exception unused) {
            return _wrapUrl(RestConstants.getTransferUrl(), null, null, str8, context, str2, str3, str4, str5, str6, str7);
        }
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
