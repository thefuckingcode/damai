package com.opensource.svgaplayer.proto;

import com.youku.squareup.wire.FieldEncoding;
import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.ProtoReader;
import com.youku.squareup.wire.ProtoWriter;
import com.youku.squareup.wire.WireField;
import com.youku.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* compiled from: Taobao */
public final class MovieEntity extends Message<MovieEntity, a> {
    public static final ProtoAdapter<MovieEntity> ADAPTER = new b();
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.opensource.svgaplayer.proto.AudioEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<AudioEntity> audios;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, ByteString> images;
    @WireField(adapter = "com.opensource.svgaplayer.proto.MovieParams#ADAPTER", tag = 2)
    public final MovieParams params;
    @WireField(adapter = "com.opensource.svgaplayer.proto.SpriteEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<SpriteEntity> sprites;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String version;

    /* compiled from: Taobao */
    public static final class a extends Message.Builder<MovieEntity, a> {
        public String a;
        public MovieParams b;
        public Map<String, ByteString> c = Internal.newMutableMap();
        public List<SpriteEntity> d = Internal.newMutableList();
        public List<AudioEntity> e = Internal.newMutableList();

        /* renamed from: a */
        public MovieEntity build() {
            return new MovieEntity(this.a, this.b, this.c, this.d, this.e, super.buildUnknownFields());
        }

        public a b(MovieParams movieParams) {
            this.b = movieParams;
            return this;
        }

        public a c(String str) {
            this.a = str;
            return this;
        }
    }

    /* compiled from: Taobao */
    private static final class b extends ProtoAdapter<MovieEntity> {
        private final ProtoAdapter<Map<String, ByteString>> a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);

        b() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieEntity.class);
        }

        /* renamed from: a */
        public MovieEntity decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                } else if (nextTag == 1) {
                    aVar.c(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    aVar.b(MovieParams.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    aVar.c.putAll(this.a.decode(protoReader));
                } else if (nextTag == 4) {
                    aVar.d.add(SpriteEntity.ADAPTER.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    aVar.e.add(AudioEntity.ADAPTER.decode(protoReader));
                }
            }
        }

        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, MovieEntity movieEntity) throws IOException {
            String str = movieEntity.version;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            MovieParams movieParams = movieEntity.params;
            if (movieParams != null) {
                MovieParams.ADAPTER.encodeWithTag(protoWriter, 2, movieParams);
            }
            this.a.encodeWithTag(protoWriter, 3, movieEntity.images);
            SpriteEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, movieEntity.sprites);
            AudioEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, movieEntity.audios);
            protoWriter.writeBytes(movieEntity.unknownFields());
        }

        /* renamed from: c */
        public int encodedSize(MovieEntity movieEntity) {
            String str = movieEntity.version;
            int i = 0;
            int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
            MovieParams movieParams = movieEntity.params;
            if (movieParams != null) {
                i = MovieParams.ADAPTER.encodedSizeWithTag(2, movieParams);
            }
            return encodedSizeWithTag + i + this.a.encodedSizeWithTag(3, movieEntity.images) + SpriteEntity.ADAPTER.asRepeated().encodedSizeWithTag(4, movieEntity.sprites) + AudioEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, movieEntity.audios) + movieEntity.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.opensource.svgaplayer.proto.MovieEntity$a, com.youku.squareup.wire.Message$Builder] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: d */
        public MovieEntity redact(MovieEntity movieEntity) {
            ?? newBuilder = movieEntity.newBuilder();
            MovieParams movieParams = newBuilder.b;
            if (movieParams != null) {
                newBuilder.b = MovieParams.ADAPTER.redact(movieParams);
            }
            Internal.redactElements(newBuilder.d, SpriteEntity.ADAPTER);
            Internal.redactElements(newBuilder.e, AudioEntity.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2) {
        this(str, movieParams, map, list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MovieEntity)) {
            return false;
        }
        MovieEntity movieEntity = (MovieEntity) obj;
        if (!unknownFields().equals(movieEntity.unknownFields()) || !Internal.equals(this.version, movieEntity.version) || !Internal.equals(this.params, movieEntity.params) || !this.images.equals(movieEntity.images) || !this.sprites.equals(movieEntity.sprites) || !this.audios.equals(movieEntity.audios)) {
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
        String str = this.version;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        MovieParams movieParams = this.params;
        if (movieParams != null) {
            i2 = movieParams.hashCode();
        }
        int hashCode3 = ((((((hashCode2 + i2) * 37) + this.images.hashCode()) * 37) + this.sprites.hashCode()) * 37) + this.audios.hashCode();
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.params != null) {
            sb.append(", params=");
            sb.append(this.params);
        }
        if (!this.images.isEmpty()) {
            sb.append(", images=");
            sb.append(this.images);
        }
        if (!this.sprites.isEmpty()) {
            sb.append(", sprites=");
            sb.append(this.sprites);
        }
        if (!this.audios.isEmpty()) {
            sb.append(", audios=");
            sb.append(this.audios);
        }
        StringBuilder replace = sb.replace(0, 2, "MovieEntity{");
        replace.append('}');
        return replace.toString();
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = str;
        this.params = movieParams;
        this.images = Internal.immutableCopyOf("images", map);
        this.sprites = Internal.immutableCopyOf("sprites", list);
        this.audios = Internal.immutableCopyOf("audios", list2);
    }

    /* Return type fixed from 'com.opensource.svgaplayer.proto.MovieEntity$a' to match base method */
    @Override // com.youku.squareup.wire.Message
    public Message.Builder<MovieEntity, a> newBuilder() {
        a aVar = new a();
        aVar.a = this.version;
        aVar.b = this.params;
        aVar.c = Internal.copyOf("images", this.images);
        aVar.d = Internal.copyOf("sprites", this.sprites);
        aVar.e = Internal.copyOf("audios", this.audios);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
