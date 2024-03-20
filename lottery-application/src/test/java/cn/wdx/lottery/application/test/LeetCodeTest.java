package cn.wdx.lottery.application.test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/11 5:49 PM
 * @version: 1.0
 */
public class LeetCodeTest {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        set.add(head.val);
        ListNode temp =null;
        ListNode head1 = head;
        while(head1.next != null){
            temp = head1.next;
            if(set.contains(temp.val)){
                head1.next = temp.next;
            }
            set.add(temp.val);
            head1 = head1.next;
        }
        return head;
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

}
