package anet.channel.monitor;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {
    private long a = 0;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i = 0.0d;
    private double j = 0.0d;
    private double k = 0.0d;

    a() {
    }

    public void a() {
        this.a = 0;
        this.k = 0.0d;
    }

    public double b(double d2, double d3) {
        double d4 = d2 / d3;
        if (d4 >= 8.0d) {
            long j2 = this.a;
            if (j2 == 0) {
                this.i = d4;
                this.h = d4;
                this.d = d4 * 0.1d;
                this.c = 0.02d * d4;
                this.e = 0.1d * d4 * d4;
            } else if (j2 == 1) {
                this.j = d4;
                this.h = d4;
            } else {
                double d5 = this.j;
                double d6 = d4 - d5;
                this.i = d5;
                this.j = d4;
                double d7 = d4 / 0.95d;
                this.b = d7;
                this.g = d7 - (this.h * 0.95d);
                char c2 = 0;
                double sqrt = Math.sqrt(this.d);
                double d8 = this.g;
                if (d8 >= 4.0d * sqrt) {
                    this.g = (d8 * 0.75d) + (sqrt * 2.0d);
                    c2 = 1;
                } else if (d8 <= -4.0d * sqrt) {
                    this.g = (sqrt * -1.0d) + (d8 * 0.75d);
                    c2 = 2;
                }
                double d9 = this.g;
                double min = Math.min(Math.max(Math.abs((this.d * 1.05d) - ((0.0025d * d9) * d9)), this.d * 0.8d), this.d * 1.25d);
                this.d = min;
                double d10 = this.e;
                double d11 = d10 / ((0.9025d * d10) + min);
                this.f = d11;
                double d12 = this.h + (1.0526315789473684d * d6) + (d11 * this.g);
                this.h = d12;
                if (c2 == 1) {
                    this.h = Math.min(d12, this.b);
                } else if (c2 == 2) {
                    this.h = Math.max(d12, this.b);
                }
                this.e = (1.0d - (0.95d * this.f)) * (this.e + this.c);
            }
            double d13 = this.h;
            if (d13 < 0.0d) {
                double d14 = this.j * 0.7d;
                this.k = d14;
                this.h = d14;
            } else {
                this.k = d13;
            }
            return this.k;
        } else if (this.a != 0) {
            return this.k;
        } else {
            this.k = d4;
            return d4;
        }
    }
}
