package com.alibaba.security.realidentity.business;

import com.alibaba.security.common.c.a;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.AbsStartHttpParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.submit.AbsSubmitHttpParams;
import com.alibaba.security.realidentity.business.submit.SubmitHttpParams;
import com.alibaba.security.realidentity.business.upload.AbsUploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.business.uploadresult.AbsUploadResultParams;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class c {
    private static final String h = "c";
    protected String a;
    public BusinessHeadParams b;
    public StartHttpParams c;
    public BiometricsBucketParams d;
    public UploadFileParams e;
    public UploadResultParams f;
    public SubmitHttpParams g;
    private int i = -1;
    private List<BusinessType> j = new ArrayList();
    private Class<? extends BucketParams>[] k = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.security.realidentity.business.c$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[BusinessType.values().length];
            a = iArr;
            iArr[BusinessType.START.ordinal()] = 1;
            a[BusinessType.SUBMIT.ordinal()] = 2;
            a[BusinessType.UPLOADFILE.ordinal()] = 3;
            a[BusinessType.UPLOADRESULT.ordinal()] = 4;
            a[BusinessType.ALBIOMETERICS.ordinal()] = 5;
        }
    }

    public c(BusinessHeadParams businessHeadParams) {
        this.b = businessHeadParams;
    }

    private boolean b(BusinessType businessType) {
        try {
            if (this.k == null) {
                a.d(h, "createParams classes is null");
                return false;
            }
            int i2 = AnonymousClass1.a[businessType.ordinal()];
            if (i2 == 1) {
                Class<? extends BucketParams>[] clsArr = this.k;
                for (Class<? extends BucketParams> cls : clsArr) {
                    if (AbsStartHttpParams.class.isAssignableFrom(cls)) {
                        this.c = (StartHttpParams) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                        return true;
                    }
                }
            } else if (i2 == 2) {
                Class<? extends BucketParams>[] clsArr2 = this.k;
                for (Class<? extends BucketParams> cls2 : clsArr2) {
                    if (AbsSubmitHttpParams.class.isAssignableFrom(cls2)) {
                        this.g = (SubmitHttpParams) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
                        return true;
                    }
                }
            } else if (i2 == 3) {
                Class<? extends BucketParams>[] clsArr3 = this.k;
                for (Class<? extends BucketParams> cls3 : clsArr3) {
                    if (AbsUploadFileParams.class.isAssignableFrom(cls3)) {
                        this.e = (UploadFileParams) cls3.getConstructor(new Class[0]).newInstance(new Object[0]);
                        return true;
                    }
                }
            } else if (i2 == 4) {
                Class<? extends BucketParams>[] clsArr4 = this.k;
                for (Class<? extends BucketParams> cls4 : clsArr4) {
                    if (AbsUploadResultParams.class.isAssignableFrom(cls4)) {
                        this.f = (UploadResultParams) cls4.getConstructor(new Class[0]).newInstance(new Object[0]);
                        return true;
                    }
                }
            } else if (i2 == 5) {
                Class<? extends BucketParams>[] clsArr5 = this.k;
                for (Class<? extends BucketParams> cls5 : clsArr5) {
                    if (AbsBiometricsBucketParams.class.isAssignableFrom(cls5)) {
                        this.d = (BiometricsBucketParams) cls5.getConstructor(new Class[0]).newInstance(new Object[0]);
                        return true;
                    }
                }
            }
            return false;
        } catch (NoSuchMethodException unused) {
            a.b();
        } catch (IllegalAccessException unused2) {
            a.b();
        } catch (InstantiationException unused3) {
            a.b();
        } catch (InvocationTargetException unused4) {
            a.b();
        }
    }

    public final void a(List<BusinessType> list, String str) {
        this.j = list;
        this.i = -1;
        this.k = i.a.a.c();
        this.a = str;
    }

    public final void c() {
        List<BusinessType> list = this.j;
        if (list != null && !list.isEmpty()) {
            this.i = this.j.size();
        }
    }

    public final void d() {
        List<BusinessType> list = this.j;
        if (list != null && !list.isEmpty()) {
            this.i = this.j.indexOf(BusinessType.ALBIOMETERICS);
        }
    }

    public final boolean a() {
        int i2 = this.i + 1;
        this.i = i2;
        if (i2 >= this.j.size()) {
            return false;
        }
        BusinessType businessType = this.j.get(this.i);
        if (!b(businessType)) {
            String str = h;
            a.d(str, "isCreateSuccessful params error businessType:" + businessType.name());
            return false;
        }
        int i3 = AnonymousClass1.a[businessType.ordinal()];
        if (i3 == 1) {
            this.c.dispatch(this);
        } else if (i3 == 2) {
            this.g.dispatch(this);
        } else if (i3 == 3) {
            this.e.dispatch(this);
        } else if (i3 == 4) {
            this.f.dispatch(this);
        } else if (i3 == 5) {
            this.d.dispatch(this);
        }
        return true;
    }

    private BucketParams.ErrorCode a(BusinessType businessType) {
        int i2 = AnonymousClass1.a[businessType.ordinal()];
        if (i2 == 1) {
            return this.c.getErrorCode();
        }
        if (i2 == 2) {
            return this.g.getErrorCode();
        }
        if (i2 == 3) {
            return this.e.getErrorCode();
        }
        if (i2 == 4) {
            return this.f.getErrorCode();
        }
        if (i2 != 5) {
            return null;
        }
        return this.d.getErrorCode();
    }

    private void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.a;
    }
}
