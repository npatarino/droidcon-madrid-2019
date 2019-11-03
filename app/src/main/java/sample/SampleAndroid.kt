package sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ui.SessionsFragment

actual class Sample {
    actual fun checkMe() = 44
}

actual object Platform {
    actual val name: String = "Android"
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpSessions()
    }

    private fun setUpSessions() {
        val fragment = SessionsFragment.build()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentHost, fragment, SessionsFragment.TAG)
            commit()
        }
    }
}