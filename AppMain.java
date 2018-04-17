package projectpackage;

import java.sql.Connection;

import java.sql.*;
import java.io.*;
import java.util.*;

public class AppMain {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
		if (args.length == 0){
			System.out.println("Usage: java RideShare propertiesFile");
			System.exit(0);
		}
		SimpleDataSource.init(args[0]);
		
		try(Connection conn = SimpleDataSource.getConnection()){
			
			Statement stat = conn.createStatement();
			
			String fileName = "Driver.txt";
			File inputFile = new File(fileName);
			Scanner in = new Scanner(inputFile);
			
			ArrayList<String> phoneNum = new ArrayList<String>();
			ArrayList<String> driverName = new ArrayList<String>();
			ArrayList<String> carMake = new ArrayList<String>();
			ArrayList<String> carModel = new ArrayList<String>();
			ArrayList<String> carColor = new ArrayList<String>();
			ArrayList<String> licensePlate = new ArrayList<String>();
			ArrayList<String> driversLicense = new ArrayList<String>();
			ArrayList<String> carLevel = new ArrayList<String>();
			ArrayList<String> paycheck = new ArrayList<String>();
			//initialize array lists that will store the information from the document
			
			while(in.hasNext()){ //stores the values from the document as variables and insert them to their respective array lists
				String phone = in.next();
				String driver = in.next();
				String make = in.next();
				String model = in.next();
				String color = in.next();
				String plateNum = in.next();
				String licenseNum = in.next();
				String level = in.next();
				String pay = in.next();
				
				phoneNum.add(phone);
				driverName.add(driver);
				carMake.add(make);
				carModel.add(model);
				carColor.add(color);
				licensePlate.add(plateNum);
				driversLicense.add(licenseNum);
				carLevel.add(level);
				paycheck.add(pay);
				//stores the values from the document as variables and insert them to their respective array lists
			}
			
			in.close();
			
			stat.execute("CREATE TABLE AllDrivers (Phone CHAR(12), Name VARCHAR(20), Make VARCHAR(20), Model VARCHAR(20), Color VARCHAR(10), License Plate CHAR(6), Drivers License Number (9), Ride Level CHAR(1), Pay Rate VARCHAR(10)");
			//create table for the driver information
			for(int i=0; i<carMake.size(); i++){//insert all the values into an SQL database
				stat.execute("INSERT INTO AllDriver VALUES('" + phoneNum.get(i) + "', '" + driverName.get(i) + "', '" + carMake.get(i) + "', '" + carModel.get(i) + "', '" + carColor.get(i) + "', '" + licensePlate + "', '" + driversLicense + "', '" + carLevel.get(i) + "', '" + paycheck.get(i) +")");
			}
			
			stat.execute("CREATE TABLE AllRiders (Phone CHAR(12), Name VARCHAR(20), Credit Card CHAR(19)");
			
			boolean on = true;
			while (on==true){
				Scanner user = new Scanner(System.in);
				String hold = "";
				System.out.println("Please select if you are a manager, employee, or customer:");
				System.out.println("(M) Manager");
				System.out.println("(E) Employee");
				System.out.println("(C) Customer");
				System.out.println("(Q) Quit");
				hold = user.next();
				
				if(hold.equalsIgnoreCase("Q")){
					on = false;
					stat.execute("DROP TABLE AllDrivers");
					stat.execute("DROP TABLE AllRiders");
				}
				
				if(hold.equalsIgnoreCase("M")){
					boolean loop = true;
					while(loop == true){
						String pass = "1234";
						String attempt = "";
						Scanner mgmt = new Scanner(System.in);
						System.out.println("Please enter the management password: ");
						System.out.println("If you want to go back to the menu, enter: (S)");
						attempt = mgmt.next();
					
						if(attempt.equals(pass)){
							Scanner s1 = new Scanner(System.in);
							String s2 = "";
							System.out.println("What function would you like to perform?");
							System.out.println("(1) ");
							System.out.println("(2) ");
							System.out.println("(3) ");
							System.out.println("(4) ");
							System.out.println("(5) ");
							
						}
					
						else if(attempt.equalsIgnoreCase("S")){
							loop = false;
						}
					
						else{
							System.out.println("Sorry, that is incorrect.");
						}
					}
					
				}
				
				if(hold.equalsIgnoreCase("E")){
					
				}
				
				if(hold.equalsIgnoreCase("C")){
					
				}
			}
		}
	}
}