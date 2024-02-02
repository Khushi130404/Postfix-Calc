package com.example.mycalculator;
import java.util.Stack;

public class Evaluation1
{
    String ans;
    Stack<Float> stack;
    int rank;
    Infix_To_Postfix1 itp;

    public Evaluation1(String ans)
    {
        this.ans=ans;
        stack = new Stack<Float>();
        itp = new Infix_To_Postfix1(ans);
        rank = itp.infix_Postfix();
    }

    public float evaluate(float a,float b,char c)
    {
        switch (c)
        {
            case '+': return a+b;
            case '-': return a-b;
            case '×': return a*b;
            case '÷': return a/b;
            case '%': return a%b;
        }
        return 0;
    }

    public float postfixEvaluation()
    {
        for(int i=0; i<itp.postfix.length(); i++)
        {
            if(itp.postfix.charAt(i)>='0' && itp.postfix.charAt(i)<='9')
            {
                stack.push((float)(itp.postfix.charAt(i)-'0'));
            }
            else if(itp.postfix.charAt(i)>='a' && itp.postfix.charAt(i)<='z')
            {
                if(!itp.num.isEmpty())
                {
                    stack.push(itp.num.remove(0));
                }
            }
            else
            {
                float b = stack.pop();
                float a = stack.pop();
                stack.push(evaluate(a,b,itp.postfix.charAt(i)));
            }
        }
        return stack.peek();
    }
}
