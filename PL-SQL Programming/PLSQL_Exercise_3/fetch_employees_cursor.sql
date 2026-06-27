SET SERVEROUTPUT ON;

DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, last_name
        FROM employees;

    v_employee_id   employees.employee_id%TYPE;
    v_last_name     employees.last_name%TYPE;
BEGIN
    OPEN emp_cursor;

    LOOP
        FETCH emp_cursor INTO v_employee_id, v_last_name;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID: ' || v_employee_id || ', Name: ' || v_last_name);
    END LOOP;

    CLOSE emp_cursor;
END;
/
