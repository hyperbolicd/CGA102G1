/*
Insert data
*/
USE movietheater;


/*
建置會員等級資料內容
*/
INSERT INTO `movietheater`.`level_data` (`MEMBER_LEVEL`,`MAX_COUNT`,`MIN_COUNT`,`LEVEL_DESCRIPTION`)
VALUES ('A',100,51,'該會員累積購買票數最大100~51之間為A等級'),
('B',50,31,'該會員累積購買票數最大50~31之間為B等級'),
('C',30,0,'該會員累積購買票數最大30~0之間為C等級');
/*
會員表格資料內容
*/
INSERT INTO `movietheater`.`member` (`MEMBER_LEVEL`,`MEMBER_EMAIL`,`MEMBER_PASSWORD`,`MEMBER_NAME`,`MEMBER_PHONE`,`MEMBER_ADDRESS`,`MEMBER_PIC`,`MEMBER_STATUS`,`WISH_TICKET`,`BONUS_POINTS`,`SUM_COUNT`)
VALUES ('A','hireme123@gmail.com','aa123123','林曉慧','0971547438','台南市北區三民南路七段 235 巷',"/member_pic/2.jpg",1,3,0,100),
('B','QKE7wab9@gmail.com','qw456456','哈惠瑩','0961868594','桃園市大園區航站南路10號',"/member_pic/3.jpg",1,2,1,50),
('C','K6YtCvsa@gmail.com','as789789','屈中霞','0971991074','新竹市北區金雅一街4號',"/member_pic/4.jpg",2,0,4,30),
('C','WXACg50j@gmail.com','zx890890','林雲季','0963812653','新北市中和區中板路25號',"/member_pic/1.jpg",2,10,5,20),
('B','Nj26jYBa@gmail.com','wewe4565','詹汝伶','0960029509','桃園市楊梅區永美路25號',"/member_pic/2.jpg",2,14,6,40),
('C','SusO1Pxf@gmail.com','ty678456','黃桂潔','0971041974','新竹縣竹東鎮水仙路17號',"/member_pic/3.jpg",2,1,7,20),
('A','Ousv4nFq@gmail.com','sd789567','裴姿琦','0971442076','苗栗縣竹南鎮萬壽街27號',"/member_pic/4.jpg",2,14,9,70),
('C','HGs6ptNa@gmail.com','hu789123','黃紋琴','0952097800','新竹市香山區牛埔北路12號',"/member_pic/2.jpg",2,1,8,10),
('A','SJw21QxG@gmail.com','qw789890','黃旻音','0953679665','新北市新店區直潭三街7號',"/member_pic/3.jpg",2,20,2,80),
('A','SJw24Qxa@gmail.com','qa789878','張惠美','0953679666','新北市新店區直潭三街16號',"/member_pic/2.jpg",2,30,3,90);

/*
員工資料
*/
INSERT INTO `movietheater`.`emp_account` 
	(`EMP_EMAIL`, `EMP_PASSWORD`, `EMP_NAME`, `EMP_PHONE`, `EMP_ADDRESS`, `EMP_PHOTO`, `EMP_STATUS`) VALUES 
	('ada@xxx.com', '123456', 'Ada', '0912-345678', '桃園市中壢區', null , 1),
	('belle@xxx.com', '234567', 'Belle', '0923-456789', '桃園市平鎮區', null , 1),
    ('cindy@yyyyyy.com', '345678', 'Cindy', '0934-567890', '新北市中和區', null , 1),
	('donki@zzzzzzz.com.tw', '987654321', 'Donki', '0945-678901', '高雄市燕巢區', null , 1),
    ('emma@xxx.com', 'asdafasf4321', 'Emma', '0956-789012', '新竹市東區', null , 2),        
    ('frank@zzzzzzz.com.tw', 'djsjgfjjhkr%f', 'Frank', '0967-890123', '台中市沙鹿區', null , 0);

/*
員工權限功能
*/    
INSERT INTO `movietheater`.`emp_function` 
	(`FC_NAME`, `FC_DESCRIPTION`, `FC_CATEGORY`) VALUES 
    -- 資訊管理 0：現場人員 1：網站管理員
	('影城資訊管理', '/cinemaInfoManege/cinemaInfoManege.jsp', 1),
    ('電影資訊管理', '/back_end/ManageMV/manageMV.jsp', 1),
    ('票價資訊管理', '/back_end/tk_inf/allTkInf.jsp', 1),
    ('餐飲資訊管理', '/back_end/fd_inf/allFdInf.jsp', 1),
    ('影廳資訊管理', '/back_end/ManageHall/manageHall.jsp', 1),
    ('場次管理', '/back_end/showing/showing_select_page.jsp', 1),
    ('座位管理', '/back_end/ManageSeat/manageSeat.jsp', 1),
    -- 票務管理
    ('現場購票/購餐', '/back_end/tk_ord/sellTK.jsp', 0),
    ('票務訂單管理', '/back_end/refundTicket/refundIndex.jsp', 0),
    -- 評論相關
    ('舉報回應管理', '/back_end/ManageReport/manageReport.jsp', 1),
    -- 商城相關
    ('商品資訊', '/back_end/merchandise/mallIndex.jsp', 1),
    ('商城訂單', '/back_end/merchandiseOrd/orderIndex.jsp', 0),
    -- 活動相關
    ('促銷活動管理', '/back_end/act/allAct.jsp', 1),
    ('許願池管理', '/back_end/wish/wishPond.jsp', 1),
    -- 公告客服
    ('公告管理', '/back_end/ann/allAnn.jsp', 1),
    ('常見問題管理', '/back_end/faq/allFaq.jsp', 1),
    -- 員工管理
    ('帳號與權限', '/back_end/emp/empAcc.jsp', 1),
    ('個人資料維護', '/back_end/emp/empSelf.jsp', 0),
    -- 會員管理
    ('會員帳號管理', '/back_end/member/listAllMember.jsp', 1);

/*
員工權限
*/    
INSERT INTO `movietheater`.`emp_privilege`
	(`EMP_NO`, `FC_NO`) VALUES 
    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8),
    (1, 9), (1, 10), (1, 11), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16),
    (1, 17), (1, 18), (1, 19), 
    (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 11), (2, 12),
    (2, 14), (2, 15), (2, 16), (2, 17), (2, 19), 
    (3, 8), (3, 9), (3, 10), (3, 13), (3, 18), 
    (4, 19), 
    (5, 8), (5, 9), (5, 10), (5, 13), (5, 18), 
    (6, 19);
    
/*
建置常見問答 FAQ table 測試資料
*/
insert into `movietheater`.`faq`(FAQ_CLASS, FAQ_TITLE, FAQ_CONTENT) values
(1, '影城公告', '◎ 請遵守影片分級制度相關規定。片長超過150分鐘，酌量增加票價，以現場公告為主！
◎ 購買優待票觀眾請主動出示相關有效證明文件，應主動出示優待身分證明文件，以供查驗。若未事先告知或證明文件不全者，恕不折扣，亦不得在購票後申請退票或退差額。
◎ 二歲以上且未滿十二歲之兒童，需購買優待票進場。
◎ 請當面清點您的找零及票券，各式票券（如團體票、公關票、預售票、活動票…等）經劃位兌換，離開櫃檯後恕不退換。
◎ 請妥善保管電影票券，如遺失、破損、燒毀及無法辨識…等情形，恕不重新開票。任何憑證皆無法取代票券本身，恕無法持任何憑證要求入場或補開票券。
◎ 為維持著作權，影片放映時場內全面禁止攝影及錄音。若查獲，本公司得報警處理並保留法律追訴權。
◎ 本影城全面禁煙、酒類、嚼食檳榔及服用禁藥；為維護公共安全及觀影品質，請勿攜帶玻璃瓶、鐵鋁罐或寵物入場。飲酒過量顯有醉意者，請勿入內。
◎ 為維護良好觀影環境，觀賞電影時，請將手機、呼叫器關機或轉為震動，切勿在影廳內大聲喧嘩或擱足於前排座椅。
◎ 入內者請勿隨地吐痰、檳榔汁（渣）、口香糖、便溺、瓜果皮核、棄置廢棄物或有其他污染行為。
◎ 貴重物品請隨身攜帶，散場時請特別注意隨身物品。
◎ 若有違反上述情事，得謝絕入場，敬請見諒。
◎ 本場所若有任何待改進事項，歡迎立即向服務人員反應。
◎ 兒童未滿二歲，無需購票可入場觀賞【普遍級】影片，每位購票者限免費攜帶一名未滿二歲兒童入場。（未購票之兒童恕不提供座位）
'),
(1, '電影格式介紹', '播放格式： 目前嗨邇覓影城皆為全數位影廳，支援播放格式有數位及IMAX
2D數位版 (數位)：以數位放映設備播放的高畫質影片，較一般膠卷來得明亮清晰、色彩飽合，不需配戴3D眼鏡。
IMAX：在IMAX影廳上演的哈利波特是所謂的IMAX-DMR電影。IMAX集團花了五年的時間研發這種數位化重製影片技術，以便將一般的商業電影轉成IMAX的格式播放。
首先，以盡量最大的解析度掃描每一格35厘米的影片轉成數位影像。
接著，透過電腦將影像銳利化並將色彩豐富化，以便轉成世界最大底片格式──IMAX。(15孔/70厘米影片)這個系統同時會將影片的原始音效，轉成12,000瓦功率的7.1聲道的IMAX環繞音效, 使得音質純淨清澈無雜音的完美音場表現。
這一套特別設計的音源平衡喇叭系統，可確保觀眾無論坐在影廳任何座位，均可享有最佳音量品質及聽覺效果。 
註：除非片商未提供，否則所有的影片版本皆會有中文字幕 （國）表示是國語配音，中文字幕 （英）表示是英文原音，中文字幕 （粵）表示是
粵語原音，中文字幕 ，以上語言版本為示範說明，其他請依此類推。'),
(2, '電影的分級制度如何區分?', '依照行政院新聞局規定，電影分級制度分為四級，詳細規定如下：
◎普遍級/G (簡稱 普級)：
一般觀眾皆可觀賞。
◎保護級/P (簡稱 護級)：
未滿六歲之兒童不得觀賞，六歲以上十二歲未滿之兒童需父母、師長或成年親友陪伴輔導觀賞。
◎輔12級/PG12(簡稱 輔12級)：
未滿十二歲不得觀賞。
◎輔15級/PG15(簡稱 輔15級)：
未滿十五歲不得觀賞。
◎限制級/R (簡稱 限級)：
未滿十八歲不得觀賞。
'),
(2, '這部片有在嗨邇覓影城上映嗎？', '您可點選嗨邇覓影城官網直接查詢現正上映資訊，若該片沒有在秀泰上映，關乎到素材格式、廳別、檔期等種種因素，各位影迷仍可選擇其它好片前往觀賞。'),
(2, '電影什麼時候會下片？', '下片的檔期會因不同狀況而定，您可透過秀泰影城官網/各影城現場，進行訂票或查詢場次；或盡早到秀泰影城觀賞，也讓您可以享有更多場次的選擇權利。'),
(0, '如何加入HireMe會員？', '會員資格申請：請至嗨邇覓影城官網，點選會員註冊進行申請，啟用帳號成功後，即可使用網路訂票與線上累兌點功能。'),
(0, '為什麼無法加入會員？', '若於申請會員時出現『此身份證號碼已存在』或『此信箱已加入過會員』的訊息而無法註冊，請洽影城服務專線為您查詢處理。'),
(0, '為什麼不能登入網站？', '請先確認
◎所輸入的帳號密碼大小寫正確，且未因複製貼上時貼到空白鍵或是key到空白鍵。
◎帳號是否被停用、未註冊成功或是尚未完成開卡。'),
(3, '請問影城禁止攜入影廳食物規定為何？', '◎味道嗆辣濃郁食物：漢堡、披薩、滷味、油炸、燒烤食品、臭豆腐、烤玉米、章魚燒、榴槤...等味道嗆辣濃郁食物。

◎高溫熱燙食物：熱湯、熱麵、泡麵、關東煮、燒仙草、速食店蘋果派...等高溫熱燙食物。

◎食用時會發出聲響之食物：瓜子、花生、燒酒螺...等食物。

◎任何含酒精飲料。

◎若對以上禁止攜入影廳食物有爭議時，將由影城工作人員認定。

以上規定根據行政院新聞局【電影片映演業禁止攜帶外食定型化契約不得記載事項】規定：電影片映演業者不得為禁止消費者攜帶食物進入映演場所食用之揭示，標示或口頭告知，但『味道嗆辣、濃郁、高溫熱湯(飲)食用時會發出聲響之食物，得於映演場所明顯處揭示或標示禁止攜帶』訂定之。'),
(3, '影城開始營業的時間？', '影城營業時間週一至週五為首場電影開演前30分鐘，週六至週日為首場電影開演前一小時。');

/*
建置公告 ADD table 測試資料
*/
insert into `movietheater`.`announcement`(ANN_DATE, ANN_TITLE, ANN_CONTENT, ANN_PICTURE) value
('2022-03-14', '影廳內嚴禁拍照、錄影、錄音', '戲院影廳內嚴禁拍照、錄音、錄影（含電影正片、片尾），任何未經授權之攝錄行為，已觸犯著作權法第91條，最高可處5年有期徒刑', "/ann_pic/ann_1.jpg"), -- 內容會放照片
('2022-03-14', '本場所全面禁菸!', '', "/ann_pic/ann_2.jpg") ,-- 內容只放照片
('2022-03-14', '因應政府防疫規定', '因應政府防疫規定：出入電影場所應佩戴口罩，未佩戴且勸導不聽者，由地方政府裁罰新臺幣3千元至1萬5千元以下罰鍰，感謝您的支持與配合!', "/ann_pic/ann_3.jpg"), -- 內容會放照片
('2022-04-01', '「臺灣社交距離App」宣導', '', "/ann_pic/ann_4.jpg") ;-- 內容只放照片


/*
電影table 
測試資料 內有未上映*2 已下檔*2 其餘上映中*8 共12部
*/

-- 咒術迴戰0
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('劇場版 咒術迴戰 0','JUJUTSU KAISEN:ZERO','105',2,'故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚，並且要永遠再一起…。但里香卻在一場車禍中橫死，死後化為強大怨靈依附在乙骨身邊，為此所苦的乙骨，甚至一心求死。終於，在五條悟的帶領下，乙骨憂太進入咒術高專學習咒術，讓他結識了新同學：禪院真希、狗卷棘與熊貓，他漸漸打開心防並決定在這裡找到活下去的自信與解開里香詛咒的方法；另一方面，主張全面殲滅非術師的夏油傑宣布發動「百鬼夜行」，要在新宿與京都釋放出千隻詛咒。為此，咒術高專傾盡所有人力阻止夏油傑的野心，被捲入這場爭鬥中的咒術高專一年級生乙骨能否阻止夏油傑的野心並且順利地解開里香的詛咒？',
'2022-07-13','動畫','緒方惠美、小松未可子、內山昂輝、關智一','朴性厚',
'2022-09-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/TD9aUF9wtPk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
'/mvPicture_upload/JUJUTSUKAISENZERO.jpg',10,50);

-- 怪獸與鄧不力多
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('怪獸與鄧不利多的秘密','Fantastic Beasts: The Secrets of Dumbledore','142',1,'阿不思鄧不利多教授（裘德洛 飾演）知道強大的黑巫師蓋勒葛林戴華德（邁茲米克森 飾演）正準備控制整個魔法世界，但他深知自己無法單獨阻止葛林戴華德，於是委託奇獸飼育學家紐特斯卡曼德（艾迪瑞德曼 飾演）帶領一群勇敢的巫師、女巫和一位麻瓜烘焙師進行這項危險任務。他們在任務中將會遇到新舊奇獸，並與更多葛林戴華德的追隨者發生衝突，但隨著任務風險越來越高，鄧不利多還能置身事外到什麼時候呢？',
'2022-08-27','奇幻','裘德洛(Jude Law)、邁茲米克森(Mads Mikkelsen)、艾迪瑞德曼(Eddie Redmayne)、凱薩琳沃特斯頓(Katherine Waterston)','大衛葉慈(David Yates)',
'2022-09-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/HOyPQfJ5p68" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
'/mvPicture_upload/FantasticBeasts.jpg',10,20);

-- 進擊的巨人
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('進擊的巨人 劇場版:覺醒的咆哮','ATTACK ON TITAN:Kakusei no Houkou','121',2,'城牆為何要存在？戰士又是誰？真實的正義到底在哪裡？自從超大型巨人出現，人類的和平與幻影遭到破滅的那一天起，艾連‧葉卡從此展開無止盡的奮戰歲月……。親眼看著無力抵抗、只能成為巨人餌食的母親臨終慘狀，艾連發誓要殺光這個世界裡的巨人，一具也不留。但在激烈的奮戰過程中，他自己竟然也變成了巨人……。為贏回人類自由而發揮巨人力量的艾連，在席納之牆的史托黑斯區裡，與「女巨人」正面激戰。在同為巨人之間的慘烈對戰下，艾連勉強贏得了勝利。儘管如此，艾連與人類仍沒有時間喘息，因為下一場戰爭已宣告開始。面對逼往羅塞之牆而來的巨人大軍，人類該如何對抗！？信念、衝突、命運 現在起，激烈撞擊',
'2022-05-26','動畫','梶裕貴(Yuki Kaji)、石川由依(Yui Ishikawa)、神谷浩史(Hiroshi Kamiya)','荒木哲郎',
'2022-07-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/67ScV4jUqVs" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
'/mvPicture_upload/ATTACKONTITAN.jpg',10,50);

-- 福音戰士
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('福音戰士新劇場版：Q','Evangelion 3.0: You Can (Not) Redo','96',2,'本集接續著第二集《破》的劇情展開。明日香戴著眼罩重新復活，而真嗣在戰鬥中使初號機完全覺醒，在初號機頭上出現的天使光環，暗示人類將遭遇更可怕的第三次衝擊。懵懂的真嗣返回了千瘡百孔的NERV總部，並意外重逢朝思夜想的綾波，還從父親那裡得知自己將和美少年渚薰共同駕駛十三號機。長達14年的空白，期間的滄桑巨變和情感糾葛，讓真嗣不知所措。而看似溫柔的渚薰為他揭開了種種難以置信的真相……為每個人不可預知的未來，做最後一章《？》的鋪路',
'2022-05-26','動畫','山寺宏一、阪本真綾','庵野秀明',
'2022-07-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/s3cD1hztqJM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/EVA.jpg',30,120);

-- FGO 
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('FGO 絕對魔獸戰線','FGO babylonia','100',0,'迦勒底唯一殘存的御主·藤丸立香，與亞從者瑪修·基列萊特一同介入這些特異點的事象，從而執行將其解明或破壞的禁斷儀式——「聖杯探索 Grand Order」。這一次新發現的是第七個特異點——紀元前2655年的古代美索不達米亞。由結束了不老不死靈草的探索的「天之楔·賢王吉爾伽美什」所統治，以繁榮而自豪的烏魯克之地，在三柱女神及眾多魔獸的蹂躪下面臨滅亡的危機。以及，通過前往過去的時間旅行——「靈子轉移」而到達烏魯克之地的藤丸與瑪修，所遇到的是阻擋住魔獸猛攻的要塞都市·絕對魔獸戰線，以及人們那即使暴露於威脅之下仍然拚命求生的樣子。襲來的諸神與魔獸。以及對其反抗的人類——。',
'2022-05-27','動畫','川澄綾子','赤井俊文',
'2022-08-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/OvY_2WuGIYo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/FGO.jpg',1,5);

-- 鬼滅
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('鬼滅之刃劇場版 無限列車篇','Kimetsu no Yaiba:Mugen Ressha Hen','117',1,'《鬼滅之刃》是家人慘遭鬼殺害的少年－竈門炭治郎，為了讓化為鬼的妹妹禰豆子恢復回人 類，自願加入「鬼殺隊」的故事。以人鬼間的悲痛故事、驚心動魄的劍戰，以及偶然穿插的 滑稽場景，贏得廣大人氣，不僅紅遍日本，更掀起全球觀眾的熱烈討論。',
'2022-05-27','動畫','花江夏樹、松岡禎丞','外崎春雄',
'2022-08-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/yUmtCIeQEyo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/Kimetsu.jpg',1000,5000);

-- 賽道狂人
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('賽道狂人','Ford v Ferrari','152',0,'曾獲奧斯卡殊榮的金獎得主麥特戴蒙和金球獎影帝克里斯汀貝爾即將共同出演《賽道狂人》，電影根據真實事件改編，劇情描述來自美國的汽車設計師卡洛謝爾比（麥特戴蒙 飾演）和無所畏懼的英國賽車手肯邁爾斯（克里斯汀貝爾 飾演），兩人聯手對抗企業干預、打破物理定律，同時面對他們各自的心魔，最後為福特汽車打造出一輛革命性新款賽車，更在1966年於法國舉辦的利曼24小時耐力賽中，一舉擊敗當時的賽車界霸主法拉利。',
'2022-07-27','動作','克里斯汀貝爾(Christian Bale)、麥特戴蒙(Matt Damon)、強柏恩瑟(Jon Bernthal)、喬許盧卡斯(Josh Lucas)、諾亞朱佩(Noah Jupe)、特雷西萊特(Tracy Letts)','詹姆士曼格(James Mangold)',
'2022-08-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/_rjNH0CZW-g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/Ford v Ferrari.jpg',50,200);

-- 神力女超人
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('神力女超人','Wonder Woman','141',1,'在成為神力女超人之前，她是戴安娜，一名從小被訓練成為英勇戰士的亞馬遜公主。自幼生長在與世隔絕的天堂小島，卻從一名墜機在小島附近海域的美國飛行軍官告訴她，小島以外的世界正經歷一場全球性的大規模武力衝突，戴安娜毅然離開家園，她深信自己有能力阻止這場戰爭。在第一次世界大戰中，她為正義而戰，戴安娜將會發現自己真正的力量…與她與生俱來的天命。',
'2022-05-27','動作','克里斯潘恩(Chris Pine)、蓋兒加朵(Gal Gadot)、麗莎拉文康斯里(Lisa Loven Kongsli)、康妮尼爾森(Connie Nielsen)','派蒂珍金斯(Patty Jenkins)',
'2022-08-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/aodDSkV94CI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/WM.jpg',100,500);

-- 星際效應
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('星際效應','Interstellar','169',1,'故事描述一群探險家運用新發現的蟲洞，計劃一場遠超越過去人類太空旅行極限，展開一場遙遠距離的星際航行。該片請來蟲洞理論大師基普索恩作為顧問。主要演員包含馬修麥康納、安海瑟威、潔西卡雀絲坦及米高肯恩。',
'2022-05-27','科幻','馬修麥康納(Matthew McConaughey)、安海瑟威(Anne Hathaway)、艾倫鮑絲汀(Ellen Burstyn)、麥肯基弗依(Mackenzie Foy)、約翰李斯高(John Lithgow)、提摩西夏勒梅(Timothée Chalamet)、大衛歐洛沃(David Oyelowo)','克里斯多福諾蘭(Christopher Nolan)',
'2022-08-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/g0mWHu0KAJA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/Interstellar.jpg',50,250);

-- 天能
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('天能','Tenet','149',1,'時間將至。克里斯多福諾蘭編導，卡司羅伯派汀森、約翰大衛華盛頓主演。這不是時空旅行，而是逆轉未來。全新主角必須僅靠一個字「天能」，在順向與逆轉的時空中，為地球全人類的存亡誓死奮戰。',
'2022-05-27','劇情',' 亞倫泰勒強森(Aaron Taylor-Johnson) 、 羅伯派汀森(Robert Pattinson) 、 肯尼斯布萊納(Kenneth Branagh)、伊莉莎白戴比基(Elizabeth Debicki)、米高肯恩(Michael Caine)、克蕾曼絲波西(Clémence Poésy)、約翰大衛華盛頓(John David Washington)、傑佛遜豪爾(Jefferson Hall)','克里斯多福諾蘭(Christopher Nolan)',
'2022-08-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/nSJ7qPLjcQ4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/TENET.jpg',10,50);
-- 鋼鐵人
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('鋼鐵人','Iron Man','125',1,'【鋼鐵人】是Marvel動漫系列的最新動作強片。故事主人翁東尼史塔克（小勞勃道尼飾）是一位身價億萬的企業家，同時還是一位天才發明家。他身為美國政府頂尖武器承包商「史氏工業」的總裁，幾十年來因保護美國的全球利益而享有極高聲望。此時，東尼令人稱羨的生活出現三百六十度的大轉變；他的隊員遭到武器測試的攻擊，而他也被一群暴徒挾持淪為人質。',
'2022-07-27','動作','小勞勃道尼(Robert Downey Jr.)、葛妮絲派特羅(Gwyneth Paltrow)','強法洛(Jon Favreau)',
'2022-08-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/F-LOP37YkAw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/IRONMAN.jpg',10,50);


-- 黑暗騎士
insert into movie(MV_NAME, MV_E_NAME, MV_LONG, MV_LEVEL, MV_DT, MV_ST_DATE,
 MV_TYPE, MV_CAST, MV_DRT, MV_ED_DATE, MV_TLER,MV_PICTURE,MV_TT_CM,MV_TT_STAR)
values('黑暗騎士','The Dark Knight','152',1,'蝙蝠俠全力打擊犯罪活動，這次加上正義警官吉姆戈登和地方檢察官哈維丹特的鼎力相助，蝙蝠俠蓄勢待發剷除危害高譚市的犯罪組織。蝙蝠俠與兩位官方人物的合作雖然更具優勢，不過他們很快就發現自己成為敵人鎖定的目標，此人便是高譚市居民聞之喪膽的「小丑」（Joker），正是勢力漸大的犯罪組織首領。他在高譚市掀起一片混亂，使得替天行道的除惡英雄蝙蝠俠再次出擊。',
'2022-05-27','劇情','克里斯汀貝爾(Christian Bale)、希斯萊傑(Heath Ledger)、亞倫艾克哈特(Aaron Eckhart)、米高肯恩(Michael Caine)、瑪姬葛倫霍(Maggie Gyllenhaal)、蓋瑞歐德曼(Gary Oldman)、摩根費里曼(Morgan Freeman)','克里斯多福諾蘭(Christopher Nolan)',
'2022-09-27','<iframe width="560" height="315" src="https://www.youtube.com/embed/8gXj5SzLieI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>','/mvPicture_upload/DK.jpg',10,50);


/*
廳院測試資料 
 row*col = 橫排*直列
*/

-- 數位超大廳 
insert into hall (HL_NAME, HL_SEAT, HL_ROW, HL_COL, HL_TYPE, HL_SEATCOUNT)
values('數位超大廳','010110102101030010410105101061010710108101091011000111101121020110202102030020410205102061020710208102091021000211102121030110302103030030410305103061030710308103091031000311103121040110402104030040410405104061040710408104091041000411104121050110502105030050410505105061050710508105091051000511105121060110602106030060410605106061060710608106091061000611106121070100702007030070400705007060070700708007090071000711007120080130802308030080430805308063080730808308093081000811308123090110902109030090410905109061090710908109091091000911109121100111002110030100411005110061100711008110091101001011110121110111102111030110411105111061110711108111091111001111111121120111202112030120411205112061120711208112091121001211112121130111302113030130411305113061130711308113091131001311113121140111402114030140411405114061140711408114091141001411114121150111502115030150411505115061150711508115091151001511115121'
,15,12,0,140);

-- 數位震撼廳 
insert into hall (HL_NAME, HL_SEAT, HL_ROW, HL_COL, HL_TYPE, HL_SEATCOUNT)
values('數位震撼廳','010110102101030010410105101061010710108101091011000111101121020110202102030020410205102061020710208102091021000211102121030110302103030030410305103061030710308103091031000311103121040110402104030040410405104061040710408104091041000411104121050100502005030050400505005060050700508005090051000511005120060110602106030060410605106061060710608106091061000611106121070110702107030070410705107061070710708107091071000711107121080110802108030080410805108061080710808108091081000811108121090110902109030090410905109061090710908109091091000911109121100131002310030100431005310063100731008310093101001011310123'
,10,12,0,90);

-- IMAX豪華A廳 
insert into hall (HL_NAME, HL_SEAT, HL_ROW, HL_COL, HL_TYPE, HL_SEATCOUNT)
values('IMAX豪華A廳','010110102101031010410105101060010700108101091011010111101121020110202102031020410205102060020700208102091021010211102121030110302103031030410305103060030700308103091031010311103121040110402104031040410405104060040700408104091041010411104121050110502105031050410505105060050700508105091051010511105121060110602106031060410605106060060700608106091061010611106121070110702107031070410705107060070700708107091071010711107121080110802108031080410805108060080700808108091081010811108121090110902109031090410905109060090700908109091091010911109121100131002310033100431005310060100701008310093101031011310123'
,10,12,1,100);



/*
許願池
*/
-- Need MV_ID
INSERT INTO `movietheater`.`wishing_pond` 
	(`WISH_NO`,`WISH_NAME`, `WISH_START`, `WISH_END`, `TOP_ONE`) VALUES 
    (1, "母親節票選", "2022-05-01", "2022-05-20", 5),
    (2, "端午節票選", "2022-06-01", "2022-06-30", 10),
    (3, "日頭赤炎炎", "2022-06-01", "2022-06-10", 6),
    (4, "隨人顧性命", "2022-06-11", "2022-06-20", 2),
    (5, "沖脫泡蓋送", "2022-06-21", "2022-06-30", 10),
    (6, "濕搓沖捧擦", "2022-07-01", "2022-07-04", 6),
    (7, "定靜安慮得", "2022-07-01", "2022-07-06", 2);
    
    /*
許願池明細
*/
-- Need MV_ID
INSERT INTO `movietheater`.`wishing_list` 
	(`WISH_NO`, `MV_ID`, `WISH_COUNT`) VALUES 
    (1, 1, 80),
    (1, 2, 64),
    (1, 3, 33),
    (1, 4, 40),
    (1, 5, 100),
    (2, 6, 70),
    (2, 7, 78),
    (2, 8, 39),
    (2, 9, 34),
    (2, 10, 92),
    (2, 11, 12),
    (2, 12, 34),
    (3, 6, 70),
    (3, 9, 23),
    (3, 10, 39),
    (3, 11, 34),
    (4, 1, 80),
    (4, 2, 94),
    (4, 3, 65),
    (5, 6, 70),
    (5, 7, 78),
    (5, 8, 39),
    (5, 9, 34),
    (5, 10, 92),
    (5, 11, 12),
    (5, 12, 34),
	(6, 6, 70),
    (6, 9, 23),
    (6, 10, 39),
    (6, 11, 34),
	(7, 1, 80),
    (7, 2, 94),
    (7, 3, 65);

/*
許願池回覆
*/
-- Need MEMBER_ID
INSERT INTO `movietheater`.`wish_reply` 
	(`WISH_NO`, `MEMBER_ID`, `WISH_MSG`) VALUES 
    (1, 2, '太棒了'),
    (1, 2, '希望能上教父!!'),
    (1, 2, '巨人萬歲!'),
    (1, 5, '加油'),
    (1, 6, '能再上魔戒三部曲嗎?'),
    (1, 10, '希望能上教父!!'),
    (1, 3, '巨人萬歲!'),
    (1, 8, '加油'),
    (1, 7, '得第一!'),
    (2, 5, '加油'),
    (2, 6, '得第一!'),
    (2, 10, '希望能上教父!!'),
    (2, 3, '巨人萬歲!'),
    (2, 8, '加油'),
    (2, 7, '得第一!');





/* 影城資訊 */
insert into movietheater.cnm_inf(CNM_DT, CNM_TEL, CNM_EM, CNM_LC, CNM_TRP)
value('共計5個影廳，2個一般數位廳、2個IMAX巨幕影廳及1個尊爵天龍頂級影廳，共計詐854個座位。
		全影城放映機皆為4K雷射投影，皆採高對比雷射放映機。
		音響部分則全是隱藏式 7.1 環繞音響，將呈現精緻達到4迴路音響效果，影迷入場後看不到配置音響，會更感受到整座影廳的氣派空間感。座椅全採用尊榮皮質座椅，讓影迷看電影簡直就像在搭乘頭等艙。
		為滿足VIP客人，本影城推出的『IMAX尊爵天龍廳』，提供超越想像舒適的皮革尊榮座椅，與精緻餐點及專人服務。', 
        '02-2345678', 
        'staff@hireme.com', 
        '台北市某某區提拔米路1號', 
        '捷運: OO站2號出口; 公車: 123/234號至提拔米路口下車');
        

/* 評論區 */
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(1, 1, 'AAAAAAAAAAAAAAAAABBBBBBBBBBBBCCCCCCCCCCCCC', 100, 1, 0, '2022-01-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(2, 1, 'AAAAAAAAAAAAAAAAABBBBBBBBBBBBCCCCCCCCCCCCC', 10, 1, 2, '2022-02-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(3, 1, 'AAAAAAAAAAAAAAAAABBBBBBBBBBBBCCCCCCCCCCCCC', 1, 1, 1, '2022-05-23 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(1, 2, 'AAAAAAAAAAAAAAAAABBBBBBBBBBBBCCCCCCCCCCCCC', 100, 1, 0, '2022-01-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(2, 2, 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB', 10, 1, 2, '2022-02-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(3, 2, 'CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC', 1, 1, 1, '2022-05-23 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(1, 3, 'WWWWWWWWWWWWWWWWWWWWWWWWWW', 100, 1, 0, '2022-01-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(2, 3, 'FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF', 10, 1, 2, '2022-02-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(3, 3, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa', 1, 1, 1, '2022-05-23 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(1, 4, '.........................................', 100, 1, 0, '2022-01-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(2, 4, '謝謝大大無私地分享謝謝大大無私地分享謝謝大大無私地分享謝謝大大無私地分享謝謝大大無私地分享', 99, 5, 0, '2022-02-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(3, 4, 'ddddddddddddddddddddddd', 1, 1, 0, '2022-02-23 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(1, 5, 'AAAAAAAAAAAAAAAAABBBBBBBBBBBBCCCCCCCCCCCCC', 1, 1, 2, '2022-05-26 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(2, 5, '潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ', 20, 5, 0, '2022-05-17 10:40:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(3, 5, '潮好看ㄉ', 49, 5, 0, '2022-05-27 11:29:32');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(4, 5, '絕對魔獸戰線不是TV版嗎怎麼會在電影院上', 23, 4, 0, '2022-05-28 18:09:02');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(1, 6, '大哥沒有輸', 99, 5, 0, '2022-06-01 11:37:17');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(2, 6, '大哥沒有輸大哥沒有輸大哥沒有輸', 99, 5, 0, '2022-06-02 12:37:17');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(3, 6, '大哥死了', 99, 5, 1, '2022-06-03 13:37:17');
insert into movietheater.cmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE)
value(8, 8, '想被踩', 15, 5, 2, '2022-05-29 10:42:22');

-- 票價資訊假資料
INSERT INTO `movietheater`.`tk_inf` (`TK_TYPE`,`TK_PRICE`,`TK_DI`,`TK_TYPE_DT`)
VALUES ('全票',300,0,'數位'),
('全票',360,1,'IMAX'),
('學生票',280,0,'數位，須在驗票時出示證件'),
('學生票',340,1,'IMAX，須在驗票時出示證件'),
('敬老票',260,0,'數位，須在驗票時出示證件'),
('敬老票',320,1,'IMAX，須在驗票時出示證件');

-- 餐飲資訊假資料 
INSERT INTO `movietheater`.`fd_inf` (`FD_TYPE`,`FD_NAME`,`FD_PRICE`,`FD_DT`,`FD_STATE`)
VALUES (0,'可樂(中)',40,'600ml',1),
(0,'可樂(小)',20,'250ml' ,1),
(0,'雪碧(中)',40,'600ml' ,1),
(0,'雪碧(小)',20,'250ml',1),
(1,'爆米花(大)',80,'桶裝',1),
(1,'爆米花(中)',50,'盒裝',1);

-- 票夾用驗證碼假資料
INSERT INTO `movietheater`.`code` (`CODE`)
VALUES (1234);


/*
建置活動方案明細 假資料
*/
insert into movietheater.activity_detail(ACT_ID, ACT_DATE_START, ACT_TITLE, ACT_SUBTITLE, TK_TYPE_ID, ACT_DISCOUNT, ACT_COUPON, ACT_STATUS,ACT_CONTENT, ACT_PICTURE) value
(1, '2022-03-14','未符合','原價', 1, 1, 0, 1,'未符合活動方案','/act_pic/act_1.jpg'),
(1, '2022-03-14','未符合','原價',  2, 1, 0, 1,'未符合活動方案','/act_pic/act_1.jpg'),
(1, '2022-03-14','未符合','原價',  3, 1, 0, 1,'未符合活動方案','/act_pic/act_1.jpg'),
(1, '2022-03-14','未符合','原價',  4, 1, 0, 1,'未符合活動方案','/act_pic/act_1.jpg'),
(1, '2022-03-14','未符合','原價',  5, 1, 0, 1,'未符合活動方案','/act_pic/act_1.jpg'),
(1, '2022-03-14','未符合','原價',  6, 1, 0, 1,'未符合活動方案','/act_pic/act_1.jpg'),
(2, '2022-03-14','開幕慶方案','HIREME開幕慶', 1, 1, -50, 2,'大家期待已久的「嗨邇覓影城」，確定將於05/26正式開幕！凡於當日入場看電影，皆享50元電影票折價優惠 !','/act_pic/act_2.jpg'),
(2, '2022-03-14','開幕慶方案','HIREME開幕慶', 2, 1, -50, 2,'大家期待已久的「嗨邇覓影城」，確定將於05/26正式開幕！凡於當日入場看電影，皆享50元電影票折價優惠 !','/act_pic/act_2.jpg'),
(2, '2022-03-14','開幕慶方案','HIREME開幕慶', 3, 1, -50, 2,'大家期待已久的「嗨邇覓影城」，確定將於05/26正式開幕！凡於當日入場看電影，皆享50元電影票折價優惠 !','/act_pic/act_2.jpg'),
(2, '2022-03-14','開幕慶方案','HIREME開幕慶', 4, 1, -50, 2,'大家期待已久的「嗨邇覓影城」，確定將於05/26正式開幕！凡於當日入場看電影，皆享50元電影票折價優惠 !','/act_pic/act_2.jpg'),
(2, '2022-03-14','開幕慶方案','HIREME開幕慶', 5, 1, -50, 2,'大家期待已久的「嗨邇覓影城」，確定將於05/26正式開幕！凡於當日入場看電影，皆享50元電影票折價優惠 !','/act_pic/act_2.jpg'),
(2, '2022-03-14','開幕慶方案','HIREME開幕慶', 6, 1, -50, 2,'大家期待已久的「嗨邇覓影城」，確定將於05/26正式開幕！凡於當日入場看電影，皆享50元電影票折價優惠 !','/act_pic/act_2.jpg'),
(3,'2022-05-25','夏日方案','夏日觀影趣 樂FUN一下', 1, 1, -20, 1,'凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠','/act_pic/act_3.jpg'),
(3,'2022-05-25','夏日方案','夏日觀影趣 樂FUN一下', 2, 1, -20, 1,'凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠','/act_pic/act_3.jpg'),
(3,'2022-05-25','夏日方案','夏日觀影趣 樂FUN一下', 3, 1, -20, 1,'凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠','/act_pic/act_3.jpg'),
(3,'2022-05-25','夏日方案','夏日觀影趣 樂FUN一下', 4, 1, -20, 1,'凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠','/act_pic/act_3.jpg'),
(3,'2022-05-25','夏日方案','夏日觀影趣 樂FUN一下', 5, 1, -20, 1,'凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠','/act_pic/act_3.jpg'),
(3,'2022-05-25','夏日方案','夏日觀影趣 樂FUN一下', 6, 1, -20, 1,'凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠','/act_pic/act_3.jpg'),
(4,'2022-06-01','IMAX促銷方案','看IMAX享折扣', 2, 0.95, 0, 1,'看電影！2022強檔大爆發 IMAX熱映發燒電影，購買IMAX電影票者，享95折優惠。','/act_pic/act_4.jpg'),
(4,'2022-06-01','IMAX促銷方案','看IMAX享折扣',4, 0.95, 0, 1,'看電影！2022強檔大爆發 IMAX熱映發燒電影，購買IMAX電影票者，享95折優惠。','/act_pic/act_4.jpg'),
(4,'2022-06-01','IMAX促銷方案','看IMAX享折扣', 6, 0.95, 0, 1,'看電影！2022強檔大爆發 IMAX熱映發燒電影，購買IMAX電影票者，享95折優惠。','/act_pic/act_4.jpg'),
(5, '2022-06-01','學生防疫促銷方案','早安❤ 學生防疫新生活！安心看電影！！', 3, 0.9, 0, 1,'共同防疫由你我做起！！為促進分流，6月至10月凡購買學生票者，一律再打9折優惠！','/act_pic/act_5.jpg'),
(5, '2022-06-01','學生防疫促銷方案','早安❤ 學生防疫新生活！安心看電影！！', 4, 0.9, 0, 1,'共同防疫由你我做起！！為促進分流，6月至10月凡購買學生票者，一律再打9折優惠！','/act_pic/act_5.jpg');


/*商城商品*/
INSERT INTO `movietheater`.`merchandise_inf` (`MERCH_NAME`,`MERCH_DT`,`MERCH_PRICE`,`MERCH_CLASS`,`SOLD_TOTAL`,`MERCH_STATUS`,`MERCH_STOCK`)
values ('巴斯光年 太空騎警巴斯光年','<br> - 精心製作，細緻還原巴斯於《巴斯光年》電影中的造型設計<br> - 一個全新打造戴紫色頭套的巴斯頭雕，配備可動眼球 (Separate Rolling Eyeballs)<br> - 擬真度高的塗裝技術以突顯出其面部表情及皮膚紋理<br> - 深度舊化塗裝以突顯出印有特別徽章的白、綠太空裝甲連紫色線條及磨損細節<br> - 多達 30 個可動關節素體<br> - 約 29.5cm 高<br>',8100,'模型',100,1,999),
('哆啦A夢 陶瓷雲燈','●商品廠牌：Macott Station 美光站 <br> ●商品尺寸：高27.5cm x 長32cm x 寬25cm <br> ●商品材質：多啦A夢 PVC、雲朵 高級陶瓷 <br> ●商品說明：「多啦A夢LightingCloud」陶瓷雲燈，既是精緻的家品擺設亦是燈具，以極窩心的姿態給都市人送上點點亮光。多啦A夢微笑躺睡的樣子，既暖心又治癒心靈！雲朵經USB充電後可發光，共有三級亮度可供調校。充滿電的雲燈可隨意安放於家中任何角落，既可作為床頭小夜燈，亦可放在書桌伴讀，就像夜空中的星月，守護着長夜漫漫。',12000,'生活用品',100,2,999),
('鬼滅之刃 掌中禰豆子','●商品廠牌：Megahouse 百萬屋 <br> ●商品類型：已塗裝靜態完成品 <br> ●商品尺寸：全長約120mm',1980,'模型',100,1,999),
('鬼滅之刃 無限列車 煉獄杏壽郎&猗窩座',' ●商品尺寸：煉獄杏壽郎約150mm /猗窩座約180mm <br> ●商品材質：ABS、PVC製',3980,'模型',100,1,999),
('復仇者聯盟 ：終局之戰 戰損馬克50頭盔','取材自《復仇者聯盟:終局之戰》中，東尼一行人在泰坦星球為了給薩諾斯出其不意地突擊，反被他將時間寶石搶走，引發後續一連串的彈指事件，到了《復仇者聯盟：終局之戰》電影一開頭看見東尼對著損壞的「馬克50」頭盔錄下最後的遺言，畫面是如此絕望且悲壯，深刻烙印在所有影迷心中！ <br><br>「Master craft 極匠系列」延續精工之美，專注雕刻產品細節，力求還原電影經典場景，將劇中戰損的「馬克50」頭盔，以手工打模雕刻搭配上烤漆等級上色工藝製作，並將其戰鬥後破損的細節完美還原，眼睛部分亦具有發光機制，是身為資深漫威迷絕不能錯過的夢幻逸品！',9800,'服飾',100,1,999),
('鬼滅之刃炭治郎絨毛娃娃玩偶','尺寸約：寬20x高30x厚17cm <br> 材質：絨毛、聚酯纖維 <br> 產地：中國製 <br>提醒您商品所呈現顏色會因電腦螢幕不同而有差異，以實際色彩為準，介意色調者請考慮清楚喔~',590,'抱枕',100,1,999),
('鬼滅之刃禰豆子絨毛娃娃玩偶','尺寸約：寬20x高30x厚17cm <br> 材質：絨毛、聚酯纖維 <br> 產地：中國製 <br>提醒您商品所呈現顏色會因電腦螢幕不同而有差異，以實際色彩為準，介意色調者請考慮清楚喔~',590,'抱枕',100,1,999),
('蠟筆小新 野原新之助','●商品廠牌：BANPRESTO <br> ●商品尺寸：高約18cm',499,'模型',100,1,999),
('PLUS LUFFY TREASURE GOLD EDITION 海賊王 魯夫','●商品尺寸：高約20cm',5480,'模型',100,2,999),
('Figuarts ZERO 超激戰 海賊王 百獸凱多','●商品廠牌：TAMASHII 魂 <br> ●商品類型：已塗裝靜態完成品 <br> ●商品尺寸：約32cm',3500,'模型',100,2,999),
('DXF 海賊王 THE GRANDLINE MEN 和之國 vol.1 紅髮傑克 小時候','●商品廠牌：BANPRESTO <br> ●商品尺寸：約9cm <br> ●商品說明：已塗裝靜態完成品',380,'模型',101,2,999),
('超合金 海賊王 千陽號','●商品類型：已塗裝可動完成品 <br> ●商品說明：全長：約350mm /全高：約380mm <br> ●商品材質：ABS、PVC',6000,'模型',100,2,999),
('海賊王 MANHOOD 白鬍子 艾德華紐蓋特 ver.A','●商品廠牌：BANPRESTO <br> ●商品類型：已塗裝靜態完成品 <br> ●商品尺寸：約9cm',480,'模型',199,2,999),
('哆啦A夢 雲朵小夜燈','●商品廠牌：Macott Station 美光站 <br> ●商品尺寸：高31.5cm x 長17cm x 寬21.5cm <br> ●商品材質：PVC、ABS、高檔玻璃 <br> ●商品材質：雲朵經充電後可發光，分別又四個燈光擋位可供切換 - 低亮度、中亮度、高亮度、呼吸燈效果，暖色燈光不刺眼，小夜燈下的哆啦A夢更平添一份恬靜，也給了你黑夜裏滿滿的安全感，安心陪伴你的每晚睡眠。',7680,'生活用品',20,1,999),
('MMS655 雷神索爾：愛與雷霆 雷神索爾','● 忠實且細緻地還原電影《雷神索爾：愛與雷霆》雷神索爾造型設計 <br> ● 一個雷神索爾超擬真頭雕 <br> ● 眼部位置特別飾有特效塗裝還原雷神索爾發威的狀態 <br> ● 擬真度高的塗裝技術以突顯出其皮膚紋理 <br> ● 細緻雕塑出咖啡色長髮紋理 <br> ● 約 32 cm高 <br> ● 全新打造多達 30 個可動關節',8500,'模型',120,1,999),
('7J玩具銀行 鋼鐵人 MARK50 1/1 可穿戴收藏級頭盔 cosplay 道具','尺寸：高約48cm <br> 材質：Vinyl, PVC',6980,'服飾',80,1,999),
('鬼滅之刃 戒指套組 珠寶指甲戒指 女士配件 jeweller jeweller','●物品狀況： 全新 <br> ●物品所在地： CN,foshan',800,'服飾',200,1,999),
('熱賣の海賊王cos服火拳艾斯和服全套現貨二次元角色扮演服裝','●物品狀況： 全新 <br> ●物品所在地： CN,foshan',1400,'服飾',30,1,999),
('漫威死侍電影cos韋德·威爾遜緊身衣連體衣cosplay服裝','品牌:Manles/漫天際 <br> 適用年齡:14周歲以上 <br> COS男裝分類:套裝 <br> 作品地區:歐美 <br> 顏色分類:衣服,頭套,配飾,全套 <br> 出售狀態:定做 <br> 作品來源:影視',3000,'服飾',88,1,999),
('熱賣の哈利波特系列魁地奇COS服游戲動漫角色扮演死亡聖器披風電影周邊','面料/材質：滌綸/滌綸（聚酯纖維） <br> 成分含量：91%（含）—95%（含） <br> 適用年齡：青年（18-25周歲）',600,'服飾',66,1,999),
('復聯4 盾牌紅五星圓盾道具PU橡膠電影周邊武器道具','商品名稱	美盾 <br> 產品重量	442克 <br> 產品尺寸	45CM',650,'服飾',65,1,999),
('蜘蛛俠毒液外套衛衣電影周邊休閑寬松復仇者聯盟帶帽秋冬外穿衣服','品牌：FrdunTommy/法頓湯米面料/材質：滌綸/滌綸（聚酯纖維）<br> 成分含量：91%（含）—95%（含） <br> 穿著方式：套頭 <br> 服裝款式細節：印花 <br> 風格：休閑 <br> 適用年齡：青年（18-25周歲） <br> 領型：連帽',1250,'服飾',50,1,999),
('棋魂正版周邊馬克杯進藤光塔矢亮藤原佐為動漫陶瓷水杯子學生漫畫','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',500,'生活用品',300,1,999),
('x戰警 x2電影斯坦因馬克杯 漫威 北極巨人 風暴 金剛狼 俠盜2003','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',800,'生活用品',400,1,999),
('關于我轉生成為史萊姆的那件事書包 動漫雙肩包 萌王團子周邊背包','適用年齡: 8周歲以上 <br> 材質: 尼龍 <br> 適用性別: 通用',1300,'生活用品',150,1,999),
('鬼滅之刃動漫畫cos周邊同款帆布袋子手提學生單肩背包','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',500,'生活用品',110,2,999),
('海賊王書包男背包路飛動漫二次元周邊索隆路飛白胡子羅學生雙肩包','品牌:威游 <br> 型號:X2JB004 <br> 適用年齡:8周歲以上 <br> 材質:牛津布 <br> 適用性別:通用',450,'生活用品',100,2,999),
('咒術回戰周邊抱枕頭五條悟虎杖悠仁動漫','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',800,'抱枕',100,2,999),
('千代COS】排球少年正版周邊抱枕動漫二次元靠墊方形枕禮物午睡枕頭學生男女','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',700,'抱枕',80,1,999),
('禰豆子炭治郎我妻善逸富岡義勇伊之助蝴蝶忍 雙面印花抱枕靠墊','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',200,'抱枕',600,2,999),
('【淺墨】東京食尸鬼/喰種RE正版周邊U型枕金木研旅行枕睡枕護頸午睡靠枕頭','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',300,'抱枕',200,1,999),
('動漫文具板夾從零開始的異世界生活','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',800,'文具',10,1,999),
('原派蒙神周邊簽字筆寫字筆文具學生動漫金屬中性筆','品牌: 漫宅坊 <br> 型號: 派蒙金屬中性筆 <br> 適用年齡: 14周歲以上',490,'文具',20,1,999),
('鬼滅之刃眼鏡盒眼鏡收納盒','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',100,'文具',30,1,999),
('鬼滅之刃動漫筆袋灶門炭治郎文具盒禰豆子二次元鉛筆盒','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',600,'文具',60,1,999),
('空白動漫二次元收納袋學生文具辦公資料夾','物品狀況： 全新 <br> 物品所在地： 台灣.新北市',250,'文具',30,1,999),
('火影忍者正版周邊筆記本動漫學生記事本A5日記文具本子鳴人佐助鼬','物品狀況： 全新 <br> 物品所在地： 台灣.新北市 <br> 隨機發貨',150,'文具',20,1,999);