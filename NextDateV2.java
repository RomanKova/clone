package week2;

/**
 * <p> This unit is an independent program including a couple of classes</p>
 * by which the next date is generated using the given current</p>
 * day, month and year. </p>
 *<p> It should be noted that some months are 30 days, and some 31 days. </p>
 * </p>There is February that is either 28 or 29 depending on whether or not
 * the year is a leap year.</p>
 * <code> nextDate of 1/3/2022 is 1/4/2022 in mm/dd/yyyy format</code>
 **/

/* 
 * An error has been added to this code for the purpose of the activity 
 * of week 2 of EECS4313- Group B 
 */
public class NextDateV2 {
    public static SimpleDateV2 nextDate(SimpleDateV2 date) {
           int tomorrowDay, tomorrowMonth, tomorrowYear;
           tomorrowMonth = date.month;
           tomorrowDay = date.day;
           tomorrowYear = date.year; 
           switch (date.month) {
           // 31 day months (except Dec.)
           case 1:
           case 3:
           case 5:
           case 7:
           case 8:
           case 10:
                  if (date.day < 31)
                       tomorrowDay = date.day + 1;
                  else {
                       tomorrowDay = 1;
                       tomorrowMonth = date.month + 1;
                  }
                  break;
            // 30 day months
            case 4:
            case 6:
            case 9:
            case 11:
                  if (date.day < 30)
                       tomorrowDay = date.day + 1;
                  else {
                       tomorrowDay = 1;
                       tomorrowMonth = date.month + 1;
                  }
                  break;
            // December
            case 12:
                  if (date.day < 31)
                       tomorrowDay = date.day + 1;
                  else {
                       tomorrowDay = 1;
                       tomorrowMonth = 1;
                       if (date.year == 2042)
                           System.out.println("Date beyond 2042 ");
                       else
                           tomorrowYear = date.year + 1;
}
                  break;
            // February
            case 2:
                  if (date.day < 28)
                       tomorrowDay = date.day + 1;
                  else {
                       if (date.day == 28) {
                           if (date.isLeap())
                               tomorrowDay = 29;
                           else {
                               tomorrowDay = 1;
                               tomorrowMonth = 3;
                           }
                       } else if(date.day == 29) {
                               tomorrowDay = 1;
                               tomorrowMonth = 3;
                       }
                  }
                  break;
            }
            return new SimpleDateV2(tomorrowMonth, tomorrowDay, tomorrowYear);
    }
}



class SimpleDateV2 {
    int month;
    int day;
    int year;
    public SimpleDateV2() {
        this.month = 1;
        this.day = 3;
        this.year = 2022;
    }

    public SimpleDateV2(int month, int day, int year) {
           if(!rangesOK(month, day, year))
                      throw new IllegalArgumentException("Invalid Date");
           this.month = month;
           this.day = day;
           this.year = year;
    }
    // all the getters and setters methods are here
    public int getMonth() {
           return month;
    }
    public void setMonth(int month) {
           this.month = month;
    }
    public int getDay() {
           return day;
    }
    public void setDay(int day) {
           this.day = day;
    }
    public int getYear() {
           return year;
    }
    public void setYear(int year) {
           this.year = year;
    } 
    
    boolean rangesOK(int month, int day, int year) {
        boolean dateOK = true;
        dateOK &= (year > 1841) && (year < 2043); // Year OK?
        dateOK &= (month > 0) && (month < 13); // Month OK?
        dateOK &= (day > 0) && ( //day ok
     		   ((month == 1 || month == 3 || month == 5 || 
     		   month == 7 || month == 8 || month == 10 || 
     		   month == 12) && day < 32) ||
     		   ((month == 4 || month == 6 || month == 9 || 
     		   month == 11) && day < 31) ||
              ((month == 2 && isLeap(year)) && day < 30) ||
              ((month == 2 && !isLeap(year)) && day < 29));
        return dateOK;
    }
 
    /**
     * A leap year is divisible by 4 except for century years. 
     * The century year, which are divisible by 400 are leap year. 
     * @param year is the year that is checked for being a leap year
     * @return true if the input parameter is a leap year
     */
       private boolean isLeap(int year) {
              boolean isLeapYear = false;
              if (year % 4 == 0 && year % 100 == 0)
            	  isLeapYear = true; 
              else if ((year % 400 == 0))
            	  isLeapYear = true;
              else isLeapYear = false;
              return isLeapYear;        
              
       }    
    
    public boolean isLeap() {
                 return isLeap(year);
    }
    
    
    @Override
    public boolean equals(Object obj) {
                 boolean areEqual = false;
                 if(obj instanceof SimpleDateV2) {
                       SimpleDateV2 simpleDate = (SimpleDateV2) obj;
                       areEqual = simpleDate.getDay() == getDay() &&
                             simpleDate.getMonth() == getMonth() &&
                             simpleDate.getYear() == getYear();
                 }
                 return areEqual;
    }
    // some other related code is here 
}

