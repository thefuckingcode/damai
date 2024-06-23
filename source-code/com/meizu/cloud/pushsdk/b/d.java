package com.meizu.cloud.pushsdk.b;

import com.youku.upsplayer.util.YKUpsConvert;
import org.apache.commons.lang3.CharUtils;
import tb.jl1;
import tb.u91;
import tb.v00;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class d {
    private static final char[] a = {YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', u91.LEVEL_I, 'J', 'K', u91.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', u91.LEVEL_V, u91.LEVEL_W, 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, '+', v00.DIR};
    private static final char b = ((char) Integer.parseInt("00000011", 2));
    private static final char c = ((char) Integer.parseInt("00001111", 2));
    private static final char d = ((char) Integer.parseInt("00111111", 2));
    private final String e;
    private char[] f;
    private int g = 0;

    public d(String str) {
        this.e = str;
        a();
    }

    private void a() {
        char[] cArr = new char[a.length];
        int i = 0;
        this.g = this.e.charAt(0) % CharUtils.CR;
        while (true) {
            char[] cArr2 = a;
            if (i < cArr2.length) {
                cArr[i] = cArr2[(this.g + i) % cArr2.length];
                i++;
            } else {
                this.f = cArr;
                return;
            }
        }
    }

    public String a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i = 0;
        int length = bArr.length;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                sb.append(this.f[i3 >>> 2]);
                sb.append(this.f[(i3 & b) << 4]);
                str = jl1.EQUAL2;
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                sb.append(this.f[i3 >>> 2]);
                sb.append(this.f[((i3 & b) << 4) | (i5 >>> 4)]);
                sb.append(this.f[(c & i5) << 2]);
                str = "=";
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            sb.append(this.f[i3 >>> 2]);
            sb.append(this.f[((i3 & b) << 4) | (i5 >>> 4)]);
            sb.append(this.f[((i5 & c) << 2) | (i7 >>> 6)]);
            sb.append(this.f[d & i7]);
            i = i6;
        }
        sb.append(str);
        return sb.toString();
    }
}
