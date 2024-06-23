package cn.damai.commonbusiness.ticklet.listener;

/* compiled from: Taobao */
public interface TickletPopListener {
    void doNotShowTickletPopWindow();

    void popWindowClickListener(String str);

    void showPopFailed();

    void showPopWindow(String str);
}
