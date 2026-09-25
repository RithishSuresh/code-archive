package Week6;
public class LabBirdDemo {
    public static void main(String[] args) {
        Bird[] birds = new Bird[2];

        birds[0] = new Penguin();
        birds[1] = new Eagle();

        for (Bird bird : birds) {
            bird.fly();
        }
    }
}

class Bird {
    public void fly() {
        System.out.println("Bird is flying in the sky");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin can't fly but swims in water");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky");
    }
}

