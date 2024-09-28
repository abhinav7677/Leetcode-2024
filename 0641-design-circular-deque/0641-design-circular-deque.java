class MyCircularDeque {

    class Node {
        int data;
        Node next;
        Node prev;  // Double link for circular deque

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    int maxLength;
    int len;
    Node front;
    Node rear;

    public MyCircularDeque(int k) {
        this.maxLength = k;
        this.len = 0;
        this.front = null;
        this.rear = null;
    }

    public boolean insertFront(int value) {
        if (len == maxLength) return false;  // Check if deque is full

        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;  // First node becomes both front and rear
            front.next = front.prev = front;  // Circular link
        } else {
            newNode.next = front;
            newNode.prev = rear;
            front.prev = newNode;
            rear.next = newNode;
            front = newNode;
        }
        len++;
        return true;
    }

    public boolean insertLast(int value) {
        if (len == maxLength) return false;  // Check if deque is full

        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;  // First node becomes both front and rear
            front.next = front.prev = front;  // Circular link
        } else {
            newNode.prev = rear;
            newNode.next = front;
            rear.next = newNode;
            front.prev = newNode;
            rear = newNode;
        }
        len++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;  // Check if deque is empty

        if (front == rear) {  // Single element
            front = rear = null;
        } else {
            front = front.next;
            front.prev = rear;
            rear.next = front;
        }
        len--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;  // Check if deque is empty

        if (front == rear) {  // Single element
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = front;
            front.prev = rear;
        }
        len--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : front.data;
    }

    public int getRear() {
        return isEmpty() ? -1 : rear.data;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == maxLength;
    }
}