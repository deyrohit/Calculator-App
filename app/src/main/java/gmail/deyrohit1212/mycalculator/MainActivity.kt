package gmail.deyrohit1212.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    var inputval : TextView? = null
    var m=0
    var c=0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//
//        }
        inputval=findViewById(R.id.input)
    }
   fun onDigit(view :View)
    {
        inputval?.append((view as Button).text)
        m=1
    }

    var f=0
    fun onDot(view :View)
    {
        if(f==0)
        {
            inputval?.append((view as Button).text)
            f++
        }
    }
    fun OnOperator(view: View)
    {
        if(m==1 && !onOperatorAdded(inputval?.text.toString()))
        {
            inputval?.append((view as Button).text)
            f=0
            m=0
        }
        else
        {
            var prefix =""
            var text2=inputval?.text.toString()
            try
            {
                if(text2.startsWith("-"))
                {
                    prefix ="-"
                    text2=text2.substring(1)
                }
                if(text2.contains("+"))
                {
                    val s =text2.split("+")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1

                    val res = num1.toDouble() + num2.toDouble()
                    inputval?.text=res.toString()
                }

                else if(text2.contains("-"))
                {
                    val s =text2.split("-")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1


                    val res = num1.toDouble() - num2.toDouble()
                    inputval?.text=res.toString()
                }

                else if(text2.contains("*"))
                {
                    val s =text2.split("*")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1

                    val res = num1.toDouble() * num2.toDouble()
                    inputval?.text=res.toString()

                }

                if(text2.contains("/"))
                {
                    val s =text2.split("/")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1

                    val res = num1.toDouble() / num2.toDouble()
                    inputval?.text=res.toString()
                }
                inputval?.text=remove_decimal(inputval?.text.toString())
            }
            catch (e :ArithmeticException)
            {
                inputval?.text="Arithmetic Error"
            }
        }
    }

    fun OnEqual(view: View)
    {

        if(m==1)
        {
            var prefix =""
            var text2=inputval?.text.toString()
            try
            {
                if(text2.startsWith("-"))
                {
                    prefix ="-"
                    text2=text2.substring(1)
                }
                if(text2.contains("+"))
                {
                    val s =text2.split("+")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1

                    val res = num1.toDouble() + num2.toDouble()
                    inputval?.text=res.toString()
                }

                else if(text2.contains("-"))
                {
                    val s =text2.split("-")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1


                    val res = num1.toDouble() - num2.toDouble()
                    inputval?.text=res.toString()
                }

                else if(text2.contains("*"))
                {
                    val s =text2.split("*")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1

                    val res = num1.toDouble() * num2.toDouble()
                    inputval?.text=res.toString()

                }

                if(text2.contains("/"))
                {
                    val s =text2.split("/")
                    var num1= s[0]
                    var num2 = s[1]

                    if(prefix.isNotEmpty())
                        num1=prefix+num1

                    val res = num1.toDouble() / num2.toDouble()
                    inputval?.text=res.toString()
                }
                inputval?.text=remove_decimal( inputval?.text.toString())
            }
            catch (e :ArithmeticException)
            {
                inputval?.text="Arithmetic Error"
            }
        }
    }
    private fun onOperatorAdded(value: String):Boolean
    {
        if(value.startsWith("-"))
            return false
        if (value.contains("+") || value.contains("-") || value.contains("/") || value.contains("*"))
            return true
        else
            return false
    }

    fun OnClear(view: View)
    {
        inputval?.text=""
        f=0;
        m=0;
    }

    fun onBackSpace(view: View) {
        var text1 = inputval?.text?.toString() ?: ""
        if (text1.isNotEmpty())
        {
            text1 = text1.dropLast(1)
            inputval?.text = text1
            if(!text1.contains("."))
                f=0
        }
        else
            m=0
    }
    fun remove_decimal(result: String) :String
    {
        var value= result
        if(result.contains(".0"))
           value= (result.substring(0,result.length-2))
        return value
    }
}