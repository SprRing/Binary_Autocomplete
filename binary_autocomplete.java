import java.util.ArrayList;
import java.util.List;

class Node{
    int index;
    Node left;//for zero
    Node right;//for one
}

public class binary_autocomplete {
    /*
     * Complete the 'autocomplete' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY command as parameter.
     */

    public static List<Integer> autocomplete(List<String> command) {
        Node root = new Node();
        Node cur = root;
        List<Integer> reslist = new ArrayList<Integer>();
        for (int i = 0; i < command.size(); i++) {
            int res = i;
            cur = root;
            int tempint = 0;
            for (int j = 0; j < command.get(i).length(); j++) {
                String s = command.get(i);
                if ('0' == s.charAt(j)) {
                    if (cur.left == null) {
                        cur.left = new Node();
                        cur = cur.left;
                    } else {
                        cur = cur.left;
                        res = cur.index;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = new Node();
                        cur = cur.right;
                    } else {
                        cur = cur.right;
                        res = cur.index;
                    }
                }
                cur.index = i + 1;
            }
            res = Integer.min(res, i);
            reslist.add(res);
        }
        return reslist;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<String> commands = new ArrayList<String>();
        commands.add("100110");
        commands.add("1001");
        commands.add("1001111");


        System.out.println(autocomplete(commands));

    }
}