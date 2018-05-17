package com.example.smail.projectmob

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View

import kotlinx.android.synthetic.main.activity_restaurant_details.*
import kotlinx.android.synthetic.main.content_restaurant_details.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.toast
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.widget.*
import android.widget.Toast
import android.widget.DatePicker
import android.app.DatePickerDialog




class Restaurant_detailsActivity : AppCompatActivity() {


    var isFABOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)
//        setSupportActionBar(toolbar)

        initValues()

        initFonts()



        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val mapFragment = MapFragment()
        fragmentTransaction.replace(R.id._placeholder2, mapFragment)
        fragmentTransaction.commit()


        fab.setOnClickListener { view ->
            if (!isFABOpen) {
                showFABMenu()
            } else {
                closeFABMenu()
            }
        }


        explorBtn.setOnClickListener({
            val intent = Intent(this,ExploringActivity::class.java)
            startActivity(intent);
        })

        fab2.setOnClickListener({
            val intent = Intent(this,ExploringActivity::class.java)
            startActivity(intent);

        })

        fab1.setOnClickListener({

            val inflater = layoutInflater
            val alertLayout = inflater.inflate(R.layout.reservation, null)
            val dateBtn = alertLayout.findViewById<ImageButton>(R.id.dateBtn)
            val datePicker = alertLayout.findViewById<DatePicker>(R.id.datePicker2)

            val linearLayout9 = alertLayout.findViewById<LinearLayout>(R.id.linearLayout9)
            val linearLayout8 = alertLayout.findViewById<LinearLayout>(R.id.linearLayout8)
            val linearLayout10 = alertLayout.findViewById<LinearLayout>(R.id.linearLayout10)

            val alert = AlertDialog.Builder(this)
            alert.setTitle("Nouvelle reservation")
            // this is set the view from XML inside AlertDialog
            alert.setView(alertLayout)
            // disallow cancel of AlertDialog on click of back button and outside touch
            alert.setCancelable(false)
            alert.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> Toast.makeText(baseContext, "Cancel clicked", Toast.LENGTH_SHORT).show() })

            alert.setPositiveButton("Done", DialogInterface.OnClickListener { dialog, which ->
                toast("Votre reservation est prise en compte !")
            })
            val dialog = alert.create()
            dialog.show()

            dateBtn.setOnClickListener({
                datePicker.setVisibility(View.VISIBLE)
                linearLayout9.setVisibility(View.INVISIBLE)
                linearLayout8.setVisibility(View.INVISIBLE)
                linearLayout10.setVisibility(View.INVISIBLE)

            })
//            datePicker.setOnDateChangedListener { view, a, b, v ->
//                toast("Message")
//            }

            datePicker.setOnClickListener{ view ->
                toast("Message")
            }
            




        })

        //make a call
        linearLayout3.setOnClickListener({
            //tocast("ceci est un toast")
            snackbar(content, "voullez vous effectuer l'appel", "OK")
                {makeCall(phonenumber2.text.toString())}
        })
        backBtn.setOnClickListener({
            onBackPressed()
        })

    }



    private fun showFABMenu() {
        isFABOpen = true
        fab.animate().rotation(45F)
        fab1.animate().translationY(-resources.getDimension(R.dimen.standard_105))
        fab2.animate().translationY(-resources.getDimension(R.dimen.standard_155))
    }

    private fun closeFABMenu() {
        isFABOpen = false
        fab.animate().rotation(0F)
        fab1.animate().translationY(0F)
        fab2.animate().translationY(0F)
    }

    fun initValues(){
        val res = intent.getSerializableExtra("resto") as Restaurant

        val res_name2 = findViewById<TextView>(R.id.res_name2)
        res_name2.text= res.nom

        val res_image = findViewById<ImageView>(R.id.ResImage2)
        res_image.setImageResource(res.image)

        val phonenumber2 = findViewById<TextView>(R.id.phonenumber2)
        phonenumber2?.text = res.telephone

        val adress2 = findViewById<TextView>(R.id.adress2)
        adress2?.text = res.adresse

        val mail2 = findViewById<TextView>(R.id.mail2)
        mail2?.text = res.mail

        val fb2 = findViewById<TextView>(R.id.fb2)
        fb2?.text = res.fb

    }

    fun initFonts(){

        val typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto_Slab/RobotoSlab-Regular.ttf")

        val explor = findViewById<Button>(R.id.explorBtn)
        explor?.setTypeface(typeface)

        val res_name2 = findViewById<TextView>(R.id.res_name2)
        res_name2?.setTypeface(typeface)

        val phonenumber2 = findViewById<TextView>(R.id.phonenumber2)
        phonenumber2?.setTypeface(typeface)

        val adress2 = findViewById<TextView>(R.id.adress2)
        adress2?.setTypeface(typeface)

        val mail2 = findViewById<TextView>(R.id.mail2)
        mail2?.setTypeface(typeface)

        val fb2 = findViewById<TextView>(R.id.fb2)
        fb2?.setTypeface(typeface)

    }

//    override fun onBackPressed() {
//        if (isFABOpen) {
//            closeFABMenu()
//            onBackPressed()
//        }
//    }

}
