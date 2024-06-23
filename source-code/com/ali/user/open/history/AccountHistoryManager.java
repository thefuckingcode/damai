package com.ali.user.open.history;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.service.StorageService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AccountHistoryManager {
    private static final String HISTORY_LOGIN_ACCOUNTS = "tb_history_acounts";
    private static volatile AccountHistoryManager singleton;

    private AccountHistoryManager() {
    }

    public static AccountHistoryManager getInstance() {
        if (singleton == null) {
            synchronized (AccountHistoryManager.class) {
                if (singleton == null) {
                    singleton = new AccountHistoryManager();
                }
            }
        }
        return singleton;
    }

    private List<HistoryAccount> parseObject(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                HistoryAccount historyAccount = new HistoryAccount();
                historyAccount.userId = jSONObject.optString("userId");
                historyAccount.tokenKey = jSONObject.optString("tokenKey");
                historyAccount.mobile = jSONObject.optString("mobile");
                historyAccount.nick = jSONObject.optString("nick");
                historyAccount.email = jSONObject.optString("email");
                historyAccount.t = jSONObject.optString("t");
                arrayList.add(historyAccount);
            }
        }
        return arrayList;
    }

    private String toJSONString(List<HistoryAccount> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (HistoryAccount historyAccount : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userId", historyAccount.userId);
                jSONObject.put("tokenKey", historyAccount.tokenKey);
                jSONObject.put("nick", historyAccount.nick);
                jSONObject.put("email", historyAccount.email);
                jSONObject.put("mobile", historyAccount.mobile);
                jSONObject.put("t", String.valueOf(System.currentTimeMillis()));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return jSONArray.toString();
    }

    public void clearHistoryAccount() {
        ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
    }

    public HistoryAccount findHistoryAccount(String str) {
        try {
            List<HistoryAccount> historyAccounts = getHistoryAccounts();
            if (historyAccounts != null) {
                for (HistoryAccount historyAccount : historyAccounts) {
                    String str2 = historyAccount.userId;
                    if (str2 != null && str2.equals(str)) {
                        return historyAccount;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public List<HistoryAccount> getHistoryAccounts() {
        String dDpExValue = ((StorageService) AliMemberSDK.getService(StorageService.class)).getDDpExValue(HISTORY_LOGIN_ACCOUNTS);
        if (TextUtils.isEmpty(dDpExValue)) {
            return new ArrayList();
        }
        try {
            return parseObject(dDpExValue);
        } catch (JSONException unused) {
            ArrayList arrayList = new ArrayList();
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0010  */
    public HistoryAccount matchHistoryAccount(String str) {
        List<HistoryAccount> historyAccounts = getHistoryAccounts();
        if (historyAccounts == null) {
            return null;
        }
        for (HistoryAccount historyAccount : historyAccounts) {
            if (TextUtils.equals(str, historyAccount.nick) || TextUtils.equals(str, historyAccount.email) || TextUtils.equals(str, historyAccount.mobile)) {
                return historyAccount;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }

    public void putLoginHistory(HistoryAccount historyAccount, String str) {
        if (!ConfigManager.getInstance().isSaveHistoryWithSalt() || ((StorageService) AliMemberSDK.getService(StorageService.class)).saveSafeToken(historyAccount.tokenKey, str)) {
            List<HistoryAccount> historyAccounts = getHistoryAccounts();
            if (historyAccounts != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(historyAccount);
                for (HistoryAccount historyAccount2 : historyAccounts) {
                    if (arrayList.size() >= ConfigManager.getInstance().getMaxHistoryAccount()) {
                        break;
                    } else if (TextUtils.isEmpty(historyAccount2.userId) || !historyAccount2.userId.equals(historyAccount.userId)) {
                        arrayList.add(historyAccount2);
                    }
                }
                ((StorageService) AliMemberSDK.getService(StorageService.class)).putDDpExValue(HISTORY_LOGIN_ACCOUNTS, toJSONString(arrayList));
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(historyAccount);
            ((StorageService) AliMemberSDK.getService(StorageService.class)).putDDpExValue(HISTORY_LOGIN_ACCOUNTS, toJSONString(arrayList2));
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024 A[Catch:{ JSONException -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[Catch:{ JSONException -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    public void removeHistoryAccount(HistoryAccount historyAccount) {
        ArrayList arrayList;
        if (historyAccount != null) {
            try {
                ((StorageService) AliMemberSDK.getService(StorageService.class)).removeSafeToken(historyAccount.tokenKey);
                String str = "";
                str = ((StorageService) AliMemberSDK.getService(StorageService.class)).getDDpExValue(HISTORY_LOGIN_ACCOUNTS);
                try {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList = new ArrayList();
                    } else {
                        arrayList = parseObject(str);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    arrayList = new ArrayList();
                    ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
                }
                if (arrayList != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (HistoryAccount historyAccount2 : arrayList) {
                        if (!historyAccount2.userId.equals(historyAccount.userId)) {
                            arrayList2.add(historyAccount2);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (arrayList != null) {
                    return;
                }
                if (arrayList.isEmpty()) {
                    ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
                } else {
                    ((StorageService) AliMemberSDK.getService(StorageService.class)).putDDpExValue(HISTORY_LOGIN_ACCOUNTS, toJSONString(arrayList));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
