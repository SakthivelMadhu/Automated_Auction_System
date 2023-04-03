package com.masai.app;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.AdminDAO;
import com.masai.DAO.DisputeDAO;
import com.masai.DAO.UserDAO;
import com.masai.DTO.UserDTO;
import com.masai.Exception.AdministratorException;
import com.masai.Exception.ItemException;
import com.masai.Exception.UserException;



public class Main {
	
	private static AdminDAO admin;
	public static AdminDAO adminProfile;
	public static UserDAO userProfile;
	
	static {
		System.out.println("+----------------------------------------------+");
		System.out.println("|**********************************************|");
		System.out.println("|********Hello Welcome to Auction   ********|");
		System.out.println("|**********************************************|");
		System.out.println("+----------------------------------------------+");
		
	};
	public static void main(String[] args) throws AdministratorException, UserException, ItemException {
		
		System.out.println( "Please press following number:- who are you? ");
		
		System.out.println("1. Are you Administrator..");
		System.out.println("2. Are you user..");
		System.out.println("3. Exit");
		
		
		
		try (Scanner sc = new Scanner(System.in)) {
			int num= sc.nextInt();
			sc.nextLine();

			
			switch(num){
			
				case 1:{
						while(true) {
							System.out.println("Enter username/email: ");
							String username=sc.nextLine();
							
							System.out.println("Enter password : ");
							String password = sc.nextLine();
							
							adminProfile = admin.loginAdministrator(username, password);
							System.out.print("\n Welcome Administrator "+adminProfile.getaFirstName());
							if(adminProfile.getaLastName()!=null) {
								System.out.println(" "+adminProfile.getaLastName());
							}
							else {
								
								System.out.println();
							}
							break;
						}
						adminDashboard();
					}
				break;
			
					
				case 2:
					{
						System.out.println("Hey User.." + "\n");
						System.out.println("1. New user? register..");
						System.out.println("2. Login..");
						System.out.println("3. Exit");
						
						int option= sc.nextInt();
						sc.nextLine();
						switch(option) {
							case 1:{
								UserDTO userReg= new UserDTO(option, null, null, null);
								System.out.println("\n Enter your First Name: ");
								userReg.setbFirstName(sc.nextLine());
								
								System.out.println("\n Enter your Last Name: ");
								userReg.setbLastName(sc.nextLine());
								
								System.out.println("\n Enter your email id: ");
								userReg.setBemail(sc.nextLine());
								
								System.out.println("\n Enter your password: ");
								userReg.setBpassword(sc.nextLine());
								
								System.out.println("\n Enter your mobile number: ");
								userReg.setBmobile(sc.nextLine());
								
								System.out.println("\n Enter your Date of dirth (in yyyy-mm-dd formate): ");
								userReg.setBdod(Date.valueOf(sc.nextLine()));
								
								String mesg= userReg.registerBuyer(userReg);
								
								System.out.println(mesg+"\n");
								loginUser();
							}
							break;
							case 2:{
								loginUser();
							}
							break;
							case 3:{
								System.out.println("Thanking you for visiting...");
								return;
							}
							default: {
								System.out.println("Invalid number, Thanking you! visiting again...");							
								break;
							}
						}
					}
					break;
					
				case 3:
					{
						System.out.println("Thanking you for visiting...");
						return;
					}
					
				default:
					System.out.println("Invalid number, try again ...");
					main(args);
					break;
			}
		}
	}
	public static UserDAO loginUser() throws UserException{
		System.out.println("Hey, user! Welcome Login penal...");
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\n 1. Enter your login detail..");
			System.out.println("2. forget username..");
			System.out.println("3. forget password..");
			System.out.println("4. Exit");
			int option2 = sc.nextInt();
			sc.nextLine();
			
			UserDAO user = null;
			switch(option2) {
				case 1:{
					System.out.println("\n Enter your emailid/username...");
					System.out.println("\n Enter your password...");
					try {
						userProfile = Main.loginUser();
						System.out.print("\n Welcome user "+userProfile.getbFirstName());
						if(userProfile.getbLastName() !=null) {
							System.out.println(" "+userProfile.getbLastName());
						}
						else {
							
							System.out.println();
						}
						UserDashboard();
					} catch (UserException e) {
						System.out.println(e.getMessage());
						System.out.println("Do you want exit: press 4, else press any key...");
						String numb= sc.nextLine();
						if(numb.equals("4")) {
							System.out.println("Thanking you for visiting...");
							return user;
						}
						else {
							loginUser();
						}
					}
				}
				break;
				case 2:{
					System.out.println("\n Enter your new emailid/username");
					String username= sc.nextLine();
					
					System.out.println("\n Enter your first name: ");
					String firstname = sc.nextLine();
					
					System.out.println("\n Enter your Date of birth (in yyyymmdd format): ");
					Date dob= Date.valueOf(sc.nextLine());
					
					System.out.println("\n Enter your mobile number: ");
					String mobileNumber = sc.nextLine();
					
					@SuppressWarnings("null")
					String message = user.resetUsernameByuser(firstname, username, dob, mobileNumber);
					System.out.println(message);
					loginUser();
				}
				break;
				case 3:{

					System.out.println("\n Enter your emailid/username");
					String username= sc.nextLine();
					
					System.out.println("\n Enter new password");
					String password = sc.nextLine();
					
					@SuppressWarnings("null")
					String message = user.resetPasswordByuser(username, password);
					System.out.println(message);
					loginUser();
					
				}
				break;
				case 4:{
					System.out.println("Thanking you for visiting...");
					return user;
				}
				
				default: {
					System.out.println("Invalid number, Thanking you! visit again ...");
					loginUser();
				}
				break;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return userProfile;
	}
	
	
	
	
	public static void UserDashboard() {
		
	}
	public static void userProfileSetting(){
		
	}
	
	public static void adminDashboard() throws UserException, ItemException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("1. View the registered buyer list.");
			System.out.println("2. View the registered seller list.");
			System.out.println("3. View the daily dispute report.");
			System.out.println("4. View the daily selling report.");
			System.out.println("5. Solved the dispute report.");
			System.out.println("6. Profile Setting..");
			System.out.println("7. LogOut And Exit");
			
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1 : {
					
					List<UserDAO> list = admin.listOfBuyers();
					System.out.println(" registered buyer list ....");
					list.forEach(l -> {
						System.out.println(" user ID is : ");
						System.out.println(" user first Name is : ");
						System.out.println(" user last Name is : ");
						System.out.println(" user email is : ");
						System.out.println(" user mobile number is : ");
						System.out.println(" user date of birth is : ");
						System.out.println("===========================");
					});
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							adminProfileSetting();
							break;
						}
						case 2 : {
							adminDashboard();
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							break;
						}
					}
					break;
				}
				case 2 : {
					List<UserDAO> list2 = admin.listOfBuyers();
					System.out.println(" registered Seller list ....");
					list2.forEach(l -> {
						System.out.println(" Seller ID is : ");
						System.out.println(" Seller first Name is : ");
						System.out.println(" Seller last Name is : ");
						System.out.println(" Seller email is : ");
						System.out.println(" Seller mobile number is : ");
						System.out.println(" Seller date of birth is : ");
						System.out.println("===========================");
					});
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							adminProfileSetting();
							break;
						}
						case 2 : {
							adminDashboard();
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							break;
						}
					}
				}
				break;
				case 3 : {
					System.out.println("Choose appropriate dispute report..");
					System.out.println("1. Dispute list Seller to Application ..");
					System.out.println("2. Dispute list Buyer to Seller ..");
					System.out.println("3. Back");
					int num3= sc.nextInt();
					switch(num3) {
						case 1 : {
							List<DisputeDAO> list3 = admin.disputeListSellerToApp();
							System.out.println(" Dispute list Seller to Application ....");
							list3.forEach(l -> {
								System.out.println(" Dispute ID is : ");
								
								System.out.println(" Dispute by Seller ID is : ");
								System.out.println(" Category ID is : ");
								System.out.println(" Dispute description is : ");
								System.out.println(" Dispute registration date is : ");
								System.out.println(" Dispute solution except date is : ");
								System.out.println(" Dispute status is : ");
								System.out.println(" Dispute Assign to solve is by : ");
								System.out.println("===========================");
							});
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 2 : {
							List<DisputeDAO> list4 = admin.disputeListBuyerToSeller();
							System.out.println(" Dispute list of Buyer to Seller ....");
							list4.forEach(l -> {
								System.out.println(" Dispute ID is : ");
								
								System.out.println(" Dispute by Buyer ID is : ");
								
								if(l.getSid() != 0)
									System.out.println("Dispute On Seller ID is : ");
								
								System.out.println("Dispute Category is : ");
								
								System.out.println(" Dispute description is : ");
								
								System.out.println(" Dispute registration date is : ");
								
								System.out.println(" Dispute solution except date is : ");
								
								System.out.println(" Dispute status is : ");
								
								System.out.println(" Dispute Assign to solve is by : ");
								
								System.out.println("===========================");
							});
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 3 : {
							adminDashboard();
						}
						break;
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							
						}
						break;
					}

					
				}
				break;
				case 4 : {
					System.out.println(  "+ ---------------------------- +" );
					System.out.println( "|** Datewise Selling Report **|" );
					System.out.println(  "+ ---------------------------- +" );
					List<DisputeDAO> list5= admin.SoldItemListDatewise();
					list5.forEach(l -> {
						System.out.println(" Auction ID is : ");
						
						System.out.println(" Seller ID is : ");
						
						System.out.println(" Buyer ID is : ");
											
						System.out.println(" Category ID is : ");
						
						System.out.println(" Item Name is : ");
						
						System.out.println(" Item Quantity is : ");
						
						System.out.println(" Item insert date by seller is : ");
						
						System.out.println(" Item sold price is : ");
						
						System.out.println(" Item Auction price is : ");
						
						System.out.println(" Item Auction address is : ");
						
						System.out.println(" Item sold date is : ");
						
						System.out.println("===========================");
					});
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							adminProfileSetting();
							break;
						}
						case 2 : {
							adminDashboard();
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							break;
						}
					}
					
					
				}
				break;
				case 5 : {
					System.out.println("\n"+"Choose appropriate solved dispute report.."+"\n");
					System.out.println("\n 1. Solve Dispute list Seller to Application ..");
					System.out.println("2. Solve Dispute list Buyer to Seller ..");
					System.out.println("3. Back");
					int num3= sc.nextInt();
					switch(num3) {
						case 1 : {
							List<DisputeDAO> list7 = admin.solvedDisputeListSellerToApp();
							System.out.println(" Solve Dispute list Seller to Application ....");
							list7.forEach(l -> {
								System.out.println(" Dispute ID is : ");
								System.out.println(" Dispute by Seller ID is : ");
								System.out.println(" Category ID is : ");
								System.out.println(" Dispute description is : ");
								System.out.println(" Dispute registration date is : ");
								System.out.println(" Dispute solution date is : ");
								System.out.println(" Dispute status is : ");
								System.out.println(" Dispute Assign to solve is by : ");
								System.out.println("===========================");
							});
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 2 : {
							List<DisputeDAO> list8 = admin.solvedDisputeListBuyerToSeller();
							
							
							
							System.out.println(" Solve Dispute list of Buyer to Seller ....");
							list8.forEach(l -> {
								System.out.println(" Dispute ID is : ");
								
								System.out.println(" Dispute by Buyer ID is : ");
								
								if(l.getSid() != 0)
									System.out.println("Dispute On Seller ID is : ");
								
								System.out.println("Dispute Category is : ");
								
								System.out.println(" Dispute description is : ");
								
								System.out.println(" Dispute registration date is : ");
								
								System.out.println(" Dispute solution date is : ");
								
								System.out.println(" Dispute status is : ");
								
								System.out.println(" Dispute Assign to solve is by : ");
								
								System.out.println("===========================");
							});
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 3 : {
							adminDashboard();
						}
						break;
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							
						}
						break;
					}

				}
				break;
				case 6 : {
					adminProfileSetting();
				}
				break;
				case 7 : {
					System.out.println("Thanking you for visiting");
					return;
				}
				default:{
					System.out.println("Invalid Entry, try again...");
					adminDashboard();
				}
				break;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void adminProfileSetting() throws AdministratorException, UserException, ItemException {

		
		System.out.println(" Admin ID is : ");
		System.out.println(" Admin first Name is : ");
		System.out.println(" Admin last Name is : ");
		System.out.println(" Admin email is : ");
		System.out.println(" Admin mobile number is : ");
		System.out.println(" Admin date of birth is : ");
		System.out.println("===========================");
				
		System.out.println("1. Change Password..");
		System.out.println("2. Go to dashboard..");
		System.out.println("3. LogOut And Exit");
		try (Scanner sc = new Scanner(System.in)) {
			int num2 = sc.nextInt();
			
			sc.nextLine();
			switch(num2) {
				case 1 : {
					System.out.println("Enter your new password...");
					String password= sc.nextLine();
					String msg = admin.changePasswordAdmin(adminProfile.getAemail(), password);
					System.out.println(msg);
					System.out.println("===========================");
					adminProfileSetting();
				}
				break;
				case 2 : {
					adminDashboard();
				}
				break;
				case 3 : {
					System.out.println("Successfully logout ...");
					System.out.println("Thanking you for visiting...");
					return;
					
				}
				default : {
					System.out.println("Invalid number, try again ...");
					adminProfileSetting();
				}
				break;
			}
		}
	}
}
