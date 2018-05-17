package com.example.smail.projectmob

import android.content.DialogInterface
import android.graphics.Typeface
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_exploring.*
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.view.View
import android.widget.*
import com.github.ivbaranov.mfb.MaterialFavoriteButton
import org.jetbrains.anko.toast


class ExploringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exploring)
        setSupportActionBar(toolbar)

        initFonts()

        app_bar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = true
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbar_layout.title = " "
                    imageView3333.setVisibility(View.GONE)
                    linearLayoutttt.setVisibility(View.GONE)
                    isShow = true
                } else if (isShow) {
                    toolbar_layout.title = " "//carefull there should a space between double quote otherwise it wont work
                    isShow = false
                    imageView3333.setVisibility(View.VISIBLE)
                    linearLayoutttt.setVisibility(View.VISIBLE)
                }
            }
        })

        backBtn.setOnClickListener({
            onBackPressed()
        })

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        val  listFragment = ListPlatFragment()
        fragmentTransaction.replace(R.id._placeholder3, listFragment)
        fragmentTransaction.commit()


        val filter_menu_crdView = findViewById<CardView>(R.id.filter_menu_crdView)
        filter_menu_crdView.setVisibility(View.GONE)
        val filterBtn = findViewById<ImageButton>(R.id.filterBtn)
        filterBtn.setOnClickListener{e->
            if (filter_menu_crdView.getVisibility() === View.GONE)
                filter_menu_crdView.setVisibility(View.VISIBLE)
            else
                filter_menu_crdView.setVisibility(View.GONE)

        }

        val materialFavoriteButton2 = findViewById<MaterialFavoriteButton>(R.id.materialFavoriteButton2)
        materialFavoriteButton2.setVisibility(View.INVISIBLE)

        val diabeteBtn = findViewById<Button>(R.id.diabeteBtn)
        val vegetalBtn = findViewById<Button>(R.id.vegetalBtn)
        val menuGleBtn = findViewById<Button>(R.id.menuGleBtn)


        val typemenu_label = findViewById<TextView>(R.id.typemenu_label)
        typemenu_label.setText(" ")

        diabeteBtn.setOnClickListener({
            typemenu_label.setText("menu pour les diabètes")
            materialFavoriteButton2.setVisibility(View.VISIBLE)
            toast("Séléctionner le menu pour les diabètes")
        })


        vegetalBtn.setOnClickListener({
            typemenu_label.setText("menu végétarien")
            materialFavoriteButton2.setVisibility(View.VISIBLE)
            toast("Séléctionner le menu végétarien")
        })

        menuGleBtn.setOnClickListener({
            typemenu_label.setText(" ")
            materialFavoriteButton2.setVisibility(View.INVISIBLE)
        })



        val emplacementBtn = findViewById<Button>(R.id.emplacementBtn)
        emplacementBtn.setOnClickListener({
            toast("Emplacement indiqué : 'Alger'  ")
        })


        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        constraintLayout.setOnClickListener({
            filter_menu_crdView.setVisibility(View.GONE)
        })

        fabcommande.setOnClickListener { view ->


            val inflater = layoutInflater
            val alertLayout = inflater.inflate(R.layout.commande_, null)
            val validateBtn = alertLayout.findViewById<Button>(R.id.validateBtn)

            val alert = AlertDialog.Builder(this)
            alert.setTitle(" Votre commande")
            // this is set the view from XML inside AlertDialog
            alert.setView(alertLayout)
            // disallow cancel of AlertDialog on click of back button and outside touch
            alert.setCancelable(false)
            alert.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> Toast.makeText(baseContext, "Cancel clicked", Toast.LENGTH_SHORT).show() })


//            alert.setPositiveButton("Done", DialogInterface.OnClickListener { dialog, which ->
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//
//            })
            val dialog = alert.create()
            dialog.show()

            validateBtn.setOnClickListener({
                Snackbar.make(view, "votre commande est prise en compte !", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                dialog.cancel()

            })
            }



    }

    fun initFonts(){

        val typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto_Slab/RobotoSlab-Regular.ttf")

        val menuGleBtn = findViewById<Button>(R.id.menuGleBtn)
        menuGleBtn.setTypeface(typeface)

        val diabeteBtn = findViewById<Button>(R.id.diabeteBtn)
        diabeteBtn.setTypeface(typeface)

        val vegetalBtn = findViewById<Button>(R.id.vegetalBtn)
        vegetalBtn.setTypeface(typeface)

    }
}
