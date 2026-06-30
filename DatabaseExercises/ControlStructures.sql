DECLARE
BEGIN
FOR r IN (SELECT customer_id FROM Customers WHERE age > 60) LOOP
UPDATE Loans
SET interest_rate = interest_rate - 1
WHERE customer_id = r.customer_id;
END LOOP;
COMMIT;
END;
/

DECLARE
BEGIN
FOR r IN (SELECT customer_id FROM Customers WHERE balance > 10000) LOOP
UPDATE Customers
SET is_vip = 'TRUE'
WHERE customer_id = r.customer_id;
END LOOP;
COMMIT;
END;
/


DECLARE
BEGIN
FOR r IN (SELECT customer_id, loan_id FROM Loans WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || r.customer_id || ' your loan ' || r.loan_id || ' is due soon.');
END LOOP;
END;
/