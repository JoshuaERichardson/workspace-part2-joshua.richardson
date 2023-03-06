package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Josh", Date.valueOf("1997-04-08"), 50000.5);
        emp2 = new SalariedEmployee("Josh", Date.valueOf("1997-04-08"), 50000.5);
    }

    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes() {
        assertEquals(emp1.hashCode(),emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1,emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("DIFFERENT");
        assertNotEquals(emp1,emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("1990-09-09"));
        assertNotEquals(emp1,emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentSalary() {
        emp2.setSalary(14.0);
        assertNotEquals(emp1,emp2);
    }


    @Test
    public void testPay() {
        assertEquals("Josh is paid salary 50000.5", emp1.pay());
    }

    @Test
    public void testPayTaxes() {
        assertEquals(.3*50000.5, emp1.payTaxes(), .00003);

    }
}