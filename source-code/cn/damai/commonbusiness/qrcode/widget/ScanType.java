package cn.damai.commonbusiness.qrcode.widget;

import android.text.TextUtils;

/* compiled from: Taobao */
public enum ScanType {
    SCAN_MA("MA");
    
    private String value;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScanType.values().length];
            a = iArr;
            try {
                iArr[ScanType.SCAN_MA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private ScanType(String str) {
        this.value = str;
    }

    public static ScanType getType(String str) {
        ScanType[] values = values();
        for (ScanType scanType : values) {
            if (TextUtils.equals(scanType.value, str)) {
                return scanType;
            }
        }
        return SCAN_MA;
    }

    public String toBqcScanType() {
        int i = a.a[ordinal()];
        return "MA";
    }
}
