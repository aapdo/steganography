import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PicLib.Picture;
import PicLib.Pixel;

import java.awt.Color;

public class Activity1Test {
	@Test
    public void testClearLow() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // get an array of the pixels
        Pixel[] pixels = test.getPixels();
        // pick a pixel at random
        int i = (int)(Math.random() * pixels.length);
        Pixel p = pixels[i];
        // run the test
        Steganography.clearLow(p);
        int sum = p.getRed() % 4 + p.getGreen() % 4 + p.getBlue() % 4;
        assertEquals(0, sum);
    }
	@Test
    public void testTestClearLow1of2() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // run the test
        Picture copy = Steganography.testClearLow(test);
        assertEquals(test.getPixels2D().length, copy.getPixels2D().length);
    }
	@Test
    public void testTestClearLow2of2() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // build a copy of the picture whose pixels have all been "cleared"
        Picture copy = Steganography.testClearLow(test);
        // get an array of the pixels
        Pixel[] pixels = copy.getPixels();
        // run the test
        int sum = 0;
        for (Pixel p : pixels) {
            sum += p.getRed() % 4 + p.getGreen() % 4 + p.getBlue() % 4;
        }
        assertEquals(0, sum);
    }
	@Test
    public void testSetLow1of3() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // create a color
        Color c = new Color(65, 129, 193);
        // get an array of the pixels
        Pixel[] pixels = test.getPixels();
        // pick a pixel at random
        int i = (int)(Math.random() * pixels.length);
        Pixel p = pixels[i];
        // run the test
        Steganography.setLow(p, c);
        assertEquals(1, p.getRed() % 4);
    }
	@Test
    public void testSetLow2of3() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // create a color
        Color c = new Color(65, 129, 193);
        // get an array of the pixels
        Pixel[] pixels = test.getPixels();
        // pick a pixel at random
        int i = (int)(Math.random() * pixels.length);
        Pixel p = pixels[i];
        // run the test
        Steganography.setLow(p, c);
        assertEquals(2, p.getGreen() % 4);
    }
	@Test
    public void testSetLow3of3() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // create a color
        Color c = new Color(65, 129, 193);
        // get an array of the pixels
        Pixel[] pixels = test.getPixels();
        // pick a pixel at random
        int i = (int)(Math.random() * pixels.length);
        Pixel p = pixels[i];
        // run the test
        Steganography.setLow(p, c);
        assertEquals(3, p.getBlue() % 4);
    }
	@Test
    public void testTestSetLow1of2() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // run the test
        Picture copy = Steganography.testSetLow(test, new Color(0, 0, 0));
        assertEquals(test.getPixels2D().length, copy.getPixels2D().length);
    }
	@Test
    public void testTestSetLow2of2() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // build a copy of the picture whose pixels have all been set to a color
        Color c = new Color(65, 129, 193);
        Picture copy = Steganography.testSetLow(test, c);
        // get an array of the pixels
        Pixel[] pixels = copy.getPixels();
        // run the test
        int sum = 0;
        for (Pixel p : pixels) {
            sum += p.getRed() % 4 + p.getGreen() % 4 + p.getBlue() % 4;
        }
        int expected = 6 * pixels.length;
        assertEquals(expected, sum);
    }
	@Test   
    public void testRevealPicture1of2() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // run the test
        Picture copy = Steganography.revealPicture(test);
        
        assertEquals(test.getPixels2D().length, copy.getPixels2D().length);
    }
	@Test
    public void testRevealPicture2of2() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // build a copy of the picture whose pixels have all been set to a color
        Color c = new Color(65, 129, 193);
        Picture copy = Steganography.testSetLow(test, c);
        // run the test
        Picture reveal = Steganography.revealPicture(copy);
        Pixel[] pixels = reveal.getPixels();
        int sum = 0;
        for (Pixel p : pixels) {
            sum += p.getRed() / 64 + p.getGreen() / 64 + p.getBlue() / 64;
        }
        int expected = 6 * pixels.length;
        assertEquals(expected, sum);
    }

}
