package com.alipay.mobile.binarize;

import android.content.Context;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.Type;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.ma.MaLogger;
import com.alipay.mobile.binarize.rs.ScriptC_localAdaptiveBinarizer;

/* compiled from: Taobao */
public class LocalAdaptiveBinarizer extends Binarizer {
    private ScriptC_localAdaptiveBinarizer b = new ScriptC_localAdaptiveBinarizer(this.c);
    private RenderScript c;
    private Allocation d;
    private Allocation e;
    private Allocation f;
    private Allocation g;
    private Allocation h;
    private byte[] i;
    private int j;
    private int k;

    public LocalAdaptiveBinarizer(Context context) {
        this.c = RenderScript.create(context);
    }

    private void a() {
        Allocation allocation = this.d;
        if (allocation != null) {
            allocation.destroy();
            this.d.getType().destroy();
        }
        Allocation allocation2 = this.f;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f.getType().destroy();
        }
        Allocation allocation3 = this.e;
        if (allocation3 != null) {
            allocation3.destroy();
            this.e.getType().destroy();
        }
        Allocation allocation4 = this.g;
        if (allocation4 != null) {
            allocation4.destroy();
            this.g.getType().destroy();
        }
        Allocation allocation5 = this.h;
        if (allocation5 != null) {
            allocation5.destroy();
            this.h.getType().destroy();
        }
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public void destroy() {
        a();
        ScriptC_localAdaptiveBinarizer scriptC_localAdaptiveBinarizer = this.b;
        if (scriptC_localAdaptiveBinarizer != null) {
            scriptC_localAdaptiveBinarizer.destroy();
        }
        RenderScript renderScript = this.c;
        if (renderScript != null) {
            renderScript.destroy();
        }
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public BinarizeResult getBinarizedData(byte[] bArr) {
        this.d.copyFrom(bArr);
        this.b.forEach_calculateBlock(this.e);
        this.c.finish();
        this.b.forEach_calculateThresholdForBlock(this.e, this.f);
        this.c.finish();
        this.b.forEach_setBlack(this.g, this.h);
        this.h.copyTo(this.i);
        this.c.finish();
        BinarizeResult binarizeResult = new BinarizeResult();
        binarizeResult.bitMatrixData = this.i;
        binarizeResult.width = this.j;
        binarizeResult.height = this.k;
        return binarizeResult;
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public void initialize(int i2, int i3) {
        if (this.j != i2 || this.k != i3) {
            a();
            this.j = i2;
            this.k = i3;
            int ceil = (int) Math.ceil((double) (((float) i2) / 32.0f));
            this.i = new byte[(ceil * i3 * 4)];
            RenderScript renderScript = this.c;
            Type.Builder y = new Type.Builder(renderScript, Element.U8(renderScript)).setX(ceil * 4).setY(i3);
            this.g = Allocation.createTyped(this.c, y.create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
            this.h = Allocation.createTyped(this.c, y.create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
            int i4 = ((i2 + 7) >> 3) / 8;
            int i5 = ((i3 + 7) >> 3) / 8;
            int i6 = 1;
            while (i6 < 5 && (1 << i6) < i4) {
                i6++;
            }
            int i7 = 1;
            while (i7 < 5 && (1 << i7) < i5) {
                i7++;
            }
            int i8 = 1 << i6;
            int i9 = 1 << i7;
            int ceil2 = (int) Math.ceil(((double) i2) / ((double) i8));
            int ceil3 = (int) Math.ceil(((double) i3) / ((double) i9));
            MaLogger.d("LocalAdaptiveBinarizer", "blockWidth:" + i8 + ",blockHeight:" + i9);
            RenderScript renderScript2 = this.c;
            this.d = Allocation.createTyped(this.c, new Type.Builder(renderScript2, Element.U8(renderScript2)).setX(i2 * i3).create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
            RenderScript renderScript3 = this.c;
            Type.Builder x = new Type.Builder(renderScript3, Element.U8(renderScript3)).setX(ceil2 * ceil3);
            this.e = Allocation.createTyped(this.c, x.create());
            this.f = Allocation.createTyped(this.c, x.create());
            this.b.set_gCurrentFrame(this.d);
            this.b.set_gBlockAllocation(this.e);
            this.b.set_gThresholdAllocation(this.f);
            this.b.invoke_initLocalBinarizer(i2, i3, ceil2, ceil3, i8, i9, 8);
        }
    }
}
