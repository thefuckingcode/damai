package com.efs.sdk.base.processor.action;

/* compiled from: Taobao */
public interface ILogEncryptAction {
    byte[] decrypt(String str, byte[] bArr);

    byte[] encrypt(String str, byte[] bArr);

    int getDeVal();
}
