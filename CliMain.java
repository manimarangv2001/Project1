package com.Hexaware.CMS.Cli;

import java.util.Scanner;


import com.Hexaware.CMS.Factory.VendorFactory;
import com.Hexaware.CMS.Factory.CustomerFactory;
import com.Hexaware.CMS.Factory.LoginFactory;
import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Login;
import com.Hexaware.CMS.Model.Vendor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CliMain {
    
    static Scanner sc=new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/**
 * main method  used to display the option we had in the application.
 */  
   
        
        private void mainMenu(){
            System.out.println( "------------------------------" );    
        System.out.println( "  cms  " );
        System.out.println( "------------------------------" );      
        System.out.println("1. User Login");
        System.out.println("2. Registering new user");
        System.out.println("3.Change Password");
        System.out.println("4. Vendor Login");
        System.out.println("5. Logging Out");
        System.out.println("Enter your choice :");
        int ch=sc.nextInt();
        subMenu(ch);
        }
        
        void subMenu(int ch){
            
            switch(ch){
            case 1:
                System.out.println("Please enter your details");
                System.out.println("UserName: ");
                String user = sc.next();
                System.out.println("Password: ");
                String pass = sc.next();
                Login l = LoginFactory.getUserByUserName(user);
                if(!l.equals(null)){
                    if(pass.equals(l.getpassword())){
                CustomerUtil cu = new CustomerUtil();
                Customer c = CustomerFactory.retrieveByEmail(user);
                cu.customerMenu(c);
                } 
             else {
                System.out.println("Wrong username and password");
                }
            }
                break;
            case 2:
                   registerUser();
                break;
            case 3:
                System.out.println("Please Login to Change your Passwords");
                break;
            
            case 4:
                System.out.println("Please enter your details");
                System.out.print("UserName: ");
                String ven = sc.next();
                System.out.print("Password: ");
                String code = sc.next();

                Login l2 = LoginFactory.getUserByUserName(ven);
                if (!l2.equals(null)) {
                    if(code.equals(l2.getpassword())) {
                    VendorUtil v = new VendorUtil();
                    Vendor vc = VendorFactory.retrieveByEmail(ven);
                    v.vendorMenu(vc);
                } else {
                    System.out.println("Wrong username or password");
                    }
                } else{
                    System.out.println("Please Contact the Administrator");
                }
                break;

                
            
            case 5:
                sc.close();
                Runtime.getRuntime().exit(0);
                break;
            default:
            System.out.println("Invalid Choice. Please choose a valid option.");
            break;
        }
        mainMenu();
        }

        /**
        This is  a method for registering the user
         */
        void registerUser(){
            String cust_Address = "";
            System.out.println("Enter your First Name: ");
                String cust_FName = sc.next();
            System.out.println("Enter your Last Name: ");
                String cust_LName = sc.next();
            System.out.println("Enter your Address: ");
                try{
                   cust_Address = br.readLine();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            System.out.println("Enter your Phone no: ");
                String cust_PhoneNo = sc.next();
            System.out.println("Enter your Email: ");
                String cust_Email = sc.next();
            System.out.println("Enter your Password: ");
                String custPass = sc.next();
            System.out.println("Confirm your Password: ");
                String confirm = sc.next();
            
            if(custPass.equals(confirm)){
                Customer c = new Customer();
                String str = c.registerCustomer(cust_FName, cust_LName, cust_Address , cust_Email , cust_PhoneNo, custPass);
                System.out.println(str);
                System.out.println("Please login to Continue");
            } else {
                System.out.println("Password wrong. Please Try Again");

            }              
            mainMenu();
            
        }
        public static void main(String[] args) {
    CliMain obj = new CliMain();
    obj.mainMenu();
        }
}

    

      
        
    
//     /**
//      * this method  is to place food order.
//      */
//         public static void placeOrder(){
//         System.out.println("Enter the Food id");
//         int fid=sc.nextInt();
//         System.out.println("Enter the Food Name");
//         String fname=sc.next();
//         System.out.println("Enter the Food Price");
//         int fprice=sc.nextInt();
//         System.out.println("Enter the Food Quantity");
//         int  fquan=sc.nextInt();

//         //Add other attributes to complete the functionality
//         int r= OrderFactory.OrderFood(fid,fname,fprice,fquan);
//         System.out.println(r+"   is inserted.....");
//         }
// /**
//  * this method is to fetch Menu list.
//  */
//         public static void menuList(){
//         Menu m[]=OrderFactory.fetchMenu();
//         System.out.println("Food Id"+"    "+"Food Name"+"    "+"Food Price"); 
//         for(int i=0;i<m.length;i++){
//               System.out.println(m[i].getFoodId()+"       "+m[i].getFoodName()+"       "+m[i].getFoodPrice());
//            }
//     }
/**
 * this method is to acceptRejectOrder.
 */
// public static String acceptRejectOrder(){}

 /**
 * this method is for customerProfile.
 */
// public static Customer customerProfile(){}

/**
 * this method is for VendorProfile.
 */
// public static Vendor vendorProfile(){}

/**
 * this method is for VendorOderHistory.
 */
// public static Vendor[] VendorOderHistory(){}

/**
 * this method is for CustomerOrderHistory.
 */
// public static Customer[] CustomerOrderHistory(){}



