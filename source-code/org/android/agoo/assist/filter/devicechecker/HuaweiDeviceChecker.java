package org.android.agoo.assist.filter.devicechecker;

import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.HuaweiOperator;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class HuaweiDeviceChecker extends DeviceChecker {
    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByBrand() {
        return DeviceChecker.mBrand.equalsIgnoreCase("huawei") || DeviceChecker.mBrand.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR);
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByInvoke() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public PhoneType getPhoneType() {
        return new PhoneType("huawei", AssistConstant.TOKEN_TYPE_HW, new HuaweiOperator());
    }
}
