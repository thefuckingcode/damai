package com.taobao.alivfssdk.fresco.binaryresource;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public interface BinaryResource {
    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();
}
