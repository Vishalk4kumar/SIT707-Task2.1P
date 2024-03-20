package sit707_week2;

/**
 * Hello world!
 * @author Ahsan Habib
 */
public class Main 
{
    public static void main( String[] args )
    {
        // Call the officeworks_registration_page function
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        
        // Call the figma_signup function
        SeleniumOperations.figma_signup("https://www.figma.com/signup");
    }
}
