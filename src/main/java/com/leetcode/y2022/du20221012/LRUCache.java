package com.leetcode.y2022.du20221012;


import java.util.HashMap;

/**
 * LRU cache
 */
public class LRUCache {
    /**
     * 缓存容量
     */
    private final int capacity;
    private HashMap<Integer, Entry> map;

    private Entry head;
    private Entry tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>((int) (capacity / 0.75 + 1), 0.75f);
        head = new Entry(0, 0);
        tail = new Entry(0, 0);


        head.next = tail;
        tail.prev = head;
    }


    /**
     * 获取
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            // 将 entry 移动到最后
            popTail(entry);
            return entry.value;
        }
        return -1;
    }

    private void popTail(Entry entry) {
        Entry prev = entry.prev;
        Entry next = entry.next;

        prev.next = next;
        next.prev = prev;

        Entry lastPrev = tail.prev;
        lastPrev.next = entry;
        tail.prev = entry;

        entry.prev = lastPrev;
        entry.next = tail;
    }

    /**
     * 缓存
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            // 更新 value
            entry.value = value;
            // 移动到最末尾
            popTail(entry);
        } else {
            Entry newEntry = new Entry(key, value);
            if (map.size() >= capacity) {
                // 删除最前面的 Entry
                Entry removeFirstEntry = removeFirstEntry();
                map.remove(removeFirstEntry.key);
            }

            addTail(newEntry);
            map.put(newEntry.key, newEntry);
        }
    }

    private void addTail(Entry newEntry) {
        Entry prev = tail.prev;

        prev.next = newEntry;
        tail.prev = newEntry;

        newEntry.prev = prev;
        newEntry.next = tail;
    }

    private Entry removeFirstEntry() {
        Entry removeEntry = head.next;

        Entry next = removeEntry.next;

        head.next = next;
        next.prev = head;
        return removeEntry;
    }

    class Entry {
        int key;
        int value;

        Entry prev;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 2);
        cache.put(3, 4);
        cache.put(5, 6);
        cache.put(7, 8);

        System.out.println(cache.get(1));
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.get(7));
    }
}
