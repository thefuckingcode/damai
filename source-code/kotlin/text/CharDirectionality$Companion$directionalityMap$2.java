package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ww1;

/* compiled from: Taobao */
final class CharDirectionality$Companion$directionalityMap$2 extends Lambda implements Function0<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality$Companion$directionalityMap$2 INSTANCE = new CharDirectionality$Companion$directionalityMap$2();

    CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    /* Return type fixed from 'java.util.Map<java.lang.Integer, kotlin.text.CharDirectionality>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<Integer, ? extends CharDirectionality> invoke() {
        CharDirectionality[] values = CharDirectionality.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(values.length), 16));
        for (CharDirectionality charDirectionality : values) {
            linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
        }
        return linkedHashMap;
    }
}
