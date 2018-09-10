
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class StringUtilitiesTest {

	@Test(expected=NullPointerException.class)
	public void testReverseWithNull()
	{
		assertEquals( "", new String("").toString());
		new StringUtilities().reverse();
	}
	
	@Test
	public void testReverseWithSingleChar()
	{
		StringUtilities s = new StringUtilities( "z" );
		assertEquals( "z", s.reverse() );
		
	}

	@Test
	public void testReverseWithDoubleSameChar()
	{
		StringUtilities s = new StringUtilities( "zz" );
		assertEquals( "zz", s.reverse() );
		
	}
	
	@Test
	public void testReverseWithEmptyString()
	{
		StringUtilities s = new StringUtilities( "" );
		assertEquals( "", s.reverse() );
		
	}

	@Test
	public void testReverseWithDoubleDifferentChar()
	{
		StringUtilities s = new StringUtilities( "az" );
		assertEquals( "za", s.reverse() );
		
	}
	
	@Test
	public void testReverseWithRandomStuff()
	{
		StringUtilities s = new StringUtilities( "â•¥Ã¦Â±B Ã¨\n" );
		assertEquals( "\n¨Ã B±Â¦Ã¥•â", s.reverse() );
		
	}
	
	@Test
	public void testSetAndToString()
	{
		StringUtilities s = new StringUtilities();
		assertNull( s.toString() );
		
		s.setString("Cow");
		assertEquals( "Cow", s.toString() );
		
		s.setString("1	0234");
		assertEquals( "1	0234", s.toString() );
		
		
		s.setString(null);
		assertNull( s.toString() );
		
	}
	
	
	@Test(expected=NullPointerException.class)
	public void testReverseIndicesWithNull()
	{
		assertEquals( "", new String("").toString());
		new StringUtilities().reverse(0,0);
	}
	
	@Test
	public void testReverseIndicesWithSingleChar()
	{
		StringUtilities s = new StringUtilities( "z" );
		assertEquals( "z", s.reverse(0,1) );
		
	}

	@Test
	public void testReverseIndicesWithDoubleSameChar()
	{
		StringUtilities s = new StringUtilities( "zz" );
		assertEquals( "zz", s.reverse(0,2) );
		
	}
	
	@Test
	public void testReverseIndicesWithEmptyString()
	{
		StringUtilities s = new StringUtilities( "" );
		assertEquals( "", s.reverse(0,0) );
		
	}

	@Test
	public void testReverseIndicesWithDoubleDifferentChar()
	{
		StringUtilities s = new StringUtilities( "az" );
		assertEquals( "za", s.reverse(0,2) );
		
	}
	
	@Test
	public void testReverseIndicesOnlyFirstChar()
	{
		StringUtilities s = new StringUtilities( "az" );
		assertEquals( "a", s.reverse(0,1) );
		
	}
	
	@Test
	public void testReverseIndicesOnlyLastChar()
	{
		StringUtilities s = new StringUtilities( "az" );
		assertEquals( "z", s.reverse(1,2) );
		
	}
	

	@Test
	public void testReverseIndicesMiddleGroup()
	{
		StringUtilities s = new StringUtilities( "alphabet" );
		assertEquals( "ahp", s.reverse(2,5) );
		
	}
	

	@Test (expected = IllegalArgumentException.class)
	public void testReverseIndicesBadFrom()
	{
		StringUtilities s = new StringUtilities( "az" );
		assertEquals( "z", s.reverse(-1,2) );
	}


	@Test (expected = IllegalArgumentException.class)
	public void testReverseIndicesBadTo()
	{
		StringUtilities s = new StringUtilities( "az" );
		assertEquals( "z", s.reverse(1,3) );
	}

	@Test (expected = IllegalArgumentException.class)
	public void testReverseIndicesSmallerToThanFrom()
	{
		StringUtilities s = new StringUtilities( "az" );
		assertEquals( "z", s.reverse(2,1) );
	}

	
	@Test
	public void testReverseIndicesWithRandomStuff()
	{
		StringUtilities s = new StringUtilities( "â•¥Ã¦Â±B Ã¨\n" );
		assertEquals( "\n¨Ã B±Â¦Ã¥•â", s.reverse(0,12) );
		
	}
	
	@Test
	public void testAllUpperWithAllUpper()
	{
		StringUtilities s = new StringUtilities( "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		assertTrue( s.isAllUpper() );
		StringUtilities t = new StringUtilities( "A");
		assertTrue( t.isAllUpper() );
		StringUtilities u = new StringUtilities( "CD");
		assertTrue( u.isAllUpper() );
	}

	@Test
	public void testAllUpperWithAllLower()
	{
		StringUtilities s = new StringUtilities( "abcdefghijklmnopqrstuvwxyz");
		assertFalse( s.isAllUpper() );
		StringUtilities t = new StringUtilities( "a");
		assertFalse( t.isAllUpper() );
		StringUtilities u = new StringUtilities( "cd");
		assertFalse( u.isAllUpper() );
	}
	
	@Test
	public void testAllUpperWithMixedValue()
	{
		StringUtilities s = new StringUtilities( "aBc");
		assertFalse( s.isAllUpper() );
		StringUtilities t = new StringUtilities( "AcD");
		assertFalse( t.isAllUpper() );
		StringUtilities u = new StringUtilities( "0A");
		assertTrue( u.isAllUpper() );
		StringUtilities v = new StringUtilities( "0A99.8");
		assertTrue( v.isAllUpper() );
	}
	
	@Test
	public void testAllLowerWithAllUpper()
	{
		StringUtilities s = new StringUtilities( "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		assertFalse( s.isAllLower() );
		StringUtilities t = new StringUtilities( "A");
		assertFalse( t.isAllLower() );
		StringUtilities u = new StringUtilities( "CD");
		assertFalse( u.isAllLower() );
	}

	@Test
	public void testAllLowerWithAllLower()
	{
		StringUtilities s = new StringUtilities( "abcdefghijklmnopqrstuvwxyz");
		assertTrue( s.isAllLower() );
		StringUtilities t = new StringUtilities( "a");
		assertTrue( t.isAllLower() );
		StringUtilities u = new StringUtilities( "bc");
		assertTrue( u.isAllLower() );
	}
	
	@Test
	public void testAllLowerWithMixedValue()
	{
		StringUtilities s = new StringUtilities( "aBc");
		assertFalse( s.isAllLower() );
		StringUtilities t = new StringUtilities( "AcD");
		assertFalse( t.isAllLower() );
		StringUtilities u = new StringUtilities( "0a");
		assertTrue( u.isAllLower() );
		StringUtilities v = new StringUtilities( "0a99.8");
		assertTrue( v.isAllLower() );
	}
	
	@Test (expected = NullPointerException.class)
	public void testAllLowerWithNull()
	{
		StringUtilities n = new StringUtilities();
		n.isAllLower();
	}
	

	@Test (expected = NullPointerException.class)
	public void testAllUpperWithNull()
	{
		StringUtilities n = new StringUtilities();
		n.isAllUpper();
	}
	
	
	@Test (expected = NullPointerException.class)
	public void testContainsNumbersNull()
	{
		StringUtilities n = new StringUtilities();
		n.containsNumbers();	
	}
	
	@Test
	public void testContainsNumbers()
	{
		StringUtilities n = new StringUtilities( "9");
		assertTrue( n.containsNumbers());
		
		n.setString("a");
		assertFalse( n.containsNumbers() );

		n.setString("a1");
		assertTrue( n.containsNumbers() );
		
		n.setString("0a");
		assertTrue( n.containsNumbers() );
		
		n.setString("a2b");
		assertTrue( n.containsNumbers() );
		
		n.setString("aaaaaaaaaaaaaaa");
		assertFalse( n.containsNumbers() );
		
		n.setString("9393939393939234a");
		assertTrue( n.containsNumbers() );		
	}
	
	@Test (expected = NullPointerException.class)
	public void testIsNumberWithNull()
	{
		StringUtilities n = new StringUtilities();
		n.isNumber();	
	}
	
	@Test
	public void testIsNumberWithWholeNumbers()
	{
		StringUtilities n = new StringUtilities( "9");
		assertTrue( n.isNumber());
		
		n.setString("789456321");
		assertTrue( n.isNumber() );

		n.setString("-789456321");
		assertTrue( n.isNumber() );

		n.setString("-1");
		assertTrue( n.isNumber() );

	}

	@Test
	public void testIsNumberWithDecimalNumbers()
	{
		StringUtilities n = new StringUtilities( "9.5");
		assertTrue( n.isNumber());
		
		n.setString(".39238498234");
		assertTrue( n.isNumber() );

		n.setString("0.1823");
		assertTrue( n.isNumber() );

		n.setString("-1.9382948");
		assertTrue( n.isNumber() );

		n.setString("-92340123098.9382948");
		assertTrue( n.isNumber() );

	}



	@Test
	public void testIsNumberWithDifferentFailures()
	{
		StringUtilities n = new StringUtilities( "9.5a");
		assertFalse( n.isNumber());
		
		n.setString(".392.38498234");
		assertFalse( n.isNumber() );

		n.setString(".");
		assertFalse( n.isNumber() );

		n.setString("-");
		assertFalse( n.isNumber() );

		n.setString("-9234-0123098.9382948");
		assertFalse( n.isNumber() );

	}
	
	@Test (expected = NullPointerException.class)
	public void testNumConsecutiveWithNull()
	{

		StringUtilities n = new StringUtilities( null );
		n.numConsecutiveDuplicates();
	}
	
	@Test
	public void testNumConsecutiveDuplicatesVariety()
	{
		StringUtilities n = new StringUtilities( "9");
		assertEquals( 0, n.numConsecutiveDuplicates() );
		
		n.setString("a");
		assertEquals( 0, n.numConsecutiveDuplicates() );

		n.setString("abcdefa");
		assertEquals( 0, n.numConsecutiveDuplicates() );

		n.setString("aaaaaaaa");
		assertEquals( 7, n.numConsecutiveDuplicates() );

		n.setString("abababababa");
		assertEquals( 0, n.numConsecutiveDuplicates() );

		n.setString("a0a0a00aa");
		assertEquals( 2, n.numConsecutiveDuplicates() );
		
		n.setString("\n\n");
		assertEquals( 1, n.numConsecutiveDuplicates() );

	}
	
	
	@Test (expected = NullPointerException.class)
	public void testNumMatchesCharWithNull()
	{

		StringUtilities n = new StringUtilities( null );
		n.numMatches(' ');
	}
	
	@Test
	public void testNumMatchesChar()
	{
		StringUtilities n = new StringUtilities( "9");
		assertEquals( 1, n.numMatches("9") );
		
		n.setString("a");
		assertEquals( 0, n.numMatches('9') );

		n.setString("abcdefa");
		assertEquals( 2, n.numMatches('a') );

		n.setString("aaaaaaaa");
		assertEquals( 8, n.numMatches('a') );

		n.setString("abababababa");
		assertEquals( 5, n.numMatches('b') );

		n.setString("3a0a0a00aa3");
		assertEquals( 2, n.numMatches('3') );
		
		n.setString("\n\n");
		assertEquals( 2, n.numMatches('\n') );

	}

	
	
	@Test (expected = NullPointerException.class)
	public void testNumMatchesStringWithNull()
	{

		StringUtilities n = new StringUtilities( null );
		n.numMatches("");
	}
	
	@Test
	public void testNumMatchesString()
	{
		StringUtilities n = new StringUtilities( "9");
		assertEquals( 1, n.numMatches("9") );
		
		n.setString("a");
		assertEquals( 0, n.numMatches("aa") );

		n.setString("abcdefa");
		assertEquals( 1, n.numMatches("cde") );

		n.setString("aaaaaaaa");
		assertEquals( 7, n.numMatches("aa") );

		n.setString("abababababa");
		assertEquals( 5, n.numMatches("ab") );

		n.setString("3a0a0a00aa3");
		assertEquals( 1, n.numMatches("3a0a0a00aa3") );
		
		n.setString("\n\n");
		assertEquals( 2, n.numMatches("\n") );

	}


	
	@Test (expected = NullPointerException.class)
	public void testAsArrayWithNull()
	{

		StringUtilities n = new StringUtilities();
		n.asArray();
	}
	
	@Test
	public void testAsArrayMixed()
	{
		StringUtilities n = new StringUtilities( "hello" );
		assertArrayEquals( new char[] {'h','e','l','l','o'}, n.asArray() );
		
		n.setString("");
		assertArrayEquals( new char[] {}, n.asArray());
		
		
		
	}
	
}