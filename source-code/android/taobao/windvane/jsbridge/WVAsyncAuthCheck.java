package android.taobao.windvane.jsbridge;

/* compiled from: Taobao */
public interface WVAsyncAuthCheck {

    /* compiled from: Taobao */
    public interface AsyncAuthCheckCallBack {
        void callBackFail(String str, WVCallMethodContext wVCallMethodContext);

        void callBackSuccess(String str, WVCallMethodContext wVCallMethodContext);
    }

    boolean AsyncapiAuthCheck(String str, WVCallMethodContext wVCallMethodContext, AsyncAuthCheckCallBack asyncAuthCheckCallBack);
}
