package ca.mylearning.student.repository;

import org.junit.Assert;
import org.junit.Test;
//import org.mvel2.MVEL;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyUnitTest {


        @Test
        public void testD(){
            System.out.println(average(2,3));
            System.out.println(average2(2,3));
            System.out.println(average3(2,3));

            String word = "Deleveled";
        }

        private double average(int a, int b) {
            BigDecimal sumaryOne = new BigDecimal(a + b);
            return sumaryOne.divide(new BigDecimal(2)).doubleValue();
        }


        private double average2(int a, int b) {
            Double sumaryOne = new Double(a + b);
            return sumaryOne / new Double(2);
        }

        private double average3(int a, int b) {
            double sumaryOne = (double)(a + b);
            return sumaryOne / 2;
        }

        @Test
        public void testPalindrome(){
            System.out.println(isPalindrome("isPalindrome"));
            System.out.println(isPalindrome("issi"));
            System.out.println(isPalindrome("isasi"));
            System.out.println(isPalindrome("Deleveled"));
            System.out.println(isPalindrome("Deleeled"));
            System.out.println(isPalindrome("DeleeleQ"));
            TextInput textInput = new TextInput();
            TextInput textInput2 = new TextInput();
            TextInput textInput3 = textInput;
            System.out.println("textInput 1 eq 2: "+ textInput2.compareTo(textInput));
            System.out.println("TextInput0: "+ textInput.hashCode());
            System.out.println("TextInput1: " + new TextInput().hashCode());
            System.out.println("TextInput2: "+ textInput2.hashCode());
            System.out.println("TextInput3: "+ textInput3.hashCode());
            textInput.add('a');
            textInput3.add('Q');
            System.out.println("DeleeleQ3: "+ textInput2.hashCode());
            System.out.println("textInput1 eq 21: "+ textInput2.compareTo(textInput));
            System.out.println("TextInput0: " + textInput.hashCode());
            System.out.println("TextInput2: "+ textInput2.hashCode());
            System.out.println("TextInput3: "+ textInput3.hashCode());
            System.out.println("TextInput = 3: "+ textInput3.equals(textInput));
            System.out.println("TextInput = 3: "+ textInput3.compareTo(textInput));
            System.out.println("TextInput = values: "+ textInput3.getValue() + " -- " + textInput.getValue());
        }

        public boolean isPalindrome(String word) {
            int wordLength = word.length();
            boolean flag  = true;
            if(wordLength % 2 == 0){
                for(int i= 0; i<(wordLength/2); i++){
                    if(String.valueOf(word.charAt(i)).equalsIgnoreCase(String.valueOf(word.charAt(wordLength-(i+1))))){
                        continue;
                    } else {
                        flag =false;
                        break;
                    }
                }
            } else if(wordLength % 2 == 1){
                for(int i= 0; i<((wordLength-1)/2 ); i++){
                    if(String.valueOf(word.charAt(i)).equalsIgnoreCase(String.valueOf(word.charAt(wordLength-(i+1))))){
                        continue;
                    } else {
                        flag =false;
                        break;
                    }
                }
            } else {
                throw new UnsupportedOperationException("Waiting to be implemented.");
            }

            return flag;
        }

        @Test
        public void testMyClass(){
            TextInput input = new NumericInput();
            input.add('1');
            input.add('a');
            input.add('0');
            System.out.println(input.getValue());
        }


        public class TextInput implements Comparable <TextInput>{
            protected String value = "";
            public void add(char c){
                value = value.concat(String.valueOf(c));

            }

            public String getValue(){
                return value;
            }


            @Override
            public int compareTo(TextInput o) {
                int i = 1;
                if( o.getValue().equalsIgnoreCase(this.getValue())){
                    i = 0;
                } else {
                    i = -1;
                }
                return  i;
            }
        }

        public class NumericInput extends TextInput{
            @Override
            public void add(char c){
                if(validText(c)){
                    value =value.concat(String.valueOf(c));
                }

            }

            public boolean validText(char me){
                boolean flag = true;
                try{
                    Number number =  Double.valueOf(String.valueOf(me));

                } catch(Exception e){
                    System.out.println("this is not munberic " + me);
                    flag = false;
                }

                return flag;
            }
        }


        @Test
        public void treeSetTest(){
            TreeSet<String> treeSet = new TreeSet<>();
            treeSet.add("First");
            treeSet.add("Second");
            treeSet.add("Third");
            Iterator<String> itr = treeSet.descendingIterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());

            }

            TreeSet<Integer> treeIntSet = new TreeSet<>();
            treeIntSet.add(12);
            treeIntSet.add(9);
            treeIntSet.add(6);
            treeIntSet.add(3);
            treeIntSet.add(1);

            Iterator<Integer> itrInt = treeIntSet.descendingIterator();
            while (itrInt.hasNext()) {
                System.out.println(itrInt.next());

            }
            int sum = treeIntSet.stream().mapToInt(t->t.intValue()).sum();

            Assert.assertTrue(sum == 31);
            Set<Integer> subSet3 = treeIntSet.tailSet(9);
            Iterator<Integer> itrInt3 = subSet3.iterator();
            while (itrInt3.hasNext()) {
                System.out.println("trail: " + itrInt3.next());

            }

            Set<Integer> subSet4 = treeIntSet.headSet(3);
            Iterator<Integer> itrInt4 = subSet4.iterator();
            while (itrInt4.hasNext()) {
                System.out.println("head: " + itrInt4.next());

            }
        }

        @Test
        public void binaryTreeTest(){
            BinaryTree bt = new BinaryTree();
            bt.add(6);
            bt.add(4);
            bt.add(8);
            bt.add(3);
            bt.add(5);
            bt.add(7);
            bt.add(9);

            int sum = bt.getTotalValue();

            Assert.assertEquals(42, sum);
        }

    @Test
    public void testCodeArray(){
        String [] CODE_LIMITED = {"AT","AV","BC","BD","BP","BQ","BT", "CW", "CX","BE","BI","CG","EO","EP","ER","ET","ELT","FE","FH","HM"};

        Assert.assertTrue(Arrays.asList(CODE_LIMITED).contains("AT"));
        //Here input to the MVEL expression is a map.
        Map<String, Object> input = new HashMap<String, Object>();
        Employee e = new Employee();
        e.setFirstName("john");
        e.setLastName("michale");
        input.put("employee", e);
        /*
         * Property Expression - Used to extract the property value out of the variable.
         */
//        String lastName = MVEL.evalToString("employee.lastName",input);
//        System.out.println("Employee Last Name:"+lastName)
//        MVEL.evalToBoolean("employee.lastName == \"john\"", input);
//        input.put("numeric", new Double(-0.253405));
//        System.out.println(MVEL.evalToBoolean("numeric > 0",input));
    }

}

class Employee{
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
    class BinaryTree {

        Node root;
        int totalValue;

        Node getRoot() {
            return root;
        }

        public Node addRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.left = addRecursive(current.left, value);
            } else if (value > current.value) {
                current.right = addRecursive(current.right, value);
            } else {
                // value already exists
                return current;
            }

            return current;
        }

        public void add(int value) {
            root = addRecursive(root, value);
        }

        private boolean containsNodeRecursive(Node current, int value) {
            if (current == null) {
                return false;
            }
            if (value == current.value) {
                return true;
            }
            return value < current.value
                    ? containsNodeRecursive(current.left, value)
                    : containsNodeRecursive(current.right, value);
        }

        public int getTotalValue() {
            if (totalValue == 0) {
                getNodeRecursive(root);
            }
            return totalValue;
        }

        private void getNodeRecursive(Node current) {
            if (current == null) {
                return;
            }
            totalValue += current.value;
            getNodeRecursive(current.left);
            getNodeRecursive(current.right);
            return;
        }


    }


