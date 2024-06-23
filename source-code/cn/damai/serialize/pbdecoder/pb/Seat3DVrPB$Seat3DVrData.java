package cn.damai.serialize.pbdecoder.pb;

import cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.g;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
public final class Seat3DVrPB$Seat3DVrData extends GeneratedMessageLite<Seat3DVrPB$Seat3DVrData, Builder> implements Seat3DVrPB$Seat3DVrDataOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLOORSEATLIST_FIELD_NUMBER = 1;
    private static final Seat3DVrPB$Seat3DVrData e;
    private static volatile Parser<Seat3DVrPB$Seat3DVrData> f;
    private Internal.ProtobufList<Seat3DVrPB$FloorSeat3DVrInfo> d = GeneratedMessageLite.k();

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.Builder<Seat3DVrPB$Seat3DVrData, Builder> implements Seat3DVrPB$Seat3DVrDataOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder addAllFloorSeatList(Iterable<? extends Seat3DVrPB$FloorSeat3DVrInfo> iterable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "50473342")) {
                return (Builder) ipChange.ipc$dispatch("50473342", new Object[]{this, iterable});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).I(iterable);
            return this;
        }

        public Builder addFloorSeatList(Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1082533677")) {
                return (Builder) ipChange.ipc$dispatch("1082533677", new Object[]{this, seat3DVrPB$FloorSeat3DVrInfo});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).M(seat3DVrPB$FloorSeat3DVrInfo);
            return this;
        }

        public Builder clearFloorSeatList() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "252489836")) {
                return (Builder) ipChange.ipc$dispatch("252489836", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).N();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrDataOrBuilder
        public Seat3DVrPB$FloorSeat3DVrInfo getFloorSeatList(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2022414401")) {
                return ((Seat3DVrPB$Seat3DVrData) this.instance).getFloorSeatList(i);
            }
            return (Seat3DVrPB$FloorSeat3DVrInfo) ipChange.ipc$dispatch("2022414401", new Object[]{this, Integer.valueOf(i)});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrDataOrBuilder
        public int getFloorSeatListCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "825813549")) {
                return ((Seat3DVrPB$Seat3DVrData) this.instance).getFloorSeatListCount();
            }
            return ((Integer) ipChange.ipc$dispatch("825813549", new Object[]{this})).intValue();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrDataOrBuilder
        public List<Seat3DVrPB$FloorSeat3DVrInfo> getFloorSeatListList() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1196112252")) {
                return Collections.unmodifiableList(((Seat3DVrPB$Seat3DVrData) this.instance).getFloorSeatListList());
            }
            return (List) ipChange.ipc$dispatch("-1196112252", new Object[]{this});
        }

        public Builder removeFloorSeatList(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1482424594")) {
                return (Builder) ipChange.ipc$dispatch("1482424594", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).Q(i);
            return this;
        }

        public Builder setFloorSeatList(int i, Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1117937609")) {
                return (Builder) ipChange.ipc$dispatch("-1117937609", new Object[]{this, Integer.valueOf(i), seat3DVrPB$FloorSeat3DVrInfo});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).S(i, seat3DVrPB$FloorSeat3DVrInfo);
            return this;
        }

        private Builder() {
            super(Seat3DVrPB$Seat3DVrData.e);
        }

        public Builder addFloorSeatList(int i, Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1454051816")) {
                return (Builder) ipChange.ipc$dispatch("-1454051816", new Object[]{this, Integer.valueOf(i), seat3DVrPB$FloorSeat3DVrInfo});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).K(i, seat3DVrPB$FloorSeat3DVrInfo);
            return this;
        }

        public Builder setFloorSeatList(int i, Seat3DVrPB$FloorSeat3DVrInfo.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1024471808")) {
                return (Builder) ipChange.ipc$dispatch("1024471808", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).R(i, builder);
            return this;
        }

        public Builder addFloorSeatList(Seat3DVrPB$FloorSeat3DVrInfo.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1679123446")) {
                return (Builder) ipChange.ipc$dispatch("1679123446", new Object[]{this, builder});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).L(builder);
            return this;
        }

        public Builder addFloorSeatList(int i, Seat3DVrPB$FloorSeat3DVrInfo.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "663752673")) {
                return (Builder) ipChange.ipc$dispatch("663752673", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrData) this.instance).J(i, builder);
            return this;
        }
    }

    static {
        Seat3DVrPB$Seat3DVrData seat3DVrPB$Seat3DVrData = new Seat3DVrPB$Seat3DVrData();
        e = seat3DVrPB$Seat3DVrData;
        seat3DVrPB$Seat3DVrData.q();
    }

    private Seat3DVrPB$Seat3DVrData() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void I(Iterable<? extends Seat3DVrPB$FloorSeat3DVrInfo> iterable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566948063")) {
            ipChange.ipc$dispatch("-1566948063", new Object[]{this, iterable});
            return;
        }
        O();
        AbstractMessageLite.a(iterable, this.d);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void J(int i, Seat3DVrPB$FloorSeat3DVrInfo.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533106564")) {
            ipChange.ipc$dispatch("1533106564", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        O();
        this.d.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K(int i, Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942942533")) {
            ipChange.ipc$dispatch("-942942533", new Object[]{this, Integer.valueOf(i), seat3DVrPB$FloorSeat3DVrInfo});
            return;
        }
        Objects.requireNonNull(seat3DVrPB$FloorSeat3DVrInfo);
        O();
        this.d.add(i, seat3DVrPB$FloorSeat3DVrInfo);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void L(Seat3DVrPB$FloorSeat3DVrInfo.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952954421")) {
            ipChange.ipc$dispatch("-1952954421", new Object[]{this, builder});
            return;
        }
        O();
        this.d.add(builder.build());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void M(Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241711614")) {
            ipChange.ipc$dispatch("-1241711614", new Object[]{this, seat3DVrPB$FloorSeat3DVrInfo});
            return;
        }
        Objects.requireNonNull(seat3DVrPB$FloorSeat3DVrInfo);
        O();
        this.d.add(seat3DVrPB$FloorSeat3DVrInfo);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1747302207")) {
            ipChange.ipc$dispatch("-1747302207", new Object[]{this});
            return;
        }
        this.d = GeneratedMessageLite.k();
    }

    private void O() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587763960")) {
            ipChange.ipc$dispatch("587763960", new Object[]{this});
        } else if (!this.d.isModifiable()) {
            this.d = GeneratedMessageLite.r(this.d);
        }
    }

    public static Seat3DVrPB$Seat3DVrData P(byte[] bArr) throws InvalidProtocolBufferException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1476396804")) {
            return (Seat3DVrPB$Seat3DVrData) GeneratedMessageLite.t(e, bArr);
        }
        return (Seat3DVrPB$Seat3DVrData) ipChange.ipc$dispatch("-1476396804", new Object[]{bArr});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Q(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1732535079")) {
            ipChange.ipc$dispatch("1732535079", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        O();
        this.d.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void R(int i, Seat3DVrPB$FloorSeat3DVrInfo.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493824675")) {
            ipChange.ipc$dispatch("1493824675", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        O();
        this.d.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void S(int i, Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-806027046")) {
            ipChange.ipc$dispatch("-806027046", new Object[]{this, Integer.valueOf(i), seat3DVrPB$FloorSeat3DVrInfo});
            return;
        }
        Objects.requireNonNull(seat3DVrPB$FloorSeat3DVrInfo);
        O();
        this.d.set(i, seat3DVrPB$FloorSeat3DVrInfo);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrDataOrBuilder
    public Seat3DVrPB$FloorSeat3DVrInfo getFloorSeatList(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-717962006")) {
            return this.d.get(i);
        }
        return (Seat3DVrPB$FloorSeat3DVrInfo) ipChange.ipc$dispatch("-717962006", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrDataOrBuilder
    public int getFloorSeatListCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "646059364")) {
            return this.d.size();
        }
        return ((Integer) ipChange.ipc$dispatch("646059364", new Object[]{this})).intValue();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrDataOrBuilder
    public List<Seat3DVrPB$FloorSeat3DVrInfo> getFloorSeatListList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1664779643")) {
            return this.d;
        }
        return (List) ipChange.ipc$dispatch("1664779643", new Object[]{this});
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1511255169")) {
            return ((Integer) ipChange.ipc$dispatch("-1511255169", new Object[]{this})).intValue();
        }
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            i2 += CodedOutputStream.i(1, this.d.get(i3));
        }
        this.c = i2;
        return i2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object j(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1820099350")) {
            return ipChange.ipc$dispatch("1820099350", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (a.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Seat3DVrPB$Seat3DVrData();
            case 2:
                return e;
            case 3:
                this.d.makeImmutable();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                this.d = ((GeneratedMessageLite.Visitor) obj).visitList(this.d, ((Seat3DVrPB$Seat3DVrData) obj2).d);
                GeneratedMessageLite.g gVar = GeneratedMessageLite.g.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                g gVar2 = (g) obj2;
                while (!z) {
                    try {
                        int v = codedInputStream.v();
                        if (v != 0) {
                            if (v == 10) {
                                if (!this.d.isModifiable()) {
                                    this.d = GeneratedMessageLite.r(this.d);
                                }
                                this.d.add(codedInputStream.l(Seat3DVrPB$FloorSeat3DVrInfo.S(), gVar2));
                            } else if (!codedInputStream.A(v)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f == null) {
                    synchronized (Seat3DVrPB$Seat3DVrData.class) {
                        if (f == null) {
                            f = new GeneratedMessageLite.b(e);
                        }
                    }
                }
                return f;
            default:
                throw new UnsupportedOperationException();
        }
        return e;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164037416")) {
            ipChange.ipc$dispatch("-1164037416", new Object[]{this, codedOutputStream});
            return;
        }
        for (int i = 0; i < this.d.size(); i++) {
            codedOutputStream.B(1, this.d.get(i));
        }
    }
}
