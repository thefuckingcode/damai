package io.flutter.embedding.engine;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import com.taobao.aranger.constant.Constants;
import io.flutter.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
public class FlutterEngineMemoryMapsGroup implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CMDLINE_PATH = "/proc/self/cmdline";
    private static final int MAPS_GROUP_BYTES_LIMIT = 1024;
    private static final int MAPS_GROUP_CHECK_DELAY_MS = 50;
    private static final String MAPS_GROUP_FIELD_COMMAND = "command";
    private static final String MAPS_GROUP_FIELD_FORMAT = "format";
    private static final String MAPS_GROUP_FIELD_INTERVAL = "interval_ms";
    private static final String MAPS_GROUP_FIELD_KEEP_COMMAND = "keep_command";
    private static final String MAPS_GROUP_FIELD_TARGET = "target";
    private static final String MAPS_GROUP_FIELD_TYPE = "type";
    private static final String MAPS_GROUP_FIELD_VALUE = "value";
    private static final String MAPS_GROUP_FILE_PATH = "/data/local/tmp/hummer_mapsgrp_ori.json";
    private static final int MAPS_GROUP_IV_LENGTH = 16;
    private static final String MAPS_GROUP_PID_FILE_PATH = ("/data/local/tmp/hummer_mapsgrp_ori." + Process.myPid() + ".json");
    private static final String MAPS_GROUP_TARGET_CRASH_CALLBACK = "crash_callback";
    private static final String MAPS_GROUP_TARGET_MAPSGRP = "mapsgrp";
    private static final String MAPS_GROUP_TYPE_JSON = "json";
    private static final String MAPS_GROUP_TYPE_PLAIN = "plain";
    private static final String MAPS_GROUP_VALUE_DIR = "dir";
    private static final String MAPS_GROUP_VALUE_FILE = "file";
    private static final String MAPS_GROUP_VALUE_IDLE = "idle";
    private static final String MAPS_GROUP_VALUE_LOGCAT = "logcat";
    private static final String MAPS_GROUP_VALUE_PULL_ONCE = "pull_once";
    private static final String MAPS_GROUP_VALUE_PULL_REPEAT_BEGIN = "pull_repeat_begin";
    private static final String MAPS_GROUP_VALUE_PULL_REPEAT_END = "pull_repeat_end";
    private static final String OK_STRING = "ok";
    private static final boolean USE_TIME_STAMP = true;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static volatile FlutterEngineMemoryMapsGroup sInstance;
    private static final SimpleDateFormat sSDFSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA);
    private Context mAppContext;
    private File mFile;
    private File mFilePid;
    private Handler mHandler;
    private String mProcessName;
    private Command mRepeatCommand;
    private Runnable mRepeatTask = new Runnable() {
        /* class io.flutter.embedding.engine.FlutterEngineMemoryMapsGroup.AnonymousClass1 */

        public void run() {
            try {
                if (FlutterEngineMemoryMapsGroup.this.mRepeatCommand.target.equals(FlutterEngineMemoryMapsGroup.MAPS_GROUP_TARGET_MAPSGRP)) {
                    FlutterEngineMemoryMapsGroup flutterEngineMemoryMapsGroup = FlutterEngineMemoryMapsGroup.this;
                    flutterEngineMemoryMapsGroup.outputMapsGrp(flutterEngineMemoryMapsGroup.mRepeatCommand);
                } else if (FlutterEngineMemoryMapsGroup.this.mRepeatCommand.target.equals(FlutterEngineMemoryMapsGroup.MAPS_GROUP_TARGET_CRASH_CALLBACK)) {
                    FlutterEngineMemoryMapsGroup flutterEngineMemoryMapsGroup2 = FlutterEngineMemoryMapsGroup.this;
                    flutterEngineMemoryMapsGroup2.outputCrashCallbacl(flutterEngineMemoryMapsGroup2.mRepeatCommand);
                }
                try {
                    FlutterEngineMemoryMapsGroup.this.mHandler.postDelayed(this, FlutterEngineMemoryMapsGroup.this.mRepeatCommand.interval);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                try {
                    FlutterEngineMemoryMapsGroup.this.mHandler.postDelayed(this, FlutterEngineMemoryMapsGroup.this.mRepeatCommand.interval);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                throw th2;
            }
        }
    };

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class Command {
        public String command;
        public String format;
        public long interval;
        public String target;
        public String type;
        public String value;

        private Command() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof Command) {
                Command command2 = (Command) obj;
                return this.command.equals(command2.command) && this.format.equals(command2.format) && this.value.equals(command2.value) && this.interval == command2.interval && this.target.equals(command2.target) && this.type.equals(command2.type);
            }
        }
    }

    public static void freeInstance() {
        sInstance = null;
    }

    private Command getCommand() throws Exception {
        JSONObject jsonCommand = getJsonCommand();
        String optString = jsonCommand.optString("command", "");
        String optString2 = jsonCommand.optString("value", "");
        String optString3 = jsonCommand.optString(MAPS_GROUP_FIELD_FORMAT, "");
        String optString4 = jsonCommand.optString("target", "");
        String optString5 = jsonCommand.optString("type", "json");
        long optLong = jsonCommand.optLong(MAPS_GROUP_FIELD_INTERVAL, 0);
        if (optString.equals(MAPS_GROUP_VALUE_PULL_ONCE) || optString.equals(MAPS_GROUP_VALUE_PULL_REPEAT_BEGIN)) {
            if (optString2.length() > 0) {
                optString2 = optString2.replace("{$pid}", String.valueOf(Process.myPid())).replace("{$tid}", String.valueOf(Process.myTid()));
            }
            optString3.hashCode();
            char c = 65535;
            switch (optString3.hashCode()) {
                case -1097341422:
                    if (optString3.equals(MAPS_GROUP_VALUE_LOGCAT)) {
                        c = 0;
                        break;
                    }
                    break;
                case 99469:
                    if (optString3.equals("dir")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3143036:
                    if (optString3.equals("file")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (optString2.length() <= 0) {
                        throw new RuntimeException("invalid");
                    }
                    break;
                case 1:
                    File file = new File(optString2);
                    file.mkdirs();
                    if (!file.isDirectory()) {
                        throw new RuntimeException("invalid");
                    }
                    break;
                case 2:
                    File file2 = new File(optString2);
                    file2.getParentFile().mkdirs();
                    if (!file2.getParentFile().isDirectory()) {
                        throw new RuntimeException("invalid");
                    } else if (file2.exists() && !file2.canWrite()) {
                        throw new RuntimeException("invalid");
                    }
                default:
                    throw new RuntimeException("invalid");
            }
            optString4.hashCode();
            if (optString4.equals(MAPS_GROUP_TARGET_CRASH_CALLBACK) || optString4.equals(MAPS_GROUP_TARGET_MAPSGRP)) {
                optString5.hashCode();
                if (!optString5.equals("json") && !optString5.equals(MAPS_GROUP_TYPE_PLAIN)) {
                    throw new RuntimeException("invalid");
                } else if (optString5.equals(MAPS_GROUP_TYPE_PLAIN) && !optString3.equals(MAPS_GROUP_VALUE_LOGCAT)) {
                    throw new RuntimeException("invalid");
                } else if (optString.equals(MAPS_GROUP_VALUE_PULL_REPEAT_BEGIN) && optLong < 10) {
                    throw new RuntimeException("invalid");
                }
            } else {
                throw new RuntimeException("invalid");
            }
        } else if (!optString.equals(MAPS_GROUP_VALUE_PULL_REPEAT_END) && !optString.equals(MAPS_GROUP_VALUE_IDLE)) {
            throw new RuntimeException("invalid");
        }
        Command command = new Command();
        command.command = optString;
        command.format = optString3;
        command.interval = optLong;
        command.value = optString2;
        command.target = optString4;
        command.type = optString5;
        return command;
    }

    private static String getFileContents(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        int read = fileInputStream.read(bArr);
        fileInputStream.close();
        return new String(bArr, 0, read, UTF_8);
    }

    public static FlutterEngineMemoryMapsGroup getInstance() {
        FlutterEngineMemoryMapsGroup flutterEngineMemoryMapsGroup = sInstance;
        if (flutterEngineMemoryMapsGroup == null) {
            synchronized (FlutterEngineMemoryMapsGroup.class) {
                flutterEngineMemoryMapsGroup = sInstance;
                if (flutterEngineMemoryMapsGroup == null) {
                    flutterEngineMemoryMapsGroup = new FlutterEngineMemoryMapsGroup();
                    sInstance = flutterEngineMemoryMapsGroup;
                }
            }
        }
        return flutterEngineMemoryMapsGroup;
    }

    private JSONObject getJsonCommand() throws Exception {
        File file = (!this.mFilePid.exists() || this.mFilePid.length() <= 0) ? this.mFile : this.mFilePid;
        JSONObject jSONObject = new JSONObject(getFileContents(file));
        if (!jSONObject.optBoolean(MAPS_GROUP_FIELD_KEEP_COMMAND, false) && !file.delete()) {
            writeFile(file, "", false);
        }
        return jSONObject;
    }

    private static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static String getTimeString() {
        return String.format(Locale.CHINA, "%.6f", Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d));
    }

    private static /* synthetic */ void lambda$start$0(Thread thread, Throwable th) {
        try {
            FlutterJNI.nativeSetMapsGroupParams(false, "", "", "", "", "", 0);
            freeInstance();
            th.printStackTrace();
            thread.interrupt();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void output(Command command, String str) throws Exception {
        String str2 = command.format;
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1097341422:
                if (str2.equals(MAPS_GROUP_VALUE_LOGCAT)) {
                    c = 0;
                    break;
                }
                break;
            case 99469:
                if (str2.equals("dir")) {
                    c = 1;
                    break;
                }
                break;
            case 3143036:
                if (str2.equals("file")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Log.e(command.value, str);
                return;
            case 1:
                writeFile(new File(new File(command.value), getTimeString()), str, false);
                return;
            case 2:
                writeFile(new File(command.value), str, true);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void outputCrashCallbacl(Command command) throws Exception {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void outputMapsGrp(Command command) throws Exception {
        String nativeGetCurrentMapsGroup = FlutterJNI.nativeGetCurrentMapsGroup(MAPS_GROUP_TYPE_PLAIN.equals(command.type));
        if (nativeGetCurrentMapsGroup.length() > 0) {
            JSONObject jSONObject = new JSONObject(nativeGetCurrentMapsGroup);
            putCommonFields(jSONObject);
            output(command, jSONObject.toString() + StringUtils.LF);
        }
    }

    private void putCommonFields(JSONObject jSONObject) throws Exception {
        jSONObject.put("time", getTimeString());
        jSONObject.put(Constants.PARAM_PROCESS_NAME, getProcessName());
        jSONObject.put("processId", Process.myPid());
    }

    private void runCommand() {
        if ((this.mFile.exists() && this.mFile.length() > 0) || (this.mFilePid.exists() && this.mFilePid.length() > 0)) {
            try {
                Command command = getCommand();
                String str = command.command;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1651901249:
                        if (str.equals(MAPS_GROUP_VALUE_PULL_REPEAT_BEGIN)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -292218255:
                        if (str.equals(MAPS_GROUP_VALUE_PULL_REPEAT_END)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3227604:
                        if (str.equals(MAPS_GROUP_VALUE_IDLE)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1723157563:
                        if (str.equals(MAPS_GROUP_VALUE_PULL_ONCE)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2) {
                            this.mRepeatCommand = null;
                            this.mHandler.removeCallbacks(this.mRepeatTask);
                        }
                    } else if (!command.equals(this.mRepeatCommand)) {
                        this.mRepeatCommand = command;
                        this.mHandler.removeCallbacks(this.mRepeatTask);
                        this.mHandler.post(this.mRepeatTask);
                    }
                } else if (command.target.equals(MAPS_GROUP_TARGET_MAPSGRP)) {
                    outputMapsGrp(command);
                } else if (command.target.equals(MAPS_GROUP_TARGET_CRASH_CALLBACK)) {
                    outputCrashCallbacl(command);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    private void writeFile(File file, String str, boolean z) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, z);
        fileWriter.write(str);
        fileWriter.close();
    }

    public void run() {
        runCommand();
        this.mHandler.postDelayed(this, 50);
        Command command = this.mRepeatCommand;
        if (command != null) {
            FlutterJNI.nativeSetMapsGroupParams(true, command.command, command.format, command.type, command.value, command.target, command.interval);
        }
    }

    public void start(Context context) {
    }

    private String getProcessName() {
        String str = this.mProcessName;
        if (str != null) {
            return str;
        }
        try {
            this.mProcessName = getProcessName(this.mAppContext);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.mProcessName == null) {
            try {
                this.mProcessName = getFileContents(new File(CMDLINE_PATH));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (this.mProcessName == null) {
            this.mProcessName = "(null)";
        }
        return this.mProcessName;
    }
}
