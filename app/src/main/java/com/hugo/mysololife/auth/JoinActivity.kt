package com.hugo.mysololife.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hugo.mysololife.R
import com.hugo.mysololife.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        binding.joinBtn.setOnClickListener {
            var isGoToJoin = true

            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            // 값이 비어있는 경우
            if (email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요!", Toast.LENGTH_LONG).show()
                isGoToJoin = false
                return@setOnClickListener
            }
            // 값이 비어있거느 6자리 이상인
            if (password1.isEmpty() || password1.length < 6) {
                Toast.makeText(this, "비밀번호를 입력해주세요! \n(6자리 이상)", Toast.LENGTH_LONG).show()
                isGoToJoin = false
                return@setOnClickListener
            }
            if (password2.isEmpty()) {
                Toast.makeText(this, "비밀번호 확인을 입력해주세요!", Toast.LENGTH_LONG).show()
                isGoToJoin = false
                return@setOnClickListener
            }
            // 비밀번호 2개가 같은지 확인
            if (!password1.equals(password2)) {
                Toast.makeText(this, "비밀번호와 비밀번호 확인을 똑같이 입력해주세요!", Toast.LENGTH_LONG).show()
                isGoToJoin = false
                return@setOnClickListener
            }
        }



//       auth.createUserWithEmailAndPassword("abc@abc.com", "abcdabcd")
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, "실", Toast.LENGTH_SHORT).show()
//                }
//            }
    }
}