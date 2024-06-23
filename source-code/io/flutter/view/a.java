package io.flutter.view;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

/* compiled from: Taobao */
public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ AccessibilityBridge.SemanticsNode a;

    public /* synthetic */ a(AccessibilityBridge.SemanticsNode semanticsNode) {
        this.a = semanticsNode;
    }

    @Override // io.flutter.util.Predicate
    public final boolean test(Object obj) {
        return AccessibilityBridge.lambda$shouldSetCollectionInfo$0(this.a, (AccessibilityBridge.SemanticsNode) obj);
    }
}
