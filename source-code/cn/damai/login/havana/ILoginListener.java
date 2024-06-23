package cn.damai.login.havana;

/* compiled from: Taobao */
public interface ILoginListener {
    void onLoginCancel();

    void onLoginFail();

    void onLoginSuccess();

    void onLogout();
}
