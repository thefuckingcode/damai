package com.ali.user.mobile.security;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.FingerInfo;
import com.ali.user.mobile.model.FingerList;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.LoginHistory;
import com.ali.user.mobile.rpc.login.model.SessionList;
import com.ali.user.mobile.rpc.login.model.SessionModel;
import com.ali.user.mobile.rpc.login.model.WSecurityData;
import com.ali.user.mobile.rpc.login.model.WUAData;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.StorageService;
import com.ali.user.mobile.utils.EnvUtil;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.utils.FileUtils;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class SecurityGuardManagerWraper {
    private static final boolean DEBUG = Debuggable.isDebug();
    public static final String FINGER_LIST = "finger_list";
    private static final String HISTORY_LOGIN_ACCOUNTS = "aliusersdk_history_acounts";
    public static final String LOGIN_IS_MORE_ACCOUNT = "is_more_act";
    private static final String SESSION_LIST = "aliusersdk_session_lists";
    private static final String TAG = "login.SecurityManager";
    private static final long THREE_MONTH_SECOND = 7776000;
    private static boolean hadReadHistory = false;
    private static LoginHistory mLoginHistory;
    private static SecurityGuardManager mSecurityGuardManager = null;

    public static void afterCancelAccount(String str) {
        List<SessionModel> list;
        if (!TextUtils.isEmpty(str)) {
            try {
                List<HistoryAccount> historyAccounts = getHistoryAccounts();
                String str2 = null;
                if (historyAccounts != null && historyAccounts.size() > 0) {
                    HistoryAccount historyAccount = null;
                    int i = 0;
                    for (int i2 = 0; i2 < historyAccounts.size(); i2++) {
                        if (str.equals(mask(historyAccounts.get(i2).userId))) {
                            i++;
                            historyAccount = historyAccounts.get(i2);
                        }
                    }
                    if (i == 1 && historyAccount != null) {
                        removeHistoryAccount(historyAccount);
                    }
                }
                SessionList sessionListFromFile = getSessionListFromFile();
                if (!(sessionListFromFile == null || (list = sessionListFromFile.sessionModels) == null || list.size() <= 0)) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < sessionListFromFile.sessionModels.size(); i4++) {
                        if (str.equals(mask(sessionListFromFile.sessionModels.get(i4).userId))) {
                            str2 = sessionListFromFile.sessionModels.get(i4).userId;
                            i3++;
                        }
                    }
                    if (i3 == 1 && str2 != null) {
                        removeSessionModelFromFile(str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static WSecurityData buildRPSecurityData() {
        WSecurityData wSecurityData = new WSecurityData();
        WUAData rpwua = getRPWUA();
        if (rpwua != null) {
            wSecurityData.wua = rpwua.wua;
            wSecurityData.t = rpwua.t;
        }
        wSecurityData.apdId = AlipayInfo.getInstance().getApdid();
        wSecurityData.umidToken = AppInfo.getInstance().getUmidToken();
        return wSecurityData;
    }

    public static WSecurityData buildWSecurityData() {
        return buildWSecurityData(true);
    }

    public static synchronized void clearAutologinTokenFromFile(String str) {
        SessionList sessionList;
        List<SessionModel> list;
        synchronized (SecurityGuardManagerWraper.class) {
            if (!TextUtils.isEmpty(str)) {
                String decrypt = decrypt(FileUtils.readFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST));
                if (TextUtils.isEmpty(decrypt)) {
                    sessionList = new SessionList();
                } else {
                    try {
                        sessionList = (SessionList) JSON.parseObject(decrypt, SessionList.class);
                    } catch (JSONException unused) {
                        emptySessionListFromFile();
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (!(sessionList == null || (list = sessionList.sessionModels) == null)) {
                    for (SessionModel sessionModel : list) {
                        if (TextUtils.equals(str, sessionModel.userId)) {
                            sessionModel.autoLoginToken = "";
                            sessionModel.sid = "";
                        }
                        arrayList.add(sessionModel);
                    }
                }
                sessionList.sessionModels = arrayList;
                FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST, encode(JSON.toJSONString(sessionList)));
            }
        }
    }

    public static String decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = getSecurityGuardManager().getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp == null) {
                return str;
            }
            if (str.length() <= 4 || str.charAt(3) != '&') {
                return dynamicDataEncryptComp.dynamicDecrypt(str);
            }
            return dynamicDataEncryptComp.dynamicDecryptDDp(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static synchronized void emptyAllSessionAutoLoginTokenFromFile() {
        List<SessionModel> list;
        synchronized (SecurityGuardManagerWraper.class) {
            try {
                SessionList sessionListFromFile = getSessionListFromFile();
                if (!(sessionListFromFile == null || (list = sessionListFromFile.sessionModels) == null)) {
                    if (list.size() != 0) {
                        for (SessionModel sessionModel : sessionListFromFile.sessionModels) {
                            sessionModel.autoLoginToken = "";
                        }
                        FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST, encode(JSON.toJSONString(sessionListFromFile)));
                        return;
                    }
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void emptySessionListFromFile() {
        FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST, "");
    }

    public static String encode(String str) {
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = getSecurityGuardManager().getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp != null) {
                String dynamicEncryptDDp = dynamicDataEncryptComp.dynamicEncryptDDp(str);
                return TextUtils.isEmpty(dynamicEncryptDDp) ? str : dynamicEncryptDDp;
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static List<HistoryAccount> filterThreeMonthHistoryAccounts(List<HistoryAccount> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                Collections.sort(list, new HistoryAccount());
                findThreeMonthHistoryAccounts(list, arrayList, true);
                findThreeMonthHistoryAccounts(list, arrayList, false);
            } catch (Exception e) {
                if (DEBUG) {
                    Log.w(TAG, "getThreeMonthHistoryAccounts error: ", e);
                }
            }
        }
        return arrayList;
    }

    public static HistoryAccount findHistoryAccount(long j) {
        try {
            List<HistoryAccount> historyAccounts = getHistoryAccounts();
            if (historyAccounts != null) {
                for (HistoryAccount historyAccount : historyAccounts) {
                    if (j == historyAccount.userId) {
                        return historyAccount;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void findThreeMonthHistoryAccounts(List<HistoryAccount> list, List<HistoryAccount> list2, boolean z) {
        for (HistoryAccount historyAccount : list) {
            if (list2.size() < 3 && !TextUtils.isEmpty(historyAccount.loginType)) {
                if (z) {
                    if (!historyAccount.isVip) {
                    }
                } else if (historyAccount.isVip) {
                }
                if (Math.abs((System.currentTimeMillis() / 1000) - historyAccount.loginTime) < THREE_MONTH_SECOND) {
                    list2.add(historyAccount);
                }
            } else {
                return;
            }
        }
    }

    public static String getDeviceTokenKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                HistoryAccount findHistoryAccount = findHistoryAccount(Long.parseLong(str));
                if (findHistoryAccount != null) {
                    return findHistoryAccount.tokenKey;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static synchronized List<FingerInfo> getFingerList() {
        List<FingerInfo> arrayList;
        synchronized (SecurityGuardManagerWraper.class) {
            arrayList = new ArrayList<>();
            try {
                String string = getString(FINGER_LIST);
                if (TextUtils.isEmpty(string)) {
                    UserTrackAdapter.sendUT("readFingerFromFile");
                    string = FileUtils.readFileData(DataProviderFactory.getApplicationContext(), FINGER_LIST);
                    if (!TextUtils.isEmpty(string)) {
                        UserTrackAdapter.sendUT("readFingerFromFileNotEmpty");
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    if (LoginSwitch.getSwitch("fingerLog", "true")) {
                        TLogAdapter.e(TAG, "getFingerString:" + string);
                    }
                    arrayList = ((FingerList) JSON.parseObject(string, FingerList.class)).list;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public static synchronized String getFingerValue(String str) {
        synchronized (SecurityGuardManagerWraper.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "getFingerEmptyId");
                    return "";
                }
                List<FingerInfo> fingerList = getFingerList();
                if (fingerList == null || fingerList.size() == 0) {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "getFingerEmptyList");
                    return "";
                }
                UserTrackAdapter.sendUT("startFindFor_" + fingerList.size());
                for (int i = 0; i < fingerList.size(); i++) {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "checkEncryptedUserId", str, fingerList.get(i).key, null);
                    if (TextUtils.equals(str, fingerList.get(i).key)) {
                        return fingerList.get(i).value;
                    }
                }
                return "";
            } catch (Throwable th) {
                th.printStackTrace();
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "getFingerException", th.getMessage(), null);
            }
        }
    }

    public static List<HistoryAccount> getHistoryAccounts() {
        try {
            LoginHistory loginHistoryFromLocal = getLoginHistoryFromLocal();
            if (loginHistoryFromLocal != null) {
                return loginHistoryFromLocal.accountHistory;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LoginHistory getLoginHistory() {
        List<HistoryAccount> list;
        try {
            LoginHistory loginHistory = mLoginHistory;
            if (loginHistory == null) {
                if (!hadReadHistory) {
                    loginHistory = getLoginHistoryFromLocal();
                    if (!(loginHistory == null || (list = loginHistory.accountHistory) == null)) {
                        Collections.sort(list, new HistoryAccount());
                        loginHistory.index = 0;
                    }
                    mLoginHistory = loginHistory;
                    hadReadHistory = true;
                }
            }
            return loginHistory;
        } catch (Exception e) {
            SecurityUTHitUtils.utHit("80027", "Exception" + e, "Event_getLoginHistoryFailException");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static LoginHistory getLoginHistoryFromLocal() {
        String string = getString(HISTORY_LOGIN_ACCOUNTS);
        try {
            if (TextUtils.isEmpty(string)) {
                return new LoginHistory();
            }
            return (LoginHistory) JSON.parseObject(string, LoginHistory.class);
        } catch (JSONException e) {
            TLogAdapter.e(TAG, "removeHistoryAccount JSONException");
            e.printStackTrace();
            SecurityUTHitUtils.utHit("80005", "JSONException: " + string, "Event_removeHistoryAccountFail");
            LoginHistory loginHistory = new LoginHistory();
            removeString(HISTORY_LOGIN_ACCOUNTS);
            return loginHistory;
        }
    }

    private static WUAData getRPWUA() {
        if (ServiceFactory.getService(FaceService.class) == null) {
            return null;
        }
        return new WUAData(DataProviderFactory.getDataProvider().getAppkey(), String.valueOf(System.currentTimeMillis()), ((FaceService) ServiceFactory.getService(FaceService.class)).getDeviceInfo());
    }

    private static String getSecurityBodyOpen(long j, String str) {
        try {
            return ((ISecurityBodyComponent) getSecurityGuardManager().getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(String.valueOf(j), str, "", null, 4, EnvUtil.getAlimmsdk_env());
        } catch (Exception e) {
            TLogAdapter.e(TAG, e);
            return null;
        } catch (Throwable th) {
            TLogAdapter.e(TAG, th);
            return null;
        }
    }

    public static synchronized SecurityGuardManager getSecurityGuardManager() {
        SecurityGuardManager securityGuardManager;
        synchronized (SecurityGuardManagerWraper.class) {
            if (mSecurityGuardManager == null) {
                try {
                    mSecurityGuardManager = SecurityGuardManager.getInstance(new ContextWrapper(DataProviderFactory.getApplicationContext()));
                } catch (SecException e) {
                    e.printStackTrace();
                }
            }
            securityGuardManager = mSecurityGuardManager;
        }
        return securityGuardManager;
    }

    public static void getSessionList(final DataCallback<SessionList> dataCallback) {
        if (dataCallback != null) {
            new CoordinatorWrapper().execute(new AsyncTask<Object, Void, SessionList>() {
                /* class com.ali.user.mobile.security.SecurityGuardManagerWraper.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public SessionList doInBackground(Object... objArr) {
                    return SecurityGuardManagerWraper.getSessionListFromFile();
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(SessionList sessionList) {
                    dataCallback.result(sessionList);
                }
            }, new Object[0]);
        }
    }

    public static SessionList getSessionListFromFile() {
        try {
            String decrypt = decrypt(FileUtils.readFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST));
            if (TextUtils.isEmpty(decrypt)) {
                return null;
            }
            return (SessionList) JSON.parseObject(decrypt, SessionList.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getString(String str) {
        return ((StorageService) ServiceFactory.getService(StorageService.class)).get(str);
    }

    public static WUAData getWUA() {
        com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent securityBodyComp;
        try {
            com.taobao.wireless.security.sdk.SecurityGuardManager instance = com.taobao.wireless.security.sdk.SecurityGuardManager.getInstance(new ContextWrapper(DataProviderFactory.getApplicationContext()));
            if (instance == null || (securityBodyComp = instance.getSecurityBodyComp()) == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String valueOf = String.valueOf(currentTimeMillis);
            String appkey = DataProviderFactory.getDataProvider().getAppkey();
            String securityBodyOpen = getSecurityBodyOpen(currentTimeMillis, appkey);
            if (TextUtils.isEmpty(securityBodyOpen)) {
                securityBodyOpen = securityBodyComp.getSecurityBodyData(valueOf, appkey);
            }
            return new WUAData(DataProviderFactory.getDataProvider().getAppkey(), valueOf, securityBodyOpen);
        } catch (Exception e) {
            TLogAdapter.e(TAG, e);
            return null;
        }
    }

    public static boolean hasHistoryAccounts() {
        List<HistoryAccount> historyAccounts = getHistoryAccounts();
        return historyAccounts != null && historyAccounts.size() > 0;
    }

    public static String hiddenExceptPreAndPost(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        return length <= i + i2 ? str : hiddenMiddle(str, i + 1, (length - i) - i2);
    }

    public static String hiddenMiddle(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 1; i3 <= length; i3++) {
            if (i3 < i || i3 >= i + i2) {
                sb.append(str.charAt(i3 - 1));
            } else {
                sb.append('*');
            }
        }
        return sb.toString();
    }

    public static String mask(long j) {
        return mask(String.valueOf(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0011  */
    public static HistoryAccount matchHistoryAccount(String str) {
        List<HistoryAccount> historyAccounts = getHistoryAccounts();
        if (historyAccounts != null) {
            for (HistoryAccount historyAccount : historyAccounts) {
                if (TextUtils.equals(str, historyAccount.userInputName) || TextUtils.equals(str, historyAccount.nick) || TextUtils.equals(str, historyAccount.mobile) || TextUtils.equals(str, historyAccount.email) || TextUtils.equals(str, historyAccount.autologinToken)) {
                    return historyAccount;
                }
                while (r0.hasNext()) {
                }
            }
        }
        return null;
    }

    public static synchronized void putLoginHistory(HistoryAccount historyAccount, String str) {
        synchronized (SecurityGuardManagerWraper.class) {
            if (AlibabaSecurityTokenService.saveToken(historyAccount.tokenKey, str) || !LoginStatus.saveSalt) {
                saveHistoryOnly(historyAccount);
            }
        }
    }

    public static synchronized void putSessionModelToFile(SessionModel sessionModel) {
        SessionList sessionList;
        List<SessionModel> list;
        synchronized (SecurityGuardManagerWraper.class) {
            String decrypt = decrypt(FileUtils.readFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST));
            if (TextUtils.isEmpty(decrypt)) {
                sessionList = new SessionList();
            } else {
                try {
                    sessionList = (SessionList) JSON.parseObject(decrypt, SessionList.class);
                } catch (JSONException unused) {
                    sessionList = new SessionList();
                    emptySessionListFromFile();
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(sessionModel);
            if (!(sessionList == null || (list = sessionList.sessionModels) == null)) {
                for (SessionModel sessionModel2 : list) {
                    if (!TextUtils.equals(sessionModel.userId, sessionModel2.userId)) {
                        arrayList.add(sessionModel2);
                    }
                }
            }
            int maxSessionSize = DataProviderFactory.getDataProvider().getMaxSessionSize();
            if (maxSessionSize > 20) {
                maxSessionSize = 20;
            }
            if (arrayList.size() - maxSessionSize > 0 && arrayList.size() > 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            sessionList.sessionModels = arrayList;
            FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST, encode(JSON.toJSONString(sessionList)));
        }
    }

    public static void putString(String str, String str2) {
        ((StorageService) ServiceFactory.getService(StorageService.class)).put(str, str2);
    }

    public static void removeAllFinger() {
        UserTrackAdapter.sendUT("removeAllFinger");
        removeString(FINGER_LIST);
        FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), FINGER_LIST, "");
    }

    public static void removeAllHistoryAccount() {
        try {
            removeString(HISTORY_LOGIN_ACCOUNTS);
            updateMemoryHistory(null);
        } catch (Throwable th) {
            th.printStackTrace();
            SecurityUTHitUtils.utHit("80005", "Throwable: " + th, "Event_removeHistoryAccountFail");
        }
    }

    public static void removeFinger(FingerInfo fingerInfo) {
        if (fingerInfo != null && !TextUtils.isEmpty(fingerInfo.key)) {
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "rmFinger", fingerInfo.key, null);
            List<FingerInfo> fingerList = getFingerList();
            if (fingerList != null && fingerList.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < fingerList.size(); i++) {
                    FingerInfo fingerInfo2 = fingerList.get(i);
                    if (!TextUtils.equals(fingerInfo.key, fingerInfo2.key)) {
                        arrayList.add(fingerInfo2);
                    }
                }
                FingerList fingerList2 = new FingerList();
                fingerList2.list = arrayList;
                try {
                    putString(FINGER_LIST, JSON.toJSONString(fingerList2));
                } catch (Throwable th) {
                    th.printStackTrace();
                    TLogAdapter.e(TAG, th.getMessage());
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "SGPutFingerException", th.getMessage(), null);
                }
                try {
                    FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), FINGER_LIST, JSON.toJSONString(fingerList2));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "SaveFingerFileException", th2.getMessage(), null);
                    th2.printStackTrace();
                }
            }
        }
    }

    public static void removeHistoryAccount(HistoryAccount historyAccount) {
        if (historyAccount != null) {
            UserTrackAdapter.sendUT("history_remove_user");
            try {
                AlibabaSecurityTokenService.removeSafeToken(historyAccount.tokenKey);
                LoginHistory loginHistoryFromLocal = getLoginHistoryFromLocal();
                if (!(loginHistoryFromLocal == null || loginHistoryFromLocal.accountHistory == null)) {
                    ArrayList arrayList = new ArrayList();
                    if (historyAccount.alipayHid == 0) {
                        for (HistoryAccount historyAccount2 : loginHistoryFromLocal.accountHistory) {
                            if (historyAccount2.userId != historyAccount.userId || historyAccount2.alipayHid != 0) {
                                arrayList.add(historyAccount2);
                            }
                        }
                        loginHistoryFromLocal.accountHistory = arrayList;
                    } else {
                        for (HistoryAccount historyAccount3 : loginHistoryFromLocal.accountHistory) {
                            if (historyAccount.alipayHid != historyAccount3.alipayHid) {
                                arrayList.add(historyAccount3);
                            }
                        }
                        loginHistoryFromLocal.accountHistory = arrayList;
                    }
                }
                if (loginHistoryFromLocal != null) {
                    List<HistoryAccount> list = loginHistoryFromLocal.accountHistory;
                    if (list == null || list.isEmpty()) {
                        removeString(HISTORY_LOGIN_ACCOUNTS);
                    } else {
                        Collections.sort(loginHistoryFromLocal.accountHistory, new HistoryAccount());
                        loginHistoryFromLocal.index = 0;
                        putString(HISTORY_LOGIN_ACCOUNTS, JSON.toJSONString(loginHistoryFromLocal));
                    }
                }
                updateMemoryHistory(loginHistoryFromLocal);
            } catch (Throwable th) {
                th.printStackTrace();
                SecurityUTHitUtils.utHit("80005", "Throwable: " + th, "Event_removeHistoryAccountFail");
            }
        }
    }

    public static synchronized void removeSessionAutoLoginTokenFromFile(String str) {
        List<SessionModel> list;
        synchronized (SecurityGuardManagerWraper.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SessionList sessionListFromFile = getSessionListFromFile();
                    if (!(sessionListFromFile == null || (list = sessionListFromFile.sessionModels) == null)) {
                        if (list.size() != 0) {
                            for (SessionModel sessionModel : sessionListFromFile.sessionModels) {
                                if (sessionModel.userId.equals(str)) {
                                    sessionModel.autoLoginToken = "";
                                }
                            }
                            FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST, encode(JSON.toJSONString(sessionListFromFile)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void removeSessionModelFromFile(String str) {
        List<SessionModel> list;
        synchronized (SecurityGuardManagerWraper.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SessionList sessionListFromFile = getSessionListFromFile();
                    if (!(sessionListFromFile == null || (list = sessionListFromFile.sessionModels) == null)) {
                        if (list.size() != 0) {
                            ArrayList arrayList = new ArrayList();
                            for (SessionModel sessionModel : sessionListFromFile.sessionModels) {
                                if (!sessionModel.userId.equals(str)) {
                                    arrayList.add(sessionModel);
                                }
                            }
                            sessionListFromFile.sessionModels = arrayList;
                            FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), SESSION_LIST, encode(JSON.toJSONString(sessionListFromFile)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void removeString(String str) {
        ((StorageService) ServiceFactory.getService(StorageService.class)).remove(str);
    }

    public static synchronized void saveFinger(FingerInfo fingerInfo) {
        synchronized (SecurityGuardManagerWraper.class) {
            saveFinger(fingerInfo, null);
        }
    }

    public static void saveHistoryOnly(HistoryAccount historyAccount) {
        boolean z;
        if (DEBUG) {
            Log.d(TAG, "saveHistoryOnly HistoryAccount: " + historyAccount);
        }
        UserTrackAdapter.sendUT("history_update_user");
        if (getSecurityGuardManager().getDynamicDataStoreComp() == null) {
            SecurityUTHitUtils.utHit("80016", "dynamicDataStoreComp = null", "Event_putLoginHistoryFail");
            return;
        }
        LoginHistory loginHistoryFromLocal = getLoginHistoryFromLocal();
        if (loginHistoryFromLocal != null) {
            boolean z2 = false;
            if (loginHistoryFromLocal.accountHistory != null) {
                ArrayList arrayList = new ArrayList();
                if (historyAccount.alipayHid != 0) {
                    for (HistoryAccount historyAccount2 : loginHistoryFromLocal.accountHistory) {
                        if (historyAccount2.alipayHid == historyAccount.alipayHid) {
                            historyAccount2.update(historyAccount);
                            historyAccount = historyAccount2;
                        } else {
                            arrayList.add(historyAccount2);
                        }
                    }
                    arrayList.add(historyAccount);
                } else {
                    for (HistoryAccount historyAccount3 : loginHistoryFromLocal.accountHistory) {
                        if (historyAccount3.userId == historyAccount.userId && historyAccount3.alipayHid == 0) {
                            historyAccount3.update(historyAccount);
                            historyAccount = historyAccount3;
                        } else {
                            arrayList.add(historyAccount3);
                        }
                    }
                    arrayList.add(historyAccount);
                }
                int size = arrayList.size() - DataProviderFactory.getDataProvider().getMaxHistoryAccount();
                Collections.sort(arrayList, new HistoryAccount());
                if (size > 0) {
                    if (DataProviderFactory.getDataProvider().isYoukuApps()) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!((HistoryAccount) it.next()).isVip) {
                                    z = false;
                                    break;
                                }
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            AlibabaSecurityTokenService.removeSafeToken(((HistoryAccount) arrayList.remove(arrayList.size() - 1)).tokenKey);
                        } else {
                            Collections.reverse(arrayList);
                            Iterator it2 = arrayList.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!((HistoryAccount) it2.next()).isVip) {
                                        it2.remove();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            Collections.reverse(arrayList);
                        }
                    } else {
                        AlibabaSecurityTokenService.removeSafeToken(((HistoryAccount) arrayList.remove(arrayList.size() - 1)).tokenKey);
                    }
                }
                loginHistoryFromLocal.accountHistory = arrayList;
                loginHistoryFromLocal.index = arrayList.indexOf(historyAccount);
                if (DataProviderFactory.getDataProvider().isYoukuApps()) {
                    Context applicationContext = DataProviderFactory.getApplicationContext();
                    if (filterThreeMonthHistoryAccounts(arrayList).size() > 1) {
                        z2 = true;
                    }
                    SharedPreferencesUtil.saveData(applicationContext, LOGIN_IS_MORE_ACCOUNT, Boolean.valueOf(z2));
                }
                putString(HISTORY_LOGIN_ACCOUNTS, JSON.toJSONString(loginHistoryFromLocal));
            } else if (DataProviderFactory.getDataProvider().getMaxHistoryAccount() > 0) {
                ArrayList arrayList2 = new ArrayList();
                loginHistoryFromLocal.accountHistory = arrayList2;
                arrayList2.add(historyAccount);
                loginHistoryFromLocal.index = 0;
                putString(HISTORY_LOGIN_ACCOUNTS, JSON.toJSONString(loginHistoryFromLocal));
            }
        }
        updateMemoryHistory(loginHistoryFromLocal);
        TLogAdapter.e(TAG, "putLoginHistory Success");
    }

    public static String staticSafeEncrypt(String str) {
        try {
            IStaticDataEncryptComponent staticDataEncryptComp = SecurityGuardManager.getInstance(new ContextWrapper(DataProviderFactory.getApplicationContext())).getStaticDataEncryptComp();
            return staticDataEncryptComp != null ? staticDataEncryptComp.staticSafeEncrypt(16, DataProviderFactory.getDataProvider().getAppkey(), str, "") : str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static void updateFirstHistoryCountLoginType(String str) {
        List<HistoryAccount> historyAccounts = getHistoryAccounts();
        if (historyAccounts != null) {
            HistoryAccount historyAccount = historyAccounts.get(0);
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "before updateFirstHistoryCountLoginType: loginType:" + str + " HistoryAccount:" + historyAccount);
            }
            historyAccount.setSrcLoginType(TextUtils.isEmpty(historyAccount.srcLoginType) ? historyAccount.loginType : historyAccount.srcLoginType);
            historyAccount.loginType = str;
            updateLoginHistoryIndex(historyAccount);
            if (z) {
                Log.d(TAG, "after updateFirstHistoryCountLoginType: loginType:" + str + " HistoryAccount:" + historyAccount);
            }
        }
    }

    public static synchronized void updateLoginHistoryIndex(HistoryAccount historyAccount) {
        boolean z;
        synchronized (SecurityGuardManagerWraper.class) {
            if (historyAccount != null) {
                long j = historyAccount.userId;
                try {
                    LoginHistory loginHistoryFromLocal = getLoginHistoryFromLocal();
                    if (!(loginHistoryFromLocal == null || loginHistoryFromLocal.accountHistory == null)) {
                        int i = 0;
                        while (true) {
                            if (i >= loginHistoryFromLocal.accountHistory.size()) {
                                z = false;
                                break;
                            }
                            HistoryAccount historyAccount2 = loginHistoryFromLocal.accountHistory.get(i);
                            if (historyAccount2.userId == j) {
                                historyAccount2.loginType = historyAccount.loginType;
                                historyAccount2.loginTime = historyAccount.loginTime;
                                historyAccount2.hasPwd = historyAccount.hasPwd;
                                historyAccount2.isVip = historyAccount.isVip;
                                historyAccount2.vipExpireTime = historyAccount.vipExpireTime;
                                historyAccount2.srcLoginType = historyAccount.srcLoginType;
                                z = true;
                                break;
                            }
                            i++;
                        }
                        if (z) {
                            Collections.sort(loginHistoryFromLocal.accountHistory, new HistoryAccount());
                            loginHistoryFromLocal.index = 0;
                            putString(HISTORY_LOGIN_ACCOUNTS, JSON.toJSONString(loginHistoryFromLocal));
                        }
                    }
                } catch (JSONException e) {
                    SecurityUTHitUtils.utHit("80017", "Exception:" + e.getMessage(), "Event_updateLoginHistoryFailJsonException");
                } catch (Exception e2) {
                    SecurityUTHitUtils.utHit("80017", "Exception" + e2, "Event_updateLoginHistoryFailException");
                }
            }
        }
    }

    private static void updateMemoryHistory(LoginHistory loginHistory) {
        mLoginHistory = loginHistory;
        hadReadHistory = true;
    }

    public static WSecurityData buildWSecurityData(boolean z) {
        WUAData wua;
        WSecurityData wSecurityData = new WSecurityData();
        if (z && (wua = getWUA()) != null) {
            wSecurityData.wua = wua.wua;
            wSecurityData.t = wua.t;
        }
        wSecurityData.apdId = AlipayInfo.getInstance().getApdid();
        wSecurityData.umidToken = AppInfo.getInstance().getUmidToken();
        wSecurityData.appStore = DataProviderFactory.getDataProvider().getTTID();
        wSecurityData.osName = "android";
        wSecurityData.osVersion = Build.VERSION.getRELEASE();
        String model = Build.getMODEL();
        wSecurityData.deviceModel = model;
        wSecurityData.deviceBrand = Build.getMANUFACTURER();
        wSecurityData.deviceName = model;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DataProviderFactory.getApplicationContext().getResources().getDisplayMetrics();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        wSecurityData.screenSize = i + Constants.Name.X + i2;
        return wSecurityData;
    }

    public static String mask(String str) {
        return hiddenExceptPreAndPost(str, 3, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3 A[Catch:{ all -> 0x00f1 }] */
    public static synchronized void saveFinger(FingerInfo fingerInfo, ArrayList<String> arrayList) {
        ArrayList arrayList2;
        synchronized (SecurityGuardManagerWraper.class) {
            if (fingerInfo != null) {
                try {
                    if (!TextUtils.isEmpty(fingerInfo.key)) {
                        if (!TextUtils.isEmpty(fingerInfo.value)) {
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "saveFinger", fingerInfo.key, null);
                            List<FingerInfo> fingerList = getFingerList();
                            if (!(fingerList == null || fingerList.size() == 0 || arrayList == null)) {
                                if (arrayList.size() != 0) {
                                    TLogAdapter.e(TAG, "saveFingerNotEmptyList");
                                    arrayList2 = new ArrayList();
                                    for (int i = 0; i < fingerList.size(); i++) {
                                        FingerInfo fingerInfo2 = fingerList.get(i);
                                        if (!TextUtils.equals(fingerInfo.key, fingerInfo2.key) && arrayList.contains(fingerInfo2.key)) {
                                            arrayList2.add(fingerInfo2);
                                        }
                                    }
                                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerSize", String.valueOf(arrayList2.size()), null);
                                    arrayList2.add(fingerInfo);
                                    FingerList fingerList2 = new FingerList();
                                    fingerList2.list = arrayList2;
                                    String jSONString = JSON.toJSONString(fingerList2);
                                    if (LoginSwitch.getSwitch("fingerLog", "true")) {
                                        TLogAdapter.e(TAG, "finger_list=" + jSONString);
                                    }
                                    putString(FINGER_LIST, jSONString);
                                    FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), FINGER_LIST, jSONString);
                                    return;
                                }
                            }
                            TLogAdapter.e(TAG, "saveFingerEmptyList");
                            UserTrackAdapter.sendUT("saveFingerEmptyList");
                            arrayList2 = new ArrayList();
                            arrayList2.add(fingerInfo);
                            FingerList fingerList22 = new FingerList();
                            fingerList22.list = arrayList2;
                            String jSONString2 = JSON.toJSONString(fingerList22);
                            if (LoginSwitch.getSwitch("fingerLog", "true")) {
                            }
                            try {
                                putString(FINGER_LIST, jSONString2);
                            } catch (Throwable th) {
                                th.printStackTrace();
                                TLogAdapter.e(TAG, th.getMessage());
                                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "SGPutException", th.getMessage(), null);
                            }
                            FileUtils.writeFileData(DataProviderFactory.getApplicationContext(), FINGER_LIST, jSONString2);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    TLogAdapter.e(TAG, th2.getMessage());
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "SaveFingerException", th2.getMessage(), null);
                    th2.printStackTrace();
                }
            }
            TLogAdapter.e(TAG, "saveFingerException");
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "saveFingerException");
            return;
        }
    }
}
