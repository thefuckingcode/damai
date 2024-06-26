package com.opensource.svgaplayer.proto;

import com.youku.squareup.wire.FieldEncoding;
import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.ProtoReader;
import com.youku.squareup.wire.ProtoWriter;
import com.youku.squareup.wire.WireField;
import com.youku.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* compiled from: Taobao */
public final class Transform extends Message<Transform, a> {
    public static final ProtoAdapter<Transform> ADAPTER = new b();
    public static final Float DEFAULT_A;
    public static final Float DEFAULT_B;
    public static final Float DEFAULT_C;
    public static final Float DEFAULT_D;
    public static final Float DEFAULT_TX;
    public static final Float DEFAULT_TY;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float a;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float b;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float c;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float d;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    /* compiled from: Taobao */
    public static final class a extends Message.Builder<Transform, a> {
        public Float a;
        public Float b;
        public Float c;
        public Float d;
        public Float e;
        public Float f;

        public a a(Float f2) {
            this.a = f2;
            return this;
        }

        public a b(Float f2) {
            this.b = f2;
            return this;
        }

        /* renamed from: c */
        public Transform build() {
            return new Transform(this.a, this.b, this.c, this.d, this.e, this.f, super.buildUnknownFields());
        }

        public a d(Float f2) {
            this.c = f2;
            return this;
        }

        public a e(Float f2) {
            this.d = f2;
            return this;
        }

        public a f(Float f2) {
            this.e = f2;
            return this;
        }

        public a g(Float f2) {
            this.f = f2;
            return this;
        }
    }

    /* compiled from: Taobao */
    private static final class b extends ProtoAdapter<Transform> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
        }

        /* renamed from: a */
        public Transform decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.a(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 2:
                            aVar.b(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 3:
                            aVar.d(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 4:
                            aVar.e(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 5:
                            aVar.f(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 6:
                            aVar.g(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, Transform transform) throws IOException {
            Float f = transform.a;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f);
            }
            Float f2 = transform.b;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f2);
            }
            Float f3 = transform.c;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f3);
            }
            Float f4 = transform.d;
            if (f4 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f4);
            }
            Float f5 = transform.tx;
            if (f5 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 5, f5);
            }
            Float f6 = transform.ty;
            if (f6 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 6, f6);
            }
            protoWriter.writeBytes(transform.unknownFields());
        }

        /* renamed from: c */
        public int encodedSize(Transform transform) {
            Float f = transform.a;
            int i = 0;
            int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
            Float f2 = transform.b;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2) : 0);
            Float f3 = transform.c;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3) : 0);
            Float f4 = transform.d;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4) : 0);
            Float f5 = transform.tx;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f5) : 0);
            Float f6 = transform.ty;
            if (f6 != null) {
                i = ProtoAdapter.FLOAT.encodedSizeWithTag(6, f6);
            }
            return encodedSizeWithTag5 + i + transform.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.youku.squareup.wire.Message$Builder, com.opensource.svgaplayer.proto.Transform$a] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: d */
        public Transform redact(Transform transform) {
            ?? newBuilder = transform.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_A = valueOf;
        DEFAULT_B = valueOf;
        DEFAULT_C = valueOf;
        DEFAULT_D = valueOf;
        DEFAULT_TX = valueOf;
        DEFAULT_TY = valueOf;
    }

    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6) {
        this(f, f2, f3, f4, f5, f6, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Transform)) {
            return false;
        }
        Transform transform = (Transform) obj;
        if (!unknownFields().equals(transform.unknownFields()) || !Internal.equals(this.a, transform.a) || !Internal.equals(this.b, transform.b) || !Internal.equals(this.c, transform.c) || !Internal.equals(this.d, transform.d) || !Internal.equals(this.tx, transform.tx) || !Internal.equals(this.ty, transform.ty)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Float f = this.a;
        int i2 = 0;
        int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.b;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.c;
        int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.d;
        int hashCode5 = (hashCode4 + (f4 != null ? f4.hashCode() : 0)) * 37;
        Float f5 = this.tx;
        int hashCode6 = (hashCode5 + (f5 != null ? f5.hashCode() : 0)) * 37;
        Float f6 = this.ty;
        if (f6 != null) {
            i2 = f6.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a != null) {
            sb.append(", a=");
            sb.append(this.a);
        }
        if (this.b != null) {
            sb.append(", b=");
            sb.append(this.b);
        }
        if (this.c != null) {
            sb.append(", c=");
            sb.append(this.c);
        }
        if (this.d != null) {
            sb.append(", d=");
            sb.append(this.d);
        }
        if (this.tx != null) {
            sb.append(", tx=");
            sb.append(this.tx);
        }
        if (this.ty != null) {
            sb.append(", ty=");
            sb.append(this.ty);
        }
        StringBuilder replace = sb.replace(0, 2, "Transform{");
        replace.append('}');
        return replace.toString();
    }

    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
        super(ADAPTER, byteString);
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.tx = f5;
        this.ty = f6;
    }

    /* Return type fixed from 'com.opensource.svgaplayer.proto.Transform$a' to match base method */
    @Override // com.youku.squareup.wire.Message
    public Message.Builder<Transform, a> newBuilder() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = this.b;
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.tx;
        aVar.f = this.ty;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
