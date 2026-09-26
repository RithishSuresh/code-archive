class Artwork {
    String title;
    Artwork(String title) { this.title = title; }
    void showDetails() { System.out.println("Artwork: " + title); }
}

class PaintingArtwork extends Artwork {
    String brushTechnique;
    String colorPalette;
    String frameSpecs;

    PaintingArtwork(String title, String brushTechnique, String colorPalette, String frameSpecs) {
        super(title);
        this.brushTechnique = brushTechnique;
        this.colorPalette = colorPalette;
        this.frameSpecs = frameSpecs;
    }

    void showDetails() {
        System.out.println("Painting: " + title + ", Brush: " + brushTechnique + ", Colors: " + colorPalette + ", Frame: " + frameSpecs);
    }

    void displayTechnique() {
        System.out.println("Displaying brush technique for " + title);
    }
}

class SculptureArtwork extends Artwork {
    String material;
    String dimensions;
    String lighting;

    SculptureArtwork(String title, String material, String dimensions, String lighting) {
        super(title);
        this.material = material;
        this.dimensions = dimensions;
        this.lighting = lighting;
    }

    void showDetails() {
        System.out.println("Sculpture: " + title + ", Material: " + material + ", Dimensions: " + dimensions + ", Lighting: " + lighting);
    }

    void setupDisplay() {
        System.out.println("Setting up sculpture display for " + title);
    }
}

class DigitalArtwork extends Artwork {
    String resolution;
    String fileFormat;
    boolean interactive;

    DigitalArtwork(String title, String resolution, String fileFormat, boolean interactive) {
        super(title);
        this.resolution = resolution;
        this.fileFormat = fileFormat;
        this.interactive = interactive;
    }

    void showDetails() {
        System.out.println("Digital Art: " + title + ", Resolution: " + resolution + ", Format: " + fileFormat + ", Interactive: " + (interactive ? "Yes" : "No"));
    }

    void enableInteraction() {
        System.out.println("Enabling interactive elements for " + title);
    }
}

class PhotographyArtwork extends Artwork {
    String cameraSettings;
    String editingDetails;
    String printSpecs;

    PhotographyArtwork(String title, String cameraSettings, String editingDetails, String printSpecs) {
        super(title);
        this.cameraSettings = cameraSettings;
        this.editingDetails = editingDetails;
        this.printSpecs = printSpecs;
    }

    void showDetails() {
        System.out.println("Photography: " + title + ", Camera: " + cameraSettings + ", Editing: " + editingDetails + ", Print: " + printSpecs);
    }

    void printPhoto() {
        System.out.println("Printing photograph " + title);
    }
}

public class DigitalArtGallery {
    public static void main(String[] args) {
        Artwork[] gallery = {
                new PaintingArtwork("Starry Night", "Impasto", "Blue & Yellow", "Gold Frame"),
                new SculptureArtwork("David", "Marble", "17ft", "Spotlight"),
                new DigitalArtwork("Virtual Landscape", "4K", "MP4", true),
                new PhotographyArtwork("Moonrise", "f/8, 1/125s", "Edited in Lightroom", "24x36 inches")
        };

        for (Artwork a : gallery) {
            a.showDetails();

            if (a instanceof PaintingArtwork) {
                PaintingArtwork p = (PaintingArtwork) a;
                p.displayTechnique();
            } else if (a instanceof SculptureArtwork) {
                SculptureArtwork s = (SculptureArtwork) a;
                s.setupDisplay();
            } else if (a instanceof DigitalArtwork) {
                DigitalArtwork d = (DigitalArtwork) a;
                d.enableInteraction();
            } else if (a instanceof PhotographyArtwork) {
                PhotographyArtwork ph = (PhotographyArtwork) a;
                ph.printPhoto();
            }

            System.out.println();
        }
    }
}
