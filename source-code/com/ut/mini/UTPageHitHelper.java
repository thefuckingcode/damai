package com.ut.mini;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.ut.mini.extend.JTrackExtend;
import com.ut.mini.extend.UTExtendSwitch;
import com.ut.mini.module.UTOperationStack;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.ar2;
import tb.o70;
import tb.yi;
import tb.zf2;

/* compiled from: Taobao */
public class UTPageHitHelper {
    private static final String FORCE_SPM_CNT = "force-spm-cnt";
    private static final String FORCE_SPM_URL = "force-spm-url";
    static final String ISBF = "isbf";
    static final String ISFM = "isfm";
    private static final int MAX_SKIP_CLEAR_PAGE_OBJECT_CACHE_CAPACITY = 100;
    private static final int MAX_SPM_OBJECT_CACHE_CAPACITY = 50;
    static final String SKIPBK = "skipbk";
    static final String SPM_URL = "spm-url";
    private static final String TAG = "UTPageHitHelper";
    static final String UTPARAM_CNT = "utparam-cnt";
    static final String UTPARAM_PRE = "utparam-pre";
    static final String UTPARAM_URL = "utparam-url";
    static final String UT_ISBK = "ut_isbk";
    private static ArrayList<PageChangeListener> mPageChangerListeners = new ArrayList<>();
    private static UTPageHitHelper s_instance = new UTPageHitHelper();
    private Map<String, String> mBackupNextPageProperties = null;
    private Queue<String> mClearUTPageStateObjectList = new LinkedList();
    private String mCurPage = null;
    private String mCurrentPageCacheKey = null;
    private boolean mIsTurnOff = false;
    private String mLastCacheKey = null;
    private String mLastCacheKeyScmUrl = null;
    private String mLastCacheKeySpmUrl = null;
    private String mLastCacheKeyUtParam = null;
    private String mLastCacheKeyUtParamCnt = null;
    private Map<String, String> mNextPageProperties = new HashMap();
    private boolean mNextPageSkipBack = false;
    private Map<String, UTPageEventObject> mPageEventObjects = new HashMap();
    private Map<String, String> mPageProperties = new HashMap();
    private Map<String, UTPageStateObject> mPageStateObjects = new HashMap();
    private Queue<String> mSPMObjectList = new LinkedList();
    private Map<String, String> mSPMObjectMap = new HashMap();
    private Queue<UTPageEventObject> mSkipClearPageObjectList = new LinkedList();

    /* compiled from: Taobao */
    public interface PageChangeListener {
        void onPageAppear(Object obj);

        void onPageDisAppear(Object obj);
    }

    /* compiled from: Taobao */
    public static class UTPageEventObject {
        private String mCacheKey = null;
        private boolean mIsH5Called = false;
        private boolean mIsPageAppearCalled = false;
        private boolean mIsSkipPage = false;
        private Map<String, String> mNextPageProperties = null;
        private long mPageAppearTimestamp = 0;
        private String mPageName = null;
        private Map<String, String> mPageProperties = new HashMap();
        private UTPageStatus mPageStatus = null;
        private int mPageStatusCode = 0;
        private long mPageStayTimstamp = 0;
        private Uri mPageUrl = null;
        private String mRefPage = null;

        public String getCacheKey() {
            return this.mCacheKey;
        }

        public Map<String, String> getNextPageProperties() {
            return this.mNextPageProperties;
        }

        public long getPageAppearTimestamp() {
            return this.mPageAppearTimestamp;
        }

        public String getPageName() {
            return this.mPageName;
        }

        public Map<String, String> getPageProperties() {
            return this.mPageProperties;
        }

        public UTPageStatus getPageStatus() {
            return this.mPageStatus;
        }

        public int getPageStatusCode() {
            return this.mPageStatusCode;
        }

        public long getPageStayTimstamp() {
            return this.mPageStayTimstamp;
        }

        public Uri getPageUrl() {
            return this.mPageUrl;
        }

        public String getRefPage() {
            return this.mRefPage;
        }

        public boolean isH5Called() {
            return this.mIsH5Called;
        }

        public boolean isPageAppearCalled() {
            return this.mIsPageAppearCalled;
        }

        public boolean isSkipPage() {
            return this.mIsSkipPage;
        }

        public void resetPropertiesWithoutSkipFlagAndH5Flag() {
            this.mPageProperties = new HashMap();
            this.mPageAppearTimestamp = 0;
            this.mPageStayTimstamp = 0;
            this.mPageUrl = null;
            this.mPageName = null;
            this.mRefPage = null;
            UTPageStatus uTPageStatus = this.mPageStatus;
            if (uTPageStatus == null || uTPageStatus != UTPageStatus.UT_H5_IN_WebView) {
                this.mPageStatus = null;
            }
            this.mIsPageAppearCalled = false;
            this.mIsH5Called = false;
            this.mPageStatusCode = 0;
            this.mNextPageProperties = null;
        }

        public void setCacheKey(String str) {
            this.mCacheKey = str;
        }

        public void setH5Called() {
            this.mIsH5Called = true;
        }

        public void setNextPageProperties(Map<String, String> map) {
            this.mNextPageProperties = map;
        }

        public void setPageAppearCalled() {
            this.mIsPageAppearCalled = true;
        }

        public void setPageAppearTimestamp(long j) {
            this.mPageAppearTimestamp = j;
        }

        public void setPageName(String str) {
            this.mPageName = str;
        }

        public void setPageProperties(Map<String, String> map) {
            this.mPageProperties = map;
        }

        public void setPageStatus(UTPageStatus uTPageStatus) {
            this.mPageStatus = uTPageStatus;
        }

        public void setPageStatusCode(int i) {
            this.mPageStatusCode = i;
        }

        public void setPageStayTimstamp(long j) {
            this.mPageStayTimstamp = j;
        }

        public void setPageUrl(Uri uri) {
            this.mPageUrl = uri;
        }

        public void setRefPage(String str) {
            this.mRefPage = str;
        }

        public void setToSkipPage() {
            this.mIsSkipPage = true;
        }
    }

    /* compiled from: Taobao */
    public static class UTPageStateObject {
        public boolean mIsBack = false;
        public boolean mIsFrame = false;
        public boolean mIsH5Page = false;
        boolean mIsSkipBack = false;
        boolean mIsSkipBackForever = false;
        public boolean mIsSwitchBackground = false;
        public String mScmPre = null;
        public String mScmUrl = null;
        public String mSpmCnt = null;
        public String mSpmPre = null;
        public String mSpmUrl = null;
        public String mUtparamCnt = null;
        public String mUtparamPre = null;
        public String mUtparamUrl = null;

        public Map<String, String> getPageStatMap(boolean z) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.mSpmCnt)) {
                hashMap.put("spm-cnt", this.mSpmCnt);
            }
            if (!TextUtils.isEmpty(this.mSpmUrl)) {
                hashMap.put("spm-url", this.mSpmUrl);
            }
            if (!TextUtils.isEmpty(this.mSpmPre)) {
                hashMap.put("spm-pre", this.mSpmPre);
            }
            if (!TextUtils.isEmpty(this.mScmPre)) {
                hashMap.put("scm-pre", this.mScmPre);
            }
            if (this.mIsSwitchBackground) {
                hashMap.put(UTPageHitHelper.ISBF, "1");
            } else if (this.mIsFrame && z) {
                hashMap.put(UTPageHitHelper.ISFM, "1");
            } else if (this.mIsBack) {
                hashMap.put(UTPageHitHelper.UT_ISBK, "1");
            }
            if (!TextUtils.isEmpty(this.mUtparamCnt)) {
                hashMap.put("utparam-cnt", this.mUtparamCnt);
            }
            if (!TextUtils.isEmpty(this.mUtparamUrl)) {
                hashMap.put("utparam-url", this.mUtparamUrl);
            }
            if (!TextUtils.isEmpty(this.mUtparamPre)) {
                hashMap.put(UTPageHitHelper.UTPARAM_PRE, this.mUtparamPre);
            }
            return hashMap;
        }
    }

    private void _clearPageDisAppearContext() {
        this.mPageProperties = new HashMap();
        this.mCurrentPageCacheKey = null;
        this.mCurPage = null;
        this.mBackupNextPageProperties = null;
        UTVariables.getInstance().setBackupH5Url(null);
    }

    private synchronized void _clearUTPageEventObjectCache(UTPageEventObject uTPageEventObject) {
        if (this.mPageEventObjects.containsKey(uTPageEventObject.getCacheKey())) {
            this.mPageEventObjects.remove(uTPageEventObject.getCacheKey());
        }
    }

    private synchronized UTPageEventObject _getOrNewAUTPageEventObject(Object obj) {
        String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
        if (this.mPageEventObjects.containsKey(_getPageEventObjectCacheKey)) {
            return this.mPageEventObjects.get(_getPageEventObjectCacheKey);
        }
        UTPageEventObject uTPageEventObject = new UTPageEventObject();
        this.mPageEventObjects.put(_getPageEventObjectCacheKey, uTPageEventObject);
        uTPageEventObject.setCacheKey(_getPageEventObjectCacheKey);
        return uTPageEventObject;
    }

    private static String _getOutsideTTID(Uri uri) {
        List<String> queryParameters;
        if (uri == null || (queryParameters = uri.getQueryParameters("ttid")) == null) {
            return null;
        }
        for (String str : queryParameters) {
            if (!(str.contains(o70.DINAMIC_PREFIX_AT) || str.contains("%40"))) {
                return str;
            }
        }
        return null;
    }

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

    private static String _getPageName(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return simpleName.toLowerCase().endsWith("activity") ? simpleName.substring(0, simpleName.length() - 8) : simpleName;
    }

    private String _getSpmByUri(Uri uri) {
        String queryParameter = uri.getQueryParameter("spm");
        if (zf2.f(queryParameter)) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri.toString(), "UTF-8"));
                queryParameter = uri.getQueryParameter("spm");
            } catch (Exception e) {
                Logger.u("", e, new Object[0]);
            }
        }
        if (!zf2.f(queryParameter)) {
            return queryParameter;
        }
        String queryParameter2 = uri.getQueryParameter("spm_url");
        if (!zf2.f(queryParameter2)) {
            return queryParameter2;
        }
        try {
            return Uri.parse(URLDecoder.decode(uri.toString(), "UTF-8")).getQueryParameter("spm_url");
        } catch (Exception e2) {
            Logger.u("", e2, new Object[0]);
            return queryParameter2;
        }
    }

    private synchronized void _putUTPageEventObjectToCache(String str, UTPageEventObject uTPageEventObject) {
        this.mPageEventObjects.put(str, uTPageEventObject);
    }

    private synchronized void _releaseUTPageStateObject() {
        if (this.mClearUTPageStateObjectList.size() > 100) {
            for (int i = 0; i < 50; i++) {
                String poll = this.mClearUTPageStateObjectList.poll();
                if (poll != null && this.mPageStateObjects.containsKey(poll)) {
                    this.mPageStateObjects.remove(poll);
                }
            }
        }
    }

    private synchronized void _removeUTPageEventObject(Object obj) {
        String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
        if (this.mPageEventObjects.containsKey(_getPageEventObjectCacheKey)) {
            this.mPageEventObjects.remove(_getPageEventObjectCacheKey);
        }
    }

    public static synchronized void addPageChangerListener(PageChangeListener pageChangeListener) {
        synchronized (UTPageHitHelper.class) {
            if (pageChangeListener != null) {
                if (!mPageChangerListeners.contains(pageChangeListener)) {
                    mPageChangerListeners.add(pageChangeListener);
                }
            }
        }
    }

    private void clearMapEmptyValue(Map<String, Object> map) {
        try {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if (value == null) {
                    it.remove();
                } else if ((value instanceof String) && TextUtils.isEmpty((String) value)) {
                    it.remove();
                }
            }
        } catch (Exception e) {
            Logger.f("", e);
        }
    }

    private void clearUTPageStateObject(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            map.remove("spm-cnt");
            map.remove("spm-url");
            map.remove("spm-pre");
            map.remove("utparam-cnt");
            map.remove("utparam-url");
            map.remove(UTPARAM_PRE);
            map.remove("scm-pre");
        }
    }

    private UTPageStateObject copyUTPageStateObject(UTPageStateObject uTPageStateObject) {
        if (uTPageStateObject == null) {
            return null;
        }
        UTPageStateObject uTPageStateObject2 = new UTPageStateObject();
        uTPageStateObject2.mSpmCnt = uTPageStateObject.mSpmCnt;
        uTPageStateObject2.mSpmUrl = uTPageStateObject.mSpmUrl;
        uTPageStateObject2.mSpmPre = uTPageStateObject.mSpmPre;
        uTPageStateObject2.mIsBack = uTPageStateObject.mIsBack;
        uTPageStateObject2.mIsFrame = uTPageStateObject.mIsFrame;
        uTPageStateObject2.mIsSwitchBackground = uTPageStateObject.mIsSwitchBackground;
        uTPageStateObject2.mUtparamCnt = uTPageStateObject.mUtparamCnt;
        uTPageStateObject2.mUtparamUrl = uTPageStateObject.mUtparamUrl;
        uTPageStateObject2.mUtparamPre = uTPageStateObject.mUtparamPre;
        uTPageStateObject2.mScmUrl = uTPageStateObject.mScmUrl;
        uTPageStateObject2.mScmPre = uTPageStateObject.mScmPre;
        uTPageStateObject2.mIsSkipBack = uTPageStateObject.mIsSkipBack;
        uTPageStateObject2.mIsSkipBackForever = uTPageStateObject.mIsSkipBackForever;
        return uTPageStateObject2;
    }

    static synchronized void disPathcherPageChangerEvent(int i, Object obj) {
        synchronized (UTPageHitHelper.class) {
            int size = mPageChangerListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                PageChangeListener pageChangeListener = mPageChangerListeners.get(i2);
                if (pageChangeListener != null) {
                    if (i == 0) {
                        pageChangeListener.onPageAppear(obj);
                    } else {
                        pageChangeListener.onPageDisAppear(obj);
                    }
                }
            }
        }
    }

    public static Map<String, String> encodeUtParam(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        try {
            String str = map.get("utparam-cnt");
            if (!TextUtils.isEmpty(str)) {
                map.put("utparam-cnt", URLEncoder.encode(str));
            }
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
        try {
            String str2 = map.get("utparam-url");
            if (!TextUtils.isEmpty(str2)) {
                map.put("utparam-url", URLEncoder.encode(str2));
            }
        } catch (Throwable th2) {
            Logger.h(null, th2, new Object[0]);
        }
        try {
            String str3 = map.get(UTPARAM_PRE);
            if (!TextUtils.isEmpty(str3)) {
                map.put(UTPARAM_PRE, URLEncoder.encode(str3));
            }
        } catch (Throwable th3) {
            Logger.h(null, th3, new Object[0]);
        }
        try {
            String str4 = map.get("ut_seq");
            if (!TextUtils.isEmpty(str4)) {
                map.put("ut_seq", URLEncoder.encode(str4));
            }
        } catch (Throwable th4) {
            Logger.h(null, th4, new Object[0]);
        }
        return map;
    }

    private void forceSetSpm(UTPageStateObject uTPageStateObject, Map<String, String> map) {
        if (uTPageStateObject != null && map != null) {
            String str = map.get(FORCE_SPM_CNT);
            if (!TextUtils.isEmpty(str)) {
                uTPageStateObject.mSpmCnt = str;
            }
            String str2 = map.get(FORCE_SPM_URL);
            if (!TextUtils.isEmpty(str2)) {
                uTPageStateObject.mSpmUrl = str2;
            }
        }
    }

    public static UTPageHitHelper getInstance() {
        return s_instance;
    }

    private String getSpmUrl(Map<String, String> map, String str) {
        if (map == null) {
            return str;
        }
        String str2 = map.get("spm-url");
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = map.get("spm_url");
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = map.get("spm");
        return !TextUtils.isEmpty(str4) ? str4 : "";
    }

    private static boolean isDefaultActivityName(Object obj, String str) {
        String _getPageName;
        return (obj instanceof Activity) && (_getPageName = _getPageName(obj)) != null && _getPageName.equalsIgnoreCase(str);
    }

    private boolean isEmptyMap(Map<String, Object> map) {
        return map == null || map.size() < 1;
    }

    private Map<String, Object> parseJsonToMap(String str) {
        try {
            return (Map) JSON.parseObject(str, Map.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private void refreshUTPageStateObject(UTPageStateObject uTPageStateObject, Map<String, String> map, String str, String str2, String str3, String str4) {
        String str5;
        String str6 = map.get("spm-cnt");
        if (!TextUtils.isEmpty(str6)) {
            uTPageStateObject.mSpmCnt = str6;
        } else {
            uTPageStateObject.mSpmCnt = map.get(UTDataCollectorNodeColumn.SPM_CNT);
        }
        uTPageStateObject.mSpmUrl = getSpmUrl(map, str);
        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
            uTPageStateObject.mSpmPre = this.mLastCacheKeySpmUrl;
        } else {
            uTPageStateObject.mSpmPre = "";
        }
        if (!TextUtils.isEmpty(str3)) {
            uTPageStateObject.mScmUrl = str3;
        } else {
            uTPageStateObject.mScmUrl = map.get("scm");
        }
        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
            uTPageStateObject.mScmPre = this.mLastCacheKeyScmUrl;
        } else {
            uTPageStateObject.mScmPre = "";
        }
        String refreshUtParam = refreshUtParam(map.get("utparam-cnt"), str4);
        if (!TextUtils.isEmpty(refreshUtParam)) {
            uTPageStateObject.mUtparamCnt = refreshUtParam;
        } else {
            uTPageStateObject.mUtparamCnt = "";
        }
        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
            str5 = this.mLastCacheKeyUtParamCnt;
        } else {
            str5 = "";
        }
        uTPageStateObject.mUtparamUrl = refreshUtParam(str2, refreshUtParam(map.get("utparam-url"), str5));
        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
            uTPageStateObject.mUtparamPre = this.mLastCacheKeyUtParam;
        } else {
            uTPageStateObject.mUtparamPre = "";
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void _releaseSPMCacheObj(String str) {
        if (!this.mSPMObjectList.contains(str)) {
            this.mSPMObjectList.add(str);
        }
        if (this.mSPMObjectList.size() > 100) {
            for (int i = 0; i < 50; i++) {
                String poll = this.mSPMObjectList.poll();
                if (poll != null && this.mSPMObjectMap.containsKey(poll)) {
                    this.mSPMObjectMap.remove(poll);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void _releaseSkipFlagAndH5FlagPageObject(UTPageEventObject uTPageEventObject) {
        uTPageEventObject.resetPropertiesWithoutSkipFlagAndH5Flag();
        if (!this.mSkipClearPageObjectList.contains(uTPageEventObject)) {
            this.mSkipClearPageObjectList.add(uTPageEventObject);
        }
        if (this.mSkipClearPageObjectList.size() > 200) {
            for (int i = 0; i < 100; i++) {
                UTPageEventObject poll = this.mSkipClearPageObjectList.poll();
                if (poll != null && this.mPageEventObjects.containsKey(poll.getCacheKey())) {
                    this.mPageEventObjects.remove(poll.getCacheKey());
                }
            }
        }
    }

    public String getCurrentPageName() {
        return this.mCurPage;
    }

    public String getLastCacheKey() {
        return this.mLastCacheKey;
    }

    public String getLastCacheKeyScmUrl() {
        return this.mLastCacheKeyScmUrl;
    }

    public String getLastCacheKeySpmUrl() {
        return this.mLastCacheKeySpmUrl;
    }

    public String getLastCacheKeyUtParam() {
        return this.mLastCacheKeyUtParam;
    }

    public String getLastCacheKeyUtParamCnt() {
        return this.mLastCacheKeyUtParamCnt;
    }

    /* access modifiers changed from: package-private */
    public synchronized Map<String, String> getNextPageProperties(Object obj) {
        if (obj == null) {
            return null;
        }
        return _getOrNewAUTPageEventObject(obj).getNextPageProperties();
    }

    public synchronized UTPageStateObject getOrNewUTPageStateObject(Object obj) {
        if (!(obj instanceof Activity)) {
            return null;
        }
        String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
        if (!this.mClearUTPageStateObjectList.contains(_getPageEventObjectCacheKey)) {
            this.mClearUTPageStateObjectList.add(_getPageEventObjectCacheKey);
        }
        if (this.mPageStateObjects.containsKey(_getPageEventObjectCacheKey)) {
            return this.mPageStateObjects.get(_getPageEventObjectCacheKey);
        }
        UTPageStateObject uTPageStateObject = new UTPageStateObject();
        this.mPageStateObjects.put(_getPageEventObjectCacheKey, uTPageStateObject);
        return uTPageStateObject;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e9  */
    public synchronized Map<String, String> getPageAllProperties(Activity activity) {
        String str;
        String str2;
        String str3;
        String str4;
        Intent intent;
        if (activity != null) {
            if (this.mCurrentPageCacheKey != null) {
                UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(activity);
                if (!_getOrNewAUTPageEventObject.isPageAppearCalled()) {
                    Logger.i("getPagePropertiesWithSpmAndUtparam", "activity isPageAppearCalled is false");
                    return null;
                } else if (_getOrNewAUTPageEventObject.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != _getOrNewAUTPageEventObject.getPageStatus()) {
                    UTPageStateObject copyUTPageStateObject = copyUTPageStateObject(getOrNewUTPageStateObject(activity));
                    if (copyUTPageStateObject == null) {
                        Logger.i("getPagePropertiesWithSpmAndUtparam", "getOrNewUTPageStateObject is null");
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(this.mPageProperties);
                    if (_getOrNewAUTPageEventObject.getPageProperties() != null) {
                        hashMap.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                    }
                    String str5 = "";
                    String str6 = "";
                    String str7 = "";
                    Uri pageUrl = _getOrNewAUTPageEventObject.getPageUrl();
                    if (pageUrl == null && (intent = activity.getIntent()) != null) {
                        pageUrl = intent.getData();
                    }
                    if (pageUrl != null) {
                        try {
                            str5 = _getSpmByUri(pageUrl);
                        } catch (Throwable unused) {
                        }
                        try {
                            str6 = pageUrl.getQueryParameter("utparamcnt");
                        } catch (Throwable unused2) {
                        }
                        try {
                            str7 = pageUrl.getQueryParameter("utparam");
                        } catch (Throwable unused3) {
                        }
                        try {
                            str4 = str5;
                            str2 = pageUrl.getQueryParameter("scm");
                            str = str6;
                            str3 = str7;
                        } catch (Throwable unused4) {
                        }
                        boolean equals = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                        if (copyUTPageStateObject.mIsSwitchBackground) {
                            if ("1".equals(hashMap.get(SKIPBK)) || copyUTPageStateObject.mIsSkipBackForever || copyUTPageStateObject.mIsSkipBack) {
                                copyUTPageStateObject.mIsBack = false;
                                copyUTPageStateObject.mIsSkipBack = false;
                            }
                            if (!copyUTPageStateObject.mIsBack || (copyUTPageStateObject.mIsFrame && equals)) {
                                refreshUTPageStateObject(copyUTPageStateObject, hashMap, str4, str3, str2, str);
                            }
                        } else {
                            copyUTPageStateObject.mIsBack = false;
                            clearUTPageStateObject(hashMap);
                        }
                        if (copyUTPageStateObject.mIsBack) {
                            clearUTPageStateObject(hashMap);
                        }
                        forceSetSpm(copyUTPageStateObject, hashMap);
                        hashMap.putAll(copyUTPageStateObject.getPageStatMap(equals));
                        return hashMap;
                    }
                    str4 = str5;
                    str = str6;
                    str3 = str7;
                    str2 = "";
                    boolean equals2 = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                    if (copyUTPageStateObject.mIsSwitchBackground) {
                    }
                    if (copyUTPageStateObject.mIsBack) {
                    }
                    forceSetSpm(copyUTPageStateObject, hashMap);
                    hashMap.putAll(copyUTPageStateObject.getPageStatMap(equals2));
                    return hashMap;
                } else {
                    Logger.i("getPagePropertiesWithSpmAndUtparam", "activity is UT_H5_IN_WebView");
                    return null;
                }
            }
        }
        Logger.i("getPagePropertiesWithSpmAndUtparam", "activity or CurrentPageCacheKey is null");
        return null;
    }

    public synchronized Map<String, String> getPageProperties(Object obj) {
        if (obj == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.mPageProperties;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> pageProperties = _getOrNewAUTPageEventObject(obj).getPageProperties();
        if (pageProperties != null) {
            hashMap.putAll(pageProperties);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public synchronized String getPageScmPre(Activity activity) {
        String str;
        if (activity == null) {
            return "";
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(activity);
        if (_getOrNewAUTPageEventObject.getPageStatus() != null && UTPageStatus.UT_H5_IN_WebView == _getOrNewAUTPageEventObject.getPageStatus()) {
            return "";
        }
        String str2 = "";
        UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(activity);
        if (orNewUTPageStateObject != null) {
            boolean z = orNewUTPageStateObject.mIsBack;
            if (!orNewUTPageStateObject.mIsSwitchBackground) {
                boolean z2 = false;
                if (orNewUTPageStateObject.mIsSkipBackForever || orNewUTPageStateObject.mIsSkipBack) {
                    z = false;
                }
                boolean equals = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                if (!orNewUTPageStateObject.mIsFrame || !equals) {
                    z2 = z;
                }
                if (z2) {
                    str = orNewUTPageStateObject.mScmPre;
                } else if (!TextUtils.isEmpty(this.mLastCacheKey)) {
                    str = this.mLastCacheKeyScmUrl;
                }
                str2 = str;
            } else {
                str2 = orNewUTPageStateObject.mScmPre;
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public synchronized String getPageSpmPre(Activity activity) {
        String str;
        if (activity == null) {
            return "";
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(activity);
        if (_getOrNewAUTPageEventObject.getPageStatus() != null && UTPageStatus.UT_H5_IN_WebView == _getOrNewAUTPageEventObject.getPageStatus()) {
            return "";
        }
        String str2 = "";
        UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(activity);
        if (orNewUTPageStateObject != null) {
            boolean z = orNewUTPageStateObject.mIsBack;
            if (!orNewUTPageStateObject.mIsSwitchBackground) {
                boolean z2 = false;
                if (orNewUTPageStateObject.mIsSkipBackForever || orNewUTPageStateObject.mIsSkipBack) {
                    z = false;
                }
                boolean equals = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                if (!orNewUTPageStateObject.mIsFrame || !equals) {
                    z2 = z;
                }
                if (z2) {
                    str = orNewUTPageStateObject.mSpmPre;
                } else if (!TextUtils.isEmpty(this.mLastCacheKey)) {
                    str = this.mLastCacheKeySpmUrl;
                }
                str2 = str;
            } else {
                str2 = orNewUTPageStateObject.mSpmPre;
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public synchronized String getPageSpmUrl(Activity activity) {
        Intent intent;
        if (activity == null) {
            return "";
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(activity);
        if (_getOrNewAUTPageEventObject.getPageStatus() != null && UTPageStatus.UT_H5_IN_WebView == _getOrNewAUTPageEventObject.getPageStatus()) {
            return "";
        }
        String str = "";
        Uri pageUrl = _getOrNewAUTPageEventObject.getPageUrl();
        if (pageUrl == null && (intent = activity.getIntent()) != null) {
            pageUrl = intent.getData();
        }
        if (pageUrl != null) {
            try {
                str = _getSpmByUri(pageUrl);
            } catch (Throwable unused) {
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(activity);
        if (orNewUTPageStateObject != null) {
            boolean z = orNewUTPageStateObject.mIsBack;
            if (!orNewUTPageStateObject.mIsSwitchBackground) {
                boolean z2 = false;
                if (orNewUTPageStateObject.mIsSkipBackForever || orNewUTPageStateObject.mIsSkipBack) {
                    z = false;
                }
                boolean equals = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                if (!orNewUTPageStateObject.mIsFrame || !equals) {
                    z2 = z;
                }
                if (!z2) {
                    Map<String, String> pageProperties = _getOrNewAUTPageEventObject.getPageProperties();
                    String str2 = pageProperties.get("spm-url");
                    String str3 = pageProperties.get("spm_url");
                    if (TextUtils.isEmpty(str2)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        } else {
                            str2 = pageProperties.get("spm");
                        }
                    }
                    str = str2;
                } else {
                    str = orNewUTPageStateObject.mSpmUrl;
                }
            } else {
                str = orNewUTPageStateObject.mSpmUrl;
            }
        }
        if (str == null) {
            str = "";
        }
        return str;
    }

    public synchronized String getPageUrl(Object obj) {
        if (obj == null) {
            return null;
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
        if (_getOrNewAUTPageEventObject == null || _getOrNewAUTPageEventObject.getPageUrl() == null) {
            return null;
        }
        return _getOrNewAUTPageEventObject.getPageUrl().toString();
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isH52001(Object obj) {
        if (obj != null) {
            UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
            if (_getOrNewAUTPageEventObject.getPageStatus() != null && _getOrNewAUTPageEventObject.getPageStatus() == UTPageStatus.UT_H5_IN_WebView) {
                Logger.f(TAG, "isH52001:true aPageObject", obj);
                return true;
            }
        }
        Logger.f(TAG, "isH52001:false aPageObject", obj);
        return false;
    }

    @Deprecated
    public synchronized void pageAppear(Object obj) {
        pageAppear(obj, null, false);
    }

    /* access modifiers changed from: package-private */
    public void pageAppearByAuto(Activity activity) {
        if (!this.mIsTurnOff) {
            pageAppear(activity);
        }
    }

    public void pageDestroyed(Activity activity) {
        String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(activity);
        if (this.mPageStateObjects.containsKey(_getPageEventObjectCacheKey)) {
            this.mPageStateObjects.remove(_getPageEventObjectCacheKey);
        }
        if (this.mClearUTPageStateObjectList.contains(_getPageEventObjectCacheKey)) {
            this.mClearUTPageStateObjectList.remove(_getPageEventObjectCacheKey);
        }
        _releaseUTPageStateObject();
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02a6 A[SYNTHETIC, Splitter:B:122:0x02a6] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x04b4  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x04ca A[Catch:{ Exception -> 0x04d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0520  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0591  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x05ae  */
    @Deprecated
    public synchronized void pageDisAppear(Object obj, UTTracker uTTracker) {
        boolean z;
        String str;
        Map<String, String> map;
        String str2;
        String str3;
        Uri pageUrl;
        String str4;
        String str5;
        String str6;
        UTPageStateObject orNewUTPageStateObject;
        long j;
        long j2;
        String uri;
        String f;
        boolean z2;
        Object th;
        String _getSpmByUri;
        String str7;
        String str8;
        String str9;
        String queryParameter;
        String str10;
        StringBuilder sb;
        Map<String, String> map2;
        Logger.f(TAG, "pageDisAppear aPageObject", obj);
        if (!UTAnalytics.getInstance().isInit()) {
            Logger.i(TAG, "pageDisAppear", "Please initialize UT_Analytics first");
            return;
        }
        if (obj == null) {
            Logger.i("pageDisAppear", "The page object should not be null");
        } else if (this.mCurrentPageCacheKey == null) {
            Logger.i("pageDisAppear", "UT has already recorded the page disappear event on this page");
        } else {
            UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
            boolean isPageAppearCalled = _getOrNewAUTPageEventObject.isPageAppearCalled();
            if (isPageAppearCalled) {
                UTTrackerListenerMgr.getInstance().pageDisAppear(uTTracker, obj);
                UTOperationStack instance = UTOperationStack.getInstance();
                instance.addAction("pageDisAppear:" + obj.getClass().getSimpleName());
                if (_getOrNewAUTPageEventObject.getPageStatus() != null && UTPageStatus.UT_H5_IN_WebView == _getOrNewAUTPageEventObject.getPageStatus()) {
                    if (1 == _getOrNewAUTPageEventObject.getPageStatusCode()) {
                        this.mNextPageProperties = this.mBackupNextPageProperties;
                        UTVariables.getInstance().setH5Url(UTVariables.getInstance().getBackupH5Url());
                    }
                    if (1 == _getOrNewAUTPageEventObject.getPageStatusCode() || _getOrNewAUTPageEventObject.isH5Called()) {
                        Logger.f("pageDisAppear", "UTTracker.PAGE_STATUS_CODE_302 or PageEventObject.isH5Called");
                        UTPageStateObject orNewUTPageStateObject2 = getOrNewUTPageStateObject(obj);
                        if (orNewUTPageStateObject2 != null) {
                            orNewUTPageStateObject2.mIsH5Page = false;
                        }
                        _releaseSkipFlagAndH5FlagPageObject(_getOrNewAUTPageEventObject);
                        _clearPageDisAppearContext();
                        return;
                    }
                }
                long pageAppearTimestamp = _getOrNewAUTPageEventObject.getPageAppearTimestamp();
                long elapsedRealtime = SystemClock.elapsedRealtime() - _getOrNewAUTPageEventObject.getPageStayTimstamp();
                if (obj instanceof Activity) {
                    disPathcherPageChangerEvent(1, obj);
                    if (!(!Logger.n() || ((Activity) obj).getIntent() == null || ((Activity) obj).getIntent().getData() == null)) {
                        Logger.m("pageDisAppear", "uri=" + ((Activity) obj).getIntent().getData().toString());
                    }
                    Uri pageUrl2 = _getOrNewAUTPageEventObject.getPageUrl();
                    String uri2 = pageUrl2 != null ? pageUrl2.toString() : null;
                    Intent intent = ((Activity) obj).getIntent();
                    Uri data = intent != null ? intent.getData() : null;
                    String uri3 = data != null ? data.toString() : null;
                    boolean z3 = (uri2 != null && !uri2.equals(uri3)) || (uri3 != null && !uri3.equals(uri2));
                    if (_getOrNewAUTPageEventObject.getPageUrl() == null && z3) {
                        _getOrNewAUTPageEventObject.setPageUrl(data);
                    }
                }
                String pageName = _getOrNewAUTPageEventObject.getPageName();
                String refPage = _getOrNewAUTPageEventObject.getRefPage();
                if (refPage == null || refPage.length() == 0) {
                    refPage = "-";
                }
                Map<String, String> map3 = this.mPageProperties;
                if (map3 == null) {
                    map3 = new HashMap<>();
                }
                if (UTExtendSwitch.bJTrackExtend) {
                    try {
                        if (obj instanceof Activity) {
                            Uri data2 = ((Activity) obj).getIntent().getData();
                            if (data2 != null) {
                                Object[] objArr = new Object[1];
                                StringBuilder sb2 = new StringBuilder();
                                str = pageName;
                                try {
                                    sb2.append("uri:");
                                    sb2.append(data2.toString());
                                    objArr[0] = sb2.toString();
                                    Logger.m("JTrack", objArr);
                                } catch (Throwable unused) {
                                }
                            } else {
                                str = pageName;
                            }
                            if (!zf2.f(_getOrNewAUTPageEventObject.getPageName())) {
                                Map<String, String> argsMap = JTrackExtend.getArgsMap(_getOrNewAUTPageEventObject.getPageName(), data2);
                                StringBuilder sb3 = new StringBuilder();
                                map2 = argsMap;
                                sb3.append("getArgsMap by pagename:");
                                sb3.append(_getOrNewAUTPageEventObject.getPageName());
                                Logger.m("JTrack", sb3.toString());
                            } else {
                                map2 = null;
                            }
                            if (map2 != null) {
                                if (map2.size() == 0) {
                                }
                                if (map2 != null && map2.size() > 0) {
                                    map3.putAll(map2);
                                    Logger.m("JTrack", "ArgsMap:" + zf2.a(map2));
                                }
                                if (_getOrNewAUTPageEventObject.getPageProperties() != null) {
                                    map3.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                }
                                if (obj instanceof IUTPageTrack) {
                                    IUTPageTrack iUTPageTrack = (IUTPageTrack) obj;
                                    String referPage = iUTPageTrack.getReferPage();
                                    if (!zf2.f(referPage)) {
                                        refPage = referPage;
                                    }
                                    Map<String, String> pageProperties = iUTPageTrack.getPageProperties();
                                    if (pageProperties != null && pageProperties.size() > 0) {
                                        this.mPageProperties.putAll(pageProperties);
                                        map3 = this.mPageProperties;
                                    }
                                    String pageName2 = iUTPageTrack.getPageName();
                                    if (!zf2.f(pageName2)) {
                                        str3 = pageName2;
                                        str2 = refPage;
                                        map = map3;
                                        String str11 = "";
                                        String str12 = "";
                                        String str13 = "";
                                        z = isPageAppearCalled;
                                        pageUrl = _getOrNewAUTPageEventObject.getPageUrl();
                                        if (pageUrl == null) {
                                            try {
                                                HashMap hashMap = new HashMap();
                                                str6 = "";
                                                try {
                                                    _getSpmByUri = _getSpmByUri(pageUrl);
                                                    if (!zf2.f(_getSpmByUri)) {
                                                        str8 = str11;
                                                        try {
                                                            sb = new StringBuilder();
                                                            str7 = str12;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            str11 = str8;
                                                            str5 = str11;
                                                            str4 = str12;
                                                            Logger.f("", th);
                                                            orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                            if (orNewUTPageStateObject == null) {
                                                            }
                                                            f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                            if (!zf2.f(f)) {
                                                            }
                                                            map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                            map.remove("_allow_override_value");
                                                            uri = pageUrl.toString();
                                                            if (!TextUtils.isEmpty(uri)) {
                                                            }
                                                            UTHitBuilders.UTPageHitBuilder uTPageHitBuilder = new UTHitBuilders.UTPageHitBuilder(str3);
                                                            uTPageHitBuilder.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                            String str14 = LogField.RECORD_TIMESTAMP.toString();
                                                            uTPageHitBuilder.setProperty(str14, "" + j);
                                                            uTPageHitBuilder.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                            UTVariables.getInstance().setRefPage(str3);
                                                            if (uTTracker == null) {
                                                            }
                                                        }
                                                        try {
                                                            sb.append(obj.getClass().getSimpleName());
                                                            sb.append(obj.hashCode());
                                                            String sb4 = sb.toString();
                                                            if (!(this.mSPMObjectMap.containsKey(sb4) && _getSpmByUri.equals(this.mSPMObjectMap.get(sb4)))) {
                                                                hashMap.put("spm", _getSpmByUri);
                                                                this.mSPMObjectMap.put(sb4, _getSpmByUri);
                                                                _releaseSPMCacheObj(sb4);
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            str11 = str8;
                                                            str12 = str7;
                                                            str5 = str11;
                                                            str4 = str12;
                                                            Logger.f("", th);
                                                            orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                            if (orNewUTPageStateObject == null) {
                                                            }
                                                            f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                            if (!zf2.f(f)) {
                                                            }
                                                            map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                            map.remove("_allow_override_value");
                                                            uri = pageUrl.toString();
                                                            if (!TextUtils.isEmpty(uri)) {
                                                            }
                                                            UTHitBuilders.UTPageHitBuilder uTPageHitBuilder2 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                            uTPageHitBuilder2.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                            String str142 = LogField.RECORD_TIMESTAMP.toString();
                                                            uTPageHitBuilder2.setProperty(str142, "" + j);
                                                            uTPageHitBuilder2.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                            UTVariables.getInstance().setRefPage(str3);
                                                            if (uTTracker == null) {
                                                            }
                                                        }
                                                    } else {
                                                        str8 = str11;
                                                        str7 = str12;
                                                    }
                                                    try {
                                                        str11 = pageUrl.getQueryParameter("utparamcnt");
                                                        try {
                                                            str12 = pageUrl.getQueryParameter("utparam");
                                                            try {
                                                                queryParameter = pageUrl.getQueryParameter("scm");
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                str6 = _getSpmByUri;
                                                                str5 = str11;
                                                                str4 = str12;
                                                                Logger.f("", th);
                                                                orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                                if (orNewUTPageStateObject == null) {
                                                                }
                                                                f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                                if (!zf2.f(f)) {
                                                                }
                                                                map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                                map.remove("_allow_override_value");
                                                                uri = pageUrl.toString();
                                                                if (!TextUtils.isEmpty(uri)) {
                                                                }
                                                                UTHitBuilders.UTPageHitBuilder uTPageHitBuilder22 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                                uTPageHitBuilder22.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                                String str1422 = LogField.RECORD_TIMESTAMP.toString();
                                                                uTPageHitBuilder22.setProperty(str1422, "" + j);
                                                                uTPageHitBuilder22.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                                UTVariables.getInstance().setRefPage(str3);
                                                                if (uTTracker == null) {
                                                                }
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            str9 = _getSpmByUri;
                                                            str6 = str9;
                                                            str12 = str7;
                                                            str5 = str11;
                                                            str4 = str12;
                                                            Logger.f("", th);
                                                            orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                            if (orNewUTPageStateObject == null) {
                                                            }
                                                            f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                            if (!zf2.f(f)) {
                                                            }
                                                            map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                            map.remove("_allow_override_value");
                                                            uri = pageUrl.toString();
                                                            if (!TextUtils.isEmpty(uri)) {
                                                            }
                                                            UTHitBuilders.UTPageHitBuilder uTPageHitBuilder222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                            uTPageHitBuilder222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                            String str14222 = LogField.RECORD_TIMESTAMP.toString();
                                                            uTPageHitBuilder222.setProperty(str14222, "" + j);
                                                            uTPageHitBuilder222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                            UTVariables.getInstance().setRefPage(str3);
                                                            if (uTTracker == null) {
                                                            }
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        str9 = _getSpmByUri;
                                                        str11 = str8;
                                                        str6 = str9;
                                                        str12 = str7;
                                                        str5 = str11;
                                                        str4 = str12;
                                                        Logger.f("", th);
                                                        orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                        if (orNewUTPageStateObject == null) {
                                                        }
                                                        f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                        if (!zf2.f(f)) {
                                                        }
                                                        map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                        map.remove("_allow_override_value");
                                                        uri = pageUrl.toString();
                                                        if (!TextUtils.isEmpty(uri)) {
                                                        }
                                                        UTHitBuilders.UTPageHitBuilder uTPageHitBuilder2222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                        uTPageHitBuilder2222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                        String str142222 = LogField.RECORD_TIMESTAMP.toString();
                                                        uTPageHitBuilder2222.setProperty(str142222, "" + j);
                                                        uTPageHitBuilder2222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                        UTVariables.getInstance().setRefPage(str3);
                                                        if (uTTracker == null) {
                                                        }
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    str5 = str11;
                                                    str4 = str12;
                                                    Logger.f("", th);
                                                    orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                    if (orNewUTPageStateObject == null) {
                                                    }
                                                    f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                    if (!zf2.f(f)) {
                                                    }
                                                    map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                    map.remove("_allow_override_value");
                                                    uri = pageUrl.toString();
                                                    if (!TextUtils.isEmpty(uri)) {
                                                    }
                                                    UTHitBuilders.UTPageHitBuilder uTPageHitBuilder22222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                    uTPageHitBuilder22222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                    String str1422222 = LogField.RECORD_TIMESTAMP.toString();
                                                    uTPageHitBuilder22222.setProperty(str1422222, "" + j);
                                                    uTPageHitBuilder22222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                    UTVariables.getInstance().setRefPage(str3);
                                                    if (uTTracker == null) {
                                                    }
                                                }
                                                try {
                                                    if (!zf2.f(queryParameter)) {
                                                        str10 = str11;
                                                        try {
                                                            hashMap.put("scm", queryParameter);
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            str13 = queryParameter;
                                                            str11 = str10;
                                                            str6 = _getSpmByUri;
                                                            str5 = str11;
                                                            str4 = str12;
                                                            Logger.f("", th);
                                                            orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                            if (orNewUTPageStateObject == null) {
                                                            }
                                                            f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                            if (!zf2.f(f)) {
                                                            }
                                                            map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                            map.remove("_allow_override_value");
                                                            uri = pageUrl.toString();
                                                            if (!TextUtils.isEmpty(uri)) {
                                                            }
                                                            UTHitBuilders.UTPageHitBuilder uTPageHitBuilder222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                            uTPageHitBuilder222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                            String str14222222 = LogField.RECORD_TIMESTAMP.toString();
                                                            uTPageHitBuilder222222.setProperty(str14222222, "" + j);
                                                            uTPageHitBuilder222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                            UTVariables.getInstance().setRefPage(str3);
                                                            if (uTTracker == null) {
                                                            }
                                                        }
                                                    } else {
                                                        str10 = str11;
                                                    }
                                                    String queryParameter2 = pageUrl.getQueryParameter("pg1stepk");
                                                    if (!zf2.f(queryParameter2)) {
                                                        str13 = queryParameter;
                                                        try {
                                                            hashMap.put("pg1stepk", queryParameter2);
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            str11 = str10;
                                                            str6 = _getSpmByUri;
                                                            str5 = str11;
                                                            str4 = str12;
                                                            Logger.f("", th);
                                                            orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                            if (orNewUTPageStateObject == null) {
                                                            }
                                                            f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                            if (!zf2.f(f)) {
                                                            }
                                                            map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                            map.remove("_allow_override_value");
                                                            uri = pageUrl.toString();
                                                            if (!TextUtils.isEmpty(uri)) {
                                                            }
                                                            UTHitBuilders.UTPageHitBuilder uTPageHitBuilder2222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                            uTPageHitBuilder2222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                            String str142222222 = LogField.RECORD_TIMESTAMP.toString();
                                                            uTPageHitBuilder2222222.setProperty(str142222222, "" + j);
                                                            uTPageHitBuilder2222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                            UTVariables.getInstance().setRefPage(str3);
                                                            if (uTTracker == null) {
                                                            }
                                                        }
                                                    } else {
                                                        str13 = queryParameter;
                                                    }
                                                    if (!zf2.f(pageUrl.getQueryParameter("point"))) {
                                                        hashMap.put("issb", "1");
                                                    }
                                                    String _getOutsideTTID = _getOutsideTTID(pageUrl);
                                                    if (!zf2.f(_getOutsideTTID)) {
                                                        yi.c().n(_getOutsideTTID);
                                                    }
                                                    if (hashMap.size() > 0) {
                                                        map.putAll(hashMap);
                                                    }
                                                    str5 = str10;
                                                    str6 = _getSpmByUri;
                                                    str4 = str12;
                                                } catch (Throwable th10) {
                                                    th = th10;
                                                    str13 = queryParameter;
                                                    str6 = _getSpmByUri;
                                                    str5 = str11;
                                                    str4 = str12;
                                                    Logger.f("", th);
                                                    orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                    if (orNewUTPageStateObject == null) {
                                                    }
                                                    f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                    if (!zf2.f(f)) {
                                                    }
                                                    map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                    map.remove("_allow_override_value");
                                                    uri = pageUrl.toString();
                                                    if (!TextUtils.isEmpty(uri)) {
                                                    }
                                                    UTHitBuilders.UTPageHitBuilder uTPageHitBuilder22222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                    uTPageHitBuilder22222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                    String str1422222222 = LogField.RECORD_TIMESTAMP.toString();
                                                    uTPageHitBuilder22222222.setProperty(str1422222222, "" + j);
                                                    uTPageHitBuilder22222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                    UTVariables.getInstance().setRefPage(str3);
                                                    if (uTTracker == null) {
                                                    }
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                str6 = "";
                                                str5 = str11;
                                                str4 = str12;
                                                Logger.f("", th);
                                                orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                                if (orNewUTPageStateObject == null) {
                                                }
                                                f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                                if (!zf2.f(f)) {
                                                }
                                                map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                                map.remove("_allow_override_value");
                                                uri = pageUrl.toString();
                                                if (!TextUtils.isEmpty(uri)) {
                                                }
                                                UTHitBuilders.UTPageHitBuilder uTPageHitBuilder222222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                                uTPageHitBuilder222222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                                String str14222222222 = LogField.RECORD_TIMESTAMP.toString();
                                                uTPageHitBuilder222222222.setProperty(str14222222222, "" + j);
                                                uTPageHitBuilder222222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                                UTVariables.getInstance().setRefPage(str3);
                                                if (uTTracker == null) {
                                                }
                                            }
                                        } else {
                                            str6 = "";
                                            str5 = str11;
                                            str4 = str12;
                                        }
                                        orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                        if (orNewUTPageStateObject == null) {
                                            if (_getOrNewAUTPageEventObject.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != _getOrNewAUTPageEventObject.getPageStatus()) {
                                                boolean equals = _getPageEventObjectCacheKey(obj).equals(this.mLastCacheKey);
                                                if (!orNewUTPageStateObject.mIsSwitchBackground) {
                                                    if ("1".equals(map.get(SKIPBK)) || orNewUTPageStateObject.mIsSkipBackForever || orNewUTPageStateObject.mIsSkipBack) {
                                                        orNewUTPageStateObject.mIsBack = false;
                                                        orNewUTPageStateObject.mIsSkipBack = false;
                                                    }
                                                    if (!orNewUTPageStateObject.mIsBack || (orNewUTPageStateObject.mIsFrame && equals)) {
                                                        z2 = equals;
                                                        j2 = elapsedRealtime;
                                                        j = pageAppearTimestamp;
                                                        refreshUTPageStateObject(orNewUTPageStateObject, map, str6, str4, str13, str5);
                                                    } else {
                                                        z2 = equals;
                                                        j2 = elapsedRealtime;
                                                        j = pageAppearTimestamp;
                                                    }
                                                } else {
                                                    z2 = equals;
                                                    j2 = elapsedRealtime;
                                                    j = pageAppearTimestamp;
                                                    orNewUTPageStateObject.mIsBack = false;
                                                    clearUTPageStateObject(map);
                                                }
                                                if (orNewUTPageStateObject.mIsBack) {
                                                    clearUTPageStateObject(map);
                                                }
                                                forceSetSpm(orNewUTPageStateObject, _getOrNewAUTPageEventObject.getPageProperties());
                                                map.putAll(orNewUTPageStateObject.getPageStatMap(z2));
                                            } else {
                                                if (orNewUTPageStateObject.mIsBack) {
                                                    clearUTPageStateObject(map);
                                                }
                                                map.putAll(orNewUTPageStateObject.getPageStatMap(false));
                                                j2 = elapsedRealtime;
                                                j = pageAppearTimestamp;
                                            }
                                            setLastCacheKey(_getPageEventObjectCacheKey(obj));
                                            setLastCacheKeySpmUrl(orNewUTPageStateObject.mSpmUrl);
                                            setLastCacheKeyScmUrl(orNewUTPageStateObject.mScmUrl);
                                            setLastCacheKeyUtParam(orNewUTPageStateObject.mUtparamUrl);
                                            setLastCacheKeyUtParamCnt(orNewUTPageStateObject.mUtparamCnt);
                                            Logger.f("", "mLastCacheKey:" + this.mLastCacheKey + ",mLastCacheKeySpmUrl:" + this.mLastCacheKeySpmUrl + ",mLastCacheKeyUtParam:" + this.mLastCacheKeyUtParam + ",mLastCacheKeyUtParamCnt:" + this.mLastCacheKeyUtParamCnt);
                                            orNewUTPageStateObject.mIsBack = true;
                                            orNewUTPageStateObject.mIsSwitchBackground = false;
                                        } else {
                                            j2 = elapsedRealtime;
                                            j = pageAppearTimestamp;
                                        }
                                        f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                        if (!zf2.f(f)) {
                                            map.put("_tpk", f);
                                        }
                                        if (_getOrNewAUTPageEventObject.getPageProperties() != null && _getOrNewAUTPageEventObject.getPageProperties().containsKey("_allow_override_value")) {
                                            map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                            map.remove("_allow_override_value");
                                        }
                                        if (("Page_Webview".equalsIgnoreCase(str3) || (UTPageStatus.UT_H5_IN_WebView == _getOrNewAUTPageEventObject.getPageStatus() && isDefaultActivityName(obj, str3))) && pageUrl != null) {
                                            uri = pageUrl.toString();
                                            if (!TextUtils.isEmpty(uri)) {
                                                int indexOf = uri.indexOf("?");
                                                String substring = indexOf != -1 ? uri.substring(0, indexOf) : uri;
                                                if (!TextUtils.isEmpty(substring)) {
                                                    str3 = substring;
                                                }
                                                Logger.f("", "temp", uri, "urlForPageName", substring);
                                            }
                                        }
                                        UTHitBuilders.UTPageHitBuilder uTPageHitBuilder2222222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                        uTPageHitBuilder2222222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                        String str142222222222 = LogField.RECORD_TIMESTAMP.toString();
                                        uTPageHitBuilder2222222222.setProperty(str142222222222, "" + j);
                                        uTPageHitBuilder2222222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                        UTVariables.getInstance().setRefPage(str3);
                                        if (uTTracker == null) {
                                            Map<String, String> processPagePvid = UTPvidHelper.processPagePvid(uTPageHitBuilder2222222222.build());
                                            UTPageSequenceMgr.pushNode(obj, processPagePvid);
                                            processPagePvid.put(UTEvent.TAG_UTEVENT, "1");
                                            uTTracker.send(processPagePvid);
                                            UTTrackerListenerMgr.getInstance().pageDisAppearEnd(uTTracker, obj, processPagePvid);
                                        } else {
                                            throw new NullPointerException("Tracker instance is null,please init sdk first.");
                                        }
                                    }
                                }
                                str2 = refPage;
                                map = map3;
                                str3 = str;
                                String str112 = "";
                                String str122 = "";
                                String str132 = "";
                                z = isPageAppearCalled;
                                pageUrl = _getOrNewAUTPageEventObject.getPageUrl();
                                if (pageUrl == null) {
                                }
                                orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                                if (orNewUTPageStateObject == null) {
                                }
                                f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                                if (!zf2.f(f)) {
                                }
                                map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                                map.remove("_allow_override_value");
                                uri = pageUrl.toString();
                                if (!TextUtils.isEmpty(uri)) {
                                }
                                UTHitBuilders.UTPageHitBuilder uTPageHitBuilder22222222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                                uTPageHitBuilder22222222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                                String str1422222222222 = LogField.RECORD_TIMESTAMP.toString();
                                uTPageHitBuilder22222222222.setProperty(str1422222222222, "" + j);
                                uTPageHitBuilder22222222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                                UTVariables.getInstance().setRefPage(str3);
                                if (uTTracker == null) {
                                }
                            }
                            map2 = JTrackExtend.getArgsMap((Activity) obj, data2);
                            Logger.m("JTrack", "getArgsMap by activity:" + obj.getClass().getName());
                            map3.putAll(map2);
                            Logger.m("JTrack", "ArgsMap:" + zf2.a(map2));
                            if (_getOrNewAUTPageEventObject.getPageProperties() != null) {
                            }
                            if (obj instanceof IUTPageTrack) {
                            }
                            str2 = refPage;
                            map = map3;
                            str3 = str;
                            String str1122 = "";
                            String str1222 = "";
                            String str1322 = "";
                            z = isPageAppearCalled;
                            pageUrl = _getOrNewAUTPageEventObject.getPageUrl();
                            if (pageUrl == null) {
                            }
                            orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                            if (orNewUTPageStateObject == null) {
                            }
                            f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                            if (!zf2.f(f)) {
                            }
                            map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                            map.remove("_allow_override_value");
                            uri = pageUrl.toString();
                            if (!TextUtils.isEmpty(uri)) {
                            }
                            UTHitBuilders.UTPageHitBuilder uTPageHitBuilder222222222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                            uTPageHitBuilder222222222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                            String str14222222222222 = LogField.RECORD_TIMESTAMP.toString();
                            uTPageHitBuilder222222222222.setProperty(str14222222222222, "" + j);
                            uTPageHitBuilder222222222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                            UTVariables.getInstance().setRefPage(str3);
                            if (uTTracker == null) {
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                str = pageName;
                if (_getOrNewAUTPageEventObject.getPageProperties() != null) {
                }
                if (obj instanceof IUTPageTrack) {
                }
                str2 = refPage;
                map = map3;
                str3 = str;
                String str11222 = "";
                String str12222 = "";
                String str13222 = "";
                z = isPageAppearCalled;
                pageUrl = _getOrNewAUTPageEventObject.getPageUrl();
                if (pageUrl == null) {
                }
                orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
                if (orNewUTPageStateObject == null) {
                }
                try {
                    f = ar2.e().f(_getOrNewAUTPageEventObject.getPageUrl(), map);
                    if (!zf2.f(f)) {
                    }
                } catch (Exception e) {
                    Logger.f("", e.toString());
                }
                map.putAll(_getOrNewAUTPageEventObject.getPageProperties());
                map.remove("_allow_override_value");
                uri = pageUrl.toString();
                if (!TextUtils.isEmpty(uri)) {
                }
                UTHitBuilders.UTPageHitBuilder uTPageHitBuilder2222222222222 = new UTHitBuilders.UTPageHitBuilder(str3);
                uTPageHitBuilder2222222222222.setReferPage(str2).setDurationOnPage(j2).setProperties(map);
                String str142222222222222 = LogField.RECORD_TIMESTAMP.toString();
                uTPageHitBuilder2222222222222.setProperty(str142222222222222, "" + j);
                uTPageHitBuilder2222222222222.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
                UTVariables.getInstance().setRefPage(str3);
                if (uTTracker == null) {
                }
            } else {
                z = isPageAppearCalled;
                Logger.i(BizTime.UT, "Please call pageAppear first(" + _getPageName(obj) + ").");
            }
            if (_getOrNewAUTPageEventObject.isSkipPage()) {
                _releaseSkipFlagAndH5FlagPageObject(_getOrNewAUTPageEventObject);
            } else if (_getOrNewAUTPageEventObject.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != _getOrNewAUTPageEventObject.getPageStatus()) {
                _removeUTPageEventObject(obj);
            } else {
                _releaseSkipFlagAndH5FlagPageObject(_getOrNewAUTPageEventObject);
            }
            if (z) {
                _clearPageDisAppearContext();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pageDisAppearByAuto(Activity activity) {
        if (!this.mIsTurnOff) {
            pageDisAppear(activity, UTAnalytics.getInstance().getDefaultTracker());
        }
    }

    public void pageSwitchBackground() {
        UTPageStateObject uTPageStateObject;
        if (this.mPageStateObjects.containsKey(this.mLastCacheKey) && (uTPageStateObject = this.mPageStateObjects.get(this.mLastCacheKey)) != null) {
            uTPageStateObject.mIsSwitchBackground = true;
        }
    }

    /* access modifiers changed from: package-private */
    public String refreshUtParam(String str, String str2) {
        try {
            Map<String, Object> map = null;
            Map<String, Object> parseJsonToMap = !TextUtils.isEmpty(str) ? parseJsonToMap(str) : null;
            if (!TextUtils.isEmpty(str2)) {
                map = parseJsonToMap(str2);
            }
            if (!isEmptyMap(parseJsonToMap) && !isEmptyMap(map)) {
                map.putAll(parseJsonToMap);
                clearMapEmptyValue(map);
                return JSON.toJSONString(map);
            } else if (!isEmptyMap(parseJsonToMap) && isEmptyMap(map)) {
                clearMapEmptyValue(parseJsonToMap);
                return JSON.toJSONString(parseJsonToMap);
            } else if (!isEmptyMap(parseJsonToMap) || isEmptyMap(map)) {
                return "";
            } else {
                clearMapEmptyValue(map);
                return JSON.toJSONString(map);
            }
        } catch (Exception e) {
            Logger.f("", e);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void setH5Called(Object obj) {
        if (obj != null) {
            UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
            if (_getOrNewAUTPageEventObject.getPageStatus() != null) {
                _getOrNewAUTPageEventObject.setH5Called();
            }
        }
    }

    public void setLastCacheKey(String str) {
        this.mLastCacheKey = str;
    }

    public void setLastCacheKeyScmUrl(String str) {
        this.mLastCacheKeyScmUrl = str;
    }

    public void setLastCacheKeySpmUrl(String str) {
        this.mLastCacheKeySpmUrl = str;
    }

    public void setLastCacheKeyUtParam(String str) {
        this.mLastCacheKeyUtParam = str;
    }

    public void setLastCacheKeyUtParamCnt(String str) {
        this.mLastCacheKeyUtParamCnt = str;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setPageStatusCode(Object obj, int i) {
        if (obj != null) {
            _getOrNewAUTPageEventObject(obj).setPageStatusCode(i);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void skipBack(Object obj) {
        if (obj != null) {
            UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
            if (orNewUTPageStateObject != null) {
                orNewUTPageStateObject.mIsSkipBack = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void skipBackForever(Object obj, boolean z) {
        if (obj != null) {
            UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
            if (orNewUTPageStateObject != null) {
                orNewUTPageStateObject.mIsSkipBackForever = z;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void skipNextPageBack() {
        this.mNextPageSkipBack = true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void skipPage(Object obj) {
        if (obj != null) {
            Logger.f(TAG, "skipPage", obj);
            _getOrNewAUTPageEventObject(obj).setToSkipPage();
        }
    }

    @Deprecated
    public synchronized void turnOffAutoPageTrack() {
        this.mIsTurnOff = true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateNextPageProperties(Map<String, String> map) {
        if (map != null) {
            Map<String, String> map2 = this.mNextPageProperties;
            if (map2 == null) {
                this.mNextPageProperties = new HashMap(map);
            } else {
                map2.putAll(map);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateNextPageUtparam(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            Map<String, String> map = this.mNextPageProperties;
            if (map != null) {
                str2 = map.get("utparam-url");
            } else {
                this.mNextPageProperties = new HashMap();
            }
            String refreshUtParam = refreshUtParam(str, str2);
            if (!TextUtils.isEmpty(refreshUtParam)) {
                HashMap hashMap = new HashMap();
                hashMap.put("utparam-url", refreshUtParam);
                this.mNextPageProperties.putAll(hashMap);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateNextPageUtparamCnt(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            Map<String, String> map = this.mNextPageProperties;
            if (map != null) {
                str2 = map.get("utparam-cnt");
            } else {
                this.mNextPageProperties = new HashMap();
            }
            String refreshUtParam = refreshUtParam(str, str2);
            if (!TextUtils.isEmpty(refreshUtParam)) {
                HashMap hashMap = new HashMap();
                hashMap.put("utparam-cnt", refreshUtParam);
                this.mNextPageProperties.putAll(hashMap);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updatePageName(Object obj, String str) {
        Logger.f(TAG, "updatePageName", str);
        if (obj != null) {
            if (!zf2.f(str)) {
                _getOrNewAUTPageEventObject(obj).setPageName(str);
                this.mCurPage = str;
            }
        }
    }

    @Deprecated
    public synchronized void updatePageProperties(Map<String, String> map) {
        if (map != null) {
            Logger.i(TAG, "UTPageHitHelper.updatePageProperties is deprecated.Please use UTAnalytics.getInstance().getDefaultTracker().updatePageProperties with PageObject parameter.");
            this.mPageProperties.putAll(map);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        if (obj != null) {
            _getOrNewAUTPageEventObject(obj).setPageStatus(uTPageStatus);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updatePageUrl(Object obj, Uri uri) {
        if (obj != null) {
            _getOrNewAUTPageEventObject(obj).setPageUrl(uri);
            UTPagePropertiesHelper.updatePageProperties(obj);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updatePageUtparam(Object obj, String str) {
        if (obj != null) {
            if (!zf2.f(str)) {
                Map<String, String> pageProperties = getPageProperties(obj);
                String str2 = "";
                if (pageProperties != null) {
                    str2 = pageProperties.get("utparam-cnt");
                }
                String refreshUtParam = refreshUtParam(str, str2);
                if (!TextUtils.isEmpty(refreshUtParam)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("utparam-cnt", refreshUtParam);
                    updatePageProperties(obj, hashMap);
                }
                UTPagePropertiesHelper.updatePageProperties(obj);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void pageAppear(Object obj, String str, boolean z) {
        UTPageStateObject orNewUTPageStateObject;
        UTPageStateObject orNewUTPageStateObject2;
        Logger.f(TAG, "pageAppear aPageObject", obj, "aCustomPageName", str, "aIsDonotSkipFlag", Boolean.valueOf(z));
        if (!UTAnalytics.getInstance().isInit()) {
            Logger.i(TAG, "pageAppear", "Please initialize UT_Analytics first");
            return;
        }
        if (obj != null) {
            String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
            if (_getPageEventObjectCacheKey == null || !_getPageEventObjectCacheKey.equals(this.mCurrentPageCacheKey)) {
                if (this.mCurrentPageCacheKey != null) {
                    Logger.i("lost 2001", "Last page requires leave(" + this.mCurrentPageCacheKey + ").");
                }
                UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
                if (z || !_getOrNewAUTPageEventObject.isSkipPage()) {
                    UTPvidHelper.pageAppear();
                    UTTrackerListenerMgr.getInstance().pageAppear(UTAnalytics.getInstance().getDefaultTracker(), obj, str, z);
                    disPathcherPageChangerEvent(0, obj);
                    UTOperationStack instance = UTOperationStack.getInstance();
                    instance.addAction("pageAppear:" + obj.getClass().getSimpleName());
                    String h5Url = UTVariables.getInstance().getH5Url();
                    if (h5Url != null) {
                        UTVariables.getInstance().setBackupH5Url(h5Url);
                        try {
                            Uri parse = Uri.parse(h5Url);
                            String queryParameter = parse.getQueryParameter("spm");
                            String queryParameter2 = parse.getQueryParameter("scm");
                            this.mPageProperties.put("spm", queryParameter);
                            this.mPageProperties.put("scm", queryParameter2);
                        } catch (Throwable th) {
                            Logger.f("", th);
                        }
                        UTVariables.getInstance().setH5Url(null);
                    }
                    String _getPageName = _getPageName(obj);
                    if (UTExtendSwitch.bJTrackExtend) {
                        try {
                            String pageName = JTrackExtend.getPageName(obj.getClass().getSimpleName());
                            if (!TextUtils.isEmpty(pageName)) {
                                if (pageName.toLowerCase().endsWith("activity")) {
                                    pageName = pageName.substring(0, pageName.length() - 8);
                                }
                                Logger.m("JTrack", "getPageName:" + pageName);
                                _getPageName = pageName;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (zf2.f(str)) {
                        str = _getPageName;
                    }
                    if (!zf2.f(_getOrNewAUTPageEventObject.getPageName())) {
                        str = _getOrNewAUTPageEventObject.getPageName();
                    }
                    this.mCurPage = str;
                    _getOrNewAUTPageEventObject.setPageName(str);
                    _getOrNewAUTPageEventObject.setPageAppearTimestamp(System.currentTimeMillis());
                    _getOrNewAUTPageEventObject.setPageStayTimstamp(SystemClock.elapsedRealtime());
                    _getOrNewAUTPageEventObject.setRefPage(UTVariables.getInstance().getRefPage());
                    _getOrNewAUTPageEventObject.setPageAppearCalled();
                    Map<String, String> map = this.mNextPageProperties;
                    if (map != null) {
                        this.mBackupNextPageProperties = map;
                        _getOrNewAUTPageEventObject.setNextPageProperties(map);
                        Map<String, String> pageProperties = _getOrNewAUTPageEventObject.getPageProperties();
                        if (pageProperties == null) {
                            _getOrNewAUTPageEventObject.setPageProperties(this.mNextPageProperties);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.putAll(pageProperties);
                            hashMap.putAll(this.mNextPageProperties);
                            _getOrNewAUTPageEventObject.setPageProperties(hashMap);
                        }
                    }
                    this.mNextPageProperties = null;
                    this.mCurrentPageCacheKey = _getPageEventObjectCacheKey(obj);
                    if (this.mNextPageSkipBack && (orNewUTPageStateObject2 = getOrNewUTPageStateObject(obj)) != null) {
                        orNewUTPageStateObject2.mIsSkipBack = true;
                        this.mNextPageSkipBack = false;
                    }
                    _clearUTPageEventObjectCache(_getOrNewAUTPageEventObject);
                    _putUTPageEventObjectToCache(_getPageEventObjectCacheKey(obj), _getOrNewAUTPageEventObject);
                    if (z && _getOrNewAUTPageEventObject.isSkipPage() && (orNewUTPageStateObject = getOrNewUTPageStateObject(obj)) != null) {
                        orNewUTPageStateObject.mIsFrame = true;
                    }
                } else {
                    Logger.m("skip page[pageAppear]", "page name:" + obj.getClass().getSimpleName());
                }
            } else {
                Logger.f(TAG, "pageAppear", "pageAppear repeat");
            }
        } else {
            Logger.i("pageAppear", "The page object should not be null");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updatePageProperties(Object obj, Map<String, String> map) {
        if (!(obj == null || map == null)) {
            if (map.size() != 0) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
                Map<String, String> pageProperties = _getOrNewAUTPageEventObject.getPageProperties();
                if (pageProperties == null) {
                    _getOrNewAUTPageEventObject.setPageProperties(hashMap);
                } else {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.putAll(pageProperties);
                    hashMap2.putAll(hashMap);
                    _getOrNewAUTPageEventObject.setPageProperties(hashMap2);
                }
                UTPagePropertiesHelper.updatePageProperties(obj);
                return;
            }
        }
        Logger.i("", "failed to update project properties");
    }

    /* access modifiers changed from: package-private */
    public synchronized void pageAppear(Object obj, String str) {
        pageAppear(obj, str, false);
    }

    @Deprecated
    public synchronized void pageDisAppear(Object obj) {
        pageDisAppear(obj, UTAnalytics.getInstance().getDefaultTracker());
    }
}
