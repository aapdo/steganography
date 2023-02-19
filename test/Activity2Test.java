import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PicLib.Picture;
import PicLib.Pixel;

public class Activity2Test {
	@Test
    public void testCanHide1of2() {
        // create two pictures
        Picture p1 = new Picture(640, 480);
        Picture p2 = new Picture(640, 480);
        // run the test
        assertTrue(Steganography.canHide(p1, p2));
    }
	@Test
    public void testCanHide2of2() {
        // create two pictures
        Picture p1 = new Picture(640, 480);
        Picture p2 = new Picture(641, 479);
        // run the test
        assertFalse(Steganography.canHide(p1, p2));
    }
	@Test   
    public void testHidePicture1of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        assertNotSame(swan, combined);
    }
	@Test
    // tests 2-4 check pixel[100][380] for RGB(77, 49, 44)
    public void testHidePicture2of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[100][380].getRed(), 77);
    }
	@Test
    public void testHidePicture3of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[100][380].getGreen(), 49);
    }
	@Test
    public void testHidePicture4of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[100][380].getBlue(), 44);
    }
	@Test
    // tests 5-7 check pixel[250][225] for RGB(210, 206, 201)
    public void testHidePicture5of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[250][225].getRed(), 210);
    }
	@Test
    public void testHidePicture6of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[250][225].getGreen(), 206);
    }
	@Test
    public void testHidePicture7of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[250][225].getBlue(), 201);
    }
	@Test
    // tests 8-10 check pixel[125][150] for RGB(61, 60, 56)
    public void testHidePicture8of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[125][150].getRed(), 61);
    }
	@Test
    public void testHidePicture9of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[125][150].getGreen(), 60);
    }
	@Test
    public void testHidePicture10of10() {
        // create two pictures
        Picture swan = new Picture("swan.jpg");
        Picture gorge = new Picture("gorge.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(swan, gorge);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[125][150].getBlue(), 56);
    }
}
