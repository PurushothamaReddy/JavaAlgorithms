package com.passion.coding.previous;

import java.util.HashMap;
import java.util.Map;

class Test {

    private Map<String,String> rules;

    private void initRules(){
        rules=new HashMap<>();
        rules.put("AB", "AA");
        rules.put("BA", "AA");
        rules.put("CB", "CC");
        rules.put("BC", "CC");
        rules.put("AA", "A");
        rules.put("CC", "C");
    }

    public String test(String S) {
        initRules();
        while(true){
            String oldString=S;
            for (Map.Entry<String, String> rule : rules.entrySet())
            {
                if(oldString.contains(rule.getKey())) {
                    S = S.replace(rule.getKey(), rule.getValue());
                }
            }
            if (oldString.equals(S)){
               return S;
            }
        }
    }
}

 public class NewMain {

    public static void main(String[] args) {
        Test test=new Test();
        System.out.println("Result:"+test.test("ABBCC"));;
    }

}