package androidx.dynamicanimation.animation;

/* compiled from: Taobao */
public final class FloatValueHolder {
    private float mValue = 0.0f;

    public FloatValueHolder() {
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f) {
        this.mValue = f;
    }

    public FloatValueHolder(float f) {
        setValue(f);
    }
}
