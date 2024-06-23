package org.apache.commons.net.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* compiled from: Taobao */
public class SocketOutputStream extends FilterOutputStream {
    private final Socket __socket;

    public SocketOutputStream(Socket socket, OutputStream outputStream) {
        super(outputStream);
        this.__socket = socket;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.__socket.close();
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
    }
}
