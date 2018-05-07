public class MyStackChar {
    private char array[] = new char[20];
    private int index = -1;

    public void push(char i) {
        index++;
        array[index] = i;
    }

    public char getTop() {
        return array[index];
    }

    public char pop() {
        char j = array[index];
        index--;
        return j;

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}