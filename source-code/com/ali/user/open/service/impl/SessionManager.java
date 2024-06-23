package com.ali.user.open.service.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.open.cookies.CookieManagerService;
import com.ali.user.open.cookies.CookieManagerWrapper;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.DeviceTokenRO;
import com.ali.user.open.core.model.LoginDataModel;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.core.util.ReflectionUtils;
import com.ali.user.open.history.AccountHistoryManager;
import com.ali.user.open.history.HistoryAccount;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.InternalSession;
import com.ali.user.open.session.Session;
import com.ali.user.open.util.SessionUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.accs.common.Constants;
import com.taobao.login4android.session.constants.SessionConstants;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.usercenter.passport.util.CookieUtil;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class SessionManager implements SessionService {
    public static final String COOKIE_KEY_STOEKN = "P_sck";
    public static final SessionManager INSTANCE = new SessionManager();
    private static final String TAG = "SessionManager";
    private volatile InternalSession internalSession;
    public String internalSessionMapKey = "internal_session_list";
    public String internalSessionStoreKey = "internal_session";
    private volatile Map<String, InternalSession> mIntenalSessions;

    public SessionManager() {
        CommonUtils.sendUT("init_step_ucc_init_session_module");
        try {
            preInit();
        } catch (Throwable unused) {
            this.internalSession = new InternalSession();
            this.mIntenalSessions = new HashMap();
        }
    }

    private void buildYoukuExt(InternalSession internalSession2, Map<String, String> map) {
        if (map != null && internalSession2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(JSON.toJSONString(map)).optString("youkuExt")).optString("content"));
                JSONObject optJSONObject = jSONObject.optJSONObject("sessionInfo");
                long optLong = optJSONObject.optLong("cookieExpireTime");
                optJSONObject.optString("ptoken");
                String optString = optJSONObject.optString(IRequestConst.STOKEN);
                long optLong2 = optJSONObject.optLong(SessionConstants.LOGIN_TIME);
                optJSONObject.optInt("site");
                JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.KEY_USER_ID);
                optJSONObject2.optString(CookieUtil.COOKIE_KEY_YKTK);
                String optString2 = optJSONObject2.optString("ytid");
                optJSONObject2.optString("yid");
                optJSONObject2.optString("tid");
                optJSONObject2.optString("uid");
                String optString3 = optJSONObject2.optString("nickname");
                String optString4 = optJSONObject2.optString("avatar");
                optJSONObject2.optString("loginEmail");
                String str = null;
                JSONObject optJSONObject3 = jSONObject.optJSONObject("userProfile");
                if (optJSONObject3 != null) {
                    optJSONObject3.optString(RegistConstants.REGION_INFO);
                    str = optJSONObject3.optString("mobile");
                    optJSONObject3.optBoolean("hasMobile");
                    optJSONObject3.optBoolean("isLoginMobile");
                    optJSONObject3.optString("maskMobile");
                    optJSONObject3.optString("noRegionMobile");
                }
                jSONObject.optJSONObject("sdkCookieInfo");
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("domians");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        CookieManagerWrapper cookieManagerWrapper = CookieManagerWrapper.INSTANCE;
                        CookieManagerService.getWebViewProxy().setCookie(optJSONArray.getString(i), CookieManagerWrapper.generateCookie(optJSONArray.getString(i), "P_sck", optString, true));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                internalSession2.userId = optString2;
                internalSession2.avatarUrl = optString4;
                internalSession2.mobile = str;
                internalSession2.loginTime = optLong2;
                internalSession2.sid = optString;
                internalSession2.expireIn = adjustSessionExpireTime(optLong, optLong2);
                internalSession2.loginTime = optLong2;
                internalSession2.nick = optString3;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private Object getServiceInstance(String str, String[] strArr, Object[] objArr) {
        try {
            return ReflectionUtils.newInstance(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    private void preInit() throws JSONException {
        InternalSession createInternalSession;
        if (AliMemberSDK.getService(StorageService.class) == null) {
            registerStorage();
        }
        String value = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue("loginEnvironmentIndex", true);
        String valueOf = String.valueOf(KernelContext.getEnvironment().ordinal());
        if (value == null || value.equals(valueOf)) {
            String value2 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionMapKey, true);
            if (TextUtils.isEmpty(value2)) {
                value2 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionMapKey, true);
            }
            String value3 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionStoreKey, true);
            if (TextUtils.isEmpty(value3)) {
                value3 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionStoreKey, true);
            }
            this.mIntenalSessions = new HashMap();
            if (!TextUtils.isEmpty(value2)) {
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(value2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i)) && (createInternalSession = createInternalSession(jSONArray.optString(i))) != null && !TextUtils.isEmpty(createInternalSession.site)) {
                        this.mIntenalSessions.put(createInternalSession.site, createInternalSession);
                    }
                }
            }
            if (!TextUtils.isEmpty(value3)) {
                this.internalSession = createInternalSession(value3);
                if (this.internalSession == null) {
                    return;
                }
                if (!TextUtils.isEmpty(this.internalSession.site)) {
                    this.mIntenalSessions.put(this.internalSession.site, this.internalSession);
                } else {
                    this.mIntenalSessions.put("taobao", this.internalSession);
                }
            } else {
                this.internalSession = new InternalSession();
            }
        } else {
            ((StorageService) AliMemberSDK.getService(StorageService.class)).putValue("loginEnvironmentIndex", valueOf, true);
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeValue(this.internalSessionStoreKey, true);
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeValue(this.internalSessionMapKey, true);
            this.internalSession = new InternalSession();
            this.mIntenalSessions = new HashMap();
        }
    }

    private void refreshInternalSession(InternalSession internalSession2) {
        this.internalSession = internalSession2;
        ((StorageService) AliMemberSDK.getService(StorageService.class)).putValue(this.internalSessionStoreKey, SessionUtils.toInternalSessionJSON(internalSession2), true);
        if (this.mIntenalSessions != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, InternalSession> entry : this.mIntenalSessions.entrySet()) {
                InternalSession value = entry.getValue();
                if (value != null) {
                    jSONArray.put(SessionUtils.toInternalSessionJSON(value));
                }
            }
            ((StorageService) AliMemberSDK.getService(StorageService.class)).putValue(this.internalSessionMapKey, jSONArray.toString(), true);
        }
        if (KernelContext.getApplicationContext() != null) {
            Intent intent = new Intent();
            intent.setAction("aliuser_sync_session");
            intent.setPackage(KernelContext.getApplicationContext().getPackageName());
            KernelContext.getApplicationContext().sendBroadcast(intent);
        }
    }

    private void registerStorage() {
        try {
            Class[] clsArr = {StorageService.class};
            KernelContext.registerService(clsArr, getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null), null);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    public long adjustSessionExpireTime(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > j2) {
            return j > 0 ? j + (currentTimeMillis - j2) : 86400 + currentTimeMillis;
        }
        return j;
    }

    public InternalSession createInternalSession(String str) {
        return createInternalSession("", str);
    }

    public Set<String> getAllSessionSites() {
        if (this.mIntenalSessions == null) {
            return null;
        }
        this.mIntenalSessions.keySet();
        return null;
    }

    public InternalSession getInternalSession() {
        return this.internalSession;
    }

    @Override // com.ali.user.open.service.SessionService
    public Session getSession() {
        Session session = new Session();
        String str = "";
        session.nick = this.internalSession == null ? str : this.internalSession.nick;
        session.hid = this.internalSession == null ? str : this.internalSession.userId;
        session.sid = this.internalSession == null ? str : this.internalSession.sid;
        long j = 0;
        session.loginTime = this.internalSession == null ? 0 : this.internalSession.loginTime;
        if (this.internalSession != null) {
            j = this.internalSession.expireIn;
        }
        session.expireIn = j;
        session.avatarUrl = this.internalSession == null ? str : this.internalSession.avatarUrl;
        session.openId = this.internalSession == null ? str : this.internalSession.openId;
        session.openSid = this.internalSession == null ? str : this.internalSession.openSid;
        session.topAccessToken = this.internalSession == null ? str : this.internalSession.topAccessToken;
        session.topAuthCode = this.internalSession == null ? str : this.internalSession.topAuthCode;
        session.topExpireTime = this.internalSession == null ? str : this.internalSession.topExpireTime;
        if (this.internalSession != null) {
            str = this.internalSession.bindToken;
        }
        session.bindToken = str;
        return session;
    }

    public String getSessionData() {
        try {
            return ((StorageService) getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null)).getValue(this.internalSessionStoreKey, true);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.ali.user.open.service.SessionService
    public boolean isSessionValid() {
        String str = TAG;
        SDKLogger.d(str, "func isSessionValid");
        if (this.internalSession == null || TextUtils.isEmpty(this.internalSession.sid)) {
            SDKLogger.d(str, "isSessionValid()  internalSession is null");
            return false;
        } else if (this.internalSession.loginTime == 0 || this.internalSession.expireIn == 0) {
            SDKLogger.d(str, "isSessionValid()  loginTime is 0 or expireIn is 0");
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("isSessionValid()  ");
            sb.append(System.currentTimeMillis() / 1000 < this.internalSession.expireIn);
            SDKLogger.d(str, sb.toString());
            if (System.currentTimeMillis() / 1000 < this.internalSession.expireIn) {
                return true;
            }
            return false;
        }
    }

    @Override // com.ali.user.open.service.SessionService
    public ResultCode logout(String str) {
        CookieManagerWrapper.INSTANCE.clearCookies(str);
        InternalSession internalSession2 = new InternalSession();
        if (this.mIntenalSessions != null) {
            this.mIntenalSessions.remove(str);
        }
        refreshInternalSession(internalSession2);
        if (!TextUtils.isEmpty(Site.getMtopInstanceTag(str))) {
            ((RpcService) AliMemberSDK.getService(RpcService.class)).logout(Site.getMtopInstanceTag(str));
        }
        return ResultCode.SUCCESS;
    }

    @Override // com.ali.user.open.service.SessionService
    public void refreshCookie(String str, LoginReturnData loginReturnData) {
        if (loginReturnData != null && !TextUtils.isEmpty(loginReturnData.data)) {
            try {
                LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
                String[] strArr = null;
                Map<String, Object> map = loginDataModel.extendAttribute;
                if (map != null) {
                    try {
                        Object obj = map.get(SessionConstants.SSO_DOMAIN_LIST);
                        if (obj != null && (obj instanceof ArrayList)) {
                            strArr = (String[]) ((ArrayList) obj).toArray(new String[0]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                CookieManagerWrapper.INSTANCE.injectCookie(str, loginDataModel.cookies, strArr);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ed  */
    @Override // com.ali.user.open.service.SessionService
    public void refreshWhenLogin(String str, LoginReturnData loginReturnData) {
        Map<String, String> map;
        if (loginReturnData != null && !TextUtils.isEmpty(loginReturnData.data)) {
            InternalSession internalSession2 = new InternalSession();
            try {
                LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
                internalSession2.site = str;
                Map<String, String> map2 = loginDataModel.loginServiceExt;
                if (map2 == null || !map2.containsKey("youkuExt")) {
                    internalSession2.externalCookies = loginDataModel.externalCookies;
                    internalSession2.userId = loginDataModel.userId;
                    String str2 = loginDataModel.nick;
                    if (str2 != null) {
                        try {
                            internalSession2.nick = URLDecoder.decode(str2, "UTF-8");
                        } catch (Exception e) {
                            SDKLogger.e(TAG, e.getMessage(), e);
                        }
                    }
                    internalSession2.openId = loginDataModel.openId;
                    internalSession2.openSid = loginDataModel.openSid;
                    internalSession2.avatarUrl = loginDataModel.headPicLink;
                    internalSession2.email = loginDataModel.email;
                    DeviceTokenRO deviceTokenRO = loginReturnData.deviceToken;
                    if (deviceTokenRO != null) {
                        internalSession2.deviceTokenSalt = deviceTokenRO.salt;
                        internalSession2.deviceTokenKey = deviceTokenRO.key;
                    }
                    if (TextUtils.equals(str, "taobao")) {
                        AccountHistoryManager.getInstance().putLoginHistory(new HistoryAccount(loginDataModel.userId, internalSession2.deviceTokenKey, loginDataModel.nick, loginDataModel.phone, loginDataModel.email), internalSession2.deviceTokenSalt);
                    }
                    long j = loginDataModel.loginTime;
                    internalSession2.loginTime = j;
                    internalSession2.sid = loginDataModel.sid;
                    internalSession2.expireIn = adjustSessionExpireTime(loginDataModel.expires, j);
                    internalSession2.mobile = loginDataModel.loginPhone;
                    internalSession2.loginId = loginReturnData.showLoginId;
                    internalSession2.autoLoginToken = loginDataModel.autoLoginToken;
                    internalSession2.topAccessToken = loginDataModel.topAccessToken;
                    internalSession2.topAuthCode = loginDataModel.topAuthCode;
                    internalSession2.topExpireTime = loginDataModel.topExpireTime;
                    Map<String, Object> map3 = loginDataModel.extendAttribute;
                    internalSession2.otherInfo = map3;
                    String[] strArr = null;
                    if (map3 != null) {
                        try {
                            Object obj = map3.get(SessionConstants.SSO_DOMAIN_LIST);
                            if (obj != null && (obj instanceof ArrayList)) {
                                strArr = (String[]) ((ArrayList) obj).toArray(new String[0]);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    CookieManagerWrapper.INSTANCE.injectCookie(str, loginDataModel.cookies, strArr);
                    map = loginReturnData.extMap;
                    if (map != null) {
                        internalSession2.bindToken = map.get("bind_token");
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("site", str);
                    hashMap.put("sid", internalSession2.sid);
                    CommonUtils.sendUT("ucc_register_to_mtop_site", hashMap);
                    if (!TextUtils.isEmpty(Site.getMtopInstanceTag(str)) && TextUtils.equals(KernelContext.getApplicationContext().getPackageName(), CommonUtils.getProcessName(KernelContext.getApplicationContext()))) {
                        ((RpcService) AliMemberSDK.getService(RpcService.class)).registerSessionInfo(Site.getMtopInstanceTag(str), internalSession2.sid, internalSession2.userId);
                    }
                    SDKLogger.d(Preloader.KEY_SESSION, "session = " + internalSession2.toString());
                    this.mIntenalSessions.put(str, internalSession2);
                    refreshInternalSession(internalSession2);
                }
                buildYoukuExt(internalSession2, loginDataModel.loginServiceExt);
                map = loginReturnData.extMap;
                if (map != null) {
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("site", str);
                hashMap2.put("sid", internalSession2.sid);
                CommonUtils.sendUT("ucc_register_to_mtop_site", hashMap2);
                ((RpcService) AliMemberSDK.getService(RpcService.class)).registerSessionInfo(Site.getMtopInstanceTag(str), internalSession2.sid, internalSession2.userId);
                SDKLogger.d(Preloader.KEY_SESSION, "session = " + internalSession2.toString());
                this.mIntenalSessions.put(str, internalSession2);
                refreshInternalSession(internalSession2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void reloadSession() {
        try {
            StorageService storageService = (StorageService) getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null);
            String value = storageService.getValue(this.internalSessionStoreKey, true);
            if (TextUtils.isEmpty(value)) {
                value = storageService.getValue(this.internalSessionStoreKey, true);
            }
            if (!TextUtils.isEmpty(value)) {
                this.internalSession = createInternalSession("taobao", value);
                storageService.putValue(this.internalSessionStoreKey, SessionUtils.toInternalSessionJSON(this.internalSession), true);
                if (this.mIntenalSessions == null) {
                    this.mIntenalSessions = new HashMap();
                }
                if (!TextUtils.isEmpty(this.internalSession.site)) {
                    this.mIntenalSessions.put(this.internalSession.site, this.internalSession);
                } else {
                    this.mIntenalSessions.put("taobao", this.internalSession);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public InternalSession createInternalSession(String str, String str2) {
        InternalSession internalSession2 = new InternalSession();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            internalSession2.sid = JSONUtils.optString(jSONObject, "sid");
            if (TextUtils.isEmpty(str)) {
                internalSession2.site = JSONUtils.optString(jSONObject, "site");
            } else {
                internalSession2.site = str;
            }
            internalSession2.expireIn = (long) JSONUtils.optInteger(jSONObject, "expireIn").intValue();
            internalSession2.avatarUrl = JSONUtils.optString(jSONObject, "avatarUrl");
            internalSession2.userId = JSONUtils.optString(jSONObject, "userId");
            internalSession2.nick = JSONUtils.optString(jSONObject, "nick");
            internalSession2.openId = JSONUtils.optString(jSONObject, "openId");
            internalSession2.openSid = JSONUtils.optString(jSONObject, "openSid");
            internalSession2.deviceTokenKey = JSONUtils.optString(jSONObject, "deviceTokenKey");
            internalSession2.deviceTokenSalt = JSONUtils.optString(jSONObject, "deviceTokenSalt");
            if (!TextUtils.isEmpty(internalSession2.sid) && !TextUtils.isEmpty(internalSession2.userId) && TextUtils.equals(KernelContext.getApplicationContext().getPackageName(), CommonUtils.getProcessName(KernelContext.getApplicationContext()))) {
                if (ConfigManager.getInstance().isRegisterSidToMtopDefault()) {
                    CommonUtils.sendUT("ucc_register_to_mtop");
                    ((RpcService) AliMemberSDK.getService(RpcService.class)).registerSessionInfo(null, internalSession2.sid, internalSession2.userId);
                } else if (!TextUtils.isEmpty(internalSession2.site)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("site", internalSession2.site);
                    hashMap.put("sid", internalSession2.sid);
                    CommonUtils.sendUT("ucc_register_to_mtop_site", hashMap);
                    if (!TextUtils.isEmpty(Site.getMtopInstanceTag(internalSession2.site))) {
                        ((RpcService) AliMemberSDK.getService(RpcService.class)).registerSessionInfo(Site.getMtopInstanceTag(internalSession2.site), internalSession2.sid, internalSession2.userId);
                    }
                }
            }
            internalSession2.loginTime = JSONUtils.optLong(jSONObject, SessionConstants.LOGIN_TIME).longValue();
            internalSession2.mobile = JSONUtils.optString(jSONObject, "mobile");
            internalSession2.loginId = JSONUtils.optString(jSONObject, "loginId");
            internalSession2.autoLoginToken = JSONUtils.optString(jSONObject, "autoLoginToken");
            internalSession2.topAccessToken = JSONUtils.optString(jSONObject, "topAccessToken");
            internalSession2.topExpireTime = JSONUtils.optString(jSONObject, "topExpireTime");
            internalSession2.topAuthCode = JSONUtils.optString(jSONObject, "topAuthCode");
            internalSession2.otherInfo = JSONUtils.toMap(jSONObject.optJSONObject("otherInfo"));
        } catch (Throwable th) {
            SDKLogger.e(TAG, th.getMessage(), th);
        }
        return internalSession2;
    }

    public InternalSession getInternalSession(String str) {
        if (this.mIntenalSessions == null) {
            return null;
        }
        return this.mIntenalSessions.get(str);
    }

    @Override // com.ali.user.open.service.SessionService
    public boolean isSessionValid(String str) {
        String str2 = TAG;
        SDKLogger.d(str2, "func isSessionValid");
        if (this.mIntenalSessions == null || this.mIntenalSessions.get(str) == null || TextUtils.isEmpty(this.mIntenalSessions.get(str).sid)) {
            SDKLogger.d(str2, "isSessionValid()  internalSession is null");
            return false;
        }
        InternalSession internalSession2 = this.mIntenalSessions.get(str);
        if (internalSession2.loginTime == 0 || internalSession2.expireIn == 0) {
            SDKLogger.d(str2, "isSessionValid()  loginTime is 0 or expireIn is 0");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid()  ");
        sb.append(System.currentTimeMillis() / 1000 < internalSession2.expireIn);
        SDKLogger.d(str2, sb.toString());
        if (System.currentTimeMillis() / 1000 < internalSession2.expireIn) {
            return true;
        }
        return false;
    }

    public void reloadSession(String str, String str2) {
        try {
            StorageService storageService = (StorageService) getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null);
            if (!TextUtils.isEmpty(str2)) {
                this.internalSession = createInternalSession(str, str2);
                storageService.putValue(this.internalSessionStoreKey, SessionUtils.toInternalSessionJSON(this.internalSession), true);
                if (this.mIntenalSessions == null) {
                    this.mIntenalSessions = new HashMap();
                }
                if (!TextUtils.isEmpty(this.internalSession.site)) {
                    this.mIntenalSessions.put(this.internalSession.site, this.internalSession);
                } else {
                    this.mIntenalSessions.put("taobao", this.internalSession);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.user.open.service.SessionService
    public Session getSession(String str) {
        InternalSession internalSession2;
        Session session = new Session();
        if (!(this.mIntenalSessions == null || (internalSession2 = this.mIntenalSessions.get(str)) == null)) {
            session.nick = internalSession2.nick;
            session.hid = internalSession2.userId;
            session.sid = internalSession2.sid;
            session.loginTime = internalSession2.loginTime;
            session.expireIn = internalSession2.expireIn;
            session.avatarUrl = internalSession2.avatarUrl;
            session.openId = internalSession2.openId;
            session.openSid = internalSession2.openSid;
            session.topAccessToken = internalSession2.topAccessToken;
            session.topAuthCode = internalSession2.topAuthCode;
            session.topExpireTime = internalSession2.topExpireTime;
            session.bindToken = internalSession2.bindToken;
        }
        return session;
    }
}
