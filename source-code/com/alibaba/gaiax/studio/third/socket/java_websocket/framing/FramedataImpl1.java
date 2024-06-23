package com.alibaba.gaiax.studio.third.socket.java_websocket.framing;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.util.ByteBufferUtils;
import java.nio.ByteBuffer;

@Keep
/* compiled from: Taobao */
public abstract class FramedataImpl1 implements Framedata {
    private boolean fin = true;
    private Opcode optcode;
    private boolean rsv1 = false;
    private boolean rsv2 = false;
    private boolean rsv3 = false;
    private boolean transferemasked = false;
    private ByteBuffer unmaskedpayload = ByteBufferUtils.getEmptyByteBuffer();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[Opcode.values().length];
            a = iArr;
            iArr[Opcode.PING.ordinal()] = 1;
            a[Opcode.PONG.ordinal()] = 2;
            a[Opcode.TEXT.ordinal()] = 3;
            a[Opcode.BINARY.ordinal()] = 4;
            a[Opcode.CLOSING.ordinal()] = 5;
            try {
                a[Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public FramedataImpl1(Opcode opcode) {
        this.optcode = opcode;
    }

    public static FramedataImpl1 get(Opcode opcode) {
        if (opcode != null) {
            switch (a.a[opcode.ordinal()]) {
                case 1:
                    return new PingFrame();
                case 2:
                    return new PongFrame();
                case 3:
                    return new TextFrame();
                case 4:
                    return new BinaryFrame();
                case 5:
                    return new CloseFrame();
                case 6:
                    return new ContinuousFrame();
                default:
                    throw new IllegalArgumentException("Supplied opcode is invalid");
            }
        } else {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public void append(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        if (this.unmaskedpayload == null) {
            this.unmaskedpayload = ByteBuffer.allocate(payloadData.remaining());
            payloadData.mark();
            this.unmaskedpayload.put(payloadData);
            payloadData.reset();
        } else {
            payloadData.mark();
            ByteBuffer byteBuffer = this.unmaskedpayload;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.unmaskedpayload;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (payloadData.remaining() > this.unmaskedpayload.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(payloadData.remaining() + this.unmaskedpayload.capacity());
                this.unmaskedpayload.flip();
                allocate.put(this.unmaskedpayload);
                allocate.put(payloadData);
                this.unmaskedpayload = allocate;
            } else {
                this.unmaskedpayload.put(payloadData);
            }
            this.unmaskedpayload.rewind();
            payloadData.reset();
        }
        this.fin = framedata.isFin();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FramedataImpl1 framedataImpl1 = (FramedataImpl1) obj;
        if (this.fin != framedataImpl1.fin || this.transferemasked != framedataImpl1.transferemasked || this.rsv1 != framedataImpl1.rsv1 || this.rsv2 != framedataImpl1.rsv2 || this.rsv3 != framedataImpl1.rsv3 || this.optcode != framedataImpl1.optcode) {
            return false;
        }
        ByteBuffer byteBuffer = this.unmaskedpayload;
        ByteBuffer byteBuffer2 = framedataImpl1.unmaskedpayload;
        if (byteBuffer != null) {
            return byteBuffer.equals(byteBuffer2);
        }
        if (byteBuffer2 == null) {
            return true;
        }
        return false;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public Opcode getOpcode() {
        return this.optcode;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public ByteBuffer getPayloadData() {
        return this.unmaskedpayload;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public boolean getTransfereMasked() {
        return this.transferemasked;
    }

    public int hashCode() {
        int hashCode = (((this.fin ? 1 : 0) * 31) + this.optcode.hashCode()) * 31;
        ByteBuffer byteBuffer = this.unmaskedpayload;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.transferemasked ? 1 : 0)) * 31) + (this.rsv1 ? 1 : 0)) * 31) + (this.rsv2 ? 1 : 0)) * 31) + (this.rsv3 ? 1 : 0);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public boolean isFin() {
        return this.fin;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public boolean isRSV1() {
        return this.rsv1;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public boolean isRSV2() {
        return this.rsv2;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata
    public boolean isRSV3() {
        return this.rsv3;
    }

    public abstract void isValid() throws InvalidDataException;

    public void setFin(boolean z) {
        this.fin = z;
    }

    public void setPayload(ByteBuffer byteBuffer) {
        this.unmaskedpayload = byteBuffer;
    }

    public void setRSV1(boolean z) {
        this.rsv1 = z;
    }

    public void setRSV2(boolean z) {
        this.rsv2 = z;
    }

    public void setRSV3(boolean z) {
        this.rsv3 = z;
    }

    public void setTransferemasked(boolean z) {
        this.transferemasked = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ optcode:");
        sb.append(getOpcode());
        sb.append(", fin:");
        sb.append(isFin());
        sb.append(", rsv1:");
        sb.append(isRSV1());
        sb.append(", rsv2:");
        sb.append(isRSV2());
        sb.append(", rsv3:");
        sb.append(isRSV3());
        sb.append(", payloadlength:[pos:");
        sb.append(this.unmaskedpayload.position());
        sb.append(", len:");
        sb.append(this.unmaskedpayload.remaining());
        sb.append("], payload:");
        sb.append(this.unmaskedpayload.remaining() > 1000 ? "(too big to display)" : new String(this.unmaskedpayload.array()));
        sb.append('}');
        return sb.toString();
    }
}
