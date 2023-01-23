package com.jhon.pokedex.main.adapter

class RegularSimulationAdapter(private val listener: (InsuranceUi) -> Unit) :
    RecyclerView.Adapter<RegularSimulationAdapter.ViewHolder>() {

    var list: List<InsuranceUi> by basicDiffUtil(
        emptyList(), { old, new -> old.name == new.name }
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(parent.bindingInflate(R.layout.item_regular_simulation, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.dataBinding.item = item
        holder.dataBinding.root.findViewById<AppCompatCheckBox>(R.id.checkbox)
            .setOnClickListener {
                listener.invoke(item)
            }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val dataBinding: ItemRegularSimulationBinding) :
        RecyclerView.ViewHolder(dataBinding.root)
}