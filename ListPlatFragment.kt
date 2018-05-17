package com.example.smail.projectmob


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_restaurant_details.*


/**
 * A simple [Fragment] subclass.
 */
class ListPlatFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val myDataset = ArrayList<Plat>()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_list_plat, container, false)
    }



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        initialiser()

        viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
        viewAdapter = PlatAdapter(myDataset,getActivity())

        //val rootView = inflater.inflate(R.layout.fragment_list_restaurant, container, false)

        recyclerView = getActivity().findViewById<RecyclerView>(R.id.my_recycler_view2).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }



//hide  #fab while scrolling down
        val fabcommande = getActivity().findViewById<FloatingActionButton>(R.id.fabcommande)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && fabcommande.getVisibility() === View.VISIBLE) {
                    fabcommande.setVisibility(View.GONE)
                } else if (dy < 0 && fabcommande.getVisibility() !== View.VISIBLE) {
                    fabcommande.setVisibility(View.VISIBLE)
                }
            }
        })





    }


    fun initialiser(){
        myDataset.add(Plat("Escalope",200,R.drawable.escalope,"...","a"))
        myDataset.add(Plat("salade",100,R.drawable.sala,"...","a"))
        myDataset.add(Plat("Viande Hachée",200,R.drawable.vh,"...","a"))
        myDataset.add(Plat("Entrecote",200,R.drawable.entrecote,"...","a"))
        myDataset.add(Plat("Frite-omlette",100,R.drawable.frite_omlette,"...","a"))
        myDataset.add(Plat("Gateau",50,R.drawable.chocola,"...","b"))
        myDataset.add(Plat("Soupe",70,R.drawable.chourba,"...","a"))
        myDataset.add(Plat("Sociers",50,R.drawable.mergaz,"...","a"))
        myDataset.add(Plat("Escalope",200,R.drawable.escalope,"...","a"))
    }
}// Required empty public constructor


