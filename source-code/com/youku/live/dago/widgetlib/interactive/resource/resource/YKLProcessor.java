package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.ResourceUTUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
public class YKLProcessor implements AfterDownloadProcessor.Processor {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01aa A[SYNTHETIC, Splitter:B:61:0x01aa] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b2 A[Catch:{ IOException -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b7 A[Catch:{ IOException -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c7 A[SYNTHETIC, Splitter:B:76:0x01c7] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01cf A[Catch:{ IOException -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d4 A[Catch:{ IOException -> 0x01cb }] */
    private AfterDownloadProcessor.ProcessedResource unZipFile(Config config, String str, String str2) {
        FileOutputStream fileOutputStream;
        ZipInputStream zipInputStream;
        Throwable th;
        ZipInputStream zipInputStream2;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream3;
        Exception e;
        FileOutputStream fileOutputStream2;
        ZipInputStream zipInputStream4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188841950")) {
            return (AfterDownloadProcessor.ProcessedResource) ipChange.ipc$dispatch("-188841950", new Object[]{this, config, str, str2});
        }
        Log.d("YKLPrefetchManager", "unzip file = " + str + "  file = " + str2);
        File file = new File(str2);
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.contains(".zip")) {
            absolutePath = file.getAbsolutePath().substring(0, absolutePath.lastIndexOf(46));
        }
        File file2 = new File(absolutePath);
        FileUtils.deleteFolder(file2.getAbsolutePath());
        file2.mkdirs();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str2);
            try {
                zipInputStream4 = new ZipInputStream(new BufferedInputStream(fileInputStream));
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = null;
                fileOutputStream = fileOutputStream2;
                zipInputStream3 = fileOutputStream2;
                try {
                    ResourceUTUtils.unZipFile(str, false);
                    Log.e("yklresouce", "unzip  failed  " + str);
                    e.printStackTrace();
                    FileUtils.deleteFolder(file2.getAbsolutePath());
                    FileUtils.deleteFolder(str2);
                    if (fileInputStream != null) {
                    }
                    if (zipInputStream3 != 0) {
                    }
                    if (fileOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    zipInputStream2 = zipInputStream3;
                    fileInputStream2 = fileInputStream;
                    zipInputStream = zipInputStream2;
                    FileUtils.deleteFolder(str2);
                    if (fileInputStream2 != null) {
                    }
                    if (zipInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipInputStream2 = null;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                zipInputStream = zipInputStream2;
                FileUtils.deleteFolder(str2);
                if (fileInputStream2 != null) {
                }
                if (zipInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                Log.d("yklresouce", str + "  start getNextEntry");
                fileOutputStream = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream4.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        Log.d("yklresouce", str + "  ze.getName() = " + name);
                        if (!nextEntry.isDirectory()) {
                            File file3 = new File(absolutePath + "/" + name);
                            file3.deleteOnExit();
                            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                            while (true) {
                                try {
                                    int read = zipInputStream4.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream3.write(bArr, 0, read);
                                } catch (Exception e3) {
                                    e = e3;
                                    fileOutputStream = fileOutputStream3;
                                    zipInputStream3 = zipInputStream4;
                                    ResourceUTUtils.unZipFile(str, false);
                                    Log.e("yklresouce", "unzip  failed  " + str);
                                    e.printStackTrace();
                                    FileUtils.deleteFolder(file2.getAbsolutePath());
                                    FileUtils.deleteFolder(str2);
                                    if (fileInputStream != null) {
                                    }
                                    if (zipInputStream3 != 0) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    return null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileInputStream2 = fileInputStream;
                                    fileOutputStream = fileOutputStream3;
                                    zipInputStream = zipInputStream4;
                                    FileUtils.deleteFolder(str2);
                                    if (fileInputStream2 != null) {
                                    }
                                    if (zipInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream3.close();
                            zipInputStream4.closeEntry();
                            fileOutputStream = fileOutputStream3;
                        } else {
                            File file4 = new File(absolutePath + "/" + name);
                            file4.deleteOnExit();
                            file4.mkdirs();
                        }
                        ResourceUTUtils.unZipFile(str, true);
                        Log.d("yklresouce", "un zip  success " + str);
                    } catch (Exception e4) {
                        e = e4;
                        zipInputStream3 = zipInputStream4;
                        ResourceUTUtils.unZipFile(str, false);
                        Log.e("yklresouce", "unzip  failed  " + str);
                        e.printStackTrace();
                        FileUtils.deleteFolder(file2.getAbsolutePath());
                        FileUtils.deleteFolder(str2);
                        if (fileInputStream != null) {
                        }
                        if (zipInputStream3 != 0) {
                        }
                        if (fileOutputStream != null) {
                        }
                        return null;
                    }
                }
                Log.d("yklresouce", str + "  end while getNextEntry");
                zipInputStream4.close();
                AfterDownloadProcessor.ProcessedResource processedResource = new AfterDownloadProcessor.ProcessedResource(absolutePath);
                FileUtils.deleteFolder(str2);
                try {
                    fileInputStream.close();
                    zipInputStream4.close();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return processedResource;
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                zipInputStream3 = zipInputStream4;
                ResourceUTUtils.unZipFile(str, false);
                Log.e("yklresouce", "unzip  failed  " + str);
                e.printStackTrace();
                FileUtils.deleteFolder(file2.getAbsolutePath());
                FileUtils.deleteFolder(str2);
                if (fileInputStream != null) {
                }
                if (zipInputStream3 != 0) {
                }
                if (fileOutputStream != null) {
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                zipInputStream2 = zipInputStream4;
                fileInputStream2 = fileInputStream;
                zipInputStream = zipInputStream2;
                FileUtils.deleteFolder(str2);
                if (fileInputStream2 != null) {
                }
                if (zipInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            fileOutputStream2 = null;
            fileOutputStream = fileOutputStream2;
            zipInputStream3 = fileOutputStream2;
            ResourceUTUtils.unZipFile(str, false);
            Log.e("yklresouce", "unzip  failed  " + str);
            e.printStackTrace();
            FileUtils.deleteFolder(file2.getAbsolutePath());
            FileUtils.deleteFolder(str2);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return null;
                }
            }
            if (zipInputStream3 != 0) {
                zipInputStream3.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
            fileOutputStream = null;
            FileUtils.deleteFolder(str2);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
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

    @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor.Processor
    public boolean interruptable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-816794514")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-816794514", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor.Processor
    public AfterDownloadProcessor.ProcessedResource process(Config config, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911601299")) {
            return (AfterDownloadProcessor.ProcessedResource) ipChange.ipc$dispatch("-911601299", new Object[]{this, config, str, str2});
        }
        Log.d("YKLPrefetchManager", "process file name = " + str + "  file = " + str2);
        if (!str2.endsWith(".zip")) {
            Log.d("YKLPrefetchManager", "modify file name" + str);
            String str3 = str2 + ".zip";
            new File(str2).renameTo(new File(str3));
            str2 = str3;
        }
        return unZipFile(config, str, str2);
    }
}
