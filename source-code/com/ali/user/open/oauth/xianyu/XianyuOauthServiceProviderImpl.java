package com.ali.user.open.oauth.xianyu;

import android.app.Activity;
import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.ali.user.open.service.SessionService;
import com.alibaba.fastjson.JSON;
import java.util.Map;

/* compiled from: Taobao */
public class XianyuOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "oa.XianyuOauthServiceProviderImpl";

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        ((SessionService) AliMemberSDK.getService(SessionService.class)).logout(Site.XIANYU);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void refreshWhenLogin(String str, boolean z) {
        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin(Site.XIANYU, (LoginReturnData) JSON.parseObject(str, LoginReturnData.class));
    }
}
