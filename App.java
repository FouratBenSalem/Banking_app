public class App
{
    public static void main(String[] args) 
    {
        System.out.println("\n  **  Welcome To The New Banking App  **\n");
        Account fourat = new Account("Fourat", "Ben Salem", "A000001");
        

        Account islem = new Account("Islem ","Bargui", "B000001");

        islem.showMenu();
    }
}