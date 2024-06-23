package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
public interface MessageLite extends MessageLiteOrBuilder {

    /* compiled from: Taobao */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        @Override // java.lang.Object
        Builder clone();

        boolean mergeDelimitedFrom(InputStream inputStream) throws IOException;

        boolean mergeDelimitedFrom(InputStream inputStream, g gVar) throws IOException;

        Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString byteString, g gVar) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream codedInputStream) throws IOException;

        Builder mergeFrom(CodedInputStream codedInputStream, g gVar) throws IOException;

        Builder mergeFrom(MessageLite messageLite);

        Builder mergeFrom(InputStream inputStream) throws IOException;

        Builder mergeFrom(InputStream inputStream, g gVar) throws IOException;

        Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2, g gVar) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, g gVar) throws InvalidProtocolBufferException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream outputStream) throws IOException;

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;

    void writeTo(OutputStream outputStream) throws IOException;
}
