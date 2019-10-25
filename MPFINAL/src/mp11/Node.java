package mp11;

public class Node<K, V> {

  private K key;
  private V value;
  private Node<K, V> next;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K key() {
    return this.key;
  }

  public V value() {
    return this.value;
  }

  public void value(V value) {
    this.value = value;
  }

  public Node<K, V> next() {
    return this.next;
  }

  public void next(Node<K, V> next) {
    this.next = next;
  }

  public boolean hasNext() {
    return this.next != null;
  }

}
