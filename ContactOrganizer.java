import java.util.*;
import java.time.*;

class Contacts{
	private String contactId;
	private String name;
	private String phoneNumber;
	private String companyName;
	private Double salary;
	private String dOb;
	
	Contacts(){}
	
	
		Contacts(String contactId,String name,String phoneNumber,String companyName,double salary,String dOb){
			setContactId(contactId);
			setContactName(name);
			setContactPhoneNumber(phoneNumber);
			setCompanyName(companyName);
			setSalaryAmount(salary);
			setDOb(dOb);
		}
		public void setContactId(String contactId){
			this.contactId = contactId;
		}
		public  void setContactName(String name){
			this.name = name;
		}
		public  void setContactPhoneNumber(String phoneNumber){
			this.phoneNumber = phoneNumber;
		}
		public  void setCompanyName(String companyName){
			this.companyName = companyName;
		}
		public  void setSalaryAmount(double salary){
			this.salary = salary;
		}
		public  void setDOb(String dOb){
			this.dOb = dOb;
		}
		public  String getContactId(){
			return contactId;
		}
		public  String getContactName(){
			return name;
		}
		public String getContactPhoneNumber(){
			return phoneNumber;
		}
		public String getCompanyName(){
			return companyName;
		}
		public  double getSalaryAmount(){
			return salary;
		}
		public String getDoB(){
			return dOb;
		}

	
}



class ContactOrganizer{
	static Contacts[] contactArray = new Contacts[0];
	static int id = 1;
	
	
	//check birthday
		public static boolean isValidBirthday(String dOb){
			LocalDate localdate = LocalDate.parse(dOb);
			int birthyear = localdate.getYear();
			int birthmonth = localdate.getMonthValue();
			int birthdate = localdate.getDayOfMonth();
			
			LocalDate currentDate = LocalDate.now();
			int currentYear = currentDate.getYear();
			
			
			if(birthyear > 1926 && birthyear < currentYear && 12> birthmonth && birthmonth > 0 && birthdate >0 &&  birthdate <30){
				return true;
			}else{
				return false;
			}
		}
	
	//check salary
	public static boolean isValidsalary(double salary){
		if (salary > 0)
		{
			return true;
		}
		return false;
	}
	
	//check phone number
	public static boolean isValidPhonenumber(String number){
		if (number.startsWith("0") && number.length() == 10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//extend array
	
	public static void extendArrays(String contactId, String name, String phoneNumber,String companyName,double salary,String dOb){
		Contacts[] tempContactArray = new Contacts[contactArray.length +1];
		for (int i = 0; i < contactArray.length; i++)
		{
			tempContactArray[i] = contactArray[i];
		}
		
		contactArray = tempContactArray;
		contactArray[contactArray.length -1] = new Contacts(contactId,name,phoneNumber,companyName,salary,dOb);
	}
	//generate ID
	public static String generateId(int id){
		String generatedId = String.format("C%04d",id);
		return generatedId;
	}
	
	//ADD CONTACT METHOD
	public static void addContacts(){
		Scanner input = new Scanner(System.in);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|\t\tAdd Contact to the list\t\t  |");
		System.out.println("+-------------------------------------------------+");
		System.out.println();
		System.out.println(generateId(id));
		System.out.println("===========");
		System.out.println();		
		System.out.print("Name\t\t : ");
		String name = input. next();
		String number = " ";
		L1:while (true)
		{
			System.out.print("Phone Number\t : ");
			number = input. next();
			if (!isValidPhonenumber(number))
			{
				System.out.println("Invalid number.. try again..");
				continue L1;
			}
			break;
		}
		System.out.print("Company Name\t : ");
		String companyName = input. next();
		double salary = 0;
		L2:while (true)
		{
			System.out.print("Salary\t\t : ");
			salary = input. nextDouble();
			if (!isValidsalary(salary))
			{
				System.out.println("Salary should positive .. try again..");
				continue L2;
			}
			break;
		}
		String dOb = "";
		L3:while (true)
		{
			System.out.print("B'Day(YYYY-MM-DD) : ");
			 dOb = input. next();
			if (!isValidBirthday(dOb))
			{
				System.out.println("Invalid Birthday....");
				continue L3;
			}
			break;
		}
		extendArrays(generateId(id),name,number,companyName,salary,dOb);
		System.out.print("\n\tContact has been added successfully...\n\n");
			System.out.print("Do you want to add another contact(Y/N): ");
			char yORn = input.next().charAt(0);
			if (yORn == 'Y' ||yORn == 'y' )
			{	
				id++;
				addContacts();
			}if (yORn == 'N' ||yORn == 'n')
			{
				main(null);
			}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("	                      /$$ / $$$$$$$$/$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$    ");
		System.out.println("	                      |__/  $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$  ");
		System.out.println("	                       /$$  $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$  ");
		System.out.println("	                      | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$  ");
		System.out.println("	                      | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/  ");
		System.out.println("	                      |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/   ");
		
		System.out.println('\n');
		
		System.out.println("   _____             _             _              ____                         _                   ");
		System.out.println("  / ____|           | |           | |            / __ \\                       (_)                 ");
		System.out.println(" | |      ___  _ __ | |_ __ _  ___| |_ ___      | |  | |_ __ __ _       _ __  _ ____ __ _ __     ");
		System.out.println(" | |     / _ \\| '_ \\| __/ _` |/ __| __/ __|     | |  | | `_/  _` |/ _` | '_ \\| |_  / _ \\ `__|    ");
		System.out.println(" | |____| (_) | | | | || |_| | |__| |_\\__ \\     | |__| | | | |_| | |_| | | | | |/ /  __/| |      ");
		System.out.println("  \\_____ \\___/|_| |_|\\__\\__,_|\\___|\\__|___/      \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___||_|      ");
		System.out.println("                                                             __/ |                               ");
		System.out.println("                                                            |___/                                ");
		
		System.out.println();
		System.out.println("========================================================================================================");
		System.out.println('\n');
		
		System.out.println("\t[01] Add Contacts\n");
		System.out.println("\t[02] Update Contacts\n");
		System.out.println("\t[03] Delete Contacts\n");
		System.out.println("\t[04] Search Contacts\n");
		System.out.println("\t[05] List Contacts\n");
		System.out.println("\t[06] Exit\n");
		
		System.out.print("Enter an option to continue ->");
		int option = input.nextInt();
		
		
		
		switch (option)
		{
			case 01:
				addContacts();
				break;
			case 02:
				//updateContacts();
				break;
			case 03:
				//deleteContacts();
				break;
			case 04:
				//searchContacts();
				break;
			case 05:
				//listContacts();
				break;
			case 06:
				return;
			default:
				System.out.println("Invalid input.. try again...");
		}
		
	}
}
































/*import java.util.*;
import java.time.*;

class Contact{
		private int contactId;
		private String contactName;
		private String contactPhoneNumber;
		private String companyName;
		private double salaryAmount;
		private String dOb;
	
		public Contact(){}
		
		public void setContactId(int contactId){
			this.contactId = contactId;
		}
		public static void setContactName(String contactName){
			
		}
		public static void setContactPhoneNumber(String contactPhoneNumber){
			
		}
		public static void setCompanyName(String companyName){
			
		}
		public static void setSalaryAmount(double salaryAmount){
			
		}
		public static void dOb(String dOb){
			
		}
		public  int getContactId(){
			return contactId;
		}
		public  String getContactName(){
			return contactName;
		}
		public String getContactPhoneNumber(){
			return contactPhoneNumber;
		}
		public String getCompanyName(){
			return companyName;
		}
		public  double getSalaryAmount(){
			return salaryAmount;
		}
		public String getDoB(){
			return dOb;
		}

}

// Contact Class end =============================================

class ContactOrganizer{
	static int id = 1;
	public static Contact[] contactArray = new Contact[0];
	
	//Increment Array method ======
	public static void incrementArrays(int contactId,String contactName,String contactPhoneNumber,String companyName,double salaryAmount,String dOb){
		Contact[] tempContactsArray = new Contact[contactArray.length+1];
		for (int i = 0; i <tempContactsArray.length; i++)
		{
			tempContactsArray[i] = contactArray[i];
		}
		
		contactArray = tempContactsArray;
		//Contact[contactArray.length - 1] = new Contact[contactId,contactName,contactPhoneNumber,companyName,salaryAmount,dOb];
	}
	
	//generate ID Method==================
	public static String generateId(int id){
		String generatedId = String.format("C%04d",id);
		return generatedId;
	}
	
	
	public static boolean isValidPhonenumber(String number){
		if (number.startsWith("0") && number.length() == 10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isValidsalary(int salary){
		if (salary > 0)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isValidBirthday(String bOd){
		LocalDate localdate = LocalDate.parse(bOd);
		int birthyear = localdate.getYear();
		int birthmonth = localdate.getMonthValue();
		int birthdate = localdate.getDayOfMonth();
		
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		
		
		if(birthyear > 1926 && birthyear < currentYear && 12> birthmonth && birthmonth > 0 && birthdate >0 &&  birthdate <30){
			return true;
		}else{
			return false;
		}
	}
	
	//Add contact method==========
	public static void addContacts(){
		Scanner input = new Scanner(System.in);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|\t\tAdd Contact to the list\t\t  |");
		System.out.println("+-------------------------------------------------+");
		System.out.println();
		
		System.out.println(generateId(id));
		System.out.println("======\n");
		System.out.print("Name              :");
		String name = input.next();
		
		L1:while (true)
		{
			System.out.print("Phone Number      :");
			String number = input.next();
			if (!isValidPhonenumber(number))
			{
				System.out.println("Invalid number.. try again..");
				continue L1;
			}
			
			System.out.print("Company Name      :");
			String comName = input.next();
			System.out.print("Salary            :");
			int salary = input.nextInt();
			if (!isValidsalary(salary))
			{
				System.out.println("Salary should positive .. try again..");
			}
		L2:while (true)
		{
			System.out.print("B'Day(YYYY-MM-DD) : ");
			String dOb = input.next();
			
			if (!isValidBirthday(dOb))
			{
				System.out.println("Invalid Birthday....");
				continue L2;
			}else
			{
			
			System.out.print("\n\tContact has been added successfully...\n\n");
			System.out.print("Do you want to add another contact(Y/N): ");
			char yORn = input.next().charAt(0);
			if (yORn == 'Y' ||yORn == 'y' )
			{	
				id++;
				addContacts();
			}if (yORn == 'N' ||yORn == 'n')
			{
				main(null);
			}
			}
		}
		
		
		}
		
		

	}
	
	
	//main method===================
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("	                      /$$ / $$$$$$$$/$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$    ");
		System.out.println("	                      |__/  $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$  ");
		System.out.println("	                       /$$  $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$  ");
		System.out.println("	                      | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$  ");
		System.out.println("	                      | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/  ");
		System.out.println("	                      |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/   ");
		
		System.out.println('\n');
		
		System.out.println("   _____             _             _              ____                         _                   ");
		System.out.println("  / ____|           | |           | |            / __ \\                       (_)                 ");
		System.out.println(" | |      ___  _ __ | |_ __ _  ___| |_ ___      | |  | |_ __ __ _       _ __  _ ____ __ _ __     ");
		System.out.println(" | |     / _ \\| '_ \\| __/ _` |/ __| __/ __|     | |  | | `_/  _` |/ _` | '_ \\| |_  / _ \\ `__|    ");
		System.out.println(" | |____| (_) | | | | || |_| | |__| |_\\__ \\     | |__| | | | |_| | |_| | | | | |/ /  __/| |      ");
		System.out.println("  \\_____ \\___/|_| |_|\\__\\__,_|\\___|\\__|___/      \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___||_|      ");
		System.out.println("                                                             __/ |                               ");
		System.out.println("                                                            |___/                                ");
		
		System.out.println();
		System.out.println("========================================================================================================");
		System.out.println('\n');
		
		System.out.println("\t[01] Add Contacts\n");
		System.out.println("\t[02] Update Contacts\n");
		System.out.println("\t[03] Delete Contacts\n");
		System.out.println("\t[04] Search Contacts\n");
		System.out.println("\t[05] List Contacts\n");
		System.out.println("\t[06] Exit\n");
		
		System.out.print("Enter an option to continue ->");
		int option = input.nextInt();
		
		
		
		switch (option)
		{
			case 01:
				addContacts();
				break;
			case 02:
				//updateContacts();
				break;
			case 03:
				//deleteContacts();
				break;
			case 04:
				//searchContacts();
				break;
			case 05:
				//listContacts();
				break;
			case 06:
				return;
			default:
				System.out.println("Invalid input.. try again...");
		}
		
		

	}
}
*/
