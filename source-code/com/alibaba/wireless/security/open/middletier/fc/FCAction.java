package com.alibaba.wireless.security.open.middletier.fc;

/* compiled from: Taobao */
public class FCAction {

    /* compiled from: Taobao */
    public enum FCMainAction {
        SUCCESS,
        FAIL,
        CANCEL,
        RETRY,
        TIMEOUT
    }

    /* compiled from: Taobao */
    public enum FCSubAction {
        WUA(1),
        NC(2),
        FL(4),
        LOGIN(8),
        DENY(16);
        
        private long a = 0;

        private FCSubAction(long j) {
            this.a = j;
        }

        public long getValue() {
            return this.a;
        }
    }
}
