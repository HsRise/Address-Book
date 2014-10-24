package example.com.textproject1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
//public class MyActivity extends Activity {
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my);
//        Button search = (Button) findViewById(R.id.buttonGetMessage);
//        search.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View source)
//            {
//                final ArrayList<String> names = new ArrayList<String>();
//                final ArrayList<ArrayList<String>> details
//                        = new ArrayList<ArrayList<String>>();
//                // Ê¹ÓÃContentResolver²éÕÒÁªÏµÈËÊý¾Ý
//                Cursor cursor = getContentResolver().query(
//                        ContactsContract.Contacts.CONTENT_URI, null, null,
//                        null, null);
//                // ±éÀú²éÑ¯½á¹û£¬»ñÈ¡ÏµÍ³ÖÐËùÓÐÁªÏµÈË
//                while (cursor.moveToNext())
//                {
//                    // »ñÈ¡ÁªÏµÈËID
//                    String contactId = cursor.getString(cursor
//                            .getColumnIndex(ContactsContract.Contacts._ID));
//                    // »ñÈ¡ÁªÏµÈËµÄÃû×Ö
//                    String name = cursor.getString(cursor.getColumnIndex(
//                            ContactsContract.Contacts.DISPLAY_NAME));
//                    names.add(name);
//                    // Ê¹ÓÃContentResolver²éÕÒÁªÏµÈËµÄµç»°ºÅÂë
//                    Cursor phones = getContentResolver().query(
//                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                            null,
//                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID
//                                    + " = " + contactId, null, null);
//                    ArrayList<String> detail = new ArrayList<String>();
//                    // ±éÀú²éÑ¯½á¹û£¬»ñÈ¡¸ÃÁªÏµÈËµÄ¶à¸öµç»°ºÅÂë
//                    while (phones.moveToNext())
//                    {
//                        // »ñÈ¡²éÑ¯½á¹ûÖÐµç»°ºÅÂëÁÐÖÐÊý¾Ý¡£
//                        String phoneNumber = phones.getString(phones
//                                .getColumnIndex(ContactsContract
//                                        .CommonDataKinds.Phone.NUMBER));
//                        detail.add("电话：" + phoneNumber);
//                    }
//                    phones.close();
//                    // Ê¹ÓÃContentResolver²éÕÒÁªÏµÈËµÄEmailµØÖ·
//                    Cursor emails = getContentResolver().query(
//                            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
//                            null,
//                            ContactsContract.CommonDataKinds.Email.CONTACT_ID
//                                    + " = " + contactId, null, null);
//                    // ±éÀú²éÑ¯½á¹û£¬»ñÈ¡¸ÃÁªÏµÈËµÄ¶à¸öEmailµØÖ·
//                    while (emails.moveToNext())
//                    {
//                        // »ñÈ¡²éÑ¯½á¹ûÖÐEmailµØÖ·ÁÐÖÐÊý¾Ý¡£
//                        String emailAddress = emails.getString(emails
//                                .getColumnIndex(ContactsContract
//                                        .CommonDataKinds.Email.DATA));
//                        detail.add("邮箱：" + emailAddress);
//                    }
//                    emails.close();
//                    details.add(detail);
//                }
//                cursor.close();
//                // ¼ÓÔØresult.xml½çÃæ²¼¾Ö´ú±íµÄÊÓÍ¼
//                View resultDialog = getLayoutInflater().inflate(
//                        R.layout.result, null);
//                // »ñÈ¡resultDialogÖÐIDÎªlistµÄExpandableListView
//                ExpandableListView list = (ExpandableListView) resultDialog
//                        .findViewById(R.id.list);
//                // ´´½¨Ò»¸öExpandableListAdapter¶ÔÏó
//                ExpandableListAdapter adapter =
//                        new BaseExpandableListAdapter()
//                        {
//                            // »ñÈ¡Ö¸¶¨×éÎ»ÖÃ¡¢Ö¸¶¨×ÓÁÐ±íÏî´¦µÄ×ÓÁÐ±íÏîÊý¾Ý
//                            @Override
//                            public Object getChild(int groupPosition,
//                                                   int childPosition)
//                            {
//                                return details.get(groupPosition).get(
//                                        childPosition);
//                            }
//
//                            @Override
//                            public long getChildId(int groupPosition,
//                                                   int childPosition)
//                            {
//                                return childPosition;
//                            }
//
//                            @Override
//                            public int getChildrenCount(int groupPosition)
//                            {
//                                int childrenSize = details.get(groupPosition).size();
//                                return childrenSize;
//                            }
//
//                            private TextView getTextView()
//                            {
//                                AbsListView.LayoutParams lp = new AbsListView
//                                        .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
//                                        , 64);
//                                TextView textView = new TextView(
//                                        MyActivity.this);
//                                textView.setLayoutParams(lp);
//                                textView.setGravity(Gravity.CENTER_VERTICAL
//                                        | Gravity.LEFT);
//                                textView.setPadding(36, 0, 0, 0);
//                                textView.setTextSize(20);
//                                return textView;
//                            }
//
//                            // ¸Ã·½·¨¾ö¶¨Ã¿¸ö×ÓÑ¡ÏîµÄÍâ¹Û
//                            @Override
//                            public View getChildView(int groupPosition,
//                                                     int childPosition, boolean isLastChild,
//                                                     View convertView, ViewGroup parent)
//                            {
//                                TextView textView = getTextView();
//                                textView.setText(getChild(groupPosition,
//                                        childPosition).toString());
//                                return textView;
//                            }
//
//                            // »ñÈ¡Ö¸¶¨×éÎ»ÖÃ´¦µÄ×éÊý¾Ý
//                            @Override
//                            public Object getGroup(int groupPosition)
//                            {
//                                Object groupSize = names.get(groupPosition);
//                                return groupSize;
//                            }
//
//                            @Override
//                            public int getGroupCount()
//                            {
//                                int groupSize = names.size();
//                                return groupSize;
//                            }
//
//                            @Override
//                            public long getGroupId(int groupPosition)
//                            {
//                                long groupId = groupPosition;
//                                return groupPosition;
//                            }
//
//                            // ¸Ã·½·¨¾ö¶¨Ã¿¸ö×éÑ¡ÏîµÄÍâ¹Û
//                            @Override
//                            public View getGroupView(int groupPosition,
//                                                     boolean isExpanded, View convertView,
//                                                     ViewGroup parent)
//                            {
//                                TextView textView = getTextView();
//                                textView.setText(getGroup(groupPosition)
//                                        .toString());
//                                return textView;
//                            }
//
//                            @Override
//                            public boolean isChildSelectable(int groupPosition,
//                                                             int childPosition)
//                            {
//                                return true;
//                            }
//
//                            @Override
//                            public boolean hasStableIds()
//                            {
//                                return true;
//                            }
//                        };
//                // ÎªExpandableListViewÉèÖÃAdapter¶ÔÏó
//                list.setAdapter(adapter);
//                // Ê¹ÓÃ¶Ô»°¿òÀ´ÏÔÊ¾²éÑ¯½á¹û¡£
//                new AlertDialog.Builder(MyActivity.this)
//                        .setView(resultDialog).setPositiveButton("确定", null)
//                        .show();
//            }
//        });
//    }
//}
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
