package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;

@VisibleForTesting
/* compiled from: Taobao */
interface Closer$Suppressor {
    void suppress(Closeable closeable, Throwable th, Throwable th2);
}
