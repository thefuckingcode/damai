package com.google.zxing;

import java.util.Hashtable;
import tb.h12;
import tb.lb;

/* compiled from: Taobao */
public interface Reader {
    h12 decode(lb lbVar) throws NotFoundException, ChecksumException, FormatException;

    h12 decode(lb lbVar, Hashtable hashtable) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
