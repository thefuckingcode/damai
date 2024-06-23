package com.ali.user.open.ucc.alipay3;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import java.util.Map;

/* compiled from: Taobao */
public class AlipayUccServiceProviderImpl extends BaseUccServiceProvider {
    public static final String TAG = "AlipayUccServiceProviderImpl";

    @Override // com.ali.user.open.ucc.UccServiceProvider, com.ali.user.open.ucc.base.BaseUccServiceProvider
    public void cleanUp(Context context) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).logout(context, "alipay");
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    public boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return map != null && TextUtils.equals(map.get(ParamsConstants.Key.PARAM_FORCE_NATIVE), "1");
    }
}
