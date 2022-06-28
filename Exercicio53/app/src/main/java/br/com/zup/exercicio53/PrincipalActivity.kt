package br.com.zup.exercicio53

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import br.com.zup.exercicio53.databinding.PrincipalActivityBinding

class PrincipalActivity : AppCompatActivity() {
    private val preferences: SharedPreferences by lazy {
        getPreferences(MODE_PRIVATE)
    }
    private lateinit var binding: PrincipalActivityBinding
    private  var email: String? = ""
    private var senha: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PrincipalActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = preferences.getString("EMAIL", "text@text.com")
        senha = preferences.getString("SENHA", "123")

        binding.txtEmail.setText(email)
        binding.txtSenha.setText(senha)

        binding.btnSalvar.setOnClickListener {
            preferences.edit {
                putString("EMAIL", binding.txtEmail.text.toString())
                putString("SENHA", binding.txtSenha.text.toString())
                commit()
            }
        }
    }
}