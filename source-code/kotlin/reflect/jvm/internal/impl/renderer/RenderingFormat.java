package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.jl1;
import tb.k21;
import tb.m40;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: Taobao */
public abstract class RenderingFormat extends Enum<RenderingFormat> {
    private static final /* synthetic */ RenderingFormat[] $VALUES;
    public static final RenderingFormat HTML;
    public static final RenderingFormat PLAIN;

    /* compiled from: Taobao */
    static final class HTML extends RenderingFormat {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        HTML(String str, int i) {
            super(str, i, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String str) {
            k21.i(str, "string");
            return o.F(o.F(str, jl1.L, "&lt;", false, 4, null), jl1.G, "&gt;", false, 4, null);
        }
    }

    /* compiled from: Taobao */
    static final class PLAIN extends RenderingFormat {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        PLAIN(String str, int i) {
            super(str, i, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String str) {
            k21.i(str, "string");
            return str;
        }
    }

    static {
        PLAIN plain = new PLAIN("PLAIN", 0);
        PLAIN = plain;
        HTML html = new HTML("HTML", 1);
        HTML = html;
        $VALUES = new RenderingFormat[]{plain, html};
    }

    private RenderingFormat(String str, int i) {
    }

    public /* synthetic */ RenderingFormat(String str, int i, m40 m40) {
        this(str, i);
    }

    public static RenderingFormat valueOf(String str) {
        k21.i(str, "value");
        return (RenderingFormat) Enum.valueOf(RenderingFormat.class, str);
    }

    public static RenderingFormat[] values() {
        RenderingFormat[] renderingFormatArr = $VALUES;
        RenderingFormat[] renderingFormatArr2 = new RenderingFormat[renderingFormatArr.length];
        System.arraycopy(renderingFormatArr, 0, renderingFormatArr2, 0, renderingFormatArr.length);
        return renderingFormatArr2;
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}
