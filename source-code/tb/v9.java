package tb;

import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class v9<V, O> implements AnimatableValue<V, O> {
    final List<b61<V>> a;

    v9(V v) {
        this(Collections.singletonList(new b61(v)));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<b61<V>> getKeyframes() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    v9(List<b61<V>> list) {
        this.a = list;
    }
}
