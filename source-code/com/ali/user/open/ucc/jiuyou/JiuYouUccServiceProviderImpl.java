package com.ali.user.open.ucc.jiuyou;

import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import java.util.Map;

/* compiled from: Taobao */
public class JiuYouUccServiceProviderImpl extends BaseUccServiceProvider {
    public static final String TAG = "AlipayUccServiceProviderImpl";

    @Override // com.ali.user.open.ucc.UccServiceProvider, com.ali.user.open.ucc.base.BaseUccServiceProvider
    public void cleanUp(Context context) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).logout(context, "jiuyou");
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    public boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return true;
    }
}
