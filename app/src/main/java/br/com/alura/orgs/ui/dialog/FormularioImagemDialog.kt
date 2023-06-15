package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostra(
        imagemPadrao: String? = null,
        quandoImagemCarregada: (imagem: String) -> Unit,
    ) {

        FormularioImagemBinding.inflate(LayoutInflater.from(context)).apply {
            imagemPadrao?.let {
                formularioImagemImageView.tentaCarregarImagem(it)
                formularioImagemUrl.setText(it)
            }
            formularioImagemBotaoCarregar.setOnClickListener {
                val url = formularioImagemUrl.text.toString()
                formularioImagemImageView.tentaCarregarImagem(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("Confirmar")
                { _, _ ->
                    val url = formularioImagemUrl.text.toString()
                    quandoImagemCarregada(url)
                }
                .setNegativeButton("Cancelar")
                { _, _ ->

                }
                .show()
        }

    }

}
