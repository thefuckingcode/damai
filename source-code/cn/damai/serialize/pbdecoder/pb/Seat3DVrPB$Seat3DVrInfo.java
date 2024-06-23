package cn.damai.serialize.pbdecoder.pb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.g;
import java.io.IOException;
import java.util.Objects;

/* compiled from: Taobao */
public final class Seat3DVrPB$Seat3DVrInfo extends GeneratedMessageLite<Seat3DVrPB$Seat3DVrInfo, Builder> implements Seat3DVrPB$Seat3DVrInfoOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLOORID_FIELD_NUMBER = 2;
    public static final int FOV_FIELD_NUMBER = 3;
    public static final int HORIZONTAL_FIELD_NUMBER = 4;
    public static final int IMGHASH_FIELD_NUMBER = 8;
    public static final int IMG_FIELD_NUMBER = 6;
    public static final int SID_FIELD_NUMBER = 1;
    public static final int THUMB_FIELD_NUMBER = 7;
    public static final int VERTICAL_FIELD_NUMBER = 5;
    private static final Seat3DVrPB$Seat3DVrInfo l;
    private static volatile Parser<Seat3DVrPB$Seat3DVrInfo> m;
    private long d;
    private long e;
    private double f;
    private double g;
    private double h;
    private String i = "";
    private String j = "";
    private String k = "";

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.Builder<Seat3DVrPB$Seat3DVrInfo, Builder> implements Seat3DVrPB$Seat3DVrInfoOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearFloorId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1466757268")) {
                return (Builder) ipChange.ipc$dispatch("1466757268", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).S();
            return this;
        }

        public Builder clearFov() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-69549234")) {
                return (Builder) ipChange.ipc$dispatch("-69549234", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).T();
            return this;
        }

        public Builder clearHorizontal() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-969937173")) {
                return (Builder) ipChange.ipc$dispatch("-969937173", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).U();
            return this;
        }

        public Builder clearImg() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1721303912")) {
                return (Builder) ipChange.ipc$dispatch("-1721303912", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).V();
            return this;
        }

        public Builder clearImgHash() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "33611562")) {
                return (Builder) ipChange.ipc$dispatch("33611562", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).W();
            return this;
        }

        public Builder clearSid() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "932876205")) {
                return (Builder) ipChange.ipc$dispatch("932876205", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).X();
            return this;
        }

        public Builder clearThumb() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1304762405")) {
                return (Builder) ipChange.ipc$dispatch("1304762405", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).Y();
            return this;
        }

        public Builder clearVertical() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1315031847")) {
                return (Builder) ipChange.ipc$dispatch("-1315031847", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).Z();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public long getFloorId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1720344255")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getFloorId();
            }
            return ((Long) ipChange.ipc$dispatch("-1720344255", new Object[]{this})).longValue();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public double getFov() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-294539147")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getFov();
            }
            return ((Double) ipChange.ipc$dispatch("-294539147", new Object[]{this})).doubleValue();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public double getHorizontal() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-601051424")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getHorizontal();
            }
            return ((Double) ipChange.ipc$dispatch("-601051424", new Object[]{this})).doubleValue();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public String getImg() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-203458833")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImg();
            }
            return (String) ipChange.ipc$dispatch("-203458833", new Object[]{this});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public ByteString getImgBytes() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1025740578")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImgBytes();
            }
            return (ByteString) ipChange.ipc$dispatch("1025740578", new Object[]{this});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public String getImgHash() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2037246179")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImgHash();
            }
            return (String) ipChange.ipc$dispatch("-2037246179", new Object[]{this});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public ByteString getImgHashBytes() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1044476980")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImgHashBytes();
            }
            return (ByteString) ipChange.ipc$dispatch("1044476980", new Object[]{this});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public long getSid() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "71562458")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getSid();
            }
            return ((Long) ipChange.ipc$dispatch("71562458", new Object[]{this})).longValue();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public String getThumb() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "463148354")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getThumb();
            }
            return (String) ipChange.ipc$dispatch("463148354", new Object[]{this});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public ByteString getThumbBytes() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1229959663")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getThumbBytes();
            }
            return (ByteString) ipChange.ipc$dispatch("1229959663", new Object[]{this});
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public double getVertical() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1240813198")) {
                return ((Seat3DVrPB$Seat3DVrInfo) this.instance).getVertical();
            }
            return ((Double) ipChange.ipc$dispatch("1240813198", new Object[]{this})).doubleValue();
        }

        public Builder setFloorId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-272946725")) {
                return (Builder) ipChange.ipc$dispatch("-272946725", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).c0(j);
            return this;
        }

        public Builder setFov(double d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-592394917")) {
                return (Builder) ipChange.ipc$dispatch("-592394917", new Object[]{this, Double.valueOf(d)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).d0(d);
            return this;
        }

        public Builder setHorizontal(double d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1233635048")) {
                return (Builder) ipChange.ipc$dispatch("1233635048", new Object[]{this, Double.valueOf(d)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).e0(d);
            return this;
        }

        public Builder setImg(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-880373321")) {
                return (Builder) ipChange.ipc$dispatch("-880373321", new Object[]{this, str});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).f0(str);
            return this;
        }

        public Builder setImgBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2020439788")) {
                return (Builder) ipChange.ipc$dispatch("2020439788", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).g0(byteString);
            return this;
        }

        public Builder setImgHash(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2113994423")) {
                return (Builder) ipChange.ipc$dispatch("-2113994423", new Object[]{this, str});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).h0(str);
            return this;
        }

        public Builder setImgHashBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986387942")) {
                return (Builder) ipChange.ipc$dispatch("-986387942", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).i0(byteString);
            return this;
        }

        public Builder setSid(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1064528738")) {
                return (Builder) ipChange.ipc$dispatch("1064528738", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).j0(j);
            return this;
        }

        public Builder setThumb(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "815907524")) {
                return (Builder) ipChange.ipc$dispatch("815907524", new Object[]{this, str});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).k0(str);
            return this;
        }

        public Builder setThumbBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1286768831")) {
                return (Builder) ipChange.ipc$dispatch("1286768831", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).l0(byteString);
            return this;
        }

        public Builder setVertical(double d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1456742394")) {
                return (Builder) ipChange.ipc$dispatch("1456742394", new Object[]{this, Double.valueOf(d)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).m0(d);
            return this;
        }

        private Builder() {
            super(Seat3DVrPB$Seat3DVrInfo.l);
        }
    }

    static {
        Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo = new Seat3DVrPB$Seat3DVrInfo();
        l = seat3DVrPB$Seat3DVrInfo;
        seat3DVrPB$Seat3DVrInfo.q();
    }

    private Seat3DVrPB$Seat3DVrInfo() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void S() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-770912211")) {
            ipChange.ipc$dispatch("-770912211", new Object[]{this});
            return;
        }
        this.e = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void T() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890799463")) {
            ipChange.ipc$dispatch("1890799463", new Object[]{this});
            return;
        }
        this.f = 0.0d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void U() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1568969746")) {
            ipChange.ipc$dispatch("1568969746", new Object[]{this});
            return;
        }
        this.g = 0.0d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void V() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974393009")) {
            ipChange.ipc$dispatch("1974393009", new Object[]{this});
            return;
        }
        this.i = a0().getImg();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void W() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631214397")) {
            ipChange.ipc$dispatch("-631214397", new Object[]{this});
            return;
        }
        this.k = a0().getImgHash();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void X() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038066234")) {
            ipChange.ipc$dispatch("-2038066234", new Object[]{this});
            return;
        }
        this.d = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330816510")) {
            ipChange.ipc$dispatch("1330816510", new Object[]{this});
            return;
        }
        this.j = a0().getThumb();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608435136")) {
            ipChange.ipc$dispatch("608435136", new Object[]{this});
            return;
        }
        this.h = 0.0d;
    }

    public static Seat3DVrPB$Seat3DVrInfo a0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-742101330") ? (Seat3DVrPB$Seat3DVrInfo) ipChange.ipc$dispatch("-742101330", new Object[0]) : l;
    }

    public static Parser<Seat3DVrPB$Seat3DVrInfo> b0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1800467838") ? (Parser) ipChange.ipc$dispatch("-1800467838", new Object[0]) : l.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c0(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684318078")) {
            ipChange.ipc$dispatch("-684318078", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        this.e = j2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d0(double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1729384834")) {
            ipChange.ipc$dispatch("1729384834", new Object[]{this, Double.valueOf(d2)});
            return;
        }
        this.f = d2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e0(double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539766849")) {
            ipChange.ipc$dispatch("539766849", new Object[]{this, Double.valueOf(d2)});
            return;
        }
        this.g = d2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830671920")) {
            ipChange.ipc$dispatch("-830671920", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.i = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677468781")) {
            ipChange.ipc$dispatch("-1677468781", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.i = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373167842")) {
            ipChange.ipc$dispatch("373167842", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.k = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61674687")) {
            ipChange.ipc$dispatch("-61674687", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.k = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j0(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193638281")) {
            ipChange.ipc$dispatch("193638281", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        this.d = j2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419539299")) {
            ipChange.ipc$dispatch("-419539299", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.j = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91495514")) {
            ipChange.ipc$dispatch("-91495514", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.j = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m0(double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241029229")) {
            ipChange.ipc$dispatch("-241029229", new Object[]{this, Double.valueOf(d2)});
            return;
        }
        this.h = d2;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public long getFloorId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1350396310")) {
            return this.e;
        }
        return ((Long) ipChange.ipc$dispatch("-1350396310", new Object[]{this})).longValue();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public double getFov() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-560881122")) {
            return this.f;
        }
        return ((Double) ipChange.ipc$dispatch("-560881122", new Object[]{this})).doubleValue();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public double getHorizontal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-367903465")) {
            return this.g;
        }
        return ((Double) ipChange.ipc$dispatch("-367903465", new Object[]{this})).doubleValue();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public String getImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2144201830")) {
            return this.i;
        }
        return (String) ipChange.ipc$dispatch("2144201830", new Object[]{this});
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public ByteString getImgBytes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1045847989")) {
            return ByteString.copyFromUtf8(this.i);
        }
        return (ByteString) ipChange.ipc$dispatch("-1045847989", new Object[]{this});
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public String getImgHash() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-490014444")) {
            return this.k;
        }
        return (String) ipChange.ipc$dispatch("-490014444", new Object[]{this});
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public ByteString getImgHashBytes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "26790109")) {
            return ByteString.copyFromUtf8(this.k);
        }
        return (ByteString) ipChange.ipc$dispatch("26790109", new Object[]{this});
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1778137595")) {
            return ((Integer) ipChange.ipc$dispatch("1778137595", new Object[]{this})).intValue();
        }
        int i3 = this.c;
        if (i3 != -1) {
            return i3;
        }
        long j2 = this.d;
        if (j2 != 0) {
            i2 = 0 + CodedOutputStream.r(1, j2);
        }
        long j3 = this.e;
        if (j3 != 0) {
            i2 += CodedOutputStream.r(2, j3);
        }
        double d2 = this.f;
        if (d2 != 0.0d) {
            i2 += CodedOutputStream.f(3, d2);
        }
        double d3 = this.g;
        if (d3 != 0.0d) {
            i2 += CodedOutputStream.f(4, d3);
        }
        double d4 = this.h;
        if (d4 != 0.0d) {
            i2 += CodedOutputStream.f(5, d4);
        }
        if (!this.i.isEmpty()) {
            i2 += CodedOutputStream.m(6, getImg());
        }
        if (!this.j.isEmpty()) {
            i2 += CodedOutputStream.m(7, getThumb());
        }
        if (!this.k.isEmpty()) {
            i2 += CodedOutputStream.m(8, getImgHash());
        }
        this.c = i2;
        return i2;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public long getSid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-194779517")) {
            return this.d;
        }
        return ((Long) ipChange.ipc$dispatch("-194779517", new Object[]{this})).longValue();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public String getThumb() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1707215097")) {
            return this.j;
        }
        return (String) ipChange.ipc$dispatch("1707215097", new Object[]{this});
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public ByteString getThumbBytes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-996795176")) {
            return ByteString.copyFromUtf8(this.j);
        }
        return (ByteString) ipChange.ipc$dispatch("-996795176", new Object[]{this});
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public double getVertical() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-175702395")) {
            return this.h;
        }
        return ((Double) ipChange.ipc$dispatch("-175702395", new Object[]{this})).doubleValue();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object j(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "261418642")) {
            return ipChange.ipc$dispatch("261418642", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (a.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Seat3DVrPB$Seat3DVrInfo();
            case 2:
                return l;
            case 3:
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo = (Seat3DVrPB$Seat3DVrInfo) obj2;
                long j2 = this.d;
                boolean z2 = j2 != 0;
                long j3 = seat3DVrPB$Seat3DVrInfo.d;
                this.d = visitor.visitLong(z2, j2, j3 != 0, j3);
                long j4 = this.e;
                boolean z3 = j4 != 0;
                long j5 = seat3DVrPB$Seat3DVrInfo.e;
                this.e = visitor.visitLong(z3, j4, j5 != 0, j5);
                double d2 = this.f;
                boolean z4 = d2 != 0.0d;
                double d3 = seat3DVrPB$Seat3DVrInfo.f;
                this.f = visitor.visitDouble(z4, d2, d3 != 0.0d, d3);
                double d4 = this.g;
                boolean z5 = d4 != 0.0d;
                double d5 = seat3DVrPB$Seat3DVrInfo.g;
                this.g = visitor.visitDouble(z5, d4, d5 != 0.0d, d5);
                double d6 = this.h;
                boolean z6 = d6 != 0.0d;
                double d7 = seat3DVrPB$Seat3DVrInfo.h;
                this.h = visitor.visitDouble(z6, d6, d7 != 0.0d, d7);
                this.i = visitor.visitString(!this.i.isEmpty(), this.i, !seat3DVrPB$Seat3DVrInfo.i.isEmpty(), seat3DVrPB$Seat3DVrInfo.i);
                this.j = visitor.visitString(!this.j.isEmpty(), this.j, !seat3DVrPB$Seat3DVrInfo.j.isEmpty(), seat3DVrPB$Seat3DVrInfo.j);
                this.k = visitor.visitString(!this.k.isEmpty(), this.k, !seat3DVrPB$Seat3DVrInfo.k.isEmpty(), seat3DVrPB$Seat3DVrInfo.k);
                GeneratedMessageLite.g gVar = GeneratedMessageLite.g.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                g gVar2 = (g) obj2;
                while (!z) {
                    try {
                        int v = codedInputStream.v();
                        if (v != 0) {
                            if (v == 8) {
                                this.d = codedInputStream.x();
                            } else if (v == 16) {
                                this.e = codedInputStream.x();
                            } else if (v == 25) {
                                this.f = codedInputStream.k();
                            } else if (v == 33) {
                                this.g = codedInputStream.k();
                            } else if (v == 41) {
                                this.h = codedInputStream.k();
                            } else if (v == 50) {
                                this.i = codedInputStream.u();
                            } else if (v == 58) {
                                this.j = codedInputStream.u();
                            } else if (v == 66) {
                                this.k = codedInputStream.u();
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
                if (m == null) {
                    synchronized (Seat3DVrPB$Seat3DVrInfo.class) {
                        if (m == null) {
                            m = new GeneratedMessageLite.b(l);
                        }
                    }
                }
                return m;
            default:
                throw new UnsupportedOperationException();
        }
        return l;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631959004")) {
            ipChange.ipc$dispatch("631959004", new Object[]{this, codedOutputStream});
            return;
        }
        long j2 = this.d;
        if (j2 != 0) {
            codedOutputStream.G(1, j2);
        }
        long j3 = this.e;
        if (j3 != 0) {
            codedOutputStream.G(2, j3);
        }
        double d2 = this.f;
        if (d2 != 0.0d) {
            codedOutputStream.z(3, d2);
        }
        double d3 = this.g;
        if (d3 != 0.0d) {
            codedOutputStream.z(4, d3);
        }
        double d4 = this.h;
        if (d4 != 0.0d) {
            codedOutputStream.z(5, d4);
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.D(6, getImg());
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.D(7, getThumb());
        }
        if (!this.k.isEmpty()) {
            codedOutputStream.D(8, getImgHash());
        }
    }
}
