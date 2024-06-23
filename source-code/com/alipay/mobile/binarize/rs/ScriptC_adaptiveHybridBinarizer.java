package com.alipay.mobile.binarize.rs;

import android.annotation.TargetApi;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.Script;
import android.renderscript.ScriptC;
import android.renderscript.Type;

@TargetApi(24)
/* compiled from: Taobao */
public class ScriptC_adaptiveHybridBinarizer extends ScriptC {
    private Element a;
    private Element b;
    private Allocation c;
    private Allocation d;
    private Allocation e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public ScriptC_adaptiveHybridBinarizer(RenderScript renderScript) {
        super(renderScript, "adaptivehybridbinarizer", adaptiveHybridBinarizerBitCode.getBitCode32(), adaptiveHybridBinarizerBitCode.getBitCode64());
        Element.ALLOCATION(renderScript);
        Element.I32(renderScript);
        this.b = Element.U8(renderScript);
        this.a = Element.I32_3(renderScript);
    }

    public void forEach_calAverage(Allocation allocation) {
        forEach_calAverage(allocation, null);
    }

    public void forEach_calThreshold(Allocation allocation) {
        forEach_calThreshold(allocation, null);
    }

    public void forEach_deNoiseByAverage(Allocation allocation, Allocation allocation2) {
        forEach_deNoiseByAverage(allocation, allocation2, null);
    }

    public void forEach_setBlack(Allocation allocation, Allocation allocation2) {
        forEach_setBlack(allocation, allocation2, null);
    }

    public Script.FieldID getFieldID_gAverageFrame() {
        return createFieldID(2, null);
    }

    public Script.FieldID getFieldID_gBlockSize() {
        return createFieldID(6, null);
    }

    public Script.FieldID getFieldID_gCount() {
        return createFieldID(9, null);
    }

    public Script.FieldID getFieldID_gCurrentFrame() {
        return createFieldID(0, null);
    }

    public Script.FieldID getFieldID_gHeight() {
        return createFieldID(5, null);
    }

    public Script.FieldID getFieldID_gMinDynamicRange() {
        return createFieldID(3, null);
    }

    public Script.FieldID getFieldID_gSubHeight() {
        return createFieldID(8, null);
    }

    public Script.FieldID getFieldID_gSubWidth() {
        return createFieldID(7, null);
    }

    public Script.FieldID getFieldID_gTempAverageFrame() {
        return createFieldID(1, null);
    }

    public Script.FieldID getFieldID_gWidth() {
        return createFieldID(4, null);
    }

    public Script.InvokeID getInvokeID_initSize() {
        return createInvokeID(0);
    }

    public Script.KernelID getKernelID_calAverage() {
        return createKernelID(3, 57, null, null);
    }

    public Script.KernelID getKernelID_calThreshold() {
        return createKernelID(4, 57, null, null);
    }

    public Script.KernelID getKernelID_deNoiseByAverage() {
        return createKernelID(1, 59, null, null);
    }

    public Script.KernelID getKernelID_setBlack() {
        return createKernelID(2, 59, null, null);
    }

    public Allocation get_gAverageFrame() {
        return this.e;
    }

    public int get_gBlockSize() {
        return this.i;
    }

    public int get_gCount() {
        return this.l;
    }

    public Allocation get_gCurrentFrame() {
        return this.c;
    }

    public int get_gHeight() {
        return this.h;
    }

    public int get_gMinDynamicRange() {
        return this.f;
    }

    public int get_gSubHeight() {
        return this.k;
    }

    public int get_gSubWidth() {
        return this.j;
    }

    public Allocation get_gTempAverageFrame() {
        return this.d;
    }

    public int get_gWidth() {
        return this.g;
    }

    public void invoke_initSize(int i2, int i3, int i4, int i5) {
        FieldPacker fieldPacker = new FieldPacker(16);
        fieldPacker.addI32(i2);
        fieldPacker.addI32(i3);
        fieldPacker.addI32(i4);
        fieldPacker.addI32(i5);
        invoke(0, fieldPacker);
    }

    public synchronized void set_gAverageFrame(Allocation allocation) {
        setVar(2, allocation);
        this.e = allocation;
    }

    public synchronized void set_gBlockSize(int i2) {
        setVar(6, i2);
        this.i = i2;
    }

    public synchronized void set_gCount(int i2) {
        setVar(9, i2);
        this.l = i2;
    }

    public synchronized void set_gCurrentFrame(Allocation allocation) {
        setVar(0, allocation);
        this.c = allocation;
    }

    public synchronized void set_gHeight(int i2) {
        setVar(5, i2);
        this.h = i2;
    }

    public synchronized void set_gMinDynamicRange(int i2) {
        setVar(3, i2);
        this.f = i2;
    }

    public synchronized void set_gSubHeight(int i2) {
        setVar(8, i2);
        this.k = i2;
    }

    public synchronized void set_gSubWidth(int i2) {
        setVar(7, i2);
        this.j = i2;
    }

    public synchronized void set_gTempAverageFrame(Allocation allocation) {
        setVar(1, allocation);
        this.d = allocation;
    }

    public synchronized void set_gWidth(int i2) {
        setVar(4, i2);
        this.g = i2;
    }

    public void forEach_calAverage(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.b)) {
            forEach(3, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
            return;
        }
        throw new RSRuntimeException("Type mismatch with U8!");
    }

    public void forEach_calThreshold(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.a)) {
            forEach(4, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
            return;
        }
        throw new RSRuntimeException("Type mismatch with I32_3!");
    }

    public void forEach_deNoiseByAverage(Allocation allocation, Allocation allocation2, Script.LaunchOptions launchOptions) {
        if (!allocation.getType().getElement().isCompatible(this.b)) {
            throw new RSRuntimeException("Type mismatch with U8!");
        } else if (allocation2.getType().getElement().isCompatible(this.b)) {
            Type type = allocation.getType();
            Type type2 = allocation2.getType();
            if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                forEach(1, allocation, allocation2, (FieldPacker) null, launchOptions);
                return;
            }
            throw new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
        } else {
            throw new RSRuntimeException("Type mismatch with U8!");
        }
    }

    public void forEach_setBlack(Allocation allocation, Allocation allocation2, Script.LaunchOptions launchOptions) {
        if (!allocation.getType().getElement().isCompatible(this.b)) {
            throw new RSRuntimeException("Type mismatch with U8!");
        } else if (allocation2.getType().getElement().isCompatible(this.b)) {
            Type type = allocation.getType();
            Type type2 = allocation2.getType();
            if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                forEach(2, allocation, allocation2, (FieldPacker) null, launchOptions);
                return;
            }
            throw new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
        } else {
            throw new RSRuntimeException("Type mismatch with U8!");
        }
    }
}
