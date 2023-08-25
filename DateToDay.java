import java.util.Scanner;

class DateToDay
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("\tDate To Day ");
        System.out.println("=====================================");
        while(true)
        {
            System.out.print("\nEnter Date ( 1 - 31 ) : ");
            int date=sc.nextInt();
            System.out.print("Enter Month (1 - 12 ) : ");
            int month=sc.nextInt();
            System.out.print("Enter Year\t      : ");
            int year=sc.nextInt();

            int month_odd_Days=0;
            if(year%4==0)
                month_odd_Days = calculateMonthOddDays_leapyear(month-1);
            else
               month_odd_Days = calculateMonthOddDays(month-1);
            int year_odd_Days=calculateYearOddDays(year-1);
            System.out.println("------------------------------------");
            System.out.print(date+" : "+month+" : "+year);
            String day=calculate_Day(date,month_odd_Days,year_odd_Days);
            System.out.println(" -> "+day);

            System.out.println("------------------------------------");
            System.out.print("Do you want to Check Again (Y/N):");
            char check=sc.next().charAt(0);
            System.out.println("------------------------------------");
            if(check=='Y' || check=='y')
                continue;
            else    
                break; 
        }
        sc.close();
    }

    private static String calculate_Day(int date,int month_odd_Days,int year_odd_Days)
    {
        int total_odd_days=(date+month_odd_Days+year_odd_Days)%7;

        var day=switch (total_odd_days) {
            case 0-> "Sunday";
            case 1-> "Monday";
            case 2-> "Tuesday";
            case 3-> "Wednesday";
            case 4-> "Thursday";
            case 5-> "Friday";
            case 6-> "Saturday";
            default-> "Sorry cannot resolve";
        };
        return day;
    }
    private static int calculateMonthOddDays(int month)
    {
        //add odd days of previous month should be added and take a reminder 
        //when divisble by 7
        int month_odd_Days=switch (month) {
            case 1-> 3;
            case 2-> 3;
            case 3-> 6;
            case 4-> 1;
            case 5-> 4;
            case 6-> 6;
            case 7-> 2;
            case 8-> 5;
            case 9-> 0;
            case 10-> 3;
            case 11-> 5;
            case 12-> 1;
            default-> 0;
        };
        return month_odd_Days;

    }

    private static int calculateMonthOddDays_leapyear(int month)
    {
        int month_odd_Days=
            switch (month) {
                case 1-> 3;
                case 2-> 4;
                case 3-> 0;
                case 4-> 2;
                case 5-> 5;
                case 6-> 0;
                case 7-> 3;
                case 8-> 6;
                case 9-> 1;
                case 10-> 4;
                case 11-> 6;
                case 12-> 2;
                default-> 0;
        };
        return month_odd_Days;
    }

    private static int calculateYearOddDays(int year)
    {
        int years=year;
        int leapyears=year/4;
        int hundred_years=years/100;
        int four_hundred_years=years/400;

        int year_odd_Days=(years+leapyears-hundred_years+four_hundred_years)%7;

        return year_odd_Days;
    }
}