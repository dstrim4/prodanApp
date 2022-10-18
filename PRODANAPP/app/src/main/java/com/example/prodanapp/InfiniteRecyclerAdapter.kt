import android.content.Context
import android.graphics.Color
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prodanapp.MainActivity
import com.example.prodanapp.MainviewFragment
import com.example.prodanapp.R
import com.example.prodanapp.data.Sample
import com.example.prodanapp.databinding.CustomInfinitePagerLayoutBinding
import com.example.prodanapp.databinding.FragmentDetailsBinding
import com.example.prodanapp.databinding.FragmentMainviewBinding

class InfiniteRecyclerAdapter(val context: Context, originalList: List<Sample>,
                              private val funcionX : (Sample) -> Unit)
    : RecyclerView.Adapter<InfiniteRecyclerAdapter.InfiniteRecyclerViewHolder>() {

    private val newList: List<Sample> =
        listOf(originalList.last()) + originalList + listOf(originalList.first())

    private lateinit var mListener : OnItemCLickListener

    interface OnItemCLickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemCLickListener){
        mListener = listener
    }

    class InfiniteRecyclerViewHolder(val binding: CustomInfinitePagerLayoutBinding, funcionZ:(Int) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(sample: Sample, context: Context) {
            binding.animalNamePagerLayout.text = sample.nomAnimal

            var text = sample.edadAnimal.toString()
            text += if (sample.edadAnimal == 1){
                " año"
            } else{
                " años"
            }
            binding.animalAgePagerLayout.text = text

            Glide.with(context)
                .load(sample.imgAnimal.data[0].attributes.url)
                .into(binding.animalImagePagerLayout)
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
        holder.bind(newList[position], context)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

}