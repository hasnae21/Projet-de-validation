package prototype.todolist.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.R
import prototype.todolist.databinding.FragmentTaskFormBinding
import prototype.todolist.databinding.FragmentTaskManagerBinding
import prototype.todolist.models.Task
import prototype.todolist.utils.Status


class TaskManagerFragment : BaseFragment<FragmentTaskManagerBinding>(FragmentTaskManagerBinding::inflate) {

    private val viewModel: TaskViewModel by viewModels()
    private lateinit var adapter: TaskRecyclerViewAdapter

    override fun init(view: View) {
        this.setProgressBar(R.id.progressBar)
        adapter =  TaskRecyclerViewAdapter(arrayListOf(), view.findNavController() )
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =  adapter
        }

        // getUsers observe
        viewModel.getTasks().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> this.showProgressBar()
                Status.ERROR -> this.showResponseError(it.message.toString())
                Status.SUCCESS -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    adapter.apply {
                        addTasks(it.data!!)
                        notifyDataSetChanged()
                    }
                }
            }
        })

    }

    override fun listeners(view: View) {
        binding.apply {
            floatingActionButton.setOnClickListener{
                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = 0 )
                view.findNavController().navigate(action)
            }
        }
    }


    // Todo : Implémentez le code du button Ajouter une tâche dans le menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
    }



}