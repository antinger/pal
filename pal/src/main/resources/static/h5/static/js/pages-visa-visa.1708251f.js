(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-visa-visa"],{"0d2e":function(t,e,i){"use strict";var n=i("288e");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=n(i("5676")),s=n(i("8c86")),u={components:{commonHeader:a.default,uniIcons:s.default},data:function(){return{ticket:"",amount:0,languageID:3,label1:["消费金额","账单信息","请选择账单签收国家","请输入账单签收州","请输入账单签收城市","请输入账单签收地址","请输入账单邮编"],label2:["收货信息","请选择收货国家","请输入收货州","请输入收货城市","请输入收货地址","请输入收货邮编","请输入收货邮箱"],label3:["收货人信息","请输入收货人电话","请输入收货人姓名","请输入消费的信用卡卡号","请输入信用卡有效期年份（4位）","请输入信用卡有效期月份（2位）","请输入信用卡背面的cvv"],label4:["银行卡绑定的持卡人姓氏","银行卡绑定的持卡人名字","银行卡绑定的手机号"],btnLabel:"立即支付",cardCountry:"",cardState:"",cardCity:"",cardAddress:"",cardZipCode:"",grCountry:"",grState:"",grCity:"",grAddress:"",grZipCode:"",grEmail:"",grphoneNumber:"",grPerName:"",cardNO:"",expYear:"",expMonth:"",cvv:"",FristName:"",LastName:"",cardFullPhone:"",custom:"",countryID:1,countrys:[{value:"0",title:"CN"},{value:"1",title:"US"},{value:"2",title:"KR"},{value:"3",title:"JP"},{value:"4",title:"TH"}],countryID2:1,countrys2:[{value:"0",title:"CN"},{value:"1",title:"US"},{value:"2",title:"KR"},{value:"3",title:"JP"},{value:"4",title:"TH"}],isRotate:!0}},onShow:function(){this.setLanguage()},onLoad:function(t){uni.showToast({icon:"none",position:"bottom",title:"enjoy looking forward to"}),uni.navigateBack({delta:1}),console.log(t);var e=t.toUserName;this.custom=e?t.payType+"&"+t.type+"&"+t.ticket+"&"+t.money+"&"+t.toUserName:t.payType+"&"+t.type+"&"+t.ticket+"&"+t.money,this.amount=t.money,this.checkTicket()},methods:{checkTicket:function(){this.ticket=uni.getStorageSync("ticket"),""==this.ticket&&uni.navigateTo({url:"../login/login"})},payVisa:function(){var t=this;this.isRotate||(this.isRotate=!0,""!=this.cardCountry&&""!=this.cardState&&""!=this.cardCity&&""!=this.cardAddress&&""!=this.cardZipCode&&""!=this.grCountry&&""!=this.grState&&""!=this.grCity&&""!=this.grAddress&&""!=this.grZipCode&&""!=this.grEmail&&""!=this.grphoneNumber&&""!=this.grPerName&&""!=this.cardNO&&""!=this.expYear&&""!=this.expMonth&&""!=this.cvv&&""!=this.FristName&&""!=this.LastName&&""!=this.cardFullPhone&&uni.request({url:this.config.webUrl+"/login/",method:"POST",data:{cardCountry:this.cardCountry,cardState:this.cardState,cardCity:this.cardCity,cardAddress:this.cardAddress,cardZipCode:this.cardZipCode,grCountry:this.grCountry,grState:this.grState,grCity:this.grCity,grAddress:this.grAddress,grZipCode:this.grZipCode,grEmail:this.grEmail,grphoneNumber:this.grphoneNumber,grPerName:this.grPerName,cardNO:this.cardNO,expYear:this.expYear,expMonth:this.expMonth,cvv:this.cvv,FristName:this.FristName,LastName:this.LastName,cardFullPhone:this.cardFullPhone,custom:this.custom},header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},success:function(e){"00"==e.data.res.respCode?(uni.showToast({icon:"none",position:"bottom",title:"OK"}),uni.navigateTo({url:"../index/index"})):uni.showToast({icon:"none",position:"bottom",title:"fail"}),t.isRotate=!1},fail:function(e){t.isRotate=!1}}))},countryChange:function(t){for(var e=0;e<this.countrys.length;e++)if(this.countrys[e].value==t.target.value){this.countryID=this.countrys[e].value,this.cardCountry=this.countrys[e].title;break}},countryChange2:function(t){for(var e=0;e<this.countrys2.length;e++)if(this.countrys2[e].value==t.target.value){this.countryID2=this.countrys2[e].value,this.grCountry=this.countrys2[e].title;break}},setLanguage:function(){var t=""==uni.getStorageSync("languageID")?3:uni.getStorageSync("languageID");1==t?(this.label1=["消费金额","账单信息","请选择账单签收国家","请输入账单签收州","请输入账单签收城市","请输入账单签收地址","请输入账单邮编"],this.label2=["收货信息","请选择收货国家","请输入收货州","请输入收货城市","请输入收货地址","请输入收货邮编","请输入收货邮箱"],this.label3=["收货人信息","请输入收货人电话","请输入收货人姓名","请输入消费的信用卡卡号","请输入信用卡有效期年份（4位）","请输入信用卡有效期月份（2位）","请输入信用卡背面的cvv"],this.label4=["银行卡绑定的持卡人姓氏","银行卡绑定的持卡人名字","银行卡绑定的手机号"],this.btnLabel="立即支付"):2==t?(this.label1=["消費金額","賬單信息","請選擇賬單簽收國家","請輸入賬單簽收州","請輸入賬單簽收城市","請輸入賬單簽收地址","請輸入賬單郵編"],this.label2=["收貨信息","請選擇收貨國家","請輸入收貨州","請輸入收貨城市","請輸入收貨地址","請輸入收貨郵編","請輸入收貨郵箱"],this.label3=["收貨人信息","請輸入收貨人電話","請輸入收貨人姓名","請輸入消費的信用卡卡號","請輸入信用卡有效期年份（4位）","請輸入信用卡有效期月份（2位）","請輸入信用卡背面的cvv"],this.label4=["銀行卡綁定的持卡人姓氏","銀行卡綁定的持卡人名字","銀行卡綁定的手機號"],this.btnLabel="立即支付"):3==t?(this.label1=["Amount spent","Bill Information","Please select the country in which the bill was signed","Please enter the state in which the bill was signed","Please enter the city in which the bill was signed","Please enter the address in which the Bill was signed","Please enter the bill postcode"],this.label2=["Please select the receiving country"," Please enter the receiving state","Please enter the receiving city","Please enter the receiving address","Please enter the receiving postcode","Please enter the receiving email"],this.label3=["Consignee information","Enter the consignee's telephone number","enter the consignee's name","Enter the credit card number of consumption","Enter the credit card expiry year (4 digits) ","Enter the credit card expiry month (2 digits) ","Enter the CVV on the back of the credit card"],this.label4=["Last name of the cardholder of the bank card binding"," First name of the cardholder of the bank card binding","Mobile phone number of the bank card binding"],this.btnLabel="immediate payment"):4==t?(this.label1=["사용금액","청구서 정보","청구서 서명 국립","청구서 서명 국립","청구서 서명 국립","청구서 서명 국립","청구서 서명 국립","청구서 서명 국립","청구서 서명 국립","청구서 서명 국립","청구서 서명 전국"],this.label2=["배송정보","배송국가 선택","배송주 입력","배송도시 입력","배송주소 입력","배송번호 입력","배송번호 입력","배송번호 입력"],this.label3=["수취인 정보","수취인 전화","수취인 성명","소비되는 신용카드 번호","신용카드 유효기간 (4위)","신용카드 유효기간 (2위)","신용카드 뒷면 cvv"],this.label4=["카드 바인딩된 카드 소지자 성","카드 바인딩된 카드 소지자 이름","카드 바인딩된 휴대폰번호"],this.btnLabel="지금 지불하다"):5==t?(this.label1=["消費金額","請求書情報","請求書受領国を選択してください","請求書受領州を入力してください","請求書受領都市を入力してください","請求書受領先を入力してください","請求書郵便番号を入力してください"],this.label2=["受取情報","受取国を選択してください","受取州を入力してください","受取都市を入力してください","受取住所を入力してください","受取郵便番号を入力してください","受取郵便ポストを入力してください"],this.label3=["受取人情報","受取人の電話を入力してください","受取人の名前を入力してください","クレジットカードの有効期限の年(4桁)を入力してください","クレジットカードの有効期限の月(2桁)を入力してください","クレジットカードの裏面のcvvを入力してください"],this.label4=["クレジットカードのクレジットカードのバスティングの持ち主の苗字","クレジットカードのバスティングの持ち主の名前","クレジットカードのバスティングの携帯電話番号"],this.btnLabel="即時支払い"):6==t&&(this.label1=["จํานวนผู้บริโภค","ข้อมูลบิล","กรุณาป้อนประเทศที่ลงชื่อเรียกเก็บเงิน","กรุณาป้อนการเรียกเก็บเงินออกจากเมือง","กรุณาป้อนที่อยู่สําหรับลงชื่อชําระเงิน","กรุณาป้อนรหัสไปรษณีย์สําหรับการเรียกเก็บเงิน","โปรดป้อนรหัสไปรษณีย์สําหรับการเรียกเก็บเงิน"],this.label2=["การรับข้อมูล","กรุณาเลือกประเทศที่ได้รับ","กรุณาป้อนรัฐที่ได้รับ","กรุณาป้อนประเทศที่ได้รับ","โปรดป้อนที่อยู่ที่ได้รับ","กรุณาใส่ที่อยู่ที่ได้รับ","กรุณาใส่รหัสไปรษณีย์ที่ได้รับ","กรุณาป้อนกล่องจดหมายรับ"],this.label3=["ข้อมูลใบเสร็จรับเงิน","กรุณาใส่โทรศัพท์ของผู้รับ","กรุณาใส่ชื่อของผู้รับฝาก","กรุณากรอกหมายเลขบัตรเครดิตสําหรับการบริโภค","กรุณาป้อนปีบัตรเครดิตที่ถูกต้อง (4 หลัก)","กรุณาใส่บัตรเครดิตเดือนที่ถูกต้อง (2 หลัก)","กรุณาป้อน cvv บนหลังของบัตรเครดิต"],this.label4=["ชื่อสกุลของผู้ถือบัตรสําหรับบัตรธนาคาร","ชื่อผู้ถือบัตรของบัตร","บัตรของบัตรจะถูกกําหนดโดยบัตร"],this.btnLabel="จ่ายทันที")}}};e.default=u},"14bd":function(t,e,i){"use strict";var n=i("ead8"),a=i.n(n);a.a},4226:function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,".header[data-v-8bde7dfc]{width:100%;background:#ff8457;padding:%?10?% %?0?%;position:fixed;top:0;left:0;z-index:9999}",""])},"462b":function(t,e,i){"use strict";i.r(e);var n=i("6b9b"),a=i("a9b9");for(var s in a)"default"!==s&&function(t){i.d(e,t,function(){return a[t]})}(s);var u=i("2877"),r=Object(u["a"])(a["default"],n["a"],n["b"],!1,null,"23cc98f9",null);e["default"]=r.exports},"4d8f":function(t,e,i){"use strict";var n=i("288e");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=n(i("8c86")),s=n(i("9464")),u={data:function(){return{ticket:"",messageCount:0,title:""}},components:{uniIcons:a.default,uniBadge:s.default},methods:{checkTicket:function(){this.ticket=uni.getStorageSync("ticket"),""==this.ticket&&uni.navigateTo({url:"../login/login"})},toMessageView:function(){uni.navigateTo({url:"../message/message"})},toLanguageView:function(){uni.navigateTo({url:"../language/language"})},getMessageNumByStatus:function(){var t=this;uni.request({url:this.config.webUrl+"/user/getMessageNumByStatus/",header:{"content-type":"application/x-www-form-urlencoded",cookie:"ticket="+this.ticket},method:"GET",data:{},success:function(e){t.messageCount=e.data.count}})},setLanguage:function(){var t=""==uni.getStorageSync("languageID")?3:uni.getStorageSync("languageID");1==t?this.title="中文":2==t?this.title="繁体":3==t?this.title="English":4==t?this.title="한국어":5==t?this.title="わぶん":6==t&&(this.title="ไทย")}},created:function(){this.checkTicket(),this.getMessageNumByStatus(),this.setLanguage();setInterval(this.setLanguage,"1000")}};e.default=u},5676:function(t,e,i){"use strict";i.r(e);var n=i("abc3"),a=i("c745");for(var s in a)"default"!==s&&function(t){i.d(e,t,function(){return a[t]})}(s);i("690f");var u=i("2877"),r=Object(u["a"])(a["default"],n["a"],n["b"],!1,null,"8bde7dfc",null);e["default"]=r.exports},"690f":function(t,e,i){"use strict";var n=i("950b"),a=i.n(n);a.a},"6b9b":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",[i("common-header"),i("v-uni-view",{staticStyle:{"margin-top":"150upx"}},[i("v-uni-view",{staticStyle:{background:"#FF8457",padding:"10upx 20upx",color:"#FFFFFF","font-size":"40upx"}},[t._v(t._s(t.label1[0])+":"+t._s(t.amount))])],1),i("v-uni-view",{staticClass:"m-t-5"},[i("v-uni-view",{staticStyle:{background:"#FF8457",padding:"10upx 20upx",color:"#FFFFFF","font-size":"40upx"}},[t._v(t._s(t.label1[1]))])],1),i("v-uni-view",{staticClass:"uni-list u-f-ajc m-t-5"},[i("v-uni-view",{staticClass:"uni-list-cell input-border",staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-list-cell-left"},[t._v(t._s(t.label1[2]))]),i("v-uni-view",{staticClass:"uni-list-cell-db"},[i("v-uni-picker",{attrs:{value:t.countryID,range:t.countrys,"range-key":"title"},on:{change:function(e){e=t.$handleEvent(e),t.countryChange(e)}}},[i("v-uni-view",{staticClass:"uni-input"},[t._v(t._s(t.countrys[t.countryID].title))])],1)],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label1[3]},model:{value:t.cardState,callback:function(e){t.cardState=e},expression:"cardState"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label1[4]},model:{value:t.cardCity,callback:function(e){t.cardCity=e},expression:"cardCity"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label1[5]},model:{value:t.cardAddress,callback:function(e){t.cardAddress=e},expression:"cardAddress"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label1[6]},model:{value:t.cardZipCode,callback:function(e){t.cardZipCode=e},expression:"cardZipCode"}})],1)],1)],1),i("v-uni-view",{staticClass:"m-t-5"},[i("v-uni-view",{staticStyle:{background:"#FF8457",padding:"10upx 20upx",color:"#FFFFFF","font-size":"40upx"}},[t._v(t._s(t.label2[0]))])],1),i("v-uni-view",{staticClass:"uni-list u-f-ajc m-t-5"},[i("v-uni-view",{staticClass:"uni-list-cell input-border",staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-list-cell-left"},[t._v(t._s(t.label2[1]))]),i("v-uni-view",{staticClass:"uni-list-cell-db"},[i("v-uni-picker",{attrs:{value:t.countryID2,range:t.countrys2,"range-key":"title"},on:{change:function(e){e=t.$handleEvent(e),t.countryChange2(e)}}},[i("v-uni-view",{staticClass:"uni-input"},[t._v(t._s(t.countrys2[t.countryID2].title))])],1)],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label2[2]},model:{value:t.grState,callback:function(e){t.grState=e},expression:"grState"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label2[3]},model:{value:t.grCity,callback:function(e){t.grCity=e},expression:"grCity"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label2[4]},model:{value:t.grAddress,callback:function(e){t.grAddress=e},expression:"grAddress"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label2[5]},model:{value:t.grZipCode,callback:function(e){t.grZipCode=e},expression:"grZipCode"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label2[6]},model:{value:t.grEmail,callback:function(e){t.grEmail=e},expression:"grEmail"}})],1)],1)],1),i("v-uni-view",{staticClass:"m-t-5"},[i("v-uni-view",{staticStyle:{background:"#FF8457",padding:"10upx 20upx",color:"#FFFFFF","font-size":"40upx"}},[t._v(t._s(t.label3[0]))])],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label3[1]},model:{value:t.grphoneNumber,callback:function(e){t.grphoneNumber=e},expression:"grphoneNumber"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label3[2]},model:{value:t.grPerName,callback:function(e){t.grPerName=e},expression:"grPerName"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label3[3]},model:{value:t.cardNO,callback:function(e){t.cardNO=e},expression:"cardNO"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label3[4]},model:{value:t.expYear,callback:function(e){t.expYear=e},expression:"expYear"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label3[5]},model:{value:t.expMonth,callback:function(e){t.expMonth=e},expression:"expMonth"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label3[6]},model:{value:t.cvv,callback:function(e){t.cvv=e},expression:"cvv"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label4[0]},model:{value:t.FristName,callback:function(e){t.FristName=e},expression:"FristName"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label4[1]},model:{value:t.LastName,callback:function(e){t.LastName=e},expression:"LastName"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"90%"}},[i("v-uni-view",{staticClass:"uni-form-item uni-column"},[i("v-uni-input",{staticClass:"uni-input input-border",attrs:{focus:"",type:"text",placeholder:t.label4[2]},model:{value:t.cardFullPhone,callback:function(e){t.cardFullPhone=e},expression:"cardFullPhone"}})],1)],1)],1),i("v-uni-view",{staticClass:"u-f-ajc"},[i("v-uni-view",{staticStyle:{width:"100%"}},[i("v-uni-button",{staticStyle:{background:"#ff8457",color:"#FFFFFF"},on:{click:function(e){e=t.$handleEvent(e),t.payVisa(e)}}},[t._v(t._s(t.btnLabel))])],1)],1)],1)},a=[];i.d(e,"a",function(){return n}),i.d(e,"b",function(){return a})},9464:function(t,e,i){"use strict";i.r(e);var n=i("ccbe"),a=i("9dd5");for(var s in a)"default"!==s&&function(t){i.d(e,t,function(){return a[t]})}(s);i("14bd");var u=i("2877"),r=Object(u["a"])(a["default"],n["a"],n["b"],!1,null,"6bb2db75",null);e["default"]=r.exports},"950b":function(t,e,i){var n=i("4226");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=i("4f06").default;a("148dcb72",n,!0,{sourceMap:!1,shadowMode:!1})},"9c4b":function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("c5f6");var n={name:"UniBadge",props:{type:{type:String,default:"default"},inverted:{type:Boolean,default:!1},text:{type:[String,Number],default:""},size:{type:String,default:"normal"}},data:function(){return{badgeStyle:""}},watch:{text:function(){this.setStyle()}},mounted:function(){this.setStyle()},methods:{setStyle:function(){this.badgeStyle="width: ".concat(8*String(this.text).length+12,"px")},onClick:function(){this.$emit("click")}}};e.default=n},"9dd5":function(t,e,i){"use strict";i.r(e);var n=i("9c4b"),a=i.n(n);for(var s in n)"default"!==s&&function(t){i.d(e,t,function(){return n[t]})}(s);e["default"]=a.a},a9b9:function(t,e,i){"use strict";i.r(e);var n=i("0d2e"),a=i.n(n);for(var s in n)"default"!==s&&function(t){i.d(e,t,function(){return n[t]})}(s);e["default"]=a.a},abc3:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticStyle:{width:"100%"}},[i("v-uni-view",{staticClass:"header u-f u-f-jsb u-f-ac"},[i("v-uni-view",{staticClass:"u-f-ac m-l-20"},[i("v-uni-button",{staticStyle:{background:"#51d5d1",color:"#FFFFFF"},attrs:{size:"mini"},on:{click:function(e){e=t.$handleEvent(e),t.toLanguageView(e)}}},[t._v(t._s(t.title))])],1),i("v-uni-view",{staticClass:"m-r-20 u-f-ac",on:{click:function(e){e=t.$handleEvent(e),t.toMessageView(e)}}},[i("uni-icons",{attrs:{type:"chat",size:"30",color:"#ffffff"}}),i("uni-badge",{attrs:{text:t.messageCount,type:"success",size:"small"}})],1)],1)],1)},a=[];i.d(e,"a",function(){return n}),i.d(e,"b",function(){return a})},bb98:function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.uni-badge[data-v-6bb2db75]{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-pack:center;-webkit-justify-content:center;-ms-flex-pack:center;justify-content:center;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;-ms-flex-direction:row;flex-direction:row;height:20px;line-height:20px;color:#333;border-radius:100px;background-color:#f1f1f1;background-color:rgba(0,0,0,0);text-align:center;font-family:Helvetica Neue,Helvetica,sans-serif;font-size:12px;padding:0 6px}.uni-badge--inverted[data-v-6bb2db75]{padding:0 5px 0 0;color:#f1f1f1}.uni-badge--default[data-v-6bb2db75]{color:#333;background-color:#f1f1f1}.uni-badge--default-inverted[data-v-6bb2db75]{color:#999;background-color:rgba(0,0,0,0)}.uni-badge--primary[data-v-6bb2db75]{color:#fff;background-color:#007aff}.uni-badge--primary-inverted[data-v-6bb2db75]{color:#007aff;background-color:rgba(0,0,0,0)}.uni-badge--success[data-v-6bb2db75]{color:#fff;background-color:#4cd964}.uni-badge--success-inverted[data-v-6bb2db75]{color:#4cd964;background-color:rgba(0,0,0,0)}.uni-badge--warning[data-v-6bb2db75]{color:#fff;background-color:#f0ad4e}.uni-badge--warning-inverted[data-v-6bb2db75]{color:#f0ad4e;background-color:rgba(0,0,0,0)}.uni-badge--error[data-v-6bb2db75]{color:#fff;background-color:#dd524d}.uni-badge--error-inverted[data-v-6bb2db75]{color:#dd524d;background-color:rgba(0,0,0,0)}.uni-badge--small[data-v-6bb2db75]{-webkit-transform:scale(.8);-ms-transform:scale(.8);transform:scale(.8);-webkit-transform-origin:center center;-ms-transform-origin:center center;transform-origin:center center}',""])},c745:function(t,e,i){"use strict";i.r(e);var n=i("4d8f"),a=i.n(n);for(var s in n)"default"!==s&&function(t){i.d(e,t,function(){return n[t]})}(s);e["default"]=a.a},ccbe:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return t.text?i("v-uni-text",{staticClass:"uni-badge",class:t.inverted?"uni-badge--"+t.type+" uni-badge--"+t.size+" uni-badge--"+t.type+"-inverted":"uni-badge--"+t.type+" uni-badge--"+t.size,style:t.badgeStyle,on:{click:function(e){e=t.$handleEvent(e),t.onClick()}}},[t._v(t._s(t.text))]):t._e()},a=[];i.d(e,"a",function(){return n}),i.d(e,"b",function(){return a})},ead8:function(t,e,i){var n=i("bb98");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=i("4f06").default;a("48562836",n,!0,{sourceMap:!1,shadowMode:!1})}}]);