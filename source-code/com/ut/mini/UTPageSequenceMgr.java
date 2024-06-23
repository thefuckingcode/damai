package com.ut.mini;

import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.open.securitybodysdk.ISecurityBodyPageTrack;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.gj2;
import tb.yi;
import tb.zc2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UTPageSequenceMgr {
    private static String CONFIG = "{\"spm_seq\":{\"count\":4,\"page\":[\"Page_Detail\",\"Page_MyTaobao\"]}}";
    private static final String SPM_SEQ = "spm_seq";
    private static final String TAG = "UTPageSequenceMgr";
    static final String UT_SEQ = "ut_seq";
    private static boolean bInit = false;
    private static String mConfig = null;
    private static List<PageNode> mPageSequence = new ArrayList();
    private static int mSpmCount = 0;
    private static List<String> mSpmPageList = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class PageNode {
        int pageId;
        String pageName;
        String spmUrl;

        private PageNode() {
            this.pageName = "";
            this.spmUrl = "-";
        }
    }

    UTPageSequenceMgr() {
    }

    private static boolean compare(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private static int findNodeIndex(int i, String str) {
        int i2 = -1;
        for (int size = mPageSequence.size() - 1; size >= 0; size--) {
            PageNode pageNode = mPageSequence.get(size);
            if (pageNode != null && i == pageNode.pageId) {
                if (i2 < 0) {
                    i2 = size;
                }
                if (compare(str, pageNode.pageName)) {
                    return size;
                }
            }
        }
        return i2;
    }

    private static List<String> getSpmSeq(int i) {
        ArrayList arrayList = new ArrayList();
        int size = mPageSequence.size();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (size - 1) - i2;
            if (i3 < 0) {
                break;
            }
            PageNode pageNode = mPageSequence.get(i3);
            if (pageNode != null) {
                arrayList.add(pageNode.spmUrl);
            }
        }
        return arrayList;
    }

    public static void init() {
        if (!bInit) {
            bInit = true;
            Logger.f(TAG, UCCore.LEGACY_EVENT_INIT);
            gj2.c().f(new Runnable() {
                /* class com.ut.mini.UTPageSequenceMgr.AnonymousClass1 */

                public void run() {
                    try {
                        UTPageSequenceMgr.updateConfig(zc2.a(yi.c().b(), UTPageSequenceMgr.UT_SEQ));
                    } catch (Exception unused) {
                    }
                }
            });
            UTClientConfigMgr.d().f(new UTClientConfigMgr.IConfigChangeListener() {
                /* class com.ut.mini.UTPageSequenceMgr.AnonymousClass2 */

                @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
                public String getKey() {
                    return UTPageSequenceMgr.UT_SEQ;
                }

                @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
                public void onChange(String str) {
                    UTPageSequenceMgr.updateConfig(str);
                }
            });
        }
    }

    private static void popNode(int i) {
        int size = mPageSequence.size();
        int i2 = size - 1;
        if (i > i2) {
            Logger.i(TAG, "popIndex", Integer.valueOf(i), "maxIndex", Integer.valueOf(i2));
            return;
        }
        mPageSequence.subList(i + 1, size).clear();
    }

    private static void printSpmSeq() {
        ArrayList arrayList = new ArrayList();
        int size = mPageSequence.size();
        for (int i = 0; i < size; i++) {
            PageNode pageNode = mPageSequence.get(i);
            if (pageNode != null) {
                arrayList.add(pageNode.pageName + ":" + pageNode.spmUrl);
            } else {
                arrayList.add("");
            }
        }
        Logger.f(TAG, "PageSequence", JSON.toJSONString(arrayList));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[Catch:{ Exception -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ Exception -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[Catch:{ Exception -> 0x00c5 }] */
    public static synchronized void pushNode(Object obj, Map<String, String> map) {
        boolean z;
        String str;
        List<String> list;
        synchronized (UTPageSequenceMgr.class) {
            if (obj != null && map != null) {
                try {
                    int hashCode = obj.hashCode();
                    String str2 = map.get(LogField.PAGE.toString());
                    if (!map.containsKey("ut_isbk")) {
                        if (!map.containsKey("isbf")) {
                            z = false;
                            str = map.get("spm-url");
                            if (str == null) {
                                str = "-";
                            }
                            if (!z) {
                                int findNodeIndex = findNodeIndex(hashCode, str2);
                                if (findNodeIndex >= 0) {
                                    popNode(findNodeIndex);
                                    PageNode pageNode = mPageSequence.get(findNodeIndex);
                                    if (pageNode != null) {
                                        pageNode.pageName = str2;
                                        pageNode.spmUrl = str;
                                    }
                                } else {
                                    Logger.i(TAG, "Cannot find object", obj, ISecurityBodyPageTrack.PAGE_ID_KEY, Integer.valueOf(hashCode), "pageName", str2);
                                    PageNode pageNode2 = new PageNode();
                                    pageNode2.pageId = hashCode;
                                    pageNode2.pageName = str2;
                                    pageNode2.spmUrl = str;
                                    mPageSequence.add(pageNode2);
                                }
                            } else {
                                PageNode pageNode3 = new PageNode();
                                pageNode3.pageId = hashCode;
                                pageNode3.pageName = str2;
                                pageNode3.spmUrl = str;
                                mPageSequence.add(pageNode3);
                            }
                            if (mSpmCount > 0 && (list = mSpmPageList) != null && list.contains(str2)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(SPM_SEQ, getSpmSeq(mSpmCount));
                                map.put(UT_SEQ, JSON.toJSONString(hashMap));
                            }
                            return;
                        }
                    }
                    z = true;
                    str = map.get("spm-url");
                    if (str == null) {
                    }
                    if (!z) {
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(SPM_SEQ, getSpmSeq(mSpmCount));
                    map.put(UT_SEQ, JSON.toJSONString(hashMap2));
                } catch (Exception e) {
                    Logger.h(TAG, e, new Object[0]);
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        com.ut.mini.UTPageSequenceMgr.mSpmCount = 0;
        com.ut.mini.UTPageSequenceMgr.mSpmPageList = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r5.equalsIgnoreCase(com.ut.mini.UTPageSequenceMgr.mConfig) == false) goto L_0x000f;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0074 */
    public static synchronized void updateConfig(String str) {
        Map map;
        synchronized (UTPageSequenceMgr.class) {
            if (str != null) {
            }
            if (!(str == null && mConfig == null)) {
                mConfig = str;
                zc2.b(yi.c().b(), UT_SEQ, mConfig);
                String str2 = mConfig;
                if (str2 != null) {
                    try {
                        Map map2 = (Map) JSON.parseObject(str2, Map.class);
                        if (map2 != null && map2.size() > 0 && (map = (Map) map2.get(SPM_SEQ)) != null && map.size() > 0) {
                            mSpmCount = ((Integer) map.get(AdUtConstants.XAD_UT_ARG_COUNT)).intValue();
                            mSpmPageList = (List) map.get("page");
                        }
                    } catch (Exception e) {
                        Logger.h(TAG, e, new Object[0]);
                    }
                } else {
                    mSpmCount = 0;
                    mSpmPageList = null;
                }
                return;
            }
            return;
        }
    }
}
