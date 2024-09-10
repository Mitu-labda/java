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
        sentBack.pre.next=sentBack;
        size-=1;
    }

    public int size(){
        return size;
    }


}

9/10
    ALList
    public class ALList {
    private int[] items;
    private int size;
    private void resize(int capacity){
        int[] a=new int[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }




//Glorp[] items = (Glorp []) new Object[8];

    /*create an empty list*/
    public ALList(){
        items=new int[100];
        size=0;
    }

    public void addLast(int x){
        if (size == items.length) {
            resize(size*2);
        }


        items[size]=x;
        size+=1;
    }

    public int getLast(){
        return items[size-1];
    }

    public int get(int i){
        if (i >= items.length) {
            throw new IllegalStateException();
        }
        return items[i];

    }

    public int size(){
        return size;
    }
    public int removeLast(){
        int x=getLast();
        size=size-1;
        return x;
    }
}

public class ALList <Glorp>{
    private Glorp[] items;
    private int size;
    private void resize(int capacity){
        Glorp[] a = (Glorp[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }






    /*create an empty list*/
    public ALList(){
        items=(Glorp[]) new Object[100];

        size=0;
    }

    public void addLast(int x){
        if (size == items.length) {
            resize(size*2);
        }


        items[size]=x;
        size+=1;
    }

    public Glorp getLast(){
        return items[size-1];
    }

    public Glorp get(int i){
        if (i >= items.length) {
            throw new IllegalStateException();
        }
        return items[i];

    }

    public int size(){
        return size;
    }
    public Glorp removeLast(){
        Glorp x=getLast();
        items[size-1]=null;
        size=size-1;
        return x;
    }
}

List61B
    public interface List61B <Item>{
    public void insert(Item x, int position);
    public void addFirst(Item x);
    public void addLast(Item y);
    public Item getFirst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public int  size();



    /** Prints out the entire list. */
    default public void print() {
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List61B<String> someList = new ALList<>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        someList.print();
    }

}

ALList
    public class ALList <Item>implements List61B<Item>{
    private Item[] items;
    private int size;
    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }






    /*create an empty list*/
    public ALList(){
        items=(Item[]) new Object[100];

        size=0;
    }
    @Override
    public void addLast(Item x){
        if (size == items.length) {
            resize(size*2);
        }


        items[size]=x;
        size+=1;
    }
    @Override
    public Item getLast(){
        return items[size-1];
    }

    @Override
    public Item get(int i){
        if (i >= items.length) {
            throw new IllegalStateException();
        }
        return items[i];

    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public Item removeLast(){
        Item x=getLast();
        items[size-1]=null;
        size=size-1;
        return x;
    }

    @Override
    public void insert(Item x, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (size == items.length) {
            resize(size * 2);  // Resize the array if necessary
        }
        System.arraycopy(items, position, items, position + 1, size - position);
        items[position] = x;
        size += 1;
    }

    // Add an element at the beginning of the list
    @Override
    public void addFirst(Item x) {
        insert(x, 0);  // Delegate to the insert method
    }

    // Get the first element in the list
    @Override
    public Item getFirst() {
        return items[0];
    }

}
SLList
    public class SLList<Blorp> implements List61B<Blorp>{

    public class Intnode{
        public Blorp item;
        public Intnode next;

        public Intnode(Blorp s,Intnode f){
            item=s;
            next=f;
        }

    }

    private Intnode sentinel;
    private  int size;


    @Override
    public void print() {
        System.out.println("The boss doesn't know what he's doing!");
        for (Intnode p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
    }


    public SLList(Blorp x){
        sentinel=new Intnode(null,null);
        sentinel.next=new Intnode(x,null);

        size=1;
    }

    public SLList(){
        sentinel=new Intnode(null,null);
        size=0;
    }
    @Override
    public void addFirst(Blorp x){
        sentinel.next=new Intnode(x,sentinel.next);
        size+=1;
    }
    @Override
    public Blorp getFirst(){
        return sentinel.next.item;
    }
    @Override
    public Blorp getLast(){
        Intnode p=sentinel;
        while(p.next!=null){
            p=p.next;
        }
        return p.next.item;

    }



    @Override
    public void addLast(Blorp x){
        Intnode p=sentinel;
        while (p.next != null) {
            p=p.next;
        }
        p.next=new Intnode(x,null);
        size+=1;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public Blorp removeLast() {
        if (sentinel.next == null) {  // List is empty
            return null;
        }

        Intnode p = sentinel;
        // Traverse to the second-last node
        while (p.next.next != null) {
            p = p.next;
        }

        Blorp lastItem = p.next.item;
        p.next = null;  // Remove the last node
        size -= 1;
        return lastItem;
    }

    @Override
    public void insert(Blorp x, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Intnode p = sentinel;
        for (int i = 0; i < position; i++) {
            p = p.next;
        }
        p.next = new Intnode(x, p.next);
        size += 1;
    }

    @Override
    public Blorp get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Intnode p = sentinel.next;
        for (int index = 0; index < i; index++) {
            p = p.next;
        }
        return p.item;
    }

}

