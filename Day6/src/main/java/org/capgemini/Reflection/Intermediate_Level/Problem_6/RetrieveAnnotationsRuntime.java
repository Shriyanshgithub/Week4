package org.capgemini.Reflection.Intermediate_Level.Problem_6;

public class RetrieveAnnotationsRuntime {
    public static void main(String[] args) {
        try{
            //get class reference
            Class<?> cl = Class.forName("org.capgemini.Reflection.Intermediate_Level.Problem_6.Book");

            //retrieve the annotation
            Author author = cl.getAnnotation(Author.class);

            //display annotation value
            if(author != null){
                System.out.println("author name ; " + author.value());
            }
            else{
                System.out.println("No @Author annotation found");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
@Author(value = "John Doe")
class Book{
    private String title;

    public Book(String title) {
        this.title = title;
    }
}
