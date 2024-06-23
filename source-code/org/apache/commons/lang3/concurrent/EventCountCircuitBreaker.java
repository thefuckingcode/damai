package org.apache.commons.lang3.concurrent;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* compiled from: Taobao */
public class EventCountCircuitBreaker extends AbstractCircuitBreaker<Integer> {
    private static final Map<AbstractCircuitBreaker.State, StateStrategy> STRATEGY_MAP = createStrategyMap();
    private final AtomicReference<CheckIntervalData> checkIntervalData;
    private final long closingInterval;
    private final int closingThreshold;
    private final long openingInterval;
    private final int openingThreshold;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CheckIntervalData {
        private final long checkIntervalStart;
        private final int eventCount;

        CheckIntervalData(int i, long j) {
            this.eventCount = i;
            this.checkIntervalStart = j;
        }

        public long getCheckIntervalStart() {
            return this.checkIntervalStart;
        }

        public int getEventCount() {
            return this.eventCount;
        }

        public CheckIntervalData increment(int i) {
            return i != 0 ? new CheckIntervalData(getEventCount() + i, getCheckIntervalStart()) : this;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class StateStrategy {
        private StateStrategy() {
        }

        /* access modifiers changed from: protected */
        public abstract long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker);

        public boolean isCheckIntervalFinished(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, long j) {
            return j - checkIntervalData.getCheckIntervalStart() > fetchCheckInterval(eventCountCircuitBreaker);
        }

        public abstract boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class StateStrategyClosed extends StateStrategy {
        private StateStrategyClosed() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getOpeningInterval();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getEventCount() > eventCountCircuitBreaker.getOpeningThreshold();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class StateStrategyOpen extends StateStrategy {
        private StateStrategyOpen() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getClosingInterval();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getCheckIntervalStart() != checkIntervalData.getCheckIntervalStart() && checkIntervalData.getEventCount() < eventCountCircuitBreaker.getClosingThreshold();
        }
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2, long j2, TimeUnit timeUnit2) {
        this.checkIntervalData = new AtomicReference<>(new CheckIntervalData(0, 0));
        this.openingThreshold = i;
        this.openingInterval = timeUnit.toNanos(j);
        this.closingThreshold = i2;
        this.closingInterval = timeUnit2.toNanos(j2);
    }

    private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State state) {
        changeState(state);
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    private static Map<AbstractCircuitBreaker.State, StateStrategy> createStrategyMap() {
        EnumMap enumMap = new EnumMap(AbstractCircuitBreaker.State.class);
        enumMap.put((Object) AbstractCircuitBreaker.State.CLOSED, (Object) new StateStrategyClosed());
        enumMap.put((Object) AbstractCircuitBreaker.State.OPEN, (Object) new StateStrategyOpen());
        return enumMap;
    }

    private CheckIntervalData nextCheckIntervalData(int i, CheckIntervalData checkIntervalData2, AbstractCircuitBreaker.State state, long j) {
        if (stateStrategy(state).isCheckIntervalFinished(this, checkIntervalData2, j)) {
            return new CheckIntervalData(i, j);
        }
        return checkIntervalData2.increment(i);
    }

    private boolean performStateCheck(int i) {
        AbstractCircuitBreaker.State state;
        CheckIntervalData checkIntervalData2;
        CheckIntervalData nextCheckIntervalData;
        do {
            long now = now();
            state = this.state.get();
            checkIntervalData2 = this.checkIntervalData.get();
            nextCheckIntervalData = nextCheckIntervalData(i, checkIntervalData2, state, now);
        } while (!updateCheckIntervalData(checkIntervalData2, nextCheckIntervalData));
        if (stateStrategy(state).isStateTransition(this, checkIntervalData2, nextCheckIntervalData)) {
            state = state.oppositeState();
            changeStateAndStartNewCheckInterval(state);
        }
        return !AbstractCircuitBreaker.isOpen(state);
    }

    private static StateStrategy stateStrategy(AbstractCircuitBreaker.State state) {
        return STRATEGY_MAP.get(state);
    }

    private boolean updateCheckIntervalData(CheckIntervalData checkIntervalData2, CheckIntervalData checkIntervalData3) {
        return checkIntervalData2 == checkIntervalData3 || this.checkIntervalData.compareAndSet(checkIntervalData2, checkIntervalData3);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() {
        return performStateCheck(0);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        super.close();
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    public long getClosingInterval() {
        return this.closingInterval;
    }

    public int getClosingThreshold() {
        return this.closingThreshold;
    }

    public long getOpeningInterval() {
        return this.openingInterval;
    }

    public int getOpeningThreshold() {
        return this.openingThreshold;
    }

    /* access modifiers changed from: package-private */
    public long now() {
        return System.nanoTime();
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        super.open();
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    public boolean incrementAndCheckState(Integer num) throws CircuitBreakingException {
        return performStateCheck(1);
    }

    public boolean incrementAndCheckState() {
        return incrementAndCheckState((Integer) 1);
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2) {
        this(i, j, timeUnit, i2, j, timeUnit);
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit) {
        this(i, j, timeUnit, i);
    }
}
