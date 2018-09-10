/** 
 * A class that performs simple calculates on a given stored String
 * @author MeermaBR and <Your Name>
 * @version 9/4/18
 */
public class StringUtilities
{
   private String string;
   
   /**
    * Builds an empty (null) StringUtilities
    */
   public StringUtilities()
   {
       string = null;
   }

   /**
    * Builds a StringUtilities with the given String value
    * @param string The string to be stored for manipulation
    */
   public StringUtilities( String string )
   {
       this.string = string;
   }
   
   /**
    * Changes the stored String
    * @param string The new value for the String to become
    */
   public void setString( String string )
   {
	   this.string = string;
   }   
   
   /**
    * Returns the value of the String
    * @return The value of the String or null if the String is null
    */
   public String toString()
   {
	   return string;
   }
   
   /**
    * Calculates a reversed value of the stored String
    * @return A new String with all values reversed
    * @throws NullPointerException if the original String is null
    */
   public String reverse()
   {
	   nullCheck();
	   
	   StringBuilder builder = new StringBuilder();
	   for ( int i = string.length() - 1; i >= 0; i-- )
	   {
		   builder.append(string.charAt( i ) );
	   }
	   return builder.toString();
   }

   /**
    * Calculates a reversed value of a subsection of the String
    * @param from The index to begin at (inclusive)
    * @param to The index to stop at (exclusive)
    * @return A new String with all values reversed between index 
    * from (inclusive) and to (exclusive)
    * @throws NullPointerException if the original String is null
    * @throws IllegalArgumentException if the given indices are not valid
    */
   public String reverse(int from, int to)
   {
	   nullCheck();
	   
	   if ( from < 0 || to > string.length() || from > to )
	   {
		   throw new IllegalArgumentException();
	   }
	   
	   StringUtilities temp = new StringUtilities( string.substring(from,  to ) );
	   
	   return temp.reverse();
   }
   
   /**
    * Determines if all the alpha-characters in the string are Uppercase
    * @return True if all alpha-characters in the string are Uppercase
    * @throws NullPointerException if the original String is null
    */
   public boolean isAllUpper()
   {
	   nullCheck();
	   
	   return string.equals( string.toUpperCase() );
   }

   /**
    * Determines if all the alpha-characters in the string are Lowercase
    * @return True if all alpha-characters in the string are Lowercase
    * @throws NullPointerException if the original String is null
    */
   public boolean isAllLower()
   {
	   nullCheck();
	   
	   return string.equals( string.toLowerCase() );
   }

   /**
    * Determines if any of the characters in the string are numeric (0-9)
    * @return True if any 0-9 character is in the string
    * @throws NullPointerException if the original String is null
    */
   public boolean containsNumbers()
   {

	   nullCheck();
	   
	   return string.matches( ".*[0-9].*");
   }
   
   /**
    * Determines if the String itself is storing a number.
    * A number can start with a negative sign (-), may
    * contains one period (.), and otherwise is made only
    * of digits from 0-9.
    * @return True if the entire string is a number
    * @throws NullPointerException if the original String is null
    */
   public boolean isNumber()
   {
	   return containsNumbers() && string.matches( "-?[0-9]*\\.?[0-9]*");
   }
   
   /**
    * Counts the number of characters which have the same value
    * next to them. ie: Meow = 0, Moo = 1, Shhhh! = 3 
    * @return The number of consecutive duplicates found
    * @throws NullPointerException if the original String is null
    */
   public int numConsecutiveDuplicates()
   {
	   nullCheck();
	   
	   int numMatches = 0;
	   for ( int i = 1; i < string.length(); i++ )
	   {
		   if ( string.charAt(i-1) == string.charAt(i) )
		   {
			   numMatches++;
		   }
	   }
	   return numMatches;
   }
   
   /**
    * Counts the number of times a given char is in the String
    * @param c The char to be counted
    * @return The number of times the char is in the String
    * @throws NullPointerException if the original String is null
    */
   public int numMatches( char c )
   {
	   return numMatches( String.valueOf( c ) );
   }
   
   /**
    * Counts the number of times a given String is found in the original
    * @param other The string to be looked for
    * @return The number of times other is in the original String
    * @throws NullPointerException if either the original or other string are null
    */
   public int numMatches( String other )
   {
	   nullCheck();
	   int num = 0;
	   int len = other.length();
	   
	   for ( int i = len; i <= string.length(); i++ )
	   {
		   if ( string.substring( i - len, i).equals( other ) )
		   {
			   num++;
		   }
	   }
	   return num;
   }

   /**
    * Calculates an array version of the String, with each slot a char 
    * @return An array conversion of the String
    * @throws NullPointerException if the String is null.
    */
   public char [] asArray()
   {
	   nullCheck();
	   return string.toCharArray();
   }
   
   public void nullCheck()
   {
	   if ( string  == null ) {
		   throw new NullPointerException();
	   }
   }
   
}