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
public final class AudioEntity extends Message<AudioEntity, a> {
    public static final ProtoAdapter<AudioEntity> ADAPTER = new b();
    public static final String DEFAULT_AUDIOKEY = "";
    public static final Integer DEFAULT_ENDFRAME = 0;
    public static final Integer DEFAULT_STARTFRAME = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_TOTALTIME = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String audioKey;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer endFrame;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer startFrame;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer startTime;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer totalTime;

    /* compiled from: Taobao */
    public static final class a extends Message.Builder<AudioEntity, a> {
        public String a;
        public Integer b;
        public Integer c;
        public Integer d;
        public Integer e;

        public a a(String str) {
            this.a = str;
            return this;
        }

        /* renamed from: b */
        public AudioEntity build() {
            return new AudioEntity(this.a, this.b, this.c, this.d, this.e, super.buildUnknownFields());
        }

        public a c(Integer num) {
            this.c = num;
            return this;
        }

        public a d(Integer num) {
            this.b = num;
            return this;
        }

        public a e(Integer num) {
            this.d = num;
            return this;
        }

        public a f(Integer num) {
            this.e = num;
            return this;
        }
    }

    /* compiled from: Taobao */
    private static final class b extends ProtoAdapter<AudioEntity> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, AudioEntity.class);
        }

        /* renamed from: a */
        public AudioEntity decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                } else if (nextTag == 1) {
                    aVar.a(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    aVar.d(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 3) {
                    aVar.c(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 4) {
                    aVar.e(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    aVar.f(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, AudioEntity audioEntity) throws IOException {
            String str = audioEntity.audioKey;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            Integer num = audioEntity.startFrame;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, num);
            }
            Integer num2 = audioEntity.endFrame;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, num2);
            }
            Integer num3 = audioEntity.startTime;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, num3);
            }
            Integer num4 = audioEntity.totalTime;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, num4);
            }
            protoWriter.writeBytes(audioEntity.unknownFields());
        }

        /* renamed from: c */
        public int encodedSize(AudioEntity audioEntity) {
            String str = audioEntity.audioKey;
            int i = 0;
            int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
            Integer num = audioEntity.startFrame;
            int encodedSizeWithTag2 = encodedSizeWithTag + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, num) : 0);
            Integer num2 = audioEntity.endFrame;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num2) : 0);
            Integer num3 = audioEntity.startTime;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, num3) : 0);
            Integer num4 = audioEntity.totalTime;
            if (num4 != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(5, num4);
            }
            return encodedSizeWithTag4 + i + audioEntity.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.opensource.svgaplayer.proto.AudioEntity$a, com.youku.squareup.wire.Message$Builder] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: d */
        public AudioEntity redact(AudioEntity audioEntity) {
            ?? newBuilder = audioEntity.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this(str, num, num2, num3, num4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioEntity)) {
            return false;
        }
        AudioEntity audioEntity = (AudioEntity) obj;
        if (!unknownFields().equals(audioEntity.unknownFields()) || !Internal.equals(this.audioKey, audioEntity.audioKey) || !Internal.equals(this.startFrame, audioEntity.startFrame) || !Internal.equals(this.endFrame, audioEntity.endFrame) || !Internal.equals(this.startTime, audioEntity.startTime) || !Internal.equals(this.totalTime, audioEntity.totalTime)) {
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
        String str = this.audioKey;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.startFrame;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.endFrame;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.startTime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.totalTime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.audioKey != null) {
            sb.append(", audioKey=");
            sb.append(this.audioKey);
        }
        if (this.startFrame != null) {
            sb.append(", startFrame=");
            sb.append(this.startFrame);
        }
        if (this.endFrame != null) {
            sb.append(", endFrame=");
            sb.append(this.endFrame);
        }
        if (this.startTime != null) {
            sb.append(", startTime=");
            sb.append(this.startTime);
        }
        if (this.totalTime != null) {
            sb.append(", totalTime=");
            sb.append(this.totalTime);
        }
        StringBuilder replace = sb.replace(0, 2, "AudioEntity{");
        replace.append('}');
        return replace.toString();
    }

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.audioKey = str;
        this.startFrame = num;
        this.endFrame = num2;
        this.startTime = num3;
        this.totalTime = num4;
    }

    /* Return type fixed from 'com.opensource.svgaplayer.proto.AudioEntity$a' to match base method */
    @Override // com.youku.squareup.wire.Message
    public Message.Builder<AudioEntity, a> newBuilder() {
        a aVar = new a();
        aVar.a = this.audioKey;
        aVar.b = this.startFrame;
        aVar.c = this.endFrame;
        aVar.d = this.startTime;
        aVar.e = this.totalTime;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
