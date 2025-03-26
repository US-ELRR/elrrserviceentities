SET search_path TO elrr;

TRUNCATE TABLE organization CASCADE;
TRUNCATE TABLE location CASCADE;
TRUNCATE TABLE person CASCADE;
TRUNCATE TABLE identity CASCADE;
TRUNCATE TABLE association CASCADE;
TRUNCATE TABLE qualification CASCADE;
TRUNCATE TABLE person_qualification CASCADE;
TRUNCATE TABLE learning_resource CASCADE;
TRUNCATE TABLE learning_record CASCADE;
TRUNCATE TABLE phone CASCADE;
TRUNCATE TABLE person_phone CASCADE;
TRUNCATE TABLE email CASCADE;
TRUNCATE TABLE person_email CASCADE;
TRUNCATE TABLE facility CASCADE;
TRUNCATE TABLE organization_facility CASCADE;  
TRUNCATE TABLE employment_record CASCADE;
TRUNCATE TABLE employment_qualification CASCADE;
TRUNCATE TABLE military_record CASCADE;