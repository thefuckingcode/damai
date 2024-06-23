package org.apache.commons.net.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/* compiled from: Taobao */
public final class CRLFLineReader extends BufferedReader {
    private static final char CR = '\r';
    private static final char LF = '\n';

    public CRLFLineReader(Reader reader) {
        super(reader);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r0.length() != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r0;
     */
    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        synchronized (((BufferedReader) this).lock) {
            boolean z = false;
            while (true) {
                int read = read();
                if (read != -1) {
                    if (!z || read != 10) {
                        z = read == 13;
                        sb.append((char) read);
                    } else {
                        return sb.substring(0, sb.length() - 1);
                    }
                }
            }
        }
    }
}
