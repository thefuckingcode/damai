package com.ali.user.mobile.login.presenter;

import android.os.AsyncTask;
import com.ali.user.mobile.base.BasePresenter;
import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.data.RegisterComponent;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.model.BaseRegistRequest;
import com.ali.user.mobile.register.model.MtopRegisterInitcontextResponseData;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.utils.CountryCodeUtil;
import com.ali.user.mobile.utils.ResourceUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
public class RegionPresenter implements BasePresenter {
    public static final int LOGIN_REGION = 0;
    public static final int REGISTER_REGION = 1;
    BaseView mViewer;

    public RegionPresenter(BaseView baseView) {
        this.mViewer = baseView;
    }

    private void getRegion(final int i, final RpcRequestCallback rpcRequestCallback) {
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, MtopRegisterInitcontextResponseData>() {
            /* class com.ali.user.mobile.login.presenter.RegionPresenter.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public MtopRegisterInitcontextResponseData doInBackground(Object[] objArr) {
                HashMap hashMap = new HashMap();
                BaseRegistRequest baseRegistRequest = new BaseRegistRequest();
                baseRegistRequest.ext = hashMap;
                try {
                    if (i == 0) {
                        return (MtopRegisterInitcontextResponseData) LoginComponent.getInstance().getCountryList();
                    }
                    return RegisterComponent.getInstance().countryCodeRes(baseRegistRequest);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData) {
                RpcRequestCallback rpcRequestCallback = rpcRequestCallback;
                if (rpcRequestCallback != null) {
                    if (mtopRegisterInitcontextResponseData == null) {
                        rpcRequestCallback.onSystemError(null);
                    } else if (mtopRegisterInitcontextResponseData.returnValue != null) {
                        rpcRequestCallback.onSuccess(mtopRegisterInitcontextResponseData);
                    } else {
                        rpcRequestCallback.onError(mtopRegisterInitcontextResponseData);
                    }
                }
            }
        }, new Object[0]);
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onDestory() {
        this.mViewer = null;
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onStart() {
    }

    public void region(int i) {
        BaseView baseView = this.mViewer;
        if (baseView != null && baseView.isActive()) {
            this.mViewer.showLoading();
            getRegion(i, new RpcRequestCallback() {
                /* class com.ali.user.mobile.login.presenter.RegionPresenter.AnonymousClass1 */

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onError(RpcResponse rpcResponse) {
                    BaseView baseView = RegionPresenter.this.mViewer;
                    if (baseView != null && baseView.isActive()) {
                        RegionPresenter.this.mViewer.dismissLoading();
                        SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSuccess(RpcResponse rpcResponse) {
                    T t;
                    MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData = (MtopRegisterInitcontextResponseData) rpcResponse;
                    if (mtopRegisterInitcontextResponseData != null && (t = mtopRegisterInitcontextResponseData.returnValue) != null && t.countrycodes != null) {
                        ArrayList<RegionInfo> fillData = CountryCodeUtil.fillData(ResourceUtil.getStringById("aliuser_common_region"), mtopRegisterInitcontextResponseData.returnValue.countrycodes, new HashMap(), new ArrayList());
                        BaseView baseView = RegionPresenter.this.mViewer;
                        if (baseView != null) {
                            baseView.dismissLoading();
                            RegionPresenter.this.mViewer.onGetRegion(fillData);
                        }
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSystemError(RpcResponse rpcResponse) {
                    BaseView baseView = RegionPresenter.this.mViewer;
                    if (baseView != null && baseView.isActive()) {
                        RegionPresenter.this.mViewer.dismissLoading();
                        SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
                    }
                }
            });
        }
    }
}
