class RandomizedSet {
    // array list to store value
    private ArrayList<Integer> nums;
    // hash map to store value and stored index, value => nums's index
    private HashMap<Integer, Integer> valLocation;
    private Random rand;
    
    public RandomizedSet() {
        valLocation = new HashMap();
        nums = new ArrayList();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        // if value already exist
        if (valLocation.containsKey(val)) return false;
        // add value and stored index
        valLocation.put(val, nums.size());
        // add value to list
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valLocation.containsKey(val)) return false;
        int valIndex = valLocation.get(val);
        // if target is not the last element, copy last element to target
        if (valIndex < nums.size() - 1) {
            int lastValue = nums.get(nums.size() - 1);
            nums.set(valIndex, lastValue);
            valLocation.put(lastValue, valIndex);
        }
        // delete last element
        nums.remove(nums.size() - 1);
        valLocation.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */