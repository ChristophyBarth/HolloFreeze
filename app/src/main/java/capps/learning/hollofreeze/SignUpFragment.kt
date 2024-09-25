package capps.learning.hollofreeze

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import capps.learning.hollofreeze.databinding.FragmentSignUpBinding
import kotlin.text.replace

class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root
          }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view, LoginFragment())
            transaction.addToBackStack(null)
            transaction.commit()


            val sharedPreferences = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("name", "Nelly")
            editor.putString("email", "Nelly12@gmail.com")
            editor.putString("password", "strongpassword")
            editor.putString("current password", "password")
            editor.apply()


            val storedName = sharedPreferences.getString("name", "")
            val storedEmail = sharedPreferences.getString("email", "")
            val storedPassword = sharedPreferences.getString("password", "")
            val storedCurrentPassword = sharedPreferences.getString("current password", "")

            fun validateUserInput(
                context: Context,
                name: String,
                email: String,
                password: String,
                currentPassword: String
            ): Boolean {
                if (!name.isNotEmpty() && name.matches("[A-Z].*".toRegex())) {
                    println("Invalid name format")
                    return false
                }
                if (!email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches()
                ) {
                    println("Invalid email format")
                    return false
                }
                if (!password.isNotEmpty() && password.length >= 8 &&
                    password.matches(".*[A-Z].*".toRegex()) &&
                    password.matches(".*[a-z].*".toRegex()) &&
                    password.matches(".*[0-9].*".toRegex())
                ) {
                    println("your password must be longer than 8 character")
                    return false
                }
                if (currentPassword != storedPassword) {
                    println("password does not match")
                    return false
                }

                return true
            }
        }
    }
}






