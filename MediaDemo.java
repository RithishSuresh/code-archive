package Week8;

// Interface Playable
interface Playable {
    void play();
    void pause();
}

// MusicPlayer class implementing Playable
class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("MusicPlayer: Playing music...");
    }

    @Override
    public void pause() {
        System.out.println("MusicPlayer: Music paused.");
    }
}

// VideoPlayer class implementing Playable
class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("VideoPlayer: Playing video...");
    }

    @Override
    public void pause() {
        System.out.println("VideoPlayer: Video paused.");
    }
}

// Main class
public class MediaDemo {
    public static void main(String[] args) {
        // Polymorphism: Playable reference to MusicPlayer
        Playable player = new MusicPlayer();
        player.play();
        player.pause();

        System.out.println();

        // Polymorphism: Playable reference to VideoPlayer
        player = new VideoPlayer();
        player.play();
        player.pause();
    }
}

