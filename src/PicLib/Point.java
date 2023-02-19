package PicLib;
/**
 * Represents a point at [row,col]
 */
public class Point
{
    private int row;
    private int col;
    
    /**
     * Constructor for point [newRow,newCol]
     * @param newRow row number
     * @param newCol col number
     */
    public Point (int newRow, int newCol)
    {
        row = newRow;
        col = newCol;
    }
    
    /**
     * Accessor for row
     * @return row
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Accessor for col
     * @return col
     */
    public int getCol()
    {
        return col;
    }   
    
    /**
     * Mutator for row
     * @param newRow new value for row
     */
    public void setRow(int newRow)
    {
        row = newRow;
    }

    /**
     * Mutator for col
     * @param newCol new value for col
     */
    public void setCol(int newCol)
    {
        col = newCol;
    }
    
    /**
     * Method to return a string with information about this point
     * @return a string with information about this point
     */
    public String toString()
    {
        return "row: " + row + " col: " + col;
    }
}