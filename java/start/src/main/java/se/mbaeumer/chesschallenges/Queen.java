package se.mbaeumer.chesschallenges;

import java.util.ArrayList;
import java.util.List;

public class Queen {
    private Position position;
    private List<PotentialVector> potentialDiagonalVectors;
    private List<PotentialVector> potentialNonDiagonalVectors;

    public Queen(Position position) {
        this.position = position;
        initPotentialVectors();
    }

    private void initPotentialVectors(){
        potentialDiagonalVectors = new ArrayList<>();
        potentialNonDiagonalVectors = new ArrayList<>();
        potentialDiagonalVectors.add(new PotentialVector(1, 1));
        potentialDiagonalVectors.add(new PotentialVector(-1, -1));
        potentialDiagonalVectors.add(new PotentialVector(-1, 1));
        potentialDiagonalVectors.add(new PotentialVector(1, -1));
        potentialNonDiagonalVectors.add(new PotentialVector(-1, 0));
        potentialNonDiagonalVectors.add(new PotentialVector(0, 1));
        potentialNonDiagonalVectors.add(new PotentialVector(0, -1));
        potentialNonDiagonalVectors.add(new PotentialVector(1, 0));
    }

    public List<Position> getPotentialDestinations(){
        List<Position> positions = new ArrayList<>();
        List<PotentialVector> allPotentialVectors = new ArrayList<>();
        allPotentialVectors.addAll(potentialDiagonalVectors);
        allPotentialVectors.addAll(potentialNonDiagonalVectors);
        for (PotentialVector potentialVector : allPotentialVectors){
            Position currentPosition = this.position;
            currentPosition = new Position(currentPosition.getX() + potentialVector.getX(),
                    currentPosition.getY() + potentialVector.getY());
            while (isValid(currentPosition.getX(), currentPosition.getY())){
                positions.add(currentPosition);
                currentPosition = new Position(currentPosition.getX() + potentialVector.getX(),
                        currentPosition.getY() + potentialVector.getY());
            }
        }

        return positions;
    }

    private boolean isValid(final int x, final int y){
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public boolean isAllowed(Position target){
        if (position.getX() == target.getX() || position.getY() == target.getY()){
            return true;
        }

        for (PotentialVector potentialVector : potentialDiagonalVectors){
            System.out.println("Vector: " + potentialVector.getX() + ", " + potentialVector.getY());
            Position currentPosition = this.position;
            while (currentPosition.getX() >= 0 && currentPosition.getX() < 8
                    && currentPosition.getY() >= 0 && currentPosition.getY() < 8){
                currentPosition = new Position(currentPosition.getX() + potentialVector.getX(),
                        currentPosition.getY() + potentialVector.getY());
                System.out.println("Checking pos " + currentPosition.getX() + ", " + currentPosition.getY());
                if (currentPosition.getX() == target.getX() && currentPosition.getY() == target.getY()){
                    return true;
                }
            }
        }

        return false;
    }
}
