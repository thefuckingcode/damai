package com.alipay.ma.analyze.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.ma.common.result.ResultMaType;
import com.alipay.ma.decode.DecodeResult;

/* compiled from: Taobao */
public class MaResultTypeHelper {
    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && ((str.startsWith("8") && str.length() == 20) || ((str.startsWith("10") || str.startsWith("11")) && str.length() == 16));
    }

    private static boolean b(String str) {
        Uri parse;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && !TextUtils.isEmpty(parse.getHost()) && TextUtils.equals("s.tb.cn", parse.getHost().toLowerCase())) {
            return true;
        }
        return false;
    }

    public static ResultMaType getMaType(DecodeResult decodeResult) {
        int i = decodeResult.type;
        if (i == 0) {
            return ResultMaType.PRODUCT;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 1024) {
                    return ResultMaType.DM;
                }
                if (i == 2048) {
                    return ResultMaType.PDF417;
                }
                if (i != 65536) {
                    if (i == 131072) {
                        return ResultMaType.NARROW;
                    }
                    if (i != 262144) {
                        return null;
                    }
                    return ResultMaType.HMCODE;
                } else if (isARCode(i, decodeResult.subType)) {
                    return ResultMaType.ARCODE;
                } else {
                    return null;
                }
            } else if (a(decodeResult.strCode)) {
                return ResultMaType.MEDICINE;
            } else {
                return ResultMaType.EXPRESS;
            }
        } else if (b(decodeResult.strCode)) {
            return ResultMaType.TB_ANTI_FAKE;
        } else {
            return ResultMaType.QR;
        }
    }

    public static boolean isARCode(int i, int i2) {
        ResultMaType resultMaType = ResultMaType.ARCODE;
        return i == resultMaType.getType() && i2 == resultMaType.getDiscernType();
    }
}
