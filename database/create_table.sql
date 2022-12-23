/*create database PBL4Perfect  
*/
use PBL4Perfect

create table NguoiDung(
	id_users int primary key ,
	Ho nvarchar(50) ,
	Ten nvarchar(50) ,
	avatar nvarchar(150) ,
	sodienthoai varchar(20), 
	password varchar(20)
)

create table HopChat /* giaodien hop chat */
(
	id_hopchat int primary key ,
	tinnhancuoi nvarchar(255) ,
	id_nguoiguicuoi int not null ,

	constraint fk_HopChat_nguoiDung
	foreign key (id_nguoiguicuoi)
	references NguoiDung(id_users)
)

create table DSHopChat /* danh sach hop chat */
(
	id int primary key ,
	id_nguoidung int not null ,
	id_hopchat int not null , 

	constraint fk_DSHopChat_NguoiDung
	foreign key (id_nguoidung)
	references NguoiDung(id_users) ,

	constraint fk_DSHopChat_HopChat
	foreign key (id_hopchat)
	references HopChat(id_hopchat)
)

create table NhomChat
(
	id_nhomchat int primary key ,
	tennhom nvarchar(50) 

)
create table TinNhan
(
	id_tinnhan int primary key ,
	id_nguoidung int not null ,
	id_hopchat int not null ,
	noidung nvarchar(255) ,
	thoigiantao datetime ,
	id_nhomchat int not null ,

	constraint fk_TinNhan_NguoiDung 
	foreign key (id_nguoidung)
	references NguoiDung(id_users) ,

	constraint fk_TinNhan_HopChat 
	foreign key (id_hopchat)
	references HopChat(id_hopchat),

	constraint fk_TinNhan_NhomChat
	foreign key (id_nhomchat)
	references NhomChat(id_nhomchat)
)



create table CTNhomChat(
	id_nhomchat int not null ,
	id_nguoidung int not null ,
	thoigianthamgia  datetime ,
	thoigianroikhoi datetime ,
	
	

	constraint fk_NguoiDung_CTNhomChat
	foreign key (id_nguoidung)
	references NguoiDung(id_users),

	constraint fk_NhomChat_CTNhomChat
	foreign key (id_nhomchat)
	references NhomChat(id_nhomchat)
)
