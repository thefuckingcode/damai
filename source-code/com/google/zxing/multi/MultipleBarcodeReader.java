package com.google.zxing.multi;

import com.google.zxing.NotFoundException;
import java.util.Hashtable;
import tb.h12;
import tb.lb;

/* compiled from: Taobao */
public interface MultipleBarcodeReader {
    h12[] decodeMultiple(lb lbVar) throws NotFoundException;

    h12[] decodeMultiple(lb lbVar, Hashtable hashtable) throws NotFoundException;
}
