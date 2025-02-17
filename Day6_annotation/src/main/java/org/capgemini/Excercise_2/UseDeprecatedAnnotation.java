package org.capgemini.Excercise_2;

//Define a class LegacyAPI
class LegacyAPI{
    //Use @Deprecated to Mark an Old Method
    @Deprecated
    void oldFeature(){
        System.out.println("It is the old feature");
    }
  // newFeaturre method
    void newFeature(){
        System.out.println("It is the new feature");
    }
}

public class UseDeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI legacyAPI = new LegacyAPI();
        //this show the warning because it is deprecated
        legacyAPI.oldFeature();
        //call new Feature method
        legacyAPI.newFeature();
    }
}



