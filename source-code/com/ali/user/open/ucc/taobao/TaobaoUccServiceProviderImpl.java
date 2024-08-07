package com.ali.user.open.ucc.taobao;

import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import com.alibaba.fastjson.JSON;
import java.util.Map;

/* compiled from: Taobao */
public class TaobaoUccServiceProviderImpl extends BaseUccServiceProvider {
    public static final String TAG = "TaobaoUccServiceProviderImpl";

    @Override // com.ali.user.open.ucc.UccServiceProvider, com.ali.user.open.ucc.base.BaseUccServiceProvider
    public void cleanUp(Context context) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).logout(context, "taobao");
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    public boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return ((OauthService) AliMemberSDK.getService(OauthService.class)).isAppAuthSurpport(context, str);
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider, com.ali.user.open.ucc.base.BaseUccServiceProvider
    public void refreshWhenLogin(String str, String str2, boolean z) {
        LoginReturnData loginReturnData = (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class);
        if (z) {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(".taobao.com", loginReturnData);
        } else {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", loginReturnData);
        }
    }
}
