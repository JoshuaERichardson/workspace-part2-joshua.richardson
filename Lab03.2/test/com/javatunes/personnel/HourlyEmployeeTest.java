package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;

    @Before
    public void setUp(){
        emp = new HourlyEmployee("Martin", Date.valueOf("2011-02-17"), 25.0, 35.0);
    }

    @Test
    public void testPay() {
        assertEquals("Martin is paid hourly " + 25.0 * 35.0, emp.pay());
    }

    @Test
    public void testPayTaxes() {
        assertEquals(218.75, emp.payTaxes(), 0.001);
    }
}