package tb;

import android.app.Activity;
import android.view.FrameMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ld0 extends ea {
    public ld0(on1 on1) {
    }

    @Override // com.taobao.monitor.procedure.IPage.PageDataSetter, tb.ea
    public void addProperty(String str, Object obj) {
    }

    /* access modifiers changed from: protected */
    @Override // tb.ea
    public String f() {
        return null;
    }

    @Override // com.taobao.monitor.impl.trace.FPSDispatcher.FPSListener, tb.ea
    public void frameDataPerSecond(int i, int i2, int i3, int i4, List<FrameMetrics> list) {
    }

    /* access modifiers changed from: protected */
    @Override // tb.ea
    public void g() {
    }

    @Override // tb.ea, com.taobao.monitor.impl.trace.ApplicationGCDispatcher.ApplicationGCListener
    public void gc() {
    }

    /* access modifiers changed from: protected */
    @Override // tb.ea
    public void h() {
    }

    /* access modifiers changed from: protected */
    @Override // tb.ea
    public void l() {
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
    }

    @Override // com.taobao.monitor.procedure.IPage.PageDataSetter, tb.ea
    public void onEvent(String str, Object obj) {
    }

    @Override // com.taobao.monitor.impl.trace.ImageStageDispatcher.IImageStageListener, tb.ea
    public void onImageStage(int i) {
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher.LowMemoryListener
    public void onLowMemory() {
    }

    @Override // com.taobao.monitor.impl.trace.NetworkStageDispatcher.INetworkStageListener, tb.ea
    public void onNetworkStage(int i) {
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageAppear() {
    }

    @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
    public void onPageClickTime(long j) {
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

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageInteractive(long j) {
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageLoadError(int i) {
    }

    @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
    public void onPageNavStartTime(long j) {
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

    @Override // com.taobao.monitor.procedure.IPage.PageDataSetter, tb.ea
    public void onStage(String str, long j) {
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
    }
}
