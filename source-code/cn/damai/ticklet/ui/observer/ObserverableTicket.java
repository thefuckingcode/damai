package cn.damai.ticklet.ui.observer;

/* compiled from: Taobao */
public interface ObserverableTicket {
    void notifyObserver();

    void registerObserver(ObserverTicket observerTicket);

    void removeObserver(ObserverTicket observerTicket);
}
