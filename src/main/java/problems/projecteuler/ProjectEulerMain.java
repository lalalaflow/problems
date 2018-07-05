package problems.projecteuler;

import org.slf4j.bridge.SLF4JBridgeHandler;
import problems.projecteuler.problem.Problem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.logging.LogManager;

public class ProjectEulerMain {

    static {
        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.install();
    }

    static int[] arrayPackage = new int[]{20, 40, 60, 80, 100};
    static String packageName = "problems.projecteuler.problem.difficulty_";
    static String defaultPackage = "1";
    static String defaultClassName = "Problem";
    static String currentProblem = "7";

    public ProjectEulerMain() {
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        String packageNumber = "1";
        System.out.print("Please, choose package : \n1 - Problem1-20 \nAnswer : ");
        scanner = new Scanner(System.in);
        packageNumber = scanner.nextLine();
        int packageIdx = 1;
        if(null != packageNumber && !"".equals(packageNumber)) {
            packageIdx = Integer.valueOf(packageNumber).intValue();
        }

        System.out.print("Please, insert the number of the problem : ");
        scanner = new Scanner(System.in);
        String problemNumber = scanner.nextLine();
        if(null == problemNumber || "".equals(problemNumber)) {
            problemNumber = currentProblem;
        }

        Problem problemClass = (Problem)createObject(packageName + String.valueOf(arrayPackage[packageIdx - 1]) + "." + defaultClassName + problemNumber);
        System.out.println(problemClass.getClass().getName() + "\n\n");
        problemClass.solve();
    }

    static Object createObject(String className) {
        Object object = null;

        try {
            Class e = Class.forName(className);
            object = e.newInstance();
        } catch (InstantiationException var3) {
            var3.printStackTrace();
        } catch (IllegalAccessException var4) {
            var4.printStackTrace();
        } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
        }

        return object;
    }

    static Object createConstructorObject(Constructor<?> constructor, Object[] args) {
        System.out.println("Constructor : " + constructor.toString());
        Object object = null;

        try {
            object = constructor.newInstance(args);
            System.out.println("Object: " + object.toString());
            return object;
        } catch (InstantiationException var4) {
            ;
        } catch (IllegalAccessException var5) {
            ;
        } catch (IllegalArgumentException var6) {
            ;
        } catch (InvocationTargetException var7) {
            ;
        }

        return object;
    }
}
