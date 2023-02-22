import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import PicLib.Picture;
import PicLib.Pixel;
import PicLib.Point;

public class Steganography {

	////////////////////////////////////////////////////////////////////
	//
	// ACTIVITY 1: Exploring Color
	//
	//////////////////////////////////////////////////
	// Changing Colors (Exercise 1.6-1.8)

	// 
	/**
	 * Clears the lower (rightmost) two bits of of the Red, Green, and Blue
	 * values of p.
	 * @param p The pixel to clear 
	 */
	public static void clearLow(Pixel p) {
		/* to be implemented in Activity 1 */
		// extract the red, green, and blue values from the pixel
		int r = p.getRed();
		int g = p.getGreen();
		int b = p.getBlue();
		// TODO: clear the lowest two bits of each color component
		// To clear the lower two bits, divide by 4 and then multiply by 4
		//clear
		r = (r/4)*4;
		g = (g/4)*4;
		b = (b/4)*4;
		// TODO: set the RGB components of the pixel to the new values
		//set
		p.setRed(r);
		p.setGreen(g);
		p.setBlue(b);
	}

	/**
	 * Creates a copy of original and then clears the lower two bits of every
	 * pixel in the picture. Must use the clearLow method. Returns the Picture copy.
	 * @param original the original picture.
	 * @return a copy of the original picture that has the lower two bits
	 *  of every pixel cleared
	 */
	public static Picture testClearLow(Picture original) {
		/* to be implemented in Activity 1 Part A*/

		// create a new picture as a copy of the original
		Picture copy = new Picture(original);
		// get an array of pixels from the copy
		Pixel [][] pixels = copy.getPixels2D();

		// TODO: use a for each loop to clear the low bits of each pixel
		for (Pixel[] pixel : pixels) {
			for (Pixel p : pixel) {
				clearLow(p);
			}
		}

		// return the copy
		return copy;
	}

	//////////////////////////////////////////////////
	// Setting Bits (Exercise 1.10-1.12)

	/**
	 * Sets the lower (rightmost) two bits of each red, green, blue value
	 * of a pixel to the higher (leftmost) two bits of each red, green, blue value
	 * in the specified color.
	 * @param p The pixel to modify.
	 * @param c The color to use to modify the pixel.
	 */
	public static void setLow(Pixel p, Color c) {
		// clear the lowest 2 bits of the pixel
		clearLow(p);
		// extract the red, green, and blue values from the color
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		// TODO (1.10): get the highest two bits of the color using maths!
		// to get the highest two bits, divide by 64.

		r = r / 64;
		g = g / 64;
		b = b / 64;
		// TODO (1.11): set the RGB components of the pixel to new values
		// to set a color component (RGB), add the cleared value to
		// highest 2 bits of c
		p.setRed(p.getRed()+ r);
		p.setGreen(p.getGreen()+ g);
		p.setBlue(p. getBlue() + b);
		/**
		 * ex)
		 * p.r: 1000 1011 c.r: 1101 1010
		 * ==> p.r: 1000 1011
		 *
		 */
	}

	/**
	 * Creates a copy of the specified picture, clears the lower two bits of every pixel
	 * in copy, then sets the lower two bits to the higher two bits of the specified color.
	 * Must use the setLow method. Returns copy.
	 * @param original The original picture to copy
	 * @param c The color used to modify the picture copy
	 * @return The Picture copy.
	 */
	public static Picture testSetLow(Picture original, Color c) {
		// create a new picture as a copy of the original
		Picture copy = new Picture(original);
		// get an array of pixels from the copy
		Pixel[] pixels = copy.getPixels();
		// TODO (1.12): use a for each loop to set the low bits of each pixel
		for (Pixel pixel : pixels) {
			setLow(pixel, c);
		}

		// return the copy
		return copy;
	}

	//////////////////////////////////////////////////
	// Revealing Bits (Exercise 1.13-1.14)

	/**
	 * Given a picture that has a hidden picture, it reveals the hidden picture.
	 * Creates a copy of a picture, sets the highest two bits of each pixel
	 * in the copy to the lowest two bits of each pixel in the source.
	 * @param The picture that contains a hidden picture.
	 * @return The hidden picture.
	 */
	public static Picture revealPicture(Picture hidden) {
		// create a copy of the hidden picture
		Picture copy = new Picture(hidden);
		// get a 2D array of pixels from the copy
		Pixel[][] pixels = copy.getPixels2D();
		// get a 2D array of pixels from the source image
		Pixel[][] source = hidden.getPixels2D();

		// TODO (1.13): traverse pixels using a nested for loop
		//copy pixels clear

		for (Pixel[] pixel : pixels) {
			for (Pixel p : pixel) {
				// >> 2
				p.setRed(p.getRed() / 4);
				p.setGreen(p.getGreen() / 4);
				p.setBlue(p.getBlue() / 4);
			}
		}

		// TODO (1.14): set red, green, and blue values of each 
		//              pixel to the lowest two bits in source
		//
		// get the color from hidden

		// get the pixel from copy

		// set all the color components (red, green, blue)
		// To get the lower 2 bits of a color component and 
		// make that the upper bits, % 4 * 64
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[0].length; j++) {
				pixels[i][j].setRed(pixels[i][j].getRed() + (source[i][j].getRed() % 4 * 64) );
				pixels[i][j].setGreen(pixels[i][j].getGreen() + (source[i][j].getGreen() % 4 * 64) );
				pixels[i][j].setBlue(pixels[i][j].getBlue() + (source[i][j].getBlue() % 4 * 64) );
			}
		}

		// return the copy. Since the pixels that you modified are referenced from 
		// copy, copy contains the hidden secret picture.
		return copy;
	}

	////////////////////////////////////////////////////////////////////
	//
	// ACTIVITY 2: Hiding and Revealing a Picture
	//

	// Exercise 2.8
	// **ATTENTION**: do not rewrite this method for Activity 3!
	/**
	 * Determines whether the secret picture can be hidden in the source picture.
	 * @param source The source picture to hide the secret picture in.
	 * @param secret The secret picture.
	 * @return true if source and secret images have the same dimensions; otherwise false
	 */
	public static boolean canHide(Picture source, Picture secret) {
		// TODO (2.8): determine whether secret can be hidden in source
		boolean flag = false;
		Pixel[][] sourcePixels = source.getPixels2D();
		Pixel[][] secretPixels = secret.getPixels2D();
		if (secretPixels.length == sourcePixels.length && secretPixels[0].length == sourcePixels[0].length) {
			flag = true;
		}
		return flag;
	}

	// Exercise 2.9
	/**
	 * Hides a secret image inside a source image that is the same size by
	 * creating a copy of the source picture and setting the lower two bits
	 * of each pixel using the data from the secret pixel. Must use the 
	 * setLow method.
	 * @param source The source image 
	 * @param secret The secret image
	 * @return a combined image that contains a copy of the source image with 
	 *         the secret image hidden within.
	 */
	public static Picture hidePicture(Picture source, Picture secret) {
		// TODO (2.9): Create a copy of the source picture and hide a secret picture within the copy. Return the copy.
		Picture hidden = new Picture(source);
		Pixel[][] hPixels = hidden.getPixels2D();
		Pixel[][] sPixels = secret.getPixels2D();
		int rowLen = hPixels.length;
		int colLen = hPixels[0].length;

		// Traverse hPixels
		// Get the corresponding pixel from sPixels

		// call setLow on hPixels, using the color from 
		// the pixel in sPixels
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				setLow(hPixels[i][j], sPixels[i][j].getColor());
			}
		}


		// return hidden. Since the pixels that you modified are referenced from 
		// the hidden, hidden contains the hidden secret picture.

		return hidden;
	}

	////////////////////////////////////////////////////////////////////
	//
	// ACTIVITY 3: Identifying a Hidden Picture
	//

	// Exercise 3.0
	// returns true if secret image can be embedded in source image at the
	// specified row and column without exceeding bounds of source image
	/**
   /**
	 * Determines whether the secret picture can be hidden in the source picture at 
	 * the specified row and column.
	 * @param source The source picture to hide the secret picture in.
	 * @param secret The secret picture.
	 * @param row the row to start hiding the secret image.
	 * @param col the column to start hiding the secret image.
	 * @return true if secret can be hidden in source at the specified row and column; otherwise false
	 */
	public static boolean canHide(Picture source, Picture secret, int row, int col) {
		// TODO (3.0): determine whether secret can be hidden in source at [row][col]
		boolean flag = false;
		Pixel[][] sourcePixel = source.getPixels2D();
		Pixel[][] secretPixel = secret.getPixels2D();
		if(
				row > -1 && col > -1 //row and col is bigger than -1
				&& sourcePixel.length - row > secretPixel.length //source row is bigger than secret
				&& sourcePixel[0].length - col > secretPixel[0].length //source col is bigger than secret
		){
			flag = true;
		}

		return flag;
	}

	// Exercise 3.1
	// creates a new Picture with data from secret hidden in the RGB
	// information in source beginning at pixel location (row, col)
	/**
	 * Hides a secret image inside a source image beginning at pixel location (row, col)
	 * by creating a copy of the source picture and setting the lower two bits
	 * of each pixel using the data from the secret pixel. Must use the 
	 * setLow method.
	 * @param source The source image 
	 * @param secret The secret image
	 * @param row the row to start hiding the secret image at
	 * @param col the column to start hiding the secret image at
	 * @return a combined image that contains a copy of the source image with 
	 *         the secret image hidden within.
	 */
	public static Picture hidePicture(Picture source, Picture secret, int row, int col) {
		// TODO (3.1): hide a secret picture within a source picture at [row][col]

		Picture hidden = new Picture(source);
		Pixel[][] hPixels = hidden.getPixels2D();
		Pixel[][] sPixels = secret.getPixels2D();
		int rowLen = sPixels.length;
		int colLen = sPixels[0].length;

		//secret을 감추기 때문에 secret 크기 만큼 반복.
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				//원래 사진에서 row, col을 더한 곳에서부터 시작.
				setLow(hPixels[i+row][j+col], sPixels[i][j].getColor());
			}

		}

		return hidden;
	}

	// Exercise 3.2
	/**
	 * Determines whether two images are exactly the same. Two images are exactly the
	 * same if they are the same size and each pixel has the same RGB values.
	 * @param image1 image one
	 * @param image2 image two
	 * @return true if image1 and image are exactly the same;otherwise false.
	 */
	public static boolean isSame(Picture image1, Picture image2) {
		// images won't be the same if the height or width is different
		if ((image1.getHeight() != image2.getHeight()) || 
				(image1.getWidth() != image2.getWidth())) {
			return false;
		}
		// get a 2D array of pixels for each image
		Pixel[][] pixels1 = image1.getPixels2D();
		Pixel[][] pixels2 = image2.getPixels2D();
		int rowLen = pixels1.length;
		int colLen = pixels1[0].length;
		// TODO (3.2): compare RGB values of pixel pairs using a nested for loop
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (!pixels1[i][j].getColor().equals(pixels2[i][j].getColor())) {
					return false;
				}
			}

		}

		return true;
	}

	// Exercise 3.3
	/**
	 * Finds the list of pixels that differ between two pictures.
	 * @param image1 image one
	 * @param image2 image two
	 * @return An ArrayList of Point objects that differ. If no pixels differ, return an
	 *         empty list. A pixel differs, if either the red, green, or blue value
	 *         differ for a Pixel.
	 */
	public static ArrayList<Point> findDifferences(Picture image1, Picture image2) {
		// create an ArrayList of Point objects
		ArrayList<Point> list = new ArrayList<Point>();
		// return an empty list if the images are different sizes
		if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()) { 
			return list;
		}
		// get a 2D array of pixels for each image
		Pixel[][] pixels = image1.getPixels2D();
		Pixel[][] otherPixels = image2.getPixels2D();
		int rowLen = pixels.length;
		int colLen = pixels[0].length;

		// compare RGB values of pixel pairs using a nested for loop
		// TODO create an ArrayList of points where RGB values differ between pixels
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (!pixels[i][j].getColor().equals(otherPixels[i][j].getColor())) {
					list.add(new Point(i, j));
				}
			}
		}

		return list;
	}

	// Exercise 3.4
	// 
	/**
	 * Displays a rectangle area containing the points that are different
	 * The border is Color.red
	 * The interior of the rectangle is greyscale
	 * @param image The source image to draw the rectangular outline on.
	 * @param points The points for which the outline is to be drawn around.
	 * @return A copy of the source image with the rectangular outline
	 */
	public static Picture showDifferentArea(Picture image, ArrayList<Point> points) {
		// create a new picture as a copy of the original
		Picture copy = new Picture(image);
		Pixel[][] copyPixels = copy.getPixels2D();
		Pixel pixel;
		int grey;
		// find the minimum and maximum row values as well as the minimum and
		// maximum column values for the bounding box that contains all points
		int minRow, maxRow, minCol, maxCol;
		// initialize the minimums and maximums to the values of the first point
		//최대 최소를 다시 찾아야할 것 같음.
		minRow = points.get(0).getRow();
		maxRow = points.get(points.size()-1).getRow();
		minCol = points.get(0).getCol();
		maxCol = points.get(points.size()-1).getCol();
		// return an image without a bounding box if the list of points is empty
		if (points.size() == 0) {
			return copy;
		}
		System.out.println("minCol = " + minCol);

		// TODO loop over the points in the list and find the bounding box
/*
		for (int i = minCol; i < maxCol+1; i++) {
			copyPixels[minRow][i].setColor(Color.RED);
			copyPixels[maxRow][i].setColor(Color.RED);
		}
		for (int i = minRow; i < maxRow+1; i++) {
			copyPixels[i][minCol].setColor(Color.RED);
			copyPixels[i][maxCol].setColor(Color.RED);
		}
 */
		for (int i = minRow; i < maxRow+1; i++) {
			for (int j = minCol; j < maxCol+1; j++) {
				copyPixels[i][j].setColor(Color.RED);
				System.out.println("copyPixels["+i+"]["+j+"].getRed() = " + copyPixels[i][j].getRed());
			}
		}

		// Create a rectangle that shows where the differences are.
		// the border is Color.red
		// the interior is greyscale
		//   greyscale is computed by computing the average of the current 
		//   red, green, and blue values

		// TODO using a nested loop, determine if we are on
		// the border of the rectangle or inside of it.
		// if on the border, set the color to Color.red;
		// if inside the rectangle, compute the greyscale for the original pixel and set the color to that.

		/*
		for (int i = minRow+1; i < maxRow; i++) {
			for (int j = minCol+1; j < maxCol; j++) {
				pixel = copyPixels[i][j];
				grey = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/2;
				pixel.setColor(new Color(grey));
			}
		}

		 */

		// return the copy
		return copy;
	}

	////////////////////////////////////////////////////////////////////
	//
	// ACTIVITY 4: Hiding and Revealing a Text Message
	//
	/**
	 * Provided by the College Board, but modified to add uppercase letters and numbers
	 * Encodes a string consisting of letters, numbers, and spaces. Each character
	 * of the String is encoded into an integer per the following: 
	 * 1-26 for A-Z, 27-52 for a-z, 53-62 for 0-9, 63 for space, and 0 for end of string.
	 * @param s the string to encode
	 * @return An ArrayList of integers including the encoding
	 */
	private static ArrayList<Integer> encodeString(String s) {
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			result.add(alpha.indexOf(s.substring(i, i + 1)) + 1);
		}
		// terminate the list with a zero
		result.add(0);
		// return the list
		return result;
	}

	/**
	 * Decodes the string represented by the codes in arrayList.
	 * The encoded integers use the following rules: 
	 * 1-26 for A-Z, 27-52 for a-z, 53-62 for 0-9, 63 for space, and 0 for end of string.
	 * @param codes The ArrayList of Integers containing the encoded string.
	 * 				Precondition: 
	 * @return The decoded string.
	 * Pre-Condition: 
	 */
	private static String decodeString(ArrayList<Integer> codes) {
		String result = "";
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
		for (int i = 0; i < codes.size(); i++) {
			result = result + alpha.substring(codes.get(i) - 1, codes.get(i));
		}
		return result;
	}

	// 
	// 
	// 
	// 
	/**
	 * Provided by the College Board
	 * Given a number from 0 to 63, creates and returns a 3-element
	 * integer array consisting of the integers representing the
	 * pairs of bits in the number from right to left.
	 * @param num number to be broken up
	 * @return bit pairs in number
	 */
	private static int[] getBitPairs(int num) {
		int[] bits = new int[3];
		int code = num;
		for (int i = 0; i < 3; i++) {
			// Get the rightmost 2 bits
			bits[i] = code % 4;
			// shift the bits 2 to the right
			code = code / 4;
		}
		return bits;
	}
	/**
	 * Given a 1D array of 3 elements, returns an integer that can be 
	 * decoded by decodeString. The 3 elements are the Red, Green Components
	 * of a color  
	 *    Element 0 is red
	 *    Element 1 is green
	 *    Element 2 is  blue
	 * 
	 * @param bitPairs The Red, Green components of a color
	 * @return an integer that can be decoded with decodeString
	 */
	private static int getNumberFromBitPairs(int[] bitPairs) {
		int red = bitPairs[0];
		int green = bitPairs[1];
		int blue = bitPairs[2];
		return blue * 16 + green * 4 + red;
	}
	// Exercise 4.2
	/**
	 * Hides a string that only contains letters, numbers, and spaces
	 * in the upper left corner of the specified picture.
	 * @param image picture to hide the string in.
	 * @param s string to hide
	 * @return picture with hidden string.
	 */
	public static Picture hideText(Picture image, String s) {
		// use the method provided by the College Board to create
		// a list of integers that represents an encoded message
		ArrayList<Integer> list = encodeString(s);
		// create a new picture as a copy of the original
		Picture copy = new Picture(image);
		Pixel[] pixels = copy.getPixels();
		Pixel pixel;
		int[] bitPair;
		//determine loop times.
		//if pixel.length < list.size ==> times are pixel.length
		//because if times are list.size, then cause OutOfBonud.
		int hiddenLen = pixels.length > list.size() ? list.size() : pixels.length;
		// loop through the list, split up each letter into bit pairs, then
		// TODO hide the bit pairs in the RGB info of the image pixels
		// traverse the list of integers until you reach the end
		// or there are no more pixels to modify

		// clear the lower 2 bits of the Pixel to change
		System.out.println("hiddenLen = " + hiddenLen);
		for (int i = 0; i < hiddenLen; i++) {

			clearLow(pixels[i]);
		}

		// Get an integer from the list

		// call getBitPairs with that integer. A 3 element
		// array of integers are returned.
		// bitPairs[0] is red
		// bitPairs[1] is green
		// bitPairs[2] is blue
		for (int i = 0; i < hiddenLen; i++) {
			pixel = pixels[i];
			bitPair = getBitPairs(list.get(i));

			// set the red, green, and components to be a
			// sum of the color component and the corresponding
			// bitPairs element.
			pixel.setRed(pixel.getRed() + bitPair[0]);
			pixel.setGreen(pixel.getGreen() + bitPair[1]);
			pixel.setBlue(pixel.getBlue() + bitPair[2]);
		}

		// return the copy
		// Since the pixels that you modified are referenced from 
		// the copy, the copy contains the hidden text.
		return copy;
	}


	/**
	 * Reveals the string that is hidden within the specified picture.
	 * @param source picture with hidden string
	 * @return revealed string
	 */
	public static String revealText(Picture source) {
		// declare an arrayList of Integer type to store the encoded text 
		ArrayList<Integer> textList = new ArrayList<Integer>();
		// Get a 1D array of the pixels for source
		Pixel[] pixels = source.getPixels();
		int strToNum;
		// TODO (4.3): loop though the pixels in an image and extract the hidden message
		// Traverse the 1D array
		// for every pixel in the 1D Array
		//    Create a 1D array of integers to hold color components
		//int[] bitPairs = new int[3];
		int[][] bitPairs = new int[pixels.length][3];
		for (int i = 0; i < pixels.length; i++) {
			//    get each color component's (Red, Green, Blue).
			//    get each color component's lower 2 bits
			//       The lower 2 bits can be obtained using % 4
			//    add each color component to bitPairs

			//      bitPairs[0] is red
			//      bitPairs[1] is green
			//      bitPairs[2] is blue
			bitPairs[i][0] = pixels[i].getRed() % 4;
			bitPairs[i][1] = pixels[i].getGreen() % 4;
			bitPairs[i][2] = pixels[i].getBlue() % 4;
		}


		for (int i = 0; i < bitPairs.length; i++) {
			//    Create a number that can be decoded with decodeString
			strToNum = getNumberFromBitPairs(bitPairs[i]);
			// if number is 0, we are done, so break
			if (strToNum == 0) {
				break;
			}
			//Add number to list
			textList.add(strToNum);
		}

		// else 

		// Call decodeString to decode our array of integers
		// to obtain the hidden string.
		// return the revealed text
		return decodeString(textList);
	}

	////////////////////////////////////////////////////////////////////
	//
	// main() method
	//
	// it is recommended that you preserve the sections in main and
	// code up each section as you progress through the student guide.
	//
	// comment out previously completed sections instead of deleting
	// them so that you can preserve the checkpoint functionality.
	//
	// please refer to the Lab student guide for more information.
	//
	public static void main(String[] args) {

		////////////////////////////////////////////////////
		// ACTIVITY 1: Exploring Color
		File path = new File("images/beach.jpg");

		System.out.println("path = " + path.getAbsolutePath());


		// Part A
		/*
		Picture beach1dot8 = new Picture("beach.jpg");
		beach1dot8.setTitle("Activity 1 - Part A: Beach Original");
		beach1dot8.explore();
		//System.out.println(DigitalPicture.class.getResource("src/PigLib/leftArrow.gif"));
		//System.out.println(DigitalPicture.class.getResource("image/beach.jpg"));
		Picture copy1dot8 = testClearLow(beach1dot8);
		copy1dot8.setTitle("Activity 1 - Part A: Beach after testClearLow");
		copy1dot8.explore();

		 */

		/*
        // Part B
        Picture beach1dot12 = new Picture("beach.jpg");
        beach1dot12.setTitle("Activity 1 - Part B: Beach Original");
        beach1dot12.explore();
        Color eastlakeRed = new Color(107, 0, 36);
        Picture copy1dot12 = testSetLow(beach1dot12, eastlakeRed);
        copy1dot12.setTitle("Activity 1 - Part B: Beach after testSetLow");
        copy1dot12.explore();

        // Part C
        Picture copy1dot14 = revealPicture(copy1dot12);
        copy1dot14.setTitle("1.14 revealPicture");
        copy1dot14.explore();
		 **/

		////////////////////////////////////////////////////
		// ACTIVITY 2: Hiding and Revealing a Picture

		/*
        // Part A - Test canHide 
        Picture beach2dot8 = new Picture("beach.jpg");
        Picture arch2dot8 = new Picture("arch.jpg");
        System.out.println("beach same size as arch? " + canHide(beach2dot8, arch2dot8));

        // Part B - Test hidePicture
        Picture swan2dot9 = new Picture("swan.jpg");
        Picture gorge2dot9 = new Picture("gorge.jpg");
        System.out.println("swan same size as gorge? " + canHide(swan2dot9, gorge2dot9));
        swan2dot9.setTitle("ACTIVITY 2 - Part B Swan Original");
        swan2dot9.explore();
        gorge2dot9.setTitle("ACTIVITY 2 - Part B Gorge Original");
        gorge2dot9.explore();
        Picture combined2dot9 = null;
        if (canHide(swan2dot9, gorge2dot9)) {
            combined2dot9 = hidePicture(swan2dot9, gorge2dot9);
            combined2dot9.setTitle("ACTIVITY 2 - Part C Gorge hidden in Swan");
            combined2dot9.explore();
        }

        // Part C - Verify revealPicture still works
        if (combined2dot9 != null) {
            Picture revealed2dot11 = revealPicture(combined2dot9);
            revealed2dot11.setTitle("ACTIVITY 2 - Part C Gorge revealed");
            revealed2dot11.explore();
        }
		 */

		////////////////////////////////////////////////////
		// ACTIVITY 3: Identifying a Hidden Picture

		/*
        // Part A
        Picture beach3dot1 = new Picture("beach.jpg");
        beach3dot1.setTitle("ACTIVITY 3 - Part A - Beach Original");
        beach3dot1.explore();
        // hide the robot and flower pictures in the beach picture
        Picture robot3dot1 = new Picture("robot.jpg");
        Picture flower3dot1 = new Picture("flower1.jpg");
        if (canHide(beach3dot1, robot3dot1, 65, 208) && canHide(beach3dot1, flower3dot1, 280, 110)) {
            Picture temp = hidePicture(beach3dot1, robot3dot1, 65, 208);
            Picture hidden = hidePicture(temp, flower3dot1, 280, 110);
            hidden.setTitle("ACTIVITY 3 - Part A - Beach with Hidden Pictures");
            hidden.explore();
            Picture unhidden = revealPicture(hidden);
            unhidden.setTitle("ACTIVITY 3 - Part A - Beach with Revealed Pictures");
            unhidden.explore();
        }

        // Part B
        Picture swanCopy1 = new Picture("swan.jpg");
        Picture swanCopy2 = new Picture("swan.jpg");
        System.out.print("Swan1 and swan2 are the same? ");
        System.out.println(isSame(swanCopy1, swanCopy2));
        swanCopy2 = testClearLow(swanCopy2);
        System.out.print("Swans are the same after clearLow on swan2? ");
        System.out.println(isSame(swanCopy1, swanCopy2));

        // Part C
        Picture archCopy1 = new Picture("arch.jpg");
        Picture archCopy2 = new Picture("arch.jpg");
        Picture koala3dot3 = new Picture("koala.jpg");
        Picture robot3dot3 = new Picture("robot.jpg");
        ArrayList<Point> pointList = findDifferences(archCopy1, archCopy2);
        System.out.print("Number of pixels different between arch and arch: ");
        System.out.println(pointList.size());
        pointList = findDifferences(archCopy1, koala3dot3);
        System.out.print("Number of pixels different between arch and koala: ");
        System.out.println(pointList.size());
        archCopy2 = hidePicture(archCopy1, robot3dot3, 65, 102);
        pointList = findDifferences(archCopy1, archCopy2);
        System.out.print("Number of pixels different between arch with hidden ");
        System.out.print("image and original arch image: ");
        System.out.println(pointList.size());
        archCopy1.setTitle("ACTIVITY 3 - Part C - Original Arch");
        archCopy1.explore();
        archCopy2.setTitle("ACTIVITY 3 - Part C - Arch with Hidden Image");
        archCopy2.explore();
        Picture revealed3dot3 = revealPicture(archCopy2);
        revealed3dot3.setTitle("ACTIVITY 3 - Part C - Revealed Hidden Picture");
        revealed3dot3.explore();

        // Part D
        Picture templeCopy1 = new Picture("femaleLionAndHall.jpg");
        Picture robot3dot4 = new Picture("robot.jpg");
        Picture flower3dot4 = new Picture("flower1.jpg");
        // hide pictures
        Picture templeCopy2 = hidePicture(templeCopy1, robot3dot4, 50, 300);
        Picture templeCopy3 = hidePicture(templeCopy2, flower3dot4, 115, 275);
        templeCopy3.setTitle("ACTIVITY 3 - Part D - Original Female Lion and Hall");
        templeCopy3.explore();
        if (!isSame(templeCopy1, templeCopy3)) {
            ArrayList<Point> pointList2 = findDifferences(templeCopy1, templeCopy3);
            System.out.print("Number of pixels different between temple with hidden ");
            System.out.print("images and original arch image: ");
            System.out.println(pointList2.size());
            Picture templeCopy4 = showDifferentArea(templeCopy1, pointList2);
            templeCopy4.setTitle("ACTIVITY 3 - Part D - Show Different Area");
            templeCopy4.explore();
            Picture unhidden = revealPicture(templeCopy3);
            unhidden.setTitle("ACTIVITY 3 - Part D - Temple with Hidden Pictures");
            unhidden.explore();
        }

		 */
		////////////////////////////////////////////////////
		// ACTIVITY 4: Hiding and Revealing a Text Message

		/*
        // Part A
        Picture beach4dot4 = new Picture("beach.jpg");
        beach4dot4.setTitle("ACTIVITY 4 - Part A - Original Beach Image");
        beach4dot4.explore();
        Picture hiddenText = hideText(beach4dot4, "May the Force be with you");
        hiddenText.setTitle("ACTIVITY 4 - Part A - Beach Image with Hidden Text");
        hiddenText.explore();
        String secret = revealText(hiddenText);
        if (secret.equals("May the Force be with you")) {
            System.out.println("The force is strong with you.");
        }
        else {
            System.out.println("Something went wrong.");
        }
		 */

		////////////////////////////////////////////////////
	}

}
