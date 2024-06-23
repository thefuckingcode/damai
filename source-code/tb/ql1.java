package tb;

import android.text.TextUtils;
import cn.damai.ticklet.bean.UserTicketTable;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ql1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x012e, code lost:
        if (r1.equals("1") == false) goto L_0x0130;
     */
    public static int a(UserTicketTable userTicketTable) {
        char c;
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-302334115")) {
            return ((Integer) ipChange.ipc$dispatch("-302334115", new Object[]{userTicketTable})).intValue();
        } else if (userTicketTable == null) {
            return 0;
        } else {
            String voucherType = userTicketTable.getVoucherType();
            voucherType.hashCode();
            char c2 = 65535;
            switch (voucherType.hashCode()) {
                case 49:
                    if (voucherType.equals("1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (voucherType.equals("2")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    if (voucherType.equals("3")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 52:
                    if (voucherType.equals("4")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 53:
                    if (voucherType.equals("5")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 54:
                    if (voucherType.equals("6")) {
                        c = 5;
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
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 5;
                    break;
                case 3:
                    i = 6;
                    break;
                case 4:
                    i = 4;
                    break;
                case 5:
                    i = 3;
                    break;
                default:
                    i = 0;
                    break;
            }
            String voucherState = userTicketTable.getVoucherState();
            voucherState.hashCode();
            switch (voucherState.hashCode()) {
                case 49:
                    if (voucherState.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (voucherState.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (voucherState.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 52:
                    if (voucherState.equals("4")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 53:
                    if (voucherState.equals("5")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 54:
                    if (voucherState.equals("6")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 55:
                    if (voucherState.equals("7")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 56:
                    if (voucherState.equals("8")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 57:
                    if (voucherState.equals("9")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case SecExceptionCode.SEC_ERROR_SIMULATORDETECT_UNSUPPORTED:
                    if (voucherState.equals("20")) {
                        c2 = '\t';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    i2 = 2;
                    break;
                case 1:
                    i2 = 5;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                    i2 = 9;
                    break;
                case 4:
                    i2 = 10;
                    break;
                case 5:
                    i2 = 4;
                    break;
                case 6:
                    i2 = 8;
                    break;
                case 7:
                    i2 = 3;
                    break;
                case '\b':
                    i2 = 7;
                    break;
                case '\t':
                    i2 = 1;
                    break;
            }
            if (!TextUtils.isEmpty(userTicketTable.getVoucherSubType())) {
                String voucherSubType = userTicketTable.getVoucherSubType();
                voucherSubType.hashCode();
            }
            i3 = 2;
            return (i2 * 10000) + (i * 100) + i3;
        }
    }
}
