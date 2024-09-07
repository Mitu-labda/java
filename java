public class InList {
    public int first;
    public InList rest;

    public static void main(String[] args){
        InList L = new InList();
        L.first=5;
        L.rest=null;

        L.rest=new InList();
        L.rest.first=10;
        L.rest.rest=null;

        L.rest.rest=new InList();
        L.rest.rest.first=20;
        L.rest.rest.rest=null;

    }

}
//尾插法
public InList(int s,InList f)  {
         first=s;
         rest=f;

    }

    public static void main(String[] args){
        InList L=new InList(10,null);
        L=new InList(5,L);
        L=new InList(20,L);

    }
//计算节点个数
public int size(){
        if(rest==null){
            return 1;
        }
        return 1+this.rest.size();

    }

    public int size1(){
        int count=0;
        InList p=this;
        while(p != null) {
            p = p.rest;
            count++;
        }
        return count;

    }

public int get(int i){
        if (i == 0) {
            return first;
        }
        return this.rest.get(i-1);
    }

    public int get1(int i) {
        // 检查索引是否超出范围
        if (i > this.size() || i < 1) {
            throw new IllegalArgumentException("Index out of bounds");
            //throw new IllegalArgumentException("Index out of bounds");
        }

        int count = 1;
        InList p = this;

        // 遍历链表直到找到第 i 个元素
        while (count < i) {
            p = p.rest;
            count += 1;
        }

        // 返回第 i 个元素的值
        return p.first;
    }

//int[] x=int[]{10,2,3,4};

/*2024/9/5*/

public class SLList{

    public  class Intnode {//变为静态，实例变量不能访问外部类的元素
        public int item;
        public Intnode next;



        public Intnode(int s, Intnode f) {
            item = s;
            next = f;

        }
    }


    /** The first item (if it exists) is at sentinel.next. */
    private Intnode sentinel;//除了SLList类可以使用，其他都不可以使用
    private int size;
    public  SLList(int x){
        sentinel=new Intnode(0,null);
        sentinel.next = new Intnode(x,null);

        size=1;

    }


    public SLList(){
        sentinel=new Intnode(0,null);
        size=0;
    }

    public void addFirst(int x){
        sentinel.next=new Intnode(x,sentinel.next);
        size+==1;
    }
    //头插法
    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLst(int x){
        Intnode p=sentinel;

        while (p.next != null) {
            p=p.next;
        }
        p.next=new Intnode(x,null);
        size+=1;
    }

    public int size(){
        return size;
    }


    public static void main(String[] args){
        SLList L=new SLList();
        L.addLst(20);
        System.out.println(L.size());
        SLList L=new SLList(5);
    }
}
//比较麻烦的计算节点方法
/*public class SLList {
   private IntNode first;

   public SLList(int x) {
      first = new IntNode(x, null);
   }

   public void addFirst(int x) {
      first = new IntNode(x, first);
   }

   private int size(IntNode p) {
      if (p.next == null)
         return 1;
      return 1 + size(p.next);
   }

   public int size() {
      return size(first);
   }
}
*/

9/7    
//双链表

public class DLList<abandon> {
    public class Intnode{
        public abandon item;
        public Intnode next;
        public Intnode pre;



        public Intnode(abandon s, Intnode f,Intnode w) {
            item = s;
            next = f;
            pre=w;

        }
    }

    private Intnode sentFront;
    private Intnode sentBack;
    private int size;

    public DLList(abandon x){
        sentFront=new Intnode(null,sentBack,null);
        sentBack=new Intnode(null,null,sentFront);
        sentFront.next=new Intnode(x,sentFront,sentBack);

        size=1;
    }

    public void addLast(abandon x){
        Intnode L=new Intnode(x,sentBack,sentBack.pre);
        sentBack.pre.next=L;
        sentBack.pre=L;

        size+=1;

    }

    public abandon Back(){
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return sentBack.pre.item;
    }



    public void removeLast(){
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        sentBack.pre=sentBack.pre.pre;
        sentBack.pre.pre.next=sentBack;
        size-=1;
    }

    public int size(){
        return size;
    }


}
