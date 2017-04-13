/**
 * Created by kracoz on 13.03.2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Необходимо реализовать консольную программу, которая бы фильтровала поток
 * текстовой информации, подаваемой на вход и на выходе показывала лишь те строчки,
 * которые содержат слово, передаваемое программе на вход в качестве аргумента.

 Варианты усложнения:
 + Программа не должна учитывать регистр
 + В аргументах может быть передано не одно слово, а несколько
 В качестве аргумента может быть задано не конкретное слово, а регулярное выражение

 */
public class StringLes2 {

    private static Map<String,StringBuilder> ResultMap;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите данные: ");

        String inputData = reader.readLine();// sdfsfd 34dFg411 ggssaae Dfg4
        String exit;
        do {
            System.out.println("Введите запрос: ");
            String inputrReg = reader.readLine();
            while(inputrReg.equals("")){
                System.out.println("Запрос пуст! Повторите запрос.");
                inputrReg = reader.readLine();
            }

            System.out.println("Учитывать регист(y/n)?");
            String ignoreCaseStr = reader.readLine();
            Boolean ignoreCase = false;

            while(ignoreCaseStr.compareToIgnoreCase("y") != 0 && ignoreCaseStr.compareToIgnoreCase("n") != 0){
                ignoreCaseStr = reader.readLine();
            }

            if(ignoreCaseStr.compareToIgnoreCase("y") == 0){
                ignoreCase = false;
            }else if(ignoreCaseStr.compareToIgnoreCase("n") == 0){
                ignoreCase = true;
            }

            ResultMap = wordsContainsRequest(inputData, inputrReg, ignoreCase);

            if (ResultMap != null) {
                for (Map.Entry<String, StringBuilder> m : ResultMap.entrySet()) {
                        System.out.println("Аргумент  [" + m.getKey() + "] содержится в : " + m.getValue());
                }
            } else {
                System.out.println("Совпадений не найдено.");
            }
            System.out.println("Повторить запрос(y/n)?");
            exit = reader.readLine();

            while(ignoreCaseStr.compareToIgnoreCase("y") != 0 && ignoreCaseStr.compareToIgnoreCase("n") != 0){
                exit = reader.readLine();
            }
        } while (exit.compareToIgnoreCase("y") == 0);
        reader.close();
    }

    public static Map wordsContainsRequest(String inputData, String request, Boolean ignoreCase) {

        String[] splitReg = request.split(" ");
        String[] whitoutRegular = inputData.split(" ");
        Map<String, StringBuilder> resultMap = new HashMap<>();

        for (int i = 0; i < splitReg.length; i++) {
            resultMap.put(splitReg[i], new StringBuilder(""));
        }

        for (Map.Entry<String, StringBuilder> m : resultMap.entrySet()) {
            for (String s : whitoutRegular) {
                if (!ignoreCase) {
                    if (s.contains(m.getKey())) {                               // С учетом регистра
                        resultMap.put(m.getKey(), m.getValue().append(s + " "));
                    }
                }else {
                    if (s.toLowerCase().contains(m.getKey().toLowerCase())) {   // Без учета регистра
                        resultMap.put(m.getKey(), m.getValue().append(s + " "));
                    }
                }
            }
        }
        if (resultMap.size() == 1 && resultMap.get(request).toString().equals("")) {//если нет совпадений
            resultMap = null;
        }
        return resultMap;
    }
    /*
    public static Map wordsContainsRequest(String inputData, String inputReg, Boolean ignoreCase) {

        String[] splitReg = inputReg.split(" ");
        String[] WhitoutRegular = inputData.split(" ");
        Map<String, StringBuilder> ResultMap = new HashMap<>();
        StringBuilder inputDataToRegular = new StringBuilder();

        try {

            Pattern pattern = Pattern.compile(inputReg);
            Matcher matcher = pattern.matcher(inputData);
            while(matcher.find())
                System.out.println(matcher.group());


        } catch (PatternSyntaxException e) {

            System.out.println("Это не регулярное выражение");

            for (int i = 0; i < splitReg.length; i++) {
                ResultMap.put(splitReg[i], new StringBuilder(""));
            }
            if (!ignoreCase) {
                for (Map.Entry<String, StringBuilder> m : ResultMap.entrySet()) { // С учетом регистра
                    for (String s : WhitoutRegular) {
                        if (s.contains(m.getKey())) {
                            ResultMap.put(m.getKey(), m.getValue().append(s + " "));
                        }
                    }
                }
            } else {
                for (Map.Entry<String, StringBuilder> m : ResultMap.entrySet()) {// Без учета регистра
                    for (String s : WhitoutRegular) {
                        if (s.toLowerCase().contains(m.getKey().toLowerCase())) {
                            ResultMap.put(m.getKey(), m.getValue().append(s + " "));
                        }
                    }
                }
            }
            if (ResultMap.size() == 1 && ResultMap.get(inputReg).toString().equals("")) {//если нет совпадений
                return null;
            } else {
                return ResultMap;
            }
        }
    return ResultMap;
    }
    */
}




