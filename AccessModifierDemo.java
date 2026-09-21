package Week5;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    public void testInternalAccess() {
        System.out.println(privateField);
        System.out.println(defaultField);
        System.out.println(protectedField);
        System.out.println(publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(10, "default", 20.5, true);
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
        demo.testInternalAccess();

        SamePackageTest.testAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo demo = new AccessModifierDemo(1, "default", 3.14, false);
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}
