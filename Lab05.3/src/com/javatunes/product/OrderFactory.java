package com.javatunes.product;

import com.javatunes.billing.*;

class OrderFactory {

    public static TaxCalculator getOrder(Location location){
        TaxCalculator calc = null;

        switch(location) {
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
                break;
            case ONLINE:
                calc = new OnlineTax();
        }
        return calc;

    }
}