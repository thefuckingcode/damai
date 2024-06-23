package org.apache.commons.net.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/* compiled from: Taobao */
public final class DotTerminatedMessageReader extends BufferedReader {
    private static final char CR = '\r';
    private static final int DOT = 46;
    private static final char LF = '\n';
    private boolean atBeginning = true;
    private boolean eof = false;
    private boolean seenCR;

    public DotTerminatedMessageReader(Reader reader) {
        super(reader);
    }

    @Override // java.io.Closeable, java.io.BufferedReader, java.io.Reader, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (((BufferedReader) this).lock) {
            if (!this.eof) {
                while (read() != -1) {
                }
            }
            this.eof = true;
            this.atBeginning = false;
        }
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws IOException {
        synchronized (((BufferedReader) this).lock) {
            if (this.eof) {
                return -1;
            }
            int read = super.read();
            if (read == -1) {
                this.eof = true;
                return -1;
            }
            if (this.atBeginning) {
                this.atBeginning = false;
                if (read == 46) {
                    mark(2);
                    int read2 = super.read();
                    if (read2 == -1) {
                        this.eof = true;
                        return 46;
                    } else if (read2 == 46) {
                        return read2;
                    } else {
                        if (read2 == 13) {
                            int read3 = super.read();
                            if (read3 == -1) {
                                reset();
                                return 46;
                            } else if (read3 == 10) {
                                this.atBeginning = true;
                                this.eof = true;
                                return -1;
                            }
                        }
                        reset();
                        return 46;
                    }
                }
            }
            if (this.seenCR) {
                this.seenCR = false;
                if (read == 10) {
                    this.atBeginning = true;
                }
            }
            if (read == 13) {
                this.seenCR = true;
            }
            return read;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r0.length() != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return r0;
     */
    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        synchronized (((BufferedReader) this).lock) {
            while (true) {
                int read = read();
                if (read != -1) {
                    if (read != 10 || !this.atBeginning) {
                        sb.append((char) read);
                    } else {
                        return sb.substring(0, sb.length() - 1);
                    }
                }
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        if (i2 < 1) {
            return 0;
        }
        synchronized (((BufferedReader) this).lock) {
            int read = read();
            if (read == -1) {
                return -1;
            }
            int i4 = i;
            while (true) {
                i3 = i4 + 1;
                cArr[i4] = (char) read;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                read = read();
                if (read == -1) {
                    break;
                }
                i4 = i3;
            }
            return i3 - i;
        }
    }
}
