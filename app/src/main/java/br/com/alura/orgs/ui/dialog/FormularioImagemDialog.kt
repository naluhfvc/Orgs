package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostra() {
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context))

        binding.formularioImagemBotaoCarregar.setOnClickListener {
            val url = binding.formularioImagemUrl.text.toString()
            binding.formularioImagemImageView.tentaCarregarImagem(url)
        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar")
            { _, _ ->
                url = binding.formularioImagemUrl.text.toString()
                binding.activityFormularioProdutoImagem.tentaCarregarImagem(url)
            }
            .setNegativeButton("Cancelar")
            { _, _ ->

            }
            .show()
    }

}
