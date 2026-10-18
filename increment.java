public class increment {
    public static void main(String[] args) {
        int i = 5;
        System.out.println("Initial i = " + i);
        int post = i++;  //Post-increment-assign the old value,then increment
        System.out.println("After post-increment:");
        System.out.println(" post = " + post);
        System.out.println(" i = " + i);
        int pre = ++i;  // Pre-increment-increment first,then it will assign
        System.out.println("After pre-increment:");
        System.out.println(" pre = " + pre);
        System.out.println(" i = " + i);
    }
}

