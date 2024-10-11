package pt.ipt.dam.mybio

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /**
     * it is the place where the Android finds your first instruction to be executed
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // find the button
        // we are going to specify a 'pointer' the 'continue button'
        findViewById<Button>(R.id.btContinue).setOnClickListener {
            addNickname(it)
        }


    }


    /**
     * this function assigns the 'nickname' to the+ textView
     * and presents it on screen.
     * It hides the button, and shows the users' curriculum
     */
    private fun addNickname(view: View) {
        // algorithm
        //   - assigns the nickname of 'textbox' (EditText) to the TextView
        //   - make the nickname + curriculum visible
        //   - hide the button + textbox (EditText)
        //   - hide the keyboard

        // lets do the actions...
        //   - assigns the nickname of 'textbox' (EditText) to the TextView
        val nicknameTextView = findViewById<TextView>(R.id.textViewNickname)
        val nicknameTextBox = findViewById<EditText>(R.id.editTextNickname)
        nicknameTextView.text = nicknameTextBox.text

        //   - make the nickname + curriculum visible
        nicknameTextView.visibility = View.VISIBLE
        findViewById<TextView>(R.id.textViewCurriculum).visibility = View.VISIBLE

        //   - hide the button + textbox (EditText)
        view.visibility = View.GONE // hide the button
        nicknameTextBox.visibility = View.GONE

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}