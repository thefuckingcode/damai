package tb;

import com.taobao.downloader.download.IListener;
import mtopsdk.mtop.util.ErrorConstant;
import tb.of1;

/* compiled from: Taobao */
public class fn1 {
    public int a = 10;
    public IListener b;
    public long c = 0;
    public boolean d;
    public a e = new a();
    public of1.a f = new of1.a();

    /* compiled from: Taobao */
    public static class a {
        public boolean a = true;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int f;
        public int g;
        public String h;

        public a a(int i, int i2, String str) {
            this.a = false;
            this.f = i;
            this.g = i2;
            this.h = str;
            return this;
        }
    }

    public fn1(IListener iListener) {
        this.b = iListener;
    }

    public void a(f11 f11) {
        if (this.b != null) {
            lb2 lb2 = f11.b;
            a aVar = this.e;
            if (aVar.a) {
                lb2.a = true;
                lb2.d = f11.e.getAbsolutePath();
                lb2.b = this.a;
                lb2.c = "下载成功";
            } else {
                lb2.a = false;
                lb2.b = aVar.f;
                lb2.h.a(aVar.c);
                int i = lb2.b;
                if (i != -21) {
                    if (i != -18 && i != -15) {
                        switch (i) {
                            case -12:
                                lb2.c = ErrorConstant.ERRMSG_NETWORK_ERROR;
                                break;
                            case -11:
                                lb2.c = "文件读写错误";
                                break;
                            case -10:
                                lb2.c = "url错误";
                                break;
                            default:
                                lb2.c = "下载失败";
                                break;
                        }
                    } else {
                        lb2.c = "文件校验失败";
                    }
                } else {
                    lb2.c = "手机剩余空间不足";
                }
            }
            of1.a aVar2 = this.f;
            aVar2.a = f11.c;
            aVar2.b = lb2.e.b;
            long j = aVar2.f;
            if (0 != j) {
                aVar2.g = (((double) aVar2.i) / 1024.0d) / (((double) j) / 1000.0d);
            }
            boolean z = lb2.a;
            aVar2.c = z;
            if (z) {
                aVar2.j = String.valueOf(this.a);
            } else {
                a aVar3 = this.e;
                aVar2.j = String.valueOf((aVar3.f * 1000) - aVar3.g);
            }
            of1.a aVar4 = this.f;
            aVar4.k = this.e.h;
            aVar4.h = lb2.f.a;
            this.b.onResult(lb2);
        }
    }

    public void b() {
        IListener iListener = this.b;
        if (iListener != null) {
            iListener.onProgress(this.c);
        }
    }
}
