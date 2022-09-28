import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.prodanapp.MainActivity
import com.example.prodanapp.MainviewFragment
import com.example.prodanapp.R
import com.example.prodanapp.data.Sample

class InfiniteRecyclerAdapter(originalList: List<Sample>)
    : RecyclerView.Adapter<InfiniteRecyclerAdapter.InfiniteRecyclerViewHolder>() {

    private val newList: List<Sample> =
        listOf(originalList.last()) + originalList + listOf(originalList.first())

    private lateinit var mListener : onItemCLickListener

    interface onItemCLickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemCLickListener){
        mListener = listener
    }

    class InfiniteRecyclerViewHolder(itemView: View, listener: onItemCLickListener)
        : RecyclerView.ViewHolder(itemView) {

        fun bind(sample: Sample) {
            val pagerTextView: TextView = itemView.findViewById(R.id.textView)
            val pagerCardView: CardView = itemView.findViewById(R.id.cardView)

            pagerTextView.text = sample.number.toString()
            pagerCardView.setBackgroundColor(Color.parseColor(sample.color))
        }

        companion object {
            fun from(parent: ViewGroup, mListener: onItemCLickListener) : InfiniteRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemView = layoutInflater.inflate(R.layout.custom_infinite_pager_layout,
                    parent, false)
                return InfiniteRecyclerViewHolder(itemView, mListener)

            }
        }
        init {
            itemView.setOnClickListener {
                Log.d("oClick", "Click!")
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteRecyclerViewHolder {
        return InfiniteRecyclerViewHolder.from(parent, mListener)
    }

    override fun onBindViewHolder(holder: InfiniteRecyclerViewHolder, position: Int) {
        holder.bind(newList[position])
    }

    override fun getItemCount(): Int {
        return newList.size
    }

}