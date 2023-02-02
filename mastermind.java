package mastermind;

//import files
import java.util.Scanner;
import java.util.Random;

//class declaration
public class mastermind 
{//class starts
	
	//import initialize
    static Scanner sc=new Scanner(System.in);
    static Random rand = new Random();
    //sample set and answer
    static String sample[] = {"R","Y","G","B","P","O","V","I"};
	static String answer[]= {"","","",""};
	//upper bound for random
	static int upperbound = 7;

	
	//main method
	public static void main(String args[])
	{//main starts
		//iterating loop
		while(true) 
		{
		System.out.println("=============================");
		//make a random array for answers
		decidearray();
		//start game
		gamesystem();
		System.out.println("=============================");
		System.out.println("Continue playing(Y:1/N:2)? ");
		int ch=sc.nextInt();
		if(ch==1) {
			continue;
		}
		else {
			break;
		}
		}
	}//main ends

    //function to set answer array
	private static void decidearray() 
	{//func starts
		for(int i=0;i<4;i++)
		{	
		//takes element from sample and puts it in answer
	      int int_random = rand.nextInt(upperbound); 
	      answer[i]=sample[int_random];
		}
	}//func ends

    //function to start game
	public static void gamesystem()
	{//game starts
		//initialize game variables
		int ahit,bhit,chit,dhit;
		String a,b,c,d;
		int black,white;
		int tries=1;
		int i=0;
		
		System.out.println("Game starts");
		
		//game loop
		for(;tries>0;tries--) 
		{
			//initialize white and black
			white=0;
			black=0;
			
			System.out.println("Enter guess:");
			
			//input guess
			a=sc.next();
            b=sc.next();
            c=sc.next();
            d=sc.next();
            
            //check if guess is in the array
            ahit=inarray(a);
            bhit=inarray(b);
            chit=inarray(c);
            dhit=inarray(d);
            
            //check if position of guess is correct
            if(ahit==1&&a.equals(answer[0]))
            {
            	white++;
            }
            else if(ahit==1)
            {
            	black++;
            }
            if(bhit==1&&b.equals(answer[1]))
            {
            	white++;
            }
            else if(bhit==1)
            {
            	black++;
            }
            if(chit==1&&c.equals(answer[2]))
            {
            	white++;
            }
            else if(chit==1)
            {
            	black++;
            }
            if(dhit==1&&d.equals(answer[3]))
            {
            	white++;
            }
            else if(dhit==1)
            {
            	black++;
            }
            //game win situation
            if(white==4)
            {
            	System.out.println("Won game");
            	break;
            }
            
            //show status
        	System.out.println("Guess: "+a+" "+b+" "+c+" "+d);
        	System.out.println("White: "+white+"\nBlack: "+black);
		}
		
		//game lose condition
    	System.out.println("Lost game");
    	//print answer
    	System.out.println("Answer: "+answer[0]+" "+answer[1]+" "+answer[2]+" "+answer[3]);
	}//game ends

	//function to see if guess is in the answer array (returns 1 if it is in the array)
	private static int inarray(String a) {//func starts
		for(int i=0;i<4;i++)
		{
			if(a.equals(answer[i]))
			{
				return 1;
			}
		}
		return 0;
	}//func ends

}//class ends
