package com.masai.App;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Exception.AdministratorException;
import com.masai.Exception.BuyerException;
import com.masai.Exception.DisputeException;
import com.masai.Exception.ItemException;
import com.masai.Exception.SellerException;




public class Main {

	private static AdministratorDao admin;
	private static BuyerDao buyer;
	private static SellerDao seller;
	
	
	public static Administrator adminProfile;
	public static Buyer buyerProfile;
	public static Seller sellerProfile;
	
	static {
		System.out.println("+----------------------------------------------+"+JavaConsoleColor.BLUE);
		System.out.println("|**********************************************|");
		System.out.println("|********"+ JavaConsoleColor.BOLDON+ " Hellow Welcome to Auction 41 "+ JavaConsoleColor.BOLDOFF+JavaConsoleColor.BLUE +"********|");
		System.out.println("|**********************************************|" + JavaConsoleColor.RESET);
		System.out.println("+----------------------------------------------+");
		
		admin= new AdministratorDaoImpl();
		buyer = new BuyerDaoImpl();
		seller = new SellerDaoImpl();
		
	};
	public static void main(String[] args) {
		
		System.out.println("\n" +JavaConsoleColor.BOLDON+ "Please press following number:- who are you? " +JavaConsoleColor.BOLDOFF+"\n");
		
		System.out.println("1. Are you Administrator..");
		System.out.println("2. Are you Seller..");
		System.out.println("3. Are you Buyer..");
		System.out.println("4. Exit");
		
		
		
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
							
							try {
								adminProfile = admin.loginAdministrator(username, password);
								System.out.print("\n Welcome Administrator "+adminProfile.getaFirstName());
								if(adminProfile.getaLastName()!=null) {
									System.out.println(" "+adminProfile.getaLastName());
								}
								else {
									
									System.out.println();
								}
								break;
							} catch (AdministratorException e) {
								System.out.println(e.getMessage());
								System.out.println("Do you want exit: press 4, else press any key...");
								String ex= sc.nextLine();
								if(ex.equals("4")) {
									System.out.println("Thanking you for visiting...");
									return;
								}
							}
						}
						adminDashboard();
					}
				break;
			case 2:
					{
						System.out.println(JavaConsoleColor.BOLDON+JavaConsoleColor.BLUE+"Hey Seller.."+JavaConsoleColor.BOLDOFF+JavaConsoleColor.RESET+"\n");
						System.out.println("1. New user? register..");
						System.out.println("2. Login..");
						System.out.println("3. Exit");
						
						int number= sc.nextInt();
						sc.nextLine();
						switch(number) {
							case 1:{
								Seller sellerRegistration= new Seller();
								System.out.println("\n Enter your First Name: ");
								sellerRegistration.setsFirstName(sc.nextLine());
								
								System.out.println("\n Enter your Last Name: ");
								sellerRegistration.setsLastName(sc.nextLine());
								
								System.out.println("\n Enter your email id: ");
								sellerRegistration.setsEmail(sc.nextLine());
								
								System.out.println("\n Enter your password: ");
								sellerRegistration.setSpassword(sc.nextLine());
								
								System.out.println("\n Enter your mobile number: ");
								sellerRegistration.setSmobile(sc.nextLine());
								
								System.out.println("\n Enter your Date of dirth (in yyyy-mm-dd formate): ");
								sellerRegistration.setSdod(Date.valueOf(sc.nextLine()));
								
								try {
									String str= seller.registerSeller(sellerRegistration);
									System.out.println(str+"\n");
									loginSeller();
								} catch (SellerException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								}
							}
							break;
							case 2:{
								loginSeller();
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
						System.out.println(JavaConsoleColor.BOLDON+JavaConsoleColor.BLUE+"Hey Buyer.."+JavaConsoleColor.BOLDOFF+JavaConsoleColor.RESET+"\n");
						System.out.println("1. New user? register..");
						System.out.println("2. Login..");
						System.out.println("3. Exit");
						
						int option= sc.nextInt();
						sc.nextLine();
						switch(option) {
							case 1:{
								Buyer buyerRegistration= new Buyer();
								System.out.println("\n Enter your First Name: ");
								buyerRegistration.setbFirstName(sc.nextLine());
								
								System.out.println("\n Enter your Last Name: ");
								buyerRegistration.setbLastName(sc.nextLine());
								
								System.out.println("\n Enter your email id: ");
								buyerRegistration.setBemail(sc.nextLine());
								
								System.out.println("\n Enter your password: ");
								buyerRegistration.setBpassword(sc.nextLine());
								
								System.out.println("\n Enter your mobile number: ");
								buyerRegistration.setBmobile(sc.nextLine());
								
								System.out.println("\n Enter your Date of dirth (in yyyy-mm-dd formate): ");
								buyerRegistration.setBdod(Date.valueOf(sc.nextLine()));
								
								try {
									String mesg= buyer.registerBuyer(buyerRegistration);
									
									System.out.println(mesg+"\n");
									loginBuyer();
								} catch (BuyerException e) {
									System.out.println(e.getMessage());
								}
							}
							break;
							case 2:{
								loginBuyer();
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
					
				case 4:
					{
						System.out.println("Thanking you for visiting...");
						return;
					}
					
				default:
					System.out.println("Invalid number, try again ...");
					main(args);
					break;
//				i++;
//				if(i<5) {
					
					
//				}
//				else {
//					System.out.println("Thanking you for visiting bye bye...");
//				}
					
			}
		}
	}
	
	
	
	
	
	public static void adminDashboard() {
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
					
					try {
						List<Buyer> list = admin.listOfBuyers();
						System.out.println(" registered buyer list ....");
						list.forEach(l -> {
							System.out.println(JavaConsoleColor.BOLDON+" Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Buyer first Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getbFirstName()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Buyer last Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getbLastName()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Buyer email is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBemail()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Buyer mobile number is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBmobile()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Buyer date of birth is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBdod()+JavaConsoleColor.RESET);
							System.out.println("===========================");
						});
					} catch (BuyerException e) {
						System.out.println(e.getMessage());
					}
					
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
					try {
						List<Seller> list2 = admin.listOfSeller();
						System.out.println(" registered Seller list ....");
						list2.forEach(l -> {
							System.out.println(JavaConsoleColor.BOLDON+" Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Seller first Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getsFirstName()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Seller last Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getsLastName()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Seller email is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getsEmail()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Seller mobile number is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSmobile()+JavaConsoleColor.RESET);
							System.out.println(JavaConsoleColor.BOLDON+" Seller date of birth is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSdod()+JavaConsoleColor.RESET);
							System.out.println("===========================");
						});
					} catch (SellerException e) {
						System.out.println(e.getMessage());
					}
					
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
					System.out.println("\n"+"Choose appropriate dispute report.."+"\n");
					System.out.println("\n 1. Dispute list Seller to Application ..");
					System.out.println("2. Dispute list Buyer to Seller ..");
					System.out.println("3. Back");
					int num3= sc.nextInt();
					switch(num3) {
						case 1 : {
							try {
								List<DisputeSellerToAppWithTeamNameDto> list3 = admin.disputeListSellerToApp();
								System.out.println(" Dispute list Seller to Application ....");
								list3.forEach(l -> {
									System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute by Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Category ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCid()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute solution except date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+"in process"+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
									System.out.println("===========================");
								});
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
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
							try {
								List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> list4 = admin.disputeListBuyerToSeller();
								
								
								
								System.out.println(" Dispute list of Buyer to Seller ....");
								list4.forEach(l -> {
									System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute by Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
									
									if(l.getSid() != 0)
										System.out.println(JavaConsoleColor.BOLDON+"Dispute On Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+"Dispute Category is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCname()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute solution except date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+"in process"+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
									
									System.out.println("===========================");
								});
								
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
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
					System.out.println(JavaConsoleColor.PURPLE + "+ ---------------------------- +" +JavaConsoleColor.RESET);
					System.out.println(JavaConsoleColor.RED + "|** Datewise Selling Report **|" +JavaConsoleColor.RESET);
					System.out.println(JavaConsoleColor.PURPLE + "+ ---------------------------- +" +JavaConsoleColor.RESET);
					try {
						List<Sold> list5= admin.SoldItemListDatewise();
						list5.forEach(l -> {
							System.out.println(JavaConsoleColor.BOLDON+" Auction ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionid()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
												
							System.out.println(JavaConsoleColor.BOLDON+" Category ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCid()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Item Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getItem_detail()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Item Quantity is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getItem_quantity()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Item insert date by seller is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getItemDate()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Item sold price is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSellingPrice()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Item Auction price is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionPrice()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Item Auction address is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionAddress()+JavaConsoleColor.RESET);
							
							System.out.println(JavaConsoleColor.BOLDON+" Item sold date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionDate()+JavaConsoleColor.RESET);
							
							System.out.println("===========================");
						});
					
					} catch (ItemException e) {
						System.out.println(e.getMessage());
					}
					
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
							try {
								
								
								List<DisputeSellerToAppWithTeamNameDto> list7 = admin.solvedDisputeListSellerToApp();
								System.out.println(" Solve Dispute list Seller to Application ....");
								list7.forEach(l -> {
									System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute by Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Category ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCid()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute solution date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+"Solved"+JavaConsoleColor.RESET);
									System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
									System.out.println("===========================");
								});
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
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
							try {
								List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> list8 = admin.solvedDisputeListBuyerToSeller();
								
								
								
								System.out.println(" Solve Dispute list of Buyer to Seller ....");
								list8.forEach(l -> {
									System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute by Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
									
									if(l.getSid() != 0)
										System.out.println(JavaConsoleColor.BOLDON+"Dispute On Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+"Dispute Category is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCname()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute solution date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+"Solved"+JavaConsoleColor.RESET);
									
									System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
									
									System.out.println("===========================");
								});
								
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
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
}
