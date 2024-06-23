package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.ResourceUTUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
public class YKLAfterDownloadProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    public YKLDownloadListener mDownloadListener;
    public String mUrl;

    public YKLAfterDownloadProcessor() {
    }

    public void copyFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530089528")) {
            ipChange.ipc$dispatch("-1530089528", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            String subStringFileName = FileUtils.subStringFileName(str);
            File file = new File(str);
            String name = file.getName();
            String str2 = str.substring(0, str.lastIndexOf("/") + 1) + subStringFileName + File.separator;
            File file2 = new File(str2);
            FileUtils.deleteDirectory(file2.getAbsolutePath());
            file2.mkdirs();
            ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "Copy to  = " + file.renameTo(new File(str2 + name)));
        }
    }

    public void process(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006367986")) {
            ipChange.ipc$dispatch("2006367986", new Object[]{this, Boolean.valueOf(z), str});
        } else if (!TextUtils.isEmpty(str)) {
            if (z) {
                ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "isZip file , unzip , filepathc = " + str);
                unZipFile(FileUtils.subStringFileName(str), str);
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "not zip file , copy to , filepathc = " + str);
            copyFile(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x01b8 A[Catch:{ all -> 0x01ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0206 A[SYNTHETIC, Splitter:B:76:0x0206] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x020e A[Catch:{ IOException -> 0x020a }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0213 A[Catch:{ IOException -> 0x020a }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    public void unZipFile(String str, String str2) {
        ZipInputStream zipInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception e;
        YKLDownloadListener yKLDownloadListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889087445")) {
            ipChange.ipc$dispatch("-1889087445", new Object[]{this, str, str2});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "unzip file = " + str + "  file = " + str2);
        File file = new File(str2);
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.contains(".zip")) {
            absolutePath = file.getAbsolutePath().substring(0, absolutePath.lastIndexOf(46));
        }
        File file2 = new File(absolutePath);
        FileUtils.deleteDirectory(file2.getAbsolutePath());
        file2.mkdirs();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str2);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream2));
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                zipInputStream = null;
                fileInputStream = fileInputStream2;
                try {
                    ResourceUTUtils.unZipFile(str, false);
                    yKLDownloadListener = this.mDownloadListener;
                    if (yKLDownloadListener != null) {
                    }
                    ((ILog) Dsl.getService(ILog.class)).e("liulei-download", "unzip  failed  " + str);
                    e.printStackTrace();
                    FileUtils.deleteFolder(file2.getAbsolutePath());
                    FileUtils.deleteFolder(str2);
                    if (fileInputStream != null) {
                    }
                    if (zipInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    FileUtils.deleteFolder(str2);
                    if (fileInputStream != null) {
                    }
                    if (zipInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                zipInputStream = null;
                fileInputStream = fileInputStream2;
                FileUtils.deleteFolder(str2);
                if (fileInputStream != null) {
                }
                if (zipInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                ((ILog) Dsl.getService(ILog.class)).d("liulei-download", str + "  start getNextEntry");
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String name = nextEntry.getName();
                    if (name.contains("__MACOSX")) {
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "  zeFile.isDirectory()");
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", str + "  ze.getName() = " + name);
                        if (!nextEntry.isDirectory()) {
                            File file3 = new File(absolutePath + "/" + name);
                            file3.deleteOnExit();
                            fileOutputStream = new FileOutputStream(file3);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                } catch (Exception e3) {
                                    e = e3;
                                    fileInputStream = fileInputStream2;
                                    ResourceUTUtils.unZipFile(str, false);
                                    yKLDownloadListener = this.mDownloadListener;
                                    if (yKLDownloadListener != null) {
                                    }
                                    ((ILog) Dsl.getService(ILog.class)).e("liulei-download", "unzip  failed  " + str);
                                    e.printStackTrace();
                                    FileUtils.deleteFolder(file2.getAbsolutePath());
                                    FileUtils.deleteFolder(str2);
                                    if (fileInputStream != null) {
                                    }
                                    if (zipInputStream != null) {
                                    }
                                    if (fileOutputStream == null) {
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileInputStream = fileInputStream2;
                                    FileUtils.deleteFolder(str2);
                                    if (fileInputStream != null) {
                                    }
                                    if (zipInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream.close();
                            zipInputStream.closeEntry();
                            fileOutputStream2 = fileOutputStream;
                        } else {
                            File file4 = new File(absolutePath + "/" + name);
                            file4.deleteOnExit();
                            file4.mkdirs();
                        }
                        ResourceUTUtils.unZipFile(str, true);
                        YKLDownloadListener yKLDownloadListener2 = this.mDownloadListener;
                        if (yKLDownloadListener2 != null) {
                            yKLDownloadListener2.onProcessSuccess(this.mUrl, 1000, "un zip success");
                        }
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "un zip  success " + str);
                    }
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-download", str + "  end while getNextEntry");
                zipInputStream.close();
                FileUtils.deleteFolder(str2);
                try {
                    fileInputStream2.close();
                    zipInputStream.close();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                ResourceUTUtils.unZipFile(str, false);
                yKLDownloadListener = this.mDownloadListener;
                if (yKLDownloadListener != null) {
                }
                ((ILog) Dsl.getService(ILog.class)).e("liulei-download", "unzip  failed  " + str);
                e.printStackTrace();
                FileUtils.deleteFolder(file2.getAbsolutePath());
                FileUtils.deleteFolder(str2);
                if (fileInputStream != null) {
                }
                if (zipInputStream != null) {
                }
                if (fileOutputStream == null) {
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                FileUtils.deleteFolder(str2);
                if (fileInputStream != null) {
                }
                if (zipInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            zipInputStream = null;
            ResourceUTUtils.unZipFile(str, false);
            yKLDownloadListener = this.mDownloadListener;
            if (yKLDownloadListener != null) {
                yKLDownloadListener.onProcessSuccess(this.mUrl, 2002, "un zip failure");
            }
            ((ILog) Dsl.getService(ILog.class)).e("liulei-download", "unzip  failed  " + str);
            e.printStackTrace();
            FileUtils.deleteFolder(file2.getAbsolutePath());
            FileUtils.deleteFolder(str2);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            zipInputStream = null;
            FileUtils.deleteFolder(str2);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    throw th;
                }
            }
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public YKLAfterDownloadProcessor(String str, YKLDownloadListener yKLDownloadListener) {
        this.mUrl = str;
        this.mDownloadListener = yKLDownloadListener;
    }
}
