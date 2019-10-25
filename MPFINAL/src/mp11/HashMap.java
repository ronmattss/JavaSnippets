package mp11;

public class HashMap<K, V> {

  private final int DEFAULT_BUCKETSIZE = 17;
  private List<Node<K, V>> bucket;
  private int bucketSize;
  private int size;

  public HashMap() {
    bucket = new List<>();
    bucketSize = DEFAULT_BUCKETSIZE;
    size = 0;

    for (int i = 0; i < bucketSize; i++)
      bucket.add(null);
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }


  public int index(K key) {
    return Math.abs(key.hashCode()) % bucketSize;
  }


  public void add(K key, V value) {
    int index = index(key);
    Node<K, V> head = bucket.get(index);

    while (head != null) {
      if (head.value().equals(value)) {
        return;
      }

      head = head.next();
    }

    this.size++;
    head = bucket.get(index);
    Node<K, V> newNode = new Node<>(key, value);
    newNode.next(head);
    bucket.set(index, newNode);

    if ((1.0 * size) / bucketSize >= 7.0) {
      List<Node<K, V>> temp = bucket;
      bucket = new List<>();
      bucketSize = this.bucketSize * 2;
      size = 0;

      for (int i = 0; i < bucketSize; i++) {
        bucket.add(null);
      }

      for (Node<K, V> node : temp) {
        while (node != null) {
          add(node.key(), node.value());
          node = node.next();
        }
      }
    }
  }

  public Node<K, V> get(K key) {
    int index = index(key);
    Node<K, V> head = bucket.get(index);

    while (head != null) {
      if (head.key().equals(key)) {
        return head;
      }

      head = head.next();
    }

    return null;
  }


}
