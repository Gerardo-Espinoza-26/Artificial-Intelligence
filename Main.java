package Hands_On_2;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Stack stackOpen = new Stack();
    static Stack stackClose = new Stack();
    static Queue openQueue = new LinkedList();

    public static void main(String[] args) {

        Width_First_Search width_search = new Width_First_Search(openQueue, stackClose);

    }

}
