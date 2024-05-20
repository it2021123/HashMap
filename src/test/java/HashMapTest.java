

import com.potis.hashmap.HashMap;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ΧΑΡΑΛΑΜΠΟΣ
 */
public class HashMapTest {
 
   @Test
    public void testPutWithCollision() {
        HashMap<String, Integer> hashMap = new HashMap<>(2);
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        assertEquals(1, (int)hashMap.get("a"));
        assertEquals(2, (int)hashMap.get("b"));
        assertEquals(2, hashMap.size());
    }
    
    @Test
    public void testRemoveWithCollision() {
        HashMap<String, Integer> hashMap = new HashMap<>(2);
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        assertEquals(2, (int)hashMap.remove("b"));
        assertEquals(null, hashMap.get("b"));
    }
    
    
    
}