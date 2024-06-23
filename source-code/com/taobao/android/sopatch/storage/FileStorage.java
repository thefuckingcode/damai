package com.taobao.android.sopatch.storage;

import java.io.File;
import tb.pc2;
import tb.sc2;

/* compiled from: Taobao */
public interface FileStorage {
    void deleteInvalidFiles();

    File getSoFile(pc2 pc2);

    File getSoPatchCacheFile();

    File getTmpFile(String str);

    File getZipFile(sc2 sc2);
}
