/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassApplication;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class CalendarUse {
    private final Calendar calendar = Calendar.getInstance();
    private final SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("EEEE");
    private final SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("dd-M-yyyy");
    private final Date date = new Date();
    
    private final String currentDate;
    private final String dayOfTheWeek;
    
    public CalendarUse(){
        this.dayOfTheWeek = simpleDateFormatDay.format(date);
        this.currentDate = simpleDateFormatDate.format(calendar.getTime()).toUpperCase();
    }
    
    public String getDayOfTheWeek(){
        return this.dayOfTheWeek;
    }
    
    
    public String getDate(){
        return this.currentDate;
    }
}
