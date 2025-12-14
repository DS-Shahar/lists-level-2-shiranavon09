import java.util.*;

public class Main 
{
	public static void main(String[] args) 
	{
	    int[] a={6,7,8,9,10,11};
	    int[] x={6,7,8,9,10,400};
	    Node<Integer> p=ex1_buildList(a);
	    Node<Integer> b=ex1_buildList(x);
	    System.out.println(p);
	    System.out.println(b);
	    System.out.println(ex3_sumDistances(p,8));
	}
	public static Node<Integer> ex1_buildList(int[] arr) //builds list from an array
	{
		Node<Integer> head = new Node<Integer>(arr[0]);
		Node<Integer> p = head;
		Node<Integer> x;
		for (int i = 1; i < arr.length; i++) 
		{
			x = new Node<Integer>(arr[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return head;
	}
	public static void ex2a_printList(Node<Integer> head) 
	{
	    if(head.getValue()==null)
	    {
	        return;
	    }
        while (head.getValue()!=null) 
        {
            System.out.println(head.getValue());
            head=head.getNext();
    	}
	}
	public static void ex2b_printList(Node<Integer> head) 
	{
            System.out.println(head.getValue());
            if(head.getNext()==null)
                return;
            ex2b_printList(head.getNext());
	}
	public static void ex2c_printList(Node<Integer> head) 
	{
            if(head.getNext()==null)
                return;
            ex2b_printList(head.getNext());
            System.out.println(head.getValue());
	}
	public static int sumList(Node<Integer> h) 
	{
		if (h==null) 
		{
			return 0;
		}
		return h.getValue()+sumList(h.getNext());
	}

    public static Node<Integer> ex3_addUntil() //until -1 is input in
    {
        Scanner sc=new Scanner(System.in);
        Node<Integer> dummy=new Node<>(0); // dummy head
        Node<Integer> p=dummy;
        System.out.print("Enter your nums (-1 to stop): ");
        int num=sc.nextInt();
        while (num!=-1) 
        {
            p.setNext(new Node<>(num));
            p=p.getNext();
            System.out.print("Enter your nums (-1 to stop): ");
            num=sc.nextInt();
        }
        return dummy.getNext(); //real head
    }

    public static void ex4_printEvens(Node<Integer> head) //prints the even nums in node.
    {
        Node<Integer> p = head;
    
        while(p!=null) 
        {
            if(p.getValue()%2==0) 
                System.out.println(p.getValue()+ " is an even number in this node.");
            p=p.getNext();
        }
    }
    public static boolean ex5a_ifNumIn(int num, Node<Integer> head) 
    {
        while(head!=null) 
        {
            if(num==head.getValue())
                return true;
            head=head.getNext();
        }
        return false;
    }
    public static boolean ex5b_ifNumIn(int num, Node<Integer> head) //tail rec
    {
        if(head==null)
            return false;
        if(head.getValue()==num)
            return true;
        return ex5b_ifNumIn(num, head.getNext());
    }
    public static Node<Integer> ex6_delByX(Node<Integer> p,int x)
    {
        Node<Integer> h=new Node<>(null,p);
        p=h;
        if(p==null)
            return null;
        while(p.hasNext())
        {
            if(p.getNext().getValue()==x)
                p.setNext(p.getNext().getNext());
            else
                p=p.getNext();
        }
        return h.getNext();
    }
    public static Node<Integer> ex7_delByPlace(Node<Integer> h,int x)
    {
        Node<Integer> i=h;
        int num=1;
        while(num!=x)
        {
            i=i.getNext();
            num++;
        }
        ex6_delByX(h,i.getValue());
        return h;
    }
    public static boolean isIn(Node<Integer> h,int x)
    {
        while(h!=null)
        {
            if(x==h.getValue())
                return true;
            h=h.getNext(); 
        }
        return false;
    }
    public static boolean ex8_all(Node <Integer> p1,Node<Integer> p2)
    {
        if(p1==null)
            return true;
        if(!isIn(p2, p1.getValue()))
            return false;
        return ex8_all(p1.getNext(),p2);
    }
    public static void ex9_printL1inL2(Node<Integer> p1, Node<Integer> p2)
    {
        while(p1!=null)
        {
            if(isIn(p2, p1.getValue()))
                System.out.println(p1.getValue()+" is in L2");
        }
    }
    public static Node<Integer> ex10_createL1inL2(Node<Integer> p1, Node<Integer> p2)
    {
        Node<Integer> head = new Node<Integer>(-1);
		Node<Integer> p = head;
        while(p1!=null)
        {
            if(isIn(p2, p1.getValue()))
                p.setNext(p1);
            p=p.getNext();
        }
        return head.getNext();
    }
    public static Node<Integer> ex11_l1WithoutL2(Node<Integer> l1,Node<Integer>l2)
    {
        while(l1.getValue()!=null)
        {
            if(isIn(l2,l1.getValue()))
                ex6_delByX(l1,l1.getValue());
            l1=l1.getNext();
        }
        return l1;
    }
    //////////////////////level 2//////////////////////////
    public static int ex2_getMinHelper(Node<Integer> head)
    {
        int min=head.getValue();
        head=head.getNext();
        while(head!=null)
        {
            if(head.getValue()<min)
            {
                min=head.getValue();
            }
            head=head.getNext();
        }
        return min;
    }
    public static Node<Integer> ex1_newNode(Node<Integer> p1, Node<Integer> p2) //אורך קלט:n,m:יעילות: O(n+m)
    {                                                                           //אורך קלט:n^2:יעילות:O(n^2)
        Node<Integer> head = new Node<Integer>(-1); 
        Node<Integer> p = head;
        while((p1!=null)&&(p2!=null))
        {
            if(p1.getValue()<=p2.getValue()) 
            {
                p.setNext(new Node<Integer>(p1.getValue()));
                p=p.getNext();
                p1=p1.getNext();
            } 
            else 
            {
                p.setNext(new Node<Integer>(p2.getValue()));
                p = p.getNext();
                p2 = p2.getNext();
            }
        }
        while(p1!=null) 
        {
            p.setNext(new Node<Integer>(p1.getValue()));
            p=p.getNext();
            p1=p1.getNext();
        }
        while(p2!=null) 
        {
            p.setNext(new Node<Integer>(p2.getValue()));
            p=p.getNext();
            p2=p2.getNext();
        }
        return head.getNext();
    }
    public static Node<Integer> ex2_selectSort(Node<Integer> p1, Node<Integer> p2)//אורך הקלט: 2n, היעילות: O(n^2)
    {                                                                            //אורך הקלט:n+m, היעילות: O(n*m)

        Node<Integer> head = new Node<>(-1);
        Node<Integer> p = head;
        while (p1 != null || p2 != null)
        {
            if (p1 != null && p2 != null)
            {
                int min1 = ex2_getMinHelper(p1);
                int min2 = ex2_getMinHelper(p2);
    
                if (min1 <= min2)
                {
                    p.setNext(new Node<>(min1));
                    p = p.getNext();
                    p1 = ex6_delByX(p1, min1);
                }
                else
                {
                    p.setNext(new Node<>(min2));
                    p = p.getNext();
                    p2 = ex6_delByX(p2, min2);
                }
            }
            else if (p1 != null)
            {
                int min1 = ex2_getMinHelper(p1);
                p.setNext(new Node<>(min1));
                p = p.getNext();
                p1 = ex6_delByX(p1, min1);
            }
            else
            {
                int min2 = ex2_getMinHelper(p2);
                p.setNext(new Node<>(min2));
                p = p.getNext();
                p2 = ex6_delByX(p2, min2);
            }
        }
        return head.getNext();
    }
    public static int ex3_sumDistances(Node<Integer> head,int x)
    {
        if(ex5a_ifNumIn(x,head)==false)
            return -1;
        int count=0;
        int fakcount=0;
        boolean i=true;;
        while(i==true)
        {
            if(head.getValue()==x)
            {
                i=false;
            }
            else
            {
                count++;
                head=head.getNext();
            }
        }
        while(head!=null)
        {
            head=head.getNext();
            fakcount++;
            if(head.getValue()==x)
                fakcount=0;
        }
        return count+fakcount;
    }
}
