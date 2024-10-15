import java.util.Scanner;

//Class for Date Calculation.
class DateCalc{
    int daynum;
    int calculateDaysBetween(int startDay, int startMonth, int startYear,int endDay, int endMonth, int endYear) 
    {
        int Smonthdays, Emonthdays, LYDetector, days = 0;

        //For calculating days for each year between startYear and endYear.
        for (int year = startYear; year < endYear; year++) 
        {
            LYDetector = isLeapYear(year);
            if (LYDetector==1) 
            {
                days = days + 366;
            } else {
                days = days + 365;
            }
        }

        //For calculating days for each month in the start year.
        for (int month=1; month<startMonth; month++) 
        {
            Smonthdays = getDaysInMonth(month, startYear);
            days = days - Smonthdays;
        }
        days = days - startDay;

        //For calculating days for each month in the end year.
        for (int month = 1; month < endMonth; month++) 
        {
            Emonthdays = getDaysInMonth(month, endYear);
            days = days + Emonthdays;
        }
        days = days + endDay;
        return days;
    }

    //For Checking whether entered year is leap year or not.
    int isLeapYear(int year) 
    {
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            return 1;
        } else {
            return 0;
        }
    }

    //For getting days in the entered month.
    int getDaysInMonth(int month, int year) 
    {
        int LYDetector;
        if (month == 2) 
        {
            LYDetector = isLeapYear(year);
            if (LYDetector==1) 
            {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    //For Calculating Weeks in a day
    void getDayofWeek(int daynum)
    {
        if(daynum==1)
        {
            System.out.println("SUNDAY");
            System.out.println("__________________________________________________________________");
        } 
        else if (daynum==2) {
            System.out.println("MONDAY");
            System.out.println("__________________________________________________________________");
        }
        else if (daynum==2)
        {
            System.out.println("TUESDAY");
            System.out.println("__________________________________________________________________");
        }
        else if (daynum==2)
        {
            System.out.println("WEDNESDAY");
            System.out.println("__________________________________________________________________");
        }
        else if (daynum==2)
        {
            System.out.println("FRIDAY");
            System.out.println("__________________________________________________________________");
        }
        else if (daynum==2)
        {
            System.out.println("SATURDAY");
            System.out.println("__________________________________________________________________");
        } 
        else {
            System.out.println("NOT A WEEKDAY!!!");
            System.out.println("__________________________________________________________________");
        }

    }
}

public class CoreJavaProject{
    public static void main(String[] args) 
    {
        Scanner ob = new Scanner(System.in);
        int startDay, startMonth, startYear;
        int endDay, endMonth, endYear;
        int option, day, year, temp;

        //Creating Object of class DateCalc.
        DateCalc D = new DateCalc();

        System.out.println("__________________________________________________________________");
        System.out.println("Menu:");
        System.out.println("1.Finding days between dates.");
        System.out.println("2.Find day of week.");
        System.out.println("3.Check a year is leap year or not.");
        System.out.println("4.Exit.");
        System.out.println("__________________________________________________________________");
        System.out.print("Enter your choice: ");
        option = ob.nextInt();
        while(option!=4)
        {
            switch(option)
            {
               case 1:  System.out.println("---------------------------------------------------");

                        //Taking user input.
                        //Start Date.
                        System.out.println("Enter the Start Date: ");
                        System.out.println("---------------------------------------------------");
                        System.out.println("Enter the Day, Month, Year (Format - DD MM YYYY): ");
                        startDay = ob.nextInt();
                        startMonth = ob.nextInt();
                        startYear = ob.nextInt();
                        System.out.println(" ");
                        System.out.println("---------------------------------------------------");
        
                        //End Date.
                        System.out.println("Enter the End Date: ");
                        System.out.println("---------------------------------------------------");
                        System.out.println("Enter the Day, Month, Year (Format - DD MM YYYY): ");
                        endDay = ob.nextInt();
                        endMonth = ob.nextInt();
                        endYear = ob.nextInt();
                        System.out.println(" ");

                        //Checking if proper dates are entered.
                        if(endYear<startYear || startMonth>12 || endMonth>12 || startMonth<1 || endMonth<1)
                        {
                            System.out.println("__________________________________________________________________");
                            if(endYear<startYear)
                            {
                                System.out.println("End year date must be larger than start year date.");
                                System.out.println("__________________________________________________________________");
                            } else {
                                System.out.println("Months must be between 01-12.");
                                System.out.println("__________________________________________________________________");
                            }

                        } else if(D.getDaysInMonth(startMonth,startYear)<startDay || D.getDaysInMonth(endMonth,endYear)<endDay) {

                            System.out.println("__________________________________________________________________");
                            System.out.println("Day must be entered properly.");
                            System.out.println("__________________________________________________________________");

                        } else if(startDay<=0 || endDay<=0) {

                            System.out.println("__________________________________________________________________");
                            System.out.println("Day can't be zero or negative.");
                            System.out.println("__________________________________________________________________");

                        } else { 

                        //Calling calculateDaysBetween method from CalcDate class for getting output.
                        int daysBetween = D.calculateDaysBetween(startDay, startMonth, startYear, endDay, endMonth, endYear);

                        //Displaying the Output.
                        System.out.println("__________________________________________________________________");
                        System.out.println("Number of days between the two dates: " + daysBetween);
                        System.out.println("__________________________________________________________________");
                        System.out.println(" ");
                        }
                        break;
                
                case 2: System.out.println("---------------------------------------------------");
                        System.out.print("Enter a number(1-7): ");
                        day=ob.nextInt();
                        System.out.println("---------------------------------------------------");
                        D.getDayofWeek(day);
                        break;

                case 3: System.out.println("---------------------------------------------------");
                        System.out.print("Enter the year: ");
                        year = ob.nextInt();
                        System.out.println("---------------------------------------------------");
                        temp = D.isLeapYear(year);
                        if(temp==1)
                        {
                            System.out.println(year + " is a leap year.");
                        } else {
                            System.out.println(year + " is not a leap year.");
                        }
                        System.out.println("__________________________________________________________________");
                        break;
                
                case 4: break;

                default: System.out.println("Enter a Valid choice.");
                         break;
            }
            System.out.print("Enter your choice: ");
            option = ob.nextInt();
        }
        System.out.println("__________________________________________________________________");
        System.out.println("Quiting...");

        //Closing Scanner Class Object.
        ob.close();
    }
}
