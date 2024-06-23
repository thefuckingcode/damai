package cn.damai.ticklet.ui.observer;

/* compiled from: Taobao */
public interface Observerable {
    void notifyObserver();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
}
