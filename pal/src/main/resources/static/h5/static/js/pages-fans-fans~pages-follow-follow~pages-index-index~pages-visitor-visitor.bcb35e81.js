(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-fans-fans~pages-follow-follow~pages-index-index~pages-visitor-visitor"],{1176:function(t,e,i){"use strict";var n=i("288e");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=n(i("8c86")),o={props:{users:Array},data:function(){return{ticket:"",member:"",title:["升级会员，查看用户更多信息","余额不足"]}},components:{uniIcons:a.default},methods:{checkTicket:function(){this.ticket=uni.getStorageSync("ticket"),""==this.ticket&&uni.navigateTo({url:"../login/login"})},follow:function(t,e){var i=this;uni.request({url:this.config.webUrl+"/user/follow/",method:"POST",data:{followUserID:t},header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},success:function(t){i.$emit("follow",e)},fail:function(t){}})},toVideo:function(){uni.showToast({icon:"none",position:"bottom",title:this.title[1]}),uni.navigateTo({url:"../recharge/recharge"})},toGift:function(t){this.config.toUserID=t,uni.switchTab({url:"../gift/gift"})},toMessageDetail:function(t){uni.navigateTo({url:"../messageDetail/messageDetail?toUserID="+t})},toOtherHome:function(t){this.member?uni.navigateTo({url:"../otherHome/otherHome?userID="+t}):(uni.showToast({icon:"none",position:"bottom",title:this.title[0]}),uni.navigateTo({url:"../upgrade/upgrade"}))},getUserInfo:function(){var t=this;uni.request({url:this.config.webUrl+"/user/getUserInfo/",header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},method:"GET",data:{},success:function(e){t.member=e.data.member}})},setTitle:function(){var t=""==uni.getStorageSync("languageID")?3:uni.getStorageSync("languageID");1==t?this.title=["升級會員，查看用戶更多信息","余額不足"]:2==t?this.title=["升级会员，查看用户更多信息","余额不足"]:3==t?this.title=["Upgrade your membership to see more about your users","not sufficient funds"]:4==t?this.title=["회원 업그레이드, 사용자 정보 보기","잔액이 부족하다"]:5==t?this.title=["会員をアップグレードし、ユーザーの情報をチェックする","余额不足"]:6==t&&(this.title=["อัพเกรดการเป็นสมาชิกของคุณเพื่อดูข้อมูลเพิ่มเติม","ดุลไม่เพียงพอ"])}},created:function(){this.setTitle(),this.checkTicket(),this.getUserInfo()}};e.default=o},"14bd":function(t,e,i){"use strict";var n=i("ead8"),a=i.n(n);a.a},"16aa":function(t,e,i){var n=i("929c");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=i("4f06").default;a("27355b08",n,!0,{sourceMap:!1,shadowMode:!1})},4226:function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,".header[data-v-8bde7dfc]{width:100%;background:#ff8457;padding:%?10?% %?0?%;position:fixed;top:0;left:0;z-index:9999}",""])},"4d8f":function(t,e,i){"use strict";var n=i("288e");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=n(i("8c86")),o=n(i("9464")),s={data:function(){return{ticket:"",messageCount:0,title:""}},components:{uniIcons:a.default,uniBadge:o.default},methods:{checkTicket:function(){this.ticket=uni.getStorageSync("ticket"),""==this.ticket&&uni.navigateTo({url:"../login/login"})},toMessageView:function(){uni.navigateTo({url:"../message/message"})},toLanguageView:function(){uni.navigateTo({url:"../language/language"})},getMessageNumByStatus:function(){var t=this;uni.request({url:this.config.webUrl+"/user/getMessageNumByStatus/",header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},method:"GET",data:{},success:function(e){t.messageCount=e.data.count}})},setLanguage:function(){var t=""==uni.getStorageSync("languageID")?3:uni.getStorageSync("languageID");1==t?this.title="中文":2==t?this.title="繁体":3==t?this.title="English":4==t?this.title="한국어":5==t?this.title="わぶん":6==t&&(this.title="ไทย")}},created:function(){this.checkTicket(),this.getMessageNumByStatus(),this.setLanguage();setInterval(this.setLanguage,"1000")}};e.default=s},5676:function(t,e,i){"use strict";i.r(e);var n=i("abc3"),a=i("c745");for(var o in a)"default"!==o&&function(t){i.d(e,t,function(){return a[t]})}(o);i("690f");var s=i("2877"),r=Object(s["a"])(a["default"],n["a"],n["b"],!1,null,"8bde7dfc",null);e["default"]=r.exports},"690f":function(t,e,i){"use strict";var n=i("950b"),a=i.n(n);a.a},"6ac2":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"recommend"},[i("v-uni-view",{staticClass:"user-list"},t._l(t.users,function(e,n){return i("v-uni-view",{key:e,staticClass:"u-f u-f-jsb"},[i("v-uni-view",{staticClass:"u-f u-f-ac"},[i("v-uni-view",{on:{click:function(i){i=t.$handleEvent(i),t.toOtherHome(e.view.user.id)}}},[1==e.view.user.headStatus?i("v-uni-image",{staticClass:"headLink",attrs:{src:t.config.defaultHead}}):t._e(),0==e.view.user.headStatus?i("v-uni-image",{staticClass:"headLink",attrs:{src:e.view.user.headLink}}):t._e()],1),i("v-uni-view",{staticClass:"m-l-20",staticStyle:{"font-size":"35upx"}},[i("v-uni-text",[t._v(t._s(e.view.user.username))]),i("v-uni-view",{staticClass:"u-f-ac"},[i("v-uni-view",[0==e.view.user.bannedStatus?i("uni-icons",{attrs:{type:"smallcircle-filled",color:"#1AA034"}}):t._e()],1),e.view.member?i("v-uni-view",{staticClass:"m-l-20"},[1==e.view.member?i("v-uni-image",{staticClass:"vip",attrs:{src:t.config.huangguan,mode:"widthFix"}}):t._e(),2==e.view.member?i("v-uni-image",{staticClass:"vip",attrs:{src:t.config.zuanshi,mode:"widthFix"}}):t._e()],1):t._e()],1)],1)],1),i("v-uni-view",{staticClass:"u-f u-f-ac"},[i("v-uni-view",[e.view.follow?t._e():i("uni-icons",{attrs:{type:"heart-filled",color:"#ff8457",size:"28"},on:{click:function(i){i=t.$handleEvent(i),t.follow(e.view.user.id,n)}}})],1),i("v-uni-view",{staticClass:"m-l-40"},[i("uni-icons",{attrs:{type:"videocam-filled",color:"#ff8457",size:"28"},on:{click:function(e){e=t.$handleEvent(e),t.toVideo(e)}}})],1),i("v-uni-view",{staticClass:"m-l-40"},[i("uni-icons",{attrs:{type:"chat-filled",color:"#ff8457",size:"28"},on:{click:function(i){i=t.$handleEvent(i),t.toMessageDetail(e.view.user.id)}}})],1),i("v-uni-view",{staticClass:"m-l-40"},[i("uni-icons",{attrs:{type:"shop",color:"#ff8457",size:"28"},on:{click:function(i){i=t.$handleEvent(i),t.toGift(e.view.user.id)}}})],1)],1)],1)}),1)],1)},a=[];i.d(e,"a",function(){return n}),i.d(e,"b",function(){return a})},"7ef0":function(t,e,i){"use strict";var n=i("16aa"),a=i.n(n);a.a},"89f9":function(t,e,i){"use strict";i.r(e);var n=i("6ac2"),a=i("ab3a");for(var o in a)"default"!==o&&function(t){i.d(e,t,function(){return a[t]})}(o);i("7ef0");var s=i("2877"),r=Object(s["a"])(a["default"],n["a"],n["b"],!1,null,"538d8ca3",null);e["default"]=r.exports},"929c":function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,".recommend[data-v-538d8ca3]{margin-top:%?5?%;background:#fff;padding:%?10?% %?20?%}.user-list[data-v-538d8ca3]{width:100%}.user-list>uni-view[data-v-538d8ca3]{border-bottom:%?1?% solid #bebebe;padding-top:%?20?%}",""])},9464:function(t,e,i){"use strict";i.r(e);var n=i("ccbe"),a=i("9dd5");for(var o in a)"default"!==o&&function(t){i.d(e,t,function(){return a[t]})}(o);i("14bd");var s=i("2877"),r=Object(s["a"])(a["default"],n["a"],n["b"],!1,null,"6bb2db75",null);e["default"]=r.exports},"950b":function(t,e,i){var n=i("4226");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=i("4f06").default;a("148dcb72",n,!0,{sourceMap:!1,shadowMode:!1})},"9c4b":function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("c5f6");var n={name:"UniBadge",props:{type:{type:String,default:"default"},inverted:{type:Boolean,default:!1},text:{type:[String,Number],default:""},size:{type:String,default:"normal"}},data:function(){return{badgeStyle:""}},watch:{text:function(){this.setStyle()}},mounted:function(){this.setStyle()},methods:{setStyle:function(){this.badgeStyle="width: ".concat(8*String(this.text).length+12,"px")},onClick:function(){this.$emit("click")}}};e.default=n},"9dd5":function(t,e,i){"use strict";i.r(e);var n=i("9c4b"),a=i.n(n);for(var o in n)"default"!==o&&function(t){i.d(e,t,function(){return n[t]})}(o);e["default"]=a.a},ab3a:function(t,e,i){"use strict";i.r(e);var n=i("1176"),a=i.n(n);for(var o in n)"default"!==o&&function(t){i.d(e,t,function(){return n[t]})}(o);e["default"]=a.a},abc3:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticStyle:{width:"100%"}},[i("v-uni-view",{staticClass:"header u-f u-f-jsb u-f-ac"},[i("v-uni-view",{staticClass:"u-f-ac m-l-20"},[i("v-uni-button",{staticStyle:{background:"#51d5d1",color:"#FFFFFF"},attrs:{size:"mini"},on:{click:function(e){e=t.$handleEvent(e),t.toLanguageView(e)}}},[t._v(t._s(t.title))])],1),i("v-uni-view",{staticClass:"m-r-20 u-f-ac",on:{click:function(e){e=t.$handleEvent(e),t.toMessageView(e)}}},[i("uni-icons",{attrs:{type:"chat",size:"30",color:"#ffffff"}}),i("uni-badge",{attrs:{text:t.messageCount,type:"success",size:"small"}})],1)],1)],1)},a=[];i.d(e,"a",function(){return n}),i.d(e,"b",function(){return a})},bb98:function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.uni-badge[data-v-6bb2db75]{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-pack:center;-webkit-justify-content:center;-ms-flex-pack:center;justify-content:center;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;-ms-flex-direction:row;flex-direction:row;height:20px;line-height:20px;color:#333;border-radius:100px;background-color:#f1f1f1;background-color:rgba(0,0,0,0);text-align:center;font-family:Helvetica Neue,Helvetica,sans-serif;font-size:12px;padding:0 6px}.uni-badge--inverted[data-v-6bb2db75]{padding:0 5px 0 0;color:#f1f1f1}.uni-badge--default[data-v-6bb2db75]{color:#333;background-color:#f1f1f1}.uni-badge--default-inverted[data-v-6bb2db75]{color:#999;background-color:rgba(0,0,0,0)}.uni-badge--primary[data-v-6bb2db75]{color:#fff;background-color:#007aff}.uni-badge--primary-inverted[data-v-6bb2db75]{color:#007aff;background-color:rgba(0,0,0,0)}.uni-badge--success[data-v-6bb2db75]{color:#fff;background-color:#4cd964}.uni-badge--success-inverted[data-v-6bb2db75]{color:#4cd964;background-color:rgba(0,0,0,0)}.uni-badge--warning[data-v-6bb2db75]{color:#fff;background-color:#f0ad4e}.uni-badge--warning-inverted[data-v-6bb2db75]{color:#f0ad4e;background-color:rgba(0,0,0,0)}.uni-badge--error[data-v-6bb2db75]{color:#fff;background-color:#dd524d}.uni-badge--error-inverted[data-v-6bb2db75]{color:#dd524d;background-color:rgba(0,0,0,0)}.uni-badge--small[data-v-6bb2db75]{-webkit-transform:scale(.8);-ms-transform:scale(.8);transform:scale(.8);-webkit-transform-origin:center center;-ms-transform-origin:center center;transform-origin:center center}',""])},c745:function(t,e,i){"use strict";i.r(e);var n=i("4d8f"),a=i.n(n);for(var o in n)"default"!==o&&function(t){i.d(e,t,function(){return n[t]})}(o);e["default"]=a.a},ccbe:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return t.text?i("v-uni-text",{staticClass:"uni-badge",class:t.inverted?"uni-badge--"+t.type+" uni-badge--"+t.size+" uni-badge--"+t.type+"-inverted":"uni-badge--"+t.type+" uni-badge--"+t.size,style:t.badgeStyle,on:{click:function(e){e=t.$handleEvent(e),t.onClick()}}},[t._v(t._s(t.text))]):t._e()},a=[];i.d(e,"a",function(){return n}),i.d(e,"b",function(){return a})},ead8:function(t,e,i){var n=i("bb98");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=i("4f06").default;a("48562836",n,!0,{sourceMap:!1,shadowMode:!1})}}]);