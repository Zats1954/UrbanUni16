package ru.zatsoft.phoneshop1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(context: Context, var resource: Int, var dataList: List<Phone>) :
    ArrayAdapter<Phone>(context, resource, dataList) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val rootView =
            view ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        rootView?.let {
            val data = getItem(position)
            val tvName = rootView.findViewById<TextView>(R.id.tvName)
            val tvPrice = rootView.findViewById<TextView>(R.id.tvPrice)
            val tvCount = rootView.findViewById<TextView>(R.id.tvCount)
            println(data?.name)
            tvName.text = data?.name
            tvPrice.text = data?.price.toString()
            tvCount.text = data?.sells.toString()
            return rootView
        } ?: return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
    }
}