package org.techtown.dialog_lab

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import org.techtown.dialog_lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyCustomFragment.MyCustomFragmentListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        onClickDialogButton()
        setContentView(binding.root)
    }

    private fun onClickDialogButton() {
        binding.btnDialog.setOnClickListener {
            Log.d(TAG, "MainActivity - onDialogButtonClick() called")
            // Create an instance of the dialog fragment and show it
            val dialog = MyCustomFragment(this)
            dialog.show(supportFragmentManager, MYCUSTOMFRAGMENT_TAG)
        }
    }

    override fun onClickCloseImage(dialog: DialogFragment) {
        Log.d(TAG, "MainActivity - onClickCloseImage() called")
        dialog.dismiss()
    }
    override fun onClickSaveButton(dialog: DialogFragment) {
        Log.d(TAG, "MainActivity - onClickDeleteButton() called")
        Toast.makeText(this, "저장 버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onClickDeleteButton(dialog: DialogFragment) {
        Log.d(TAG, "MainActivity - onClickDeleteButton() called")
        Toast.makeText(this, "삭제 버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "로그"
        const val MYCUSTOMFRAGMENT_TAG = "MyCustomFragment"
    }
}
