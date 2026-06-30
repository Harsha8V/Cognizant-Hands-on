CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
UPDATE Accounts
SET balance = balance + (balance * 0.01)
WHERE account_type = 'Savings';
COMMIT;
END ProcessMonthlyInterest;
/


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_dept_id IN NUMBER, p_bonus_pct IN NUMBER) IS
BEGIN
UPDATE Employees
SET salary = salary + (salary * (p_bonus_pct / 100))
WHERE department_id = p_dept_id;
COMMIT;
END UpdateEmployeeBonus;
/


CREATE OR REPLACE PROCEDURE TransferFunds(p_from_acc IN NUMBER, p_to_acc IN NUMBER, p_amount IN NUMBER) IS
    v_balance NUMBER;
BEGIN
SELECT balance INTO v_balance FROM Accounts WHERE account_id = p_from_acc;

IF v_balance >= p_amount THEN
UPDATE Accounts SET balance = balance - p_amount WHERE account_id = p_from_acc;
UPDATE Accounts SET balance = balance + p_amount WHERE account_id = p_to_acc;
COMMIT;
END IF;
END TransferFunds;
/

