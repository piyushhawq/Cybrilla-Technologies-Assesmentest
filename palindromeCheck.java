import java.util.*;   
public class PalindromeCheck {

	
	  public static void main(String[] args) {

		  String str, reverseStr = ""; 
	      Scanner in = new Scanner(System.in);   
	      System.out.println("Enter a string to check if it is a palindrome:- ");  
	      str = in.nextLine();   

	    
	    int strLength = str.length();

	    for (int i = (strLength - 1); i >=0; --i) {
	      reverseStr = reverseStr + str.charAt(i);
	    }

	    if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
	      System.out.println("true");
	    }
	    else {
	      System.out.println("false");
	    }
	  }
	}
