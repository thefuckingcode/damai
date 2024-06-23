package com.alibaba.aliweex.plugin;

/* compiled from: Taobao */
class WorkFlow$WorkFlowException extends RuntimeException {
    WorkFlow$WorkFlowException(Throwable th) {
        super(th);
    }

    public String toString() {
        return "WorkException{causeException=" + getCause() + "} " + super.toString();
    }
}
