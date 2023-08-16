import java.util.List;
import java.util.PriorityQueue;

public class LC合并k个升序列 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        ListNode res = new ListNode();
        ListNode temp = res;
        while (pq.size() > 0) {
            ListNode poll = pq.poll();
            res.next = poll;
            res = res.next;
            if (poll.next != null) {
                pq.add(poll.next);
            }
        }
        return temp.next;
    }
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     * 每k个节点进行一次翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode index = new ListNode();  // 哨兵节点
        ListNode res  = index;
        int i;
        while (head != null) {
            i = k;
            ListNode temp = head;
            while(head != null && i > 0) {
                head = head.next;
                i--;
            }
            if(i > 0) {
                System.out.println(temp.val);
                index.next = temp;
                break;  // 最后一段不用翻转
            }
            ListNode temp1 = temp;
            ListNode lis = re(temp,head); // 翻转后的头节点
            index.next = lis; // 把前面的和后面的接上
            index = temp1; // 移动到下一个为止
        }

        return res.next;
    }

    private ListNode re(ListNode temp, ListNode head) {  // 将 temp 到 head中的节点翻转，然后返回翻转之后的节点头
        ListNode temp1 = new ListNode();
        ListNode li;
        while (temp != head) {
            li = temp.next;
            temp.next = temp1;
            temp1 = temp;
            temp = li;
        }
        return temp1; // 返回一个头节点
    }
}
