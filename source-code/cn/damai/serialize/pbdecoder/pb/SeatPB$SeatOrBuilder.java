package cn.damai.serialize.pbdecoder.pb;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: Taobao */
public interface SeatPB$SeatOrBuilder extends MessageLiteOrBuilder {
    double getAngle();

    String getChint();

    ByteString getChintBytes();

    String getFn();

    ByteString getFnBytes();

    long getGroupId();

    long getGroupPriceId();

    int getI();

    long getPlid();

    String getRhint();

    ByteString getRhintBytes();

    long getSid();

    int getX();

    int getY();
}
