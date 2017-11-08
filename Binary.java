import java.io.*;
import java.util.*;

class Binary
{

	public static void main(String[] args)
	{
		System.out.println(bin("1100","00111"));
		System.out.println(bin("1100","0011"));
		System.out.println(bin("1111","1111"));
	}

	public static String bin(String a, String b)
	{
		char [] aArray;
		char [] bArray;
		char [] retArray;
		int carry = 0;
		int maxLen, aPtr, bPtr;

		aArray = a.toCharArray();
		bArray = b.toCharArray();

		maxLen = aArray.length > bArray.length ? aArray.length : bArray.length;

		retArray = new char[maxLen+1];
		aPtr = aArray.length - 1;
		bPtr = bArray.length - 1;

		while(maxLen > 0)
		{
			int curVal = getVal(aArray, aPtr--) + getVal(bArray, bPtr--) + carry;

			if (curVal == 3)
			{
				retArray[maxLen] = '1';
			}
			else if(curVal == 2)
			{
				retArray[maxLen] = '0';
				carry = 1;
			}
			else if (curVal == 1)
			{
				retArray[maxLen] = '1';
				carry = 0;
			}
			else
			{
				retArray[maxLen] = '0';
				carry = 0;
			}
			maxLen--;
		}

		retArray[0] = carry == 1 ? '1' : '0';
		return String.valueOf(retArray);
	}

	public static int getVal(char [] array, int ptr)
	{
		if (ptr < 0)
			return 0;

		if (array[ptr] == '0')
			return 0;
		else
			return 1;
	}
}
