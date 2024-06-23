package com.ali.user.open.tbauth;

import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.tbauth.handler.TbAuthActivityResultHandler;
import com.ali.user.open.tbauth.ui.support.ActivityResultHandler;

/* compiled from: Taobao */
public class TbAuthLifecycleAdapter {
    public static final String TAG = "Member.TbAuthLifecycleAdapter";

    public static void init() {
        CommonUtils.sendUT("init_step_ucc_init_tbauth_module");
        SDKLogger.d(TAG, "LoginLifecycle init ");
        Class[] clsArr = {ActivityResultHandler.class};
        KernelContext.registerService(clsArr, new TbAuthActivityResultHandler(), null);
        Class[] clsArr2 = {TbAuthService.class};
        KernelContext.registerService(clsArr2, new TbAuthServiceImpl(), null);
    }
}
