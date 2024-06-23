package com.taomai.android.h5container.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.util.Base64;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXConfig;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.lf1;
import tb.lf2;
import tb.m40;
import tb.ph;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u001d\u0010\u0016\u001a\u00020\u00048B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/taomai/android/h5container/api/TaoMaiFilePlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "fileLength", "", "data", "", "isAppend", "canWriteFile", "actionName", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "execute", "Ltb/ur2;", TaoMaiFilePlugin.ACTION_FILE_READ, TaoMaiFilePlugin.ACTION_FILE_SAVE, TaoMaiFilePlugin.ACTION_FILE_DELETE, "cacheDir$delegate", "Lkotlin/Lazy;", "getCacheDir", "()Ljava/lang/String;", WXConfig.cacheDir, "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TaoMaiFilePlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_FILE_DELETE = "deleteFile";
    @NotNull
    public static final String ACTION_FILE_READ = "readFile";
    @NotNull
    public static final String ACTION_FILE_SAVE = "saveFile";
    @NotNull
    public static final String BRIDGE_NAME = "TMFile";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String FILES_DIR = "h5files";
    public static final long FILE_MAX_SIZE = 6291456;
    @NotNull
    public static final String File_ENCODE_BASE64 = "base64";
    private final Lazy cacheDir$delegate = b.b(TaoMaiFilePlugin$cacheDir$2.INSTANCE);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final boolean canWriteFile(long j, String str, boolean z) {
        long j2;
        if (z) {
            j2 = j + ((long) str.length());
        } else {
            j2 = (long) str.length();
        }
        return j2 <= FILE_MAX_SIZE;
    }

    private final String getCacheDir() {
        return (String) this.cacheDir$delegate.getValue();
    }

    public final void deleteFile(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        if (str != null && (a2 = lf2.a(str)) != null) {
            try {
                String string = a2.getString("fileName");
                if (getCacheDir() != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getCacheDir());
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("sharedFiles");
                    String sb2 = sb.toString();
                    File file = new File(sb2 + str2 + string);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    if (wVCallBackContext != null) {
                        wVCallBackContext.success();
                    }
                } else if (wVCallBackContext != null) {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("error", "GET_DIR_FAILED");
                    ur2 ur2 = ur2.INSTANCE;
                    wVCallBackContext.error(wVResult);
                }
            } catch (Exception unused) {
                if (wVCallBackContext != null) {
                    WVResult wVResult2 = new WVResult();
                    wVResult2.addData("error", ILocatable.ErrorMsg.PARAMS_ERROR);
                    ur2 ur22 = ur2.INSTANCE;
                    wVCallBackContext.error(wVResult2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2073025383) {
                if (hashCode != -867956686) {
                    if (hashCode == 1764172231 && str.equals(ACTION_FILE_DELETE)) {
                        deleteFile(str2, wVCallBackContext);
                        return true;
                    }
                } else if (str.equals(ACTION_FILE_READ)) {
                    readFile(str2, wVCallBackContext);
                    return true;
                }
            } else if (str.equals(ACTION_FILE_SAVE)) {
                saveFile(str2, wVCallBackContext);
                return true;
            }
        }
        return false;
    }

    public final void readFile(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        String str2;
        if (str != null && (a2 = lf2.a(str)) != null && a2.size() != 0) {
            try {
                String string = a2.getString("fileName");
                boolean d = k21.d(File_ENCODE_BASE64, a2.getString("fileOption"));
                if (string == null || string.length() == 0) {
                    if (wVCallBackContext != null) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("error", "file name is empty");
                        ur2 ur2 = ur2.INSTANCE;
                        wVCallBackContext.error(wVResult);
                    }
                } else if (getCacheDir() != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getCacheDir());
                    String str3 = File.separator;
                    sb.append(str3);
                    sb.append("sharedFiles");
                    String sb2 = sb.toString();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(new File(sb2 + str3 + string));
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        if (d) {
                            str2 = Base64.encodeToString(bArr, 0);
                            k21.h(str2, "Base64.encodeToString(\n …e64.DEFAULT\n            )");
                        } else {
                            Charset forName = Charset.forName("UTF-8");
                            k21.h(forName, "java.nio.charset.Charset.forName(\"UTF-8\")");
                            str2 = new String(bArr, forName);
                        }
                        fileInputStream.close();
                        if (wVCallBackContext != null) {
                            WVResult wVResult2 = new WVResult();
                            wVResult2.addData("data", str2);
                            ur2 ur22 = ur2.INSTANCE;
                            wVCallBackContext.success(wVResult2);
                        }
                    } catch (FileNotFoundException unused) {
                        if (wVCallBackContext != null) {
                            WVResult wVResult3 = new WVResult();
                            wVResult3.addData("error", "FILE_NOT_FOUND");
                            ur2 ur23 = ur2.INSTANCE;
                            wVCallBackContext.error(wVResult3);
                        }
                    } catch (Exception e) {
                        if (wVCallBackContext != null) {
                            WVResult wVResult4 = new WVResult();
                            wVResult4.addData("error", "READ_FILE_FAILED");
                            ur2 ur24 = ur2.INSTANCE;
                            wVCallBackContext.error(wVResult4);
                        }
                        e.printStackTrace();
                    }
                } else if (wVCallBackContext != null) {
                    WVResult wVResult5 = new WVResult();
                    wVResult5.addData("error", "GET_DIR_FAILED");
                    ur2 ur25 = ur2.INSTANCE;
                    wVCallBackContext.error(wVResult5);
                }
            } catch (Exception unused2) {
                if (wVCallBackContext != null) {
                    WVResult wVResult6 = new WVResult();
                    wVResult6.addData("error", ILocatable.ErrorMsg.PARAMS_ERROR);
                    ur2 ur26 = ur2.INSTANCE;
                    wVCallBackContext.error(wVResult6);
                }
            }
        }
    }

    @Nullable
    public final String saveFile(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        byte[] bArr;
        if (!(str == null || (a2 = lf2.a(str)) == null)) {
            try {
                String string = a2.getString("fileName");
                String string2 = a2.getString("fileContent");
                if (string2 == null) {
                    string2 = "";
                }
                String string3 = a2.getString("fileOption");
                String string4 = a2.getString("mode");
                if (getCacheDir() == null) {
                    if (wVCallBackContext != null) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("error", "GET_DIR_FAILED");
                        ur2 ur2 = ur2.INSTANCE;
                        wVCallBackContext.error(wVResult);
                    }
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(getCacheDir());
                String str2 = File.separator;
                sb.append(str2);
                sb.append("sharedFiles");
                String sb2 = sb.toString();
                File file = new File(sb2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str3 = sb2 + str2 + string;
                File file2 = new File(str3);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException unused) {
                        if (wVCallBackContext != null) {
                            WVResult wVResult2 = new WVResult();
                            wVResult2.addData("error", "MAKE_FILE_FAILED");
                            ur2 ur22 = ur2.INSTANCE;
                            wVCallBackContext.error(wVResult2);
                        }
                        return null;
                    }
                } else if (o.w(lf1.OPERATION_WRITE, string4, true)) {
                    if (wVCallBackContext != null) {
                        WVResult wVResult3 = new WVResult();
                        wVResult3.addData("error", "FILE_EXIST");
                        ur2 ur23 = ur2.INSTANCE;
                        wVCallBackContext.error(wVResult3);
                    }
                    return null;
                }
                try {
                    boolean z = o.w("append", string4, true);
                    if (!canWriteFile(file2.length(), string2, z)) {
                        if (wVCallBackContext != null) {
                            WVResult wVResult4 = new WVResult();
                            wVResult4.addData("error", "FILE_TOO_LARGE");
                            ur2 ur24 = ur2.INSTANCE;
                            wVCallBackContext.error(wVResult4);
                        }
                        return null;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2, z);
                    if (k21.d(File_ENCODE_BASE64, string3)) {
                        bArr = Base64.decode(string2, 0);
                    } else {
                        bArr = string2.getBytes(ph.UTF_8);
                        k21.h(bArr, "(this as java.lang.String).getBytes(charset)");
                    }
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    if (wVCallBackContext != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("filePath", str3);
                        ur2 ur25 = ur2.INSTANCE;
                        wVCallBackContext.success(JSON.toJSONString(hashMap));
                    }
                    return str3;
                } catch (Exception e) {
                    if (wVCallBackContext != null) {
                        WVResult wVResult5 = new WVResult();
                        wVResult5.addData("error", "WRITE_FILE_FAILED");
                        ur2 ur26 = ur2.INSTANCE;
                        wVCallBackContext.error(wVResult5);
                    }
                    e.printStackTrace();
                    return null;
                }
            } catch (Exception unused2) {
                if (wVCallBackContext != null) {
                    WVResult wVResult6 = new WVResult();
                    wVResult6.addData("error", ILocatable.ErrorMsg.PARAMS_ERROR);
                    ur2 ur27 = ur2.INSTANCE;
                    wVCallBackContext.error(wVResult6);
                }
            }
        }
        return null;
    }
}
