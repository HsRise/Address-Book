package example.com.textproject1;

import android.app.Activity;
import android.os.Bundle;

public class Message extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new NewTextView(this));
    }
}