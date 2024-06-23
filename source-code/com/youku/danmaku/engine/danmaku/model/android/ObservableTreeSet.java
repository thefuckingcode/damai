package com.youku.danmaku.engine.danmaku.model.android;

import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

/* compiled from: Taobao */
public class ObservableTreeSet<O extends Observable> extends TreeSet<O> implements Observer {
    private Observer mObserver;

    public ObservableTreeSet(Comparator<O> comparator) {
        super(comparator);
    }

    public void setDataChangedListener(Observer observer) {
        this.mObserver = observer;
    }

    public void update(Observable observable, Object obj) {
        Observer observer = this.mObserver;
        if (observer != null) {
            observer.update(observable, obj);
        }
    }

    public boolean add(O o) {
        if (o != null) {
            o.addObserver(this);
        }
        return super.add((Object) o);
    }
}
