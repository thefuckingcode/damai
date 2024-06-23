package com.alipay.ma.common.result;

import com.alipay.ma.decode.DecodeType;

/* JADX WARN: Init of enum PRODUCT can be incorrect */
/* JADX WARN: Init of enum QR can be incorrect */
/* JADX WARN: Init of enum MEDICINE can be incorrect */
/* JADX WARN: Init of enum EXPRESS can be incorrect */
/* JADX WARN: Init of enum TB_ANTI_FAKE can be incorrect */
/* compiled from: Taobao */
public enum ResultMaType {
    PRODUCT(0, r1.getCodeType()),
    QR(1, r3.getCodeType()),
    MEDICINE(2, r1.getCodeType()),
    EXPRESS(2, r1.getCodeType()),
    TB_ANTI_FAKE(1, r3.getCodeType()),
    DM(1024, DecodeType.DMCODE.getCodeType()),
    PDF417(2048, DecodeType.PDF417.getCodeType()),
    NARROW(131072, DecodeType.NARROW.getCodeType()),
    ARCODE(65536, DecodeType.ARCODE.getCodeType()),
    HMCODE(262144, DecodeType.HMCODE.getCodeType());
    
    public static final int AR_CODE = 65536;
    public static final int BAR_CODE = 0;
    public static final int DM_CODE = 1024;
    public static final int EXPRESS_CODE = 2;
    public static final int HM_CODE = 262144;
    public static final int NARROW_CODE = 131072;
    public static final int PDF417_CODE = 2048;
    public static final int QR_CODE = 1;
    private int discernType;
    private int type;

    static {
        DecodeType decodeType = DecodeType.ONECODE;
        DecodeType decodeType2 = DecodeType.QRCODE;
    }

    private ResultMaType(int i, int i2) {
        this.type = i;
        this.discernType = i2;
    }

    public int getDiscernType() {
        return this.discernType;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
