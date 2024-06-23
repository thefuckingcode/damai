package com.alibaba.gaiax.studio.third.socket.java_websocket.drafts;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketImpl;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.CloseHandshakeType;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.HandshakeState;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Role;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.IncompleteHandshakeException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidHandshakeException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.BinaryFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.ContinuousFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.DataFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.TextFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ClientHandshake;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ClientHandshakeBuilder;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.HandshakeBuilder;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.HandshakeImpl1Client;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.HandshakeImpl1Server;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.Handshakedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshake;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshakeBuilder;
import com.alibaba.gaiax.studio.third.socket.java_websocket.util.Charsetfunctions;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.orange.OConstant;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.net.SocketClient;

@Keep
/* compiled from: Taobao */
public abstract class Draft {
    protected Opcode continuousFrameType = null;
    protected Role role = null;

    public static ByteBuffer readLine(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == 13 && b2 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String readStringLine(ByteBuffer byteBuffer) {
        ByteBuffer readLine = readLine(byteBuffer);
        if (readLine == null) {
            return null;
        }
        return Charsetfunctions.stringAscii(readLine.array(), 0, readLine.limit());
    }

    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer byteBuffer, Role role2) throws InvalidHandshakeException {
        HandshakeBuilder handshakeBuilder;
        String readStringLine = readStringLine(byteBuffer);
        if (readStringLine != null) {
            String[] split = readStringLine.split(" ", 3);
            if (split.length == 3) {
                if (role2 == Role.CLIENT) {
                    handshakeBuilder = translateHandshakeHttpClient(split, readStringLine);
                } else {
                    handshakeBuilder = translateHandshakeHttpServer(split, readStringLine);
                }
                String readStringLine2 = readStringLine(byteBuffer);
                while (readStringLine2 != null && readStringLine2.length() > 0) {
                    String[] split2 = readStringLine2.split(":", 2);
                    if (split2.length == 2) {
                        if (handshakeBuilder.hasFieldValue(split2[0])) {
                            String str = split2[0];
                            handshakeBuilder.put(str, handshakeBuilder.getFieldValue(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            handshakeBuilder.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        readStringLine2 = readStringLine(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (readStringLine2 != null) {
                    return handshakeBuilder;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    private static HandshakeBuilder translateHandshakeHttpClient(String[] strArr, String str) throws InvalidHandshakeException {
        if (!OConstant.CODE_POINT_EXP_BIND_SERVICE.equals(strArr[1])) {
            throw new InvalidHandshakeException(String.format("Invalid status code received: %s Status line: %s", strArr[1], str));
        } else if ("HTTP/1.1".equalsIgnoreCase(strArr[0])) {
            HandshakeImpl1Server handshakeImpl1Server = new HandshakeImpl1Server();
            handshakeImpl1Server.setHttpStatus(Short.parseShort(strArr[1]));
            handshakeImpl1Server.setHttpStatusMessage(strArr[2]);
            return handshakeImpl1Server;
        } else {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", strArr[0], str));
        }
    }

    private static HandshakeBuilder translateHandshakeHttpServer(String[] strArr, String str) throws InvalidHandshakeException {
        if (!"GET".equalsIgnoreCase(strArr[0])) {
            throw new InvalidHandshakeException(String.format("Invalid request method received: %s Status line: %s", strArr[0], str));
        } else if ("HTTP/1.1".equalsIgnoreCase(strArr[2])) {
            HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
            handshakeImpl1Client.setResourceDescriptor(strArr[1]);
            return handshakeImpl1Client;
        } else {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", strArr[2], str));
        }
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException;

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException;

    /* access modifiers changed from: protected */
    public boolean basicAccept(Handshakedata handshakedata) {
        return handshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket") && handshakedata.getFieldValue(IRequestConst.CONNECTION).toLowerCase(Locale.ENGLISH).contains(LoginConstants.LOGIN_UPGRADE);
    }

    public int checkAlloc(int i) throws InvalidDataException {
        if (i >= 0) {
            return i;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public List<Framedata> continuousFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        DataFrame dataFrame;
        Opcode opcode2 = Opcode.BINARY;
        if (opcode == opcode2 || opcode == Opcode.TEXT) {
            if (this.continuousFrameType != null) {
                dataFrame = new ContinuousFrame();
            } else {
                this.continuousFrameType = opcode;
                if (opcode == opcode2) {
                    dataFrame = new BinaryFrame();
                } else {
                    dataFrame = opcode == Opcode.TEXT ? new TextFrame() : null;
                }
            }
            dataFrame.setPayload(byteBuffer);
            dataFrame.setFin(z);
            try {
                dataFrame.isValid();
                if (z) {
                    this.continuousFrameType = null;
                } else {
                    this.continuousFrameType = opcode;
                }
                return Collections.singletonList(dataFrame);
            } catch (InvalidDataException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
    }

    public abstract Draft copyInstance();

    public abstract ByteBuffer createBinaryFrame(Framedata framedata);

    public abstract List<Framedata> createFrames(String str, boolean z);

    public abstract List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z);

    @Deprecated
    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, Role role2) {
        return createHandshake(handshakedata);
    }

    public abstract CloseHandshakeType getCloseHandshakeType();

    public Role getRole() {
        return this.role;
    }

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException;

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException;

    public abstract void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException;

    /* access modifiers changed from: package-private */
    public int readVersion(Handshakedata handshakedata) {
        String fieldValue = handshakedata.getFieldValue("Sec-WebSocket-Version");
        if (fieldValue.length() > 0) {
            try {
                return new Integer(fieldValue.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract void reset();

    public void setParseMode(Role role2) {
        this.role = role2;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException;

    public Handshakedata translateHandshake(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return translateHandshakeHttp(byteBuffer, this.role);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata) {
        return createHandshake(handshakedata, true);
    }

    @Deprecated
    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, Role role2, boolean z) {
        return createHandshake(handshakedata, z);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, boolean z) {
        int i;
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).getResourceDescriptor());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((ServerHandshake) handshakedata).getHttpStatusMessage());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append(SocketClient.NETASCII_EOL);
        Iterator<String> iterateHttpFields = handshakedata.iterateHttpFields();
        while (iterateHttpFields.hasNext()) {
            String next = iterateHttpFields.next();
            String fieldValue = handshakedata.getFieldValue(next);
            sb.append(next);
            sb.append(": ");
            sb.append(fieldValue);
            sb.append(SocketClient.NETASCII_EOL);
        }
        sb.append(SocketClient.NETASCII_EOL);
        byte[] asciiBytes = Charsetfunctions.asciiBytes(sb.toString());
        byte[] content = z ? handshakedata.getContent() : null;
        if (content == null) {
            i = 0;
        } else {
            i = content.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i + asciiBytes.length);
        allocate.put(asciiBytes);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }
}
