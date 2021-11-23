import java.util.*;

public class OurHashMap <K,V> implements Map<K,V> {

    private final int SIZE = 16;
    private int numElements;

    class Entry<K,V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Entry>[] values = new List[SIZE];

    private List<Entry> getEntries(Object key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % SIZE;
        return values[index];
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        List<Entry> list = getEntries(key);
        if (list == null) {
            return false;
        }
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(List<Entry> list: values){
            if (list != null){
                for(Entry entry: list){
                    if(entry.value.equals(value)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        List<Entry> list = getEntries(key);
        if (list == null) {
            return null;
        }
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        if (list == null) {
            list = new ArrayList<Entry>();
            values[index] = list;
        }

        for (Entry<K,V> entry : (List<Entry<K,V>>) list) {
            if (entry.key.equals(key)) {
                V saved = entry.value;
                entry.value = value;
                return saved;
            }
        }

        Entry entry = new Entry(key,value);
        list.add(entry);
        numElements ++;

        return null;
    }

    @Override
    public V remove(Object key) {
        List<Entry> list = getEntries(key);
        for(Entry entry: list){
            if(entry.key.equals(key)){
                V value = (V) entry.value;
                list.remove(entry);
                numElements --;
                return value;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Map.Entry<? extends K, ? extends V> entry: m.entrySet()){
            put(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public void clear() {
        numElements = 0;
        values = new List[SIZE];
    }

    @Override
    public Set keySet() {
        Set<K> keySet = new HashSet<>();
        for(List<Entry> list: values){
            if (list != null){
                for(Entry entry: list){
                    keySet.add((K) entry.key);
                }
            }
        }
       return keySet;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collectionValues = new ArrayList<>();
        for(List<Entry> list: values){
            if (list != null){
                for(Entry entry: list){
                    collectionValues.add((V) entry.value);
                }
            }
        }
        return collectionValues;
    }

    //TODO
    @Override
    public Set<java.util.Map.Entry<K,V>> entrySet() {
        return null;
    }
}
