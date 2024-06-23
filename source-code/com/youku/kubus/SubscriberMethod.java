package com.youku.kubus;

import java.lang.reflect.Method;

@NoProguard
/* compiled from: Taobao */
public class SubscriberMethod {
    final String eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method method2, String str, ThreadMode threadMode2, int i, boolean z) {
        this.method = method2;
        this.threadMode = threadMode2;
        this.eventType = str;
        this.priority = i;
        this.sticky = z;
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.method.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.method.getName());
            sb.append('(');
            sb.append(this.eventType);
            this.methodString = sb.toString();
        }
    }

    public String dumpInfo() {
        if (this.methodString == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.method.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.method.getName());
            sb.append('(');
            sb.append(this.eventType);
            this.methodString = sb.toString();
        }
        return this.methodString;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        checkMethodString();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.checkMethodString();
        return this.methodString.equals(subscriberMethod.methodString);
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
