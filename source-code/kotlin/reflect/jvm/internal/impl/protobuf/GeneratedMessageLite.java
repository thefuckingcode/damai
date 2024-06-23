package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* compiled from: Taobao */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* compiled from: Taobao */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            a = iArr;
            iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            a[WireFormat.JavaType.ENUM.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b implements FieldSet.FieldDescriptorLite<b> {
        final Internal.EnumLiteMap<?> a;
        final int b;
        final WireFormat.FieldType c;
        final boolean d;
        final boolean e;

        b(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.a = enumLiteMap;
            this.b = i;
            this.c = fieldType;
            this.d = z;
            this.e = z2;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            return this.b - bVar.b;
        }

        public Internal.EnumLiteMap<?> b() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.c.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    public static class c<ContainingType extends MessageLite, Type> {
        final ContainingType a;
        final Type b;
        final MessageLite c;
        final b d;
        final Method e;

        c(ContainingType containingtype, Type type, MessageLite messageLite, b bVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (bVar.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.a = containingtype;
                this.b = type;
                this.c = messageLite;
                this.d = bVar;
                if (Internal.EnumLite.class.isAssignableFrom(cls)) {
                    this.e = GeneratedMessageLite.getMethodOrDie(cls, "valueOf", Integer.TYPE);
                    return;
                }
                this.e = null;
            }
        }

        /* access modifiers changed from: package-private */
        public Object a(Object obj) {
            if (!this.d.isRepeated()) {
                return e(obj);
            }
            if (this.d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) obj) {
                arrayList.add(e(obj2));
            }
            return arrayList;
        }

        public ContainingType b() {
            return this.a;
        }

        public MessageLite c() {
            return this.c;
        }

        public int d() {
            return this.d.getNumber();
        }

        /* access modifiers changed from: package-private */
        public Object e(Object obj) {
            if (this.d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            return GeneratedMessageLite.invokeOrDie(this.e, null, (Integer) obj);
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return this.d.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }
    }

    protected GeneratedMessageLite() {
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            String name = cls.getName();
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(name.length() + 45 + valueOf.length());
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(valueOf);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <ContainingType extends MessageLite, Type> c<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new c<>(containingtype, Collections.emptyList(), messageLite, new b(enumLiteMap, i, fieldType, true, z), cls);
    }

    public static <ContainingType extends MessageLite, Type> c<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new c<>(containingtype, type, messageLite, new b(enumLiteMap, i, fieldType, false, false), cls);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, c cVar, int i) throws IOException {
        return codedInputStream.P(i, codedOutputStream);
    }

    /* compiled from: Taobao */
    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields = ByteString.EMPTY;

        protected Builder() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(ByteString byteString) {
            this.unknownFields = byteString;
            return this;
        }

        @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* compiled from: Taobao */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<b> extensions;

        /* access modifiers changed from: protected */
        /* compiled from: Taobao */
        public class a {
            private final Iterator<Map.Entry<b, Object>> a;
            private Map.Entry<b, Object> b;
            private final boolean c;

            /* synthetic */ a(ExtendableMessage extendableMessage, boolean z, a aVar) {
                this(z);
            }

            public void a(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<b, Object> entry = this.b;
                    if (entry != null && entry.getKey().getNumber() < i) {
                        b key = this.b.getKey();
                        if (!this.c || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                            FieldSet.z(key, this.b.getValue(), codedOutputStream);
                        } else {
                            codedOutputStream.f0(key.getNumber(), (MessageLite) this.b.getValue());
                        }
                        if (this.a.hasNext()) {
                            this.b = this.a.next();
                        } else {
                            this.b = null;
                        }
                    } else {
                        return;
                    }
                }
            }

            private a(boolean z) {
                Iterator<Map.Entry<b, Object>> p = ExtendableMessage.this.extensions.p();
                this.a = p;
                if (p.hasNext()) {
                    this.b = p.next();
                }
                this.c = z;
            }
        }

        protected ExtendableMessage() {
            this.extensions = FieldSet.t();
        }

        private void verifyExtensionContainingType(c<MessageType, ?> cVar) {
            if (cVar.b() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.n();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.k();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(c<MessageType, Type> cVar) {
            verifyExtensionContainingType(cVar);
            Object h = this.extensions.h(cVar.d);
            return h == null ? cVar.b : (Type) cVar.a(h);
        }

        public final <Type> int getExtensionCount(c<MessageType, List<Type>> cVar) {
            verifyExtensionContainingType(cVar);
            return this.extensions.j(cVar.d);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(c<MessageType, Type> cVar) {
            verifyExtensionContainingType(cVar);
            return this.extensions.m(cVar.d);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.q();
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.a newExtensionWriter() {
            return new a(this, false, null);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, c cVar, int i) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, codedOutputStream, cVar, i);
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        public final <Type> Type getExtension(c<MessageType, List<Type>> cVar, int i) {
            verifyExtensionContainingType(cVar);
            return (Type) cVar.e(this.extensions.i(cVar.d, i));
        }
    }

    protected GeneratedMessageLite(Builder builder) {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    public static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<b> fieldSet, MessageType messagetype, CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, c cVar, int i) throws IOException {
        boolean z;
        boolean z2;
        Object obj;
        MessageLite messageLite;
        int b2 = WireFormat.b(i);
        c b3 = cVar.b(messagetype, WireFormat.a(i));
        if (b3 != null) {
            if (b2 == FieldSet.l(b3.d.getLiteType(), false)) {
                z2 = false;
                z = false;
                if (z2) {
                    return codedInputStream.P(i, codedOutputStream);
                }
                if (z) {
                    int j = codedInputStream.j(codedInputStream.A());
                    if (b3.d.getLiteType() == WireFormat.FieldType.ENUM) {
                        while (codedInputStream.e() > 0) {
                            Internal.EnumLite findValueByNumber = b3.d.b().findValueByNumber(codedInputStream.n());
                            if (findValueByNumber == null) {
                                return true;
                            }
                            fieldSet.a(b3.d, b3.f(findValueByNumber));
                        }
                    } else {
                        while (codedInputStream.e() > 0) {
                            fieldSet.a(b3.d, FieldSet.u(codedInputStream, b3.d.getLiteType(), false));
                        }
                    }
                    codedInputStream.i(j);
                } else {
                    int i2 = a.a[b3.d.getLiteJavaType().ordinal()];
                    if (i2 == 1) {
                        MessageLite.Builder builder = null;
                        if (!b3.d.isRepeated() && (messageLite = (MessageLite) fieldSet.h(b3.d)) != null) {
                            builder = messageLite.toBuilder();
                        }
                        if (builder == null) {
                            builder = b3.c().newBuilderForType();
                        }
                        if (b3.d.getLiteType() == WireFormat.FieldType.GROUP) {
                            codedInputStream.r(b3.d(), builder, cVar);
                        } else {
                            codedInputStream.v(builder, cVar);
                        }
                        obj = builder.build();
                    } else if (i2 != 2) {
                        obj = FieldSet.u(codedInputStream, b3.d.getLiteType(), false);
                    } else {
                        int n = codedInputStream.n();
                        Internal.EnumLite findValueByNumber2 = b3.d.b().findValueByNumber(n);
                        if (findValueByNumber2 == null) {
                            codedOutputStream.o0(i);
                            codedOutputStream.y0(n);
                            return true;
                        }
                        obj = findValueByNumber2;
                    }
                    if (b3.d.isRepeated()) {
                        fieldSet.a(b3.d, b3.f(obj));
                    } else {
                        fieldSet.v(b3.d, b3.f(obj));
                    }
                }
                return true;
            }
            b bVar = b3.d;
            if (bVar.d && bVar.c.isPackable() && b2 == FieldSet.l(b3.d.getLiteType(), true)) {
                z2 = false;
                z = true;
                if (z2) {
                }
            }
        }
        z2 = true;
        z = false;
        if (z2) {
        }
    }

    /* compiled from: Taobao */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<b> extensions = FieldSet.g();
        private boolean extensionsIsMutable;

        protected ExtendableBuilder() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private FieldSet<b> buildExtensions() {
            this.extensions.q();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.clone();
                this.extensionsIsMutable = true;
            }
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.n();
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(MessageType messagetype) {
            ensureExtensionsIsMutable();
            this.extensions.r(((ExtendableMessage) messagetype).extensions);
        }

        @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }
}
