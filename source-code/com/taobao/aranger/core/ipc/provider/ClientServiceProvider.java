package com.taobao.aranger.core.ipc.provider;

import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.taobao.aranger.annotation.method.UIThread;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IClientService;
import com.taobao.aranger.utils.CallbackManager;
import com.taobao.aranger.utils.TypeUtils;
import com.taobao.aranger.utils.a;
import com.taobao.aranger.utils.d;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.jz0;
import tb.kz0;

/* compiled from: Taobao */
public class ClientServiceProvider extends Binder implements IClientService {
    private static final String TAG = ClientServiceProvider.class.getSimpleName();
    private static volatile ClientServiceProvider sInstance;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CallbackRunnable implements Runnable {
        private final Object mCallback;
        private CountDownLatch mCountDownLatch;
        private Exception mException;
        private final Method mMethod;
        private final Object[] mParameters;
        private Object mResult;

        CallbackRunnable(Method method, Object obj, Object[] objArr) {
            this.mMethod = method;
            this.mCallback = obj;
            this.mParameters = objArr;
        }

        /* access modifiers changed from: package-private */
        public Exception getException() {
            return this.mException;
        }

        /* access modifiers changed from: package-private */
        public Object getResult() {
            return this.mResult;
        }

        public void run() {
            CountDownLatch countDownLatch;
            try {
                this.mResult = this.mMethod.invoke(this.mCallback, this.mParameters);
                countDownLatch = this.mCountDownLatch;
                if (countDownLatch == null) {
                    return;
                }
            } catch (Exception e) {
                jz0.c(ClientServiceProvider.TAG, "[CallbackRunnable][run]", e, new Object[0]);
                this.mException = e;
                countDownLatch = this.mCountDownLatch;
                if (countDownLatch == null) {
                    return;
                }
            } catch (Throwable th) {
                CountDownLatch countDownLatch2 = this.mCountDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                throw th;
            }
            countDownLatch.countDown();
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.mCountDownLatch = countDownLatch;
        }
    }

    private ClientServiceProvider() {
        attachInterface(this, Constants.CLIENT_SERVICE_DESCRIPTOR);
    }

    public static ClientServiceProvider getClientService() {
        if (sInstance == null) {
            synchronized (ClientServiceProvider.class) {
                if (sInstance == null) {
                    sInstance = new ClientServiceProvider();
                }
            }
        }
        return sInstance;
    }

    @Keep
    public IBinder asBinder() {
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // android.os.Binder
    @Keep
    public boolean onTransact(int i, @NonNull final Parcel parcel, Parcel parcel2, int i2) {
        if (i != 3) {
            if (i == 4) {
                kz0.b(false, false, new Runnable() {
                    /* class com.taobao.aranger.core.ipc.provider.ClientServiceProvider.AnonymousClass2 */

                    public void run() {
                        try {
                            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                            if (createStringArrayList != null) {
                                ClientServiceProvider.this.recycle(createStringArrayList);
                            } else {
                                jz0.d(ClientServiceProvider.TAG, "[onTransact][recycle] list is null.", new Object[0]);
                            }
                        } catch (Exception e) {
                            jz0.c(ClientServiceProvider.TAG, "[onTransact][recycle]", e, new Object[0]);
                        }
                    }
                });
            }
            return true;
        }
        if (i2 == 1) {
            kz0.b(false, false, new Runnable() {
                /* class com.taobao.aranger.core.ipc.provider.ClientServiceProvider.AnonymousClass1 */

                public void run() {
                    try {
                        ClientServiceProvider.this.sendCallback(Callback.CREATOR.createFromParcel(parcel));
                    } catch (Exception e) {
                        jz0.c(ClientServiceProvider.TAG, "[onTransact][sendCallback][oneway]", e, new Object[0]);
                    }
                }
            });
        } else {
            try {
                Callback createFromParcel = Callback.CREATOR.createFromParcel(parcel);
                Reply sendCallback = sendCallback(createFromParcel);
                if (!TextUtils.isEmpty(createFromParcel.getMethodWrapper().getReturnType()) || sendCallback.isError() || sendCallback.getFlowParameterWrappers() != null) {
                    sendCallback.writeToParcel(parcel2, 0);
                }
            } catch (Exception e) {
                Reply.obtain().setErrorCode(8).setErrorMessage(e.getMessage()).writeToParcel(parcel2, i2);
            }
        }
        return true;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) {
        for (String str : list) {
            CallbackManager.e().g(str);
        }
    }

    @Override // com.taobao.aranger.intf.IClientService
    public Reply sendCallback(Callback callback) {
        Exception e;
        Object obj;
        Object d = CallbackManager.e().d(callback.getKey());
        if (d == null) {
            return Reply.obtain().setErrorCode(6).setErrorMessage("can't find callback in current process");
        }
        try {
            ArrayList<Integer> arrayList = new ArrayList();
            Method f = d.e().f(d.getClass(), callback.getMethodWrapper(), callback.getParameterWrappers());
            Object[] a = a.a(callback.getParameterWrappers(), arrayList);
            Class<?>[] interfaces = d.getClass().getInterfaces();
            boolean z = false;
            for (Class<?> cls : interfaces) {
                if (TypeUtils.arrayContainsAnnotation(cls.getAnnotations(), com.taobao.aranger.annotation.type.Callback.class)) {
                    z = TypeUtils.arrayContainsAnnotation(d.e().f(cls, callback.getMethodWrapper(), callback.getParameterWrappers()).getAnnotations(), UIThread.class);
                }
            }
            boolean z2 = true;
            boolean z3 = Looper.getMainLooper() == Looper.myLooper();
            Reply obtain = Reply.obtain();
            boolean z4 = z3 ^ z;
            ParameterWrapper[] parameterWrapperArr = null;
            if (z4) {
                try {
                    CallbackRunnable callbackRunnable = new CallbackRunnable(f, d, a);
                    if (!Constants.VOID.equals(f.getReturnType().getName()) || !arrayList.isEmpty()) {
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        callbackRunnable.setCountDownLatch(countDownLatch);
                        if (z3) {
                            z2 = false;
                        }
                        kz0.b(z2, false, callbackRunnable);
                        countDownLatch.await(z3 ? 1000 : 10000, TimeUnit.MILLISECONDS);
                        e = callbackRunnable.getException();
                        obj = callbackRunnable.getResult();
                    } else {
                        if (z3) {
                            z2 = false;
                        }
                        kz0.b(z2, false, callbackRunnable);
                        return obtain.setResult(null);
                    }
                } catch (Exception e2) {
                    return obtain.setErrorCode(7).setErrorMessage("callback invoke error: " + e2.getMessage());
                }
            } else {
                try {
                    obj = f.invoke(d, a);
                    e = null;
                } catch (Exception e3) {
                    e = e3;
                    obj = null;
                }
            }
            if (e == null) {
                if (!arrayList.isEmpty()) {
                    parameterWrapperArr = new ParameterWrapper[arrayList.size()];
                    for (Integer num : arrayList) {
                        int intValue = num.intValue();
                        parameterWrapperArr[intValue] = ParameterWrapper.obtain().setData(a[((Integer) arrayList.get(intValue)).intValue()]);
                    }
                }
                return obtain.setFlowParameterWrappers(parameterWrapperArr).setResult(obj);
            }
            throw new IPCException(4, e);
        } catch (IPCException e4) {
            jz0.c(TAG, "[sendCallback]", e4, new Object[0]);
            return Reply.obtain().setErrorCode(e4.getErrorCode()).setErrorMessage(e4.getMessage());
        }
    }
}
