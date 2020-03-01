package com.company;

import java.io.*;
import java.math.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

@Beta(from = "1.0.0")
public final class JavaStudy {

    private JavaStudy() {
    }

    public static void forBreakPractice() {
        for (int i = 0; i < 10; i++) {
            if (i < 7) {
                System.out.println(i);
            } else {
                System.out.println("おわり＼(^o^)／ｵﾜﾀ");
                break;
            }
        }
    }

    public static void switchPractice(String bankName) {
        switch (bankName) {
            case "福岡銀行":
                System.out.println("わたしが福岡銀行です！");
                break;
            case "熊本銀行":
                System.out.println("わたしが熊本銀行です！");
                break;
            case "親和銀行":
                System.out.println("わたしが親和銀行です！");
                break;
            case "西日本シティ銀行":
                throw new FukuokaBankException("NCは他行やんけ！");
            default:
                System.out.println("(どれでもないか・・・)");
                System.out.println("わたしたちがふくおかフィナンシャルグループです！");
        }
    }

    public static void doWhilePractice(int max) {
        int i = 1;
        do {
            System.out.println(i + "回目〜！");
            i++;
        } while (i < max);
    }

    public static void tryWithResourcePractice() {
        try (ClosableSample sample = new ClosableSample()) {
            System.out.println("リソースを使った処理を行っています....");
            sample.printWei();
        }
        catch (Exception e) {
            throw new FukuokaBankException("connectionに何かあったﾝｺﾞww");
        }
    }

    // Java6以前は try-finallyで！
    public static void tryFinallyPractice() {
        ClosableSample sample = new ClosableSample();
        try {
            System.out.println("リソースを使った処理を行っています....");
            sample.printWei();
        }
        catch (Exception e) {
            throw new FukuokaBankException("connectionに何かあったﾝｺﾞww");
        }
        finally {
            // Apache CommonsのIOUtils クラスにあるcloseQuietlyを使えばキレイに。
            try {
                sample.close();
            }
            catch (Exception e) {
                throw new FukuokaBankException("connectionに何かあったﾝｺﾞww");
            }
        }
    }

    public static class ClosableSample implements AutoCloseable {
        public ClosableSample() {
            System.out.println("ClosableなClass. connection開始するお.");
//            throw new RuntimeException();
        }

        public void printWei() {
            System.out.println("うぇ〜い！ｗｗｗ");
        }

        @Override
        public void close() throws Exception {
            System.out.println("closeしま〜す(閉店ｶﾞﾗｶﾞﾗwww)");
        }
    }

    public static class FukuokaBankException extends RuntimeException {
        public FukuokaBankException(String message) {
            super(message);
        }
    }

    //  Lambda
    @FunctionalInterface
    private static interface Predicate {
        public boolean predicateTest(String test);
    }

    private static List<String> filter(List<String> list,
                                       Predicate predicate) {
        List<String> ret = new ArrayList<>();
        for (String s : list) {
            if (predicate.predicateTest(s)) {
                ret.add(s);
            }
        }
        return ret;
    }

    public static void stringFilter(String... args) {
//        Lambda使う前はこんな感じ。。
//        filter(new ArrayList<>(Arrays.asList(args)), new JavaStudy.Predicate() {
//            @Override
//            public boolean test(String value) {
//                return value.length() > 4;
//            }
        List<String> list =
                filter(new ArrayList<>(Arrays.asList(args)), value -> value.length() > 4);
        System.out.println("前: " + Arrays.asList(args));
        System.out.println("5文字以上: " + list);
        methodReference(list);
    }

    private static void methodReference(List<String> list) {
        System.out.println("-------------------------------------");
        System.out.println("[メソッド参照の練習]");
        list.forEach(System.out::println);
    }

    public static boolean bofMatched(String bankName) {
        Pattern pattern = Pattern.compile("福岡銀行");
        Matcher matcher = pattern.matcher(bankName);
        return matcher.matches();
    }

    public static void stringIndexOfAndStartsWithEtc() {
        System.out.println("FukuokaFinancialGroup".contains("Financial"));
        System.out.println("FukuokaFinancialGroup".indexOf("F"));
        System.out.println("FukuokaFinancialGroup".lastIndexOf("F"));
        System.out.println(Pattern.matches("[0-9]{4}", "8354"));
        System.out.println("FukuokaBank".startsWith("Fuk"));
        System.out.println("FukuokaBank".endsWith("Bank"));
        System.out.println("fukuokafinancialGroup".replace("f", "F"));
//        replaceAllでは引数に指定した文字を正規表現と見なして置き換える。
        System.out.println("FukuokaFinancialGroup".replaceAll("[A-Z]", "@"));
        System.out.println("FukuokaFinancialGroup".replaceFirst("[A-Z]", "@"));
        System.out.println(Arrays.toString("福岡銀行 熊本銀行 親和銀行 十八銀行".split("\\s", 4)));
        System.out.println(Arrays.toString("福岡銀行,熊本銀行,親和銀行,十八銀行, ".split(",", -1)));
        System.out.println("FukuokaFinancialGroup".substring(7));
        System.out.println("FukuokaFinancialGroup".substring(7, 16));
        System.out.println(Arrays.deepToString(new String[][]{
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        }));

        String[] strArray = new String[5];
        Arrays.fill(strArray, "hello");
        System.out.println(Arrays.toString(strArray));
        Arrays.fill(strArray, 1, 3, "こんにちは〜");
        System.out.println(Arrays.toString(strArray));
        String[] strArray2 = Arrays.copyOf(strArray, strArray.length);
        System.out.println(Arrays.toString(strArray2));

        String[] originalArray = {"java", "scala", "ruby", "c", "kotlin"};
        String[] originalArray2 = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println(Arrays.toString(originalArray));
        Arrays.sort(originalArray2);
        System.out.println(Arrays.toString(originalArray));
        System.out.println(Arrays.toString(originalArray2));

//      #binarySearchは昇順にソート済じゃないと正しい値を返さない。
//      Listにする方法もあるが、#binarySearchのが速く、要素数が増えると差が顕著。
        int searchIndex = Arrays.binarySearch(originalArray2, "ruby");
        System.out.println(searchIndex > 0 ? searchIndex + 1 + "番目にあります！" : "ないです（直球）");
        int searchIndex2 = Arrays.binarySearch(originalArray2, "ffg");
        System.out.println(searchIndex2 > 0 ? searchIndex2 + 1 + "番目にあります！" : "ないです（直球）");
        System.out.println(Arrays.asList(originalArray).contains("java"));

        System.out.println(Arrays.hashCode(new String[]{"Fukuoka", "Kumamoto", "Nagasaki"}));
        System.out.println(Arrays.deepHashCode(new String[][]{{"Fukuoka", "Kumamoto", "Nagasaki"}, {"Okinawa", "Oita", "Kagoshima"}}));

        Collection<String> collection = Arrays.asList("Java", "Python", "JavaScript");
        Iterator<String> iterator = collection.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        System.out.println(iterator.hasNext());

        System.out.println("------------------------------------");
        Collection<Integer> collection2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator2 = collection2.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next() % 2 != 0) {
                iterator2.remove();
            }
        }
        System.out.println(collection2);

        System.out.println("------------------------------------");
        Collection<String> collection3 = new ArrayList<>(Arrays.asList("ffg", "bof", "ffg", "kmb", "ffg", "swb"));
        collection3.removeIf("ffg"::equals);
        System.out.println(collection3);
        System.out.println("------------------------------------");
        Collection<Integer> collection4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        collection4.removeIf(new java.util.function.Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });
        System.out.println(collection4);
        System.out.println("------------------------------------");
        Collection<Integer> collection5 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator5 = collection5.iterator();
        while (iterator5.hasNext()) {
            if (iterator5.next() == 5) {
                break;
            }
        }
        iterator5.forEachRemaining(System.out::println);
    }

    public static void listEtc() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add(0, "Hello");
        list.addAll(Arrays.asList("Hello", "Ruby", "Hello", "World!!", "kado", "ffg"));
        System.out.println(list);
        System.out.println("------------------------------------");
        for (String element : list) {
            System.out.println(element);
        }
        System.out.println("------------------------------------");
        list.forEach(System.out::println);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove("Hello");
        System.out.println(list);
        list.removeIf(x -> x.length() < 4);
        System.out.println(list);
        list.removeAll(Arrays.asList("Ruby", "World!!"));
        System.out.println(list);
        list.set(2, "BOF");
        System.out.println(list);
//        listがnullの可能性があるときはApache Commons CollectionsにあるListUtils#isEqualListを使わないとNPEになる可能性が。。
        System.out.println(list.equals(Arrays.asList("Java", "Hello", "BOF")));
//        Integer.MAX_VALUEより大きい場合はInteger.MAX_VALUEが返る!!!
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        System.out.println(list.contains("kado"));
        System.out.println(list.containsAll(Arrays.asList("Java", "Hello", "BOF")));
        list.addAll(1, Arrays.asList("Ruby", "on", "Rails", "Python", "C#"));
        System.out.println(list);
        List<String> list2 = list.subList(1, 3);
        System.out.println(list2);
        List<String> list3 = list.subList(1, 5);
        System.out.println(list3);
        list2.add("mac");
        System.out.println(list);
        System.out.println(list2);
//        java.util.ConcurrentModificationException が発生する。
//        System.out.println(list3);
        List<String> list4 = new ArrayList<>(list);
        System.out.println(list4);
        List<String> list5 = new ArrayList<String>() {{
            add("a");
            add("b");
        }};
        System.out.println(list5);
        Collections.shuffle(list4);
        System.out.println(list4);
    }

    public static void mapEtc() {
        Map<String, String> map = new HashMap<>();
        map.put("Oracle", "Java");
        System.out.println(map);
        Map<String, String> addingMap = new HashMap<>();
        addingMap.put("Google", "Go");
        addingMap.put("Ericsson", "Erlang");
        addingMap.put("Fukuoka", "BOF");
        addingMap.put("Nagasaki", "SWB");
        addingMap.put("Kumamoto", "KMB");
//        まとめて追加
        map.putAll(addingMap);
        System.out.println(map);
//        指定したキーがない場合のみ要素を追加
        map.putIfAbsent("Oracle", "Javaaaa");
        map.putIfAbsent("Matz", "Ruby");
        System.out.println(map);
        System.out.println(map.remove("Kumamoto"));
        System.out.println(map.remove("Kadono"));
        System.out.println(map.remove("Nagasaki", "SWB"));
        System.out.println(map.remove("Fukuoka", "NCB"));
        System.out.println(map);
        System.out.println("------------------------------------");
        System.out.println(map.replace("Oracle", "MySQL"));
        System.out.println(map);
        System.out.println(map.replace("Google", "Go", "YouTube"));
        System.out.println(map);
//        指定されたキーの値を元に新しい値を生成する関数を指定
        System.out.println(map.compute("Fukuoka", (k, v) -> v != null ? k + "Bank" : "BOFFFFF"));
        System.out.println(map);
//        指定したキーが存在する場合のみ実行
        System.out.println(map.computeIfPresent("Fukuoka", (k, v) -> v + "(BOF)"));
        System.out.println(map);
//        指定したキーが存在しない場合のみ追加
        System.out.println(map.computeIfAbsent("Nagasaki", k -> k + "Bank"));
        System.out.println(map);
//        存在していた場合はvalueを追加、存在していない場合はラムダ式の計算結果で値を更新(oldとnewを渡す)
        System.out.println(map.merge("Kumamoto", "HigoBank", (oldVal, newVal) -> oldVal + ", " + newVal));
        System.out.println(map.merge("Kumamoto", "KumamotoBank", (oldVal, newVal) -> oldVal + ", " + newVal));
        System.out.println(map.merge("Miyazaki", "MiyazakiBank", (oldVal, newVal) -> oldVal + ", " + newVal));
        System.out.println(map);
        System.out.println(map.containsKey("Fukuoka"));
        System.out.println(map.containsValue("YouTube"));
        System.out.println(map.get("Nagasaki"));
        System.out.println(map.getOrDefault("kadono", "FukuokaFinancialGroup"));
        System.out.println("------------------------------------");
//        Set<Map.Entry<K, V>>オブジェクトはマップの保存されているキーと値のペアの1つを表すオブジェクト
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("------------------------------------");
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------");
        Set<String> keySet = map.keySet();
        keySet.forEach(System.out::println);
        System.out.println(keySet.size());
        map.remove("Matz");
        System.out.println(keySet.size());
        System.out.println("------------------------------------");
        Collection<String> values = map.values();
        values.forEach(System.out::println);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }

    public static void streamPractice() {
        List<String> strings = Arrays.asList("Java", "Ruby", "Python", "PHP", "C");
        Stream<String> stream = strings.stream();
        String[] strings2 = {"Java", "Ruby", "Python", "PHP", "C"};
        Stream<String> stream2 = Arrays.stream(strings2);
        Stream<String> stream3 = Stream.of("Java", "Ruby", "Python", "PHP", "C");
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(System.out::println);
        System.out.println("------------------------------------");
        IntStream.rangeClosed(1, 5).forEach(System.out::println);
        System.out.println(Stream.empty().collect(Collectors.toList()));
        System.out.println(Stream.empty().count());
        System.out.println("------------------------------------");
        System.out.println(Stream.concat(stream, stream2).collect(Collectors.toList()));
        System.out.println("------------------------------------");
        Stream.Builder<String> builder = Stream.builder();
        for (int i = 0; i < 10; i++) {
            builder = builder.add("test" + i);
        }
        Stream<String> stringStream = builder.build();
        stringStream.filter(x -> Integer.parseInt(x.substring(4)) % 2 == 0)
                    .forEach(System.out::println);
        System.out.println("------------------------------------");
        Stream<Double> stream1 = Stream.generate(Math::random);
        stream1.limit(10).forEach(System.out::println);
        System.out.println(stream1.isParallel());
        stream1 = stream1.parallel();
        System.out.println(stream1.isParallel());
        stream1 = stream1.sequential();
        System.out.println(stream1.isParallel());
        System.out.println("------------------------------------");
        stream3.filter(s -> s.length() > 4)
               .forEach(System.out::println);

        Stream<Integer> integerStream = Stream.of("Java", "Ruby", "Python", "PHP", "C")
                                              .map(String::length);
        integerStream.forEach(System.out::println);
        System.out.println("------------------------------------");
        Stream.of("Java", "Ruby", "Python", "PHP", "C")
              .sorted()
              .forEach(System.out::println);
        System.out.println("------------------------------------");
        Stream.of("Java", "Ruby", "Python", "PHP", "C")
              .sorted(Comparator.reverseOrder())
              .forEach(System.out::println);
        System.out.println("------------------------------------");
        Stream.of("Java", "Ruby", "Python", "PHP", "C", "Java", "ruby")
              .distinct()
              .forEach(System.out::println);
        System.out.println("------------------------------------");
        System.out.println(IntStream.rangeClosed(1, 10).sum());
        System.out.println("------------------------------------");
        System.out.println(IntStream.rangeClosed(1, 10).average());
        System.out.println("------------------------------------");
//        collectメソッドとCollectors#partitioningByを使うことで、Streamに含まれる要素を
//        ある条件を満たすものと満たさないものの2つのリストに分割することが出来る。
        Map<Boolean, List<String>> partitioned = Stream.of("Java", "Ruby", "Python", "PHP", "C")
                                                       .collect(Collectors.partitioningBy(x -> x.length() > 4));
        System.out.println("条件満たす:" + partitioned.get(true));
        System.out.println("条件満たさない:" + partitioned.get(false));
        System.out.println("------------------------------------");
//        collectメソッドとCollectors#groupingByを使うことで、Streamに含まれる要素を分類することが出来る。
        Map<Integer, List<String>> group = Stream.of("Java", "Ruby", "Python", "PHP", "C")
                                                 .collect(Collectors.groupingBy(String::length));
        for (Map.Entry<Integer, List<String>> entry : group.entrySet()) {
            System.out.println(entry.getKey() + "文字の要素：" + entry.getValue());
        }
        System.out.println("------------------------------------");
        System.out.println(Stream.of("Java", "Ruby", "Python", "PHP", "C")
                                 .allMatch(x -> Character.isUpperCase(x.charAt(0))));
        System.out.println(Stream.of("Java", "Ruby", "Python", "PHP", "C")
                                 .anyMatch(x -> x.length() > 6));
        System.out.println(Stream.of("Java", "Ruby", "Python", "PHP", "C")
                                 .noneMatch(String::isEmpty));
        System.out.println("------------------------------------");
        Stream.of("Java", "Ruby", "Python", "PHP", "C")
              .min(Comparator.naturalOrder())
              .ifPresent(System.out::println);
        Stream.of("Java", "Ruby", "Python", "PHP", "C")
              .max(Comparator.naturalOrder())
              .ifPresent(System.out::println);
//        Streamオブジェクトに含まれるすべての要素に対して、順番に2つずつ値を取り出し、
//        それらの値をもとに計算していく処理を畳み込みという。
        System.out.println(Stream.of("Java", "Ruby", "Python", "PHP", "C")
                                 .reduce("", (s1, s2) -> s1 + s2));
        Stream.of(1, 2, 3, 4)
              .reduce((accum, value) -> accum * value)
              .ifPresent(System.out::println);
        System.out.println(Stream.of(1, 2, 3, 4)
                                 .mapToInt(x -> x)
                                 .sum());
        System.out.println(IntStream.of(1, 2, 3)
                                    .sum());
    }

    public static void math() {
        System.out.println(Math.E);
        System.out.println(Math.PI);
        int num1 = 7;
        int num2 = -7;
        System.out.println(Math.abs(num1));
        System.out.println(Math.abs(num2));
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Math.abs(Long.MIN_VALUE));
        System.out.println(Float.NaN);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Math.abs(Float.NEGATIVE_INFINITY));
        try {
            System.out.println(Math.addExact(Integer.MAX_VALUE, 7));
        }
        catch (ArithmeticException e) {
            System.out.println(e + ": 加算でオーバーフローが発生しました。");
        }
        double radian = Math.PI / 3;
        double radian2 = Math.PI / 4;
        System.out.println(Math.sin(radian));
        System.out.println(Math.tan(radian2));

        System.out.println(Math.sqrt(9.0));
        System.out.println(Math.sqrt(-9.0));
        System.out.println(Math.cbrt(64.0));
        System.out.println(Math.floor(Math.PI));
        System.out.println(Math.ceil(Math.PI));
        System.out.println(Math.round(4.5));
        System.out.println(Math.min(5, 6));
        System.out.println(Math.random());
        System.out.println(new SecureRandom().nextDouble());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        BigDecimal decimal = new BigDecimal("123.456");
        System.out.println(decimal.setScale(2, RoundingMode.HALF_UP));
        System.out.println(decimal.setScale(2, RoundingMode.HALF_DOWN));
    }

    public static void file() {
//        BufferdReaderを使って1行ずつ読み込む
//        FileInputStream: ファイルの内容をバイナリとして読み込む
//        InputStreamReader: FileInputStreamから受け取ったバイナリの内容を文字列として読み込む
//        BufferedReader: InputStreamReaderから受け取った文字列の内容をまとめて読み込む
        try (BufferedReader reader
                     = new BufferedReader(new InputStreamReader(
                new FileInputStream("/Users/yoshihiro/project/sandbox/src/com/company/static/BankList.txt"),
                StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//         Files.readAllLinesを使ってすべての行を一気に読み込む(Java7〜)
        try {
            List<String> lines
                    = Files.readAllLines(
                    Paths.get("/Users/yoshihiro/project/sandbox/src/com/company/static/BankList.txt")
                    , StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//          Stream APIを使ってファイルから1行ずつ読み込む(Java8)
        try {
            Files.lines(Paths.get("/Users/yoshihiro/project/sandbox/src/com/company/static/BankList.txt"),
                        StandardCharsets.UTF_8)
                 .forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
