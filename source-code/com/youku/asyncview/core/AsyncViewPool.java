package com.youku.asyncview.core;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.util.Pools;
import com.youku.asyncview.AsyncViewSetting;
import com.youku.asyncview.IViewCreator;
import com.youku.asyncview.ViewContext;
import com.youku.asyncview.sdk.R;
import com.youku.asyncview.utils.ThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class AsyncViewPool {
    private static final String TAG = "AsyncViewPool";
    private IViewCreator mCustomViewCreator;
    private IViewCreator mDefaultViewCreator;
    private ArrayList<GroupInfo> mGroupList = new ArrayList<>();
    private boolean mIsDebug;
    private int mLayoutId;
    private Object mLock = new Object();
    private int mMaxNum;
    private ArrayList<View> mPool = new ArrayList<>();
    private AsyncViewSetting.AsyncViewPriority mPriority;
    private int mTagId;
    private ViewContext mViewContext;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class GroupInfo {
        private int mCount;
        private String mName;

        private GroupInfo() {
        }

        public int getCount() {
            return this.mCount;
        }

        public String getName() {
            return this.mName;
        }

        public void setCount(int i) {
            this.mCount = i;
        }

        public void setName(String str) {
            this.mName = str;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class InflateRequest {
        int count;
        AsyncViewPool pool;

        InflateRequest() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<InflateRequest> mQueue = new ArrayBlockingQueue<>(100);
        private Pools.SynchronizedPool<InflateRequest> mRequestPool = new Pools.SynchronizedPool<>(100);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.mRequestPool.acquire();
            return acquire == null ? new InflateRequest() : acquire;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.count = 0;
            inflateRequest.pool = null;
            this.mRequestPool.release(inflateRequest);
        }

        public void run() {
            ThreadUtil.forceSetMainLoop();
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            int i;
            try {
                InflateRequest take = this.mQueue.take();
                AsyncViewPool asyncViewPool = take.pool;
                if (asyncViewPool != null && (i = take.count) > 0) {
                    asyncViewPool.init(i);
                }
                releaseRequest(take);
            } catch (InterruptedException e) {
                Log.w(AsyncViewPool.TAG, e);
            }
        }
    }

    AsyncViewPool(ViewContext viewContext, AsyncViewSetting asyncViewSetting, IViewCreator iViewCreator) {
        this.mMaxNum = asyncViewSetting.getCacheSize();
        this.mLayoutId = asyncViewSetting.getLayoutId();
        this.mPriority = asyncViewSetting.getPriority();
        this.mCustomViewCreator = asyncViewSetting.getViewCreater();
        this.mDefaultViewCreator = iViewCreator;
        this.mViewContext = viewContext;
        this.mTagId = R.id.async_pool_view_tag;
    }

    private GroupInfo findGroupInfo(String str) {
        Iterator<GroupInfo> it = this.mGroupList.iterator();
        while (it.hasNext()) {
            GroupInfo next = it.next();
            if (next.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private boolean innerGroupNameCountCut(String str) {
        int count;
        GroupInfo findGroupInfo = findGroupInfo(str);
        if (findGroupInfo == null || (count = findGroupInfo.getCount()) <= 1) {
            return false;
        }
        findGroupInfo.setCount(count - 1);
        return true;
    }

    private int innerGroupTotalCount() {
        Iterator<GroupInfo> it = this.mGroupList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getCount();
        }
        if (this.mIsDebug) {
            Log.w(TAG, "innerGroupTotalCount: count = " + i);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public boolean checkIn(View view) {
        boolean innerGroupNameCountCut;
        if (view == null) {
            return true;
        }
        String str = null;
        Object tag = view.getTag(this.mTagId);
        if (tag instanceof String) {
            str = (String) tag;
        }
        if (this.mIsDebug) {
            Log.w(TAG, "checkIn: groupName = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        synchronized (this.mLock) {
            innerGroupNameCountCut = innerGroupNameCountCut(str);
        }
        if (this.mIsDebug) {
            Log.w(TAG, "checkIn: isFillPool = " + innerGroupNameCountCut);
        }
        if (!innerGroupNameCountCut) {
            return false;
        }
        fillPool(1);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        r0 = create();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        if (r6.mIsDebug == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        android.util.Log.w(com.youku.asyncview.core.AsyncViewPool.TAG, "checkOut: 2 groupName = " + r7 + ",view = " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bc, code lost:
        if (r0 == null) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        r2 = r6.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c0, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r3 = findGroupInfo(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c5, code lost:
        if (r3 != null) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        r3 = new com.youku.asyncview.core.AsyncViewPool.GroupInfo(null);
        r3.setName(r7);
        r6.mGroupList.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00da, code lost:
        if (innerGroupTotalCount() >= r6.mMaxNum) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00dc, code lost:
        r3.setCount(r3.getCount() + 1);
        r0.setTag(r6.mTagId, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ec, code lost:
        if (r6.mIsDebug == false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ee, code lost:
        android.util.Log.w(com.youku.asyncview.core.AsyncViewPool.TAG, "checkOut: 2 group size = " + r6.mGroupList.size());
        innerGroupTotalCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010d, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0112, code lost:
        return r0;
     */
    public View checkOut(String str) {
        View view;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            if (this.mPool.size() > 0) {
                ArrayList<View> arrayList = this.mPool;
                view = arrayList.remove(arrayList.size() - 1);
            } else {
                view = null;
            }
            if (this.mIsDebug) {
                Log.w(TAG, "checkOut: 1 groupName = " + str + ",view = " + view);
            }
            if (view != null) {
                view.setTag(this.mTagId, str);
                GroupInfo findGroupInfo = findGroupInfo(str);
                if (findGroupInfo == null) {
                    findGroupInfo = new GroupInfo();
                    findGroupInfo.setName(str);
                    this.mGroupList.add(findGroupInfo);
                }
                if (innerGroupTotalCount() < this.mMaxNum) {
                    findGroupInfo.setCount(findGroupInfo.getCount() + 1);
                }
                if (this.mIsDebug) {
                    Log.w(TAG, "checkOut: 1 group size = " + this.mGroupList.size());
                    innerGroupTotalCount();
                }
                return view;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        synchronized (this.mLock) {
            this.mPool.clear();
            this.mGroupList.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r0.createView(r4.mViewContext, r4.mLayoutId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        return r4.mDefaultViewCreator.createView(r4.mViewContext, r4.mLayoutId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r0 = r4.mCustomViewCreator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 == null) goto L_0x001f;
     */
    public View create() {
        synchronized (this.mLock) {
            if (this.mPool.size() > this.mMaxNum) {
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void fillPool(int i) {
        InflateRequest obtainRequest = InflateThread.getInstance().obtainRequest();
        obtainRequest.pool = this;
        obtainRequest.count = i;
        if (this.mIsDebug) {
            Log.w(TAG, "fillPool: count = " + obtainRequest.count + ",mMaxNum = " + this.mMaxNum);
        }
        InflateThread.getInstance().enqueue(obtainRequest);
    }

    public AsyncViewSetting.AsyncViewPriority getPriority() {
        return this.mPriority;
    }

    public void init(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i2 = 0; i2 < i; i2++) {
            View create = create();
            if (create != null) {
                synchronized (this.mLock) {
                    this.mPool.add(create);
                }
            }
        }
        if (this.mIsDebug) {
            Log.w(TAG, "init: time = " + (System.currentTimeMillis() - currentTimeMillis));
            synchronized (this.mLock) {
                Log.w(TAG, "init: pool size = " + this.mPool.size());
                ArrayList<GroupInfo> arrayList = this.mGroupList;
                if (arrayList.size() > 0) {
                    Iterator<GroupInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupInfo next = it.next();
                        Log.w(TAG, "init: info name = " + next.getName() + ",count = " + next.getCount());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        int i;
        synchronized (this.mLock) {
            Iterator<GroupInfo> it = this.mGroupList.iterator();
            i = 0;
            while (it.hasNext()) {
                i += it.next().getCount();
            }
        }
        if (i > 0) {
            fillPool(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void resetGroup(String str) {
        int i;
        synchronized (this.mLock) {
            GroupInfo findGroupInfo = findGroupInfo(str);
            i = 0;
            if (findGroupInfo != null) {
                int count = findGroupInfo.getCount();
                findGroupInfo.setCount(0);
                i = count;
            }
        }
        if (i > 0) {
            fillPool(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDebug(boolean z) {
        this.mIsDebug = z;
        if (z) {
            Log.w(TAG, "setDebug: mTagId = " + this.mTagId);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxNum(int i) {
        synchronized (this.mLock) {
            ArrayList<View> arrayList = this.mPool;
            if (arrayList.size() > i) {
                int size = arrayList.size() - i;
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            int innerGroupTotalCount = innerGroupTotalCount();
            if (innerGroupTotalCount > i) {
                int i3 = innerGroupTotalCount - i;
                Iterator<GroupInfo> it = this.mGroupList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GroupInfo next = it.next();
                    if (i3 - next.getCount() <= 0) {
                        next.setCount(next.getCount() - i3);
                        break;
                    } else {
                        i3 -= next.getCount();
                        next.setCount(0);
                    }
                }
            }
            if (this.mIsDebug) {
                Log.w(TAG, "init: pool size = " + this.mPool.size() + ",maxNum = " + i);
                ArrayList<GroupInfo> arrayList2 = this.mGroupList;
                if (arrayList2.size() > 0) {
                    Iterator<GroupInfo> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        GroupInfo next2 = it2.next();
                        Log.w(TAG, "init: info name = " + next2.getName() + ",count = " + next2.getCount());
                    }
                }
            }
        }
        this.mMaxNum = i;
    }

    public void setPriority(AsyncViewSetting.AsyncViewPriority asyncViewPriority) {
        this.mPriority = asyncViewPriority;
    }

    public void setViewCreator(IViewCreator iViewCreator) {
        this.mCustomViewCreator = iViewCreator;
    }
}
