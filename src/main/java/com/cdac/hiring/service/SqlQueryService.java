package com.cdac.hiring.service;

import org.springframework.stereotype.Service;

@Service
public class SqlQueryService {

    /**
     * Generates the SQL query based on the registration number.
     * Odd last two digits -> Question 1
     * Even last two digits -> Question 2
     */
    public String generateSqlQuery(String regNo) {
        int lastTwoDigits = extractLastTwoDigits(regNo);
        
        if (lastTwoDigits % 2 == 1) {
            // Odd - Question 1
            return getQuestion1Query();
        } else {
            // Even - Question 2
            return getQuestion2Query();
        }
    }

    private int extractLastTwoDigits(String regNo) {
        // Extract numeric part from registration number
        String numericPart = regNo.replaceAll("[^0-9]", "");
        if (numericPart.length() >= 2) {
            return Integer.parseInt(numericPart.substring(numericPart.length() - 2));
        } else if (numericPart.length() == 1) {
            return Integer.parseInt(numericPart);
        }
        return 0;
    }

    /**
     * Question 1 SQL Query (for odd registration numbers)
     * 
     * Note: You need to replace this with the actual SQL query 
     * from the Google Drive link for Question 1
     */
    private String getQuestion1Query() {
        
        return "SELECT * FROM your_table WHERE condition = 'Question1'";
    }

    /**
     * Question 2 SQL Query (for even registration numbers)
     * 
     * Problem: Calculate average age and employee list for employees earning > ₹70,000 per department
     * Output: DEPARTMENT_NAME, AVERAGE_AGE, EMPLOYEE_LIST (max 10 employees)
     * Order: Department ID descending
     */
    private String getQuestion2Query() {
        return "WITH HighEarners AS (SELECT DISTINCT e.EMP_ID, e.FIRST_NAME, e.LAST_NAME, e.DEPARTMENT, " +
               "TIMESTAMPDIFF(YEAR, e.DOB, CURDATE()) AS AGE FROM EMPLOYEE e INNER JOIN PAYMENTS p ON " +
               "e.EMP_ID = p.EMP_ID WHERE p.AMOUNT > 70000), RankedEmployees AS (SELECT he.*, " +
               "ROW_NUMBER() OVER (PARTITION BY he.DEPARTMENT ORDER BY he.EMP_ID) AS rn FROM HighEarners he) " +
               "SELECT d.DEPARTMENT_NAME, ROUND(AVG(re.AGE), 2) AS AVERAGE_AGE, " +
               "GROUP_CONCAT(CONCAT(re.FIRST_NAME, ' ', re.LAST_NAME) ORDER BY re.EMP_ID SEPARATOR ', ') AS EMPLOYEE_LIST " +
               "FROM DEPARTMENT d INNER JOIN RankedEmployees re ON d.DEPARTMENT_ID = re.DEPARTMENT " +
               "WHERE re.rn <= 10 GROUP BY d.DEPARTMENT_ID, d.DEPARTMENT_NAME ORDER BY d.DEPARTMENT_ID DESC";
    }
}
