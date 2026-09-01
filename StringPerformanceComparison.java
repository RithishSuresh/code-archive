public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");


        long startTime = System.nanoTime();
        String result1 = concatenateWithString(1000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        System.out.println("\n=== StringBuilder Methods Demo ===");
        demonstrateStringBuilderMethods();

        System.out.println("\n=== String Comparison Demo ===");
        compareStringComparisonMethods();
    }


    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }


    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }


    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }


    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");

        sb.append(" Java");              // append
        sb.insert(6, "Beautiful ");      // insert
        sb.delete(0, 6);                 // delete
        sb.deleteCharAt(5);              // deleteCharAt
        sb.reverse();                    // reverse
        sb.replace(0, 5, "Hey");         // replace
        sb.setCharAt(2, 'X');            // setCharAt
        System.out.println("Final StringBuilder content: " + sb);

        System.out.println("Capacity: " + sb.capacity());
        sb.ensureCapacity(50);
        System.out.println("After ensureCapacity(50): " + sb.capacity());
        sb.trimToSize();
        System.out.println("After trimToSize(): " + sb.capacity());
    }


    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("== comparison (str1 == str2): " + (str1 == str2));
        System.out.println("== comparison (str1 == str3): " + (str1 == str3));
        System.out.println("equals(): " + str1.equals(str3));
        System.out.println("equalsIgnoreCase(): " + str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo(): " + str1.compareTo("World"));
        System.out.println("compareToIgnoreCase(): " + str1.compareToIgnoreCase("hello"));
    }
}

