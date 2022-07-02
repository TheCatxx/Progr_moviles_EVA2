package com.tecsupapp.d_marco.notify

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.model.Notify
import kotlinx.android.synthetic.main.fragment_notify.*

class NotifyFragment: Fragment(), NotifyAdapter.ItemClickListener {


    private lateinit var notifyViewModel: NotifyViewModel
    lateinit var list: List<Notify>

    companion object{
        fun newInstance(): NotifyFragment = NotifyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notifyViewModel = run {
            ViewModelProviders.of(this).get(NotifyViewModel::class.java)

        }

        loadData()
        configurationTouchRecycler()

    }

    private fun loadData() {
        val adapter = NotifyAdapter(this)
        recyclerNotifys.adapter = adapter
        recyclerNotifys.layoutManager = LinearLayoutManager(activity)

        notifyViewModel.notifys.observe(viewLifecycleOwner) { notifys ->
            if (notifys.isNotEmpty()){
                list = notifys
                notifys?.let {
                    adapter.setNotifys(notifys)
                }

            }
        }

    }

    override fun onItemClick(notify: Notify) {

    }

    private  fun configurationTouchRecycler(){
        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    notifyViewModel.deleteNotify(list[position])
                    view!!.snack("Notificacion eliminada correctamente")
                }

                override fun getMovementFlags(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ): Int {
                    return ItemTouchHelper.Callback.makeMovementFlags(ItemTouchHelper.LEFT, ItemTouchHelper.START)
                }

            }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerNotifys)
    }

    fun View.snack(mensaje: String, duration: Int = Snackbar.LENGTH_LONG){
        val snackBar = Snackbar.make(this,mensaje, duration)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.RED)
        snackBar.show()
    }

}