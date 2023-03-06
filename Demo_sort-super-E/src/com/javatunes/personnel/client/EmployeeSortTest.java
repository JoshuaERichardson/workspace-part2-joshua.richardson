package com.javatunes.personnel.client;

import com.javatunes.personnel.Employee;
import com.javatunes.personnel.EmployeeHireDateComparator;
import com.javatunes.personnel.HourlyEmployee;
import com.javatunes.personnel.SalariedEmployee;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class EmployeeSortTest {

    public static void main(String[] args) {
        // I am a Comparator<Employee>, an "independent 3rd party" that compares Employees.
        // I can be used to compare any types of Employee: SalariedEmployee or HourlyEmployee.
        // I can only compare based on name or hireDate, and I choose to do it by hireDate.
        Comparator<Employee> comparator = new EmployeeHireDateComparator();

        // This is collection of SalariedEmployees specifically - just SalariedEmployees.
        // Since they are SalariedEmployees, they OF COURSE have a hireDate.
        // That's great, because that's what the comparator compares by.
        List<SalariedEmployee> semps = new ArrayList<>();
        semps.add(new SalariedEmployee("Logan",   Date.valueOf("2000-01-01"), 1500.0));
        semps.add(new SalariedEmployee("Amilia",  Date.valueOf("1998-10-11"), 2500.0));
        semps.add(new SalariedEmployee("Jackie",  Date.valueOf("2022-11-15"), 1150.0));

        // sort() takes a Comparator<? super E>
        // The "E" for semps is SalariedEmployee, and I'm passing a Comparator<Employee>.
        semps.sort(comparator);
        dump(semps);
        System.out.println();


        // This is a collection of HourlyEmployees specifically - just HourlyEmployees.
        // Since they are HourlyEmployees, they OF COURSE have a hireDate.
        // That's great, because that's what the comparator compares by.
        List<HourlyEmployee> hemps = new ArrayList<>();
        hemps.add(new HourlyEmployee("Jenny", Date.valueOf("2007-06-30"), 50.0, 25.0));
        hemps.add(new HourlyEmployee("Edwin", Date.valueOf("1996-03-08"), 25.0, 40.0));
        hemps.add(new HourlyEmployee("Julie", Date.valueOf("1986-12-05"), 35.0, 20.0));

        // sort() takes a Comparator<? super E>
        // The "E" for hemps is HourlyEmployee, and I'm passing a Comparator<Employee>.
        hemps.sort(comparator);
        dump(hemps);
        System.out.println();
    }

    private static void dump(Collection<?> collection) {
        for (Object obj : collection) {
            System.out.println(obj);  // obj.toString() - all classes have this method!
        }
    }
}