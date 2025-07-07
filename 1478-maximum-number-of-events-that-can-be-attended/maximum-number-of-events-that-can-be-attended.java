class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int eventIndex = 0, attended = 0;

        int day = 1, n = events.length;

        int maxDays = 0;
        for(int[] event: events){
            maxDays = Math.max(maxDays, event[1]);
        }

        for (day = 1; day <= maxDays; day++) {
            // Add all events that start today
            while (eventIndex < n && events[eventIndex][0] == day) {
                minHeap.add(events[eventIndex][1]); // push end day
                eventIndex++;
            }

            // Remove all events that have already expired (end before today)
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event with the earliest end day
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }
        }

        return attended;
    }
}