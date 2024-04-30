package br.senai.sp.jandira.contatos.dao

import androidx.room.Dao
import androidx.room.Insert
import br.senai.sp.jandira.contatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun salvar(contato: Contato): Long
}