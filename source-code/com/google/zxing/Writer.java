package com.google.zxing;

import java.util.Hashtable;
import tb.t9;
import tb.vb;

/* compiled from: Taobao */
public interface Writer {
    vb encode(String str, t9 t9Var, int i, int i2) throws WriterException;

    vb encode(String str, t9 t9Var, int i, int i2, Hashtable hashtable) throws WriterException;
}
