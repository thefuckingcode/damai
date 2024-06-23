package org.android.agoo.assist.filter.devicechecker;

import com.vivo.push.PushClient;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.VivoOperator;

/* compiled from: Taobao */
public class VivoDeviceChecker extends DeviceChecker {
    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByBrand() {
        return DeviceChecker.mBrand.contains("vivo") || DeviceChecker.mBrand.contains("iqoo");
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByInvoke() {
        try {
            return PushClient.getInstance(this.mContext).isSupport();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public PhoneType getPhoneType() {
        return new PhoneType("vivo", AssistConstant.TOKEN_TYPE_VIVO, new VivoOperator());
    }
}
