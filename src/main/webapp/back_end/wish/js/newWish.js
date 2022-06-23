let movies = [];
const movie1 = { 'name': '劇場版 咒術迴戰 0', 'img': '1.jpg', 'level': 2, 'type': '動畫', 'story': '故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚，並且要永遠再一起…。但里香卻在一場車禍中橫死，死後化為強大怨靈依附在乙骨身邊，為此所苦的乙骨，甚至一心求死。終於，在五條悟的帶領下，乙骨憂太進入咒術高專學習咒術，讓他結識了新同學：禪院真希、狗卷棘與熊貓，他漸漸打開心防並決定在這裡找到活下去的自信與解開里香詛咒的方法；另一方面，主張全面殲滅非術師的夏油傑宣布發動「百鬼夜行」，要在新宿與京都釋放出千隻詛咒。為此，咒術高專傾盡所有人力阻止夏油傑的野心，被捲入這場爭鬥中的咒術高專一年級生乙骨能否阻止夏油傑的野心並且順利地解開里香的詛咒？' }
const movie2 = { 'name': '怪獸與鄧不利多的秘密', 'img': '2.jpg', 'level': 1, 'type': '奇幻', 'story': '阿不思鄧不利多教授（裘德洛 飾演）知道強大的黑巫師蓋勒葛林戴華德（邁茲米克森 飾演）正準備控制整個魔法世界，但他深知自己無法單獨阻止葛林戴華德，於是委託奇獸飼育學家紐特斯卡曼德（艾迪瑞德曼 飾演）帶領一群勇敢的巫師、女巫和一位麻瓜烘焙師進行這項危險任務。他們在任務中將會遇到新舊奇獸，並與更多葛林戴華德的追隨者發生衝突，但隨著任務風險越來越高，鄧不利多還能置身事外到什麼時候呢？' }
const movie3 = { 'name': '進擊的巨人 劇場版:覺醒的咆哮', 'img': '3.jpg', 'level': 2, 'type': '動畫', 'story': '城牆為何要存在？戰士又是誰？真實的正義到底在哪裡？自從超大型巨人出現，人類的和平與幻影遭到破滅的那一天起，艾連‧葉卡從此展開無止盡的奮戰歲月……。親眼看著無力抵抗、只能成為巨人餌食的母親臨終慘狀，艾連發誓要殺光這個世界裡的巨人，一具也不留。但在激烈的奮戰過程中，他自己竟然也變成了巨人……。為贏回人類自由而發揮巨人力量的艾連，在席納之牆的史托黑斯區裡，與「女巨人」正面激戰。在同為巨人之間的慘烈對戰下，艾連勉強贏得了勝利。儘管如此，艾連與人類仍沒有時間喘息，因為下一場戰爭已宣告開始。面對逼往羅塞之牆而來的巨人大軍，人類該如何對抗！？信念、衝突、命運 現在起，激烈撞擊' }
const movie4 = { 'name': '福音戰士新劇場版：Q', 'img': '4.jpg', 'level': 2, 'type': '動畫', 'story': '本集接續著第二集《破》的劇情展開。明日香戴著眼罩重新復活，而真嗣在戰鬥中使初號機完全覺醒，在初號機頭上出現的天使光環，暗示人類將遭遇更可怕的第三次衝擊。懵懂的真嗣返回了千瘡百孔的NERV總部，並意外重逢朝思夜想的綾波，還從父親那裡得知自己將和美少年渚薰共同駕駛十三號機。長達14年的空白，期間的滄桑巨變和情感糾葛，讓真嗣不知所措。而看似溫柔的渚薰為他揭開了種種難以置信的真相……為每個人不可預知的未來，做最後一章《？》的鋪路' }
const movie5 = { 'name': '賽道狂人', 'img': '5.jpg', 'level': 0, 'type': '動作', 'story': '曾獲奧斯卡殊榮的金獎得主麥特戴蒙和金球獎影帝克里斯汀貝爾即將共同出演《賽道狂人》，電影根據真實事件改編，劇情描述來自美國的汽車設計師卡洛謝爾比（麥特戴蒙 飾演）和無所畏懼的英國賽車手肯邁爾斯（克里斯汀貝爾 飾演），兩人聯手對抗企業干預、打破物理定律，同時面對他們各自的心魔，最後為福特汽車打造出一輛革命性新款賽車，更在1966年於法國舉辦的利曼24小時耐力賽中，一舉擊敗當時的賽車界霸主法拉利。' }
const movie6 = { 'name': '神力女超人', 'img': '6.jpg', 'level': 1, 'type': '動作', 'story': '在成為神力女超人之前，她是戴安娜，一名從小被訓練成為英勇戰士的亞馬遜公主。自幼生長在與世隔絕的天堂小島，卻從一名墜機在小島附近海域的美國飛行軍官告訴她，小島以外的世界正經歷一場全球性的大規模武力衝突，戴安娜毅然離開家園，她深信自己有能力阻止這場戰爭。在第一次世界大戰中，她為正義而戰，戴安娜將會發現自己真正的力量…與她與生俱來的天命。' }
const movie7 = { 'name': '星際效應', 'img': '7.jpg', 'level': 1, 'type': '科幻', 'story': '故事描述一群探險家運用新發現的蟲洞，計劃一場遠超越過去人類太空旅行極限，展開一場遙遠距離的星際航行。該片請來蟲洞理論大師基普索恩作為顧問。主要演員包含馬修麥康納、安海瑟威、潔西卡雀絲坦及米高肯恩。' }
movies.push(movie1);
movies.push(movie2);
movies.push(movie3);
movies.push(movie4);
movies.push(movie5);
movies.push(movie6);
movies.push(movie7);

const moviesBlock = document.querySelector('#movies');

showMovie();

function showMovie() {
    moviesBlock.innerHTML = '';
    let str = '';
    for (let movie of movies) {
        str += `
        <div class="movie">
            <input type="checkbox" name="checkMovie" id="${movie.name}" onclick="colorChange(this)">
            <label for="${movie.name}">
                <div class="inner">
                    <h3>${movie.name}</h3>
                    <img src="/CGA102G1/back_end/wish/images/${movie.img}" alt=""><br> 類型: ${movie.type}<br> 分級: ${movie.level}
                </div>
            </label>
        </div>
        `;
    }
    moviesBlock.innerHTML = str;

}

function colorChange(e) {
    console.log(e.parentElement);
    if (e.parentElement.classList.contains('checked')) {
        e.parentElement.classList.remove('checked');
    } else {
        e.parentElement.classList.add('checked');
    }
}