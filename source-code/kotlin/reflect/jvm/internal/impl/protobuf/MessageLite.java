package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: Taobao */
public interface MessageLite extends MessageLiteOrBuilder {

    /* compiled from: Taobao */
    public interface Builder extends Cloneable, MessageLiteOrBuilder {
        MessageLite build();

        Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
