package com.mall4j.cloud.common.dto;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

public class CarterHashMap<K,V>  {
    //序列号
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 默认的初始容量是16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * 最大容量
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 默认的填充因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 当桶(bucket)上的结点数大于这个值时会转成红黑树
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 当桶(bucket)上的结点数小于这个值时树转链表
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 桶中结构转化为红黑树对应的table的最小容量
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /**
     * node节点源码
     * @param <K>
     * @param <V>
     */
    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final boolean equals(Object o){
            if (o==this){
                return true;
            }
            if (o instanceof Map.Entry){
                Entry<?, ?> e = (Entry<?, ?>) o;
                if (Objects.equals(key,e.getKey())&&Objects.equals(value,e.getValue())){
                    return true;
                }
            }
            return false;
        }
    }

}
