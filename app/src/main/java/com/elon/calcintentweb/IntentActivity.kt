package com.elon.calcintentweb

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var Btn_Call:Button
    lateinit var Btn_Sms:Button
    lateinit var Btn_Dial:Button
    lateinit var Btn_Camera:Button
    lateinit var Btn_Stk:Button
    lateinit var Btn_Share:Button
    lateinit var Btn_Email:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        Btn_Call=findViewById(R.id.btn_Call)
        Btn_Camera=findViewById(R.id.btn_Camera)
        Btn_Sms=findViewById(R.id.btn_Sms)
        Btn_Stk=findViewById(R.id.btn_Stk)
        Btn_Share=findViewById(R.id.btn_share)
        Btn_Dial=findViewById(R.id.btn_Dial)
        Btn_Email=findViewById(R.id.btn_email)

        Btn_Sms.setOnClickListener {
            val uri=Uri.parse("Smsto:0741126228")
            val intent=Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("Hello","Good morning")
            startActivity(intent)

        }
        Btn_Camera.setOnClickListener {
            val takepic=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepic,1)
        }
        Btn_Dial.setOnClickListener {
            val nambari="+254725680388"
            val intent=Intent(Intent.ACTION_DIAL,Uri.fromParts("telephone",nambari,null))
            startActivity(intent)
        }
        Btn_Email.setOnClickListener {
            val emailintent=Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","elonmasai7@gmail.com",null))
            emailintent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
            emailintent.putExtra(Intent.EXTRA_TEXT,"Body")
            startActivity(Intent.createChooser(emailintent,"send email...."))
        }
        Btn_Stk.setOnClickListener {
            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        Btn_Share.setOnClickListener {
            val shareIntent=Intent(Intent.ACTION_SENDTO)
            shareIntent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Hello, click to download")
            startActivity(shareIntent)
        }
        Btn_Call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254741126228"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) { ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }


        }


    }


}