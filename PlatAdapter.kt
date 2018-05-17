package com.example.smail.projectmob

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.jetbrains.anko.toast

/**
 * Created by smail on 01/05/18.
 */

class PlatAdapter(private var myDataset: ArrayList<Plat>, var mCtx: Context): RecyclerView.Adapter<PlatAdapter.ViewHolder>(){

    class ViewHolder(holder : View) : RecyclerView.ViewHolder(holder){
        val nomPlat = holder.findViewById<TextView>(R.id.nomPlat)
        val imagePlat = holder.findViewById<ImageView>(R.id.imagePlat)
        val addPlatBtn = holder.findViewById<ImageButton>(R.id.addPlatBtn)
    }



    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.plat_item, parent, false)
        // set the view's size, margins, paddings and layout parameters
        initFonts(v);
        return ViewHolder(v)
    }


    fun initFonts(v: View){

        val typeface = Typeface.createFromAsset(v.getContext().getAssets(), "fonts/Roboto_Slab/RobotoSlab-Regular.ttf")

        val nomPlat = v?.findViewById<TextView>(R.id.nomPlat)
        nomPlat?.setTypeface(typeface)

    }





    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nomPlat.text=myDataset[position].nom
        holder.imagePlat.setImageResource(myDataset[position].image)

        holder.addPlatBtn.setOnClickListener({ view ->
           // view.getContext().toast("Plat ajouté !")

            val inflater = LayoutInflater.from(mCtx)
            val alertLayout = inflater.inflate(R.layout.details_plat_, null)
            val validateBtn = alertLayout.findViewById<Button>(R.id.validatePlatBtn)
            val imagePlatDialog = alertLayout.findViewById<ImageView>(R.id.imagePlatDialog)
            val nomPlatDialog = alertLayout.findViewById<TextView>(R.id.nomPlatDialog)
            val prixPlatDialog = alertLayout.findViewById<TextView>(R.id.prixPlatDialog)

            val closeDialogPlatBtn = alertLayout.findViewById<ImageButton>(R.id.closeDialogPlatBtn)

            val alert = AlertDialog.Builder(mCtx)
            //alert.setTitle(holder.nomPlat.getText())
            nomPlatDialog.text = myDataset[position].nom
            imagePlatDialog.setImageResource(myDataset[position].image)

            prixPlatDialog.setText(""+myDataset[position].price+" DA")


            // this is set the view from XML inside AlertDialog
            alert.setView(alertLayout)
            // disallow cancel of AlertDialog on click of back button and outside touch
            alert.setCancelable(false)
           // alert.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> Toast.makeText(baseContext, "Cancel clicked", Toast.LENGTH_SHORT).show() })


//            alert.setPositiveButton("Done", DialogInterface.OnClickListener { dialog, which ->
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//
//            })
            val dialog = alert.create()
            dialog.show()

            validateBtn.setOnClickListener({
                Snackbar.make(view, "Plat ajouté !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
                dialog.cancel()

            })
            closeDialogPlatBtn.setOnClickListener({
                dialog.cancel()
            })



        })


//        holder.itemView.setOnClickListener(
//                { view ->
//                    //                    Snackbar.make(view, holder.phone.text, Snackbar.LENGTH_LONG)
////                            .setAction("Action", null).show()
//
//                    val intent = Intent()
//                    intent.setClass(view.getContext(), Restaurant_detailsActivity::class.java)
//
//                    intent.putExtra("resto", myDataset[position])
//                    view.getContext().startActivity(intent)
//                }
//        )



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}
