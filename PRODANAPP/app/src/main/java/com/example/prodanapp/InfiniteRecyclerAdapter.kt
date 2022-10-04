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
import com.example.prodanapp.databinding.CustomInfinitePagerLayoutBinding
import com.example.prodanapp.databinding.FragmentDetailsBinding
import com.example.prodanapp.databinding.FragmentMainviewBinding

class InfiniteRecyclerAdapter(originalList: List<Sample>,
                              private val funcionX : (Sample) -> Unit)
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

    class InfiniteRecyclerViewHolder(val binding: CustomInfinitePagerLayoutBinding, funcionZ:(Int) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(sample: Sample) {
//            val pagerTextView: TextView = itemView.findViewById(R.id.textView)
//            val pagerCardView: CardView = itemView.findViewById(R.id.cardView)

//            pagerTextView.text = sample.number.toString()
//            pagerCardView.setBackgroundColor(Color.parseColor(sample.color))
        }

        init {
            itemView.setOnClickListener {
                funcionZ(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteRecyclerViewHolder {
        val view = CustomInfinitePagerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InfiniteRecyclerViewHolder(view){
            funcionX(newList[it])
        }
    }

    override fun onBindViewHolder(holder: InfiniteRecyclerViewHolder, position: Int) {
        holder.bind(newList[position])
    }

    override fun getItemCount(): Int {
        return newList.size
    }

}