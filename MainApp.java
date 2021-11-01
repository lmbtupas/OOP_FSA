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
            System.out.println("==================");

            if(number == 1){
                if(pplForm.checkIfArrayFull()){
                    System.out.println("Maximum number of forms reached. Cannot create form.");
                }else{
                    pplForm.createForm(); //create form
                }
                
            }
            else if (number == 2){
                if(pplForm.checkIfArrayEmpty()){
                    System.out.println("No forms to display.");
                }else{
                    pplForm.displayForm(); //display form
                }                
            }
            else if (number == 3){
                if(pplForm.checkIfArrayEmpty()){
                    System.out.println("No forms to update.");
                }else{
                    pplForm.updateForm(); //update form
                }                
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
