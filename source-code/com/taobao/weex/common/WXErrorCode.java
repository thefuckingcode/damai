package com.taobao.weex.common;

import cn.damai.launcher.utils.SplashXFlushHelper;
import com.taobao.weex.ui.module.WXDomModule;
import tb.rx0;
import tb.su0;

/* JADX WARN: Init of enum WX_ERR_LOAD_SO can be incorrect */
/* JADX WARN: Init of enum WX_ERR_LOAD_JSLIB can be incorrect */
/* JADX WARN: Init of enum WX_ERR_BAD_SO can be incorrect */
/* JADX WARN: Init of enum WX_ERR_COPY_FROM_APK can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JSFUNC_PARAM can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JSON_OBJECT can be incorrect */
/* JADX WARN: Init of enum WX_ERR_INVOKE_NATIVE can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JS_EXECUTE can be incorrect */
/* JADX WARN: Init of enum WX_SUCCESS can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_CREATEBODY can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_UPDATEATTRS can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_UPDATESTYLE can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_ADDELEMENT can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_REMOVEELEMENT can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_MOVEELEMENT can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_ADDEVENT can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_REMOVEEVENT can be incorrect */
/* JADX WARN: Init of enum WX_ERROR_DOM_CREATEFINISH can be incorrect */
/* JADX WARN: Init of enum WX_ERROR_DOM_REFRESHFINISH can be incorrect */
/* JADX WARN: Init of enum WX_ERR_DOM_SCROLLTO can be incorrect */
/* JADX WARN: Init of enum WX_ERR_RELOAD_PAGE can be incorrect */
/* JADX WARN: Init of enum WX_ERR_RELOAD_PAGE_EXCEED_LIMIT can be incorrect */
/* JADX WARN: Init of enum WX_ERROR_WHITE_SCREEN can be incorrect */
/* JADX WARN: Init of enum WHITE_SCREEN_RESPONSE_TIMEOUT can be incorrect */
/* JADX WARN: Init of enum WHITE_SCREEN_REBOOT_EXCEED_LIMIT can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JSC_CRASH can be incorrect */
/* JADX WARN: Init of enum WX_ERR_FIRST_DOM_ACTION_EXCEPTION can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JSDOWNLOAD_START can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JSBUNDLE_DOWNLOAD can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JSBUNDLE_EMPTY can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JSDOWNLOAD_END can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_INIT_SUCCESS can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_REINIT_SUCCESS can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JS_FRAMEWORK can be incorrect */
/* JADX WARN: Init of enum WX_ERR_JS_REINIT_FRAMEWORK can be incorrect */
/* JADX WARN: Init of enum WX_ERR_SINGLE_PROCESS_DLOPEN_FILE_NOT_EXIST can be incorrect */
/* JADX WARN: Init of enum WX_ERR_SINGLE_PROCESS_DLOPEN_FLAIED can be incorrect */
/* JADX WARN: Init of enum WX_ERR_SINGLE_PROCESS_DLSYM_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_ERR_SINGLE_PROCESS_JS_FRAMEWORK can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_INIT_MULPROCESS_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_REINIT_MULPROCESS_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_INIT_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL can be incorrect */
/* JADX WARN: Init of enum WX_JS_FRAMEWORK_INIT_FAILED_FIND_ICU_TIMEOUT can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_SDK_INIT can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_INVOKE_BRIDGE can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_JS_DOWNLOAD can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_WXBRIDGE can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_WXBRIDGE_EXCEPTION can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_JS_CREATE_INSTANCE can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_LAYER_OVERFLOW can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_NULL_KEY can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_NATIVE_RUNTIME can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_COMPONENT_NOT_REGISTER can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_COMPONENT_ATTR_KEY can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_BRIDGE_ARG_NULL can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_CONTAINER_TYPE can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_TRANSITION can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_INSTANCE_ID_NULL can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_TEXTURE_SETBACKGROUND can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_WAR_GPU_LIMIT_LAYOUT can be incorrect */
/* JADX WARN: Init of enum WX_RENDER_ERR_CALL_NATIVE_MODULE can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_HERON can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_HERON_RENDER can be incorrect */
/* JADX WARN: Init of enum WX_KEY_EXCEPTION_NO_BUNDLE_TYPE can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_ERR can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_ERR_OTHER_CAUSE_DEGRADTOH5 can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED_JS can be incorrect */
/* JADX WARN: Init of enum WX_DEGRAD_EAGLE_RENDER_ERROR can be incorrect */
/* JADX WARN: Init of enum WX_ERR_HASH_MAP_TMP can be incorrect */
/* JADX WARN: Init of enum WX_ERR_TEST can be incorrect */
/* compiled from: Taobao */
public enum WXErrorCode {
    WX_ERR_LOAD_SO(su0.LOGIN_ALIPAY_FAILED_CODE, "load so error", r8, r9),
    WX_ERR_LOAD_JSLIB(su0.LOGIN_TAOBAO_FAILED_CODE, "unzip JSLib error!", r8, r9),
    WX_ERR_BAD_SO(su0.LOGIN_WEIBO_FAILED_CODE, "so size error, to reload apk so", r8, r9),
    WX_ERR_COPY_FROM_APK(su0.LOGIN_YOUKU_FAILED_CODE, "system load so error，copy from APK also error!", r8, r9),
    WX_ERR_JSFUNC_PARAM("-2009", "JS params error!", r8, r9),
    WX_ERR_JSON_OBJECT("-2008", "transform JSON->OBJ  error!", r8, r9),
    WX_ERR_INVOKE_NATIVE("-2012", "Native-> Call ->JS  error!", r8, r9),
    WX_ERR_JS_EXECUTE("-2013", "JavaScript execute error!", r24, r25),
    WX_SUCCESS("0", "successful", r8, r9),
    WX_ERR_DOM_CREATEBODY("-2100", "createBody error", r8, r9),
    WX_ERR_DOM_UPDATEATTRS("-2101", "updateAttrs error", r8, r9),
    WX_ERR_DOM_UPDATESTYLE("-2102", "updateStyle error", r8, r9),
    WX_ERR_DOM_ADDELEMENT("-2103", "addElement error", r8, r9),
    WX_ERR_DOM_REMOVEELEMENT("-2104", "removeElement error", r8, r9),
    WX_ERR_DOM_MOVEELEMENT("-2105", "moveElement error", r8, r9),
    WX_ERR_DOM_ADDEVENT("-2106", "addEvent error", r8, r9),
    WX_ERR_DOM_REMOVEEVENT("-2107", "removeEvent error", r8, r9),
    WX_ERROR_DOM_CREATEFINISH("-2108", "createFinish error", r8, r9),
    WX_ERROR_DOM_REFRESHFINISH("-2109", "refreshFinish error", r8, r9),
    WX_ERR_DOM_SCROLLTO("-2110", WXDomModule.SCROLL_TO_ELEMENT, r8, r9),
    WX_ERR_RELOAD_PAGE("-2111", "reloadPage", r8, r9),
    WX_ERR_RELOAD_PAGE_EXCEED_LIMIT("-2114", "RELOAD_PAGE_EXCEED_LIMIT", r8, r9),
    WX_ERROR_WHITE_SCREEN("-2116", "WHITE_SCREEN", r34, r25),
    WHITE_SCREEN_RESPONSE_TIMEOUT("-2117", "WHITE_SCREEN_RESPONSE_TIMEOUT", r34, r25),
    WHITE_SCREEN_REBOOT_EXCEED_LIMIT("-2118", "WHITE_SCREEN_REBOOT_EXCEED_LIMIT", r34, r25),
    WX_ERR_JSC_CRASH("-2112", "weexjscCrash", r8, r9),
    WX_ERR_FIRST_DOM_ACTION_EXCEPTION("-2113", "dom action is invalid ", r8, r9),
    WX_ERR_JSDOWNLOAD_START("-2201", "js bundle download start", r8, r9),
    WX_ERR_JSBUNDLE_DOWNLOAD("-2299", "js bundle download err", r8, r9),
    WX_ERR_JSBUNDLE_EMPTY("-2203", "js bundle empty", r8, r9),
    WX_ERR_JSDOWNLOAD_END("-2299", "js bundle download end", r8, r9),
    WX_JS_FRAMEWORK_INIT_SUCCESS("-1000", "js framework success", r8, r9),
    WX_JS_FRAMEWORK_REINIT_SUCCESS("-1001", "js framework reinit success", r8, r9),
    WX_ERR_JS_FRAMEWORK("-1002", "js framework error", r8, r9),
    WX_ERR_JS_REINIT_FRAMEWORK("-1003", "js reinit framework error", r8, r9),
    WX_ERR_SINGLE_PROCESS_DLOPEN_FILE_NOT_EXIST("-1004", "so file does not exist", r8, r9),
    WX_ERR_SINGLE_PROCESS_DLOPEN_FLAIED(rx0.HOMEPAGE_CHANNEL_FEED_FAIL_CODE, "dlopen so file failed", r8, r9),
    WX_ERR_SINGLE_PROCESS_DLSYM_FAILED("-1006", "find function from so file failed", r8, r9),
    WX_ERR_SINGLE_PROCESS_JS_FRAMEWORK("-1007", "js framework  init singleProcess failed", r8, r9),
    WX_JS_FRAMEWORK_INIT_MULPROCESS_FAILED("-1008", "js framework init multiProcess failed", r8, r9),
    WX_JS_FRAMEWORK_REINIT_MULPROCESS_FAILED("-1009", "js framework reinit multiProcess failed", r8, r9),
    WX_JS_FRAMEWORK_INIT_FAILED(SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE0, "js framework init failed", r8, r9),
    WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS("-1011", "js framework init success in single process", r8, r9),
    WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL(SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE2, "js framework init failed due to params null", r8, r9),
    WX_JS_FRAMEWORK_INIT_FAILED_FIND_ICU_TIMEOUT(SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE3, "find icu failed", r8, r9),
    WX_KEY_EXCEPTION_SDK_INIT("-9000", "[WX_KEY_EXCEPTION_SDK_INIT]", r8, r9),
    WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT("-9001", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpu is x86", r8, r9),
    WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT("-9002", "[WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT] for device isTabletDevice", r8, r9),
    WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED("-9003", "[WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED] for jsfm init failed|detail error is:", r8, r9),
    WX_KEY_EXCEPTION_INVOKE_BRIDGE("-9100", "[WX_KEY_EXCEPTION_INVOKE_BRIDGE]", r8, r9),
    WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED("-9101", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED] details", r8, r9),
    WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE("-9102", "[WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE] details", r8, r9),
    WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES("-9103", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES] details", r8, r9),
    WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT("-9104", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT] details", r8, r9),
    WX_KEY_EXCEPTION_JS_DOWNLOAD("-9200", "[WX_KEY_EXCEPTION_JS_DOWNLOAD]|", r67, r9),
    WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED("-9201", "[WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED] | details", r67, r9),
    WX_KEY_EXCEPTION_WXBRIDGE("-9400", "[js excute runtime error] detail js stack -> ", r24, r25),
    WX_KEY_EXCEPTION_WXBRIDGE_EXCEPTION("-9401", "[js excute runtime error] detail js stack -> ", r24, r25),
    WX_RENDER_ERR_JS_CREATE_INSTANCE("-9600", "white screen cause create instance failed,check js stack ->", r34, r25),
    WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT("-9700", "white screen cause create instanceContext failed,check js stack ->", r34, r25),
    WX_RENDER_ERR_LAYER_OVERFLOW("-9602", "WX_RENDER_ERR_LAYER_OVERFLOW", r8, r9),
    WX_RENDER_ERR_NULL_KEY("-9603", "WX_RENDER_ERR_NULL_KEY", r8, r9),
    WX_RENDER_ERR_NATIVE_RUNTIME("-9604", "WX_RENDER_ERR for js error", r34, r9),
    WX_RENDER_ERR_COMPONENT_NOT_REGISTER("-9605", "WX_RENDER_ERR_COMPONENT_NOT_REGISTER", r8, r9),
    WX_RENDER_ERR_COMPONENT_ATTR_KEY("-9606", "The key passed to Component.updateAttr() is not string", r8, r25),
    WX_RENDER_ERR_BRIDGE_ARG_NULL("-9610", "WX_RENDER_ERR_BRIDGE_ARG_NULL", r8, r9),
    WX_RENDER_ERR_CONTAINER_TYPE("-9611", "WX_RENDER_ERR_CONTAINER_TYPE", r24, r25),
    WX_RENDER_ERR_TRANSITION("-9616", "WX_RENDER_ERR_TRANSITION", r24, r25),
    WX_RENDER_ERR_INSTANCE_ID_NULL("-9618", "WX_RENDER_ERR_INSTANCE_ID_NULL", r8, r9),
    WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT("-9619", "WX_RENDER_ERR_LIST_INVALID_COLUMNJ_CONUNT", r24, r25),
    WX_RENDER_ERR_TEXTURE_SETBACKGROUND("-9620", "WX_RENDER_ERR_TEXTURE_SETBACKGROUND", r8, r9),
    WX_RENDER_WAR_GPU_LIMIT_LAYOUT("-9621", "WX_RENDER_WAR_GPU_LIMIT_LAYOUT", r24, r25),
    WX_RENDER_ERR_CALL_NATIVE_MODULE("-9622", "WX_CALL_NATIVE_MODULE_ERROR", r8, r9),
    WX_KEY_EXCEPTION_HERON("Heron_-9900", "Error of Heron engine: ", r8, r9),
    WX_KEY_EXCEPTION_HERON_RENDER("Heron_-9901", "Render error of Heron engine: ", r34, r9),
    WX_KEY_EXCEPTION_NO_BUNDLE_TYPE("-9801", "Fatal Error : No bundle type in js bundle head, cause white screen or memory leak!!", r24, r25),
    WX_DEGRAD_ERR("-1000", "degradeToH5|Weex DegradPassivity ->", r88, r25),
    WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED("-1001", "degradeToH5|createInstance fail|wx_create_instance_error", r88, r9),
    WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED("-1002", "|wx_network_error|js bundle download failed", r67, r9),
    WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED("-1003", "degradeToH5|wx_network_error|js bundle content-length check failed", r88, r9),
    WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR("-1004", "degradeToH5|wx_user_intercept_error |Content-Type is not application/javascript, Weex render template must be javascript, please check your request!", r88, r9),
    WX_DEGRAD_ERR_OTHER_CAUSE_DEGRADTOH5(rx0.HOMEPAGE_CHANNEL_FEED_FAIL_CODE, "degradeToH5|for other reason|", r88, r9),
    WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED_JS("-1006", "degradeToH5|createInstance fail|wx_create_instance_error", r88, r25),
    WX_DEGRAD_EAGLE_RENDER_ERROR("Eagle_-1007", "degradeToH5|eagleRenderErr", r88, r9),
    WX_ERR_HASH_MAP_TMP("-10010", "WX_ERR_HASH_MAP_TMP", r8, r9),
    WX_ERR_TEST("test", "test", r8, r9);
    
    private String appendMsg = "";
    private String args;
    private String errorCode;
    private String errorMsg;
    private ErrorGroup mErrorGroup;
    private ErrorType mErrorType;

    /* compiled from: Taobao */
    public enum ErrorGroup {
        JS,
        NATIVE
    }

    /* compiled from: Taobao */
    public enum ErrorType {
        JS_ERROR,
        NATIVE_ERROR,
        RENDER_ERROR,
        DEGRAD_ERROR,
        DOWN_LOAD_ERROR
    }

    static {
        ErrorType errorType = ErrorType.NATIVE_ERROR;
        ErrorGroup errorGroup = ErrorGroup.NATIVE;
        ErrorType errorType2 = ErrorType.JS_ERROR;
        ErrorGroup errorGroup2 = ErrorGroup.JS;
        ErrorType errorType3 = ErrorType.RENDER_ERROR;
        ErrorType errorType4 = ErrorType.DOWN_LOAD_ERROR;
        ErrorType errorType5 = ErrorType.DEGRAD_ERROR;
    }

    private WXErrorCode(String str, String str2, ErrorType errorType, ErrorGroup errorGroup) {
        this.errorCode = str;
        this.errorMsg = str2;
        this.mErrorType = errorType;
        this.mErrorGroup = errorGroup;
    }

    public void appendErrMsg(String str) {
        this.appendMsg = str;
    }

    public String getArgs() {
        return this.args;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public ErrorGroup getErrorGroup() {
        return this.mErrorGroup;
    }

    public String getErrorMsg() {
        return this.errorMsg + this.appendMsg;
    }

    public ErrorType getErrorType() {
        return this.mErrorType;
    }

    public void setArgs(String str) {
        this.args = str;
    }
}
