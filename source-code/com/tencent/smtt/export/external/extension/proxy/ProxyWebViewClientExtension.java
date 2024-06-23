package com.tencent.smtt.export.external.extension.proxy;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;

public abstract class ProxyWebViewClientExtension implements IX5WebViewClientExtension {
    private static boolean sCompatibleOnMetricsSavedCountReceived = true;
    private static boolean sCompatibleOnPageLoadingStartedAndFinished = true;
    protected IX5WebViewClientExtension mWebViewClientExt;

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPreReadFinished() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onPreReadFinished();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPromptScaleSaved() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onPromptScaleSaved();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUrlChange(String str, String str2) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onUrlChange(str, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onHideListBox() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onHideListBox();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onShowListBox(strArr, iArr, iArr2, i);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onInputBoxTextChanged(iX5WebViewExtension, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onTransitionToCommitted() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onTransitionToCommitted();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void showTranslateBubble(int i, String str, String str2, int i2) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.showTranslateBubble(i, str, str2, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUploadProgressStart(int i) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onUploadProgressStart(i);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUploadProgressChange(int i, int i2, String str) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onUploadProgressChange(i, i2, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFlingScrollBegin(int i, int i2, int i3) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onFlingScrollBegin(i, i2, i3);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFlingScrollEnd() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onFlingScrollEnd();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSoftKeyBoardShow() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onSoftKeyBoardShow();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSoftKeyBoardHide(int i) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onSoftKeyBoardHide(i);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSetButtonStatus(boolean z, boolean z2) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onSetButtonStatus(z, z2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onHistoryItemChanged() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onHistoryItemChanged();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void hideAddressBar() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.hideAddressBar();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.handlePluginTag(str, str2, z, str3);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onDoubleTapStart() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onDoubleTapStart();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPinchToZoomStart() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onPinchToZoomStart();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSlidingTitleOffScreen(int i, int i2) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onSlidingTitleOffScreen(i, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.preShouldOverrideUrlLoading(iX5WebViewExtension, str);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onMissingPluginClicked(String str, String str2, String str3, int i) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onMissingPluginClicked(str, str2, str3, i);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onReportAdFilterInfo(i, i2, str, z);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReportHtmlInfo(int i, String str) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onReportHtmlInfo(i, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onNativeCrashReport(int i, String str) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onNativeCrashReport(i, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public Object onMiscCallBack(String str, Bundle bundle) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.onMiscCallBack(str, bundle);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.onInterceptTouchEvent(motionEvent, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.onTouchEvent(motionEvent, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.dispatchTouchEvent(motionEvent, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onScrollChanged(i, i2, i3, i4, view);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onOverScrolled(i, i2, z, z2, view);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void computeScroll(View view) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.computeScroll(view);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null && sCompatibleOnMetricsSavedCountReceived) {
            try {
                iX5WebViewClientExtension.onMetricsSavedCountReceived(str, z, j, str2, i);
            } catch (NoSuchMethodError e) {
                if (e.getMessage() == null || !e.getMessage().contains("onMetricsSavedCountReceived")) {
                    throw e;
                }
                Log.d("incompatible-oldcore", "IX5WebViewClientExtension.onMetricsSavedCountReceived");
                sCompatibleOnMetricsSavedCountReceived = false;
            }
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean notifyAutoAudioPlay(String str, JsResult jsResult) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension == null) {
            return false;
        }
        try {
            return iX5WebViewClientExtension.notifyAutoAudioPlay(str, jsResult);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.allowJavaScriptOpenWindowAutomatically(str, str2);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            return iX5WebViewClientExtension.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onShowLongClickPopupMenu() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension == null) {
            return false;
        }
        try {
            return iX5WebViewClientExtension.onShowLongClickPopupMenu();
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onResponseReceived(webResourceRequest, webResourceResponse, i);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void didFirstVisuallyNonEmptyPaint() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.didFirstVisuallyNonEmptyPaint();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void documentAvailableInMainFrame() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.documentAvailableInMainFrame();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedViewSource(String str) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onReceivedViewSource(str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPrefetchResourceHit(boolean z) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onPrefetchResourceHit(z);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedSslErrorCancel() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onReceivedSslErrorCancel();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void invalidate() {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.invalidate();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPreloadCallback(int i, String str) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onPreloadCallback(i, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFakeLoginRecognised(Bundle bundle) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onFakeLoginRecognised(bundle);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReportResponseHeaders(String str, int i, HashMap<String, String> hashMap) {
        IX5WebViewClientExtension iX5WebViewClientExtension = this.mWebViewClientExt;
        if (iX5WebViewClientExtension != null) {
            iX5WebViewClientExtension.onReportResponseHeaders(str, i, hashMap);
        }
    }
}
