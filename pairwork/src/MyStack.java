
public class MyStack {
    private int array[]=new int [20];
    private int  index=-1;
    public void push(int i){
        index++;
        array[index]=i;
    }
    public int getTop(){
        return array[index];
    }
    public int pop(){
        int j=array[index];
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