package cn.damai.common.badge.update;

/* compiled from: Taobao */
public interface BadgeLoginMonitor {

    /* compiled from: Taobao */
    public interface LoginCallback {
        void onLoginSuccess();

        void onLogoutSuccess();
    }

    void setLoginCallback(LoginCallback loginCallback);

    void startLoginMonitor();

    void stopLoginMonitor();
}
