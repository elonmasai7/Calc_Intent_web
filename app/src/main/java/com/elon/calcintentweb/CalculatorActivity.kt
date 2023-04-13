package com.elon.calcintentweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var tv_answer:TextView
    lateinit var edt_fnumber:EditText
    lateinit var edt_secnumber:EditText
    lateinit var btnadd:Button
    lateinit var btmin:Button
    lateinit var btmultiply:Button
    lateinit var btdiv:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        tv_answer=findViewById(R.id.Edt_txt)
        edt_fnumber=findViewById(R.id.edt_fnum)
        edt_secnumber=findViewById(R.id.edt_secnum)
        btnadd=findViewById(R.id.btn_plus)
        btmin=findViewById(R.id.btn_minus)
        btmultiply=findViewById(R.id.btn_multi)
        btdiv=findViewById(R.id.btn_div)

        btnadd.setOnClickListener {
         var myfirstnumber=edt_fnumber.text.toString()
         var mysecnumber=edt_secnumber.text.toString()
         if (myfirstnumber.isEmpty() && mysecnumber.isEmpty()){
             tv_answer.text="Please fill in all inputs"

         }else{
             //lets now calculate
             var answer=myfirstnumber.toDouble()+mysecnumber.toDouble()
             tv_answer.text=answer.toString()
         }
        }
        btmin.setOnClickListener {
            var myfirstnumber=edt_fnumber.text.toString()
            var mysecnumber=edt_secnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecnumber.isEmpty()){
                tv_answer.text="Please fill in all inputs"

            }else{
                //lets now calculate
                var answer=myfirstnumber.toDouble()-mysecnumber.toDouble()
                tv_answer.text=answer.toString()
            }
        }
        btmultiply.setOnClickListener {
            var myfirstnumber=edt_fnumber.text.toString()
            var mysecnumber=edt_secnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecnumber.isEmpty()){
                tv_answer.text="Please fill in all inputs"

            }else{
                //lets now calculate
                var answer=myfirstnumber.toDouble()*mysecnumber.toDouble()
                tv_answer.text=answer.toString()
            }
        }
        btdiv.setOnClickListener {
            var myfirstnumber=edt_fnumber.text.toString()
            var mysecnumber=edt_secnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecnumber.isEmpty()){
                tv_answer.text="Please fill in all inputs"

            }else{
                //lets now calculate
                var answer=myfirstnumber.toDouble()/mysecnumber.toDouble()
                tv_answer.text=answer.toString()
            }
        }

    }
}