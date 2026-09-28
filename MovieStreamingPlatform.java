package Week7;
class Content {
    String title;
    Content(String title) { this.title = title; }
    void showInfo() { System.out.println("Content: " + title); }
}

class StreamMovie extends Content {
    double rating;
    int duration;
    boolean subtitles;
    StreamMovie(String title, double rating, int duration, boolean subtitles) {
        super(title);
        this.rating = rating;
        this.duration = duration;
        this.subtitles = subtitles;
    }
    void showInfo() {
        System.out.println("Movie: " + title + ", Rating: " + rating + ", Duration: " + duration + " mins, Subtitles: " + (subtitles ? "Yes" : "No"));
    }
    void playTrailer() { System.out.println("Playing movie trailer for " + title); }
}

class StreamTVSeries extends Content {
    int seasons;
    int episodes;
    String nextEpisode;
    StreamTVSeries(String title, int seasons, int episodes, String nextEpisode) {
        super(title);
        this.seasons = seasons;
        this.episodes = episodes;
        this.nextEpisode = nextEpisode;
    }
    void showInfo() {
        System.out.println("TV Series: " + title + ", Seasons: " + seasons + ", Episodes: " + episodes + ", Next: " + nextEpisode);
    }
    void watchNextEpisode() { System.out.println("Watching next episode of " + title); }
}

class StreamDocumentary extends Content {
    String tags;
    String relatedContent;
    StreamDocumentary(String title, String tags, String relatedContent) {
        super(title);
        this.tags = tags;
        this.relatedContent = relatedContent;
    }
    void showInfo() {
        System.out.println("Documentary: " + title + ", Tags: " + tags + ", Related: " + relatedContent);
    }
    void exploreRelated() { System.out.println("Exploring related content for " + title); }
}

public class MovieStreamingPlatform {
    public static void main(String[] args) {
        Content[] watchlist = {
                new StreamMovie("Inception", 8.8, 148, true),
                new StreamTVSeries("Stranger Things", 4, 34, "Season 5 Episode 1"),
                new StreamDocumentary("Planet Earth", "Nature, Wildlife", "Blue Planet")
        };

        for (Content c : watchlist) {
            c.showInfo();

            if (c instanceof StreamMovie) {
                StreamMovie m = (StreamMovie) c;
                m.playTrailer();
            } else if (c instanceof StreamTVSeries) {
                StreamTVSeries t = (StreamTVSeries) c;
                t.watchNextEpisode();
            } else if (c instanceof StreamDocumentary) {
                StreamDocumentary d = (StreamDocumentary) c;
                d.exploreRelated();
            }

            System.out.println();
        }
    }
}

