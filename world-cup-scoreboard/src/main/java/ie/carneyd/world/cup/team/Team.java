/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.carneyd.world.cup.team;

/**
 *
 * @author Acer
 */
public class Team {
    private String shortName;
    private String longName;
    
    public Team(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    @Override
    public String toString() {
        return shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }
}
