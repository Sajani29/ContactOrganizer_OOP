import java.util.*;
import java.time.*;

class Contact{
		private String contactId;
		private String contactName;
		private String contactPhoneNumber;
		private String companyName;
		private double salaryAmount;
		private String dob;


}

// Contact Class=============================================

class ContactOrganizer{
	static int id = 1;

	public static void incrementArrays(){
		Contact[] tempContactsArray = new Contact[contactArray.length+1];
		/*for (int i = 0; i <tempContactsArray; i++)
		{
			tempContactsArray[i] = contactArray[i];
		}
		*/
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
		
		public static Contact[] contactArray = new Contact[0];
		
		switch (option)
		{
			case 01:
				//addContacts();
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
