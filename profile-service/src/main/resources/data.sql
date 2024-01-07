-- Insert into profiles
INSERT INTO profiles (user_id, current_job_title, industry, summary, headline, website, open_for_work)
VALUES (1, 'Software Developer', 'Information Technology', 'Experienced in full-stack development',
        'Senior Software Developer', 'http://profilewebsite1.com', true),
       (2, 'Data Analyst', 'Data Science', 'Expert in data analysis and visualization', 'Lead Data Analyst',
        'http://profilewebsite2.com', true),
       (3, 'Project Manager', 'Project Management', 'Skilled in managing large-scale projects', 'Project Manager',
        'http://profilewebsite3.com', true);

-- Insert into education
INSERT INTO education (profile_id, school, degree, field_of_study, start_date, end_date)
VALUES (1, 'Tech University', 'BSc Computer Science', 'Computer Science', '2015-09-01', '2019-06-30'),
       (2, 'Data Institute', 'MSc Data Science', 'Data Science', '2016-09-01', '2018-08-31'),
       (3, 'Management School', 'MBA', 'Business Administration', '2014-09-01', '2016-05-31');

-- Insert into experiences
INSERT INTO experiences (profile_id, job_title, company_name, location, start_date, end_date)
VALUES (1, 'Junior Developer', 'Tech Corp', 'New York', '2019-07-01', '2021-08-31'),
       (2, 'Data Analyst', 'DataSolutions', 'San Francisco', '2018-09-01', '2020-09-30'),
       (3, 'Project Coordinator', 'GlobalProjects', 'London', '2016-06-01', '2018-12-31');

-- Insert into skills (assuming skills are predefined)
INSERT INTO skills (name)
VALUES ('Java'),
       ('Python'),
       ('Project Management');

-- Associate skills with profiles
INSERT INTO profiles_skills (profile_id, skill_id)
VALUES (1, 1), -- Profile 1 has Java
       (2, 2), -- Profile 2 has Python
       (3, 3);
-- Profile 3 has Project Management

-- Insert into profiles_connections (assuming some profiles are connected)
INSERT INTO profiles_connections (profile1_id, profile2_id)
VALUES (1, 2), -- Profile 1 connected with Profile 2
       (2, 3); -- Profile 2 connected with Profile 3
