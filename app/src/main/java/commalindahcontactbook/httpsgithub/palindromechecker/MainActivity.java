/**
 * Name: Linhui Huang (Malinda)
 * Course: CS30S
 * Teacher: Mr. Hardman
 * Lab #4, Program #1
 * Date Last Modified: 4/18/2018
 */
package commalindahcontactbook.httpsgithub.palindromechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mUserInput;
    private TextView mErrorMessage;
    private TextView mResult;

    @Override
    /**
     * onCreate is the method that is executed when the Activity begins
     *
     * @param savedInstanceState is a Bundle of data used to restore the activity
     *                           from a previous instance
     * @return "" Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserInput = (EditText) findViewById(R.id.et_user_input);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);
        mResult = (TextView) findViewById(R.id.tv_result);

        mUserInput.addTextChangedListener( textInputWatcher );
    }

    private final TextWatcher textInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        /**
         * afterTextChanged is the method that is executed when the user enters text
         * into the Editable object
         *
         * @param editable is the Editable object the user types input into
         * @return "" Nothing is returned
         */
        public void afterTextChanged(Editable editable)
        {
            String userInput;
            Boolean resultFromPalindromeCheck;

            if( editable.length() == 0 )
            {
                mResult.setText("");
                mErrorMessage.setText("You must enter a word to check.");
            }
            else if( editable.length() != 0 )
            {
                mResult.setText("");
                mErrorMessage.setText("");

                userInput = mUserInput.getText().toString().toUpperCase();
                resultFromPalindromeCheck = checkPalindrome( userInput, 0 );

                if( resultFromPalindromeCheck == true )
                {
                    userInput = mUserInput.getText().toString();
                    mResult.setText( userInput + " is a palindrome.");
                }
                else
                {
                    userInput = mUserInput.getText().toString();
                    mResult.setText( userInput + " is not a palindrome.");
                }
            }
        }
    };

    /**
     * checkPalindrome checks whether the word that user has typed in is a palindrome
     * or not by firstly changing every letter into uppercase and secondly comparing
     * the letters at currentNumberIndex and indexFromEnd recursively
     *
     * @param userWord is the word that the user has typed into the Editable
     * @param currentNumberIndex is the index of the letter that is being checked
     * @return the result of whether the word is a palindrome or not
     */
    private boolean checkPalindrome( String userWord, int currentNumberIndex )
    {
        boolean result = false;
        int indexFromEnd = userWord.length() - currentNumberIndex - 1;

        if( userWord.charAt(currentNumberIndex) == userWord.charAt(indexFromEnd) )
        {
            if( currentNumberIndex == indexFromEnd || currentNumberIndex == indexFromEnd - 1 )
            {
                result = true;
            }
            else
            {
                result = checkPalindrome( userWord, currentNumberIndex + 1 );
            }
        }
        else
        {
            result = false;
        }
        
        return result;
    }
}









