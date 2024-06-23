package com.youku.playerservice.axp.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class CacheUtil {
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004f A[SYNTHETIC, Splitter:B:33:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0059 A[SYNTHETIC, Splitter:B:38:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0066 A[SYNTHETIC, Splitter:B:46:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0070 A[SYNTHETIC, Splitter:B:51:0x0070] */
    public static String getM3u8File(String str) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Exception e;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            TLogUtil.playLog(e.getStackTrace().toString());
                            if (fileInputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                String str2 = new String(byteArrayOutputStream.toByteArray());
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return str2;
            } catch (Exception e7) {
                e = e7;
                byteArrayOutputStream = null;
                TLogUtil.playLog(e.getStackTrace().toString());
                if (fileInputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
            byteArrayOutputStream = null;
            TLogUtil.playLog(e.getStackTrace().toString());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (fileInputStream2 != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    public static String readFile(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        readToBuffer(stringBuffer, str);
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039 A[SYNTHETIC, Splitter:B:23:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A[SYNTHETIC, Splitter:B:28:0x0043] */
    public static void readToBuffer(StringBuffer stringBuffer, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(StringUtils.LF);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (bufferedReader != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }
}
