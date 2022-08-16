package com.company;

import java.io.*;
import java.util.*;

public final class Java8ToJava17Diff {
    public static void java9() throws FileNotFoundException {
        // 参考: https://qiita.com/sizer/items/76d5f7dfe925640b3766
        // 不変 List/Set/Map 用のファクトリメソッド
        Map<Integer, String> map1 = Map.of(1, "one", 2, "two", 3, "three");
        System.out.println(map1);

        // Interface内のprivateメソッド
        interface Card {
            private Long createCardID() {
                return 1L;
            }
            private static void displayCardDetails() {
                System.out.println("Detail");
            }
        }

        // Process APIの改善
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Current Process Id: = " + currentProcess.pid());

        // try-with-resourceの改善
        // try 節中でのクラスを宣言が必須ではなくなった
        BufferedReader reader1 = new BufferedReader(new FileReader("/Users/yoshihiro/project/sandbox/src/com/company/static/Write.txt"));
        try (reader1) {
            System.out.println(reader1.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // WIP
    }
}
