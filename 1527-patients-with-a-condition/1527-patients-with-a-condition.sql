# Write your MySQL query statement below
select patient_id, patient_name, conditions from Patients
WHERE conditions LIKE 'DIAB1%' or conditions LIKE '% DIAB1%'