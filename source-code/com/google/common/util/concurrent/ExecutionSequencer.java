package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;

@Beta
/* compiled from: Taobao */
public final class ExecutionSequencer {

    /* compiled from: Taobao */
    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }
}
