(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-messageDetail-messageDetail"],{"0cba":function(t,e,i){"use strict";var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"left-message"},[i("v-uni-view",{staticClass:"avator-wrapper"},[i("v-uni-view",{staticClass:"avator"},[0==t.headStatus?i("v-uni-image",{staticClass:"img",attrs:{src:t.url}}):t._e(),1==t.headStatus?i("v-uni-image",{staticClass:"img",attrs:{src:t.config.defaultHead}}):t._e()],1)],1),i("v-uni-view",{staticClass:"bubble-wrapper"},[i("div",{staticClass:"bubble",staticStyle:{"word-wrap":"break-word !important"}},[i("v-uni-rich-text",{attrs:{nodes:t.content}}),t.image?i("v-uni-image",{staticStyle:{width:"300upx"},attrs:{src:t.image,mode:"widthFix"}}):t._e()],1),i("v-uni-view",{staticClass:"time"},[t._v(t._s(t.time))])],1)],1)},n=[];i.d(e,"a",function(){return a}),i.d(e,"b",function(){return n})},"196f":function(t,e,i){"use strict";i.r(e);var a=i("c2fb"),n=i("ca6a");for(var s in n)"default"!==s&&function(t){i.d(e,t,function(){return n[t]})}(s);i("7f55");var r=i("2877"),c=Object(r["a"])(n["default"],a["a"],a["b"],!1,null,"22587a90",null);e["default"]=c.exports},"1cbd":function(t,e,i){"use strict";i.r(e);var a=i("0cba"),n=i("d060");for(var s in n)"default"!==s&&function(t){i.d(e,t,function(){return n[t]})}(s);i("c10d");var r=i("2877"),c=Object(r["a"])(n["default"],a["a"],a["b"],!1,null,"66185164",null);e["default"]=c.exports},"1d28":function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.left-message[data-v-66185164]{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;padding-left:%?20?%}.avator-wrapper[data-v-66185164]{-webkit-box-flex:0;-webkit-flex:0 0 auto;-ms-flex:0 0 auto;flex:0 0 auto}.bubble-wrapper[data-v-66185164]{padding-left:%?30?%;-webkit-box-flex:1;-webkit-flex:1;-ms-flex:1;flex:1;padding-right:%?135?%}.bubble-wrapper .bubble[data-v-66185164]{padding:%?20?% %?20?% %?20?% %?30?%;background:#d5ebff;border-radius:%?15?%;width:%?400?%;position:relative}.bubble-wrapper .bubble[data-v-66185164]:before{position:absolute;left:%?-20?%;top:%?10?%;content:"";width:0;height:0;border-top:20px solid rgba(0,0,0,0);border-right:20px solid #d5ebff;border-bottom:20px solid rgba(0,0,0,0)}.avator[data-v-66185164]{width:%?100?%;height:%?100?%;border-radius:50%;overflow:hiideen;background:#f1f1f1}.avator .img[data-v-66185164]{width:100%;height:100%;border-radius:50%}.time[data-v-66185164]{line-height:%?50?%;color:#b7b7b7;font-size:%?24?%;text-align:right}',""])},5162:function(t,e,i){"use strict";var a=i("b0f3"),n=i.n(a);n.a},"53f3":function(t,e,i){"use strict";i.r(e);var a=i("f923"),n=i.n(a);for(var s in a)"default"!==s&&function(t){i.d(e,t,function(){return a[t]})}(s);e["default"]=n.a},"56d6":function(t,e,i){"use strict";var a=i("288e");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=a(i("bd86")),s=a(i("f499"));i("28a5");var r,c=a(i("1cbd")),o=a(i("6467")),u=a(i("196f")),f=a(i("8c86")),l=(r={components:{leftMessage:c.default,rightMessage:o.default,sendMessage:u.default,uniIcons:f.default},data:function(){return{ticket:"",message:[],pageHeight:0,windowHeight:0,toUserID:"",content:"",image:"",url:"",takeUrl:"",faceShow:!1,faceList:[{url:"../../static/face/weixiao.gif"},{url:"../../static/face/xixi.gif"},{url:"../../static/face/haha.gif"},{url:"../../static/face/keai.gif"},{url:"../../static/face/kelian.gif"},{url:"../../static/face/wabi.gif"},{url:"../../static/face/chijing.gif"},{url:"../../static/face/haixiu.gif"},{url:"../../static/face/jiyan.gif"},{url:"../../static/face/bizui.gif"},{url:"../../static/face/bishi.gif"},{url:"../../static/face/aini.gif"},{url:"../../static/face/lei.gif"},{url:"../../static/face/touxiao.gif"},{url:"../../static/face/qinqin.gif"},{url:"../../static/face/shengbing.gif"},{url:"../../static/face/taikaixin.gif"},{url:"../../static/face/baiyan.gif"},{url:"../../static/face/youhengheng.gif"},{url:"../../static/face/zuohengheng.gif"},{url:"../../static/face/xu.gif"},{url:"../../static/face/shuai.gif"},{url:"../../static/face/tu.gif"},{url:"../../static/face/haqian.gif"},{url:"../../static/face/baobao.gif"},{url:"../../static/face/nu.gif"},{url:"../../static/face/yiwen.gif"},{url:"../../static/face/chanzui.gif"},{url:"../../static/face/baibai.gif"},{url:"../../static/face/sikao.gif"},{url:"../../static/face/han.gif"},{url:"../../static/face/kun.gif"},{url:"../../static/face/shui.gif"},{url:"../../static/face/qian.gif"},{url:"../../static/face/shiwang.gif"},{url:"../../static/face/ku.gif"},{url:"../../static/face/se.gif"},{url:"../../static/face/heng.gif"},{url:"../../static/face/guzhang.gif"},{url:"../../static/face/yun.gif"},{url:"../../static/face/beishang.gif"},{url:"../../static/face/zhuakuang.gif"},{url:"../../static/face/heixian.gif"},{url:"../../static/face/yinxian.gif"},{url:"../../static/face/numa.gif"},{url:"../../static/face/shudaizi.gif"},{url:"../../static/face/fennu.gif"},{url:"../../static/face/ganmao.gif"},{url:"../../static/face/zhu.gif"},{url:"../../static/face/xiongmao.gif"},{url:"../../static/face/tuzi.gif"}]}},onReady:function(){var t=this;uni.createSelectorQuery().selectAll(".page").boundingClientRect(function(e){t.pageHeight=e[0].height,uni.pageScrollTo({scrollTop:e[0].height-t.windowHeight,duration:0})}).exec()},onLoad:function(){var t=this;uni.getSystemInfo({success:function(e){t.windowHeight=e.windowHeight}}),console.log(t.pageHeight),uni.onWindowResize(function(e){uni.pageScrollTo({scrollTop:t.pageHeight-e.size.windowHeight,duration:300})})}},(0,n.default)(r,"onLoad",function(t){this.toUserID=t.toUserID,this.checkTicket(),this.getMessageDetail(),this.updateChat()}),(0,n.default)(r,"methods",{checkTicket:function(){this.ticket=uni.getStorageSync("ticket"),""==this.ticket&&uni.navigateTo({url:"../login/login"})},getMessageDetail:function(){var t=this;uni.request({url:this.config.webUrl+"/user/getMessageDetail/",method:"GET",header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},data:{userID:this.toUserID},success:function(e){t.message=e.data.data}})},addMessageH5:function(){var t=this,e=this.content;if(-1!=this.content.indexOf("[")&&-1!=this.content.indexOf("]"))for(var i=this.takeUrl.split(","),a=0;a<i.length-1;a++){var n=e.indexOf("["),s=e.indexOf("]");e=0==n?i[a]+e.substring(s+1):e.substring(0,n)+i[a]+e.substring(s+1)}0!=this.toUserID&&(""==this.content&&""==this.image||uni.request({url:this.config.webUrl+"/user/addMessageH5/",method:"POST",data:{toUserID:this.toUserID,content:e,image:this.image},header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},success:function(e){e.data.member&&(uni.showToast({icon:"none",position:"bottom",title:"pleace upgrade"}),uni.navigateTo({url:"../upgrade/upgrade"})),t.message.push(e.data.message),t.content="",t.image="",t.url="",t.takeUrl=""}}))},getFace:function(t){t=t;var e=t.lastIndexOf("/")+1,i=t.lastIndexOf("."),a="["+t.substring(e,i)+"]";this.content=this.content+a;var n="<img src='"+t+"'>,";this.takeUrl=this.takeUrl+n},updateChat:function(){uni.createSelectorQuery().select(".chat").boundingClientRect(function(t){console.log("消息"+(0,s.default)(t)),uni.pageScrollTo({duration:0,scrollTop:t.top})}).exec()},showFace:function(){this.faceShow=!this.faceShow},closeFace:function(){this.faceShow=!1},selectImage:function(){var t=this;uni.chooseImage({count:1,sourceType:["album"],success:function(e){t.image=e.tempFilePaths[0],uni.uploadFile({url:t.config.webUrl+"/user/upload/",filePath:t.image,name:"file",header:{"Content-Type":"multipart/form-data",cookie:"ticket="+uni.getStorageSync("ticket")},success:function(i){t.url=e.tempFilePaths[0];var a=i.data,n=JSON.parse(a);t.image="",t.image=n.file}})}})}}),r);e.default=l},"5d9c":function(t,e,i){"use strict";var a=i("b392"),n=i.n(a);n.a},6282:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a={name:"send-message",data:function(){return{content:""}},methods:{sendMessage:function(t){this.$emit("sendMessage",t),this.content=""}}};e.default=a},6467:function(t,e,i){"use strict";i.r(e);var a=i("b521"),n=i("53f3");for(var s in n)"default"!==s&&function(t){i.d(e,t,function(){return n[t]})}(s);i("5d9c");var r=i("2877"),c=Object(r["a"])(n["default"],a["a"],a["b"],!1,null,"69ecc6f6",null);e["default"]=c.exports},"7b8c":function(t,e,i){var a=i("b65b");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("05590c20",a,!0,{sourceMap:!1,shadowMode:!1})},"7f55":function(t,e,i){"use strict";var a=i("7b8c"),n=i.n(a);n.a},b0f3:function(t,e,i){var a=i("c0d4");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("73638598",a,!0,{sourceMap:!1,shadowMode:!1})},b392:function(t,e,i){var a=i("fd14");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("08913a88",a,!0,{sourceMap:!1,shadowMode:!1})},b521:function(t,e,i){"use strict";var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"right-message"},[i("v-uni-view",{staticClass:"bubble-wrapper"},[i("div",{staticClass:"bubble",staticStyle:{"word-wrap":"break-word"}},[i("v-uni-rich-text",{attrs:{nodes:t.content}}),t.image?i("v-uni-image",{staticStyle:{width:"300upx"},attrs:{src:t.image,mode:"widthFix"}}):t._e()],1),i("v-uni-view",{staticClass:"time"},[t._v(t._s(t.time))])],1),i("v-uni-view",{staticClass:"avator-wrapper"},[i("v-uni-view",{staticClass:"avator"},[0==t.headStatus?i("v-uni-image",{staticClass:"img",attrs:{src:t.url}}):t._e(),1==t.headStatus?i("v-uni-image",{staticClass:"img",attrs:{src:t.config.defaultHead}}):t._e()],1)],1)],1)},n=[];i.d(e,"a",function(){return a}),i.d(e,"b",function(){return n})},b65b:function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.send-message[data-v-22587a90]{-webkit-box-sizing:border-box;box-sizing:border-box;padding:0 %?15?%;height:%?100?%;width:100%;background:#3c444c;line-height:%?100?%;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-flex-wrap:nowrap;-ms-flex-wrap:nowrap;flex-wrap:nowrap}.send-message .iconfont[data-v-22587a90]{width:%?160?%;text-align:center;line-height:%?100?%;-webkit-box-flex:0;-webkit-flex:0 0 auto;-ms-flex:0 0 auto;flex:0 0 auto;color:#fff}.send-message .input-wrapper[data-v-22587a90]{-webkit-box-flex:1;-webkit-flex:1;-ms-flex:1;flex:1;padding:%?15?%}.send-message .input-wrapper uni-input[data-v-22587a90]{-webkit-box-sizing:border-box;box-sizing:border-box;padding:0 %?15?%;width:100%;height:100%;border-radius:%?10?%;background:#fff}uni-button[data-v-22587a90]{font-size:%?30?%;background:#00acc2;color:#fff}',""])},c0d4:function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.page[data-v-4e21570d]{-webkit-box-sizing:border-box;box-sizing:border-box;width:100%;background:#f6fbff;overflow:hidden;padding-bottom:%?100?%;padding-top:%?20?%}.messagelist .message-height[data-v-4e21570d]{padding:%?30?% 0 %?130?% 0}.footer[data-v-4e21570d]{position:fixed;bottom:0;left:0;width:100%;height:%?200?%;background:#ff8457;padding:%?20?%}.face[data-v-4e21570d]{-webkit-flex-wrap:wrap;-ms-flex-wrap:wrap;flex-wrap:wrap;position:relative;bottom:%?680?%;background:#007aff;padding:%?20?%;border:%?1?% solid #bebebe;z-index:9999}.face>uni-view[data-v-4e21570d]{padding:%?5?%;background:#fff;border:%?1?% solid #f1f1f1}.content-image[data-v-4e21570d]{position:relative;bottom:%?400?%}.content-image>uni-image[data-v-4e21570d]{width:%?200?%;height:%?200?%}',""])},c10d:function(t,e,i){"use strict";var a=i("c916"),n=i.n(a);n.a},c2fb:function(t,e,i){"use strict";var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"send-message"},[i("v-uni-view",{staticClass:"input-wrapper"},[i("v-uni-input",{attrs:{type:"text","cursor-spacing":"0","adjust-position":"true"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}})],1),i("v-uni-view",{staticClass:"iconfont u-f-ajc"},[i("v-uni-button",{on:{click:function(e){e=t.$handleEvent(e),t.sendMessage(t.content)}}},[t._v("发送")])],1)],1)},n=[];i.d(e,"a",function(){return a}),i.d(e,"b",function(){return n})},c916:function(t,e,i){var a=i("1d28");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("186f5b4d",a,!0,{sourceMap:!1,shadowMode:!1})},ca6a:function(t,e,i){"use strict";i.r(e);var a=i("6282"),n=i.n(a);for(var s in a)"default"!==s&&function(t){i.d(e,t,function(){return a[t]})}(s);e["default"]=n.a},d060:function(t,e,i){"use strict";i.r(e);var a=i("f17a"),n=i.n(a);for(var s in a)"default"!==s&&function(t){i.d(e,t,function(){return a[t]})}(s);e["default"]=n.a},d3df:function(t,e,i){"use strict";var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"page"},[i("v-uni-view",{staticClass:"message-height",staticStyle:{"margin-bottom":"100upx"},attrs:{id:"chat"},on:{click:function(e){e=t.$handleEvent(e),t.closeFace(e)}}},t._l(t.message,function(e,a){return t.message.length>0?i("v-uni-view",{key:a},[e.view.flag?t._e():i("left-message",{attrs:{content:e.view.message.content,time:e.view.createDate,url:e.view.user.headLink,image:e.view.message.image,headStatus:e.view.user.headStatus}}),e.view.flag?i("right-message",{attrs:{content:e.view.message.content,time:e.view.createDate,url:e.view.user.headLink,image:e.view.message.image,headStatus:e.view.user.headStatus}}):t._e()],1):t._e()}),1),i("v-uni-view",{staticClass:"footer"},[i("v-uni-view",{staticStyle:{"padding-bottom":"10upx"}},[i("v-uni-textarea",{staticStyle:{border:"1upx solid #FFFFFF",background:"#FFFFFF",color:"#333333",height:"100upx"},attrs:{maxlength:"500"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}})],1),i("v-uni-view",{staticClass:"u-f u-f-jsb u-f-ac"},[i("v-uni-view",{staticClass:"u-f-ac"},[i("v-uni-view",{staticClass:"u-f-ac",on:{click:function(e){e=t.$handleEvent(e),t.showFace(e)}}},[i("v-uni-image",{staticStyle:{width:"64upx"},attrs:{src:"../../static/biaoqing.png",mode:"widthFix"}})],1),i("v-uni-view",{staticClass:"m-l-40 u-f-ac",on:{click:function(e){e=t.$handleEvent(e),t.selectImage(e)}}},[i("uni-icons",{attrs:{type:"image-filled",color:"#51d5d1",size:"25"}})],1)],1),i("v-uni-view",{staticClass:"u-f-ac",staticStyle:{"padding-right":"40upx"}},[i("v-uni-button",{staticStyle:{background:"#51d5d1",color:"#FFFFFF"},attrs:{size:"mini"},on:{click:function(e){e=t.$handleEvent(e),t.addMessageH5(e)}}},[t._v("发送")])],1)],1),t.faceShow?i("v-uni-view",{staticClass:"face u-f",attrs:{id:"face"}},t._l(t.faceList,function(e,a){return i("v-uni-view",{key:a},[i("v-uni-image",{staticStyle:{width:"64upx"},attrs:{src:e.url,mode:"widthFix"},on:{click:function(i){i=t.$handleEvent(i),t.getFace(e.url)}}})],1)}),1):t._e(),t.url?i("v-uni-view",{staticClass:"content-image"},[i("v-uni-image",{attrs:{src:t.url,mode:"widthFix"}})],1):t._e()],1)],1)},n=[];i.d(e,"a",function(){return a}),i.d(e,"b",function(){return n})},e34a:function(t,e,i){"use strict";i.r(e);var a=i("d3df"),n=i("eee8");for(var s in n)"default"!==s&&function(t){i.d(e,t,function(){return n[t]})}(s);i("5162");var r=i("2877"),c=Object(r["a"])(n["default"],a["a"],a["b"],!1,null,"4e21570d",null);e["default"]=c.exports},eee8:function(t,e,i){"use strict";i.r(e);var a=i("56d6"),n=i.n(a);for(var s in a)"default"!==s&&function(t){i.d(e,t,function(){return a[t]})}(s);e["default"]=n.a},f17a:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("c5f6");var a={name:"left-message",props:{content:String,time:String,url:String,image:String,headStatus:Number}};e.default=a},f923:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("c5f6");var a={name:"right-message",props:{content:String,time:String,url:String,image:String,headStatus:Number}};e.default=a},fd14:function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.right-message[data-v-69ecc6f6]{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;padding-right:%?20?%}.avator-wrapper[data-v-69ecc6f6]{-webkit-box-flex:0;-webkit-flex:0 0 auto;-ms-flex:0 0 auto;flex:0 0 auto}.bubble-wrapper[data-v-69ecc6f6]{padding-left:%?135?%;-webkit-box-flex:1;-webkit-flex:1;-ms-flex:1;flex:1;padding-right:%?30?%}.bubble-wrapper .bubble[data-v-69ecc6f6]{padding:%?20?%;background:#d5ebff;border-radius:%?15?%;position:relative;width:%?400?%}.bubble-wrapper .bubble[data-v-69ecc6f6]:before{position:absolute;right:%?-20?%;top:%?10?%;content:"";width:0;height:0;border-top:20px solid rgba(0,0,0,0);border-left:20px solid #d5ebff;border-bottom:20px solid rgba(0,0,0,0)}.avator[data-v-69ecc6f6]{width:%?100?%;height:%?100?%;border-radius:50%;overflow:hiideen;background:#f1f1f1}.avator .img[data-v-69ecc6f6]{width:100%;height:100%;border-radius:50%}.time[data-v-69ecc6f6]{line-height:%?50?%;color:#b7b7b7;font-size:%?24?%}',""])}}]);