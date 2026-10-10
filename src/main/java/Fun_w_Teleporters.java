/*
In Thrilling Teleporters, teleporters are randomized each game. Sometimes, this can create boards where the player can’t reach the final tile.

Your task is to write a function that determines whether the player can reach tile N from the starting tile, using the following inputs:
- A list of teleporters (as strings)
- The number of sides on the die
- The starting tile
- The total number of tiles N

The function should return true if tile N is reachable from the starting tile in any number of die rolls, or false otherwise.

Examples:
teleporters1 = [
  "10,8", -- From tile 10 to tile  8
  "11,5", -- From tile 11 to tile  5
  "12,7", -- From tile 12 to tile  7
  "13,9", -- From tile 13 to tile  9
]

                               "11,5"
                    ┌──<───<───<───<───<───<──<┐
                    │                         │
                    │             "10,8"      │
                    │           ┌─<───<──┐    │                    N = 16
                    v           v        │    │
0 → 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10 . 11 . 12 . 13 . 14 → 15 → 16
                            ^       ^              │    │
                            │       └──<──<───<───<───<──┘
                            │             "13,9"   │
                            │                      │
                            └──<───<───<───<───<───<┘
                                     "12,7"

Using a 4-sided die, starting from tile 0 on a board with N = 16 (as shown above),
it's impossible to reach tile 16 — no matter what you roll — because the teleporters between tiles 10 and 13 trap the player in a loop.
finishable(teleporters1, 4, 0, 16) => False

Adding a teleporter from tile 2 to 15 makes it possible to finish the game.
teleporters2 = ["10,8", "11,5", "12,7", "13,9", "2,15"]
finishable(teleporters2, 4, 0, 16) => True

But if we started on tile 9, then it is still impossible as tile 16 cannot be reached.
finishable(teleporters2, 4, 9, 16) => False
seq_count=4;
s
Additional Input:
teleporters3 = ["10,8", "11,5", "12,1", "13,9", "2,15"]
teleporters4 = ["2,4", "9,8", "11,7", "12,6", "18,14",
                "19,16", "20,9", "21,14", "22,6", "23,26",
                "25,10", "28,19", "29,27", "31,29", "38,33",
                "39,17", "41,30", "42,28", "45,44", "46,36"]
teleporters5 = ["4,21", "11,18", "13,17", "16,17", "18,21",
                "22,11", "26,25", "27,9", "31,38", "32,43",
                "34,19", "35,19", "36,39", "38,25", "41,31"]
teleporters6 = ["4,6", "5,6", "6,0"]


All Test Cases:
                        die, start, N
finishable(teleporters1, 4,   0,   16)  => False (Above)
finishable(teleporters2, 4,   0,   16)  => True  (Above)
finishable(teleporters2, 4,   9,   16)  => False (Above)
finishable(teleporters3, 4,   9,   16)  => True
finishable(teleporters4, 4,   0,   50)  => False
finishable(teleporters4, 6,   0,   50)  => True
finishable(teleporters5, 4,   0,   50)  => True
finishable(teleporters5, 2,   0,   50)  => False
finishable(teleporters6, 3,   5,   17)  => True


Complexity variable:
N = number of tiles
Note: The number of teleporters, T, and the size of the die, D, are bounded by N.
*/

import java.io.*;
import java.util.*;

public class Fun_w_Teleporters {
    public static void main(String[] argv) {
        String[] teleporters1 = {"10,8", "11,5", "12,7", "13,9"};
        String[] teleporters2 = {"10,8", "11,5", "12,7", "13,9", "2,15"};
        String[] teleporters3 = {"10,8", "11,5", "12,1", "13,9", "2,15"};
        String[] teleporters4 = {"2,4", "9,8", "11,7", "12,6", "18,14",
                "19,16", "20,9", "21,14", "22,6", "23,26",
                "25,10", "28,19", "29,27", "31,29", "38,33",
                "39,17", "41,30", "42,28", "45,44", "46,36"};
        String[] teleporters5 = {"4,21", "11,18", "13,17", "16,17", "18,21",
                "22,11", "26,25", "27,9", "31,38", "32,43",
                "34,19", "35,19", "36,39", "38,25", "41,31"};
        String[] teleporters6 = {"4,6", "5,6", "6,0"};
        // List<Integer> output=destinations(teleporters1,  6,    0,  12);
        // print_the_output(output);

        // output=destinations(teleporters2,  6,   46, 100);
        // print_the_output(output);

        // output=destinations(teleporters2, 10,    0,  50);
        // print_the_output(output);

        // output=destinations(teleporters3, 10,   95, 100);
        // print_the_output(output);

        // output=destinations(teleporters3, 10,   70, 100);
        // print_the_output(output);

        // output=destinations(teleporters4,  6,    0, 100);
        // print_the_output(output);

        // output=destinations(teleporters5,  7,    2,  20);
        // print_the_output(output);
        boolean output = finishable_v2(teleporters1, 4, 0, 16);
        System.out.println("output->" + output);
        output = finishable_v2(teleporters2, 4, 0, 16);
        System.out.println("output->" + output);

        output = finishable_v2(teleporters2, 4, 9, 16);

        System.out.println("output->" + output);
        output = finishable_v2(teleporters3, 4, 9, 16);//  => True

        System.out.println("output->" + output);
        output = finishable_v2(teleporters4, 4, 0, 50);//  => False
        System.out.println("output->" + output);
        output = finishable_v2(teleporters4, 6, 0, 50);//  => True
        System.out.println("output->" + output);
        output = finishable_v2(teleporters5, 4, 0, 50);//  => True
        System.out.println("output->" + output);
        output = finishable_v2(teleporters5, 2, 0, 50);//  => False
        System.out.println("output->" + output);
        output = finishable_v2(teleporters6, 3, 5, 17);//  => True
        System.out.println("output->" + output);

    }

    public static void print_the_output(List<Integer> output) {
        System.out.print("[");
        for (Integer i : output) {
            System.out.print(i + ",");
        }
        System.out.println("]");

    }

    /**
     * Let's try using BFS
     *
     * @param teleporters
     * @param dice_sides
     * @param start_index
     * @param board_size
     * @return
     */
    public static boolean finishable_v2(String[] teleporters, int dice_sides, int start_index, int board_size) {
        Map<Integer, Integer> teleporterMap = getTeleporterMap(teleporters);

        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start_index);
        while (!queue.isEmpty()) {
            Integer currentTile = queue.poll();
            if (currentTile == board_size) {
                return true;
            }
            visitedNodes.add(currentTile);

            List<Integer> destinations = destinations(teleporterMap, dice_sides, currentTile, board_size);
            for (Integer destination : destinations) {

                if (!visitedNodes.contains(destination)) {
                    queue.add(destination);
                    visitedNodes.add(destination);
                }
            }
        }

        return false;
    }

    /**
     * Let's try using DFS
     *
     * @param teleporters
     * @param dice_sides
     * @param start_index
     * @param board_size
     * @return
     */
    public static String findPath(String[] teleporters, int dice_sides, int start_index, int board_size) {
        Map<Integer, Integer> teleporterMap = getTeleporterMap(teleporters);

        HashSet<Integer> seen = new HashSet<>(start_index);
        HashSet<Integer> toVisit = new HashSet<>(start_index);
        // this needs to be a queue or a stack
//        HashSet<Integer> toVisit = new HashSet<>(start_index);
        Stack<Integer> queue = new Stack<>();

        while(!queue.isEmpty()){
//            Integer current=queue.
        }


        return "string";
    }

    public static boolean finishable(String[] teleporters, int dice_sides, int start_index, int board_size) {
        Map<Integer, Integer> teleporterMap = getTeleporterMap(teleporters);

        int prev = 0;
        int i = 0;
        int max_seq = 0;
        int current_seq = 0;
        //{"10,8", "11,5", "12,7", "13,9"};
        for (Map.Entry<Integer, Integer> entry : teleporterMap.entrySet()) {
            if (i == 0) {
                prev = entry.getKey();
                i++;
                current_seq = 1;
                continue;
            } else if (entry.getKey() == prev + 1) {
                prev = entry.getKey();
                i++;
                current_seq++;
            } else {
                prev = entry.getKey();
                i++;
                max_seq = Math.max(max_seq, current_seq);
                current_seq = 1;
            }
            max_seq = Math.max(max_seq, current_seq);
        }
        System.out.println("max_seq->" + max_seq);

        if (max_seq >= dice_sides) {
            return false;
        }
        return true;
    }

    private static Map<Integer, Integer> getTeleporterMap(String[] teleporters) {
        Map<Integer, Integer> teleporterMap = new TreeMap<Integer, Integer>();
        for (String teleporter : teleporters) {
            String[] split = teleporter.split(",");
            Integer start = Integer.parseInt(split[0]);
            Integer end = Integer.parseInt(split[1]);
            teleporterMap.put(start, end);
        }
        return teleporterMap;
    }

    /**
     *
     * @param telporterMap
     * @param dice_sides
     * @param start_index
     * @param board_size
     * @return
     */
    public static List<Integer> destinations(Map<Integer, Integer> telporterMap, int dice_sides, int start_index, int board_size) {
        //populate telporter map

//        Map<Integer, Integer> telporterMap = getTeleporterMap(teleporters);
        Set<Integer> finalEndTileSet = new HashSet<Integer>();
        //now iterate over possible the dice_sides
        int current_index = start_index;
        // int final_index=0;
        boolean isGameOver = false;
        // while(!isGameOver){
        // }
        for (int i = 1; i <= dice_sides; i++) {
            current_index = start_index + i;
            //find this current index in the telporter map
            if (telporterMap.get(current_index) != null) {
                current_index = telporterMap.get(current_index);
            }
            if (current_index >= board_size) {
                finalEndTileSet.add(board_size);
            } else {
                finalEndTileSet.add(current_index);
            }
        }
        return new ArrayList<Integer>(finalEndTileSet);

    }
}
