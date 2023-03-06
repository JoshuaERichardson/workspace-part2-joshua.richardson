package com.javatunes.personnel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() throws Exception {
        emp1 = new SalariedEmployee("Jack", Date.valueOf("2020-10-10"));
        emp2 = new SalariedEmployee("Jack", Date.valueOf("2020-10-10"));
    }

    @Test
    public void hashCode_shouldBeEqual_whenObjectsEqual() {
        assertEquals(emp1.hashCode(),emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2);
        assertTrue(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHigherDate() {
        emp2.setHireDate(Date.valueOf("2000-10-10"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_diffName_sameHigherDate() {
        emp2.setName("Adam");
        assertNotEquals(emp1,emp2);
    }
}