package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* access modifiers changed from: package-private */
/* compiled from: predefinedEnhancementInfo.kt */
public final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures = new LinkedHashMap();

    /* compiled from: predefinedEnhancementInfo.kt */
    public final class ClassEnhancementBuilder {
        private final String className;
        final /* synthetic */ SignatureEnhancementBuilder this$0;

        public ClassEnhancementBuilder(SignatureEnhancementBuilder signatureEnhancementBuilder, String str) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            this.this$0 = signatureEnhancementBuilder;
            this.className = str;
        }

        public final String getClassName() {
            return this.className;
        }

        public final void function(String str, Function1<? super FunctionEnhancementBuilder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
            Intrinsics.checkParameterIsNotNull(function1, "block");
            Map map = this.this$0.signatures;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(this, str);
            function1.invoke(functionEnhancementBuilder);
            Pair<String, PredefinedFunctionEnhancementInfo> build = functionEnhancementBuilder.build();
            map.put(build.getFirst(), build.getSecond());
        }

        /* compiled from: predefinedEnhancementInfo.kt */
        public final class FunctionEnhancementBuilder {
            private final String functionName;
            private final List<Pair<String, TypeEnhancementInfo>> parameters = new ArrayList();
            private Pair<String, TypeEnhancementInfo> returnType = TuplesKt.to("V", null);
            final /* synthetic */ ClassEnhancementBuilder this$0;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder classEnhancementBuilder, String str) {
                Intrinsics.checkParameterIsNotNull(str, "functionName");
                this.this$0 = classEnhancementBuilder;
                this.functionName = str;
            }

            public final void parameter(String str, JavaTypeQualifiers... javaTypeQualifiersArr) {
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkParameterIsNotNull(str, "type");
                Intrinsics.checkParameterIsNotNull(javaTypeQualifiersArr, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> list = this.parameters;
                if (javaTypeQualifiersArr.length == 0) {
                    typeEnhancementInfo = null;
                } else {
                    Iterable<IndexedValue> withIndex = ArraysKt.withIndex(javaTypeQualifiersArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
                    for (IndexedValue indexedValue : withIndex) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                    }
                    typeEnhancementInfo = new TypeEnhancementInfo(linkedHashMap);
                }
                list.add(TuplesKt.to(str, typeEnhancementInfo));
            }

            public final void returns(String str, JavaTypeQualifiers... javaTypeQualifiersArr) {
                Intrinsics.checkParameterIsNotNull(str, "type");
                Intrinsics.checkParameterIsNotNull(javaTypeQualifiersArr, "qualifiers");
                Iterable<IndexedValue> withIndex = ArraysKt.withIndex(javaTypeQualifiersArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
                for (IndexedValue indexedValue : withIndex) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                }
                this.returnType = TuplesKt.to(str, new TypeEnhancementInfo(linkedHashMap));
            }

            public final void returns(JvmPrimitiveType jvmPrimitiveType) {
                Intrinsics.checkParameterIsNotNull(jvmPrimitiveType, "type");
                this.returnType = TuplesKt.to(jvmPrimitiveType.getDesc(), null);
            }

            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                String className = this.this$0.getClassName();
                String str = this.functionName;
                List<Pair<String, TypeEnhancementInfo>> list = this.parameters;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next().getFirst());
                }
                String signature = signatureBuildingComponents.signature(className, signatureBuildingComponents.jvmDescriptor(str, arrayList, this.returnType.getFirst()));
                TypeEnhancementInfo second = this.returnType.getSecond();
                List<Pair<String, TypeEnhancementInfo>> list2 = this.parameters;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((TypeEnhancementInfo) it2.next().getSecond());
                }
                return TuplesKt.to(signature, new PredefinedFunctionEnhancementInfo(second, arrayList2));
            }
        }
    }

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }
}
