package garage.pappdagger2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.login);
    }

    @Override
    public void onClick(View view) {
        TextInputLayout userIdWrapper = (TextInputLayout)findViewById(R.id.userId_wrapper);
        TextInputLayout passwordWrapper = (TextInputLayout)findViewById(R.id.password_wrapper);
        EditText userIdEditText = (EditText) findViewById(R.id.userId);
        EditText passwordEditText = (EditText) findViewById(R.id.password);
        String userId = userIdEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean errorFlag = false;
        if(userId==null || userId.isEmpty()) {
            userIdWrapper.setError("Enter user ID");
            errorFlag = true;
        }
        if(password == null || password.isEmpty()) {
            passwordWrapper.setError("Enter password");
            errorFlag = true;
        }

        if(!errorFlag) {
            goToMainActivity();
        }
    }

    private void goToMainActivity() {
        Intent intent = new Intent();
        intent.setClassName(this, "garage.pappdagger2.MainActivity");
        startActivity(intent);
        finish();
    }
}
