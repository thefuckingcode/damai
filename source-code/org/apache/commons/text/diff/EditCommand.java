package org.apache.commons.text.diff;

/* compiled from: Taobao */
public abstract class EditCommand<T> {
    private final T object;

    protected EditCommand(T t) {
        this.object = t;
    }

    public abstract void accept(CommandVisitor<T> commandVisitor);

    /* access modifiers changed from: protected */
    public T getObject() {
        return this.object;
    }
}
