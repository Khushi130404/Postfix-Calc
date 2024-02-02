package com.example.mycalculator;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Infix_To_Postfix1
{
    String infix,postfix="";
    Stack<Character> st;
    List<Float> num;

    public Infix_To_Postfix1(String infix)
    {
        this.infix = infix;
        st = new Stack<Character>();
        num = new ArrayList<Float>();
    }

    public int infixPrec(char c)
    {
        switch (c)
        {
            case '+':
            case '-': return 1;
            case '×':
            case '%':
            case '÷': return 3;
            case '(': return 7;
            case ')': return 0;
            default: return 5;
        }
    }

    public int stackPrec(char c)
    {
        switch (c)
        {
            case '+':
            case '-': return 2;
            case '%':
            case '×':
            case '÷': return 4;
            case '(': return 0;
            case '#': return -1;
            default: return 6;
        }
    }

    public int rank(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
            case '×':
            case '%':
            case '(':
            case '÷': return -1;
            default: return 1;
        }
    }

    public int infix_Postfix()
    {
        try {
            int r = 0;
            int j = 97;
            st.push('#');
            for (int i = 0; i < infix.length(); i++)
            {
                while (infixPrec(infix.charAt(i)) < stackPrec(st.peek()))
                {
                    r += rank(st.peek());
                    if (r < 1)
                    {
                        return -1;
                    }
                    postfix += st.pop().toString();
                }
                if (infixPrec(infix.charAt(i)) == stackPrec(st.peek()))
                {
                    st.pop();
                }
                else
                {
                    String temp = "";
                    while (i < infix.length() && infixPrec(infix.charAt(i)) == 5)
                    {
                        temp += infix.charAt(i);
                        i++;
                    }
                    if (temp.equals(""))
                    {
                        if(infix.charAt(i)=='-')
                        {
                            if(i>0 && (infix.charAt(i-1)=='-' || infix.charAt(i-1)=='+' || infix.charAt(i-1)=='÷' || infix.charAt(i-1)=='×' || infix.charAt(i-1)=='%' || infix.charAt(i-1)=='('))
                            {
                                i++;
                                while (i < infix.length() && infixPrec(infix.charAt(i)) == 5)
                                {
                                    temp += infix.charAt(i);
                                    i++;
                                }
                                num.add(Float.parseFloat(temp)*-1);
                                st.push((char) j);
                                i--;
                                j++;
                            }
                            else if (i==0)
                            {
                                i++;
                                while (i < infix.length() && infixPrec(infix.charAt(i)) == 5)
                                {
                                    temp += infix.charAt(i);
                                    i++;
                                }
                                num.add(Float.parseFloat(temp)*-1);
                                st.push((char) j);
                                i--;
                                j++;
                            } else
                            {
                                st.push(infix.charAt(i));
                            }
                        }
                        else
                        {
                            st.push(infix.charAt(i));
                        }
                    }
                    else
                    {
                        num.add(Float.parseFloat(temp));
                        st.push((char) j);
                        i--;
                        j++;
                    }
                }
            }
            while (st.peek() != '#')
            {
                r += rank(st.peek());
                if (r < 1)
                {
                    return -1;
                }
                postfix += st.pop().toString();
            }
            return r;
        }
        catch (Exception e)
        {
            return -1;
        }
    }
}
