package com.ali.user.open.core.message;

@Deprecated
/* compiled from: Taobao */
public class Message implements Cloneable {
    public int code;
    public String message;

    public static Message create(int i, Object... objArr) {
        return MessageUtils.createMessage(i, objArr);
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
