import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PicLib.Picture;
import PicLib.Pixel;
import PicLib.Point;

import java.util.ArrayList;


public class Activity3Test{
	@Test
    public void testCanHide1of5() {
        // create two pictures
        Picture p1 = new Picture(640, 480);
        Picture p2 = new Picture(100, 100);
        // run the test
        assertTrue(Steganography.canHide(p1, p2, 0, 0));
    }
	@Test
    public void testCanHide2of5() {
        // create two pictures
        Picture p1 = new Picture(640, 480);
        Picture p2 = new Picture(100, 100);
        // run the test
        assertFalse(Steganography.canHide(p1, p2, -1, 0));
    }
	@Test
    public void testCanHide3of5() {
        // create two pictures
        Picture p1 = new Picture(640, 480);
        Picture p2 = new Picture(100, 100);
        // run the test
        assertFalse(Steganography.canHide(p1, p2, 0, -1));
    }
	@Test
    public void testCanHide4of5() {
        // create two pictures
        Picture p1 = new Picture(640, 480);
        Picture p2 = new Picture(100, 100);
        // run the test
        assertTrue(Steganography.canHide(p1, p2, 400, 0));
    }
	@Test 
    public void testCanHide5of5() {
        // create two pictures
        Picture p1 = new Picture(640, 480);
        Picture p2 = new Picture(100, 100);
        // run the test
        assertFalse(Steganography.canHide(p1, p2, 0, 600));
    }
	@Test  
    public void testHidePicture1of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 0, 0);
        assertNotSame(beach, combined);
    }
	@Test
    // tests 2-4 check pixel[325][150] for RGB(23, 23, 15)
    public void testHidePicture2of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[325][150].getRed(), 23);
    }
	@Test
    public void testHidePicture3of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[325][150].getGreen(), 23);
    }
	@Test
    public void testHidePicture4of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[325][150].getBlue(), 15);
    }
	@Test
    // tests 5-7 check pixel[375][175] for RGB(48, 47, 36)
    public void testHidePicture5of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[375][175].getRed(), 48);
    }
	@Test
    public void testHidePicture6of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[375][175].getGreen(), 47);
    }
	@Test
    public void testHidePicture7of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[375][175].getBlue(), 36);
    }
	@Test
    // tests 8-10 check pixel[125][225] for RGB(168, 206, 229)
    public void testHidePicture8of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[125][225].getRed(), 168);
    }
	@Test
    public void testHidePicture9of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[125][225].getGreen(), 206);
    }
	@Test
    public void testHidePicture10of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[125][225].getBlue(), 229);
    }
	@Test
    // tests 11-13 check pixel[85][225] for RGB(159, 196, 231)
    public void testHidePicture11of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[85][225].getRed(), 159);
    }
	@Test
    public void testHidePicture12of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[85][225].getGreen(), 196);
    }
	@Test
    public void testHidePicture13of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[85][225].getBlue(), 231);
    }
	@Test
    // tests 14-16 check pixel[100][100] for RGB(160, 204, 231)
    public void testHidePicture14of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[100][100].getRed(), 160);
    }
	@Test
    public void testHidePicture15of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[100][100].getGreen(), 204);
    }
	@Test
    public void testHidePicture16of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, flower, 280, 110);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[100][100].getBlue(), 231);
    }
	@Test
    // tests 17-19 check pixel[400][400] for RGB(80, 62, 48)
    public void testHidePicture17of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[400][400].getRed(), 80);
    }
	@Test
    public void testHidePicture18of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[400][400].getGreen(), 62);
    }
	@Test
    public void testHidePicture19of19() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 65, 208);
        Pixel[][] pixels = combined.getPixels2D();
        assertEquals(pixels[400][400].getBlue(), 48);
    }
	@Test
    public void testIsSame1of3() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        assertFalse(Steganography.isSame(beach, robot));
    }
	@Test
    public void testIsSame2of3() {
        // create two pictures
        Picture beach1 = new Picture("beach.jpg");
        Picture beach2 = new Picture("beach.jpg");
        // run the test
        assertTrue(Steganography.isSame(beach1, beach2));
    }
	@Test
    public void testIsSame3of3() {
        // create two pictures
        Picture beach1 = new Picture("beach.jpg");
        Picture beach2 = new Picture("beach.jpg");
        // invert the RGB value of a random pixel
        Pixel[] pixels = beach2.getPixels();
        int i = (int)(Math.random() * pixels.length);
        pixels[i].setRed(255 - pixels[i].getRed()); 
        pixels[i].setGreen(255 - pixels[i].getGreen()); 
        pixels[i].setBlue(255 - pixels[i].getBlue()); 
        // run the test
        assertFalse(Steganography.isSame(beach1, beach2));
    }
	@Test
    public void testFindDifferences1of3() {
        // create two pictures
        Picture beach1 = new Picture("beach.jpg");
        Picture beach2 = new Picture("beach.jpg");
        // run the test
        ArrayList<Point> list = Steganography.findDifferences(beach1, beach2);
        assertEquals(0, list.size());
    }
	@Test
    public void testFindDifferences2of3() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        ArrayList<Point> list = Steganography.findDifferences(beach, robot);
        assertEquals(0, list.size());
    }
	@Test
    public void testFindDifferences3of3() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 50, 100);
        ArrayList<Point> list = Steganography.findDifferences(beach, combined);
        assertEquals(2929, list.size());
    }
	@Test
    public void testShowDifferentArea1of7() {
        // create two pictures
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        // run the test
        Picture combined = Steganography.hidePicture(beach, robot, 0, 0);
        ArrayList<Point> list = Steganography.findDifferences(beach, combined);
        Picture outline = Steganography.showDifferentArea(beach, list);
        assertNotSame(beach, outline);
    }
	@Test
    public void testShowDifferentArea2of7() {
        // create three pictures 
        Picture temple = new Picture("femaleLionAndHall.jpg");
        Picture robot = new Picture("robot.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        int row = (int)(Math.random() * 150);
        Picture temp = Steganography.hidePicture(temple, robot, row, 300);
        Picture combined = Steganography.hidePicture(temp, flower, row + 65, 275);
        ArrayList<Point> list = Steganography.findDifferences(temple, combined);
        Picture outline = Steganography.showDifferentArea(temple, list);
        Pixel[][] pixels = outline.getPixels2D();
        assertTrue(pixels[row][350].getRed() == 255 && pixels[row][350].getGreen() == 0 &&
                   pixels[row][350].getBlue() == 0);
    }
	@Test
    public void testShowDifferentArea3of7() {
        // create three pictures 
        Picture temple = new Picture("femaleLionAndHall.jpg");
        Picture robot = new Picture("robot.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        int row = (int)(Math.random() * 150);
        Picture temp = Steganography.hidePicture(temple, robot, row, 300);
        Picture combined = Steganography.hidePicture(temp, flower, row + 65, 275);
        ArrayList<Point> list = Steganography.findDifferences(temple, combined);
        Picture outline = Steganography.showDifferentArea(temple, list);
        Pixel[][] pixels = outline.getPixels2D();
        assertTrue(pixels[row + 164][350].getRed() == 255 && 
                   pixels[row + 164][350].getGreen() == 0 &&
                   pixels[row + 164][350].getBlue() == 0);
    }
	@Test
    public void testShowDifferentArea4of7() {
        // create three pictures 
        Picture temple = new Picture("femaleLionAndHall.jpg");
        Picture robot = new Picture("robot.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        int col = (int)(Math.random() * 275);
        Picture temp = Steganography.hidePicture(temple, robot, 50, col + 25);
        Picture combined = Steganography.hidePicture(temp, flower, 115, col);
        ArrayList<Point> list = Steganography.findDifferences(temple, combined);
        Picture outline = Steganography.showDifferentArea(temple, list);
        Pixel[][] pixels = outline.getPixels2D();
        assertTrue(pixels[100][col].getRed() == 255 && pixels[100][col].getGreen() == 0 &&
                   pixels[100][col].getBlue() == 0);
    }
	@Test
    public void testShowDifferentArea5of7() {
        // create three pictures 
        Picture temple = new Picture("femaleLionAndHall.jpg");
        Picture robot = new Picture("robot.jpg");
        Picture flower = new Picture("flower1.jpg");
        // run the test
        int col = (int)(Math.random() * 275);
        Picture temp = Steganography.hidePicture(temple, robot, 50, col + 25);
        Picture combined = Steganography.hidePicture(temp, flower, 115, col);
        ArrayList<Point> list = Steganography.findDifferences(temple, combined);
        Picture outline = Steganography.showDifferentArea(temple, list);
        Pixel[][] pixels = outline.getPixels2D();
        assertTrue(pixels[100][col + 99].getRed() == 255 &&
                   pixels[100][col + 99].getGreen() == 0 &&
                   pixels[100][col + 99].getBlue() == 0);
    }
	@Test
    public void testShowDifferentArea6of7() {
        Picture temple = new Picture("femaleLionAndHall.jpg");
        Pixel[][] orig = temple.getPixels2D();
        Picture robot = new Picture("robot.jpg");
        Pixel[][] robotPixs = robot.getPixels2D();
        int startCol = (int)(Math.random() * 275);
        int endCol = startCol + robotPixs[0].length-1;
         // run the test
        int row = (int)(Math.random() * 150);
        Picture temp = Steganography.hidePicture(temple, robot, row, startCol);
        ArrayList<Point> list = Steganography.findDifferences(temple, temp);
        Picture outline = Steganography.showDifferentArea(temple, list);
        Pixel[][] pixels = outline.getPixels2D();
        boolean isWorking = true;
        for (int rows = row+1; rows < row+robotPixs.length - 1; rows++) {
        	for (int cols = startCol+1; cols < endCol; cols++) {
        		int g = (orig[rows][cols].getRed() + orig[rows][cols].getGreen() + orig[rows][cols].getBlue() )/3;
        		if (pixels[rows][cols].getRed() != g || pixels[rows][cols].getGreen() != g || pixels[rows][cols].getBlue() != g) {
        			isWorking = false;
        			System.out.println("[" +rows + "," + cols + "]");
        		}
        	}
        }
        assertTrue(isWorking);

    }
	@Test
    public void testShowDifferentArea7of7() {
        Picture temple = new Picture("femaleLionAndHall.jpg");
        Pixel[][] orig = temple.getPixels2D();
        Picture robot = new Picture("robot.jpg");
        Pixel[][] robotPixs = robot.getPixels2D();
        int startCol = 300;
        int endCol = startCol + robotPixs[0].length-1;
         // run the test
        int row = (int)(Math.random() * 150);
        Picture temp = Steganography.hidePicture(temple, robot, row, startCol);
        ArrayList<Point> list = Steganography.findDifferences(temple, temp);
        Picture outline = Steganography.showDifferentArea(temple, list);
        Pixel[][] pixels = outline.getPixels2D();
        boolean isWorking = true;

        for (int rows = row+1; rows < row+robotPixs.length - 1; rows++) {
        	for (int cols = startCol+1; cols < endCol; cols++) {
        		int g = (orig[rows][cols].getRed() + orig[rows][cols].getGreen() + orig[rows][cols].getBlue() )/3;
        		if (pixels[rows][cols].getRed() != g || pixels[rows][cols].getGreen() != g || pixels[rows][cols].getBlue() != g) {
        			isWorking = false;
        			System.out.println("[" +rows + "," + cols + "]");
        		}
        	}
        }
        assertTrue(isWorking);
     }


}
