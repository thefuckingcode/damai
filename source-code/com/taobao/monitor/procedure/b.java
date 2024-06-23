package com.taobao.monitor.procedure;

import androidx.annotation.NonNull;
import com.taobao.monitor.procedure.IPage;
import java.util.Map;

/* compiled from: Taobao */
public class b implements IPage {
    private static final c a = new c();
    private static final a b = new a();
    private static final d c = new d();
    private static final C0222b d = new C0222b();

    /* compiled from: Taobao */
    public static class a implements IPage.PageBeginStandard {
        @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
        public void onPageClickTime(long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
        public void onPageNavStartTime(long j) {
        }
    }

    /* renamed from: com.taobao.monitor.procedure.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0222b implements IPage.PageDataSetter {
        @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
        public void addProperty(String str, Object obj) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
        public void onEvent(String str, Object obj) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
        public void onStage(String str, long j) {
        }
    }

    /* compiled from: Taobao */
    public static class c implements IPage.PageLifecycleCallback {
        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageAppear() {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageCreate(String str, String str2, Map<String, Object> map) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageDestroy() {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageDisappear() {
        }
    }

    /* compiled from: Taobao */
    public static class d implements IPage.PageRenderStandard {
        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageInteractive(long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageLoadError(int i) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderPercent(float f, long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderStart(long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageVisible(long j) {
        }
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageBeginStandard getPageBeginStandard() {
        return b;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageDataSetter getPageDataSetter() {
        return d;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageLifecycleCallback getPageLifecycleCallback() {
        return a;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageRenderStandard getPageRenderStandard() {
        return c;
    }
}
