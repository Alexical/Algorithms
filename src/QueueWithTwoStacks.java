import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueWithTwoStacks<Item> {

    private Stack<Item> in = new Stack<>();
    private Stack<Item> out = new Stack<>();

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    public int size() {
        return in.size() + out.size();
    }

    public Item peek() {
        reverse();
        return out.peek();
    }

    public void enqueue(Item item) {
        in.push(item);
    }

    public Item dequeue() {
        reverse();
        return out.pop();
    }

    private void reverse() {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-"))
                StdOut.println(queue.dequeue() + " ");
            else queue.enqueue(item);
        }
    }

}
