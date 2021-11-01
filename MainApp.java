import java.util.*;


public class MainApp {

    static void showMenu(){ //idk if put in new class....
        System.out.println("==================");
        System.out.println("Input a number to:");
        System.out.println("1 - Create form");
        System.out.println("2 - Display form");
        System.out.println("3 - Update form");
        System.out.println("4 - Exit program");
        System.out.println("==================");
    }
    
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int number = 0;
        Form pplForm = new Form(); //create Form object

        try{
            pplForm.readFileToArr();
            System.out.println("read");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("No file");
        }

        while(number !=4){ //as long as user does not exit program keep goin
            
            showMenu();
            number = in.nextInt(); 
            
            
             //get number input of customer
            System.out.println("tsk==================");

            if(number == 1){
                pplForm.createForm(); //create form
            }
            else if (number == 2){
                pplForm.displayForm(); //display form
                System.out.println("hmmm");
            }
            else if (number == 3){
                pplForm.updateForm(); //update form
                System.out.println("hm");
            }
            else if (number == 4){
                System.out.println("Thank for using this program! Goodbye!");
                break; //exit program
            }
        }
        in.close();
        
        try{
            pplForm.saveToFile();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error saving file");
        }


    }

}
