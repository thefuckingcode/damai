package io.flutter.view;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

/* compiled from: Taobao */
public final /* synthetic */ class b implements Predicate {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // io.flutter.util.Predicate
    public final boolean test(Object obj) {
        return AccessibilityBridge.lambda$shouldSetCollectionInfo$1((AccessibilityBridge.SemanticsNode) obj);
    }
}
