package org.apache.commons.text.diff;

/* compiled from: Taobao */
public class KeepCommand<T> extends EditCommand<T> {
    public KeepCommand(T t) {
        super(t);
    }

    @Override // org.apache.commons.text.diff.EditCommand
    public void accept(CommandVisitor<T> commandVisitor) {
        commandVisitor.visitKeepCommand(getObject());
    }
}
