package Hands_On_2;

import java.util.Queue;
import java.util.Stack;

public class Width_First_Search {

    public Width_First_Search(Queue openeQueue, Stack stackClose) {

        Nodes flight = new Nodes();

        System.out.print("== Open Queue ==		== Stack Close ==\n");
        openeQueue.add("NY");
        System.out.print(openeQueue + "                              " + stackClose + "\n");

        while (openeQueue.isEmpty() == false) {

            if (openeQueue.isEmpty()) {
                System.out.print("PASS");
            } else {
                stackClose.add(openeQueue.poll());

                System.out.print(openeQueue + "                              " + stackClose + "\n");
                if (stackClose.lastElement() == "NY") {

                    for (int i = 0; i <= flight.NY.length - 1; i++) {
                        openeQueue.add(flight.NY[i]);
                        System.out.print(openeQueue + "                              " + stackClose + "\n");

                    }
                }

                if (stackClose.lastElement() == "CHI") {

                    for (int i = 0; i <= flight.CHI.length - 1; i++) {
                        openeQueue.add(flight.CHI[i]);
                        System.out.print(openeQueue + "                              " + stackClose + "\n");

                    }
                }
                if (stackClose.lastElement() == "TOR") {

                    for (int i = 0; i <= flight.TOR.length - 1; i++) {
                        openeQueue.add(flight.TOR[i]);
                        System.out.print(openeQueue + "                              " + stackClose + "\n");

                    }
                }
                if (stackClose.lastElement() == "DEN") {

                    for (int i = 0; i <= flight.DEN.length - 1; i++) {
                        openeQueue.add(flight.DEN[i]);
                        System.out.print(openeQueue + "                              " + stackClose + "\n");

                    }
                }
                if (stackClose.lastElement() == "HOW") {

                    for (int i = 0; i <= flight.HOW.length - 1; i++) {
                        openeQueue.add(flight.HOW[i]);
                        System.out.print(openeQueue + "                              " + stackClose + "\n");

                    }
                }

                if (stackClose.lastElement() == "LA") {
                    System.out.println("");
                    System.out.print("The flight arrived in LA\n");
                    System.out.println("");
                    stackClose.pop();
                }

            }		
        }
    }
}
