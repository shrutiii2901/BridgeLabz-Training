class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("This is a deprecated method.");
    }

    public void newFeature() {
        System.out.println("This is the new method to use.");
    }
}

public class LegacyAPITest {

    
    public static void main(String[] args) {
        LegacyAPI test = new LegacyAPI();
        test.oldFeature();  
        test.newFeature();
    }
}
