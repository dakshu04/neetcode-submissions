class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Step 1: Use a 2D array to store [position, timeToTarget] for each car
        // cars[i][0] -> position of car i
        // cars[i][1] -> time required for car i to reach the target independently
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // Time = (target - position) / speed
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Step 2: Sort the cars by starting position in descending order
        // Processing from closest to target (farthest right) to farthest from target (farthest left)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleetCount = 0;
        double currentFleetTime = 0;

        // Step 3: Iterate through cars and determine fleet merging
        for (int i = 0; i < n; i++) {
            double timeToTarget = cars[i][1];

            // If a car takes LONGER than the fleet ahead of it, it can never catch up.
            // Therefore, it must start a brand new fleet.
            if (timeToTarget > currentFleetTime) {
                fleetCount++;
                currentFleetTime = timeToTarget; // This car sets the bottleneck time for its fleet
            }
            // If timeToTarget <= currentFleetTime:
            // The car catches up to the fleet ahead and joins it (its arrival time is limited by the fleet ahead).
        }

        return fleetCount;
    }
}