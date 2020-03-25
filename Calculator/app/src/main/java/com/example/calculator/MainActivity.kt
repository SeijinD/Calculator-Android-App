package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = findViewById<TextView>(R.id.result)
        val expression = findViewById<TextView>(R.id.expression)

        val add = findViewById<Button>(R.id.add)
        val sub = findViewById<Button>(R.id.sub)
        val div = findViewById<Button>(R.id.div)
        val mul = findViewById<Button>(R.id.mul)
        val equal = findViewById<Button>(R.id.equal)
        val clear = findViewById<Button>(R.id.clear)
        val dot = findViewById<Button>(R.id.dot)
        val del = findViewById<Button>(R.id.del)
        val left_para = findViewById<Button>(R.id.left_para)
        val right_para = findViewById<Button>(R.id.right_para)

        val one = findViewById<Button>(R.id.one)
        val two = findViewById<Button>(R.id.two)
        val three = findViewById<Button>(R.id.three)
        val four = findViewById<Button>(R.id.four)
        val five = findViewById<Button>(R.id.five)
        val six = findViewById<Button>(R.id.six)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine = findViewById<Button>(R.id.nine)
        val zero = findViewById<Button>(R.id.zero)

        // Numbers
        one.setOnClickListener{
            appendOnExpression("1", false)
        }
        two.setOnClickListener{
            appendOnExpression("2", false)
        }
        three.setOnClickListener{
            appendOnExpression("3", false)
        }
        four.setOnClickListener{
            appendOnExpression("4", false)
        }
        five.setOnClickListener{
            appendOnExpression("5", false)
        }
        six.setOnClickListener{
            appendOnExpression("6", false)
        }
        seven.setOnClickListener{
            appendOnExpression("7", false)
        }
        eight.setOnClickListener{
            appendOnExpression("8", false)
        }
        nine.setOnClickListener{
            appendOnExpression("9", false)
        }
        zero.setOnClickListener{
            appendOnExpression("0", false)
        }
        dot.setOnClickListener{
            appendOnExpression(".", false)
        }

        // Operators
        add.setOnClickListener{
            appendOnExpression("+", false)
        }
        sub.setOnClickListener{
            appendOnExpression("-", false)
        }
        mul.setOnClickListener{
            appendOnExpression("*", false)
        }
        div.setOnClickListener{
            appendOnExpression("/", false)
        }
        left_para.setOnClickListener{
            appendOnExpression("(", false)
        }
        right_para.setOnClickListener{
            appendOnExpression(")", false)
        }
        equal.setOnClickListener{
            try {
                val var_expression = ExpressionBuilder(expression.text.toString()).build()
                val var_result = var_expression.evaluate()
                val longResult = var_result.toLong()
                if (var_result == longResult.toDouble()){
                    result.text = longResult.toString()
                }
                else{
                    result.text = var_result.toString()
                }
            }catch (e:Exception){
                Log.d("Expression"," message :" + e.message)
            }
        }
        del.setOnClickListener{
            val string = expression.text.toString()
            if(string.isNotEmpty() && result.text.isEmpty()){
                expression.text = string.substring(0,string.length-1)
            }
        }
        clear.setOnClickListener{
            result.text = ""
            expression.text = ""
        }
    }

    fun appendOnExpression(string: String, clear: Boolean) {
        if(result.text.isNotEmpty()){
            expression.text = null
        }

        expression.append(result.text)
        expression.append(string)
        result.text = null
    }
}
