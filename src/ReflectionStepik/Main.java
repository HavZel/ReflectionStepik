package ReflectionStepik;

import java.lang.reflect.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Class randomClass = Random.class;
        showClassInfo(randomClass);

        Random random;
        try {
            Class classClass = Class.forName("java.util.Random");
            random = (Random) classClass.getDeclaredConstructor().newInstance();
            System.out.println("\nRandom value:" + random.nextDouble());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void showClassInfo(Class rClass) {
        Method[] classMethods = rClass.getDeclaredMethods();
        Field[] classFields = rClass.getDeclaredFields();
        Constructor[] classConstructors = rClass.getConstructors();

        System.out.println("CLASS:" + "\n\t" + rClass.toGenericString());
        System.out.println("FIELDS:");
        for (Field f: classFields) {
            System.out.println("\t" + f.toGenericString());
        }
        System.out.println("CONSTRUCTORS:");
        for (Constructor c: classConstructors) {
            System.out.println("\t" + c.toGenericString());
        }
        System.out.println("METHODS:");
        for (Method m: classMethods) {
            System.out.println("\t" + m.toGenericString());
        }
    }
}
