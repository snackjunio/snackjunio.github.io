--サーバー起動--
python manage.py runserver

--DB作成--
python manage.py runserver


--Private Key--
ssh-rsa AAAAB3NzaC1yc2EAAAABJQAAAQEAiNq+Wv8yEvRbkR//YVUI8sUv/SA7w/d7BF89pujm1QA9Z0FDa01g1/nmYc5lExj7txMAI9JZ6mrPYhubCvdzEGyC3cbab8kKAsHWtYpccoju+zTbfzhPRS5v+t8rDzgGqbED8yo95KUU2nWTi1ubAglB7+lcrNZah/dB1oTqA+d4KPLsRKb0SG1gSDZ8DuqVG635pGyuuNZIVjUTL535CmBuERzGqUNBOfM6UCIANs/3CO4aHlIE1/SCnsfIo0gWe2E9lnHiJFxr/4sxQBD7OH371nD5qzFlcrXo123xi/q47la0CDeI2Xp9iRpY/pq8YcxupoLAq83OVmUnvHsT2w== rsa-key-20200424






--block chain--
--Python SHA256--
import hashlib
from hashlib import sha256
data = input('入力ください:')
hs = hashlib.md5(data.encode()).hexdigest()
print(hs)








--CSV--
a：追記
r：読み込む
w：書き込む
--CSVファイル書き込む--
import csv
with open('fileアドレス.csv','w') as f:
	writer = csv.writer(f)
	writer.writernow(書きたい内容)
--CSVファイル書き込む--
import csv
with open('fileアドレス.csv','r') as f:
	reader = csv.reader(f)
	for row in reader:
		print(row)
--OpenCV--
-- Camera 接続するとき
import cv2
capture = cv2.VideoCapture(0)
while True:
	ret, cam(変数名) = capture.read()
	cv2.imshow('frame', cam)
	if cv2.waitKey(1) & 0xFF == ord('q'):
	    break
capture.release()
cv2.destroyAllWindows()

-- Gray Color convert
img（変数名） = r'file.jpg'
img_gray = cvtColor(img, cv2.COLOR_RGB2GRAY)

--コミット方法--
--GitBash--
cd C:/Users/2016xxxx/PyCharm/mybook
git add .
git commit -m"コメント"
git push origin master


--データベースコマンド--
		PostgreSQL	MySQL
ログイン	su - postgres	mysql -u user_name -p
データーベースを作成	createdb database_name	CREATE DATABASE database_name;
データベース一覧を表示	psql -l
\l	SHOW DATABASES;
データーベースへ接続	\c database_name	USE database_name;
テーブル一覧を表示	\d	SHOW TABLES;
テーブルカラムの一覧表示	\d table_name	DESC table_name;
ユーザーを作成	createuser user_name	CREATE USER user_name;
ユーザー一覧を表示	\du	SELECT User, Host FROM mysql.user;
ログアウト	exit
\q	exit;

--Create table--
create table public.people(
	id int,
	name varchar(20),
	age int,
	gender text,
	primary key (id)
);

--insert--
insert into public.users values("","");

--Python PostgreSQL--
conn = psycopg2.connect(database="facebase", user="postgres", password="1234")
cur = conn.cursor()
cur.execute('SQL Query')
conn.commit()





--SEO--
http://stg.gpsa.gooparts.com/
sunseer
sunseer2014
0100001
abcdefg

idac
idac1129

--Linux--
cd 移動
ls 中身をみたいフォルダに移動して
mv ファイルを移動
cp ファイルやフォルダをコピーする
clear 消さずに画面を綺麗にする
mkdir フォルダを作成する
touch ファイルを作成する
rmdir 空のフォルダを削除する
rm ファイルやフォルダを削除する
pwd 現在いる位置を表示する
find ファイルの検索をする
cat ファイルの内容を表示する
diff ファイルとファイルの内容の違いを表示する
grep 指定した文字列がテキスト内に存在した場合その行を抽出する
chmod ファイルやフォルダのアクセス権限を変更する
chown ファイルやフォルダのオーナーやグループを変更する
history コマンドの履歴を表示する
ln ファイルやフォルダにリンクを設定する
man コマンドのマニュアルを表示する
apropos manページの内容を検索する
less テキストファイルを閲覧する
more ァイルをページ単位で閲覧する

alias
locate 検索キーワード(url)
