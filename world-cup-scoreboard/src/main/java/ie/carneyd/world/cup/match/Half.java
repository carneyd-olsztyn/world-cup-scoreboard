/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ie.carneyd.world.cup.match;

/**
 *
 * @author Acer
 */
public enum Half {
    FIRST_HALF(1),
    SECOND_HALF(2);
    
    private Half(final int halfNumber) {
      this.halfNumber = halfNumber;
    }
    
    private int halfNumber;
    
    public int getHalfNumber() {
        return halfNumber;
    }
    public void setHalfNumber(int halfNumber) {
        this.halfNumber = halfNumber;
    }
}
