(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-follow-follow"],{"1c61":function(t,e,n){"use strict";var o=n("288e");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i=o(n("5676")),u=o(n("8c86")),c=o(n("89f9")),r={data:function(){return{ticket:"",users:[]}},components:{commonHeader:i.default,uniIcons:u.default,commonUserList:c.default},methods:{checkTicket:function(){this.ticket=uni.getStorageSync("ticket"),""==this.ticket&&uni.navigateTo({url:"../login/login"})},getFollowUser:function(){var t=this;uni.request({url:this.config.webUrl+"/user/getFollowUser/",header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},method:"GET",data:{},success:function(e){t.users=e.data.data}})}},onLoad:function(){this.checkTicket(),this.getFollowUser()}};e.default=r},"4f90":function(t,e,n){"use strict";n.r(e);var o=n("d577"),i=n("d8ae");for(var u in i)"default"!==u&&function(t){n.d(e,t,function(){return i[t]})}(u);var c=n("2877"),r=Object(c["a"])(i["default"],o["a"],o["b"],!1,null,"9fc34848",null);e["default"]=r.exports},d577:function(t,e,n){"use strict";var o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-uni-view",[n("common-user-list",{attrs:{users:t.users}})],1)},i=[];n.d(e,"a",function(){return o}),n.d(e,"b",function(){return i})},d8ae:function(t,e,n){"use strict";n.r(e);var o=n("1c61"),i=n.n(o);for(var u in o)"default"!==u&&function(t){n.d(e,t,function(){return o[t]})}(u);e["default"]=i.a}}]);