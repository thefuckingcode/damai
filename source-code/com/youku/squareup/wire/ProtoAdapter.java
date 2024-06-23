package com.youku.squareup.wire;

import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.WireField;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.h;

/* compiled from: Taobao */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL;
    public static final ProtoAdapter<ByteString> BYTES;
    public static final ProtoAdapter<Double> DOUBLE;
    public static final ProtoAdapter<Integer> FIXED32;
    public static final ProtoAdapter<Long> FIXED64;
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT;
    public static final ProtoAdapter<Integer> INT32;
    public static final ProtoAdapter<Long> INT64;
    public static final ProtoAdapter<Integer> SFIXED32;
    public static final ProtoAdapter<Long> SFIXED64;
    public static final ProtoAdapter<Integer> SINT32;
    public static final ProtoAdapter<Long> SINT64;
    public static final ProtoAdapter<String> STRING;
    public static final ProtoAdapter<Integer> UINT32;
    public static final ProtoAdapter<Long> UINT64;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    /* compiled from: Taobao */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        EnumConstantNotFoundException(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.value = i;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        MapEntryProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = protoAdapter;
            this.valueAdapter = protoAdapter2;
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            encode(protoWriter, (Map.Entry) ((Map.Entry) obj));
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
            return encodedSize((Map.Entry) ((Map.Entry) obj));
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader protoReader) {
            throw new UnsupportedOperationException();
        }

        public void encode(ProtoWriter protoWriter, Map.Entry<K, V> entry) throws IOException {
            this.keyAdapter.encodeWithTag(protoWriter, 1, entry.getKey());
            this.valueAdapter.encodeWithTag(protoWriter, 2, entry.getValue());
        }

        public int encodedSize(Map.Entry<K, V> entry) {
            return this.keyAdapter.encodedSizeWithTag(1, entry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, entry.getValue());
        }
    }

    /* compiled from: Taobao */
    private static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        MapProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter<>(protoAdapter, protoAdapter2);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            encode(protoWriter, (Map) ((Map) obj));
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) throws IOException {
            encodeWithTag(protoWriter, i, (Map) ((Map) obj));
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
            return encodedSize((Map) ((Map) obj));
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSizeWithTag(int i, Object obj) {
            return encodedSizeWithTag(i, (Map) ((Map) obj));
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object obj) {
            return redact((Map) ((Map) obj));
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader protoReader) throws IOException {
            long beginMessage = protoReader.beginMessage();
            K k = null;
            V v = null;
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    break;
                } else if (nextTag == 1) {
                    k = this.entryAdapter.keyAdapter.decode(protoReader);
                } else if (nextTag == 2) {
                    v = this.entryAdapter.valueAdapter.decode(protoReader);
                }
            }
            protoReader.endMessage(beginMessage);
            if (k == null) {
                throw new IllegalStateException("Map entry with null key");
            } else if (v != null) {
                return Collections.singletonMap(k, v);
            } else {
                throw new IllegalStateException("Map entry with null value");
            }
        }

        public void encode(ProtoWriter protoWriter, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public void encodeWithTag(ProtoWriter protoWriter, int i, Map<K, V> map) throws IOException {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                this.entryAdapter.encodeWithTag(protoWriter, i, entry);
            }
        }

        public int encodedSize(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        public int encodedSizeWithTag(int i, Map<K, V> map) {
            int i2 = 0;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                i2 += this.entryAdapter.encodedSizeWithTag(i, entry);
            }
            return i2;
        }

        public Map<K, V> redact(Map<K, V> map) {
            return Collections.emptyMap();
        }
    }

    static {
        FieldEncoding fieldEncoding2 = FieldEncoding.VARINT;
        BOOL = new ProtoAdapter<Boolean>(fieldEncoding2, Boolean.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass1 */

            public int encodedSize(Boolean bool) {
                return 1;
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Boolean decode(ProtoReader protoReader) throws IOException {
                int readVarint32 = protoReader.readVarint32();
                if (readVarint32 == 0) {
                    return Boolean.FALSE;
                }
                if (readVarint32 == 1) {
                    return Boolean.TRUE;
                }
                throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(readVarint32)));
            }

            public void encode(ProtoWriter protoWriter, Boolean bool) throws IOException {
                protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
            }
        };
        INT32 = new ProtoAdapter<Integer>(fieldEncoding2, Integer.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass2 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(protoReader.readVarint32());
            }

            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeSignedVarint32(num.intValue());
            }

            public int encodedSize(Integer num) {
                return ProtoWriter.int32Size(num.intValue());
            }
        };
        UINT32 = new ProtoAdapter<Integer>(fieldEncoding2, Integer.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass3 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(protoReader.readVarint32());
            }

            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeVarint32(num.intValue());
            }

            public int encodedSize(Integer num) {
                return ProtoWriter.varint32Size(num.intValue());
            }
        };
        SINT32 = new ProtoAdapter<Integer>(fieldEncoding2, Integer.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass4 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(ProtoWriter.decodeZigZag32(protoReader.readVarint32()));
            }

            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeVarint32(ProtoWriter.encodeZigZag32(num.intValue()));
            }

            public int encodedSize(Integer num) {
                return ProtoWriter.varint32Size(ProtoWriter.encodeZigZag32(num.intValue()));
            }
        };
        FieldEncoding fieldEncoding3 = FieldEncoding.FIXED32;
        AnonymousClass5 r2 = new ProtoAdapter<Integer>(fieldEncoding3, Integer.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass5 */

            public int encodedSize(Integer num) {
                return 4;
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(protoReader.readFixed32());
            }

            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeFixed32(num.intValue());
            }
        };
        FIXED32 = r2;
        SFIXED32 = r2;
        INT64 = new ProtoAdapter<Long>(fieldEncoding2, Long.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass6 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(protoReader.readVarint64());
            }

            public void encode(ProtoWriter protoWriter, Long l) throws IOException {
                protoWriter.writeVarint64(l.longValue());
            }

            public int encodedSize(Long l) {
                return ProtoWriter.varint64Size(l.longValue());
            }
        };
        UINT64 = new ProtoAdapter<Long>(fieldEncoding2, Long.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass7 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(protoReader.readVarint64());
            }

            public void encode(ProtoWriter protoWriter, Long l) throws IOException {
                protoWriter.writeVarint64(l.longValue());
            }

            public int encodedSize(Long l) {
                return ProtoWriter.varint64Size(l.longValue());
            }
        };
        SINT64 = new ProtoAdapter<Long>(fieldEncoding2, Long.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass8 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(ProtoWriter.decodeZigZag64(protoReader.readVarint64()));
            }

            public void encode(ProtoWriter protoWriter, Long l) throws IOException {
                protoWriter.writeVarint64(ProtoWriter.encodeZigZag64(l.longValue()));
            }

            public int encodedSize(Long l) {
                return ProtoWriter.varint64Size(ProtoWriter.encodeZigZag64(l.longValue()));
            }
        };
        FieldEncoding fieldEncoding4 = FieldEncoding.FIXED64;
        AnonymousClass9 r1 = new ProtoAdapter<Long>(fieldEncoding4, Long.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass9 */

            public int encodedSize(Long l) {
                return 8;
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(protoReader.readFixed64());
            }

            public void encode(ProtoWriter protoWriter, Long l) throws IOException {
                protoWriter.writeFixed64(l.longValue());
            }
        };
        FIXED64 = r1;
        SFIXED64 = r1;
        FLOAT = new ProtoAdapter<Float>(fieldEncoding3, Float.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass10 */

            public int encodedSize(Float f) {
                return 4;
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Float decode(ProtoReader protoReader) throws IOException {
                return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
            }

            public void encode(ProtoWriter protoWriter, Float f) throws IOException {
                protoWriter.writeFixed32(Float.floatToIntBits(f.floatValue()));
            }
        };
        DOUBLE = new ProtoAdapter<Double>(fieldEncoding4, Double.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass11 */

            public int encodedSize(Double d) {
                return 8;
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public Double decode(ProtoReader protoReader) throws IOException {
                return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
            }

            public void encode(ProtoWriter protoWriter, Double d) throws IOException {
                protoWriter.writeFixed64(Double.doubleToLongBits(d.doubleValue()));
            }
        };
        FieldEncoding fieldEncoding5 = FieldEncoding.LENGTH_DELIMITED;
        STRING = new ProtoAdapter<String>(fieldEncoding5, String.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass12 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public String decode(ProtoReader protoReader) throws IOException {
                return protoReader.readString();
            }

            public void encode(ProtoWriter protoWriter, String str) throws IOException {
                protoWriter.writeString(str);
            }

            public int encodedSize(String str) {
                return ProtoWriter.utf8Length(str);
            }
        };
        BYTES = new ProtoAdapter<ByteString>(fieldEncoding5, ByteString.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass13 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public ByteString decode(ProtoReader protoReader) throws IOException {
                return protoReader.readBytes();
            }

            public void encode(ProtoWriter protoWriter, ByteString byteString) throws IOException {
                protoWriter.writeBytes(byteString);
            }

            public int encodedSize(ByteString byteString) {
                return byteString.size();
            }
        };
    }

    public ProtoAdapter(FieldEncoding fieldEncoding2, Class<?> cls) {
        this.fieldEncoding = fieldEncoding2;
        this.javaType = cls;
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding fieldEncoding2 = this.fieldEncoding;
        FieldEncoding fieldEncoding3 = FieldEncoding.LENGTH_DELIMITED;
        if (fieldEncoding2 != fieldEncoding3) {
            return new ProtoAdapter<List<E>>(fieldEncoding3, List.class) {
                /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass14 */

                @Override // com.youku.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
                    encode(protoWriter, (List) ((List) obj));
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) throws IOException {
                    encodeWithTag(protoWriter, i, (List) ((List) obj));
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
                    return encodedSize((List) ((List) obj));
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSizeWithTag(int i, Object obj) {
                    return encodedSizeWithTag(i, (List) ((List) obj));
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Object redact(Object obj) {
                    return redact((List) ((List) obj));
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                public List<E> decode(ProtoReader protoReader) throws IOException {
                    return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
                }

                public void encode(ProtoWriter protoWriter, List<E> list) throws IOException {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ProtoAdapter.this.encode(protoWriter, list.get(i));
                    }
                }

                public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) throws IOException {
                    if (!list.isEmpty()) {
                        ProtoAdapter.super.encodeWithTag(protoWriter, i, (Object) list);
                    }
                }

                public int encodedSize(List<E> list) {
                    int size = list.size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        i += ProtoAdapter.this.encodedSize(list.get(i2));
                    }
                    return i;
                }

                public int encodedSizeWithTag(int i, List<E> list) {
                    if (list.isEmpty()) {
                        return 0;
                    }
                    return ProtoAdapter.super.encodedSizeWithTag(i, (Object) list);
                }

                public List<E> redact(List<E> list) {
                    return Collections.emptyList();
                }
            };
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        return new ProtoAdapter<List<E>>(this.fieldEncoding, List.class) {
            /* class com.youku.squareup.wire.ProtoAdapter.AnonymousClass15 */

            @Override // com.youku.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
                encode(protoWriter, (List) ((List) obj));
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) throws IOException {
                encodeWithTag(protoWriter, i, (List) ((List) obj));
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
                return encodedSize((List) ((List) obj));
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSizeWithTag(int i, Object obj) {
                return encodedSizeWithTag(i, (List) ((List) obj));
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Object redact(Object obj) {
                return redact((List) ((List) obj));
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            public List<E> decode(ProtoReader protoReader) throws IOException {
                return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
            }

            public void encode(ProtoWriter protoWriter, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) throws IOException {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ProtoAdapter.this.encodeWithTag(protoWriter, i, list.get(i2));
                }
            }

            public int encodedSize(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            public int encodedSizeWithTag(int i, List<E> list) {
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += ProtoAdapter.this.encodedSizeWithTag(i, list.get(i3));
                }
                return i2;
            }

            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }

    public static <M extends Message> ProtoAdapter<M> get(M m) {
        return get(m.getClass());
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return new RuntimeEnumAdapter<>(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return RuntimeMessageAdapter.create(cls);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createPacked = createPacked();
        this.packedAdapter = createPacked;
        return createPacked;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createRepeated = createRepeated();
        this.repeatedAdapter = createRepeated;
        return createRepeated;
    }

    public abstract E decode(ProtoReader protoReader) throws IOException;

    public final E decode(byte[] bArr) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes == null");
        return decode(new Buffer().write(bArr));
    }

    public abstract void encode(ProtoWriter protoWriter, E e) throws IOException;

    public final void encode(BufferedSink bufferedSink, E e) throws IOException {
        Preconditions.checkNotNull(e, "value == null");
        Preconditions.checkNotNull(bufferedSink, "sink == null");
        encode(new ProtoWriter(bufferedSink), e);
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, E e) throws IOException {
        if (e != null) {
            protoWriter.writeTag(i, this.fieldEncoding);
            if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
                protoWriter.writeVarint32(encodedSize(e));
            }
            encode(protoWriter, e);
        }
    }

    public abstract int encodedSize(E e);

    public int encodedSizeWithTag(int i, E e) {
        if (e == null) {
            return 0;
        }
        int encodedSize = encodedSize(e);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.varint32Size(encodedSize);
        }
        return encodedSize + ProtoWriter.tagSize(i);
    }

    public E redact(E e) {
        return null;
    }

    public String toString(E e) {
        return e.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.youku.squareup.wire.ProtoAdapter<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public ProtoAdapter<?> withLabel(WireField.Label label) {
        if (!label.isRepeated()) {
            return this;
        }
        if (label.isPacked()) {
            return asPacked();
        }
        return asRepeated();
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e);
        }
    }

    public final E decode(ByteString byteString) throws IOException {
        Preconditions.checkNotNull(byteString, "bytes == null");
        return decode(new Buffer().write(byteString));
    }

    public static ProtoAdapter<?> get(String str) {
        try {
            int indexOf = str.indexOf(35);
            String substring = str.substring(0, indexOf);
            return (ProtoAdapter) Class.forName(substring).getField(str.substring(indexOf + 1)).get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("failed to access " + str, e);
        }
    }

    public final byte[] encode(E e) {
        Preconditions.checkNotNull(e, "value == null");
        Buffer buffer = new Buffer();
        try {
            encode(buffer, e);
            return buffer.readByteArray();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E decode(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream, "stream == null");
        return decode(h.d(h.k(inputStream)));
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        Preconditions.checkNotNull(bufferedSource, "source == null");
        return decode(new ProtoReader(bufferedSource));
    }

    public final void encode(OutputStream outputStream, E e) throws IOException {
        Preconditions.checkNotNull(e, "value == null");
        Preconditions.checkNotNull(outputStream, "stream == null");
        BufferedSink c = h.c(h.g(outputStream));
        encode(c, e);
        c.emit();
    }
}
