package com.javatunes.personnel.client;

import com.javatunes.personnel.Employee;
import com.javatunes.personnel.HourlyEmployee;
import com.javatunes.personnel.SalariedEmployee;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

class EmployeeAddAllTest {

    public static void main(String[] args) {
        // what's the "E"?  Employee.  It will hold both kinds - Hourly and Salaried.
        Collection<Employee> emps = new ArrayList<>();
        emps.add(new SalariedEmployee("Jason", Date.valueOf("1990-08-24"), 1500.0));
        emps.add(new HourlyEmployee("Marilyn", Date.valueOf("2017-07-04"), 25.0, 32.0));


        // here, we have a Collection<SalariedEmployee> specifically - no other kind!
        // what's the "E"?  SalariedEmployee.
        Collection<SalariedEmployee> newHires = new ArrayList<>();
        newHires.add(new SalariedEmployee("Tammy", Date.valueOf("1989-08-26"), 1250.0));
        newHires.add(new SalariedEmployee("Susan", Date.valueOf("1990-09-30"), 2425.0));

        // can we "merge" the SalariedEmployees in 'newHires' into the 'emps' collection?
        // Think IS-A.
        // YES, OF COURSE we can - 'emps' can hold both kinds!
        emps.addAll(newHires);


        // here, we have a Collection<HourlyEmployee> specifically
        // what's the "E"?  HourlyEmployee.
        Collection<HourlyEmployee> temps = new ArrayList<>();
        temps.add(new HourlyEmployee("Ann", Date.valueOf("1986-10-09"), 22.5, 40.0));
        temps.add(new HourlyEmployee("Joe", Date.valueOf("2020-01-08"), 20.0, 25.0));

        // can we "merge" the HourlyEmployees in 'temps' into the 'emps' collection?
        // AGAIN, OF COURSE we can - 'emps' can hold both kinds!
        emps.addAll(temps);

        // show that all 6 are in there
        dump(emps);
    }

    private static void dump(Collection<Employee> employees) {
        System.out.println("Size: " + employees.size());

        for (Employee emp : employees) {
            System.out.println(emp);  // toString() automatically called
        }
    }
}