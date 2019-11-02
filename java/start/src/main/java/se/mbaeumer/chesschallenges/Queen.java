package se.mbaeumer.chesschallenges;

import java.util.ArrayList;
import java.util.List;

public class Queen {
    private Position position;
    private List<PotentialVector> potentialVectors;

    public Queen(Position position) {
        this.position = position;
        initPotentialVectors();
    }

    private void initPotentialVectors(){
        potentialVectors = new ArrayList<>();
        potentialVectors.add(new PotentialVector(-1, -1));
        potentialVectors.add(new PotentialVector(-1, 0));
        potentialVectors.add(new PotentialVector(-1, 1));
        potentialVectors.add(new PotentialVector(0, 1));
        potentialVectors.add(new PotentialVector(0, -1));
        potentialVectors.add(new PotentialVector(1, -1));
        potentialVectors.add(new PotentialVector(1, 0));
        potentialVectors.add(new PotentialVector(1, 1));
    }

    public List<Position> getPotentialDestinations(){
        return null;
    }

    public boolean isAllowed(Position position){
        return true;
    }
    //for (PotentialVector potentialVector : pote)
}
