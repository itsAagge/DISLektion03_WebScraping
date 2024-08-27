package opgave08.Flettesortering;

import java.util.List;

public class MergesortThread extends Thread {

    FletteSortering fletteSortering;
    List<Integer> list;
    int low;
    int high;


    public MergesortThread(FletteSortering fletteSortering, List<Integer> list, int low, int high) {
        this.fletteSortering = fletteSortering;
        this.list = list;
        this.low = low;
        this.high = high;
    }

    public void run() {
        fletteSortering.mergesort(list, low, high);
    }
}
