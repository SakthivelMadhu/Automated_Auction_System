For Login/Register
__________________

1. Seller

create table seller(
sid int primary key auto_increment,
sFirstName varchar(20) not null,
sLastName varchar(20),
semail varchar(20) not null unique,
spassword varchar(45) not null,
smobile char(10) unique not null,
sdod date not null
);

2.Buyer

create table buyer(
bid int primary key auto_increment,
bFirstName varchar(20) not null,
bLastName varchar(20),
bemail varchar(20) not null unique,
bpassword varchar(45) not null,
bmobile char(10) unique not null,
bdod date not null
);


3. Administrator

create table Administrator(
aid int primary key auto_increment,
aFirstName varchar(20) not null,
aLastName varchar(20),
aemail varchar(20) not null unique,
apassword varchar(45) not null,
amobile char(10) unique not null,
adod date not null
);

Category
______________

create table category(
cid int primary key auto_increment,
cname varchar(25) not null unique
);

Dispute Detail tables
-----------------------

1. Dispute Handle Team

create table disputTeam(
DTid int primary key auto_increment,
DTname varchar(20) not null,
cid int not null,
foreign key (cid) references category(cid)
);

2. Seller to App

create table seller_app(
did int primary key auto_increment,
sid int not null,
cid int not null,
distputDetail varchar(50) not null,
dDate date not null,
solutionDate date,
IsSolve boolean,
foreign key (sid) references seller(sid),
foreign key (cid) references category(cid)
);


3. Buyer to Seller

create table buyer_to_seller(
did int primary key auto_increment,
bid int not null,
cid int not null,
disputeDetail varchar(50) not null,
dDate date not null,
sid int,
solutionDate date,
IsSolve boolean,
foreign key (bid) references buyer(bid),
foreign key (sid) references seller(sid),
foreign key (cid) references category(cid)
);


Items To Sell
------------------

1. Item Selling List

create table selling_item(
autionID int not null unique auto_increment,
sid int not null,
cid int not null,
ItemDate date not null,
sellingPrice int not null,
item_detail varchar(25) not null,
item_quantity int not null,
auctionAddress varchar(25) not null,
auctionDate date not null,
noOfBuyerAuction int not null,
foreign key (sid) references seller(sid),
foreign key (cid) references category(cid),
primary key(sid, item_detail)
);

2. Item Sold List

create table sold(
auctionid int primary key,
sid int not null,
bid int not null,
cid int not null,
item_detail varchar(25),
item_quantity int not null,
ItemDate date not null,
sellingPrice int not null,
auctionPrice int not null,
auctionAddress varchar(25) not null,
auctionDate date,
foreign key (sid) references seller(sid),
foreign key (bid) references buyer(bid),
foreign key (cid) references category(cid)
);


3. Auction on Items

create table AuctionTable(
auctionId int not null,
bid int not null,
auctionPrice int not null,
primary key (auctionid, bid)
);


--------------------------------------------------------------------

values
-------

1. Administrator
________________

Register Administrator

>insert into administrator 
(aFirstName, aLastName, aemail, apassword, amobile, adod) 
values(
'sakthi',
null, 
'sakthi@12345',
'Admin@12345',
'1234568902',
19960412
);


Login Administrator

>select * from Administrator where aemail = ? AND apassword = ?



List of Buyer

>select * from buyer;


insert in Buyer

>insert into buyer
(bFirstName, bLastName, bemail, bpassword, bmobile, bdod) values(
'sakthivel',
'madhu',
'sakthi13@gmail.com',
'Admin@12345',
'87984981155',
19981225
);

> update administrator set apassword = '12345' where aemail='sakthi@12345';

> select * from seller

> insert into seller
(sFirstName, sLastName, semail, spassword, smobile, sdod) values(
'sakthivel',
'madhu',
'seller@gmail.com',
'12345',
'1234567890',
'1999-02-02'
);


> select s.did, s.sid, s.cid, s.distputDetail, s.dDate, s.solutionDate, s.IsSolve, t.DTname from seller_app s INNER JOIN disputTeam t ON s.cid = t.cid AND s.IsSolve = false;

> insert into seller_app(sid, cid, distputDetail, dDate, solutionDate, IsSolve) values(
1, 1, 'property not able to listing', CURDATE(), adddate(sysdate(), INTERVAL 10 DAY), false
);

> insert into category(cname) values('property');
> insert into category(cname) values('login or registration');
> insert into category(cname) values('photo upload');
> insert into category(cname) values('refund');
> insert into category(cname) values('payment');
> insert into category(cname) values('sell');
> insert into category(cname) values('app improvement');
> insert into category(cname) values('item listing');
> insert into category(cname) values('Electronic');
> insert into category(cname) values('Automobile');
> insert into category(cname) values('Miscellaneous');


> insert into disputTeam(DTname, cid) values('ironman', 1);
> insert into disputTeam(DTname, cid) values('hulk', 2);
> insert into disputTeam(DTname, cid) values('captain', 3);
> insert into disputTeam(DTname, cid) values('thor', 4);
> insert into disputTeam(DTname, cid) values('strange', 5);
> insert into disputTeam(DTname, cid) values('marvel', 6);
> insert into disputTeam(DTname, cid) values('spiderman', 7);
> insert into disputTeam(DTname, cid) values('batman', 8);
> insert into disputTeam(DTname, cid) values('superman', 9);
> insert into disputTeam(DTname, cid) values('Atrain', 10);
> insert into disputTeam(DTname, cid) values('homelander', 11);

> select s.did, s.bid, s.sid, c.cname, s.disputeDetail, s.dDate, s.solutionDate, s.IsSolve, t.DTname from buyer_to_seller s INNER JOIN disputTeam t INNER JOIN category c ON s.cid = t.cid AND s.cid = c.cid AND s.IsSolve = false

> insert into buyer_to_seller (bid, cid, disputeDetail, dDate, sid, solutionDate, IsSolve) values( 1, 2, 'can not login', now(), null, addDate(curDate(), INTERVAL 15 DAY), false );

> insert into sold values( 0, 1, 1, 1, 'house', 1, curdate(), 2500000, 2000000, 'bangalore', curdate() );

> insert into sold values( -1, 1, 1, 1, 'house', 1, 19900101, 2500000, 2000000, 'bangalore', curdate() );

> insert into sold values( -2, 1, 1, 1, 'house', 1, 19900101, 2500000, 2000000, 'bangalore', 19960505 );

> select * from sold order by auctionDate desc;

> insert into seller (sFirstName, sLastName, semail, spassword, smobile, sdod) values('sakthivel', 'madhu', 'seller@gmail.com', '12345', '1234567890', '1999-02-02');

> select * from Seller where semail = 'seller@gmail.com' AND spassword = '12345';

> update seller set spassword = 'Admin@12345' where semail = 'seller@gmail.com';

> update seller set semail= 'sakthi13@gmail.com' where sFirstName='sakthivel' AND sdod= '1999-02-02' AND smobile = '1234567890';

> insert into selling_item (sid, cid, itemdate, sellingprice, item_detail, item_quantity, auctionaddress, auctiondate, noOfBuyerAuction) values(1, 1, sysdate(), 15000000, 'shop', 1, 'Delhi', adddate(sysdate(), INTERVAL 10 DAY), 0);

> update selling_item set item_quantity = 5 where sid  = 1 and item_detail= 'shop';

> update selling_item set sellingPrice = 156825 where sid  = 1 and item_detail= 'shop';

> update selling_item set item_quantity = 1, sellingPrice = 10 where sid  = 1 and item_detail= 'shop';

> delete from selling_item where sid=1 AND item_detail = 'shop';

> select * from selling_item where sid = 1 order by ItemDate desc;