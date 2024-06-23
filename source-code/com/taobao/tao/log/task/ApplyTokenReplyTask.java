package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.ApplyTokenReply;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;

/* compiled from: Taobao */
public class ApplyTokenReplyTask implements ICommandTask {
    private String TAG = "TLOG.ApplyTokenReplyTask";

    @Override // com.taobao.tao.log.task.ICommandTask
    public ICommandTask execute(CommandInfo commandInfo) {
        String str = commandInfo.sessionId;
        TLogEventHelper.UploadEventInfo UploadEventInfo = TLogEventHelper.UploadEventInfo(str);
        try {
            UploadFileType uploadFileType = UploadEventInfo.fileType;
            UploadReason uploadReason = UploadReason.SERVER_PULL;
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_TOKEN_RES, uploadFileType, uploadReason, str);
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, this.TAG, "消息处理：申请token回复消息");
            if (!"200".equals(commandInfo.replyCode)) {
                Log.e(this.TAG, "commandInfo.replyCode not 200");
                if ("403".equals(commandInfo.replyCode)) {
                    TLogEventHelper.uploadFailEvent(UploadEventInfo.fileType, uploadReason, UploadStage.STAGE_RES_TOKEN, ErrorCode.TOKEN_REFUSE_ERROR.getValue(), commandInfo.replyCode, str);
                } else {
                    ErrorCode errorCode = ErrorCode.TOKEN_REPLY_ERROR;
                    LogUploadReplyTask.executeFailure(commandInfo, str, null, "1", errorCode.getValue(), commandInfo.replyCode, null);
                    TLogEventHelper.uploadFailEvent(UploadEventInfo.fileType, uploadReason, UploadStage.STAGE_RES_TOKEN, errorCode.getValue(), commandInfo.replyCode, str);
                }
                return this;
            }
            ApplyTokenReply applyTokenReply = new ApplyTokenReply();
            applyTokenReply.parse(commandInfo.data, commandInfo);
            UploadTokenInfo[] uploadTokenInfoArr = applyTokenReply.tokenInfos;
            Log.e("tlog-debug", "ApplyTokenReplyTask execute uploadId = " + str);
            if (uploadTokenInfoArr == null || uploadTokenInfoArr.length <= 0) {
                UploadFileType uploadFileType2 = UploadEventInfo.fileType;
                UploadStage uploadStage = UploadStage.STAGE_RES_TOKEN;
                ErrorCode errorCode2 = ErrorCode.TOKEN_EMPTY;
                TLogEventHelper.uploadFailEvent(uploadFileType2, uploadReason, uploadStage, errorCode2.getValue(), "tokenInfos is null", str);
                LogUploadReplyTask.executeFailure(commandInfo, str, null, "1", errorCode2.getValue(), "token info is empty", null);
            } else {
                UploadFileTask.taskExecute(commandInfo, str, applyTokenReply.tokenType, applyTokenReply.tokenInfos, UploadEventInfo);
            }
            return this;
        } catch (Exception e) {
            Log.e(this.TAG, "execute error", e);
            UploadFileType uploadFileType3 = UploadEventInfo.fileType;
            UploadReason uploadReason2 = UploadReason.SERVER_PULL;
            UploadStage uploadStage2 = UploadStage.STAGE_RES_TOKEN;
            ErrorCode errorCode3 = ErrorCode.CODE_EXC;
            TLogEventHelper.uploadFailEvent(uploadFileType3, uploadReason2, uploadStage2, errorCode3.getValue(), e.getMessage(), str);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e);
            String value = errorCode3.getValue();
            LogUploadReplyTask.executeFailure(commandInfo, str, null, "1", value, "ApplyTokenReplyTask:" + e.getMessage(), null);
        }
    }
}
