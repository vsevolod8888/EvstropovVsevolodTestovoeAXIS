import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.evstropovvsevolodtestovoeaxis.R
import com.example.evstropovvsevolodtestovoeaxis.databinding.HolderBinding
import com.example.evstropovvsevolodtestovoeaxis.domain.NoteDomain
import com.google.android.material.button.MaterialButton

class AdapterNote(
 //   var noteListener: NoteListener
) :
    ListAdapter<NoteDomain, AdapterNote.Holder>(ArchiveDiffCallback()) {
    var selectedItemPosition: Int = -1                                            // для чего это???


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder.from(parent)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.itemView.findViewById<MaterialButton>(R.id.buttonDelete).setOnClickListener {
//            noteListener.onDeleteClickK(item)
//            selectItemPosition(position)
        }
        holder.bind(item)
    }

    fun selectItemPosition(itemPos: Int) {
        selectedItemPosition = itemPos
        notifyDataSetChanged()
    }

    class Holder(val binding: HolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: NoteDomain
        ) {
            binding.noteDomain = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): Holder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HolderBinding.inflate(layoutInflater, parent, false)
                return Holder(binding)
            }
        }
    }
}

class ArchiveDiffCallback : DiffUtil.ItemCallback<NoteDomain>() {
    override fun areItemsTheSame(
        oldItem: NoteDomain,
        newItem: NoteDomain
    ): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: NoteDomain,
        newItem: NoteDomain
    ): Boolean {
        return oldItem == newItem
    }
}

//interface NoteListener {
//    fun onDeleteClickK(note: NoteDomain)
//}