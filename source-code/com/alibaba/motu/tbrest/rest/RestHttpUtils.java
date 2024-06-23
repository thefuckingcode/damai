package com.alibaba.motu.tbrest.rest;

import com.alibaba.motu.tbrest.utils.LogUtil;
import com.alibaba.motu.tbrest.utils.StringUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import mtopsdk.network.util.Constants;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public class RestHttpUtils {
    public static final int HTTP_REQ_TYPE_GET = 1;
    public static final int HTTP_REQ_TYPE_POST_FORM_DATA = 2;
    public static final int HTTP_REQ_TYPE_POST_URL_ENCODED = 3;
    public static final int MAX_CONNECTION_TIME_OUT = 10000;
    public static final int MAX_READ_CONNECTION_STREAM_TIME_OUT = 60000;
    private static final String POST_Field_BOTTOM = "--GJircTeP--\r\n";
    private static final String POST_Field_TOP = "--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n";

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01be A[Catch:{ IOException -> 0x01d8 }, LOOP:1: B:104:0x01b7->B:106:0x01be, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01c2 A[EDGE_INSN: B:107:0x01c2->B:108:? ?: BREAK  , SYNTHETIC, Splitter:B:107:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01d6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01e5 A[SYNTHETIC, Splitter:B:124:0x01e5] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01f5 A[SYNTHETIC, Splitter:B:131:0x01f5] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x021a A[SYNTHETIC, Splitter:B:150:0x021a] */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    public static byte[] sendRequest(int i, String str, Map<String, Object> map, boolean z) {
        byte[] bArr;
        DataOutputStream dataOutputStream;
        Throwable th;
        DataOutputStream dataOutputStream2;
        Exception e;
        InputStream inputStream;
        Throwable th2;
        InputStream inputStream2;
        IOException e2;
        InputStream inputStream3;
        byte[] bArr2;
        int read;
        IOException e3;
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection == null) {
                return null;
            }
            if (i == 2 || i == 3) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setDoInput(true);
            if (i == 2 || i == 3) {
                httpURLConnection.setRequestMethod("POST");
            } else {
                try {
                    httpURLConnection.setRequestMethod("GET");
                } catch (ProtocolException e4) {
                    LogUtil.e("connection error!", e4);
                    return null;
                }
            }
            char c = 0;
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
            if (z) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            if (i == 2 || i == 3) {
                if (i == 2) {
                    httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=GJircTeP");
                } else if (i == 3) {
                    httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
                }
                if (map == null || map.size() <= 0) {
                    bArr = null;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Set<String> keySet = map.keySet();
                    String[] strArr = new String[keySet.size()];
                    keySet.toArray(strArr);
                    String[] sortResourcesList = RestKeyArraySorter.getInstance().sortResourcesList(strArr, true);
                    int length = sortResourcesList.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str2 = sortResourcesList[i2];
                        if (i == 2) {
                            byte[] bArr3 = (byte[]) map.get(str2);
                            if (bArr3 != null) {
                                try {
                                    Object[] objArr = new Object[2];
                                    objArr[c] = str2;
                                    try {
                                        objArr[1] = str2;
                                        byteArrayOutputStream.write(String.format(POST_Field_TOP, objArr).getBytes());
                                        byteArrayOutputStream.write(bArr3);
                                        byteArrayOutputStream.write(SocketClient.NETASCII_EOL.getBytes());
                                    } catch (IOException e5) {
                                        e3 = e5;
                                    }
                                } catch (IOException e6) {
                                    e3 = e6;
                                    LogUtil.e("write lBaos error!", e3);
                                    i2++;
                                    c = 0;
                                }
                            }
                        } else if (i == 3) {
                            String str3 = (String) map.get(str2);
                            if (byteArrayOutputStream.size() > 0) {
                                try {
                                    byteArrayOutputStream.write(("&" + str2 + "=" + str3).getBytes());
                                } catch (IOException e7) {
                                    LogUtil.e("write lBaos error!", e7);
                                }
                            } else {
                                try {
                                    byteArrayOutputStream.write((str2 + "=" + str3).getBytes());
                                } catch (IOException e8) {
                                    LogUtil.e("write lBaos error!", e8);
                                }
                            }
                        }
                        i2++;
                        c = 0;
                    }
                    if (i == 2) {
                        try {
                            byteArrayOutputStream.write(POST_Field_BOTTOM.getBytes());
                        } catch (IOException e9) {
                            LogUtil.e("write lBaos error!", e9);
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                }
                httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(bArr != null ? bArr.length : 0));
            } else {
                bArr = null;
            }
            try {
                httpURLConnection.connect();
                if ((i == 2 || i == 3) && bArr != null && bArr.length > 0) {
                    dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        dataOutputStream2.write(bArr);
                        dataOutputStream2.flush();
                    } catch (Exception e10) {
                        e = e10;
                    }
                } else {
                    dataOutputStream2 = null;
                }
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e11) {
                        LogUtil.e("out close error!", e11);
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                if (z) {
                    try {
                        if ("gzip".equals(httpURLConnection.getContentEncoding())) {
                            inputStream3 = new GZIPInputStream(httpURLConnection.getInputStream());
                            inputStream2 = inputStream3;
                            bArr2 = new byte[2048];
                            while (true) {
                                read = inputStream2.read(bArr2, 0, 2048);
                                if (read == -1) {
                                    byteArrayOutputStream2.write(bArr2, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e12) {
                                        LogUtil.e("out close error!", e12);
                                    }
                                }
                            }
                            inputStream2.close();
                            if (byteArrayOutputStream2.size() <= 0) {
                                return byteArrayOutputStream2.toByteArray();
                            }
                            return null;
                        }
                    } catch (IOException e13) {
                        e2 = e13;
                        inputStream2 = null;
                        try {
                            LogUtil.e("write out error!", e2);
                            if (inputStream2 != null) {
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        inputStream = null;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e14) {
                                LogUtil.e("out close error!", e14);
                            }
                        }
                        throw th2;
                    }
                }
                inputStream3 = new DataInputStream(httpURLConnection.getInputStream());
                inputStream2 = inputStream3;
                try {
                    bArr2 = new byte[2048];
                    while (true) {
                        read = inputStream2.read(bArr2, 0, 2048);
                        if (read == -1) {
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    }
                    inputStream2.close();
                    if (byteArrayOutputStream2.size() <= 0) {
                    }
                } catch (IOException e15) {
                    e2 = e15;
                    LogUtil.e("write out error!", e2);
                    if (inputStream2 != null) {
                        return null;
                    }
                    try {
                        inputStream2.close();
                        return null;
                    } catch (Exception e16) {
                        LogUtil.e("out close error!", e16);
                        return null;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                dataOutputStream2 = null;
                try {
                    LogUtil.e("write out error!", e);
                    if (dataOutputStream2 == null) {
                        return null;
                    }
                    try {
                        dataOutputStream2.close();
                        return null;
                    } catch (IOException e18) {
                        LogUtil.e("out close error!", e18);
                        return null;
                    }
                } catch (Throwable th5) {
                    dataOutputStream = dataOutputStream2;
                    th = th5;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e19) {
                            LogUtil.e("out close error!", e19);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                }
                throw th;
            }
        } catch (MalformedURLException e20) {
            LogUtil.e("connection error!", e20);
            return null;
        } catch (IOException e21) {
            LogUtil.e("connection error!", e21);
            return null;
        }
    }
}
