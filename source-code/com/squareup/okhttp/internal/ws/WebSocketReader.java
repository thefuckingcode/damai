package com.squareup.okhttp.internal.ws;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.ws.WebSocket;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.h;
import okio.o;

/* compiled from: Taobao */
public final class WebSocketReader {
    private boolean closed;
    private long frameBytesRead;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final Source framedMessageSource = new FramedMessageSource();
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private boolean isMasked;
    private final byte[] maskBuffer = new byte[2048];
    private final byte[] maskKey = new byte[4];
    private boolean messageClosed;
    private int opcode;
    private final BufferedSource source;

    /* compiled from: Taobao */
    public interface FrameCallback {
        void onClose(int i, String str);

        void onMessage(BufferedSource bufferedSource, WebSocket.PayloadType payloadType) throws IOException;

        void onPing(Buffer buffer);

        void onPong(Buffer buffer);
    }

    /* compiled from: Taobao */
    private final class FramedMessageSource implements Source {
        private FramedMessageSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!WebSocketReader.this.messageClosed) {
                WebSocketReader.this.messageClosed = true;
                if (!WebSocketReader.this.closed) {
                    WebSocketReader.this.source.skip(WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
                    while (!WebSocketReader.this.isFinalFrame) {
                        WebSocketReader.this.readUntilNonControlFrame();
                        WebSocketReader.this.source.skip(WebSocketReader.this.frameLength);
                    }
                }
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long j2;
            if (WebSocketReader.this.closed) {
                throw new IOException(IRequestConst.CLOSED);
            } else if (!WebSocketReader.this.messageClosed) {
                if (WebSocketReader.this.frameBytesRead == WebSocketReader.this.frameLength) {
                    if (WebSocketReader.this.isFinalFrame) {
                        return -1;
                    }
                    WebSocketReader.this.readUntilNonControlFrame();
                    if (WebSocketReader.this.opcode != 0) {
                        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(WebSocketReader.this.opcode));
                    } else if (WebSocketReader.this.isFinalFrame && WebSocketReader.this.frameLength == 0) {
                        return -1;
                    }
                }
                long min = Math.min(j, WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
                if (WebSocketReader.this.isMasked) {
                    j2 = (long) WebSocketReader.this.source.read(WebSocketReader.this.maskBuffer, 0, (int) Math.min(min, (long) WebSocketReader.this.maskBuffer.length));
                    if (j2 != -1) {
                        WebSocketProtocol.toggleMask(WebSocketReader.this.maskBuffer, j2, WebSocketReader.this.maskKey, WebSocketReader.this.frameBytesRead);
                        buffer.write(WebSocketReader.this.maskBuffer, 0, (int) j2);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    j2 = WebSocketReader.this.source.read(buffer, min);
                    if (j2 == -1) {
                        throw new EOFException();
                    }
                }
                WebSocketReader.this.frameBytesRead += j2;
                return j2;
            } else {
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
        }

        @Override // okio.Source
        public o timeout() {
            return WebSocketReader.this.source.timeout();
        }
    }

    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback2) {
        Objects.requireNonNull(bufferedSource, "source == null");
        Objects.requireNonNull(frameCallback2, "frameCallback == null");
        this.isClient = z;
        this.source = bufferedSource;
        this.frameCallback = frameCallback2;
    }

    private void readControlFrame() throws IOException {
        Buffer buffer;
        String str;
        short s = 0;
        if (this.frameBytesRead < this.frameLength) {
            buffer = new Buffer();
            if (!this.isClient) {
                while (true) {
                    long j = this.frameBytesRead;
                    long j2 = this.frameLength;
                    if (j >= j2) {
                        break;
                    }
                    int read = this.source.read(this.maskBuffer, 0, (int) Math.min(j2 - j, (long) this.maskBuffer.length));
                    if (read != -1) {
                        long j3 = (long) read;
                        WebSocketProtocol.toggleMask(this.maskBuffer, j3, this.maskKey, this.frameBytesRead);
                        buffer.write(this.maskBuffer, 0, read);
                        this.frameBytesRead += j3;
                    } else {
                        throw new EOFException();
                    }
                }
            } else {
                this.source.readFully(buffer, this.frameLength);
            }
        } else {
            buffer = null;
        }
        switch (this.opcode) {
            case 8:
                if (buffer != null) {
                    s = buffer.readShort();
                    str = buffer.readUtf8();
                } else {
                    str = "";
                }
                this.frameCallback.onClose(s, str);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onPing(buffer);
                return;
            case 10:
                this.frameCallback.onPong(buffer);
                return;
            default:
                throw new IllegalStateException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    private void readHeader() throws IOException {
        if (!this.closed) {
            int readByte = this.source.readByte() & 255;
            this.opcode = readByte & 15;
            boolean z = true;
            boolean z2 = (readByte & 128) != 0;
            this.isFinalFrame = z2;
            boolean z3 = (readByte & 8) != 0;
            this.isControlFrame = z3;
            if (!z3 || z2) {
                boolean z4 = (readByte & 64) != 0;
                boolean z5 = (readByte & 32) != 0;
                boolean z6 = (readByte & 16) != 0;
                if (z4 || z5 || z6) {
                    throw new ProtocolException("Reserved flags are unsupported.");
                }
                int readByte2 = this.source.readByte() & 255;
                if ((readByte2 & 128) == 0) {
                    z = false;
                }
                this.isMasked = z;
                if (z != this.isClient) {
                    long j = (long) (readByte2 & 127);
                    this.frameLength = j;
                    if (j == 126) {
                        this.frameLength = ((long) this.source.readShort()) & 65535;
                    } else if (j == 127) {
                        long readLong = this.source.readLong();
                        this.frameLength = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    this.frameBytesRead = 0;
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (this.isMasked) {
                        this.source.readFully(this.maskKey);
                    }
                } else {
                    throw new ProtocolException("Client-sent frames must be masked. Server sent must not.");
                }
            } else {
                throw new ProtocolException("Control frames must be final.");
            }
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    private void readMessageFrame() throws IOException {
        WebSocket.PayloadType payloadType;
        int i = this.opcode;
        if (i == 1) {
            payloadType = WebSocket.PayloadType.TEXT;
        } else if (i == 2) {
            payloadType = WebSocket.PayloadType.BINARY;
        } else {
            throw new IllegalStateException("Unknown opcode: " + Integer.toHexString(this.opcode));
        }
        this.messageClosed = false;
        this.frameCallback.onMessage(h.d(this.framedMessageSource), payloadType);
        if (!this.messageClosed) {
            throw new IllegalStateException("Listener failed to call close on message payload.");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
