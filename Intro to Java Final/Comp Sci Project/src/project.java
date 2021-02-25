import java.util.*;
import java.io.*;

public class project {

	public static void main(String[] args) {

		//questions
		String	Array[] = {"George Washington", "John Adams", "Thomas Jefferson", "James Madison","James Monroe","John Quincy Adams"
				,"Andrew Jackson","Martin Van Buren","William Henry Harrison","John Tyler","James K. Polk","Zachary Taylor"
				,"Millard Fillmore","Franklin Pierce","James Buchanan","Abraham Lincoln ","Andrew Johnson","Ulysses S. Grant"
				,"Rutherford B. Hayes","James Garfield","Chester A. Arthur","Grover Cleveland (first term)","Benjamin Harrison","Grover Cleveland (second term)"
				,"William McKinley","Theodore Roosevelt","William Howard Taft","Woodrow Wilson","Warren G. Harding","Calvin Coolidge"
				,"Herbert Hoover","Franklin D. Roosevelt","Harry S. Truman","Dwight D. Eisenhower","John F. Kennedy"
				,"Lyndon B. Johnson","Richard M. Nixon","Gerald R. Ford","James Carter" , "Ronald Reagan","George H. W. Bush"
				,"William J. Clinton","George W. Bush","Barack Obama", "Donald J. Trump"};

		//answers
		String  Array2[] = {"1789–1797","1797–1801","1801–1809","1809–1817","1817–1825","1825–1829","1829–1837","1837–1841","1841"
				,"1841–1845","1845–1849","1849–1850","1850–1853","1853–1857","1857–1861","1861–1865","1865–1869","1869–1877"
				,"1877–1881","1881","1881–1885","1885–1889","1889–1893","1893–1897","1897–1901","1901–1909","1909–1913","1913–1921"
				,"1921–1923","1923–1929","1929–1933","1933–1945","1945–1953","1953–1961","1961–1963","1963–1969","1969–1974"
				,"1974–1977","1977–1981","1981–1989","1989–1993","1993–2001","2001–2009","2009–2017","2017–present"};

		//makes sure no question is repeated
		int Array3[] = new int[45];

		//keeps score [scores/right/wrong][player]
		int Array4[][];

		//takes inputs and makes answer [first input/second input/full answer]
		String Array5[] = new String[3];
		
		//game settings [correct points/incorrect points/number of questions/questions counter/number of players/active player]
		int Array6[] = {50, 0, 20, 0, 3, 0};

		int a = 0; // sets array position to pick president
		int b = 0; // question counter
		int c = 0; // number of players
		int d = 0; // active player answering
		int e = 0; // error indicator

		//get # of players and set score array size
		Scanner input = new Scanner(System.in);

		System.out.print("Welcome to the Presidents Triva Game Show!\n"
				+"In this game you will be given a president of the United States and asked what year(s) they served.\n"
				+"If you answer correctly you will be awarded 50 points and asked to answer again.\n"
				+"If you answer inccorrectly the question will go to another player.\n"
				+"If you don't know the answer, you can skip and send it to the next person.\n"
				+"The first person to 200 points wins. \n"
				+"---------------------------------------------------------------------------------------------------\n");
		
		
		System.out.printf("Settings\nPoints for correct answer: %o \nPoints for incorrect answer: %o\nNumber of questions: %o\nNumber of players: %o\n"
				, Array6[0], Array6[1], Array6[2] , Array6[4] );
		
		
		
		c = project.Catch(c,e);
		Array4 = new int[3][c];
		
		//starts games
		for (b = 0; b != 45 ; b++) {
			
			//runs randomizer
			a = project.Random(a, Array3);

			//generates question based on randomizer output and asks each player for their answer
			for (d = 0; d != c; d++) {

				//question
				System.out.print("Player " + (d + 1));
				System.out.println(" when was " + Array[a] + " president?");

				// answer
				System.out.println("First year: ");	
				Array5[0] = input.nextLine();
				System.out.println("Last year: ");
				Array5[1] = input.nextLine();
				Array5[2] = Array5[0] + "–" + Array5[1];

				//checks answer
				Array4 = project.Score(a, d, Array2, Array4, Array5);

			}// end question loop

		}// end loop for game

		//Prints out score
		for (d = 0; d != c; d++) {
			System.out.println("Player " +  (d + 1) + " score is: " + Array4[0][d]);
		} 

		project.Catch(c, d, Array4);
		
	} // end main

	//catches invalid entry for # of players and retries until valid number is given
	public static int Catch(int c, int e) {

		Scanner input2 = new Scanner(System.in);

		do {
			e = 0;	
			try {
				c = input2.nextInt();
			}
			catch (InputMismatchException | OutOfMemoryError ex) {
				System.out.println("Please enter a valid number of players.");
				e=1;
			} 
			input2.nextLine();
		} while (e == 1 );
		
		return c;

	} // end catch

	//runs outputFile and catches error
	public static void Catch(int c, int d, int Array4[][]) {

		try {
			project.outputFile(c, d, Array4);
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}

	} // end catch

	//Randomizer figures out next question making sure no question is repeated
	public static int Random(int a, int Array3[]) {

		Random r = new Random();
		do {
			a = r.nextInt(45);
		} while (Array3[a] != 0);
		Array3[a] = 1;
		return a;

	} //  end randomizer

	//checks to see if answer given is correct and adjusts score accordingly
	public static int[][] Score(int a, int d, String Array2[], int Array4[][], String Array5[]) {

		if ( Array5[2].equals(Array2[a])) {
			Array4[0][d] += 50;
			Array4[1][d] += 1;
		}

		else {
			Array4[0][d] += -25;
			Array4[2][d] += 1;
		}

		return Array4;

	}// end score checker

	//outputs a file called 'results.txt'
	public static void outputFile(int c, int d, int Array4[][]) throws FileNotFoundException {

		PrintWriter output = new PrintWriter("results.txt");

		for (d = 0; d != c; d++) {
			output.printf("Player %o: %o correct, %o incorrect", d+1, Array4[1][d], Array4[2][d]);
			output.println();
		}
		output.close();

	}// end file output


} //  end class
