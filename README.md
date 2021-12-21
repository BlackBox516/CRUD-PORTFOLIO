#Spring Boot　＋　JDBC ＋Tymeleaf の組み合わせによる基礎のCRUD


**MENTAのサービスによる現役エンジニアからの指導の下で作成したCRUDのアプリです。
4大機能である、CRUDのCは登録機能、Rは読出機能、Uは変更機能、Dは削除機能で
どのWebサイトもデータに対してこれら4つの操作を行なっているので
Web開発の基本を身につけるためにCRUDの開発に着手しました。**


**開発環境
 ・OS:mac OS Catalina (ver10.15.7)
 ・docker,docer-compose
 ・Spring Tool Suite 4  Version: 4.9.0.RELEASE
 ・Java:15
 ・MySQL Workbench**


 #URL

 **https://127.0.0.1**


 #操作画面画像


#苦労した点
**コードの記述においては、CRUDのUの部分に相当するところで苦戦し、
編集フォームを開こうとするとエラーになり、開発し初めて最初の頃はここで行き詰まっていました。
単なる記述ミスであることに気づいたらすぐにエラーなく開くようになり
プログラミングが上手くいかない原因のおおよそはケアレスミスというのを実感しました。
仕上げであるリファクタリング作業もItemFormクラスを分割して、ItemFormとItemEntityに分割するという
ところからControllerの分割、サービスレイヤの作成といった作業をしてきました。
分割関連は分割した時点で確実にエラーになるので、対応させるための修正や、どのアノテーションがどっちで必要になるかなどの取捨選択で混乱しました。
サービスレイヤは似たようなコードを参考に進めていきましたが、いざ自分の環境に当てはめて書こうとすると
エラーになり、行き詰まりました。
似たような構成のコードを巡って行くうちにフォームから値を取得し、エンティティにセットするという流れに気づいて解決できました。
また、一気に進めすぎてエラーに遭遇した際にどれが原因で発生したかが分からなくなることがあり、結局デバッグした時点から
やり直すことになった際には現役エンジニアの方からは、一つ一つ触って行くことと、指示されたところ以外は極力
触ってはいけないということを教わり、プログラミングは無闇に進めて行くと収拾がつかなくなるということを学習しました。**

