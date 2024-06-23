package com.taobao.phenix.loader.file;

/* compiled from: Taobao */
public class UnSupportedSchemeException extends Exception {
    public UnSupportedSchemeException(int i) {
        super("SchemeType(" + i + ") cannot be supported now");
    }
}
