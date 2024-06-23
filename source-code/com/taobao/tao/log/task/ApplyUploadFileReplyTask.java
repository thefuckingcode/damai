package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.ApplyUploadReply;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadStage;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.UploadQueue;

/* compiled from: Taobao */
public class ApplyUploadFileReplyTask implements ICommandTask {
    private String TAG = "TLOG.ApplyUploadFileReplyTask";

    @Override // com.taobao.tao.log.task.ICommandTask
    public ICommandTask execute(CommandInfo commandInfo) {
        String str = "";
        TLogEventHelper.UploadEventInfo UploadEventInfo = TLogEventHelper.UploadEventInfo(commandInfo.sessionId);
        try {
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_TOKEN_RES, UploadEventInfo, commandInfo.sessionId);
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, this.TAG, "主动上报 消息处理：请求文件上传服务端回复消息");
            if (!"200".equals(commandInfo.replyCode)) {
                Log.e(this.TAG, "commandInfo.replyCode not 200");
                if ("403".equals(commandInfo.replyCode)) {
                    FileUploadListener popListener = UploadQueue.getInstance().popListener(commandInfo.requestId);
                    if (popListener != null) {
                        popListener.onError(str, ErrorCode.TOKEN_REFUSE_ERROR.getValue(), "TOKEN_REFUSE_ERROR");
                    }
                    TLogEventHelper.uploadFailEvent(UploadEventInfo, UploadStage.STAGE_RES_TOKEN, ErrorCode.TOKEN_REFUSE_ERROR.getValue(), commandInfo.replyCode, commandInfo.sessionId);
                } else {
                    try {
                        ApplyUploadReply applyUploadReply = new ApplyUploadReply();
                        applyUploadReply.parse(commandInfo.data, commandInfo);
                        str = applyUploadReply.uploadId;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ErrorCode errorCode = ErrorCode.TOKEN_REPLY_ERROR;
                    ApplyUploadCompleteRequestTask.executeFailure(commandInfo, str, null, "1", errorCode.getValue(), commandInfo.replyCode, null);
                    TLogEventHelper.uploadFailEvent(UploadEventInfo, UploadStage.STAGE_RES_TOKEN, errorCode.getValue(), commandInfo.replyCode, commandInfo.sessionId);
                }
                return this;
            }
            ApplyUploadReply applyUploadReply2 = new ApplyUploadReply();
            applyUploadReply2.parse(commandInfo.data, commandInfo);
            String str2 = applyUploadReply2.uploadId;
            UploadTokenInfo[] uploadTokenInfoArr = applyUploadReply2.tokenInfos;
            if (uploadTokenInfoArr == null || uploadTokenInfoArr.length <= 0) {
                UploadStage uploadStage = UploadStage.STAGE_RES_TOKEN;
                ErrorCode errorCode2 = ErrorCode.TOKEN_EMPTY;
                TLogEventHelper.uploadFailEvent(UploadEventInfo, uploadStage, errorCode2.getValue(), "tokenInfos is null", commandInfo.sessionId);
                ApplyUploadCompleteRequestTask.executeFailure(commandInfo, str2, null, "1", errorCode2.getValue(), "token info is empty", null);
            } else {
                UploadFileTask.taskExecute(commandInfo, str2, applyUploadReply2.tokenType, uploadTokenInfoArr, UploadEventInfo);
            }
            return this;
        } catch (Exception e2) {
            Log.e(this.TAG, "execute error");
            UploadStage uploadStage2 = UploadStage.STAGE_RES_TOKEN;
            ErrorCode errorCode3 = ErrorCode.CODE_EXC;
            TLogEventHelper.uploadFailEvent(UploadEventInfo, uploadStage2, errorCode3.getValue(), e2.getMessage(), commandInfo.sessionId);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e2);
            String value = errorCode3.getValue();
            ApplyUploadCompleteRequestTask.executeFailure(commandInfo, str, null, "1", value, "ApplyUploadFileReplyTask:" + e2.getMessage(), null);
        }
    }
}
