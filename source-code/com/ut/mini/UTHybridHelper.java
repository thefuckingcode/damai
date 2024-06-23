package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.taobao.ju.track.JTrack;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import tb.ar2;
import tb.zf2;

/* compiled from: Taobao */
public class UTHybridHelper {
    private static final String TAG = "UTHybridHelper";
    private static UTHybridHelper s_instance = new UTHybridHelper();

    private String _getPageEventObjectCacheKey(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName();
        }
        int hashCode = obj.hashCode();
        return str + hashCode;
    }

    private void beginEvent(Map<String, String> map, Object obj, String str, String str2, Map<String, String> map2) {
        try {
            UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(UTEventTracker.getInstance().getKeyForObject(obj));
            eventByKey.setEventId(2001);
            eventByKey.setContext(obj);
            eventByKey.setPageName(str);
            eventByKey.setArg1(str2);
            eventByKey.updateProperties(map2);
            eventByKey.setH5Pv(true);
            UTEventTracker.getInstance().beginEvent(eventByKey);
            map.put(UTEvent.TAG_UTEVENT, "1");
        } catch (Exception unused) {
        }
    }

    private boolean checkUtUpdateSpm(Map<String, String> map) {
        if (map == null || !"1".equals(map.get("_ut_update_spm"))) {
            return false;
        }
        Logger.f(TAG, "_ut_update_spm=1");
        return true;
    }

    private String getH5PageName(String str, String str2) {
        if (str != null && !zf2.f(str)) {
            return str;
        }
        if (zf2.f(str2)) {
            return "";
        }
        int indexOf = str2.indexOf("?");
        return indexOf == -1 ? str2 : str2.substring(0, indexOf);
    }

    public static UTHybridHelper getInstance() {
        return s_instance;
    }

    private Map<String, String> getUTPageStateObjectSpmMap(Object obj, Map<String, String> map, String str, Map<String, String> map2) {
        return getUTPageStateObjectSpmMap(obj, map, str, "", map2, false);
    }

    private void h5Ctrl(String str, Date date, Map<String, String> map) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (Throwable unused) {
            i = -1;
        }
        if (i != -1 && map != null && map.size() != 0) {
            String h5PageName = getH5PageName(map.get("urlpagename"), map.get("url"));
            if (h5PageName == null || zf2.f(h5PageName)) {
                Logger.m("h5Ctrl", "pageName is null,return");
                return;
            }
            String str2 = map.get("logkey");
            if (str2 == null || zf2.f(str2)) {
                Logger.m("h5Ctrl", "logkey is null,return");
                return;
            }
            Map<String, String> map2 = null;
            String str3 = map.get("utjstype");
            map.remove("utjstype");
            if (str3 == null || str3.equals("0")) {
                map2 = h5CtrlParseArgsWithAplus(map);
            } else if (str3.equals("1")) {
                map2 = h5CtrlParseArgsWithOutAplus(map);
            }
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(h5PageName, i, str2, null, null, map2);
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(uTOriginalCustomHitBuilder.build());
                return;
            }
            Logger.i("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
    }

    private void h5Ctrl2(Map<String, String> map) {
        int i;
        if (map != null && map.size() != 0) {
            try {
                i = Integer.parseInt(map.remove("funcId"));
            } catch (Throwable unused) {
                i = -1;
            }
            if (i != -1) {
                String remove = map.remove("url");
                if (remove == null || zf2.f(remove)) {
                    Logger.m("h5Ctrl", "pageName is null,return");
                    return;
                }
                String remove2 = map.remove("logkey");
                if (remove2 == null || zf2.f(remove2)) {
                    Logger.m("h5Ctrl", "logkey is null,return");
                    return;
                }
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(remove, i, remove2, null, null, map);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                    return;
                }
                Logger.i("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
        }
    }

    private Map<String, String> h5CtrlParseArgsWithAplus(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("logkeyargs");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        hashMap.put("_lka", str);
        String str3 = map.get("cna");
        if (str3 == null) {
            str3 = str2;
        }
        hashMap.put("_cna", str3);
        String str4 = map.get("extendargs");
        if (str4 != null) {
            str2 = str4;
        }
        hashMap.put("_h5ea", str2);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> h5CtrlParseArgsWithOutAplus(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("extendargs");
        if (str == null) {
            str = "";
        }
        hashMap.put("_h5ea", str);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private void h5Page(Date date, Map<String, String> map, Object obj) {
        Map<String, String> map2;
        int i;
        Logger.d();
        if (map != null && map.size() != 0) {
            String str = map.get("url");
            String h5PageName = getH5PageName(map.get("urlpagename"), str);
            if (h5PageName == null || zf2.f(h5PageName)) {
                Logger.i("h5Page", "pageName is null,return");
                return;
            }
            String str2 = map.get("utjstype");
            map.remove("utjstype");
            if (str2 == null || str2.equals("0")) {
                map2 = h5PageParseArgsWithAplus(map);
            } else {
                map2 = str2.equals("1") ? h5PageParseArgsWithOutAplus(map) : null;
            }
            int i2 = UTPageHitHelper.getInstance().isH52001(obj) ? 2001 : 2006;
            String refPage = UTVariables.getInstance().getRefPage();
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(h5PageName, i2, refPage, null, null, map2);
            if (2001 == i2) {
                UTVariables.getInstance().setRefPage(h5PageName);
                Map<String, String> nextPageProperties = UTPageHitHelper.getInstance().getNextPageProperties(obj);
                if (nextPageProperties != null && nextPageProperties.size() > 0) {
                    uTOriginalCustomHitBuilder.setProperties(nextPageProperties);
                }
                if (obj instanceof Activity) {
                    uTOriginalCustomHitBuilder.setProperties(getUTPageStateObjectSpmMap(obj, map, str, nextPageProperties));
                }
            }
            try {
                String f = ar2.e().f(Uri.parse(str), null);
                if (!zf2.f(f)) {
                    uTOriginalCustomHitBuilder.setProperty("_tpk", f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                Map<String, String> build = uTOriginalCustomHitBuilder.build();
                if (i2 == 2001) {
                    UTPageSequenceMgr.pushNode(obj, build);
                    i = i2;
                    beginEvent(build, obj, h5PageName, refPage, map2);
                } else {
                    i = i2;
                }
                defaultTracker.send(UTPvidHelper.processH5PagePvid(i, build));
            } else {
                Logger.i("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
            UTPageHitHelper.getInstance().setH5Called(obj);
        }
    }

    private void h5Page2(Map<String, String> map, Object obj) {
        Map<String, String> uTPageStateObjectSpmMap;
        Logger.d();
        if (map == null || map.size() == 0) {
            Logger.m("h5Page2", "dataMap is null or empty,return");
            return;
        }
        String remove = map.remove("url");
        if (remove == null || zf2.f(remove)) {
            Logger.m("h5Page2", "pageName is null,return");
            return;
        }
        String refPage = UTVariables.getInstance().getRefPage();
        int i = UTPageHitHelper.getInstance().isH52001(obj) ? 2001 : 2006;
        HashMap hashMap = new HashMap(map);
        if (2001 == i) {
            UTVariables.getInstance().setRefPage(remove);
            Map<String, String> nextPageProperties = UTPageHitHelper.getInstance().getNextPageProperties(obj);
            if (nextPageProperties != null && nextPageProperties.size() > 0) {
                hashMap.putAll(nextPageProperties);
            }
            if ((obj instanceof Activity) && (uTPageStateObjectSpmMap = getUTPageStateObjectSpmMap(obj, map, remove, map.get("_h5url"), nextPageProperties)) != null) {
                hashMap.putAll(uTPageStateObjectSpmMap);
            }
        }
        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(remove, i, refPage, null, null, hashMap);
        try {
            String f = ar2.e().f(Uri.parse(map.get("_h5url")), null);
            if (!zf2.f(f)) {
                uTOriginalCustomHitBuilder.setProperty("_tpk", f);
            }
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
        UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
        if (defaultTracker != null) {
            Map<String, String> build = uTOriginalCustomHitBuilder.build();
            if (i == 2001) {
                UTPageSequenceMgr.pushNode(obj, build);
                beginEvent(build, obj, remove, refPage, hashMap);
            }
            defaultTracker.send(UTPvidHelper.processH5PagePvid(i, build));
        } else {
            Logger.i("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        UTPageHitHelper.getInstance().setH5Called(obj);
    }

    private Map<String, String> h5PageParseArgsWithAplus(Map<String, String> map) {
        Map argsMap;
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        String str2 = "";
        hashMap.put("_h5url", str == null ? str2 : str);
        if (str != null) {
            try {
                int indexOf = str.indexOf(63);
                if (indexOf > 0 && (argsMap = JTrack.Page.getArgsMap(str.substring(0, indexOf), Uri.parse(str))) != null) {
                    hashMap.putAll(argsMap);
                }
            } catch (Throwable unused) {
            }
        }
        if (str != null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("spm");
            if (queryParameter == null || zf2.f(queryParameter)) {
                hashMap.put("spm", "0.0.0.0");
            } else {
                hashMap.put("spm", queryParameter);
            }
            String queryParameter2 = parse.getQueryParameter("scm");
            if (queryParameter2 != null && !zf2.f(queryParameter2)) {
                hashMap.put("scm", queryParameter2);
            }
            String queryParameter3 = parse.getQueryParameter("pg1stepk");
            if (queryParameter3 != null && !zf2.f(queryParameter3)) {
                hashMap.put("pg1stepk", queryParameter3);
            }
            if (!zf2.f(parse.getQueryParameter("point"))) {
                hashMap.put("issb", "1");
            }
        } else {
            hashMap.put("spm", "0.0.0.0");
        }
        String str3 = map.get("spmcnt");
        if (str3 == null) {
            str3 = str2;
        }
        hashMap.put("_spmcnt", str3);
        String str4 = map.get("spmpre");
        if (str4 == null) {
            str4 = str2;
        }
        hashMap.put("_spmpre", str4);
        String str5 = map.get("lzsid");
        if (str5 == null) {
            str5 = str2;
        }
        hashMap.put("_lzsid", str5);
        String str6 = map.get("extendargs");
        if (str6 == null) {
            str6 = str2;
        }
        hashMap.put("_h5ea", str6);
        String str7 = map.get("cna");
        if (str7 != null) {
            str2 = str7;
        }
        hashMap.put("_cna", str2);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> h5PageParseArgsWithOutAplus(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        hashMap.put("_h5url", str);
        String str3 = map.get("extendargs");
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put("_h5ea", str2);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    public void h5UT(Map<String, String> map, Object obj) {
        if (Logger.n()) {
            Logger.f(TAG, "h5UT view", obj, "dataMap", map);
        }
        if (map == null || map.size() == 0) {
            Logger.i(TAG, "h5UT dataMap is empty");
            return;
        }
        String str = map.get("functype");
        if (str == null) {
            Logger.i(TAG, "h5UT funcType is null");
            return;
        }
        String str2 = map.get("utjstype");
        if (str2 == null || str2.equals("0") || str2.equals("1")) {
            map.remove("functype");
            Date date = new Date();
            if (str.equals("2001")) {
                h5Page(date, map, obj);
                UTTeamWork.getInstance().dispatchH5JSCall(obj, map);
                return;
            }
            h5Ctrl(str, date, map);
            return;
        }
        Logger.i(TAG, "h5UT utjstype should be 1 or 0 or null");
    }

    public void h5UT2(Map<String, String> map, Object obj) {
        if (Logger.n()) {
            Logger.f(TAG, "h5UT2 view", obj, "dataMap", map);
        }
        if (map == null || map.size() == 0) {
            Logger.i("h5UT", "dataMap is empty");
            return;
        }
        String remove = map.remove("functype");
        if (remove == null) {
            Logger.i("h5UT", "funcType is null");
        } else if (remove.equals("page")) {
            map.remove("funcId");
            h5Page2(map, obj);
            UTTeamWork.getInstance().dispatchH5JSCall(obj, map);
        } else if (remove.equals("ctrl")) {
            h5Ctrl2(map);
        }
    }

    public void setH5Url(String str) {
        UTAnalytics.getInstance().getDefaultTracker().setH5Url(str);
    }

    private Map<String, String> getUTPageStateObjectSpmMap(Object obj, Map<String, String> map, String str, String str2, Map<String, String> map2) {
        return getUTPageStateObjectSpmMap(obj, map, str, str2, map2, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fe, code lost:
        if (checkUtUpdateSpm(r24) != false) goto L_0x0106;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007d */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083 A[Catch:{ Exception -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x028b  */
    private Map<String, String> getUTPageStateObjectSpmMap(Object obj, Map<String, String> map, String str, String str2, Map<String, String> map2, boolean z) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z2;
        Object obj2;
        String str8;
        Object obj3;
        String str9;
        String str10;
        String str11;
        UTPageHitHelper.UTPageStateObject orNewUTPageStateObject = UTPageHitHelper.getInstance().getOrNewUTPageStateObject(obj);
        String str12 = null;
        if (orNewUTPageStateObject == null) {
            return null;
        }
        String str13 = "";
        if (map2 != null) {
            str13 = map2.get("utparam-url");
            str3 = map2.get("utparam-cnt");
        } else {
            str3 = str13;
        }
        if (z) {
            String str14 = map.get("spm-cnt");
            str6 = map.get("utparam-cnt");
            str5 = map.get("spm-url");
            str4 = map.get("utparam-url");
            String str15 = map.get("scm");
            if (!TextUtils.isEmpty(str2)) {
                Uri parse = Uri.parse(str2);
                if (TextUtils.isEmpty(str5)) {
                    str5 = parse.getQueryParameter("spm");
                }
                if (TextUtils.isEmpty(str4)) {
                    str4 = parse.getQueryParameter("utparam");
                }
                if (TextUtils.isEmpty(str15)) {
                    str15 = parse.getQueryParameter("scm");
                }
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    Uri parse2 = Uri.parse(str);
                    if (TextUtils.isEmpty(str5)) {
                        str5 = parse2.getQueryParameter("spm");
                    }
                    if (TextUtils.isEmpty(str4)) {
                        str4 = parse2.getQueryParameter("utparam");
                    }
                    if (TextUtils.isEmpty(str15)) {
                        str15 = parse2.getQueryParameter("scm");
                    }
                }
            } catch (Exception unused) {
            }
            str7 = str14;
            str12 = str15;
        } else {
            str7 = map.get("spmcnt");
            str6 = map.get("utparamcnt");
            try {
                Uri parse3 = Uri.parse(str);
                String queryParameter = parse3.getQueryParameter("spm");
                try {
                    str4 = parse3.getQueryParameter("utparam");
                    try {
                        str12 = parse3.getQueryParameter("scm");
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str4 = null;
                }
                str5 = queryParameter;
            } catch (Exception unused4) {
                str5 = null;
                str4 = null;
            }
        }
        if (TextUtils.isEmpty(orNewUTPageStateObject.mSpmUrl)) {
            orNewUTPageStateObject.mSpmUrl = str5;
        }
        if (TextUtils.isEmpty(orNewUTPageStateObject.mUtparamUrl)) {
            orNewUTPageStateObject.mUtparamUrl = str4;
        }
        if (TextUtils.isEmpty(orNewUTPageStateObject.mScmUrl)) {
            orNewUTPageStateObject.mScmUrl = str12;
        }
        if (!orNewUTPageStateObject.mIsH5Page) {
            orNewUTPageStateObject.mSpmCnt = str7;
            orNewUTPageStateObject.mSpmUrl = str5;
            if (!TextUtils.isEmpty(UTPageHitHelper.getInstance().getLastCacheKey())) {
                orNewUTPageStateObject.mSpmPre = UTPageHitHelper.getInstance().getLastCacheKeySpmUrl();
            }
            orNewUTPageStateObject.mScmUrl = str12;
            if (!TextUtils.isEmpty(UTPageHitHelper.getInstance().getLastCacheKey())) {
                orNewUTPageStateObject.mScmPre = UTPageHitHelper.getInstance().getLastCacheKeyScmUrl();
            }
            orNewUTPageStateObject.mIsBack = true;
            str6 = UTPageHitHelper.getInstance().refreshUtParam(str6, str3);
            orNewUTPageStateObject.mUtparamCnt = str6;
            str4 = UTPageHitHelper.getInstance().refreshUtParam(UTPageHitHelper.getInstance().refreshUtParam(str4, str13), UTPageHitHelper.getInstance().getLastCacheKeyUtParamCnt());
            orNewUTPageStateObject.mUtparamUrl = str4;
            if (!TextUtils.isEmpty(UTPageHitHelper.getInstance().getLastCacheKeyUtParam())) {
                orNewUTPageStateObject.mUtparamPre = UTPageHitHelper.getInstance().getLastCacheKeyUtParam();
            }
            UTPageHitHelper.getInstance().setLastCacheKey(_getPageEventObjectCacheKey(obj));
            UTPageHitHelper.getInstance().setLastCacheKeySpmUrl(str5);
            UTPageHitHelper.getInstance().setLastCacheKeyScmUrl(str12);
            UTPageHitHelper.getInstance().setLastCacheKeyUtParam(str4);
            UTPageHitHelper.getInstance().setLastCacheKeyUtParamCnt(str6);
            if (Logger.n()) {
                Logger.f(TAG, "h5Page mLastCacheKey", UTPageHitHelper.getInstance().getLastCacheKey(), "mLastCacheKeySpmUrl", UTPageHitHelper.getInstance().getLastCacheKeySpmUrl(), "mLastCacheKeyUtParam", UTPageHitHelper.getInstance().getLastCacheKeyUtParam(), "mLastCacheKeyUtParamCnt", UTPageHitHelper.getInstance().getLastCacheKeyUtParamCnt());
                z2 = true;
                Logger.f(TAG, "UTHybridHelper lPageStateObject PageStatMap", orNewUTPageStateObject.getPageStatMap(false));
                orNewUTPageStateObject.mIsH5Page = z2;
                if (!z) {
                    str9 = map.get("spm-pre");
                    obj3 = "utparam-cnt";
                    str8 = str6;
                    Logger.f(TAG, "UTHybridHelper spm-pre", str9);
                    if (TextUtils.isEmpty(str9)) {
                        String str16 = orNewUTPageStateObject.mSpmPre;
                        obj2 = "scm";
                        Logger.f(TAG, "UTHybridHelper mSpmPre", str16);
                        str9 = str16;
                    } else {
                        obj2 = "scm";
                    }
                    str10 = map.get("scm-pre");
                    Logger.f(TAG, "UTHybridHelper scm-pre", str10);
                    if (TextUtils.isEmpty(str10)) {
                        str10 = orNewUTPageStateObject.mScmPre;
                        Logger.f(TAG, "UTHybridHelper mScmPre", str10);
                    }
                    str11 = map.get("utparam-pre");
                    Logger.f(TAG, "UTHybridHelper utparam-pre", str11);
                    if (TextUtils.isEmpty(str11)) {
                        str11 = orNewUTPageStateObject.mUtparamPre;
                        Logger.f(TAG, "UTHybridHelper mUtparamPre", str11);
                    }
                } else {
                    obj3 = "utparam-cnt";
                    obj2 = "scm";
                    str8 = str6;
                    String str17 = map.get("spmpre");
                    Logger.f(TAG, "UTHybridHelper _spmpre", str17);
                    if (TextUtils.isEmpty(str17)) {
                        str17 = orNewUTPageStateObject.mSpmPre;
                        Logger.f(TAG, "UTHybridHelper mSpmPre", str17);
                    }
                    str9 = str17;
                    str10 = map.get("scmpre");
                    Logger.f(TAG, "UTHybridHelper _scmpre", str10);
                    if (TextUtils.isEmpty(str10)) {
                        str10 = orNewUTPageStateObject.mScmPre;
                        Logger.f(TAG, "UTHybridHelper mScmPre", str10);
                    }
                    str11 = map.get("utparampre");
                    Logger.f(TAG, "UTHybridHelper _utparampre", str11);
                    if (TextUtils.isEmpty(str11)) {
                        str11 = orNewUTPageStateObject.mUtparamPre;
                        Logger.f(TAG, "UTHybridHelper mUtparamPre", str11);
                    }
                }
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str7)) {
                    hashMap.put("spm-cnt", str7);
                }
                if (!TextUtils.isEmpty(str5)) {
                    hashMap.put("spm-url", str5);
                }
                if (!TextUtils.isEmpty(str9)) {
                    hashMap.put("spm-pre", str9);
                }
                if (!TextUtils.isEmpty(str12)) {
                    hashMap.put(obj2, str12);
                }
                if (!TextUtils.isEmpty(str10)) {
                    hashMap.put("scm-pre", str10);
                }
                if (!TextUtils.isEmpty(str8)) {
                    hashMap.put(obj3, str8);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("utparam-url", str4);
                }
                if (!TextUtils.isEmpty(str11)) {
                    hashMap.put("utparam-pre", str11);
                }
                return hashMap;
            }
        }
        z2 = true;
        orNewUTPageStateObject.mIsH5Page = z2;
        if (!z) {
        }
        HashMap hashMap2 = new HashMap();
        if (!TextUtils.isEmpty(str7)) {
        }
        if (!TextUtils.isEmpty(str5)) {
        }
        if (!TextUtils.isEmpty(str9)) {
        }
        if (!TextUtils.isEmpty(str12)) {
        }
        if (!TextUtils.isEmpty(str10)) {
        }
        if (!TextUtils.isEmpty(str8)) {
        }
        if (!TextUtils.isEmpty(str4)) {
        }
        if (!TextUtils.isEmpty(str11)) {
        }
        return hashMap2;
    }
}
