package problems.codingtest.tasks;

import java.util.LinkedList;
import java.util.Scanner;

public class Task3 {
    public Task3() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _count = Integer.parseInt(in.nextLine());
        OutputCommonManager(_count, in);
    }

    static void OutputCommonManager(int count, Scanner in) {
        String[] var10000 = new String[]{in.nextLine(), in.nextLine()};
        LinkedList employees = new LinkedList();

        while(in.hasNext()) {
            String[] relation = in.nextLine().split(" ");
            if(employees.indexOf(relation[0]) > -1) {
                if(employees.indexOf(relation[1]) > -1) {
                    employees.add(relation[0]);
                    employees.add(relation[1]);
                } else {
                    employees.add(employees.indexOf(relation[1]), relation[0]);
                }
            } else if(employees.indexOf(relation[1]) > -1) {
                employees.add(employees.indexOf(relation[0]) + 1, relation[1]);
            }
        }

    }
}
