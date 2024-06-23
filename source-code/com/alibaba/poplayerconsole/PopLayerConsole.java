package com.alibaba.poplayerconsole;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.utils.ConsoleLogger$Level;
import com.alibaba.poplayerconsole.LogCache;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.poplayerconsole.lib.Window;
import com.alibaba.poplayerconsole.view.GeekView;
import com.alibaba.poplayerconsole.view.ILogView;
import com.alibaba.poplayerconsole.view.PopLayerConsoleLogView;
import com.alibaba.poplayerconsole.view.PopLayerInfoLogView;
import com.alibaba.poplayerconsole.view.PopLayerToolsView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.vd2;

/* compiled from: Taobao */
public final class PopLayerConsole extends StandOutWindow {
    private static WeakReference<Context> m;
    private final Handler j = new Handler(Looper.getMainLooper());
    private List<ILogView> k = new ArrayList();
    private ViewPager l;

    /* compiled from: Taobao */
    private static class a extends PagerAdapter {
        private List<ILogView> a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.a.get(i).getView());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.a.get(i).getTitle();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.a.get(i).getView());
            return this.a.get(i).getView();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private a(List<ILogView> list) {
            this.a = list;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void N(String str) {
        for (int i = 0; i < this.k.size(); i++) {
            if (this.k.get(i) instanceof PopLayerConsoleLogView) {
                if (i != this.l.getCurrentItem()) {
                    this.l.setCurrentItem(i, true);
                }
                ((PopLayerConsoleLogView) this.k.get(i)).updateConsoleTag(str);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void O(int i) {
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) instanceof PopLayerInfoLogView) {
                if (i2 != this.l.getCurrentItem()) {
                    this.l.setCurrentItem(i2, true);
                }
                ((PopLayerInfoLogView) this.k.get(i2)).updateDomain(i);
                return;
            }
        }
    }

    public static void P(String str, ConsoleLogger$Level consoleLogger$Level) {
        if (PopLayerDebugActivity.a()) {
            WeakReference<Context> weakReference = m;
            Context context = weakReference == null ? null : weakReference.get();
            if (context != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(DumpManager.LOG_PATH, LogCache.c(str, consoleLogger$Level));
                StandOutWindow.B(context, PopLayerConsole.class, 0, 1, bundle, null, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Q(Window window) {
        try {
            this.k.get(this.l.getCurrentItem()).update(window);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public void f(int i, FrameLayout frameLayout) {
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R$layout.console_body, (ViewGroup) frameLayout, true);
        this.l = (ViewPager) inflate.findViewById(R$id.container);
        ((PagerTabStrip) inflate.findViewById(R$id.pager_header)).setNonPrimaryAlpha(0.0f);
        this.k.add(new PopLayerInfoLogView(frameLayout.getContext()));
        this.k.add(new PopLayerConsoleLogView(frameLayout.getContext()));
        this.k.add(new PopLayerToolsView(frameLayout.getContext()));
        this.k.add(new GeekView(frameLayout.getContext()));
        this.l.setAdapter(new a(this.k));
        this.l.setCurrentItem(0);
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public List<StandOutWindow.d> j(final int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StandOutWindow.d(this, 17301568, "Status:page", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass2 */

            public void run() {
                PopLayerConsole.this.O(2);
            }
        }));
        arrayList.add(new StandOutWindow.d(this, 17301568, "Status:app", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass3 */

            public void run() {
                PopLayerConsole.this.O(1);
            }
        }));
        arrayList.add(new StandOutWindow.d(this, 17301568, "Status:view", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass4 */

            public void run() {
                PopLayerConsole.this.O(3);
            }
        }));
        arrayList.add(new StandOutWindow.d(this, 17301661, "Console", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass5 */

            public void run() {
                PopLayerConsole.this.N("Console");
            }
        }));
        arrayList.add(new StandOutWindow.d(this, 17301661, "PopLayer log", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass6 */

            public void run() {
                PopLayerConsole.this.N("PopLayer");
            }
        }));
        arrayList.add(new StandOutWindow.d(this, 17301661, "windvane", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass7 */

            public void run() {
                PopLayerConsole.this.N("WindVane");
            }
        }));
        arrayList.add(new StandOutWindow.d(this, 17301591, "Tracking log", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass8 */

            public void run() {
                if (!(PopLayerConsole.this.k.get(PopLayerConsole.this.l.getCurrentItem()) instanceof PopLayerToolsView)) {
                    for (int i = 0; i < PopLayerConsole.this.k.size(); i++) {
                        if (PopLayerConsole.this.k.get(i) instanceof PopLayerToolsView) {
                            PopLayerConsole.this.l.setCurrentItem(i, true);
                            return;
                        }
                    }
                }
            }
        }));
        arrayList.add(new StandOutWindow.d(this, 17301564, "Clear all console", new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass9 */

            public void run() {
                if (PopLayerConsole.this.r(i) != null) {
                    LogCache.b();
                    for (ILogView iLogView : PopLayerConsole.this.k) {
                        if (iLogView instanceof PopLayerConsoleLogView) {
                            ((PopLayerConsoleLogView) iLogView).resetData();
                        }
                    }
                }
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public StandOutWindow.StandOutLayoutParams n(int i, Window window) {
        return new StandOutWindow.StandOutLayoutParams(this, i, DisplayMetrics.getwidthPixels(getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(getResources().getDisplayMetrics()) / 2, StandOutWindow.StandOutLayoutParams.AUTO_POSITION, StandOutWindow.StandOutLayoutParams.AUTO_POSITION, 100, 100);
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public void onCreate() {
        super.onCreate();
        PopLayer.getReference().switchLogMode(true);
        m = new WeakReference<>(getApplicationContext());
        this.a = "PopLayerConsole";
        this.b = 17301514;
        this.c = vd2.FLAG_DECORATION_SYSTEM | vd2.FLAG_BODY_MOVE_ENABLE | vd2.FLAG_WINDOW_HIDE_ENABLE | vd2.FLAG_WINDOW_EDGE_LIMITS_ENABLE | vd2.FLAG_WINDOW_PINCH_RESIZE_ENABLE;
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public boolean u(int i, Window window) {
        PopLayer.getReference().switchLogMode(false);
        this.j.removeCallbacksAndMessages(null);
        return super.u(i, window);
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public boolean v() {
        this.j.removeCallbacksAndMessages(null);
        return super.v();
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public boolean w(int i, Window window) {
        this.j.removeCallbacksAndMessages(null);
        return super.w(i, window);
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public void x(int i, int i2, Bundle bundle, Class<? extends StandOutWindow> cls, int i3) {
        if (r(i) != null) {
            if (i2 != 1) {
                Log.e("PopLayerConsole", "Unexpected data received.");
                return;
            }
            LogCache.LogDO logDO = (LogCache.LogDO) bundle.getSerializable(DumpManager.LOG_PATH);
            LogCache.a(logDO);
            for (ILogView iLogView : this.k) {
                if (iLogView instanceof PopLayerConsoleLogView) {
                    ((PopLayerConsoleLogView) iLogView).addLog(logDO);
                }
            }
        }
    }

    @Override // com.alibaba.poplayerconsole.lib.StandOutWindow
    public boolean y(int i, final Window window) {
        this.j.post(new Runnable() {
            /* class com.alibaba.poplayerconsole.PopLayerConsole.AnonymousClass1 */

            public void run() {
                try {
                    PopLayerConsole.this.Q(window);
                } catch (Throwable th) {
                    Log.e("PopLayer", "PopLayerConsole.updateStatus.error", th);
                }
                PopLayerConsole.this.j.postDelayed(this, 2000);
            }
        });
        return super.y(i, window);
    }
}
