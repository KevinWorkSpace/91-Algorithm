package Leetcode.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    private ArrayList<Integer> arrayList;
    private HashMap<Integer, Integer> hashMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        //用ArrayList存储元素, 实现插入和取随机数都能达到O(1)
        arrayList = new ArrayList<>();
        //用hashMap记录元素的索引位置, 实现删除操作达到O(1)
        hashMap = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!hashMap.containsKey(val)) {
            arrayList.add(val);
            hashMap.put(val, arrayList.size()-1);
            return true;
        }
        else return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (hashMap.containsKey(val)) {
            int index = hashMap.get(val);
            if (index != arrayList.size()-1) {
                //将要删的元素跟最后一个元素交换, 每次删除最后一个元素避免数组移动
                int tmp = arrayList.get(arrayList.size()-1);
                hashMap.replace(arrayList.get(arrayList.size()-1), index); // hashMap也要跟着修改
                arrayList.set(arrayList.size()-1, arrayList.get(index));
                arrayList.set(index, tmp);
                arrayList.remove(arrayList.size()-1);
                hashMap.remove(val);
            }
            else {   //考虑只有一个元素的情况
                hashMap.remove(val);
                arrayList.remove(index);
            }
            return true;
        }
        else return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        // int randomIndex = (int) (Math.random() * (arrayList.size() - 1));  这样设置随机数会出现问题, 一直过不了最后一个样例
        int randomIndex = r.nextInt(hashMap.size());
        return arrayList.get(randomIndex);
    }

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();

        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        boolean s1 = randomSet.insert(0);
        boolean s2 = randomSet.insert(1);
        // 返回 false ，表示集合中不存在 2 。
        boolean s3 = randomSet.remove(0);

        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        boolean s4 = randomSet.insert(2);


        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        boolean s5 = randomSet.remove(1);

        int a = randomSet.getRandom();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */