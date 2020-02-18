607. Two Sum III - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example
Example 1:

add(1); add(3); add(5);
find(4) // return true
find(7) // return false

//array
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    List<Integer> list = new ArrayList<Integer>();
    public void add(int number) {
        // write your code here
        list.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (int i=0; i<list.size(); i++) {
            int temp = value - list.get(i);
            for (int j=0; j<list.size(); j++) {
                if (j != i && temp == list.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}


//hashmap
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public void add(int number) {
        // write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number)+1);
        }
        else {
            map.put(number, 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (int i: map.keySet()) {
            int temp = value - i;
            if (map.containsKey(temp)) {
                if (temp != i || (temp == i && map.get(temp) != 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}