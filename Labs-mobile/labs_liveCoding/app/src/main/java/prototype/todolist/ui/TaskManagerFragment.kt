package prototype.todolist.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.R
import prototype.todolist.databinding.FragmentTaskManagerBinding


class TaskManagerFragment : Fragment() {


    private var _binding: FragmentTaskManagerBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter : TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTaskManagerBinding.inflate(inflater, container, false)
        return binding.root
//        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        this.taskAdapter =  TaskAdapter(view.findNavController())
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =  taskAdapter
            floatingActionButton.setOnClickListener{

                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = 0 )
                view.findNavController().navigate(action)
            }

        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Implémentez le code du button Ajouter une tâche dans le menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

//    }
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.layout_menu, menu)

//        layout_menu.setOnClickListener{
//            val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = 0 )
//            view.findNavController().navigate(action)
//        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_add -> {


                // Handle the action item click
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}