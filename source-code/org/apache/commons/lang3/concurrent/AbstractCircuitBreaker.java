package org.apache.commons.lang3.concurrent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public abstract class AbstractCircuitBreaker<T> implements CircuitBreaker<T> {
    public static final String PROPERTY_NAME = "open";
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    protected final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public enum State {
        CLOSED {
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return State.OPEN;
            }
        },
        OPEN {
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return State.CLOSED;
            }
        };

        public abstract State oppositeState();
    }

    public void addChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    /* access modifiers changed from: protected */
    public void changeState(State state2) {
        if (this.state.compareAndSet(state2.oppositeState(), state2)) {
            this.changeSupport.firePropertyChange("open", !isOpen(state2), isOpen(state2));
        }
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public abstract boolean checkState();

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        changeState(State.CLOSED);
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public abstract boolean incrementAndCheckState(T t);

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean isClosed() {
        return !isOpen();
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean isOpen() {
        return isOpen(this.state.get());
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        changeState(State.OPEN);
    }

    public void removeChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    protected static boolean isOpen(State state2) {
        return state2 == State.OPEN;
    }
}
