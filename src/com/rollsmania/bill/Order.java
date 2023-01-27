package com.rollsmania.bill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Order {
	
	//Variables
	final static int cheesyBarbequeFries = 159;
	final static int doubleEggOmletteRoll =  89;
	final static int singleEggOmletteRoll = 69;
	final static int chickenRoll = 189;
	final static int coke = 59;
	final static float gstPercent =  2.5f;
	final static float pkgCharges = 13.14f;
	
	int input;
	int quantity;
	float subTotal;
	float sum;
	float gst;
	String reorder;
	float promototal;
	float netTotal;
	float charges  ;
	float promo;
	
	
	
	Scanner sc = new Scanner(System.in);
	Print print = new Print();
	BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
	
	//Food Menu
	public void displayMenu() {
		
		System.out.println("**********Welcome to Rolls Mania*************");
		System.out.println("=============================================");
		System.out.println("    1.Cheesy Barbeque Fries         Rs. 159/-");
		System.out.println("    2.Double Egg Omlette Roll       Rs.  89/-");
		System.out.println("    3.Single Egg Omlette Roll       Rs.  69/-");
		System.out.println("    4.Chicken Roll                  Rs. 189/-");
		System.out.println("    5.Coke                          Rs.  59/-");
		System.out.println("=============================================");
		System.out.println("========Let the Good Times Roll...!!!========");

	}
	
	//backend
	public void getOrder() throws IOException {
	
		System.out.println("Enter Desired Choice code");
		input = sc.nextInt();
		switch(input) {
		case 1: //Cheesy Barbeque Fries
			System.out.println("You have ordered Cheesy Barbeque Fries");
			System.out.println();
			System.out.println("Enter Desired Quantity");
			quantity = sc.nextInt();
			subTotal = subTotal + quantity * cheesyBarbequeFries;
			print.cheesyBarbequeFriesQty=quantity;
			break;
			
		case 2: //Double Egg Omlette Roll
			System.out.println("You have ordered Double Egg Omlette Roll");
			System.out.println();
			System.out.println("Enter Desired Quantity");
			quantity = sc.nextInt();
			subTotal = subTotal + quantity * doubleEggOmletteRoll;
			print.doubleEggOmletteRollQty=quantity;
			break;
		
		case 3: //Single Egg Omlette Roll
			System.out.println("You have ordered Single Egg Omlette Roll");
			System.out.println();
			System.out.println("Enter Desired Quantity");
			quantity = sc.nextInt();
			subTotal = subTotal + quantity * singleEggOmletteRoll;
			print.singleEggOmletteRollQty=quantity;
			break;
		
		case 4: //Chicken Roll
			System.out.println("You have ordered Chicken Roll");
			System.out.println();
			System.out.println("Enter Desired Quantity");
			quantity = sc.nextInt();
			subTotal = subTotal + quantity * chickenRoll;
			print.chickenRollQty=quantity;
			break;
			
		case 5: //Coke
			System.out.println("You have ordered Coke");
			System.out.println();
			System.out.println("Enter Desired Quantity");
			quantity = sc.nextInt();
			subTotal = subTotal + quantity * coke;
			print.cokeQty=quantity;
			break;
			
			
		default:
			break;
		
		}
		System.out.println();
		System.out.println("Do you wish to  anything else (Y/N)");
		reorder = sc.next();
		if(reorder.equalsIgnoreCase("Y")) { 
			getOrder();
		}
		else if(reorder.equalsIgnoreCase("N")){
			checkPromo();
			addGST();
			finalTotal();
			getCustomerInfo();
			generateInvoice();
			
			System.exit(1);
		}
		else {
			System.out.println("Invalid Input");
		}
		}
		


	
	//Promo code
	private void checkPromo() {
		System.out.println("Do you have Promo Code(Y/N)");
		String check = sc.next();
		if(check.equalsIgnoreCase("Y")) {
			System.out.println("Enter Promo Code");
			String promocode= sc.next();
			if(promocode.equalsIgnoreCase("Yummy")) {
				System.out.println("Promo Code Applied Successfully");
				promo = Math.min((10*(subTotal/100)), 80);
				
				promototal= subTotal-promo;
			}
			else {
				System.out.println("NOT VALID CODE");
			}
			}

	}
	
	
	//Adding GST to get gstTotal
	public void addGST() {
		sum=subTotal-promo+pkgCharges;
		gst = ((gstPercent*sum)/100);
		
	}
	
	//Final Total
	public void finalTotal() {
		netTotal = subTotal-promo+pkgCharges+gst*2-20;
	}
	
	
	//invoice
	private void generateInvoice() {
		
		System.out.println();
		//System.out.println("********Thank you *********");
		print.restInfo();
		print.getProds();
		printTotal();
	}
	
	
	//Print Calculattions
	public void printTotal() {
		System.out.printf("%-42s%-6.2f\n","Sub-Total",subTotal);
		System.out.println("------------------------------------------------");

		if (promo>=1) {
			System.out.printf("%-42s-%-6.2f\n","YUMMY",promo);
			System.out.println("------------------------------------------------");
		}
		System.out.println("Taxes/Charges               Appl.Amt      Amt   ");
		System.out.printf("%-42s%-6.2f\n","Restaurant Packaging",pkgCharges);
		System.out.println("Charges                                         ");
		System.out.printf("%-28s%-14.2f%-6.2f\n","CGST@2.5%",sum,gst);
		System.out.printf("%-28s%-14.2f%-6.2f\n","SGST@2.5%",sum,gst);
		System.out.printf("%-42s%-6.2f\n","Total Charges/Taxes",(pkgCharges+2*gst));
		System.out.println("------------------------------------------------");
		System.out.println("Zomato Voucher Code_Fixed_20                 -20");
		System.out.printf("%-42s%-6.2f\n","GRAND TOTAL",netTotal);
		System.out.printf("%-42s%-6.2f\n","NET PAYABLE",netTotal);
		System.out.println("Payment Type                             ONLINE/");
		System.out.println("                                 SOURCE_DISCOUNT");
		System.out.println("Invoice Currency                             INR");
		System.out.println("------------------------------------------------");
		System.out.printf("%-23s%s\n","Customer Instructions: ",print.customerInstructions);

		System.out.println("               FSSAI-21518181000261             ");
		System.out.println("------------------------------------------------");
		System.out.println("|                                              |");
		System.out.println("|     Thnak you.Now Order Online from our      |");
		System.out.println("|    website www.rollsmania.com Disclaimer     |");
		System.out.println("|  You allow us to send promotional messages   |");
		System.out.println("|            after this transection            |");
		System.out.println("|                                              |");
		System.out.println("------------------------------------------------");
















	}

	//Get Customer Information	
	public void getCustomerInfo() throws IOException {
		System.out.println("Please Enter your Name");
		print.customerName = bufferReader.readLine();
		System.out.println("Please Enter your Mobile Number");
		print.mobileNo = sc.nextLong();
		System.out.println("Please Enter Delivery Address");
		print.Address = bufferReader.readLine();
		System.out.println("Any Delivery Instructions?");
		print.customerInstructions=bufferReader.readLine();

		
	}
}
