package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {
    public static Map<Integer, String> integerStringMap = new LinkedHashMap<>();
    public static BSTNode bstNode;

    @Test
    void test1() {
        integerStringMap.put(6, "Value 6");
        integerStringMap.put(14, "Value 14");
        integerStringMap.put(5, "Value 5");
        integerStringMap.put(21, "Value 21");
        integerStringMap.put(9, "Value 9");
        integerStringMap.put(24, "Value 24");
        integerStringMap.put(12, "Value 12");
        integerStringMap.put(4, "Value 5");
        integerStringMap.put(22, "Value 22");
        integerStringMap.put(11, "Value 11");
        integerStringMap.put(8, "Value 8");
        integerStringMap.put(15, "Value 15");
        integerStringMap.put(13, "Value 13");
        integerStringMap.put(19, "Value 19");
        integerStringMap.put(18, "Value 18");
        integerStringMap.put(16, "Value 16");
        integerStringMap.put(23, "Value 23");
        integerStringMap.put(17, "Value 17");
        integerStringMap.put(10, "Value 10");
        integerStringMap.put(7, "Value 7");
        integerStringMap.put(20, "Value 20");
    }

    @Test
    void test2() {
        bstNode = new BSTNode(4, integerStringMap.get(4));
        for (int key : integerStringMap.keySet()) {
            String value = integerStringMap.get(key);
            bstNode.insert(bstNode, key, value);
        }
        assertEquals(integerStringMap.size(), bstNode.countNodes(bstNode));
    }

    @Test
    void test3() {
        BSTNode node;
        node = bstNode.search(bstNode, 18);
        assertEquals("Value 18", node.getValue());

        node = bstNode.search(bstNode, 24);
        assertEquals("Value 24", node.getValue());

        node = bstNode.search(bstNode, 1);
        assertNull(node);
    }

    @Test
    void test4() {
        BSTNode node;

        bstNode = new BSTNode(4, integerStringMap.get(4));
        for (int key : integerStringMap.keySet()) {
            if (key == 8) {
                continue;
            }
            String value = integerStringMap.get(key);
            bstNode.insert(bstNode, key, value);
        }
        assertEquals(integerStringMap.size() - 1, bstNode.countNodes(bstNode));

        bstNode.insert(bstNode, 8, "Value 8");
        assertEquals("Value 8", bstNode.search(bstNode, 8).getValue());

        bstNode.insert(bstNode, 8, "Value 8 second insert");
        int nodeCount = bstNode.countNodes(bstNode);
        assertEquals(integerStringMap.size(), nodeCount);

        node = bstNode.search(bstNode, 8);
        assertEquals("Value 8 second insert", node.getValue());
    }

    @Test
    void test5() {
        BSTNode node;
        bstNode = bstNode.delete(bstNode, 8);
        assertEquals(integerStringMap.size() -1, bstNode.countNodes(bstNode));
        node = bstNode.search(bstNode, 8);
        assertNull(node);
    }

}