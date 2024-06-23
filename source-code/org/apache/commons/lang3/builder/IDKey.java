package org.apache.commons.lang3.builder;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class IDKey {
    private final int id;
    private final Object value;

    IDKey(Object obj) {
        this.id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.id == iDKey.id && this.value == iDKey.value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.id;
    }
}
