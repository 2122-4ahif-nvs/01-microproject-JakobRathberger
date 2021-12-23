insert into poll(name,description) values ('Meeting', 'Meeting for Project1');
insert into option(poll_id, starttime, endtime)
    values (1, TO_TIMESTAMP('2022-01-30 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-01-30 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (1, TO_TIMESTAMP('2022-01-30 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-01-30 16:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (1, TO_TIMESTAMP('2022-02-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-01 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (1, TO_TIMESTAMP('2022-02-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-01 16:00:00','YYYY-MM-DD HH24:MI:SS'));


insert into poll(name,description) values ('Meeting', 'Meeting for Project2');
insert into option(poll_id, starttime, endtime)
    values (2, TO_TIMESTAMP('2022-02-10 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-10 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (2, TO_TIMESTAMP('2022-02-10 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-10 16:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (2, TO_TIMESTAMP('2022-02-11 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-11 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (2, TO_TIMESTAMP('2022-02-11 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-11 16:00:00','YYYY-MM-DD HH24:MI:SS'));


insert into poll(name,description) values ('Meeting', 'Meeting for Project1');
insert into option(poll_id, starttime, endtime)
    values (3, TO_TIMESTAMP('2022-02-22 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-22 20:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (3, TO_TIMESTAMP('2022-02-23 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-23 20:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (3, TO_TIMESTAMP('2022-02-24 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-24 20:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (3, TO_TIMESTAMP('2022-02-25 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-25 20:00:00','YYYY-MM-DD HH24:MI:SS'));


insert into poll(name,description) values ('Meeting', 'Meeting for Project3');
insert into option(poll_id, starttime, endtime)
    values (4, TO_TIMESTAMP('2022-02-27 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-27 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (4, TO_TIMESTAMP('2022-02-28 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-28 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (4, TO_TIMESTAMP('2022-03-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-03-01 14:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (4, TO_TIMESTAMP('2022-03-02 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-03-02 14:00:00','YYYY-MM-DD HH24:MI:SS'));


insert into poll(name,description) values ('Meeting', 'Meeting for Project4');
insert into option(poll_id, starttime, endtime)
    values (5, TO_TIMESTAMP('2022-03-09 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-03-09 11:00:00','YYYY-MM-DD HH24:MI:SS'));
insert into option(poll_id, starttime, endtime)
    values (5, TO_TIMESTAMP('2022-03-18 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-03-18 11:00:00','YYYY-MM-DD HH24:MI:SS'));


insert into person(name) values ('Zoe');
insert into vote(option_id, person_id) values (1, 1);
insert into vote(option_id, person_id) values (2, 1);
insert into vote(option_id, person_id) values (3, 1);
insert into vote(option_id, person_id) values (4, 1);
insert into vote(option_id, person_id) values (5, 1);
insert into vote(option_id, person_id) values (8, 1);
insert into vote(option_id, person_id) values (9, 1);
insert into vote(option_id, person_id) values (10, 1);
insert into vote(option_id, person_id) values (17, 1);
insert into vote(option_id, person_id) values (18, 1);


insert into person(name) values ('Katy');
insert into vote(option_id, person_id) values (1, 2);
insert into vote(option_id, person_id) values (2, 2);
insert into vote(option_id, person_id) values (3, 2);
insert into vote(option_id, person_id) values (4, 2);
insert into vote(option_id, person_id) values (5, 2);
insert into vote(option_id, person_id) values (8, 2);
insert into vote(option_id, person_id) values (14, 2);
insert into vote(option_id, person_id) values (15, 2);
insert into vote(option_id, person_id) values (17, 2);
insert into vote(option_id, person_id) values (18, 2);


insert into person(name) values ('Eliza');
insert into vote(option_id, person_id) values (1, 3);
insert into vote(option_id, person_id) values (2, 3);
insert into vote(option_id, person_id) values (3, 3);
insert into vote(option_id, person_id) values (5, 3);
insert into vote(option_id, person_id) values (7, 3);
insert into vote(option_id, person_id) values (8, 3);
insert into vote(option_id, person_id) values (9, 3);
insert into vote(option_id, person_id) values (13, 3);
insert into vote(option_id, person_id) values (14, 3);
insert into vote(option_id, person_id) values (17, 3);


insert into person(name) values ('Verity');
insert into vote(option_id, person_id) values (1, 4);
insert into vote(option_id, person_id) values (2, 4);
insert into vote(option_id, person_id) values (3, 4);
insert into vote(option_id, person_id) values (4, 4);
insert into vote(option_id, person_id) values (5, 4);
insert into vote(option_id, person_id) values (8, 4);
insert into vote(option_id, person_id) values (9, 4);
insert into vote(option_id, person_id) values (10, 4);
insert into vote(option_id, person_id) values (17, 4);
insert into vote(option_id, person_id) values (18, 4);


insert into person(name) values ('Jodie');
insert into vote(option_id, person_id) values (6, 5);
insert into vote(option_id, person_id) values (7, 5);
insert into vote(option_id, person_id) values (8, 5);
insert into vote(option_id, person_id) values (9, 5);
insert into vote(option_id, person_id) values (10, 5);
insert into vote(option_id, person_id) values (11, 5);
insert into vote(option_id, person_id) values (12, 5);
insert into vote(option_id, person_id) values (13, 5);
insert into vote(option_id, person_id) values (14, 5);
insert into vote(option_id, person_id) values (17, 5);


insert into person(name) values ('Bob');
insert into vote(option_id, person_id) values (4, 6);
insert into vote(option_id, person_id) values (6, 6);
insert into vote(option_id, person_id) values (7, 6);
insert into vote(option_id, person_id) values (9, 6);
insert into vote(option_id, person_id) values (11, 6);
insert into vote(option_id, person_id) values (13, 6);
insert into vote(option_id, person_id) values (14, 6);
insert into vote(option_id, person_id) values (15, 6);
insert into vote(option_id, person_id) values (16, 6);
insert into vote(option_id, person_id) values (18, 6);


insert into person(name) values ('Alice');
insert into vote(option_id, person_id) values (1, 7);
insert into vote(option_id, person_id) values (3, 7);
insert into vote(option_id, person_id) values (4, 7);
insert into vote(option_id, person_id) values (7, 7);
insert into vote(option_id, person_id) values (8, 7);
insert into vote(option_id, person_id) values (10, 7);
insert into vote(option_id, person_id) values (13, 7);
insert into vote(option_id, person_id) values (14, 7);
insert into vote(option_id, person_id) values (16, 7);
insert into vote(option_id, person_id) values (18, 7);


insert into person(name) values ('Eve');
insert into vote(option_id, person_id) values (1, 8);
insert into vote(option_id, person_id) values (2, 8);
insert into vote(option_id, person_id) values (3, 8);
insert into vote(option_id, person_id) values (4, 8);
insert into vote(option_id, person_id) values (5, 8);
insert into vote(option_id, person_id) values (8, 8);
insert into vote(option_id, person_id) values (9, 8);
insert into vote(option_id, person_id) values (10, 8);
insert into vote(option_id, person_id) values (17, 8);
insert into vote(option_id, person_id) values (18, 8);


insert into person(name) values ('Eve');
insert into vote(option_id, person_id) values (1, 9);
insert into vote(option_id, person_id) values (2, 9);
insert into vote(option_id, person_id) values (3, 9);
insert into vote(option_id, person_id) values (4, 9);
insert into vote(option_id, person_id) values (5, 9);
insert into vote(option_id, person_id) values (8, 9);
insert into vote(option_id, person_id) values (9, 9);
insert into vote(option_id, person_id) values (10, 9);
insert into vote(option_id, person_id) values (17, 9);
insert into vote(option_id, person_id) values (18, 9);
