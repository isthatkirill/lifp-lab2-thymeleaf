-- Inserting data into the 'facts' table
insert into facts (description, weight) values
    ('Fact 1', 0.75),
    ('Fact 2', 0.85),
    ('Fact 3', 0.65),
    ('Fact 4', 0.90);

-- Inserting data into the 'jobs' table
insert into jobs (name) values
    ('Job A'),
    ('Job B'),
    ('Job C'),
    ('Job D');

-- Inserting data into the 'trust' table
insert into trust (fact_id, job_id, trust_cf) values
    (1, 1, 0.95),
    (1, 2, 0.85),
    (1, 3, 0.75),
    (1, 4, 0.90),
    (2, 1, 0.80),
    (2, 2, 0.85),
    (2, 3, 0.90),
    (2, 4, 0.95),
    (3, 1, 0.70),
    (3, 2, 0.75),
    (3, 3, 0.80),
    (3, 4, 0.85),
    (4, 1, 0.90),
    (4, 2, 0.95),
    (4, 3, 0.85),
    (4, 4, 0.80);
