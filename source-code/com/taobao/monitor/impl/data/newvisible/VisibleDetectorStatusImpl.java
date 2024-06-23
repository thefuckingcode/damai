package com.taobao.monitor.impl.data.newvisible;

import android.taobao.windvane.connect.HttpRequest;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.taobao.monitor.impl.data.newvisible.IVisibleDetector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.dm2;
import tb.gw2;
import tb.hz2;
import tb.jl1;
import tb.k50;
import tb.nw2;
import tb.qs0;
import tb.t91;

/* compiled from: Taobao */
public class VisibleDetectorStatusImpl implements IVisibleDetector, Runnable {
    private static final List<a> BLACK_VIEW_INFO_LIST;
    private static final long CONTINUOUS_OBSERVER_DURATION = 5000;
    private static final long INTERVAL = 75;
    private static final String TAG = "VisibleDetectorStatusImpl";
    private static final int WEEX_VISIBLE_KEY = -307;
    private IVisibleDetector.IDetectorCallback callback;
    private final WeakReference<View> containRef;
    private long lastChangedTime = dm2.a();
    private String lastChangedView = "";
    private Set<String> moveViewCacheSet = new HashSet();
    private Map<String, Integer> oldViews = new HashMap();
    private final String pageName;
    final a pagePercentCalculate;
    private boolean stopImmediately = false;
    private volatile boolean stopped = false;
    private Map<String, String> typeKeyStatusMap = new HashMap();
    private Set<String> typeLocationStatusSet = new HashSet();
    private int validElementCount = 0;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private String a;
        private int b;
        private String c;

        public a(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        BLACK_VIEW_INFO_LIST = arrayList;
        arrayList.add(new a("TBMainActivity", id("uik_refresh_header_second_floor"), jl1.MUL));
        arrayList.add(new a("MainActivity3", id("uik_refresh_header_second_floor"), jl1.MUL));
        arrayList.add(new a(jl1.MUL, id("mytaobao_carousel"), "RecyclerView"));
        arrayList.add(new a(jl1.MUL, -1, "HLoopView"));
        arrayList.add(new a(jl1.MUL, -1, "HGifView"));
        arrayList.add(new a("TBLiveVideoActivity", id("recyclerview"), "AliLiveRecyclerView"));
    }

    public VisibleDetectorStatusImpl(View view, String str, float f) {
        try {
            View findViewById = view.findViewById(view.getResources().getIdentifier("content", "id", "android"));
            if (findViewById != null) {
                view = findViewById;
            }
        } catch (Exception unused) {
        }
        this.containRef = new WeakReference<>(view);
        this.pageName = str;
        this.pagePercentCalculate = new a(f);
        t91.a(TAG, str);
    }

    private void calculateStatus(View view, View view2) {
        View[] c;
        if (isValidView(view)) {
            boolean z = !inBlackList(view);
            if (view instanceof WebView) {
                int webViewProgress = k50.INSTANCE.webViewProgress(view);
                if (webViewProgress != 100) {
                    this.lastChangedTime = dm2.a();
                } else {
                    this.stopImmediately = true;
                }
                this.validElementCount = webViewProgress;
                this.lastChangedView = "progress";
                return;
            }
            hz2 hz2 = hz2.INSTANCE;
            if (hz2.isWebView(view)) {
                int webViewProgress2 = hz2.webViewProgress(view);
                if (webViewProgress2 != 100) {
                    this.lastChangedTime = dm2.a();
                } else {
                    this.stopImmediately = true;
                }
                this.validElementCount = webViewProgress2;
                this.lastChangedView = "progress";
            } else if (!(view instanceof EditText) || !view.hasFocus()) {
                boolean z2 = view instanceof TextView;
                if (z2) {
                    this.validElementCount++;
                } else if (view instanceof ImageView) {
                    if (((ImageView) view).getDrawable() != null) {
                        this.validElementCount++;
                    }
                } else if (view.getBackground() != null) {
                    this.validElementCount++;
                }
                if (z2) {
                    doValidViewAction(view, view2);
                } else if ((view instanceof ImageView) && ((ImageView) view).getDrawable() != null) {
                    doValidViewAction(view, view2);
                }
                if ((view instanceof ViewGroup) && z && (c = nw2.c((ViewGroup) view)) != null) {
                    for (View view3 : c) {
                        if (view3 != null) {
                            calculateStatus(view3, view2);
                        } else {
                            return;
                        }
                    }
                }
            } else {
                this.stopImmediately = true;
            }
        }
    }

    private void check() {
        IVisibleDetector.IDetectorCallback iDetectorCallback;
        View view = this.containRef.get();
        long j = this.lastChangedTime;
        this.validElementCount = 0;
        if (view == null) {
            stop();
            return;
        }
        try {
            if (view.getHeight() * view.getWidth() != 0) {
                this.pagePercentCalculate.b();
                calculateStatus(view, view);
                if (j != this.lastChangedTime) {
                    this.pagePercentCalculate.a();
                }
                if ((j != this.lastChangedTime || this.stopImmediately) && (iDetectorCallback = this.callback) != null) {
                    iDetectorCallback.onChanged(j);
                    this.callback.onValidElementChanged(this.validElementCount);
                    this.callback.onLastChangedView(this.lastChangedView);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void doValidViewAction(View view, View view2) {
        this.pagePercentCalculate.c(view);
        String e = gw2.e(view);
        String b = gw2.b(view2, view);
        String d = gw2.d(view);
        String a2 = gw2.a(view);
        String str = e + b + d;
        String str2 = e + a2 + d;
        String str3 = e + a2;
        String c = gw2.c(view2, view);
        Integer num = 1;
        if (nw2.d(view, view2) && !this.typeKeyStatusMap.containsKey(str2)) {
            if (this.oldViews.containsKey(str3)) {
                if (!this.typeKeyStatusMap.containsKey(str2)) {
                    this.lastChangedTime = dm2.a();
                    this.lastChangedView = c + " " + str;
                    t91.a(TAG, c, str);
                }
            } else if (!this.moveViewCacheSet.contains(c) && !this.typeLocationStatusSet.contains(str)) {
                this.lastChangedTime = dm2.a();
                this.lastChangedView = c + " " + str;
                t91.a(TAG, c, str);
            }
        }
        Integer num2 = this.oldViews.get(str3);
        if (num2 == null) {
            this.oldViews.put(str3, num);
        } else {
            num = num2;
        }
        String str4 = this.typeKeyStatusMap.get(str2);
        if (!b.equals(str4) && !TextUtils.isEmpty(str4)) {
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            this.oldViews.put(str3, valueOf);
            if (valueOf.intValue() > 2) {
                this.moveViewCacheSet.add(c);
            }
        }
        this.typeKeyStatusMap.put(str2, b);
        this.typeLocationStatusSet.add(str);
    }

    private static int id(String str) {
        try {
            return qs0.e().a().getResources().getIdentifier(str, "id", qs0.e().a().getPackageName());
        } catch (Exception unused) {
            return -1;
        }
    }

    private boolean inBlackList(View view) {
        for (a aVar : BLACK_VIEW_INFO_LIST) {
            if ((aVar.a.equals(jl1.MUL) || this.pageName.endsWith(aVar.a)) && ((view.getId() == aVar.b || aVar.b == -1) && (aVar.c.equals(jl1.MUL) || aVar.c.equals(view.getClass().getSimpleName())))) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidView(View view) {
        if (HttpRequest.DEFAULT_HTTPS_ERROR_INVALID.equals(view.getTag(WEEX_VISIBLE_KEY)) || view.getVisibility() != 0 || (view instanceof ViewStub)) {
            return false;
        }
        if ((view instanceof EditText) && view.hasFocus()) {
            return true;
        }
        if (view.getHeight() < nw2.screenHeight / 25) {
            return false;
        }
        if ((view instanceof TextView) || (view instanceof ImageView) || (view instanceof ViewGroup)) {
            return true;
        }
        return false;
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void execute() {
        if (this.containRef.get() == null) {
            stop();
            return;
        }
        long a2 = dm2.a();
        this.lastChangedTime = a2;
        IVisibleDetector.IDetectorCallback iDetectorCallback = this.callback;
        if (iDetectorCallback != null) {
            iDetectorCallback.onChanged(a2);
        }
        qs0.e().b().postDelayed(this, 75);
    }

    public long getLastChangedTime() {
        return this.lastChangedTime;
    }

    public void run() {
        long a2 = dm2.a();
        if (this.stopped) {
            return;
        }
        if (a2 - this.lastChangedTime > 5000 || this.stopImmediately) {
            visibleEndByType("NORMAL");
            stop();
            return;
        }
        check();
        qs0.e().b().postDelayed(this, 75);
    }

    public void setCallback(IVisibleDetector.IDetectorCallback iDetectorCallback) {
        this.callback = iDetectorCallback;
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void stop() {
        if (!this.stopped) {
            this.stopped = true;
            qs0.e().b().removeCallbacks(this);
            IVisibleDetector.IDetectorCallback iDetectorCallback = this.callback;
            if (iDetectorCallback != null) {
                iDetectorCallback.onCompleted(this.pagePercentCalculate.d(this.lastChangedTime));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void visibleEndByType(String str) {
        if (!this.stopped) {
            stop();
        }
    }
}
