/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLC;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author huy
 */
public class Extension {
    
    public Date AddDate(int borrowdate){
        java.sql.Date todaysDate = new java.sql.Date(new java.util.Date().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(todaysDate);
        c.add(Calendar.DATE, borrowdate);
        return new Date(c.getTimeInMillis());
    }
    public Date AddMonth(int borrowMonth){
        java.sql.Date todaysDate = new java.sql.Date(new java.util.Date().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(todaysDate);
        c.add(Calendar.MONTH, borrowMonth);
        return new Date(c.getTimeInMillis());
    }
}
