import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class NoteApp {
	public static void createNote(Scanner sc) {
		System.out.println("Provide File Name : ");
		String file_name = sc.nextLine();
		System.out.println("Provide the Content for a file : ");
		String content = sc.nextLine();
		try {
			FileWriter fw = new FileWriter(file_name);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Note is succesfully Created");
			bw.close();
			fw.close();
		}
		catch(Exception e) {
			System.out.println("Error Creating a note :" +e.getMessage());
		}
		
	}
	
	public static void viewNote(Scanner sc) {
		System.out.println("Provide me the File Name : ");
		String file_name = sc.nextLine();
		try {
			FileReader fr = new FileReader(file_name);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null) {
				System.out.println(line);
				line = br.readLine();
				}
			br.close();
			fr.close();

		}
		catch(Exception ex) {
			System.out.println("Invalid file name or error in reading note " +ex.getMessage());
			
		}
	
		
	}
	
	public static void updateNote(Scanner sc) {
		System.out.println("Provide me the File Name : ");
		String file_name = sc.nextLine();
		System.out.println("Provide the content which to be update. ");
		String u_content = sc.nextLine();
		try {
			FileWriter fw = new FileWriter(file_name, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write (u_content);	
			System.out.println("Note has been updated! ");

			bw.close();
			fw.close();
		}		
		catch(Exception e) {
			System.out.println("Error in updating..");
			
		}
	}
	
	public static void deleteNote(Scanner sc) {
		 System.out.println("Provide me the File Name to delete : ");
		 String file_name = sc.nextLine();
		    try {
		        File file = new File(file_name);   // create File object
		        if (file.exists()) {
		            if (file.delete()) {
		                System.out.println(" File deleted successfully!");
		            } else {
		                System.out.println(" File could not be deleted.");
		            }
		        } else {
		            System.out.println("File does not exist.");
		        }
		    } catch (Exception ex) {
		        System.out.println("Error in deleting: " + ex.getMessage());
		    }
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice=0;
		
		while(choice!=5) {
			System.out.println("==== Notes App ====");
			System.out.println("1. Create Note");
			System.out.println("2. View Note");
			System.out.println("3. Update a Note");
			System.out.println("4. Delete a Note");
			System.out.println("5. Exit");
			
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				createNote(sc);
				break;
			
			case 2:
				viewNote(sc);
				break;
			case 3:
				updateNote(sc);
				break;
				
			case 4:
				deleteNote(sc);
				break;
			
			case 5:
				if (choice == 5) {
					System.out.println("Exiting........");
				}
			default:
					System.out.println("Invalid Input ");
			}
			
		}
		sc.close();

	}

}
