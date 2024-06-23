package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
public class d {
    public static ErrorEnum a(Context context) {
        if (!TextUtils.isEmpty(BaseUtils.getLocalToken(context, null))) {
            return ErrorEnum.SUCCESS;
        }
        if (AutoInitHelper.isAutoInitEnabled(context)) {
            HMSLog.e("TokenUtil", "Token not exist, try auto init");
            AutoInitHelper.doAutoInit(context);
            return ErrorEnum.ERROR_AUTO_INITIALIZING;
        }
        HMSLog.e("TokenUtil", "Token not exist");
        return ErrorEnum.ERROR_NO_TOKEN;
    }
}
