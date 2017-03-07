package egger.software.ac_statements;

public class ContinueAndBreakDecompiled {

    public static void simpleContinue() {
        for (int i = 0; i < 10; i++) {
            if (i == 2)
                continue;
            System.out.println("test");
        }

        /*
          0: iconst_0
          1: istore_0
          2: iload_0
          3: bipush        10
          5: if_icmpge     30
          8: iload_0
          9: iconst_2
         10: if_icmpne     16
         13: goto          24
         16: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         19: ldc           #3                  // String test
         21: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         24: iinc          0, 1
         27: goto          2
         30: return
         */
    }

    public static void forWithPrintln() {
        for (int i = 0; i < 10; i++) {
            System.out.println("test");
        }

        /*
         0: iconst_0
         1: istore_0
         2: iload_0
         3: bipush        10
         5: if_icmpge     22
         8: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        11: ldc           #3                  // String test
        13: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        16: iinc          0, 1
        19: goto          2
        22: return
         */
    }

}
