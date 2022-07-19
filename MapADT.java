// --== CS400 Project One File Header ==--
// Name: FNU Simran
// Email: simran4@wisc.edu
// Team: red
// Group: DQ
// TA: Yuye Jiang
// Lecturer: Florian Heimerl
// Notes to Grader: This code executed perfectly on IntelliJ IDEA


import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {

    public boolean put(KeyType key, ValueType value);
    public ValueType get(KeyType key) throws NoSuchElementException;
    public int size();
    public boolean containsKey(KeyType key);
    public ValueType remove(KeyType key);
    public void clear();

}
