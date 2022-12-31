package com.example.tigetprojectinhome.fragments

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.tigetprojectinhome.databinding.FragmentSettingBinding
import java.util.*

class SettingFragment : Fragment() {

    lateinit var fragmentSettingBinding: FragmentSettingBinding
    private val language = listOf<String>("Select language", "English", "Persian")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentSettingBinding = FragmentSettingBinding.inflate(layoutInflater, container, false)
        setSpinner()
        return fragmentSettingBinding.root
    }

    private fun setSpinner() {
        var adapter: ArrayAdapter<String> =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, language)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fragmentSettingBinding.spinner.adapter = adapter
        fragmentSettingBinding.spinner.setSelection(0)
        fragmentSettingBinding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedLanguage = parent?.getItemAtPosition(position).toString()
                if (selectedLanguage == "English") {
                    getLocate(requireActivity(), "en")
                    requireActivity().finish()
                    requireActivity().startActivity(requireActivity().intent)
                } else if (selectedLanguage == "Persian") {
                    getLocate(requireActivity(), "fa")
                    requireActivity().finish()
                    requireActivity().startActivity(requireActivity().intent)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun getLocate(activity: Activity, lanCode: String) {
        val locale = Locale(lanCode)
        Locale.setDefault(locale)
        val resource: Resources = activity.resources
        val config: Configuration = resource.configuration
        config.setLocale(locale)
        resource.updateConfiguration(config, resource.displayMetrics)
    }
}

