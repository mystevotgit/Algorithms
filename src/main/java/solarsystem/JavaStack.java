package solarsystem;
import javax.script.*;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collector;

public class JavaStack {
    public static void main(String[] args) {
//        Collector<String, ?, AbstractMap<Integer, String>> mapCollector = Collector.of(TreeMap::new,
//                (s, t) -> s.put(t.length(), t.toLowerCase()),
//                (x, y) -> {x.putAll(y); return x;});
//        AbstractMap<Integer, String> coll;
//        for (int i = 0; i < 4; ++i) {
//            testArgs[0] = new Integer(i);
//            testArgs[2] = testArgs[0];
//            System.out.println(messageFormat.format(testArgs));
//        }

//        boolean b = false;
//        int n = 5;
//        System.out.println(b || n == 5);
//        System.out.println(b = true && n == 5);
//        System.out.println(b);

//        aCalendar.add(Calendar.DAY_OF_MONTH, 60);
//        aDate = aCalendar.getTime();
//        System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));
//        anInstant.plus(60, ChronoUnit.DAYS);
//        System.out.println(" " + LocalDateTime.ofInstant(anInstant, ZoneId.systemDefault()).format(d));
//         for (int i = 0; i < 5; i++) {
//             file.setWritable(i);
//             file.toString();
//         }
    }
}

//public class B {
//    public static void main(String[] args) {
//
//    }
//}

//public class IkmTest {
//    static class Helper {
//        private int data = 5;
//        public void bump(int inc) {
//            inc++;
//            data = data + inc;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        Helper h = new Helper();
//        int data = 2;
//        h.bump(data);
//    }
//}

//public class EmbeddedJavaScript {
//    public static void main(String[] args) throws Exception {
//        ScriptinEngineManager factory = new ScriptEngineManager();
//        ScriptEngine engine = factory.getEngineByName("nashorn");
//    }
//}

//import javax.script.*;
//class EmbeddedJavascript {
//    public static void main(String[] args) throws Exception {
//        ScriptEngineManager factory = new ScriptEngineManager();
//        ScriptEngine engine = factory.getEngineByName("nashorn");
//        try {
//            engine.eval (
//                    "var i=0;"
//                            + "i++;"
//                            +"var String = Java.type(\"java.lang.String\");"
//                            +"var str = new String(\"Java\");"
//                            + "print(str);"
//                            + "print(i);"
//            );
//        } catch (ScriptException se) {
//            System.out.println("Script Exception");
//        }
//    }
//}


