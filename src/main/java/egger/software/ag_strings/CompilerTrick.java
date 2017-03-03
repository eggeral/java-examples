package egger.software.ag_strings;

public class CompilerTrick {
    public static void main(String[] args) {
        String test = "test";
        test = test + "1" + "2";
        System.out.println(test);
    }

    /*
       0: ldc           #2                  // String test
       2: astore_1
       3: new           #3                  // class java/lang/StringBuilder
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: aload_1
      11: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      14: ldc           #6                  // String 1
      16: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: ldc           #7                  // String 2
      21: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      27: astore_1
      28: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
      31: aload_1
      32: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      35: return
    */
}
