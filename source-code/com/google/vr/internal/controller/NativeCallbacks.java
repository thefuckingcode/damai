package com.google.vr.internal.controller;

import com.google.vr.cardboard.annotations.UsedByNative;
import com.google.vr.internal.controller.ControllerServiceBridge;
import com.google.vr.vrcore.controller.api.ControllerAccelEvent;
import com.google.vr.vrcore.controller.api.ControllerBatteryEvent;
import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
import com.google.vr.vrcore.controller.api.ControllerEventPacket;
import com.google.vr.vrcore.controller.api.ControllerEventPacket2;
import com.google.vr.vrcore.controller.api.ControllerGyroEvent;
import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
import com.google.vr.vrcore.controller.api.ControllerPositionEvent;
import com.google.vr.vrcore.controller.api.ControllerTouchEvent;

@UsedByNative
/* compiled from: Taobao */
public final class NativeCallbacks implements ControllerServiceBridge.Callbacks {
    private final long a;
    private boolean b;

    @UsedByNative
    public NativeCallbacks(long j) {
        this.a = j;
    }

    private final void a(ControllerEventPacket controllerEventPacket) {
        int i = 0;
        int i2 = 0;
        while (!this.b && i2 < controllerEventPacket.getAccelEventCount()) {
            ControllerAccelEvent accelEvent = controllerEventPacket.getAccelEvent(i2);
            handleAccelEvent(this.a, accelEvent.timestampNanos, accelEvent.x, accelEvent.y, accelEvent.z);
            i2++;
        }
        int i3 = 0;
        while (!this.b && i3 < controllerEventPacket.getButtonEventCount()) {
            ControllerButtonEvent buttonEvent = controllerEventPacket.getButtonEvent(i3);
            handleButtonEvent(this.a, buttonEvent.timestampNanos, buttonEvent.button, buttonEvent.down);
            i3++;
        }
        int i4 = 0;
        while (!this.b && i4 < controllerEventPacket.getGyroEventCount()) {
            ControllerGyroEvent gyroEvent = controllerEventPacket.getGyroEvent(i4);
            handleGyroEvent(this.a, gyroEvent.timestampNanos, gyroEvent.x, gyroEvent.y, gyroEvent.z);
            i4++;
        }
        int i5 = 0;
        while (!this.b && i5 < controllerEventPacket.getOrientationEventCount()) {
            ControllerOrientationEvent orientationEvent = controllerEventPacket.getOrientationEvent(i5);
            handleOrientationEvent(this.a, orientationEvent.timestampNanos, orientationEvent.qx, orientationEvent.qy, orientationEvent.qz, orientationEvent.qw);
            i5++;
        }
        while (!this.b && i < controllerEventPacket.getTouchEventCount()) {
            ControllerTouchEvent touchEvent = controllerEventPacket.getTouchEvent(i);
            handleTouchEvent(this.a, touchEvent.timestampNanos, touchEvent.action, touchEvent.x, touchEvent.y);
            i++;
        }
    }

    private final native void handleAccelEvent(long j, long j2, float f, float f2, float f3);

    private final native void handleBatteryEvent(long j, long j2, boolean z, int i);

    private final native void handleButtonEvent(long j, long j2, int i, boolean z);

    private final native void handleControllerRecentered(long j, long j2, float f, float f2, float f3, float f4);

    private final native void handleGyroEvent(long j, long j2, float f, float f2, float f3);

    private final native void handleOrientationEvent(long j, long j2, float f, float f2, float f3, float f4);

    private final native void handlePositionEvent(long j, long j2, float f, float f2, float f3);

    private final native void handleServiceConnected(long j, int i);

    private final native void handleServiceDisconnected(long j);

    private final native void handleServiceFailed(long j);

    private final native void handleServiceInitFailed(long j, int i);

    private final native void handleServiceUnavailable(long j);

    private final native void handleStateChanged(long j, int i, int i2);

    private final native void handleTouchEvent(long j, long j2, int i, float f, float f2);

    @UsedByNative
    public final synchronized void close() {
        this.b = true;
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onControllerEventPacket(ControllerEventPacket controllerEventPacket) {
        if (!this.b) {
            a(controllerEventPacket);
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) {
        if (!this.b) {
            a(controllerEventPacket2);
            int i = 0;
            while (!this.b && i < controllerEventPacket2.getPositionEventCount()) {
                ControllerPositionEvent positionEvent = controllerEventPacket2.getPositionEvent(i);
                handlePositionEvent(this.a, positionEvent.timestampNanos, positionEvent.x, positionEvent.y, positionEvent.z);
                i++;
            }
            if (!this.b && controllerEventPacket2.hasBatteryEvent()) {
                ControllerBatteryEvent batteryEvent = controllerEventPacket2.getBatteryEvent();
                handleBatteryEvent(this.a, batteryEvent.timestampNanos, batteryEvent.charging, batteryEvent.batteryLevelBucket);
            }
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) {
        if (!this.b) {
            handleControllerRecentered(this.a, controllerOrientationEvent.timestampNanos, controllerOrientationEvent.qx, controllerOrientationEvent.qy, controllerOrientationEvent.qz, controllerOrientationEvent.qw);
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onControllerStateChanged(int i, int i2) {
        if (!this.b) {
            handleStateChanged(this.a, i, i2);
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onServiceConnected(int i) {
        if (!this.b) {
            handleServiceConnected(this.a, i);
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onServiceDisconnected() {
        if (!this.b) {
            handleServiceDisconnected(this.a);
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onServiceFailed() {
        if (!this.b) {
            handleServiceFailed(this.a);
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onServiceInitFailed(int i) {
        if (!this.b) {
            handleServiceInitFailed(this.a, i);
        }
    }

    @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
    public final synchronized void onServiceUnavailable() {
        if (!this.b) {
            handleServiceUnavailable(this.a);
        }
    }
}
