package com.google.common.logging.nano;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.youku.danmaku.engine.BuildConfig;
import com.youku.uplayer.AliMediaPlayer;
import java.io.IOException;
import logs.proto.wireless.performance.mobile.nano.MemoryMetric$AndroidMemoryStats;

/* compiled from: Taobao */
public final class Vr$VREvent extends ExtendableMessageNano<Vr$VREvent> implements Cloneable {
    private Application application = null;
    private AudioStats audioStats = null;
    private String cohort = null;
    private Cyclops cyclops = null;
    private Long durationMs = null;
    private EarthVr earthVr = null;
    private EmbedVrWidget embedVrWidget = null;
    private Expeditions expeditions = null;
    private GConfigUpdate gConfigUpdate = null;
    private HeadMount headMount = null;
    private HeadTracking headTracking = null;
    private Application[] installedVrApplications = Application.emptyArray();
    private JumpInspector jumpInspector = null;
    private Keyboard keyboard = null;
    private Launcher launcher = null;
    private Integer lifetimeCountBucket = null;
    private Lullaby lullaby = null;
    private PerformanceStats performanceStats = null;
    public PhoneAlignment phoneAlignment = null;
    private Photos photos = null;
    private QrCodeScan qrCodeScan = null;
    private Renderer renderer = null;
    private SdkConfigurationParams sdkConfiguration = null;
    private SensorStats sensorStats = null;
    private StreetView streetView = null;
    private VrCore vrCore = null;
    private VrHome vrHome = null;
    private VrStreaming vrStreaming = null;

    /* compiled from: Taobao */
    public final class EarthVr extends ExtendableMessageNano<EarthVr> implements Cloneable {
        private Actor[] actors = Actor.emptyArray();
        private AppState appState = null;
        private ControllerState[] controllerStates = ControllerState.emptyArray();
        private Environment environment = null;
        private VrSdkError[] errors = VrSdkError.emptyArray();
        private Menu menu = null;
        private Preferences preferences = null;
        private Preferences preferencesDelta = null;
        private Search search = null;
        private SplashScreen splashScreen = null;
        private Transform startFromHeadTransform = null;
        private DoublePrecisionTransform startFromKeyholeTransform = null;
        private Tour tour = null;
        private Tutorial tutorial = null;
        private View view = null;

        public EarthVr() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
            if (doublePrecisionTransform != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, doublePrecisionTransform);
            }
            Transform transform = this.startFromHeadTransform;
            if (transform != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, transform);
            }
            ControllerState[] controllerStateArr = this.controllerStates;
            int i = 0;
            if (controllerStateArr != null && controllerStateArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.controllerStates;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, messageNano);
                    }
                    i2++;
                }
            }
            AppState appState2 = this.appState;
            if (appState2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, appState2);
            }
            View view2 = this.view;
            if (view2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, view2);
            }
            Menu menu2 = this.menu;
            if (menu2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, menu2);
            }
            Preferences preferences2 = this.preferences;
            if (preferences2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, preferences2);
            }
            Tour tour2 = this.tour;
            if (tour2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, tour2);
            }
            Tutorial tutorial2 = this.tutorial;
            if (tutorial2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, tutorial2);
            }
            Actor[] actorArr = this.actors;
            if (actorArr != null && actorArr.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.actors;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, messageNano2);
                    }
                    i3++;
                }
            }
            Environment environment2 = this.environment;
            if (environment2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, environment2);
            }
            SplashScreen splashScreen2 = this.splashScreen;
            if (splashScreen2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, splashScreen2);
            }
            Search search2 = this.search;
            if (search2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, search2);
            }
            Preferences preferences3 = this.preferencesDelta;
            if (preferences3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, preferences3);
            }
            VrSdkError[] vrSdkErrorArr = this.errors;
            if (vrSdkErrorArr != null && vrSdkErrorArr.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr3 = this.errors;
                    if (i >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i];
                    if (messageNano3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, messageNano3);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.startFromKeyholeTransform == null) {
                            this.startFromKeyholeTransform = new DoublePrecisionTransform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromKeyholeTransform);
                        break;
                    case 18:
                        if (this.startFromHeadTransform == null) {
                            this.startFromHeadTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromHeadTransform);
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        ControllerState[] controllerStateArr = this.controllerStates;
                        int length = controllerStateArr == null ? 0 : controllerStateArr.length;
                        int i = repeatedFieldArrayLength + length;
                        MessageNano[] messageNanoArr = new ControllerState[i];
                        if (length != 0) {
                            System.arraycopy(controllerStateArr, 0, messageNanoArr, 0, length);
                        }
                        while (length < i - 1) {
                            messageNanoArr[length] = new ControllerState();
                            codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        messageNanoArr[length] = new ControllerState();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        this.controllerStates = messageNanoArr;
                        break;
                    case 34:
                        if (this.appState == null) {
                            this.appState = new AppState();
                        }
                        codedInputByteBufferNano.readMessage(this.appState);
                        break;
                    case 42:
                        if (this.view == null) {
                            this.view = new View();
                        }
                        codedInputByteBufferNano.readMessage(this.view);
                        break;
                    case 50:
                        if (this.menu == null) {
                            this.menu = new Menu();
                        }
                        codedInputByteBufferNano.readMessage(this.menu);
                        break;
                    case 58:
                        if (this.preferences == null) {
                            this.preferences = new Preferences();
                        }
                        codedInputByteBufferNano.readMessage(this.preferences);
                        break;
                    case 66:
                        if (this.tour == null) {
                            this.tour = new Tour();
                        }
                        codedInputByteBufferNano.readMessage(this.tour);
                        break;
                    case 74:
                        if (this.tutorial == null) {
                            this.tutorial = new Tutorial();
                        }
                        codedInputByteBufferNano.readMessage(this.tutorial);
                        break;
                    case 82:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        Actor[] actorArr = this.actors;
                        int length2 = actorArr == null ? 0 : actorArr.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        MessageNano[] messageNanoArr2 = new Actor[i2];
                        if (length2 != 0) {
                            System.arraycopy(actorArr, 0, messageNanoArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            messageNanoArr2[length2] = new Actor();
                            codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        messageNanoArr2[length2] = new Actor();
                        codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                        this.actors = messageNanoArr2;
                        break;
                    case 90:
                        if (this.environment == null) {
                            this.environment = new Environment();
                        }
                        codedInputByteBufferNano.readMessage(this.environment);
                        break;
                    case 98:
                        if (this.splashScreen == null) {
                            this.splashScreen = new SplashScreen();
                        }
                        codedInputByteBufferNano.readMessage(this.splashScreen);
                        break;
                    case 106:
                        if (this.search == null) {
                            this.search = new Search();
                        }
                        codedInputByteBufferNano.readMessage(this.search);
                        break;
                    case 114:
                        if (this.preferencesDelta == null) {
                            this.preferencesDelta = new Preferences();
                        }
                        codedInputByteBufferNano.readMessage(this.preferencesDelta);
                        break;
                    case 122:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                        VrSdkError[] vrSdkErrorArr = this.errors;
                        int length3 = vrSdkErrorArr == null ? 0 : vrSdkErrorArr.length;
                        int i3 = repeatedFieldArrayLength3 + length3;
                        MessageNano[] messageNanoArr3 = new VrSdkError[i3];
                        if (length3 != 0) {
                            System.arraycopy(vrSdkErrorArr, 0, messageNanoArr3, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            messageNanoArr3[length3] = new VrSdkError();
                            codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        messageNanoArr3[length3] = new VrSdkError();
                        codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                        this.errors = messageNanoArr3;
                        break;
                    default:
                        if (Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
            if (doublePrecisionTransform != null) {
                codedOutputByteBufferNano.writeMessage(1, doublePrecisionTransform);
            }
            Transform transform = this.startFromHeadTransform;
            if (transform != null) {
                codedOutputByteBufferNano.writeMessage(2, transform);
            }
            ControllerState[] controllerStateArr = this.controllerStates;
            int i = 0;
            if (controllerStateArr != null && controllerStateArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.controllerStates;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(3, messageNano);
                    }
                    i2++;
                }
            }
            AppState appState2 = this.appState;
            if (appState2 != null) {
                codedOutputByteBufferNano.writeMessage(4, appState2);
            }
            View view2 = this.view;
            if (view2 != null) {
                codedOutputByteBufferNano.writeMessage(5, view2);
            }
            Menu menu2 = this.menu;
            if (menu2 != null) {
                codedOutputByteBufferNano.writeMessage(6, menu2);
            }
            Preferences preferences2 = this.preferences;
            if (preferences2 != null) {
                codedOutputByteBufferNano.writeMessage(7, preferences2);
            }
            Tour tour2 = this.tour;
            if (tour2 != null) {
                codedOutputByteBufferNano.writeMessage(8, tour2);
            }
            Tutorial tutorial2 = this.tutorial;
            if (tutorial2 != null) {
                codedOutputByteBufferNano.writeMessage(9, tutorial2);
            }
            Actor[] actorArr = this.actors;
            if (actorArr != null && actorArr.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.actors;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        codedOutputByteBufferNano.writeMessage(10, messageNano2);
                    }
                    i3++;
                }
            }
            Environment environment2 = this.environment;
            if (environment2 != null) {
                codedOutputByteBufferNano.writeMessage(11, environment2);
            }
            SplashScreen splashScreen2 = this.splashScreen;
            if (splashScreen2 != null) {
                codedOutputByteBufferNano.writeMessage(12, splashScreen2);
            }
            Search search2 = this.search;
            if (search2 != null) {
                codedOutputByteBufferNano.writeMessage(13, search2);
            }
            Preferences preferences3 = this.preferencesDelta;
            if (preferences3 != null) {
                codedOutputByteBufferNano.writeMessage(14, preferences3);
            }
            VrSdkError[] vrSdkErrorArr = this.errors;
            if (vrSdkErrorArr != null && vrSdkErrorArr.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr3 = this.errors;
                    if (i >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i];
                    if (messageNano3 != null) {
                        codedOutputByteBufferNano.writeMessage(15, messageNano3);
                    }
                    i++;
                }
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class Actor extends ExtendableMessageNano<Actor> implements Cloneable {
            private static volatile Actor[] _emptyArray;
            private ControllerState[] controllerStates = ControllerState.emptyArray();
            private Transform startFromHeadTransform = null;
            private Integer vrSdk = null;
            private Integer vrSystemType = null;

            public Actor() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static Actor[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Actor[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Transform transform = this.startFromHeadTransform;
                if (transform != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, transform);
                }
                ControllerState[] controllerStateArr = this.controllerStates;
                if (controllerStateArr != null && controllerStateArr.length > 0) {
                    int i = 0;
                    while (true) {
                        MessageNano[] messageNanoArr = this.controllerStates;
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
                Integer num = this.vrSdk;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num.intValue());
                }
                Integer num2 = this.vrSystemType;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 18) {
                        if (this.startFromHeadTransform == null) {
                            this.startFromHeadTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromHeadTransform);
                    } else if (readTag == 26) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        ControllerState[] controllerStateArr = this.controllerStates;
                        int length = controllerStateArr == null ? 0 : controllerStateArr.length;
                        int i = repeatedFieldArrayLength + length;
                        MessageNano[] messageNanoArr = new ControllerState[i];
                        if (length != 0) {
                            System.arraycopy(controllerStateArr, 0, messageNanoArr, 0, length);
                        }
                        while (length < i - 1) {
                            messageNanoArr[length] = new ControllerState();
                            codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        messageNanoArr[length] = new ControllerState();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        this.controllerStates = messageNanoArr;
                    } else if (readTag == 32) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.vrSdk = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 40) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                            this.vrSystemType = Integer.valueOf(readInt322);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Transform transform = this.startFromHeadTransform;
                if (transform != null) {
                    codedOutputByteBufferNano.writeMessage(2, transform);
                }
                ControllerState[] controllerStateArr = this.controllerStates;
                if (controllerStateArr != null && controllerStateArr.length > 0) {
                    int i = 0;
                    while (true) {
                        MessageNano[] messageNanoArr = this.controllerStates;
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
                Integer num = this.vrSdk;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(4, num.intValue());
                }
                Integer num2 = this.vrSystemType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num2.intValue());
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            /* compiled from: Taobao */
            public final class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
                private static volatile ControllerState[] _emptyArray;
                private Integer role = null;
                private Transform startFromControllerTransform = null;
                private Integer type = null;

                public ControllerState() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public static ControllerState[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new ControllerState[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = Actor.super.computeSerializedSize();
                    Integer num = this.role;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Transform transform = this.startFromControllerTransform;
                    if (transform != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, transform);
                    }
                    Integer num2 = this.type;
                    return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                this.role = Integer.valueOf(readInt32);
                            } else {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            }
                        } else if (readTag == 18) {
                            if (this.startFromControllerTransform == null) {
                                this.startFromControllerTransform = new Transform();
                            }
                            codedInputByteBufferNano.readMessage(this.startFromControllerTransform);
                        } else if (readTag == 24) {
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3 || readInt322 == 4) {
                                this.type = Integer.valueOf(readInt322);
                            } else {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            }
                        } else if (!Actor.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.role;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Transform transform = this.startFromControllerTransform;
                    if (transform != null) {
                        codedOutputByteBufferNano.writeMessage(2, transform);
                    }
                    Integer num2 = this.type;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                    }
                    Actor.super.writeTo(codedOutputByteBufferNano);
                }

                @Override // java.lang.Object
                public final ControllerState clone() {
                    try {
                        ControllerState clone = Actor.super.clone();
                        Transform transform = this.startFromControllerTransform;
                        if (transform != null) {
                            clone.startFromControllerTransform = transform.clone();
                        }
                        return clone;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            @Override // java.lang.Object
            public final Actor clone() {
                try {
                    Actor clone = EarthVr.super.clone();
                    Transform transform = this.startFromHeadTransform;
                    if (transform != null) {
                        clone.startFromHeadTransform = transform.clone();
                    }
                    ControllerState[] controllerStateArr = this.controllerStates;
                    if (controllerStateArr != null && controllerStateArr.length > 0) {
                        clone.controllerStates = new ControllerState[controllerStateArr.length];
                        int i = 0;
                        while (true) {
                            ControllerState[] controllerStateArr2 = this.controllerStates;
                            if (i >= controllerStateArr2.length) {
                                break;
                            }
                            if (controllerStateArr2[i] != null) {
                                clone.controllerStates[i] = controllerStateArr2[i].clone();
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
        public final class AppState extends ExtendableMessageNano<AppState> implements Cloneable {
            private Long appModeId = null;

            public AppState() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Long l = this.appModeId;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.appModeId = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.appModeId;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final AppState clone() {
                try {
                    return EarthVr.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
            private static volatile ControllerState[] _emptyArray;
            private Integer role = null;
            private Transform startFromControllerTransform = null;

            public ControllerState() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static ControllerState[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ControllerState[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Integer num = this.role;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Transform transform = this.startFromControllerTransform;
                return transform != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, transform) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.role = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 18) {
                        if (this.startFromControllerTransform == null) {
                            this.startFromControllerTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromControllerTransform);
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.role;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Transform transform = this.startFromControllerTransform;
                if (transform != null) {
                    codedOutputByteBufferNano.writeMessage(2, transform);
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final ControllerState clone() {
                try {
                    ControllerState clone = EarthVr.super.clone();
                    Transform transform = this.startFromControllerTransform;
                    if (transform != null) {
                        clone.startFromControllerTransform = transform.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Environment extends ExtendableMessageNano<Environment> implements Cloneable {
            private Transform startFromEnvironmentTransform = null;

            public Environment() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Transform transform = this.startFromEnvironmentTransform;
                return transform != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, transform) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.startFromEnvironmentTransform == null) {
                            this.startFromEnvironmentTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromEnvironmentTransform);
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Transform transform = this.startFromEnvironmentTransform;
                if (transform != null) {
                    codedOutputByteBufferNano.writeMessage(1, transform);
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Environment clone() {
                try {
                    Environment clone = EarthVr.super.clone();
                    Transform transform = this.startFromEnvironmentTransform;
                    if (transform != null) {
                        clone.startFromEnvironmentTransform = transform.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Menu extends ExtendableMessageNano<Menu> implements Cloneable {
            private String categoryName = null;
            private String contentKey = null;
            private String contentName = null;
            private Integer pageIndex = null;

            public Menu() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                String str = this.categoryName;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                Integer num = this.pageIndex;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
                }
                String str2 = this.contentKey;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str2);
                }
                String str3 = this.contentName;
                return str3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, str3) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.categoryName = codedInputByteBufferNano.readString();
                    } else if (readTag == 16) {
                        this.pageIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 26) {
                        this.contentKey = codedInputByteBufferNano.readString();
                    } else if (readTag == 34) {
                        this.contentName = codedInputByteBufferNano.readString();
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.categoryName;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                Integer num = this.pageIndex;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(2, num.intValue());
                }
                String str2 = this.contentKey;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(3, str2);
                }
                String str3 = this.contentName;
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(4, str3);
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Menu clone() {
                try {
                    return EarthVr.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Preferences extends ExtendableMessageNano<Preferences> implements Cloneable {
            private Integer comfortModeState = null;
            private Integer guestMode = null;
            private Integer humanScaleMode = null;
            private Integer labelsState = null;
            private Integer startConfiguration = null;

            public Preferences() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Integer num = this.labelsState;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.comfortModeState;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.startConfiguration;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                }
                Integer num4 = this.guestMode;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue());
                }
                Integer num5 = this.humanScaleMode;
                return num5 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, num5.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.labelsState = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                            this.comfortModeState = Integer.valueOf(readInt322);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 24) {
                        int position3 = codedInputByteBufferNano.getPosition();
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2) {
                            this.startConfiguration = Integer.valueOf(readInt323);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position3);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 32) {
                        int position4 = codedInputByteBufferNano.getPosition();
                        int readInt324 = codedInputByteBufferNano.readInt32();
                        if (readInt324 == 0 || readInt324 == 1 || readInt324 == 2) {
                            this.guestMode = Integer.valueOf(readInt324);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position4);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 40) {
                        int position5 = codedInputByteBufferNano.getPosition();
                        int readInt325 = codedInputByteBufferNano.readInt32();
                        if (readInt325 == 0 || readInt325 == 1 || readInt325 == 2) {
                            this.humanScaleMode = Integer.valueOf(readInt325);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position5);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.labelsState;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.comfortModeState;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.startConfiguration;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                Integer num4 = this.guestMode;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num4.intValue());
                }
                Integer num5 = this.humanScaleMode;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num5.intValue());
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Preferences clone() {
                try {
                    return EarthVr.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Search extends ExtendableMessageNano<Search> implements Cloneable {
            private String searchQuery = null;
            private Integer selectedEntityIndex = null;
            private View selectedEntityView = null;
            private String typedQuery = null;

            public Search() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                String str = this.typedQuery;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.searchQuery;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
                }
                Integer num = this.selectedEntityIndex;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num.intValue());
                }
                View view = this.selectedEntityView;
                return view != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, view) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.typedQuery = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        this.searchQuery = codedInputByteBufferNano.readString();
                    } else if (readTag == 24) {
                        this.selectedEntityIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 34) {
                        if (this.selectedEntityView == null) {
                            this.selectedEntityView = new View();
                        }
                        codedInputByteBufferNano.readMessage(this.selectedEntityView);
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.typedQuery;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.searchQuery;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                Integer num = this.selectedEntityIndex;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(3, num.intValue());
                }
                View view = this.selectedEntityView;
                if (view != null) {
                    codedOutputByteBufferNano.writeMessage(4, view);
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Search clone() {
                try {
                    Search clone = EarthVr.super.clone();
                    View view = this.selectedEntityView;
                    if (view != null) {
                        clone.selectedEntityView = view.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class SplashScreen extends ExtendableMessageNano<SplashScreen> implements Cloneable {
            private Integer exitType = null;
            private Long numberOfViewPreloadsAttempted = null;
            private Long numberOfViewPreloadsSucceeded = null;
            private Long viewPreloadDurationMs = null;

            public SplashScreen() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Integer num = this.exitType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.numberOfViewPreloadsAttempted;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
                }
                Long l2 = this.numberOfViewPreloadsSucceeded;
                if (l2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, l2.longValue());
                }
                Long l3 = this.viewPreloadDurationMs;
                return l3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, l3.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1) {
                            this.exitType = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.numberOfViewPreloadsAttempted = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 24) {
                        this.numberOfViewPreloadsSucceeded = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 32) {
                        this.viewPreloadDurationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.exitType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.numberOfViewPreloadsAttempted;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                Long l2 = this.numberOfViewPreloadsSucceeded;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeInt64(3, l2.longValue());
                }
                Long l3 = this.viewPreloadDurationMs;
                if (l3 != null) {
                    codedOutputByteBufferNano.writeInt64(4, l3.longValue());
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final SplashScreen clone() {
                try {
                    return EarthVr.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Tour extends ExtendableMessageNano<Tour> implements Cloneable {
            private String name = null;
            private Long playbackMs = null;

            public Tour() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                String str = this.name;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                Long l = this.playbackMs;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.name = codedInputByteBufferNano.readString();
                    } else if (readTag == 16) {
                        this.playbackMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.name;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                Long l = this.playbackMs;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Tour clone() {
                try {
                    return EarthVr.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Tutorial extends ExtendableMessageNano<Tutorial> implements Cloneable {
            private Integer stage = null;
            private String stageName = null;

            public Tutorial() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Integer num = this.stage;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                String str = this.stageName;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.stage = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 18) {
                        this.stageName = codedInputByteBufferNano.readString();
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.stage;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                String str = this.stageName;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Tutorial clone() {
                try {
                    return EarthVr.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class View extends ExtendableMessageNano<View> implements Cloneable {
            private Integer mode = null;
            private Long simulationSecondsSinceEpoch = null;
            private DoublePrecisionTransform startFromKeyholeTransform = null;

            public View() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Integer num = this.mode;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                if (doublePrecisionTransform != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, doublePrecisionTransform);
                }
                Long l = this.simulationSecondsSinceEpoch;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.mode = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 18) {
                        if (this.startFromKeyholeTransform == null) {
                            this.startFromKeyholeTransform = new DoublePrecisionTransform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromKeyholeTransform);
                    } else if (readTag == 24) {
                        this.simulationSecondsSinceEpoch = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.mode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                if (doublePrecisionTransform != null) {
                    codedOutputByteBufferNano.writeMessage(2, doublePrecisionTransform);
                }
                Long l = this.simulationSecondsSinceEpoch;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(3, l.longValue());
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final View clone() {
                try {
                    View clone = EarthVr.super.clone();
                    DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                    if (doublePrecisionTransform != null) {
                        clone.startFromKeyholeTransform = doublePrecisionTransform.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class VrSdkError extends ExtendableMessageNano<VrSdkError> implements Cloneable {
            private static volatile VrSdkError[] _emptyArray;
            private Integer sdkErrorCode = null;
            private String sdkFunction = null;
            private Integer shutdownReason = null;

            public VrSdkError() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static VrSdkError[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new VrSdkError[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EarthVr.super.computeSerializedSize();
                Integer num = this.shutdownReason;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.sdkErrorCode;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                String str = this.sdkFunction;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.shutdownReason = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.sdkErrorCode = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 26) {
                        this.sdkFunction = codedInputByteBufferNano.readString();
                    } else if (!EarthVr.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.shutdownReason;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.sdkErrorCode;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                String str = this.sdkFunction;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                EarthVr.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final VrSdkError clone() {
                try {
                    return EarthVr.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final EarthVr clone() {
            try {
                EarthVr clone = Vr$VREvent.super.clone();
                DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                if (doublePrecisionTransform != null) {
                    clone.startFromKeyholeTransform = doublePrecisionTransform.clone();
                }
                Transform transform = this.startFromHeadTransform;
                if (transform != null) {
                    clone.startFromHeadTransform = transform.clone();
                }
                ControllerState[] controllerStateArr = this.controllerStates;
                int i = 0;
                if (controllerStateArr != null && controllerStateArr.length > 0) {
                    clone.controllerStates = new ControllerState[controllerStateArr.length];
                    int i2 = 0;
                    while (true) {
                        ControllerState[] controllerStateArr2 = this.controllerStates;
                        if (i2 >= controllerStateArr2.length) {
                            break;
                        }
                        if (controllerStateArr2[i2] != null) {
                            clone.controllerStates[i2] = controllerStateArr2[i2].clone();
                        }
                        i2++;
                    }
                }
                AppState appState2 = this.appState;
                if (appState2 != null) {
                    clone.appState = appState2.clone();
                }
                View view2 = this.view;
                if (view2 != null) {
                    clone.view = view2.clone();
                }
                Menu menu2 = this.menu;
                if (menu2 != null) {
                    clone.menu = menu2.clone();
                }
                Preferences preferences2 = this.preferences;
                if (preferences2 != null) {
                    clone.preferences = preferences2.clone();
                }
                Preferences preferences3 = this.preferencesDelta;
                if (preferences3 != null) {
                    clone.preferencesDelta = preferences3.clone();
                }
                Tour tour2 = this.tour;
                if (tour2 != null) {
                    clone.tour = tour2.clone();
                }
                Tutorial tutorial2 = this.tutorial;
                if (tutorial2 != null) {
                    clone.tutorial = tutorial2.clone();
                }
                Actor[] actorArr = this.actors;
                if (actorArr != null && actorArr.length > 0) {
                    clone.actors = new Actor[actorArr.length];
                    int i3 = 0;
                    while (true) {
                        Actor[] actorArr2 = this.actors;
                        if (i3 >= actorArr2.length) {
                            break;
                        }
                        if (actorArr2[i3] != null) {
                            clone.actors[i3] = actorArr2[i3].clone();
                        }
                        i3++;
                    }
                }
                Environment environment2 = this.environment;
                if (environment2 != null) {
                    clone.environment = environment2.clone();
                }
                SplashScreen splashScreen2 = this.splashScreen;
                if (splashScreen2 != null) {
                    clone.splashScreen = splashScreen2.clone();
                }
                Search search2 = this.search;
                if (search2 != null) {
                    clone.search = search2.clone();
                }
                VrSdkError[] vrSdkErrorArr = this.errors;
                if (vrSdkErrorArr != null && vrSdkErrorArr.length > 0) {
                    clone.errors = new VrSdkError[vrSdkErrorArr.length];
                    while (true) {
                        VrSdkError[] vrSdkErrorArr2 = this.errors;
                        if (i >= vrSdkErrorArr2.length) {
                            break;
                        }
                        if (vrSdkErrorArr2[i] != null) {
                            clone.errors[i] = vrSdkErrorArr2[i].clone();
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
    public final class VrCore extends ExtendableMessageNano<VrCore> implements Cloneable {
        private CaptureEvent captureEvent = null;
        private Integer clientApiVersion = null;
        private Controller controller = null;
        private DashboardEvent dashboardEvent = null;
        private Integer errorCode = null;
        private Application foregroundApplication = null;
        private Boolean isInDemoMode = null;
        private Integer permission = null;
        private Application previousForegroundApplication = null;

        public VrCore() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.errorCode;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.permission;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
            }
            Application application = this.foregroundApplication;
            if (application != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, application);
            }
            Integer num3 = this.clientApiVersion;
            if (num3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num3.intValue());
            }
            Application application2 = this.previousForegroundApplication;
            if (application2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, application2);
            }
            Controller controller2 = this.controller;
            if (controller2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, controller2);
            }
            DashboardEvent dashboardEvent2 = this.dashboardEvent;
            if (dashboardEvent2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, dashboardEvent2);
            }
            Boolean bool = this.isInDemoMode;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, bool.booleanValue());
            }
            CaptureEvent captureEvent2 = this.captureEvent;
            return captureEvent2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, captureEvent2) : computeSerializedSize;
        }

        /* JADX WARNING: Removed duplicated region for block: B:72:0x00f7 A[FALL_THROUGH] */
        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (!(readInt32 == 0 || readInt32 == 1 || readInt32 == 301 || readInt32 == 510 || readInt32 == 520 || readInt32 == 401 || readInt32 == 402 || readInt32 == 501 || readInt32 == 502)) {
                        switch (readInt32) {
                            default:
                                switch (readInt32) {
                                    default:
                                        switch (readInt32) {
                                            default:
                                                switch (readInt32) {
                                                    case 201:
                                                    case 202:
                                                    case 203:
                                                        break;
                                                    default:
                                                        codedInputByteBufferNano.rewindToPosition(position);
                                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                                        break;
                                                }
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_LOADING_FACTOR_STEP /*{ENCODED_INT: 176}*/:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD3_LOADING_FACTOR_STEP /*{ENCODED_INT: 177}*/:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD /*{ENCODED_INT: 178}*/:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD /*{ENCODED_INT: 179}*/:
                                            case 180:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DOWNLOAD_TIMEOUT_FACTOR /*{ENCODED_INT: 181}*/:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_LOCAL_SOURCE /*{ENCODED_INT: 182}*/:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_WIFI /*{ENCODED_INT: 183}*/:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_AudioMode /*{ENCODED_INT: 184}*/:
                                            case 185:
                                            case AliMediaPlayer.UPLAYER_UPS_START_GEAR /*{ENCODED_INT: 186}*/:
                                            case AliMediaPlayer.OPEN_RENDER_VV_BEGIN /*{ENCODED_INT: 187}*/:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_DRM_LICENSE_URI /*{ENCODED_INT: 188}*/:
                                            case 189:
                                            case AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH /*{ENCODED_INT: 190}*/:
                                            case 191:
                                            case 192:
                                                this.errorCode = Integer.valueOf(readInt32);
                                                break;
                                        }
                                    case 151:
                                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR /*{ENCODED_INT: 152}*/:
                                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX /*{ENCODED_INT: 153}*/:
                                        break;
                                }
                            case 101:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                            case 109:
                            case 110:
                            case 111:
                            case 112:
                            case 113:
                            case 114:
                            case 115:
                            case 116:
                            case 117:
                            case 118:
                            case 119:
                            case 120:
                            case 121:
                            case 122:
                            case 123:
                            case 124:
                            case 125:
                            case 126:
                            case 127:
                            case 128:
                            case SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR:
                                break;
                        }
                    }
                    this.errorCode = Integer.valueOf(readInt32);
                } else if (readTag == 16) {
                    int position2 = codedInputByteBufferNano.getPosition();
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    switch (readInt322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            this.permission = Integer.valueOf(readInt322);
                            continue;
                        default:
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            continue;
                    }
                } else if (readTag == 26) {
                    if (this.foregroundApplication == null) {
                        this.foregroundApplication = new Application();
                    }
                    codedInputByteBufferNano.readMessage(this.foregroundApplication);
                } else if (readTag == 32) {
                    this.clientApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 42) {
                    if (this.previousForegroundApplication == null) {
                        this.previousForegroundApplication = new Application();
                    }
                    codedInputByteBufferNano.readMessage(this.previousForegroundApplication);
                } else if (readTag == 50) {
                    if (this.controller == null) {
                        this.controller = new Controller();
                    }
                    codedInputByteBufferNano.readMessage(this.controller);
                } else if (readTag == 58) {
                    if (this.dashboardEvent == null) {
                        this.dashboardEvent = new DashboardEvent();
                    }
                    codedInputByteBufferNano.readMessage(this.dashboardEvent);
                } else if (readTag == 64) {
                    this.isInDemoMode = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 74) {
                    if (this.captureEvent == null) {
                        this.captureEvent = new CaptureEvent();
                    }
                    codedInputByteBufferNano.readMessage(this.captureEvent);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.errorCode;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.permission;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            Application application = this.foregroundApplication;
            if (application != null) {
                codedOutputByteBufferNano.writeMessage(3, application);
            }
            Integer num3 = this.clientApiVersion;
            if (num3 != null) {
                codedOutputByteBufferNano.writeInt32(4, num3.intValue());
            }
            Application application2 = this.previousForegroundApplication;
            if (application2 != null) {
                codedOutputByteBufferNano.writeMessage(5, application2);
            }
            Controller controller2 = this.controller;
            if (controller2 != null) {
                codedOutputByteBufferNano.writeMessage(6, controller2);
            }
            DashboardEvent dashboardEvent2 = this.dashboardEvent;
            if (dashboardEvent2 != null) {
                codedOutputByteBufferNano.writeMessage(7, dashboardEvent2);
            }
            Boolean bool = this.isInDemoMode;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(8, bool.booleanValue());
            }
            CaptureEvent captureEvent2 = this.captureEvent;
            if (captureEvent2 != null) {
                codedOutputByteBufferNano.writeMessage(9, captureEvent2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class DashboardEvent extends ExtendableMessageNano<DashboardEvent> implements Cloneable {
            private Long clientTimestamp = null;
            private DashboardDismissDetails dismissDetails = null;
            private Integer eventType = null;
            private String sessionId = null;
            private Application worldApp = null;
            private MemoryMetric$AndroidMemoryStats worldAppMemoryStats = null;

            public DashboardEvent() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrCore.super.computeSerializedSize();
                Integer num = this.eventType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.clientTimestamp;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
                }
                String str = this.sessionId;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
                }
                Application application = this.worldApp;
                if (application != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, application);
                }
                MemoryMetric$AndroidMemoryStats memoryMetric$AndroidMemoryStats = this.worldAppMemoryStats;
                if (memoryMetric$AndroidMemoryStats != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, memoryMetric$AndroidMemoryStats);
                }
                DashboardDismissDetails dashboardDismissDetails = this.dismissDetails;
                return dashboardDismissDetails != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, dashboardDismissDetails) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.eventType = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.clientTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 26) {
                        this.sessionId = codedInputByteBufferNano.readString();
                    } else if (readTag == 34) {
                        if (this.worldApp == null) {
                            this.worldApp = new Application();
                        }
                        codedInputByteBufferNano.readMessage(this.worldApp);
                    } else if (readTag == 42) {
                        if (this.worldAppMemoryStats == null) {
                            this.worldAppMemoryStats = new MemoryMetric$AndroidMemoryStats();
                        }
                        codedInputByteBufferNano.readMessage(this.worldAppMemoryStats);
                    } else if (readTag == 50) {
                        if (this.dismissDetails == null) {
                            this.dismissDetails = new DashboardDismissDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.dismissDetails);
                    } else if (!VrCore.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.eventType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.clientTimestamp;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                String str = this.sessionId;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                Application application = this.worldApp;
                if (application != null) {
                    codedOutputByteBufferNano.writeMessage(4, application);
                }
                MemoryMetric$AndroidMemoryStats memoryMetric$AndroidMemoryStats = this.worldAppMemoryStats;
                if (memoryMetric$AndroidMemoryStats != null) {
                    codedOutputByteBufferNano.writeMessage(5, memoryMetric$AndroidMemoryStats);
                }
                DashboardDismissDetails dashboardDismissDetails = this.dismissDetails;
                if (dashboardDismissDetails != null) {
                    codedOutputByteBufferNano.writeMessage(6, dashboardDismissDetails);
                }
                VrCore.super.writeTo(codedOutputByteBufferNano);
            }

            /* compiled from: Taobao */
            public final class DashboardDismissDetails extends ExtendableMessageNano<DashboardDismissDetails> implements Cloneable {
                private Integer dismissReason = null;
                private Boolean worldAppDied = null;

                public DashboardDismissDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = DashboardEvent.super.computeSerializedSize();
                    Integer num = this.dismissReason;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Boolean bool = this.worldAppDied;
                    return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            switch (readInt32) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    this.dismissReason = Integer.valueOf(readInt32);
                                    continue;
                                default:
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    continue;
                            }
                        } else if (readTag == 16) {
                            this.worldAppDied = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        } else if (!DashboardEvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.dismissReason;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Boolean bool = this.worldAppDied;
                    if (bool != null) {
                        codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                    }
                    DashboardEvent.super.writeTo(codedOutputByteBufferNano);
                }

                @Override // java.lang.Object
                public final DashboardDismissDetails clone() {
                    try {
                        return DashboardEvent.super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            @Override // java.lang.Object
            public final DashboardEvent clone() {
                try {
                    DashboardEvent clone = VrCore.super.clone();
                    Application application = this.worldApp;
                    if (application != null) {
                        clone.worldApp = application.clone();
                    }
                    MemoryMetric$AndroidMemoryStats memoryMetric$AndroidMemoryStats = this.worldAppMemoryStats;
                    if (memoryMetric$AndroidMemoryStats != null) {
                        clone.worldAppMemoryStats = memoryMetric$AndroidMemoryStats.clone();
                    }
                    DashboardDismissDetails dashboardDismissDetails = this.dismissDetails;
                    if (dashboardDismissDetails != null) {
                        clone.dismissDetails = dashboardDismissDetails.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class CaptureEvent extends ExtendableMessageNano<CaptureEvent> implements Cloneable {
            private Boolean initiatedByController = null;

            public CaptureEvent() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrCore.super.computeSerializedSize();
                Boolean bool = this.initiatedByController;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.initiatedByController = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (!VrCore.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Boolean bool = this.initiatedByController;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(1, bool.booleanValue());
                }
                VrCore.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final CaptureEvent clone() {
                try {
                    return VrCore.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Controller extends ExtendableMessageNano<Controller> implements Cloneable {
            private String availableFirmware = null;
            private Integer axis = null;
            private Integer batteryLevel = null;
            private String firmware = null;
            private String hardwareRevision = null;
            private Boolean isConnected = null;
            private String manufacturer = null;
            private String model = null;
            private Integer otaRetries = null;
            private Integer sampleCount = null;
            private Integer sensorType = null;
            private String softwareRevision = null;
            private Integer totalControllerLagCount = null;
            private Integer xRailCount = null;
            private Integer yRailCount = null;
            private Integer zRailCount = null;

            public Controller() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrCore.super.computeSerializedSize();
                String str = this.manufacturer;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.model;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
                }
                String str3 = this.firmware;
                if (str3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str3);
                }
                String str4 = this.availableFirmware;
                if (str4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, str4);
                }
                String str5 = this.softwareRevision;
                if (str5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, str5);
                }
                Integer num = this.batteryLevel;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num.intValue());
                }
                String str6 = this.hardwareRevision;
                if (str6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str6);
                }
                Integer num2 = this.xRailCount;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num2.intValue());
                }
                Integer num3 = this.yRailCount;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, num3.intValue());
                }
                Integer num4 = this.zRailCount;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, num4.intValue());
                }
                Integer num5 = this.sampleCount;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, num5.intValue());
                }
                Integer num6 = this.sensorType;
                if (num6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, num6.intValue());
                }
                Integer num7 = this.axis;
                if (num7 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, num7.intValue());
                }
                Integer num8 = this.otaRetries;
                if (num8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, num8.intValue());
                }
                Integer num9 = this.totalControllerLagCount;
                if (num9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, num9.intValue());
                }
                Boolean bool = this.isConnected;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(16, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 10:
                            this.manufacturer = codedInputByteBufferNano.readString();
                            break;
                        case 18:
                            this.model = codedInputByteBufferNano.readString();
                            break;
                        case 26:
                            this.firmware = codedInputByteBufferNano.readString();
                            break;
                        case 34:
                            this.availableFirmware = codedInputByteBufferNano.readString();
                            break;
                        case 42:
                            this.softwareRevision = codedInputByteBufferNano.readString();
                            break;
                        case 48:
                            this.batteryLevel = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 58:
                            this.hardwareRevision = codedInputByteBufferNano.readString();
                            break;
                        case 64:
                            this.xRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 72:
                            this.yRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 80:
                            this.zRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 88:
                            this.sampleCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 96:
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.sensorType = Integer.valueOf(readInt32);
                                break;
                            }
                        case 104:
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.axis = Integer.valueOf(readInt322);
                                break;
                            }
                        case 112:
                            this.otaRetries = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 120:
                            this.totalControllerLagCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 128:
                            this.isConnected = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        default:
                            if (VrCore.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.manufacturer;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.model;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                String str3 = this.firmware;
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(3, str3);
                }
                String str4 = this.availableFirmware;
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(4, str4);
                }
                String str5 = this.softwareRevision;
                if (str5 != null) {
                    codedOutputByteBufferNano.writeString(5, str5);
                }
                Integer num = this.batteryLevel;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(6, num.intValue());
                }
                String str6 = this.hardwareRevision;
                if (str6 != null) {
                    codedOutputByteBufferNano.writeString(7, str6);
                }
                Integer num2 = this.xRailCount;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num2.intValue());
                }
                Integer num3 = this.yRailCount;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(9, num3.intValue());
                }
                Integer num4 = this.zRailCount;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(10, num4.intValue());
                }
                Integer num5 = this.sampleCount;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(11, num5.intValue());
                }
                Integer num6 = this.sensorType;
                if (num6 != null) {
                    codedOutputByteBufferNano.writeInt32(12, num6.intValue());
                }
                Integer num7 = this.axis;
                if (num7 != null) {
                    codedOutputByteBufferNano.writeInt32(13, num7.intValue());
                }
                Integer num8 = this.otaRetries;
                if (num8 != null) {
                    codedOutputByteBufferNano.writeInt32(14, num8.intValue());
                }
                Integer num9 = this.totalControllerLagCount;
                if (num9 != null) {
                    codedOutputByteBufferNano.writeInt32(15, num9.intValue());
                }
                Boolean bool = this.isConnected;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(16, bool.booleanValue());
                }
                VrCore.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Controller clone() {
                try {
                    return VrCore.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final VrCore clone() {
            try {
                VrCore clone = Vr$VREvent.super.clone();
                Application application = this.foregroundApplication;
                if (application != null) {
                    clone.foregroundApplication = application.clone();
                }
                Application application2 = this.previousForegroundApplication;
                if (application2 != null) {
                    clone.previousForegroundApplication = application2.clone();
                }
                Controller controller2 = this.controller;
                if (controller2 != null) {
                    clone.controller = controller2.clone();
                }
                DashboardEvent dashboardEvent2 = this.dashboardEvent;
                if (dashboardEvent2 != null) {
                    clone.dashboardEvent = dashboardEvent2.clone();
                }
                CaptureEvent captureEvent2 = this.captureEvent;
                if (captureEvent2 != null) {
                    clone.captureEvent = captureEvent2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class VrHome extends ExtendableMessageNano<VrHome> implements Cloneable {
        private DialogAction dialogAction = null;
        private GConfigUpdate gConfigUpdate = null;
        private GetViewerClick getViewerClick = null;
        private Setup setup = null;

        public VrHome() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Setup setup2 = this.setup;
            if (setup2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, setup2);
            }
            GConfigUpdate gConfigUpdate2 = this.gConfigUpdate;
            if (gConfigUpdate2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gConfigUpdate2);
            }
            GetViewerClick getViewerClick2 = this.getViewerClick;
            if (getViewerClick2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, getViewerClick2);
            }
            DialogAction dialogAction2 = this.dialogAction;
            return dialogAction2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, dialogAction2) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.setup == null) {
                        this.setup = new Setup();
                    }
                    codedInputByteBufferNano.readMessage(this.setup);
                } else if (readTag == 18) {
                    if (this.gConfigUpdate == null) {
                        this.gConfigUpdate = new GConfigUpdate();
                    }
                    codedInputByteBufferNano.readMessage(this.gConfigUpdate);
                } else if (readTag == 26) {
                    if (this.getViewerClick == null) {
                        this.getViewerClick = new GetViewerClick();
                    }
                    codedInputByteBufferNano.readMessage(this.getViewerClick);
                } else if (readTag == 34) {
                    if (this.dialogAction == null) {
                        this.dialogAction = new DialogAction();
                    }
                    codedInputByteBufferNano.readMessage(this.dialogAction);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Setup setup2 = this.setup;
            if (setup2 != null) {
                codedOutputByteBufferNano.writeMessage(1, setup2);
            }
            GConfigUpdate gConfigUpdate2 = this.gConfigUpdate;
            if (gConfigUpdate2 != null) {
                codedOutputByteBufferNano.writeMessage(2, gConfigUpdate2);
            }
            GetViewerClick getViewerClick2 = this.getViewerClick;
            if (getViewerClick2 != null) {
                codedOutputByteBufferNano.writeMessage(3, getViewerClick2);
            }
            DialogAction dialogAction2 = this.dialogAction;
            if (dialogAction2 != null) {
                codedOutputByteBufferNano.writeMessage(4, dialogAction2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class Setup extends ExtendableMessageNano<Setup> implements Cloneable {
            private StepStateChange stepStateChange = null;
            private View view = null;

            public Setup() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrHome.super.computeSerializedSize();
                View view2 = this.view;
                if (view2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, view2);
                }
                StepStateChange stepStateChange2 = this.stepStateChange;
                return stepStateChange2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, stepStateChange2) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.view == null) {
                            this.view = new View();
                        }
                        codedInputByteBufferNano.readMessage(this.view);
                    } else if (readTag == 18) {
                        if (this.stepStateChange == null) {
                            this.stepStateChange = new StepStateChange();
                        }
                        codedInputByteBufferNano.readMessage(this.stepStateChange);
                    } else if (!VrHome.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                View view2 = this.view;
                if (view2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, view2);
                }
                StepStateChange stepStateChange2 = this.stepStateChange;
                if (stepStateChange2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, stepStateChange2);
                }
                VrHome.super.writeTo(codedOutputByteBufferNano);
            }

            /* compiled from: Taobao */
            public final class StepStateChange extends ExtendableMessageNano<StepStateChange> implements Cloneable {
                private Integer newStepState = null;
                private Integer previousStepState = null;
                private Integer step = null;

                public StepStateChange() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = Setup.super.computeSerializedSize();
                    Integer num = this.step;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Integer num2 = this.previousStepState;
                    if (num2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                    }
                    Integer num3 = this.newStepState;
                    return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            switch (readInt32) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                    this.step = Integer.valueOf(readInt32);
                                    continue;
                                default:
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    continue;
                            }
                        } else if (readTag == 16) {
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3 || readInt322 == 4) {
                                this.previousStepState = Integer.valueOf(readInt322);
                            } else {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            }
                        } else if (readTag == 24) {
                            int position3 = codedInputByteBufferNano.getPosition();
                            int readInt323 = codedInputByteBufferNano.readInt32();
                            if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2 || readInt323 == 3 || readInt323 == 4) {
                                this.newStepState = Integer.valueOf(readInt323);
                            } else {
                                codedInputByteBufferNano.rewindToPosition(position3);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            }
                        } else if (!Setup.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.step;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Integer num2 = this.previousStepState;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                    }
                    Integer num3 = this.newStepState;
                    if (num3 != null) {
                        codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                    }
                    Setup.super.writeTo(codedOutputByteBufferNano);
                }

                @Override // java.lang.Object
                public final StepStateChange clone() {
                    try {
                        return Setup.super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            /* compiled from: Taobao */
            public final class View extends ExtendableMessageNano<View> implements Cloneable {
                private Integer page = null;
                private Integer step = null;

                public View() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                /* access modifiers changed from: protected */
                public final int computeSerializedSize() {
                    int computeSerializedSize = Setup.super.computeSerializedSize();
                    Integer num = this.step;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Integer num2 = this.page;
                    return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            switch (readInt32) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                    this.step = Integer.valueOf(readInt32);
                                    continue;
                                default:
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    continue;
                            }
                        } else if (readTag == 16) {
                            this.page = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (!Setup.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.step;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Integer num2 = this.page;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                    }
                    Setup.super.writeTo(codedOutputByteBufferNano);
                }

                @Override // java.lang.Object
                public final View clone() {
                    try {
                        return Setup.super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            @Override // java.lang.Object
            public final Setup clone() {
                try {
                    Setup clone = VrHome.super.clone();
                    View view2 = this.view;
                    if (view2 != null) {
                        clone.view = view2.clone();
                    }
                    StepStateChange stepStateChange2 = this.stepStateChange;
                    if (stepStateChange2 != null) {
                        clone.stepStateChange = stepStateChange2.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class DialogAction extends ExtendableMessageNano<DialogAction> implements Cloneable {
            private Integer actionType = null;
            private Integer type = null;

            public DialogAction() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrHome.super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.actionType;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1) {
                            this.type = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                            this.actionType = Integer.valueOf(readInt322);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (!VrHome.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.actionType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                VrHome.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final DialogAction clone() {
                try {
                    return VrHome.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class GetViewerClick extends ExtendableMessageNano<GetViewerClick> implements Cloneable {
            private String url = null;

            public GetViewerClick() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrHome.super.computeSerializedSize();
                String str = this.url;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.url = codedInputByteBufferNano.readString();
                    } else if (!VrHome.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.url;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                VrHome.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final GetViewerClick clone() {
                try {
                    return VrHome.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final VrHome clone() {
            try {
                VrHome clone = Vr$VREvent.super.clone();
                Setup setup2 = this.setup;
                if (setup2 != null) {
                    clone.setup = setup2.clone();
                }
                GConfigUpdate gConfigUpdate2 = this.gConfigUpdate;
                if (gConfigUpdate2 != null) {
                    clone.gConfigUpdate = gConfigUpdate2.clone();
                }
                GetViewerClick getViewerClick2 = this.getViewerClick;
                if (getViewerClick2 != null) {
                    clone.getViewerClick = getViewerClick2.clone();
                }
                DialogAction dialogAction2 = this.dialogAction;
                if (dialogAction2 != null) {
                    clone.dialogAction = dialogAction2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    public Vr$VREvent() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
    }

    /* access modifiers changed from: protected */
    public final int computeSerializedSize() {
        int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
        HeadMount headMount2 = this.headMount;
        if (headMount2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, headMount2);
        }
        Application application2 = this.application;
        if (application2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, application2);
        }
        Long l = this.durationMs;
        if (l != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, l.longValue());
        }
        Application[] applicationArr = this.installedVrApplications;
        if (applicationArr != null && applicationArr.length > 0) {
            int i = 0;
            while (true) {
                MessageNano[] messageNanoArr = this.installedVrApplications;
                if (i >= messageNanoArr.length) {
                    break;
                }
                MessageNano messageNano = messageNanoArr[i];
                if (messageNano != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, messageNano);
                }
                i++;
            }
        }
        Cyclops cyclops2 = this.cyclops;
        if (cyclops2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cyclops2);
        }
        QrCodeScan qrCodeScan2 = this.qrCodeScan;
        if (qrCodeScan2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, qrCodeScan2);
        }
        String str = this.cohort;
        if (str != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str);
        }
        Integer num = this.lifetimeCountBucket;
        if (num != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num.intValue());
        }
        PerformanceStats performanceStats2 = this.performanceStats;
        if (performanceStats2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, performanceStats2);
        }
        SensorStats sensorStats2 = this.sensorStats;
        if (sensorStats2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, sensorStats2);
        }
        AudioStats audioStats2 = this.audioStats;
        if (audioStats2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, audioStats2);
        }
        EmbedVrWidget embedVrWidget2 = this.embedVrWidget;
        if (embedVrWidget2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, embedVrWidget2);
        }
        VrCore vrCore2 = this.vrCore;
        if (vrCore2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, vrCore2);
        }
        EarthVr earthVr2 = this.earthVr;
        if (earthVr2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, earthVr2);
        }
        Launcher launcher2 = this.launcher;
        if (launcher2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, launcher2);
        }
        Keyboard keyboard2 = this.keyboard;
        if (keyboard2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, keyboard2);
        }
        Renderer renderer2 = this.renderer;
        if (renderer2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, renderer2);
        }
        Lullaby lullaby2 = this.lullaby;
        if (lullaby2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, lullaby2);
        }
        StreetView streetView2 = this.streetView;
        if (streetView2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, streetView2);
        }
        Photos photos2 = this.photos;
        if (photos2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, photos2);
        }
        VrHome vrHome2 = this.vrHome;
        if (vrHome2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, vrHome2);
        }
        SdkConfigurationParams sdkConfigurationParams = this.sdkConfiguration;
        if (sdkConfigurationParams != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, sdkConfigurationParams);
        }
        GConfigUpdate gConfigUpdate2 = this.gConfigUpdate;
        if (gConfigUpdate2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, gConfigUpdate2);
        }
        JumpInspector jumpInspector2 = this.jumpInspector;
        if (jumpInspector2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, jumpInspector2);
        }
        PhoneAlignment phoneAlignment2 = this.phoneAlignment;
        if (phoneAlignment2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, phoneAlignment2);
        }
        VrStreaming vrStreaming2 = this.vrStreaming;
        if (vrStreaming2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(26, vrStreaming2);
        }
        Expeditions expeditions2 = this.expeditions;
        if (expeditions2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, expeditions2);
        }
        HeadTracking headTracking2 = this.headTracking;
        return headTracking2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(28, headTracking2) : computeSerializedSize;
    }

    public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.headMount == null) {
                        this.headMount = new HeadMount();
                    }
                    codedInputByteBufferNano.readMessage(this.headMount);
                    break;
                case 18:
                    if (this.application == null) {
                        this.application = new Application();
                    }
                    codedInputByteBufferNano.readMessage(this.application);
                    break;
                case 24:
                    this.durationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    Application[] applicationArr = this.installedVrApplications;
                    int length = applicationArr == null ? 0 : applicationArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new Application[i];
                    if (length != 0) {
                        System.arraycopy(applicationArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new Application();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new Application();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.installedVrApplications = messageNanoArr;
                    break;
                case 42:
                    if (this.cyclops == null) {
                        this.cyclops = new Cyclops();
                    }
                    codedInputByteBufferNano.readMessage(this.cyclops);
                    break;
                case 50:
                    if (this.qrCodeScan == null) {
                        this.qrCodeScan = new QrCodeScan();
                    }
                    codedInputByteBufferNano.readMessage(this.qrCodeScan);
                    break;
                case 58:
                    this.cohort = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (!(readInt32 == 11 || readInt32 == 21)) {
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                break;
                            default:
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                        }
                    }
                    this.lifetimeCountBucket = Integer.valueOf(readInt32);
                    break;
                case 74:
                    if (this.performanceStats == null) {
                        this.performanceStats = new PerformanceStats();
                    }
                    codedInputByteBufferNano.readMessage(this.performanceStats);
                    break;
                case 82:
                    if (this.sensorStats == null) {
                        this.sensorStats = new SensorStats();
                    }
                    codedInputByteBufferNano.readMessage(this.sensorStats);
                    break;
                case 90:
                    if (this.audioStats == null) {
                        this.audioStats = new AudioStats();
                    }
                    codedInputByteBufferNano.readMessage(this.audioStats);
                    break;
                case 98:
                    if (this.embedVrWidget == null) {
                        this.embedVrWidget = new EmbedVrWidget();
                    }
                    codedInputByteBufferNano.readMessage(this.embedVrWidget);
                    break;
                case 106:
                    if (this.vrCore == null) {
                        this.vrCore = new VrCore();
                    }
                    codedInputByteBufferNano.readMessage(this.vrCore);
                    break;
                case 114:
                    if (this.earthVr == null) {
                        this.earthVr = new EarthVr();
                    }
                    codedInputByteBufferNano.readMessage(this.earthVr);
                    break;
                case 122:
                    if (this.launcher == null) {
                        this.launcher = new Launcher();
                    }
                    codedInputByteBufferNano.readMessage(this.launcher);
                    break;
                case 130:
                    if (this.keyboard == null) {
                        this.keyboard = new Keyboard();
                    }
                    codedInputByteBufferNano.readMessage(this.keyboard);
                    break;
                case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR:
                    if (this.renderer == null) {
                        this.renderer = new Renderer();
                    }
                    codedInputByteBufferNano.readMessage(this.renderer);
                    break;
                case 146:
                    if (this.lullaby == null) {
                        this.lullaby = new Lullaby();
                    }
                    codedInputByteBufferNano.readMessage(this.lullaby);
                    break;
                case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER /*{ENCODED_INT: 154}*/:
                    if (this.streetView == null) {
                        this.streetView = new StreetView();
                    }
                    codedInputByteBufferNano.readMessage(this.streetView);
                    break;
                case 162:
                    if (this.photos == null) {
                        this.photos = new Photos();
                    }
                    codedInputByteBufferNano.readMessage(this.photos);
                    break;
                case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT /*{ENCODED_INT: 170}*/:
                    if (this.vrHome == null) {
                        this.vrHome = new VrHome();
                    }
                    codedInputByteBufferNano.readMessage(this.vrHome);
                    break;
                case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD /*{ENCODED_INT: 178}*/:
                    if (this.sdkConfiguration == null) {
                        this.sdkConfiguration = new SdkConfigurationParams();
                    }
                    codedInputByteBufferNano.readMessage(this.sdkConfiguration);
                    break;
                case AliMediaPlayer.UPLAYER_UPS_START_GEAR /*{ENCODED_INT: 186}*/:
                    if (this.gConfigUpdate == null) {
                        this.gConfigUpdate = new GConfigUpdate();
                    }
                    codedInputByteBufferNano.readMessage(this.gConfigUpdate);
                    break;
                case 194:
                    if (this.jumpInspector == null) {
                        this.jumpInspector = new JumpInspector();
                    }
                    codedInputByteBufferNano.readMessage(this.jumpInspector);
                    break;
                case 202:
                    if (this.phoneAlignment == null) {
                        this.phoneAlignment = new PhoneAlignment();
                    }
                    codedInputByteBufferNano.readMessage(this.phoneAlignment);
                    break;
                case 210:
                    if (this.vrStreaming == null) {
                        this.vrStreaming = new VrStreaming();
                    }
                    codedInputByteBufferNano.readMessage(this.vrStreaming);
                    break;
                case BuildConfig.VERSION_CODE /*{ENCODED_INT: 218}*/:
                    if (this.expeditions == null) {
                        this.expeditions = new Expeditions();
                    }
                    codedInputByteBufferNano.readMessage(this.expeditions);
                    break;
                case 226:
                    if (this.headTracking == null) {
                        this.headTracking = new HeadTracking();
                    }
                    codedInputByteBufferNano.readMessage(this.headTracking);
                    break;
                default:
                    if (Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        HeadMount headMount2 = this.headMount;
        if (headMount2 != null) {
            codedOutputByteBufferNano.writeMessage(1, headMount2);
        }
        Application application2 = this.application;
        if (application2 != null) {
            codedOutputByteBufferNano.writeMessage(2, application2);
        }
        Long l = this.durationMs;
        if (l != null) {
            codedOutputByteBufferNano.writeInt64(3, l.longValue());
        }
        Application[] applicationArr = this.installedVrApplications;
        if (applicationArr != null && applicationArr.length > 0) {
            int i = 0;
            while (true) {
                MessageNano[] messageNanoArr = this.installedVrApplications;
                if (i >= messageNanoArr.length) {
                    break;
                }
                MessageNano messageNano = messageNanoArr[i];
                if (messageNano != null) {
                    codedOutputByteBufferNano.writeMessage(4, messageNano);
                }
                i++;
            }
        }
        Cyclops cyclops2 = this.cyclops;
        if (cyclops2 != null) {
            codedOutputByteBufferNano.writeMessage(5, cyclops2);
        }
        QrCodeScan qrCodeScan2 = this.qrCodeScan;
        if (qrCodeScan2 != null) {
            codedOutputByteBufferNano.writeMessage(6, qrCodeScan2);
        }
        String str = this.cohort;
        if (str != null) {
            codedOutputByteBufferNano.writeString(7, str);
        }
        Integer num = this.lifetimeCountBucket;
        if (num != null) {
            codedOutputByteBufferNano.writeInt32(8, num.intValue());
        }
        PerformanceStats performanceStats2 = this.performanceStats;
        if (performanceStats2 != null) {
            codedOutputByteBufferNano.writeMessage(9, performanceStats2);
        }
        SensorStats sensorStats2 = this.sensorStats;
        if (sensorStats2 != null) {
            codedOutputByteBufferNano.writeMessage(10, sensorStats2);
        }
        AudioStats audioStats2 = this.audioStats;
        if (audioStats2 != null) {
            codedOutputByteBufferNano.writeMessage(11, audioStats2);
        }
        EmbedVrWidget embedVrWidget2 = this.embedVrWidget;
        if (embedVrWidget2 != null) {
            codedOutputByteBufferNano.writeMessage(12, embedVrWidget2);
        }
        VrCore vrCore2 = this.vrCore;
        if (vrCore2 != null) {
            codedOutputByteBufferNano.writeMessage(13, vrCore2);
        }
        EarthVr earthVr2 = this.earthVr;
        if (earthVr2 != null) {
            codedOutputByteBufferNano.writeMessage(14, earthVr2);
        }
        Launcher launcher2 = this.launcher;
        if (launcher2 != null) {
            codedOutputByteBufferNano.writeMessage(15, launcher2);
        }
        Keyboard keyboard2 = this.keyboard;
        if (keyboard2 != null) {
            codedOutputByteBufferNano.writeMessage(16, keyboard2);
        }
        Renderer renderer2 = this.renderer;
        if (renderer2 != null) {
            codedOutputByteBufferNano.writeMessage(17, renderer2);
        }
        Lullaby lullaby2 = this.lullaby;
        if (lullaby2 != null) {
            codedOutputByteBufferNano.writeMessage(18, lullaby2);
        }
        StreetView streetView2 = this.streetView;
        if (streetView2 != null) {
            codedOutputByteBufferNano.writeMessage(19, streetView2);
        }
        Photos photos2 = this.photos;
        if (photos2 != null) {
            codedOutputByteBufferNano.writeMessage(20, photos2);
        }
        VrHome vrHome2 = this.vrHome;
        if (vrHome2 != null) {
            codedOutputByteBufferNano.writeMessage(21, vrHome2);
        }
        SdkConfigurationParams sdkConfigurationParams = this.sdkConfiguration;
        if (sdkConfigurationParams != null) {
            codedOutputByteBufferNano.writeMessage(22, sdkConfigurationParams);
        }
        GConfigUpdate gConfigUpdate2 = this.gConfigUpdate;
        if (gConfigUpdate2 != null) {
            codedOutputByteBufferNano.writeMessage(23, gConfigUpdate2);
        }
        JumpInspector jumpInspector2 = this.jumpInspector;
        if (jumpInspector2 != null) {
            codedOutputByteBufferNano.writeMessage(24, jumpInspector2);
        }
        PhoneAlignment phoneAlignment2 = this.phoneAlignment;
        if (phoneAlignment2 != null) {
            codedOutputByteBufferNano.writeMessage(25, phoneAlignment2);
        }
        VrStreaming vrStreaming2 = this.vrStreaming;
        if (vrStreaming2 != null) {
            codedOutputByteBufferNano.writeMessage(26, vrStreaming2);
        }
        Expeditions expeditions2 = this.expeditions;
        if (expeditions2 != null) {
            codedOutputByteBufferNano.writeMessage(27, expeditions2);
        }
        HeadTracking headTracking2 = this.headTracking;
        if (headTracking2 != null) {
            codedOutputByteBufferNano.writeMessage(28, headTracking2);
        }
        Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
    }

    /* compiled from: Taobao */
    public final class Cyclops extends ExtendableMessageNano<Cyclops> implements Cloneable {
        private Capture capture = null;
        private Share share = null;
        private ShareStart shareStart = null;
        private View view = null;

        public Cyclops() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Capture capture2 = this.capture;
            if (capture2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, capture2);
            }
            View view2 = this.view;
            if (view2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, view2);
            }
            Share share2 = this.share;
            if (share2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, share2);
            }
            ShareStart shareStart2 = this.shareStart;
            return shareStart2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, shareStart2) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.capture == null) {
                        this.capture = new Capture();
                    }
                    codedInputByteBufferNano.readMessage(this.capture);
                } else if (readTag == 18) {
                    if (this.view == null) {
                        this.view = new View();
                    }
                    codedInputByteBufferNano.readMessage(this.view);
                } else if (readTag == 26) {
                    if (this.share == null) {
                        this.share = new Share();
                    }
                    codedInputByteBufferNano.readMessage(this.share);
                } else if (readTag == 34) {
                    if (this.shareStart == null) {
                        this.shareStart = new ShareStart();
                    }
                    codedInputByteBufferNano.readMessage(this.shareStart);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Capture capture2 = this.capture;
            if (capture2 != null) {
                codedOutputByteBufferNano.writeMessage(1, capture2);
            }
            View view2 = this.view;
            if (view2 != null) {
                codedOutputByteBufferNano.writeMessage(2, view2);
            }
            Share share2 = this.share;
            if (share2 != null) {
                codedOutputByteBufferNano.writeMessage(3, share2);
            }
            ShareStart shareStart2 = this.shareStart;
            if (shareStart2 != null) {
                codedOutputByteBufferNano.writeMessage(4, shareStart2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class Capture extends ExtendableMessageNano<Capture> implements Cloneable {
            private Float angleDegrees = null;
            private Long captureTimeMs = null;
            private Boolean captureWarnings = null;
            private Long compositionTimeMs = null;
            private Integer outcome = null;
            private Long processingTimeMs = null;
            private Boolean withSound = null;

            public Capture() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Cyclops.super.computeSerializedSize();
                Integer num = this.outcome;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Float f = this.angleDegrees;
                if (f != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f.floatValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool.booleanValue());
                }
                Boolean bool2 = this.captureWarnings;
                if (bool2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, bool2.booleanValue());
                }
                Long l = this.compositionTimeMs;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, l.longValue());
                }
                Long l2 = this.captureTimeMs;
                if (l2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, l2.longValue());
                }
                Long l3 = this.processingTimeMs;
                return l3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, l3.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                            this.outcome = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 21) {
                        this.angleDegrees = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 24) {
                        this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 32) {
                        this.captureWarnings = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 40) {
                        this.compositionTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 48) {
                        this.captureTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 56) {
                        this.processingTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (!Cyclops.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.outcome;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Float f = this.angleDegrees;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(2, f.floatValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(3, bool.booleanValue());
                }
                Boolean bool2 = this.captureWarnings;
                if (bool2 != null) {
                    codedOutputByteBufferNano.writeBool(4, bool2.booleanValue());
                }
                Long l = this.compositionTimeMs;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(5, l.longValue());
                }
                Long l2 = this.captureTimeMs;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeInt64(6, l2.longValue());
                }
                Long l3 = this.processingTimeMs;
                if (l3 != null) {
                    codedOutputByteBufferNano.writeInt64(7, l3.longValue());
                }
                Cyclops.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Capture clone() {
                try {
                    return Cyclops.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Share extends ExtendableMessageNano<Share> implements Cloneable {
            private Integer numPhotos = null;
            private Integer type = null;
            private Boolean withSound = null;

            public Share() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Cyclops.super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
                }
                Integer num2 = this.numPhotos;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.type = Integer.valueOf(readInt32);
                                continue;
                            default:
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                continue;
                        }
                    } else if (readTag == 16) {
                        this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 24) {
                        this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!Cyclops.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                Integer num2 = this.numPhotos;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                Cyclops.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Share clone() {
                try {
                    return Cyclops.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class ShareStart extends ExtendableMessageNano<ShareStart> implements Cloneable {
            private Integer numPhotos = null;
            private Integer originScreen = null;

            public ShareStart() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Cyclops.super.computeSerializedSize();
                Integer num = this.originScreen;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.numPhotos;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.originScreen = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!Cyclops.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.originScreen;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.numPhotos;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Cyclops.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final ShareStart clone() {
                try {
                    return Cyclops.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class View extends ExtendableMessageNano<View> implements Cloneable {
            private Boolean interaction = null;
            private Integer numPanos = null;
            private Integer orientation = null;
            private Boolean withSound = null;

            public View() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Cyclops.super.computeSerializedSize();
                Integer num = this.orientation;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.interaction;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
                }
                Boolean bool2 = this.withSound;
                if (bool2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool2.booleanValue());
                }
                Integer num2 = this.numPanos;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.orientation = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.interaction = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 24) {
                        this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 32) {
                        this.numPanos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!Cyclops.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.orientation;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.interaction;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                Boolean bool2 = this.withSound;
                if (bool2 != null) {
                    codedOutputByteBufferNano.writeBool(3, bool2.booleanValue());
                }
                Integer num2 = this.numPanos;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num2.intValue());
                }
                Cyclops.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final View clone() {
                try {
                    return Cyclops.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final Cyclops clone() {
            try {
                Cyclops clone = Vr$VREvent.super.clone();
                Capture capture2 = this.capture;
                if (capture2 != null) {
                    clone.capture = capture2.clone();
                }
                View view2 = this.view;
                if (view2 != null) {
                    clone.view = view2.clone();
                }
                Share share2 = this.share;
                if (share2 != null) {
                    clone.share = share2.clone();
                }
                ShareStart shareStart2 = this.shareStart;
                if (shareStart2 != null) {
                    clone.shareStart = shareStart2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class EmbedVrWidget extends ExtendableMessageNano<EmbedVrWidget> implements Cloneable {
        private String errorMsg = null;
        private Pano pano = null;
        private Video video = null;
        private Integer viewMode = null;

        public EmbedVrWidget() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.viewMode;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Pano pano2 = this.pano;
            if (pano2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pano2);
            }
            Video video2 = this.video;
            if (video2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, video2);
            }
            String str = this.errorMsg;
            return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, str) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                        this.viewMode = Integer.valueOf(readInt32);
                    } else {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    }
                } else if (readTag == 18) {
                    if (this.pano == null) {
                        this.pano = new Pano();
                    }
                    codedInputByteBufferNano.readMessage(this.pano);
                } else if (readTag == 26) {
                    if (this.video == null) {
                        this.video = new Video();
                    }
                    codedInputByteBufferNano.readMessage(this.video);
                } else if (readTag == 34) {
                    this.errorMsg = codedInputByteBufferNano.readString();
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.viewMode;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Pano pano2 = this.pano;
            if (pano2 != null) {
                codedOutputByteBufferNano.writeMessage(2, pano2);
            }
            Video video2 = this.video;
            if (video2 != null) {
                codedOutputByteBufferNano.writeMessage(3, video2);
            }
            String str = this.errorMsg;
            if (str != null) {
                codedOutputByteBufferNano.writeString(4, str);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class Pano extends ExtendableMessageNano<Pano> implements Cloneable {
            private Integer heightPixels = null;
            private Integer stereoFormat = null;
            private Integer widthPixels = null;

            public Pano() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EmbedVrWidget.super.computeSerializedSize();
                Integer num = this.widthPixels;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.stereoFormat = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (!EmbedVrWidget.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.widthPixels;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                EmbedVrWidget.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Pano clone() {
                try {
                    return EmbedVrWidget.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Video extends ExtendableMessageNano<Video> implements Cloneable {
            private Integer heightPixels = null;
            private Integer stereoFormat = null;
            private Integer videoDurationMs = null;
            private Integer widthPixels = null;

            public Video() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = EmbedVrWidget.super.computeSerializedSize();
                Integer num = this.widthPixels;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                }
                Integer num4 = this.videoDurationMs;
                return num4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.stereoFormat = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 32) {
                        this.videoDurationMs = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!EmbedVrWidget.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.widthPixels;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                Integer num4 = this.videoDurationMs;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num4.intValue());
                }
                EmbedVrWidget.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Video clone() {
                try {
                    return EmbedVrWidget.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final EmbedVrWidget clone() {
            try {
                EmbedVrWidget clone = Vr$VREvent.super.clone();
                Pano pano2 = this.pano;
                if (pano2 != null) {
                    clone.pano = pano2.clone();
                }
                Video video2 = this.video;
                if (video2 != null) {
                    clone.video = video2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class GConfigUpdate extends ExtendableMessageNano<GConfigUpdate> implements Cloneable {
        private GConfigValue[] gConfigValue = GConfigValue.emptyArray();

        public GConfigUpdate() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            GConfigValue[] gConfigValueArr = this.gConfigValue;
            if (gConfigValueArr != null && gConfigValueArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.gConfigValue;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    GConfigValue[] gConfigValueArr = this.gConfigValue;
                    int length = gConfigValueArr == null ? 0 : gConfigValueArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new GConfigValue[i];
                    if (length != 0) {
                        System.arraycopy(gConfigValueArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new GConfigValue();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new GConfigValue();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.gConfigValue = messageNanoArr;
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            GConfigValue[] gConfigValueArr = this.gConfigValue;
            if (gConfigValueArr != null && gConfigValueArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.gConfigValue;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(1, messageNano);
                    }
                    i++;
                }
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class GConfigValue extends ExtendableMessageNano<GConfigValue> implements Cloneable {
            private static volatile GConfigValue[] _emptyArray;
            private String gConfigKey = null;
            private String stringValue = null;

            public GConfigValue() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static GConfigValue[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new GConfigValue[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = GConfigUpdate.super.computeSerializedSize();
                String str = this.gConfigKey;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.stringValue;
                return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str2) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.gConfigKey = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        this.stringValue = codedInputByteBufferNano.readString();
                    } else if (!GConfigUpdate.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.gConfigKey;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.stringValue;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                GConfigUpdate.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final GConfigValue clone() {
                try {
                    return GConfigUpdate.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final GConfigUpdate clone() {
            try {
                GConfigUpdate clone = Vr$VREvent.super.clone();
                GConfigValue[] gConfigValueArr = this.gConfigValue;
                if (gConfigValueArr != null && gConfigValueArr.length > 0) {
                    clone.gConfigValue = new GConfigValue[gConfigValueArr.length];
                    int i = 0;
                    while (true) {
                        GConfigValue[] gConfigValueArr2 = this.gConfigValue;
                        if (i >= gConfigValueArr2.length) {
                            break;
                        }
                        if (gConfigValueArr2[i] != null) {
                            clone.gConfigValue[i] = gConfigValueArr2[i].clone();
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
    public final class JumpInspector extends ExtendableMessageNano<JumpInspector> implements Cloneable {
        private MediaDetails mediaDetails = null;
        private PickerDetails pickerEvent = null;
        private PlaybackDetails playbackDetails = null;

        public JumpInspector() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            MediaDetails mediaDetails2 = this.mediaDetails;
            if (mediaDetails2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, mediaDetails2);
            }
            PlaybackDetails playbackDetails2 = this.playbackDetails;
            if (playbackDetails2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, playbackDetails2);
            }
            PickerDetails pickerDetails = this.pickerEvent;
            return pickerDetails != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, pickerDetails) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.mediaDetails == null) {
                        this.mediaDetails = new MediaDetails();
                    }
                    codedInputByteBufferNano.readMessage(this.mediaDetails);
                } else if (readTag == 18) {
                    if (this.playbackDetails == null) {
                        this.playbackDetails = new PlaybackDetails();
                    }
                    codedInputByteBufferNano.readMessage(this.playbackDetails);
                } else if (readTag == 26) {
                    if (this.pickerEvent == null) {
                        this.pickerEvent = new PickerDetails();
                    }
                    codedInputByteBufferNano.readMessage(this.pickerEvent);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            MediaDetails mediaDetails2 = this.mediaDetails;
            if (mediaDetails2 != null) {
                codedOutputByteBufferNano.writeMessage(1, mediaDetails2);
            }
            PlaybackDetails playbackDetails2 = this.playbackDetails;
            if (playbackDetails2 != null) {
                codedOutputByteBufferNano.writeMessage(2, playbackDetails2);
            }
            PickerDetails pickerDetails = this.pickerEvent;
            if (pickerDetails != null) {
                codedOutputByteBufferNano.writeMessage(3, pickerDetails);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class AudioDetails extends ExtendableMessageNano<AudioDetails> implements Cloneable {
            private Integer audioBitRate = null;
            private Integer audioChannelCount = null;
            private Integer audioCodec = null;
            private Long mediaLengthSeconds = null;
            private Integer sampleRate = null;

            public AudioDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
                }
                Integer num2 = this.audioBitRate;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
                }
                Integer num3 = this.audioCodec;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num3.intValue());
                }
                Integer num4 = this.audioChannelCount;
                return num4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, num4.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.mediaLengthSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 16) {
                        this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        this.audioBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 32) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                            this.audioCodec = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 40) {
                        this.audioChannelCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(2, num.intValue());
                }
                Integer num2 = this.audioBitRate;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                Integer num3 = this.audioCodec;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num3.intValue());
                }
                Integer num4 = this.audioChannelCount;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num4.intValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final AudioDetails clone() {
                try {
                    return JumpInspector.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class ImageDetails extends ExtendableMessageNano<ImageDetails> implements Cloneable {
            private Resolution resolution = null;
            private Boolean usedMonoFilename = null;

            public ImageDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Resolution resolution2 = this.resolution;
                if (resolution2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, resolution2);
                }
                Boolean bool = this.usedMonoFilename;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.resolution == null) {
                            this.resolution = new Resolution();
                        }
                        codedInputByteBufferNano.readMessage(this.resolution);
                    } else if (readTag == 16) {
                        this.usedMonoFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Resolution resolution2 = this.resolution;
                if (resolution2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, resolution2);
                }
                Boolean bool = this.usedMonoFilename;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final ImageDetails clone() {
                try {
                    ImageDetails clone = JumpInspector.super.clone();
                    Resolution resolution2 = this.resolution;
                    if (resolution2 != null) {
                        clone.resolution = resolution2.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class ImagePlaybackDetails extends ExtendableMessageNano<ImagePlaybackDetails> implements Cloneable {
            private Integer playbackMode = null;

            public ImagePlaybackDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Integer num = this.playbackMode;
                return num != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, num.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.playbackMode = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.playbackMode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final ImagePlaybackDetails clone() {
                try {
                    return JumpInspector.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class MediaDetails extends ExtendableMessageNano<MediaDetails> implements Cloneable {
            private AudioDetails audioDetails = null;
            private String fileExtension = null;
            private ImageDetails imageDetails = null;
            private VideoDetails videoDetails = null;

            public MediaDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                String str = this.fileExtension;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                VideoDetails videoDetails2 = this.videoDetails;
                if (videoDetails2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, videoDetails2);
                }
                ImageDetails imageDetails2 = this.imageDetails;
                if (imageDetails2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, imageDetails2);
                }
                AudioDetails audioDetails2 = this.audioDetails;
                return audioDetails2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, audioDetails2) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.fileExtension = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        if (this.videoDetails == null) {
                            this.videoDetails = new VideoDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.videoDetails);
                    } else if (readTag == 26) {
                        if (this.imageDetails == null) {
                            this.imageDetails = new ImageDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.imageDetails);
                    } else if (readTag == 34) {
                        if (this.audioDetails == null) {
                            this.audioDetails = new AudioDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.audioDetails);
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.fileExtension;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                VideoDetails videoDetails2 = this.videoDetails;
                if (videoDetails2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, videoDetails2);
                }
                ImageDetails imageDetails2 = this.imageDetails;
                if (imageDetails2 != null) {
                    codedOutputByteBufferNano.writeMessage(3, imageDetails2);
                }
                AudioDetails audioDetails2 = this.audioDetails;
                if (audioDetails2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, audioDetails2);
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final MediaDetails clone() {
                try {
                    MediaDetails clone = JumpInspector.super.clone();
                    VideoDetails videoDetails2 = this.videoDetails;
                    if (videoDetails2 != null) {
                        clone.videoDetails = videoDetails2.clone();
                    }
                    ImageDetails imageDetails2 = this.imageDetails;
                    if (imageDetails2 != null) {
                        clone.imageDetails = imageDetails2.clone();
                    }
                    AudioDetails audioDetails2 = this.audioDetails;
                    if (audioDetails2 != null) {
                        clone.audioDetails = audioDetails2.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class PickerDetails extends ExtendableMessageNano<PickerDetails> implements Cloneable {
            private Integer numberOfFiles = null;
            private Integer numberOfFolders = null;

            public PickerDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Integer num = this.numberOfFiles;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.numberOfFolders;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.numberOfFiles = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.numberOfFolders = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.numberOfFiles;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.numberOfFolders;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final PickerDetails clone() {
                try {
                    return JumpInspector.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class PlaybackDetails extends ExtendableMessageNano<PlaybackDetails> implements Cloneable {
            private ImagePlaybackDetails imagePlayback = null;
            private Long playbackDurationSeconds = null;
            private Integer playbackEngine = null;
            private Integer playbackState = null;
            private VideoPlaybackDetails videoPlayback = null;

            public PlaybackDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Integer num = this.playbackState;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.playbackDurationSeconds;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
                }
                Integer num2 = this.playbackEngine;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
                }
                VideoPlaybackDetails videoPlaybackDetails = this.videoPlayback;
                if (videoPlaybackDetails != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, videoPlaybackDetails);
                }
                ImagePlaybackDetails imagePlaybackDetails = this.imagePlayback;
                return imagePlaybackDetails != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, imagePlaybackDetails) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.playbackState = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.playbackDurationSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 24) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                            this.playbackEngine = Integer.valueOf(readInt322);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 34) {
                        if (this.videoPlayback == null) {
                            this.videoPlayback = new VideoPlaybackDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.videoPlayback);
                    } else if (readTag == 42) {
                        if (this.imagePlayback == null) {
                            this.imagePlayback = new ImagePlaybackDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.imagePlayback);
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.playbackState;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.playbackDurationSeconds;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                Integer num2 = this.playbackEngine;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                VideoPlaybackDetails videoPlaybackDetails = this.videoPlayback;
                if (videoPlaybackDetails != null) {
                    codedOutputByteBufferNano.writeMessage(4, videoPlaybackDetails);
                }
                ImagePlaybackDetails imagePlaybackDetails = this.imagePlayback;
                if (imagePlaybackDetails != null) {
                    codedOutputByteBufferNano.writeMessage(5, imagePlaybackDetails);
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final PlaybackDetails clone() {
                try {
                    PlaybackDetails clone = JumpInspector.super.clone();
                    VideoPlaybackDetails videoPlaybackDetails = this.videoPlayback;
                    if (videoPlaybackDetails != null) {
                        clone.videoPlayback = videoPlaybackDetails.clone();
                    }
                    ImagePlaybackDetails imagePlaybackDetails = this.imagePlayback;
                    if (imagePlaybackDetails != null) {
                        clone.imagePlayback = imagePlaybackDetails.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Resolution extends ExtendableMessageNano<Resolution> implements Cloneable {
            private Integer height = null;
            private Integer width = null;

            public Resolution() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Integer num = this.width;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.height;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.width = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.height = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.width;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.height;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Resolution clone() {
                try {
                    return JumpInspector.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class SphericalMetadata extends ExtendableMessageNano<SphericalMetadata> implements Cloneable {
            private Integer meshCrc = null;
            private Integer metadataVersion = null;
            private Integer projectionType = null;

            public SphericalMetadata() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Integer num = this.metadataVersion;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.projectionType;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.meshCrc;
                return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.metadataVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                            this.projectionType = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 24) {
                        this.meshCrc = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.metadataVersion;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.projectionType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.meshCrc;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final SphericalMetadata clone() {
                try {
                    return JumpInspector.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class VideoDetails extends ExtendableMessageNano<VideoDetails> implements Cloneable {
            private Integer audioBitRate = null;
            private Integer audioChannelCount = null;
            private Integer audioCodec = null;
            private Double framesPerSecond = null;
            private Long mediaLengthSeconds = null;
            private Resolution resolution = null;
            private Integer sampleRate = null;
            private SphericalMetadata sphericalMetadata = null;
            private Boolean usedMonoFilename = null;
            private Boolean usedWalleFilename = null;
            private Boolean usedWallyFilename = null;
            private Integer videoBitRate = null;
            private Integer videoCodec = null;

            public VideoDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Resolution resolution2 = this.resolution;
                if (resolution2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, resolution2);
                }
                Double d = this.framesPerSecond;
                if (d != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, d.doubleValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num.intValue());
                }
                Integer num2 = this.videoBitRate;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num2.intValue());
                }
                Integer num3 = this.audioBitRate;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num3.intValue());
                }
                Integer num4 = this.videoCodec;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, num4.intValue());
                }
                Integer num5 = this.audioCodec;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num5.intValue());
                }
                SphericalMetadata sphericalMetadata2 = this.sphericalMetadata;
                if (sphericalMetadata2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, sphericalMetadata2);
                }
                Integer num6 = this.audioChannelCount;
                if (num6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, num6.intValue());
                }
                Boolean bool = this.usedMonoFilename;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, bool.booleanValue());
                }
                Boolean bool2 = this.usedWalleFilename;
                if (bool2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, bool2.booleanValue());
                }
                Boolean bool3 = this.usedWallyFilename;
                return bool3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(13, bool3.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            this.mediaLengthSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                            break;
                        case 18:
                            if (this.resolution == null) {
                                this.resolution = new Resolution();
                            }
                            codedInputByteBufferNano.readMessage(this.resolution);
                            break;
                        case 25:
                            this.framesPerSecond = Double.valueOf(codedInputByteBufferNano.readDouble());
                            break;
                        case 32:
                            this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 40:
                            this.videoBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 48:
                            this.audioBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 56:
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.videoCodec = Integer.valueOf(readInt32);
                                break;
                            }
                        case 64:
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3 && readInt322 != 4) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.audioCodec = Integer.valueOf(readInt322);
                                break;
                            }
                        case 74:
                            if (this.sphericalMetadata == null) {
                                this.sphericalMetadata = new SphericalMetadata();
                            }
                            codedInputByteBufferNano.readMessage(this.sphericalMetadata);
                            break;
                        case 80:
                            this.audioChannelCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 88:
                            this.usedMonoFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        case 96:
                            this.usedWalleFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        case 104:
                            this.usedWallyFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        default:
                            if (JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Resolution resolution2 = this.resolution;
                if (resolution2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, resolution2);
                }
                Double d = this.framesPerSecond;
                if (d != null) {
                    codedOutputByteBufferNano.writeDouble(3, d.doubleValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(4, num.intValue());
                }
                Integer num2 = this.videoBitRate;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num2.intValue());
                }
                Integer num3 = this.audioBitRate;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(6, num3.intValue());
                }
                Integer num4 = this.videoCodec;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(7, num4.intValue());
                }
                Integer num5 = this.audioCodec;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num5.intValue());
                }
                SphericalMetadata sphericalMetadata2 = this.sphericalMetadata;
                if (sphericalMetadata2 != null) {
                    codedOutputByteBufferNano.writeMessage(9, sphericalMetadata2);
                }
                Integer num6 = this.audioChannelCount;
                if (num6 != null) {
                    codedOutputByteBufferNano.writeInt32(10, num6.intValue());
                }
                Boolean bool = this.usedMonoFilename;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(11, bool.booleanValue());
                }
                Boolean bool2 = this.usedWalleFilename;
                if (bool2 != null) {
                    codedOutputByteBufferNano.writeBool(12, bool2.booleanValue());
                }
                Boolean bool3 = this.usedWallyFilename;
                if (bool3 != null) {
                    codedOutputByteBufferNano.writeBool(13, bool3.booleanValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final VideoDetails clone() {
                try {
                    VideoDetails clone = JumpInspector.super.clone();
                    Resolution resolution2 = this.resolution;
                    if (resolution2 != null) {
                        clone.resolution = resolution2.clone();
                    }
                    SphericalMetadata sphericalMetadata2 = this.sphericalMetadata;
                    if (sphericalMetadata2 != null) {
                        clone.sphericalMetadata = sphericalMetadata2.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class VideoPlaybackDetails extends ExtendableMessageNano<VideoPlaybackDetails> implements Cloneable {
            private Integer droppedFramesCount = null;
            private Integer playbackMode = null;
            private Boolean usedExternalSync = null;

            public VideoPlaybackDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = JumpInspector.super.computeSerializedSize();
                Integer num = this.playbackMode;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.usedExternalSync;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
                }
                Integer num2 = this.droppedFramesCount;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.playbackMode = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.usedExternalSync = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 24) {
                        this.droppedFramesCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!JumpInspector.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.playbackMode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.usedExternalSync;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                Integer num2 = this.droppedFramesCount;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                JumpInspector.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final VideoPlaybackDetails clone() {
                try {
                    return JumpInspector.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final JumpInspector clone() {
            try {
                JumpInspector clone = Vr$VREvent.super.clone();
                MediaDetails mediaDetails2 = this.mediaDetails;
                if (mediaDetails2 != null) {
                    clone.mediaDetails = mediaDetails2.clone();
                }
                PlaybackDetails playbackDetails2 = this.playbackDetails;
                if (playbackDetails2 != null) {
                    clone.playbackDetails = playbackDetails2.clone();
                }
                PickerDetails pickerDetails = this.pickerEvent;
                if (pickerDetails != null) {
                    clone.pickerEvent = pickerDetails.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class Keyboard extends ExtendableMessageNano<Keyboard> implements Cloneable {
        private KeyboardEvent[] keyboardEvents = KeyboardEvent.emptyArray();

        public Keyboard() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
            if (keyboardEventArr != null && keyboardEventArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.keyboardEvents;
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

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
                    int length = keyboardEventArr == null ? 0 : keyboardEventArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new KeyboardEvent[i];
                    if (length != 0) {
                        System.arraycopy(keyboardEventArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new KeyboardEvent();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new KeyboardEvent();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.keyboardEvents = messageNanoArr;
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
            if (keyboardEventArr != null && keyboardEventArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.keyboardEvents;
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
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class KeyboardEvent extends ExtendableMessageNano<KeyboardEvent> implements Cloneable {
            private static volatile KeyboardEvent[] _emptyArray;
            private Long clientTimestamp = null;
            private String[] enabledLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
            private Integer eventType = null;
            private Integer inputType = null;
            private Application keyboardService = null;
            private String language = null;
            private String layout = null;
            private Integer suggestionCount = null;
            private String[] systemLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
            private KeyboardTextEntry textEntry = null;

            public KeyboardEvent() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static KeyboardEvent[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new KeyboardEvent[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Keyboard.super.computeSerializedSize();
                Long l = this.clientTimestamp;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Integer num = this.eventType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
                }
                KeyboardTextEntry keyboardTextEntry = this.textEntry;
                if (keyboardTextEntry != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, keyboardTextEntry);
                }
                Application application = this.keyboardService;
                if (application != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, application);
                }
                String[] strArr = this.systemLanguages;
                int i = 0;
                if (strArr != null && strArr.length > 0) {
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        String[] strArr2 = this.systemLanguages;
                        if (i2 >= strArr2.length) {
                            break;
                        }
                        String str = strArr2[i2];
                        if (str != null) {
                            i4++;
                            i3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                        }
                        i2++;
                    }
                    computeSerializedSize = computeSerializedSize + i3 + (i4 * 1);
                }
                String[] strArr3 = this.enabledLanguages;
                if (strArr3 != null && strArr3.length > 0) {
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        String[] strArr4 = this.enabledLanguages;
                        if (i >= strArr4.length) {
                            break;
                        }
                        String str2 = strArr4[i];
                        if (str2 != null) {
                            i6++;
                            i5 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                        }
                        i++;
                    }
                    computeSerializedSize = computeSerializedSize + i5 + (i6 * 1);
                }
                String str3 = this.language;
                if (str3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str3);
                }
                Integer num2 = this.inputType;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num2.intValue());
                }
                String str4 = this.layout;
                if (str4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, str4);
                }
                Integer num3 = this.suggestionCount;
                return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, num3.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            this.clientTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                            break;
                        case 16:
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (!(readInt32 == 1000 || readInt32 == 1001 || readInt32 == 2000)) {
                                switch (readInt32) {
                                    default:
                                        switch (readInt32) {
                                            case 3000:
                                            case 3001:
                                            case 3002:
                                                break;
                                            default:
                                                codedInputByteBufferNano.rewindToPosition(position);
                                                storeUnknownField(codedInputByteBufferNano, readTag);
                                                break;
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                        this.eventType = Integer.valueOf(readInt32);
                                        break;
                                }
                            }
                            this.eventType = Integer.valueOf(readInt32);
                        case 26:
                            if (this.textEntry == null) {
                                this.textEntry = new KeyboardTextEntry();
                            }
                            codedInputByteBufferNano.readMessage(this.textEntry);
                            break;
                        case 34:
                            if (this.keyboardService == null) {
                                this.keyboardService = new Application();
                            }
                            codedInputByteBufferNano.readMessage(this.keyboardService);
                            break;
                        case 42:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                            String[] strArr = this.systemLanguages;
                            int length = strArr == null ? 0 : strArr.length;
                            int i = repeatedFieldArrayLength + length;
                            String[] strArr2 = new String[i];
                            if (length != 0) {
                                System.arraycopy(strArr, 0, strArr2, 0, length);
                            }
                            while (length < i - 1) {
                                strArr2[length] = codedInputByteBufferNano.readString();
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            strArr2[length] = codedInputByteBufferNano.readString();
                            this.systemLanguages = strArr2;
                            break;
                        case 50:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                            String[] strArr3 = this.enabledLanguages;
                            int length2 = strArr3 == null ? 0 : strArr3.length;
                            int i2 = repeatedFieldArrayLength2 + length2;
                            String[] strArr4 = new String[i2];
                            if (length2 != 0) {
                                System.arraycopy(strArr3, 0, strArr4, 0, length2);
                            }
                            while (length2 < i2 - 1) {
                                strArr4[length2] = codedInputByteBufferNano.readString();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            strArr4[length2] = codedInputByteBufferNano.readString();
                            this.enabledLanguages = strArr4;
                            break;
                        case 58:
                            this.language = codedInputByteBufferNano.readString();
                            break;
                        case 64:
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.inputType = Integer.valueOf(readInt322);
                                break;
                            }
                        case 74:
                            this.layout = codedInputByteBufferNano.readString();
                            break;
                        case 80:
                            this.suggestionCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        default:
                            if (Keyboard.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.clientTimestamp;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Integer num = this.eventType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(2, num.intValue());
                }
                KeyboardTextEntry keyboardTextEntry = this.textEntry;
                if (keyboardTextEntry != null) {
                    codedOutputByteBufferNano.writeMessage(3, keyboardTextEntry);
                }
                Application application = this.keyboardService;
                if (application != null) {
                    codedOutputByteBufferNano.writeMessage(4, application);
                }
                String[] strArr = this.systemLanguages;
                int i = 0;
                if (strArr != null && strArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr2 = this.systemLanguages;
                        if (i2 >= strArr2.length) {
                            break;
                        }
                        String str = strArr2[i2];
                        if (str != null) {
                            codedOutputByteBufferNano.writeString(5, str);
                        }
                        i2++;
                    }
                }
                String[] strArr3 = this.enabledLanguages;
                if (strArr3 != null && strArr3.length > 0) {
                    while (true) {
                        String[] strArr4 = this.enabledLanguages;
                        if (i >= strArr4.length) {
                            break;
                        }
                        String str2 = strArr4[i];
                        if (str2 != null) {
                            codedOutputByteBufferNano.writeString(6, str2);
                        }
                        i++;
                    }
                }
                String str3 = this.language;
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(7, str3);
                }
                Integer num2 = this.inputType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num2.intValue());
                }
                String str4 = this.layout;
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(9, str4);
                }
                Integer num3 = this.suggestionCount;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(10, num3.intValue());
                }
                Keyboard.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final KeyboardEvent clone() {
                try {
                    KeyboardEvent clone = Keyboard.super.clone();
                    KeyboardTextEntry keyboardTextEntry = this.textEntry;
                    if (keyboardTextEntry != null) {
                        clone.textEntry = keyboardTextEntry.clone();
                    }
                    Application application = this.keyboardService;
                    if (application != null) {
                        clone.keyboardService = application.clone();
                    }
                    String[] strArr = this.systemLanguages;
                    if (strArr != null && strArr.length > 0) {
                        clone.systemLanguages = (String[]) strArr.clone();
                    }
                    String[] strArr2 = this.enabledLanguages;
                    if (strArr2 != null && strArr2.length > 0) {
                        clone.enabledLanguages = (String[]) strArr2.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class KeyboardTextEntry extends ExtendableMessageNano<KeyboardTextEntry> implements Cloneable {
            private String language = null;
            private String layout = null;
            private Integer length = null;
            private Integer type = null;

            public KeyboardTextEntry() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Keyboard.super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.length;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                String str = this.layout;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
                }
                String str2 = this.language;
                return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, str2) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 4 || readInt32 == 5) {
                            this.type = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.length = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 26) {
                        this.layout = codedInputByteBufferNano.readString();
                    } else if (readTag == 34) {
                        this.language = codedInputByteBufferNano.readString();
                    } else if (!Keyboard.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.length;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                String str = this.layout;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                String str2 = this.language;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(4, str2);
                }
                Keyboard.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final KeyboardTextEntry clone() {
                try {
                    return Keyboard.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final Keyboard clone() {
            try {
                Keyboard clone = Vr$VREvent.super.clone();
                KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
                if (keyboardEventArr != null && keyboardEventArr.length > 0) {
                    clone.keyboardEvents = new KeyboardEvent[keyboardEventArr.length];
                    int i = 0;
                    while (true) {
                        KeyboardEvent[] keyboardEventArr2 = this.keyboardEvents;
                        if (i >= keyboardEventArr2.length) {
                            break;
                        }
                        if (keyboardEventArr2[i] != null) {
                            clone.keyboardEvents[i] = keyboardEventArr2[i].clone();
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
    public final class Lullaby extends ExtendableMessageNano<Lullaby> implements Cloneable {
        private String contentId = null;
        private Integer index = null;
        private LoadTime loadTime = null;
        private Integer uiElement = null;

        public Lullaby() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.uiElement;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.index;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
            }
            String str = this.contentId;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
            }
            LoadTime loadTime2 = this.loadTime;
            return loadTime2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, loadTime2) : computeSerializedSize;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[FALL_THROUGH] */
        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (!(readInt32 == 0 || readInt32 == 1)) {
                        switch (readInt32) {
                            default:
                                switch (readInt32) {
                                    default:
                                        switch (readInt32) {
                                            case 3000:
                                            case 3001:
                                            case 3002:
                                            case 3003:
                                            case 3004:
                                            case 3005:
                                            case 3006:
                                            case 3007:
                                            case 3008:
                                            case 3009:
                                            case 3010:
                                            case 3011:
                                            case 3012:
                                            case 3013:
                                            case 3014:
                                                break;
                                            default:
                                                codedInputByteBufferNano.rewindToPosition(position);
                                                storeUnknownField(codedInputByteBufferNano, readTag);
                                                break;
                                        }
                                    case 2000:
                                    case 2001:
                                    case 2002:
                                    case 2003:
                                    case 2004:
                                    case 2005:
                                    case 2006:
                                    case 2007:
                                    case 2008:
                                    case 2009:
                                    case 2010:
                                    case 2011:
                                    case 2012:
                                    case 2013:
                                    case 2014:
                                    case 2015:
                                    case 2016:
                                    case 2017:
                                    case 2018:
                                    case 2019:
                                    case 2020:
                                    case 2021:
                                        this.uiElement = Integer.valueOf(readInt32);
                                        break;
                                }
                            case 1000:
                            case 1001:
                            case 1002:
                            case 1003:
                            case 1004:
                            case 1005:
                            case 1006:
                            case 1007:
                                break;
                        }
                    }
                    this.uiElement = Integer.valueOf(readInt32);
                } else if (readTag == 16) {
                    this.index = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 26) {
                    this.contentId = codedInputByteBufferNano.readString();
                } else if (readTag == 34) {
                    if (this.loadTime == null) {
                        this.loadTime = new LoadTime();
                    }
                    codedInputByteBufferNano.readMessage(this.loadTime);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.uiElement;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.index;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            String str = this.contentId;
            if (str != null) {
                codedOutputByteBufferNano.writeString(3, str);
            }
            LoadTime loadTime2 = this.loadTime;
            if (loadTime2 != null) {
                codedOutputByteBufferNano.writeMessage(4, loadTime2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class LoadTime extends ExtendableMessageNano<LoadTime> implements Cloneable {
            private Integer assetType = null;
            private Long loadTimeMs = null;

            public LoadTime() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Lullaby.super.computeSerializedSize();
                Integer num = this.assetType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.loadTimeMs;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                this.assetType = Integer.valueOf(readInt32);
                                continue;
                            default:
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                continue;
                        }
                    } else if (readTag == 16) {
                        this.loadTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (!Lullaby.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.assetType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.loadTimeMs;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                Lullaby.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final LoadTime clone() {
                try {
                    return Lullaby.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final Lullaby clone() {
            try {
                Lullaby clone = Vr$VREvent.super.clone();
                LoadTime loadTime2 = this.loadTime;
                if (loadTime2 != null) {
                    clone.loadTime = loadTime2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class Photos extends ExtendableMessageNano<Photos> implements Cloneable {
        private Integer numPhotos = null;
        private OpenMedia openMedia = null;
        private WarmWelcome warmWelcome = null;

        public Photos() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.numPhotos;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            OpenMedia openMedia2 = this.openMedia;
            if (openMedia2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, openMedia2);
            }
            WarmWelcome warmWelcome2 = this.warmWelcome;
            return warmWelcome2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, warmWelcome2) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 18) {
                    if (this.openMedia == null) {
                        this.openMedia = new OpenMedia();
                    }
                    codedInputByteBufferNano.readMessage(this.openMedia);
                } else if (readTag == 26) {
                    if (this.warmWelcome == null) {
                        this.warmWelcome = new WarmWelcome();
                    }
                    codedInputByteBufferNano.readMessage(this.warmWelcome);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.numPhotos;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            OpenMedia openMedia2 = this.openMedia;
            if (openMedia2 != null) {
                codedOutputByteBufferNano.writeMessage(2, openMedia2);
            }
            WarmWelcome warmWelcome2 = this.warmWelcome;
            if (warmWelcome2 != null) {
                codedOutputByteBufferNano.writeMessage(3, warmWelcome2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class OpenMedia extends ExtendableMessageNano<OpenMedia> implements Cloneable {
            private Boolean isSample = null;
            private Integer source = null;
            private Integer type = null;

            public OpenMedia() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Photos.super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.source;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Boolean bool = this.isSample;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                            this.type = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                            this.source = Integer.valueOf(readInt322);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 24) {
                        this.isSample = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (!Photos.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.source;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Boolean bool = this.isSample;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(3, bool.booleanValue());
                }
                Photos.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final OpenMedia clone() {
                try {
                    return Photos.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class WarmWelcome extends ExtendableMessageNano<WarmWelcome> implements Cloneable {
            private Float exitProgress = null;

            public WarmWelcome() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = Photos.super.computeSerializedSize();
                Float f = this.exitProgress;
                return f != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 13) {
                        this.exitProgress = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (!Photos.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Float f = this.exitProgress;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(1, f.floatValue());
                }
                Photos.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final WarmWelcome clone() {
                try {
                    return Photos.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final Photos clone() {
            try {
                Photos clone = Vr$VREvent.super.clone();
                OpenMedia openMedia2 = this.openMedia;
                if (openMedia2 != null) {
                    clone.openMedia = openMedia2.clone();
                }
                WarmWelcome warmWelcome2 = this.warmWelcome;
                if (warmWelcome2 != null) {
                    clone.warmWelcome = warmWelcome2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class SdkConfigurationParams extends ExtendableMessageNano<SdkConfigurationParams> implements Cloneable {
        public Boolean allowDynamicJavaLibraryLoading = null;
        public Boolean allowDynamicLibraryLoading = null;
        public Boolean allowVrcoreCompositing = null;
        public Boolean allowVrcoreHeadTracking = null;
        public AsyncReprojectionConfig asyncReprojectionConfig = null;
        public Boolean cpuLateLatchingEnabled = null;
        public Integer daydreamImageAlignment = null;
        private Boolean daydreamImageAlignmentEnabled = null;
        public Boolean enableForcedTrackingCompat = null;
        private PerformanceOverlayInfo performanceOverlayInfo = null;
        public Boolean touchOverlayEnabled = null;
        public Boolean useDeviceIdleDetection = null;
        public Boolean useMagnetometerInSensorFusion = null;
        public Boolean useOnlineMagnetometerCalibration = null;
        private Boolean useStationaryBiasCorrection = null;
        public Boolean useSystemClockForSensorTimestamps = null;

        public SdkConfigurationParams() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Boolean bool = this.daydreamImageAlignmentEnabled;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, bool.booleanValue());
            }
            Boolean bool2 = this.useSystemClockForSensorTimestamps;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool2.booleanValue());
            }
            Boolean bool3 = this.useMagnetometerInSensorFusion;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool3.booleanValue());
            }
            Boolean bool4 = this.allowDynamicLibraryLoading;
            if (bool4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, bool4.booleanValue());
            }
            Boolean bool5 = this.cpuLateLatchingEnabled;
            if (bool5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, bool5.booleanValue());
            }
            Integer num = this.daydreamImageAlignment;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num.intValue());
            }
            AsyncReprojectionConfig asyncReprojectionConfig2 = this.asyncReprojectionConfig;
            if (asyncReprojectionConfig2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, asyncReprojectionConfig2);
            }
            Boolean bool6 = this.useOnlineMagnetometerCalibration;
            if (bool6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, bool6.booleanValue());
            }
            Boolean bool7 = this.useDeviceIdleDetection;
            if (bool7 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, bool7.booleanValue());
            }
            Boolean bool8 = this.useStationaryBiasCorrection;
            if (bool8 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, bool8.booleanValue());
            }
            Boolean bool9 = this.allowDynamicJavaLibraryLoading;
            if (bool9 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, bool9.booleanValue());
            }
            Boolean bool10 = this.touchOverlayEnabled;
            if (bool10 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, bool10.booleanValue());
            }
            Boolean bool11 = this.allowVrcoreHeadTracking;
            if (bool11 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, bool11.booleanValue());
            }
            Boolean bool12 = this.allowVrcoreCompositing;
            if (bool12 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, bool12.booleanValue());
            }
            PerformanceOverlayInfo performanceOverlayInfo2 = this.performanceOverlayInfo;
            if (performanceOverlayInfo2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, performanceOverlayInfo2);
            }
            Boolean bool13 = this.enableForcedTrackingCompat;
            return bool13 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(16, bool13.booleanValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        this.daydreamImageAlignmentEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 16:
                        this.useSystemClockForSensorTimestamps = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 24:
                        this.useMagnetometerInSensorFusion = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 32:
                        this.allowDynamicLibraryLoading = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 40:
                        this.cpuLateLatchingEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 48:
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        } else {
                            this.daydreamImageAlignment = Integer.valueOf(readInt32);
                            break;
                        }
                    case 58:
                        if (this.asyncReprojectionConfig == null) {
                            this.asyncReprojectionConfig = new AsyncReprojectionConfig();
                        }
                        codedInputByteBufferNano.readMessage(this.asyncReprojectionConfig);
                        break;
                    case 64:
                        this.useOnlineMagnetometerCalibration = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 72:
                        this.useDeviceIdleDetection = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 80:
                        this.useStationaryBiasCorrection = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 88:
                        this.allowDynamicJavaLibraryLoading = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 96:
                        this.touchOverlayEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 104:
                        this.allowVrcoreHeadTracking = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 112:
                        this.allowVrcoreCompositing = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 122:
                        if (this.performanceOverlayInfo == null) {
                            this.performanceOverlayInfo = new PerformanceOverlayInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.performanceOverlayInfo);
                        break;
                    case 128:
                        this.enableForcedTrackingCompat = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    default:
                        if (Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Boolean bool = this.daydreamImageAlignmentEnabled;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(1, bool.booleanValue());
            }
            Boolean bool2 = this.useSystemClockForSensorTimestamps;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(2, bool2.booleanValue());
            }
            Boolean bool3 = this.useMagnetometerInSensorFusion;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(3, bool3.booleanValue());
            }
            Boolean bool4 = this.allowDynamicLibraryLoading;
            if (bool4 != null) {
                codedOutputByteBufferNano.writeBool(4, bool4.booleanValue());
            }
            Boolean bool5 = this.cpuLateLatchingEnabled;
            if (bool5 != null) {
                codedOutputByteBufferNano.writeBool(5, bool5.booleanValue());
            }
            Integer num = this.daydreamImageAlignment;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(6, num.intValue());
            }
            AsyncReprojectionConfig asyncReprojectionConfig2 = this.asyncReprojectionConfig;
            if (asyncReprojectionConfig2 != null) {
                codedOutputByteBufferNano.writeMessage(7, asyncReprojectionConfig2);
            }
            Boolean bool6 = this.useOnlineMagnetometerCalibration;
            if (bool6 != null) {
                codedOutputByteBufferNano.writeBool(8, bool6.booleanValue());
            }
            Boolean bool7 = this.useDeviceIdleDetection;
            if (bool7 != null) {
                codedOutputByteBufferNano.writeBool(9, bool7.booleanValue());
            }
            Boolean bool8 = this.useStationaryBiasCorrection;
            if (bool8 != null) {
                codedOutputByteBufferNano.writeBool(10, bool8.booleanValue());
            }
            Boolean bool9 = this.allowDynamicJavaLibraryLoading;
            if (bool9 != null) {
                codedOutputByteBufferNano.writeBool(11, bool9.booleanValue());
            }
            Boolean bool10 = this.touchOverlayEnabled;
            if (bool10 != null) {
                codedOutputByteBufferNano.writeBool(12, bool10.booleanValue());
            }
            Boolean bool11 = this.allowVrcoreHeadTracking;
            if (bool11 != null) {
                codedOutputByteBufferNano.writeBool(13, bool11.booleanValue());
            }
            Boolean bool12 = this.allowVrcoreCompositing;
            if (bool12 != null) {
                codedOutputByteBufferNano.writeBool(14, bool12.booleanValue());
            }
            PerformanceOverlayInfo performanceOverlayInfo2 = this.performanceOverlayInfo;
            if (performanceOverlayInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(15, performanceOverlayInfo2);
            }
            Boolean bool13 = this.enableForcedTrackingCompat;
            if (bool13 != null) {
                codedOutputByteBufferNano.writeBool(16, bool13.booleanValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class AsyncReprojectionConfig extends ExtendableMessageNano<AsyncReprojectionConfig> implements Cloneable {
            private Long displayLatencyMicros = null;
            public Long flags = null;

            public AsyncReprojectionConfig() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = SdkConfigurationParams.super.computeSerializedSize();
                Long l = this.flags;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Long l2 = this.displayLatencyMicros;
                return l2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, l2.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.flags = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 16) {
                        this.displayLatencyMicros = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (!SdkConfigurationParams.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.flags;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Long l2 = this.displayLatencyMicros;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeInt64(2, l2.longValue());
                }
                SdkConfigurationParams.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final AsyncReprojectionConfig clone() {
                try {
                    return SdkConfigurationParams.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class PerformanceOverlayInfo extends ExtendableMessageNano<PerformanceOverlayInfo> implements Cloneable {
            private String version = null;

            public PerformanceOverlayInfo() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = SdkConfigurationParams.super.computeSerializedSize();
                String str = this.version;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.version = codedInputByteBufferNano.readString();
                    } else if (!SdkConfigurationParams.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.version;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                SdkConfigurationParams.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final PerformanceOverlayInfo clone() {
                try {
                    return SdkConfigurationParams.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final SdkConfigurationParams clone() {
            try {
                SdkConfigurationParams clone = Vr$VREvent.super.clone();
                AsyncReprojectionConfig asyncReprojectionConfig2 = this.asyncReprojectionConfig;
                if (asyncReprojectionConfig2 != null) {
                    clone.asyncReprojectionConfig = asyncReprojectionConfig2.clone();
                }
                PerformanceOverlayInfo performanceOverlayInfo2 = this.performanceOverlayInfo;
                if (performanceOverlayInfo2 != null) {
                    clone.performanceOverlayInfo = performanceOverlayInfo2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class SensorStats extends ExtendableMessageNano<SensorStats> implements Cloneable {
        private GyroscopeStats gyroscopeStats = null;

        public SensorStats() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            GyroscopeStats gyroscopeStats2 = this.gyroscopeStats;
            return gyroscopeStats2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, gyroscopeStats2) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.gyroscopeStats == null) {
                        this.gyroscopeStats = new GyroscopeStats();
                    }
                    codedInputByteBufferNano.readMessage(this.gyroscopeStats);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            GyroscopeStats gyroscopeStats2 = this.gyroscopeStats;
            if (gyroscopeStats2 != null) {
                codedOutputByteBufferNano.writeMessage(1, gyroscopeStats2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class GyroscopeStats extends ExtendableMessageNano<GyroscopeStats> implements Cloneable {
            private Vector3 bias = null;
            private Vector3 lowerBound = null;
            private Vector3 standardDeviation = null;
            private Vector3 upperBound = null;

            public GyroscopeStats() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = SensorStats.super.computeSerializedSize();
                Vector3 vector3 = this.bias;
                if (vector3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vector3);
                }
                Vector3 vector32 = this.lowerBound;
                if (vector32 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, vector32);
                }
                Vector3 vector33 = this.upperBound;
                if (vector33 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, vector33);
                }
                Vector3 vector34 = this.standardDeviation;
                return vector34 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, vector34) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.bias == null) {
                            this.bias = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.bias);
                    } else if (readTag == 18) {
                        if (this.lowerBound == null) {
                            this.lowerBound = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.lowerBound);
                    } else if (readTag == 26) {
                        if (this.upperBound == null) {
                            this.upperBound = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.upperBound);
                    } else if (readTag == 34) {
                        if (this.standardDeviation == null) {
                            this.standardDeviation = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.standardDeviation);
                    } else if (!SensorStats.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Vector3 vector3 = this.bias;
                if (vector3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, vector3);
                }
                Vector3 vector32 = this.lowerBound;
                if (vector32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, vector32);
                }
                Vector3 vector33 = this.upperBound;
                if (vector33 != null) {
                    codedOutputByteBufferNano.writeMessage(3, vector33);
                }
                Vector3 vector34 = this.standardDeviation;
                if (vector34 != null) {
                    codedOutputByteBufferNano.writeMessage(4, vector34);
                }
                SensorStats.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final GyroscopeStats clone() {
                try {
                    GyroscopeStats clone = SensorStats.super.clone();
                    Vector3 vector3 = this.bias;
                    if (vector3 != null) {
                        clone.bias = vector3.clone();
                    }
                    Vector3 vector32 = this.lowerBound;
                    if (vector32 != null) {
                        clone.lowerBound = vector32.clone();
                    }
                    Vector3 vector33 = this.upperBound;
                    if (vector33 != null) {
                        clone.upperBound = vector33.clone();
                    }
                    Vector3 vector34 = this.standardDeviation;
                    if (vector34 != null) {
                        clone.standardDeviation = vector34.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class Vector3 extends ExtendableMessageNano<Vector3> implements Cloneable {
            private Float x = null;
            private Float y = null;
            private Float z = null;

            public Vector3() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = SensorStats.super.computeSerializedSize();
                Float f = this.x;
                if (f != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue());
                }
                Float f2 = this.y;
                if (f2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f2.floatValue());
                }
                Float f3 = this.z;
                return f3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, f3.floatValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 13) {
                        this.x = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 21) {
                        this.y = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 29) {
                        this.z = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (!SensorStats.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Float f = this.x;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(1, f.floatValue());
                }
                Float f2 = this.y;
                if (f2 != null) {
                    codedOutputByteBufferNano.writeFloat(2, f2.floatValue());
                }
                Float f3 = this.z;
                if (f3 != null) {
                    codedOutputByteBufferNano.writeFloat(3, f3.floatValue());
                }
                SensorStats.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Vector3 clone() {
                try {
                    return SensorStats.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final SensorStats clone() {
            try {
                SensorStats clone = Vr$VREvent.super.clone();
                GyroscopeStats gyroscopeStats2 = this.gyroscopeStats;
                if (gyroscopeStats2 != null) {
                    clone.gyroscopeStats = gyroscopeStats2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class StreetView extends ExtendableMessageNano<StreetView> implements Cloneable {
        private PanoSession panoSession = null;
        private TutorialSession tutorialSession = null;

        public StreetView() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            PanoSession panoSession2 = this.panoSession;
            if (panoSession2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, panoSession2);
            }
            TutorialSession tutorialSession2 = this.tutorialSession;
            return tutorialSession2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, tutorialSession2) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.panoSession == null) {
                        this.panoSession = new PanoSession();
                    }
                    codedInputByteBufferNano.readMessage(this.panoSession);
                } else if (readTag == 18) {
                    if (this.tutorialSession == null) {
                        this.tutorialSession = new TutorialSession();
                    }
                    codedInputByteBufferNano.readMessage(this.tutorialSession);
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            PanoSession panoSession2 = this.panoSession;
            if (panoSession2 != null) {
                codedOutputByteBufferNano.writeMessage(1, panoSession2);
            }
            TutorialSession tutorialSession2 = this.tutorialSession;
            if (tutorialSession2 != null) {
                codedOutputByteBufferNano.writeMessage(2, tutorialSession2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class PanoSession extends ExtendableMessageNano<PanoSession> implements Cloneable {
            private Integer infoClicks = null;
            private Integer nextClicks = null;
            private Integer nodesNavigated = null;
            private Integer panosAvailable = null;
            private Integer panosViewed = null;
            private Integer playPauseClicks = null;
            private Integer prevClicks = null;
            private Integer source = null;

            public PanoSession() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = StreetView.super.computeSerializedSize();
                Integer num = this.source;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.panosAvailable;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.panosViewed;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                }
                Integer num4 = this.nodesNavigated;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue());
                }
                Integer num5 = this.nextClicks;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num5.intValue());
                }
                Integer num6 = this.prevClicks;
                if (num6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num6.intValue());
                }
                Integer num7 = this.playPauseClicks;
                if (num7 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, num7.intValue());
                }
                Integer num8 = this.infoClicks;
                return num8 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, num8.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                            this.source = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.panosAvailable = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        this.panosViewed = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 32) {
                        this.nodesNavigated = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 40) {
                        this.nextClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 48) {
                        this.prevClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 56) {
                        this.playPauseClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 64) {
                        this.infoClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!StreetView.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.source;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.panosAvailable;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.panosViewed;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                Integer num4 = this.nodesNavigated;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num4.intValue());
                }
                Integer num5 = this.nextClicks;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num5.intValue());
                }
                Integer num6 = this.prevClicks;
                if (num6 != null) {
                    codedOutputByteBufferNano.writeInt32(6, num6.intValue());
                }
                Integer num7 = this.playPauseClicks;
                if (num7 != null) {
                    codedOutputByteBufferNano.writeInt32(7, num7.intValue());
                }
                Integer num8 = this.infoClicks;
                if (num8 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num8.intValue());
                }
                StreetView.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final PanoSession clone() {
                try {
                    return StreetView.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class TutorialSession extends ExtendableMessageNano<TutorialSession> implements Cloneable {
            private Boolean completed = null;
            private Integer tutorial = null;

            public TutorialSession() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = StreetView.super.computeSerializedSize();
                Integer num = this.tutorial;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.completed;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.tutorial = Integer.valueOf(readInt32);
                        } else {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        }
                    } else if (readTag == 16) {
                        this.completed = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (!StreetView.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.tutorial;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.completed;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                StreetView.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final TutorialSession clone() {
                try {
                    return StreetView.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final StreetView clone() {
            try {
                StreetView clone = Vr$VREvent.super.clone();
                PanoSession panoSession2 = this.panoSession;
                if (panoSession2 != null) {
                    clone.panoSession = panoSession2.clone();
                }
                TutorialSession tutorialSession2 = this.tutorialSession;
                if (tutorialSession2 != null) {
                    clone.tutorialSession = tutorialSession2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class TimeSeriesData extends ExtendableMessageNano<TimeSeriesData> implements Cloneable {
        private TimeIntervalData[] timeIntervalData = TimeIntervalData.emptyArray();
        private Integer timeIntervalSeconds = null;

        public TimeSeriesData() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.timeIntervalSeconds;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
            if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.timeIntervalData;
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

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.timeIntervalSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
                    int length = timeIntervalDataArr == null ? 0 : timeIntervalDataArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new TimeIntervalData[i];
                    if (length != 0) {
                        System.arraycopy(timeIntervalDataArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new TimeIntervalData();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new TimeIntervalData();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.timeIntervalData = messageNanoArr;
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.timeIntervalSeconds;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
            if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.timeIntervalData;
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
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class TimeIntervalData extends ExtendableMessageNano<TimeIntervalData> implements Cloneable {
            private static volatile TimeIntervalData[] _emptyArray;
            private Integer batteryLevel = null;
            private Integer batteryLevelDelta = null;
            private float[] batteryTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
            private float[] cpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
            private Integer edsThreadFrameDropCount = null;
            private float[] gpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
            private Integer intervalStartTimeSeconds = null;
            private Float skinTemperature = null;
            private Integer thermalWarningsShown = null;

            public TimeIntervalData() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static TimeIntervalData[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new TimeIntervalData[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = TimeSeriesData.super.computeSerializedSize();
                Integer num = this.intervalStartTimeSeconds;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Float f = this.skinTemperature;
                if (f != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f.floatValue());
                }
                Integer num2 = this.edsThreadFrameDropCount;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
                }
                Integer num3 = this.batteryLevel;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num3.intValue());
                }
                Integer num4 = this.batteryLevelDelta;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num4.intValue());
                }
                Integer num5 = this.thermalWarningsShown;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num5.intValue());
                }
                float[] fArr = this.cpuTemperature;
                if (fArr != null && fArr.length > 0) {
                    computeSerializedSize = computeSerializedSize + (fArr.length * 4) + (fArr.length * 1);
                }
                float[] fArr2 = this.gpuTemperature;
                if (fArr2 != null && fArr2.length > 0) {
                    computeSerializedSize = computeSerializedSize + (fArr2.length * 4) + (fArr2.length * 1);
                }
                float[] fArr3 = this.batteryTemperature;
                return (fArr3 == null || fArr3.length <= 0) ? computeSerializedSize : computeSerializedSize + (fArr3.length * 4) + (fArr3.length * 1);
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            this.intervalStartTimeSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 21:
                            this.skinTemperature = Float.valueOf(codedInputByteBufferNano.readFloat());
                            break;
                        case 24:
                            this.edsThreadFrameDropCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 32:
                            this.batteryLevel = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 40:
                            this.batteryLevelDelta = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 48:
                            this.thermalWarningsShown = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 58:
                            int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                            int i = readRawVarint32 / 4;
                            float[] fArr = this.cpuTemperature;
                            int length = fArr == null ? 0 : fArr.length;
                            int i2 = i + length;
                            float[] fArr2 = new float[i2];
                            if (length != 0) {
                                System.arraycopy(fArr, 0, fArr2, 0, length);
                            }
                            while (length < i2) {
                                fArr2[length] = codedInputByteBufferNano.readFloat();
                                length++;
                            }
                            this.cpuTemperature = fArr2;
                            codedInputByteBufferNano.popLimit(pushLimit);
                            break;
                        case 61:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 61);
                            float[] fArr3 = this.cpuTemperature;
                            int length2 = fArr3 == null ? 0 : fArr3.length;
                            int i3 = repeatedFieldArrayLength + length2;
                            float[] fArr4 = new float[i3];
                            if (length2 != 0) {
                                System.arraycopy(fArr3, 0, fArr4, 0, length2);
                            }
                            while (length2 < i3 - 1) {
                                fArr4[length2] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            fArr4[length2] = codedInputByteBufferNano.readFloat();
                            this.cpuTemperature = fArr4;
                            break;
                        case 66:
                            int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                            int i4 = readRawVarint322 / 4;
                            float[] fArr5 = this.gpuTemperature;
                            int length3 = fArr5 == null ? 0 : fArr5.length;
                            int i5 = i4 + length3;
                            float[] fArr6 = new float[i5];
                            if (length3 != 0) {
                                System.arraycopy(fArr5, 0, fArr6, 0, length3);
                            }
                            while (length3 < i5) {
                                fArr6[length3] = codedInputByteBufferNano.readFloat();
                                length3++;
                            }
                            this.gpuTemperature = fArr6;
                            codedInputByteBufferNano.popLimit(pushLimit2);
                            break;
                        case 69:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 69);
                            float[] fArr7 = this.gpuTemperature;
                            int length4 = fArr7 == null ? 0 : fArr7.length;
                            int i6 = repeatedFieldArrayLength2 + length4;
                            float[] fArr8 = new float[i6];
                            if (length4 != 0) {
                                System.arraycopy(fArr7, 0, fArr8, 0, length4);
                            }
                            while (length4 < i6 - 1) {
                                fArr8[length4] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length4++;
                            }
                            fArr8[length4] = codedInputByteBufferNano.readFloat();
                            this.gpuTemperature = fArr8;
                            break;
                        case 74:
                            int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                            int i7 = readRawVarint323 / 4;
                            float[] fArr9 = this.batteryTemperature;
                            int length5 = fArr9 == null ? 0 : fArr9.length;
                            int i8 = i7 + length5;
                            float[] fArr10 = new float[i8];
                            if (length5 != 0) {
                                System.arraycopy(fArr9, 0, fArr10, 0, length5);
                            }
                            while (length5 < i8) {
                                fArr10[length5] = codedInputByteBufferNano.readFloat();
                                length5++;
                            }
                            this.batteryTemperature = fArr10;
                            codedInputByteBufferNano.popLimit(pushLimit3);
                            break;
                        case 77:
                            int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 77);
                            float[] fArr11 = this.batteryTemperature;
                            int length6 = fArr11 == null ? 0 : fArr11.length;
                            int i9 = repeatedFieldArrayLength3 + length6;
                            float[] fArr12 = new float[i9];
                            if (length6 != 0) {
                                System.arraycopy(fArr11, 0, fArr12, 0, length6);
                            }
                            while (length6 < i9 - 1) {
                                fArr12[length6] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length6++;
                            }
                            fArr12[length6] = codedInputByteBufferNano.readFloat();
                            this.batteryTemperature = fArr12;
                            break;
                        default:
                            if (TimeSeriesData.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.intervalStartTimeSeconds;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Float f = this.skinTemperature;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(2, f.floatValue());
                }
                Integer num2 = this.edsThreadFrameDropCount;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                Integer num3 = this.batteryLevel;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num3.intValue());
                }
                Integer num4 = this.batteryLevelDelta;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num4.intValue());
                }
                Integer num5 = this.thermalWarningsShown;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(6, num5.intValue());
                }
                float[] fArr = this.cpuTemperature;
                int i = 0;
                if (fArr != null && fArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        float[] fArr2 = this.cpuTemperature;
                        if (i2 >= fArr2.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloat(7, fArr2[i2]);
                        i2++;
                    }
                }
                float[] fArr3 = this.gpuTemperature;
                if (fArr3 != null && fArr3.length > 0) {
                    int i3 = 0;
                    while (true) {
                        float[] fArr4 = this.gpuTemperature;
                        if (i3 >= fArr4.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloat(8, fArr4[i3]);
                        i3++;
                    }
                }
                float[] fArr5 = this.batteryTemperature;
                if (fArr5 != null && fArr5.length > 0) {
                    while (true) {
                        float[] fArr6 = this.batteryTemperature;
                        if (i >= fArr6.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloat(9, fArr6[i]);
                        i++;
                    }
                }
                TimeSeriesData.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final TimeIntervalData clone() {
                try {
                    TimeIntervalData clone = TimeSeriesData.super.clone();
                    float[] fArr = this.cpuTemperature;
                    if (fArr != null && fArr.length > 0) {
                        clone.cpuTemperature = (float[]) fArr.clone();
                    }
                    float[] fArr2 = this.gpuTemperature;
                    if (fArr2 != null && fArr2.length > 0) {
                        clone.gpuTemperature = (float[]) fArr2.clone();
                    }
                    float[] fArr3 = this.batteryTemperature;
                    if (fArr3 != null && fArr3.length > 0) {
                        clone.batteryTemperature = (float[]) fArr3.clone();
                    }
                    return clone;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final TimeSeriesData clone() {
            try {
                TimeSeriesData clone = Vr$VREvent.super.clone();
                TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
                if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                    clone.timeIntervalData = new TimeIntervalData[timeIntervalDataArr.length];
                    int i = 0;
                    while (true) {
                        TimeIntervalData[] timeIntervalDataArr2 = this.timeIntervalData;
                        if (i >= timeIntervalDataArr2.length) {
                            break;
                        }
                        if (timeIntervalDataArr2[i] != null) {
                            clone.timeIntervalData[i] = timeIntervalDataArr2[i].clone();
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
    public final class VrStreaming extends ExtendableMessageNano<VrStreaming> implements Cloneable {
        private Frame[] frame = Frame.emptyArray();
        private SessionInfo sessionInfo = null;

        public VrStreaming() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            SessionInfo sessionInfo2 = this.sessionInfo;
            if (sessionInfo2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sessionInfo2);
            }
            Frame[] frameArr = this.frame;
            if (frameArr != null && frameArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frame;
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

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.sessionInfo == null) {
                        this.sessionInfo = new SessionInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.sessionInfo);
                } else if (readTag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    Frame[] frameArr = this.frame;
                    int length = frameArr == null ? 0 : frameArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new Frame[i];
                    if (length != 0) {
                        System.arraycopy(frameArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new Frame();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new Frame();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.frame = messageNanoArr;
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            SessionInfo sessionInfo2 = this.sessionInfo;
            if (sessionInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(1, sessionInfo2);
            }
            Frame[] frameArr = this.frame;
            if (frameArr != null && frameArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frame;
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
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        public final class Frame extends ExtendableMessageNano<Frame> implements Cloneable {
            private static volatile Frame[] _emptyArray;
            private Long decodeEndTimeUsec = null;
            private Long decodeStartTimeUsec = null;
            private Long framePresentTimeUsec = null;
            private Integer poseId = null;
            private Long poseSendTimeUsec = null;

            public Frame() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static Frame[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Frame[0];
                        }
                    }
                }
                return _emptyArray;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrStreaming.super.computeSerializedSize();
                Integer num = this.poseId;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.poseSendTimeUsec;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, l.longValue());
                }
                Long l2 = this.framePresentTimeUsec;
                if (l2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, l2.longValue());
                }
                Long l3 = this.decodeStartTimeUsec;
                if (l3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, l3.longValue());
                }
                Long l4 = this.decodeEndTimeUsec;
                return l4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, l4.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.poseId = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.poseSendTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    } else if (readTag == 24) {
                        this.framePresentTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    } else if (readTag == 32) {
                        this.decodeStartTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    } else if (readTag == 40) {
                        this.decodeEndTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    } else if (!VrStreaming.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.poseId;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.poseSendTimeUsec;
                if (l != null) {
                    codedOutputByteBufferNano.writeUInt64(2, l.longValue());
                }
                Long l2 = this.framePresentTimeUsec;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeUInt64(3, l2.longValue());
                }
                Long l3 = this.decodeStartTimeUsec;
                if (l3 != null) {
                    codedOutputByteBufferNano.writeUInt64(4, l3.longValue());
                }
                Long l4 = this.decodeEndTimeUsec;
                if (l4 != null) {
                    codedOutputByteBufferNano.writeUInt64(5, l4.longValue());
                }
                VrStreaming.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final Frame clone() {
                try {
                    return VrStreaming.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        public final class SessionInfo extends ExtendableMessageNano<SessionInfo> implements Cloneable {
            private String sessionId = null;

            public SessionInfo() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            /* access modifiers changed from: protected */
            public final int computeSerializedSize() {
                int computeSerializedSize = VrStreaming.super.computeSerializedSize();
                String str = this.sessionId;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.sessionId = codedInputByteBufferNano.readString();
                    } else if (!VrStreaming.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.sessionId;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                VrStreaming.super.writeTo(codedOutputByteBufferNano);
            }

            @Override // java.lang.Object
            public final SessionInfo clone() {
                try {
                    return VrStreaming.super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // java.lang.Object
        public final VrStreaming clone() {
            try {
                VrStreaming clone = Vr$VREvent.super.clone();
                SessionInfo sessionInfo2 = this.sessionInfo;
                if (sessionInfo2 != null) {
                    clone.sessionInfo = sessionInfo2.clone();
                }
                Frame[] frameArr = this.frame;
                if (frameArr != null && frameArr.length > 0) {
                    clone.frame = new Frame[frameArr.length];
                    int i = 0;
                    while (true) {
                        Frame[] frameArr2 = this.frame;
                        if (i >= frameArr2.length) {
                            break;
                        }
                        if (frameArr2[i] != null) {
                            clone.frame[i] = frameArr2[i].clone();
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
    public final class Application extends ExtendableMessageNano<Application> implements Cloneable {
        private static volatile Application[] _emptyArray;
        private String name = null;
        private String packageName = null;
        private String version = null;

        public Application() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public static Application[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Application[0];
                    }
                }
            }
            return _emptyArray;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            String str = this.packageName;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.name;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            String str3 = this.version;
            return str3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, str3) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.packageName = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag == 26) {
                    this.version = codedInputByteBufferNano.readString();
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.packageName;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.name;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            String str3 = this.version;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(3, str3);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final Application clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class AudioStats extends ExtendableMessageNano<AudioStats> implements Cloneable {
        private HistogramBucket[] cpuMeasurementsPercent = HistogramBucket.emptyArray();
        private Integer framesPerBuffer = null;
        private HistogramBucket[] numberOfSimultaneousSoundFields = HistogramBucket.emptyArray();
        private HistogramBucket[] numberOfSimultaneousSoundObjects = HistogramBucket.emptyArray();
        private Integer renderingMode = null;
        private HistogramBucket[] renderingTimePerBufferMilliseconds = HistogramBucket.emptyArray();
        private Integer sampleRate = null;

        public AudioStats() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.renderingMode;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.sampleRate;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
            }
            Integer num3 = this.framesPerBuffer;
            if (num3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.renderingTimePerBufferMilliseconds;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, messageNano);
                    }
                    i2++;
                }
            }
            HistogramBucket[] histogramBucketArr2 = this.numberOfSimultaneousSoundObjects;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.numberOfSimultaneousSoundObjects;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundFields;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.numberOfSimultaneousSoundFields;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.cpuMeasurementsPercent;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr4 = this.cpuMeasurementsPercent;
                    if (i >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i];
                    if (messageNano4 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, messageNano4);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                        this.renderingMode = Integer.valueOf(readInt32);
                    } else {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    }
                } else if (readTag == 16) {
                    this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 24) {
                    this.framesPerBuffer = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
                    int length = histogramBucketArr == null ? 0 : histogramBucketArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new HistogramBucket[i];
                    if (length != 0) {
                        System.arraycopy(histogramBucketArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.renderingTimePerBufferMilliseconds = messageNanoArr;
                } else if (readTag == 42) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    HistogramBucket[] histogramBucketArr2 = this.numberOfSimultaneousSoundObjects;
                    int length2 = histogramBucketArr2 == null ? 0 : histogramBucketArr2.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    MessageNano[] messageNanoArr2 = new HistogramBucket[i2];
                    if (length2 != 0) {
                        System.arraycopy(histogramBucketArr2, 0, messageNanoArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        messageNanoArr2[length2] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    messageNanoArr2[length2] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                    this.numberOfSimultaneousSoundObjects = messageNanoArr2;
                } else if (readTag == 50) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundFields;
                    int length3 = histogramBucketArr3 == null ? 0 : histogramBucketArr3.length;
                    int i3 = repeatedFieldArrayLength3 + length3;
                    MessageNano[] messageNanoArr3 = new HistogramBucket[i3];
                    if (length3 != 0) {
                        System.arraycopy(histogramBucketArr3, 0, messageNanoArr3, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        messageNanoArr3[length3] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    messageNanoArr3[length3] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                    this.numberOfSimultaneousSoundFields = messageNanoArr3;
                } else if (readTag == 58) {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    HistogramBucket[] histogramBucketArr4 = this.cpuMeasurementsPercent;
                    int length4 = histogramBucketArr4 == null ? 0 : histogramBucketArr4.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    MessageNano[] messageNanoArr4 = new HistogramBucket[i4];
                    if (length4 != 0) {
                        System.arraycopy(histogramBucketArr4, 0, messageNanoArr4, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        messageNanoArr4[length4] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    messageNanoArr4[length4] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                    this.cpuMeasurementsPercent = messageNanoArr4;
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.renderingMode;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.sampleRate;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            Integer num3 = this.framesPerBuffer;
            if (num3 != null) {
                codedOutputByteBufferNano.writeInt32(3, num3.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.renderingTimePerBufferMilliseconds;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(4, messageNano);
                    }
                    i2++;
                }
            }
            HistogramBucket[] histogramBucketArr2 = this.numberOfSimultaneousSoundObjects;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.numberOfSimultaneousSoundObjects;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundFields;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.numberOfSimultaneousSoundFields;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        codedOutputByteBufferNano.writeMessage(6, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.cpuMeasurementsPercent;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr4 = this.cpuMeasurementsPercent;
                    if (i >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i];
                    if (messageNano4 != null) {
                        codedOutputByteBufferNano.writeMessage(7, messageNano4);
                    }
                    i++;
                }
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final AudioStats clone() {
            try {
                AudioStats clone = Vr$VREvent.super.clone();
                HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
                int i = 0;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    clone.renderingTimePerBufferMilliseconds = new HistogramBucket[histogramBucketArr.length];
                    int i2 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.renderingTimePerBufferMilliseconds;
                        if (i2 >= histogramBucketArr2.length) {
                            break;
                        }
                        if (histogramBucketArr2[i2] != null) {
                            clone.renderingTimePerBufferMilliseconds[i2] = histogramBucketArr2[i2].clone();
                        }
                        i2++;
                    }
                }
                HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundObjects;
                if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                    clone.numberOfSimultaneousSoundObjects = new HistogramBucket[histogramBucketArr3.length];
                    int i3 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr4 = this.numberOfSimultaneousSoundObjects;
                        if (i3 >= histogramBucketArr4.length) {
                            break;
                        }
                        if (histogramBucketArr4[i3] != null) {
                            clone.numberOfSimultaneousSoundObjects[i3] = histogramBucketArr4[i3].clone();
                        }
                        i3++;
                    }
                }
                HistogramBucket[] histogramBucketArr5 = this.numberOfSimultaneousSoundFields;
                if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                    clone.numberOfSimultaneousSoundFields = new HistogramBucket[histogramBucketArr5.length];
                    int i4 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr6 = this.numberOfSimultaneousSoundFields;
                        if (i4 >= histogramBucketArr6.length) {
                            break;
                        }
                        if (histogramBucketArr6[i4] != null) {
                            clone.numberOfSimultaneousSoundFields[i4] = histogramBucketArr6[i4].clone();
                        }
                        i4++;
                    }
                }
                HistogramBucket[] histogramBucketArr7 = this.cpuMeasurementsPercent;
                if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                    clone.cpuMeasurementsPercent = new HistogramBucket[histogramBucketArr7.length];
                    while (true) {
                        HistogramBucket[] histogramBucketArr8 = this.cpuMeasurementsPercent;
                        if (i >= histogramBucketArr8.length) {
                            break;
                        }
                        if (histogramBucketArr8[i] != null) {
                            clone.cpuMeasurementsPercent[i] = histogramBucketArr8[i].clone();
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
    public final class DoublePrecisionTransform extends ExtendableMessageNano<DoublePrecisionTransform> implements Cloneable {
        private Double rotationQx = null;
        private Double rotationQy = null;
        private Double rotationQz = null;
        private Double scale = null;
        private Double translationX = null;
        private Double translationY = null;
        private Double translationZ = null;

        public DoublePrecisionTransform() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Double d = this.translationX;
            if (d != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, d.doubleValue());
            }
            Double d2 = this.translationY;
            if (d2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, d2.doubleValue());
            }
            Double d3 = this.translationZ;
            if (d3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, d3.doubleValue());
            }
            Double d4 = this.rotationQx;
            if (d4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(4, d4.doubleValue());
            }
            Double d5 = this.rotationQy;
            if (d5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(5, d5.doubleValue());
            }
            Double d6 = this.rotationQz;
            if (d6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, d6.doubleValue());
            }
            Double d7 = this.scale;
            return d7 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(7, d7.doubleValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 9) {
                    this.translationX = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 17) {
                    this.translationY = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 25) {
                    this.translationZ = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 33) {
                    this.rotationQx = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 41) {
                    this.rotationQy = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 49) {
                    this.rotationQz = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 57) {
                    this.scale = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Double d = this.translationX;
            if (d != null) {
                codedOutputByteBufferNano.writeDouble(1, d.doubleValue());
            }
            Double d2 = this.translationY;
            if (d2 != null) {
                codedOutputByteBufferNano.writeDouble(2, d2.doubleValue());
            }
            Double d3 = this.translationZ;
            if (d3 != null) {
                codedOutputByteBufferNano.writeDouble(3, d3.doubleValue());
            }
            Double d4 = this.rotationQx;
            if (d4 != null) {
                codedOutputByteBufferNano.writeDouble(4, d4.doubleValue());
            }
            Double d5 = this.rotationQy;
            if (d5 != null) {
                codedOutputByteBufferNano.writeDouble(5, d5.doubleValue());
            }
            Double d6 = this.rotationQz;
            if (d6 != null) {
                codedOutputByteBufferNano.writeDouble(6, d6.doubleValue());
            }
            Double d7 = this.scale;
            if (d7 != null) {
                codedOutputByteBufferNano.writeDouble(7, d7.doubleValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final DoublePrecisionTransform clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class Expeditions extends ExtendableMessageNano<Expeditions> implements Cloneable {
        private String contentId = null;

        public Expeditions() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            String str = this.contentId;
            return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.contentId = codedInputByteBufferNano.readString();
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.contentId;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final Expeditions clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class HeadMount extends ExtendableMessageNano<HeadMount> implements Cloneable {
        private String model = null;
        private String vendor = null;

        public HeadMount() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            String str = this.vendor;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.model;
            return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str2) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.vendor = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.model = codedInputByteBufferNano.readString();
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.vendor;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.model;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final HeadMount clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class HeadTracking extends ExtendableMessageNano<HeadTracking> implements Cloneable {
        private Float floorHeight = null;
        private Long headTrackingTimestamp = null;
        private Integer sixDofFallbackReason = null;
        private Long sixDofFallbackTimestamp = null;

        public HeadTracking() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.sixDofFallbackReason;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Long l = this.sixDofFallbackTimestamp;
            if (l != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
            }
            Float f = this.floorHeight;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, f.floatValue());
            }
            Long l2 = this.headTrackingTimestamp;
            return l2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, l2.longValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.sixDofFallbackReason = Integer.valueOf(readInt32);
                            continue;
                        default:
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            continue;
                    }
                } else if (readTag == 16) {
                    this.sixDofFallbackTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                } else if (readTag == 29) {
                    this.floorHeight = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 32) {
                    this.headTrackingTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.sixDofFallbackReason;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Long l = this.sixDofFallbackTimestamp;
            if (l != null) {
                codedOutputByteBufferNano.writeInt64(2, l.longValue());
            }
            Float f = this.floorHeight;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(3, f.floatValue());
            }
            Long l2 = this.headTrackingTimestamp;
            if (l2 != null) {
                codedOutputByteBufferNano.writeInt64(4, l2.longValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final HeadTracking clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class HistogramBucket extends ExtendableMessageNano<HistogramBucket> implements Cloneable {
        private static volatile HistogramBucket[] _emptyArray;
        private Integer count = null;
        private Integer minimumValue = null;

        public HistogramBucket() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public static HistogramBucket[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new HistogramBucket[0];
                    }
                }
            }
            return _emptyArray;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.minimumValue;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.count;
            return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.minimumValue = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 16) {
                    this.count = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.minimumValue;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.count;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final HistogramBucket clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class Launcher extends ExtendableMessageNano<Launcher> implements Cloneable {
        private Integer navItem = null;

        public Launcher() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.navItem;
            return num != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, num.intValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 6 || readInt32 == 7 || readInt32 == 8) {
                        this.navItem = Integer.valueOf(readInt32);
                    } else {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    }
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.navItem;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final Launcher clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class PerformanceStats extends ExtendableMessageNano<PerformanceStats> implements Cloneable {
        private HistogramBucket[] appRenderTime = HistogramBucket.emptyArray();
        private Float averageAppFps = null;
        private Integer averageFps = null;
        private float[] batteryShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] batteryThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private HistogramBucket[] consecutiveDroppedFrames = HistogramBucket.emptyArray();
        private float[] cpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] cpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private Float edsFps = null;
        private HistogramBucket[] frameTime = HistogramBucket.emptyArray();
        private float[] gpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] gpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private Integer memoryConsumptionKilobytes = null;
        private HistogramBucket[] postFrameTime = HistogramBucket.emptyArray();
        private HistogramBucket[] presentTime = HistogramBucket.emptyArray();
        private HistogramBucket[] scanlineRacingVsyncOvershootUs = HistogramBucket.emptyArray();
        private Float shutdownSkinTemperatureCelsius = null;
        private Integer thermalEventFlags = null;
        private Float throttleSkinTemperatureCelsius = null;
        private TimeSeriesData timeSeriesData = null;
        private HistogramBucket[] totalRenderTime = HistogramBucket.emptyArray();
        private Float vrMaxSkinTemperatureCelsius = null;

        public PerformanceStats() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.averageFps;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.frameTime;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frameTime;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, messageNano);
                    }
                    i2++;
                }
            }
            Integer num2 = this.memoryConsumptionKilobytes;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
            }
            Float f = this.throttleSkinTemperatureCelsius;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, f.floatValue());
            }
            Float f2 = this.vrMaxSkinTemperatureCelsius;
            if (f2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, f2.floatValue());
            }
            Float f3 = this.shutdownSkinTemperatureCelsius;
            if (f3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, f3.floatValue());
            }
            TimeSeriesData timeSeriesData2 = this.timeSeriesData;
            if (timeSeriesData2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, timeSeriesData2);
            }
            HistogramBucket[] histogramBucketArr2 = this.appRenderTime;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.appRenderTime;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.presentTime;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.presentTime;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.totalRenderTime;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                int i5 = 0;
                while (true) {
                    MessageNano[] messageNanoArr4 = this.totalRenderTime;
                    if (i5 >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i5];
                    if (messageNano4 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, messageNano4);
                    }
                    i5++;
                }
            }
            HistogramBucket[] histogramBucketArr5 = this.postFrameTime;
            if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                int i6 = 0;
                while (true) {
                    MessageNano[] messageNanoArr5 = this.postFrameTime;
                    if (i6 >= messageNanoArr5.length) {
                        break;
                    }
                    MessageNano messageNano5 = messageNanoArr5[i6];
                    if (messageNano5 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, messageNano5);
                    }
                    i6++;
                }
            }
            HistogramBucket[] histogramBucketArr6 = this.consecutiveDroppedFrames;
            if (histogramBucketArr6 != null && histogramBucketArr6.length > 0) {
                int i7 = 0;
                while (true) {
                    MessageNano[] messageNanoArr6 = this.consecutiveDroppedFrames;
                    if (i7 >= messageNanoArr6.length) {
                        break;
                    }
                    MessageNano messageNano6 = messageNanoArr6[i7];
                    if (messageNano6 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, messageNano6);
                    }
                    i7++;
                }
            }
            HistogramBucket[] histogramBucketArr7 = this.scanlineRacingVsyncOvershootUs;
            if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr7 = this.scanlineRacingVsyncOvershootUs;
                    if (i >= messageNanoArr7.length) {
                        break;
                    }
                    MessageNano messageNano7 = messageNanoArr7[i];
                    if (messageNano7 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, messageNano7);
                    }
                    i++;
                }
            }
            Integer num3 = this.thermalEventFlags;
            if (num3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, num3.intValue());
            }
            float[] fArr = this.cpuThrottlingTemperature;
            if (fArr != null && fArr.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr.length * 4) + (fArr.length * 1);
            }
            float[] fArr2 = this.gpuThrottlingTemperature;
            if (fArr2 != null && fArr2.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr2.length * 4) + (fArr2.length * 2);
            }
            float[] fArr3 = this.batteryThrottlingTemperature;
            if (fArr3 != null && fArr3.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr3.length * 4) + (fArr3.length * 2);
            }
            float[] fArr4 = this.cpuShutdownTemperature;
            if (fArr4 != null && fArr4.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr4.length * 4) + (fArr4.length * 2);
            }
            float[] fArr5 = this.gpuShutdownTemperature;
            if (fArr5 != null && fArr5.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr5.length * 4) + (fArr5.length * 2);
            }
            float[] fArr6 = this.batteryShutdownTemperature;
            if (fArr6 != null && fArr6.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr6.length * 4) + (fArr6.length * 2);
            }
            Float f4 = this.averageAppFps;
            if (f4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(21, f4.floatValue());
            }
            Float f5 = this.edsFps;
            return f5 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(22, f5.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        this.averageFps = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        HistogramBucket[] histogramBucketArr = this.frameTime;
                        int length = histogramBucketArr == null ? 0 : histogramBucketArr.length;
                        int i = repeatedFieldArrayLength + length;
                        MessageNano[] messageNanoArr = new HistogramBucket[i];
                        if (length != 0) {
                            System.arraycopy(histogramBucketArr, 0, messageNanoArr, 0, length);
                        }
                        while (length < i - 1) {
                            messageNanoArr[length] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        messageNanoArr[length] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        this.frameTime = messageNanoArr;
                        break;
                    case 24:
                        this.memoryConsumptionKilobytes = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 37:
                        this.throttleSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case 45:
                        this.vrMaxSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case 53:
                        this.shutdownSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case 58:
                        if (this.timeSeriesData == null) {
                            this.timeSeriesData = new TimeSeriesData();
                        }
                        codedInputByteBufferNano.readMessage(this.timeSeriesData);
                        break;
                    case 66:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        HistogramBucket[] histogramBucketArr2 = this.appRenderTime;
                        int length2 = histogramBucketArr2 == null ? 0 : histogramBucketArr2.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        MessageNano[] messageNanoArr2 = new HistogramBucket[i2];
                        if (length2 != 0) {
                            System.arraycopy(histogramBucketArr2, 0, messageNanoArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            messageNanoArr2[length2] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        messageNanoArr2[length2] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                        this.appRenderTime = messageNanoArr2;
                        break;
                    case 74:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        HistogramBucket[] histogramBucketArr3 = this.presentTime;
                        int length3 = histogramBucketArr3 == null ? 0 : histogramBucketArr3.length;
                        int i3 = repeatedFieldArrayLength3 + length3;
                        MessageNano[] messageNanoArr3 = new HistogramBucket[i3];
                        if (length3 != 0) {
                            System.arraycopy(histogramBucketArr3, 0, messageNanoArr3, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            messageNanoArr3[length3] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        messageNanoArr3[length3] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                        this.presentTime = messageNanoArr3;
                        break;
                    case 82:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        HistogramBucket[] histogramBucketArr4 = this.totalRenderTime;
                        int length4 = histogramBucketArr4 == null ? 0 : histogramBucketArr4.length;
                        int i4 = repeatedFieldArrayLength4 + length4;
                        MessageNano[] messageNanoArr4 = new HistogramBucket[i4];
                        if (length4 != 0) {
                            System.arraycopy(histogramBucketArr4, 0, messageNanoArr4, 0, length4);
                        }
                        while (length4 < i4 - 1) {
                            messageNanoArr4[length4] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        messageNanoArr4[length4] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                        this.totalRenderTime = messageNanoArr4;
                        break;
                    case 90:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        HistogramBucket[] histogramBucketArr5 = this.postFrameTime;
                        int length5 = histogramBucketArr5 == null ? 0 : histogramBucketArr5.length;
                        int i5 = repeatedFieldArrayLength5 + length5;
                        MessageNano[] messageNanoArr5 = new HistogramBucket[i5];
                        if (length5 != 0) {
                            System.arraycopy(histogramBucketArr5, 0, messageNanoArr5, 0, length5);
                        }
                        while (length5 < i5 - 1) {
                            messageNanoArr5[length5] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr5[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        messageNanoArr5[length5] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr5[length5]);
                        this.postFrameTime = messageNanoArr5;
                        break;
                    case 98:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                        HistogramBucket[] histogramBucketArr6 = this.consecutiveDroppedFrames;
                        int length6 = histogramBucketArr6 == null ? 0 : histogramBucketArr6.length;
                        int i6 = repeatedFieldArrayLength6 + length6;
                        MessageNano[] messageNanoArr6 = new HistogramBucket[i6];
                        if (length6 != 0) {
                            System.arraycopy(histogramBucketArr6, 0, messageNanoArr6, 0, length6);
                        }
                        while (length6 < i6 - 1) {
                            messageNanoArr6[length6] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr6[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        messageNanoArr6[length6] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr6[length6]);
                        this.consecutiveDroppedFrames = messageNanoArr6;
                        break;
                    case 106:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        HistogramBucket[] histogramBucketArr7 = this.scanlineRacingVsyncOvershootUs;
                        int length7 = histogramBucketArr7 == null ? 0 : histogramBucketArr7.length;
                        int i7 = repeatedFieldArrayLength7 + length7;
                        MessageNano[] messageNanoArr7 = new HistogramBucket[i7];
                        if (length7 != 0) {
                            System.arraycopy(histogramBucketArr7, 0, messageNanoArr7, 0, length7);
                        }
                        while (length7 < i7 - 1) {
                            messageNanoArr7[length7] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr7[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        messageNanoArr7[length7] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr7[length7]);
                        this.scanlineRacingVsyncOvershootUs = messageNanoArr7;
                        break;
                    case 112:
                        this.thermalEventFlags = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 122:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i8 = readRawVarint32 / 4;
                        float[] fArr = this.cpuThrottlingTemperature;
                        int length8 = fArr == null ? 0 : fArr.length;
                        int i9 = i8 + length8;
                        float[] fArr2 = new float[i9];
                        if (length8 != 0) {
                            System.arraycopy(fArr, 0, fArr2, 0, length8);
                        }
                        while (length8 < i9) {
                            fArr2[length8] = codedInputByteBufferNano.readFloat();
                            length8++;
                        }
                        this.cpuThrottlingTemperature = fArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        break;
                    case 125:
                        int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 125);
                        float[] fArr3 = this.cpuThrottlingTemperature;
                        int length9 = fArr3 == null ? 0 : fArr3.length;
                        int i10 = repeatedFieldArrayLength8 + length9;
                        float[] fArr4 = new float[i10];
                        if (length9 != 0) {
                            System.arraycopy(fArr3, 0, fArr4, 0, length9);
                        }
                        while (length9 < i10 - 1) {
                            fArr4[length9] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length9++;
                        }
                        fArr4[length9] = codedInputByteBufferNano.readFloat();
                        this.cpuThrottlingTemperature = fArr4;
                        break;
                    case 130:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i11 = readRawVarint322 / 4;
                        float[] fArr5 = this.gpuThrottlingTemperature;
                        int length10 = fArr5 == null ? 0 : fArr5.length;
                        int i12 = i11 + length10;
                        float[] fArr6 = new float[i12];
                        if (length10 != 0) {
                            System.arraycopy(fArr5, 0, fArr6, 0, length10);
                        }
                        while (length10 < i12) {
                            fArr6[length10] = codedInputByteBufferNano.readFloat();
                            length10++;
                        }
                        this.gpuThrottlingTemperature = fArr6;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        break;
                    case 133:
                        int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 133);
                        float[] fArr7 = this.gpuThrottlingTemperature;
                        int length11 = fArr7 == null ? 0 : fArr7.length;
                        int i13 = repeatedFieldArrayLength9 + length11;
                        float[] fArr8 = new float[i13];
                        if (length11 != 0) {
                            System.arraycopy(fArr7, 0, fArr8, 0, length11);
                        }
                        while (length11 < i13 - 1) {
                            fArr8[length11] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length11++;
                        }
                        fArr8[length11] = codedInputByteBufferNano.readFloat();
                        this.gpuThrottlingTemperature = fArr8;
                        break;
                    case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR:
                        int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                        int i14 = readRawVarint323 / 4;
                        float[] fArr9 = this.batteryThrottlingTemperature;
                        int length12 = fArr9 == null ? 0 : fArr9.length;
                        int i15 = i14 + length12;
                        float[] fArr10 = new float[i15];
                        if (length12 != 0) {
                            System.arraycopy(fArr9, 0, fArr10, 0, length12);
                        }
                        while (length12 < i15) {
                            fArr10[length12] = codedInputByteBufferNano.readFloat();
                            length12++;
                        }
                        this.batteryThrottlingTemperature = fArr10;
                        codedInputByteBufferNano.popLimit(pushLimit3);
                        break;
                    case 141:
                        int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 141);
                        float[] fArr11 = this.batteryThrottlingTemperature;
                        int length13 = fArr11 == null ? 0 : fArr11.length;
                        int i16 = repeatedFieldArrayLength10 + length13;
                        float[] fArr12 = new float[i16];
                        if (length13 != 0) {
                            System.arraycopy(fArr11, 0, fArr12, 0, length13);
                        }
                        while (length13 < i16 - 1) {
                            fArr12[length13] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length13++;
                        }
                        fArr12[length13] = codedInputByteBufferNano.readFloat();
                        this.batteryThrottlingTemperature = fArr12;
                        break;
                    case 146:
                        int readRawVarint324 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint324);
                        int i17 = readRawVarint324 / 4;
                        float[] fArr13 = this.cpuShutdownTemperature;
                        int length14 = fArr13 == null ? 0 : fArr13.length;
                        int i18 = i17 + length14;
                        float[] fArr14 = new float[i18];
                        if (length14 != 0) {
                            System.arraycopy(fArr13, 0, fArr14, 0, length14);
                        }
                        while (length14 < i18) {
                            fArr14[length14] = codedInputByteBufferNano.readFloat();
                            length14++;
                        }
                        this.cpuShutdownTemperature = fArr14;
                        codedInputByteBufferNano.popLimit(pushLimit4);
                        break;
                    case 149:
                        int repeatedFieldArrayLength11 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 149);
                        float[] fArr15 = this.cpuShutdownTemperature;
                        int length15 = fArr15 == null ? 0 : fArr15.length;
                        int i19 = repeatedFieldArrayLength11 + length15;
                        float[] fArr16 = new float[i19];
                        if (length15 != 0) {
                            System.arraycopy(fArr15, 0, fArr16, 0, length15);
                        }
                        while (length15 < i19 - 1) {
                            fArr16[length15] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length15++;
                        }
                        fArr16[length15] = codedInputByteBufferNano.readFloat();
                        this.cpuShutdownTemperature = fArr16;
                        break;
                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER /*{ENCODED_INT: 154}*/:
                        int readRawVarint325 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit5 = codedInputByteBufferNano.pushLimit(readRawVarint325);
                        int i20 = readRawVarint325 / 4;
                        float[] fArr17 = this.gpuShutdownTemperature;
                        int length16 = fArr17 == null ? 0 : fArr17.length;
                        int i21 = i20 + length16;
                        float[] fArr18 = new float[i21];
                        if (length16 != 0) {
                            System.arraycopy(fArr17, 0, fArr18, 0, length16);
                        }
                        while (length16 < i21) {
                            fArr18[length16] = codedInputByteBufferNano.readFloat();
                            length16++;
                        }
                        this.gpuShutdownTemperature = fArr18;
                        codedInputByteBufferNano.popLimit(pushLimit5);
                        break;
                    case 157:
                        int repeatedFieldArrayLength12 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 157);
                        float[] fArr19 = this.gpuShutdownTemperature;
                        int length17 = fArr19 == null ? 0 : fArr19.length;
                        int i22 = repeatedFieldArrayLength12 + length17;
                        float[] fArr20 = new float[i22];
                        if (length17 != 0) {
                            System.arraycopy(fArr19, 0, fArr20, 0, length17);
                        }
                        while (length17 < i22 - 1) {
                            fArr20[length17] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length17++;
                        }
                        fArr20[length17] = codedInputByteBufferNano.readFloat();
                        this.gpuShutdownTemperature = fArr20;
                        break;
                    case 162:
                        int readRawVarint326 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit6 = codedInputByteBufferNano.pushLimit(readRawVarint326);
                        int i23 = readRawVarint326 / 4;
                        float[] fArr21 = this.batteryShutdownTemperature;
                        int length18 = fArr21 == null ? 0 : fArr21.length;
                        int i24 = i23 + length18;
                        float[] fArr22 = new float[i24];
                        if (length18 != 0) {
                            System.arraycopy(fArr21, 0, fArr22, 0, length18);
                        }
                        while (length18 < i24) {
                            fArr22[length18] = codedInputByteBufferNano.readFloat();
                            length18++;
                        }
                        this.batteryShutdownTemperature = fArr22;
                        codedInputByteBufferNano.popLimit(pushLimit6);
                        break;
                    case 165:
                        int repeatedFieldArrayLength13 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 165);
                        float[] fArr23 = this.batteryShutdownTemperature;
                        int length19 = fArr23 == null ? 0 : fArr23.length;
                        int i25 = repeatedFieldArrayLength13 + length19;
                        float[] fArr24 = new float[i25];
                        if (length19 != 0) {
                            System.arraycopy(fArr23, 0, fArr24, 0, length19);
                        }
                        while (length19 < i25 - 1) {
                            fArr24[length19] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length19++;
                        }
                        fArr24[length19] = codedInputByteBufferNano.readFloat();
                        this.batteryShutdownTemperature = fArr24;
                        break;
                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SEEK_GEAR_INDEX /*{ENCODED_INT: 173}*/:
                        this.averageAppFps = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DOWNLOAD_TIMEOUT_FACTOR /*{ENCODED_INT: 181}*/:
                        this.edsFps = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    default:
                        if (Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.averageFps;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.frameTime;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frameTime;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(2, messageNano);
                    }
                    i2++;
                }
            }
            Integer num2 = this.memoryConsumptionKilobytes;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(3, num2.intValue());
            }
            Float f = this.throttleSkinTemperatureCelsius;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(4, f.floatValue());
            }
            Float f2 = this.vrMaxSkinTemperatureCelsius;
            if (f2 != null) {
                codedOutputByteBufferNano.writeFloat(5, f2.floatValue());
            }
            Float f3 = this.shutdownSkinTemperatureCelsius;
            if (f3 != null) {
                codedOutputByteBufferNano.writeFloat(6, f3.floatValue());
            }
            TimeSeriesData timeSeriesData2 = this.timeSeriesData;
            if (timeSeriesData2 != null) {
                codedOutputByteBufferNano.writeMessage(7, timeSeriesData2);
            }
            HistogramBucket[] histogramBucketArr2 = this.appRenderTime;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.appRenderTime;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        codedOutputByteBufferNano.writeMessage(8, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.presentTime;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.presentTime;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        codedOutputByteBufferNano.writeMessage(9, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.totalRenderTime;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                int i5 = 0;
                while (true) {
                    MessageNano[] messageNanoArr4 = this.totalRenderTime;
                    if (i5 >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i5];
                    if (messageNano4 != null) {
                        codedOutputByteBufferNano.writeMessage(10, messageNano4);
                    }
                    i5++;
                }
            }
            HistogramBucket[] histogramBucketArr5 = this.postFrameTime;
            if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                int i6 = 0;
                while (true) {
                    MessageNano[] messageNanoArr5 = this.postFrameTime;
                    if (i6 >= messageNanoArr5.length) {
                        break;
                    }
                    MessageNano messageNano5 = messageNanoArr5[i6];
                    if (messageNano5 != null) {
                        codedOutputByteBufferNano.writeMessage(11, messageNano5);
                    }
                    i6++;
                }
            }
            HistogramBucket[] histogramBucketArr6 = this.consecutiveDroppedFrames;
            if (histogramBucketArr6 != null && histogramBucketArr6.length > 0) {
                int i7 = 0;
                while (true) {
                    MessageNano[] messageNanoArr6 = this.consecutiveDroppedFrames;
                    if (i7 >= messageNanoArr6.length) {
                        break;
                    }
                    MessageNano messageNano6 = messageNanoArr6[i7];
                    if (messageNano6 != null) {
                        codedOutputByteBufferNano.writeMessage(12, messageNano6);
                    }
                    i7++;
                }
            }
            HistogramBucket[] histogramBucketArr7 = this.scanlineRacingVsyncOvershootUs;
            if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                int i8 = 0;
                while (true) {
                    MessageNano[] messageNanoArr7 = this.scanlineRacingVsyncOvershootUs;
                    if (i8 >= messageNanoArr7.length) {
                        break;
                    }
                    MessageNano messageNano7 = messageNanoArr7[i8];
                    if (messageNano7 != null) {
                        codedOutputByteBufferNano.writeMessage(13, messageNano7);
                    }
                    i8++;
                }
            }
            Integer num3 = this.thermalEventFlags;
            if (num3 != null) {
                codedOutputByteBufferNano.writeInt32(14, num3.intValue());
            }
            float[] fArr = this.cpuThrottlingTemperature;
            if (fArr != null && fArr.length > 0) {
                int i9 = 0;
                while (true) {
                    float[] fArr2 = this.cpuThrottlingTemperature;
                    if (i9 >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(15, fArr2[i9]);
                    i9++;
                }
            }
            float[] fArr3 = this.gpuThrottlingTemperature;
            if (fArr3 != null && fArr3.length > 0) {
                int i10 = 0;
                while (true) {
                    float[] fArr4 = this.gpuThrottlingTemperature;
                    if (i10 >= fArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(16, fArr4[i10]);
                    i10++;
                }
            }
            float[] fArr5 = this.batteryThrottlingTemperature;
            if (fArr5 != null && fArr5.length > 0) {
                int i11 = 0;
                while (true) {
                    float[] fArr6 = this.batteryThrottlingTemperature;
                    if (i11 >= fArr6.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(17, fArr6[i11]);
                    i11++;
                }
            }
            float[] fArr7 = this.cpuShutdownTemperature;
            if (fArr7 != null && fArr7.length > 0) {
                int i12 = 0;
                while (true) {
                    float[] fArr8 = this.cpuShutdownTemperature;
                    if (i12 >= fArr8.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(18, fArr8[i12]);
                    i12++;
                }
            }
            float[] fArr9 = this.gpuShutdownTemperature;
            if (fArr9 != null && fArr9.length > 0) {
                int i13 = 0;
                while (true) {
                    float[] fArr10 = this.gpuShutdownTemperature;
                    if (i13 >= fArr10.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(19, fArr10[i13]);
                    i13++;
                }
            }
            float[] fArr11 = this.batteryShutdownTemperature;
            if (fArr11 != null && fArr11.length > 0) {
                while (true) {
                    float[] fArr12 = this.batteryShutdownTemperature;
                    if (i >= fArr12.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(20, fArr12[i]);
                    i++;
                }
            }
            Float f4 = this.averageAppFps;
            if (f4 != null) {
                codedOutputByteBufferNano.writeFloat(21, f4.floatValue());
            }
            Float f5 = this.edsFps;
            if (f5 != null) {
                codedOutputByteBufferNano.writeFloat(22, f5.floatValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final PerformanceStats clone() {
            try {
                PerformanceStats clone = Vr$VREvent.super.clone();
                HistogramBucket[] histogramBucketArr = this.frameTime;
                int i = 0;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    clone.frameTime = new HistogramBucket[histogramBucketArr.length];
                    int i2 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.frameTime;
                        if (i2 >= histogramBucketArr2.length) {
                            break;
                        }
                        if (histogramBucketArr2[i2] != null) {
                            clone.frameTime[i2] = histogramBucketArr2[i2].clone();
                        }
                        i2++;
                    }
                }
                TimeSeriesData timeSeriesData2 = this.timeSeriesData;
                if (timeSeriesData2 != null) {
                    clone.timeSeriesData = timeSeriesData2.clone();
                }
                HistogramBucket[] histogramBucketArr3 = this.appRenderTime;
                if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                    clone.appRenderTime = new HistogramBucket[histogramBucketArr3.length];
                    int i3 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr4 = this.appRenderTime;
                        if (i3 >= histogramBucketArr4.length) {
                            break;
                        }
                        if (histogramBucketArr4[i3] != null) {
                            clone.appRenderTime[i3] = histogramBucketArr4[i3].clone();
                        }
                        i3++;
                    }
                }
                HistogramBucket[] histogramBucketArr5 = this.presentTime;
                if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                    clone.presentTime = new HistogramBucket[histogramBucketArr5.length];
                    int i4 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr6 = this.presentTime;
                        if (i4 >= histogramBucketArr6.length) {
                            break;
                        }
                        if (histogramBucketArr6[i4] != null) {
                            clone.presentTime[i4] = histogramBucketArr6[i4].clone();
                        }
                        i4++;
                    }
                }
                HistogramBucket[] histogramBucketArr7 = this.totalRenderTime;
                if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                    clone.totalRenderTime = new HistogramBucket[histogramBucketArr7.length];
                    int i5 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr8 = this.totalRenderTime;
                        if (i5 >= histogramBucketArr8.length) {
                            break;
                        }
                        if (histogramBucketArr8[i5] != null) {
                            clone.totalRenderTime[i5] = histogramBucketArr8[i5].clone();
                        }
                        i5++;
                    }
                }
                HistogramBucket[] histogramBucketArr9 = this.postFrameTime;
                if (histogramBucketArr9 != null && histogramBucketArr9.length > 0) {
                    clone.postFrameTime = new HistogramBucket[histogramBucketArr9.length];
                    int i6 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr10 = this.postFrameTime;
                        if (i6 >= histogramBucketArr10.length) {
                            break;
                        }
                        if (histogramBucketArr10[i6] != null) {
                            clone.postFrameTime[i6] = histogramBucketArr10[i6].clone();
                        }
                        i6++;
                    }
                }
                HistogramBucket[] histogramBucketArr11 = this.consecutiveDroppedFrames;
                if (histogramBucketArr11 != null && histogramBucketArr11.length > 0) {
                    clone.consecutiveDroppedFrames = new HistogramBucket[histogramBucketArr11.length];
                    int i7 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr12 = this.consecutiveDroppedFrames;
                        if (i7 >= histogramBucketArr12.length) {
                            break;
                        }
                        if (histogramBucketArr12[i7] != null) {
                            clone.consecutiveDroppedFrames[i7] = histogramBucketArr12[i7].clone();
                        }
                        i7++;
                    }
                }
                HistogramBucket[] histogramBucketArr13 = this.scanlineRacingVsyncOvershootUs;
                if (histogramBucketArr13 != null && histogramBucketArr13.length > 0) {
                    clone.scanlineRacingVsyncOvershootUs = new HistogramBucket[histogramBucketArr13.length];
                    while (true) {
                        HistogramBucket[] histogramBucketArr14 = this.scanlineRacingVsyncOvershootUs;
                        if (i >= histogramBucketArr14.length) {
                            break;
                        }
                        if (histogramBucketArr14[i] != null) {
                            clone.scanlineRacingVsyncOvershootUs[i] = histogramBucketArr14[i].clone();
                        }
                        i++;
                    }
                }
                float[] fArr = this.cpuThrottlingTemperature;
                if (fArr != null && fArr.length > 0) {
                    clone.cpuThrottlingTemperature = (float[]) fArr.clone();
                }
                float[] fArr2 = this.gpuThrottlingTemperature;
                if (fArr2 != null && fArr2.length > 0) {
                    clone.gpuThrottlingTemperature = (float[]) fArr2.clone();
                }
                float[] fArr3 = this.batteryThrottlingTemperature;
                if (fArr3 != null && fArr3.length > 0) {
                    clone.batteryThrottlingTemperature = (float[]) fArr3.clone();
                }
                float[] fArr4 = this.cpuShutdownTemperature;
                if (fArr4 != null && fArr4.length > 0) {
                    clone.cpuShutdownTemperature = (float[]) fArr4.clone();
                }
                float[] fArr5 = this.gpuShutdownTemperature;
                if (fArr5 != null && fArr5.length > 0) {
                    clone.gpuShutdownTemperature = (float[]) fArr5.clone();
                }
                float[] fArr6 = this.batteryShutdownTemperature;
                if (fArr6 != null && fArr6.length > 0) {
                    clone.batteryShutdownTemperature = (float[]) fArr6.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class PhoneAlignment extends ExtendableMessageNano<PhoneAlignment> implements Cloneable {
        public Float angleDegrees = null;
        public Vector2 lensOffset = null;
        public Vector2[] touchLocations = Vector2.emptyArray();

        public PhoneAlignment() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Vector2[] vector2Arr = this.touchLocations;
            if (vector2Arr != null && vector2Arr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.touchLocations;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, messageNano);
                    }
                    i++;
                }
            }
            Vector2 vector2 = this.lensOffset;
            if (vector2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, vector2);
            }
            Float f = this.angleDegrees;
            return f != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, f.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    Vector2[] vector2Arr = this.touchLocations;
                    int length = vector2Arr == null ? 0 : vector2Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new Vector2[i];
                    if (length != 0) {
                        System.arraycopy(vector2Arr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new Vector2();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new Vector2();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.touchLocations = messageNanoArr;
                } else if (readTag == 18) {
                    if (this.lensOffset == null) {
                        this.lensOffset = new Vector2();
                    }
                    codedInputByteBufferNano.readMessage(this.lensOffset);
                } else if (readTag == 29) {
                    this.angleDegrees = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Vector2[] vector2Arr = this.touchLocations;
            if (vector2Arr != null && vector2Arr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.touchLocations;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(1, messageNano);
                    }
                    i++;
                }
            }
            Vector2 vector2 = this.lensOffset;
            if (vector2 != null) {
                codedOutputByteBufferNano.writeMessage(2, vector2);
            }
            Float f = this.angleDegrees;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(3, f.floatValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final PhoneAlignment clone() {
            try {
                PhoneAlignment clone = Vr$VREvent.super.clone();
                Vector2[] vector2Arr = this.touchLocations;
                if (vector2Arr != null && vector2Arr.length > 0) {
                    clone.touchLocations = new Vector2[vector2Arr.length];
                    int i = 0;
                    while (true) {
                        Vector2[] vector2Arr2 = this.touchLocations;
                        if (i >= vector2Arr2.length) {
                            break;
                        }
                        if (vector2Arr2[i] != null) {
                            clone.touchLocations[i] = vector2Arr2[i].clone();
                        }
                        i++;
                    }
                }
                Vector2 vector2 = this.lensOffset;
                if (vector2 != null) {
                    clone.lensOffset = vector2.clone();
                }
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class QrCodeScan extends ExtendableMessageNano<QrCodeScan> implements Cloneable {
        private String headMountConfigUrl = null;
        private Integer status = null;

        public QrCodeScan() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Integer num = this.status;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            String str = this.headMountConfigUrl;
            return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                        this.status = Integer.valueOf(readInt32);
                    } else {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    }
                } else if (readTag == 18) {
                    this.headMountConfigUrl = codedInputByteBufferNano.readString();
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.status;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            String str = this.headMountConfigUrl;
            if (str != null) {
                codedOutputByteBufferNano.writeString(2, str);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final QrCodeScan clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class Renderer extends ExtendableMessageNano<Renderer> implements Cloneable {
        private String glRenderer = null;
        private String glVendor = null;
        private String glVersion = null;

        public Renderer() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            String str = this.glVendor;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.glRenderer;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            String str3 = this.glVersion;
            return str3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, str3) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.glVendor = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.glRenderer = codedInputByteBufferNano.readString();
                } else if (readTag == 26) {
                    this.glVersion = codedInputByteBufferNano.readString();
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.glVendor;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.glRenderer;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            String str3 = this.glVersion;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(3, str3);
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final Renderer clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class Transform extends ExtendableMessageNano<Transform> implements Cloneable {
        private Float rotationQx = null;
        private Float rotationQy = null;
        private Float rotationQz = null;
        private Float scale = null;
        private Float translationX = null;
        private Float translationY = null;
        private Float translationZ = null;

        public Transform() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Float f = this.translationX;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue());
            }
            Float f2 = this.translationY;
            if (f2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f2.floatValue());
            }
            Float f3 = this.translationZ;
            if (f3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, f3.floatValue());
            }
            Float f4 = this.rotationQx;
            if (f4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, f4.floatValue());
            }
            Float f5 = this.rotationQy;
            if (f5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, f5.floatValue());
            }
            Float f6 = this.rotationQz;
            if (f6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, f6.floatValue());
            }
            Float f7 = this.scale;
            return f7 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(7, f7.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.translationX = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 21) {
                    this.translationY = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 29) {
                    this.translationZ = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 37) {
                    this.rotationQx = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 45) {
                    this.rotationQy = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 53) {
                    this.rotationQz = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 61) {
                    this.scale = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Float f = this.translationX;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(1, f.floatValue());
            }
            Float f2 = this.translationY;
            if (f2 != null) {
                codedOutputByteBufferNano.writeFloat(2, f2.floatValue());
            }
            Float f3 = this.translationZ;
            if (f3 != null) {
                codedOutputByteBufferNano.writeFloat(3, f3.floatValue());
            }
            Float f4 = this.rotationQx;
            if (f4 != null) {
                codedOutputByteBufferNano.writeFloat(4, f4.floatValue());
            }
            Float f5 = this.rotationQy;
            if (f5 != null) {
                codedOutputByteBufferNano.writeFloat(5, f5.floatValue());
            }
            Float f6 = this.rotationQz;
            if (f6 != null) {
                codedOutputByteBufferNano.writeFloat(6, f6.floatValue());
            }
            Float f7 = this.scale;
            if (f7 != null) {
                codedOutputByteBufferNano.writeFloat(7, f7.floatValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final Transform clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    public final class Vector2 extends ExtendableMessageNano<Vector2> implements Cloneable {
        private static volatile Vector2[] _emptyArray;
        public Float x = null;
        public Float y = null;

        public Vector2() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public static Vector2[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Vector2[0];
                    }
                }
            }
            return _emptyArray;
        }

        /* access modifiers changed from: protected */
        public final int computeSerializedSize() {
            int computeSerializedSize = Vr$VREvent.super.computeSerializedSize();
            Float f = this.x;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue());
            }
            Float f2 = this.y;
            return f2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(2, f2.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.x = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 21) {
                    this.y = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (!Vr$VREvent.super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Float f = this.x;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(1, f.floatValue());
            }
            Float f2 = this.y;
            if (f2 != null) {
                codedOutputByteBufferNano.writeFloat(2, f2.floatValue());
            }
            Vr$VREvent.super.writeTo(codedOutputByteBufferNano);
        }

        @Override // java.lang.Object
        public final Vector2 clone() {
            try {
                return Vr$VREvent.super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* access modifiers changed from: private */
    @Override // java.lang.Object
    public Vr$VREvent clone() {
        try {
            Vr$VREvent clone = Vr$VREvent.super.clone();
            HeadMount headMount2 = this.headMount;
            if (headMount2 != null) {
                clone.headMount = headMount2.clone();
            }
            Application application2 = this.application;
            if (application2 != null) {
                clone.application = application2.clone();
            }
            Application[] applicationArr = this.installedVrApplications;
            if (applicationArr != null && applicationArr.length > 0) {
                clone.installedVrApplications = new Application[applicationArr.length];
                int i = 0;
                while (true) {
                    Application[] applicationArr2 = this.installedVrApplications;
                    if (i >= applicationArr2.length) {
                        break;
                    }
                    if (applicationArr2[i] != null) {
                        clone.installedVrApplications[i] = applicationArr2[i].clone();
                    }
                    i++;
                }
            }
            Cyclops cyclops2 = this.cyclops;
            if (cyclops2 != null) {
                clone.cyclops = cyclops2.clone();
            }
            QrCodeScan qrCodeScan2 = this.qrCodeScan;
            if (qrCodeScan2 != null) {
                clone.qrCodeScan = qrCodeScan2.clone();
            }
            PerformanceStats performanceStats2 = this.performanceStats;
            if (performanceStats2 != null) {
                clone.performanceStats = performanceStats2.clone();
            }
            SensorStats sensorStats2 = this.sensorStats;
            if (sensorStats2 != null) {
                clone.sensorStats = sensorStats2.clone();
            }
            AudioStats audioStats2 = this.audioStats;
            if (audioStats2 != null) {
                clone.audioStats = audioStats2.clone();
            }
            EmbedVrWidget embedVrWidget2 = this.embedVrWidget;
            if (embedVrWidget2 != null) {
                clone.embedVrWidget = embedVrWidget2.clone();
            }
            VrCore vrCore2 = this.vrCore;
            if (vrCore2 != null) {
                clone.vrCore = vrCore2.clone();
            }
            EarthVr earthVr2 = this.earthVr;
            if (earthVr2 != null) {
                clone.earthVr = earthVr2.clone();
            }
            Launcher launcher2 = this.launcher;
            if (launcher2 != null) {
                clone.launcher = launcher2.clone();
            }
            Keyboard keyboard2 = this.keyboard;
            if (keyboard2 != null) {
                clone.keyboard = keyboard2.clone();
            }
            Renderer renderer2 = this.renderer;
            if (renderer2 != null) {
                clone.renderer = renderer2.clone();
            }
            Lullaby lullaby2 = this.lullaby;
            if (lullaby2 != null) {
                clone.lullaby = lullaby2.clone();
            }
            StreetView streetView2 = this.streetView;
            if (streetView2 != null) {
                clone.streetView = streetView2.clone();
            }
            Photos photos2 = this.photos;
            if (photos2 != null) {
                clone.photos = photos2.clone();
            }
            VrHome vrHome2 = this.vrHome;
            if (vrHome2 != null) {
                clone.vrHome = vrHome2.clone();
            }
            SdkConfigurationParams sdkConfigurationParams = this.sdkConfiguration;
            if (sdkConfigurationParams != null) {
                clone.sdkConfiguration = sdkConfigurationParams.clone();
            }
            GConfigUpdate gConfigUpdate2 = this.gConfigUpdate;
            if (gConfigUpdate2 != null) {
                clone.gConfigUpdate = gConfigUpdate2.clone();
            }
            JumpInspector jumpInspector2 = this.jumpInspector;
            if (jumpInspector2 != null) {
                clone.jumpInspector = jumpInspector2.clone();
            }
            PhoneAlignment phoneAlignment2 = this.phoneAlignment;
            if (phoneAlignment2 != null) {
                clone.phoneAlignment = phoneAlignment2.clone();
            }
            VrStreaming vrStreaming2 = this.vrStreaming;
            if (vrStreaming2 != null) {
                clone.vrStreaming = vrStreaming2.clone();
            }
            Expeditions expeditions2 = this.expeditions;
            if (expeditions2 != null) {
                clone.expeditions = expeditions2.clone();
            }
            HeadTracking headTracking2 = this.headTracking;
            if (headTracking2 != null) {
                clone.headTracking = headTracking2.clone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
