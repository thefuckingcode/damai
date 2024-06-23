package com.alipay.sdk.m.y;

import com.youku.upsplayer.util.YKUpsConvert;
import tb.ok1;
import tb.u91;
import tb.v00;

/* compiled from: Taobao */
public final class a {
    public static char[] a = {YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', u91.LEVEL_I, 'J', 'K', u91.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', u91.LEVEL_V, u91.LEVEL_W, 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, '+', v00.DIR};
    public static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0047 A[EDGE_INSN: B:34:0x0047->B:16:0x0047 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0047 A[EDGE_INSN: B:35:0x0047->B:16:0x0047 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0047 A[EDGE_INSN: B:37:0x0047->B:16:0x0047 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023 A[LOOP:2: B:8:0x0023->B:11:0x0030, LOOP_START, PHI: r5 
      PHI: (r5v1 int) = (r5v0 int), (r5v9 int) binds: [B:7:0x0021, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    public static byte[] a(String str) {
        byte b2;
        byte b3;
        byte b4;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i = 0;
        loop0:
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                b2 = b[bytes[i]];
                if (i2 >= length || b2 != -1) {
                    if (b2 != -1) {
                        break;
                    }
                    while (true) {
                        int i3 = i2 + 1;
                        b3 = b[bytes[i2]];
                        if (i3 >= length || b3 != -1) {
                            if (b3 != -1) {
                                break;
                            }
                            stringBuffer.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
                            while (true) {
                                int i4 = i3 + 1;
                                byte b5 = bytes[i3];
                                if (b5 == 61) {
                                    break loop0;
                                }
                                b4 = b[b5];
                                if (i4 >= length || b4 != -1) {
                                    if (b4 != -1) {
                                        break;
                                    }
                                    stringBuffer.append((char) (((b3 & 15) << 4) | ((b4 & 60) >>> 2)));
                                    while (true) {
                                        int i5 = i4 + 1;
                                        byte b6 = bytes[i4];
                                        if (b6 == 61) {
                                            break loop0;
                                        }
                                        byte b7 = b[b6];
                                        if (i5 >= length || b7 != -1) {
                                            if (b7 == -1) {
                                                break;
                                            }
                                            stringBuffer.append((char) (b7 | ((b4 & 3) << 6)));
                                            i = i5;
                                        } else {
                                            i4 = i5;
                                        }
                                    }
                                } else {
                                    i3 = i4;
                                }
                            }
                            if (b4 != -1) {
                            }
                        } else {
                            i2 = i3;
                        }
                    }
                    if (b3 != -1) {
                    }
                } else {
                    i = i2;
                }
            }
            if (b2 != -1) {
            }
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
