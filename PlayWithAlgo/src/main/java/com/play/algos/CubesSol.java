package com.play.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CubesSol {

  static ArrayList<Long> cubes= new ArrayList<>();
  static ArrayList<Long> prime= new ArrayList<>();

  public int solve(ArrayList<Integer> A) {

    initPrimeCube();

    HashMap<Long,Long> mp= new HashMap<>();
    for(int i=0; i<A.size(); i++)
    {
      long x = (long)divfact(A.get(i));
      if(!mp.containsKey(x))
        mp.put(x,(long)1);
      else
        mp.put(x, mp.get(x)+1);
    }
    long ans = 0;
    HashSet<Long> done= new HashSet<>();
    for(long it : mp.keySet())
    {
      long alpha = it;
      long cnt = mp.get(it);
      long beta = complement(alpha);

      if(done.contains(alpha))
        continue;

      if(alpha == beta)
      {
        ans++;
        continue;
      }

      if(mp.containsKey(beta))
      {
        ans += Math.max(cnt, mp.get(beta));
        done.add(alpha);
        done.add(beta);
      }
      else
      {
        done.add(alpha);
        ans += cnt;
      }
    }
    return (int)ans;
  }

  static boolean is_p(long x){
    for(long i=2;i*i<=x;i++){
      if(x%i==0)
        return false;
    }
    return true;
  }


  static void initPrimeCube(){
    cubes.clear();
    prime.clear();
    for(int i=2;i<100;i++){
      if(is_p(i))
        cubes.add((long)(i*i*i));
    }

    for(int i=2;i<100011;i++){
      if(is_p(i))
        prime.add((long)i);
    }
  }

  static long divfact(long x){
    for(int i=0;i<cubes.size();i++){
      long q= cubes.get(i);
      if(q>x)
        break;
      while(x%q==0)
        x/=q;
    }
    return x;
  }

  static long complement(long x) {
    long y = 1;
    for (int i=0; i<prime.size(); i++) {
      long p = prime.get(i);
      if (p * p > x) break;
      if (x % p == 0) {
        if (((x / p) % p) == 0){
          y = y*p;
          x /= p;
          x /= p;
        }
        else{
          y = y*p*p;
          x /= p;
        }
      }
    }
    if (x != 1) y = y*x*x;
    return y;
  }

}


