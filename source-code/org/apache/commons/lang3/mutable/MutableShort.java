package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* compiled from: Taobao */
public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    private static final long serialVersionUID = -2135791679;
    private short value;

    public MutableShort() {
    }

    public void add(short s) {
        this.value = (short) (this.value + s);
    }

    public short addAndGet(short s) {
        short s2 = (short) (this.value + s);
        this.value = s2;
        return s2;
    }

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    public short decrementAndGet() {
        short s = (short) (this.value - 1);
        this.value = s;
        return s;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableShort) || this.value != ((MutableShort) obj).shortValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public short getAndAdd(short s) {
        short s2 = this.value;
        this.value = (short) (s + s2);
        return s2;
    }

    public short getAndDecrement() {
        short s = this.value;
        this.value = (short) (s - 1);
        return s;
    }

    public short getAndIncrement() {
        short s = this.value;
        this.value = (short) (s + 1);
        return s;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    public short incrementAndGet() {
        short s = (short) (this.value + 1);
        this.value = s;
        return s;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public short shortValue() {
        return this.value;
    }

    public void subtract(short s) {
        this.value = (short) (this.value - s);
    }

    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }

    public MutableShort(short s) {
        this.value = s;
    }

    public void add(Number number) {
        this.value = (short) (this.value + number.shortValue());
    }

    public short addAndGet(Number number) {
        short shortValue = (short) (this.value + number.shortValue());
        this.value = shortValue;
        return shortValue;
    }

    public int compareTo(MutableShort mutableShort) {
        return NumberUtils.compare(this.value, mutableShort.value);
    }

    /* Return type fixed from 'java.lang.Short' to match base method */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public Number getValue() {
        return Short.valueOf(this.value);
    }

    public void setValue(short s) {
        this.value = s;
    }

    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    public short getAndAdd(Number number) {
        short s = this.value;
        this.value = (short) (number.shortValue() + s);
        return s;
    }

    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String str) throws NumberFormatException {
        this.value = Short.parseShort(str);
    }
}
