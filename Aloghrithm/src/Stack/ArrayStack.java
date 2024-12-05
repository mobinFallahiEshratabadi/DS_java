package Stack;

import java.util.Arrays;

public class ArrayStack {
    private int max_size, top = 0;
    private int array_[];

    public ArrayStack(int max_size) {
        this.max_size = max_size;
        array_ = new int[max_size];
    }

    boolean isEmpty() {
        return top == 0;
    }

    public boolean push(int value) {
        if (top < max_size) {
            array_[top] = value;
            top++;
            return true;
        } else return false;
    }

    int Top() throws Exception {
        if (top > 0)
            return array_[top - 1];
        else throw new Exception("stack is empty.");
    }

    public void Print() {
        System.out.println(Arrays.toString(array_));
    }

    public int Pop() throws Exception {
        if (top > 0) {
            top--;
            int temp = array_[top];
            array_[top] = 0;
            return temp;
        } else throw new Exception("stack is empty.");
    }

}
