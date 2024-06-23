package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.j;
import com.uc.webview.export.internal.utility.p;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import tb.jl1;

/* compiled from: Taobao */
public class aw extends UCSubSetupTask<aw, aw> {
    private static final String a = aw.class.getSimpleName();
    private static Object b = new Object();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        private static long A = 0;
        private static long B = 0;
        private static long C = 0;
        private static long D = 0;
        private static long E = 0;
        private static long F = 0;
        private static long G = 0;
        private static long H = 0;
        private static long I = 0;
        private static long J = 0;
        private static long a = 1;
        private static long b = 2;
        private static long c = 4;
        private static long d = 8;
        private static long e = 16;
        private static long f = 32;
        private static long g = 64;
        private static long h = 128;
        private static long i = 256;
        private static long j = 512;
        private static long k = 1024;
        private static long l = 2048;
        private static long m = 4096;
        private static long n = 8192;
        private static long o = 16384;
        private static long p = 32768;
        private static long q;
        private static long r;
        private static long s;
        private static long t;
        private static long u;
        private static long v;
        private static long w;
        private static long x;
        private static long y;
        private static long z;

        static {
            long j2 = 1 << 1;
            q = j2;
            long j3 = j2 << 1;
            r = j3;
            long j4 = j3 << 1;
            s = j4;
            long j5 = j4 << 1;
            t = j5;
            u = j5 << 1;
            long j6 = 1 << 1;
            v = j6;
            long j7 = j6 << 1;
            w = j7;
            long j8 = j7 << 1;
            x = j8;
            long j9 = j8 << 1;
            y = j9;
            z = j9 << 1;
            long j10 = 1 << 1;
            A = j10;
            long j11 = j10 << 1;
            B = j11;
            long j12 = j11 << 1;
            C = j12;
            long j13 = j12 << 1;
            D = j13;
            long j14 = j13 << 1;
            E = j14;
            long j15 = j14 << 1;
            F = j15;
            long j16 = j15 << 1;
            G = j16;
            long j17 = j16 << 1;
            H = j17;
            long j18 = j17 << 1;
            I = j18;
            J = j18 << 1;
        }

        private a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:190:?, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_TIMECOST, java.lang.Long.toString(r18));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x07ef, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, java.lang.Long.toString(r5));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, java.lang.Long.toString(r3));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, java.lang.Long.toString(r7));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r13, java.lang.Long.toString(r9));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r1, java.lang.Long.toString(r11));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, java.lang.Long.toString(r12));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0823, code lost:
            if (r12 != com.uc.webview.export.internal.setup.aw.a.B) goto L_0x0829;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0825, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r16);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x082d, code lost:
            if (r12 != com.uc.webview.export.internal.setup.aw.a.G) goto L_0x0833;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x082f, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r17);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0833, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r23);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0836, code lost:
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fProcessStat: " + r5);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, r16 + r3);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fSdcardAuthoryStat: " + r7);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fDeleteStat: " + r9);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fPreconditionStat: " + r11);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            r1 = new java.lang.StringBuilder(r29);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x08b1, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x08b2, code lost:
            r20 = r3;
            r57 = r7;
            r18 = r9;
            r11 = r13;
            r1 = r1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:267:0x0b85  */
        /* JADX WARNING: Removed duplicated region for block: B:268:0x0b89  */
        /* JADX WARNING: Removed duplicated region for block: B:307:0x0d2b  */
        /* JADX WARNING: Removed duplicated region for block: B:308:0x0d2f  */
        /* JADX WARNING: Removed duplicated region for block: B:322:0x0e08  */
        /* JADX WARNING: Removed duplicated region for block: B:326:0x0e16  */
        public static void a(Context context, String str, int i2) {
            long j2;
            String str2;
            long j3;
            long j4;
            String str3;
            long j5;
            long j6;
            String str4;
            String str5;
            long j7;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            Throwable th;
            String str14;
            String str15;
            String str16;
            long j8;
            Throwable th2;
            long j9;
            String str17;
            StringBuilder sb;
            String str18;
            String str19;
            String str20;
            String str21;
            Throwable th3;
            long j10;
            long j11;
            String str22;
            boolean z2;
            long j12;
            long a2;
            long j13;
            String str23 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_DELETE;
            String str24 = aw.a;
            Log.d(str24, ".shareCoreDecFile " + str);
            long j14 = a;
            try {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_TOTEL_COUNT_PV);
                if (!"0".equals((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
                    try {
                        long j15 = e;
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j15));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j14));
                        IWaStat.WaStat.stat(str23, Long.toString(j14));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION, Long.toString(j14));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(j14));
                        if (j14 == B) {
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_SUCCESS_PV);
                        } else if (j14 == G) {
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_HAS_EXISTS_PV);
                        } else {
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_OTHER_PV);
                        }
                        String str25 = aw.a;
                        Log.d(str25, ".shareCoreDecFile fProcessStat: " + j15);
                        String str26 = aw.a;
                        Log.d(str26, ".shareCoreDecFile fProcessStatExp: " + j14);
                        String str27 = aw.a;
                        Log.d(str27, ".shareCoreDecFile fSdcardAuthoryStat: " + j14);
                        String str28 = aw.a;
                        Log.d(str28, ".shareCoreDecFile fDeleteStat: " + j14);
                        String str29 = aw.a;
                        Log.d(str29, ".shareCoreDecFile fPreconditionStat: " + j14);
                        str17 = aw.a;
                        sb = new StringBuilder(".shareCoreDecFile fCopyStat: ");
                    } catch (Throwable th4) {
                        th = th4;
                        j2 = j14;
                        j5 = j2;
                        j4 = j5;
                        j3 = j4;
                        str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                        str2 = ".shareCoreDecFile fCopyStat: ";
                        str8 = ".shareCoreDecFile fProcessStatExp: ";
                        str9 = ".shareCoreDecFile fProcessStat: ";
                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                        str12 = ".shareCoreDecFile fDeleteStat: ";
                        j6 = j3;
                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                        str4 = IWaStat.SHARE_CORE_COPY_HAS_EXISTS_PV;
                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                        str6 = str23;
                        j7 = j6;
                        try {
                            j9 = f;
                            try {
                                try {
                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                    j14 = j3;
                                    if (j14 == B) {
                                    }
                                    String str30 = aw.a;
                                    Log.d(str30, str9 + j7);
                                    String str31 = aw.a;
                                    Log.d(str31, str8 + j9);
                                    String str32 = aw.a;
                                    Log.d(str32, str7 + j2);
                                    String str33 = aw.a;
                                    Log.d(str33, str12 + j6);
                                    String str34 = aw.a;
                                    Log.d(str34, str11 + j4);
                                    str17 = aw.a;
                                    sb = new StringBuilder(str2);
                                    sb.append(j14);
                                    Log.d(str17, sb.toString());
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    j5 = j9;
                                    str16 = str12;
                                    j8 = j3;
                                    str15 = str11;
                                    str14 = str2;
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j5));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                    IWaStat.WaStat.stat(str10, Long.toString(j8));
                                    if (j8 == B) {
                                        IWaStat.WaStat.stat(str5);
                                    } else if (j8 == G) {
                                        IWaStat.WaStat.stat(str4);
                                    } else {
                                        IWaStat.WaStat.stat(str3);
                                    }
                                    String str35 = aw.a;
                                    Log.d(str35, str9 + j7);
                                    String str36 = aw.a;
                                    Log.d(str36, str8 + j5);
                                    String str37 = aw.a;
                                    Log.d(str37, str7 + j2);
                                    String str38 = aw.a;
                                    Log.d(str38, str16 + j6);
                                    String str39 = aw.a;
                                    Log.d(str39, str15 + j4);
                                    String str40 = aw.a;
                                    Log.d(str40, str14 + j8);
                                    throw th2;
                                }
                            } catch (Throwable th6) {
                                th2 = th6;
                                j5 = j9;
                                str15 = str11;
                                str14 = str2;
                                str16 = str12;
                                j8 = j3;
                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j5));
                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                IWaStat.WaStat.stat(str10, Long.toString(j8));
                                if (j8 == B) {
                                }
                                String str352 = aw.a;
                                Log.d(str352, str9 + j7);
                                String str362 = aw.a;
                                Log.d(str362, str8 + j5);
                                String str372 = aw.a;
                                Log.d(str372, str7 + j2);
                                String str382 = aw.a;
                                Log.d(str382, str16 + j6);
                                String str392 = aw.a;
                                Log.d(str392, str15 + j4);
                                String str402 = aw.a;
                                Log.d(str402, str14 + j8);
                                throw th2;
                            }
                        } catch (Throwable th7) {
                            th2 = th7;
                            str16 = str12;
                            str15 = str11;
                            j8 = j3;
                            str14 = str2;
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j5));
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                            IWaStat.WaStat.stat(str6, Long.toString(j6));
                            IWaStat.WaStat.stat(str13, Long.toString(j4));
                            IWaStat.WaStat.stat(str10, Long.toString(j8));
                            if (j8 == B) {
                            }
                            String str3522 = aw.a;
                            Log.d(str3522, str9 + j7);
                            String str3622 = aw.a;
                            Log.d(str3622, str8 + j5);
                            String str3722 = aw.a;
                            Log.d(str3722, str7 + j2);
                            String str3822 = aw.a;
                            Log.d(str3822, str16 + j6);
                            String str3922 = aw.a;
                            Log.d(str3922, str15 + j4);
                            String str4022 = aw.a;
                            Log.d(str4022, str14 + j8);
                            throw th2;
                        }
                    }
                    sb.append(j14);
                    Log.d(str17, sb.toString());
                }
                try {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_MAIN_PROCESS_COUNT_PV);
                } catch (Throwable th8) {
                    th = th8;
                    str4 = IWaStat.SHARE_CORE_COPY_HAS_EXISTS_PV;
                    str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                    str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                    str8 = ".shareCoreDecFile fProcessStatExp: ";
                    str9 = ".shareCoreDecFile fProcessStat: ";
                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                    str6 = str23;
                    str18 = ".shareCoreDecFile fCopyStat: ";
                    str12 = ".shareCoreDecFile fDeleteStat: ";
                    str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                    j5 = j14;
                    str2 = str18;
                    j2 = j5;
                    j7 = j2;
                    j6 = j7;
                    j4 = j6;
                    j3 = j4;
                    j9 = f;
                    Log.d(aw.a, ".shareCoreDecFile", th);
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                    j14 = j3;
                    if (j14 == B) {
                    }
                    String str302 = aw.a;
                    Log.d(str302, str9 + j7);
                    String str312 = aw.a;
                    Log.d(str312, str8 + j9);
                    String str322 = aw.a;
                    Log.d(str322, str7 + j2);
                    String str332 = aw.a;
                    Log.d(str332, str12 + j6);
                    String str342 = aw.a;
                    Log.d(str342, str11 + j4);
                    str17 = aw.a;
                    sb = new StringBuilder(str2);
                    sb.append(j14);
                    Log.d(str17, sb.toString());
                }
                try {
                    long j16 = g;
                    str4 = IWaStat.SHARE_CORE_COPY_HAS_EXISTS_PV;
                    try {
                        long a3 = j.a(context);
                        try {
                            if (j.a != a3) {
                                try {
                                    try {
                                        Log.d(aw.a, ".run Sdcard权限检查失败");
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j16));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                        IWaStat.WaStat.stat(str23, Long.toString(j14));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION, Long.toString(j14));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(j14));
                                        if (j14 == B) {
                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_SUCCESS_PV);
                                        } else if (j14 == G) {
                                            IWaStat.WaStat.stat(str4);
                                        } else {
                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_OTHER_PV);
                                        }
                                        String str41 = aw.a;
                                        Log.d(str41, ".shareCoreDecFile fProcessStat: " + j16);
                                        String str42 = aw.a;
                                        Log.d(str42, ".shareCoreDecFile fProcessStatExp: " + j14);
                                        String str43 = aw.a;
                                        Log.d(str43, ".shareCoreDecFile fSdcardAuthoryStat: " + a3);
                                        String str44 = aw.a;
                                        Log.d(str44, ".shareCoreDecFile fDeleteStat: " + j14);
                                        String str45 = aw.a;
                                        Log.d(str45, ".shareCoreDecFile fPreconditionStat: " + j14);
                                        str17 = aw.a;
                                        sb = new StringBuilder(".shareCoreDecFile fCopyStat: ");
                                    } catch (Throwable th9) {
                                        th = th9;
                                        j4 = j14;
                                        j3 = j4;
                                        j2 = a3;
                                        str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                        str6 = str23;
                                        str8 = ".shareCoreDecFile fProcessStatExp: ";
                                        str2 = ".shareCoreDecFile fCopyStat: ";
                                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                                        str12 = ".shareCoreDecFile fDeleteStat: ";
                                        j5 = j3;
                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                        j7 = j16;
                                        j6 = j5;
                                        j9 = f;
                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                        j14 = j3;
                                        if (j14 == B) {
                                        }
                                        String str3022 = aw.a;
                                        Log.d(str3022, str9 + j7);
                                        String str3122 = aw.a;
                                        Log.d(str3122, str8 + j9);
                                        String str3222 = aw.a;
                                        Log.d(str3222, str7 + j2);
                                        String str3322 = aw.a;
                                        Log.d(str3322, str12 + j6);
                                        String str3422 = aw.a;
                                        Log.d(str3422, str11 + j4);
                                        str17 = aw.a;
                                        sb = new StringBuilder(str2);
                                        sb.append(j14);
                                        Log.d(str17, sb.toString());
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    j3 = j14;
                                    j2 = a3;
                                    str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                    str6 = str23;
                                    str8 = ".shareCoreDecFile fProcessStatExp: ";
                                    str2 = ".shareCoreDecFile fCopyStat: ";
                                    str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                                    str12 = ".shareCoreDecFile fDeleteStat: ";
                                    j5 = j3;
                                    j4 = j5;
                                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                    str9 = ".shareCoreDecFile fProcessStat: ";
                                    str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                    j7 = j16;
                                    j6 = j4;
                                    j9 = f;
                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                    j14 = j3;
                                    if (j14 == B) {
                                    }
                                    String str30222 = aw.a;
                                    Log.d(str30222, str9 + j7);
                                    String str31222 = aw.a;
                                    Log.d(str31222, str8 + j9);
                                    String str32222 = aw.a;
                                    Log.d(str32222, str7 + j2);
                                    String str33222 = aw.a;
                                    Log.d(str33222, str12 + j6);
                                    String str34222 = aw.a;
                                    Log.d(str34222, str11 + j4);
                                    str17 = aw.a;
                                    sb = new StringBuilder(str2);
                                    sb.append(j14);
                                    Log.d(str17, sb.toString());
                                }
                                sb.append(j14);
                                Log.d(str17, sb.toString());
                            }
                            try {
                                long j17 = h;
                                try {
                                    try {
                                        File a4 = j.a(new File(j.a()), context.getPackageName());
                                        if (!a4.exists()) {
                                            try {
                                                long j18 = d;
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j18));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                                IWaStat.WaStat.stat(str23, Long.toString(j14));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION, Long.toString(j14));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(j14));
                                                if (j14 == B) {
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_SUCCESS_PV);
                                                } else if (j14 == G) {
                                                    IWaStat.WaStat.stat(str4);
                                                } else {
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_OTHER_PV);
                                                }
                                                String str46 = aw.a;
                                                Log.d(str46, ".shareCoreDecFile fProcessStat: " + j18);
                                                String str47 = aw.a;
                                                Log.d(str47, ".shareCoreDecFile fProcessStatExp: " + j14);
                                                String str48 = aw.a;
                                                Log.d(str48, ".shareCoreDecFile fSdcardAuthoryStat: " + a3);
                                                String str49 = aw.a;
                                                Log.d(str49, ".shareCoreDecFile fDeleteStat: " + j14);
                                                String str50 = aw.a;
                                                Log.d(str50, ".shareCoreDecFile fPreconditionStat: " + j14);
                                                str17 = aw.a;
                                                sb = new StringBuilder(".shareCoreDecFile fCopyStat: ");
                                            } catch (Throwable th11) {
                                                th3 = th11;
                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                str6 = str23;
                                                str8 = ".shareCoreDecFile fProcessStatExp: ";
                                                str20 = ".shareCoreDecFile fDeleteStat: ";
                                                str21 = ".shareCoreDecFile fPreconditionStat: ";
                                                str19 = ".shareCoreDecFile fCopyStat: ";
                                                str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                try {
                                                    j7 = m;
                                                    try {
                                                        try {
                                                            Log.d(aw.a, ".shareCoreDecFile createAppSubFolder", th3);
                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                                            IWaStat.WaStat.stat(str6, Long.toString(j14));
                                                            IWaStat.WaStat.stat(str13, Long.toString(j14));
                                                            IWaStat.WaStat.stat(str10, Long.toString(j14));
                                                            if (j14 == B) {
                                                            }
                                                            String str51 = aw.a;
                                                            Log.d(str51, str9 + j7);
                                                            String str52 = aw.a;
                                                            Log.d(str52, str8 + j14);
                                                            String str53 = aw.a;
                                                            Log.d(str53, str7 + a3);
                                                            String str54 = aw.a;
                                                            Log.d(str54, str20 + j14);
                                                            String str55 = aw.a;
                                                            Log.d(str55, str21 + j14);
                                                            str17 = aw.a;
                                                            sb = new StringBuilder(str19);
                                                        } catch (Throwable th12) {
                                                            th = th12;
                                                            j10 = a3;
                                                            str7 = str7;
                                                            str8 = str8;
                                                            str11 = str21;
                                                            j5 = j14;
                                                            str12 = str20;
                                                            j6 = j5;
                                                            j3 = j6;
                                                            j2 = j10;
                                                            str2 = str19;
                                                            j4 = j3;
                                                            j9 = f;
                                                            Log.d(aw.a, ".shareCoreDecFile", th);
                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                            IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                            IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                            IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                            j14 = j3;
                                                            if (j14 == B) {
                                                            }
                                                            String str302222 = aw.a;
                                                            Log.d(str302222, str9 + j7);
                                                            String str312222 = aw.a;
                                                            Log.d(str312222, str8 + j9);
                                                            String str322222 = aw.a;
                                                            Log.d(str322222, str7 + j2);
                                                            String str332222 = aw.a;
                                                            Log.d(str332222, str12 + j6);
                                                            String str342222 = aw.a;
                                                            Log.d(str342222, str11 + j4);
                                                            str17 = aw.a;
                                                            sb = new StringBuilder(str2);
                                                            sb.append(j14);
                                                            Log.d(str17, sb.toString());
                                                        }
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        j10 = a3;
                                                        str7 = str7;
                                                        str11 = str21;
                                                        j5 = j14;
                                                        str12 = str20;
                                                        j6 = j5;
                                                        j3 = j6;
                                                        j2 = j10;
                                                        str2 = str19;
                                                        j4 = j3;
                                                        j9 = f;
                                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                        j14 = j3;
                                                        if (j14 == B) {
                                                        }
                                                        String str3022222 = aw.a;
                                                        Log.d(str3022222, str9 + j7);
                                                        String str3122222 = aw.a;
                                                        Log.d(str3122222, str8 + j9);
                                                        String str3222222 = aw.a;
                                                        Log.d(str3222222, str7 + j2);
                                                        String str3322222 = aw.a;
                                                        Log.d(str3322222, str12 + j6);
                                                        String str3422222 = aw.a;
                                                        Log.d(str3422222, str11 + j4);
                                                        str17 = aw.a;
                                                        sb = new StringBuilder(str2);
                                                        sb.append(j14);
                                                        Log.d(str17, sb.toString());
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    j10 = a3;
                                                    str11 = str21;
                                                    j5 = j14;
                                                    str12 = str20;
                                                    j7 = j17;
                                                    j6 = j5;
                                                    j3 = j6;
                                                    j2 = j10;
                                                    str2 = str19;
                                                    j4 = j3;
                                                    j9 = f;
                                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                    j14 = j3;
                                                    if (j14 == B) {
                                                        IWaStat.WaStat.stat(str5);
                                                    } else if (j14 == G) {
                                                        IWaStat.WaStat.stat(str4);
                                                    } else {
                                                        IWaStat.WaStat.stat(str3);
                                                    }
                                                    String str30222222 = aw.a;
                                                    Log.d(str30222222, str9 + j7);
                                                    String str31222222 = aw.a;
                                                    Log.d(str31222222, str8 + j9);
                                                    String str32222222 = aw.a;
                                                    Log.d(str32222222, str7 + j2);
                                                    String str33222222 = aw.a;
                                                    Log.d(str33222222, str12 + j6);
                                                    String str34222222 = aw.a;
                                                    Log.d(str34222222, str11 + j4);
                                                    str17 = aw.a;
                                                    sb = new StringBuilder(str2);
                                                    sb.append(j14);
                                                    Log.d(str17, sb.toString());
                                                }
                                                sb.append(j14);
                                                Log.d(str17, sb.toString());
                                            }
                                        } else {
                                            str2 = ".shareCoreDecFile fCopyStat: ";
                                            try {
                                                j11 = i;
                                                Boolean valueOf = Boolean.valueOf(Boolean.parseBoolean(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_COPY_SDCARD)));
                                                if (valueOf == null) {
                                                    str22 = ".shareCoreDecFile fProcessStatExp: ";
                                                    z2 = false;
                                                } else {
                                                    try {
                                                        z2 = valueOf.booleanValue();
                                                        str22 = ".shareCoreDecFile fProcessStatExp: ";
                                                    } catch (Throwable th15) {
                                                        th = th15;
                                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                                        str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                        str8 = ".shareCoreDecFile fProcessStatExp: ";
                                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                        str6 = str23;
                                                        j4 = j14;
                                                        j2 = a3;
                                                        j7 = j11;
                                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                        j6 = j4;
                                                        j5 = j6;
                                                        str12 = ".shareCoreDecFile fDeleteStat: ";
                                                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                        j3 = j5;
                                                        j9 = f;
                                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                        j14 = j3;
                                                        if (j14 == B) {
                                                        }
                                                        String str302222222 = aw.a;
                                                        Log.d(str302222222, str9 + j7);
                                                        String str312222222 = aw.a;
                                                        Log.d(str312222222, str8 + j9);
                                                        String str322222222 = aw.a;
                                                        Log.d(str322222222, str7 + j2);
                                                        String str332222222 = aw.a;
                                                        Log.d(str332222222, str12 + j6);
                                                        String str342222222 = aw.a;
                                                        Log.d(str342222222, str11 + j4);
                                                        str17 = aw.a;
                                                        sb = new StringBuilder(str2);
                                                        sb.append(j14);
                                                        Log.d(str17, sb.toString());
                                                    }
                                                }
                                            } catch (Throwable th16) {
                                                th = th16;
                                                str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                                str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                str8 = ".shareCoreDecFile fProcessStatExp: ";
                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                str6 = str23;
                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                j5 = j14;
                                                j4 = j5;
                                                j2 = a3;
                                                j7 = j11;
                                                j6 = j4;
                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                j3 = j6;
                                                j9 = f;
                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                j14 = j3;
                                                if (j14 == B) {
                                                }
                                                String str3022222222 = aw.a;
                                                Log.d(str3022222222, str9 + j7);
                                                String str3122222222 = aw.a;
                                                Log.d(str3122222222, str8 + j9);
                                                String str3222222222 = aw.a;
                                                Log.d(str3222222222, str7 + j2);
                                                String str3322222222 = aw.a;
                                                Log.d(str3322222222, str12 + j6);
                                                String str3422222222 = aw.a;
                                                Log.d(str3422222222, str11 + j4);
                                                str17 = aw.a;
                                                sb = new StringBuilder(str2);
                                                sb.append(j14);
                                                Log.d(str17, sb.toString());
                                            }
                                            try {
                                                String str56 = aw.a;
                                                try {
                                                    str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                                    try {
                                                        Log.d(str56, "配置允许内核共享:" + z2);
                                                        if (!z2) {
                                                            try {
                                                                long j19 = c;
                                                                try {
                                                                    UCCyclone.recursiveDelete(a4, false, null);
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j19));
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                                                    IWaStat.WaStat.stat(str23, Long.toString(j14));
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION, Long.toString(j14));
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(j14));
                                                                    if (j14 == B) {
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_SUCCESS_PV);
                                                                    } else if (j14 == G) {
                                                                        IWaStat.WaStat.stat(str4);
                                                                    } else {
                                                                        IWaStat.WaStat.stat(str3);
                                                                    }
                                                                    String str57 = aw.a;
                                                                    Log.d(str57, ".shareCoreDecFile fProcessStat: " + j19);
                                                                    String str58 = aw.a;
                                                                    Log.d(str58, str22 + j14);
                                                                    String str59 = aw.a;
                                                                    Log.d(str59, ".shareCoreDecFile fSdcardAuthoryStat: " + a3);
                                                                    String str60 = aw.a;
                                                                    Log.d(str60, ".shareCoreDecFile fDeleteStat: " + j14);
                                                                    String str61 = aw.a;
                                                                    Log.d(str61, ".shareCoreDecFile fPreconditionStat: " + j14);
                                                                    str17 = aw.a;
                                                                    sb = new StringBuilder(str2);
                                                                } catch (Throwable th17) {
                                                                    th = th17;
                                                                    j6 = j14;
                                                                    j4 = j6;
                                                                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                    str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                    str6 = str23;
                                                                    str8 = str22;
                                                                    str9 = ".shareCoreDecFile fProcessStat: ";
                                                                    j7 = j19;
                                                                    j2 = a3;
                                                                    str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                    str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                    j5 = j4;
                                                                    j3 = j5;
                                                                    j9 = f;
                                                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                    j14 = j3;
                                                                    if (j14 == B) {
                                                                    }
                                                                    String str30222222222 = aw.a;
                                                                    Log.d(str30222222222, str9 + j7);
                                                                    String str31222222222 = aw.a;
                                                                    Log.d(str31222222222, str8 + j9);
                                                                    String str32222222222 = aw.a;
                                                                    Log.d(str32222222222, str7 + j2);
                                                                    String str33222222222 = aw.a;
                                                                    Log.d(str33222222222, str12 + j6);
                                                                    String str34222222222 = aw.a;
                                                                    Log.d(str34222222222, str11 + j4);
                                                                    str17 = aw.a;
                                                                    sb = new StringBuilder(str2);
                                                                    sb.append(j14);
                                                                    Log.d(str17, sb.toString());
                                                                }
                                                            } catch (Throwable th18) {
                                                                th = th18;
                                                                j4 = j14;
                                                                j2 = a3;
                                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                str6 = str23;
                                                                str8 = str22;
                                                                j7 = j11;
                                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                                j6 = j4;
                                                                str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                j5 = j6;
                                                                j3 = j5;
                                                                j9 = f;
                                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                j14 = j3;
                                                                if (j14 == B) {
                                                                }
                                                                String str302222222222 = aw.a;
                                                                Log.d(str302222222222, str9 + j7);
                                                                String str312222222222 = aw.a;
                                                                Log.d(str312222222222, str8 + j9);
                                                                String str322222222222 = aw.a;
                                                                Log.d(str322222222222, str7 + j2);
                                                                String str332222222222 = aw.a;
                                                                Log.d(str332222222222, str12 + j6);
                                                                String str342222222222 = aw.a;
                                                                Log.d(str342222222222, str11 + j4);
                                                                str17 = aw.a;
                                                                sb = new StringBuilder(str2);
                                                                sb.append(j14);
                                                                Log.d(str17, sb.toString());
                                                            }
                                                        } else {
                                                            try {
                                                                j11 = o;
                                                                if (p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_PUSH_UCM_VERSIONS))) {
                                                                    try {
                                                                        long j20 = p;
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j20));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                                                        IWaStat.WaStat.stat(str23, Long.toString(j14));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION, Long.toString(j14));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(j14));
                                                                        if (j14 == B) {
                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_SUCCESS_PV);
                                                                        } else if (j14 == G) {
                                                                            IWaStat.WaStat.stat(str4);
                                                                        } else {
                                                                            IWaStat.WaStat.stat(str3);
                                                                        }
                                                                        String str62 = aw.a;
                                                                        Log.d(str62, ".shareCoreDecFile fProcessStat: " + j20);
                                                                        String str63 = aw.a;
                                                                        Log.d(str63, str22 + j14);
                                                                        String str64 = aw.a;
                                                                        Log.d(str64, ".shareCoreDecFile fSdcardAuthoryStat: " + a3);
                                                                        String str65 = aw.a;
                                                                        Log.d(str65, ".shareCoreDecFile fDeleteStat: " + j14);
                                                                        String str66 = aw.a;
                                                                        Log.d(str66, ".shareCoreDecFile fPreconditionStat: " + j14);
                                                                        str17 = aw.a;
                                                                        sb = new StringBuilder(str2);
                                                                    } catch (Throwable th19) {
                                                                        th = th19;
                                                                        j5 = j14;
                                                                        j4 = j5;
                                                                        j3 = j4;
                                                                        j2 = a3;
                                                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                        str6 = str23;
                                                                        str2 = str2;
                                                                        str8 = str22;
                                                                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                        j7 = j11;
                                                                        str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                        j6 = j3;
                                                                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                        j9 = f;
                                                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                        j14 = j3;
                                                                        if (j14 == B) {
                                                                        }
                                                                        String str3022222222222 = aw.a;
                                                                        Log.d(str3022222222222, str9 + j7);
                                                                        String str3122222222222 = aw.a;
                                                                        Log.d(str3122222222222, str8 + j9);
                                                                        String str3222222222222 = aw.a;
                                                                        Log.d(str3222222222222, str7 + j2);
                                                                        String str3322222222222 = aw.a;
                                                                        Log.d(str3322222222222, str12 + j6);
                                                                        String str3422222222222 = aw.a;
                                                                        Log.d(str3422222222222, str11 + j4);
                                                                        str17 = aw.a;
                                                                        sb = new StringBuilder(str2);
                                                                        sb.append(j14);
                                                                        Log.d(str17, sb.toString());
                                                                    }
                                                                } else {
                                                                    try {
                                                                        long j21 = j;
                                                                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                                        try {
                                                                            long a5 = a(context, a4);
                                                                            try {
                                                                                long j22 = k;
                                                                                try {
                                                                                    long a6 = a(i2);
                                                                                    try {
                                                                                        if (q != a6) {
                                                                                            try {
                                                                                            } catch (Throwable th20) {
                                                                                                th = th20;
                                                                                                j3 = j14;
                                                                                                j2 = a3;
                                                                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                str2 = str2;
                                                                                                j4 = a6;
                                                                                                str6 = str23;
                                                                                                j7 = j22;
                                                                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                j6 = a5;
                                                                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                str8 = str22;
                                                                                                j5 = j3;
                                                                                                j9 = f;
                                                                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                j14 = j3;
                                                                                                if (j14 == B) {
                                                                                                }
                                                                                                String str30222222222222 = aw.a;
                                                                                                Log.d(str30222222222222, str9 + j7);
                                                                                                String str31222222222222 = aw.a;
                                                                                                Log.d(str31222222222222, str8 + j9);
                                                                                                String str32222222222222 = aw.a;
                                                                                                Log.d(str32222222222222, str7 + j2);
                                                                                                String str33222222222222 = aw.a;
                                                                                                Log.d(str33222222222222, str12 + j6);
                                                                                                String str34222222222222 = aw.a;
                                                                                                Log.d(str34222222222222, str11 + j4);
                                                                                                str17 = aw.a;
                                                                                                sb = new StringBuilder(str2);
                                                                                                sb.append(j14);
                                                                                                Log.d(str17, sb.toString());
                                                                                            }
                                                                                            try {
                                                                                                Log.d(aw.a, ".run 先决条件判断失败！");
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j22));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                                                                                IWaStat.WaStat.stat(str23, Long.toString(a5));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION, Long.toString(a6));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(j14));
                                                                                                if (j14 == B) {
                                                                                                    IWaStat.WaStat.stat(str5);
                                                                                                } else if (j14 == G) {
                                                                                                    IWaStat.WaStat.stat(str4);
                                                                                                } else {
                                                                                                    IWaStat.WaStat.stat(str3);
                                                                                                }
                                                                                                String str67 = aw.a;
                                                                                                Log.d(str67, ".shareCoreDecFile fProcessStat: " + j22);
                                                                                                String str68 = aw.a;
                                                                                                Log.d(str68, str22 + j14);
                                                                                                String str69 = aw.a;
                                                                                                Log.d(str69, ".shareCoreDecFile fSdcardAuthoryStat: " + a3);
                                                                                                String str70 = aw.a;
                                                                                                Log.d(str70, ".shareCoreDecFile fDeleteStat: " + a5);
                                                                                                String str71 = aw.a;
                                                                                                Log.d(str71, ".shareCoreDecFile fPreconditionStat: " + a6);
                                                                                                str17 = aw.a;
                                                                                                sb = new StringBuilder(str2);
                                                                                            } catch (Throwable th21) {
                                                                                                th = th21;
                                                                                                j2 = a3;
                                                                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                str2 = str2;
                                                                                                j4 = a6;
                                                                                                str6 = str23;
                                                                                                j7 = j22;
                                                                                                j6 = a5;
                                                                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                str8 = str22;
                                                                                                j5 = j14;
                                                                                                j3 = j5;
                                                                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                j9 = f;
                                                                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                j14 = j3;
                                                                                                if (j14 == B) {
                                                                                                }
                                                                                                String str302222222222222 = aw.a;
                                                                                                Log.d(str302222222222222, str9 + j7);
                                                                                                String str312222222222222 = aw.a;
                                                                                                Log.d(str312222222222222, str8 + j9);
                                                                                                String str322222222222222 = aw.a;
                                                                                                Log.d(str322222222222222, str7 + j2);
                                                                                                String str332222222222222 = aw.a;
                                                                                                Log.d(str332222222222222, str12 + j6);
                                                                                                String str342222222222222 = aw.a;
                                                                                                Log.d(str342222222222222, str11 + j4);
                                                                                                str17 = aw.a;
                                                                                                sb = new StringBuilder(str2);
                                                                                                sb.append(j14);
                                                                                                Log.d(str17, sb.toString());
                                                                                            }
                                                                                        } else {
                                                                                            str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                                            try {
                                                                                                long j23 = l;
                                                                                                try {
                                                                                                    if (p.a(str)) {
                                                                                                        try {
                                                                                                            long j24 = n;
                                                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j24));
                                                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                                                                                            IWaStat.WaStat.stat(str23, Long.toString(a5));
                                                                                                            IWaStat.WaStat.stat(str13, Long.toString(a6));
                                                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(j14));
                                                                                                            if (j14 == B) {
                                                                                                                IWaStat.WaStat.stat(str5);
                                                                                                            } else if (j14 == G) {
                                                                                                                IWaStat.WaStat.stat(str4);
                                                                                                            } else {
                                                                                                                IWaStat.WaStat.stat(str3);
                                                                                                            }
                                                                                                            String str72 = aw.a;
                                                                                                            Log.d(str72, ".shareCoreDecFile fProcessStat: " + j24);
                                                                                                            String str73 = aw.a;
                                                                                                            Log.d(str73, str22 + j14);
                                                                                                            String str74 = aw.a;
                                                                                                            Log.d(str74, ".shareCoreDecFile fSdcardAuthoryStat: " + a3);
                                                                                                            String str75 = aw.a;
                                                                                                            Log.d(str75, ".shareCoreDecFile fDeleteStat: " + a5);
                                                                                                            String str76 = aw.a;
                                                                                                            Log.d(str76, ".shareCoreDecFile fPreconditionStat: " + a6);
                                                                                                            str17 = aw.a;
                                                                                                            sb = new StringBuilder(str2);
                                                                                                        } catch (Throwable th22) {
                                                                                                            th = th22;
                                                                                                            j5 = j14;
                                                                                                            j3 = j5;
                                                                                                            j2 = a3;
                                                                                                            j6 = a5;
                                                                                                            str8 = str22;
                                                                                                            str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                            str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                            str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                            str2 = str2;
                                                                                                            str6 = str23;
                                                                                                            j7 = j13;
                                                                                                            str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                            str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                            j4 = a6;
                                                                                                            j9 = f;
                                                                                                            Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                            IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                            IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                            IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                            j14 = j3;
                                                                                                            if (j14 == B) {
                                                                                                            }
                                                                                                            String str3022222222222222 = aw.a;
                                                                                                            Log.d(str3022222222222222, str9 + j7);
                                                                                                            String str3122222222222222 = aw.a;
                                                                                                            Log.d(str3122222222222222, str8 + j9);
                                                                                                            String str3222222222222222 = aw.a;
                                                                                                            Log.d(str3222222222222222, str7 + j2);
                                                                                                            String str3322222222222222 = aw.a;
                                                                                                            Log.d(str3322222222222222, str12 + j6);
                                                                                                            String str3422222222222222 = aw.a;
                                                                                                            Log.d(str3422222222222222, str11 + j4);
                                                                                                            str17 = aw.a;
                                                                                                            sb = new StringBuilder(str2);
                                                                                                            sb.append(j14);
                                                                                                            Log.d(str17, sb.toString());
                                                                                                        }
                                                                                                    } else {
                                                                                                        long j25 = 0;
                                                                                                        long j26 = j14;
                                                                                                        while (true) {
                                                                                                            j25++;
                                                                                                            try {
                                                                                                                a2 = a(context, a4, str);
                                                                                                                try {
                                                                                                                    if (a2 == B) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    try {
                                                                                                                        if (a2 == G) {
                                                                                                                            break;
                                                                                                                        } else if (j25 > 3) {
                                                                                                                            break;
                                                                                                                        } else {
                                                                                                                            j26 = a2;
                                                                                                                            str23 = str23;
                                                                                                                            str13 = str13;
                                                                                                                            a6 = a6;
                                                                                                                        }
                                                                                                                    } catch (Throwable th23) {
                                                                                                                        th = th23;
                                                                                                                        str6 = str23;
                                                                                                                        str13 = str13;
                                                                                                                        j5 = j14;
                                                                                                                        j2 = a3;
                                                                                                                        j6 = a5;
                                                                                                                        j4 = a6;
                                                                                                                        str8 = str22;
                                                                                                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                                        str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                                        str2 = str2;
                                                                                                                        j3 = a2;
                                                                                                                        j7 = j23;
                                                                                                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                                        j9 = f;
                                                                                                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                                        j14 = j3;
                                                                                                                        if (j14 == B) {
                                                                                                                        }
                                                                                                                        String str30222222222222222 = aw.a;
                                                                                                                        Log.d(str30222222222222222, str9 + j7);
                                                                                                                        String str31222222222222222 = aw.a;
                                                                                                                        Log.d(str31222222222222222, str8 + j9);
                                                                                                                        String str32222222222222222 = aw.a;
                                                                                                                        Log.d(str32222222222222222, str7 + j2);
                                                                                                                        String str33222222222222222 = aw.a;
                                                                                                                        Log.d(str33222222222222222, str12 + j6);
                                                                                                                        String str34222222222222222 = aw.a;
                                                                                                                        Log.d(str34222222222222222, str11 + j4);
                                                                                                                        str17 = aw.a;
                                                                                                                        sb = new StringBuilder(str2);
                                                                                                                        sb.append(j14);
                                                                                                                        Log.d(str17, sb.toString());
                                                                                                                    }
                                                                                                                } catch (Throwable th24) {
                                                                                                                    th = th24;
                                                                                                                    j26 = a2;
                                                                                                                    str6 = str23;
                                                                                                                    str13 = str13;
                                                                                                                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                                    str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                                    j2 = a3;
                                                                                                                    j7 = j23;
                                                                                                                    str8 = str22;
                                                                                                                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                                    str2 = str2;
                                                                                                                    j4 = a6;
                                                                                                                    j6 = a5;
                                                                                                                    j3 = j26;
                                                                                                                    j5 = j14;
                                                                                                                    str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                                    j9 = f;
                                                                                                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                                    j14 = j3;
                                                                                                                    if (j14 == B) {
                                                                                                                    }
                                                                                                                    String str302222222222222222 = aw.a;
                                                                                                                    Log.d(str302222222222222222, str9 + j7);
                                                                                                                    String str312222222222222222 = aw.a;
                                                                                                                    Log.d(str312222222222222222, str8 + j9);
                                                                                                                    String str322222222222222222 = aw.a;
                                                                                                                    Log.d(str322222222222222222, str7 + j2);
                                                                                                                    String str332222222222222222 = aw.a;
                                                                                                                    Log.d(str332222222222222222, str12 + j6);
                                                                                                                    String str342222222222222222 = aw.a;
                                                                                                                    Log.d(str342222222222222222, str11 + j4);
                                                                                                                    str17 = aw.a;
                                                                                                                    sb = new StringBuilder(str2);
                                                                                                                    sb.append(j14);
                                                                                                                    Log.d(str17, sb.toString());
                                                                                                                }
                                                                                                            } catch (Throwable th25) {
                                                                                                                th = th25;
                                                                                                                str6 = str23;
                                                                                                                str13 = str13;
                                                                                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                                j2 = a3;
                                                                                                                j7 = j23;
                                                                                                                str8 = str22;
                                                                                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                                str2 = str2;
                                                                                                                j4 = a6;
                                                                                                                j6 = a5;
                                                                                                                j3 = j26;
                                                                                                                j5 = j14;
                                                                                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                                j9 = f;
                                                                                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                                j14 = j3;
                                                                                                                if (j14 == B) {
                                                                                                                }
                                                                                                                String str3022222222222222222 = aw.a;
                                                                                                                Log.d(str3022222222222222222, str9 + j7);
                                                                                                                String str3122222222222222222 = aw.a;
                                                                                                                Log.d(str3122222222222222222, str8 + j9);
                                                                                                                String str3222222222222222222 = aw.a;
                                                                                                                Log.d(str3222222222222222222, str7 + j2);
                                                                                                                String str3322222222222222222 = aw.a;
                                                                                                                Log.d(str3322222222222222222, str12 + j6);
                                                                                                                String str3422222222222222222 = aw.a;
                                                                                                                Log.d(str3422222222222222222, str11 + j4);
                                                                                                                str17 = aw.a;
                                                                                                                sb = new StringBuilder(str2);
                                                                                                                sb.append(j14);
                                                                                                                Log.d(str17, sb.toString());
                                                                                                            }
                                                                                                        }
                                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j23));
                                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                                                                                        IWaStat.WaStat.stat(str23, Long.toString(a5));
                                                                                                        IWaStat.WaStat.stat(str13, Long.toString(a6));
                                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, Long.toString(a2));
                                                                                                        if (a2 == B) {
                                                                                                            IWaStat.WaStat.stat(str5);
                                                                                                        } else if (a2 == G) {
                                                                                                            IWaStat.WaStat.stat(str4);
                                                                                                        } else {
                                                                                                            IWaStat.WaStat.stat(str3);
                                                                                                        }
                                                                                                        String str77 = aw.a;
                                                                                                        Log.d(str77, ".shareCoreDecFile fProcessStat: " + j23);
                                                                                                        String str78 = aw.a;
                                                                                                        Log.d(str78, str22 + j14);
                                                                                                        String str79 = aw.a;
                                                                                                        Log.d(str79, ".shareCoreDecFile fSdcardAuthoryStat: " + a3);
                                                                                                        String str80 = aw.a;
                                                                                                        Log.d(str80, ".shareCoreDecFile fDeleteStat: " + a5);
                                                                                                        String str81 = aw.a;
                                                                                                        Log.d(str81, ".shareCoreDecFile fPreconditionStat: " + a6);
                                                                                                        str17 = aw.a;
                                                                                                        sb = new StringBuilder(str2);
                                                                                                        sb.append(a2);
                                                                                                        Log.d(str17, sb.toString());
                                                                                                    }
                                                                                                } catch (Throwable th26) {
                                                                                                    th = th26;
                                                                                                    str6 = str23;
                                                                                                    str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                    j5 = j14;
                                                                                                    j2 = a3;
                                                                                                    j7 = j23;
                                                                                                    str8 = str22;
                                                                                                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                    str2 = str2;
                                                                                                    j4 = a6;
                                                                                                    j6 = a5;
                                                                                                    str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                    j3 = j5;
                                                                                                    j9 = f;
                                                                                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                    j14 = j3;
                                                                                                    if (j14 == B) {
                                                                                                    }
                                                                                                    String str30222222222222222222 = aw.a;
                                                                                                    Log.d(str30222222222222222222, str9 + j7);
                                                                                                    String str31222222222222222222 = aw.a;
                                                                                                    Log.d(str31222222222222222222, str8 + j9);
                                                                                                    String str32222222222222222222 = aw.a;
                                                                                                    Log.d(str32222222222222222222, str7 + j2);
                                                                                                    String str33222222222222222222 = aw.a;
                                                                                                    Log.d(str33222222222222222222, str12 + j6);
                                                                                                    String str34222222222222222222 = aw.a;
                                                                                                    Log.d(str34222222222222222222, str11 + j4);
                                                                                                    str17 = aw.a;
                                                                                                    sb = new StringBuilder(str2);
                                                                                                    sb.append(j14);
                                                                                                    Log.d(str17, sb.toString());
                                                                                                }
                                                                                            } catch (Throwable th27) {
                                                                                                th = th27;
                                                                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                                str6 = str23;
                                                                                                j2 = a3;
                                                                                                j4 = a6;
                                                                                                j7 = j22;
                                                                                                j6 = a5;
                                                                                                str8 = str22;
                                                                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                                str2 = str2;
                                                                                                j5 = j14;
                                                                                                j3 = j5;
                                                                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                                j9 = f;
                                                                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                                j14 = j3;
                                                                                                if (j14 == B) {
                                                                                                }
                                                                                                String str302222222222222222222 = aw.a;
                                                                                                Log.d(str302222222222222222222, str9 + j7);
                                                                                                String str312222222222222222222 = aw.a;
                                                                                                Log.d(str312222222222222222222, str8 + j9);
                                                                                                String str322222222222222222222 = aw.a;
                                                                                                Log.d(str322222222222222222222, str7 + j2);
                                                                                                String str332222222222222222222 = aw.a;
                                                                                                Log.d(str332222222222222222222, str12 + j6);
                                                                                                String str342222222222222222222 = aw.a;
                                                                                                Log.d(str342222222222222222222, str11 + j4);
                                                                                                str17 = aw.a;
                                                                                                sb = new StringBuilder(str2);
                                                                                                sb.append(j14);
                                                                                                Log.d(str17, sb.toString());
                                                                                            }
                                                                                        }
                                                                                    } catch (Throwable th28) {
                                                                                        th = th28;
                                                                                        str6 = str23;
                                                                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                        str8 = str22;
                                                                                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                        j2 = a3;
                                                                                        j4 = a6;
                                                                                        j7 = j22;
                                                                                        j6 = a5;
                                                                                        str2 = str2;
                                                                                        j5 = j14;
                                                                                        j3 = j5;
                                                                                        str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                        j9 = f;
                                                                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                        j14 = j3;
                                                                                        if (j14 == B) {
                                                                                        }
                                                                                        String str3022222222222222222222 = aw.a;
                                                                                        Log.d(str3022222222222222222222, str9 + j7);
                                                                                        String str3122222222222222222222 = aw.a;
                                                                                        Log.d(str3122222222222222222222, str8 + j9);
                                                                                        String str3222222222222222222222 = aw.a;
                                                                                        Log.d(str3222222222222222222222, str7 + j2);
                                                                                        String str3322222222222222222222 = aw.a;
                                                                                        Log.d(str3322222222222222222222, str12 + j6);
                                                                                        String str3422222222222222222222 = aw.a;
                                                                                        Log.d(str3422222222222222222222, str11 + j4);
                                                                                        str17 = aw.a;
                                                                                        sb = new StringBuilder(str2);
                                                                                        sb.append(j14);
                                                                                        Log.d(str17, sb.toString());
                                                                                    }
                                                                                } catch (Throwable th29) {
                                                                                    th = th29;
                                                                                    j12 = a5;
                                                                                    str6 = str23;
                                                                                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                    str8 = str22;
                                                                                    str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                                    str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                    j4 = j14;
                                                                                    j2 = a3;
                                                                                    j7 = j22;
                                                                                    j6 = j12;
                                                                                    str2 = str2;
                                                                                    j5 = j4;
                                                                                    j3 = j5;
                                                                                    str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                    j9 = f;
                                                                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                    j14 = j3;
                                                                                    if (j14 == B) {
                                                                                    }
                                                                                    String str30222222222222222222222 = aw.a;
                                                                                    Log.d(str30222222222222222222222, str9 + j7);
                                                                                    String str31222222222222222222222 = aw.a;
                                                                                    Log.d(str31222222222222222222222, str8 + j9);
                                                                                    String str32222222222222222222222 = aw.a;
                                                                                    Log.d(str32222222222222222222222, str7 + j2);
                                                                                    String str33222222222222222222222 = aw.a;
                                                                                    Log.d(str33222222222222222222222, str12 + j6);
                                                                                    String str34222222222222222222222 = aw.a;
                                                                                    Log.d(str34222222222222222222222, str11 + j4);
                                                                                    str17 = aw.a;
                                                                                    sb = new StringBuilder(str2);
                                                                                    sb.append(j14);
                                                                                    Log.d(str17, sb.toString());
                                                                                }
                                                                            } catch (Throwable th30) {
                                                                                th = th30;
                                                                                j12 = a5;
                                                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                                str6 = str23;
                                                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                                                str8 = str22;
                                                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                                j4 = j14;
                                                                                j2 = a3;
                                                                                j7 = j21;
                                                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                                j6 = j12;
                                                                                str2 = str2;
                                                                                j5 = j4;
                                                                                j3 = j5;
                                                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                                j9 = f;
                                                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                                j14 = j3;
                                                                                if (j14 == B) {
                                                                                }
                                                                                String str302222222222222222222222 = aw.a;
                                                                                Log.d(str302222222222222222222222, str9 + j7);
                                                                                String str312222222222222222222222 = aw.a;
                                                                                Log.d(str312222222222222222222222, str8 + j9);
                                                                                String str322222222222222222222222 = aw.a;
                                                                                Log.d(str322222222222222222222222, str7 + j2);
                                                                                String str332222222222222222222222 = aw.a;
                                                                                Log.d(str332222222222222222222222, str12 + j6);
                                                                                String str342222222222222222222222 = aw.a;
                                                                                Log.d(str342222222222222222222222, str11 + j4);
                                                                                str17 = aw.a;
                                                                                sb = new StringBuilder(str2);
                                                                                sb.append(j14);
                                                                                Log.d(str17, sb.toString());
                                                                            }
                                                                        } catch (Throwable th31) {
                                                                            th = th31;
                                                                            str8 = str22;
                                                                            str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                            str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                            str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                            str6 = str23;
                                                                            str9 = ".shareCoreDecFile fProcessStat: ";
                                                                            j5 = j14;
                                                                            j4 = j5;
                                                                            j3 = j4;
                                                                            j2 = a3;
                                                                            j7 = j21;
                                                                            str2 = str2;
                                                                            j6 = j3;
                                                                            str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                            str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                            j9 = f;
                                                                            Log.d(aw.a, ".shareCoreDecFile", th);
                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                            IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                            IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                            IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                            j14 = j3;
                                                                            if (j14 == B) {
                                                                            }
                                                                            String str3022222222222222222222222 = aw.a;
                                                                            Log.d(str3022222222222222222222222, str9 + j7);
                                                                            String str3122222222222222222222222 = aw.a;
                                                                            Log.d(str3122222222222222222222222, str8 + j9);
                                                                            String str3222222222222222222222222 = aw.a;
                                                                            Log.d(str3222222222222222222222222, str7 + j2);
                                                                            String str3322222222222222222222222 = aw.a;
                                                                            Log.d(str3322222222222222222222222, str12 + j6);
                                                                            String str3422222222222222222222222 = aw.a;
                                                                            Log.d(str3422222222222222222222222, str11 + j4);
                                                                            str17 = aw.a;
                                                                            sb = new StringBuilder(str2);
                                                                            sb.append(j14);
                                                                            Log.d(str17, sb.toString());
                                                                        }
                                                                    } catch (Throwable th32) {
                                                                        th = th32;
                                                                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                        str6 = str23;
                                                                        str8 = str22;
                                                                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                                                        j5 = j14;
                                                                        j4 = j5;
                                                                        j3 = j4;
                                                                        j2 = a3;
                                                                        str2 = str2;
                                                                        str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                        j7 = j11;
                                                                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                        j6 = j3;
                                                                        j9 = f;
                                                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                        j14 = j3;
                                                                        if (j14 == B) {
                                                                        }
                                                                        String str30222222222222222222222222 = aw.a;
                                                                        Log.d(str30222222222222222222222222, str9 + j7);
                                                                        String str31222222222222222222222222 = aw.a;
                                                                        Log.d(str31222222222222222222222222, str8 + j9);
                                                                        String str32222222222222222222222222 = aw.a;
                                                                        Log.d(str32222222222222222222222222, str7 + j2);
                                                                        String str33222222222222222222222222 = aw.a;
                                                                        Log.d(str33222222222222222222222222, str12 + j6);
                                                                        String str34222222222222222222222222 = aw.a;
                                                                        Log.d(str34222222222222222222222222, str11 + j4);
                                                                        str17 = aw.a;
                                                                        sb = new StringBuilder(str2);
                                                                        sb.append(j14);
                                                                        Log.d(str17, sb.toString());
                                                                    }
                                                                }
                                                            } catch (Throwable th33) {
                                                                th = th33;
                                                                str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                                str6 = str23;
                                                                str8 = str22;
                                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                                j5 = j14;
                                                                j4 = j5;
                                                                j3 = j4;
                                                                j2 = a3;
                                                                str2 = str2;
                                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                                j7 = j11;
                                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                                j6 = j3;
                                                                j9 = f;
                                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                                j14 = j3;
                                                                if (j14 == B) {
                                                                }
                                                                String str302222222222222222222222222 = aw.a;
                                                                Log.d(str302222222222222222222222222, str9 + j7);
                                                                String str312222222222222222222222222 = aw.a;
                                                                Log.d(str312222222222222222222222222, str8 + j9);
                                                                String str322222222222222222222222222 = aw.a;
                                                                Log.d(str322222222222222222222222222, str7 + j2);
                                                                String str332222222222222222222222222 = aw.a;
                                                                Log.d(str332222222222222222222222222, str12 + j6);
                                                                String str342222222222222222222222222 = aw.a;
                                                                Log.d(str342222222222222222222222222, str11 + j4);
                                                                str17 = aw.a;
                                                                sb = new StringBuilder(str2);
                                                                sb.append(j14);
                                                                Log.d(str17, sb.toString());
                                                            }
                                                        }
                                                    } catch (Throwable th34) {
                                                        th = th34;
                                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                        str6 = str23;
                                                        str8 = str22;
                                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                        j4 = j14;
                                                        j2 = a3;
                                                        j7 = j11;
                                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                        j6 = j4;
                                                        j5 = j6;
                                                        str12 = ".shareCoreDecFile fDeleteStat: ";
                                                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                        j3 = j5;
                                                        j9 = f;
                                                        Log.d(aw.a, ".shareCoreDecFile", th);
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                        j14 = j3;
                                                        if (j14 == B) {
                                                        }
                                                        String str3022222222222222222222222222 = aw.a;
                                                        Log.d(str3022222222222222222222222222, str9 + j7);
                                                        String str3122222222222222222222222222 = aw.a;
                                                        Log.d(str3122222222222222222222222222, str8 + j9);
                                                        String str3222222222222222222222222222 = aw.a;
                                                        Log.d(str3222222222222222222222222222, str7 + j2);
                                                        String str3322222222222222222222222222 = aw.a;
                                                        Log.d(str3322222222222222222222222222, str12 + j6);
                                                        String str3422222222222222222222222222 = aw.a;
                                                        Log.d(str3422222222222222222222222222, str11 + j4);
                                                        str17 = aw.a;
                                                        sb = new StringBuilder(str2);
                                                        sb.append(j14);
                                                        Log.d(str17, sb.toString());
                                                    }
                                                } catch (Throwable th35) {
                                                    th = th35;
                                                    str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                    str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                    str6 = str23;
                                                    str8 = str22;
                                                    str9 = ".shareCoreDecFile fProcessStat: ";
                                                    str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                    j4 = j14;
                                                    j2 = a3;
                                                    j7 = j11;
                                                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                    j6 = j4;
                                                    j5 = j6;
                                                    str12 = ".shareCoreDecFile fDeleteStat: ";
                                                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                    j3 = j5;
                                                    j9 = f;
                                                    Log.d(aw.a, ".shareCoreDecFile", th);
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                    j14 = j3;
                                                    if (j14 == B) {
                                                    }
                                                    String str30222222222222222222222222222 = aw.a;
                                                    Log.d(str30222222222222222222222222222, str9 + j7);
                                                    String str31222222222222222222222222222 = aw.a;
                                                    Log.d(str31222222222222222222222222222, str8 + j9);
                                                    String str32222222222222222222222222222 = aw.a;
                                                    Log.d(str32222222222222222222222222222, str7 + j2);
                                                    String str33222222222222222222222222222 = aw.a;
                                                    Log.d(str33222222222222222222222222222, str12 + j6);
                                                    String str34222222222222222222222222222 = aw.a;
                                                    Log.d(str34222222222222222222222222222, str11 + j4);
                                                    str17 = aw.a;
                                                    sb = new StringBuilder(str2);
                                                    sb.append(j14);
                                                    Log.d(str17, sb.toString());
                                                }
                                            } catch (Throwable th36) {
                                                th = th36;
                                                str9 = ".shareCoreDecFile fProcessStat: ";
                                                str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                                str6 = str23;
                                                str8 = str22;
                                                str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                                j4 = j14;
                                                j2 = a3;
                                                j7 = j11;
                                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                                j6 = j4;
                                                j5 = j6;
                                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                                j3 = j5;
                                                j9 = f;
                                                Log.d(aw.a, ".shareCoreDecFile", th);
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                                j14 = j3;
                                                if (j14 == B) {
                                                }
                                                String str302222222222222222222222222222 = aw.a;
                                                Log.d(str302222222222222222222222222222, str9 + j7);
                                                String str312222222222222222222222222222 = aw.a;
                                                Log.d(str312222222222222222222222222222, str8 + j9);
                                                String str322222222222222222222222222222 = aw.a;
                                                Log.d(str322222222222222222222222222222, str7 + j2);
                                                String str332222222222222222222222222222 = aw.a;
                                                Log.d(str332222222222222222222222222222, str12 + j6);
                                                String str342222222222222222222222222222 = aw.a;
                                                Log.d(str342222222222222222222222222222, str11 + j4);
                                                str17 = aw.a;
                                                sb = new StringBuilder(str2);
                                                sb.append(j14);
                                                Log.d(str17, sb.toString());
                                            }
                                        }
                                    } catch (Throwable th37) {
                                        th3 = th37;
                                        str9 = ".shareCoreDecFile fProcessStat: ";
                                        str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                        str19 = ".shareCoreDecFile fCopyStat: ";
                                        str8 = ".shareCoreDecFile fProcessStatExp: ";
                                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                        str6 = str23;
                                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                        str20 = ".shareCoreDecFile fDeleteStat: ";
                                        str21 = ".shareCoreDecFile fPreconditionStat: ";
                                        j7 = m;
                                        Log.d(aw.a, ".shareCoreDecFile createAppSubFolder", th3);
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                        IWaStat.WaStat.stat(str6, Long.toString(j14));
                                        IWaStat.WaStat.stat(str13, Long.toString(j14));
                                        IWaStat.WaStat.stat(str10, Long.toString(j14));
                                        if (j14 == B) {
                                            IWaStat.WaStat.stat(str5);
                                        } else if (j14 == G) {
                                            IWaStat.WaStat.stat(str4);
                                        } else {
                                            IWaStat.WaStat.stat(str3);
                                        }
                                        String str512 = aw.a;
                                        Log.d(str512, str9 + j7);
                                        String str522 = aw.a;
                                        Log.d(str522, str8 + j14);
                                        String str532 = aw.a;
                                        Log.d(str532, str7 + a3);
                                        String str542 = aw.a;
                                        Log.d(str542, str20 + j14);
                                        String str552 = aw.a;
                                        Log.d(str552, str21 + j14);
                                        str17 = aw.a;
                                        sb = new StringBuilder(str19);
                                        sb.append(j14);
                                        Log.d(str17, sb.toString());
                                    }
                                } catch (Throwable th38) {
                                    th3 = th38;
                                    str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                    str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                    str19 = ".shareCoreDecFile fCopyStat: ";
                                    str8 = ".shareCoreDecFile fProcessStatExp: ";
                                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                    str6 = str23;
                                    str9 = ".shareCoreDecFile fProcessStat: ";
                                    str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                    str20 = ".shareCoreDecFile fDeleteStat: ";
                                    str21 = ".shareCoreDecFile fPreconditionStat: ";
                                    j7 = m;
                                    Log.d(aw.a, ".shareCoreDecFile createAppSubFolder", th3);
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j14));
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(a3));
                                    IWaStat.WaStat.stat(str6, Long.toString(j14));
                                    IWaStat.WaStat.stat(str13, Long.toString(j14));
                                    IWaStat.WaStat.stat(str10, Long.toString(j14));
                                    if (j14 == B) {
                                    }
                                    String str5122 = aw.a;
                                    Log.d(str5122, str9 + j7);
                                    String str5222 = aw.a;
                                    Log.d(str5222, str8 + j14);
                                    String str5322 = aw.a;
                                    Log.d(str5322, str7 + a3);
                                    String str5422 = aw.a;
                                    Log.d(str5422, str20 + j14);
                                    String str5522 = aw.a;
                                    Log.d(str5522, str21 + j14);
                                    str17 = aw.a;
                                    sb = new StringBuilder(str19);
                                    sb.append(j14);
                                    Log.d(str17, sb.toString());
                                }
                            } catch (Throwable th39) {
                                th = th39;
                                j5 = j14;
                                str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                                str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                                str12 = ".shareCoreDecFile fDeleteStat: ";
                                str11 = ".shareCoreDecFile fPreconditionStat: ";
                                str8 = ".shareCoreDecFile fProcessStatExp: ";
                                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                                str6 = str23;
                                str9 = ".shareCoreDecFile fProcessStat: ";
                                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                                j7 = j16;
                                j6 = j5;
                                j2 = a3;
                                str2 = ".shareCoreDecFile fCopyStat: ";
                                j4 = j6;
                                j3 = j4;
                                j9 = f;
                                Log.d(aw.a, ".shareCoreDecFile", th);
                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                                IWaStat.WaStat.stat(str6, Long.toString(j6));
                                IWaStat.WaStat.stat(str13, Long.toString(j4));
                                IWaStat.WaStat.stat(str10, Long.toString(j3));
                                j14 = j3;
                                if (j14 == B) {
                                }
                                String str3022222222222222222222222222222 = aw.a;
                                Log.d(str3022222222222222222222222222222, str9 + j7);
                                String str3122222222222222222222222222222 = aw.a;
                                Log.d(str3122222222222222222222222222222, str8 + j9);
                                String str3222222222222222222222222222222 = aw.a;
                                Log.d(str3222222222222222222222222222222, str7 + j2);
                                String str3322222222222222222222222222222 = aw.a;
                                Log.d(str3322222222222222222222222222222, str12 + j6);
                                String str3422222222222222222222222222222 = aw.a;
                                Log.d(str3422222222222222222222222222222, str11 + j4);
                                str17 = aw.a;
                                sb = new StringBuilder(str2);
                                sb.append(j14);
                                Log.d(str17, sb.toString());
                            }
                            sb.append(j14);
                            Log.d(str17, sb.toString());
                        } catch (Throwable th40) {
                            th = th40;
                            str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                            str8 = ".shareCoreDecFile fProcessStatExp: ";
                            str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                            str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                            str12 = ".shareCoreDecFile fDeleteStat: ";
                            str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                            str11 = ".shareCoreDecFile fPreconditionStat: ";
                            j5 = j14;
                            str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                            str6 = str23;
                            str9 = ".shareCoreDecFile fProcessStat: ";
                            str2 = ".shareCoreDecFile fCopyStat: ";
                            j7 = j16;
                            j6 = j5;
                            j3 = j6;
                            j2 = a3;
                            j4 = j3;
                            j9 = f;
                            Log.d(aw.a, ".shareCoreDecFile", th);
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                            IWaStat.WaStat.stat(str6, Long.toString(j6));
                            IWaStat.WaStat.stat(str13, Long.toString(j4));
                            IWaStat.WaStat.stat(str10, Long.toString(j3));
                            j14 = j3;
                            if (j14 == B) {
                            }
                            String str30222222222222222222222222222222 = aw.a;
                            Log.d(str30222222222222222222222222222222, str9 + j7);
                            String str31222222222222222222222222222222 = aw.a;
                            Log.d(str31222222222222222222222222222222, str8 + j9);
                            String str32222222222222222222222222222222 = aw.a;
                            Log.d(str32222222222222222222222222222222, str7 + j2);
                            String str33222222222222222222222222222222 = aw.a;
                            Log.d(str33222222222222222222222222222222, str12 + j6);
                            String str34222222222222222222222222222222 = aw.a;
                            Log.d(str34222222222222222222222222222222, str11 + j4);
                            str17 = aw.a;
                            sb = new StringBuilder(str2);
                            sb.append(j14);
                            Log.d(str17, sb.toString());
                        }
                    } catch (Throwable th41) {
                        th = th41;
                        str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                        str8 = ".shareCoreDecFile fProcessStatExp: ";
                        str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                        str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                        str12 = ".shareCoreDecFile fDeleteStat: ";
                        str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                        str11 = ".shareCoreDecFile fPreconditionStat: ";
                        j5 = j14;
                        str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                        str6 = str23;
                        str9 = ".shareCoreDecFile fProcessStat: ";
                        str2 = ".shareCoreDecFile fCopyStat: ";
                        j7 = j16;
                        j2 = j5;
                        j6 = j2;
                        j4 = j6;
                        j3 = j4;
                        j9 = f;
                        Log.d(aw.a, ".shareCoreDecFile", th);
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                        IWaStat.WaStat.stat(str6, Long.toString(j6));
                        IWaStat.WaStat.stat(str13, Long.toString(j4));
                        IWaStat.WaStat.stat(str10, Long.toString(j3));
                        j14 = j3;
                        if (j14 == B) {
                        }
                        String str302222222222222222222222222222222 = aw.a;
                        Log.d(str302222222222222222222222222222222, str9 + j7);
                        String str312222222222222222222222222222222 = aw.a;
                        Log.d(str312222222222222222222222222222222, str8 + j9);
                        String str322222222222222222222222222222222 = aw.a;
                        Log.d(str322222222222222222222222222222222, str7 + j2);
                        String str332222222222222222222222222222222 = aw.a;
                        Log.d(str332222222222222222222222222222222, str12 + j6);
                        String str342222222222222222222222222222222 = aw.a;
                        Log.d(str342222222222222222222222222222222, str11 + j4);
                        str17 = aw.a;
                        sb = new StringBuilder(str2);
                        sb.append(j14);
                        Log.d(str17, sb.toString());
                    }
                } catch (Throwable th42) {
                    th = th42;
                    str9 = ".shareCoreDecFile fProcessStat: ";
                    str4 = IWaStat.SHARE_CORE_COPY_HAS_EXISTS_PV;
                    str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                    str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                    str6 = str23;
                    str8 = ".shareCoreDecFile fProcessStatExp: ";
                    str18 = ".shareCoreDecFile fCopyStat: ";
                    str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                    str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                    str12 = ".shareCoreDecFile fDeleteStat: ";
                    str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                    str11 = ".shareCoreDecFile fPreconditionStat: ";
                    j5 = j14;
                    str2 = str18;
                    j2 = j5;
                    j7 = j2;
                    j6 = j7;
                    j4 = j6;
                    j3 = j4;
                    j9 = f;
                    Log.d(aw.a, ".shareCoreDecFile", th);
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                    IWaStat.WaStat.stat(str6, Long.toString(j6));
                    IWaStat.WaStat.stat(str13, Long.toString(j4));
                    IWaStat.WaStat.stat(str10, Long.toString(j3));
                    j14 = j3;
                    if (j14 == B) {
                    }
                    String str3022222222222222222222222222222222 = aw.a;
                    Log.d(str3022222222222222222222222222222222, str9 + j7);
                    String str3122222222222222222222222222222222 = aw.a;
                    Log.d(str3122222222222222222222222222222222, str8 + j9);
                    String str3222222222222222222222222222222222 = aw.a;
                    Log.d(str3222222222222222222222222222222222, str7 + j2);
                    String str3322222222222222222222222222222222 = aw.a;
                    Log.d(str3322222222222222222222222222222222, str12 + j6);
                    String str3422222222222222222222222222222222 = aw.a;
                    Log.d(str3422222222222222222222222222222222, str11 + j4);
                    str17 = aw.a;
                    sb = new StringBuilder(str2);
                    sb.append(j14);
                    Log.d(str17, sb.toString());
                }
            } catch (Throwable th43) {
                th = th43;
                j5 = j14;
                str3 = IWaStat.SHARE_CORE_COPY_OTHER_PV;
                str13 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PRECONDITION;
                str11 = ".shareCoreDecFile fPreconditionStat: ";
                str12 = ".shareCoreDecFile fDeleteStat: ";
                str8 = ".shareCoreDecFile fProcessStatExp: ";
                str9 = ".shareCoreDecFile fProcessStat: ";
                str4 = IWaStat.SHARE_CORE_COPY_HAS_EXISTS_PV;
                str18 = ".shareCoreDecFile fCopyStat: ";
                str5 = IWaStat.SHARE_CORE_COPY_SUCCESS_PV;
                str7 = ".shareCoreDecFile fSdcardAuthoryStat: ";
                str10 = IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY;
                str6 = str23;
                str2 = str18;
                j2 = j5;
                j7 = j2;
                j6 = j7;
                j4 = j6;
                j3 = j4;
                j9 = f;
                Log.d(aw.a, ".shareCoreDecFile", th);
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, Long.toString(j7));
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, Long.toString(j9));
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, Long.toString(j2));
                IWaStat.WaStat.stat(str6, Long.toString(j6));
                IWaStat.WaStat.stat(str13, Long.toString(j4));
                IWaStat.WaStat.stat(str10, Long.toString(j3));
                j14 = j3;
                if (j14 == B) {
                }
                String str30222222222222222222222222222222222 = aw.a;
                Log.d(str30222222222222222222222222222222222, str9 + j7);
                String str31222222222222222222222222222222222 = aw.a;
                Log.d(str31222222222222222222222222222222222, str8 + j9);
                String str32222222222222222222222222222222222 = aw.a;
                Log.d(str32222222222222222222222222222222222, str7 + j2);
                String str33222222222222222222222222222222222 = aw.a;
                Log.d(str33222222222222222222222222222222222, str12 + j6);
                String str34222222222222222222222222222222222 = aw.a;
                Log.d(str34222222222222222222222222222222222, str11 + j4);
                str17 = aw.a;
                sb = new StringBuilder(str2);
                sb.append(j14);
                Log.d(str17, sb.toString());
            }
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private static long a(int i2) {
            long j2 = q;
            try {
                if (UCCyclone.DecFileOrign.Update == i2) {
                    return j2;
                }
                if (p.f()) {
                    return r;
                }
                UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
                if (totalLoadedUCM == null) {
                    return s;
                }
                if (totalLoadedUCM.isShareCore) {
                    return u;
                }
                return j2;
            } catch (Throwable th) {
                Log.d(aw.a, ".checkPrecondition", th);
                return j2;
            }
        }

        private static boolean a(Context context, File file, j.a aVar) {
            if (aVar != null) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_CONFIG, UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_PUSH_UCM_VERSIONS));
            }
            return !p.a(j.a(context, file, UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_PUSH_UCM_VERSIONS), aVar));
        }

        private static long a(Context context, File file) {
            Log.d(aw.a, ".deleteHistoryCoreFiles hostSubFolder:" + file.getAbsolutePath());
            long j2 = v;
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length != 0) {
                        for (File file2 : listFiles) {
                            if (UCCyclone.detectZipByFileType(file2.getAbsolutePath()) && !j.a(file2) && !j.a(context, file2, (j.a) null)) {
                                file2.delete();
                                j2 = x;
                                Log.d(aw.a, ".deleteHistoryCoreFiles verifySignature failure! file: " + file2.getAbsolutePath());
                            } else if (!a(context, file2, (j.a) null)) {
                                file2.delete();
                                j2 = y;
                                Log.d(aw.a, ".deleteHistoryCoreFiles verifyCoreCompressFileVersion failure! file: " + file2.getAbsolutePath());
                            }
                        }
                        return j2;
                    }
                }
                return z;
            } catch (Throwable unused) {
                return j2;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:77:0x0267  */
        private static long a(Context context, File file, String str) {
            long j2;
            long j3;
            long j4;
            String str2;
            String str3;
            String str4 = aw.a;
            Log.d(str4, ".copyCoreFileToSdcard(" + context + file.getAbsolutePath() + AVFSCacheConstants.COMMA_SEP + str + jl1.BRACKET_END_STR);
            long j5 = A;
            j.a aVar = new j.a();
            try {
                String str5 = aw.a;
                Log.d(str5, ".copyCoreFileToSdcard copy file path : " + str);
                if (p.a(str)) {
                    j3 = D;
                    j4 = aVar.s;
                } else {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isFile()) {
                        j3 = H;
                        j4 = aVar.s;
                    } else {
                        String str6 = null;
                        if (!UCCyclone.detectZipByFileType(file2.getAbsolutePath()) || j.c(context) || j.a(context, file2, (j.a) null)) {
                            if (!a(context, file2, aVar)) {
                                j5 = J;
                                aVar.a(j.a.n);
                                String str7 = aw.a;
                                Log.d(str7, ".copyCoreFileToSdcard verifyCoreCompressFileVersion failure! file: " + file2.getAbsolutePath());
                                j2 = aVar.s;
                            } else {
                                File[] listFiles = file.listFiles();
                                if (listFiles != null && listFiles.length > 0) {
                                    long length = file2.length();
                                    int length2 = listFiles.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length2) {
                                            break;
                                        }
                                        File file3 = listFiles[i2];
                                        if (length == file3.length()) {
                                            if (p.a(str6)) {
                                                str6 = UCCyclone.hashFileContents(file2, UCCyclone.MessageDigestType.SHA1);
                                                if (p.a(str6)) {
                                                    long j6 = E;
                                                    aVar.a(j.a.o);
                                                    throw new UCSetupException(1013, String.format("SHA1 [%s] failed.", file2));
                                                }
                                            }
                                            String hashFileContents = UCCyclone.hashFileContents(file3, UCCyclone.MessageDigestType.SHA1);
                                            if (p.a(hashFileContents)) {
                                                long j7 = E;
                                                aVar.a(j.a.o);
                                                throw new UCSetupException(1013, String.format("SHA1 [%s] failed.", file3));
                                            } else if (hashFileContents.equals(str6)) {
                                                j5 = G;
                                                String str8 = aw.a;
                                                Log.d(str8, ".copyCoreFileToSdcard " + file3.getAbsolutePath() + " had exists.");
                                                j2 = aVar.s;
                                                break;
                                            }
                                        }
                                        i2++;
                                    }
                                }
                                String name = file2.getName();
                                if (name.lastIndexOf(".") > 0) {
                                    str2 = String.format("%s_%s.%s", name.substring(0, name.lastIndexOf(".")), String.valueOf(System.currentTimeMillis()), name.substring(name.lastIndexOf(".") + 1, name.length()));
                                } else {
                                    str2 = String.format("%s_%s", name, String.valueOf(System.currentTimeMillis()));
                                }
                                File file4 = new File(file.getAbsolutePath(), str2);
                                File file5 = new File(file4.getAbsolutePath() + ".tmp");
                                String str9 = aw.a;
                                Log.d(str9, ".copyCoreFileToSdcard targetFile: " + file4.getAbsolutePath());
                                try {
                                    file5.createNewFile();
                                    p.a(file2, file5);
                                    if (file5.renameTo(file4)) {
                                        file4.setLastModified(file2.lastModified());
                                        try {
                                            if (file5.exists()) {
                                                file5.delete();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            str3 = aw.a;
                                            Log.d(str3, ".copyCoreFileToSdcard", th);
                                            if (j5 != F) {
                                            }
                                            j2 = aVar.s;
                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_STAT_VALUE, Long.toString(j2));
                                            return j5;
                                        }
                                        if (j5 != F) {
                                            j5 = B;
                                        }
                                        j2 = aVar.s;
                                    } else {
                                        long j8 = F;
                                        aVar.a(j.a.p);
                                        throw new UCSetupException(1005, String.format("Rename [%s] to [%s] failed.", file5, file4));
                                    }
                                } catch (Exception e2) {
                                    try {
                                        Log.d(aw.a, ".copyCoreFileToSdcard", e2);
                                        if (file5.exists()) {
                                            file5.delete();
                                        }
                                    } catch (Throwable th2) {
                                        Log.d(aw.a, ".copyCoreFileToSdcard", th2);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    str3 = aw.a;
                                    Log.d(str3, ".copyCoreFileToSdcard", th);
                                }
                            }
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_STAT_VALUE, Long.toString(j2));
                            return j5;
                        }
                        j5 = I;
                        String str10 = aw.a;
                        Log.d(str10, ".copyCoreFileToSdcard verifySignature failure! file: " + file2.getAbsolutePath());
                        j2 = aVar.s;
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_STAT_VALUE, Long.toString(j2));
                        return j5;
                    }
                }
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_STAT_VALUE, Long.toString(j4));
                return j3;
                throw th;
            } catch (Throwable unused) {
                j2 = aVar.s;
            }
        }

        public static void a(Context context, boolean z2, boolean z3, Callable<Boolean> callable) {
            int i2;
            String str = "0";
            Log.d(aw.a, ".statDevicesHasShareCore isUCCore: " + z2 + ", hasUpdSource: " + z3 + ", wifiChecker: " + callable);
            try {
                if (str.equals((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_SC_HIS", 4);
                        int i3 = (callable == null || !callable.call().booleanValue()) ? sharedPreferences.getInt("NO_WIFI_HISTORY", 0) + 1 : 0;
                        if (!z3 || !z2) {
                            i2 = sharedPreferences.getInt("INVALID_UPD_HISTORY", 0) + 1;
                        } else {
                            i2 = 0;
                        }
                        Log.d(aw.a, ".statDevicesHasShareCore noWifiTimes: " + i3 + ", invalidUpdateTimes: " + i2);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putInt("NO_WIFI_HISTORY", i3);
                        edit.putInt("INVALID_UPD_HISTORY", i2);
                        edit.apply();
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NO_WIFI_TIMES, Integer.toString(i3));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_INVALID_UPDATE_TIMES, Integer.toString(i2));
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_CURRENT_IS_UC_CORE, z2 ? "1" : str);
                        if (z3) {
                            str = "1";
                        }
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_HAS_UPD_SOURCE, str);
                    } catch (Throwable th) {
                        Log.d(aw.a, ".statDevicesHasShareCore history stat", th);
                    }
                    if (!j.b(context)) {
                        Log.d(aw.a, ".statDevicesHasShareCore Sdcard配置及权限校验失败");
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList();
                    arrayList.add(context.getPackageName());
                    String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_SPECIAL_HOST_PKG_NAME_LIST);
                    if (!p.a(param)) {
                        String[] split = param.split(CDParamKeys.CD_VALUE_STRING_SPLITER);
                        for (String str2 : split) {
                            if (!p.a(str2) && !str2.equals(context.getPackageName())) {
                                arrayList.add(str2);
                            }
                        }
                    }
                    for (String str3 : arrayList) {
                        File c2 = j.c(str3);
                        if (!c2.exists()) {
                            Log.d(aw.a, ".statDevicesHasShareCore " + c2.getAbsolutePath() + " not exists.");
                        } else {
                            File[] listFiles = c2.listFiles();
                            if (listFiles == null || listFiles.length == 0) {
                                Log.d(aw.a, ".statDevicesHasShareCore " + c2.getAbsolutePath() + " empty.");
                            } else {
                                Log.d(aw.a, ".statDevicesHasShareCore " + str3 + "," + str3.hashCode() + AVFSCacheConstants.COMMA_SEP + listFiles.length);
                                StringBuilder sb = new StringBuilder("csc_dhsc_");
                                sb.append(str3.hashCode());
                                IWaStat.WaStat.stat(sb.toString(), Integer.toString(listFiles.length));
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                Log.d(aw.a, ".statDevicesHasShareCore", th2);
            }
        }
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void run() {
        Log.d(a, ".run");
        try {
            Context applicationContext = getContext().getApplicationContext();
            if (p.a((Boolean) getOption(UCCore.OPTION_ONLY_STAT_DEVICES_HAS_CORE_SHARE))) {
                synchronized (b) {
                    new a((byte) 0);
                    a.a(applicationContext, p.a((Boolean) getOption(UCCore.OPTION_CURRENT_IS_UC_CORE)), p.a((Boolean) getOption(UCCore.OPTION_HAS_UPDATE_SOURCE)), (Callable) getOption(UCCore.OPTION_DOWNLOAD_CHECKER));
                }
                return;
            }
            String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_COMPRESSED_CORE_FILE_PATH);
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_RUN_PV);
            synchronized (b) {
                if (!p.a(param)) {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_RUN_CALL_PV);
                    new a((byte) 0);
                    a.a(applicationContext, param, UCCyclone.DecFileOrign.Other);
                }
                new a((byte) 0);
                a.a(applicationContext, p.a((Boolean) getOption(UCCore.OPTION_CURRENT_IS_UC_CORE)), p.a((Boolean) getOption(UCCore.OPTION_HAS_UPDATE_SOURCE)), (Callable) getOption(UCCore.OPTION_DOWNLOAD_CHECKER));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        String str3 = a;
        Log.d(str3, ".shareDownloadFile(" + str + AVFSCacheConstants.COMMA_SEP + str2 + jl1.BRACKET_END_STR);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_UPD_PV);
        if (!p.a(str2)) {
            synchronized (b) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_UPD_CALL_PV);
                new a((byte) 0);
                a.a(context, str2, UCCyclone.DecFileOrign.Update);
            }
        }
    }
}
