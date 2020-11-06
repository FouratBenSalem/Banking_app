import java.util.Scanner;

public class Account 
{
    // Class Variable

    int balance;
    int previousTrans;
    String custFirstName;
    String custLastName;
    String custID;

    double interestRate = 0.025;
    double loanInterest = 0.065;

    // Class Constructor
    public Account(String cFName, String cLName,String cId)
    {
        this.custFirstName=cFName;
        this.custLastName =cLName;
        this.custID = cId;
        
    }

    // Method to Deposit money
    void deposit(int amount)
    {
        if(amount !=0)
        {
            balance += amount;
            previousTrans = amount;
        }
    }

    // Method to Withdraw Money
    void withdraw(int amount)
    {
        if(amount != 0)
        {
            balance -= amount;
            previousTrans = -amount;
        }
    }

    // Method to show the previous transaction
    void getPreviousTrans()
    {
         if(previousTrans > 0)
            System.out.println(" Deposited : $" + previousTrans);
        else if(previousTrans < 0)
            System.out.println(" Withdrawn : $" + Math.abs(previousTrans));
        else
            System.out.println(" No Transaction Occured.");
    }

    // Method to calculate interest of current fund after nber of years
    void calculateInterest(int years)
    {
        double newBalance = balance * (1 + interestRate * years);
        System.out.println(" Current Interest Rate : " + (100 * interestRate));
        System.out.println(" Balance After "+years+" Years : $"+newBalance); 
    }


    // LOAN CALCULATIONS
    // CAlculate monthly payments
    void calcMonthlyPayments()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("\n  Enter Loan Amount: $ ");
        double loanAmount = sc1.nextDouble();
        System.out.print("  Enter Number of Months ");
        int months = sc1.nextInt();
        double mPayments = (loanAmount * (loanInterest/12) * Math.pow(1 + (loanInterest/12), months ) )
                             /  ( Math.pow(1 + (loanInterest/12), months ) -1 );
        System.out.format("  Monthly Payments : $%.2f",mPayments);
    }
    void calcLoanAmount()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("\n  Enter Monthly Payment: $ ");
        double monthlyPay = sc1.nextDouble();
        System.out.print("  Enter Number of Months ");
        int months = sc1.nextInt();
        double loanAmount = (monthlyPay / (loanInterest/12)) * (1 - 1/Math.pow(1 + (loanInterest/12), months )) ;
        System.out.format("  Loan Amount : $%.2f",loanAmount);

    }
    void calcNumberOfMonths()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("\n  Enter Monthly Payment: $ ");
        double monthlyPay = sc1.nextDouble();
        System.out.print("  Enter Loan Amount : $ ");
        double loanAmount = sc1.nextDouble();

        double months = Math.log( (monthlyPay/(loanInterest/12)) / ( (monthlyPay/(loanInterest/12))-  loanAmount) ) 
                / Math.log(1 + (loanInterest/12));
        System.out.format("  Number of Months : %.0f",months+1);

    }
    

    void mainMenu()
    {
        System.out.println("\n What Would You Like To Do?");
        System.out.println(" ______________________________ ");
        System.out.println("| 1) Check Your Balance        |");
        System.out.println("| 2) Make a Deposit            |");
        System.out.println("| 3) Make a Withdrawal         |");
        System.out.println("| 4) View Previous Transaction |");
        System.out.println("| 5) Calculate Interest        |");
        System.out.println("| 6) Loan Calculator           |");
        System.out.println("| 7) Settings & Informations   |");
        System.out.println("|                              |");
        System.out.println("| 8) Exit                      |");
        System.out.println("|______________________________|");
    }

    // Method showing the Main Menu
    void showMenu()
    {
        int option=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n - Welcome, "+custFirstName + " "+custLastName+" !\n - Your ID  is : "+custID);
        
        mainMenu();

        do
        {
            System.out.print("\n Enter an Option..  ");
            option = sc.nextInt();

            switch (option)
            {
                case 1 :  // check balance
                    System.out.println("\n-=======================-");
                    System.out.println(" Balance = $"+balance);
                    System.out.println("-=======================-\n");
                    break;

                case 2: // make a deposit
                    System.out.print(" Enter an amount to deposit :  ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    break;

                case 3 : // make a withdrawal
                    System.out.print(" Enter an amount to withdraw :  ");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    break;

                case 4: // view previous transaction
                    System.out.println("\n-=======================-");
                    getPreviousTrans();
                    System.out.println("-=======================-\n");
                    break;
                case 5: // Calculate interest over a number of years
                    System.out.print(" Enter number of Years of accrued Interest :  ");
                    int years = sc.nextInt();
                    calculateInterest(years);

                    break;
                case 6 :    // Loan Calculations
                    System.out.println("\n-=============================-");
                    System.out.println("       * Loan Calculator *");
                    System.out.println("  1) Find The Monthly Payment");
                    System.out.println("  2) Find The Loan Amount");
                    System.out.println("  3) Find Number of Months");
                    System.out.println("  4) Return to Main Menu");
                    int option1=0;
                    do
                    {
                        System.out.print("\n  Please Choose an Option..  ");
                        option1 = sc.nextInt();
                        switch (option1)
                        {
                            case 1 :
                                calcMonthlyPayments();
                                break;
                            case 2 :
                                calcLoanAmount();
                                break;
                            case 3 :
                                calcNumberOfMonths();
                                break;
                            case 4 :
                                mainMenu();
                                break;
                            default : 
                                System.out.println("  Please Enter a Valid Option!");
                                
                        }
                    }while(option1 != 4);
                    break;
                case 7:
                    System.out.println("\n-=============================-");
                    System.out.println("    ** User Informations **  \n");
                    System.out.println("  - ID         : "+custID);
                    System.out.println("\n  - First Name : "+custFirstName);
                    System.out.println("\n  - Last Name  : "+custLastName);
                    System.out.println("\n  - Balance    : $"+balance);


                    break;
                case 8:
                    break;
                default : // invalid option entered by user
                    System.out.println(" Please enter a Valid Option (between 1 and 5)");

            }

        } while( option != 8);
        System.out.println("\n - Thank You For Banking With Us -\n");
        System.out.println("-=======================-\n");



    }


}
