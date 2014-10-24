package example.com.textproject1;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Button message = (Button)findViewById(R.id.buttonGetMessage);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList name = new ArrayList();
                final ArrayList number = new ArrayList();
                final ArrayList<ArrayList> detail = new ArrayList<ArrayList>();
                Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI
                ,null,null,null,null);//projection 是每行要包含的列们
                while (cursor.moveToNext()){
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String theName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    name.add(theName);
                    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds
                            .Phone.CONTACT_ID + "=" +id,null,null);
                    while (phones.moveToNext()){
                        String theNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        number.add(theNumber);
                    }
                    phones.close();
                }
                cursor.close();
                detail.add(name);
                detail.add(number);
                View resultDialog = getLayoutInflater().inflate(R.layout.result,null);
                ExpandableListView list = (ExpandableListView)resultDialog.findViewById(R.id.list);
                ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
                    @Override
                    public int getGroupCount() {
                        return name.size();
                    }

                    @Override
                    public int getChildrenCount(int groupPosition) {
                        return detail.get(groupPosition).size();
                    }

                    @Override
                    public Object getGroup(int groupPosition) {
                        return name.get(groupPosition);
                    }

                    @Override
                    public Object getChild(int groupPosition, int childPosition) {
                        return detail.get(groupPosition).get(childPosition);
                    }

                    @Override
                    public long getGroupId(int groupPosition) {
                        return groupPosition;
                    }

                    @Override
                    public long getChildId(int groupPosition, int childPosition) {
                        return childPosition;
                    }

                    @Override
                    public boolean hasStableIds() {
                        return true;
                    }

                    private TextView getTextView() {
                        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup
                        .LayoutParams.MATCH_PARENT,64);
                        TextView textView = new TextView(MyActivity.this);
                        textView.setLayoutParams(lp);
                        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                        textView.setPadding(36,0,0,0);
                        textView.setTextSize(20);
                        return textView;
                    }
                    @Override
                    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                        TextView textView = getTextView();
                        textView.setText(getGroup(groupPosition).toString());
                        return textView;
                    }

                    @Override
                    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                        TextView textView = getTextView();
                        textView.setText(getChild(groupPosition,childPosition).toString());
                        return textView;
                    }

                    @Override
                    public boolean isChildSelectable(int groupPosition, int childPosition) {

                        return true;
                    }
                };
                list.setAdapter(adapter);
                new AlertDialog.Builder(MyActivity.this).setView(resultDialog).setPositiveButton("确定",null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
