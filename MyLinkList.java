package cn.list;

/**
 * @ClassName MyLinkList
 * @Description 无头单向非循环单链表
 * @Auther danni
 * @Date 2019/7/24 10:03]
 * @Version 1.0
 **/

public class MyLinkList {
    //头插法
    public Node pushFront(Node head,int data){
        Node node=new Node(data);
        if(head==null){
            return node;
        }
        else {
            node.next = head;
            return node;
        }
    }
    //尾插法
    public Node pushBack(Node head,int data){
        Node node=new Node(data);
        if(head==null){
            return node;
        }
        Node curr=new Node();
        curr=head;
       while(curr.next!=null){
         curr=curr.next;
      }
     curr.next=node;
     return head;
    }
    //头删法
    public Node popFront(Node head){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        return head.next;
    }
    //尾删法
    public Node popBack(Node head){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        Node n=head;
        while(n.next.next!=null){
            n=n.next;
        }
        n.next=null;
        return head;
    }
    //删除指定位置
    public Node popLocation(Node head,int location){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        if(location>this.length(head)){
            System.err.println("指定位置不存在数,无法删除！返回原链表");
            return head;
        }
        Node n=head;
        for (int i = 1; i <location-1 ; i++) {
            n=n.next;
        }
        n.next=n.next.next;
        return head;
    }
    //删除指定元素出现第一次的位置
    public Node remove(Node head,int datas){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }


     /*   if(this.contains(head,datas)){
            Node n=head;
            while((n.data)!=datas){
                n=n.next;
            }
            n.next=n.next.next;
            return head;
        }
        else{
            System.err.println("不存在该数，删除失败，返回原链表");
            return head;
        }*/
        Node n=head;
        if(n.data==datas){
            return head.next;
        }
        while((n.data)!=datas ){
            n=n.next;
            if(n==null){
                System.err.println("不存在该数，删除失败，返回原链表");
                return head;
            }
        }
        n.next=n.next.next;
        return head;
    }

    //删除所有值为key的节点
   public Node removeAllKey(Node head,int key){
       if(this.isEmpty(head)){
           System.err.println("链表为空");
           return null;
       }
       if(!(this.contains(head,key))){
           System.err.println("链表中不存在要删除的数，返回原链表！");
           return head;
       }
      /*1.方法1
      int num=0;
       Node n=head;
       while(n!=null){
           if(n.data==key){
               num++;
           }
           n=n.next;
       }
       Node node=head;
       boolean  m=true;
       while(num!=0){
       if(node.data==key && m==true){
           head=head.next;
           node=head;
           num--;

       }
      else if(node.next.data==key) {
           node.next = node.next.next;
           num--;
           m=false;
       }
       else{
       node=node.next;
       }
       if(node==null){
           return head;
       }
       }*/
      /*方法2，利用n这个引用来遍历整个链表，利用pre来保存经判断后删除过的链表，先对第一个结点不做判断最后在处理第一个结点。
      Node n=head.next;   //Node n=head;
      Node pre=head;
      while(n!=null){
          if(n.data==key){ //n.next.data==key
              pre.next=n.next;//n.next=n.next.next
          }
          else{
              pre=n;  //n=n.next
          }
          n=n.next;
      }
      if(head.data==key){
       head=head.next;}*/
      //方法三，利用n这个引用来遍历整个链表，利用pre来保存经判断后删除过的链表，开始就处理第一个结点
      Node n= head;
      Node pre=head;
      while(n!=null){
          if(head.data==key){
              head=head.next;
              n=head;
              pre=head;
          }else if(n.data==key){
              pre.next=n.next;
          }else{
              pre=n;
          }
          n=n.next;
      }
       return head;
   }
    //修改指定位置的数
    public Node alter(Node head,int location,int element){
        if(location>this.length(head)){
            System.err.println("指定位置无效，无法修改，返回原链表");
            return head;
        }
        Node n=head;
        for (int i = 1; i <location ; i++) {
            n=n.next;
        }
        n.data=element;
        return head;
    }
    //插入元素在指定位置
    public Node insertLocation(Node head,int location,int element){
        if(location>this.length(head)){
            System.err.println("指定位置无效，无法插入，返回原链表");
            return head;
        }
        Node n=head;
        Node node=new Node(element);
        if(location==1){
            head=this.pushFront(head,element);
        }
        else if(location==(this.length(head)+1)){
           head=this.pushBack(head,element);
        }else{
            for (int i = 1; i <location-1 ; i++) {
                 n=n.next;
             }
            node.next=n.next;
             n.next=node;
        }
        return head;
    }
    //查询指定位置的元素
    public int search(Node head ,int location){
        Node n=head;
        for (int i = 1; i <location ; i++) {
            n=n.next;
        }
        return n.data;
    }
    //查询链表中是否存在指定数
    public boolean contains(Node head,int datas){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return false;
        }
        Node n=head;
        while(n!=null){
            if(n.data==datas){
                return true;
            }
            else{
                n=n.next;
            }
        }
        return false;
    }
    //判空
    public boolean isEmpty(Node head){
        if(head==null){
            return true;
        }
        return false;
    }
    //返回链表长度
    public int length(Node head){
        int num=0;
        Node n=head;
        while(n!=null){
            num++;
            n=n.next;
        }
        return num;
    }
    //打印链表
    public void printLinkList(Node head){
        if(head==null) {
            System.err.println("单链表为空");
            return ;
        }
        Node curr=new Node();
        curr=head;
        while(curr!=null){
            System.out.print(curr+"-> ");
            curr=curr.next;
        }
        System.out.println("null");
    }
    //就地逆转单链表（设置三个引用）
    public Node ReverseList02(Node head){
        Node p1=null;
        Node p2=head;

        while(p2!=null){
            Node next=p2.next;
            p2.next=p1;
            p1=p2;
            p2=next;
        }
       return p1;
    }
    //就地逆转单链表（设置两个引用）
    public Node ReverseList01(Node head){
        Node p=head;
        Node q=p.next;
        p.next=null;
        while (p != null&&q != null){
            p = q;
            q = q.next;
            p.next = head;
            head = p;
        }
        return p;
    }
    //清空链表
    public Node clear(Node head){
        return null;
    }
    //合并两条有序的链表为一条有序的链表
    public Node mergeTwoLists (Node n1,Node n2){
        if(n1==null){
            return n2;
        }
        if(n2==null){
            return n2;
        }
        Node result=null;
        Node last=null;
        Node curr1=n1;
        Node curr2=n2;
        while(curr1!=null&&curr2!=null) {
            if (curr1.data <= curr2.data) {
               Node next=curr1.next;
                if(result==null){
                    result=curr1;
                }else{
                  last.next=curr1;
                }
               last=curr1;
               curr1=next;
            }
            else{//if(curr1.data>curr2.data)
                Node next=curr2.next;
                if(result==null){
                    result=curr2;
                }else{
                    last.next=curr2;
                }
                last=curr2;
                curr2=next;
            }
        }
        if(curr1!=null){
           last.next=curr1;
        }
        if(curr2!=null){
            last.next=curr2;
        }
        return result;
    }
    //输入一个链表，输出该链表中倒数第k个结点。
    public int  backWords(Node head,int location){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return -1;
        }
        if(location>this.length(head)){
            System.err.println("指定位置无效");
            return -1;
        }
        //方法1;求长度，遍历
       /* Node n=head;
        for (int i = 0; i < this.length(head)-location ; i++) {
            n=n.next;
        }
        return n.data;*/
       //方法2：前后引用遍历
        Node first=head;
        Node last=head;
        while((location)!=0){
            first=first.next;
            location--;
        }
        while(first!=null){
            first=first.next;
            last=last.next;
        }
        return last.data;
    }
    // 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。
    public Node sort(Node head,int key){
        Node cur=head;
        Node result_low=null;
        Node result_high=null;
        Node first=null;
        Node last=null;
        while(cur!=null){
            Node next=cur.next;
            if(cur.data<key){
                if(result_low==null){
                cur.next=null;
                result_low=cur;
                last=result_low;
                }else{
                    cur.next=null;
                    last.next=cur;
                    last=cur;
                }
            }
            else{
                if(result_high==null){
                    cur.next=null;
                    result_high=cur;
                    first=result_high;
                }
                else{
                    cur.next=null;
                    first.next=cur;
                    first=cur;
                }
            }
            cur=next;
        }
      Node right=null;
      Node p=result_high.next;
      Node pre=result_high;
      while(p!=null){
          Node next=p.next;
            if(result_high.data==key){
                right=result_high;
            }
            else if(p.data==key){
                Node node=p;
                pre.next=p.next;
                if(right==null){
                    node.next=result_high;
                    right=node;
                }
                else{
                    node.next=right;
                    right=node;
               }
            }
            pre=p;
            p=next;
      }
      last.next=right;
       return result_low;
    }
    //返回给定链表的中间结点，若中间结点有两个返回第二个结点
    public Node middleNode(Node head){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        //方法1：求链表长度，求均值；遍历
       /* Node middle=head;
        int len=0;
        if(this.length(head)%2==0){
         len=this.length(head)/2+1;}
        else
         {
           len=this.length(head)/2+1;
         }
         while((len-1)!=0){
            middle=middle.next;
            len--;
         }
          return middle;
         */
        //方法儿：设置两个引用。
        Node fast=head;
        Node slow=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null){
                break;
            }
            slow=slow.next;
            fast=fast.next;
        }
       return slow;
    }
    //判断链表是否是回文结构
    public boolean chkPalindrome(Node head){
        int len=this.length(head)/2;
        Node n=head;
        while(len!=1){
            n=n.next;
            len--;
        }

        Node p=n;
        Node q=n.next;
        Node m=n;
        while(p!=null&&q!=null){
            p=q;
            q=q.next;
            p.next=m;
            m=p;
        }
        while(m!=null&&head!=null){
            if(m.data!=head.data){
                return false;
            }
            m=m.next;
            head=head.next;
        }
        return true;
    }
    //给定一个有序的链表，删除重复的结点
    public Node deleteDuplication(Node head){
        Node p1=head;
        Node p2=head.next;
        Node m=null;
        while(p2!=null){
            if(p1.data==p2.data){
                while(p2!=null&&p2.data==p1.data){
                    p2=p2.next;
                }
                if(p2==null){
                    head=p2;
                }else if(m==null){
                    head=p2;
                    p1=head;
                    p2=p2.next;
                } else{
                    m.next=p2;
                    p1=p2;
                    p2=p2.next;
                }
            }
            else{
                m=p1;
                p1=p2;
                p2=p2.next;
            }
        }
        return head;
    }
    //给定一个结点该结点位于链表中间，删除该结点。替换思想
    public  Node popMiddle(Node n){
        n.data=n.next.data;
        n.next=n.next.next;
        return n;
    }
    public static void main(String[] args) {
        Node head=new Node();
        head=null;
        Node head2=new Node();
        head2=null;
        MyLinkList l=new MyLinkList();
        head=l.pushBack(head,1);
        head=l.pushBack(head,3);
        head=l.pushBack(head,5);
        head=l.pushBack(head,7);
        head=l.pushBack(head,9);

        head2=l.pushFront(head2,8);
        head2=l.pushFront(head2,6);
        head2=l.pushFront(head2,4);
        head2=l.pushFront(head2,2);
        //head=l.sort(head,2);
        l.printLinkList(head);
       // head=l.deleteDuplication(head);
       // head.next.next=l.middleNode(head.next.next);
        //l.printLinkList(head);
       // System.out.println(l.length(head));
       // System.out.println(l.chkPalindrome(head));
      //  System.out.println(l.middleNode(head));
     //   System.out.println(l.backWords(head,2));
        //System.out.println(l.backWords(head,8));
       //l.printLinkList(head2);
       //  head=l.mergeTwoLists(head,head2);
       // l.printLinkList(head);
        //head=l.removeAllKey(head,1);
       // l.printLinkList(head);
       /* head=l.insertLocation(head,2,11);
        l.printLinkList(head);
        head=l.alter(head,3,8);
        l.printLinkList(head);
       // System.out.println("该位置元素的值为："+l.search(head,3));
       // System.out.println(l.contains(head,0));
       /* head=l.ReverseList01(head);
        l.printLinkList(head);
        head=l.popBack(head);
        l.printLinkList(head);
        head=l.popFront(head);
        l.printLinkList(head);
        head=l.popLocation(head,5);
        l.printLinkList(head);*/
       // head=l.remove(head,1);
       // l.printLinkList(head);
      //  head=l.popLocation(head,4);
        //l.printLinkList(head);
    }
}
class Node{
    int data;
    Node next=null;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
    //重写toString方法
    public String toString(){
        return String.format("Node(%d)",data);
    }
}

