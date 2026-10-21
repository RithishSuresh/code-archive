// Class to store movie details and calculate average rating
class Film {
    String title;
    int[] ratings;

    Film(String title, int[] ratings) {
        this.title = title;
        this.ratings = ratings;
    }

    double getAverageRating() {
        int sum = 0;
        for (int r : ratings) sum += r;
        return (double) sum / ratings.length;
    }
}

public class MovieTest {
    public static void main(String[] args) {
        // Creating an array of Film objects
        Film[] films = {
                new Film("Vikram", new int[]{9, 8, 10, 9, 8}),
                new Film("Kaithi", new int[]{10, 9, 9, 10, 10}),
                new Film("Coolie", new int[]{8, 7, 8, 9, 7}),
                new Film("Leo", new int[]{7, 8, 8, 8, 9})
        };

        // Finding the film with the best average rating
        Film bestFilm = films[0];
        for (Film f : films) {
            if (f.getAverageRating() > bestFilm.getAverageRating()) {
                bestFilm = f;
            }
        }

        // Displaying the film with the best rating
        System.out.println("Best Film: " + bestFilm.title + " with average rating " + bestFilm.getAverageRating());
    }
}


