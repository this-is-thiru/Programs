package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoPointerNode {
    int data;
    OnePointerNode bottom;
    TwoPointerNode next;

    TwoPointerNode(int data, OnePointerNode bottom, TwoPointerNode next) {
        this.bottom = bottom;
        this.next = next;
        this.data = data;
    }
}

class OnePointerNode {
    int data;
    OnePointerNode next;

    OnePointerNode(int data, OnePointerNode next) {
        this.next = next;
        this.data = data;
    }
}

public class Temp2 {
    public static void main(String[] args) {
        TwoPointerNode tpn1 = new TwoPointerNode(5, null, null);
        TwoPointerNode tpn2 = new TwoPointerNode(10, null, null);
        TwoPointerNode tpn3 = new TwoPointerNode(19, null, null);
        TwoPointerNode tpn4 = new TwoPointerNode(28, null, null);

        tpn1.next = tpn2;
        tpn2.next = tpn3;
        tpn3.next = tpn4;

        OnePointerNode opn11 = new OnePointerNode(7, null);
        OnePointerNode opn12 = new OnePointerNode(8, null);
        OnePointerNode opn13 = new OnePointerNode(30, null);
        opn11.next = opn12;
        opn12.next = opn13;

        OnePointerNode opn21 = new OnePointerNode(20, null);

        OnePointerNode opn31 = new OnePointerNode(22, null);
        OnePointerNode opn32 = new OnePointerNode(50, null);
        opn31.next = opn32;

        tpn1.bottom = opn11;
        tpn2.bottom = opn21;
        tpn3.bottom = opn31;

        List<Integer> list = new ArrayList<>();
        TwoPointerNode temp = tpn1;
        while (temp != null) {
            list.add(temp.data);
            addToList(list, temp.bottom);
            temp = temp.next;
        }
        Collections.sort(list);
        System.out.println(list);
    }

    private static void addToList(List<Integer> list, OnePointerNode node) {
        OnePointerNode temp = node;
        while (temp!= null) {
            list.add(temp.data);
            temp = temp.next;
        }
    }
}

// Create a hard-coded linked list:
// 5 -> 10 -> 19 -> 28
// |    |      |
// V    V      V
// 7    20     22
// |            |
// V            V
// 8            50
// |
// V
// 30
