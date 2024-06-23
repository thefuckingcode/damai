package org.android.agoo.assist.filter.devicechecker;

import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.XiaomiOperator;

/* compiled from: Taobao */
public class XiaomiDeviceChecker extends DeviceChecker {
    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByBrand() {
        return "xiaomi".equals(DeviceChecker.mBrand) || "redmi".equals(DeviceChecker.mBrand) || "blackshark".equals(DeviceChecker.mBrand);
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByInvoke() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public PhoneType getPhoneType() {
        return new PhoneType("xiaomi", AssistConstant.TOKEN_TYPE_XM, new XiaomiOperator());
    }
}
