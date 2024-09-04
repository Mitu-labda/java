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
