package cn.damai.login.api;

/* compiled from: Taobao */
public interface IGetAuthCallback {
    void onAuthTokenFail(String str, String str2);

    void onAuthTokenSuccess(String str);
}
