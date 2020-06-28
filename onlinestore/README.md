## データベースの準備
```bash
sudo apt-get update
sudo apt-get install mysql-server
```

or

```bash
docker run --name mysql-srv -p3306:3306 -e MYSQL_ROOT_PASSWORD=mysql-passwd -d mysql:5.7
```

## データベースの初期化

```
mysql> CREATE DATABASE onlinestore default character set utf8;
mysql> CREATE USER 'appuser'@'%' identified by '8NWfD7JFFd12';
mysql> GRANT ALL ON onlinestore.* to 'appuser'@'%';
```

```
mysql> DROP TABLE orderhistory;
mysql> DROP TABLE inventory;
mysql> DROP TABLE sku;
mysql> DROP TABLE productcatalog;
```