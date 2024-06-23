package com.ut.mini.exposure;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSONArray;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.internal.ExposureViewHandle;
import com.ut.mini.internal.ExposureViewTag;
import com.ut.mini.internal.IExposureViewHandleExt;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import com.youku.vpm.track.OnePlayTrack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import tb.ib1;

/* compiled from: Taobao */
public class TrackerFrameLayout extends FrameLayout implements GestureDetector.OnGestureListener {
    private static final float CLICK_LIMIT = 20.0f;
    private static final Object HasExposrueObjectLock = new Object();
    private static final String TAG = "TrackerFrameLayout";
    public static long TIME_INTERVAL = 100;
    public static final int TRIGGER_VIEW_CHANGED = 0;
    public static final int TRIGGER_VIEW_STATUS_CHANGED = 3;
    public static final int TRIGGER_WINDOW_CHANGED = 1;
    private static final int UT_EXPORSURE_MAX_LENGTH = 25600;
    private static final String UT_SCM_TAG = "scm";
    private static final String UT_SPM_TAG = "spm";
    private static final int eventId = 2201;
    private static HashMap<String, Object> mCommonInfo = new HashMap<>();
    private static HashMap<String, Integer> mHasExposrueDataLength = new HashMap<>();
    private static Map<String, ArrayList> mHasExposrueMap = Collections.synchronizedMap(new HashMap());
    private static HashMap<String, HashSet<String>> mHasExposureSet = new HashMap<>();
    private static List<String> mImmediatelyCommitBlockList = new Vector();
    private Map<String, ExposureView> currentViews = new ConcurrentHashMap();
    private long lastDispatchDrawSystemTimeMillis = 0;
    private Rect mGlobalVisibleRect = new Rect();
    private float mOriX = 0.0f;
    private float mOriY = 0.0f;
    private Runnable traceTask = new Runnable() {
        /* class com.ut.mini.exposure.TrackerFrameLayout.AnonymousClass1 */

        public void run() {
            Logger.f(TrackerFrameLayout.TAG, "=====traceTask=====");
            TrackerFrameLayout.this.trace(0, true);
        }
    };
    private long traverseTime;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class ExposureEntity implements Serializable {
        public double area;
        public long duration = 0;
        public Map<String, String> exargs;
        public String scm;
        public String spm;
        public String viewid;

        public ExposureEntity(String str, String str2, Map map, long j, double d, String str3) {
            this.spm = str;
            this.scm = str2;
            this.exargs = map;
            this.duration = j;
            this.area = d;
            this.viewid = str3;
        }

        public int length() {
            String str = this.spm;
            int i = 0;
            if (str != null) {
                i = 0 + str.length() + 8;
            }
            String str2 = this.scm;
            if (str2 != null) {
                i += str2.length() + 8;
            }
            Map<String, String> map = this.exargs;
            if (map != null) {
                for (String str3 : map.keySet()) {
                    if (str3 != null) {
                        i += str3.length();
                    }
                    String str4 = this.exargs.get(str3);
                    if (str4 != null) {
                        i += str4.toString().length();
                    }
                    i += 5;
                }
            }
            String str5 = this.viewid;
            if (str5 != null) {
                i += str5.length() + 11;
            }
            return i + 50;
        }
    }

    /* compiled from: Taobao */
    static class PageChangerMonitor implements UTPageHitHelper.PageChangeListener {
        PageChangerMonitor() {
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageAppear(Object obj) {
            if (obj instanceof Activity) {
                View view = null;
                try {
                    view = ((Activity) obj).findViewById(16908290);
                } catch (Exception e) {
                    ExpLogger.e(TrackerFrameLayout.TAG, e, new Object[0]);
                }
                if (view instanceof ViewGroup) {
                    View childAt = ((ViewGroup) view).getChildAt(0);
                    if (childAt instanceof TrackerFrameLayout) {
                        ((TrackerFrameLayout) childAt).trace(1, true);
                        return;
                    }
                    ExpLogger.w(TrackerFrameLayout.TAG, "cannot found the trace view", childAt);
                    return;
                }
                ExpLogger.w(TrackerFrameLayout.TAG, "contentView", view);
            }
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageDisAppear(Object obj) {
            if (obj instanceof Activity) {
                View view = null;
                try {
                    view = ((Activity) obj).findViewById(16908290);
                } catch (Exception e) {
                    ExpLogger.e(TrackerFrameLayout.TAG, e, new Object[0]);
                }
                if (view instanceof ViewGroup) {
                    View childAt = ((ViewGroup) view).getChildAt(0);
                    if (childAt instanceof TrackerFrameLayout) {
                        ((TrackerFrameLayout) childAt).onPageDisAppear();
                        return;
                    }
                    ExpLogger.w(TrackerFrameLayout.TAG, "cannot found the trace view ", childAt);
                    return;
                }
                ExpLogger.w(TrackerFrameLayout.TAG, "contentView", view);
            }
        }
    }

    static {
        UTPageHitHelper.addPageChangerListener(new PageChangerMonitor());
    }

    public TrackerFrameLayout(Context context) {
        super(context);
        addCommonArgsInfo();
        ExposureConfigMgr.updateExposureConfig();
    }

    @TargetApi(4)
    private void addCommonArgsInfo() {
        if (getContext() != null && (getContext() instanceof Activity)) {
            View decorView = ((Activity) getContext()).getWindow().getDecorView();
            mCommonInfo.clear();
            HashMap<String, String> hashMap = TrackerManager.getInstance().commonInfoMap;
            if (hashMap != null) {
                mCommonInfo.putAll(hashMap);
            }
            HashMap hashMap2 = (HashMap) decorView.getTag(ExposureUtils.ut_exprosure_common_info_tag);
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                mCommonInfo.putAll(hashMap2);
                ExpLogger.d(TAG, "addCommonArgsInfo mCommonInfo ", hashMap2);
            }
            ExpLogger.d(TAG, "addCommonArgsInfo all mCommonInfo ", hashMap2);
        }
    }

    private void addToCommit(ExposureView exposureView) {
        Map map;
        String str = exposureView.block;
        String str2 = exposureView.tag;
        if (isExposured(str, str2)) {
            ExpLogger.d(TAG, "isExposured block", str, "viewId", str2);
            return;
        }
        setExposuredTag(str, str2);
        Map<String, Object> map2 = exposureView.viewData;
        HashMap hashMap = new HashMap();
        ExposureViewHandle exposureViewHandle = TrackerManager.getInstance().getExposureViewHandle();
        String[] strArr = null;
        if (exposureViewHandle != null) {
            Context context = exposureView.view.getContext();
            Map<String, String> exposureViewProperties = exposureViewHandle.getExposureViewProperties(context != null ? UTPageHitHelper.getInstance().getPageUrl(context) : null, exposureView.view);
            if (exposureViewProperties != null) {
                hashMap.putAll(exposureViewProperties);
            }
        }
        if (!(map2 == null || map2.get("UT_EXPROSURE_ARGS") == null || (map = (Map) map2.get("UT_EXPROSURE_ARGS")) == null || map.size() <= 0)) {
            hashMap.putAll(map);
        }
        String str3 = (String) hashMap.remove("spm");
        String str4 = (String) hashMap.remove("scm");
        synchronized (HasExposrueObjectLock) {
            ArrayList arrayList = mHasExposrueMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                mHasExposrueMap.put(str, arrayList);
                View view = exposureView.view;
                if (view != null) {
                    Object tag = view.getTag(ExposureUtils.ut_exposure_data_spm);
                    if (tag instanceof Map) {
                        String str5 = (String) ((Map) tag).get("x-spm-c");
                        String str6 = (String) ((Map) tag).get("x-spm-d");
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                            Object rootViewTag = getRootViewTag(view, ExposureUtils.ut_exposure_root_spm);
                            if (rootViewTag instanceof Map) {
                                String str7 = (String) ((Map) rootViewTag).get("x-spm-a");
                                String str8 = (String) ((Map) rootViewTag).get("x-spm-b");
                                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                                    str3 = str7 + "." + str8 + "." + str5 + "." + str6;
                                }
                            }
                        }
                    }
                }
            } else {
                View view2 = exposureView.view;
                if (view2 != null) {
                    Object tag2 = view2.getTag(ExposureUtils.ut_exposure_data_spm);
                    if (tag2 instanceof Map) {
                        String str9 = (String) ((Map) tag2).get("x-spm-c");
                        String str10 = (String) ((Map) tag2).get("x-spm-d");
                        if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(str10)) {
                            String str11 = ((ExposureEntity) arrayList.get(0)).spm;
                            if (!TextUtils.isEmpty(str11)) {
                                strArr = str11.split("\\.");
                            }
                            if (strArr != null && strArr.length == 4) {
                                str3 = strArr[0] + "." + strArr[1] + "." + str9 + "." + str10;
                            }
                        }
                    }
                }
            }
            ExposureEntity exposureEntity = new ExposureEntity(str3, str4, hashMap, System.currentTimeMillis() - exposureView.beginTime, exposureView.area, str2);
            arrayList.add(exposureEntity);
            Integer num = mHasExposrueDataLength.get(str);
            if (num == null) {
                num = 0;
            }
            Integer valueOf = Integer.valueOf(num.intValue() + exposureEntity.length());
            mHasExposrueDataLength.put(str, valueOf);
            if (valueOf.intValue() > UT_EXPORSURE_MAX_LENGTH) {
                commitToUT(str, mCommonInfo);
            } else if (mImmediatelyCommitBlockList.contains(str)) {
                commitToUT(str, mCommonInfo);
            }
        }
        UTTrackerListenerMgr.getInstance().addExposureViewToCommit(str, str2, str3, str4, hashMap);
        ExpLogger.d(TAG, "提交元素viewId ", str2, "block", str, "spm", str3, "scm", str4, "args", hashMap);
    }

    private void checkViewState(int i, ExposureView exposureView) {
        if (exposureView != null) {
            if (isVisableToUser(exposureView.view)) {
                int i2 = exposureView.lastState;
                if (i2 == 0) {
                    exposureView.lastState = 1;
                    exposureView.beginTime = System.currentTimeMillis();
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        exposureView.lastState = 1;
                        exposureView.beginTime = System.currentTimeMillis();
                    }
                } else if (i == 1 || i == 3) {
                    exposureView.lastState = 2;
                    exposureView.endTime = System.currentTimeMillis();
                }
            } else if (exposureView.lastState == 1) {
                exposureView.lastState = 2;
                exposureView.endTime = System.currentTimeMillis();
            }
            if (exposureView.isSatisfyTimeRequired()) {
                addToCommit(exposureView);
                this.currentViews.remove(String.valueOf(exposureView.view.hashCode()));
            } else if (exposureView.lastState == 2) {
                this.currentViews.remove(String.valueOf(exposureView.view.hashCode()));
                ExpLogger.d(TAG, "时间不满足，元素", exposureView.tag);
            }
        }
    }

    private void checkViewsStates(int i) {
        Map<String, ExposureView> map = this.currentViews;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, ExposureView> entry : this.currentViews.entrySet()) {
                checkViewState(i, this.currentViews.get(String.valueOf(entry.getValue().view.hashCode())));
            }
        }
    }

    public static void commitExposureData() {
        Object[] objArr;
        synchronized (HasExposrueObjectLock) {
            try {
                objArr = mHasExposrueMap.keySet().toArray();
            } catch (Throwable unused) {
                objArr = null;
            }
            if (objArr != null) {
                if (objArr.length > 0) {
                    for (int i = 0; i < objArr.length; i++) {
                        commitToUT(objArr[i] + "", mCommonInfo);
                    }
                }
            }
            mHasExposrueMap.clear();
        }
    }

    private static void commitToUT(String str, HashMap<String, Object> hashMap) {
        Map<String, String> a;
        ExpLogger.d();
        ArrayList remove = mHasExposrueMap.remove(str);
        HashMap hashMap2 = new HashMap();
        if (!(hashMap == null || hashMap.size() <= 0 || (a = ib1.a(hashMap)) == null)) {
            hashMap2.putAll(a);
        }
        hashMap2.put("expdata", getExpData(remove));
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(UTPageHitHelper.getInstance().getCurrentPageName(), 2201, str, null, null, hashMap2).build());
        mHasExposrueDataLength.remove(str);
    }

    private static String getExpData(ArrayList<ExposureEntity> arrayList) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.addAll(arrayList);
        return jSONArray.toJSONString();
    }

    private static Object getRootViewTag(View view, int i) {
        while (view != null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
            if (view != null && view.getTag(i) != null) {
                return view.getTag(i);
            }
        }
        return null;
    }

    private boolean isExposured(String str, String str2) {
        HashSet<String> hashSet = mHasExposureSet.get(str);
        if (hashSet == null) {
            return false;
        }
        return hashSet.contains(str2);
    }

    private boolean isVisableToUser(View view) {
        return viewSize(view) >= ExposureConfigMgr.dimThreshold;
    }

    public static void refreshExposureData() {
        mHasExposureSet.clear();
    }

    public static void refreshExposureDataByViewId(String str, String str2) {
        HashSet<String> hashSet;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (hashSet = mHasExposureSet.get(str)) != null) {
            hashSet.remove(str2);
        }
    }

    public static void setCommitImmediatelyExposureBlock(String str) {
        mImmediatelyCommitBlockList.add(str);
    }

    private void setExposuredTag(String str, String str2) {
        HashSet<String> hashSet = mHasExposureSet.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            mHasExposureSet.put(str, hashSet);
        }
        hashSet.add(str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void trace(int i, boolean z) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (z || currentTimeMillis - this.traverseTime >= TIME_INTERVAL) {
                ExpLogger.d(TAG, "扫描开始");
                this.traverseTime = currentTimeMillis;
                traverseViewTree(this);
                checkViewsStates(i);
                if (ExpLogger.enableLog) {
                    ExpLogger.d(TAG, "扫描结束，耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            } else if (ExpLogger.enableLog) {
                ExpLogger.d(TAG, "triggerTime interval is too close to " + TIME_INTERVAL + "ms");
            }
        } catch (Throwable th) {
            ExpLogger.e(TAG, th, new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c9  */
    @TargetApi(4)
    private void traverseViewTree(View view) {
        String str;
        String str2;
        ExposureView exposureView;
        String str3;
        if (view != null) {
            int i = 0;
            if (!view.isShown()) {
                ExpLogger.d(TAG, "view invisalbe,return");
            } else if (ExposureUtils.isIngoneExposureView(view)) {
                ExpLogger.d(TAG, "view ingone by user,return. view:", view);
            } else {
                Map<String, Object> map = null;
                if (ExposureUtils.isExposureViewForWeex(view)) {
                    Context context = view.getContext();
                    ExposureViewHandle exposureViewHandle = TrackerManager.getInstance().getExposureViewHandle();
                    if (exposureViewHandle != null) {
                        if (context == null || !(context instanceof Activity)) {
                            str3 = null;
                        } else {
                            str3 = UTPageHitHelper.getInstance().getPageUrl(context);
                            if (TextUtils.isEmpty(str3)) {
                                ExpLogger.w(TAG, "Cannot get Current Page Url", context);
                            }
                        }
                        ExposureViewTag exposureViewTag = exposureViewHandle.getExposureViewTag(str3, view);
                        if (exposureViewTag != null) {
                            if (TextUtils.isEmpty(exposureViewTag.block) || TextUtils.isEmpty(exposureViewTag.viewId)) {
                                if (exposureViewTag.notExposure) {
                                    ExposureUtils.clearExposureForWeex(view);
                                    ExpLogger.w(TAG, "clear exposure tag. view", view);
                                }
                                ExpLogger.w(TAG, "block or viewId is valid,plase check input params!");
                            } else {
                                str = exposureViewTag.block;
                                str2 = exposureViewTag.viewId;
                                ExpLogger.d(TAG, "weex block", str, "viewId", str2);
                                if (ExposureUtils.isExposureView(view)) {
                                    Object tag = view.getTag(ExposureUtils.ut_exprosure_tag);
                                    if (tag != null && (tag instanceof Map)) {
                                        map = (Map) tag;
                                        String str4 = (String) map.get("UT_EXPROSURE_VIEWID");
                                        str = (String) map.get("UT_EXPROSURE_BLOCK");
                                        str2 = str4;
                                    }
                                    ExpLogger.d(TAG, "native block", str, "viewId", str2);
                                }
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                    exposureView = this.currentViews.get(String.valueOf(view.hashCode()));
                                    if (exposureView == null) {
                                        for (ExposureView exposureView2 : this.currentViews.values()) {
                                            if (str2.equalsIgnoreCase(exposureView2.tag)) {
                                                ExpLogger.d(TAG, "this viewId has existed current view:", view, "oldView:", exposureView2.view, "viewId", str2);
                                                return;
                                            }
                                        }
                                    } else if (!str2.equalsIgnoreCase(exposureView.tag) || exposureView.isSatisfyTimeRequired()) {
                                        ExpLogger.d(TAG, "this view status has change or time > timeThreshold, block", str, " new viewId", str2, "old viewId", exposureView.tag);
                                        checkViewState(3, exposureView);
                                    } else {
                                        ExpLogger.d(TAG, "this view has existed block", str, "viewId", str2);
                                        return;
                                    }
                                    if (isExposured(str, str2)) {
                                        ExpLogger.d(TAG, "this view has exposured block", str, "viewId", str2);
                                        if (ExposureUtils.isViewGroupExposureView(view)) {
                                            ExpLogger.d(TAG, "this view is ViewGroupExposureView", str, "viewId", str2);
                                            if (view instanceof ViewGroup) {
                                                ViewGroup viewGroup = (ViewGroup) view;
                                                int childCount = viewGroup.getChildCount();
                                                while (i < childCount) {
                                                    traverseViewTree(viewGroup.getChildAt(i));
                                                    i++;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
                                    if (!TextUtils.isEmpty(currentPageName)) {
                                        UTTrackerListenerMgr.getInstance().viewBecomeVisible(currentPageName, str, str2);
                                    }
                                    double viewSize = viewSize(view);
                                    if (viewSize >= ExposureConfigMgr.dimThreshold) {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        ExposureView exposureView3 = new ExposureView(view);
                                        exposureView3.beginTime = currentTimeMillis;
                                        exposureView3.tag = str2;
                                        exposureView3.block = str;
                                        exposureView3.viewData = map;
                                        exposureView3.lastCalTime = currentTimeMillis;
                                        exposureView3.area = viewSize;
                                        this.currentViews.put(String.valueOf(view.hashCode()), exposureView3);
                                        ExpLogger.d(TAG, "找到元素", str2);
                                    } else {
                                        ExpLogger.d(TAG, "找到元素,但不满足曝光条件", str2);
                                    }
                                }
                                if (view instanceof ViewGroup) {
                                    ViewGroup viewGroup2 = (ViewGroup) view;
                                    int childCount2 = viewGroup2.getChildCount();
                                    while (i < childCount2) {
                                        traverseViewTree(viewGroup2.getChildAt(i));
                                        i++;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        str2 = null;
                        str = null;
                        ExpLogger.d(TAG, "weex block", str, "viewId", str2);
                        if (ExposureUtils.isExposureView(view)) {
                        }
                        exposureView = this.currentViews.get(String.valueOf(view.hashCode()));
                        if (exposureView == null) {
                        }
                        if (isExposured(str, str2)) {
                        }
                    }
                }
                str2 = null;
                str = null;
                if (ExposureUtils.isExposureView(view)) {
                }
                exposureView = this.currentViews.get(String.valueOf(view.hashCode()));
                if (exposureView == null) {
                }
                if (isExposured(str, str2)) {
                }
            }
        }
    }

    private double viewSize(View view) {
        int width = view.getWidth() * view.getHeight();
        if (!view.getGlobalVisibleRect(this.mGlobalVisibleRect) || width <= 0) {
            return 0.0d;
        }
        return (((double) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mGlobalVisibleRect) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mGlobalVisibleRect))) * 1.0d) / ((double) width);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        ExpLogger.d(TAG, "dispatchDraw");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastDispatchDrawSystemTimeMillis > 1000) {
            this.lastDispatchDrawSystemTimeMillis = currentTimeMillis;
            addCommonArgsInfo();
        }
        super.dispatchDraw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "action:", Integer.valueOf(motionEvent.getAction()));
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mOriX = motionEvent.getX();
            this.mOriY = motionEvent.getY();
        } else if (action == 1) {
            Handler threadHandle = TrackerManager.getInstance().getThreadHandle();
            if (threadHandle != null) {
                threadHandle.removeCallbacks(this.traceTask);
                threadHandle.postDelayed(this.traceTask, 1000);
            }
        } else if (action == 2) {
            if (Math.abs(motionEvent.getX() - this.mOriX) > 20.0f || Math.abs(motionEvent.getY() - this.mOriY) > 20.0f) {
                long currentTimeMillis = System.currentTimeMillis();
                ExpLogger.d(TAG, " begin");
                trace(0, false);
                if (ExpLogger.enableLog) {
                    ExpLogger.d(TAG, "end costTime=" + (System.currentTimeMillis() - currentTimeMillis) + "--" + StringUtils.LF);
                }
            } else {
                ExpLogger.d(TAG, "onInterceptTouchEvent ACTION_MOVE but not in click limit");
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchVisibilityChanged(View view, int i) {
        if (i == 8) {
            ExpLogger.d(TAG, OnePlayTrack.PlayType.BEGIN);
            long currentTimeMillis = System.currentTimeMillis();
            trace(1, false);
            if (ExpLogger.enableLog) {
                ExpLogger.d(TAG, "end costTime=" + (System.currentTimeMillis() - currentTimeMillis) + "--");
            }
        } else {
            ExpLogger.d(TAG, "visibility", Integer.valueOf(i));
        }
        super.dispatchVisibilityChanged(view, i);
    }

    public void dispatchWindowFocusChanged(boolean z) {
        ExpLogger.d(TAG, OnePlayTrack.PlayType.BEGIN);
        long currentTimeMillis = System.currentTimeMillis();
        trace(1, false);
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "end" + (System.currentTimeMillis() - currentTimeMillis) + "--");
        }
        super.dispatchWindowFocusChanged(z);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ExpLogger.d(TAG, OnePlayTrack.PlayType.BEGIN);
        long currentTimeMillis = System.currentTimeMillis();
        trace(0, false);
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "end costTime=" + (System.currentTimeMillis() - currentTimeMillis) + "--");
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onPageDisAppear() {
        Handler threadHandle = TrackerManager.getInstance().getThreadHandle();
        if (threadHandle != null) {
            threadHandle.removeCallbacks(this.traceTask);
        }
        trace(1, true);
        commitExposureData();
        mImmediatelyCommitBlockList.clear();
        this.currentViews.clear();
        if (!ExposureConfigMgr.notClearTagAfterDisAppear) {
            mHasExposureSet.clear();
        }
        ExposureViewHandle exposureViewHandle = TrackerManager.getInstance().getExposureViewHandle();
        if (exposureViewHandle instanceof IExposureViewHandleExt) {
            ((IExposureViewHandleExt) exposureViewHandle).onExposureDataCleared();
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (ExpLogger.enableLog) {
            ExpLogger.d(TAG, "action:", Integer.valueOf(motionEvent.getAction()));
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static void refreshExposureData(String str) {
        ExpLogger.d(TAG, "[refreshExposureData]block", str);
        if (!TextUtils.isEmpty(str)) {
            mHasExposureSet.remove(str);
        }
    }
}
