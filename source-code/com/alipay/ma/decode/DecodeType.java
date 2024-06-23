package com.alipay.ma.decode;

import java.util.ArrayList;

/* JADX WARN: Init of enum ONECODE can be incorrect */
/* JADX WARN: Init of enum FASTMAIL can be incorrect */
/* JADX WARN: Init of enum PRODUCT can be incorrect */
/* JADX WARN: Init of enum MEDICINE can be incorrect */
/* JADX WARN: Init of enum EXPRESS can be incorrect */
/* JADX WARN: Init of enum ALLQRCODE can be incorrect */
/* JADX WARN: Init of enum ALLBARCODE can be incorrect */
/* JADX WARN: Init of enum ALLLOTTERYCODE can be incorrect */
/* JADX WARN: Init of enum ALLCODE can be incorrect */
/* JADX WARN: Init of enum DEFAULTCODE can be incorrect */
/* compiled from: Taobao */
public enum DecodeType {
    EAN13(1),
    EAN8(2),
    UPCA(4),
    UPCE(8),
    EAN14(128),
    CODE39(16),
    CODE93(256),
    CODE128(32),
    ITF(64),
    QRCODE(512),
    DMCODE(1024),
    PDF417(2048),
    NARROW(131072),
    HMCODE(262144),
    ARCODE(65536),
    ONECODE((((((((r1.codeType | r0.codeType) | r4.codeType) | r6.codeType) | r11.codeType) | r7.codeType) | r9.codeType) | r8.codeType) | r12.codeType),
    FASTMAIL(r7.codeType | r11.codeType),
    PRODUCT(r14.codeType),
    MEDICINE(r14.codeType),
    EXPRESS(r14.codeType),
    ALLQRCODE(r13.codeType),
    ALLBARCODE(r14.codeType),
    ALLLOTTERYCODE(r3.codeType | r5.codeType),
    ALLCODE((((r14.codeType | r7.codeType) | r5.codeType) | r2.codeType) | r3.codeType),
    DEFAULTCODE(r14.codeType | ((((r14.codeType | r7.codeType) | r2.codeType) | r5.codeType) | r3.codeType));
    
    int codeType;

    private DecodeType(int i) {
        this.codeType = i;
    }

    public static int getCode(DecodeType decodeType, String str) {
        if (decodeType == null && str == null) {
            return DEFAULTCODE.getCodeType();
        }
        int codeType2 = decodeType != null ? decodeType.getCodeType() : 0;
        if (str == null) {
            return codeType2;
        }
        if (str.contains("default")) {
            codeType2 |= DEFAULTCODE.getCodeType();
        }
        if (str.contains("barCode")) {
            codeType2 |= ALLBARCODE.getCodeType();
        }
        if (str.contains("qrCode")) {
            codeType2 |= ALLQRCODE.getCodeType();
        }
        if (str.contains("dmCode")) {
            codeType2 |= DMCODE.getCodeType();
        }
        if (str.contains("pdf417Code")) {
            codeType2 |= PDF417.getCodeType();
        }
        if (str.contains("narrowCode")) {
            codeType2 |= NARROW.getCodeType();
        }
        return str.contains("hmCode") ? codeType2 | HMCODE.getCodeType() : codeType2;
    }

    public static DecodeType[] getCodeTypes(DecodeType decodeType, String str) {
        if (decodeType == null && str == null) {
            return new DecodeType[]{DEFAULTCODE};
        }
        ArrayList arrayList = new ArrayList();
        if (decodeType != null) {
            arrayList.add(decodeType);
        }
        if (str != null) {
            if (str.contains("default")) {
                arrayList.add(DEFAULTCODE);
            }
            if (str.contains("barCode")) {
                arrayList.add(ALLBARCODE);
            }
            if (str.contains("qrCode")) {
                arrayList.add(ALLQRCODE);
            }
            if (str.contains("dmCode")) {
                arrayList.add(DMCODE);
            }
            if (str.contains("pdf417Code")) {
                arrayList.add(PDF417);
            }
            if (str.contains("narrowCode")) {
                arrayList.add(NARROW);
            }
            if (str.contains("hmCode")) {
                arrayList.add(HMCODE);
            }
        }
        if (str.length() == 0) {
            arrayList.add(DEFAULTCODE);
        }
        return (DecodeType[]) arrayList.toArray(new DecodeType[arrayList.size()]);
    }

    public int getCodeType() {
        return this.codeType;
    }
}
