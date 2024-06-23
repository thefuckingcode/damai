package com.ali.user.mobile.base.helper;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.security.biz.R;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.taobao.login4android.utils.ToastUtil;

/* compiled from: Taobao */
public class SDKExceptionHelper {
    private static SDKExceptionHelper instance = new SDKExceptionHelper();

    private SDKExceptionHelper() {
    }

    public static SDKExceptionHelper getInstance() {
        return instance;
    }

    private void toast(final String str) {
        MainThreadExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.base.helper.SDKExceptionHelper.AnonymousClass1 */

            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        ToastUtil.showToast(DataProviderFactory.getApplicationContext(), str, 0);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        });
    }

    public void rpcExceptionHandler(Throwable th) {
        th.printStackTrace();
        if (th instanceof RpcException) {
            RpcException rpcException = (RpcException) th;
            int code = rpcException.getCode();
            if (!(code == 4 || code == 5)) {
                if (code == 6) {
                    toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
                    return;
                } else if (code != 7) {
                    if (code >= 400 && code < 500) {
                        toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
                        return;
                    } else if (code < 100 || code >= 600) {
                        toast(rpcException.getMsg());
                        return;
                    } else {
                        toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
                        return;
                    }
                }
            }
            toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
            return;
        }
        toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
    }
}
