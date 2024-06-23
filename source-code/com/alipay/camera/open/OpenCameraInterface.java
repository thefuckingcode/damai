package com.alipay.camera.open;

import android.hardware.Camera;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera.base.CameraConfig;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;

/* compiled from: Taobao */
public final class OpenCameraInterface {
    public static final int NO_REQUESTED_CAMERA = -1;
    private static boolean a = false;
    public static int sCameraId = -1;
    public static int sCameraIdBackup = -1;

    private OpenCameraInterface() {
    }

    public static AntCamera open(int i, boolean z) throws RuntimeException {
        if (a && !z && i == 0) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            AntCamera.getCameraInfo(0, cameraInfo, "Scan");
            if (cameraInfo.facing == i) {
                CameraConfig build = new CameraConfig.Builder("Scan").setCameraId(0).build();
                SystraceWrapper.beginTrace("openCamera");
                AntCamera openOptimized = AntCamera.openOptimized(build);
                SystraceWrapper.endTrace();
                if (openOptimized != null) {
                    return openOptimized;
                }
                throw new RuntimeException("openCamera is failed and camera is null");
            }
        }
        int numberOfCameras = AntCamera.getNumberOfCameras("Scan");
        if (numberOfCameras > 0) {
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                if (i2 >= numberOfCameras) {
                    break;
                }
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                AntCamera.getCameraInfo(i2, cameraInfo2, "Scan");
                int i3 = cameraInfo2.facing;
                if (i3 == 1) {
                    z2 = true;
                }
                if (i3 == i) {
                    MPaasLogger.d("OpenCameraInterface", new Object[]{"The original orientation of camera is ", Integer.valueOf(cameraInfo2.orientation)});
                    break;
                }
                i2++;
            }
            MPaasLogger.d("OpenCameraInterface", new Object[]{"numCameras=", Integer.valueOf(numberOfCameras), "^indexOfBack=", Integer.valueOf(i2), "^advancedOpen=", Boolean.valueOf(z), "^sCameraIdBackup=", Integer.valueOf(sCameraIdBackup), "^hasFrontCamera=", Boolean.valueOf(z2), "cameraFacing=", Integer.valueOf(i), "^enableCameraDefaultTolerant=", Boolean.valueOf(a)});
            if (i2 >= numberOfCameras) {
                MPaasLogger.d("OpenCameraInterface", new Object[]{"Requested camera does not exist,indexOfBack= ", Integer.valueOf(i2)});
                sCameraId = -1;
                if (i != 0 || !z2) {
                    Class cls = Integer.TYPE;
                    int i4 = z2 ? 1 : 0;
                    int i5 = z2 ? 1 : 0;
                    int i6 = z2 ? 1 : 0;
                    int i7 = z2 ? 1 : 0;
                    WalletBury.addWalletBury("recordOpenCameraFaultTolerant", new Class[]{cls, cls}, new Object[]{1, Integer.valueOf(i4)});
                    throw new RuntimeException("Requested Front Camera not exit");
                }
                throw new RuntimeException("Requested camera does not exist");
            }
            sCameraId = i2;
            MPaasLogger.d("OpenCameraInterface", new Object[]{"#2 Opening camera #", Integer.valueOf(i2), " sCameraId=", Integer.valueOf(sCameraId), " cameraFacing=", Integer.valueOf(i)});
            CameraConfig build2 = new CameraConfig.Builder("Scan").setCameraId(i2).build();
            SystraceWrapper.beginTrace("openCamera");
            AntCamera openOptimized2 = AntCamera.openOptimized(build2);
            SystraceWrapper.endTrace();
            if (openOptimized2 == null) {
                sCameraId = -1;
                sCameraIdBackup = -1;
                if (a) {
                    MPaasLogger.d("OpenCameraInterface", new Object[]{"#3 Opening camera"});
                    openOptimized2 = AntCamera.open("Scan");
                    int i8 = openOptimized2 == null ? 0 : 1;
                    Class cls2 = Integer.TYPE;
                    WalletBury.addWalletBury("recordOpenCameraFaultTolerant", new Class[]{cls2, cls2}, new Object[]{3, Integer.valueOf(i8)});
                }
                if (openOptimized2 == null) {
                    throw new RuntimeException("openCamera is failed and camera is null");
                }
            }
            MPaasLogger.d("OpenCameraInterface", new Object[]{"The object camera Id is ", Integer.valueOf(sCameraId)});
            return openOptimized2;
        }
        sCameraId = -1;
        throw new RuntimeException("No Cameras");
    }

    public static void setCameraIdBackup(String str) {
        MPaasLogger.d("OpenCameraInterface", new Object[]{"setCameraIdBackup: ", str});
        if (str == null) {
            try {
                sCameraIdBackup = -1;
            } catch (Exception e) {
                MPaasLogger.e("OpenCameraInterface", new Object[]{"setCameraIdBackup: "}, e);
                sCameraIdBackup = -1;
            }
        } else {
            sCameraIdBackup = Integer.parseInt(str);
        }
    }

    public static void setEnableCameraDefaultTolerant(boolean z) {
        a = z;
        MPaasLogger.d("OpenCameraInterface", new Object[]{"setEnableCameraDefaultTolerant enable= ", Boolean.valueOf(z)});
    }
}
