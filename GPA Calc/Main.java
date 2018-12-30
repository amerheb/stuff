import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean on = true;
		
		while(on == true) {
			
			System.out.println("How many courses?");
			int count = input.nextInt();
			
			String[] grades = new String[count+1];
			int[] credits = new int[count+1];
			
			for(int i = 1; i <= count; i++) {
				System.out.println("Grade for course #" + i + ":");
				grades[i] = input.next();
				
		
				
				System.out.println("Credits for course #" + i + ":");
				credits[i] = input.nextInt();
			}
			
			System.out.println("Calculating GPA...");
			
			double score = 0;
			double creds = 0;
			
			for(int i = 1; i <= count; i++) {	
				switch (grades[i]) {
				case "A":
					score = score + 4 * credits[i];
					break;
				case "B+":
					score = score + 3.5 * credits[i];
					break;
				case "B":
					score = score + 3 * credits[i];
					break;
				case "C+":
					score = score + 2.5 * credits[i];
					break;
				case "C":
					score = score + 2 * credits[i];
					break;
				case "D":
					score = score + 1 * credits[i];
					break;
				case "F":
					score = score + 0 * credits[i];
					break;
				}
				
				creds = creds + credits[i];
			}
			
			double GPA = score / creds;
			
			System.out.println();
			System.out.println("GPA: " + GPA );
			System.out.println();
			
			System.out.println("Score: " + score);
			System.out.println("Total Credits: " + creds);
			System.out.println();
			
			System.out.println("Reset? (y/n)");
			
			String reset = input.next();
			
			if(reset.equals("n")) {
				on = false;
			}
		}
		} 

}
