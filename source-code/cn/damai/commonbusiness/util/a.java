package cn.damai.commonbusiness.util;

import android.text.TextUtils;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class a implements Bitmap12ColorHex.OnHexColorListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public abstract void a(int i);

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00af, code lost:
        if (r7.equals(cn.damai.commonbusiness.util.Bitmap12ColorHex.C_HEX_40AAC8) == false) goto L_0x002f;
     */
    @Override // cn.damai.commonbusiness.util.Bitmap12ColorHex.OnHexColorListener
    public void onHexColor(String str) {
        int i;
        IpChange ipChange = $ipChange;
        char c = 1;
        if (AndroidInstantRuntime.support(ipChange, "1695815641")) {
            ipChange.ipc$dispatch("1695815641", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            a(R$drawable.bg_b_card_red_3);
        } else {
            str.hashCode();
            switch (str.hashCode()) {
                case -1770624217:
                    if (str.equals(Bitmap12ColorHex.C_HEX_3F96D8)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1762063660:
                    break;
                case -1742668107:
                    if (str.equals(Bitmap12ColorHex.C_HEX_4EAC98)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1731005442:
                    if (str.equals(Bitmap12ColorHex.C_HEX_536388)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1685694003:
                    if (str.equals("#6E82AB")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1675561140:
                    if (str.equals(Bitmap12ColorHex.C_HEX_7176D4)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1639213697:
                    if (str.equals(Bitmap12ColorHex.C_HEX_89B959)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1613733329:
                    if (str.equals("#965BBD")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1285015979:
                    if (str.equals(Bitmap12ColorHex.C_HEX_DE3F64)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1270196455:
                    if (str.equals(Bitmap12ColorHex.C_HEX_E65549)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1268286023:
                    if (str.equals(Bitmap12ColorHex.C_HEX_E87934)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -1255987112:
                    if (str.equals(Bitmap12ColorHex.C_HEX_EEA446)) {
                        c = 11;
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
                case 1:
                    i = R$drawable.abg_b_blue_4;
                    break;
                case 2:
                case 6:
                    i = R$drawable.abg_b_greed_4;
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    i = R$drawable.abg_b_purple_default_4;
                    break;
                case '\b':
                case '\t':
                    i = R$drawable.abg_b_red_4;
                    break;
                case '\n':
                case 11:
                    i = R$drawable.abg_b_yellow_4;
                    break;
                default:
                    i = R$drawable.abg_b_purple_default_4;
                    break;
            }
            a(i);
        }
    }
}
