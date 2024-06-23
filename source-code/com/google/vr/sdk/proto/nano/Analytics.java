package com.google.vr.sdk.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: Taobao */
public class Analytics {

    /* compiled from: Taobao */
    public static final class AnalyticsRequest extends ExtendableMessageNano<AnalyticsRequest> implements Cloneable {
        private static volatile AnalyticsRequest[] _emptyArray;
        private int bitField0_;
        private long prevSampleTimestampNanoseconds_;

        public AnalyticsRequest() {
            clear();
        }

        public static AnalyticsRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AnalyticsRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static AnalyticsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new AnalyticsRequest(), bArr);
        }

        public final AnalyticsRequest clear() {
            this.bitField0_ = 0;
            this.prevSampleTimestampNanoseconds_ = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AnalyticsRequest clearPrevSampleTimestampNanoseconds() {
            this.prevSampleTimestampNanoseconds_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Analytics.super.computeSerializedSize();
            return (this.bitField0_ & 1) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, this.prevSampleTimestampNanoseconds_) : computeSerializedSize;
        }

        public final long getPrevSampleTimestampNanoseconds() {
            return this.prevSampleTimestampNanoseconds_;
        }

        public final boolean hasPrevSampleTimestampNanoseconds() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AnalyticsRequest setPrevSampleTimestampNanoseconds(long j) {
            this.bitField0_ |= 1;
            this.prevSampleTimestampNanoseconds_ = j;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.prevSampleTimestampNanoseconds_);
            }
            Analytics.super.writeTo(codedOutputByteBufferNano);
        }

        public static AnalyticsRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AnalyticsRequest().mergeFrom(codedInputByteBufferNano);
        }

        public final AnalyticsRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.prevSampleTimestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                    this.bitField0_ |= 1;
                } else if (!Analytics.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // java.lang.Object
        public final AnalyticsRequest clone() {
            try {
                return Analytics.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class AnalyticsSample extends ExtendableMessageNano<AnalyticsSample> implements Cloneable {
        private static volatile AnalyticsSample[] _emptyArray;
        public AppAnalytics appAnalytics;
        public AsyncReprojectionAnalytics asyncReprojectionAnalytics;
        private int bitField0_;
        private long timestampNanoseconds_;

        public AnalyticsSample() {
            clear();
        }

        public static AnalyticsSample[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AnalyticsSample[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static AnalyticsSample parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new AnalyticsSample(), bArr);
        }

        public final AnalyticsSample clear() {
            this.bitField0_ = 0;
            this.timestampNanoseconds_ = 0;
            this.asyncReprojectionAnalytics = null;
            this.appAnalytics = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AnalyticsSample clearTimestampNanoseconds() {
            this.timestampNanoseconds_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Analytics.super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNanoseconds_);
            }
            AsyncReprojectionAnalytics asyncReprojectionAnalytics2 = this.asyncReprojectionAnalytics;
            if (asyncReprojectionAnalytics2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, asyncReprojectionAnalytics2);
            }
            AppAnalytics appAnalytics2 = this.appAnalytics;
            return appAnalytics2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, appAnalytics2) : computeSerializedSize;
        }

        public final long getTimestampNanoseconds() {
            return this.timestampNanoseconds_;
        }

        public final boolean hasTimestampNanoseconds() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AnalyticsSample setTimestampNanoseconds(long j) {
            this.bitField0_ |= 1;
            this.timestampNanoseconds_ = j;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.timestampNanoseconds_);
            }
            AsyncReprojectionAnalytics asyncReprojectionAnalytics2 = this.asyncReprojectionAnalytics;
            if (asyncReprojectionAnalytics2 != null) {
                codedOutputByteBufferNano.writeMessage(2, asyncReprojectionAnalytics2);
            }
            AppAnalytics appAnalytics2 = this.appAnalytics;
            if (appAnalytics2 != null) {
                codedOutputByteBufferNano.writeMessage(3, appAnalytics2);
            }
            Analytics.super.writeTo(codedOutputByteBufferNano);
        }

        public static AnalyticsSample parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AnalyticsSample().mergeFrom(codedInputByteBufferNano);
        }

        public final AnalyticsSample mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.timestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                    this.bitField0_ |= 1;
                } else if (readTag == 18) {
                    if (this.asyncReprojectionAnalytics == null) {
                        this.asyncReprojectionAnalytics = new AsyncReprojectionAnalytics();
                    }
                    codedInputByteBufferNano.readMessage(this.asyncReprojectionAnalytics);
                } else if (readTag == 26) {
                    if (this.appAnalytics == null) {
                        this.appAnalytics = new AppAnalytics();
                    }
                    codedInputByteBufferNano.readMessage(this.appAnalytics);
                } else if (!Analytics.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // java.lang.Object
        public final AnalyticsSample clone() {
            try {
                AnalyticsSample clone = Analytics.super.clone();
                AsyncReprojectionAnalytics asyncReprojectionAnalytics2 = this.asyncReprojectionAnalytics;
                if (asyncReprojectionAnalytics2 != null) {
                    clone.asyncReprojectionAnalytics = asyncReprojectionAnalytics2.clone();
                }
                AppAnalytics appAnalytics2 = this.appAnalytics;
                if (appAnalytics2 != null) {
                    clone.appAnalytics = appAnalytics2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class AppAnalytics extends ExtendableMessageNano<AppAnalytics> implements Cloneable {
        private static volatile AppAnalytics[] _emptyArray;
        private int bitField0_;
        private float fps_;
        public SubmitStatus[] submitStatus;

        /* compiled from: Taobao */
        public static final class SubmitStatus extends ExtendableMessageNano<SubmitStatus> implements Cloneable {
            private static volatile SubmitStatus[] _emptyArray;
            private int bitField0_;
            private long timestampNanoseconds_;
            private boolean wasBlockedOnGpu_;

            public SubmitStatus() {
                clear();
            }

            public static SubmitStatus[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new SubmitStatus[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static SubmitStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return MessageNano.mergeFrom(new SubmitStatus(), bArr);
            }

            public final SubmitStatus clear() {
                this.bitField0_ = 0;
                this.timestampNanoseconds_ = 0;
                this.wasBlockedOnGpu_ = false;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final SubmitStatus clearTimestampNanoseconds() {
                this.timestampNanoseconds_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final SubmitStatus clearWasBlockedOnGpu() {
                this.wasBlockedOnGpu_ = false;
                this.bitField0_ &= -3;
                return this;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = AppAnalytics.super.computeSerializedSize();
                if ((this.bitField0_ & 1) != 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNanoseconds_);
                }
                return (this.bitField0_ & 2) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, this.wasBlockedOnGpu_) : computeSerializedSize;
            }

            public final long getTimestampNanoseconds() {
                return this.timestampNanoseconds_;
            }

            public final boolean getWasBlockedOnGpu() {
                return this.wasBlockedOnGpu_;
            }

            public final boolean hasTimestampNanoseconds() {
                return (this.bitField0_ & 1) != 0;
            }

            public final boolean hasWasBlockedOnGpu() {
                return (this.bitField0_ & 2) != 0;
            }

            public final SubmitStatus setTimestampNanoseconds(long j) {
                this.bitField0_ |= 1;
                this.timestampNanoseconds_ = j;
                return this;
            }

            public final SubmitStatus setWasBlockedOnGpu(boolean z) {
                this.bitField0_ |= 2;
                this.wasBlockedOnGpu_ = z;
                return this;
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputByteBufferNano.writeInt64(1, this.timestampNanoseconds_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputByteBufferNano.writeBool(2, this.wasBlockedOnGpu_);
                }
                AppAnalytics.super.writeTo(codedOutputByteBufferNano);
            }

            public static SubmitStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new SubmitStatus().mergeFrom(codedInputByteBufferNano);
            }

            public final SubmitStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.timestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
                    } else if (readTag == 16) {
                        this.wasBlockedOnGpu_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 2;
                    } else if (!AppAnalytics.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // java.lang.Object
            public final SubmitStatus clone() {
                try {
                    return AppAnalytics.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        public AppAnalytics() {
            clear();
        }

        public static AppAnalytics[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppAnalytics[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static AppAnalytics parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new AppAnalytics(), bArr);
        }

        public final AppAnalytics clear() {
            this.bitField0_ = 0;
            this.fps_ = 0.0f;
            this.submitStatus = SubmitStatus.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AppAnalytics clearFps() {
            this.fps_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Analytics.super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.fps_);
            }
            SubmitStatus[] submitStatusArr = this.submitStatus;
            if (submitStatusArr != null && submitStatusArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.submitStatus;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final float getFps() {
            return this.fps_;
        }

        public final boolean hasFps() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AppAnalytics setFps(float f) {
            this.bitField0_ |= 1;
            this.fps_ = f;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.fps_);
            }
            SubmitStatus[] submitStatusArr = this.submitStatus;
            if (submitStatusArr != null && submitStatusArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.submitStatus;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(2, messageNano);
                    }
                    i++;
                }
            }
            Analytics.super.writeTo(codedOutputByteBufferNano);
        }

        public static AppAnalytics parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AppAnalytics().mergeFrom(codedInputByteBufferNano);
        }

        public final AppAnalytics mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.fps_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 1;
                } else if (readTag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    SubmitStatus[] submitStatusArr = this.submitStatus;
                    int length = submitStatusArr == null ? 0 : submitStatusArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new SubmitStatus[i];
                    if (length != 0) {
                        System.arraycopy(submitStatusArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new SubmitStatus();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new SubmitStatus();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.submitStatus = messageNanoArr;
                } else if (!Analytics.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // java.lang.Object
        public final AppAnalytics clone() {
            try {
                AppAnalytics clone = Analytics.super.clone();
                SubmitStatus[] submitStatusArr = this.submitStatus;
                if (submitStatusArr != null && submitStatusArr.length > 0) {
                    clone.submitStatus = new SubmitStatus[submitStatusArr.length];
                    int i = 0;
                    while (true) {
                        SubmitStatus[] submitStatusArr2 = this.submitStatus;
                        if (i >= submitStatusArr2.length) {
                            break;
                        }
                        if (submitStatusArr2[i] != null) {
                            clone.submitStatus[i] = submitStatusArr2[i].clone();
                        }
                        i++;
                    }
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class AsyncReprojectionAnalytics extends ExtendableMessageNano<AsyncReprojectionAnalytics> implements Cloneable {
        private static volatile AsyncReprojectionAnalytics[] _emptyArray;
        private int bitField0_;
        private float fps_;
        private int totalMissedVsyncs_;
        public VsyncStatus[] vsyncStatus;

        /* compiled from: Taobao */
        public static final class VsyncStatus extends ExtendableMessageNano<VsyncStatus> implements Cloneable {
            private static volatile VsyncStatus[] _emptyArray;
            private int bitField0_;
            private MissedVsync missedVsync;
            private NewAppFrame newAppFrame;
            private int oneof_Status_ = -1;
            private ReusedAppFrame reusedAppFrame;
            private long timestampNanoseconds_;

            /* compiled from: Taobao */
            public static final class MissedVsync extends ExtendableMessageNano<MissedVsync> implements Cloneable {
                private static volatile MissedVsync[] _emptyArray;

                public MissedVsync() {
                    clear();
                }

                public static MissedVsync[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new MissedVsync[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static MissedVsync parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                    return MessageNano.mergeFrom(new MissedVsync(), bArr);
                }

                public final MissedVsync clear() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public static MissedVsync parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    return new MissedVsync().mergeFrom(codedInputByteBufferNano);
                }

                public final MissedVsync mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    int readTag;
                    do {
                        readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            break;
                        }
                    } while (VsyncStatus.super.storeUnknownField(codedInputByteBufferNano, readTag));
                    return this;
                }

                @Override // java.lang.Object
                public final MissedVsync clone() {
                    try {
                        return VsyncStatus.super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            /* compiled from: Taobao */
            public static final class NewAppFrame extends ExtendableMessageNano<NewAppFrame> implements Cloneable {
                private static volatile NewAppFrame[] _emptyArray;
                private int bitField0_;
                private int numSkippedAppFrames_;
                private long sinceSubmitNanoseconds_;

                public NewAppFrame() {
                    clear();
                }

                public static NewAppFrame[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new NewAppFrame[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static NewAppFrame parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                    return MessageNano.mergeFrom(new NewAppFrame(), bArr);
                }

                public final NewAppFrame clear() {
                    this.bitField0_ = 0;
                    this.sinceSubmitNanoseconds_ = 0;
                    this.numSkippedAppFrames_ = 0;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final NewAppFrame clearNumSkippedAppFrames() {
                    this.numSkippedAppFrames_ = 0;
                    this.bitField0_ &= -3;
                    return this;
                }

                public final NewAppFrame clearSinceSubmitNanoseconds() {
                    this.sinceSubmitNanoseconds_ = 0;
                    this.bitField0_ &= -2;
                    return this;
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = VsyncStatus.super.computeSerializedSize();
                    if ((this.bitField0_ & 1) != 0) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.sinceSubmitNanoseconds_);
                    }
                    return (this.bitField0_ & 2) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, this.numSkippedAppFrames_) : computeSerializedSize;
                }

                public final int getNumSkippedAppFrames() {
                    return this.numSkippedAppFrames_;
                }

                public final long getSinceSubmitNanoseconds() {
                    return this.sinceSubmitNanoseconds_;
                }

                public final boolean hasNumSkippedAppFrames() {
                    return (this.bitField0_ & 2) != 0;
                }

                public final boolean hasSinceSubmitNanoseconds() {
                    return (this.bitField0_ & 1) != 0;
                }

                public final NewAppFrame setNumSkippedAppFrames(int i) {
                    this.bitField0_ |= 2;
                    this.numSkippedAppFrames_ = i;
                    return this;
                }

                public final NewAppFrame setSinceSubmitNanoseconds(long j) {
                    this.bitField0_ |= 1;
                    this.sinceSubmitNanoseconds_ = j;
                    return this;
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if ((this.bitField0_ & 1) != 0) {
                        codedOutputByteBufferNano.writeInt64(1, this.sinceSubmitNanoseconds_);
                    }
                    if ((this.bitField0_ & 2) != 0) {
                        codedOutputByteBufferNano.writeInt32(2, this.numSkippedAppFrames_);
                    }
                    VsyncStatus.super.writeTo(codedOutputByteBufferNano);
                }

                public static NewAppFrame parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    return new NewAppFrame().mergeFrom(codedInputByteBufferNano);
                }

                public final NewAppFrame mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            this.sinceSubmitNanoseconds_ = codedInputByteBufferNano.readInt64();
                            this.bitField0_ |= 1;
                        } else if (readTag == 16) {
                            this.numSkippedAppFrames_ = codedInputByteBufferNano.readInt32();
                            this.bitField0_ |= 2;
                        } else if (!VsyncStatus.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // java.lang.Object
                public final NewAppFrame clone() {
                    try {
                        return VsyncStatus.super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            /* compiled from: Taobao */
            public static final class ReusedAppFrame extends ExtendableMessageNano<ReusedAppFrame> implements Cloneable {
                private static volatile ReusedAppFrame[] _emptyArray;
                private int bitField0_;
                private long sinceSubmitNanoseconds_;

                public ReusedAppFrame() {
                    clear();
                }

                public static ReusedAppFrame[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new ReusedAppFrame[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static ReusedAppFrame parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                    return MessageNano.mergeFrom(new ReusedAppFrame(), bArr);
                }

                public final ReusedAppFrame clear() {
                    this.bitField0_ = 0;
                    this.sinceSubmitNanoseconds_ = 0;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final ReusedAppFrame clearSinceSubmitNanoseconds() {
                    this.sinceSubmitNanoseconds_ = 0;
                    this.bitField0_ &= -2;
                    return this;
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = VsyncStatus.super.computeSerializedSize();
                    return (this.bitField0_ & 1) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, this.sinceSubmitNanoseconds_) : computeSerializedSize;
                }

                public final long getSinceSubmitNanoseconds() {
                    return this.sinceSubmitNanoseconds_;
                }

                public final boolean hasSinceSubmitNanoseconds() {
                    return (this.bitField0_ & 1) != 0;
                }

                public final ReusedAppFrame setSinceSubmitNanoseconds(long j) {
                    this.bitField0_ |= 1;
                    this.sinceSubmitNanoseconds_ = j;
                    return this;
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    if ((this.bitField0_ & 1) != 0) {
                        codedOutputByteBufferNano.writeInt64(1, this.sinceSubmitNanoseconds_);
                    }
                    VsyncStatus.super.writeTo(codedOutputByteBufferNano);
                }

                public static ReusedAppFrame parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    return new ReusedAppFrame().mergeFrom(codedInputByteBufferNano);
                }

                public final ReusedAppFrame mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            this.sinceSubmitNanoseconds_ = codedInputByteBufferNano.readInt64();
                            this.bitField0_ |= 1;
                        } else if (!VsyncStatus.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // java.lang.Object
                public final ReusedAppFrame clone() {
                    try {
                        return VsyncStatus.super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            public VsyncStatus() {
                clear();
            }

            public static VsyncStatus[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new VsyncStatus[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static VsyncStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return MessageNano.mergeFrom(new VsyncStatus(), bArr);
            }

            public final VsyncStatus clear() {
                this.bitField0_ = 0;
                this.timestampNanoseconds_ = 0;
                this.oneof_Status_ = -1;
                this.newAppFrame = null;
                this.oneof_Status_ = -1;
                this.reusedAppFrame = null;
                this.oneof_Status_ = -1;
                this.missedVsync = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final VsyncStatus clearTimestampNanoseconds() {
                this.timestampNanoseconds_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = AsyncReprojectionAnalytics.super.computeSerializedSize();
                if ((this.bitField0_ & 1) != 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNanoseconds_);
                }
                if (this.oneof_Status_ == 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, this.newAppFrame);
                }
                if (this.oneof_Status_ == 1) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, this.reusedAppFrame);
                }
                return this.oneof_Status_ == 2 ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, this.missedVsync) : computeSerializedSize;
            }

            public final MissedVsync getMissedVsync() {
                if (this.oneof_Status_ == 2) {
                    return this.missedVsync;
                }
                return null;
            }

            public final NewAppFrame getNewAppFrame() {
                if (this.oneof_Status_ == 0) {
                    return this.newAppFrame;
                }
                return null;
            }

            public final ReusedAppFrame getReusedAppFrame() {
                if (this.oneof_Status_ == 1) {
                    return this.reusedAppFrame;
                }
                return null;
            }

            public final long getTimestampNanoseconds() {
                return this.timestampNanoseconds_;
            }

            public final boolean hasMissedVsync() {
                return this.oneof_Status_ == 2;
            }

            public final boolean hasNewAppFrame() {
                return this.oneof_Status_ == 0;
            }

            public final boolean hasReusedAppFrame() {
                return this.oneof_Status_ == 1;
            }

            public final boolean hasTimestampNanoseconds() {
                return (this.bitField0_ & 1) != 0;
            }

            public final VsyncStatus setMissedVsync(MissedVsync missedVsync2) {
                if (missedVsync2 == null) {
                    if (this.oneof_Status_ == 2) {
                        this.oneof_Status_ = -1;
                    }
                    this.missedVsync = null;
                    return this;
                }
                this.oneof_Status_ = -1;
                this.oneof_Status_ = 2;
                this.missedVsync = missedVsync2;
                return this;
            }

            public final VsyncStatus setNewAppFrame(NewAppFrame newAppFrame2) {
                if (newAppFrame2 == null) {
                    if (this.oneof_Status_ == 0) {
                        this.oneof_Status_ = -1;
                    }
                    this.newAppFrame = null;
                    return this;
                }
                this.oneof_Status_ = -1;
                this.oneof_Status_ = 0;
                this.newAppFrame = newAppFrame2;
                return this;
            }

            public final VsyncStatus setReusedAppFrame(ReusedAppFrame reusedAppFrame2) {
                if (reusedAppFrame2 == null) {
                    if (this.oneof_Status_ == 1) {
                        this.oneof_Status_ = -1;
                    }
                    this.reusedAppFrame = null;
                    return this;
                }
                this.oneof_Status_ = -1;
                this.oneof_Status_ = 1;
                this.reusedAppFrame = reusedAppFrame2;
                return this;
            }

            public final VsyncStatus setTimestampNanoseconds(long j) {
                this.bitField0_ |= 1;
                this.timestampNanoseconds_ = j;
                return this;
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputByteBufferNano.writeInt64(1, this.timestampNanoseconds_);
                }
                if (this.oneof_Status_ == 0) {
                    codedOutputByteBufferNano.writeMessage(2, this.newAppFrame);
                }
                if (this.oneof_Status_ == 1) {
                    codedOutputByteBufferNano.writeMessage(3, this.reusedAppFrame);
                }
                if (this.oneof_Status_ == 2) {
                    codedOutputByteBufferNano.writeMessage(4, this.missedVsync);
                }
                AsyncReprojectionAnalytics.super.writeTo(codedOutputByteBufferNano);
            }

            public static VsyncStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new VsyncStatus().mergeFrom(codedInputByteBufferNano);
            }

            public final VsyncStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.timestampNanoseconds_ = codedInputByteBufferNano.readInt64();
                        this.bitField0_ |= 1;
                    } else if (readTag == 18) {
                        if (this.newAppFrame == null) {
                            this.newAppFrame = new NewAppFrame();
                        }
                        codedInputByteBufferNano.readMessage(this.newAppFrame);
                        this.oneof_Status_ = 0;
                    } else if (readTag == 26) {
                        if (this.reusedAppFrame == null) {
                            this.reusedAppFrame = new ReusedAppFrame();
                        }
                        codedInputByteBufferNano.readMessage(this.reusedAppFrame);
                        this.oneof_Status_ = 1;
                    } else if (readTag == 34) {
                        if (this.missedVsync == null) {
                            this.missedVsync = new MissedVsync();
                        }
                        codedInputByteBufferNano.readMessage(this.missedVsync);
                        this.oneof_Status_ = 2;
                    } else if (!AsyncReprojectionAnalytics.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // java.lang.Object
            public final VsyncStatus clone() {
                try {
                    VsyncStatus clone = AsyncReprojectionAnalytics.super.clone();
                    NewAppFrame newAppFrame2 = this.newAppFrame;
                    if (newAppFrame2 != null) {
                        clone.newAppFrame = newAppFrame2.clone();
                    }
                    ReusedAppFrame reusedAppFrame2 = this.reusedAppFrame;
                    if (reusedAppFrame2 != null) {
                        clone.reusedAppFrame = reusedAppFrame2.clone();
                    }
                    MissedVsync missedVsync2 = this.missedVsync;
                    if (missedVsync2 != null) {
                        clone.missedVsync = missedVsync2.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        public AsyncReprojectionAnalytics() {
            clear();
        }

        public static AsyncReprojectionAnalytics[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AsyncReprojectionAnalytics[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static AsyncReprojectionAnalytics parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new AsyncReprojectionAnalytics(), bArr);
        }

        public final AsyncReprojectionAnalytics clear() {
            this.bitField0_ = 0;
            this.totalMissedVsyncs_ = 0;
            this.fps_ = 0.0f;
            this.vsyncStatus = VsyncStatus.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final AsyncReprojectionAnalytics clearFps() {
            this.fps_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final AsyncReprojectionAnalytics clearTotalMissedVsyncs() {
            this.totalMissedVsyncs_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Analytics.super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.totalMissedVsyncs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.fps_);
            }
            VsyncStatus[] vsyncStatusArr = this.vsyncStatus;
            if (vsyncStatusArr != null && vsyncStatusArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.vsyncStatus;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final float getFps() {
            return this.fps_;
        }

        public final int getTotalMissedVsyncs() {
            return this.totalMissedVsyncs_;
        }

        public final boolean hasFps() {
            return (this.bitField0_ & 2) != 0;
        }

        public final boolean hasTotalMissedVsyncs() {
            return (this.bitField0_ & 1) != 0;
        }

        public final AsyncReprojectionAnalytics setFps(float f) {
            this.bitField0_ |= 2;
            this.fps_ = f;
            return this;
        }

        public final AsyncReprojectionAnalytics setTotalMissedVsyncs(int i) {
            this.bitField0_ |= 1;
            this.totalMissedVsyncs_ = i;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt32(1, this.totalMissedVsyncs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.fps_);
            }
            VsyncStatus[] vsyncStatusArr = this.vsyncStatus;
            if (vsyncStatusArr != null && vsyncStatusArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.vsyncStatus;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(3, messageNano);
                    }
                    i++;
                }
            }
            Analytics.super.writeTo(codedOutputByteBufferNano);
        }

        public static AsyncReprojectionAnalytics parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new AsyncReprojectionAnalytics().mergeFrom(codedInputByteBufferNano);
        }

        public final AsyncReprojectionAnalytics mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.totalMissedVsyncs_ = codedInputByteBufferNano.readInt32();
                    this.bitField0_ |= 1;
                } else if (readTag == 21) {
                    this.fps_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 2;
                } else if (readTag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    VsyncStatus[] vsyncStatusArr = this.vsyncStatus;
                    int length = vsyncStatusArr == null ? 0 : vsyncStatusArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new VsyncStatus[i];
                    if (length != 0) {
                        System.arraycopy(vsyncStatusArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new VsyncStatus();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new VsyncStatus();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.vsyncStatus = messageNanoArr;
                } else if (!Analytics.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // java.lang.Object
        public final AsyncReprojectionAnalytics clone() {
            try {
                AsyncReprojectionAnalytics clone = Analytics.super.clone();
                VsyncStatus[] vsyncStatusArr = this.vsyncStatus;
                if (vsyncStatusArr != null && vsyncStatusArr.length > 0) {
                    clone.vsyncStatus = new VsyncStatus[vsyncStatusArr.length];
                    int i = 0;
                    while (true) {
                        VsyncStatus[] vsyncStatusArr2 = this.vsyncStatus;
                        if (i >= vsyncStatusArr2.length) {
                            break;
                        }
                        if (vsyncStatusArr2[i] != null) {
                            clone.vsyncStatus[i] = vsyncStatusArr2[i].clone();
                        }
                        i++;
                    }
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    private Analytics() {
    }
}
