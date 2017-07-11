package 算法分类.上机真题.比较重量网易;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jackson on 2017/6/28.
 */
public class Main2 {
    public int cmp(int g1, int g2, int[][] records, int n) {
        Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        int max=0;
        for(int[] pair:records){
            if(!map.containsKey(pair[0])){
                List<Integer> list=new ArrayList<Integer>();
                list.add(pair[1]);
                map.put(pair[0],list);
            }
            else map.get(pair[0]).add(pair[1]);
            int temp=(pair[0]>pair[1])?pair[0]:pair[1];
            max=(max>temp)?max:temp;
        }
        boolean[] isVisited1=new boolean[++max];
        boolean[] isVisited2=new boolean[max];
        if(isReachable(g1,g2,map,isVisited1)) return 1;
        else if(isReachable(g2,g1,map,isVisited2)) return -1;
        else return 0;

    }
    private boolean isReachable(int now,int target,Map<Integer,List<Integer>> map,boolean[] isVisited){
        if(now==target) return true;
        isVisited[now]=true;
        if(map.get(now)==null) return false;
        int size=map.get(now).size();
        for(int i=0;i<size;i++){
            int next=map.get(now).get(i);
            if(isVisited[next]) continue;
            else if(isReachable(next,target,map,isVisited)) return true;
        }
        return false;
    }
}
