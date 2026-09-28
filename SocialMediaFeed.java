class Post {
    String author;
    String content;
    String time;

    Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    void display() {
        System.out.println("Author: " + author + "\nContent: " + content + "\nTime: " + time);
    }
}

class InstagramPost extends Post {
    int likes;
    String hashtags;

    InstagramPost(String author, String content, String time, int likes, String hashtags) {
        super(author, content, time);
        this.likes = likes;
        this.hashtags = hashtags;
    }

    void display() {
        System.out.println("Instagram Post\nAuthor: " + author + "\n" + content + "\n" + hashtags + "\nLikes: " + likes + "\nTime: " + time);
    }
}

class TwitterPost extends Post {
    int retweets;

    TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    void display() {
        System.out.println("Twitter Post\n@" + author + ": " + content + "\nCharacters: " + content.length() + "\nRetweets: " + retweets + "\nTime: " + time);
    }
}

class LinkedInPost extends Post {
    int connections;

    LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    void display() {
        System.out.println("LinkedIn Post\nAuthor: " + author + "\n" + content + "\nConnections: " + connections + "\nPosted at: " + time);
    }
}

public class SocialMediaFeed {
    public static void main(String[] args) {
        Post insta = new InstagramPost("Alice", "Enjoying the beach!", "10:30 AM", 120, "#sunset #beachlife");
        Post twitter = new TwitterPost("Bob", "Just watched a great movie!", "11:00 AM", 45);
        Post linkedin = new LinkedInPost("Charlie", "Excited to start a new job at XYZ Corp!", "12:00 PM", 500);

        insta.display();
        System.out.println();
        twitter.display();
        System.out.println();
        linkedin.display();
    }
}
