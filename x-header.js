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
   

let OpenSignImpl = Java.use("mtopsdk.security.OpenSignImpl");
let HashMap=Java.use("java.util.HashMap")
let JString=Java.use("java.lang.String")

OpenSignImpl.getUnifiedSign.overload('java.util.HashMap', 'java.util.HashMap', 'java.lang.String', 'java.lang.String', 'boolean', 'java.lang.String').implementation = function (map1,map2,str1,str2,bool,str3) {
  return this["getUnifiedSign"](map1,map2,str1,str2,bool,str3);
};

let ins =OpenSignImpl.$new();
let map1=HashMap.$new();
let key1=JString.$new();
let buyNowBool=Java.use("java.lang.Boolean").$new("true")
map1.put("data","{\"itemId\":\"807430844100\",\"performId\":\"214954089\",\"skuParamListJson\":\"[{\\\"count\\\":3,\\\"price\\\":3000,\\\"priceId\\\":\\\"278694818\\\"}]\",\"dmChannel\":\"*@damai_android_*\",\"channel_from\":\"damai_market\",\"appType\":\"1\",\"osType\":\"2\",\"calculateTag\":\"0_0_0_1\",\"source\":\"10101\",\"version\":\"6000189\",\"comboChannel\":\"1\"}")
map1.put("deviceId","AuYZ2HlPK3wVfWlWDoEcQNpFmZw8KcjX1kg6Wqx3cJPt")
map1.put("sid","183e014e34a924f33e7fc02153b473e9")
map1.put("uid","2216157272693")
map1.put("x-features","27")
map1.put("appKey","23781390")
map1.put("api","mtop.damai.item.calcticketprice")
map1.put("mtopBusiness","true")
map1.put("utdid","Zn183wRaQFADAAU1t5yWrfw0")
map1.put("extdata","openappkey=DEFAULT_AUTH")
map1.put("ttid","10005894@damai_android_8.8.9")
map1.put("t","1719500669")
map1.put("v","2.0")
let map2=HashMap.$new();
map2.put("pageId","")
map2.put("pageName","")
let str1=JString.$new();
let str2=JString.$new();
let str3=JString.$new();
let res=ins.getUnifiedSign(map1,map2,"23781390",null,false,"r_80")
     
console.log(`OpenSignImpl.getUnifiedSign is called: hashMap=${map1} hashmap2=${map2} str=${str1} str2=${str2} z=${buyNowBool},str3=${str3}`);

console.log(res)