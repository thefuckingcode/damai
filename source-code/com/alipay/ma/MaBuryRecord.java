package com.alipay.ma;

import android.os.AsyncTask;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: Taobao */
public class MaBuryRecord {
    protected static volatile EngineBuryRecord a;

    /* compiled from: Taobao */
    public interface EngineBuryRecord {
        void recodeDecodeFailedMaInfo(String str);

        void recordBigPixelsImageScan(double d, double d2);

        void recordLazyRecorgnized(boolean z, String str);

        void recordRecognizedPerformance(Object obj);

        void recordRsBinarizeException(String str);

        void recordRsExceptionLimitation();

        void recordScanDecodeTrack(String str, String str2, Map map);

        void recordScanSuccess(Object obj, boolean z, String str, long j, boolean z2);

        void recordTwoCodeHasBlackList(String str);

        void reportEightSecondsNotRecognize(long j, String str);

        void reportNativeInterfaceResult(String str);

        void reportSoLoadResult(int i, long j);

        void reportUnusualScanCase(int i, String str);
    }

    private static void a(final int i, final long j) {
        new AsyncTask<Object, Object, Object>() {
            /* class com.alipay.ma.MaBuryRecord.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Object doInBackground(Object... objArr) {
                try {
                    Class<?> cls = Class.forName("com.alipay.mobile.mascanengine.BuryRecord");
                    Object newInstance = cls.newInstance();
                    cls.getDeclaredMethod("reportSoLoadResult", Integer.TYPE, Long.TYPE).invoke(newInstance, Integer.valueOf(i), Long.valueOf(j));
                    return null;
                } catch (ClassNotFoundException e) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e);
                    return null;
                } catch (IllegalAccessException e2) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e2);
                    return null;
                } catch (InstantiationException e3) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e3);
                    return null;
                } catch (NoSuchMethodException e4) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e4);
                    return null;
                } catch (InvocationTargetException e5) {
                    Log.e("MaBuryRecord", "asyncBurySoLoad()", e5);
                    return null;
                }
            }
        }.execute(new Object[0]);
    }

    private static void b(final String str, final String str2, final Map map) {
        new AsyncTask<Object, Object, Object>() {
            /* class com.alipay.ma.MaBuryRecord.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Object doInBackground(Object... objArr) {
                try {
                    Class<?> cls = Class.forName("com.alipay.mobile.mascanengine.BuryRecord");
                    Object newInstance = cls.newInstance();
                    cls.getDeclaredMethod("recordScanDecodeTrack", String.class, String.class, Map.class).invoke(newInstance, str, str2, map);
                    return null;
                } catch (ClassNotFoundException e) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e);
                    return null;
                } catch (IllegalAccessException e2) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e2);
                    return null;
                } catch (InstantiationException e3) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e3);
                    return null;
                } catch (NoSuchMethodException e4) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e4);
                    return null;
                } catch (InvocationTargetException e5) {
                    Log.e("MaBuryRecord", "asyncRecordImageDecodeTrack()", e5);
                    return null;
                }
            }
        }.execute(new Object[0]);
    }

    public static void recodeDecodeFailedMaInfo(String str) {
        if (a != null) {
            a.recodeDecodeFailedMaInfo(str);
        }
    }

    public static void recordBigPixelsImageScan(double d, double d2) {
        if (a != null) {
            a.recordBigPixelsImageScan(d, d2);
        }
    }

    public static void recordLazyRecorgnized(boolean z, String str) {
        if (a != null) {
            a.recordLazyRecorgnized(z, str);
        }
    }

    public static void recordRecognizedPerformance(Object obj) {
        if (a != null) {
            a.recordRecognizedPerformance(obj);
        }
    }

    public static void recordRsBinarizeException(String str) {
        if (a != null) {
            a.recordRsBinarizeException(str);
        }
    }

    public static void recordRsExceptionLimitation() {
        if (a != null) {
            a.recordRsExceptionLimitation();
        }
    }

    public static void recordScanDecodeTrack(String str, String str2, Map map) {
        if (a != null) {
            a.recordScanDecodeTrack(str, str2, map);
        } else {
            b(str, str2, map);
        }
    }

    public static void recordScanSuccess(Object obj, boolean z, String str, long j, boolean z2) {
        if (a != null) {
            a.recordScanSuccess(obj, z, str, j, z2);
        }
    }

    public static void recordTwoCodeHasBlackList(String str) {
        if (a != null) {
            a.recordTwoCodeHasBlackList(str);
        }
    }

    public static void registerEngineBuryRecord(EngineBuryRecord engineBuryRecord) {
        a = engineBuryRecord;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    public static void reportEightSecondsNotRecognize(Map map) {
        boolean z;
        String str;
        int i;
        if (map == null) {
            MaLogger.d("MaBuryRecord", "MaScanEngine decodeInfo == null");
            return;
        }
        Object obj = map.get("DecodeStep_find_selectedBestPatterns");
        if (obj == null || !(obj instanceof byte[])) {
            i = -2;
            str = "sdk error";
        } else {
            byte[] bArr = (byte[]) obj;
            if (bArr.length == 0) {
                i = -1;
                str = "selectedPattern is null";
            } else if (bArr.length == 1 && bArr[0] == 48) {
                str = "no selectedPatterns";
                i = 0;
            } else {
                str = null;
                i = -3;
                z = true;
                if (z) {
                    Object obj2 = map.get("DecodeStep_find_DetectorResult");
                    if (obj2 == null || !(obj2 instanceof byte[])) {
                        str = "findDetectorResult error";
                        i = 1;
                    } else {
                        byte[] bArr2 = (byte[]) obj2;
                        if (bArr2.length == 0) {
                            i = 2;
                            str = "findDetectorResult is null";
                        } else if (bArr2.length == 1 && bArr2[0] == 48) {
                            i = 3;
                            str = "not to findDetectorResult";
                        } else {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    Object obj3 = map.get("DecodeStep_decode_solomonReadFailed");
                    if (obj3 == null || !(obj3 instanceof byte[])) {
                        i = 4;
                        str = "solomonRead error";
                    } else {
                        byte[] bArr3 = (byte[]) obj3;
                        if (bArr3.length == 0) {
                            i = 5;
                            str = "solomonRead is null";
                        } else if (bArr3.length == 1 && bArr3[0] == 48) {
                            i = 6;
                            str = "not to solomonRead";
                        }
                    }
                }
                if (a != null && i > -3) {
                    a.reportEightSecondsNotRecognize((long) i, str);
                }
                if (!MaLogger.isDebuggable()) {
                    MaLogger.d("MaBuryRecord", "MaScanEngine resultCode: " + i + " resultMsg: " + str);
                    return;
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
        if (z) {
        }
        a.reportEightSecondsNotRecognize((long) i, str);
        if (!MaLogger.isDebuggable()) {
        }
    }

    public static void reportNativeInterfaceResult(String str) {
        if (a != null && str != null) {
            a.reportNativeInterfaceResult(str);
        }
    }

    public static void reportSoLoadResult(int i, long j) {
        if (a != null) {
            a.reportSoLoadResult(i, j);
        } else {
            a(i, j);
        }
    }

    public static void reportUnusualScanCase(int i, String str) {
        if (a != null) {
            a.reportUnusualScanCase(i, str);
        }
    }

    public static void unRegisterEngineBuryRecord() {
        a = null;
    }
}
