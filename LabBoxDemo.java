package Week6;
public class LabBoxDemo {
    public static void main(String[] args) {
        GiftBox gift = new GiftBox("Birthday Gift");
        gift.pack();
        System.out.println();
        gift.unpack();
    }
}

class Box {
    protected String content;

    public Box(String content) {
        this.content = content;
    }

    public void pack() {
        System.out.println("Packing the box with: " + content);
    }

    public void unpack() {
        System.out.println("Unpacking the box containing: " + content);
    }
}

class GiftBox extends Box {
    public GiftBox(String content) {
        super(content);
    }

    @Override
    public void pack() {
        super.pack();
        System.out.println("Adding gift wrapping and a ribbon");
    }

    @Override
    public void unpack() {
        super.unpack();
        System.out.println("Surprise! Enjoy your gift");
    }
}

