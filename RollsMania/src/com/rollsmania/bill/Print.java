package com.rollsmania.bill;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Print {
	int cheesyBarbequeFriesQty;
	int doubleEggOmletteRollQty;
	int singleEggOmletteRollQty;
	int chickenRollQty;
	int cokeQty;
	String customerName;
	long mobileNo;
	String Address;
	String customerInstructions;
	
	LocalDateTime now = LocalDateTime.now();  
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d uuuu hh:mm a");
	   
	
	public void getProds() {
		if(cheesyBarbequeFriesQty>=1) {
			System.out.printf("%-7s%-29s%-6s%-6s\n",cheesyBarbequeFriesQty,"Cheesy BBQ Fries",Order.cheesyBarbequeFries,Order.cheesyBarbequeFries*cheesyBarbequeFriesQty);
			System.out.println("------------------------------------------------");

		}
		
		if(doubleEggOmletteRollQty>=1) {
			System.out.printf("%-7s%-29s%-6s%-6s\n",doubleEggOmletteRollQty,"Double Egg Omlet Roll",Order.doubleEggOmletteRoll,Order.doubleEggOmletteRoll*doubleEggOmletteRollQty);
			System.out.println("------------------------------------------------");

		}
		if(singleEggOmletteRollQty>=1) {
			System.out.printf("%-7s%-29s%-6s%-6s\n",singleEggOmletteRollQty,"Single Egg Omlet Roll",Order.singleEggOmletteRoll,Order.singleEggOmletteRoll*singleEggOmletteRollQty);
			System.out.println("------------------------------------------------");

		}
		if(chickenRollQty>=1) {
			System.out.printf("%-7s%-29s%-6s%-6s\n",chickenRollQty,"Chicken Roll",Order.chickenRoll,Order.chickenRoll*chickenRollQty);
			System.out.println("------------------------------------------------");

		}
		
		if(cokeQty>=1) {
			System.out.printf("%-7s%-29s%-6s%-6s\n",cokeQty,"Coke",Order.coke,Order.coke*cokeQty);
			System.out.println("------------------------------------------------");

		}
	}

	
	public void restInfo() {
		System.out.println("       		   Rolls Mania  				    ");
		System.out.println("         Let The Good Time Roll...!!!           ");
		System.out.println("  Sr No 80/39,Behind Oxygen Valley Society,Opp  ");
		System.out.println("   Annasaheb Nagar Bazar Samiti,Pune Solapur    ");
		System.out.println("           Road,Manji Bk,Pune-412307            ");
		System.out.println("             8983030098,8180094920              ");
		System.out.println("   rmmanjribk@gmail.com,rollsmania@ymail.com    ");
		System.out.println("                  TAX INVOICE   			    ");
		System.out.println("              SAC Number:996331				    ");
		System.out.println("          GST Number:27APPPA6323L3ZM			");
		System.out.println("------------------------------------------------");
	
		
		System.out.println("DELIVERY                           Order Number:"+'\n'+"                                   PUNEMANJRI-19");
		//System.out.println(); 
		System.out.println(dtf.format(now)+'\n'+"Cashier:Manjari"+'\n'+"Invoice No:PUNEMANJIRI042840"+'\n'+"Generated At:"+dtf.format(now)+'\n'+dtf.format(now.plusMinutes(38)));
		System.out.println("Zomato                                 Order Id:"+'\n'+"                                      4519279926");
		System.out.println("------------------------------------------------");
		System.out.printf("%-35s%-13s\n",customerName,mobileNo);
		System.out.printf("%-48s\n",Address);
		System.out.println("------------------------------------------------");
		System.out.println("Qty    Name                         Rate  Amt   ");
		System.out.println("------------------------------------------------");

}

	
	
}
