package com.taobao.phenix.compat.mtop;

import com.taobao.phenix.loader.network.NetworkResponseException;

/* compiled from: Taobao */
public class MtopCertificateException extends NetworkResponseException {
    public MtopCertificateException(int i) {
        super(0, "SSL Certificate Failed", i, null);
    }
}
