import java.util.Scanner;
import java.util.Vector;

public class MyClass {

    public static void main(String[] args) 
    {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input string to unpack");
        String s = keyboard.next();
        String res = "";
        int counter = 0;
        Vector<Integer> mul = new Vector<>();

        if (checkStr(s))
        {
		    for (int i = 0; i < s.length(); ++i)
		    {
			    char sym = s.charAt(i);
			    if ((sym >= '0') && (sym <= '9'))
			    {
				    counter = counter * 10 + (sym - '0');
				    if ((s.charAt(i+1) >= '0') && (s.charAt(i+1) <= '9')) {}
				    else
				    {
					    mul.add(counter);
					    counter = 0;
				    }
			    }
			    else if (sym != '[' && sym != ']')
			    {
			        res += sym;
			    }
			    else if (sym == ']')
			    {
				    res += res.repeat(mul.get(mul.size()-1)-1);
				    mul.remove(mul.size()-1);
			    }
		    }
		    System.out.println(res);
        }
        else
        {
            System.out.println("expression error!!!");
        }
	}
	static boolean checkStr(String s) 
	{
	    int rBr = 0, lBr = 0;
	    for (int i = 0; i < s.length(); ++i)
	    {
	        char sym = s.charAt(i);
	        if (sym == '[')
	        {
	            lBr += 1;
	        }
	        else if (sym == ']')
	        {
	            rBr += 1;
	        }
	        else if ((sym >= 'a' && sym <= 'z') || (sym >= 'A' && sym <= 'Z')) {}
	        else if ((sym >= '0') && (sym <= '9')) {}
	        else
	        {
	            return false;
	        }
	        if (i == s.length() -1 && lBr != rBr) 
	        {
	            return false;
	        }
	    }
	    return true;
	}
}
