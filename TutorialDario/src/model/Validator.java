package model;

import ProjectException.*;

public class Validator {
	
	/**
	 * Check if id number is valid by Israeli law
	 * @param idNumber
	 * @throws Throwable 
	 * @throws Stam 
	 */
	public static boolean isValidId(String idNumber) throws InvalidUserIDException
	{
		// check if length of id is valid
		if(idNumber.length() != 9)
			throw new InvalidUserIDException("Missing Or to many numbers in the ID number");
		
		// if not number only throw Exception
		if(!idNumber.matches("[0-9]"))
			throw new InvalidUserIDException("Mast to be digit only");
			
			int sum = 0;		
			for(int index = 0 ; index < idNumber.length() ; index++)
			{
				if( index % 2 == 0)
					sum += idNumber.charAt(index) - '0';
				else
				{
					int temp = (idNumber.charAt(index) -'0') * 2;
					sum += temp / 10 + temp % 10; 
					
				}
			}
			
			System.out.println("Valid Func: " + sum);
			if(sum % 10 != 0 )
				throw new InvalidUserIDException("ID Number is not valid");
			
			return true;
	}

}
