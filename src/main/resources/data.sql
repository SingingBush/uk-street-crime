
INSERT INTO person (ID, username, firstname, lastname, email, created) VALUES
    (1, 'admin', 'Admin', 'User', 'admin@myapp.com', '2017-06-24 13:34:00'),
    (2, 'billy.g', 'Bill', 'Gates', 'bill.gates@microsoft.com', '2017-07-02 09:24:20'),
    (3, 'agentsmith', 'Andrew', 'Smith', 'yadda@domain.com', '2017-08-16 19:38:43'),
    (4, 'user_a', 'Test', 'Test', 'test.a@domain.com', CURRENT_TIMESTAMP - 1 MONTH),
    (5, 'user_b', 'Test', 'Test', 'test.b@domain.com', CURRENT_TIMESTAMP - 7 DAY),
    (6, 'user_c', 'Test', 'Test', 'test.c@domain.com', CURRENT_TIMESTAMP - 1 DAY);
