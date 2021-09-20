insert into roles(id,role) values(1,'ROLE_USER');
insert into roles(id,role) values(2,'ROLE_ADMIN');

insert into statuses(id,name) values(1,'Zakończona sukcesem');
insert into statuses(id,name) values(2,'Zakończona nie powodzeniem');



insert into owners (id, first_name, last_name, phone_number) values (1, 'Harcourt', 'Pidler', '775626623');
insert into owners (id, first_name, last_name, phone_number) values (2, 'Jasmine', 'Kinnane', '274537194');
insert into owners (id, first_name, last_name, phone_number) values (3, 'Paten', 'Dewicke', '863528239');
insert into owners (id, first_name, last_name, phone_number) values (4, 'Larisa', 'Sheahan', '357509184');
insert into owners (id, first_name, last_name, phone_number) values (5, 'Timmy', 'Petkovic', '312165200');
insert into owners (id, first_name, last_name, phone_number) values (6, 'Fancie', 'McGrayle', '295565880');
insert into owners (id, first_name, last_name, phone_number) values (7, 'Antin', 'Bootland', '850424006');
insert into owners (id, first_name, last_name, phone_number) values (8, 'Adamo', 'Peggrem', '465834525');
insert into owners (id, first_name, last_name, phone_number) values (9, 'Tomaso', 'Dadge', '195166577');
insert into owners (id, first_name, last_name, phone_number) values (10, 'Dalenna', 'Griffoen', '387202389');

insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(1,'Poznań','Alko-Shop','Wielka wyrwa',2,1);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(2,'Warszawa','Alko-Shop','Pokątna',12,1);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(3,'Warszawa','Alko-Shop','Pokątna',12,10);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(4,'Warszawa','Mydło-Shop','Mała',12,9);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(5,'Warszawa','Ciasto-Shop','Wielka',12,8);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(6,'Warszawa','A B C',null,12,6);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(7,'Warszawa','Shopman','Glizda',12,5);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(8,'Warszawa','Castorama','Małpa',12,4);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(9,'Warszawa','Biedronka','Trójkąt',12,3);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(10,'Warszawa','Biedronka','Koniec',1,2);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(11,'Gniezno','Biedronka','Początek',120,1);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(12,'Rzeszów','Biedronka','Trójkąt',12,1);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(13,'Poznań','Biedronka',null,12,1);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(14,'Gniezno','Alko-Shop','Podgórkę',1,1);
insert into shops(id,name_city, name_shop, name_street, number_street,owner_id)
values(15,'Warszawa','Sex-Shop','Średnia',12,7);

insert into type_devices(id,type,description)
values(1,'Kasa fiskalna','Producenci oferują wiele modeli kas fiskalnych z różnym rodzajem funkcji. Można wybrać takie, które pozwalają na zaprogramowanie całej bazy produktów oraz połączenie w system sprzedaży, dzięki czemu umożliwiają wygodniejszą pracę.');
insert into type_devices(id,type,description)
values(2,'Kasa rejestrująca','Producenci oferują wiele modeli kas fiskalnych z różnym rodzajem funkcji. Można wybrać takie, które pozwalają na zaprogramowanie całej bazy produktów oraz połączenie w system sprzedaży, dzięki czemu umożliwiają wygodniejszą pracę.');
insert into type_devices(id,type,description)
values(3,'Waga elektroniczna','Jeśli w sklepie są artykuły na wagę ten sprzęt jest niezbędny. Producenci oferują różne rodzaje wag, więc warto zastanowić się nad: udźwigiem, rozmiarem szalki czy wyświetlaczem, tak aby maksymalnie dostosować wagę do potrzeb danej działalności.');
insert into type_devices(id,type,description)
values(4,'Metkownica','To przyrząd przeznaczony do automatycznego przyklejania ceny towarów. Z uwagi na dostępność różnych rodzajów metkownic należy przemyśleć jakie informacje powinny znaleźć się na metce.');
insert into type_devices(id,type,description)
values(5,'Krajalnica','Jeśli w asortymencie sklepu spożywczego są wędliny czy sery z opcją ich krojenia na miejscu koniecznością będzie zakup krajalnicy.');
insert into type_devices(id,type,description)
values(6,'Terminal płatniczy','Zakup terminala nie jest konieczny, ale staje się wręcz niezbędny patrząc na zamiłowanie ludzi do płatności bezgotówkowych.');

insert into devices(id,mark,model,review_to,last_review,serial_number,shop_id,type_id)
values(1,'Fawag','Lite','2021-09-19','2020-09-20','PO067007725',1,1);
insert into devices(id,mark,model,review_to,last_review,serial_number,shop_id,type_id)
values(2,'Novitus','Nano E','2021-09-19','2020-09-20','PO067007711',1,2);
insert into devices(id,mark,model,review_to,last_review,serial_number,shop_id,type_id)
values(3,'Novitus','Nano E','2021-09-19','2020-09-20','PO067007125',1,2);
insert into devices(id,mark,model,review_to,last_review,serial_number,shop_id,type_id)
values(4,'Fawag','Nano E','2021-09-17','2020-09-18','PO067007725',1,3);
insert into devices(id,mark,model,review_to,last_review,serial_number,shop_id,type_id)
values(5,'Fawag','Lite','2021-09-17','2020-09-18','PO067007725',1,4);
insert into devices(id,mark,model,review_to,last_review,serial_number,shop_id,type_id)
values(6,'Fawag','Lite','2021-09-28','2020-09-27','PO067007725',1,1);
insert into devices(id,mark,model,review_to,last_review,serial_number,shop_id,type_id)
values(7,'Fawag','Lite','2021-09-28','2020-09-27','PO067007725',1,4);





