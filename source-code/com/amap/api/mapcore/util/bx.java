package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.taobao.weex.adapter.URIAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class bx {
    public static long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
    }

    public static void a(String str) {
    }

    public static ArrayList<OfflineMapCity> b(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(c(jSONObject));
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(c(optJSONObject));
            }
        }
        return arrayList;
    }

    public static OfflineMapCity c(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(d(a(jSONObject, "adcode")));
        offlineMapCity.setUrl(a(jSONObject, "url"));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(a(jSONObject, "size")));
        return offlineMapCity;
    }

    private static String d(String str) {
        return "000001".equals(str) ? "100000" : str;
    }

    public static List<OfflineMapProvince> a(String str, Context context) throws JSONException {
        if (str == null || "".equals(str)) {
            return new ArrayList();
        }
        return a(new JSONObject(str), context);
    }

    public static boolean b(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!b(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static List<OfflineMapProvince> a(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("result")) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                c(jSONObject4.toString(), context);
                jSONObject2 = jSONObject4.optJSONObject("result");
            } catch (JSONException e) {
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                hd.c(e, "Utility", "parseJson");
                e.printStackTrace();
                jSONObject2 = optJSONObject;
            }
        } else {
            jSONObject2 = jSONObject.optJSONObject("result");
        }
        if (jSONObject2 != null) {
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject2 == null) {
                return arrayList;
            }
            jSONObject3 = optJSONObject2.optJSONObject("offlinemapinfo_with_province");
        } else {
            jSONObject3 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (jSONObject3 == null) {
            return arrayList;
        }
        if (jSONObject3.has("version")) {
            ba.d = a(jSONObject3, "version");
        }
        JSONArray optJSONArray = jSONObject3.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                arrayList.add(a(optJSONObject3));
            }
        }
        JSONArray optJSONArray2 = jSONObject3.optJSONArray(URIAdapter.OTHERS);
        JSONObject jSONObject5 = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            jSONObject5 = optJSONArray2.getJSONObject(0);
        }
        if (jSONObject5 == null) {
            return arrayList;
        }
        arrayList.add(a(jSONObject5));
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[SYNTHETIC, Splitter:B:34:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e A[SYNTHETIC, Splitter:B:39:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0074 A[SYNTHETIC, Splitter:B:47:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0086 A[SYNTHETIC, Splitter:B:57:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0090 A[SYNTHETIC, Splitter:B:62:0x0090] */
    public static String c(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        FileNotFoundException e;
        IOException e2;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        hd.c(e, "MapDownloadManager", "readOfflineSD filenotfound");
                        e.printStackTrace();
                        if (bufferedReader != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        return null;
                    } catch (IOException e4) {
                        e2 = e4;
                        try {
                            hd.c(e2, "MapDownloadManager", "readOfflineSD io");
                            e2.printStackTrace();
                            if (bufferedReader != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                String stringBuffer2 = stringBuffer.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
                return stringBuffer2;
            } catch (FileNotFoundException e9) {
                e = e9;
                bufferedReader = null;
                hd.c(e, "MapDownloadManager", "readOfflineSD filenotfound");
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                if (fileInputStream != null) {
                }
                return null;
            } catch (IOException e10) {
                e2 = e10;
                bufferedReader = null;
                hd.c(e2, "MapDownloadManager", "readOfflineSD io");
                e2.printStackTrace();
                if (bufferedReader != null) {
                }
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e11) {
            e = e11;
            bufferedReader = null;
            fileInputStream = null;
            hd.c(e, "MapDownloadManager", "readOfflineSD filenotfound");
            e.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (IOException e13) {
            e2 = e13;
            bufferedReader = null;
            fileInputStream = null;
            hd.c(e2, "MapDownloadManager", "readOfflineSD io");
            e2.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (bufferedReader2 != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static void b(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(eq.c(context)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.exists() && file.getName().contains(str)) {
                    b(file);
                }
            }
            b(eq.c(context));
        }
    }

    public static void b(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    String[] list = file2.list();
                    if (list == null) {
                        file2.delete();
                    } else if (list.length == 0) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static OfflineMapProvince a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(d(a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(a(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(a(jSONObject, "size")));
        offlineMapProvince.setCityList(b(jSONObject));
        return offlineMapProvince;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a A[SYNTHETIC, Splitter:B:39:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    public static void c(String str, Context context) {
        Throwable th;
        FileNotFoundException e;
        IOException e2;
        if (!"".equals(eq.c(context))) {
            File file = new File(eq.c(context) + "offlinemapv4.png");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e3) {
                    hd.c(e3, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
                    e3.printStackTrace();
                }
            }
            if (a() > 1048576) {
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str.getBytes("utf-8"));
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        fileOutputStream = fileOutputStream2;
                        hd.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        fileOutputStream = fileOutputStream2;
                        try {
                            hd.c(e2, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                            e2.printStackTrace();
                            if (fileOutputStream == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                    hd.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e9) {
                    e2 = e9;
                    hd.c(e2, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                    e2.printStackTrace();
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                    }
                }
            }
        }
    }

    public static long a(File file) {
        long j;
        if (!file.isDirectory()) {
            return file.length();
        }
        long j2 = 0;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j = a(file2);
            } else {
                j = file2.length();
            }
            j2 += j;
        }
        return j2;
    }

    public static String a(Context context, String str) {
        try {
            return eq.a(ek.a(context).open(str));
        } catch (Throwable th) {
            hd.c(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.substring(str.lastIndexOf("/") + 1, str.indexOf(".zip"));
            }
            return null;
        } catch (Throwable th) {
            hd.c(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !"[]".equals(jSONObject.getString(str))) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }
}
