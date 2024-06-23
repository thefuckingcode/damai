package org.apache.commons.lang3.math;

import java.math.BigInteger;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public final class Fraction extends Number implements Comparable<Fraction> {
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private transient int hashCode = 0;
    private final int numerator;
    private transient String toProperString = null;
    private transient String toString = null;

    private Fraction(int i, int i2) {
        this.numerator = i;
        this.denominator = i2;
    }

    private static int addAndCheck(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    private Fraction addSub(Fraction fraction, boolean z) {
        int i;
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        if (this.numerator == 0) {
            return z ? fraction : fraction.negate();
        }
        if (fraction.numerator == 0) {
            return this;
        }
        int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
        if (greatestCommonDivisor == 1) {
            int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
            int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
            return new Fraction(z ? addAndCheck(mulAndCheck, mulAndCheck2) : subAndCheck(mulAndCheck, mulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
        }
        BigInteger multiply = BigInteger.valueOf((long) this.numerator).multiply(BigInteger.valueOf((long) (fraction.denominator / greatestCommonDivisor)));
        BigInteger multiply2 = BigInteger.valueOf((long) fraction.numerator).multiply(BigInteger.valueOf((long) (this.denominator / greatestCommonDivisor)));
        BigInteger add = z ? multiply.add(multiply2) : multiply.subtract(multiply2);
        int intValue = add.mod(BigInteger.valueOf((long) greatestCommonDivisor)).intValue();
        if (intValue == 0) {
            i = greatestCommonDivisor;
        } else {
            i = greatestCommonDivisor(intValue, greatestCommonDivisor);
        }
        BigInteger divide = add.divide(BigInteger.valueOf((long) i));
        if (divide.bitLength() <= 31) {
            return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / i));
        }
        throw new ArithmeticException("overflow: numerator too large after multiply");
    }

    public static Fraction getFraction(int i, int i2) {
        if (i2 != 0) {
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            return new Fraction(i, i2);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int i, int i2) {
        if (i2 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i == 0) {
            return ZERO;
        } else {
            if (i2 == Integer.MIN_VALUE && (i & 1) == 0) {
                i /= 2;
                i2 /= 2;
            }
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i, i2);
            return new Fraction(i / greatestCommonDivisor, i2 / greatestCommonDivisor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0050  */
    private static int greatestCommonDivisor(int i, int i2) {
        int i3;
        if (i == 0 || i2 == 0) {
            if (i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
                return Math.abs(i) + Math.abs(i2);
            }
            throw new ArithmeticException("overflow: gcd is 2^31");
        } else if (Math.abs(i) == 1 || Math.abs(i2) == 1) {
            return 1;
        } else {
            if (i > 0) {
                i = -i;
            }
            if (i2 > 0) {
                i2 = -i2;
            }
            int i4 = 0;
            while (true) {
                int i5 = i & 1;
                if (i5 == 0 && (i2 & 1) == 0 && i4 < 31) {
                    i /= 2;
                    i2 /= 2;
                    i4++;
                } else if (i4 == 31) {
                    if (i5 == 1) {
                        i3 = i2;
                    } else {
                        i3 = -(i / 2);
                    }
                    while (true) {
                        if ((i3 & 1) == 0) {
                            i3 /= 2;
                        } else {
                            if (i3 > 0) {
                                i = -i3;
                            } else {
                                i2 = i3;
                            }
                            i3 = (i2 - i) / 2;
                            if (i3 == 0) {
                                return (-i) * (1 << i4);
                            }
                        }
                    }
                } else {
                    throw new ArithmeticException("overflow: gcd is 2^31");
                }
            }
            if (i4 == 31) {
            }
        }
    }

    private static int mulAndCheck(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mul");
    }

    private static int mulPosAndCheck(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    public Fraction abs() {
        if (this.numerator >= 0) {
            return this;
        }
        return negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction divideBy(Fraction fraction) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        }
        throw new ArithmeticException("The fraction to divide by must not be zero");
    }

    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator()) {
            return true;
        }
        return false;
    }

    public float floatValue() {
        return ((float) this.numerator) / ((float) this.denominator);
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((getNumerator() + 629) * 37) + getDenominator();
        }
        return this.hashCode;
    }

    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i = this.numerator;
        if (i == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        } else if (i == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        } else if (i < 0) {
            return new Fraction(-this.denominator, -i);
        } else {
            return new Fraction(this.denominator, i);
        }
    }

    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public Fraction multiplyBy(Fraction fraction) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        int i = this.numerator;
        if (i == 0 || fraction.numerator == 0) {
            return ZERO;
        }
        int greatestCommonDivisor = greatestCommonDivisor(i, fraction.denominator);
        int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
        return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
    }

    public Fraction negate() {
        int i = this.numerator;
        if (i != Integer.MIN_VALUE) {
            return new Fraction(-i, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i) {
        if (i == 1) {
            return this;
        }
        if (i == 0) {
            return ONE;
        }
        if (i >= 0) {
            Fraction multiplyBy = multiplyBy(this);
            if (i % 2 == 0) {
                return multiplyBy.pow(i / 2);
            }
            return multiplyBy.pow(i / 2).multiplyBy(this);
        } else if (i == Integer.MIN_VALUE) {
            return invert().pow(2).pow(-(i / 2));
        } else {
            return invert().pow(-i);
        }
    }

    public Fraction reduce() {
        int i = this.numerator;
        if (i == 0) {
            Fraction fraction = ZERO;
            return equals(fraction) ? this : fraction;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i), this.denominator);
        if (greatestCommonDivisor == 1) {
            return this;
        }
        return getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i = this.numerator;
            if (i == 0) {
                this.toProperString = "0";
            } else {
                int i2 = this.denominator;
                if (i == i2) {
                    this.toProperString = "1";
                } else if (i == i2 * -1) {
                    this.toProperString = "-1";
                } else {
                    if (i > 0) {
                        i = -i;
                    }
                    if (i < (-i2)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            this.toProperString = getProperWhole() + " " + properNumerator + "/" + getDenominator();
                        }
                    } else {
                        this.toProperString = getNumerator() + "/" + getDenominator();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = getNumerator() + "/" + getDenominator();
        }
        return this.toString;
    }

    public int compareTo(Fraction fraction) {
        int i;
        if (this == fraction) {
            return 0;
        }
        int i2 = this.numerator;
        int i3 = fraction.numerator;
        if ((i2 == i3 && this.denominator == fraction.denominator) || ((long) i2) * ((long) fraction.denominator) == ((long) i3) * ((long) this.denominator)) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public static Fraction getFraction(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i3 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        } else if (i2 >= 0) {
            long j = i < 0 ? (((long) i) * ((long) i3)) - ((long) i2) : (((long) i) * ((long) i3)) + ((long) i2);
            if (j >= -2147483648L && j <= 2147483647L) {
                return new Fraction((int) j, i3);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        } else {
            throw new ArithmeticException("The numerator must not be negative");
        }
    }

    public static Fraction getFraction(double d) {
        int i;
        int i2;
        int i3 = d < 0.0d ? -1 : 1;
        double abs = Math.abs(d);
        if (abs > 2.147483647E9d || Double.isNaN(abs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i4 = (int) abs;
        double d2 = abs - ((double) i4);
        int i5 = (int) d2;
        double d3 = 1.0d;
        double d4 = d2 - ((double) i5);
        double d5 = Double.MAX_VALUE;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        int i10 = 1;
        while (true) {
            int i11 = (int) (d3 / d4);
            double d6 = d3 - (((double) i11) * d4);
            int i12 = (i5 * i6) + i7;
            int i13 = (i5 * i8) + i9;
            d5 = Math.abs(d2 - (((double) i12) / ((double) i13)));
            i = i10 + 1;
            if (d5 <= d5 || i13 > 10000 || i13 <= 0) {
                i2 = 25;
            } else {
                i2 = 25;
                if (i >= 25) {
                    break;
                }
                i10 = i;
                i8 = i13;
                i5 = i11;
                i7 = i6;
                i6 = i12;
                i9 = i8;
                d3 = d4;
                d4 = d6;
            }
        }
        if (i != i2) {
            return getReducedFraction((i6 + (i4 * i8)) * i3, i8);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) {
        Validate.isTrue(str != null, "The string must not be null", new Object[0]);
        if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        }
        int indexOf = str.indexOf(32);
        if (indexOf > 0) {
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            String substring = str.substring(indexOf + 1);
            int indexOf2 = substring.indexOf(47);
            if (indexOf2 >= 0) {
                return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
            }
            throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 < 0) {
            return getFraction(Integer.parseInt(str), 1);
        }
        return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
    }
}
