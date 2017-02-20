package main.com.savchik.task2;

public class Sequence {
    private int startIndex;
    private int endIndex;

    public Sequence(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}
