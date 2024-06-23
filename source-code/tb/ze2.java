package tb;

import com.taobao.tcommon.core.BytesPool;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* compiled from: Taobao */
public class ze2 {
    /* JADX INFO: finally extract failed */
    public static pd0 a(InputStream inputStream, BytesPool bytesPool, int[] iArr) throws Exception {
        ye2 ye2 = new ye2(null, iArr[0], 0);
        try {
            b(inputStream, bytesPool, ye2);
            iArr[0] = ye2.b();
            return ye2.a();
        } catch (Throwable th) {
            iArr[0] = ye2.b();
            throw th;
        }
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:604)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:486)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:194)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067 A[Catch:{ all -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a  */
    public static void b(java.io.InputStream r10, com.taobao.tcommon.core.BytesPool r11, tb.ye2 r12) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ze2.b(java.io.InputStream, com.taobao.tcommon.core.BytesPool, tb.ye2):void");
    }
}
