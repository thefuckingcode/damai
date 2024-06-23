package com.taobao.android.sopatch.transfer;

/* compiled from: Taobao */
public interface Transfer<A, B> {
    A antiTransfer(B b);

    B transfer(A a);
}
