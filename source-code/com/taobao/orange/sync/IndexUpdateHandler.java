package com.taobao.orange.sync;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.alibaba.fastjson.JSON;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.OLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class IndexUpdateHandler {
    private static final long CHECK_INDEX_UPD_INTERVAL = 20000;
    static final String TAG = "IndexUpdateHandler";
    private static boolean disableTaobaoClientIndexCheckUpd = true;
    private static volatile long lastIndexUpdTime;
    static final Set<IndexUpdateInfo> mCurIndexUpdInfo = new HashSet();

    /* compiled from: Taobao */
    public static class IndexUpdateInfo implements Serializable {
        static final String SYNC_KEY_BASE_VERSION = "baseVersion";
        static final String SYNC_KEY_CDN = "cdn";
        static final String SYNC_KEY_MD5 = "md5";
        static final String SYNC_KEY_PROTOCOL = "protocol";
        static final String SYNC_KEY_RESOURCEID = "resourceId";
        public String baseVersion;
        public String cdn;
        public String md5;
        public String protocol;
        public String resourceId;

        public boolean checkValid() {
            if (!TextUtils.isEmpty(this.cdn) && !TextUtils.isEmpty(this.resourceId) && !TextUtils.isEmpty(this.md5)) {
                return true;
            }
            OLog.w(IndexUpdateHandler.TAG, "lack param", new Object[0]);
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IndexUpdateInfo indexUpdateInfo = (IndexUpdateInfo) obj;
            if (this.cdn.equals(indexUpdateInfo.cdn) && this.resourceId.equals(indexUpdateInfo.resourceId)) {
                return this.md5.equals(indexUpdateInfo.md5);
            }
            return false;
        }

        public int hashCode() {
            return (((this.cdn.hashCode() * 31) + this.resourceId.hashCode()) * 31) + this.md5.hashCode();
        }

        public String toString() {
            return "IndexUpdateInfo{" + "cdn='" + this.cdn + '\'' + ", resourceId='" + this.resourceId + '\'' + ", md5='" + this.md5 + '\'' + ", protocol='" + this.protocol + '\'' + ", baseVersion='" + this.baseVersion + '\'' + '}';
        }
    }

    public static void checkIndexUpdate(final String str, final String str2) {
        if (!AndroidUtil.isTaobaoPackage(GlobalOrange.context) || !disableTaobaoClientIndexCheckUpd) {
            synchronized (IndexUpdateHandler.class) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - lastIndexUpdTime <= CHECK_INDEX_UPD_INTERVAL) {
                    OLog.w(TAG, "checkIndexUpdate too frequently, interval should more than 20s", new Object[0]);
                    return;
                }
                lastIndexUpdTime = currentTimeMillis;
                OLog.i(TAG, "checkIndexUpdate", OConstant.DIMEN_INDEX_UPDATE_APP_INDEX_VERSION, str, "versionIndexVersion", str2);
                OThreadFactory.execute(new Runnable() {
                    /* class com.taobao.orange.sync.IndexUpdateHandler.AnonymousClass1 */

                    public void run() {
                        IndexUpdateHandler.updateIndex((String) new BaseAuthRequest<String>(null, false, GlobalOrange.indexDiff == 0 ? OConstant.REQTYPE_INDEX_UPDATE : OConstant.REQTYPE_PROBE_UPDATE) {
                            /* class com.taobao.orange.sync.IndexUpdateHandler.AnonymousClass1.AnonymousClass1 */

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public Map<String, String> getReqParams() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(OConstant.KEY_CLIENTAPPINDEXVERSION, str);
                                hashMap.put(OConstant.KEY_CLIENTVERSIONINDEXVERSION, str2);
                                return hashMap;
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public String getReqPostBody() {
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public String parseResContent(String str) {
                                return str;
                            }
                        }.syncRequest(), true);
                    }
                });
                return;
            }
        }
        OLog.w(TAG, "checkIndexUpdate skip as in com.taobao.taobao package", new Object[0]);
    }

    private static IndexUpdateInfo parseIndexUpdInfo(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z) {
            return (IndexUpdateInfo) JSON.parseObject(str, IndexUpdateInfo.class);
        }
        String[] split = str.split("&");
        if (split == null) {
            return null;
        }
        IndexUpdateInfo indexUpdateInfo = new IndexUpdateInfo();
        for (String str2 : split) {
            if (str2 != null) {
                String substring = str2.substring(str2.indexOf("=") + 1);
                if (str2.startsWith(ConnType.PK_CDN)) {
                    indexUpdateInfo.cdn = substring.trim();
                } else if (str2.startsWith("md5")) {
                    indexUpdateInfo.md5 = substring.trim();
                } else if (str2.startsWith("resourceId")) {
                    indexUpdateInfo.resourceId = substring.trim();
                } else if (str2.startsWith("protocol")) {
                    indexUpdateInfo.protocol = substring;
                } else if (str2.startsWith(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION)) {
                    indexUpdateInfo.baseVersion = substring.trim();
                }
            }
        }
        return indexUpdateInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        if (com.taobao.orange.util.OLog.isPrintLog(2) == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        com.taobao.orange.util.OLog.i(com.taobao.orange.sync.IndexUpdateHandler.TAG, "updateIndex", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if ("https".equalsIgnoreCase(r4.protocol) == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        r1 = "https";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        r1 = "http";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
        com.taobao.orange.GlobalOrange.schema = r1;
        com.taobao.orange.ConfigCenter.getInstance().updateIndex(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r5.remove(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    public static void updateIndex(String str, boolean z) {
        try {
            IndexUpdateInfo parseIndexUpdInfo = parseIndexUpdInfo(str, z);
            if (parseIndexUpdInfo != null && parseIndexUpdInfo.checkValid()) {
                Set<IndexUpdateInfo> set = mCurIndexUpdInfo;
                synchronized (set) {
                    if (!set.add(parseIndexUpdInfo)) {
                        if (OLog.isPrintLog(0)) {
                            OLog.v(TAG, "updateIndex is ongoing", new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            OLog.e(TAG, "updateIndex", th, new Object[0]);
        }
    }
}
