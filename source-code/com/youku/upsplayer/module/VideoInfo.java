package com.youku.upsplayer.module;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.util.AssertUtil;

/* compiled from: Taobao */
public class VideoInfo {
    private String ad;
    private Domain adDomain;
    private AfterVideoInfo afterVideoStream;
    private Album album;
    private AppBuyInfo app_buy_info;
    private String bResults;
    private Cloud cloud;
    private JSONArray cmafJson;
    private Controller controller;
    private String domainController;
    private Dvd dvd;
    private PlayError error;
    private Fee fee;
    private FirstSlice firstSlice;
    private Domain hlsDomain;
    private Conf[] mConfs;
    private ConnectStat mConnectStat;
    private Sei[] mSeis;
    private Master[] master;
    private Domain mp4Domain;
    private Network network;
    private Pay pay;
    private PayScene pay_scene;
    private JSONObject playExt;
    private Playlog playlog;
    private JSONObject ppStreamConfig;
    private PreVideoInfo preVideoStream;
    private Preview preview;
    private JSONObject ps_trace;
    private SceneContent scene_content;
    private Security security;
    private Show show;
    private Stream[] stream;
    private JSONArray streamJson;
    private Stream[] stream_old;
    private Subtitle[] subtitles;
    private Ticket ticket;
    private Token token;
    private Trial trial;
    private Uploader uploader;
    private Ups ups;
    private User user;
    private Video video;
    private VideoLike videolike;
    private Videos videos;
    private Vip vip;
    private VipPayInfo vip_pay_info;
    private Watermark[] watermarks;
    private String ykAd;
    private ZPdPayInfo zpd_pay_info;

    public String getAd() {
        return this.ad;
    }

    public Domain getAdDomain() {
        return this.adDomain;
    }

    public AfterVideoInfo getAfterVideoStream() {
        return this.afterVideoStream;
    }

    public Album getAlbum() {
        AssertUtil.assertUpsV1();
        return this.album;
    }

    public AppBuyInfo getApp_buy_info() {
        AssertUtil.assertUpsV1();
        return this.app_buy_info;
    }

    public String getBResult() {
        return this.bResults;
    }

    public Cloud getCloud() {
        return this.cloud;
    }

    public JSONArray getCmafJson() {
        return this.cmafJson;
    }

    public Conf getConfs(String str) {
        Conf[] confArr = this.mConfs;
        if (confArr == null || str == null) {
            return null;
        }
        for (Conf conf : confArr) {
            if (conf != null && str.equals(conf.lang)) {
                return conf;
            }
        }
        return null;
    }

    public ConnectStat getConnectStat() {
        return this.mConnectStat;
    }

    public Controller getController() {
        return this.controller;
    }

    public String getDomainController() {
        return this.domainController;
    }

    public Dvd getDvd() {
        return this.dvd;
    }

    public PlayError getError() {
        return this.error;
    }

    public Fee getFee() {
        return this.fee;
    }

    public FirstSlice getFirstSlice() {
        return this.firstSlice;
    }

    public Domain getHlsDomain() {
        return this.hlsDomain;
    }

    public Master[] getMaster() {
        return this.master;
    }

    public Domain getMp4Domain() {
        return this.mp4Domain;
    }

    public Network getNetwork() {
        AssertUtil.assertUpsV1();
        return this.network;
    }

    public Pay getPay() {
        return this.pay;
    }

    public PayScene getPay_scene() {
        return this.pay_scene;
    }

    public JSONObject getPlayExt() {
        return this.playExt;
    }

    public Playlog getPlaylog() {
        return this.playlog;
    }

    public JSONObject getPpStreamConfig() {
        return this.ppStreamConfig;
    }

    public PreVideoInfo getPreVideoStream() {
        return this.preVideoStream;
    }

    public Preview getPreview() {
        return this.preview;
    }

    public JSONObject getPs_trace() {
        return this.ps_trace;
    }

    public SceneContent getSceneContent() {
        return this.scene_content;
    }

    public Security getSecurity() {
        return this.security;
    }

    public Sei getSei(String str) {
        Sei[] seiArr = this.mSeis;
        if (seiArr == null || str == null) {
            return null;
        }
        for (Sei sei : seiArr) {
            if (sei != null && str.equals(sei.lang)) {
                return sei;
            }
        }
        return null;
    }

    public Show getShow() {
        return this.show;
    }

    public Stream[] getStream() {
        return this.stream;
    }

    public JSONArray getStreamJson() {
        return this.streamJson;
    }

    public Stream[] getStream_old() {
        return this.stream_old;
    }

    public Subtitle[] getSubtitles() {
        return this.subtitles;
    }

    public Ticket getTicket() {
        AssertUtil.assertUpsV1();
        return this.ticket;
    }

    public Token getToken() {
        AssertUtil.assertUpsV1();
        return this.token;
    }

    public Trial getTrial() {
        return this.trial;
    }

    public Uploader getUploader() {
        return this.uploader;
    }

    public Ups getUps() {
        return this.ups;
    }

    public User getUser() {
        return this.user;
    }

    public Video getVideo() {
        return this.video;
    }

    public VideoLike getVideolike() {
        return this.videolike;
    }

    public Videos getVideos() {
        AssertUtil.assertUpsV1();
        return this.videos;
    }

    public Vip getVip() {
        return this.vip;
    }

    public VipPayInfo getVip_pay_info() {
        return this.vip_pay_info;
    }

    public Watermark[] getWatermarks() {
        return this.watermarks;
    }

    public String getYkAd() {
        return this.ykAd;
    }

    public ZPdPayInfo getZpd_pay_info() {
        AssertUtil.assertUpsV1();
        return this.zpd_pay_info;
    }

    public void setAd(String str) {
        this.ad = str;
    }

    public VideoInfo setAdDomain(Domain domain) {
        this.adDomain = domain;
        return this;
    }

    public void setAfterVideoStream(AfterVideoInfo afterVideoInfo) {
        this.afterVideoStream = afterVideoInfo;
    }

    public void setAlbum(Album album2) {
        this.album = album2;
    }

    public void setApp_buy_info(AppBuyInfo appBuyInfo) {
        this.app_buy_info = appBuyInfo;
    }

    public void setBResults(String str) {
        this.bResults = str;
    }

    public void setCloud(Cloud cloud2) {
        this.cloud = cloud2;
    }

    public void setCmafJson(JSONArray jSONArray) {
        this.cmafJson = jSONArray;
    }

    public void setConfs(Conf[] confArr) {
        this.mConfs = confArr;
    }

    public void setConnectStat(ConnectStat connectStat) {
        this.mConnectStat = connectStat;
    }

    public void setController(Controller controller2) {
        this.controller = controller2;
    }

    public void setDomainController(String str) {
        this.domainController = str;
    }

    public void setDvd(Dvd dvd2) {
        this.dvd = dvd2;
    }

    public void setError(PlayError playError) {
        this.error = playError;
    }

    public void setFee(Fee fee2) {
        this.fee = fee2;
    }

    public VideoInfo setFirstSlice(FirstSlice firstSlice2) {
        this.firstSlice = firstSlice2;
        return this;
    }

    public void setHlsDomain(Domain domain) {
        this.hlsDomain = domain;
    }

    public VideoInfo setMaster(Master[] masterArr) {
        this.master = masterArr;
        return this;
    }

    public void setMp4Domain(Domain domain) {
        this.mp4Domain = domain;
    }

    public void setNetwork(Network network2) {
        this.network = network2;
    }

    public void setPay(Pay pay2) {
        this.pay = pay2;
    }

    public void setPay_scene(PayScene payScene) {
        this.pay_scene = payScene;
    }

    public void setPlayExt(JSONObject jSONObject) {
        this.playExt = jSONObject;
    }

    public void setPlaylog(Playlog playlog2) {
        this.playlog = playlog2;
    }

    public void setPpStreamConfig(JSONObject jSONObject) {
        this.ppStreamConfig = jSONObject;
    }

    public void setPreVideoStream(PreVideoInfo preVideoInfo) {
        this.preVideoStream = preVideoInfo;
    }

    public void setPreview(Preview preview2) {
        this.preview = preview2;
    }

    public void setPs_trace(JSONObject jSONObject) {
        this.ps_trace = jSONObject;
    }

    public void setSceneContent(SceneContent sceneContent) {
        this.scene_content = sceneContent;
    }

    public void setSecurity(Security security2) {
        this.security = security2;
    }

    public void setSeis(Sei[] seiArr) {
        this.mSeis = seiArr;
    }

    public void setShow(Show show2) {
        this.show = show2;
    }

    public void setStream(Stream[] streamArr) {
        this.stream = streamArr;
    }

    public void setStreamJson(JSONArray jSONArray) {
        this.streamJson = jSONArray;
    }

    public void setStream_old(Stream[] streamArr) {
        this.stream_old = streamArr;
    }

    public void setSubtitles(Subtitle[] subtitleArr) {
        this.subtitles = subtitleArr;
    }

    public void setTicket(Ticket ticket2) {
        this.ticket = ticket2;
    }

    public void setToken(Token token2) {
        this.token = token2;
    }

    public void setTrial(Trial trial2) {
        this.trial = trial2;
    }

    public void setUploader(Uploader uploader2) {
        this.uploader = uploader2;
    }

    public void setUps(Ups ups2) {
        this.ups = ups2;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public void setVideo(Video video2) {
        this.video = video2;
    }

    public void setVideolike(VideoLike videoLike) {
        this.videolike = videoLike;
    }

    public void setVideos(Videos videos2) {
        this.videos = videos2;
    }

    public void setVip(Vip vip2) {
        this.vip = vip2;
    }

    public void setVip_pay_info(VipPayInfo vipPayInfo) {
        this.vip_pay_info = vipPayInfo;
    }

    public void setWatermarks(Watermark[] watermarkArr) {
        this.watermarks = watermarkArr;
    }

    public void setYkAd(String str) {
        this.ykAd = str;
    }

    public void setZpd_pay_info(ZPdPayInfo zPdPayInfo) {
        this.zpd_pay_info = zPdPayInfo;
    }
}
