class Solution:
    def sumOfDistancesInTree(self, n,edges):
            result=[0]*n
            self.dist =0
            hashmap = self.create_map(edges)
            hashmap[0].append(0)
            base = {}
            self.r(0,hashmap,base,set(),0)
            result[0]=self.dist
            self.U(0,self.dist,hashmap,base,result,set())
            return result
    def r(self,key,hashmap,base,considered,count):
        if key not in considered:
            considered.add(key)
            self.dist +=count
            val=len(hashmap[key])-1
            for child in hashmap[key]:val+=self.r(child,hashmap,base,considered,count+1)
            base[key]=val
            return val
        return 0
    def create_map(self,edges):
        from collections import defaultdict
        hashmap=defaultdict(list)
        for x,y in edges:hashmap[x].append(y),hashmap[y].append(x)
        return hashmap
    def U(self,key,current,hashmap,base,result,considered):
        if key not in considered:
            considered.add(key)
            for i in hashmap[key]:
                if i not in considered:
                    val=current + base[0] -(2*base[i])-1
                    result[i]=val
                    self.U(i,val,hashmap,base,result,considered)