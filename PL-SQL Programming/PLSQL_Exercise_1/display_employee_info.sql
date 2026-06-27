SET SERVEROUTPUT ON;

DECLARE
    v_employee_id   NUMBER := 101;
    v_first_name    VARCHAR2(50) := 'John';
    v_last_name     VARCHAR2(50) := 'Doe';
    v_salary        NUMBER := 75000;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee ID: ' || v_employee_id);
    DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_first_name || ' ' || v_last_name);
    DBMS_OUTPUT.PUT_LINE('Salary: $' || v_salary);
END;
/
