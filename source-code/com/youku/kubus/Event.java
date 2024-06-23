package com.youku.kubus;

@NoProguard
/* compiled from: Taobao */
public class Event {
    public String channel;
    private volatile boolean consumed;
    public Object data;
    public final long id;
    public String message;
    public Object target;
    public String type;

    public Event() {
        this("kubus://general");
    }

    /* access modifiers changed from: protected */
    public void consume() {
        if (!this.consumed) {
            synchronized (this) {
                if (!this.consumed) {
                    this.consumed = true;
                }
            }
        }
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public Event(String str) {
        this(str, null);
    }

    public Event(String str, String str2) {
        this.id = IdGenerator.getId();
        this.type = str;
        this.message = str2;
    }
}
