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
map1.put("buyNow",buyNowBool)
let map2=HashMap.$new();
let str1=JString.$new();
let str2=JString.$new();
let str3=JString.$new();
let res=ins.getUnifiedSign(map1,map2,str1,str2,true,str3)
     
console.log(`OpenSignImpl.getUnifiedSign is called: hashMap=${map1} hashmap2=${map2} str=${str1} str2=${str2} z=${buyNowBool},str3=${str3}`);