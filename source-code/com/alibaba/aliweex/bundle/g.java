package com.alibaba.aliweex.bundle;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.alibaba.aliweex.bundle.WeexPageFragment;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;

/* compiled from: Taobao */
public class g implements IWXRenderListener {
    private ViewGroup a;
    private WeexPageContract.IErrorView b;
    private WeexPageContract.IProgressBar c;
    private WeexPageContract.IUTPresenter d;
    private WeexPageFragment.b e;
    private WeexPageFragment.b f;

    public g(ViewGroup viewGroup, WeexPageContract.IProgressBar iProgressBar, WeexPageContract.IUTPresenter iUTPresenter, WeexPageFragment.b bVar, WeexPageFragment.b bVar2) {
        this.a = viewGroup;
        this.c = iProgressBar;
        this.d = iUTPresenter;
        this.e = bVar;
        this.f = bVar2;
    }

    private boolean b() {
        WeexPageFragment.b bVar = this.e;
        return bVar != null && bVar.a();
    }

    private void c(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    private void d(View view) {
        View view2;
        ViewParent parent = this.a.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.getChildCount() > 0) {
                view2 = viewGroup.findViewById(R$id.weex_render_view);
                if (view2 != null) {
                    c(view2);
                }
                if (view2 == null && (view2 = this.a.findViewById(R$id.weex_render_view)) != null) {
                    this.a.removeView(view2);
                }
                if (view2 != null) {
                    c(view);
                    return;
                }
                return;
            }
        }
        view2 = null;
        this.a.removeView(view2);
        if (view2 != null) {
        }
    }

    private void e(WXSDKInstance wXSDKInstance, String str) {
        int indexOf;
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str) && str.contains("networkMsg==") && str.contains("networkErrorCode") && (indexOf = str.indexOf("|mWXResponse")) > 0) {
            String substring = str.substring(0, indexOf);
            hashMap.put("wxErrorMsgDetail", str);
            str = substring;
        }
        String instanceId = wXSDKInstance.getInstanceId();
        WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED;
        WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "WXRenderListener.onException", wXErrorCode.getErrorMsg() + "--" + str, hashMap);
    }

    public WeexPageFragment.b a() {
        return this.e;
    }

    public void f(WeexPageContract.IErrorView iErrorView) {
        this.b = iErrorView;
    }

    public void g(WeexPageFragment.b bVar) {
        this.e = bVar;
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
        boolean z;
        WXLogUtils.d("WXRenderListener", "into--[onException] errCode:" + str + " msg:" + str2);
        if (TextUtils.equals(str, WXErrorCode.WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED.getErrorCode())) {
            this.b.createErrorView(wXSDKInstance.getContext(), this.a);
            this.b.showErrorView(true, "网络错误，点击刷新重试！");
            e(wXSDKInstance, str2);
            z = false;
        } else {
            z = WeexPageFragment.shouldDegrade(wXSDKInstance, str, str2);
        }
        if (WXEnvironment.isApkDebugable()) {
            Toast.makeText(wXSDKInstance.getContext(), str2, 1).show();
        }
        this.c.showProgressBar(false);
        this.f.onException(wXSDKInstance, str, str2);
        WeexPageFragment.b bVar = this.e;
        if (bVar != null) {
            bVar.c(wXSDKInstance, z, str, str2);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRefreshSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        WXLogUtils.d("WXRenderListener", "into--[onRefreshSuccess]");
        WeexPageContract.IProgressBar iProgressBar = this.c;
        if (iProgressBar != null) {
            iProgressBar.showProgressBar(false);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRenderSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        WXLogUtils.d("WXRenderListener", "into--[onRenderSuccess]");
        WeexPageFragment.b bVar = this.e;
        if (bVar != null) {
            bVar.onRenderSuccess(wXSDKInstance, i, i2);
        }
        WeexPageContract.IProgressBar iProgressBar = this.c;
        if (iProgressBar != null) {
            iProgressBar.showProgressBar(false);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
        WXLogUtils.d("WXRenderListener", "into--[onViewCreated]");
        if (this.a != null) {
            if (b()) {
                d(view);
                WeexPageFragment.b bVar = this.e;
                View b2 = bVar != null ? bVar.b(wXSDKInstance, view) : view;
                b2.setId(R$id.weex_render_view);
                if (this.a.getParent() instanceof FrameLayout) {
                    ((ViewGroup) this.a.getParent()).addView(b2);
                } else {
                    this.a.addView(b2);
                }
            } else if (view.getParent() == null) {
                if (this.a.getChildCount() > 2) {
                    this.a.removeViewAt(2);
                }
                this.a.addView(view);
            }
            this.c.showProgressBar(false);
            this.f.onViewCreated(wXSDKInstance, view);
            WeexPageFragment.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onViewCreated(wXSDKInstance, view);
            }
            WeexPageContract.IUTPresenter iUTPresenter = this.d;
            if (iUTPresenter != null) {
                iUTPresenter.tryToUpdatePageSpmCnt(wXSDKInstance);
            }
        }
    }
}
