package Service;

import java.util.List;

import ProjectException.*;
import model.*;

public class Validator {
	
	private List<User> users;
	
	public Validator(List<User> users)
	{
		this.users = users;
	}
	
	/**
	 * Check if id number is valid by Israeli law
	 * @param idNumber
	 * @throws Throwable 
	 * @throws Stam 
	 */
	public boolean isValidId(String idNumber) throws InvalidUserIDException
	{
		// check if length of id is valid
		if(idNumber.length() != 9)
			throw new InvalidUserIDException("Missing Or to many numbers in the ID number");
		
		// if not number only throw Exception
		if(!idNumber.matches("[0-9]{9,9}"))
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
			
			if(sum % 10 != 0 )
				throw new InvalidUserIDException("ID Number is not valid");
			
			return true;
	}
	
	/**
	 * Check if the user is exist or one of the parameters
	 * @param users
	 * @param user
	 * @return
	 * @throws InvalidUserException
	 */
	public void isValidNewUser(User user) throws InvalidUserException
	{
		if(users == null || users.isEmpty())
			return;
		
		for(User checkUser : users)
		{
			if(checkUser.equals(user))
				throw new InvalidUserException("The User is exist");
			
			if(checkUser.getName().compareTo(user.getName()) == 0)
				throw new InvalidUserException("The Username is exist");
			
			if(checkUser.getEmail().compareTo(user.getEmail()) == 0)
				throw new InvalidUserException("The User Email is exist");
			
			if(checkUser.getTel().compareTo(user.getTel()) == 0)
				throw new InvalidUserException("The User Phone is exist");
		}
		//return true;
	}
	
	public boolean isValidEmail(String email) throws InvalidEmailAddressException
	{
		String reg = "([a-zA-Z0-9]+([\\.+_-][a-zA-Z0-9]+)*)@(([a-zA-Z0-9]+((\\.|[-]{1,2})[a-zA-Z0-9]+)*)\\.[a-zA-Z]{2,6})";
		
		if(!email.matches(reg))
			throw new InvalidEmailAddressException("The currect Email format\n user@domain.com");
		
		return true;
	}
	
	public boolean isValidPhoneNumber(String phone) throws InvalidTelNumberFormatException
	{
		String reg = "^0(([57]\\d)|[23489])-?[2-9]\\d{6}$";
		
		if(!phone.matches(reg))
			throw new InvalidTelNumberFormatException("The Phone number is not valid");
		
		return true;
	}
	
	public boolean isValidPassword(String password) throws InvalidPassword
	{
		if(password.length() < 6 )
			throw new InvalidPassword("Password is too short");
		
		if(password.length() > 20)
			throw new InvalidPassword("Password is too long");
		
		return true;
	}
}
