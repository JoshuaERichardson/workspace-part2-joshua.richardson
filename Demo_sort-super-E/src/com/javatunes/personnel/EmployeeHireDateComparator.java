package com.javatunes.personnel;

import java.util.Comparator;

/*
 * Since Employee is abstract, I am obviously being passed either
 * SalariedEmployee objects or HourlyEmployee objects.
 * BUT I only see them as Employee, so I only have two sort keys available:
 *  name
 *  hireDate
 *
 * I choose to compare based only on hireDate.
 */
public class EmployeeHireDateComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getHireDate().compareTo(emp2.getHireDate());
    }
}