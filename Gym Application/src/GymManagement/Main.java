package GymManagement;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	System.out.println("\u001B[30m" + "Hello World in red!");
    	// Declaring ANSI_RESET so that we can reset the color 
        final String ANSI_RESET = "\u001B[0m"; 
        // Declaring the background color 
        final String ANSI_RED_BACKGROUND  = "\u001B[41m"; 
        // test part
    	//String testing = UUID.randomUUID().toString();
    	//System.out.println(testing);
        Gym gym = new Gym();
        Scanner input  = new Scanner(System.in);

        System.out.println("Hello, Welcome to Gym Service!! \n Press the service you want:");
        System.out.println("1.Member \n2.Trainer");
        int selection1 = input.nextInt();
        Boolean flag = true;
        
        while(flag == true) {
        if(selection1 == 1){
            System.out.println("1.New Member \n2.Existing Member(not yet completed) \n3)exit");
            int selection2 = input.nextInt();
            if(selection2 == 1){
                System.out.println("Enter PhoneNumber:");
                BigInteger phonenumber = input.nextBigInteger();
                System.out.println("Enter name:");
                String name = input.next();
                System.out.println("Enter age:");
                int age = input.nextInt();
                System.out.println("Plan: 1) month:Rs 1000,2) 3 month:Rs 2500,3) 6 months: Rs 5500");
                int plan = input.nextInt();
                if(!(plan == 1 ||plan == 2 || plan == 3)) {
                	System.out.println("Enter correct choice!");
                	continue;
                }
                System.out.println("Membership Type:1) Strength training(+1000) 2) Cardio(+500)");
                int memberShipType = input.nextInt();
                gym.addMember(new Member(phonenumber, name, age,memberShipType,plan));
                
            }else if(selection2 == 2){
            	System.out.println("Members:");
                for (Member member : gym.getMembers()) {
                    System.out.println("Name:    " + member.getName() + ", Age: " + member.getAge() + ", Membership Type: " + member.getMembershipType()+ ", Price: " +member.price());
                }
            }else {
            	break;
            }
           }else {
        	System.out.println("1.New Trainer \n2.Existing Trainer(not yet completed)");
            int selection2 = input.nextInt();
            if(selection2 == 1){
       
                System.out.println("Enter name:");
                String name = input.next();
                System.out.println("Enter speciality:");
                String speciality = input.next();
                System.out.println("Experience");
                int experience = input.nextInt();
                
                //gym.addTrainer(new Trainer( name, speciality, experience));
             }else {
            	 
             }
        }
        System.out.println("Add another member or exit (yes or no)");
        String check = input.next();
        if(check == "no") {
        	break;
        }else {
        	continue;
        }
        }

        
        System.out.println("Members:");
        for (Member member : gym.getMembers()) {
            System.out.println("Name:    " + member.getName() + ", Age: " + member.getAge() + ", Membership Type: " + member.getMembershipType()+ ANSI_RED_BACKGROUND + ", Price: " +member.price()+ANSI_RESET);
        }
        
        System.out.println("Trainers:");
        for (Trainer member : gym.getTrainers()) {
            System.out.println("Name:    " + member.getName() + ", Age: " + member.getSpecialty() + ", Membership Type: " + member.getExperience());
        }
        input.close();
    }
}