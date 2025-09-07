class RandomizedSet {
    private ArrayList<Integer> list;
    private HashMap<Integer,Integer> map;
    private Random rand;
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
            list.add(val);
            map.put(val,list.size()-1);
            return true;
    }
    // 1 2 3 4 5 6 7
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int ind=map.get(val);
        int last_ele=list.get(list.size()-1);
        list.set(ind,last_ele);
        map.put(last_ele,ind);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        int val=rand.nextInt(list.size());
        return list.get(val);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */