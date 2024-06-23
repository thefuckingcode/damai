package com.alibaba.wireless.security.open.dynamicdataencrypt;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface IDynamicDataEncryptComponent extends IComponent {
    @Deprecated
    String dynamicDecrypt(String str) throws SecException;

    @Deprecated
    byte[] dynamicDecryptByteArray(byte[] bArr) throws SecException;

    byte[] dynamicDecryptByteArrayDDp(byte[] bArr) throws SecException;

    String dynamicDecryptDDp(String str) throws SecException;

    @Deprecated
    String dynamicEncrypt(String str) throws SecException;

    @Deprecated
    byte[] dynamicEncryptByteArray(byte[] bArr) throws SecException;

    byte[] dynamicEncryptByteArrayDDp(byte[] bArr) throws SecException;

    String dynamicEncryptDDp(String str) throws SecException;

    boolean isVerifyCrypt(String str) throws SecException;
}
