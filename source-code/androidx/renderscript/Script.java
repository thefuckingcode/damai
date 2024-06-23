package androidx.renderscript;

import android.renderscript.Script;
import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
public class Script extends BaseObj {
    private final SparseArray<FieldID> mFIDs = new SparseArray<>();
    private final SparseArray<InvokeID> mIIDs = new SparseArray<>();
    private final SparseArray<KernelID> mKIDs = new SparseArray<>();
    private boolean mUseIncSupp = false;

    /* compiled from: Taobao */
    public static class Builder {
        RenderScript mRS;

        Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }
    }

    /* compiled from: Taobao */
    public static class FieldBase {
        protected Allocation mAllocation;
        protected Element mElement;

        protected FieldBase() {
        }

        public Allocation getAllocation() {
            return this.mAllocation;
        }

        public Element getElement() {
            return this.mElement;
        }

        public Type getType() {
            return this.mAllocation.getType();
        }

        /* access modifiers changed from: protected */
        public void init(RenderScript renderScript, int i) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, 1);
        }

        public void updateAllocation() {
        }

        /* access modifiers changed from: protected */
        public void init(RenderScript renderScript, int i, int i2) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, i2 | 1);
        }
    }

    /* compiled from: Taobao */
    public static final class FieldID extends BaseObj {
        Script.FieldID mN;
        Script mScript;
        int mSlot;

        FieldID(long j, RenderScript renderScript, Script script, int i) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
        }
    }

    /* compiled from: Taobao */
    public static final class InvokeID extends BaseObj {
        Script mScript;
        int mSlot;

        InvokeID(long j, RenderScript renderScript, Script script, int i) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
        }
    }

    /* compiled from: Taobao */
    public static final class KernelID extends BaseObj {
        Script.KernelID mN;
        Script mScript;
        int mSig;
        int mSlot;

        KernelID(long j, RenderScript renderScript, Script script, int i, int i2) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
            this.mSig = i2;
        }
    }

    /* compiled from: Taobao */
    public static final class LaunchOptions {
        private int strategy;
        private int xend = 0;
        private int xstart = 0;
        private int yend = 0;
        private int ystart = 0;
        private int zend = 0;
        private int zstart = 0;

        public int getXEnd() {
            return this.xend;
        }

        public int getXStart() {
            return this.xstart;
        }

        public int getYEnd() {
            return this.yend;
        }

        public int getYStart() {
            return this.ystart;
        }

        public int getZEnd() {
            return this.zend;
        }

        public int getZStart() {
            return this.zstart;
        }

        public LaunchOptions setX(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.xstart = i;
            this.xend = i2;
            return this;
        }

        public LaunchOptions setY(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.ystart = i;
            this.yend = i2;
            return this;
        }

        public LaunchOptions setZ(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.zstart = i;
            this.zend = i2;
            return this;
        }
    }

    Script(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public void bindAllocation(Allocation allocation, int i) {
        this.mRS.validate();
        if (allocation != null) {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptBindAllocation(getID(renderScript), allocation.getID(this.mRS), i, this.mUseIncSupp);
            return;
        }
        RenderScript renderScript2 = this.mRS;
        renderScript2.nScriptBindAllocation(getID(renderScript2), 0, i, this.mUseIncSupp);
    }

    /* access modifiers changed from: protected */
    public FieldID createFieldID(int i, Element element) {
        FieldID fieldID = this.mFIDs.get(i);
        if (fieldID != null) {
            return fieldID;
        }
        RenderScript renderScript = this.mRS;
        long nScriptFieldIDCreate = renderScript.nScriptFieldIDCreate(getID(renderScript), i, this.mUseIncSupp);
        if (nScriptFieldIDCreate != 0) {
            FieldID fieldID2 = new FieldID(nScriptFieldIDCreate, this.mRS, this, i);
            this.mFIDs.put(i, fieldID2);
            return fieldID2;
        }
        throw new RSDriverException("Failed to create FieldID");
    }

    /* access modifiers changed from: protected */
    public InvokeID createInvokeID(int i) {
        InvokeID invokeID = this.mIIDs.get(i);
        if (invokeID != null) {
            return invokeID;
        }
        RenderScript renderScript = this.mRS;
        long nScriptInvokeIDCreate = renderScript.nScriptInvokeIDCreate(getID(renderScript), i);
        if (nScriptInvokeIDCreate != 0) {
            InvokeID invokeID2 = new InvokeID(nScriptInvokeIDCreate, this.mRS, this, i);
            this.mIIDs.put(i, invokeID2);
            return invokeID2;
        }
        throw new RSDriverException("Failed to create KernelID");
    }

    /* access modifiers changed from: protected */
    public KernelID createKernelID(int i, int i2, Element element, Element element2) {
        KernelID kernelID = this.mKIDs.get(i);
        if (kernelID != null) {
            return kernelID;
        }
        RenderScript renderScript = this.mRS;
        long nScriptKernelIDCreate = renderScript.nScriptKernelIDCreate(getID(renderScript), i, i2, this.mUseIncSupp);
        if (nScriptKernelIDCreate != 0) {
            KernelID kernelID2 = new KernelID(nScriptKernelIDCreate, this.mRS, this, i, i2);
            this.mKIDs.put(i, kernelID2);
            return kernelID2;
        }
        throw new RSDriverException("Failed to create KernelID");
    }

    /* access modifiers changed from: protected */
    public void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        long j = 0;
        long id = allocation != null ? allocation.getID(this.mRS) : 0;
        if (allocation2 != null) {
            j = allocation2.getID(this.mRS);
        }
        byte[] bArr = null;
        if (fieldPacker != null) {
            bArr = fieldPacker.getData();
        }
        if (this.mUseIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            long dummyAlloc2 = getDummyAlloc(allocation2);
            RenderScript renderScript = this.mRS;
            renderScript.nScriptForEach(getID(renderScript), i, dummyAlloc, dummyAlloc2, bArr, this.mUseIncSupp);
            return;
        }
        RenderScript renderScript2 = this.mRS;
        renderScript2.nScriptForEach(getID(renderScript2), i, id, j, bArr, this.mUseIncSupp);
    }

    /* access modifiers changed from: package-private */
    public long getDummyAlloc(Allocation allocation) {
        if (allocation == null) {
            return 0;
        }
        long dummyType = allocation.getType().getDummyType(this.mRS, allocation.getType().getElement().getDummyElement(this.mRS));
        RenderScript renderScript = this.mRS;
        long nIncAllocationCreateTyped = renderScript.nIncAllocationCreateTyped(allocation.getID(renderScript), dummyType);
        allocation.setIncAllocID(nIncAllocationCreateTyped);
        return nIncAllocationCreateTyped;
    }

    /* access modifiers changed from: protected */
    public void invoke(int i) {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptInvoke(getID(renderScript), i, this.mUseIncSupp);
    }

    /* access modifiers changed from: protected */
    public boolean isIncSupp() {
        return this.mUseIncSupp;
    }

    /* access modifiers changed from: protected */
    public void setIncSupp(boolean z) {
        this.mUseIncSupp = z;
    }

    public void setTimeZone(String str) {
        this.mRS.validate();
        try {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetTimeZone(getID(renderScript), str.getBytes("UTF-8"), this.mUseIncSupp);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVar(int i, float f) {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarF(getID(renderScript), i, f, this.mUseIncSupp);
    }

    /* access modifiers changed from: protected */
    public void invoke(int i, FieldPacker fieldPacker) {
        if (fieldPacker != null) {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptInvokeV(getID(renderScript), i, fieldPacker.getData(), this.mUseIncSupp);
            return;
        }
        RenderScript renderScript2 = this.mRS;
        renderScript2.nScriptInvoke(getID(renderScript2), i, this.mUseIncSupp);
    }

    public void setVar(int i, double d) {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarD(getID(renderScript), i, d, this.mUseIncSupp);
    }

    public void setVar(int i, int i2) {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarI(getID(renderScript), i, i2, this.mUseIncSupp);
    }

    public void setVar(int i, long j) {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarJ(getID(renderScript), i, j, this.mUseIncSupp);
    }

    public void setVar(int i, boolean z) {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarI(getID(renderScript), i, z ? 1 : 0, this.mUseIncSupp);
    }

    public void setVar(int i, BaseObj baseObj) {
        long j = 0;
        if (this.mUseIncSupp) {
            long dummyAlloc = getDummyAlloc((Allocation) baseObj);
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarObj(getID(renderScript), i, baseObj == null ? 0 : dummyAlloc, this.mUseIncSupp);
            return;
        }
        RenderScript renderScript2 = this.mRS;
        long id = getID(renderScript2);
        if (baseObj != null) {
            j = baseObj.getID(this.mRS);
        }
        renderScript2.nScriptSetVarObj(id, i, j, this.mUseIncSupp);
    }

    /* access modifiers changed from: protected */
    public void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        } else if (launchOptions == null) {
            forEach(i, allocation, allocation2, fieldPacker);
        } else {
            long j = 0;
            long id = allocation != null ? allocation.getID(this.mRS) : 0;
            if (allocation2 != null) {
                j = allocation2.getID(this.mRS);
            }
            byte[] bArr = null;
            if (fieldPacker != null) {
                bArr = fieldPacker.getData();
            }
            if (this.mUseIncSupp) {
                long dummyAlloc = getDummyAlloc(allocation);
                long dummyAlloc2 = getDummyAlloc(allocation2);
                RenderScript renderScript = this.mRS;
                renderScript.nScriptForEachClipped(getID(renderScript), i, dummyAlloc, dummyAlloc2, bArr, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend, this.mUseIncSupp);
                return;
            }
            RenderScript renderScript2 = this.mRS;
            renderScript2.nScriptForEachClipped(getID(renderScript2), i, id, j, bArr, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend, this.mUseIncSupp);
        }
    }

    public void setVar(int i, FieldPacker fieldPacker) {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarV(getID(renderScript), i, fieldPacker.getData(), this.mUseIncSupp);
    }

    public void setVar(int i, FieldPacker fieldPacker, Element element, int[] iArr) {
        if (this.mUseIncSupp) {
            long dummyElement = element.getDummyElement(this.mRS);
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarVE(getID(renderScript), i, fieldPacker.getData(), dummyElement, iArr, this.mUseIncSupp);
            return;
        }
        RenderScript renderScript2 = this.mRS;
        renderScript2.nScriptSetVarVE(getID(renderScript2), i, fieldPacker.getData(), element.getID(this.mRS), iArr, this.mUseIncSupp);
    }
}
