// Name: FNU Simran
// Email: simran4@wisc.edu
// Team: Red
// Group: DQ
// TA: Yuye J
// Lecturer: Florian Heimerl
// Notes to Grader: none

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class defines various methods for implementing a Hashtable
 * @author Simran
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType>{

    //Main hashtable array containing Linked List objects
    private LinkedList<Node<KeyType, ValueType>>[] table;

    private int size; // Size of the hashtable (number of nodes)
    private int capacity; // Current capacity of the table array
    private double loadFactor; // Current load factor
    private static final double threshold = 0.80; // Constant variable for the threshold value

    /**
     * This constructor initializes the HashtableMap object's array with the given capacity
     * @param capacity size of the array for the hashtable
     */
    @SuppressWarnings("unchecked")
    public HashtableMap (int capacity) {
        // Initializing array
        table = (LinkedList<Node<KeyType, ValueType>>[]) new LinkedList[capacity];
        this.capacity = capacity;
        //currentCapacity = capacity;
    }

    /**
     * This constructor initializes the HashtableMap object's array with a default capacity of 20
     */
    @SuppressWarnings("unchecked")
    public HashtableMap() {
        // Default capacity is 20
        table = (LinkedList<Node<KeyType, ValueType>>[]) new LinkedList[20];
        capacity = table.length;
    }

    /**
     * This method adds the given key-value pair to the hashtable
     * @param key The key object
     * @param value The value object
     * @return true if key-value pair was added successfully; false otherwise
     */
    @Override
    public boolean put(KeyType key, ValueType value) {
        // Return false when the key is null
        if (key == null) {
            return false;
        }
        // Check if the key is a duplicate; return false if the key is a duplicate
        if (containsKey(key)) {
            return false;
        }

        // Calculating the hash value of the entry
        int hashIndex = getHashIndex(key);
        // Checking for collision
        if (table[hashIndex] != null) {
            // Handle collision here and add new node to the current LinkedList
            table[hashIndex].add(new Node<KeyType, ValueType>(key, value));
            size++;

        } else {
            // Create new LinkedList element in the table array
            table[hashIndex] = new LinkedList<Node<KeyType, ValueType>>();

            // Add a new node to the Linked List
            table[hashIndex].add(new Node<KeyType, ValueType>(key, value));
            size++;

        }
        // Check load factor and rehash if necessary
        loadFactor = ((double) size) / ((double) table.length);
        if (loadFactor >= threshold) {
            rehash();
        }

        return true; // If the key-value pair has been added successfully, the method will return true


    }

    /**
     * This method returns the value stored by the given key in the hashtable
     * @param the key object
     * @return the value object stored by the key
     * @throws NoSuchElementException when the key is not found
     */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        int hashIndex = getHashIndex(key);
        if (table[hashIndex] == null) {
            throw new NoSuchElementException("No element with this key value was found.");
        }
        for (int i = 0; i < table[hashIndex].size(); i++) {
            if (table[hashIndex].get(i).getKey().equals(key)) {
                return table[hashIndex].get(i).getValue();
            }
        }
        throw new NoSuchElementException("No element with this key value was found.");
    }
    /**
     * This method returns the current size of the hashtable
     * @return int containing the current size of the hashtable
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * This method checks if the given key is stored in the hashtable
     * @param key - The key object to check
     * @return true if the key is present; false otherwise
     */
    @Override
    public boolean containsKey(KeyType key) {
        if (key == null) {
            return false; // Return false is the key is null
        }
        int hashIndex = getHashIndex(key);
        if (table[hashIndex] != null) {
            // If the array index is not empty, iterate through the linkedList
            for (int i = 0; i < table[hashIndex].size(); i++) {
                if (table[hashIndex].get(i).getKey().equals(key)) {
                    // Return true if the key is found
                    return true;
                }
            }
        }
        // If no key is found, the method will return false
        return false;
    }

    /**
     * This method removes the key-value pair specified by the key object and returns a reference to
     * the value object
     * @param key - the key associated with the key-value pair
     * @return the value associated with the key-value pair
     */
    @Override
    public ValueType remove(KeyType key) {
        if (key == null) {
            return null;
        }
        int hashIndex = getHashIndex(key);

        if (table[hashIndex] == null) {
            return null;
        }

        ValueType returnValue;
        for (int i = 0; i < table[hashIndex].size(); i++) {
            if (table[hashIndex].get(i).getKey().equals(key)) {
                returnValue = table[hashIndex].get(i).getValue();
                table[hashIndex].remove(i);
                size--;
                return returnValue;
            }
        }
        System.out.println("No value found");
        return null;
    }

    /**
     * This method clears all key-value pairs from the hashtable and retains the same capacity
     */
    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        table = (LinkedList<Node<KeyType, ValueType>>[]) new LinkedList[this.capacity];
        size = 0;
    }

    /**
     * This method rehashes the hashtable and doubles the current capacity
     */
    private void rehash() {
        LinkedList<Node<KeyType, ValueType>> temp = new LinkedList<Node<KeyType, ValueType>>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (int j = 0; j < table[i].size(); j++) {
                    temp.add(table[i].get(j));
                }
            }
        }

        this.capacity *= 2;
        this.clear();
        for (int i = 0; i < temp.size(); i++) {
            this.put(temp.get(i).getKey(), temp.get(i).getValue());
        }
    }

    /**
     * This private helper method calculates the hash index of the given key objects
     * @param key - the key object
     * @return int containing the hash index of the key object
     */
    private int getHashIndex(KeyType key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

}
