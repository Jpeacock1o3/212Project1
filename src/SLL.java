public class SLL {
    StudentRecord input;
    SLL next;

    //constructors
    public  SLL()
    {input =null; next = null;}

    public SLL(StudentRecord data)
    {this.input = data; this.next = null;}

    public SLL(StudentRecord input, SLL next)
    {this.input = input; this.next = next;}

//sets and gets

    public void setData(StudentRecord input)
    {this.input = input;}

    public void setNext(SLL next)
    {this.next = next;}

    public StudentRecord getData()
    {return this.input;}

    public SLL getNext() {
        return this.next;
    }
}
