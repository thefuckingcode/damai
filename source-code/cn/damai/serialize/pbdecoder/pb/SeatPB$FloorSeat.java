package cn.damai.serialize.pbdecoder.pb;

import cn.damai.serialize.pbdecoder.pb.SeatPB$Seat;
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
public final class SeatPB$FloorSeat extends GeneratedMessageLite<SeatPB$FloorSeat, Builder> implements SeatPB$FloorSeatOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLOORID_FIELD_NUMBER = 1;
    public static final int SEATLIST_FIELD_NUMBER = 2;
    private static final SeatPB$FloorSeat g;
    private static volatile Parser<SeatPB$FloorSeat> h;
    private int d;
    private long e;
    private Internal.ProtobufList<SeatPB$Seat> f = GeneratedMessageLite.k();

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.Builder<SeatPB$FloorSeat, Builder> implements SeatPB$FloorSeatOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(b bVar) {
            this();
        }

        public Builder addAllSeatList(Iterable<? extends SeatPB$Seat> iterable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "706758440")) {
                return (Builder) ipChange.ipc$dispatch("706758440", new Object[]{this, iterable});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).K(iterable);
            return this;
        }

        public Builder addSeatList(SeatPB$Seat seatPB$Seat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-957089905")) {
                return (Builder) ipChange.ipc$dispatch("-957089905", new Object[]{this, seatPB$Seat});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).O(seatPB$Seat);
            return this;
        }

        public Builder clearFloorId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2015092072")) {
                return (Builder) ipChange.ipc$dispatch("2015092072", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).P();
            return this;
        }

        public Builder clearSeatList() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "754727456")) {
                return (Builder) ipChange.ipc$dispatch("754727456", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).Q();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public long getFloorId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1338058697")) {
                return ((SeatPB$FloorSeat) this.instance).getFloorId();
            }
            return ((Long) ipChange.ipc$dispatch("1338058697", new Object[]{this})).longValue();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public SeatPB$Seat getSeatList(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2047302163")) {
                return ((SeatPB$FloorSeat) this.instance).getSeatList(i);
            }
            return (SeatPB$Seat) ipChange.ipc$dispatch("-2047302163", new Object[]{this, Integer.valueOf(i)});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public int getSeatListCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1904792611")) {
                return ((SeatPB$FloorSeat) this.instance).getSeatListCount();
            }
            return ((Integer) ipChange.ipc$dispatch("1904792611", new Object[]{this})).intValue();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public List<SeatPB$Seat> getSeatListList() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-816772614")) {
                return Collections.unmodifiableList(((SeatPB$FloorSeat) this.instance).getSeatListList());
            }
            return (List) ipChange.ipc$dispatch("-816772614", new Object[]{this});
        }

        public Builder removeSeatList(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "751149072")) {
                return (Builder) ipChange.ipc$dispatch("751149072", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).T(i);
            return this;
        }

        public Builder setFloorId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-473530863")) {
                return (Builder) ipChange.ipc$dispatch("-473530863", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).U(j);
            return this;
        }

        public Builder setSeatList(int i, SeatPB$Seat seatPB$Seat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1925536723")) {
                return (Builder) ipChange.ipc$dispatch("1925536723", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).W(i, seatPB$Seat);
            return this;
        }

        private Builder() {
            super(SeatPB$FloorSeat.g);
        }

        public Builder addSeatList(int i, SeatPB$Seat seatPB$Seat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "10941010")) {
                return (Builder) ipChange.ipc$dispatch("10941010", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).M(i, seatPB$Seat);
            return this;
        }

        public Builder setSeatList(int i, SeatPB$Seat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-342218966")) {
                return (Builder) ipChange.ipc$dispatch("-342218966", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).V(i, builder);
            return this;
        }

        public Builder addSeatList(SeatPB$Seat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2093005082")) {
                return (Builder) ipChange.ipc$dispatch("-2093005082", new Object[]{this, builder});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).N(builder);
            return this;
        }

        public Builder addSeatList(int i, SeatPB$Seat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1351037271")) {
                return (Builder) ipChange.ipc$dispatch("-1351037271", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).L(i, builder);
            return this;
        }
    }

    static {
        SeatPB$FloorSeat seatPB$FloorSeat = new SeatPB$FloorSeat();
        g = seatPB$FloorSeat;
        seatPB$FloorSeat.q();
    }

    private SeatPB$FloorSeat() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K(Iterable<? extends SeatPB$Seat> iterable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1883703755")) {
            ipChange.ipc$dispatch("-1883703755", new Object[]{this, iterable});
            return;
        }
        R();
        AbstractMessageLite.a(iterable, this.f);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void L(int i, SeatPB$Seat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2080245214")) {
            ipChange.ipc$dispatch("-2080245214", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        R();
        this.f.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void M(int i, SeatPB$Seat seatPB$Seat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349309607")) {
            ipChange.ipc$dispatch("-349309607", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            return;
        }
        Objects.requireNonNull(seatPB$Seat);
        R();
        this.f.add(i, seatPB$Seat);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void N(SeatPB$Seat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737278217")) {
            ipChange.ipc$dispatch("-737278217", new Object[]{this, builder});
            return;
        }
        R();
        this.f.add(builder.build());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void O(SeatPB$Seat seatPB$Seat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450531026")) {
            ipChange.ipc$dispatch("-1450531026", new Object[]{this, seatPB$Seat});
            return;
        }
        Objects.requireNonNull(seatPB$Seat);
        R();
        this.f.add(seatPB$Seat);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void P() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285090635")) {
            ipChange.ipc$dispatch("-285090635", new Object[]{this});
            return;
        }
        this.e = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467710027")) {
            ipChange.ipc$dispatch("467710027", new Object[]{this});
            return;
        }
        this.f = GeneratedMessageLite.k();
    }

    private void R() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895916640")) {
            ipChange.ipc$dispatch("-895916640", new Object[]{this});
        } else if (!this.f.isModifiable()) {
            this.f = GeneratedMessageLite.r(this.f);
        }
    }

    public static Parser<SeatPB$FloorSeat> S() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1319412474") ? (Parser) ipChange.ipc$dispatch("1319412474", new Object[0]) : g.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void T(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954567323")) {
            ipChange.ipc$dispatch("954567323", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        R();
        this.f.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void U(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391551750")) {
            ipChange.ipc$dispatch("-391551750", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.e = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void V(int i, SeatPB$Seat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41399937")) {
            ipChange.ipc$dispatch("41399937", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        R();
        this.f.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void W(int i, SeatPB$Seat seatPB$Seat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922321080")) {
            ipChange.ipc$dispatch("922321080", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            return;
        }
        Objects.requireNonNull(seatPB$Seat);
        R();
        this.f.set(i, seatPB$Seat);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public long getFloorId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-371120910")) {
            return this.e;
        }
        return ((Long) ipChange.ipc$dispatch("-371120910", new Object[]{this})).longValue();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public SeatPB$Seat getSeatList(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-902429866")) {
            return this.f.get(i);
        }
        return (SeatPB$Seat) ipChange.ipc$dispatch("-902429866", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public int getSeatListCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1177121140")) {
            return this.f.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1177121140", new Object[]{this})).intValue();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public List<SeatPB$Seat> getSeatListList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1393547427")) {
            return this.f;
        }
        return (List) ipChange.ipc$dispatch("1393547427", new Object[]{this});
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141076877")) {
            return ((Integer) ipChange.ipc$dispatch("-2141076877", new Object[]{this})).intValue();
        }
        int i = this.c;
        if (i != -1) {
            return i;
        }
        long j = this.e;
        int r = j != 0 ? CodedOutputStream.r(1, j) + 0 : 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            r += CodedOutputStream.i(2, this.f.get(i2));
        }
        this.c = r;
        return r;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object j(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1905483510")) {
            return ipChange.ipc$dispatch("-1905483510", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (b.a[methodToInvoke.ordinal()]) {
            case 1:
                return new SeatPB$FloorSeat();
            case 2:
                return g;
            case 3:
                this.f.makeImmutable();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                SeatPB$FloorSeat seatPB$FloorSeat = (SeatPB$FloorSeat) obj2;
                long j = this.e;
                boolean z2 = j != 0;
                long j2 = seatPB$FloorSeat.e;
                this.e = visitor.visitLong(z2, j, j2 != 0, j2);
                this.f = visitor.visitList(this.f, seatPB$FloorSeat.f);
                if (visitor == GeneratedMessageLite.g.INSTANCE) {
                    this.d |= seatPB$FloorSeat.d;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                g gVar = (g) obj2;
                while (!z) {
                    try {
                        int v = codedInputStream.v();
                        if (v != 0) {
                            if (v == 8) {
                                this.e = codedInputStream.x();
                            } else if (v == 18) {
                                if (!this.f.isModifiable()) {
                                    this.f = GeneratedMessageLite.r(this.f);
                                }
                                this.f.add(codedInputStream.l(SeatPB$Seat.k0(), gVar));
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
                if (h == null) {
                    synchronized (SeatPB$FloorSeat.class) {
                        if (h == null) {
                            h = new GeneratedMessageLite.b(g);
                        }
                    }
                }
                return h;
            default:
                throw new UnsupportedOperationException();
        }
        return g;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853695900")) {
            ipChange.ipc$dispatch("-1853695900", new Object[]{this, codedOutputStream});
            return;
        }
        long j = this.e;
        if (j != 0) {
            codedOutputStream.G(1, j);
        }
        for (int i = 0; i < this.f.size(); i++) {
            codedOutputStream.B(2, this.f.get(i));
        }
    }
}
