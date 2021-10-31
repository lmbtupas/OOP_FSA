import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Form {
    
    String formsList[][] = new String[5][15]; // the 2d array that will list of forms and thei infos

//VALIDATION CHECKERS ==========================================================================================

    private Boolean checkEmail(String e){ //check email **************
        Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher v = p.matcher(e);

        return v.find();
    }

    private Boolean checkWeb(String w){ //check website **************
        Pattern p = Pattern.compile("^(?:[a-zA-Z0-9]{2,4}\\.)*[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,4}(?:\\.[a-zA-Z0-9]{2,4})*$");
        Matcher v = p.matcher(w);

        return v.find();
    }

    private Boolean checkN(String n){ //chekc number **************
        Pattern p = Pattern.compile("[\\d]{9}");
        Matcher v = p.matcher(n);
        if(n.length()==9 && v.find()){
            return true;
        }
        return false;
    }

    private Boolean checkPass(String pass){ //check password **************
        Pattern p = Pattern.compile("[\\d]+");
        Pattern p2 = Pattern.compile("[A-Z]+");
        Pattern p3 = Pattern.compile("[\\p{Punct}]+");

        Matcher v = p.matcher(pass);
        Matcher v2 = p2.matcher(pass);
        Matcher v3 = p3.matcher(pass);

        if(pass.length()>=8 && v.find()&& v2.find()&& v3.find()){
            return true;
        }
        return false;
    }

    private int convertMonth(String m){ //convert month to number **************
        switch(m.toLowerCase()){
            case "january":
            return 1;
            case "febuary":
            return 2;
            case "march":
            return 3;
            case "april":
            return 4;
            case "may":
            return 5;
            case "june":
            return 6;
            case "july":
            return 7;
            case "august":
            return 8;
            case "september":
            return 9;
            case "october":
            return 10;
            case "november":
            return 11;
            case "december":
            return 12;
            default:
            return 0;
        }
    }

    private int age(int m, int d, int y){ //get age **************
        
        try{
            LocalDate bDay = LocalDate.of(y,m,d);
            LocalDate now = LocalDate.now();
            return Period.between(bDay,now).getYears();
        } catch(Exception e){
            return 0; 
        }
    }

//FORM CREATOR ====================================================================================================

    //create a form
    public void createForm(){
        //the variables in a form
        String fn, mi,ln, mon, g, add, cn, e, p, w, h = "", h2 = "their ", h3 = "them ";
        int d, y, a, ppl;
        float as;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        fn = in.next() +" ";

        System.out.print("Enter your middle initial: ");
        mi = in.next() +" ";

        System.out.print("Enter your last name: ");
        ln = in.next() +" ";

        System.out.print("Enter your Bithdate: ");
        in.useDelimiter("\\s*,\\s*|\\s+");

        mon = in.next();
        d = in.nextInt();
        y = in.nextInt();
        a=age(convertMonth(mon),d,y);

        while(a<=0){ //chech if valid date
            System.out.print("Invalid date, please re-enter: ");
            mon = in.next();
            d = in.nextInt();
            y = in.nextInt();
            a=age(convertMonth(mon),d,y);}
            
        in.reset();
        System.out.print("Enter the number of people in your household: ");
        ppl = in.nextInt();
        in.nextLine();

        System.out.print("Enter your annual salary: ");
        as = Float.valueOf(in.nextLine().replaceAll(",",""));

        System.out.print("Enter your gender: ");
        g = in.next();

        System.out.print("Enter your address: ");
        add = in.next();

        System.out.print("Enter your contact number: ");
        cn = in.next();

        while(!checkN(cn)){ //check if valid number
            System.out.print("Invalid number, please re-enter: ");
            cn = in.next();}

        System.out.print("Enter your email: ");
        e = in.next();

        while(!checkEmail(e)){ //check if valid email
            System.out.print("Invalid email, please re-enter: ");
            e = in.next();}

        System.out.print("Enter your password: ");
        p = in.next();

        while(!checkPass(p)){ //check if valid password
            System.out.print("Invalid password, please re-enter: ");
            p = in.next();}

        System.out.print("Enter your website: ");
        w = in.next();

        while(!checkWeb(w)){ //check if valid website url
            System.out.print("Invalid website URL, please re-enter: ");
            w = in.next();}

            switch(g.toLowerCase()){
                case "male":
                h = "Mr. ";
                h2 ="his ";
                h3 ="him ";
                break;

                case "female":
                h = "Ms. ";
                h2 = "her ";
                h3 = h2;
                break;
            }
        in.close();
        System.out.print("\nWelcome, " + h + fn + mi + ln + "to our system. ");
        System.out.print("Your birthdate is " + mon + " " + d + ", " + y + ", and you are " + a + " years old, ");
        System.out.print("your gender is " + g + " and you reside in " + add);
        System.out.print(". The total number of people in your household is " + ppl);
        System.out.print(String.format(" and your annual salary is Php %,.2f",as)); 
        System.out.print(". \nFor inquiries of " + h2 + "IT services, please contact " + h3);
        System.out.print("at " + cn + " or send an email to " + e + ". You can also check ");
        System.out.println(h2 + "website at " + e + ".");
        System.out.println("User Account: " + e);
        System.out.println("Password: " + p);
        
        int formNum=0;
        for(int i=0;i<formsList.length;i++){
            if(formsList[i][0].equals("null")){
                formNum=i;
            }
        }

        formsList [formNum][0] = fn;
        formsList [formNum][1] = mi;
        formsList [formNum][2] = ln;
        formsList [formNum][3] = mon;
        formsList [formNum][4] = String.valueOf(d);
        formsList [formNum][5] = String.valueOf(y);
        formsList [formNum][6] = String.valueOf(a);
        formsList [formNum][7] = g;
        formsList [formNum][8] = add;
        formsList [formNum][9] = String.valueOf(ppl);
        formsList [formNum][10] = String.valueOf(as);
        formsList [formNum][11] = String.valueOf(cn);
        formsList [formNum][13] = e; 
        formsList [formNum][14] = p;

        for(String[] r:formsList){ //prints forms array
            for(String c:r){
                System.out.print(c+" ");
            }
            System.out.println();
        }

    }

    public void saveToFile() throws IOException{ //save the array of forms to a text file
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < formsList.length; i++){ //for each row
            for(int j = 0; j < formsList[i].length; j++){ //for each column
                builder.append(formsList[i][j]+""); //append to the output string
                if(j < formsList[i].length - 1) //if this is not the last row element
                    builder.append(","); //then add comma (if you don't like commas you can use spaces)
            }
            builder.append("\n");//append new line at the end of the row
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("saveFile.txt"));
        writer.write(builder.toString());//save the string representation of the board
        writer.close();
    }

    public void readFileToArr() throws IOException{ //read the text file and transfer infos to array
        BufferedReader reader = new BufferedReader(new FileReader("saveFile.txt"));
        String line = "";
        int row = 0;
        while((line = reader.readLine()) != null){
            String[] cols = line.split(","); //note that if you have used space as separator you have to split on " "
            int col = 0;
            for(String  c : cols){
                if(c.equals("null")){
                    formsList[row][col] = null;
                }else{
                    formsList[row][col] = c;
                }
                col++;}
            row++;}
        reader.close();
    }

    //display a form in a text file
    public void displayForm() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        //Menu for picking saved forms
        System.out.println("==================");
        System.out.println("Please choose which form you want to be displayed.");
        for(int i=0;i<formsList.length;i++){
            if(formsList[i][0]!=null){ //checks if there is a form
                System.out.println("Form "+String.valueOf(i+1)); //show form num if form exists
            }
        }
        System.out.println("5 - Exit");
        System.out.println("==================");

        while (choice != 5) { //Picks which user has a saved file

            choice = sc.nextInt();
            if (choice == 1) {
                break;
            } 

            else if (choice == 2) {
                break;
            } 

            else if (choice == 3) {
                break;
            }

            else if (choice == 4) {
                break;
            }

            else if (choice == 5) { //goes back to main menu
                break;
            }

        }
        sc.nextLine();
        sc.close();
        System.out.println("exit display func");
    }

    //update a form
    public void updateForm(){

    }
    
}
