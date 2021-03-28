package com.example.login

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.login.db.AppDatabase
import com.example.login.db.PegasusDAO
import com.example.login.generators.PegasusGroupGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    var dao : PegasusDAO? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dao = AppDatabase.createDb(requireContext()).pegasusDAO()
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.generate_button).setOnClickListener {
            val ugg =  PegasusGroupGenerator(1, 5)
            val unicornList = ugg.getPegasusGroup()

            GlobalScope.launch(Dispatchers.IO) {

                withContext(Dispatchers.IO) {

                    for (i in 0 until unicornList.size){
                        dao!!.insert(unicornList[i])
                    }
                }
            }
        }

        view.findViewById<Button>(R.id.show_batton).setOnClickListener {
            val list = view.findViewById(R.id.pegasusView) as TextView
            GlobalScope.launch(Dispatchers.IO) {

                withContext(Dispatchers.IO) {
                    val unicornList = dao!!.getPegasus()
                    var str = ""
                    for (unicorn in unicornList){
                        str += unicorn.toString() + "\n\n"
                    }
                    list.text = str
                }
            }
            list.movementMethod = ScrollingMovementMethod();
        }

        view.findViewById<Button>(R.id.clear_button).setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {

                withContext(Dispatchers.IO) {
                    dao!!.deleteAll()
                }
            }
            val list = view.findViewById(R.id.pegasusView) as TextView
            list.text = "Здесь будет список пегасов"
        }

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}