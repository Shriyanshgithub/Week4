package org.capgemini.CustomException;

public class CreateCustomException {
    public static void main(String[] args) {
        try{
            //method call
            validateAge(17);
        }catch (InvalidAgeException e){
            //throws exception
            System.out.println(e.getMessage());
        }
    }

    //validates age
    private static void validateAge(int age) throws InvalidAgeException{
        if(age<18)
            //throw new exception if age is below 18
            throw new InvalidAgeException("Age must be 18 or above");

    }
}
