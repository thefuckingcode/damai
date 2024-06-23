package com.youku.squareup.wire;

import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.WireEnum;
import java.io.IOException;

/* compiled from: Taobao */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    protected EnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
    }

    /* access modifiers changed from: protected */
    public abstract E fromValue(int i);

    @Override // com.youku.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader protoReader) throws IOException {
        int readVarint32 = protoReader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, this.javaType);
    }

    public final void encode(ProtoWriter protoWriter, E e) throws IOException {
        protoWriter.writeVarint32(e.getValue());
    }

    public final int encodedSize(E e) {
        return ProtoWriter.varint32Size(e.getValue());
    }
}
