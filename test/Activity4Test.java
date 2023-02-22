import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PicLib.Picture;
import PicLib.Pixel;

public class Activity4Test{
	@Test
    public void testHideText1of5() {
        // create a picture 
        Picture test = new Picture("beach.jpg");
        // run the test
        Picture hidden = Steganography.hideText(test, "HAVE FUN STORMING THE CASTLE");
        assertNotSame(test, hidden);
    }
	@Test	   
    public void testHideText2of5() {
    	// create a picture
        Picture test = new Picture("beach.jpg");
        // run the test
        Picture hidden = Steganography.hideText(test, "HAVE FUN STORMING THE CASTLE");
        Pixel[][] pixels = hidden.getPixels2D();
        // 'V' (2, 1, 1) should be stored in 3rd pixel of the 1st row
        assertTrue(pixels[0][2].getRed() % 4 == 2 && pixels[0][2].getGreen() % 4 == 1 &&
                   pixels[0][2].getBlue() % 4 == 1);
    }
	@Test
    public void testHideText3of5() {
    	// create a picture
        Picture test = new Picture("beach.jpg");
        // run the test
        Picture hidden = Steganography.hideText(test, "HAVE FUN STORMING THE CASTLE");
        Pixel[][] pixels = hidden.getPixels2D();
        // end of message (0, 0, 0) should be stored in 29th pixel of the 1st row
        assertTrue(pixels[0][28].getRed() % 4 == 0 && pixels[0][28].getGreen() % 4 == 0 &&
                   pixels[0][28].getBlue() % 4 == 0);
    }
	@Test
    public void testHideText4of5() {
    	// create a picture
        Picture test = new Picture("beach.jpg");
        // run the test
        Picture hidden = Steganography.hideText(test, "HAVE FUN STORMING THE CASTLE");
        Pixel[][] source = test.getPixels2D();
        Pixel[][] pixels = hidden.getPixels2D();
        // no pixels after 30th pixel of the 1st row should have changed
        System.out.println("pixels[0][29].getRed() == source[0][29].getRed() = " + (pixels[0][29].getBlue() == source[0][29].getBlue()));
        assertTrue(pixels[0][29].getRed() == source[0][29].getRed() && 
        		   pixels[0][29].getGreen() == source[0][29].getGreen() &&
                   pixels[0][29].getBlue() == source[0][29].getBlue());
    }
	@Test
    public void testHideText5of5() {
    	// create a picture
        Picture test = new Picture("robot.jpg");
        // run the test 
        String text = "Hello My name is Inigo Montoya you killed my father prepare to die ";
        text += text;
        text += text;
        text = text.trim();
        Picture hidden = Steganography.hideText(test, text);
        Pixel[] source = test.getPixels();
        Pixel[] pixels = hidden.getPixels();
        // count the number of pixels that were modified
        int changed = 1;  // always have a trailing 0
        for (int i = 0; i < source.length; i++) {
        	if (source[i].getRed() != pixels[i].getRed() || 
        	    source[i].getGreen() != pixels[i].getGreen() || 
        	    source[i].getBlue() != pixels[i].getBlue()) {
        		changed++;
        	}
        }
        assertEquals(234, changed);
    }
	@Test
    public void testRevealText1of3() {
    	// create a picture
        Picture test = new Picture("beach.jpg");
        // run the test
        String text = "HAVE FUN STORMING THE CASTLE";
        Picture hidden = Steganography.hideText(test, text);
        String revealed = Steganography.revealText(hidden);
        assertEquals(text, revealed);
    }
	@Test
    public void testRevealText2of3() {
    	// create a picture
        Picture test = new Picture("robot.jpg");
        // run the test
        String text = "The greatest glory in living lies not in never falling but in rising every time we fall";
        text += text;
        text += text;
        text = text.trim();
        Picture hidden = Steganography.hideText(test, text);
        String revealed = Steganography.revealText(hidden);
        assertEquals(text, revealed);
    }
	@Test
    public void testRevealText3of3() {
    	// create a picture
        Picture test = new Picture("robot.jpg");
        // run the test
        String text = "The greatest glory in living lies not in never falling but in rising every time we fall";
        text += text + text + text;
        text += text + text + text;
        text += text + text + text;
        text = text.trim();
        System.out.println("text.length() = " + text.length());
        System.out.println("test.getPixels().length = " + test.getPixels().length);
        Picture hidden = Steganography.hideText(test, text);
        String revealed = Steganography.revealText(hidden);
        assertEquals(test.getWidth() * test.getHeight(), revealed.length());
    }
}
