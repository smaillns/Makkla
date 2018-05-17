package com.example.smail.projectmob

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.w3c.dom.Text


/**
 * Created by smail on 21/03/18.
 */
class MyAdapter(private var myDataset: ArrayList<Restaurant>, var mCtx:Context):RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(holder : View) : RecyclerView.ViewHolder(holder){
        val adress = holder.findViewById<TextView>(R.id.adress)
        val phone = holder.findViewById<TextView>(R.id.phonenumber)
        val fb = holder.findViewById<TextView>(R.id.fb)
        val mail = holder.findViewById<TextView>(R.id.mail)
        val image = holder.findViewById<ImageView>(R.id.ResImage)
        val name = holder.findViewById<TextView>(R.id.res_name)

        val btn = holder.findViewById<ImageButton>(R.id.showmoreBtn)
        val view_showmore = holder.findViewById<LinearLayout>(R.id.showmore)

        val btn2 = holder.findViewById<ImageButton>(R.id.showlessBtn)





    }



    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.res_item, parent, false)
        // set the view's size, margins, paddings and layout parameters

        initFonts(v);
        return ViewHolder(v)
    }




    fun initFonts(v: View){

        val typeface = Typeface.createFromAsset(v.getContext().getAssets(), "fonts/Roboto_Slab/RobotoSlab-Regular.ttf")

        val res_name = v?.findViewById<TextView>(R.id.res_name)
        res_name?.setTypeface(typeface)

        val phonenumber = v?.findViewById<TextView>(R.id.phonenumber)
        phonenumber?.setTypeface(typeface)

        val adress = v?.findViewById<TextView>(R.id.adress)
        adress?.setTypeface(typeface)

        val mail = v?.findViewById<TextView>(R.id.mail)
        mail?.setTypeface(typeface)

        val fb = v?.findViewById<TextView>(R.id.fb)
        fb?.setTypeface(typeface)

    }





    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.phone.text = myDataset[position].telephone
        holder.adress.text = myDataset[position].adresse
        holder.image.setImageResource(myDataset[position].image)
        holder.fb.text=myDataset[position].fb
        holder.mail.text=myDataset[position].mail
        holder.name.text=myDataset[position].nom


        holder.view_showmore.setVisibility(View.GONE)


        holder.btn.setOnClickListener(
                { view ->
                    holder.view_showmore.setVisibility(View.VISIBLE)
                    holder.btn.setVisibility(View.INVISIBLE)

                }
        )

        holder.btn2.setOnClickListener(
                { view ->
                    holder.view_showmore.setVisibility(View.GONE)
                    holder.btn.setVisibility(View.VISIBLE)
                }
        )


        holder.itemView.setOnClickListener(
                { view ->
//                    Snackbar.make(view, holder.phone.text, Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show()

                    val intent = Intent()
                    intent.setClass(view.getContext(), Restaurant_detailsActivity::class.java)

                    intent.putExtra("resto", myDataset[position])
                    view.getContext().startActivity(intent)
                }
        )



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}