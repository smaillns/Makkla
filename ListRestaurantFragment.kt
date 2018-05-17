package com.example.smail.projectmob


import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_list_restaurant.*

/**
 * A simple [Fragment] subclass.
 */
class ListRestaurantFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val myDataset = ArrayList<Restaurant>()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView  = inflater!!.inflate(R.layout.fragment_list_restaurant, container, false)

        // Inflate the layout for this fragment
        return rootView
    }



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        initialiser()

        viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
        viewAdapter = MyAdapter(myDataset,getActivity())

        //val rootView = inflater.inflate(R.layout.fragment_list_restaurant, container, false)

        recyclerView = getActivity().findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
//        val searchBar = getActivity().findViewById<LinearLayout>(R.id.linearLayoutsearch)
//
//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                if (dy > 0 && searchBar.getVisibility() === View.VISIBLE) {
//                    //searchBar.setVisibility(View.INVISIBLE)
//                    searchBar.setVisibility(View.GONE)
//                } else if (dy < 0 && searchBar.getVisibility() !== View.VISIBLE) {
//                    searchBar.setVisibility(View.VISIBLE)
//                }
//            }
//        })


    }



    fun initialiser(){
        myDataset.add(Restaurant("Nom Restaurant",'A',R.drawable.img1,
                "+213552349395","Bouraoui Amar, Alger",
                "makla@gmail.com","www.facebook.com"))
        myDataset.add(Restaurant("Nom Restaurant",'A',R.drawable.img2,
                "+213552349395","Bab-Ezzouar, Alger",
                "makla@gmail.com","www.facebook.com"))
        myDataset.add(Restaurant("Nom Restaurant",'A',R.drawable.img1,
                "+213552349395","Bouraoui Amar, Alger",
                "makla@gmail.com","www.facebook.com"))
        myDataset.add(Restaurant("Nom Restaurant",'A',R.drawable.img1,
                "+213552349395","Bab-Ezzouar, Alger",
                "makla@gmail.com","www.facebook.com"))
        myDataset.add(Restaurant("Nom Restaurant",'A',R.drawable.img1,
                "+213552349395","Bouraoui Amar, Alger",
                "makla@gmail.com","www.facebook.com"))
    }

}// Required empty public constructor
