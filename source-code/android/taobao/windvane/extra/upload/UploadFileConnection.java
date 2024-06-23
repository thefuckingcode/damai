package android.taobao.windvane.extra.upload;

import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.extra.mtop.ApiUrlManager;
import android.taobao.windvane.util.PhoneInfo;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.xstate.util.XStateConstants;
import org.apache.commons.net.SocketClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class UploadFileConnection implements Runnable {
    private static final int DEFAULT_CONNECT_TIMEOUT = 60000;
    private static final int DEFAULT_READ_TIMEOUT = 60000;
    public static final int ERROE_CODE_FAIL = 1;
    public static final String ERROE_MSG_FAIL = "FAIL";
    public static final int ERR_CODE_TOKEN_INVALID = 2;
    public static final String ERR_MSG_TOKEN_INVALID = "TOKEN_IS_INVALID";
    private static final String TAG = "UploadFileConnection";
    private String accessToken;
    private String mFileExt;
    private String mFilePath;
    private HttpConnectListener<UploadFileData> mListener;
    private int tryNum;

    public UploadFileConnection(String str, String str2, HttpConnectListener<UploadFileData> httpConnectListener) {
        this.mListener = httpConnectListener;
        this.mFilePath = str;
        this.mFileExt = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0106 A[Catch:{ JSONException -> 0x016a }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0172  */
    public void run() {
        HttpConnectListener<UploadFileData> httpConnectListener;
        String str;
        JSONObject jSONObject;
        UnsupportedEncodingException e;
        String str2;
        JSONObject jSONObject2;
        UnsupportedEncodingException e2;
        String str3 = "wv-a-8.5.0-" + PhoneInfo.getImei(GlobalConfig.context);
        HttpResponse syncConnect = new HttpConnector().syncConnect(ApiUrlManager.getUploadTokenUrl(str3));
        if (syncConnect.isSuccess() && syncConnect.getData() != null) {
            try {
                str2 = new String(syncConnect.getData(), "utf-8");
                try {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(TAG, "get upload token success, content=" + str2);
                    }
                } catch (UnsupportedEncodingException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    ApiResponse apiResponse = new ApiResponse();
                    apiResponse.parseResult(str2);
                    this.accessToken = jSONObject2.optString(XStateConstants.KEY_ACCESS_TOKEN);
                    this.tryNum = jSONObject2.optInt("tryNum");
                    if (TextUtils.isEmpty(this.accessToken)) {
                    }
                }
            } catch (UnsupportedEncodingException e4) {
                e2 = e4;
                str2 = null;
                e2.printStackTrace();
                ApiResponse apiResponse2 = new ApiResponse();
                apiResponse2.parseResult(str2);
                this.accessToken = jSONObject2.optString(XStateConstants.KEY_ACCESS_TOKEN);
                this.tryNum = jSONObject2.optInt("tryNum");
                if (TextUtils.isEmpty(this.accessToken)) {
                }
            }
            ApiResponse apiResponse22 = new ApiResponse();
            apiResponse22.parseResult(str2);
            if (apiResponse22.success && (jSONObject2 = apiResponse22.data) != null) {
                this.accessToken = jSONObject2.optString(XStateConstants.KEY_ACCESS_TOKEN);
                this.tryNum = jSONObject2.optInt("tryNum");
            }
        }
        if (TextUtils.isEmpty(this.accessToken)) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "get upload token fail, accessToken is empty");
            }
            HttpConnectListener<UploadFileData> httpConnectListener2 = this.mListener;
            if (httpConnectListener2 != null) {
                httpConnectListener2.onError(2, ERR_MSG_TOKEN_INVALID);
                return;
            }
            return;
        }
        HttpConnectListener<UploadFileData> httpConnectListener3 = this.mListener;
        if (httpConnectListener3 != null) {
            httpConnectListener3.onStart();
        }
        HttpResponse uploadFile = uploadFile(ApiUrlManager.getUploadUrl(str3, this.accessToken), this.mFilePath);
        if (uploadFile.isSuccess() && uploadFile.getData() != null) {
            try {
                str = new String(uploadFile.getData(), "utf-8");
                try {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(TAG, "upload file success, response: " + str);
                    }
                } catch (UnsupportedEncodingException e5) {
                    e = e5;
                    e.printStackTrace();
                    ApiResponse parseResult = new ApiResponse().parseResult(str);
                    try {
                        if (jSONObject.getBoolean("status")) {
                        }
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    httpConnectListener = this.mListener;
                    if (httpConnectListener != null) {
                    }
                    this.mListener = null;
                }
            } catch (UnsupportedEncodingException e7) {
                e = e7;
                str = null;
                e.printStackTrace();
                ApiResponse parseResult2 = new ApiResponse().parseResult(str);
                if (jSONObject.getBoolean("status")) {
                }
                httpConnectListener = this.mListener;
                if (httpConnectListener != null) {
                }
                this.mListener = null;
            }
            ApiResponse parseResult22 = new ApiResponse().parseResult(str);
            if (parseResult22.success && (jSONObject = parseResult22.data) != null) {
                if (jSONObject.getBoolean("status")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("uploadInfo");
                    UploadFileData uploadFileData = new UploadFileData();
                    uploadFileData.accessToken = jSONObject3.getString(XStateConstants.KEY_ACCESS_TOKEN);
                    uploadFileData.blockNum = jSONObject3.getInt("blockNum");
                    uploadFileData.fileExt = jSONObject3.getString("fileExt");
                    uploadFileData.fileName = jSONObject3.getString("fileName");
                    uploadFileData.fileSize = jSONObject3.getLong(TLogEventConst.PARAM_FILE_SIZE);
                    uploadFileData.resourceUri = jSONObject3.getString("resourceUri");
                    uploadFileData.tfsKey = jSONObject3.getString("tfsKey");
                    uploadFileData.tryNum = jSONObject3.getInt("tryNum");
                    uploadFileData.validTime = jSONObject3.getLong("validTime");
                    uploadFileData.finish = jSONObject3.getBoolean("finish");
                    HttpConnectListener<UploadFileData> httpConnectListener4 = this.mListener;
                    if (httpConnectListener4 != null) {
                        httpConnectListener4.onFinish(uploadFileData, 0);
                        return;
                    }
                    return;
                }
            }
        }
        httpConnectListener = this.mListener;
        if (httpConnectListener != null) {
            httpConnectListener.onError(1, "FAIL");
        }
        this.mListener = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0183, code lost:
        if (r13 != null) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01b3, code lost:
        if (r13 != null) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b5, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01bc, code lost:
        if (android.taobao.windvane.util.TaoLog.getLogStatus() == false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01be, code lost:
        android.taobao.windvane.util.TaoLog.d(android.taobao.windvane.extra.upload.UploadFileConnection.TAG, "upload file fail.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01c9, code lost:
        return new android.taobao.windvane.connect.HttpResponse();
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0173 A[SYNTHETIC, Splitter:B:45:0x0173] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a3 A[SYNTHETIC, Splitter:B:58:0x01a3] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01cd A[SYNTHETIC, Splitter:B:75:0x01cd] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01df  */
    public final HttpResponse uploadFile(String str, String str2) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        IOException e;
        Exception e2;
        DataInputStream dataInputStream;
        HttpResponse httpResponse = new HttpResponse();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataInputStream dataInputStream2 = null;
        try {
            File file = new File(str2);
            URL url = new URL(str);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "keep-alive");
                httpURLConnection.setRequestProperty(BizTime.HOST, url.getHost());
                String uuid = UUID.randomUUID().toString();
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--" + uuid + SocketClient.NETASCII_EOL);
                if (this.mFileExt == null) {
                    this.mFileExt = "";
                }
                dataOutputStream.writeBytes("Content-Disposition:form-data;name=\"file\";filename=\"" + file.getName() + "." + this.mFileExt + "\"\r\n");
                dataOutputStream.writeBytes("Content-Transfer-Encoding:binary\r\n\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                dataOutputStream.writeBytes("--" + uuid + "--\r\n");
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                httpResponse.setHttpCode(responseCode);
                if (responseCode == 200) {
                    String contentEncoding = httpURLConnection.getContentEncoding();
                    if (contentEncoding == null || !"gzip".equals(contentEncoding)) {
                        dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                    } else {
                        dataInputStream = new DataInputStream(new GZIPInputStream(httpURLConnection.getInputStream()));
                    }
                    dataInputStream2 = dataInputStream;
                    byte[] bArr2 = new byte[2048];
                    while (true) {
                        int read2 = dataInputStream2.read(bArr2);
                        if (read2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read2);
                    }
                    httpResponse.setData(byteArrayOutputStream.toByteArray());
                }
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                httpURLConnection.disconnect();
                return httpResponse;
            } catch (IOException e5) {
                e = e5;
                TaoLog.e(TAG, "upload file IO exception, " + e.getMessage());
                if (0 != 0) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } catch (Exception e7) {
                e2 = e7;
                try {
                    TaoLog.e(TAG, "upload file error, " + e2.getMessage());
                    if (0 != 0) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            dataInputStream2.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e11) {
            e = e11;
            httpURLConnection = null;
            TaoLog.e(TAG, "upload file IO exception, " + e.getMessage());
            if (0 != 0) {
                try {
                    dataInputStream2.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            byteArrayOutputStream.close();
        } catch (Exception e13) {
            e2 = e13;
            httpURLConnection = null;
            TaoLog.e(TAG, "upload file error, " + e2.getMessage());
            if (0 != 0) {
                try {
                    dataInputStream2.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (0 != 0) {
            }
            byteArrayOutputStream.close();
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }
}
