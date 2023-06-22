package br.com.alura.orgs.model

import androidx.versionedparcelable.VersionedParcelize
import java.math.BigDecimal

@VersionedParcelize
data class Produto(
        val nome: String,
        val descricao: String,
        val valor: BigDecimal,
        val imagem: String? = null
)