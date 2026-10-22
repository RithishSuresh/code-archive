// Class to store movie details and calculate average rating
class Movie {
    String title;
    int[] ratings;

    Movie(String title, int[] ratings) {
        this.title = title;
        this.ratings = ratings;
    }

    double getAverageRating() {
        int sum = 0;
        for (int r : ratings) sum += r;
        return (double) sum / ratings.length;
    }
}

public class MovieRatings {
    public static void main(String[] args) {
        // Creating an array of Movie objects
        Movie[] movies = {
                new Movie("Inception", new int[]{5, 4, 5, 5, 4}),
                new Movie("Interstellar", new int[]{5, 5, 4, 5, 5}),
                new Movie("Dunkirk", new int[]{4, 4, 3, 5, 4}),
                new Movie("Tenet", new int[]{3, 4, 4, 4, 5})
        };

        // Finding the movie with the best average rating
        Movie bestMovie = movies[0];
        for (Movie m : movies) {
            if (m.getAverageRating() > bestMovie.getAverageRating()) {
                bestMovie = m;
            }
        }

        // Displaying the movie with the best rating
        System.out.println("Best Movie: " + bestMovie.title + " with average rating " + bestMovie.getAverageRating());
    }
}
