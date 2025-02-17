package org.capgemini.Excercise_1;

////Create a parent class Animal
class Animal{
    //method makeSound()
    void makeSound(){
        System.out.println("Animal make sound");
    }
}

//create a Dog class that extends animal class
class Dog extends Animal{
    // overrides method
    @Override
    void makeSound(){
        System.out.println("Dog make sound Baow baow");
    }
}

public class UseOverride {
    public static void main(String[] args) {
        //Instantiate Dog and call makeSound().
        Animal animal = new Dog();
        animal.makeSound();
    }
}
