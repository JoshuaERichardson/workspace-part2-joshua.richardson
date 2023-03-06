/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Objects;

public class HourlyEmployee extends Employee {
    private Double rate;
    private Double hours;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, Date hireDate) {
        super(name, hireDate);
    }

    public HourlyEmployee(String name, Date hireDate, Double rate, Double hours) {
        this(name, hireDate);
        setRate(rate);
        setHours(hours);
    }

    @Override
    public double pay() {
        double payment = getRate() * getHours();
        System.out.println(getName() + " is paid hourly " + payment);
        return payment;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getHours() {
        return this.hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    // leverage super.toString() for classname, name, and hireDate
    @Override
    public String toString() {
        return super.toString() + ", rate=" + getRate() + ", hours=" + getHours();
    }

    // leverage super.equals() for name, hireDate equality, check rate and hours here
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof HourlyEmployee) {
            HourlyEmployee other = (HourlyEmployee) obj;
            result = super.equals(obj) &&
                     Objects.equals(this.getRate(), other.getRate()) &&
                     Objects.equals(this.getHours(), other.getHours());
        }
        return result;
    }

    // take the hash of superclass (name, hireDate) and add rate and hours to the mix
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRate(), getHours());
    }
}