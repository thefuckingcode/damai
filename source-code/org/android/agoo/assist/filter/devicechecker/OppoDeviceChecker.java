package org.android.agoo.assist.filter.devicechecker;

import android.content.Context;
import com.heytap.msp.push.HeytapPushManager;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.OppoOperator;

/* compiled from: Taobao */
public class OppoDeviceChecker extends DeviceChecker {
    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByBrand() {
        return "oppo".equals(DeviceChecker.mBrand) || "realme".equals(DeviceChecker.mBrand) || "oneplus".equals(DeviceChecker.mBrand);
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public boolean checkByInvoke() {
        try {
            Context context = this.mContext;
            HeytapPushManager.init(context, (context.getApplicationInfo().flags & 2) != 0);
            return HeytapPushManager.isSupportPush(this.mContext);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.android.agoo.assist.filter.DeviceChecker
    public PhoneType getPhoneType() {
        return new PhoneType("oppo", AssistConstant.TOKEN_TYPE_OPPO, new OppoOperator());
    }
}
