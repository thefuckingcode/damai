package com.ut.mini.behavior.edgecomputing.datacollector;

import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.behavior.UTEventId;
import com.ut.mini.behavior.edgecomputing.node.BaseNode;
import com.ut.mini.behavior.edgecomputing.node.Edge;
import com.ut.mini.behavior.edgecomputing.node.ExposeNode;
import com.ut.mini.behavior.edgecomputing.node.OtherNode;
import com.ut.mini.behavior.edgecomputing.node.PVNode;
import com.ut.mini.behavior.edgecomputing.node.SceneNode;
import com.ut.mini.behavior.edgecomputing.node.ScrollNode;
import com.ut.mini.behavior.edgecomputing.node.TapNode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import tb.zf2;

/* compiled from: Taobao */
class UserActionTrack {
    private static final String TAG = "UserActionTrack";
    private static Map<String, PVNode> mAppearPVNodeMap = Collections.synchronizedMap(new HashMap());
    private static Map<String, SceneNode> mAppearSceneNodeMap = Collections.synchronizedMap(new HashMap());
    private static ScrollNode mAppearScrollNode;
    private static PVNode mLastAppearPvNode;
    private static PVNode mLastPvNode;

    UserActionTrack() {
    }

    public static synchronized void commitBeginScroll(final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (map != null) {
                final String str = "" + System.currentTimeMillis();
                UTDataStoreHelper.postRunnable(new Runnable() {
                    /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass1 */

                    public void run() {
                        UserActionTrack.commitEnterScrollNode(str, map);
                    }
                });
            }
        }
    }

    private static synchronized long commitEdge(BaseNode baseNode, BaseNode baseNode2, boolean z) {
        synchronized (UserActionTrack.class) {
            if (baseNode == null || baseNode2 == null) {
                return -1;
            }
            Edge edge = new Edge();
            edge.left_node_id = baseNode.id;
            edge.left_table = baseNode.getTableName();
            edge.left_event_id = baseNode.event_id;
            edge.left_event_name = baseNode.page;
            edge.left_scene = baseNode.scene;
            edge.right_node_id = baseNode2.id;
            edge.right_table = baseNode2.getTableName();
            edge.right_event_id = baseNode2.event_id;
            if (z) {
                edge.right_event_name = baseNode2.page;
            } else {
                try {
                    Map<String, String> map = baseNode2.bizMap;
                    if (map != null) {
                        edge.right_event_name = map.get(LogField.ARG1.toString());
                    }
                } catch (Exception unused) {
                }
            }
            edge.right_scene = baseNode2.scene;
            edge.create_time = baseNode2.updateTime;
            return edge.save();
        }
    }

    private static synchronized void commitEdgeInPv(BaseNode baseNode) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitEdgeInPv seqId", Long.valueOf(commitEdge(mLastAppearPvNode, baseNode, false)));
        }
    }

    private static synchronized void commitEdgeInScroll(BaseNode baseNode) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitEdgeInScroll seqId", Long.valueOf(commitEdge(mAppearScrollNode, baseNode, false)));
        }
    }

    public static synchronized void commitEndScroll(final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (map != null) {
                final String str = "" + System.currentTimeMillis();
                UTDataStoreHelper.postRunnable(new Runnable() {
                    /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass2 */

                    public void run() {
                        UserActionTrack.commitEndScrollNode(str, map);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void commitEndScrollNode(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (mAppearScrollNode != null) {
                if (map != null) {
                    String str2 = map.get(LogField.PAGE.toString());
                    if (str2 != null) {
                        if (str2.equals(mAppearScrollNode.page)) {
                            mAppearScrollNode.updateBizMap(map);
                            ScrollNode scrollNode = mAppearScrollNode;
                            scrollNode.updateTime = str;
                            Logger.f(TAG, "update count", Long.valueOf(scrollNode.update()));
                            mAppearScrollNode = null;
                        }
                    }
                }
            }
        }
    }

    public static synchronized void commitEnter(Object obj, final String str) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitEnter context", obj, "pageName", str);
            if (obj != null) {
                final String str2 = "" + obj.hashCode();
                final String str3 = "" + System.currentTimeMillis();
                UTDataStoreHelper.postRunnable(new Runnable() {
                    /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass5 */

                    public void run() {
                        Logger.f(UserActionTrack.TAG, "commitEnter contextHashCode", str2);
                        UserActionTrack.commitEnterNode(str2, str, str3);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void commitEnterNode(String str, String str2, String str3) {
        String str4;
        synchronized (UserActionTrack.class) {
            if (!zf2.f(str2)) {
                str4 = str + JSMethod.NOT_SET + str2.hashCode();
            } else {
                str4 = str;
            }
            PVNode pVNode = new PVNode();
            pVNode.cold_start_id = GlobalData.cold_start_id;
            pVNode.session_id = GlobalData.session_id;
            pVNode.pv_key = str4;
            pVNode.event_id = "2001";
            pVNode.createTime = str3;
            pVNode.user_id = GlobalData.getUserid();
            pVNode.page = str2;
            pVNode.scene = str2;
            long save = pVNode.save();
            Logger.f(TAG, "commitEnterNode seqId", Long.valueOf(save));
            if (save > 0) {
                pVNode.id = save;
                mLastAppearPvNode = pVNode;
                mAppearPVNodeMap.put(str, pVNode);
            }
        }
    }

    public static synchronized void commitEnterScene(final String str, final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitSceneEnter scene", str, "properties", map);
            if (!TextUtils.isEmpty(str)) {
                final String str2 = "" + System.currentTimeMillis();
                UTDataStoreHelper.postRunnable(new Runnable() {
                    /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass3 */

                    public void run() {
                        UserActionTrack.commitEnterSceneNode(str, map, str2);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void commitEnterSceneNode(String str, Map<String, String> map, String str2) {
        synchronized (UserActionTrack.class) {
            if (!zf2.f(str)) {
                SceneNode sceneNode = new SceneNode();
                sceneNode.cold_start_id = GlobalData.cold_start_id;
                sceneNode.session_id = GlobalData.session_id;
                sceneNode.event_id = "2701";
                sceneNode.createTime = str2;
                sceneNode.user_id = GlobalData.getUserid();
                sceneNode.page = str;
                sceneNode.scene = str;
                sceneNode.updateBizMap(map);
                long save = sceneNode.save();
                Logger.f(TAG, "commitEnterSceneNode seqId", Long.valueOf(save));
                if (save > 0) {
                    sceneNode.id = save;
                    mAppearSceneNodeMap.put(str, sceneNode);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void commitEnterScrollNode(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            ScrollNode scrollNode = new ScrollNode();
            scrollNode.cold_start_id = GlobalData.cold_start_id;
            scrollNode.session_id = GlobalData.session_id;
            scrollNode.event_id = "" + UTEventId.SCROLL.getEventId();
            scrollNode.createTime = str;
            scrollNode.user_id = GlobalData.getUserid();
            scrollNode.page = map.get(LogField.PAGE.toString());
            scrollNode.updateBizMap(map);
            long save = scrollNode.save();
            Logger.f(TAG, "commitEnterScrollNode seqId", Long.valueOf(save), "tyoe", scrollNode.getTableName());
            if (save > 0) {
                scrollNode.id = save;
                commitEdgeInPv(scrollNode);
                mAppearScrollNode = scrollNode;
            }
        }
    }

    public static synchronized void commitLeave(Object obj, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitLeave context", obj, "logMap", map);
            commitLeave(obj, map, true);
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void commitLeaveNode(String str, String str2, Map<String, String> map, boolean z) {
        String str3;
        synchronized (UserActionTrack.class) {
            PVNode pVNode = mAppearPVNodeMap.get(str);
            if (pVNode != null) {
                pVNode.updateBizMap(map);
                if (z) {
                    String str4 = map.get(LogField.PAGE.toString());
                    pVNode.page = str4;
                    if (!zf2.f(str4)) {
                        str3 = str + JSMethod.NOT_SET + pVNode.page.hashCode();
                    } else {
                        str3 = str + JSMethod.NOT_SET;
                    }
                    pVNode.pv_key = str3;
                    pVNode.updateTime = str2;
                    pVNode.scene = pVNode.page;
                    pVNode.from_scene = map.get(LogField.ARG1.toString());
                }
                Logger.f(TAG, "update count", Long.valueOf(pVNode.update()));
                if (z) {
                    mAppearPVNodeMap.remove(str);
                    commitPvEdge(pVNode);
                    mLastPvNode = pVNode;
                }
            }
        }
    }

    public static synchronized void commitLeaveScene(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitLeaveScene scene", str, "logMap", map);
            commitLeaveScene(str, map, true);
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void commitLeaveSceneNode(String str, String str2, Map<String, String> map, boolean z) {
        synchronized (UserActionTrack.class) {
            SceneNode sceneNode = mAppearSceneNodeMap.get(str);
            if (sceneNode != null) {
                sceneNode.updateBizMap(map);
                if (z) {
                    sceneNode.updateTime = str2;
                }
                Logger.f(TAG, "update count", Long.valueOf(sceneNode.update()));
                if (z) {
                    mAppearSceneNodeMap.remove(str);
                }
            }
        }
    }

    public static synchronized void commitLog(final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (map != null) {
                final String str = "" + System.currentTimeMillis();
                UTDataStoreHelper.postRunnable(new Runnable() {
                    /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass8 */

                    public void run() {
                        UserActionTrack.commitNode(str, map);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b9  */
    public static synchronized void commitNode(String str, Map<String, String> map) {
        boolean z;
        boolean z2;
        BaseNode baseNode;
        long save;
        synchronized (UserActionTrack.class) {
            String str2 = map.get(LogField.EVENTID.toString());
            if (!zf2.f(str2)) {
                if (!"2001".equals(str2)) {
                    if ("2101".equals(str2)) {
                        baseNode = new TapNode();
                        z2 = true;
                    } else if ("2201".equals(str2) || "2202".equals(str2)) {
                        baseNode = new ExposeNode();
                        z2 = true;
                        z = true;
                        baseNode.cold_start_id = GlobalData.cold_start_id;
                        baseNode.session_id = GlobalData.session_id;
                        baseNode.event_id = str2;
                        baseNode.createTime = str;
                        baseNode.updateTime = str;
                        baseNode.user_id = GlobalData.getUserid();
                        baseNode.page = map.get(LogField.PAGE.toString());
                        baseNode.updateBizMap(map);
                        save = baseNode.save();
                        Logger.f(TAG, "commitNode seqId", Long.valueOf(save), "tyoe", baseNode.getTableName());
                        if (save <= 0) {
                            baseNode.id = save;
                            if (z2) {
                                commitEdgeInPv(baseNode);
                            }
                            if (z) {
                                commitEdgeInScroll(baseNode);
                            }
                            return;
                        }
                        return;
                    } else {
                        baseNode = new OtherNode();
                        z2 = false;
                    }
                    z = false;
                    baseNode.cold_start_id = GlobalData.cold_start_id;
                    baseNode.session_id = GlobalData.session_id;
                    baseNode.event_id = str2;
                    baseNode.createTime = str;
                    baseNode.updateTime = str;
                    baseNode.user_id = GlobalData.getUserid();
                    baseNode.page = map.get(LogField.PAGE.toString());
                    baseNode.updateBizMap(map);
                    save = baseNode.save();
                    Logger.f(TAG, "commitNode seqId", Long.valueOf(save), "tyoe", baseNode.getTableName());
                    if (save <= 0) {
                    }
                } else if ("1".equalsIgnoreCase(map.get("_ish5"))) {
                    commitPvNodeWindVane("2001", str, map);
                }
            }
        }
    }

    private static synchronized void commitPvEdge(PVNode pVNode) {
        synchronized (UserActionTrack.class) {
            commitPvEdgeInPv(pVNode);
            commitPvEdgeInScene(pVNode);
        }
    }

    private static synchronized void commitPvEdgeInPv(PVNode pVNode) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitPvEdgeInPv seqId", Long.valueOf(commitEdge(mLastPvNode, pVNode, true)));
        }
    }

    private static synchronized void commitPvEdgeInScene(PVNode pVNode) {
        synchronized (UserActionTrack.class) {
            Map<String, SceneNode> map = mAppearSceneNodeMap;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, SceneNode> entry : map.entrySet()) {
                    Logger.f(TAG, "commitPvEdgeInScene seqId", Long.valueOf(commitEdge(entry.getValue(), pVNode, true)));
                }
            }
        }
    }

    private static synchronized void commitPvNodeWindVane(String str, String str2, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitPvNodeWindVane");
            PVNode pVNode = new PVNode();
            pVNode.cold_start_id = GlobalData.cold_start_id;
            pVNode.session_id = GlobalData.session_id;
            pVNode.event_id = str;
            pVNode.createTime = str2;
            pVNode.updateTime = str2;
            pVNode.user_id = GlobalData.getUserid();
            pVNode.page = map.get(LogField.PAGE.toString());
            pVNode.updateBizMap(map);
            pVNode.save();
        }
    }

    public static synchronized void commitUpdateProperties(Object obj, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitUpdateProperties context", obj, "logMap", map);
            commitLeave(obj, map, false);
        }
    }

    public static synchronized void commitUpdateSceneProperties(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitUpdateSceneProperties scene", str, "logMap", map);
            commitLeaveScene(str, map, false);
        }
    }

    public static synchronized void updatePvName(Object obj, final String str) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "updatePvName context", obj, "pageName", str);
            if (obj != null) {
                if (!zf2.f(str)) {
                    final String str2 = "" + obj.hashCode();
                    UTDataStoreHelper.postRunnable(new Runnable() {
                        /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass7 */

                        public void run() {
                            Logger.f(UserActionTrack.TAG, "updatePvName contextHashCode", str2);
                            UserActionTrack.updatePvNodeName(str2, str);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void updatePvNodeName(String str, String str2) {
        String str3;
        synchronized (UserActionTrack.class) {
            if (!zf2.f(str2)) {
                str3 = str + JSMethod.NOT_SET + str2.hashCode();
            } else {
                str3 = str;
            }
            PVNode pVNode = mAppearPVNodeMap.get(str);
            if (pVNode != null) {
                pVNode.pv_key = str3;
                pVNode.page = str2;
                pVNode.scene = str2;
                Logger.f(TAG, "updatePvNodeName count", Long.valueOf(pVNode.updatePageName()));
            }
        }
    }

    private static synchronized void commitLeave(Object obj, final Map<String, String> map, final boolean z) {
        synchronized (UserActionTrack.class) {
            if (obj != null && map != null) {
                final String str = "" + obj.hashCode();
                final String str2 = "" + System.currentTimeMillis();
                UTDataStoreHelper.postRunnable(new Runnable() {
                    /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass6 */

                    public void run() {
                        UserActionTrack.commitLeaveNode(str, str2, map, z);
                    }
                });
            }
        }
    }

    private static synchronized void commitLeaveScene(final String str, final Map<String, String> map, final boolean z) {
        synchronized (UserActionTrack.class) {
            if (!TextUtils.isEmpty(str)) {
                final String str2 = "" + System.currentTimeMillis();
                UTDataStoreHelper.postRunnable(new Runnable() {
                    /* class com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.AnonymousClass4 */

                    public void run() {
                        UserActionTrack.commitLeaveSceneNode(str, str2, map, z);
                    }
                });
            }
        }
    }
}
