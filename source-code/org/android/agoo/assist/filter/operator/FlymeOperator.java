package org.android.agoo.assist.filter.operator;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.taobao.accs.utl.ALog;
import org.android.agoo.assist.AssistCallback;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.filter.Operator;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class FlymeOperator extends Operator {
    private static final String TAG = "FlymeOperator";

    @Override // org.android.agoo.assist.filter.Operator
    public void onPayload(String str) {
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onRegister(AssistCallback assistCallback) {
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            assistCallback.onRegisterFlyme(this.context, applicationInfo.metaData.getString(AssistConstant.META_DATA.MZ_APP_ID).replace("appid=", ""), applicationInfo.metaData.getString(AssistConstant.META_DATA.MZ_APP_KEY).replace("appkey=", ""));
        } catch (Exception e) {
            ALog.e(TAG, "onRegister", e, new Object[0]);
        }
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onToken(String str) {
    }

    @Override // org.android.agoo.assist.filter.Operator
    public String parseMsgFromIntent(Intent intent) {
        return intent.getStringExtra(AgooConstants.MESSAGE_MEIZU_PAYLOAD);
    }
}
