package example.com.textproject1;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/10/29.
 */
public class NewTextView extends EditText {
    public NewTextView(Context context){
        super(context);
        this.setText("\\hehehe\\");
    }
}
