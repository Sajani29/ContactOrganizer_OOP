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


//class ContactOrganizer
class ContactOrganizer{
	static Contacts[] contactArray = new Contacts[0];
	static int id = 1;
	//CLEAR CONSOL
	public final static void clearConsole(){
		try {   
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			}else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		}
	}
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
	
	//CHECK PHONE NUMBER AND NAME 
	public static int searchNameorPhoneNo(String inputValue){
		for (int i = 0; i < contactArray.length; i++)
		{
			if (inputValue.equals(contactArray[i].getContactName()) || inputValue.equals(contactArray[i].getContactPhoneNumber()))
			{
				return i;
			}
			
		}
		return -1;
		
	}
	//UPDATE SALARY
	public static void updateSalary(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("Update Salary");
		System.out.println("===============");
		System.out.println();
		System.out.print("Input new salary - ");
		int newSalary = input.nextInt();
		if (!isValidsalary(newSalary))
		{
			System.out.println("Salary should positive .. try again..");
		}
		contactArray[index].setSalaryAmount(newSalary);
		System.out.println();
		System.out.println("\t Contact has been update successfully... ");
		System.out.println();
		System.out.print("Do you want to update another Contact(Y/N): ");
		char yORn = input.next().charAt(0);
		if (yORn == 'Y' ||yORn == 'y' )
		{
			updateContacts();
		}if (yORn == 'N' ||yORn == 'n')
		{
			main(null);
		}
	}
	//UPDATE COMPANY NAME 
	public static void updateCompanyName(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("Update Company Name ");
		System.out.println("===============");
		System.out.println();
		System.out.print("Input new name - ");
		String newCompanyName = input.next();
		contactArray[index].setCompanyName(newCompanyName);
		System.out.println();
		System.out.println("\t Contact has been update successfully... ");
		System.out.println();
		System.out.print("Do you want to update another Contact(Y/N): ");
		char yORn = input.next().charAt(0);
			if (yORn == 'Y' ||yORn == 'y' )
			{
				updateContacts();
			}if (yORn == 'N' ||yORn == 'n')
			{
				main(null);
			}
	}
	//UPDATE PHONE NUMBER
	public static void updatephoneNo(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("Update Phone Number");
		System.out.println("===============");
		System.out.println();
		L5:while (true)
		{
			System.out.print("Input new new phone number - ");
			String newPhoneNo = input.next();
			if (!isValidPhonenumber(newPhoneNo))
			{
				System.out.println("Invalid phone number.. try again..");
				continue L5;
			}else
			{
				contactArray[index].setContactPhoneNumber(newPhoneNo);
				System.out.println();
				System.out.println("\t Contact has been update successfully... ");
				System.out.println();
				System.out.print("Do you want to update another Contact(Y/N): ");
				char yORn = input.next().charAt(0);
				if (yORn == 'Y' ||yORn == 'y' )
				{
					updateContacts();
				}if (yORn == 'N' ||yORn == 'n')
				{
					main(null);
				}
			}
		}
	}
	//UPDATE NAME
	public static void updateName(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("Update Name");
		System.out.println("===============");
		System.out.println();
		System.out.print("Input new name - ");
		String newName = input.next();
		contactArray[index].setContactName(newName);
		System.out.println();
		System.out.println("\t Contact has been update successfully... ");
		System.out.println();
		System.out.print("Do you want to update another Contact(Y/N): ");
		char yORn = input.next().charAt(0);
			if (yORn == 'Y' ||yORn == 'y' )
			{
				updateContacts();
			}if (yORn == 'N' ||yORn == 'n')
			{
				main(null);
			}
	}
	//UPDATE CONTACAT LIST
	public static void updateContacts(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|\t\tUPDATE Contact\t\t\t  |");
		System.out.println("+-------------------------------------------------+");
		System.out.println();
		System.out.println();
		System.out.print("Search Contact by Name or Phone Number - ");
		String inputValue = input.next();
		int index = searchNameorPhoneNo(inputValue);
		if (index == -1)
		{
			System.out.println("\t\tNo contact found for "+inputValue);
		}else
		{
				System.out.println("\tContact ID       : "+contactArray[index].getContactId());
				System.out.println("\tName             : "+contactArray[index].getContactName());
				System.out.println("\tPhone Number     : "+contactArray[index].getContactPhoneNumber());
				System.out.println("\tCompany Name     : "+contactArray[index].getCompanyName());
				System.out.println("\tSalary           : "+contactArray[index].getSalaryAmount());
				System.out.println("\tB'Day(YYY-MM-DD) : "+contactArray[index].getDoB());
				System.out.println();
				System.out.println("What do you want to update...");
				System.out.println();
				System.out.println("\t[01] Name");
				System.out.println("\t[02] Phone Number");
				System.out.println("\t[03] Company Name");
				System.out.println("\t[04] Salary");
				System.out.println();
				System.out.print("Enter an option to continue -> ");
				int option = input.nextInt();
				
				switch (option)
				{
					case 1:
						updateName(index);
						break;
					case 2:
						updatephoneNo(index);
						break;
					case 3:
						updateCompanyName(index);
						break;
					case 4:
						updateSalary(index);
						break;
					default:
						System.out.println("Invalid input...");
				}
		}
	}
	
	//REDUCE ARRAY
	public static void reduceArrays(int index){
		Contacts[] temporaryArray = new Contacts[contactArray.length -1];
		for (int i = index; i < contactArray.length-1; i++)
		{
			contactArray[i] = contactArray[i+1];
		}
		
		contactArray = temporaryArray;
		
	}
	//DELETE CONTACT
	public static void deleteContacts(){
		Scanner input = new Scanner(System.in);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|\t\tDELETE Contact\t\t\t  |");
		System.out.println("+-------------------------------------------------+");
		System.out.println();
		System.out.println();
		System.out.print("Search Contact by Name or Phone Number - ");
		String inputNameorPhone = input.next();
		int index = searchNameorPhoneNo(inputNameorPhone);
		if (index == -1)
		{
			System.out.println("\t\tNo contact found for "+inputNameorPhone);
		}else
		{
				System.out.println("\tContact ID       : "+contactArray[index].getContactId());
				System.out.println("\tName             : "+contactArray[index].getContactName());
				System.out.println("\tPhone Number     : "+contactArray[index].getContactPhoneNumber());
				System.out.println("\tCompany Name     : "+contactArray[index].getCompanyName());
				System.out.println("\tSalary           : "+contactArray[index].getSalaryAmount());
				System.out.println("\tB'Day(YYY-MM-DD) : "+contactArray[index].getDoB());
				System.out.println();
				System.out.println("Do you want to delete this contact (Y/N): ");
				System.out.println();
				char yORn = input.next().charAt(0);
					if (yORn == 'Y' ||yORn == 'y' )
					{
						reduceArrays(index);
						System.out.println("\t\tCustomer has been deleted successfully...");
					}if (yORn == 'N' ||yORn == 'n')
					{
						main(null);
					}
				System.out.print("Do you want to delete another Contact(Y/N): ");
				char yORN = input.next().charAt(0);
				if (yORN == 'Y' ||yORN == 'y' )
				{
					deleteContacts();
				}if (yORN == 'N' ||yORN == 'n')
				{
					main(null);
				}
				
		}
	}
	//SORT BY NAME
	public static void sortingByName(){
	Scanner input=new Scanner(System.in);
		
		for(int j=contactArray.length-1 ;j > 0;j--){
			for (int i = 0; i < j; i++){
				if(contactArray[i].getContactName().charAt(0) > contactArray[(i+1)].getContactName().charAt(0)){
					Contacts temp = contactArray[i];
					contactArray[i] = contactArray[i+1];
					contactArray[i+1] = temp;	
				}
			}
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for(int i=0; i < contactArray.length;i++){
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8.2f | %-15s |\n",contactArray[i].getContactId(), contactArray[i].getContactName(), contactArray[i].getContactPhoneNumber(), contactArray[i].getCompanyName(), contactArray[i].getSalaryAmount(), contactArray[i].getDoB() );
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		System.out.println('\n');
		System.out.print("Do you want to go Home Page (Y/N): ");
		char main=input.next().charAt(0);
		main=Character.toLowerCase(main);
		
		if(main=='y'){
			clearConsole();
			main(null);
		}else{
			clearConsole();
			sortingByName();
		}
	}
	//SORT BY SALARY
	public static void sortingBySalary(){
		Scanner input = new Scanner(System.in);
		for (int j = contactArray.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (contactArray[i].getSalaryAmount() < contactArray[i + 1].getSalaryAmount()) {
					Contacts temp = contactArray[i];
					contactArray[i] = contactArray[i + 1];
					contactArray[i + 1] = temp;
				}
			}
		}
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s | %-15s |%n", "Contact ID", "Name", "Phone Number", "Company", "Salary", "Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		for (int i = 0; i < contactArray.length; i++) {
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8.2f | %-15s |\n", 
				contactArray[i].getContactId(), 
				contactArray[i].getContactName(), 
				contactArray[i].getContactPhoneNumber(), 
				contactArray[i].getCompanyName(), 
				contactArray[i].getSalaryAmount(), 
				contactArray[i].getDoB() 
			);
		}
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.println('\n');
		System.out.print("Do you want to go Home Page (Y/N): ");
		char main = input.next().charAt(0);
		main = Character.toLowerCase(main);
		if (main == 'y') {
			clearConsole();
			main(null);
		} else {
			clearConsole();
		}

	}
	//SORT BY BIRTHDAY
	public static void sortingByBirthday(){
		Scanner input = new Scanner(System.in);
		for (int j = contactArray.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (contactArray[i].getDoB().compareTo(contactArray[i + 1].getDoB()) > 0) {
					Contacts temp = contactArray[i];
					contactArray[i] = contactArray[i + 1];
					contactArray[i + 1] = temp;
				}
			}
		}
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s | %-15s |%n", "Contact ID", "Name", "Phone Number", "Company", "Salary", "Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		for (int i = 0; i < contactArray.length; i++) {
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8.2f | %-15s |\n", 
				contactArray[i].getContactId(), 
				contactArray[i].getContactName(), 
				contactArray[i].getContactPhoneNumber(), 
				contactArray[i].getCompanyName(), 
				contactArray[i].getSalaryAmount(), 
				contactArray[i].getDoB() 
			);
		}
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.println('\n');
		System.out.print("Do you want to go Home Page (Y/N): ");
		char main = input.next().charAt(0);
		main = Character.toLowerCase(main);
		if (main == 'y') {
			clearConsole();
			main(null);
		} else {
			clearConsole(); 
		}

	}
	//SEARCH CONTACT
	public static void searchContacts(){
		Scanner input = new Scanner(System.in);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|\t\tSEARCH Contact\t\t\t  |");
		System.out.println("+-------------------------------------------------+");
		System.out.println();
		System.out.println();
		System.out.print("Search Contact by Name or Phone Number - ");
		String inputNameorPhone = input.next();
		int index = searchNameorPhoneNo(inputNameorPhone);
		if (index == -1)
		{
			System.out.println("\t\tNo contact found for "+inputNameorPhone+"...");
			System.out.println("Do you want to try a new search (Y/N): ");
			System.out.println();
				char yORn = input.next().charAt(0);
					if (yORn == 'Y' ||yORn == 'y' )
					{
						searchContacts();
						System.out.println("\t\tCustomer has been deleted successfully...");
					}if (yORn == 'N' ||yORn == 'n')
					{
						main(null);
					}
		}
		else
		{
			System.out.println("\tContact ID       : "+contactArray[index].getContactId());
			System.out.println("\tName             : "+contactArray[index].getContactName());
			System.out.println("\tPhone Number     : "+contactArray[index].getContactPhoneNumber());
			System.out.println("\tCompany Name     : "+contactArray[index].getCompanyName());
			System.out.println("\tSalary           : "+contactArray[index].getSalaryAmount());
			System.out.println("\tB'Day(YYY-MM-DD) : "+contactArray[index].getDoB());
			System.out.println();
			
			System.out.println("Do you want to try a new search (Y/N): ");
			System.out.println();
				char yORn = input.next().charAt(0);
					if (yORn == 'Y' ||yORn == 'y' )
					{
						searchContacts();
						System.out.println("\t\tCustomer has been deleted successfully...");
					}if (yORn == 'N' ||yORn == 'n')
					{
						main(null);
					}
		}
	}
	//SORT CONTACT
	public static void listContacts(){
		Scanner input = new Scanner(System.in);
		System.out.println("+----------------------------------------------+");
		System.out.println("|\tSORT Contact\t\t\t       |");
		System.out.println("+----------------------------------------------+");
		System.out.println();
		System.out.println("[01] Sorting by Name");
		System.out.println("[02] Sorting by Salary");
		System.out.println("[03] Sorting by Birthday");
		System.out.println();
		System.out.print("Enter an option to continue ->");
		int option = input.nextInt();
		switch (option)
		{
			case 1:
				sortingByName();
				break;
			case 2:
				sortingBySalary();
				break;
			case 3:
				sortingByBirthday();
				break;
			default:
				System.out.println("Invalid input..");
		}
	}
	//MAIN METHOD
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
				clearConsole();
				addContacts();
				break;
			case 02:
				clearConsole();
				updateContacts();
				break;
			case 03:
				clearConsole();
				deleteContacts();
				break;
			case 04:
				clearConsole();
				searchContacts();
				break;
			case 05:
				clearConsole();
				listContacts();
				break;
			case 06:
				clearConsole();
				return;
			default:
				clearConsole();
				System.out.println("Invalid input.. try again...");
		}
		
	}
}
































