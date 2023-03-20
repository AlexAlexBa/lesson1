package ru.alex.lesson2.sequences;

public class SequencesImpl implements Sequences {
    @Override
    public void a(int n) {
        System.out.print("A.");
        for (int i = 0, evenNumber = 2; i < n; i++) {
            System.out.print("  " + evenNumber);
            evenNumber += 2;
        }
    }

    @Override
    public void b(int n) {
        System.out.print("B.");
        for (int i = 0, oddNumber = 1; i < n; i++) {
            System.out.print("  " + oddNumber);
            oddNumber += 2;
        }
    }

    @Override
    public void c(int n) {
        System.out.print("C.");
        for (int i = 1; i <= n; i++) {
            System.out.print("  " + (int) Math.pow(i, 2));
        }
    }

    @Override
    public void d(int n) {
        System.out.print("D.");
        for (int i = 1; i <= n; i++) {
            System.out.print("  " + (int) Math.pow(i, 3));
        }
    }

    @Override
    public void e(int n) {
        System.out.print("E.");
        for (int i = 0; i < n; i++) {
            System.out.print((i % 2 == 0) ? ("  " + 1) : ("  " + -1));
        }
    }

    @Override
    public void f(int n) {
        System.out.print("F.");
        for (int i = 1; i <= n; i++) {
            System.out.print((i % 2 == 0) ? ("  " + -i) : ("  " + i));
        }
    }

    @Override
    public void g(int n) {
        System.out.print("G.");
        for (int i = 1; i <= n; i++) {
            System.out.print((i % 2 == 0)
                    ? ("  " + (int) Math.pow(i, 2) * -1)
                    : ("  " + (int) Math.pow(i, 2)));
        }
    }

    @Override
    public void h(int n) {
        System.out.print("H.");
        for (int i = 0, notZero = 1 ; i < n; i++) {
            if (i % 2 == 0) {
                System.out.print("  " + notZero);
                notZero++;
            } else {
                System.out.print("  " + 0);
            }
        }
    }

    @Override
    public void i(int n) {
        System.out.print("I.");
        for (int i = 1, result = 1; i <= n; i++) {
            result *= i;
            System.out.print("  " + result);
        }
    }

    @Override
    public void j(int n) {
        System.out.print("J.");
        if (n != 0) {
            System.out.print("  1");
        }
        int number1 = 0;
        int number2 = 1;
        int result;
        for (int i = 1; i < n; i++) {
            result = number1 + number2;
            System.out.print("  " + result);
            number1 = number2;
            number2 = result;
        }
    }
}
