package com.taobao.android.dinamicx.monitor;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import mtopsdk.network.util.Constants;
import tb.c00;
import tb.ry;
import tb.vx;

/* compiled from: Taobao */
public class DXPerformBaselineUtil {
    private static boolean a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class Task implements Runnable {
        String baseLineName;
        long consumeTime;
        String templateName;
        long templateVersion;

        public Task(String str, long j, String str2, long j2) {
            this.baseLineName = str;
            this.consumeTime = j;
            this.templateName = str2;
            this.templateVersion = j2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00c0 A[SYNTHETIC, Splitter:B:27:0x00c0] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00d6 A[SYNTHETIC, Splitter:B:37:0x00d6] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00e0 A[SYNTHETIC, Splitter:B:42:0x00e0] */
        /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        private void sendMsg(String str) {
            Throwable th;
            InputStream inputStream;
            Exception e;
            OutputStream outputStream = null;
            InputStream inputStream2 = null;
            outputStream = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://pre-dx-platfrom.alibaba-inc.com/test/perf").openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                httpURLConnection.setRequestProperty("accept-language", "zh-CN,zh;q=0.9");
                httpURLConnection.setRequestProperty("accept", "application/json, text/plain, */*");
                byte[] bytes = str.getBytes("UTF-8");
                httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(bytes.length));
                httpURLConnection.connect();
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(bytes);
                    outputStream2.flush();
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream2 = httpURLConnection.getInputStream();
                        ry.b("DXPerformBaselineUtil", "上报成功：" + new BufferedReader(new InputStreamReader(inputStream2)).readLine());
                    } else {
                        ry.g("DXPerformBaselineUtil", "上报失败" + httpURLConnection.getResponseCode());
                    }
                    try {
                        outputStream2.close();
                    } catch (IOException e2) {
                        vx.b(e2);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e3) {
                            vx.b(e3);
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                    outputStream = outputStream2;
                    try {
                        vx.b(e);
                        if (outputStream != null) {
                        }
                        if (inputStream == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                                vx.b(e5);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                vx.b(e6);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                inputStream = null;
                vx.b(e);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e8) {
                        vx.b(e8);
                    }
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                if (outputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        }

        public void run() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("templateName", (Object) this.templateName);
            jSONObject.put("templateVersion", (Object) Long.valueOf(this.templateVersion));
            jSONObject.put("consumeTime", (Object) Long.valueOf(this.consumeTime));
            jSONObject.put("protocolV", (Object) 1);
            jSONObject.put("perfName", (Object) this.baseLineName);
            jSONObject.put("name", (Object) this.baseLineName);
            jSONObject.put("platform", (Object) "Android");
            jSONObject.put("sdkVersion", (Object) "3.9.10.3");
            String jSONString = jSONObject.toJSONString();
            ry.l(jSONString);
            sendMsg(jSONString);
        }
    }

    public static void a(String str, long j, DXTemplateItem dXTemplateItem) {
        Task task;
        if (a) {
            if (dXTemplateItem != null) {
                task = new Task(str, j, dXTemplateItem.getName(), dXTemplateItem.getVersion());
            } else {
                task = new Task(str, j, "null", -1);
            }
            c00.k(task);
        }
    }
}
