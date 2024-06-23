package org.apache.commons.lang3.time;

import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class StopWatch {
    private static final long NANO_2_MILLIS = 1000000;
    private State runningState = State.UNSTARTED;
    private SplitState splitState = SplitState.UNSPLIT;
    private long startTime;
    private long startTimeMillis;
    private long stopTime;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum SplitState {
        SPLIT,
        UNSPLIT
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum State {
        UNSTARTED {
            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        RUNNING {
            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        STOPPED {
            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED {
            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            /* access modifiers changed from: package-private */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return true;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract boolean isStarted();

        /* access modifiers changed from: package-private */
        public abstract boolean isStopped();

        /* access modifiers changed from: package-private */
        public abstract boolean isSuspended();
    }

    public static StopWatch createStarted() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    public long getNanoTime() {
        long j;
        long j2;
        State state = this.runningState;
        if (state == State.STOPPED || state == State.SUSPENDED) {
            j = this.stopTime;
            j2 = this.startTime;
        } else if (state == State.UNSTARTED) {
            return 0;
        } else {
            if (state == State.RUNNING) {
                j = System.nanoTime();
                j2 = this.startTime;
            } else {
                throw new RuntimeException("Illegal running state has occurred.");
            }
        }
        return j - j2;
    }

    public long getSplitNanoTime() {
        if (this.splitState == SplitState.SPLIT) {
            return this.stopTime - this.startTime;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getSplitTime() {
        return getSplitNanoTime() / NANO_2_MILLIS;
    }

    public long getStartTime() {
        if (this.runningState != State.UNSTARTED) {
            return this.startTimeMillis;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getTime() {
        return getNanoTime() / NANO_2_MILLIS;
    }

    public boolean isStarted() {
        return this.runningState.isStarted();
    }

    public boolean isStopped() {
        return this.runningState.isStopped();
    }

    public boolean isSuspended() {
        return this.runningState.isSuspended();
    }

    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    public void resume() {
        if (this.runningState == State.SUSPENDED) {
            this.startTime += System.nanoTime() - this.stopTime;
            this.runningState = State.RUNNING;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public void split() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.splitState = SplitState.SPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void start() {
        State state = this.runningState;
        if (state == State.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (state == State.UNSTARTED) {
            this.startTime = System.nanoTime();
            this.startTimeMillis = System.currentTimeMillis();
            this.runningState = State.RUNNING;
        } else {
            throw new IllegalStateException("Stopwatch already started. ");
        }
    }

    public void stop() {
        State state = this.runningState;
        State state2 = State.RUNNING;
        if (state == state2 || state == State.SUSPENDED) {
            if (state == state2) {
                this.stopTime = System.nanoTime();
            }
            this.runningState = State.STOPPED;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void suspend() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.runningState = State.SUSPENDED;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public void unsplit() {
        if (this.splitState == SplitState.SPLIT) {
            this.splitState = SplitState.UNSPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }

    public long getTime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
    }
}
