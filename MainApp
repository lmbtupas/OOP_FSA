import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.LocalDate;
import java.time.Period;

public class MainApp {

    static Boolean checkEmail(String e){ //check email
        Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher v = p.matcher(e);

        return v.find();
    }

    static Boolean checkWeb(String w){ //check website
        Pattern p = Pattern.compile("^(?:[a-zA-Z0-9]{2,4}\\.)*[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,4}(?:\\.[a-zA-Z0-9]{2,4})*$");
        Matcher v = p.matcher(w);

        return v.find();
    }

    static Boolean checkN(String n){ //chekc number
        Pattern p = Pattern.compile("[\\d]{9}");
        Matcher v = p.matcher(n);
        if(n.length()==9 && v.find()){
            return true;
        }
        return false;
    }

    static Boolean checkPass(String pass){ //check password
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

    static int convertMonth(String m){ //convert month to number
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

    static int age(int m, int d, int y){ //get age
        
        try{
            LocalDate bDay = LocalDate.of(y,m,d);
            LocalDate now = LocalDate.now();
            return Period.between(bDay,now).getYears();
        } catch(Exception e){
            return 0; 
        }
    }


    
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String fn,mi,ln,mon,g,add,cn,e,p,w, h="",h2="their ",h3="them ";
        int d,y,a,ppl;
        float as;

        System.out.print("Eneter your first name: ");
        fn = in.next() +" ";
        System.out.print("Eneter your middle initial: ");
        mi = in.next() +" ";
        System.out.print("Eneter your last name: ");
        ln = in.next() +" ";
        System.out.print("Eneter your Bithdate: ");
        in.useDelimiter("\\s*,\\s*|\\s+");
        mon = in.next();
        d = in.nextInt();
        y = in.nextInt();
        a=age(convertMonth(mon),d,y);
        while(a<=0){ //chech if date is valid
            System.out.print("Invalid date, please re-enter: ");
            mon = in.next();
            d = in.nextInt();
            y = in.nextInt();
            a=age(convertMonth(mon),d,y);}
        in.reset();
        System.out.print("Eneter the number of people in your household: ");
        ppl = in.nextInt();
        in.nextLine();
        System.out.print("Eneter your annual salary: ");
        as = Float.valueOf(in.nextLine().replaceAll(",",""));
        System.out.print("Eneter your gender: ");
        g = in.next();
        System.out.print("Eneter your address: ");
        add = in.next();
        System.out.print("Eneter your contact number: ");
        cn = in.next();
        while(!checkN(cn)){
            System.out.print("Invalid number, please re-enter: ");
            cn = in.next();}
        System.out.print("Eneter your email: ");
        e = in.next();
        while(!checkEmail(e)){
            System.out.print("Invalid email, please re-enter: ");
            e = in.next();}
        System.out.print("Eneter your password: ");
        p = in.next();
        while(!checkPass(p)){
            System.out.print("Invalid password, please re-enter: ");
            p = in.next();}
        System.out.print("Eneter your website: ");
        w = in.next();
        while(!checkWeb(w)){
            System.out.print("Invalid website URL, please re-enter: ");
            w = in.next();}

            switch(g.toLowerCase()){
                case "male":
                h="Mr. ";
                h2 ="his ";
                h3 ="him ";
                break;
                case "female":
                h="Ms. ";
                h2 ="her ";
                h3 =h2;
                break;
            }
        in.close();
        System.out.print("\nWelcome, "+h+fn+mi+ln+"to our system. ");
        System.out.print("Your birthdate is "+mon+" "+d +", "+y+", and you are "+a+ " years old, ");
        System.out.print("your gender is "+g+" and you reside in " + add);
        System.out.print(". The total number of people in your household is "+ppl);
        System.out.print(String.format(" and your annual salary is Php %,.2f",as)); 
        System.out.print(". \nFor inquiries of "+h2+"IT services, please contact "+h3);
        System.out.print("at "+cn+" or send an email to "+e+ ". You can also check ");
        System.out.println(h2+"website at "+e+".");
        System.out.println("User Account: "+e);
        System.out.println("Password: "+p);

    }

}
