(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-gift-gift"],{"12d1":function(t,i,e){"use strict";var n=e("30b0"),a=e.n(n);a.a},"30b0":function(t,i,e){var n=e("ffc2");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=e("4f06").default;a("26bfce47",n,!0,{sourceMap:!1,shadowMode:!1})},3146:function(t,i,e){"use strict";e.r(i);var n=e("a78e"),a=e.n(n);for(var s in n)"default"!==s&&function(t){e.d(i,t,function(){return n[t]})}(s);i["default"]=a.a},a78e:function(t,i,e){"use strict";var n=e("288e");Object.defineProperty(i,"__esModule",{value:!0}),i.default=void 0;var a=n(e("5676")),s=n(e("da4a")),o={data:function(){return{ticket:"",gifts:[],current:0,toUserID:"",content:"",num:"",username:"",titleList:["祝福语","数量","发送礼物"]}},components:{commonHeader:a.default,commonSearch:s.default},methods:{getSearchaUser:function(t){this.username=t,console.log(this.username)},checkTicket:function(){this.ticket=uni.getStorageSync("ticket"),""==this.ticket&&uni.navigateTo({url:"../login/login"})},radioChange:function(t){for(var i=0;i<this.gifts.length;i++)if(this.gifts[i].id==t.target.value){this.current=this.gifts[i].id;break}},getLaterGift:function(){var t=this;uni.request({url:this.config.webUrl+"/user/getLaterGift/",header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},method:"GET",data:{},success:function(i){t.gifts=i.data.data}})},addGiftOrder:function(){console.log(this.current),""!=this.num&&0!=this.current&&""!=this.username&&uni.request({url:this.config.webUrl+"/user/addGiftOrder/",header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},method:"POST",data:{content:this.content,num:this.num,giftID:this.current,toUsername:this.username},success:function(t){uni.showToast({icon:"none",position:"bottom",title:"OK"})}})},setLanguage:function(){var t=""==uni.getStorageSync("languageID")?3:uni.getStorageSync("languageID");1==t?this.titleList=["祝福语","数量","发送礼物"]:2==t?this.titleList=["祝福語","數量","發送禮物"]:3==t?this.titleList=["Blessing "," quantity ","sending gifts"]:4==t?this.titleList=["덕담","수량","선물 보내기"]:5==t?this.titleList=["お祝いの言葉","数","贈り物"]:6==t&&(this.titleList=["พร","ปริมาณ","ส่งของขวัญ"])}},onLoad:function(){this.checkTicket(),this.toUserID=this.config.toUserID,this.config.toUserID=0,this.getLaterGift()},onShow:function(){this.setLanguage()}};i.default=o},ba3f:function(t,i,e){"use strict";e.r(i);var n=e("cc85"),a=e("3146");for(var s in a)"default"!==s&&function(t){e.d(i,t,function(){return a[t]})}(s);e("12d1");var o=e("2877"),u=Object(o["a"])(a["default"],n["a"],n["b"],!1,null,"3b388663",null);i["default"]=u.exports},cc85:function(t,i,e){"use strict";var n=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("v-uni-view",[e("common-header"),e("v-uni-view",{staticClass:"gift-list"},[e("v-uni-radio-group",{on:{change:function(i){i=t.$handleEvent(i),t.radioChange(i)}}},[e("v-uni-view",{staticClass:"gifts u-f"},t._l(t.gifts,function(i,n){return e("v-uni-label",{key:i.id,staticClass:"uni-list-cell uni-list-cell-pd"},[e("v-uni-view",[e("v-uni-view",{staticClass:"u-f-ajc"},[e("v-uni-image",{staticStyle:{width:"150upx",height:"150upx","border-radius":"100%"},attrs:{src:i.path}})],1),e("v-uni-view",{staticClass:"u-f-ajc"},[t._v("$ "+t._s(i.price))]),e("v-uni-view",{staticClass:"u-f-ajc"},[e("v-uni-radio",{attrs:{value:i.id,checked:i.id===t.current}})],1)],1)],1)}),1)],1)],1),e("common-search",{on:{getSearchaUser:function(i){i=t.$handleEvent(i),t.getSearchaUser(i)}}}),e("v-uni-view",{staticClass:"order-info"},[e("v-uni-view",{staticClass:"uni-form-item uni-column"},[e("v-uni-input",{staticClass:"uni-input",attrs:{type:"text",placeholder:t.titleList[0]},model:{value:t.content,callback:function(i){t.content=i},expression:"content"}})],1),e("v-uni-view",{staticClass:"uni-form-item uni-column"},[e("v-uni-input",{staticClass:"uni-input",attrs:{type:"number",placeholder:t.titleList[1]},model:{value:t.num,callback:function(i){t.num=i},expression:"num"}})],1)],1),e("v-uni-view",[e("v-uni-button",{staticStyle:{background:"#ff8457",color:"#FFFFFF"},on:{click:function(i){i=t.$handleEvent(i),t.addGiftOrder(i)}}},[t._v(t._s(t.titleList[2]))])],1)],1)},a=[];e.d(i,"a",function(){return n}),e.d(i,"b",function(){return a})},ffc2:function(t,i,e){i=t.exports=e("2350")(!1),i.push([t.i,"uni-page-body[data-v-3b388663]{background:#fff}.gift-list[data-v-3b388663]{margin-top:%?120?%;background:#fff;padding:%?20?%}.gifts[data-v-3b388663]{-webkit-flex-wrap:nowrap;-ms-flex-wrap:nowrap;flex-wrap:nowrap;overflow:hidden;overflow-x:auto}.order-info[data-v-3b388663]{background:#fff}body.?%PAGE?%[data-v-3b388663]{background:#fff}",""])}}]);