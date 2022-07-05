package org.techtown.dialog_lab

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.techtown.dialog_lab.databinding.FragmentMyCustomBinding
import java.nio.file.Files.delete

class MyCustomFragment(val customFragmentListener: MyCustomFragmentListener) : DialogFragment() {
    private var _binding: FragmentMyCustomBinding? = null
    private val binding get() = _binding ?: error("null값 들어감")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "MyCustomFragment - onCreateView() called")
        _binding = FragmentMyCustomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "MyCustomFragment - onViewCreated() called")
        initDialog()
        close()
        delete()
        save()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initDialog() {
        Log.d(TAG, "MyCustomFragment - initDialog() called")
        // 레이아웃 배경을 투명하게 해줌
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        // 뒷배경 터치시 dialog가 종료되는 것 막아줌
        dialog?.setCancelable(false)
    }

    private fun close() {
        binding.ivClose.setOnClickListener {
            customFragmentListener.onClickCloseImage(this)
        }
    }

    private fun delete() {
        binding.btnDelete.setOnClickListener {
            customFragmentListener.onClickDeleteButton(this)
        }
    }

    private fun save() {
        binding.btnSave.setOnClickListener {
            customFragmentListener.onClickSaveButton(this)
        }
    }

    companion object {
        private const val TAG = "로그"
    }

    interface MyCustomFragmentListener {
        fun onClickCloseImage(dialog: DialogFragment)
        fun onClickSaveButton(dialog: DialogFragment)
        fun onClickDeleteButton(dialog: DialogFragment)
    }
}
