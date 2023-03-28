/*Query1*/

SELECT      customerName, 
 COUNT(*) as orderCount  FROM  customers
 JOIN orders 
	ON customers.customerNumber = orders.customerNumber  
GROUP BY      customers.customerNumber  
HAVING      COUNT(*) = (SELECT COUNT(*) as orderCount 
						FROM  orders  GROUP BY customerNumber          
                        ORDER BY orderCount  
                        DESC          
                        LIMIT 1     )
/*Query2*/

SELECT c.customerName, od.* FROM customers c
INNER JOIN orders o ON c.customerNumber = o.customerNumber
INNER JOIN orderdetails od ON o.orderNumber = od.orderNumber
WHERE c.country = 'Germany';

/*Query3*/

SELECT e.employeeNumber, e.firstName, e.lastName, COALESCE(SUM(p.amount), 0) as revenue
FROM employees e
LEFT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
LEFT JOIN payments p ON c.customerNumber = p.customerNumber
GROUP BY e.employeeNumber;

/*Query4*/

SELECT DISTINCT p.productCode, p.productName
FROM products p
JOIN orderdetails od ON p.productCode = od.productCode
JOIN orders o ON od.orderNumber = o.orderNumber
WHERE o.orderDate >= '2004-12-01' AND o.orderDate < '2005-01-01';

/*Query5*/

CREATE TABLE employeedetails (
  employeeNumber INT NOT NULL,
  bankAccount VARCHAR(50),
  address VARCHAR(100),
  phoneNumber VARCHAR(20),
  personalEmail VARCHAR(50),
  PRIMARY KEY (employeeNumber),
  FOREIGN KEY (employeeNumber) REFERENCES employees(employeeNumber)
);classicmodelsemployees