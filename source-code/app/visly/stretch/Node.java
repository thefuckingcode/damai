package app.visly.stretch;

import androidx.annotation.Keep;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ob2;
import tb.r61;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 A2\u00020\u0001:\u0001BB)\b\u0016\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u0010\u0004\u001a\u00020%\u0012\u0006\u0010\t\u001a\u00020;¢\u0006\u0004\b=\u0010>B/\b\u0016\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u0010\u0004\u001a\u00020%\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\"¢\u0006\u0004\b=\u0010?B!\b\u0016\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u0010\u0004\u001a\u00020%¢\u0006\u0004\b=\u0010@J!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H J!\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH J\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H J!\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH J!\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H J!\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H J)\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0002H J!\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H J!\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H J!\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H J\u0019\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H J\u0019\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H J)\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH J\u0006\u0010!\u001a\u00020\fJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\"J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010&\u001a\u00020%J\u000e\u0010'\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020%J\u0006\u0010(\u001a\u00020\fJ\u0016\u0010,\u001a\u00020+2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0)J\b\u0010.\u001a\u00020-H\u0016J\u0006\u0010/\u001a\u00020\fR\u0019\u00100\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u00104\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0004\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u00108R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u0000098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010:R\u0018\u0010\t\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010<¨\u0006C"}, d2 = {"Lapp/visly/stretch/Node;", "", "", "stretch", "style", "", RichTextNode.CHILDREN, "nConstruct", "Lapp/visly/stretch/MeasureFuncImpl;", "measure", "nConstructLeaf", "ptr", "Ltb/ur2;", "nFree", "nSetMeasure", "nSetChildren", "child", "nAddChild", "", "index", "nReplaceChildAtIndex", "nRemoveChild", "nRemoveChildAtIndex", "args", "", "nSetStyle", "nIsDirty", "nMarkDirty", "", "width", "height", "", "nComputeLayout", "safeFree", "", "getChildren", "addChild", "Lapp/visly/stretch/Style;", "getStyle", "setStyle", "markDirty", "Ltb/ob2;", "size", "Ltb/r61;", "computeLayout", "", "toString", "markDirtyAll", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "idPath", "getIdPath", "rustptr", "J", "Lapp/visly/stretch/Style;", "", "Ljava/util/List;", "Lapp/visly/stretch/MeasureFunc;", "Lapp/visly/stretch/MeasureFunc;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lapp/visly/stretch/Style;Lapp/visly/stretch/MeasureFunc;)V", "(Ljava/lang/String;Ljava/lang/String;Lapp/visly/stretch/Style;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Lapp/visly/stretch/Style;)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class Node {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private List<Node> children;
    @NotNull
    private final String id;
    @NotNull
    private final String idPath;
    @Nullable
    private MeasureFunc measure;
    private long rustptr;
    @NotNull
    private Style style;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        Stretch.Companion.b();
    }

    public Node(@NotNull String str, @NotNull String str2, @NotNull Style style2, @NotNull MeasureFunc measureFunc) {
        k21.i(str, "id");
        k21.i(str2, "idPath");
        k21.i(style2, "style");
        k21.i(measureFunc, "measure");
        synchronized (Stretch.class) {
            this.id = str;
            this.idPath = str2;
            this.rustptr = nConstructLeaf(Stretch.Companion.a(), style2.getRustptr(), new MeasureFuncImpl(new WeakReference(measureFunc)));
            this.style = style2;
            this.children = new ArrayList();
            this.measure = measureFunc;
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    private final native void nAddChild(long j, long j2, long j3);

    private final native float[] nComputeLayout(long j, long j2, float f, float f2);

    private final native long nConstruct(long j, long j2, long[] jArr);

    private final native long nConstructLeaf(long j, long j2, MeasureFuncImpl measureFuncImpl);

    private final native void nFree(long j, long j2);

    private final native boolean nIsDirty(long j, long j2);

    private final native void nMarkDirty(long j, long j2);

    private final native long nRemoveChild(long j, long j2, long j3);

    private final native long nRemoveChildAtIndex(long j, long j2, int i);

    private final native long nReplaceChildAtIndex(long j, long j2, int i, long j3);

    private final native void nSetChildren(long j, long j2, long[] jArr);

    private final native void nSetMeasure(long j, long j2, MeasureFuncImpl measureFuncImpl);

    private final native boolean nSetStyle(long j, long j2, long j3);

    public final void addChild(@NotNull Node node) {
        k21.i(node, "child");
        synchronized (Stretch.class) {
            nAddChild(Stretch.Companion.a(), this.rustptr, node.rustptr);
            this.children.add(node);
        }
    }

    @NotNull
    public final r61 computeLayout(@NotNull ob2<Float> ob2) {
        r61 second;
        k21.i(ob2, "size");
        synchronized (Stretch.class) {
            long a2 = Stretch.Companion.a();
            long j = this.rustptr;
            Float b = ob2.b();
            float floatValue = b == null ? Float.NaN : b.floatValue() - 0.01f;
            Float a3 = ob2.a();
            second = r61.Companion.a(nComputeLayout(a2, j, floatValue, a3 == null ? Float.NaN : a3.floatValue() - 0.01f), 0).getSecond();
        }
        return second;
    }

    @NotNull
    public final List<Node> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getIdPath() {
        return this.idPath;
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    public final void markDirty() {
        synchronized (Stretch.class) {
            nMarkDirty(Stretch.Companion.a(), this.rustptr);
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    public final void markDirtyAll() {
        markDirty();
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            it.next().markDirtyAll();
        }
    }

    public final void safeFree() {
        synchronized (Stretch.class) {
            if (this.rustptr != -1) {
                this.style.free();
                nFree(Stretch.Companion.a(), this.rustptr);
                this.rustptr = -1;
            }
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    public final void setStyle(@NotNull Style style2) {
        k21.i(style2, "style");
        synchronized (Stretch.class) {
            nSetStyle(Stretch.Companion.a(), this.rustptr, style2.getRustptr());
            this.style = style2;
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    @NotNull
    public String toString() {
        return "Node(id='" + this.id + "', style=" + this.style + ", children=" + this.children + ')';
    }

    public Node(@NotNull String str, @NotNull String str2, @NotNull Style style2, @NotNull List<? extends Node> list) {
        k21.i(str, "id");
        k21.i(str2, "idPath");
        k21.i(style2, "style");
        k21.i(list, RichTextNode.CHILDREN);
        synchronized (Stretch.class) {
            this.id = str;
            this.idPath = str2;
            long a2 = Stretch.Companion.a();
            long rustptr2 = style2.getRustptr();
            int size = list.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = ((Node) list.get(i)).rustptr;
            }
            this.rustptr = nConstruct(a2, rustptr2, jArr);
            this.style = style2;
            this.children = CollectionsKt___CollectionsKt.A0(list);
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    public Node(@NotNull String str, @NotNull String str2, @NotNull Style style2) {
        k21.i(str, "id");
        k21.i(str2, "idPath");
        k21.i(style2, "style");
        synchronized (Stretch.class) {
            ArrayList arrayList = new ArrayList();
            this.id = str;
            this.idPath = str2;
            long a2 = Stretch.Companion.a();
            long rustptr2 = style2.getRustptr();
            int size = arrayList.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = ((Node) arrayList.get(i)).rustptr;
            }
            this.rustptr = nConstruct(a2, rustptr2, jArr);
            this.style = style2;
            this.children = CollectionsKt___CollectionsKt.A0(arrayList);
            ur2 ur2 = ur2.INSTANCE;
        }
    }
}
