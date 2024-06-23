Java.perform(function () {
    //get real classloader
    //from http://www.lixiaopeng.top/article/63.html
    var application = Java.use("android.app.Application");
    var classloader;
    application.attach.overload("android.content.Context").implementation =
      function (context) {
        var result = this.attach(context); // run attach as it is
        classloader = context.getClassLoader(); // get real classloader
        Java.classFactory.loader = classloader;
        return result;
      };
  });

function HashMap2Str(params_hm) {
    var HashMap=Java.use('java.util.HashMap');
    var args_map=Java.cast(params_hm,HashMap);
    return args_map.toString();
};

const MtopRequest = Java.use("mtopsdk.mtop.domain.MtopRequest");
let myMtopRequest = MtopRequest.$new();
myMtopRequest.setApiName("mtop.trade.order.build");
//item_id + count + ski_id  716435462268_1_5005943905715
myMtopRequest.setData(
  '{"buyNow":"true","buyParam":"716435462268_1_5005943905715","exParams":"{\\"atomSplit\\":\\"1\\",\\"channel\\":\\"damai_app\\",\\"coVersion\\":\\"2.0\\",\\"coupon\\":\\"true\\",\\"seatInfo\\":\\"\\",\\"umpChannel\\":\\"10001\\",\\"websiteLanguage\\":\\"zh_CN_#Hans\\"}"}'
);
myMtopRequest.setNeedEcode(true);
myMtopRequest.setNeedSession(true);
myMtopRequest.setVersion("4.0");

//引入Java中的类
const MtopBusiness = Java.use("com.taobao.tao.remotebusiness.MtopBusiness");
const MtopBuilder = Java.use("mtopsdk.mtop.intf.MtopBuilder");
// let RemoteBusiness = Java.use("com.taobao.tao.remotebusiness.RemoteBusiness");
const MethodEnum = Java.use("mtopsdk.mtop.domain.MethodEnum");
const MtopListenerProxyFactory = Java.use(
  "com.taobao.tao.remotebusiness.listener.MtopListenerProxyFactory"
);
const System = Java.use("java.lang.System");
const ApiID = Java.use("mtopsdk.mtop.common.ApiID");
const MtopStatistics = Java.use("mtopsdk.mtop.util.MtopStatistics");
const InnerProtocolParamBuilderImpl = Java.use(
  "mtopsdk.mtop.protocol.builder.impl.InnerProtocolParamBuilderImpl"
);

// create MtopBusiness
let myMtopBusiness = MtopBusiness.build(myMtopRequest);
myMtopBusiness.useWua();
myMtopBusiness.reqMethod(MethodEnum.POST.value);
myMtopBusiness.setCustomDomain("mtop.damai.cn");
myMtopBusiness.setBizId(24);
myMtopBusiness.setErrorNotifyAfterCache(true);
myMtopBusiness.reqStartTime = System.currentTimeMillis();
myMtopBusiness.isCancelled = false;
myMtopBusiness.isCached = false;
myMtopBusiness.clazz = null;
myMtopBusiness.requestType = 0;
myMtopBusiness.requestContext = null;
myMtopBusiness.mtopCommitStatData(false);
myMtopBusiness.sendStartTime = System.currentTimeMillis();

let createListenerProxy = myMtopBusiness.$super.createListenerProxy(
  myMtopBusiness.$super.listener.value
);
let createMtopContext = myMtopBusiness.createMtopContext(createListenerProxy);
let myMtopStatistics = MtopStatistics.$new(null, null); //创建一个空的统计类
createMtopContext.stats.value = myMtopStatistics;
myMtopBusiness.$super.mtopContext.value = createMtopContext;
createMtopContext.apiId.value = ApiID.$new(null, createMtopContext);

let myMtopContext = createMtopContext;
myMtopContext.mtopRequest.value = myMtopRequest;
let myInnerProtocolParamBuilderImpl = InnerProtocolParamBuilderImpl.$new();
let res = myInnerProtocolParamBuilderImpl.buildParams(myMtopContext);
console.log(
  `myInnerProtocolParamBuilderImpl.buildParams => ${HashMap2Str(res)}`
);