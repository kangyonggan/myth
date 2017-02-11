<#assign ctx="${(rca.contextPath)!''}">

<link rel="stylesheet" href="${ctx}/static/app/css/book.css"/>

<div id="book-container">
    <div id="book-header">
        <div class="pull-left">
            <a href="#book" id="book-home">
                东方无神,娇子纵横!
            </a>
        </div>

        <form action="#book/search" method="get" novalidate class="pull-right">
            <input type="text" id="search-key" name="key" placeholder="输入需要搜索的小说名或作者名"/>
            <button class="btn btn-inverse btn-sm">&nbsp;&nbsp;搜&nbsp;&nbsp;&nbsp;&nbsp;索&nbsp;&nbsp;</button>
        </form>
    </div>

    <div id="book-navbar">
        <ul>
            <li><a href="#book">首页</a></li>
            <#list categories as category>
                <li><a href="#book/${category.code}">${category.value}</a></li>
            </#list>
            <li><a href="#book/finished">全本小说</a></li>
            <li><a href="#book/temp">临时书架</a></li>
        </ul>
    </div>

    <div class="space-6"></div>

    <div id="book-recommend">
        <div id="book-recommend-l">
            <div class="book-item">
                <div class="image">
                    <a href="/book/1196/">
                        <img src="http://www.biquge.cn/cover/1/1196/1196s.jpg" alt="龙王传说" width="120" height="150"/>
                    </a>
                </div>
                <dl>
                    <dt>
                        <span>唐家三少</span>
                        <a href="/book/1196/">龙王传说</a>
                    </dt>
                    <dd>
                        伴随着魂导科技的进步，斗罗大6上的人类征服了海洋，又现了两片大6。魂兽也随着人类魂师的猎杀无度走向灭亡，沉睡无数年的魂兽之王在星斗大森林最后的净土苏醒，它要带领仅存的族人，向人类复仇！唐舞麟立志要成为一名强大的魂师，可当武魂觉醒时，苏醒的，却是……旷世之才，龙王之争，我们的龙王传说，将由此开始。
                    </dd>
                </dl>
            </div>
            <div class="book-item">
                <div class="image"><a href="/book/1195/"><img src="http://www.biquge.cn/cover/1/1195/1195s.jpg"
                                                              alt="玄界之门" width="120" height="150"></a></div>
                <dl>
                    <dt><span>忘语</span><a href="/book/1195/">玄界之门</a></dt>
                    <dd> 天降神物！异血附体！
                        群仙惊惧！万魔退避！
                        一名从东洲大6走出的少年。
                        一具生死相依的红粉骷髅。
                        一个立志成为至强者的故事。
                        一段叱咤星河，大闹三界的传说。
                        忘语新书，已完本《凡人修仙传》》《魔天记》。
                    </dd>
                </dl>
                <div class="clear"></div>
            </div>
            <div class="book-item">
                <div class="image"><a href="/book/1077/"><img src="http://www.biquge.cn/cover/1/1077/1077s.jpg"
                                                              alt="巫神纪" width="120" height="150"></a></div>
                <dl>
                    <dt><span>血红</span><a href="/book/1077/">巫神纪</a></dt>
                    <dd> 当历史变成传说
                        当传说变成神话
                        当神话都已经斑驳点点
                        当时间的沙尘湮没一切
                        我们的名字，我们的故事，依旧在岁月的长河中传播
                        一如太阳高悬天空，永恒的照耀大地，永远不会熄灭
                        记住，曾经有这样的一群人，他们昂挺立在天地之间，好像擎天之柱，从没有对任何人弯腰屈膝
                        他们手握风雷，他们脚踏龙蛇，他们拳裂大地，他们掌碎星辰；他们是我们的先祖，他们和我们有同源的血脉，他们行走在大地时自称为巫，他们破碎虚空后是为巫神！
                    </dd>
                </dl>
                <div class="clear"></div>
            </div>
            <div class="book-item">
                <div class="image"><a href="/book/604/"><img src="http://www.biquge.cn/cover/0/604/604s.jpg" alt="天域苍穹"
                                                             width="120" height="150"></a></div>
                <dl>
                    <dt><span>风凌天下</span><a href="/book/604/">天域苍穹</a></dt>
                    <dd> 笑尽天下英雄，宇内我为君主！
                        天域君主叶笑，以一人之力战三大宗门，以一敌万，大杀四方，但终究寡不敌众。一朝醒来，现重生世俗界，更得到极品灵宝天晶灵髓，无尽空间。
                        这一世，他再次杀回天域，更进一步，成为苍穹主宰，纵横天下，快意恩仇，笑尽天下英雄。
                        万水千山，以我为尊；八荒六合，唯我称雄！
                        诸君与我并肩，征战这天域苍穹！
                    </dd>
                </dl>
                <div class="clear"></div>
            </div>
        </div>
        <div id="book-recommend-r">
            <h2>强势推荐</h2>
            <ul>
                <li>
                    <span class="s1">[都市]</span>
                    <span class="s2">
                        <a href="/book/1154/">特种狂医</a>
                    </span>
                    <span class="s5">楠权北腿</span>
                </li>
                <li><span class="s1">[修真]</span><span class="s2"><a href="/book/971/">仙门弃少</a></span><span class="s5">鸿蒙树</span>
                </li>
                <li><span class="s1">[都市]</span><span class="s2"><a href="/book/715/">终极教官</a></span><span class="s5">梁七少</span>
                </li>
                <li><span class="s1">[历史]</span><span class="s2"><a href="/book/668/">大明武夫</a></span><span class="s5">特别白</span>
                </li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/635/">全职法师</a></span><span
                        class="s5">乱</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/607/">御天神帝</a></span><span class="s5">乱世狂刀</span>
                </li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/545/">通天剑主</a></span><span class="s5">剑游太虚</span>
                </li>
                <li><span class="s1">[都市]</span><span class="s2"><a href="/book/334/">透视高手</a></span><span
                        class="s5">覆手</span></li>
                <li><span class="s1">[都市]</span><span class="s2"><a href="/book/127/">逆鳞</a></span><span
                        class="s5">柳下挥</span></li>
            </ul>
        </div>
    </div>

    <div class="space-6"></div>

    <div class="book-category">
        <div class="content">
            <h2>玄幻小说</h2>
            <div class="top">
                <div class="image">
                    <a href="/book/545/">
                        <img src="http://www.biquge.cn/cover/0/545/545s.jpg" alt="通天剑主" width="67" height="82"/>
                    </a>
                </div>
                <dl>
                    <dt><a href="/book/545/">通天剑主</a></dt>
                    <dd>一剑通天，剑主沉浮。 少年江辰幼年时期意外得到一部虚无剑体大法，本已资质不弱的他，自此走上漫长而传奇的武道之路。 无敌凶兽，域外生物，世界之谜，神魔传说，这只是开始。</dd>
                </dl>
            </div>
            <ul>
                <li><a href="/book/730/">最后的火龙</a>/弦月骑士</li>
                <li><a href="/book/1164/">造化炼体决</a>/零下5度01</li>
                <li><a href="/book/726/">九焰至尊</a>/爱吃白菜</li>
                <li><a href="/book/454/">天帝是怎样养成的</a>/金峰无缺</li>
                <li><a href="/book/241/">剑武独尊</a>/春秋集</li>
                <li><a href="/book/666/">诛仙神尊</a>/深海浮冰</li>
                <li><a href="/book/145/">龙傲战神</a>/零零九</li>
                <li><a href="/book/581/">养道</a>/九孔</li>
                <li><a href="/book/607/">御天神帝</a>/乱世狂刀</li>
                <li><a href="/book/296/">末世炮灰奋斗记</a>/仰秋仲伊</li>
                <li><a href="/book/646/">霸皇纪</a>/踏雪真人</li>
                <li><a href="/book/528/">穿到异界当画圣</a>/-荒原-</li>
            </ul>
        </div>
        <div class="content">
            <h2>修真小说</h2>
            <div class="top">
                <div class="image"><a href="/book/594/"><img src="http://www.biquge.cn/cover/0/594/594s.jpg" alt="盖世仙尊"
                                                             width="67" height="82"></a></div>
                <dl>
                    <dt><a href="/book/594/">盖世仙尊</a></dt>
                    <dd>“人为什么要活着？活着就是为了见识！” “走更多的路，见识更多的精彩，死了也不遗憾！” 地球来的小男生丁浩，带着他的初衷，走上了一条成为《盖世仙尊》的通天大道！</dd>
                </dl>
                <div class="clear"></div>
            </div>
            <ul>
                <li><a href="/book/305/">补天</a>/浪子刀</li>
                <li><a href="/book/655/">仙凛天下</a>/爱做梦的草莓</li>
                <li><a href="/book/304/">仙门之缘</a>/云淡天长</li>
                <li><a href="/book/82/">不朽剑神</a>/雪满弓刀</li>
                <li><a href="/book/361/">空间之旅</a>/焰色</li>
                <li><a href="/book/506/">地狱清洁工</a>/长虫</li>
                <li><a href="/book/115/">大武林世界</a>/斩魂刀</li>
                <li><a href="/book/637/">武侠世界里的剑仙</a>/九十步止</li>
                <li><a href="/book/75/">苍天教我成仙</a>/景年华</li>
                <li><a href="/book/358/">鬼门圈</a>/吉美巴林</li>
                <li><a href="/book/277/">妖神养成记</a>/苹果的种子</li>
                <li><a href="/book/111/">来自昆仑的男人</a>/热血雪人</li>
            </ul>
        </div>
        <div class="content no-border">
            <h2>都市小说</h2>
            <div class="top">
                <div class="image"><a href="/book/274/"><img src="http://www.biquge.cn/cover/0/274/274s.jpg" alt="最强狂兵"
                                                             width="67" height="82"></a></div>
                <dl>
                    <dt><a href="/book/274/">最强狂兵</a></dt>
                    <dd>一代兵王含恨离开部队，销声匿迹几年后，逆天强者强势回归都市，再度掀起血雨腥风！简单粗暴是我的行事艺术，不服就干是我的生活态度！看顶级狂少如何纵横都市，书写属于他的天王传奇！依旧极爽极热血！
                    </dd>
                </dl>
                <div class="clear"></div>
            </div>
            <ul>
                <li><a href="/book/68/">烂片之王</a>/何未满</li>
                <li><a href="/book/61/">捡宝生涯</a>/吃仙丹</li>
                <li><a href="/book/1144/">金辉岁月</a>/漂渺浪子</li>
                <li><a href="/book/715/">终极教官</a>/梁七少</li>
                <li><a href="/book/1142/">仙宝</a>/烛</li>
                <li><a href="/book/845/">天庭庄园主</a>/红薯米饭汤</li>
                <li><a href="/book/493/">深海开发商</a>/孙帅出口成诗</li>
                <li><a href="/book/1027/">硅谷大帝</a>/百刹</li>
                <li><a href="/book/633/">都市武圣</a>/河帅</li>
                <li><a href="/book/681/">极品狂少</a>/我本疯狂</li>
                <li><a href="/book/307/">我家的大明郡主</a>/老猪</li>
                <li><a href="/book/236/">超级炼宝系统</a>/闲时点根烟</li>
            </ul>
        </div>
    </div>

    <div class="space-6"></div>

    <div class="book-category">
        <div class="content">
            <h2>历史小说</h2>
            <div class="top">
                <div class="image"><a href="/book/1048/"><img src="http://www.biquge.cn/cover/1/1048/1048s.jpg"
                                                              alt="老婆是大将军" width="67" height="82"></a></div>
                <dl>
                    <dt><a href="/book/1048/">老婆是大将军</a></dt>
                    <dd>这是一个小人物回到古代，从一个默默无闻的小人物逐渐成长为人生赢家的励志故事 一个青楼小厮，被彪悍的女大将军强推了 尝尽世间百态，从此努力奋斗，生活逐渐风生水起 美人我有，小人物也能咸鱼翻身
                        谈笑间灭宋江，平方腊 天下为棋 这就是我生命不息，奋斗不止的生活！
                    </dd>
                </dl>
                <div class="clear"></div>
            </div>
            <ul>
                <li><a href="/book/292/">抗战之火线精英</a>/九耳猫</li>
                <li><a href="/book/240/">我的第三帝国</a>/龙灵骑士</li>
                <li><a href="/book/121/">百人会之关东局</a>/渔父</li>
                <li><a href="/book/609/">清末枭雄</a>/雨天下雨</li>
                <li><a href="/book/1070/">大明1617</a>/淡墨青衫</li>
                <li><a href="/book/238/">钢铁时代</a>/十年残梦</li>
                <li><a href="/book/339/">唐朝工科生</a>/鲨鱼禅师</li>
                <li><a href="/book/557/">贞观帝师</a>/石肆</li>
                <li><a href="/book/532/">董氏王朝</a>/追雪逍遥01</li>
                <li><a href="/book/497/">战辽东</a>/白河蟹</li>
                <li><a href="/book/70/">三国之袁家庶子</a>/讳岩</li>
                <li><a href="/book/323/">重生之我为唐王</a>/猪拱拱</li>
            </ul>
        </div>
        <div class="content">
            <h2>网游小说</h2>
            <div class="top">
                <div class="image"><a href="/book/716/"><img src="http://www.biquge.cn/cover/0/716/716s.jpg" alt="奥术主宰"
                                                             width="67" height="82"></a></div>
                <dl>
                    <dt><a href="/book/716/">奥术主宰</a></dt>
                    <dd>李维在玩一个全息单机游戏的时候穿越了，穿越游戏世界之中，并且现自己还带着玩这个游戏时所用的“外挂”。
                        一个由这个游戏无数的爱好者编辑，更改，实验后，所创造的“奥术补完计薄?一本记录着三百七十万种作用不同的奥术之书，涉及到到这个游戏世界中所有的领域，甚至连一些现代文明产物和其他虚拟世界也因为某些创造者的恶趣味而设立了相关的奥术分类。
                        “知识就是力量，而我终将掌握真理。” “就算神明，也比不过一名足够强大的奥术师。”
                    </dd>
                </dl>
                <div class="clear"></div>
            </div>
            <ul>
                <li><a href="/book/357/">带着历史名将闯三国</a>/唯我墨黑</li>
                <li><a href="/book/701/">重生炼气士</a>/牧官</li>
                <li><a href="/book/645/">网王系统之次元神技</a>/末空</li>
                <li><a href="/book/143/">我在异界当土豪</a>/熊猫蚂蚁</li>
                <li><a href="/book/110/">瘟神大人在隔壁</a>/会飞的考拉</li>
                <li><a href="/book/770/">九星</a>/果味喵</li>
                <li><a href="/book/1073/">网游之最强书生</a>/漂鸟若叶</li>
                <li><a href="/book/605/">网游之暗黑庇护所</a>/无百</li>
                <li><a href="/book/356/">DNF纪元</a>/似雪流年</li>
                <li><a href="/book/366/">我的DNF</a>/奶帝威武</li>
                <li><a href="/book/320/">网游之睥睨上古</a>/天鸠</li>
                <li><a href="/book/936/">网游之卡片掌握者</a>/冲破宿命的决斗王</li>
            </ul>
        </div>
        <div class="content no-border">
            <h2>科幻小说</h2>
            <div class="top">
                <div class="image"><a href="/book/846/"><img src="http://www.biquge.cn/cover/0/846/846s.jpg" alt="刀碎星河"
                                                             width="67" height="82"></a></div>
                <dl>
                    <dt><a href="/book/846/">刀碎星河</a></dt>
                    <dd>“钛级身，第九重！”“九阳真经，第十二层！”林峰悬空而立，钛级身峥嵘而现，氤氲紫气环绕全身。手中九幽雷刀高举，引动天地惊雷，轰鸣不止，彷如霸王项羽附身，无坚不摧。</dd>
                </dl>
                <div class="clear"></div>
            </div>
            <ul>
                <li><a href="/book/345/">我在末日有基地</a>/韩风水</li>
                <li><a href="/book/751/">星际半仙守则</a>/九茗</li>
                <li><a href="/book/368/">公元2213</a>/蛮牛</li>
                <li><a href="/book/459/">天启镇魂曲</a>/凤岐</li>
                <li><a href="/book/129/">怪谈研究会</a>/静谧长夜</li>
                <li><a href="/book/704/">寂静杀戮</a>/熊狼狗</li>
                <li><a href="/book/165/">位面旅行之神的玩具</a>/目自翕张</li>
                <li><a href="/book/32/">全球竞技场</a>/小丽儿的汤包儿</li>
                <li><a href="/book/337/">末世大农场主</a>/婆娑忍土</li>
                <li><a href="/book/141/">末世钢铁领主</a>/熔核元气弹</li>
                <li><a href="/book/229/">恐怖都市</a>/猛虎道长</li>
                <li><a href="/book/281/">废土西游</a>/海带酒</li>
            </ul>
        </div>
    </div>

    <div class="space-6"></div>

    <div id="book-new">
        <div class="l">
            <h2>最近更新小说列表</h2>
            <ul>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/10079/" target="_blank">吞噬魂帝</a></span><span class="s3"><a href="/book/10079/6582617.html" target="_blank">第1003章 高阶武魂！</a></span><span class="s4">徐广大</span><span class="s5">02-10</span></li>
                <li><span class="s1">[修真小说]</span><span class="s2"><a href="/book/16813/" target="_blank">我道永恒</a></span><span class="s3"><a href="/book/16813/6582616.html" target="_blank">第三十五章 血海人魔</a></span><span class="s4">我即是空</span><span class="s5">02-10</span></li>
                <li><span class="s1">[其他小说]</span><span class="s2"><a href="/book/16391/" target="_blank">武术家也要交朋友</a></span><span class="s3"><a href="/book/16391/6582615.html" target="_blank">第四十一章 能子、纪子、真子（第一更）</a></span><span class="s4">程家的缅因猫</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/16370/" target="_blank">炼金丹师</a></span><span class="s3"><a href="/book/16370/6582614.html" target="_blank">第一百节 黄金级锻造士多伦</a></span><span class="s4">九龄不重名</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/14315/" target="_blank">超级生物探测器</a></span><span class="s3"><a href="/book/14315/6582613.html" target="_blank">第一百四十三章开挂民族</a></span><span class="s4">疯神狂想</span><span class="s5">02-10</span></li>
                <li><span class="s1">[网游小说]</span><span class="s2"><a href="/book/14883/" target="_blank">抓只妖魔当老婆</a></span><span class="s3"><a href="/book/14883/6582603.html" target="_blank">第三十二章 冰原灵蛇</a></span><span class="s4">寒冰王子</span><span class="s5">02-10</span></li>
                <li><span class="s1">[修真小说]</span><span class="s2"><a href="/book/14201/" target="_blank">餮仙传人在都市</a></span><span class="s3"><a href="/book/14201/6582602.html" target="_blank">第192章 继续烤</a></span><span class="s4">小小羽</span><span class="s5">02-10</span></li>
                <li><span class="s1">[言情小说]</span><span class="s2"><a href="/book/17046/" target="_blank">凤鸣桐和</a></span><span class="s3"><a href="/book/17046/6582601.html" target="_blank">楔子</a></span><span class="s4">若止未央</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/1857/" target="_blank">重生之妖孽人生</a></span><span class="s3"><a href="/book/1857/6582600.html" target="_blank">第6759章 无神论的祈祷</a></span><span class="s4">黄金战士</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/9562/" target="_blank">文艺大明星</a></span><span class="s3"><a href="/book/9562/6582599.html" target="_blank">第469章 心想事成</a></span><span class="s4">卖萌无敌小小宝</span><span class="s5">02-10</span></li>
                <li><span class="s1">[言情小说]</span><span class="s2"><a href="/book/16808/" target="_blank">佞臣宠妻</a></span><span class="s3"><a href="/book/16808/6582598.html" target="_blank">第136章法号静莲</a></span><span class="s4">浣晓青</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/15642/" target="_blank">绝世武圣</a></span><span class="s3"><a href="/book/15642/6582597.html" target="_blank">第536章 消息传出</a></span><span class="s4">北辰</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/17140/" target="_blank">娜的流年之浮生换空城</a></span><span class="s3"><a href="/book/17140/6582590.html" target="_blank">第四章：【奇妙的缘分，奇葩的他】（21）</a></span><span class="s4">俗人就很好</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/15688/" target="_blank">鬼医传人在都市</a></span><span class="s3"><a href="/book/15688/6582589.html" target="_blank">第596章 强吻</a></span><span class="s4">依然在</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/15366/" target="_blank">爆笑英雄联盟</a></span><span class="s3"><a href="/book/15366/6582583.html" target="_blank">第427章 状况不断</a></span><span class="s4">神徒</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/15056/" target="_blank">绝品狂少混花都</a></span><span class="s3"><a href="/book/15056/6582578.html" target="_blank">第636章 被美女剃了光头</a></span><span class="s4">九头虫</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/15055/" target="_blank">逆天成仙</a></span><span class="s3"><a href="/book/15055/6582572.html" target="_blank">第1142章 大战告捷！</a></span><span class="s4">拈花笑</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/15875/" target="_blank">星空魔舰</a></span><span class="s3"><a href="/book/15875/6582563.html" target="_blank">115 红男老大</a></span><span class="s4">地球移民</span><span class="s5">02-10</span></li>
                <li><span class="s1">[修真小说]</span><span class="s2"><a href="/book/4645/" target="_blank">剑仙韦文</a></span><span class="s3"><a href="/book/4645/6582562.html" target="_blank">第185章南林故人</a></span><span class="s4">谋者</span><span class="s5">02-10</span></li>
                <li><span class="s1">[网游小说]</span><span class="s2"><a href="/book/17166/" target="_blank">真帝势无双</a></span><span class="s3"><a href="/book/17166/6582561.html" target="_blank">第047章.宫中谈论</a></span><span class="s4">赵唯居</span><span class="s5">02-10</span></li>
                <li><span class="s1">[历史小说]</span><span class="s2"><a href="/book/9465/" target="_blank">抗战武侠</a></span><span class="s3"><a href="/book/9465/6582560.html" target="_blank">第648章 压抑的气氛</a></span><span class="s4">天边的海鸥</span><span class="s5">02-10</span></li>
                <li><span class="s1">[玄幻小说]</span><span class="s2"><a href="/book/5194/" target="_blank">凌天战尊</a></span><span class="s3"><a href="/book/5194/6582559.html" target="_blank">第2351章 ‘无头公案’</a></span><span class="s4">风轻扬</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/16266/" target="_blank">大仙厨</a></span><span class="s3"><a href="/book/16266/6582558.html" target="_blank">第二十九章 第一位客人</a></span><span class="s4">茶语饭后</span><span class="s5">02-10</span></li>
                <li><span class="s1">[历史小说]</span><span class="s2"><a href="/book/10874/" target="_blank">大明魁首</a></span><span class="s3"><a href="/book/10874/6582557.html" target="_blank">第235章 ****</a></span><span class="s4">尘都乞儿</span><span class="s5">02-10</span></li>
                <li><span class="s1">[修真小说]</span><span class="s2"><a href="/book/15290/" target="_blank">西游之气血长河</a></span><span class="s3"><a href="/book/15290/6582556.html" target="_blank">第八十三章 炼化（两更）</a></span><span class="s4">崆崆无</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/478/" target="_blank">超级军工帝国</a></span><span class="s3"><a href="/book/478/6582555.html" target="_blank">1608 钓鱼岛日本“国有化”事件</a></span><span class="s4">葫芦村人</span><span class="s5">02-10</span></li>
                <li><span class="s1">[修真小说]</span><span class="s2"><a href="/book/16714/" target="_blank">最强渣男系统</a></span><span class="s3"><a href="/book/16714/6582554.html" target="_blank">037：云雾山百花洞府</a></span><span class="s4">风影摇曳</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/715/" target="_blank">终极教官</a></span><span class="s3"><a href="/book/715/6582553.html" target="_blank">第1568章 各方汇聚！</a></span><span class="s4">梁七少</span><span class="s5">02-10</span></li>
                <li><span class="s1">[都市小说]</span><span class="s2"><a href="/book/4786/" target="_blank">校园绝品狂徒</a></span><span class="s3"><a href="/book/4786/6582552.html" target="_blank">2185 六陀山</a></span><span class="s4">柳江南</span><span class="s5">02-10</span></li>
                <li><span class="s1">[历史小说]</span><span class="s2"><a href="/book/17003/" target="_blank">极品叶少龙</a></span><span class="s3"><a href="/book/17003/6582551.html" target="_blank">第99章 混进宫里</a></span><span class="s4">野生芒果</span><span class="s5">02-10</span></li>
            </ul>
        </div>
        <div class="r">
            <h2>最新入库小说</h2>
            <ul>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17257/">神话无限</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17256/">武道图书馆</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17255/">黑巫师的猫</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[修真]</span><span class="s2"><a href="/book/17253/">红楼证道</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17254/">穿越黑棺</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17252/">陨神之地</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17250/">怪物乐园</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17251/">玄薇道说录</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[历史]</span><span class="s2"><a href="/book/17249/">笑云天</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[其他]</span><span class="s2"><a href="/book/17248/">勇者和他的魔王女儿</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[修真]</span><span class="s2"><a href="/book/17247/">御气封天</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[修真]</span><span class="s2"><a href="/book/17246/">柳三哥传奇</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[言情]</span><span class="s2"><a href="/book/17245/">紫卿</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[修真]</span><span class="s2"><a href="/book/17244/">洪荒之临水为仙</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[都市]</span><span class="s2"><a href="/book/17243/">都市之神级宗师</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[其他]</span><span class="s2"><a href="/book/17242/">最终之幻</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17241/">苍穹神国</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[言情]</span><span class="s2"><a href="/book/17240/">程七娘</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[言情]</span><span class="s2"><a href="/book/17239/">杨八娘</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[玄幻]</span><span class="s2"><a href="/book/17238/">重生玩家的世界</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[修真]</span><span class="s2"><a href="/book/17237/">不一样的仙宗</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[修真]</span><span class="s2"><a href="/book/17236/">剑耀九歌</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[都市]</span><span class="s2"><a href="/book/17235/">王牌大忽悠</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[言情]</span><span class="s2"><a href="/book/17234/">高门嫡秀</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[言情]</span><span class="s2"><a href="/book/17233/">数月亮的女孩</a></span><span class="s5">02-09</span></li>
                <li><span class="s1">[言情]</span><span class="s2"><a href="/book/17232/">重生军嫂是女仙</a></span><span class="s5">02-08</span></li>
                <li><span class="s1">[网游]</span><span class="s2"><a href="/book/17231/">网游之混沌永生</a></span><span class="s5">02-08</span></li>
                <li><span class="s1">[言情]</span><span class="s2"><a href="/book/17230/">仙尊难为</a></span><span class="s5">02-08</span></li>
                <li><span class="s1">[历史]</span><span class="s2"><a href="/book/17229/">曹魏之子</a></span><span class="s5">02-08</span></li>
                <li><span class="s1">[网游]</span><span class="s2"><a href="/book/17228/">英雄联盟之至高荣耀</a></span><span class="s5">02-08</span></li>
            </ul>
        </div>
    </div>

    <div class="space-6"></div>

    <div id="book-friend">
        友情链接：
        <a href="${ctx}/" target="_blank">东方娇子</a>
        <a href="http://www.biquge.cn" target="_blank">笔趣阁</a>
        <a href="http://www.81zw.com" target="_blank">八一中文网</a>
        <a href="http://www.wenxuemi.com" target="_blank">文学迷</a>
        <a href="http://www.baquge.com" target="_blank">新笔趣阁</a>
        <a href="http://www.23txt.com" target="_blank">天籁小说网</a>
        <a href="http://www.xs222.com" target="_blank">顶点小说</a>
        <a href="http://www.mangg.com" target="_blank">追书网</a>
    </div>
</div>

<script>
    document.title = "小说"
</script>