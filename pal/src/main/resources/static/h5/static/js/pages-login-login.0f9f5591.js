(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-login-login"],{2447:function(t,i,e){"use strict";var n=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("v-uni-view",[e("v-uni-view",{staticClass:"header"},[e("v-uni-button",{staticStyle:{background:"#FF8457",color:"#FFFFFF"},on:{click:function(i){i=t.$handleEvent(i),t.toLanguageView(i)}}},[t._v(t._s(t.title))])],1),e("v-uni-view",{staticClass:"logo"},[e("v-uni-image",{attrs:{src:"../../static/cover-img.jpg",mode:"widthFix"}})],1),e("v-uni-view",{staticClass:"content"},[e("v-uni-view",{staticClass:"u-f-ajc"},[e("v-uni-view",{staticClass:"u-f",staticStyle:{width:"80%"}},[e("uni-icons",{attrs:{type:"contact",color:"#FF8457",size:"25"}}),e("v-uni-view",{staticClass:"uni-form-item uni-column"},[e("v-uni-input",{staticClass:"uni-input m-l-20",staticStyle:{border:"1upx solid #007AFF","border-radius":"50upx"},attrs:{type:"text"},model:{value:t.username,callback:function(i){t.username=i},expression:"username"}})],1)],1)],1),e("v-uni-view",{staticClass:"u-f-ajc"},[e("v-uni-view",{staticClass:"u-f",staticStyle:{width:"80%"}},[e("uni-icons",{attrs:{type:"locked",color:"#FF8457",size:"25"}}),e("v-uni-view",{staticClass:"uni-form-item uni-column"},[e("v-uni-input",{staticClass:"uni-input m-l-20",staticStyle:{border:"1upx solid #007AFF","border-radius":"50upx"},attrs:{type:"password"},model:{value:t.password,callback:function(i){t.password=i},expression:"password"}})],1)],1)],1)],1),e("v-uni-view",{staticClass:"title u-f-ajc"},[e("v-uni-view",{staticClass:"u-f",staticStyle:{width:"80%"}},[e("v-uni-view",{staticStyle:{"margin-left":"370upx"},on:{click:function(i){i=t.$handleEvent(i),t.toRegisterView(i)}}},[t._v(t._s(t.titleList[0]))]),e("v-uni-view",{staticClass:"m-l-20",on:{click:function(i){i=t.$handleEvent(i),t.toReterView(i)}}},[t._v(t._s(t.titleList[1]))])],1)],1),e("v-uni-view",{staticClass:"login u-f-ajc"},[e("v-uni-view",{staticStyle:{width:"80%"}},[e("v-uni-button",{staticStyle:{background:"#FF8457",color:"#FFFFFF",width:"100%"},on:{click:function(i){i=t.$handleEvent(i),t.startLogin(i)}}},[t._v(t._s(t.titleList[2]))])],1)],1)],1)},a=[];e.d(i,"a",function(){return n}),e.d(i,"b",function(){return a})},"3b4c":function(t,i,e){i=t.exports=e("2350")(!1),i.push([t.i,"uni-page-body[data-v-bdc8e7d4]{background:#f1f1f1}.content[data-v-bdc8e7d4]{padding:%?20?%;background:#fff}.login[data-v-bdc8e7d4]{background:#fff;padding:%?20?%}.title[data-v-bdc8e7d4]{background:#fff;font-size:%?30?%;color:#007aff;padding:0 %?20?%}.logo>uni-image[data-v-bdc8e7d4]{width:100%}body.?%PAGE?%[data-v-bdc8e7d4]{background:#f1f1f1}",""])},"528a":function(t,i,e){"use strict";var n=e("288e");Object.defineProperty(i,"__esModule",{value:!0}),i.default=void 0;var a=n(e("8c86")),s={data:function(){return{username:"",password:"",isRotate:!1,title:"",titleList:["注册","密保","登录"]}},components:{uniIcons:a.default},methods:{toLanguageView:function(){uni.navigateTo({url:"../language/language"})},startLogin:function(){var t=this;return!this.isRotate&&(this.isRotate=!0,""==this.username.length?(uni.showToast({icon:"none",position:"bottom",title:"fail"}),void(this.isRotate=!1)):this.password.length<5?(uni.showToast({icon:"none",position:"bottom",title:"fail"}),void(this.isRotate=!1)):void uni.request({url:this.config.webUrl+"/login/",method:"POST",data:{username:this.username,password:this.password},header:{"content-type":"application/x-www-form-urlencoded","Access-Control-Allow-Origin":"*"},success:function(i){if(console.log(i),i.data.ticket){var e=i.data.ticket;uni.setStorageSync("ticket",e),uni.switchTab({url:"../index/index"})}else uni.showToast({icon:"none",position:"bottom",title:"fail"});t.isRotate=!1},fail:function(i){t.isRotate=!1}}))},toRegisterView:function(){uni.navigateTo({url:"../register/register"})},toReterView:function(){uni.navigateTo({url:"../encrypted/encrypted"})},setTitle:function(){var t=""==uni.getStorageSync("languageID")?3:uni.getStorageSync("languageID");1==t?this.title="中文":2==t?this.title="繁体":3==t?this.title="English":4==t?this.title="한국어":5==t?this.title="わぶん":6==t&&(this.title="ไทย")},setLanguage:function(){var t=""==uni.getStorageSync("languageID")?3:uni.getStorageSync("languageID");1==t?this.titleList=["注册","密保","登录"]:2==t?this.titleList=["註冊","密保","登錄"]:3==t?this.titleList=["Register","secure","login"]:4==t?this.titleList=["등록","비밀보장","등록"]:5==t?this.titleList=["登録","密保","登録"]:6==t&&(this.titleList=["ลงทะเบียน","ลับ","เข้าสู่ระบบ"])}},onShow:function(){this.setTitle(),this.setLanguage()}};i.default=s},6424:function(t,i,e){"use strict";e.r(i);var n=e("2447"),a=e("c36e");for(var s in a)"default"!==s&&function(t){e.d(i,t,function(){return a[t]})}(s);e("78c2");var o=e("2877"),u=Object(o["a"])(a["default"],n["a"],n["b"],!1,null,"bdc8e7d4",null);i["default"]=u.exports},"78c2":function(t,i,e){"use strict";var n=e("f0db"),a=e.n(n);a.a},c36e:function(t,i,e){"use strict";e.r(i);var n=e("528a"),a=e.n(n);for(var s in n)"default"!==s&&function(t){e.d(i,t,function(){return n[t]})}(s);i["default"]=a.a},f0db:function(t,i,e){var n=e("3b4c");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=e("4f06").default;a("a2e0fccc",n,!0,{sourceMap:!1,shadowMode:!1})}}]);