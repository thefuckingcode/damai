package com.ali.user.open.ucc.remote.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.open.cookies.CookieManagerWrapper;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.FileUtils;
import com.ali.user.open.oauth.OauthService;

/* compiled from: Taobao */
public class UccBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "login.LoginBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.equals(action, UccResultAction.NOTIFY_UCC_LOGIN_SUCCESS.name())) {
                final String stringExtra = intent.getStringExtra("site");
                String stringExtra2 = intent.getStringExtra("process");
                if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.isEmpty(stringExtra) && !TextUtils.equals(stringExtra2, CommonUtils.getProcessName(context))) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() {
                        /* class com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver.AnonymousClass1 */

                        public void run() {
                            CookieManagerWrapper.INSTANCE.refreshCookie(stringExtra);
                        }
                    });
                }
            } else if (ConfigManager.getInstance().isMultiProcessEnable && TextUtils.equals(action, UccResultAction.NOTIFY_UCC_LOGOUT.name())) {
                final String stringExtra3 = intent.getStringExtra("site");
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() {
                    /* class com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver.AnonymousClass2 */

                    public void run() {
                        CookieManagerWrapper.INSTANCE.clearCookies(stringExtra3);
                    }
                });
            } else if (!TextUtils.equals(action, "NOTIFY_LOGIN_SUCCESS") && TextUtils.equals(action, "NOTIFY_LOGOUT")) {
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() {
                    /* class com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver.AnonymousClass3 */

                    public void run() {
                        CookieManagerWrapper cookieManagerWrapper = CookieManagerWrapper.INSTANCE;
                        cookieManagerWrapper.clearCookies(Site.ELEME, FileUtils.readFileData(KernelContext.getApplicationContext(), cookieManagerWrapper.getCoookieBackupFileNameBySite(Site.ELEME)));
                        ((OauthService) AliMemberSDK.getService(OauthService.class)).logoutAll(KernelContext.getApplicationContext());
                    }
                });
            }
        }
    }
}
