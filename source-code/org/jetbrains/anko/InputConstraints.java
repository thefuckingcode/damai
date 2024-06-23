package org.jetbrains.anko;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lorg/jetbrains/anko/InputConstraints;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PASSWORD", "platform-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: InputConstraints.kt */
public enum InputConstraints {
    PASSWORD(129);
    
    private final int value;

    protected InputConstraints(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
