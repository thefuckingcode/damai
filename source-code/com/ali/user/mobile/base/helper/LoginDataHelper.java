package com.ali.user.mobile.base.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.history.LoginHistoryManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.service.impl.FingerprintLoginServiceImpl;
import com.ali.user.mobile.model.FingerInfo;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.AliUserResponseData;
import com.ali.user.mobile.rpc.login.model.DeviceTokenRO;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.SessionModel;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.verify.VerifyApi;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.session.ISession;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.SuccessTip;
import com.taobao.login4android.session.constants.SessionConstants;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.datacollection.IDataCollectionComponent;
import com.ut.mini.UTAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class LoginDataHelper {
    public static final String TAG = "login.LoginDataHelper";

    public static long adjustSessionExpireTime(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > j2) {
            return j > 0 ? j + (currentTimeMillis - j2) : 86400 + currentTimeMillis;
        }
        return j;
    }

    public static void beforeProcessLoginData(boolean z, AliUserResponseData aliUserResponseData, String str) {
        if (LoginStatus.isFromChangeAccount() && z) {
            SessionManager instance = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
            if (aliUserResponseData == null || instance == null || !LoginSwitch.getSwitch(LoginSwitch.NEW_LOGOUT_BROADCAST_SWITCH, "true") || !TextUtils.equals(instance.getUserId(), aliUserResponseData.userId)) {
                HashMap hashMap = new HashMap();
                hashMap.put(LoginConstants.LOGOUT_TYPE, LoginConstants.LogoutType.CHANGE_ACCOUNT.getType());
                hashMap.put("nick", SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getOldNick());
                hashMap.put("uid", SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getOldUserId());
                BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGOUT, false, 0, str, (Map<String, String>) hashMap, "before recover account");
            }
        }
    }

    public static void handleHistory(LoginReturnData loginReturnData, ISession iSession, AliUserResponseData aliUserResponseData, Map<String, String> map) {
        String str;
        long j;
        long j2;
        String str2 = (map == null || TextUtils.isEmpty(map.get(LoginConstants.LOGIN_TYPE))) ? "" : map.get(LoginConstants.LOGIN_TYPE);
        LoginType.ServerLoginType serverLoginType = LoginType.ServerLoginType.AutoLogin;
        if (!TextUtils.equals(str2, serverLoginType.getType()) && !TextUtils.equals(str2, LoginConstant.LOGIN_TYPE_FINGERPRINT)) {
            SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), "login_type", str2);
        }
        if (!DataProviderFactory.getDataProvider().isYoukuApps()) {
            DeviceTokenRO deviceTokenRO = loginReturnData.deviceToken;
            String str3 = null;
            if (deviceTokenRO != null) {
                str = deviceTokenRO.key;
                str3 = deviceTokenRO.salt;
            } else {
                str = null;
            }
            int i = loginReturnData.site;
            String str4 = loginReturnData.showLoginId;
            if (TextUtils.isEmpty(str4)) {
                str4 = loginReturnData.taobaoNick;
            }
            String str5 = loginReturnData.mobile;
            String str6 = aliUserResponseData.headPicLink;
            Long l = loginReturnData.hid;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            Long l2 = loginReturnData.alipayHid;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            String str7 = aliUserResponseData.autoLoginToken;
            long j3 = aliUserResponseData.loginTime;
            if (j3 <= 0) {
                j3 = System.currentTimeMillis() / 1000;
            }
            HistoryAccount historyAccount = new HistoryAccount(str4, str5, str6, j, j2, str7, j3, str, loginReturnData.loginType, loginReturnData.taobaoNick, loginReturnData.email, loginReturnData.alipayCrossed, i);
            if (!TextUtils.isEmpty(loginReturnData.accountId)) {
                historyAccount.setAccountId(loginReturnData.accountId);
            }
            Map<String, String> map2 = loginReturnData.extMap;
            if (map2 != null) {
                historyAccount.biometricId = map2.get(SessionConstants.BIOMETRIC);
            }
            historyAccount.setLoginPhone(aliUserResponseData.loginPhone);
            if (aliUserResponseData.loginServiceExt != null) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = aliUserResponseData.loginServiceExt.get(LoginConstants.LOGIN_TYPE);
                }
                String str8 = aliUserResponseData.loginServiceExt.get("loginEntrance");
                if (!TextUtils.isEmpty(str8)) {
                    SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), LoginConstant.LOGIN_ENTRANCE, str8);
                }
                if (!aliUserResponseData.loginServiceExt.containsKey("hasPwd")) {
                    historyAccount.hasPwd = -1;
                } else if (TextUtils.equals("true", aliUserResponseData.loginServiceExt.get("hasPwd"))) {
                    historyAccount.hasPwd = 1;
                } else {
                    historyAccount.hasPwd = 0;
                }
            }
            if (!TextUtils.equals(str2, serverLoginType.getType()) && !TextUtils.equals(str2, LoginConstant.LOGIN_TYPE_FINGERPRINT)) {
                historyAccount.loginType = str2;
                SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), "login_type", str2);
            }
            if (loginReturnData.deviceToken != null) {
                LoginHistoryManager.getInstance().saveHistory(historyAccount, str3);
            } else if (DataProviderFactory.getDataProvider().isSaveHistoryWithoutSalt()) {
                LoginHistoryManager.getInstance().saveHistoryWithNoSalt(historyAccount);
            } else if (loginReturnData.hid != null) {
                SecurityGuardManagerWraper.updateLoginHistoryIndex(historyAccount);
            }
            SessionModel sessionModel = new SessionModel();
            sessionModel.sid = aliUserResponseData.sid;
            sessionModel.ecode = aliUserResponseData.ecode;
            sessionModel.nick = aliUserResponseData.nick;
            sessionModel.userId = aliUserResponseData.userId;
            sessionModel.email = aliUserResponseData.email;
            sessionModel.havanaId = aliUserResponseData.havanaId;
            sessionModel.alipayHid = aliUserResponseData.alipayHid;
            sessionModel.loginTime = aliUserResponseData.loginTime;
            sessionModel.autoLoginToken = aliUserResponseData.autoLoginToken;
            sessionModel.headPicLink = aliUserResponseData.headPicLink;
            sessionModel.havanaSsoToken = aliUserResponseData.havanaSsoToken;
            sessionModel.havanaSsoTokenExpiredTime = aliUserResponseData.havanaSsoTokenExpiredTime;
            sessionModel.externalCookies = aliUserResponseData.externalCookies;
            sessionModel.cookies = aliUserResponseData.cookies;
            sessionModel.ssoToken = aliUserResponseData.ssoToken;
            sessionModel.expires = aliUserResponseData.expires;
            sessionModel.extendAttribute = aliUserResponseData.extendAttribute;
            sessionModel.loginServiceExt = aliUserResponseData.loginServiceExt;
            sessionModel.site = loginReturnData.site;
            sessionModel.showLoginId = loginReturnData.showLoginId;
            SecurityGuardManagerWraper.putSessionModelToFile(sessionModel);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bf A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0245  */
    @SuppressLint({"CommitPrefEdits"})
    public static void onLoginSuccess(LoginReturnData loginReturnData, AliUserResponseData aliUserResponseData, SessionManager sessionManager) {
        long j;
        String str;
        SuccessTip successTip;
        String str2;
        String[] strArr;
        String str3;
        Map<String, String> map;
        int i;
        Map<String, String> map2;
        Map<String, String> map3;
        String[] strArr2;
        Exception e;
        IDataCollectionComponent dataCollectionComp;
        if (sessionManager == null) {
            LoginTLogAdapter.e(TAG, "session is null, cannot write session");
            UserTrackAdapter.sendUT("SessionNull");
            return;
        }
        String str4 = aliUserResponseData.sid;
        String str5 = aliUserResponseData.subSid;
        String str6 = aliUserResponseData.ecode;
        String str7 = aliUserResponseData.nick;
        String str8 = aliUserResponseData.userId;
        Map<String, Object> map4 = aliUserResponseData.extendAttribute;
        String str9 = aliUserResponseData.headPicLink;
        String str10 = aliUserResponseData.autoLoginToken;
        String str11 = aliUserResponseData.ssoToken;
        String str12 = aliUserResponseData.havanaSsoToken;
        long j2 = aliUserResponseData.havanaSsoTokenExpiredTime;
        long j3 = aliUserResponseData.expires;
        long j4 = aliUserResponseData.loginTime;
        String[] strArr3 = aliUserResponseData.externalCookies;
        String[] strArr4 = aliUserResponseData.cookies;
        String str13 = aliUserResponseData.email;
        String str14 = aliUserResponseData.loginPhone;
        String str15 = "";
        if (loginReturnData == null || (str = loginReturnData.sessionDisastergrd) == null) {
            j = j3;
            str = str15;
        } else {
            j = j3;
        }
        SuccessTip successTip2 = aliUserResponseData.successTips;
        if (loginReturnData == null) {
            successTip = successTip2;
            str2 = str15;
        } else {
            str2 = loginReturnData.displayNick;
            successTip = successTip2;
        }
        String str16 = aliUserResponseData.uidDigest;
        SecurityGuardManager instance = SecurityGuardManager.getInstance(DataProviderFactory.getApplicationContext());
        if (!(instance == null || (dataCollectionComp = instance.getDataCollectionComp()) == null)) {
            dataCollectionComp.setNick(str7);
        }
        if (map4 != null) {
            try {
                if (map4.get(SessionConstants.SSO_DOMAIN_LIST) != null) {
                    strArr2 = (String[]) ((JSONArray) map4.get(SessionConstants.SSO_DOMAIN_LIST)).toArray(new String[0]);
                    StringBuilder sb = new StringBuilder();
                    sb.append("domainList: ");
                    sb.append(strArr2 != null ? str15 : JSON.toJSON(strArr2));
                    LoginTLogAdapter.d(TAG, sb.toString());
                    if (map4 != null) {
                        if (map4.get("silentSsoLoginToken") != null) {
                            str15 = (String) map4.get("silentSsoLoginToken");
                        }
                    }
                    strArr = strArr2;
                    str3 = str15;
                    sessionManager.setEmail(str13);
                    sessionManager.setSubSid(str5);
                    sessionManager.setDisplayNick(str2);
                    sessionManager.setUidDigest(str16);
                    sessionManager.setSessionDisastergrd(str);
                    if (!(loginReturnData == null || (map2 = loginReturnData.extMap) == null)) {
                        sessionManager.setOldEncryptedUserId(map2.get("encryptUserId"));
                        map3 = loginReturnData.extMap;
                        if (map3 != null) {
                            String str17 = map3.get(SessionConstants.BIOMETRIC);
                            sessionManager.setbiometricId(str17);
                            try {
                                String str18 = loginReturnData.extMap.get("biometricKey");
                                if (!TextUtils.isEmpty(str18) && TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(str17))) {
                                    UserTrackAdapter.sendUT("SaveFingerAgain");
                                    FingerInfo fingerInfo = new FingerInfo();
                                    fingerInfo.key = str17;
                                    fingerInfo.value = str18;
                                    VerifyApi.saveFingerInBackground(fingerInfo, (ArrayList) JSON.parseObject(loginReturnData.extMap.get("biometricIdList"), ArrayList.class));
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    map = aliUserResponseData.loginServiceExt;
                    if (map == null) {
                        Map<String, String> map5 = loginReturnData.extMap;
                        if (map5 != null) {
                            map.putAll(map5);
                        }
                        UserTrackAdapter.sendUT("LoginExtNotEmpty");
                        sessionManager.setExtJson(JSON.toJSONString(aliUserResponseData.loginServiceExt));
                    } else {
                        UserTrackAdapter.sendUT("LoginExtEmpty");
                    }
                    if (!(loginReturnData == null || (i = loginReturnData.site) == -1)) {
                        sessionManager.setLoginSite(i);
                    }
                    if (DataProviderFactory.getDataProvider().registerSidToMtop() && DataProviderFactory.getDataProvider().isNeedUpdateUTAccount()) {
                        UTAnalytics.getInstance().updateUserAccount(str7, str8, str16);
                    }
                    sessionManager.onLoginSuccess(str4, str6, str7, str8, str9, str10, str11, str12, j2, strArr3, strArr4, strArr, adjustSessionExpireTime(j, j4), j4, str14);
                    sessionManager.setSuccessTip(successTip);
                    if (DataProviderFactory.getDataProvider().registerSidToMtop()) {
                        ((RpcService) ServiceFactory.getService(RpcService.class)).registerSessionInfo(str4, str8, str);
                        LoginTLogAdapter.d(TAG, "registerSessionInfo to mtopsdk:(sid:" + str4 + ",ecode:" + str6 + ",userId:" + str8 + ").");
                    }
                    LoginStatus.setLastRefreshCookieTime(System.currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        saveCp(str3, str9, str7);
                        UserTrackAdapter.sendUT("saveCpToken");
                    } else {
                        UserTrackAdapter.sendUT("cpTokenNull");
                    }
                    FingerprintLoginServiceImpl.getInstance().clearFingerprintInfo(aliUserResponseData);
                }
            } catch (Exception e2) {
                e = e2;
                strArr2 = null;
                e.printStackTrace();
                strArr = strArr2;
                str3 = null;
                sessionManager.setEmail(str13);
                sessionManager.setSubSid(str5);
                sessionManager.setDisplayNick(str2);
                sessionManager.setUidDigest(str16);
                sessionManager.setSessionDisastergrd(str);
                sessionManager.setOldEncryptedUserId(map2.get("encryptUserId"));
                map3 = loginReturnData.extMap;
                if (map3 != null) {
                }
                map = aliUserResponseData.loginServiceExt;
                if (map == null) {
                }
                sessionManager.setLoginSite(i);
                UTAnalytics.getInstance().updateUserAccount(str7, str8, str16);
                sessionManager.onLoginSuccess(str4, str6, str7, str8, str9, str10, str11, str12, j2, strArr3, strArr4, strArr, adjustSessionExpireTime(j, j4), j4, str14);
                sessionManager.setSuccessTip(successTip);
                if (DataProviderFactory.getDataProvider().registerSidToMtop()) {
                }
                LoginStatus.setLastRefreshCookieTime(System.currentTimeMillis());
                if (TextUtils.isEmpty(str3)) {
                }
                FingerprintLoginServiceImpl.getInstance().clearFingerprintInfo(aliUserResponseData);
            }
        }
        strArr2 = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("domainList: ");
            sb2.append(strArr2 != null ? str15 : JSON.toJSON(strArr2));
            LoginTLogAdapter.d(TAG, sb2.toString());
            if (map4 != null) {
            }
            strArr = strArr2;
            str3 = str15;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            strArr = strArr2;
            str3 = null;
            sessionManager.setEmail(str13);
            sessionManager.setSubSid(str5);
            sessionManager.setDisplayNick(str2);
            sessionManager.setUidDigest(str16);
            sessionManager.setSessionDisastergrd(str);
            sessionManager.setOldEncryptedUserId(map2.get("encryptUserId"));
            map3 = loginReturnData.extMap;
            if (map3 != null) {
            }
            map = aliUserResponseData.loginServiceExt;
            if (map == null) {
            }
            sessionManager.setLoginSite(i);
            UTAnalytics.getInstance().updateUserAccount(str7, str8, str16);
            sessionManager.onLoginSuccess(str4, str6, str7, str8, str9, str10, str11, str12, j2, strArr3, strArr4, strArr, adjustSessionExpireTime(j, j4), j4, str14);
            sessionManager.setSuccessTip(successTip);
            if (DataProviderFactory.getDataProvider().registerSidToMtop()) {
            }
            LoginStatus.setLastRefreshCookieTime(System.currentTimeMillis());
            if (TextUtils.isEmpty(str3)) {
            }
            FingerprintLoginServiceImpl.getInstance().clearFingerprintInfo(aliUserResponseData);
        }
        sessionManager.setEmail(str13);
        sessionManager.setSubSid(str5);
        sessionManager.setDisplayNick(str2);
        sessionManager.setUidDigest(str16);
        sessionManager.setSessionDisastergrd(str);
        sessionManager.setOldEncryptedUserId(map2.get("encryptUserId"));
        map3 = loginReturnData.extMap;
        if (map3 != null) {
        }
        map = aliUserResponseData.loginServiceExt;
        if (map == null) {
        }
        sessionManager.setLoginSite(i);
        try {
            UTAnalytics.getInstance().updateUserAccount(str7, str8, str16);
        } catch (Throwable unused) {
            UTAnalytics.getInstance().updateUserAccount(str7, str8);
        }
        sessionManager.onLoginSuccess(str4, str6, str7, str8, str9, str10, str11, str12, j2, strArr3, strArr4, strArr, adjustSessionExpireTime(j, j4), j4, str14);
        sessionManager.setSuccessTip(successTip);
        if (DataProviderFactory.getDataProvider().registerSidToMtop()) {
        }
        LoginStatus.setLastRefreshCookieTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(str3)) {
        }
        FingerprintLoginServiceImpl.getInstance().clearFingerprintInfo(aliUserResponseData);
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData) {
        return processLoginReturnData(z, loginReturnData, null, "", null);
    }

    private static void saveCp(String str, String str2, String str3) {
        try {
            if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
                Context applicationContext = DataProviderFactory.getApplicationContext();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", (Object) str);
                jSONObject.put("nick", (Object) StringUtil.dataMasking(str3));
                jSONObject.put("avatar", (Object) str2);
                CPHelper.save(applicationContext, LoginConstant.ACCOUNT, jSONObject.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void sendLoginResultBroadcast(boolean z, String str, String str2, LoginParam loginParam, LoginReturnData loginReturnData, AliUserResponseData aliUserResponseData, String str3, String str4) {
        Map<String, String> map;
        Map<String, String> map2;
        if (z) {
            String str5 = "";
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent(LoginResActions.LOGIN_SUCCESS_ACTION);
                intent.putExtra("nick", str2);
                intent.putExtra("uid", str);
                if (loginParam != null && TokenType.MERGE_ACCOUNT.equals(loginParam.tokenType)) {
                    intent.putExtra("message", TokenType.MERGE_ACCOUNT);
                }
                if (LoginStatus.isFromChangeAccount()) {
                    intent.putExtra(LoginConstants.LOGIN_FROM, LoginConstants.LOGIN_FROM_MULTI_ACCOUNT);
                }
                if (!(aliUserResponseData == null || (map2 = aliUserResponseData.loginServiceExt) == null)) {
                    str5 = map2.get(LoginConstants.LOGIN_TYPE);
                }
                if (TextUtils.isEmpty(str5) && (map = loginReturnData.extMap) != null) {
                    str5 = map.get(LoginConstants.LOGIN_TYPE);
                    if (TextUtils.isEmpty(str5)) {
                        str5 = loginReturnData.extMap.get("rootLoginType");
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = str5;
                }
                intent.putExtra(LoginConstants.LOGIN_TYPE, str3);
                intent.putExtra(LoginConstants.LOGIN_ACCOUNT, str4);
                intent.putExtra("serverLoginType", str5);
                BroadCastHelper.sendLocalBroadCast(intent);
                return;
            }
            BroadCastHelper.sendLoginFailBroadcast(LoginResActions.LoginFailCode.LOGIN_DATA_EXCEPTION, str5);
            LoginStatus.resetLoginFlag();
        }
    }

    public static SessionModel sessionToModel(ISession iSession) {
        SessionModel sessionModel = new SessionModel();
        sessionModel.sid = iSession.getSid();
        sessionModel.ecode = iSession.getEcode();
        sessionModel.nick = iSession.getNick();
        sessionModel.userId = iSession.getUserId();
        sessionModel.email = iSession.getEmail();
        sessionModel.autoLoginToken = iSession.getLoginToken();
        sessionModel.havanaSsoToken = iSession.getOneTimeToken();
        sessionModel.havanaSsoTokenExpiredTime = iSession.getHavanaSsoTokenExpiredTime();
        sessionModel.ssoToken = iSession.getSsoToken();
        sessionModel.expires = iSession.getSessionExpiredTime();
        if (!TextUtils.isEmpty(iSession.getExtJson())) {
            try {
                sessionModel.loginServiceExt = (Map) JSON.parseObject(iSession.getExtJson(), new TypeReference<Map<String, String>>() {
                    /* class com.ali.user.mobile.base.helper.LoginDataHelper.AnonymousClass1 */
                }, new Feature[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sessionModel.site = iSession.getLoginSite();
        String email = iSession.getEmail();
        sessionModel.showLoginId = email;
        if (TextUtils.isEmpty(email)) {
            sessionModel.showLoginId = iSession.getNick();
        }
        return sessionModel;
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData, String str) {
        return processLoginReturnData(z, loginReturnData, null, "", null);
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData, Map<String, String> map) {
        return processLoginReturnData(z, loginReturnData, null, "", map);
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData, LoginParam loginParam, String str, Map<String, String> map) {
        String str2;
        String str3;
        if (!(loginReturnData == null || loginReturnData.data == null)) {
            if (LoginSwitch.getSwitch("login_data_async2", "true")) {
                new CoordinatorWrapper().execute(new LoginDataHelperTask(z, loginReturnData, loginParam, str, map), new Object[0]);
                return true;
            }
            if (Debuggable.isDebug()) {
                LoginTLogAdapter.d(TAG, "LoginResponse Data=" + loginReturnData.data);
            }
            try {
                AliUserResponseData aliUserResponseData = (AliUserResponseData) JSON.parseObject(loginReturnData.data, AliUserResponseData.class);
                beforeProcessLoginData(z, aliUserResponseData, str);
                SessionManager instance = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
                onLoginSuccess(loginReturnData, aliUserResponseData, instance);
                handleHistory(loginReturnData, instance, aliUserResponseData, map);
                if (map == null || TextUtils.isEmpty(map.get(LoginConstants.LOGIN_TYPE))) {
                    str2 = "";
                } else {
                    str2 = map.get(LoginConstants.LOGIN_TYPE);
                }
                if (map == null || TextUtils.isEmpty(map.get(LoginConstants.LOGIN_ACCOUNT))) {
                    str3 = "";
                } else {
                    str3 = map.get(LoginConstants.LOGIN_ACCOUNT);
                }
                sendLoginResultBroadcast(z, aliUserResponseData.userId, aliUserResponseData.nick, loginParam, loginReturnData, aliUserResponseData, str2, str3);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void onLoginSuccess(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        T t;
        if (rpcResponse != null && (t = rpcResponse.returnValue) != null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(loginParam.snsType)) {
                hashMap.put(LoginConstants.LOGIN_TYPE, loginParam.snsType);
            } else if (TextUtils.equals(loginParam.tokenType, TokenType.FIND_PWD)) {
                hashMap.put(LoginConstants.LOGIN_TYPE, TokenType.FIND_PWD);
            } else if (!TextUtils.isEmpty(loginParam.nativeLoginType)) {
                hashMap.put(LoginConstants.LOGIN_TYPE, loginParam.nativeLoginType);
            } else if (!TextUtils.isEmpty(t.extMap.get(LoginConstants.LOGIN_TYPE))) {
                hashMap.put(LoginConstants.LOGIN_TYPE, t.extMap.get(LoginConstants.LOGIN_TYPE));
            }
            if (!TextUtils.isEmpty(loginParam.loginAccount)) {
                hashMap.put(LoginConstants.LOGIN_ACCOUNT, loginParam.loginAccount);
            }
            processLoginReturnData(true, (LoginReturnData) t, (Map<String, String>) hashMap);
        }
    }
}
