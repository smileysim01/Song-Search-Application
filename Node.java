// --== CS400 Project One File Header ==--
// Name: FNU Simran
// Email: simran4@wisc.edu
// Team: Red
// Group: DQ
// TA: Yuye J
// Lecturer: Florian Heimerl
// Notes to Grader: none

public class Node<KeyType, ValueType> {

    private KeyType key;
    private ValueType value;

    public Node(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return this.key;
    }

    public ValueType getValue() {
        return this.value;
    }

}

