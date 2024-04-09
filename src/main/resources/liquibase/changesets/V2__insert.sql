insert into facts (description, weight) values
    ('Знаете ли вы английский язык?', 0.8), -- 1
    ('Любите ли вы работать в команде?', 0.6), -- 2
    ('Обладаете ли вы лидерскими качествами?', 0.5), -- 3
    ('Есть ли у вас опыт работы с дистрибутивами GNU/linux?', 0.9), -- 4
    ('Знаете ли вы физику на базовом уровне?', 0.90), -- 5
    ('Рассчитываете ли вы на заработную плату выше 150 тысяч в течении следующих 5 лет?', 0.6), -- 6
    ('Обладаете ли вы навыками финансовой грамотности?', 0.85), -- 7
    ('Можете ли выполнять несколько задач одновременно?', 0.65), -- 8
    ('Знакомы ли вы с основами оптотехники и принципами работы оптических систем??', 0.95), -- 9
    ('Обладаете ли вы навыками программирования микроконтроллеров или программируемой логики для приборов?', 0.95), -- 10
    ('Знакомы ли вы с архитектурой ПК?', 0.85), -- 11
    ('Умеете ли вы работать с MapInfo/ArcGis/QGIS?', 0.85), -- 12
    ('Есть ли у вас победы в олимпиадах по спортивному программированию или других похожих дисциплинах?', 0.3), -- 13
    ('Знакомы ли вы с ООП и другими парадигмами программирования?', 1), -- 14
    ('Хорошо ли вы знаете разделы высшей математики и теории вероятности?', 0.7), -- 15
    ('Знакомы ли вы с основными принципами защиты информации?', 0.83), -- 16
    ('Имеете ли вы представление о бизнесс-процессах внутри компании?', 0.8), -- 17
    ('Есть ли у вас навыки frontend-разработки? (HTML, CSS, JS)', 1), -- 18
    ('Имеете ли вы базовые знания в области автоматизации? Знаете ли вы, что такое CI/CD?', 0.8), -- 19
    ('Знаете ли вы модель OSI, принципы комутации и маршрутизации?', 0.95), -- 20
    ('Имеете ли вы знания в области робототехники?', 0.9), -- 21
    ('Предпочтительна ли для вас удаленная работа?', 0.67), -- 22
    ('Обладаете ли вы базовыми знаниями в области геодезии?', 0.95), -- 23
    ('Умеете ли вы работать с Blender/3D MAX?', 0.90), -- 24
    ('Знаете ли вы Java/Kotlin/Scala/Groovy?', 0.95), -- 25
    ('Знаете ли вы Objective-C/Swift?', 0.95), -- 26
    ('Умеете ли вы пользоваться экосистемой 1С?', 0.95), -- 27
    ('Обладаете ли вы навыками по проведению ручного/unit/нагрузочного тестирования?', 0.85), -- 28
    ('Обладаете ли вы навыками программирования на python/matlab/haskell?', 0.95), -- 29
    ('Знакомы ли вы с пакетом Microsoft Office?', 0.8); -- 30

insert into jobs (name) values
    ('Project-менеджер'), -- 1
    ('Product-менеджер'), -- 2
    ('Backend-разработчик'), -- 3
    ('Frontend-разработчик'), -- 4
    ('QA-инженер (тестировщик)'), -- 5
    ('IOS-разработчик'), -- 6
    ('Android-разработчик'), -- 7
    ('Системный администратор'), -- 8
    ('Разработчик игр (GameDev)'), -- 9
    ('DevOps'), -- 10
    ('Аналитик'), -- 11
    ('Разработчик ПЛИС'), -- 12
    ('ГИС-специалист'), -- 13
    ('Сетевой инженер'), -- 14
    ('Специалист в области инженерии труда и производства'), -- 15
    ('1С-программист'), -- 16
    ('Специалист в области кибер-безопасности'), -- 17
    ('Инженер по волоконной оптике'); -- 18

insert into trust (job_id, fact_id, trust_cf) values
    (1, 1, 0.8), (1, 2, 1), (1, 3, 1), (1, 4, 0.1), (1, 5, 0),
    (1, 6, 0.7), (1, 7, 0.2), (1, 8, 0.9), (1, 9, 0), (1, 10, 0),
    (1, 11, 0.05), (1, 12, 0), (1, 13, 0.05), (1, 14, 0.07), (1, 15, 0.05),
    (1, 16, 0), (1, 17, 0.5), (1, 18, 0.1), (1, 19, 0.4), (1, 20, 0),
    (1, 21, 0), (1, 22, 0.6), (1, 23, 0), (1, 24, 0.01), (1, 25, 0.03),
    (1, 26, 0.01), (1, 27, 0.2), (1, 28, 0), (1, 29, 0), (1, 30, 0.8),

    (2, 1, 0.9), (2, 2, 1), (2, 3, 1), (2, 4, 0.1), (2, 5, 0),
    (2, 6, 0.7), (2, 7, 0.9), (2, 8, 0.95), (2, 9, 0), (2, 10, 0),
    (2, 11, 0), (2, 12, 0), (2, 13, 0.05), (2, 14, 0.03), (2, 15, 0.05),
    (2, 16, 0.03), (2, 17, 0.8), (2, 18, 0.2), (2, 19, 0.25), (2, 20, 0),
    (2, 21, 0), (2, 22, 0.6), (2, 23, 0), (2, 24, 0), (2, 25, 0),
    (2, 26, 0), (2, 27, 0.3), (2, 28, 0), (2, 29, 0), (2, 30, 0.8),

    (3, 1, 0.6), (3, 2, 0.6), (3, 3, 0.5), (3, 4, 0.5), (3, 5, 0.07),
    (3, 6, 0.8), (3, 7, 0), (3, 8, 0.7), (3, 9, 0), (3, 10, 0.1),
    (3, 11, 0.25), (3, 12, 0), (3, 13, 0.4), (3, 14, 1), (3, 15, 0.55),
    (3, 16, 0.2), (3, 17, 0.1), (3, 18, 0.4), (3, 19, 0.6), (3, 20, 0.1),
    (3, 21, 0.01), (3, 22, 0.9), (3, 23, 0), (3, 24, 0), (3, 25, 0.95),
    (3, 26, 0.8), (3, 27, 0.35), (3, 28, 0.6), (3, 29, 0.55), (3, 30, 0.2),
    
    (4, 1, 0.55), (4, 2, 0.6), (4, 3, 0.5), (4, 4, 0.2), (4, 5, 0.03),
    (4, 6, 0.8), (4, 7, 0), (4, 8, 0.65), (4, 9, 0), (4, 10, 0),
    (4, 11, 0.15), (4, 12, 0), (4, 13, 0.2), (4, 14, 0.87), (4, 15, 0.45),
    (4, 16, 0.01), (4, 17, 0), (4, 18, 1), (4, 19, 0.5), (4, 20, 0),
    (4, 21, 0), (4, 22, 0.72), (4, 23, 0), (4, 24, 0), (4, 25, 0.45),
    (4, 26, 0.15), (4, 27, 0.1), (4, 28, 0.5), (4, 29, 0.2), (4, 30, 0.25),
    
    (5, 1, 0.55), (5, 2, 0.55), (5, 3, 0.45), (5, 4, 0.55), (5, 5, 0.01),
    (5, 6, 0.87), (5, 7, 0), (5, 8, 0.67), (5, 9, 0), (5, 10, 0.05),
    (5, 11, 0.12), (5, 12, 0), (5, 13, 0.3), (5, 14, 0.89), (5, 15, 0.55),
    (5, 16, 0), (5, 17, 0), (5, 18, 0.2), (5, 19, 0.75), (5, 20, 0),
    (5, 21, 0), (5, 22, 0.8), (5, 23, 0), (5, 24, 0), (5, 25, 0.7),
    (5, 26, 0.25), (5, 27, 0.1), (5, 28, 1), (5, 29, 0.65), (5, 30, 0.33),
    
    (6, 1, 0.6), (6, 2, 0.6), (6, 3, 0.45), (6, 4, 0.1), (6, 5, 0.03),
    (6, 6, 0.9), (6, 7, 0), (6, 8, 0.67), (6, 9, 0), (6, 10, 0.05),
    (6, 11, 0.1), (6, 12, 0), (6, 13, 0.35), (6, 14, 0.9), (6, 15, 0.5),
    (6, 16, 0.1), (6, 17, 0), (6, 18, 0.1), (6, 19, 0.3), (6, 20, 0),
    (6, 21, 0), (6, 22, 0.8), (6, 23, 0), (6, 24, 0), (6, 25, 0.25),
    (6, 26, 1), (6, 27, 0.05), (6, 28, 0.45), (6, 29, 0.1), (6, 30, 0.2),
    
    (7, 1, 0.57), (7, 2, 0.6), (7, 3, 0.45), (7, 4, 0.2), (7, 5, 0.03),
    (7, 6, 0.85), (7, 7, 0), (7, 8, 0.65), (7, 9, 0), (7, 10, 0.07),
    (7, 11, 0.1), (7, 12, 0), (7, 13, 0.35), (7, 14, 0.95), (7, 15, 0.5),
    (7, 16, 0.1), (7, 17, 0), (7, 18, 0.15), (7, 19, 0.3), (7, 20, 0),
    (7, 21, 0), (7, 22, 0.8), (7, 23, 0), (7, 24, 0), (7, 25, 1),
    (7, 26, 0.01), (7, 27, 0.07), (7, 28, 0.45), (7, 29, 0.2), (7, 30, 0.2),
    
    (8, 1, 0.62), (8, 2, 0.4), (8, 3, 0.4), (8, 4, 1), (8, 5, 0.07),
    (8, 6, 0.8), (8, 7, 0), (8, 8, 0.65), (8, 9, 0), (8, 10, 0.1),
    (8, 11, 0.25), (8, 12, 0), (8, 13, 0.2), (8, 14, 0.4), (8, 15, 0.45),
    (8, 16, 0.35), (8, 17, 0.05), (8, 18, 0.05), (8, 19, 0.35), (8, 20, 0.15),
    (8, 21, 0), (8, 22, 0.6), (8, 23, 0), (8, 24, 0), (8, 25, 0.2),
    (8, 26, 0.1), (8, 27, 0.2), (8, 28, 0.35), (8, 29, 0.33), (8, 30, 0.3),
    
    (9, 1, 0.55), (9, 2, 0.6), (9, 3, 0.3), (9, 4, 0.2), (9, 5, 0.1),
    (9, 6, 0.8), (9, 7, 0), (9, 8, 0.4), (9, 9, 0), (9, 10, 0.01),
    (9, 11, 0.1), (9, 12, 0), (9, 13, 0.8), (9, 14, 0.8), (9, 15, 0.95),
    (9, 16, 0), (9, 17, 0), (9, 18, 0.05), (9, 19, 0.1), (9, 20, 0),
    (9, 21, 0), (9, 22, 0.57), (9, 23, 0), (9, 24, 0.97), (9, 25, 0.55),
    (9, 26, 0.1), (9, 27, 0.01), (9, 28, 0.2), (9, 29, 0.13), (9, 30, 0.2),
    
    (10, 1, 0.55), (10, 2, 0.55), (10, 3, 0.3), (10, 4, 0.87), (10, 5, 0.05),
    (10, 6, 0.83), (10, 7, 0), (10, 8, 0.4), (10, 9, 0), (10, 10, 0.01),
    (10, 11, 0.2), (10, 12, 0), (10, 13, 0.2), (10, 14, 0.4), (10, 15, 0.5),
    (10, 16, 0.2), (10, 17, 0.1), (10, 18, 0.1), (10, 19, 1), (10, 20, 0),
    (10, 21, 0), (10, 22, 0.6), (10, 23, 0), (10, 24, 0), (10, 25, 0.75),
    (10, 26, 0.05), (10, 27, 0.1), (10, 28, 0.67), (10, 29, 0.45), (10, 30, 0.3),
    
    (11, 1, 0.4), (11, 2, 0.4), (11, 3, 0.3), (11, 4, 0.3), (11, 5, 0.05),
    (11, 6, 0.7), (11, 7, 1), (11, 8, 0.55), (11, 9, 0), (11, 10, 0),
    (11, 11, 0.05), (11, 12, 0), (11, 13, 0.2), (11, 14, 0.2), (11, 15, 0.85),
    (11, 16, 0), (11, 17, 0.95), (11, 18, 0.05), (11, 19, 0.05), (11, 20, 0),
    (11, 21, 0), (11, 22, 0.55), (11, 23, 0), (11, 24, 0), (11, 25, 0.1),
    (11, 26, 0.03), (11, 27, 0.5), (11, 28, 0.1), (11, 29, 0.3), (11, 30, 0.7),
    
    (12, 1, 0.4), (12, 2, 0.2), (12, 3, 0.1), (12, 4, 0.3), (12, 5, 0.45),
    (12, 6, 0.5), (12, 7, 0), (12, 8, 0.4), (12, 9, 0.1), (12, 10, 0.7),
    (12, 11, 1), (12, 12, 0), (12, 13, 0.2), (12, 14, 0.2), (12, 15, 0.67),
    (12, 16, 0.05), (12, 17, 0), (12, 18, 0.03), (12, 19, 0.01), (12, 20, 0.05),
    (12, 21, 0.45), (12, 22, 0.05), (12, 23, 0), (12, 24, 0), (12, 25, 0.1),
    (12, 26, 0.07), (12, 27, 0), (12, 28, 0.1), (12, 29, 0.09), (12, 30, 0.1),
    
    (13, 1, 0.3), (13, 2, 0.3), (13, 3, 0.2), (13, 4, 0), (13, 5, 0.7),
    (13, 6, 0.4), (13, 7, 0.2), (13, 8, 0.4), (13, 9, 0.1), (13, 10, 0),
    (13, 11, 0.05), (13, 12, 1), (13, 13, 0.01), (13, 14, 0), (13, 15, 0.8),
    (13, 16, 0), (13, 17, 0), (13, 18, 0), (13, 19, 0), (13, 20, 0.1),
    (13, 21, 0), (13, 22, 0.25), (13, 23, 1), (13, 24, 0.3), (13, 25, 0.1),
    (13, 26, 0.01), (13, 27, 0.2), (13, 28, 0), (13, 29, 0.15), (13, 30, 0.25),
    
    (14, 1, 0.4), (14, 2, 0.45), (14, 3, 0.3), (14, 4, 0.7), (14, 5, 0.5),
    (14, 6, 0.4), (14, 7, 0), (14, 8, 0.2), (14, 9, 0.2), (14, 10, 0.1),
    (14, 11, 0.3), (14, 12, 0), (14, 13, 0.1), (14, 14, 0.1), (14, 15, 0.3),
    (14, 16, 0.47), (14, 17, 0.05), (14, 18, 0), (14, 19, 0), (14, 20, 1),
    (14, 21, 0.05), (14, 22, 0.1), (14, 23, 0), (14, 24, 0), (14, 25, 0.1),
    (14, 26, 0), (14, 27, 0.01), (14, 28, 0.2), (14, 29, 0.2), (14, 30, 0.17),
    
    (15, 1, 0.05), (15, 2, 0.3), (15, 3, 0.2), (15, 4, 0.05), (15, 5, 0.55),
    (15, 6, 0.35), (15, 7, 0.1), (15, 8, 0.3), (15, 9, 0.6), (15, 10, 0.7),
    (15, 11, 0.4), (15, 12, 0.35), (15, 13, 0.03), (15, 14, 0.01), (15, 15, 0.27),
    (15, 16, 0.01), (15, 17, 0.1), (15, 18, 0), (15, 19, 0), (15, 20, 0.2),
    (15, 21, 0.95), (15, 22, 0.03), (15, 23, 0.5), (15, 24, 0.1), (15, 25, 0.03),
    (15, 26, 0), (15, 27, 0.3), (15, 28, 0), (15, 29, 0.01), (15, 30, 0.2),
    
    (16, 1, 0.1), (16, 2, 0.3), (16, 3, 0.2), (16, 4, 0.1), (16, 5, 0.01),
    (16, 6, 0.4), (16, 7, 0.5), (16, 8, 0.5), (16, 9, 0), (16, 10, 0),
    (16, 11, 0.1), (16, 12, 0.05), (16, 13, 0.2), (16, 14, 0.35), (16, 15, 0.3),
    (16, 16, 0.01), (16, 17, 0.65), (16, 18, 0.05), (16, 19, 0.1), (16, 20, 0),
    (16, 21, 0), (16, 22, 0.4), (16, 23, 0), (16, 24, 0), (16, 25, 0.3),
    (16, 26, 0.1), (16, 27, 1), (16, 28, 0.1), (16, 29, 0.1), (16, 30, 0.6),
    
    (17, 1, 0.3), (17, 2, 0.3), (17, 3, 0.2), (17, 4, 0.75), (17, 5, 0.3),
    (17, 6, 0.47), (17, 7, 0.03), (17, 8, 0.5), (17, 9, 0.1), (17, 10, 0.04),
    (17, 11, 0.25), (17, 12, 0), (17, 13, 0.1), (17, 14, 0.1), (17, 15, 0.7),
    (17, 16, 1), (17, 17, 0.1), (17, 18, 0), (17, 19, 0), (17, 20, 0.2),
    (17, 21, 0), (17, 22, 0.3), (17, 23, 0), (17, 24, 0), (17, 25, 0.1),
    (17, 26, 0), (17, 27, 0.01), (17, 28, 0.01), (17, 29, 0.2), (17, 30, 0.2),
    
    (18, 1, 0.05), (18, 2, 0.15), (18, 3, 0.1), (18, 4, 0), (18, 5, 1),
    (18, 6, 0.4), (18, 7, 0), (18, 8, 0.3), (18, 9, 0.95), (18, 10, 0.3),
    (18, 11, 0.2), (18, 12, 0.1), (18, 13, 0.01), (18, 14, 0), (18, 15, 0.5),
    (18, 16, 0.1), (18, 17, 0.1), (18, 18, 0), (18, 19, 0), (18, 20, 0.3),
    (18, 21, 0.1), (18, 22, 0.1), (18, 23, 0.2), (18, 24, 0), (18, 25, 0.01),
    (18, 26, 0), (18, 27, 0), (18, 28, 0), (18, 29, 0), (18, 30, 0.15);


    