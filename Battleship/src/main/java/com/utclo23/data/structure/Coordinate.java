/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utclo23.data.structure;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 *
 * @author lucillefargeau
 */
public class Coordinate extends SerializableEntity{
    private int x;
    private int y;

    /**
     *
     */
    public Coordinate() {
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @param x
     * @param y
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == this) {
            return true;
        }
        if (!(o instanceof Coordinate)) {
            return false;
        }
        Coordinate c = (Coordinate) o;
        
        return ((c.getX() == this.getX()) && (c.getY() == this.getY()));
        
    }
    
    /**
     * Checks if the coordinate is taken by a ship of a list.
     * 
     * @param ships
     * @return 
     */
    @JsonIgnore
    public boolean isAllowed(List<Ship> ships) {
        if(!this.isInBoard()) {
            return false;
        }
        boolean available = true;
        for(int s = 0; s < ships.size(); s++) {
            if(ships.get(s).isCrossed(this)) {
                available = false;
                break;
            }
        }
        return available;
    }
    
    /**
     * Ckecks if the coordinate is within the board.
     * @return 
     */
    @JsonIgnore
    private boolean isInBoard() {
        return (x < 10 && x >= 0 && y < 10 && y >= 0);
    }
}
