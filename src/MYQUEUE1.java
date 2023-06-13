public class MYQUEUE1 {
    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, rear;

    public static void quickSort (int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source [(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightMarker) {
            quickSort(source, leftBorder, rightBorder);
        }
        if (leftBorder < rightBorder) {
            quickSort(source, leftMarker, rightMarker);
        }
    }

    MYQUEUE1() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (front == 0 && rear == SIZE - 1){
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1){
            return true;
        }
        else {
            return false;
        }
    }

    void enQueue (int element){
        if (isFull()){
            System.out.println("Queue is full");
        } else {
            if (front == -1){
                front = 0;
            }
            rear++;
            items[rear] = element;
            quickSort(items, front, rear);
            System.out.println("Element " + element + " was successfully added");
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()){
            System.out.println("Queue is empty");
            return (-1);
        }
        else {
            element = items[front];
            if (front >= rear){
                front = -1;
                rear = -1;
            }
            else {
                front++;
            }
            System.out.println("Element " + element + " was successfully removed");
            return element;
        }
    }

    void display(){
        int i;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        else {
            System.out.println("\nIndex FRONT >>> " + front);
            System.out.println("Element >>> ");
            for (i = front; i <= rear; i++){
                System.out.println(items[i] + " ");
            }
            System.out.println("\nIndex REAR >>> " + rear);
        }
    }

    public static void main(String[] args) {
        MYQUEUE1 q = new MYQUEUE1();
        q.deQueue();

        q.enQueue(4);
        q.enQueue(1);
        q.enQueue(3);
        q.enQueue(2);
        q.enQueue(5);

        q.enQueue(6);

        q.display();

        q.deQueue();

        q.display();

    }
}
