class RentObject implements Comparable<RentObject>{
    int shop;
    int movie;
    int price;
    RentObject(int shop, int movie, int price){
        this.shop = shop;
        this.movie = movie;
        this.price = price;
    }
    @Override
    public int compareTo(RentObject otherObject) {
        if (this.price != otherObject.price) {
            return Integer.compare(this.price, otherObject.price);
        } else if (this.shop != otherObject.shop) {
            return Integer.compare(this.shop, otherObject.shop);
        } else {
            return Integer.compare(this.movie, otherObject.movie);
        }
    }

}

class ShopObject{
    int shop;
    int movie;
    ShopObject(int shop, int movie){
        this.shop = shop;
        this.movie = movie;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ShopObject that = (ShopObject) obj;
        return shop == that.shop && movie == that.movie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shop, movie);
    }
}

class MovieRentingSystem {
    TreeSet<RentObject> rented;
    HashMap<Integer, TreeSet<RentObject>>unrentedForMovie;
    HashMap<ShopObject, Integer> prices;
    public MovieRentingSystem(int n, int[][] entries) {
        rented = new TreeSet<>();
        prices = new HashMap<>();
        unrentedForMovie = new HashMap<>();
        int m = entries.length;
        for(int i=0;i<m;i++){
            int shop = entries[i][0];
            int movie = entries[i][1];
            int price = entries[i][2];
            RentObject r = new RentObject(shop, movie, price);
            ShopObject s = new ShopObject(shop, movie);
            prices.put(s, price);
            if(unrentedForMovie.containsKey(movie)){
                TreeSet<RentObject> unrentedSet = unrentedForMovie.get(movie);
                unrentedSet.add(r);
                unrentedForMovie.put(movie, unrentedSet);
            }
            else{
                TreeSet<RentObject> unrentedSet = new TreeSet<>();
                unrentedSet.add(r);
                unrentedForMovie.put(movie, unrentedSet);
            }
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        int cnt = 5;
        if(unrentedForMovie.containsKey(movie)){
            for(RentObject p: unrentedForMovie.get(movie)){
                if(cnt == 0) break;
                res.add(p.shop);
                cnt-=1;
                
            }
        }
        
        return res;
    }
    
    public void rent(int shop, int movie) {
        ShopObject s = new ShopObject(shop, movie);
        int price = prices.get(s);
        RentObject r = new RentObject(shop, movie, price);
        TreeSet<RentObject> unrentedSet = unrentedForMovie.get(movie);
        unrentedSet.remove(r);
        rented.add(r);

    }
    
    public void drop(int shop, int movie) {
        ShopObject s = new ShopObject(shop, movie);
        int price = prices.get(s);
        RentObject r = new RentObject(shop, movie, price);
        rented.remove(r);
        TreeSet<RentObject> unrentedSet = unrentedForMovie.get(movie);
        unrentedSet.add(r);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int cnt = 5;
        for(RentObject p: rented){
            if(cnt == 0) break;
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(p.shop);
            tmp.add(p.movie);
            res.add(tmp);
            cnt-=1;
        }
        return res;
    }
}