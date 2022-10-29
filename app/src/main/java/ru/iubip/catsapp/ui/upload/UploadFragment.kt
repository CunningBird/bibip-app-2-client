package ru.iubip.catsapp.ui.upload

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toFile
import androidx.fragment.app.Fragment
import ru.iubip.catsapp.R
import ru.iubip.catsapp.ui.MainActivity
import ru.iubip.catsapp.usecases.UploadUsecase
import java.io.File


class UploadFragment : Fragment(R.layout.fragment_upload) {

    private lateinit var usecase: UploadUsecase

    private lateinit var takePicture: ActivityResultLauncher<Uri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success: Boolean ->
            if (success) {
                println("true")
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usecase = (activity as MainActivity).uploadUsecase
        val view = inflater.inflate(R.layout.fragment_upload, container, false)

        view.findViewById<Button>(R.id.uploadCatViaCamera).setOnClickListener {
            val file = File.createTempFile("flex", ".jpg") // TODO create file
            val imageUri = Uri.fromFile(file)
            takePicture.launch(imageUri)
            usecase.uploadViaCamera(imageUri.toFile())
        }
//        view.findViewById<Button>(R.id.uploadCatViaFilesystem).setOnClickListener {
//            uploadImageFromFilesystem()
//        }

        return view
    }

    private fun uploadImageFromCamera() {
    }

    private fun uploadImageFromFilesystem() {

    }
}