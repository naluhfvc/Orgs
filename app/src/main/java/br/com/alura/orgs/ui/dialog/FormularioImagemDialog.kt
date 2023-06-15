package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostra(imageView: ImageView) {
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context))

        binding.formularioImagemBotaoCarregar.setOnClickListener {
            val url = binding.formularioImagemUrl.text.toString()
            binding.formularioImagemImageView.tentaCarregarImagem(url)
        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar")
            { _, _ ->
                val url = binding.formularioImagemUrl.text.toString()
                imageView.tentaCarregarImagem(url)
            }
            .setNegativeButton("Cancelar")
            { _, _ ->

            }
            .show()
    }

}
