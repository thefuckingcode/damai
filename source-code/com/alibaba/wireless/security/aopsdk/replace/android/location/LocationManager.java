package com.alibaba.wireless.security.aopsdk.replace.android.location;

import android.app.PendingIntent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationRequest;
import android.os.CancellationSignal;
import android.os.Looper;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public class LocationManager {
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bd, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
        if (r9.getTp() != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
        r8.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r9.reportTimeCost(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d2, code lost:
        throw r2;
     */
    public static void getCurrentLocation(android.location.LocationManager locationManager, String str, LocationRequest locationRequest, CancellationSignal cancellationSignal, Executor executor, Consumer consumer) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.getCurrentLocation(str, locationRequest, cancellationSignal, executor, consumer);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_getCurrentLocation_String_LocationRequest_CancellationSignal_Executor_Consumer, locationManager, str, locationRequest, cancellationSignal, executor, consumer);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationRequest locationRequest2 = (LocationRequest) invocation.getArgL(1);
                    CancellationSignal cancellationSignal2 = (CancellationSignal) invocation.getArgL(2);
                    Executor executor2 = (Executor) invocation.getArgL(3);
                    Consumer consumer2 = (Consumer) invocation.getArgL(4);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.getCurrentLocation(str2, locationRequest2, cancellationSignal2, executor2, consumer2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.getCurrentLocation(str, locationRequest, cancellationSignal, executor, consumer);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
        if (r5.getTp() != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ad, code lost:
        throw r0;
     */
    public static Location getLastKnownLocation(android.location.LocationManager locationManager, String str) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return locationManager.getLastKnownLocation(str);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_getLastKnownLocation_String, locationManager, str);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j = System.nanoTime();
                    }
                    Location lastKnownLocation = locationManager.getLastKnownLocation(str2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
                    }
                    invocation.setResult(lastKnownLocation);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (Location) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        }
        Location lastKnownLocation2 = locationManager.getLastKnownLocation(str);
        if (!bridge.getTp()) {
            return lastKnownLocation2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return lastKnownLocation2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bc, code lost:
        if (r10.getTp() != false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00be, code lost:
        r7.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r10.reportTimeCost(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, long j, float f, Criteria criteria, PendingIntent pendingIntent) throws Throwable {
        long j2;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(j, f, criteria, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_long_float_Criteria_PendingIntent, locationManager, Long.valueOf(j), Float.valueOf(f), criteria, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j3 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long argJ = invocation.getArgJ(0);
                    float argF = invocation.getArgF(1);
                    Criteria criteria2 = (Criteria) invocation.getArgL(2);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(3);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    } else {
                        j2 = 0;
                    }
                    locationManager.requestLocationUpdates(argJ, argF, criteria2, pendingIntent2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j3 = System.nanoTime();
        }
        locationManager.requestLocationUpdates(j, f, criteria, pendingIntent);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j3) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (r5.getTp() != false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        throw r2;
     */
    public static void requestSingleUpdate(android.location.LocationManager locationManager, Criteria criteria, PendingIntent pendingIntent) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(criteria, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_Criteria_PendingIntent, locationManager, criteria, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Criteria criteria2 = (Criteria) invocation.getArgL(0);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(1);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.requestSingleUpdate(criteria2, pendingIntent2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.requestSingleUpdate(criteria, pendingIntent);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (r6.getTp() != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r3.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r6.reportTimeCost(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        throw r2;
     */
    public static void requestSingleUpdate(android.location.LocationManager locationManager, Criteria criteria, LocationListener locationListener, Looper looper) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(criteria, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_Criteria_LocationListener_Looper, locationManager, criteria, locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Criteria criteria2 = (Criteria) invocation.getArgL(0);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(1);
                    Looper looper2 = (Looper) invocation.getArgL(2);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.requestSingleUpdate(criteria2, locationListener2, looper2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.requestSingleUpdate(criteria, locationListener, looper);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c2, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        if (r11.getTp() != false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
        r10.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r11.reportTimeCost(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d7, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, long j, float f, Criteria criteria, LocationListener locationListener, Looper looper) throws Throwable {
        long j2;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(j, f, criteria, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_long_float_Criteria_LocationListener_Looper, locationManager, Long.valueOf(j), Float.valueOf(f), criteria, locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j3 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long argJ = invocation.getArgJ(0);
                    float argF = invocation.getArgF(1);
                    Criteria criteria2 = (Criteria) invocation.getArgL(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    Looper looper2 = (Looper) invocation.getArgL(4);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    } else {
                        j2 = 0;
                    }
                    locationManager.requestLocationUpdates(argJ, argF, criteria2, locationListener2, looper2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j3 = System.nanoTime();
        }
        locationManager.requestLocationUpdates(j, f, criteria, locationListener, looper);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j3) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r7.getTp() != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r6.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r7.reportTimeCost(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c4, code lost:
        throw r2;
     */
    public static void getCurrentLocation(android.location.LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, Consumer consumer) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.getCurrentLocation(str, cancellationSignal, executor, consumer);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_getCurrentLocation_String_CancellationSignal_Executor_Consumer, locationManager, str, cancellationSignal, executor, consumer);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    CancellationSignal cancellationSignal2 = (CancellationSignal) invocation.getArgL(1);
                    Executor executor2 = (Executor) invocation.getArgL(2);
                    Consumer consumer2 = (Consumer) invocation.getArgL(3);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.getCurrentLocation(str2, cancellationSignal2, executor2, consumer2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.getCurrentLocation(str, cancellationSignal, executor, consumer);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (r5.getTp() != false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        throw r2;
     */
    public static void requestSingleUpdate(android.location.LocationManager locationManager, String str, PendingIntent pendingIntent) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(str, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_String_PendingIntent, locationManager, str, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(1);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.requestSingleUpdate(str2, pendingIntent2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.requestSingleUpdate(str, pendingIntent);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c2, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        if (r11.getTp() != false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
        r10.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r11.reportTimeCost(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d7, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, long j, float f, Criteria criteria, Executor executor, LocationListener locationListener) throws Throwable {
        long j2;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(j, f, criteria, executor, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_long_float_Criteria_Executor_LocationListener, locationManager, Long.valueOf(j), Float.valueOf(f), criteria, executor, locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j3 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long argJ = invocation.getArgJ(0);
                    float argF = invocation.getArgF(1);
                    Criteria criteria2 = (Criteria) invocation.getArgL(2);
                    Executor executor2 = (Executor) invocation.getArgL(3);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(4);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    } else {
                        j2 = 0;
                    }
                    locationManager.requestLocationUpdates(argJ, argF, criteria2, executor2, locationListener2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j3 = System.nanoTime();
        }
        locationManager.requestLocationUpdates(j, f, criteria, executor, locationListener);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j3) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (r6.getTp() != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r3.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r6.reportTimeCost(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        throw r2;
     */
    public static void requestSingleUpdate(android.location.LocationManager locationManager, String str, LocationListener locationListener, Looper looper) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(str, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_String_LocationListener_Looper, locationManager, str, locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(1);
                    Looper looper2 = (Looper) invocation.getArgL(2);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.requestSingleUpdate(str2, locationListener2, looper2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.requestSingleUpdate(str, locationListener, looper);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if (r9.getTp() != false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        r8.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r9.reportTimeCost(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cb, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, PendingIntent pendingIntent) throws Throwable {
        long j2;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_PendingIntent, locationManager, str, Long.valueOf(j), Float.valueOf(f), pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j3 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(3);
                    if (bridge.getTp()) {
                        j3 = System.nanoTime();
                    }
                    locationManager.requestLocationUpdates(str2, argJ, argF, pendingIntent2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j3) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j2 = System.nanoTime();
        } else {
            j2 = 0;
        }
        locationManager.requestLocationUpdates(str, j, f, pendingIntent);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if (r9.getTp() != false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        r8.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r9.reportTimeCost(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cb, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, LocationListener locationListener) throws Throwable {
        long j2;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_LocationListener, locationManager, str, Long.valueOf(j), Float.valueOf(f), locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j3 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    if (bridge.getTp()) {
                        j3 = System.nanoTime();
                    }
                    locationManager.requestLocationUpdates(str2, argJ, argF, locationListener2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j3) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j2 = System.nanoTime();
        } else {
            j2 = 0;
        }
        locationManager.requestLocationUpdates(str, j, f, locationListener);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c6, code lost:
        if (r10.getTp() != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c8, code lost:
        r7.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r10.reportTimeCost(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d6, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, LocationListener locationListener, Looper looper) throws Throwable {
        long j2;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_LocationListener_Looper, locationManager, str, Long.valueOf(j), Float.valueOf(f), locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j3 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    Looper looper2 = (Looper) invocation.getArgL(4);
                    if (bridge.getTp()) {
                        j3 = System.nanoTime();
                    }
                    locationManager.requestLocationUpdates(str2, argJ, argF, locationListener2, looper2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j3) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j2 = System.nanoTime();
        } else {
            j2 = 0;
        }
        locationManager.requestLocationUpdates(str, j, f, locationListener, looper);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c6, code lost:
        if (r10.getTp() != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c8, code lost:
        r7.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r10.reportTimeCost(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d6, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, Executor executor, LocationListener locationListener) throws Throwable {
        long j2;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, executor, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_Executor_LocationListener, locationManager, str, Long.valueOf(j), Float.valueOf(f), executor, locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j3 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    Executor executor2 = (Executor) invocation.getArgL(3);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(4);
                    if (bridge.getTp()) {
                        j3 = System.nanoTime();
                    }
                    locationManager.requestLocationUpdates(str2, argJ, argF, executor2, locationListener2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j3) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j2 = System.nanoTime();
        } else {
            j2 = 0;
        }
        locationManager.requestLocationUpdates(str, j, f, executor, locationListener);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (r6.getTp() != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r3.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r6.reportTimeCost(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, LocationRequest locationRequest, PendingIntent pendingIntent) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, locationRequest, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_LocationRequest_PendingIntent, locationManager, str, locationRequest, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationRequest locationRequest2 = (LocationRequest) invocation.getArgL(1);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(2);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.requestLocationUpdates(str2, locationRequest2, pendingIntent2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.requestLocationUpdates(str, locationRequest, pendingIntent);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r7.getTp() != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r6.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r7.reportTimeCost(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c4, code lost:
        throw r2;
     */
    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, LocationRequest locationRequest, Executor executor, LocationListener locationListener) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_LocationRequest_Executor_LocationListener, locationManager, str, locationRequest, executor, locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationRequest locationRequest2 = (LocationRequest) invocation.getArgL(1);
                    Executor executor2 = (Executor) invocation.getArgL(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    locationManager.requestLocationUpdates(str2, locationRequest2, executor2, locationListener2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }
}
