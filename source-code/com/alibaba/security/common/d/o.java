package com.alibaba.security.common.d;

import android.util.Base64;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
public final class o {
    public static String a = "";
    private static final String[] b = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", c.a, "d", "e", "f", "g", "h", "i", "j", "k", NotifyType.LIGHTS, WXComponent.PROP_FS_MATCH_PARENT, "n", "o", "p", "q", UploadQueueMgr.MSGTYPE_REALTIME, "s", "t", IRequestConst.U, "v", WXComponent.PROP_FS_WRAP_CONTENT, Constants.Name.X, Constants.Name.Y, "z"};

    public static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789abcdef".indexOf(charArray[i2 + 1])) | (((byte) "0123456789abcdef".indexOf(charArray[i2])) << 4));
        }
        return bArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0013 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    private static String b(byte[] bArr) {
        if (bArr == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            if (b2 < 0) {
                b2 += 256;
            }
            String[] strArr = b;
            stringBuffer.append(strArr[(b2 == true ? 1 : 0) / 16]);
            stringBuffer.append(strArr[b2 % 16]);
        }
        return stringBuffer.toString();
    }

    private static byte a(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }

    public static String a(byte[] bArr) {
        return bArr == null ? "" : Base64.encodeToString(bArr, 2);
    }
}
