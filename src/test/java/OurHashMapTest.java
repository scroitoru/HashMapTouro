import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    @Test
    void size(){
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");

        //then
        assertEquals(2, map.size());
    }

    @Test
    void isEmpty(){
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");

        //then
        assertFalse(map.isEmpty());
    }

    @Test
    void containsKey(){
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");

        //then
        assertTrue(map.containsKey("ENGLISH1"));
    }

    @Test
    void containsValue(){
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");

        //then
        assertTrue(map.containsValue("HELLO"));
    }

    @Test
    void getNull() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when

        // then
        assertNull(map.get("ENGLISH1"));
    }

    @Test
    void put() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("ENGLISH2", "HI");
        map.put("ENGLISH3", "HEY");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("RUSSIAN", "PRIVIT");
        map.put("JAPANESE", "NE HOW");
        map.put("MANDARIN", "CONICHIWA");

        // then
        assertEquals("HELLO", map.get("ENGLISH1"));
        assertEquals("HI", map.get("ENGLISH2"));
        assertEquals("HEY", map.get("ENGLISH3"));
        assertEquals("HOLA", map.get("SPANISH"));
        assertEquals("SHALOM", map.get("HEBREW"));
        assertEquals("BONJOUR", map.get("FRENCH"));
        assertEquals("PRIVIT", map.get("RUSSIAN"));
        assertEquals("NE HOW", map.get("JAPANESE"));
        assertEquals("CONICHIWA", map.get("MANDARIN"));
    }

    @Test
    void putSameKeys() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("ENGLISH1", "HI");

        // then
        assertEquals("HI", map.get("ENGLISH1"));
    }

    @Test
    void remove(){
        //given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.remove("ENGLISH1");

        //then
        assertFalse(map.containsKey("ENGLISH1"));
    }

    @Test
    void putAll(){
        //given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        Map<String, String> newMap = new HashMap<>();
        newMap.put("ENGLISH1", "HELLO");
        newMap.put("SPANISH", "HOLA");
        map.putAll(newMap);

        //then
        assertTrue(map.containsKey("ENGLISH1"));
        assertTrue(map.containsKey("SPANISH"));
        assertTrue(map.containsValue("HELLO"));
        assertTrue(map.containsValue("HOLA"));
        assertEquals(2, map.size());
    }

    @Test
    void clear(){
        //given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.clear();

        //then
        assertTrue(map.isEmpty());
    }

    @Test
    void keySet(){
        //given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        Set<String> keySet = map.keySet();

        //then
        assertTrue(keySet.contains("ENGLISH1"));
        assertTrue(keySet.contains("SPANISH"));
    }

    @Test
    void values(){
        //given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        Collection<String> collectionValues = map.values();

        //then
        assertTrue(collectionValues.contains("HELLO"));
        assertTrue(collectionValues.contains("HOLA"));
    }

}