package main;

import java.util.Scanner;
public class Assignment2 
{
	public static void main(String[] args)
	{
		System.out.println("String?");
		Scanner input=new Scanner(System.in);
		StringScanner s=new StringScanner();
		boolean result=true;
		String ans="";
		while(result)
		{
			ans=input.nextLine();
			s.setScannedString(ans);
			if(ans.charAt(0)=='.')
			{
				System.out.println("Goodbye");
				break;
			}
			
		}
	}
}
