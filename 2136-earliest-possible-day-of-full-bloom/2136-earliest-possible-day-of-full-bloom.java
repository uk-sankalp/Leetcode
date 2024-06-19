class Pair{
    int growTime, plantTime;
    Pair(int growTime, int plantTime)
    {
        this.growTime = growTime;
        this.plantTime = plantTime;
    }
}
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime)
    {
        List<Pair>flowers = new ArrayList();
        int flowerCount = plantTime.length;
        for (int i = 0; i < flowerCount; i++) flowers.add(new Pair(growTime[i], plantTime[i]));
        //=========================================================
        //Sort the flowers on basis of decreasing growTime
        Collections.sort(flowers, (Pair a, Pair b)->{  //OR "return (a.growTime - b.growTime)"
            if (a.growTime > b.growTime) return -1;
            else if (a.growTime < b.growTime) return 1;
            else return 0;
        });
        //========================================================
        //currTime denotes the time at which I finished planting the current flower
        //After the currentTime I am now free to plant another plant while the current flower grows 
        //  SAVE TIME :)
        int currTime = 0, mxBloomTime = 0;
        for (Pair flower : flowers)
        {
            currTime += flower.plantTime; 
            int bloomTime = currTime + flower.growTime; //current flower will bloom at bloonTime
            mxBloomTime = Math.max(mxBloomTime, bloomTime);
        }
        //=======================================================
        return mxBloomTime;
        
    }
}