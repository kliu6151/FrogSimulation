package com.company;

public class FrogSimulation {
    public int[] testHops;
    public int nextHopIndex;
    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int dist, int numHops) {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
        return this.testHops[this.nextHopIndex];
    }
    public boolean simulate()
    {
        int currentDist = 0;
        int currentHop = 0;
        while(currentHop < maxHops)
        {
            currentDist += hopDistance();
            if(currentDist<0) {
                return false;
            }
            if(currentDist>=goalDistance){
                return true;
            }
            currentHop++;
            nextHopIndex++;
        }
        if(currentDist >= goalDistance)
            return true;
        else
            return false;
    }
    
    public double runSimulations(int num)
    {
        int simulateN = 0;
        double SSN = 0.0;
        while (simulateN < num)
        {
            if(simulate()){
                SSN++;
            }
            simulateN++;
            this.nextHopIndex = 0;
        }
        return SSN/num;
    }
}
